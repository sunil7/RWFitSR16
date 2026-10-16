package z7;

import com.google.android.datatransport.cct.internal.ClientInfo$ClientType;

/* loaded from: classes.dex */
public final class j extends p {

    /* renamed from: a, reason: collision with root package name */
    public final ClientInfo$ClientType f20367a;

    /* renamed from: b, reason: collision with root package name */
    public final h f20368b;

    public j(ClientInfo$ClientType clientInfo$ClientType, h hVar) {
        this.f20367a = clientInfo$ClientType;
        this.f20368b = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        ClientInfo$ClientType clientInfo$ClientType = this.f20367a;
        if (clientInfo$ClientType == null) {
            if (((j) pVar).f20367a != null) {
                return false;
            }
        } else if (!clientInfo$ClientType.equals(((j) pVar).f20367a)) {
            return false;
        }
        return this.f20368b.equals(((j) pVar).f20368b);
    }

    public final int hashCode() {
        ClientInfo$ClientType clientInfo$ClientType = this.f20367a;
        return (((clientInfo$ClientType == null ? 0 : clientInfo$ClientType.hashCode()) ^ 1000003) * 1000003) ^ this.f20368b.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + this.f20367a + ", androidClientInfo=" + this.f20368b + "}";
    }
}
