package kotlin.jvm.internal;

/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final h f15651a;

    static {
        h hVar = null;
        try {
            hVar = (h) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (hVar == null) {
            hVar = new h();
        }
        f15651a = hVar;
    }

    public static b a(Class cls) {
        f15651a.getClass();
        return new b(cls);
    }
}
