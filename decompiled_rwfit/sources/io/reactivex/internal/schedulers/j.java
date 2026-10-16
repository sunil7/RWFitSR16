package io.reactivex.internal.schedulers;

import rg.w;
import rg.x;

/* loaded from: classes2.dex */
public final class j extends x {

    /* renamed from: c, reason: collision with root package name */
    public static final RxThreadFactory f15089c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b, reason: collision with root package name */
    public final RxThreadFactory f15090b = f15089c;

    @Override // rg.x
    public final w a() {
        return new k(this.f15090b);
    }
}
