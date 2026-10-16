package g0;

import androidx.camera.core.impl.n;
import androidx.camera.core.impl.s1;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.Iterator;
import t.s0;

/* loaded from: classes.dex */
public final class g extends androidx.camera.core.impl.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13771a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13772b;

    public /* synthetic */ g(Object obj, int i3) {
        this.f13771a = i3;
        this.f13772b = obj;
    }

    @Override // androidx.camera.core.impl.k
    public void b(int i3, n nVar) {
        switch (this.f13771a) {
            case 0:
                Iterator it = ((h) this.f13772b).f13773a.iterator();
                while (it.hasNext()) {
                    s1 s1Var = ((androidx.camera.core.f) it.next()).f1330m;
                    Iterator it2 = s1Var.f1490g.f1369d.iterator();
                    while (it2.hasNext()) {
                        ((androidx.camera.core.impl.k) it2.next()).b(i3, new i(nVar, s1Var.f1490g.f1370f, -1L));
                    }
                }
                return;
            case 1:
                s0 s0Var = (s0) this.f13772b;
                synchronized (s0Var.f18393a) {
                    try {
                        if (s0Var.e) {
                            return;
                        }
                        s0Var.f18400i.put(nVar.d(), new y.c(nVar));
                        s0Var.g();
                        return;
                    } finally {
                    }
                }
            default:
                return;
        }
    }

    @Override // androidx.camera.core.impl.k
    public void d(int i3) {
        switch (this.f13771a) {
            case 2:
                a6.d().execute(new m5.a(this, 13));
                break;
        }
    }
}
