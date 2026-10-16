package t;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18336a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18337b;

    public /* synthetic */ g0(Object obj, int i3) {
        this.f18336a = i3;
        this.f18337b = obj;
    }

    @Override // t.w
    public final void a(x xVar) {
        w wVar;
        switch (this.f18336a) {
            case 0:
                i0 i0Var = (i0) ((WeakReference) ((h0) this.f18337b).e).get();
                if (i0Var != null) {
                    i0Var.f18346t.execute(new m5.a(i0Var, 11));
                    return;
                }
                return;
            default:
                z0 z0Var = (z0) this.f18337b;
                synchronized (z0Var.f18432a) {
                    try {
                        int i3 = z0Var.f18433b - 1;
                        z0Var.f18433b = i3;
                        if (z0Var.f18434c && i3 == 0) {
                            z0Var.close();
                        }
                        wVar = z0Var.f18436f;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (wVar != null) {
                    wVar.a(xVar);
                    return;
                }
                return;
        }
    }
}
