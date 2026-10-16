package sc;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f18253a = Charset.defaultCharset();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f18254b = Charset.forName("SJIS");

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f18255c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f18256d;

    static {
        Charset charset;
        try {
            charset = Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused) {
            charset = null;
        }
        f18255c = charset;
        Charset forName = Charset.forName("EUC_JP");
        Charset charset2 = f18254b;
        Charset charset3 = f18253a;
        f18256d = charset2.equals(charset3) || forName.equals(charset3);
    }
}
