package com.scwang.smart.refresh.layout;

import ab.q;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.Scroller;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.e1;
import com.example.baselibrary.R$id;
import com.example.baselibrary.R$string;
import com.example.baselibrary.R$styleable;
import com.example.test.ui.device.activity.i0;
import com.example.test.ui.device.activity.m;
import com.example.test.ui.view.h;
import com.example.test.ui.view.n;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.t;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import dg.e;
import dg.g;
import eg.b;
import eg.c;
import eg.d;
import java.util.LinkedList;
import java.util.WeakHashMap;
import jg.a;
import l1.n0;
import l1.r;
import l1.s;
import l1.v;
import l1.z0;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes2.dex */
public class SmartRefreshLayout extends ViewGroup implements d, v {

    /* renamed from: r1, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f11635r1 = new ViewGroup.MarginLayoutParams(-1, -1);
    public final int[] A;
    public boolean B;
    public boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public final boolean P;
    public boolean Q;
    public final boolean R;
    public final boolean S;
    public boolean T;
    public boolean U;
    public final int U0;
    public boolean V;
    public final float V0;
    public m W;
    public final float W0;
    public final float X0;
    public final float Y0;
    public final float Z0;

    /* renamed from: a, reason: collision with root package name */
    public final int f11636a;

    /* renamed from: a0, reason: collision with root package name */
    public m f11637a0;

    /* renamed from: a1, reason: collision with root package name */
    public c f11638a1;

    /* renamed from: b, reason: collision with root package name */
    public int f11639b;

    /* renamed from: b0, reason: collision with root package name */
    public int f11640b0;

    /* renamed from: b1, reason: collision with root package name */
    public b f11641b1;

    /* renamed from: c, reason: collision with root package name */
    public int f11642c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f11643c0;

    /* renamed from: c1, reason: collision with root package name */
    public a f11644c1;

    /* renamed from: d, reason: collision with root package name */
    public int f11645d;

    /* renamed from: d0, reason: collision with root package name */
    public final int[] f11646d0;

    /* renamed from: d1, reason: collision with root package name */
    public Paint f11647d1;
    public final int e;

    /* renamed from: e0, reason: collision with root package name */
    public final s f11648e0;

    /* renamed from: e1, reason: collision with root package name */
    public final Handler f11649e1;

    /* renamed from: f, reason: collision with root package name */
    public final int f11650f;

    /* renamed from: f0, reason: collision with root package name */
    public final e1 f11651f0;
    public final i0 f1;

    /* renamed from: g, reason: collision with root package name */
    public final int f11652g;

    /* renamed from: g0, reason: collision with root package name */
    public int f11653g0;

    /* renamed from: g1, reason: collision with root package name */
    public RefreshState f11654g1;

    /* renamed from: h, reason: collision with root package name */
    public float f11655h;

    /* renamed from: h0, reason: collision with root package name */
    public fg.a f11656h0;

    /* renamed from: h1, reason: collision with root package name */
    public RefreshState f11657h1;

    /* renamed from: i, reason: collision with root package name */
    public float f11658i;
    public int i0;

    /* renamed from: i1, reason: collision with root package name */
    public long f11659i1;

    /* renamed from: j, reason: collision with root package name */
    public float f11660j;

    /* renamed from: j0, reason: collision with root package name */
    public fg.a f11661j0;

    /* renamed from: j1, reason: collision with root package name */
    public int f11662j1;

    /* renamed from: k, reason: collision with root package name */
    public float f11663k;

    /* renamed from: k0, reason: collision with root package name */
    public final int f11664k0;

    /* renamed from: k1, reason: collision with root package name */
    public int f11665k1;

    /* renamed from: l, reason: collision with root package name */
    public final float f11666l;

    /* renamed from: l1, reason: collision with root package name */
    public boolean f11667l1;

    /* renamed from: m, reason: collision with root package name */
    public char f11668m;

    /* renamed from: m1, reason: collision with root package name */
    public dg.c f11669m1;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11670n;

    /* renamed from: n1, reason: collision with root package name */
    public boolean f11671n1;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11672o;

    /* renamed from: o1, reason: collision with root package name */
    public MotionEvent f11673o1;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11674p;

    /* renamed from: p1, reason: collision with root package name */
    public Runnable f11675p1;

    /* renamed from: q, reason: collision with root package name */
    public final int f11676q;

    /* renamed from: q1, reason: collision with root package name */
    public ValueAnimator f11677q1;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public final int f11678s;

    /* renamed from: t, reason: collision with root package name */
    public final int f11679t;

    /* renamed from: u, reason: collision with root package name */
    public final int f11680u;

    /* renamed from: v, reason: collision with root package name */
    public final int f11681v;

    /* renamed from: w, reason: collision with root package name */
    public int f11682w;

    /* renamed from: x, reason: collision with root package name */
    public final Scroller f11683x;

    /* renamed from: y, reason: collision with root package name */
    public final VelocityTracker f11684y;

    /* renamed from: z, reason: collision with root package name */
    public final ig.b f11685z;

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(gg.a aVar) {
    }

    public static void setDefaultRefreshHeaderCreator(gg.b bVar) {
    }

    public static void setDefaultRefreshInitializer(gg.c cVar) {
    }

