package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public final class f extends h.v {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f891l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ l f892m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(l lVar, Context context, h.k kVar, View view) {
        super(R$attr.actionOverflowMenuStyle, context, view, kVar, true);
        this.f892m = lVar;
        this.f14209f = 8388613;
        androidx.appcompat.app.t tVar = lVar.f974x;
        this.f14211h = tVar;
        h.s sVar = this.f14212i;
        if (sVar != null) {
            sVar.c(tVar);
        }
    }

    @Override // h.v
    public final void c() {
        switch (this.f891l) {
            case 0:
                l lVar = this.f892m;
                lVar.f971u = null;
                lVar.f975y = 0;
                super.c();
                break;
            default:
                l lVar2 = this.f892m;
                h.k kVar = lVar2.f955c;
                if (kVar != null) {
                    kVar.c(true);
                }
                lVar2.f970t = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(l lVar, Context context, h.d0 d0Var, View view) {
        super(R$attr.actionOverflowMenuStyle, context, view, d0Var, false);
        this.f892m = lVar;
        if ((d0Var.A.f14190x & 32) != 32) {
            View view2 = lVar.f961j;
            this.e = view2 == null ? (View) lVar.f959h : view2;
        }
        androidx.appcompat.app.t tVar = lVar.f974x;
        this.f14211h = tVar;
        h.s sVar = this.f14212i;
        if (sVar != null) {
            sVar.c(tVar);
        }
    }
}
