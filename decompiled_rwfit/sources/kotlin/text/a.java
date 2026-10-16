package kotlin.text;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f15656a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile Charset f15657b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Charset f15658c;

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.e.e(forName, "forName(\"UTF-8\")");
        f15656a = forName;
        kotlin.jvm.internal.e.e(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        kotlin.jvm.internal.e.e(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        kotlin.jvm.internal.e.e(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        kotlin.jvm.internal.e.e(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        kotlin.jvm.internal.e.e(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}
