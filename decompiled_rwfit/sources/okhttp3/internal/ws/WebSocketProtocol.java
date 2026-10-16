package okhttp3.internal.ws;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import kotlin.jvm.internal.e;
import okio.ByteString;
import wh.g;
import wh.j;
import wh.m;

/* loaded from: classes2.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String key) {
        e.f(key, "key");
        m mVar = ByteString.Companion;
        String concat = key.concat(ACCEPT_MAGIC);
        mVar.getClass();
        return m.c(concat).sha1().base64();
    }

    public final String closeCodeExceptionMessage(int i3) {
        if (i3 < 1000 || i3 >= 5000) {
            return l0.j(i3, "Code must be in range [1000,5000): ");
        }
        if ((1004 > i3 || 1006 < i3) && (1015 > i3 || 2999 < i3)) {
            return null;
        }
        return l0.k(i3, "Code ", " is reserved and may not be used.");
    }

    public final void toggleMask(g cursor, byte[] key) {
        long j4;
        e.f(cursor, "cursor");
        e.f(key, "key");
        int length = key.length;
        int i3 = 0;
        do {
            byte[] bArr = cursor.e;
            int i10 = cursor.f19648f;
            int i11 = cursor.f19649g;
            if (bArr != null) {
                while (i10 < i11) {
                    int i12 = i3 % length;
                    bArr[i10] = (byte) (bArr[i10] ^ key[i12]);
                    i10++;
                    i3 = i12 + 1;
                }
            }
            long j10 = cursor.f19647d;
            j jVar = cursor.f19644a;
            e.c(jVar);
            if (j10 == jVar.f19654b) {
                throw new IllegalStateException("no more bytes");
            }
            j4 = cursor.f19647d;
        } while (cursor.c(j4 == -1 ? 0L : j4 + (cursor.f19649g - cursor.f19648f)) != -1);
    }

    public final void validateCloseCode(int i3) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i3);
        if (closeCodeExceptionMessage == null) {
            return;
        }
        e.c(closeCodeExceptionMessage);
        throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
    }
}
