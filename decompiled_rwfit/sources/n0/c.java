package n0;

import com.google.android.gms.internal.mlkit_vision_barcode.ue;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class c extends ue {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f16343a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f16344b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f16345c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f16346d;
    public final AtomicReferenceFieldUpdater e;

    public c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f16343a = atomicReferenceFieldUpdater;
        this.f16344b = atomicReferenceFieldUpdater2;
        this.f16345c = atomicReferenceFieldUpdater3;
        this.f16346d = atomicReferenceFieldUpdater4;
        this.e = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ue
    public final boolean a(f fVar, b bVar, b bVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f16346d;
            if (atomicReferenceFieldUpdater.compareAndSet(fVar, bVar, bVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(fVar) == bVar);
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ue
    public final boolean b(f fVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.e;
            if (atomicReferenceFieldUpdater.compareAndSet(fVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(fVar) == obj);
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ue
    public final boolean c(f fVar, e eVar, e eVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f16345c;
            if (atomicReferenceFieldUpdater.compareAndSet(fVar, eVar, eVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(fVar) == eVar);
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ue
    public final void d(e eVar, e eVar2) {
        this.f16344b.lazySet(eVar, eVar2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ue
    public final void e(e eVar, Thread thread) {
        this.f16343a.lazySet(eVar, thread);
    }
}
