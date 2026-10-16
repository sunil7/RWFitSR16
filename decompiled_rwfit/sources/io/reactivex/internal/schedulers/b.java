package io.reactivex.internal.schedulers;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f15062a;

    /* renamed from: b, reason: collision with root package name */
    public final c[] f15063b;

    /* renamed from: c, reason: collision with root package name */
    public long f15064c;

    public b(int i3, RxThreadFactory rxThreadFactory) {
        this.f15062a = i3;
        this.f15063b = new c[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            this.f15063b[i10] = new c(rxThreadFactory);
        }
    }

    public final c a() {
        int i3 = this.f15062a;
        if (i3 == 0) {
            return d.f15067f;
        }
        long j4 = this.f15064c;
        this.f15064c = 1 + j4;
        return this.f15063b[(int) (j4 % i3)];
    }
}
