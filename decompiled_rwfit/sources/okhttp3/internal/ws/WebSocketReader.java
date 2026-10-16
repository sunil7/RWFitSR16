package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.e;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Settings;
import okio.ByteString;
import wh.g;
import wh.j;
import wh.l;

/* loaded from: classes2.dex */
public final class WebSocketReader implements Closeable, AutoCloseable {
    private boolean closed;
    private final j controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final g maskCursor;
    private final byte[] maskKey;
    private final j messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final l source;

    public interface FrameCallback {
        void onReadClose(int i3, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z5, l source, FrameCallback frameCallback, boolean z6, boolean z8) {
        e.f(source, "source");
        e.f(frameCallback, "frameCallback");
        this.isClient = z5;
        this.source = source;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z6;
        this.noContextTakeover = z8;
        this.controlFrameBuffer = new j();
        this.messageFrameBuffer = new j();
        this.maskKey = z5 ? null : new byte[4];
        this.maskCursor = z5 ? null : new g();
    }

    private final void readControlFrame() throws IOException {
        short s7;
        String str;
        long j4 = this.frameLength;
        if (j4 > 0) {
            this.source.t(this.controlFrameBuffer, j4);
            if (!this.isClient) {
                j jVar = this.controlFrameBuffer;
                g gVar = this.maskCursor;
                e.c(gVar);
                jVar.k(gVar);
                this.maskCursor.c(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                g gVar2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                e.c(bArr);
                webSocketProtocol.toggleMask(gVar2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                j jVar2 = this.controlFrameBuffer;
                long j10 = jVar2.f19654b;
                if (j10 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j10 != 0) {
                    s7 = jVar2.readShort();
                    str = this.controlFrameBuffer.A();
                    String closeCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s7);
                    if (closeCodeExceptionMessage != null) {
                        throw new ProtocolException(closeCodeExceptionMessage);
                    }
                } else {
                    s7 = 1005;
                    str = "";
                }
                this.frameCallback.onReadClose(s7, str);
                this.closed = true;
                return;
            case 9:
                FrameCallback frameCallback = this.frameCallback;
                j jVar3 = this.controlFrameBuffer;
                frameCallback.onReadPing(jVar3.s(jVar3.f19654b));
                return;
            case 10:
                FrameCallback frameCallback2 = this.frameCallback;
                j jVar4 = this.controlFrameBuffer;
                frameCallback2.onReadPong(jVar4.s(jVar4.f19654b));
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode));
        }
    }

    private final void readHeader() throws IOException, ProtocolException {
        boolean z5;
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int and = Util.and(this.source.readByte(), 255);
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            int i3 = and & 15;
            this.opcode = i3;
            boolean z6 = (and & 128) != 0;
            this.isFinalFrame = z6;
            boolean z8 = (and & 8) != 0;
            this.isControlFrame = z8;
            if (z8 && !z6) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z10 = (and & 64) != 0;
            if (i3 == 1 || i3 == 2) {
                if (!z10) {
                    z5 = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z5 = true;
                }
                this.readingCompressedMessage = z5;
            } else if (z10) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((and & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((and & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int and2 = Util.and(this.source.readByte(), 255);
            boolean z11 = (and2 & 128) != 0;
            if (z11 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j4 = and2 & 127;
            this.frameLength = j4;
            if (j4 == WebSocketProtocol.PAYLOAD_SHORT) {
                this.frameLength = Util.and(this.source.readShort(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            } else if (j4 == 127) {
                long readLong = this.source.readLong();
                this.frameLength = readLong;
                if (readLong < 0) {
                    throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z11) {
                l lVar = this.source;
                byte[] bArr = this.maskKey;
                e.c(bArr);
                lVar.readFully(bArr);
            }
        } catch (Throwable th2) {
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th2;
        }
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j4 = this.frameLength;
            if (j4 > 0) {
                this.source.t(this.messageFrameBuffer, j4);
                if (!this.isClient) {
                    j jVar = this.messageFrameBuffer;
                    g gVar = this.maskCursor;
                    e.c(gVar);
                    jVar.k(gVar);
                    this.maskCursor.c(this.messageFrameBuffer.f19654b - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    g gVar2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    e.c(bArr);
                    webSocketProtocol.toggleMask(gVar2, bArr);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws IOException {
        int i3 = this.opcode;
        if (i3 != 1 && i3 != 2) {
            throw new ProtocolException("Unknown opcode: " + Util.toHexString(i3));
        }
        readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) {
                messageInflater = new MessageInflater(this.noContextTakeover);
                this.messageInflater = messageInflater;
            }
            messageInflater.inflate(this.messageFrameBuffer);
        }
        if (i3 == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.A());
            return;
        }
        FrameCallback frameCallback = this.frameCallback;
        j jVar = this.messageFrameBuffer;
        frameCallback.onReadMessage(jVar.s(jVar.f19654b));
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            messageInflater.close();
        }
    }

    public final l getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
