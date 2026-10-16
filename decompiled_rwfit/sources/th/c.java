package th;

/* loaded from: classes2.dex */
public final class c extends a {

    /* renamed from: d, reason: collision with root package name */
    public static final c f18640d = new c(1, 0, 1);

    public final boolean a(int i3) {
        return this.f18633a <= i3 && i3 <= this.f18634b;
    }

    @Override // th.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        if (this.f18633a == cVar.f18633a) {
            return this.f18634b == cVar.f18634b;
        }
        return false;
    }

    @Override // th.a
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f18633a * 31) + this.f18634b;
    }

    @Override // th.a
    public final boolean isEmpty() {
        return this.f18633a > this.f18634b;
    }

    @Override // th.a
    public final String toString() {
        return this.f18633a + ".." + this.f18634b;
    }
}
