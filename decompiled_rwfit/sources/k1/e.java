package k1;

/* loaded from: classes.dex */
public final class e extends d {

    /* renamed from: c, reason: collision with root package name */
    public final Object f15454c;

    public e(int i3) {
        super(i3);
        this.f15454c = new Object();
    }

    @Override // k1.d
    public final Object a() {
        Object a3;
        synchronized (this.f15454c) {
            a3 = super.a();
        }
        return a3;
    }

    @Override // k1.d
    public final boolean c(Object obj) {
        boolean c9;
        synchronized (this.f15454c) {
            c9 = super.c(obj);
        }
        return c9;
    }
}
