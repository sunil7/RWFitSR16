package th;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class e implements Iterator, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f18644a;

    /* renamed from: b, reason: collision with root package name */
    public final long f18645b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18646c;

    /* renamed from: d, reason: collision with root package name */
    public long f18647d;

    public e(long j4, long j10, long j11) {
        this.f18644a = j11;
        this.f18645b = j10;
        boolean z5 = false;
        if (j11 <= 0 ? j4 >= j10 : j4 <= j10) {
            z5 = true;
        }
        this.f18646c = z5;
        this.f18647d = z5 ? j4 : j10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f18646c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        long j4 = this.f18647d;
        if (j4 != this.f18645b) {
            this.f18647d = this.f18644a + j4;
        } else {
            if (!this.f18646c) {
                throw new NoSuchElementException();
            }
            this.f18646c = false;
        }
        return Long.valueOf(j4);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
