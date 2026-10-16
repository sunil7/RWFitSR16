package y;

import com.google.android.gms.internal.mlkit_vision_common.a0;
import t.k0;

/* loaded from: classes.dex */
public final class g implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public final k0 f19856a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19857b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f19858c;

    public g(k0 k0Var) {
        this.f19856a = k0Var;
    }

    public final void a() {
        eh.g gVar;
        synchronized (this.f19857b) {
            try {
                if (this.f19858c) {
                    k0 k0Var = this.f19856a;
                    if (k0Var != null) {
                        k0Var.clear();
                        gVar = eh.g.f12633a;
                    } else {
                        gVar = null;
                    }
                    if (gVar == null) {
                        a0.b("ScreenFlashWrapper", "completePendingScreenFlashClear: screenFlash is null!");
                    }
                } else {
                    a0.e("ScreenFlashWrapper", "completePendingScreenFlashClear: none pending!");
                }
                this.f19858c = false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b() {
        synchronized (this.f19857b) {
        }
    }

    @Override // t.k0
    public final void clear() {
        a();
    }
}
