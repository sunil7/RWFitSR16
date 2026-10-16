package z2;

import com.google.android.gms.internal.mlkit_vision_common.p6;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class c extends p6 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f20191a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f20192b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f20193c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f20194d;
    public final AtomicReferenceFieldUpdater e;

    public c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f20191a = atomicReferenceFieldUpdater;
        this.f20192b = atomicReferenceFieldUpdater2;
        this.f20193c = atomicReferenceFieldUpdater3;
        this.f20194d = atomicReferenceFieldUpdater4;
        this.e = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final boolean a(g gVar, b bVar, b bVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f20194d;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, bVar, bVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == bVar);
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final boolean b(g gVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.e;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == obj);
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final boolean c(g gVar, f fVar, f fVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f20193c;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, fVar, fVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == fVar);
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final void d(f fVar, f fVar2) {
        this.f20192b.lazySet(fVar, fVar2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final void e(f fVar, Thread thread) {
        this.f20191a.lazySet(fVar, thread);
    }
}
