package ud;

import be.j;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19055a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19056b;

    /* renamed from: c, reason: collision with root package name */
    public j f19057c;

    /* renamed from: d, reason: collision with root package name */
    public String f19058d;

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DeviceStatus{status=0, isAuthDevice=");
        sb2.append(this.f19055a);
        sb2.append(", isEnterLowPowerMode=false, isMandatoryUpgrade=");
        sb2.append(this.f19056b);
        sb2.append(", mTargetInfo=");
        sb2.append(this.f19057c);
        sb2.append(", mDevMD5='");
        return r5.a.f(sb2, this.f19058d, "'}");
    }
}
