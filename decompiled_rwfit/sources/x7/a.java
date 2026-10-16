package x7;

import com.google.android.datatransport.Priority;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f19818a;

    /* renamed from: b, reason: collision with root package name */
    public final Priority f19819b;

    public a(Object obj, Priority priority) {
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f19818a = (byte[]) obj;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.f19819b = priority;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        aVar.getClass();
        return this.f19818a.equals(aVar.f19818a) && this.f19819b.equals(aVar.f19819b);
    }

    public final int hashCode() {
        return this.f19819b.hashCode() ^ (((1000003 * 1000003) ^ this.f19818a.hashCode()) * 1000003);
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f19818a + ", priority=" + this.f19819b + "}";
    }
}
