package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public class v0 extends l1 {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f2754a;

    /* renamed from: b, reason: collision with root package name */
    public final c2 f2755b = new c2(this);

    /* renamed from: c, reason: collision with root package name */
    public t0 f2756c;

    /* renamed from: d, reason: collision with root package name */
    public t0 f2757d;

    public static int c(View view, androidx.emoji2.text.g gVar) {
        return ((gVar.f(view) / 2) + gVar.h(view)) - ((gVar.o() / 2) + gVar.n());
    }

    public static View d(i1 i1Var, androidx.emoji2.text.g gVar) {
        int v6 = i1Var.v();
        View view = null;
        if (v6 == 0) {
            return null;
        }
        int o3 = (gVar.o() / 2) + gVar.n();
        int i3 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        for (int i10 = 0; i10 < v6; i10++) {
            View u10 = i1Var.u(i10);
            int abs = Math.abs(((gVar.f(u10) / 2) + gVar.h(u10)) - o3);
            if (abs < i3) {
                view = u10;
                i3 = abs;
            }
        }
        return view;
    }

    public final void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2754a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        c2 c2Var = this.f2755b;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(c2Var);
            this.f2754a.setOnFlingListener(null);
        }
        this.f2754a = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.f2754a.addOnScrollListener(c2Var);
            this.f2754a.setOnFlingListener(this);
            new Scroller(this.f2754a.getContext(), new DecelerateInterpolator());
            h();
        }
    }

    public final int[] b(i1 i1Var, View view) {
        int[] iArr = new int[2];
        if (i1Var.d()) {
            iArr[0] = c(view, f(i1Var));
        } else {
            iArr[0] = 0;
        }
        if (i1Var.e()) {
            iArr[1] = c(view, g(i1Var));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    public View e(i1 i1Var) {
        if (i1Var.e()) {
            return d(i1Var, g(i1Var));
        }
        if (i1Var.d()) {
            return d(i1Var, f(i1Var));
        }
        return null;
    }

    public final androidx.emoji2.text.g f(i1 i1Var) {
        t0 t0Var = this.f2757d;
        if (t0Var == null || ((i1) t0Var.f2030b) != i1Var) {
            this.f2757d = new t0(i1Var, 0);
        }
        return this.f2757d;
    }

    public final androidx.emoji2.text.g g(i1 i1Var) {
        t0 t0Var = this.f2756c;
        if (t0Var == null || ((i1) t0Var.f2030b) != i1Var) {
            this.f2756c = new t0(i1Var, 1);
        }
        return this.f2756c;
    }

    public final void h() {
        i1 layoutManager;
        View e;
        RecyclerView recyclerView = this.f2754a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (e = e(layoutManager)) == null) {
            return;
        }
        int[] b3 = b(layoutManager, e);
        int i3 = b3[0];
        if (i3 == 0 && b3[1] == 0) {
            return;
        }
        this.f2754a.h0(i3, b3[1], false);
    }
}
