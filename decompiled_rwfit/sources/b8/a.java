package b8;

import com.google.android.datatransport.runtime.backends.BackendResponse$Status;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final BackendResponse$Status f3165a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3166b;

    public a(BackendResponse$Status backendResponse$Status, long j4) {
        if (backendResponse$Status == null) {
            throw new NullPointerException("Null status");
        }
        this.f3165a = backendResponse$Status;
        this.f3166b = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f3165a.equals(aVar.f3165a) && this.f3166b == aVar.f3166b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f3165a.hashCode() ^ 1000003) * 1000003;
        long j4 = this.f3166b;
        return hashCode ^ ((int) ((j4 >>> 32) ^ j4));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BackendResponse{status=");
        sb2.append(this.f3165a);
        sb2.append(", nextRequestWaitMillis=");
        return android.support.v4.media.session.e.n(sb2, this.f3166b, "}");
    }
}
