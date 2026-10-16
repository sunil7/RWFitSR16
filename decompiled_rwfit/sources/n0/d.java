package n0;

import com.google.android.gms.internal.mlkit_vision_barcode.ue;

/* loaded from: classes.dex */
public final class d extends ue {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ue
    public final boolean a(f fVar, b bVar, b bVar2) {
        synchronized (fVar) {
            try {
                if (fVar.f16354b != bVar) {
                    return false;
                }
                fVar.f16354b = bVar2;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ue
    public final boolean b(f fVar, Object obj, Object obj2) {
        synchronized (fVar) {
            try {
                if (fVar.f16353a != obj) {
                    return false;
                }
                fVar.f16353a = obj2;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ue
    public final boolean c(f fVar, e eVar, e eVar2) {
        synchronized (fVar) {
            try {
                if (fVar.f16355c != eVar) {
                    return false;
                }
                fVar.f16355c = eVar2;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ue
    public final void d(e eVar, e eVar2) {
        eVar.f16349b = eVar2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ue
    public final void e(e eVar, Thread thread) {
        eVar.f16348a = thread;
    }
}
