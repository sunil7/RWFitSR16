package g9;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.google.android.exoplayer2.ui.R$dimen;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e0 {
    public boolean A;
    public boolean B;

    /* renamed from: a, reason: collision with root package name */
    public final StyledPlayerControlView f13925a;

    /* renamed from: b, reason: collision with root package name */
    public final View f13926b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f13927c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewGroup f13928d;
    public final ViewGroup e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewGroup f13929f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewGroup f13930g;

    /* renamed from: h, reason: collision with root package name */
    public final ViewGroup f13931h;

    /* renamed from: i, reason: collision with root package name */
    public final ViewGroup f13932i;

    /* renamed from: j, reason: collision with root package name */
    public final View f13933j;

    /* renamed from: k, reason: collision with root package name */
    public final View f13934k;

    /* renamed from: l, reason: collision with root package name */
    public final AnimatorSet f13935l;

    /* renamed from: m, reason: collision with root package name */
    public final AnimatorSet f13936m;

    /* renamed from: n, reason: collision with root package name */
    public final AnimatorSet f13937n;

    /* renamed from: o, reason: collision with root package name */
    public final AnimatorSet f13938o;

    /* renamed from: p, reason: collision with root package name */
    public final AnimatorSet f13939p;

    /* renamed from: q, reason: collision with root package name */
    public final ValueAnimator f13940q;
    public final ValueAnimator r;

    /* renamed from: s, reason: collision with root package name */
    public final a0 f13941s = new a0(this, 0);

    /* renamed from: t, reason: collision with root package name */
    public final a0 f13942t = new a0(this, 3);

    /* renamed from: u, reason: collision with root package name */
    public final a0 f13943u = new a0(this, 4);

    /* renamed from: v, reason: collision with root package name */
    public final a0 f13944v = new a0(this, 5);

    /* renamed from: w, reason: collision with root package name */
    public final a0 f13945w = new a0(this, 6);

    /* renamed from: x, reason: collision with root package name */
    public final n f13946x = new n(this, 1);
    public boolean C = true;

    /* renamed from: z, reason: collision with root package name */
    public int f13948z = 0;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f13947y = new ArrayList();

    public e0(StyledPlayerControlView styledPlayerControlView) {
        final int i3 = 2;
        this.f13925a = styledPlayerControlView;
        final int i10 = 0;
        final int i11 = 3;
        int i12 = 6;
        final int i13 = 1;
        this.f13926b = styledPlayerControlView.findViewById(R$id.exo_controls_background);
        this.f13927c = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_center_controls);
        this.e = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_bottom_bar);
        this.f13928d = viewGroup;
        this.f13932i = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_time);
        View findViewById = styledPlayerControlView.findViewById(R$id.exo_progress);
        this.f13933j = findViewById;
        this.f13929f = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_basic_controls);
        this.f13930g = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls);
        this.f13931h = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls_scroll_view);
        View findViewById2 = styledPlayerControlView.findViewById(R$id.exo_overflow_show);
        this.f13934k = findViewById2;
        View findViewById3 = styledPlayerControlView.findViewById(R$id.exo_overflow_hide);
        if (findViewById2 != null && findViewById3 != null) {
            findViewById2.setOnClickListener(new com.example.test.ui.testui.p(this, i12));
            findViewById3.setOnClickListener(new com.example.test.ui.testui.p(this, i12));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: g9.b0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e0 f13907b;

            {
                this.f13907b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i11) {
                    case 0:
                        e0 e0Var = this.f13907b;
                        e0Var.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = e0Var.f13926b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = e0Var.f13927c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = e0Var.e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        e0 e0Var2 = this.f13907b;
                        e0Var2.getClass();
                        e0Var2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        e0 e0Var3 = this.f13907b;
                        e0Var3.getClass();
                        e0Var3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        e0 e0Var4 = this.f13907b;
                        e0Var4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = e0Var4.f13926b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = e0Var4.f13927c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = e0Var4.e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat.addListener(new c0(this, 0));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: g9.b0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e0 f13907b;

            {
                this.f13907b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i10) {
                    case 0:
                        e0 e0Var = this.f13907b;
                        e0Var.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = e0Var.f13926b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = e0Var.f13927c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = e0Var.e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        e0 e0Var2 = this.f13907b;
                        e0Var2.getClass();
                        e0Var2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        e0 e0Var3 = this.f13907b;
                        e0Var3.getClass();
                        e0Var3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        e0 e0Var4 = this.f13907b;
                        e0Var4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = e0Var4.f13926b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = e0Var4.f13927c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = e0Var4.e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat2.addListener(new c0(this, 1));
        Resources resources = styledPlayerControlView.getResources();
        float dimension = resources.getDimension(R$dimen.exo_styled_bottom_bar_height) - resources.getDimension(R$dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(R$dimen.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f13935l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new d0(this, styledPlayerControlView, i10));
        animatorSet.play(ofFloat).with(d(findViewById, 0.0f, dimension)).with(d(viewGroup, 0.0f, dimension));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f13936m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d0(this, styledPlayerControlView, i13));
        animatorSet2.play(d(findViewById, dimension, dimension2)).with(d(viewGroup, dimension, dimension2));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f13937n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new d0(this, styledPlayerControlView, i3));
        animatorSet3.play(ofFloat).with(d(findViewById, 0.0f, dimension2)).with(d(viewGroup, 0.0f, dimension2));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f13938o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new c0(this, 2));
        animatorSet4.play(ofFloat2).with(d(findViewById, dimension, 0.0f)).with(d(viewGroup, dimension, 0.0f));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f13939p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new c0(this, 3));
        animatorSet5.play(ofFloat2).with(d(findViewById, dimension2, 0.0f)).with(d(viewGroup, dimension2, 0.0f));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f13940q = ofFloat3;
        ofFloat3.setDuration(250L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: g9.b0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e0 f13907b;

            {
                this.f13907b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i13) {
                    case 0:
                        e0 e0Var = this.f13907b;
                        e0Var.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = e0Var.f13926b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = e0Var.f13927c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = e0Var.e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        e0 e0Var2 = this.f13907b;
                        e0Var2.getClass();
                        e0Var2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        e0 e0Var3 = this.f13907b;
                        e0Var3.getClass();
                        e0Var3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        e0 e0Var4 = this.f13907b;
                        e0Var4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = e0Var4.f13926b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = e0Var4.f13927c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = e0Var4.e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat3.addListener(new c0(this, 4));
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.r = ofFloat4;
        ofFloat4.setDuration(250L);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: g9.b0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e0 f13907b;

            {
                this.f13907b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i3) {
                    case 0:
                        e0 e0Var = this.f13907b;
                        e0Var.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = e0Var.f13926b;
                        if (view != null) {
                            view.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup2 = e0Var.f13927c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(floatValue);
                        }
                        ViewGroup viewGroup3 = e0Var.e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(floatValue);
                            break;
                        }
                        break;
                    case 1:
                        e0 e0Var2 = this.f13907b;
                        e0Var2.getClass();
                        e0Var2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        e0 e0Var3 = this.f13907b;
                        e0Var3.getClass();
                        e0Var3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        e0 e0Var4 = this.f13907b;
                        e0Var4.getClass();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = e0Var4.f13926b;
                        if (view2 != null) {
                            view2.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup4 = e0Var4.f13927c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(floatValue2);
                        }
                        ViewGroup viewGroup5 = e0Var4.e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(floatValue2);
                            break;
                        }
                        break;
                }
            }
        });
        ofFloat4.addListener(new c0(this, 5));
    }

    public static int c(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + width;
    }

    public static ObjectAnimator d(View view, float f2, float f10) {
        return ObjectAnimator.ofFloat(view, "translationY", f2, f10);
    }

    public static boolean j(View view) {
        int id2 = view.getId();
        return id2 == R$id.exo_bottom_bar || id2 == R$id.exo_prev || id2 == R$id.exo_next || id2 == R$id.exo_rew || id2 == R$id.exo_rew_with_amount || id2 == R$id.exo_ffwd || id2 == R$id.exo_ffwd_with_amount;
    }

    public final void a(float f2) {
        ViewGroup viewGroup = this.f13931h;
        if (viewGroup != null) {
            viewGroup.setTranslationX((int) ((1.0f - f2) * viewGroup.getWidth()));
        }
        ViewGroup viewGroup2 = this.f13932i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f2);
        }
        ViewGroup viewGroup3 = this.f13929f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f2);
        }
    }

    public final boolean b(View view) {
        return view != null && this.f13947y.contains(view);
    }

    public final void e(Runnable runnable, long j4) {
        if (j4 >= 0) {
            this.f13925a.postDelayed(runnable, j4);
        }
    }

    public final void f() {
        a0 a0Var = this.f13945w;
        StyledPlayerControlView styledPlayerControlView = this.f13925a;
        styledPlayerControlView.removeCallbacks(a0Var);
        styledPlayerControlView.removeCallbacks(this.f13942t);
        styledPlayerControlView.removeCallbacks(this.f13944v);
        styledPlayerControlView.removeCallbacks(this.f13943u);
    }

    public final void g() {
        if (this.f13948z == 3) {
            return;
        }
        f();
        int showTimeoutMs = this.f13925a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                e(this.f13945w, showTimeoutMs);
            } else if (this.f13948z == 1) {
                e(this.f13943u, 2000L);
            } else {
                e(this.f13944v, showTimeoutMs);
            }
        }
    }

    public final void h(View view, boolean z5) {
        if (view == null) {
            return;
        }
        ArrayList arrayList = this.f13947y;
        if (!z5) {
            view.setVisibility(8);
            arrayList.remove(view);
            return;
        }
        if (this.A && j(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        arrayList.add(view);
    }

    public final void i(int i3) {
        int i10 = this.f13948z;
        this.f13948z = i3;
        StyledPlayerControlView styledPlayerControlView = this.f13925a;
        if (i3 == 2) {
            styledPlayerControlView.setVisibility(8);
        } else if (i10 == 2) {
            styledPlayerControlView.setVisibility(0);
        }
        if (i10 != i3) {
            Iterator it = styledPlayerControlView.f8984b.iterator();
            while (it.hasNext()) {
                z zVar = (z) it.next();
                styledPlayerControlView.getVisibility();
                f0 f0Var = (f0) zVar;
                f0Var.getClass();
                f0Var.f13949a.h();
            }
        }
    }

    public final void k() {
        if (!this.C) {
            i(0);
            g();
            return;
        }
        int i3 = this.f13948z;
        if (i3 == 1) {
            this.f13938o.start();
        } else if (i3 == 2) {
            this.f13939p.start();
        } else if (i3 == 3) {
            this.B = true;
        } else if (i3 == 4) {
            return;
        }
        g();
    }
}
