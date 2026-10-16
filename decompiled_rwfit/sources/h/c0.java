package h;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.k2;
import androidx.appcompat.widget.t1;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public final class c0 extends s implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: u, reason: collision with root package name */
    public static final int f14085u = R$layout.abc_popup_menu_item_layout;

    /* renamed from: b, reason: collision with root package name */
    public final Context f14086b;

    /* renamed from: c, reason: collision with root package name */
    public final k f14087c;

    /* renamed from: d, reason: collision with root package name */
    public final h f14088d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final int f14089f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14090g;

    /* renamed from: h, reason: collision with root package name */
    public final k2 f14091h;

    /* renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f14094k;

    /* renamed from: l, reason: collision with root package name */
    public View f14095l;

    /* renamed from: m, reason: collision with root package name */
    public View f14096m;

    /* renamed from: n, reason: collision with root package name */
    public w f14097n;

    /* renamed from: o, reason: collision with root package name */
    public ViewTreeObserver f14098o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f14099p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14100q;
    public int r;

    /* renamed from: t, reason: collision with root package name */
    public boolean f14102t;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.appcompat.widget.s f14092i = new androidx.appcompat.widget.s(this, 5);

    /* renamed from: j, reason: collision with root package name */
    public final c f14093j = new c(this, 1);

    /* renamed from: s, reason: collision with root package name */
    public int f14101s = 0;

    public c0(int i3, Context context, View view, k kVar, boolean z5) {
        this.f14086b = context;
        this.f14087c = kVar;
        this.e = z5;
        this.f14088d = new h(kVar, LayoutInflater.from(context), z5, f14085u);
        this.f14090g = i3;
        Resources resources = context.getResources();
        this.f14089f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f14095l = view;
        this.f14091h = new k2(context, null, i3, 0);
        kVar.b(this, context);
    }

    @Override // h.b0
    public final boolean a() {
        return !this.f14099p && this.f14091h.f779z.isShowing();
    }

    @Override // h.x
    public final void b(k kVar, boolean z5) {
        if (kVar != this.f14087c) {
            return;
        }
        dismiss();
        w wVar = this.f14097n;
        if (wVar != null) {
            wVar.b(kVar, z5);
        }
    }

    @Override // h.x
    public final void c(w wVar) {
        this.f14097n = wVar;
    }

    @Override // h.b0
    public final void d() {
        View view;
        if (a()) {
            return;
        }
        if (this.f14099p || (view = this.f14095l) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f14096m = view;
        k2 k2Var = this.f14091h;
        k2Var.setOnDismissListener(this);
        k2Var.setOnItemClickListener(this);
        k2Var.f778y = true;
        k2Var.f779z.setFocusable(true);
        View view2 = this.f14096m;
        boolean z5 = this.f14098o == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f14098o = viewTreeObserver;
        if (z5) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f14092i);
        }
        view2.addOnAttachStateChangeListener(this.f14093j);
        k2Var.f769o = view2;
        k2Var.f766l = this.f14101s;
        boolean z6 = this.f14100q;
        Context context = this.f14086b;
        h hVar = this.f14088d;
        if (!z6) {
            this.r = s.o(hVar, context, this.f14089f);
            this.f14100q = true;
        }
        k2Var.r(this.r);
        k2Var.f779z.setInputMethodMode(2);
        Rect rect = this.f14203a;
        k2Var.f777x = rect != null ? new Rect(rect) : null;
        k2Var.d();
        t1 t1Var = k2Var.f758c;
        t1Var.setOnKeyListener(this);
        if (this.f14102t) {
            k kVar = this.f14087c;
            if (kVar.f14155m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) t1Var, false);
                TextView textView = (TextView) frameLayout.findViewById(R.id.title);
                if (textView != null) {
                    textView.setText(kVar.f14155m);
                }
                frameLayout.setEnabled(false);
                t1Var.addHeaderView(frameLayout, null, false);
            }
        }
        k2Var.p(hVar);
        k2Var.d();
    }

    @Override // h.b0
    public final void dismiss() {
        if (a()) {
            this.f14091h.dismiss();
        }
    }

    @Override // h.x
    public final void e(Parcelable parcelable) {
    }

    @Override // h.b0
    public final t1 f() {
        return this.f14091h.f758c;
    }

    @Override // h.x
    public final void g(boolean z5) {
        this.f14100q = false;
        h hVar = this.f14088d;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // h.x
    public final boolean i() {
        return false;
    }

    @Override // h.x
    public final Parcelable j() {
        return null;
    }

    @Override // h.x
    public final boolean m(d0 d0Var) {
        if (d0Var.hasVisibleItems()) {
            View view = this.f14096m;
            v vVar = new v(this.f14090g, this.f14086b, view, d0Var, this.e);
            w wVar = this.f14097n;
            vVar.f14211h = wVar;
            s sVar = vVar.f14212i;
            if (sVar != null) {
                sVar.c(wVar);
            }
            boolean v6 = s.v(d0Var);
            vVar.f14210g = v6;
            s sVar2 = vVar.f14212i;
            if (sVar2 != null) {
                sVar2.q(v6);
            }
            vVar.setOnDismissListener(this.f14094k);
            this.f14094k = null;
            this.f14087c.c(false);
            k2 k2Var = this.f14091h;
            int i3 = k2Var.f760f;
            int l3 = k2Var.l();
            int i10 = this.f14101s;
            View view2 = this.f14095l;
            WeakHashMap weakHashMap = z0.f15748a;
            if ((Gravity.getAbsoluteGravity(i10, i0.d(view2)) & 7) == 5) {
                i3 += this.f14095l.getWidth();
            }
            if (!vVar.b()) {
                if (vVar.e != null) {
                    vVar.d(i3, l3, true, true);
                }
            }
            w wVar2 = this.f14097n;
            if (wVar2 != null) {
                wVar2.c(d0Var);
            }
            return true;
        }
        return false;
    }

    @Override // h.s
    public final void n(k kVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f14099p = true;
        this.f14087c.c(true);
        ViewTreeObserver viewTreeObserver = this.f14098o;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f14098o = this.f14096m.getViewTreeObserver();
            }
            this.f14098o.removeGlobalOnLayoutListener(this.f14092i);
            this.f14098o = null;
        }
        this.f14096m.removeOnAttachStateChangeListener(this.f14093j);
        PopupWindow.OnDismissListener onDismissListener = this.f14094k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i3 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // h.s
    public final void p(View view) {
        this.f14095l = view;
    }

    @Override // h.s
    public final void q(boolean z5) {
        this.f14088d.f14140c = z5;
    }

    @Override // h.s
    public final void r(int i3) {
        this.f14101s = i3;
    }

    @Override // h.s
    public final void s(int i3) {
        this.f14091h.f760f = i3;
    }

    @Override // h.s
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f14094k = onDismissListener;
    }

    @Override // h.s
    public final void t(boolean z5) {
        this.f14102t = z5;
    }

    @Override // h.s
    public final void u(int i3) {
        this.f14091h.h(i3);
    }
}
