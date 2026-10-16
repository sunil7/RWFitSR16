package x2;

import androidx.work.WorkInfo$State;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public String f19746a;

    /* renamed from: b, reason: collision with root package name */
    public WorkInfo$State f19747b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f19747b != gVar.f19747b) {
            return false;
        }
        return this.f19746a.equals(gVar.f19746a);
    }

    public final int hashCode() {
        return this.f19747b.hashCode() + (this.f19746a.hashCode() * 31);
    }
}
