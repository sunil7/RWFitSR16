package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.jvm.internal.e;
import okio.ByteString;
import wh.g;
import wh.j;
import wh.k;

/* loaded from: classes2.dex */
public final class WebSocketWriter implements Closeable, AutoCloseable {
    private final boolean isClient;
    private final g maskCursor;
    private final byte[] maskKey;
    private final j messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final k sink;
    private final j sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z5, k sink, Random random, boolean z6, boolean z8, long j4) {
        e.f(sink, "sink");
        e.f(random, "random");
        this.isClient = z5;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = z6;
        this.noContextTakeover = z8;
        this.minimumDeflateSize = j4;
        this.messageBuffer = new j();
        this.sinkBuffer = sink.m();
        this.maskKey = z5 ? new byte[4] : null;
        this.maskCursor = z5 ? new g() : null;
    }

    private final void writeControlFrame(int i3, ByteString byteString) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.Z(i3 | 128);
        if (this.isClient) {
            this.sinkBuffer.Z(size | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            e.c(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.X(this.maskKey);
            if (size > 0) {
                j jVar = this.sinkBuffer;
                long j4 = jVar.f19654b;
                jVar.W(byteString);
                j jVar2 = this.sinkBuffer;
                g gVar = this.maskCursor;
                e.c(gVar);
                jVar2.k(gVar);
                this.maskCursor.c(j4);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.Z(size);
            this.sinkBuffer.W(byteString);
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    public final Random getRandom() {
        return this.random;
    }

    public final k getSink() {
        return this.sink;
    }

    public final void writeClose(int i3, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i3 != 0 || byteString != null) {
            if (i3 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i3);
            }
            j jVar = new j();
            jVar.e0(i3);
            if (byteString != null) {
                jVar.W(byteString);
            }
            byteString2 = jVar.s(jVar.f19654b);
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i3, ByteString data) throws IOException {
        e.f(data, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.W(data);
        int i10 = i3 | 128;
        if (this.perMessageDeflate && data.size() >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            messageDeflater.deflate(this.messageBuffer);
            i10 = i3 | 192;
        }
        long j4 = this.messageBuffer.f19654b;
        this.sinkBuffer.Z(i10);
        int i11 = this.isClient ? 128 : 0;
        if (j4 <= 125) {
            this.sinkBuffer.Z(i11 | ((int) j4));
        } else if (j4 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.Z(i11 | WebSocketProtocol.PAYLOAD_SHORT);
            this.sinkBuffer.e0((int) j4);
        } else {
            this.sinkBuffer.Z(i11 | 127);
            this.sinkBuffer.d0(j4);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            e.c(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.X(this.maskKey);
            if (j4 > 0) {
                j jVar = this.messageBuffer;
                g gVar = this.maskCursor;
                e.c(gVar);
                jVar.k(gVar);
                this.maskCursor.c(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, j4);
        this.sink.w();
    }

    public final void writePing(ByteString payload) throws IOException {
        e.f(payload, "payload");
        writeControlFrame(9, payload);
    }

    public final void writePong(ByteString payload) throws IOException {
        e.f(payload, "payload");
        writeControlFrame(10, payload);
    }
}
