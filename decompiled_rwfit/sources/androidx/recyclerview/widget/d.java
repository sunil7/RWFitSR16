package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class d implements s0 {

    /* renamed from: a, reason: collision with root package name */
    public final s0 f2524a;

    /* renamed from: b, reason: collision with root package name */
    public int f2525b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f2526c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f2527d = -1;
    public Object e = null;

    public d(s0 s0Var) {
        this.f2524a = s0Var;
    }

    public final void a() {
        int i3 = this.f2525b;
        if (i3 == 0) {
            return;
        }
        s0 s0Var = this.f2524a;
        if (i3 == 1) {
            s0Var.onInserted(this.f2526c, this.f2527d);
        } else if (i3 == 2) {
            s0Var.onRemoved(this.f2526c, this.f2527d);
        } else if (i3 == 3) {
            s0Var.onChanged(this.f2526c, this.f2527d, this.e);
        }
        this.e = null;
        this.f2525b = 0;
    }

    @Override // androidx.recyclerview.widget.s0
    public final void onChanged(int i3, int i10, Object obj) {
        int i11;
        int i12;
        int i13;
        if (this.f2525b == 3 && i3 <= (i12 = this.f2527d + (i11 = this.f2526c)) && (i13 = i3 + i10) >= i11 && this.e == obj) {
            this.f2526c = Math.min(i3, i11);
            this.f2527d = Math.max(i12, i13) - this.f2526c;
            return;
        }
        a();
        this.f2526c = i3;
        this.f2527d = i10;
        this.e = obj;
        this.f2525b = 3;
    }

    @Override // androidx.recyclerview.widget.s0
    public final void onInserted(int i3, int i10) {
        int i11;
        if (this.f2525b == 1 && i3 >= (i11 = this.f2526c)) {
            int i12 = this.f2527d;
            if (i3 <= i11 + i12) {
                this.f2527d = i12 + i10;
                this.f2526c = Math.min(i3, i11);
                return;
            }
        }
        a();
        this.f2526c = i3;
        this.f2527d = i10;
        this.f2525b = 1;
    }

    @Override // androidx.recyclerview.widget.s0
    public final void onMoved(int i3, int i10) {
        a();
        this.f2524a.onMoved(i3, i10);
    }

    @Override // androidx.recyclerview.widget.s0
    public final void onRemoved(int i3, int i10) {
        int i11;
        if (this.f2525b == 2 && (i11 = this.f2526c) >= i3 && i11 <= i3 + i10) {
            this.f2527d += i10;
            this.f2526c = i3;
        } else {
            a();
            this.f2526c = i3;
            this.f2527d = i10;
            this.f2525b = 2;
        }
    }
}
