package com.scwang.smart.refresh.layout.simple;

import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.example.test.ui.device.activity.i0;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import dg.g;
import eg.a;
import eg.c;
import eg.d;
import fg.b;

/* loaded from: classes2.dex */
public abstract class SimpleComponent extends RelativeLayout implements a {

    /* renamed from: a, reason: collision with root package name */
    public final View f11687a;

    /* renamed from: b, reason: collision with root package name */
    public b f11688b;

    /* renamed from: c, reason: collision with root package name */
    public final a f11689c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleComponent(View view) {
        super(view.getContext(), null, 0);
        a aVar = view instanceof a ? (a) view : null;
        this.f11687a = view;
        this.f11689c = aVar;
        boolean z5 = this instanceof eg.b;
        b bVar = b.f13682f;
        if (z5 && (aVar instanceof c) && aVar.getSpinnerStyle() == bVar) {
            aVar.getView().setScaleY(-1.0f);
        } else if ((this instanceof c) && (aVar instanceof eg.b) && aVar.getSpinnerStyle() == bVar) {
            aVar.getView().setScaleY(-1.0f);
        }
    }

    @Override // eg.a
    public final void a(i0 i0Var, int i3, int i10) {
        a aVar = this.f11689c;
        if (aVar != null && aVar != this) {
            aVar.a(i0Var, i3, i10);
            return;
        }
        View view = this.f11687a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof g) {
                int i11 = ((g) layoutParams).f12405a;
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) i0Var.f7866b;
                if (smartRefreshLayout.f11647d1 == null && i11 != 0) {
                    smartRefreshLayout.f11647d1 = new Paint();
                }
                if (equals(smartRefreshLayout.f11638a1)) {
                    smartRefreshLayout.f11662j1 = i11;
                } else if (equals(smartRefreshLayout.f11641b1)) {
                    smartRefreshLayout.f11665k1 = i11;
                }
            }
        }
    }

    @Override // eg.a
    public final void b(SmartRefreshLayout smartRefreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        a aVar = this.f11689c;
        if (aVar == null || aVar == this) {
            return;
        }
        if ((this instanceof eg.b) && (aVar instanceof c)) {
            if (refreshState.isFooter) {
                refreshState = refreshState.toHeader();
            }
            if (refreshState2.isFooter) {
                refreshState2 = refreshState2.toHeader();
            }
        } else if ((this instanceof c) && (aVar instanceof eg.b)) {
            if (refreshState.isHeader) {
                refreshState = refreshState.toFooter();
            }
            if (refreshState2.isHeader) {
                refreshState2 = refreshState2.toFooter();
            }
        }
        aVar.b(smartRefreshLayout, refreshState, refreshState2);
    }

    @Override // eg.a
    public final void c(SmartRefreshLayout smartRefreshLayout, int i3, int i10) {
        a aVar = this.f11689c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.c(smartRefreshLayout, i3, i10);
    }

    @Override // eg.a
    public final void d(int i3, float f2, int i10) {
        a aVar = this.f11689c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.d(i3, f2, i10);
    }

    public final boolean e(boolean z5) {
        a aVar = this.f11689c;
        return (aVar instanceof eg.b) && ((eg.b) aVar).e(z5);
    }

    public final boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof a) && getView() == ((a) obj).getView();
    }

    @Override // eg.a
    public final void f(boolean z5, float f2, int i3, int i10, int i11) {
        a aVar = this.f11689c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.f(z5, f2, i3, i10, i11);
    }

    @Override // eg.a
    public final boolean g() {
        a aVar = this.f11689c;
        return (aVar == null || aVar == this || !aVar.g()) ? false : true;
    }

    @Override // eg.a
    public b getSpinnerStyle() {
        int i3;
        b bVar = this.f11688b;
        if (bVar != null) {
            return bVar;
        }
        a aVar = this.f11689c;
        if (aVar != null && aVar != this) {
            return aVar.getSpinnerStyle();
        }
        View view = this.f11687a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof g) {
                b bVar2 = ((g) layoutParams).f12406b;
                this.f11688b = bVar2;
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            if (layoutParams != null && ((i3 = layoutParams.height) == 0 || i3 == -1)) {
                b[] bVarArr = b.f13683g;
                for (int i10 = 0; i10 < 5; i10++) {
                    b bVar3 = bVarArr[i10];
                    if (bVar3.f13685b) {
                        this.f11688b = bVar3;
                        return bVar3;
                    }
                }
            }
        }
        b bVar4 = b.f13680c;
        this.f11688b = bVar4;
        return bVar4;
    }

    @Override // eg.a
    public View getView() {
        View view = this.f11687a;
        return view == null ? this : view;
    }

    @Override // eg.a
    public final void h(d dVar, int i3, int i10) {
        a aVar = this.f11689c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.h(dVar, i3, i10);
    }

    @Override // eg.a
    public final int i(d dVar, boolean z5) {
        a aVar = this.f11689c;
        if (aVar == null || aVar == this) {
            return 0;
        }
        return aVar.i(dVar, z5);
    }

    @Override // eg.a
    public void setPrimaryColors(int... iArr) {
        a aVar = this.f11689c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.setPrimaryColors(iArr);
    }
}
