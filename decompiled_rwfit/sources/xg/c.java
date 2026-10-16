package xg;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ec.a f19826a = new ec.a(24);

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void c(int i3, String str) {
        if (i3 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i3);
    }

    public static void d(long j4, String str) {
        if (j4 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j4);
    }
}
