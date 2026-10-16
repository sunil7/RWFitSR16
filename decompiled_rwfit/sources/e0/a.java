package e0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f12407a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12408b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12409c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12410d;

    public a(String str, String str2, String str3, String str4) {
        this.f12407a = str;
        this.f12408b = str2;
        this.f12409c = str3;
        this.f12410d = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f12407a.equals(aVar.f12407a) && this.f12408b.equals(aVar.f12408b) && this.f12409c.equals(aVar.f12409c) && this.f12410d.equals(aVar.f12410d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f12407a.hashCode() ^ 1000003) * 1000003) ^ this.f12408b.hashCode()) * 1000003) ^ this.f12409c.hashCode()) * 1000003) ^ this.f12410d.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("GraphicDeviceInfo{glVersion=");
        sb2.append(this.f12407a);
        sb2.append(", eglVersion=");
        sb2.append(this.f12408b);
        sb2.append(", glExtensions=");
        sb2.append(this.f12409c);
        sb2.append(", eglExtensions=");
        return r5.a.f(sb2, this.f12410d, "}");
    }
}
