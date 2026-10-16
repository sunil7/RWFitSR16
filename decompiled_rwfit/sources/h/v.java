package h;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14205a;

    /* renamed from: b, reason: collision with root package name */
    public final k f14206b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14207c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14208d;
    public View e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14210g;

    /* renamed from: h, reason: collision with root package name */
    public w f14211h;

    /* renamed from: i, reason: collision with root package name */
    public s f14212i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f14213j;

    /* renamed from: f, reason: collision with root package name */
    public int f14209f = 8388611;

    /* renamed from: k, reason: collision with root package name */
    public final t f14214k = new t(this);

    public v(int i3, Context context, View view, k kVar, boolean z5) {
        this.f14205a = context;
        this.f14206b = kVar;
        this.e = view;
        this.f14207c = z5;
        this.f14208d = i3;
    }

    public final s a() {
        s c0Var;
        if (this.f14212i == null) {
            Context context = this.f14205a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            u.a(defaultDisplay, point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width)) {
                c0Var = new e(context, this.e, this.f14208d, this.f14207c);
            } else {
                View view = this.e;
                Context context2 = this.f14205a;
                boolean z5 = this.f14207c;
                c0Var = new c0(this.f14208d, context2, view, this.f14206b, z5);
            }
            c0Var.n(this.f14206b);
            c0Var.setOnDismissListener(this.f14214k);
            c0Var.p(this.e);
            c0Var.c(this.f14211h);
            c0Var.q(this.f14210g);
            c0Var.r(this.f14209f);
            this.f14212i = c0Var;
        }
        return this.f14212i;
    }

    public final boolean b() {
        s sVar = this.f14212i;
        return sVar != null && sVar.a();
    }

    public void c() {
        this.f14212i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f14213j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i3, int i10, boolean z5, boolean z6) {
        s a3 = a();
        a3.t(z6);
        if (z5) {
            int i11 = this.f14209f;
            View view = this.e;
            WeakHashMap weakHashMap = z0.f15748a;
            if ((Gravity.getAbsoluteGravity(i11, i0.d(view)) & 7) == 5) {
                i3 -= this.e.getWidth();
            }
            a3.s(i3);
            a3.u(i10);
            int i12 = (int) ((this.f14205a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a3.f14203a = new Rect(i3 - i12, i10 - i12, i3 + i12, i10 + i12);
        }
        a3.d();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f14213j = onDismissListener;
    }
}
