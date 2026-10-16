package androidx.lifecycle;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class e extends y {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ a2.i f2348l;

    public e(a2.i iVar) {
        this.f2348l = iVar;
    }

    @Override // androidx.lifecycle.y
    public final void g() {
        a2.i iVar = this.f2348l;
        ((Executor) iVar.f38a).execute((androidx.activity.e) iVar.f42f);
    }
}
