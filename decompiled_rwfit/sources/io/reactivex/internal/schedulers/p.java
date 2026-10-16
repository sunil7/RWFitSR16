package io.reactivex.internal.schedulers;

/* loaded from: classes2.dex */
public final class p implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f15105a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15106b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15107c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f15108d;

    public p(Runnable runnable, Long l3, int i3) {
        this.f15105a = runnable;
        this.f15106b = l3.longValue();
        this.f15107c = i3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        p pVar = (p) obj;
        long j4 = pVar.f15106b;
        long j10 = this.f15106b;
        int i3 = j10 < j4 ? -1 : j10 > j4 ? 1 : 0;
        if (i3 != 0) {
            return i3;
        }
        int i10 = this.f15107c;
        int i11 = pVar.f15107c;
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }
}
