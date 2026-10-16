package androidx.appcompat.app;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.k1;
import androidx.appcompat.widget.w3;
import androidx.appcompat.widget.x3;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.f1;
import l1.g1;
import l1.z0;

/* loaded from: classes.dex */
public final class p0 extends b implements androidx.appcompat.widget.d {

    /* renamed from: y, reason: collision with root package name */
    public static final AccelerateInterpolator f538y = new AccelerateInterpolator();

    /* renamed from: z, reason: collision with root package name */
    public static final DecelerateInterpolator f539z = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public Context f540a;

    /* renamed from: b, reason: collision with root package name */
    public Context f541b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f542c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f543d;
    public k1 e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f544f;

    /* renamed from: g, reason: collision with root package name */
    public final View f545g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f546h;

    /* renamed from: i, reason: collision with root package name */
    public o0 f547i;

    /* renamed from: j, reason: collision with root package name */
    public o0 f548j;

    /* renamed from: k, reason: collision with root package name */
    public com.example.test.utils.y f549k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f550l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f551m;

    /* renamed from: n, reason: collision with root package name */
    public int f552n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f553o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f554p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f555q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public g.j f556s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f557t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f558u;

    /* renamed from: v, reason: collision with root package name */
    public final n0 f559v;

    /* renamed from: w, reason: collision with root package name */
    public final n0 f560w;

    /* renamed from: x, reason: collision with root package name */
    public final y2.f f561x;

    public p0(Activity activity, boolean z5) {
        new ArrayList();
        this.f551m = new ArrayList();
        this.f552n = 0;
        this.f553o = true;
        this.r = true;
        this.f559v = new n0(this, 0);
        this.f560w = new n0(this, 1);
        this.f561x = new y2.f(this, 2);
        View decorView = activity.getWindow().getDecorView();
        c(decorView);
        if (z5) {
            return;
        }
        this.f545g = decorView.findViewById(R.id.content);
    }

