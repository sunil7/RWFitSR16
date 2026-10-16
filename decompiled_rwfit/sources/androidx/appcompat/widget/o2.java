package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class o2 {

    /* renamed from: a, reason: collision with root package name */
    public int f1013a;

    /* renamed from: b, reason: collision with root package name */
    public int f1014b;

    /* renamed from: c, reason: collision with root package name */
    public int f1015c;

    /* renamed from: d, reason: collision with root package name */
    public int f1016d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f1017f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1018g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1019h;

    public final void a(int i3, int i10) {
        this.f1015c = i3;
        this.f1016d = i10;
        this.f1019h = true;
        if (this.f1018g) {
            if (i10 != Integer.MIN_VALUE) {
                this.f1013a = i10;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.f1014b = i3;
                return;
            }
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1013a = i3;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1014b = i10;
        }
    }
}
