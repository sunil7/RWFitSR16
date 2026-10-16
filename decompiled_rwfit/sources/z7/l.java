package z7;

import com.google.android.datatransport.cct.internal.QosTier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l extends r {

    /* renamed from: a, reason: collision with root package name */
    public final long f20375a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20376b;

    /* renamed from: c, reason: collision with root package name */
    public final j f20377c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f20378d;
    public final String e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f20379f;

    /* renamed from: g, reason: collision with root package name */
    public final QosTier f20380g;

    public l(long j4, long j10, j jVar, Integer num, String str, ArrayList arrayList, QosTier qosTier) {
        this.f20375a = j4;
        this.f20376b = j10;
        this.f20377c = jVar;
        this.f20378d = num;
        this.e = str;
        this.f20379f = arrayList;
        this.f20380g = qosTier;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        l lVar = (l) ((r) obj);
        if (this.f20375a != lVar.f20375a) {
            return false;
        }
        if (this.f20376b != lVar.f20376b) {
            return false;
        }
        if (!this.f20377c.equals(lVar.f20377c)) {
            return false;
        }
        Integer num = lVar.f20378d;
        Integer num2 = this.f20378d;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str = lVar.e;
        String str2 = this.e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (!this.f20379f.equals(lVar.f20379f)) {
            return false;
        }
        QosTier qosTier = lVar.f20380g;
        QosTier qosTier2 = this.f20380g;
        return qosTier2 == null ? qosTier == null : qosTier2.equals(qosTier);
    }

    public final int hashCode() {
        long j4 = this.f20375a;
        long j10 = this.f20376b;
        int hashCode = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j10 >>> 32) ^ j10))) * 1000003) ^ this.f20377c.hashCode()) * 1000003;
        Integer num = this.f20378d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        int hashCode3 = (((hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f20379f.hashCode()) * 1000003;
        QosTier qosTier = this.f20380g;
        return hashCode3 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f20375a + ", requestUptimeMs=" + this.f20376b + ", clientInfo=" + this.f20377c + ", logSource=" + this.f20378d + ", logSourceName=" + this.e + ", logEvents=" + this.f20379f + ", qosTier=" + this.f20380g + "}";
    }
}
