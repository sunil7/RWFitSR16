package th;

import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class d implements Iterable, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f18641a;

    /* renamed from: b, reason: collision with root package name */
    public final long f18642b;

    /* renamed from: c, reason: collision with root package name */
    public final long f18643c;

    public d(long j4, long j10) {
        this.f18641a = j4;
        if (j4 < j10) {
            long j11 = j10 % 1;
            long j12 = j4 % 1;
            long j13 = ((j11 < 0 ? j11 + 1 : j11) - (j12 < 0 ? j12 + 1 : j12)) % 1;
            j10 -= j13 < 0 ? j13 + 1 : j13;
        }
        this.f18642b = j10;
        this.f18643c = 1L;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this.f18641a, this.f18642b, this.f18643c);
    }
}
