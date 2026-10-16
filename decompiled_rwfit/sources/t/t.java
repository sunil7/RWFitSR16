package t;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: c, reason: collision with root package name */
    public static final t f18405c = new t(0, 0);

    /* renamed from: d, reason: collision with root package name */
    public static final t f18406d = new t(1, 8);
    public static final t e = new t(3, 10);

    /* renamed from: f, reason: collision with root package name */
    public static final t f18407f = new t(4, 10);

    /* renamed from: g, reason: collision with root package name */
    public static final t f18408g = new t(5, 10);

    /* renamed from: h, reason: collision with root package name */
    public static final t f18409h = new t(6, 10);

    /* renamed from: i, reason: collision with root package name */
    public static final t f18410i = new t(6, 8);

    /* renamed from: a, reason: collision with root package name */
    public final int f18411a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18412b;

    public t(int i3, int i10) {
        this.f18411a = i3;
        this.f18412b = i10;
    }

    public final boolean a() {
        return b() && this.f18411a != 1 && this.f18412b == 10;
    }

    public final boolean b() {
        int i3 = this.f18411a;
        return (i3 == 0 || i3 == 2 || this.f18412b == 0) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f18411a == tVar.f18411a && this.f18412b == tVar.f18412b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f18411a ^ 1000003) * 1000003) ^ this.f18412b;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("DynamicRange@");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("{encoding=");
        switch (this.f18411a) {
            case 0:
                str = "UNSPECIFIED";
                break;
            case 1:
                str = "SDR";
                break;
            case 2:
                str = "HDR_UNSPECIFIED";
                break;
            case 3:
                str = "HLG";
                break;
            case 4:
                str = "HDR10";
                break;
            case 5:
                str = "HDR10_PLUS";
                break;
            case 6:
                str = "DOLBY_VISION";
                break;
            default:
                str = "<Unknown>";
                break;
        }
        sb2.append(str);
        sb2.append(", bitDepth=");
        return r5.a.e(sb2, this.f18412b, "}");
    }
}
