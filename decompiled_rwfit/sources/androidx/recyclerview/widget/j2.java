package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class j2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2637a;

    /* renamed from: b, reason: collision with root package name */
    public int f2638b;

    /* renamed from: c, reason: collision with root package name */
    public int f2639c;

    /* renamed from: d, reason: collision with root package name */
    public int f2640d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f2641f;

    public boolean a() {
        int i3 = this.f2638b;
        int i10 = 2;
        if ((i3 & 7) != 0) {
            int i11 = this.e;
            int i12 = this.f2639c;
            if (((i11 > i12 ? 1 : i11 == i12 ? 2 : 4) & i3) == 0) {
                return false;
            }
        }
        if ((i3 & 112) != 0) {
            int i13 = this.e;
            int i14 = this.f2640d;
            if ((((i13 > i14 ? 1 : i13 == i14 ? 2 : 4) << 4) & i3) == 0) {
                return false;
            }
        }
        if ((i3 & 1792) != 0) {
            int i15 = this.f2641f;
            int i16 = this.f2639c;
            if ((((i15 > i16 ? 1 : i15 == i16 ? 2 : 4) << 8) & i3) == 0) {
                return false;
            }
        }
        if ((i3 & 28672) != 0) {
            int i17 = this.f2641f;
            int i18 = this.f2640d;
            if (i17 > i18) {
                i10 = 1;
            } else if (i17 != i18) {
                i10 = 4;
            }
            if ((i3 & (i10 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean b(int i3) {
        if (i3 != -1) {
            return this.f2640d == (i3 % 3) * 3;
        }
        return false;
    }

    public void c() {
        this.f2641f = (this.f2640d / 3) + ((this.e / 30) * 3);
    }

    public String toString() {
        switch (this.f2637a) {
            case 2:
                return this.f2641f + "|" + this.e;
            default:
                return super.toString();
        }
    }

    public j2(int i3, int i10, int i11, int i12, int i13) {
        this.f2637a = i13;
        switch (i13) {
            case 2:
                this.f2641f = -1;
                this.f2638b = i3;
                this.f2639c = i10;
                this.f2640d = i11;
                this.e = i12;
                break;
            default:
                this.f2638b = i3;
                this.f2639c = i12;
                this.f2640d = i10;
                this.e = i11;
                this.f2641f = i10 + i11;
                break;
        }
    }
}