    public final void a(boolean z5) {
        g1 i3;
        g1 g1Var;
        if (z5) {
            if (!this.f555q) {
                this.f555q = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f542c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                f(false);
            }
        } else if (this.f555q) {
            this.f555q = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f542c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            f(false);
        }
        ActionBarContainer actionBarContainer = this.f543d;
        WeakHashMap weakHashMap = z0.f15748a;
        if (!l1.k0.c(actionBarContainer)) {
            if (z5) {
                ((x3) this.e).f1109a.setVisibility(4);
                this.f544f.setVisibility(0);
                return;
            } else {
                ((x3) this.e).f1109a.setVisibility(0);
                this.f544f.setVisibility(8);
                return;
            }
        }
        if (z5) {
            x3 x3Var = (x3) this.e;
            i3 = z0.a(x3Var.f1109a);
            i3.a(0.0f);
            i3.c(100L);
            i3.d(new w3(x3Var, 4));
            g1Var = this.f544f.i(0, 200L);
        } else {
            x3 x3Var2 = (x3) this.e;
            g1 a3 = z0.a(x3Var2.f1109a);
            a3.a(1.0f);
            a3.c(200L);
            a3.d(new w3(x3Var2, 0));
            i3 = this.f544f.i(8, 100L);
            g1Var = a3;
        }
        g.j jVar = new g.j();
        ArrayList arrayList = jVar.f13735a;
        arrayList.add(i3);
        View view = (View) i3.f15698a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) g1Var.f15698a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(g1Var);
        jVar.b();
    }

    @Override // androidx.appcompat.app.b
    public void addOnMenuVisibilityListener(a aVar) {
        this.f551m.add(aVar);
    }

    public final Context b() {
        if (this.f541b == null) {
            TypedValue typedValue = new TypedValue();
            this.f540a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                this.f541b = new ContextThemeWrapper(this.f540a, i3);
            } else {
                this.f541b = this.f540a;
            }
        }
        return this.f541b;
    }

    public final void c(View view) {
        k1 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f542c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback findViewById = view.findViewById(R$id.action_bar);
        if (findViewById instanceof k1) {
            wrapper = (k1) findViewById;
        } else {
            if (!(findViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById != null ? findViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) findViewById).getWrapper();
        }
        this.e = wrapper;
        this.f544f = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f543d = actionBarContainer;
        k1 k1Var = this.e;
        if (k1Var == null || this.f544f == null || actionBarContainer == null) {
            throw new IllegalStateException(p0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((x3) k1Var).f1109a.getContext();
        this.f540a = context;
        if ((((x3) this.e).f1110b & 4) != 0) {
            this.f546h = true;
        }
        a8.c d5 = a8.c.d(context);
        int i3 = d5.f123a.getApplicationInfo().targetSdkVersion;
        this.e.getClass();
        e(d5.f123a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.f540a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f542c;
            if (!actionBarOverlayLayout2.f639h) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f558u = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f543d;
            WeakHashMap weakHashMap = z0.f15748a;
            l1.n0.s(actionBarContainer2, dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void d(boolean z5) {
        if (this.f546h) {
            return;
        }
        int i3 = z5 ? 4 : 0;
        x3 x3Var = (x3) this.e;
        int i10 = x3Var.f1110b;
        this.f546h = true;
        x3Var.a((i3 & 4) | (i10 & (-5)));
    }

    public final void e(boolean z5) {
        if (z5) {
            this.f543d.setTabContainer(null);
            ((x3) this.e).getClass();
        } else {
            ((x3) this.e).getClass();
            this.f543d.setTabContainer(null);
        }
        this.e.getClass();
        ((x3) this.e).f1109a.setCollapsible(false);
        this.f542c.setHasNonEmbeddedTabs(false);
    }

    public final void f(boolean z5) {
        boolean z6 = this.f555q || !this.f554p;
        View view = this.f545g;
        final y2.f fVar = this.f561x;
        if (!z6) {
            if (this.r) {
                this.r = false;
                g.j jVar = this.f556s;
                if (jVar != null) {
                    jVar.a();
                }
                int i3 = this.f552n;
                n0 n0Var = this.f559v;
                if (i3 != 0 || (!this.f557t && !z5)) {
                    n0Var.onAnimationEnd();
                    return;
                }
                this.f543d.setAlpha(1.0f);
                this.f543d.setTransitioning(true);
                g.j jVar2 = new g.j();
                float f2 = -this.f543d.getHeight();
                if (z5) {
                    this.f543d.getLocationInWindow(new int[]{0, 0});
                    f2 -= r12[1];
                }
                g1 a3 = z0.a(this.f543d);
                a3.e(f2);
                final View view2 = (View) a3.f15698a.get();
                if (view2 != null) {
                    f1.a(view2.animate(), fVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: l1.e1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) ((androidx.appcompat.app.p0) y2.f.this.f19953b).f543d.getParent()).invalidate();
                        }
                    } : null);
                }
                boolean z8 = jVar2.e;
                ArrayList arrayList = jVar2.f13735a;
                if (!z8) {
                    arrayList.add(a3);
                }
                if (this.f553o && view != null) {
                    g1 a10 = z0.a(view);
                    a10.e(f2);
                    if (!jVar2.e) {
                        arrayList.add(a10);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = f538y;
                boolean z10 = jVar2.e;
                if (!z10) {
                    jVar2.f13737c = accelerateInterpolator;
                }
                if (!z10) {
                    jVar2.f13736b = 250L;
                }
                if (!z10) {
                    jVar2.f13738d = n0Var;
                }
                this.f556s = jVar2;
                jVar2.b();
                return;
            }
            return;
        }
        if (this.r) {
            return;
        }
        this.r = true;
        g.j jVar3 = this.f556s;
        if (jVar3 != null) {
            jVar3.a();
        }
        this.f543d.setVisibility(0);
        int i10 = this.f552n;
        n0 n0Var2 = this.f560w;
        if (i10 == 0 && (this.f557t || z5)) {
            this.f543d.setTranslationY(0.0f);
            float f10 = -this.f543d.getHeight();
            if (z5) {
                this.f543d.getLocationInWindow(new int[]{0, 0});
                f10 -= r12[1];
            }
            this.f543d.setTranslationY(f10);
            g.j jVar4 = new g.j();
            g1 a11 = z0.a(this.f543d);
            a11.e(0.0f);
            final View view3 = (View) a11.f15698a.get();
            if (view3 != null) {
                f1.a(view3.animate(), fVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: l1.e1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((View) ((androidx.appcompat.app.p0) y2.f.this.f19953b).f543d.getParent()).invalidate();
                    }
                } : null);
            }
            boolean z11 = jVar4.e;
            ArrayList arrayList2 = jVar4.f13735a;
            if (!z11) {
                arrayList2.add(a11);
            }
            if (this.f553o && view != null) {
                view.setTranslationY(f10);
                g1 a12 = z0.a(view);
                a12.e(0.0f);
                if (!jVar4.e) {
                    arrayList2.add(a12);
                }
            }
            DecelerateInterpolator decelerateInterpolator = f539z;
            boolean z12 = jVar4.e;
            if (!z12) {
                jVar4.f13737c = decelerateInterpolator;
            }
            if (!z12) {
                jVar4.f13736b = 250L;
            }
            if (!z12) {
                jVar4.f13738d = n0Var2;
            }
            this.f556s = jVar4;
            jVar4.b();
        } else {
            this.f543d.setAlpha(1.0f);
            this.f543d.setTranslationY(0.0f);
            if (this.f553o && view != null) {
                view.setTranslationY(0.0f);
            }
            n0Var2.onAnimationEnd();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f542c;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = z0.f15748a;
            l1.l0.c(actionBarOverlayLayout);
        }
    }

    @Override // androidx.appcompat.app.b
    public void removeOnMenuVisibilityListener(a aVar) {
        this.f551m.remove(aVar);
    }

    public p0(Dialog dialog) {
        new ArrayList();
        this.f551m = new ArrayList();
        this.f552n = 0;
        this.f553o = true;
        this.r = true;
        this.f559v = new n0(this, 0);
        this.f560w = new n0(this, 1);
        this.f561x = new y2.f(this, 2);
        c(dialog.getWindow().getDecorView());
    }
}
