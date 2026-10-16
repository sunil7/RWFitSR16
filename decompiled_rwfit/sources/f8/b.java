package f8;

import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final i8.a f13503a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13504b;

    public b(i8.a aVar, HashMap hashMap) {
        this.f13503a = aVar;
        this.f13504b = hashMap;
    }

    public final long a(Priority priority, long j4, int i3) {
        long c9 = j4 - this.f13503a.c();
        c cVar = (c) this.f13504b.get(priority);
        long j10 = cVar.f13505a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i3 - 1) * j10 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j10 > 1 ? j10 : 2L) * r12))), c9), cVar.f13506b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13503a.equals(bVar.f13503a) && this.f13504b.equals(bVar.f13504b);
    }

    public final int hashCode() {
        return ((this.f13503a.hashCode() ^ 1000003) * 1000003) ^ this.f13504b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f13503a + ", values=" + this.f13504b + "}";
    }
}
