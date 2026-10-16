package v7;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: g, reason: collision with root package name */
    public static int f19185g;

    /* renamed from: a, reason: collision with root package name */
    public int f19186a;

    /* renamed from: b, reason: collision with root package name */
    public int f19187b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f19188c;

    /* renamed from: d, reason: collision with root package name */
    public int f19189d;
    public e e;

    /* renamed from: f, reason: collision with root package name */
    public float f19190f;

    public static synchronized f a(int i3, e eVar) {
        f fVar;
        synchronized (f.class) {
            fVar = new f();
            if (i3 <= 0) {
                throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
            }
            fVar.f19187b = i3;
            fVar.f19188c = new Object[i3];
            fVar.f19189d = 0;
            fVar.e = eVar;
            fVar.f19190f = 1.0f;
            fVar.d();
            int i10 = f19185g;
            fVar.f19186a = i10;
            f19185g = i10 + 1;
        }
        return fVar;
    }

    public final synchronized e b() {
        e eVar;
        try {
            if (this.f19189d == -1 && this.f19190f > 0.0f) {
                d();
            }
            Object[] objArr = this.f19188c;
            int i3 = this.f19189d;
            eVar = (e) objArr[i3];
            eVar.f19184a = -1;
            this.f19189d = i3 - 1;
        } catch (Throwable th2) {
            throw th2;
        }
        return eVar;
    }

    public final synchronized void c(e eVar) {
        try {
            int i3 = eVar.f19184a;
            if (i3 != -1) {
                if (i3 == this.f19186a) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + eVar.f19184a + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            int i10 = this.f19189d + 1;
            this.f19189d = i10;
            if (i10 >= this.f19188c.length) {
                int i11 = this.f19187b;
                int i12 = i11 * 2;
                this.f19187b = i12;
                Object[] objArr = new Object[i12];
                for (int i13 = 0; i13 < i11; i13++) {
                    objArr[i13] = this.f19188c[i13];
                }
                this.f19188c = objArr;
            }
            eVar.f19184a = this.f19186a;
            this.f19188c[this.f19189d] = eVar;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void d() {
        float f2 = this.f19190f;
        int i3 = this.f19187b;
        int i10 = (int) (i3 * f2);
        if (i10 < 1) {
            i3 = 1;
        } else if (i10 <= i3) {
            i3 = i10;
        }
        for (int i11 = 0; i11 < i3; i11++) {
            this.f19188c[i11] = this.e.a();
        }
        this.f19189d = i3 - 1;
    }
}
