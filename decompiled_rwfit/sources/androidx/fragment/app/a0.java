package androidx.fragment.app;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class a0 implements c.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f2142a;

    public a0(FragmentActivity fragmentActivity) {
        this.f2142a = fragmentActivity;
    }

    @Override // c.c
    public final void a() {
        FragmentActivity fragmentActivity = this.f2142a;
        s sVar = fragmentActivity.f2090s;
        b0 b0Var = (b0) sVar.f2264b;
        b0Var.f2184d.b(b0Var, b0Var, null);
        Bundle a3 = fragmentActivity.e.f12443b.a("android:support:fragments");
        if (a3 != null) {
            ((b0) sVar.f2264b).f2184d.K(a3.getParcelable("android:support:fragments"));
        }
    }
}
