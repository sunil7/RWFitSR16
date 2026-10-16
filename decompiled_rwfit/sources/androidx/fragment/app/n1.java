package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2228a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2229b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2230c;

    public /* synthetic */ n1(l lVar, p1 p1Var, int i3) {
        this.f2228a = i3;
        this.f2230c = lVar;
        this.f2229b = p1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2228a) {
            case 0:
                ArrayList arrayList = ((l) this.f2230c).f2214b;
                p1 p1Var = (p1) this.f2229b;
                if (arrayList.contains(p1Var)) {
                    p1Var.f2251a.applyState(p1Var.f2253c.mView);
                    break;
                }
                break;
            case 1:
                l lVar = (l) this.f2230c;
                ArrayList arrayList2 = lVar.f2214b;
                p1 p1Var2 = (p1) this.f2229b;
                arrayList2.remove(p1Var2);
                lVar.f2215c.remove(p1Var2);
                break;
            default:
                k1.g((View) this.f2229b, (Rect) this.f2230c);
                break;
        }
    }

    public n1(k1 k1Var, View view, Rect rect) {
        this.f2228a = 2;
        this.f2229b = view;
        this.f2230c = rect;
    }
}
