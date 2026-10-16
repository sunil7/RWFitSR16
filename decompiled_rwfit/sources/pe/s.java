package pe;

import com.google.android.gms.internal.mlkit_vision_common.n6;
import java.util.ArrayList;
import n.m0;

/* loaded from: classes2.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f17586a = new ArrayList();

    public final boolean a(b bVar) {
        m0 m0Var = j.f17574a;
        if (!((r) m0Var.f16254b).b()) {
            synchronized (this.f17586a) {
                try {
                    if (!((r) m0Var.f16254b).b()) {
                        m0Var.s(n6.f10047a);
                        if (!this.f17586a.contains(bVar)) {
                            bVar.f17544a.f17558d = (byte) 0;
                            ArrayList arrayList = e.f17562a.f1421a;
                            if (arrayList.isEmpty() || !arrayList.contains(bVar)) {
                                bVar.f17554l = false;
                            }
                            this.f17586a.add(bVar);
                        }
                        return true;
                    }
                } finally {
                }
            }
        }
        b(bVar);
        return false;
    }

    public final void b(b bVar) {
        if (this.f17586a.isEmpty()) {
            return;
        }
        synchronized (this.f17586a) {
            this.f17586a.remove(bVar);
        }
    }
}
