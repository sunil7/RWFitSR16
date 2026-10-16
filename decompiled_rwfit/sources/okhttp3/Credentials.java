package okhttp3;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.e;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String str, String str2) {
        return basic$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset ISO_8859_1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            ISO_8859_1 = StandardCharsets.ISO_8859_1;
            e.e(ISO_8859_1, "ISO_8859_1");
        }
        return basic(str, str2, ISO_8859_1);
    }

    public static final String basic(String username, String password, Charset charset) {
        e.f(username, "username");
        e.f(password, "password");
        e.f(charset, "charset");
        String encode = username + ':' + password;
        ByteString.Companion.getClass();
        e.f(encode, "$this$encode");
        byte[] bytes = encode.getBytes(charset);
        e.e(bytes, "(this as java.lang.String).getBytes(charset)");
        return l0.n("Basic ", new ByteString(bytes).base64());
    }
}