    @Override // android.view.View
    public final void computeScroll() {
        RefreshState refreshState;
        Scroller scroller = this.f11683x;
        scroller.getCurrY();
        if (scroller.computeScrollOffset()) {
            int finalY = scroller.getFinalY();
            boolean z5 = this.K;
            if ((finalY >= 0 || !((this.B || z5) && this.f11644c1.b())) && (finalY <= 0 || !((this.C || z5) && this.f11644c1.a()))) {
                this.f11671n1 = true;
                invalidate();
                return;
            }
            if (this.f11671n1) {
                float currVelocity = finalY > 0 ? -scroller.getCurrVelocity() : scroller.getCurrVelocity();
                if (this.f11677q1 == null) {
                    if (currVelocity > 0.0f && ((refreshState = this.f11654g1) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
                        this.f11675p1 = new e(this, currVelocity, this.f11653g0);
                    } else if (currVelocity < 0.0f && (this.f11654g1 == RefreshState.Loading || ((this.H && this.T && this.U && r(this.C)) || (this.L && !this.T && r(this.C) && this.f11654g1 != RefreshState.Refreshing)))) {
                        this.f11675p1 = new e(this, currVelocity, -this.i0);
                    } else if (this.f11639b == 0 && this.J) {
                        this.f11675p1 = new e(this, currVelocity, 0);
                    }
                }
            }
            scroller.forceFinished(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e2, code lost:
    
        if (r6 != 3) goto L213;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r26) {
        /*
            Method dump skipped, instructions count: 859
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        Paint paint;
        Paint paint2;
        a aVar = this.f11644c1;
        View view2 = aVar != null ? aVar.f15441a : null;
        c cVar = this.f11638a1;
        fg.b bVar = fg.b.f13681d;
        fg.b bVar2 = fg.b.f13680c;
        boolean z5 = this.I;
        if (cVar != null && cVar.getView() == view) {
            if (!r(this.B)) {
                return true;
            }
            if (!z5 && isInEditMode()) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getPaddingTop() + view2.getTop() + this.f11639b, view.getTop());
                int i3 = this.f11662j1;
                if (i3 != 0 && (paint2 = this.f11647d1) != null) {
                    paint2.setColor(i3);
                    if (this.f11638a1.getSpinnerStyle().f13685b) {
                        max = view.getBottom();
                    } else if (this.f11638a1.getSpinnerStyle() == bVar2) {
                        max = view.getBottom() + this.f11639b;
                    }
                    int i10 = max;
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), i10, this.f11647d1);
                    max = i10;
                }
                if ((this.D && this.f11638a1.getSpinnerStyle() == bVar) || this.f11638a1.getSpinnerStyle().f13685b) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j4);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        b bVar3 = this.f11641b1;
        if (bVar3 != null && bVar3.getView() == view) {
            if (!r(this.C)) {
                return true;
            }
            if (!z5 && isInEditMode()) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.f11639b, view.getBottom());
                int i11 = this.f11665k1;
                if (i11 != 0 && (paint = this.f11647d1) != null) {
                    paint.setColor(i11);
                    if (this.f11641b1.getSpinnerStyle().f13685b) {
                        min = view.getTop();
                    } else if (this.f11641b1.getSpinnerStyle() == bVar2) {
                        min = view.getTop() + this.f11639b;
                    }
                    int i12 = min;
                    canvas.drawRect(0.0f, i12, getWidth(), view.getBottom(), this.f11647d1);
                    min = i12;
                }
                if ((this.E && this.f11641b1.getSpinnerStyle() == bVar) || this.f11641b1.getSpinnerStyle().f13685b) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j4);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j4);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        g gVar = new g(context, attributeSet);
        gVar.f12405a = 0;
        gVar.f12406b = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout_Layout);
        gVar.f12405a = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, 0);
        if (obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle)) {
            gVar.f12406b = fg.b.f13683g[obtainStyledAttributes.getInt(R$styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, 0)];
        }
        obtainStyledAttributes.recycle();
        return gVar;
    }

    @Override // eg.d
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        e1 e1Var = this.f11651f0;
        return e1Var.f2555c | e1Var.f2554b;
    }

    public b getRefreshFooter() {
        b bVar = this.f11641b1;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }

    public c getRefreshHeader() {
        c cVar = this.f11638a1;
        if (cVar != null) {
            return cVar;
        }
        return null;
    }

    public RefreshState getState() {
        return this.f11654g1;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        if (this.Q) {
            return this.K || this.B || this.C;
        }
        return false;
    }

    public final ValueAnimator m(int i3, int i10, ig.b bVar, int i11) {
        if (this.f11639b == i3) {
            return null;
        }
        ValueAnimator valueAnimator = this.f11677q1;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.f11677q1.cancel();
            this.f11677q1 = null;
        }
        this.f11675p1 = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f11639b, i3);
        this.f11677q1 = ofInt;
        ofInt.setDuration(i11);
        this.f11677q1.setInterpolator(bVar);
        this.f11677q1.addListener(new q(this, 5));
        this.f11677q1.addUpdateListener(new t(this, 3));
        this.f11677q1.setStartDelay(i10);
        this.f11677q1.start();
        return this.f11677q1;
    }

    public final void n(int i3, boolean z5) {
        int i10 = i3 >> 16;
        int i11 = (i3 << 16) >> 16;
        dg.d dVar = new dg.d(i10, this, z5);
        if (i11 > 0) {
            this.f11649e1.postDelayed(dVar, i11);
        } else {
            dVar.run();
        }
    }

    public final void o() {
        p(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f11659i1))), 300) << 16, true, Boolean.FALSE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        i0 i0Var;
        b bVar;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.f11641b1 != null) {
                this.C = this.C || !this.V;
            }
            if (this.f11644c1 == null) {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    c cVar = this.f11638a1;
                    if ((cVar == null || childAt != cVar.getView()) && ((bVar = this.f11641b1) == null || childAt != bVar.getView())) {
                        this.f11644c1 = new a(childAt);
                    }
                }
            }
            if (this.f11644c1 == null) {
                int i10 = (int) ((ig.b.f14432a * 20.0f) + 0.5f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R$string.srl_content_empty);
                super.addView(textView, 0, new g(-1));
                this.f11644c1 = new a(textView);
                textView.setPadding(i10, i10, i10, i10);
            }
            View findViewById = findViewById(this.f11676q);
            View findViewById2 = findViewById(this.r);
            a aVar = this.f11644c1;
            aVar.f15448i.f8756a = this.P;
            View view = aVar.f15441a;
            boolean isInEditMode = view.isInEditMode();
            View view2 = null;
            while (true) {
                i0Var = this.f1;
                if (view2 != null && (!(view2 instanceof v) || (view2 instanceof r))) {
                    break;
                }
                boolean z5 = view2 == null;
                LinkedList linkedList = new LinkedList();
                linkedList.add(view);
                View view3 = null;
                while (linkedList.size() > 0 && view3 == null) {
                    View view4 = (View) linkedList.poll();
                    if (view4 != null) {
                        if ((z5 || view4 != view) && ig.b.c(view4)) {
                            view3 = view4;
                        } else if (view4 instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view4;
                            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                                linkedList.add(viewGroup.getChildAt(i11));
                            }
                        }
                    }
                }
                if (view3 == null) {
                    view3 = view;
                }
                if (view3 == view2) {
                    break;
                }
                if (!isInEditMode) {
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (view3 instanceof CoordinatorLayout) {
                        ((SmartRefreshLayout) i0Var.f7866b).setNestedScrollingEnabled(false);
                        ViewGroup viewGroup2 = (ViewGroup) view3;
                        for (int childCount2 = viewGroup2.getChildCount() - 1; childCount2 >= 0; childCount2--) {
                            try {
                                View childAt2 = viewGroup2.getChildAt(childCount2);
                                if (childAt2 instanceof AppBarLayout) {
                                    ((AppBarLayout) childAt2).addOnOffsetChangedListener((ka.c) new ig.a(aVar, 0));
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                th.printStackTrace();
                                view = view3;
                                view2 = view;
                            }
                        }
                        view = view3;
                        view2 = view;
                    }
                }
                view = view3;
                view2 = view;
            }
            if (view2 != null) {
                aVar.f15443c = view2;
            }
            if (findViewById != null || findViewById2 != null) {
                aVar.f15444d = findViewById;
                aVar.e = findViewById2;
                FrameLayout frameLayout = new FrameLayout(aVar.f15441a.getContext());
                int indexOfChild = ((SmartRefreshLayout) i0Var.f7866b).getLayout().indexOfChild(aVar.f15441a);
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) i0Var.f7866b;
                smartRefreshLayout.getLayout().removeView(aVar.f15441a);
                frameLayout.addView(aVar.f15441a, 0, new ViewGroup.LayoutParams(-1, -1));
                smartRefreshLayout.getLayout().addView(frameLayout, indexOfChild, aVar.f15441a.getLayoutParams());
                aVar.f15441a = frameLayout;
                if (findViewById != null) {
                    findViewById.setTag(R$id.srl_tag, "fixed-top");
                    ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                    ViewGroup viewGroup3 = (ViewGroup) findViewById.getParent();
                    int indexOfChild2 = viewGroup3.indexOfChild(findViewById);
                    viewGroup3.removeView(findViewById);
                    layoutParams.height = ig.b.f(findViewById);
                    viewGroup3.addView(new Space(aVar.f15441a.getContext()), indexOfChild2, layoutParams);
                    frameLayout.addView(findViewById, 1, layoutParams);
                }
                if (findViewById2 != null) {
                    findViewById2.setTag(R$id.srl_tag, "fixed-bottom");
                    ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                    ViewGroup viewGroup4 = (ViewGroup) findViewById2.getParent();
                    int indexOfChild3 = viewGroup4.indexOfChild(findViewById2);
                    viewGroup4.removeView(findViewById2);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
                    layoutParams2.height = ig.b.f(findViewById2);
                    viewGroup4.addView(new Space(aVar.f15441a.getContext()), indexOfChild3, layoutParams2);
                    layoutParams3.gravity = 80;
                    frameLayout.addView(findViewById2, 1, layoutParams3);
                }
            }
            if (this.f11639b != 0) {
                u(RefreshState.None);
                a aVar2 = this.f11644c1;
                this.f11639b = 0;
                aVar2.d(0, this.f11678s, this.f11679t);
            }
        }
        int[] iArr = this.A;
        if (iArr != null) {
            c cVar2 = this.f11638a1;
            if (cVar2 != null) {
                cVar2.setPrimaryColors(iArr);
            }
            b bVar2 = this.f11641b1;
            if (bVar2 != null) {
                bVar2.setPrimaryColors(iArr);
            }
        }
        a aVar3 = this.f11644c1;
        if (aVar3 != null) {
            super.bringChildToFront(aVar3.f15441a);
        }
        c cVar3 = this.f11638a1;
        if (cVar3 != null && cVar3.getSpinnerStyle().f13684a) {
            super.bringChildToFront(this.f11638a1.getView());
        }
        b bVar3 = this.f11641b1;
        if (bVar3 == null || !bVar3.getSpinnerStyle().f13684a) {
            return;
        }
        super.bringChildToFront(this.f11641b1.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.V = true;
        this.f11675p1 = null;
        ValueAnimator valueAnimator = this.f11677q1;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f11677q1.removeAllUpdateListeners();
            this.f11677q1.setDuration(0L);
            this.f11677q1.cancel();
            this.f11677q1 = null;
        }
        c cVar = this.f11638a1;
        if (cVar != null && this.f11654g1 == RefreshState.Refreshing) {
            cVar.i(this, false);
        }
        b bVar = this.f11641b1;
        if (bVar != null && this.f11654g1 == RefreshState.Loading) {
            bVar.i(this, false);
        }
        if (this.f11639b != 0) {
            this.f1.l(0, true);
        }
        RefreshState refreshState = this.f11654g1;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2) {
            u(refreshState2);
        }
        Handler handler = this.f11649e1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f11667l1 = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onFinishInflate() {
        /*
            r11 = this;
            super.onFinishInflate()
            int r0 = super.getChildCount()
            r1 = 3
            if (r0 > r1) goto L9e
            r2 = -1
            r3 = 0
            r5 = r2
            r4 = r3
            r6 = r4
        Lf:
            r7 = 1
            r8 = 2
            if (r4 >= r0) goto L33
            android.view.View r9 = super.getChildAt(r4)
            boolean r10 = ig.b.c(r9)
            if (r10 == 0) goto L24
            if (r6 < r8) goto L21
            if (r4 != r7) goto L24
        L21:
            r5 = r4
            r6 = r8
            goto L30
        L24:
            boolean r8 = r9 instanceof eg.a
            if (r8 != 0) goto L30
            if (r6 >= r7) goto L30
            if (r4 <= 0) goto L2e
            r6 = r7
            goto L2f
        L2e:
            r6 = r3
        L2f:
            r5 = r4
        L30:
            int r4 = r4 + 1
            goto Lf
        L33:
            if (r5 < 0) goto L4d
            jg.a r4 = new jg.a
            android.view.View r6 = super.getChildAt(r5)
            r4.<init>(r6)
            r11.f11644c1 = r4
            if (r5 != r7) goto L48
            if (r0 != r1) goto L46
        L44:
            r1 = r3
            goto L4f
        L46:
            r8 = r2
            goto L44
        L48:
            if (r0 != r8) goto L4d
            r1 = r2
            r8 = r7
            goto L4f
        L4d:
            r1 = r2
            r8 = r1
        L4f:
            r4 = r3
        L50:
            if (r4 >= r0) goto L9d
            android.view.View r5 = super.getChildAt(r4)
            if (r4 == r1) goto L8b
            if (r4 == r8) goto L65
            if (r1 != r2) goto L65
            eg.c r6 = r11.f11638a1
            if (r6 != 0) goto L65
            boolean r6 = r5 instanceof eg.c
            if (r6 == 0) goto L65
            goto L8b
        L65:
            if (r4 == r8) goto L6d
            if (r8 != r2) goto L9a
            boolean r6 = r5 instanceof eg.b
            if (r6 == 0) goto L9a
        L6d:
            boolean r6 = r11.C
            if (r6 != 0) goto L78
            boolean r6 = r11.V
            if (r6 != 0) goto L76
            goto L78
        L76:
            r6 = r3
            goto L79
        L78:
            r6 = r7
        L79:
            r11.C = r6
            boolean r6 = r5 instanceof eg.b
            if (r6 == 0) goto L82
            eg.b r5 = (eg.b) r5
            goto L88
        L82:
            com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper r6 = new com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper
            r6.<init>(r5)
            r5 = r6
        L88:
            r11.f11641b1 = r5
            goto L9a
        L8b:
            boolean r6 = r5 instanceof eg.c
            if (r6 == 0) goto L92
            eg.c r5 = (eg.c) r5
            goto L98
        L92:
            com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper r6 = new com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper
            r6.<init>(r5)
            r5 = r6
        L98:
            r11.f11638a1 = r5
        L9a:
            int r4 = r4 + 1
            goto L50
        L9d:
            return
        L9e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "最多只支持3个子View，Most only support three sub view"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.onFinishInflate():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int i13;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = super.getChildAt(i14);
            if (childAt.getVisibility() != 8 && !"GONE".equals(childAt.getTag(R$id.srl_tag))) {
                a aVar = this.f11644c1;
                ViewGroup.MarginLayoutParams marginLayoutParams = f11635r1;
                boolean z6 = this.I;
                if (aVar != null && aVar.f15441a == childAt) {
                    boolean z8 = isInEditMode() && z6 && r(this.B) && this.f11638a1 != null;
                    View view = this.f11644c1.f15441a;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : marginLayoutParams;
                    int i15 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i16 = marginLayoutParams2.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i15;
                    int measuredHeight = view.getMeasuredHeight() + i16;
                    if (z8 && s(this.F, this.f11638a1)) {
                        int i17 = this.f11653g0;
                        i16 += i17;
                        measuredHeight += i17;
                    }
                    view.layout(i15, i16, measuredWidth, measuredHeight);
                }
                c cVar = this.f11638a1;
                fg.b bVar = fg.b.f13680c;
                if (cVar != null && cVar.getView() == childAt) {
                    boolean z10 = isInEditMode() && z6 && r(this.B);
                    View view2 = this.f11638a1.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : marginLayoutParams;
                    int i18 = marginLayoutParams3.leftMargin;
                    int i19 = marginLayoutParams3.topMargin + this.f11664k0;
                    int measuredWidth2 = view2.getMeasuredWidth() + i18;
                    int measuredHeight2 = view2.getMeasuredHeight() + i19;
                    if (!z10 && this.f11638a1.getSpinnerStyle() == bVar) {
                        int i20 = this.f11653g0;
                        i19 -= i20;
                        measuredHeight2 -= i20;
                    }
                    view2.layout(i18, i19, measuredWidth2, measuredHeight2);
                }
                b bVar2 = this.f11641b1;
                if (bVar2 != null && bVar2.getView() == childAt) {
                    boolean z11 = isInEditMode() && z6 && r(this.C);
                    View view3 = this.f11641b1.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                    }
                    fg.b spinnerStyle = this.f11641b1.getSpinnerStyle();
                    int i21 = marginLayoutParams.leftMargin;
                    int measuredHeight3 = getMeasuredHeight() + marginLayoutParams.topMargin;
                    int i22 = this.U0;
                    int i23 = measuredHeight3 - i22;
                    if (this.T && this.U && this.H && this.f11644c1 != null && this.f11641b1.getSpinnerStyle() == bVar && r(this.C)) {
                        View view4 = this.f11644c1.f15441a;
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        i23 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == fg.b.f13682f) {
                        i23 = marginLayoutParams.topMargin - i22;
                    } else {
                        if (z11 || spinnerStyle == fg.b.e || spinnerStyle == fg.b.f13681d) {
                            i13 = this.i0;
                        } else if (spinnerStyle.f13685b && this.f11639b < 0) {
                            i13 = Math.max(r(this.C) ? -this.f11639b : 0, 0);
                        }
                        i23 -= i13;
                    }
                    view3.layout(i21, i23, view3.getMeasuredWidth() + i21, view3.getMeasuredHeight() + i23);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x034e A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02bd  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r26, int r27) {
        /*
            Method dump skipped, instructions count: 919
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f10, boolean z5) {
        return this.f11648e0.a(f2, f10, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f10) {
        return (this.f11667l1 && f10 > 0.0f) || z(-f10) || this.f11648e0.b(f2, f10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i3, int i10, int[] iArr) {
        int i11 = this.f11640b0;
        int i12 = 0;
        if (i10 * i11 > 0) {
            if (Math.abs(i10) > Math.abs(this.f11640b0)) {
                int i13 = this.f11640b0;
                this.f11640b0 = 0;
                i12 = i13;
            } else {
                this.f11640b0 -= i10;
                i12 = i10;
            }
            t(this.f11640b0);
        } else if (i10 > 0 && this.f11667l1) {
            int i14 = i11 - i10;
            this.f11640b0 = i14;
            t(i14);
            i12 = i10;
        }
        this.f11648e0.c(i3, i10 - i12, iArr, null, 0);
        iArr[1] = iArr[1] + i12;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i3, int i10, int i11, int i12) {
        ViewParent parent;
        boolean d5 = this.f11648e0.d(i3, i10, i11, i12, this.f11646d0, 0, null);
        int i13 = i12 + this.f11646d0[1];
        boolean z5 = this.K;
        if ((i13 < 0 && (this.B || z5)) || (i13 > 0 && (this.C || z5))) {
            RefreshState refreshState = this.f11657h1;
            if (refreshState == RefreshState.None || refreshState.isOpening) {
                this.f1.w(i13 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!d5 && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i14 = this.f11640b0 - i13;
            this.f11640b0 = i14;
            t(i14);
        }
        if (!this.f11667l1 || i10 >= 0) {
            return;
        }
        this.f11667l1 = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i3) {
        this.f11651f0.f2554b = i3;
        this.f11648e0.h(i3 & 2, 0);
        this.f11640b0 = this.f11639b;
        this.f11643c0 = true;
        q(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i3) {
        if (isEnabled() && isNestedScrollingEnabled() && (i3 & 2) != 0) {
            return this.K || this.B || this.C;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        this.f11651f0.f2554b = 0;
        this.f11643c0 = false;
        this.f11640b0 = 0;
        v();
        this.f11648e0.i(0);
    }

    public final void p(int i3, boolean z5, Boolean bool) {
        int i10 = i3 >> 16;
        int i11 = (i3 << 16) >> 16;
        Handler handler = this.f11649e1;
        handler.removeCallbacks(this.f11669m1);
        dg.c cVar = new dg.c(this, i10, bool, z5);
        this.f11669m1 = cVar;
        if (i11 > 0) {
            handler.postDelayed(cVar, i11);
        } else {
            cVar.run();
        }
    }

    public final boolean q(int i3) {
        if (i3 == 0) {
            if (this.f11677q1 != null) {
                RefreshState refreshState = this.f11654g1;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased || refreshState == RefreshState.RefreshReleased || refreshState == RefreshState.LoadReleased) {
                    return true;
                }
                RefreshState refreshState2 = RefreshState.PullDownCanceled;
                i0 i0Var = this.f1;
                if (refreshState == refreshState2) {
                    i0Var.w(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    i0Var.w(RefreshState.PullUpToLoad);
                }
                this.f11677q1.setDuration(0L);
                this.f11677q1.cancel();
                this.f11677q1 = null;
            }
            this.f11675p1 = null;
        }
        return this.f11677q1 != null;
    }

    public final boolean r(boolean z5) {
        return z5 && !this.M;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z5) {
        View view = this.f11644c1.f15443c;
        WeakHashMap weakHashMap = z0.f15748a;
        if (n0.p(view)) {
            this.f11674p = z5;
            super.requestDisallowInterceptTouchEvent(z5);
        }
    }

    public final boolean s(boolean z5, eg.a aVar) {
        return z5 || this.M || aVar == null || aVar.getSpinnerStyle() == fg.b.f13681d;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z5) {
        this.Q = z5;
        this.f11648e0.g(z5);
    }

    public void setStateDirectLoading(boolean z5) {
        RefreshState refreshState = this.f11654g1;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.f11659i1 = System.currentTimeMillis();
            this.f11667l1 = true;
            u(refreshState2);
            m mVar = this.f11637a0;
            if (mVar == null) {
                n(2000, false);
            } else if (z5) {
                mVar.a(this);
            }
            b bVar = this.f11641b1;
            if (bVar != null) {
                float f2 = this.W0;
                if (f2 < 10.0f) {
                    f2 *= this.i0;
                }
                bVar.h(this, this.i0, (int) f2);
            }
        }
    }

    public void setStateLoading(boolean z5) {
        dg.b bVar = new dg.b(0, this, z5);
        u(RefreshState.LoadReleased);
        ValueAnimator k10 = this.f1.k(-this.i0);
        if (k10 != null) {
            k10.addListener(bVar);
        }
        b bVar2 = this.f11641b1;
        if (bVar2 != null) {
            float f2 = this.W0;
            if (f2 < 10.0f) {
                f2 *= this.i0;
            }
            bVar2.c(this, this.i0, (int) f2);
        }
        if (k10 == null) {
            bVar.onAnimationEnd(null);
        }
    }

    public void setStateRefreshing(boolean z5) {
        Handler handler = this.f11649e1;
        handler.removeCallbacks(this.f11669m1);
        handler.removeCallbacksAndMessages(null);
        dg.b bVar = new dg.b(1, this, z5);
        u(RefreshState.RefreshReleased);
        ValueAnimator k10 = this.f1.k(this.f11653g0);
        if (k10 != null) {
            k10.addListener(bVar);
        }
        c cVar = this.f11638a1;
        if (cVar != null) {
            float f2 = this.V0;
            if (f2 < 10.0f) {
                f2 *= this.f11653g0;
            }
            cVar.c(this, this.f11653g0, (int) f2);
        }
        if (k10 == null) {
            bVar.onAnimationEnd(null);
        }
    }

    public void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.f11654g1;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            u(RefreshState.None);
        }
        if (this.f11657h1 != refreshState) {
            this.f11657h1 = refreshState;
        }
    }

    public final void t(float f2) {
        RefreshState refreshState;
        float f10 = (!this.f11643c0 || this.P || f2 >= 0.0f || this.f11644c1.a()) ? f2 : 0.0f;
        int i3 = this.f11652g;
        if (f10 > i3 * 5 && getTag() == null && getTag(R$id.srl_tag) == null) {
            float f11 = i3;
            if (this.f11663k < f11 / 6.0f && this.f11660j < f11 / 16.0f) {
                Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
                setTag(R$id.srl_tag, "你这么死拉，臣妾做不到啊！");
            }
        }
        RefreshState refreshState2 = this.f11654g1;
        RefreshState refreshState3 = RefreshState.TwoLevel;
        boolean z5 = this.L;
        i0 i0Var = this.f1;
        if (refreshState2 != refreshState3 || f10 <= 0.0f) {
            RefreshState refreshState4 = RefreshState.Refreshing;
            float f12 = this.V0;
            float f13 = this.f11666l;
            if (refreshState2 != refreshState4 || f10 < 0.0f) {
                float f14 = this.W0;
                if (f10 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.H && this.T && this.U && r(this.C)) || (z5 && !this.T && r(this.C))))) {
                    int i10 = this.i0;
                    if (f10 > (-i10)) {
                        i0Var.l((int) f10, true);
                    } else {
                        if (f14 < 10.0f) {
                            f14 *= i10;
                        }
                        double d5 = f14 - i10;
                        int max = Math.max((i3 * 4) / 3, getHeight());
                        int i11 = this.i0;
                        double d8 = max - i11;
                        double d10 = -Math.min(0.0f, (i11 + f10) * f13);
                        double d11 = -d10;
                        if (d8 == 0.0d) {
                            d8 = 1.0d;
                        }
                        i0Var.l(((int) (-Math.min((1.0d - Math.pow(100.0d, d11 / d8)) * d5, d10))) - this.i0, true);
                    }
                } else if (f10 >= 0.0f) {
                    double d12 = f12 < 10.0f ? this.f11653g0 * f12 : f12;
                    double max2 = Math.max(i3 / 2, getHeight());
                    double max3 = Math.max(0.0f, f13 * f10);
                    double d13 = -max3;
                    if (max2 == 0.0d) {
                        max2 = 1.0d;
                    }
                    i0Var.l((int) Math.min((1.0d - Math.pow(100.0d, d13 / max2)) * d12, max3), true);
                } else {
                    double d14 = f14 < 10.0f ? this.i0 * f14 : f14;
                    double max4 = Math.max(i3 / 2, getHeight());
                    double d15 = -Math.min(0.0f, f13 * f10);
                    double d16 = -d15;
                    if (max4 == 0.0d) {
                        max4 = 1.0d;
                    }
                    i0Var.l((int) (-Math.min((1.0d - Math.pow(100.0d, d16 / max4)) * d14, d15)), true);
                }
            } else {
                float f15 = this.f11653g0;
                if (f10 < f15) {
                    i0Var.l((int) f10, true);
                } else {
                    if (f12 < 10.0f) {
                        f12 *= f15;
                    }
                    double d17 = f12 - f15;
                    int max5 = Math.max((i3 * 4) / 3, getHeight());
                    int i12 = this.f11653g0;
                    double d18 = max5 - i12;
                    double max6 = Math.max(0.0f, (f10 - i12) * f13);
                    double d19 = -max6;
                    if (d18 == 0.0d) {
                        d18 = 1.0d;
                    }
                    i0Var.l(((int) Math.min((1.0d - Math.pow(100.0d, d19 / d18)) * d17, max6)) + this.f11653g0, true);
                }
            }
        } else {
            i0Var.l(Math.min((int) f10, getMeasuredHeight()), true);
        }
        if (!z5 || this.T || !r(this.C) || f10 >= 0.0f || (refreshState = this.f11654g1) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish) {
            return;
        }
        if (this.S) {
            this.f11675p1 = null;
            i0Var.k(-this.i0);
        }
        setStateDirectLoading(false);
        this.f11649e1.postDelayed(new androidx.activity.e(this, 15), this.f11650f);
    }

    public final void u(RefreshState refreshState) {
        RefreshState refreshState2 = this.f11654g1;
        if (refreshState2 == refreshState) {
            if (this.f11657h1 != refreshState2) {
                this.f11657h1 = refreshState2;
                return;
            }
            return;
        }
        this.f11654g1 = refreshState;
        this.f11657h1 = refreshState;
        c cVar = this.f11638a1;
        b bVar = this.f11641b1;
        if (cVar != null) {
            cVar.b(this, refreshState2, refreshState);
        }
        if (bVar != null) {
            bVar.b(this, refreshState2, refreshState);
        }
        if (refreshState == RefreshState.LoadFinish) {
            this.f11667l1 = false;
        }
    }

    public final void v() {
        RefreshState refreshState = this.f11654g1;
        RefreshState refreshState2 = RefreshState.TwoLevel;
        i0 i0Var = this.f1;
        if (refreshState == refreshState2) {
            if (this.f11682w > -1000 && this.f11639b > getHeight() / 2) {
                ValueAnimator k10 = i0Var.k(getHeight());
                if (k10 != null) {
                    k10.setDuration(this.e);
                    return;
                }
                return;
            }
            if (this.f11670n) {
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) i0Var.f7866b;
                if (smartRefreshLayout.f11654g1 == refreshState2) {
                    smartRefreshLayout.f1.w(RefreshState.TwoLevelFinish);
                    if (smartRefreshLayout.f11639b != 0) {
                        i0Var.k(0).setDuration(smartRefreshLayout.e);
                        return;
                    } else {
                        i0Var.l(0, false);
                        smartRefreshLayout.u(RefreshState.None);
                        return;
                    }
                }
                return;
            }
            return;
        }
        RefreshState refreshState3 = RefreshState.Loading;
        if (refreshState == refreshState3 || (this.H && this.T && this.U && this.f11639b < 0 && r(this.C))) {
            int i3 = this.f11639b;
            int i10 = -this.i0;
            if (i3 < i10) {
                i0Var.k(i10);
                return;
            } else {
                if (i3 > 0) {
                    i0Var.k(0);
                    return;
                }
                return;
            }
        }
        RefreshState refreshState4 = this.f11654g1;
        RefreshState refreshState5 = RefreshState.Refreshing;
        if (refreshState4 == refreshState5) {
            int i11 = this.f11639b;
            int i12 = this.f11653g0;
            if (i11 > i12) {
                i0Var.k(i12);
                return;
            } else {
                if (i11 < 0) {
                    i0Var.k(0);
                    return;
                }
                return;
            }
        }
        if (refreshState4 == RefreshState.PullDownToRefresh) {
            i0Var.w(RefreshState.PullDownCanceled);
            return;
        }
        if (refreshState4 == RefreshState.PullUpToLoad) {
            i0Var.w(RefreshState.PullUpCanceled);
            return;
        }
        if (refreshState4 == RefreshState.ReleaseToRefresh) {
            i0Var.w(refreshState5);
            return;
        }
        if (refreshState4 == RefreshState.ReleaseToLoad) {
            i0Var.w(refreshState3);
            return;
        }
        if (refreshState4 == RefreshState.ReleaseToTwoLevel) {
            i0Var.w(RefreshState.TwoLevelReleased);
            return;
        }
        if (refreshState4 == RefreshState.RefreshReleased) {
            if (this.f11677q1 == null) {
                i0Var.k(this.f11653g0);
            }
        } else if (refreshState4 == RefreshState.LoadReleased) {
            if (this.f11677q1 == null) {
                i0Var.k(-this.i0);
            }
        } else {
            if (refreshState4 == RefreshState.LoadFinish || this.f11639b == 0) {
                return;
            }
            i0Var.k(0);
        }
    }

    public final void w(boolean z5) {
        RefreshState refreshState = this.f11654g1;
        if (refreshState == RefreshState.Refreshing && z5) {
            p(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f11659i1))), 300) << 16, true, Boolean.TRUE);
            return;
        }
        if (refreshState == RefreshState.Loading && z5) {
            n(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f11659i1))), 300) << 16, true);
            return;
        }
        if (this.T != z5) {
            this.T = z5;
            b bVar = this.f11641b1;
            if (bVar != null) {
                if (!bVar.e(z5)) {
                    this.U = false;
                    new RuntimeException("Footer:" + this.f11641b1 + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                    return;
                }
                this.U = true;
                if (this.T && this.H && this.f11639b > 0 && this.f11641b1.getSpinnerStyle() == fg.b.f13680c && r(this.C) && s(this.B, this.f11638a1)) {
                    this.f11641b1.getView().setTranslationY(this.f11639b);
                }
            }
        }
    }

    public final void x(h hVar) {
        b bVar;
        b bVar2 = this.f11641b1;
        if (bVar2 != null) {
            super.removeView(bVar2.getView());
        }
        this.f11641b1 = hVar;
        this.f11667l1 = false;
        this.f11665k1 = 0;
        this.U = false;
        this.f11661j0 = fg.a.f13673c;
        this.C = !this.V || this.C;
        g gVar = new g(-2);
        ViewGroup.LayoutParams layoutParams = hVar.f8692a.getLayoutParams();
        if (layoutParams instanceof g) {
            gVar = (g) layoutParams;
        }
        if (this.f11641b1.getSpinnerStyle().f13684a) {
            super.addView(this.f11641b1.getView(), getChildCount(), gVar);
        } else {
            super.addView(this.f11641b1.getView(), 0, gVar);
        }
        int[] iArr = this.A;
        if (iArr == null || (bVar = this.f11641b1) == null) {
            return;
        }
        bVar.setPrimaryColors(iArr);
    }

    public final void y(n nVar) {
        c cVar;
        c cVar2 = this.f11638a1;
        if (cVar2 != null) {
            super.removeView(cVar2.getView());
        }
        this.f11638a1 = nVar;
        this.f11662j1 = 0;
        this.f11656h0 = fg.a.f13673c;
        g gVar = new g(-2);
        ViewGroup.LayoutParams layoutParams = nVar.f8703c.getLayoutParams();
        if (layoutParams instanceof g) {
            gVar = (g) layoutParams;
        }
        if (this.f11638a1.getSpinnerStyle().f13684a) {
            super.addView(this.f11638a1.getView(), getChildCount(), gVar);
        } else {
            super.addView(this.f11638a1.getView(), 0, gVar);
        }
        int[] iArr = this.A;
        if (iArr == null || (cVar = this.f11638a1) == null) {
            return;
        }
        cVar.setPrimaryColors(iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e5, code lost:
    
        if (r4 <= r13.f11653g0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ec, code lost:
    
        if (r4 >= (-r13.i0)) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z(float r14) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.z(float):boolean");
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 300;
        this.f11650f = 300;
        this.f11666l = 0.5f;
        this.f11668m = 'n';
        this.f11676q = -1;
        this.r = -1;
        this.f11678s = -1;
        this.f11679t = -1;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = false;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.f11646d0 = new int[2];
        s sVar = new s(this);
        this.f11648e0 = sVar;
        this.f11651f0 = new e1(3);
        fg.a aVar = fg.a.f13673c;
        this.f11656h0 = aVar;
        this.f11661j0 = aVar;
        this.V0 = 2.5f;
        this.W0 = 2.5f;
        this.X0 = 1.0f;
        this.Y0 = 1.0f;
        this.Z0 = 0.16666667f;
        this.f1 = new i0(this, 14);
        RefreshState refreshState = RefreshState.None;
        this.f11654g1 = refreshState;
        this.f11657h1 = refreshState;
        this.f11659i1 = 0L;
        this.f11662j1 = 0;
        this.f11665k1 = 0;
        this.f11667l1 = false;
        this.f11671n1 = false;
        this.f11673o1 = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f11649e1 = new Handler(Looper.getMainLooper());
        this.f11683x = new Scroller(context);
        this.f11684y = VelocityTracker.obtain();
        this.f11652g = context.getResources().getDisplayMetrics().heightPixels;
        this.f11685z = new ig.b();
        this.f11636a = viewConfiguration.getScaledTouchSlop();
        this.f11680u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f11681v = viewConfiguration.getScaledMaximumFlingVelocity();
        float f2 = ig.b.f14432a;
        this.i0 = (int) ((60.0f * f2) + 0.5f);
        this.f11653g0 = (int) ((100.0f * f2) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout);
        if (!obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        this.f11666l = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlDragRate, 0.5f);
        this.V0 = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderMaxDragRate, 2.5f);
        this.W0 = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterMaxDragRate, 2.5f);
        this.X0 = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderTriggerRate, 1.0f);
        this.Y0 = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterTriggerRate, 1.0f);
        this.B = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableRefresh, this.B);
        this.f11650f = obtainStyledAttributes.getInt(R$styleable.SmartRefreshLayout_srlReboundDuration, 300);
        this.C = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableLoadMore, this.C);
        this.f11653g0 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlHeaderHeight, this.f11653g0);
        this.i0 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlFooterHeight, this.i0);
        this.f11664k0 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlHeaderInsetStart, this.f11664k0);
        this.U0 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlFooterInsetStart, this.U0);
        this.R = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, false);
        this.S = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenLoading, false);
        this.F = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, true);
        this.G = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, true);
        this.I = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, true);
        this.L = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableAutoLoadMore, true);
        this.J = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollBounce, true);
        boolean z5 = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePureScrollMode, false);
        this.M = z5;
        this.N = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, true);
        this.O = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, true);
        this.P = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, true);
        boolean z6 = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, false);
        this.H = z6;
        this.H = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z6);
        this.D = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, true);
        this.E = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, true);
        this.K = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollDrag, false);
        this.f11676q = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedHeaderViewId, -1);
        this.r = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedFooterViewId, -1);
        this.f11678s = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlHeaderTranslationViewId, -1);
        this.f11679t = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFooterTranslationViewId, -1);
        boolean z8 = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.Q);
        this.Q = z8;
        sVar.g(z8);
        this.V = this.V || obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_srlEnableLoadMore);
        obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent);
        obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_srlEnableFooterTranslationContent);
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_srlHeaderHeight);
        fg.a aVar2 = fg.a.f13675f;
        this.f11656h0 = hasValue ? aVar2 : this.f11656h0;
        this.f11661j0 = obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_srlFooterHeight) ? aVar2 : this.f11661j0;
        int color = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.A = new int[]{color2, color};
            } else {
                this.A = new int[]{color2};
            }
        } else if (color != 0) {
            this.A = new int[]{0, color};
        }
        if (z5 && !this.V && !this.C) {
            this.C = true;
        }
        obtainStyledAttributes.recycle();
    }
}
