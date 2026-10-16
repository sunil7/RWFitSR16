package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2174a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2175b;

    public /* synthetic */ f(Object obj, int i3) {
        this.f2174a = i3;
        this.f2175b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2174a) {
            case 0:
                g gVar = (g) this.f2175b;
                gVar.f2178a.endViewTransition(gVar.f2179b);
                gVar.f2180c.a();
                break;
            case 1:
                e1.b(4, (ArrayList) this.f2175b);
                break;
            case 2:
                ((k) this.f2175b).a();
                break;
            case 3:
                p pVar = (p) this.f2175b;
                pVar.f2239d.onDismiss(pVar.f2246l);
                break;
            case 4:
                ((l) this.f2175b).d();
                break;
            default:
                ((t0) this.f2175b).s(true);
                break;
        }
    }
}
