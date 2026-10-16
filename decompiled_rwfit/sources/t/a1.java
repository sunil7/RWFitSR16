package t;

import android.util.Size;

/* loaded from: classes.dex */
public final class a1 extends x {

    /* renamed from: d, reason: collision with root package name */
    public final Object f18262d;
    public final n0 e;

    /* renamed from: f, reason: collision with root package name */
    public final int f18263f;

    /* renamed from: g, reason: collision with root package name */
    public final int f18264g;

    public a1(p0 p0Var, Size size, n0 n0Var) {
        super(p0Var);
        this.f18262d = new Object();
        if (size == null) {
            this.f18263f = this.f18423b.getWidth();
            this.f18264g = this.f18423b.getHeight();
        } else {
            this.f18263f = size.getWidth();
            this.f18264g = size.getHeight();
        }
        this.e = n0Var;
    }

    @Override // t.x, t.p0
    public final int getHeight() {
        return this.f18264g;
    }

    @Override // t.x, t.p0
    public final int getWidth() {
        return this.f18263f;
    }

    @Override // t.x, t.p0
    public final n0 u() {
        return this.e;
    }
}
