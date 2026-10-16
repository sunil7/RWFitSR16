package s5;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f18210a;

    /* renamed from: b, reason: collision with root package name */
    public int f18211b;

    /* renamed from: c, reason: collision with root package name */
    public String f18212c;

    /* renamed from: d, reason: collision with root package name */
    public int f18213d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public String f18214f;

    /* renamed from: g, reason: collision with root package name */
    public int f18215g;

    public final boolean a() {
        String str = this.f18210a;
        if (str != null) {
            return str.contains("SmartBox") || this.f18210a.contains("AC701N_watch");
        }
        return false;
    }

    public final String toString() {
        return "BleDevice{bleName='" + this.f18210a + "', bleRssi=" + this.f18211b + ", bleMac='" + this.f18212c + "', status=" + this.f18213d + ", bindStatus=" + this.e + ", rawDataFlag=" + this.f18214f + '}';
    }
}
