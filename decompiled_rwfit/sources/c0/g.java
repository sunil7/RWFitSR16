package c0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g implements k1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3301a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3302b;

    @Override // k1.a
    public final void f(Object obj) {
        switch (this.f3301a) {
            case 0:
                kotlin.jvm.internal.e.d((k1.a) this.f3302b, "Listener is not set.");
                ((k1.a) this.f3302b).f(obj);
                return;
            case 1:
                i1.d dVar = (i1.d) obj;
                if (dVar == null) {
                    dVar = new i1.d(-3);
                }
                ((ef.i) this.f3302b).G(dVar);
                return;
            default:
                i1.d dVar2 = (i1.d) obj;
                synchronized (i1.e.f14342c) {
                    try {
                        m0.k kVar = i1.e.f14343d;
                        ArrayList arrayList = (ArrayList) kVar.getOrDefault((String) this.f3302b, null);
                        if (arrayList == null) {
                            return;
                        }
                        kVar.remove((String) this.f3302b);
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            ((k1.a) arrayList.get(i3)).f(dVar2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }

    public /* synthetic */ g(Object obj, int i3) {
        this.f3301a = i3;
        this.f3302b = obj;
    }
}
