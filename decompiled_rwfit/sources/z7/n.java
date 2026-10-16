package z7;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType;

/* loaded from: classes.dex */
public final class n extends s {

    /* renamed from: a, reason: collision with root package name */
    public final NetworkConnectionInfo$NetworkType f20382a;

    /* renamed from: b, reason: collision with root package name */
    public final NetworkConnectionInfo$MobileSubtype f20383b;

    public n(NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType, NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype) {
        this.f20382a = networkConnectionInfo$NetworkType;
        this.f20383b = networkConnectionInfo$MobileSubtype;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType = this.f20382a;
            if (networkConnectionInfo$NetworkType != null ? networkConnectionInfo$NetworkType.equals(((n) sVar).f20382a) : ((n) sVar).f20382a == null) {
                NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype = this.f20383b;
                if (networkConnectionInfo$MobileSubtype != null ? networkConnectionInfo$MobileSubtype.equals(((n) sVar).f20383b) : ((n) sVar).f20383b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType = this.f20382a;
        int hashCode = ((networkConnectionInfo$NetworkType == null ? 0 : networkConnectionInfo$NetworkType.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype = this.f20383b;
        return (networkConnectionInfo$MobileSubtype != null ? networkConnectionInfo$MobileSubtype.hashCode() : 0) ^ hashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f20382a + ", mobileSubtype=" + this.f20383b + "}";
    }
}
