package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2154a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p1 f2155b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f2156c;

    public d(l lVar, ArrayList arrayList, p1 p1Var) {
        this.f2156c = lVar;
        this.f2154a = arrayList;
        this.f2155b = p1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f2154a;
        p1 p1Var = this.f2155b;
        if (arrayList.contains(p1Var)) {
            arrayList.remove(p1Var);
            this.f2156c.getClass();
            p1Var.f2251a.applyState(p1Var.f2253c.mView);
        }
    }
}
