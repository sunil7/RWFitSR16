package fg;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f13673c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f13674d;
    public static final a e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f13675f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f13676g;

    /* renamed from: h, reason: collision with root package name */
    public static final a[] f13677h;

    /* renamed from: a, reason: collision with root package name */
    public final int f13678a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13679b;

    static {
        a aVar = new a(0, false);
        f13673c = aVar;
        a aVar2 = new a(1, true);
        a aVar3 = new a(2, false);
        f13674d = aVar3;
        a aVar4 = new a(3, true);
        a aVar5 = new a(4, false);
        e = aVar5;
        a aVar6 = new a(5, true);
        a aVar7 = new a(6, false);
        f13675f = aVar7;
        a aVar8 = new a(7, true);
        a aVar9 = new a(8, false);
        a aVar10 = new a(9, true);
        f13676g = aVar10;
        f13677h = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, new a(10, false), new a(10, true)};
    }

    public a(int i3, boolean z5) {
        this.f13678a = i3;
        this.f13679b = z5;
    }

    public final boolean a(a aVar) {
        int i3 = aVar.f13678a;
        int i10 = this.f13678a;
        if (i10 >= i3) {
            return (!this.f13679b || f13676g == this) && i10 == i3;
        }
        return true;
    }
}
