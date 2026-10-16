package z2;

import com.google.android.gms.internal.mlkit_vision_common.p6;

/* loaded from: classes.dex */
public final class e extends p6 {
    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final boolean a(g gVar, b bVar, b bVar2) {
        synchronized (gVar) {
            try {
                if (gVar.f20204b != bVar) {
                    return false;
                }
                gVar.f20204b = bVar2;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final boolean b(g gVar, Object obj, Object obj2) {
        synchronized (gVar) {
            try {
                if (gVar.f20203a != obj) {
                    return false;
                }
                gVar.f20203a = obj2;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final boolean c(g gVar, f fVar, f fVar2) {
        synchronized (gVar) {
            try {
                if (gVar.f20205c != fVar) {
                    return false;
                }
                gVar.f20205c = fVar2;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final void d(f fVar, f fVar2) {
        fVar.f20199b = fVar2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final void e(f fVar, Thread thread) {
        fVar.f20198a = thread;
    }
}
