package androidx.lifecycle;

/* loaded from: classes.dex */
public class n0 implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final n0 f2381a = new n0();

    /* renamed from: b, reason: collision with root package name */
    public static final n0 f2382b = new n0();

    /* renamed from: c, reason: collision with root package name */
    public static n0 f2383c;

    @Override // androidx.lifecycle.p0
    public m0 d(Class cls) {
        try {
            Object newInstance = cls.newInstance();
            kotlin.jvm.internal.e.e(newInstance, "{\n                modelC…wInstance()\n            }");
            return (m0) newInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e10) {
            throw new RuntimeException("Cannot create an instance of " + cls, e10);
        }
    }
}
