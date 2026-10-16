package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.emoji2.text.g;
import com.example.baselibrary.R$styleable;
import og.f;
import og.h;
import og.l;

/* loaded from: classes2.dex */
public class SwipeMenuLayout extends FrameLayout implements f {

    /* renamed from: a, reason: collision with root package name */
    public final int f12139a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12140b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12141c;

    /* renamed from: d, reason: collision with root package name */
    public float f12142d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12143f;

    /* renamed from: g, reason: collision with root package name */
    public int f12144g;

    /* renamed from: h, reason: collision with root package name */
    public int f12145h;

    /* renamed from: i, reason: collision with root package name */
    public int f12146i;

    /* renamed from: j, reason: collision with root package name */
    public int f12147j;

    /* renamed from: k, reason: collision with root package name */
    public View f12148k;

    /* renamed from: l, reason: collision with root package name */
    public h f12149l;

    /* renamed from: m, reason: collision with root package name */
    public l f12150m;

    /* renamed from: n, reason: collision with root package name */
    public g f12151n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12152o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12153p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12154q;
    public final OverScroller r;

    /* renamed from: s, reason: collision with root package name */
    public VelocityTracker f12155s;

    /* renamed from: t, reason: collision with root package name */
    public final int f12156t;

    /* renamed from: u, reason: collision with root package name */
    public final int f12157u;

    public SwipeMenuLayout(Context context) {
        this(context, null);
    }

    public final boolean a() {
        h hVar = this.f12149l;
        if (hVar != null) {
            int scrollX = getScrollX();
            int i3 = (-((View) hVar.f2030b).getWidth()) * hVar.f2029a;
            if (scrollX <= i3 && i3 != 0) {
                return true;
            }
        }
        l lVar = this.f12150m;
        if (lVar == null) {
            return false;
        }
        int scrollX2 = getScrollX();
        int i10 = (-((View) lVar.f2030b).getWidth()) * lVar.f2029a;
        return scrollX2 >= i10 && i10 != 0;
    }

    public final void b(int i3, int i10) {
        l lVar;
        if (this.f12151n != null) {
            if (Math.abs(getScrollX()) < ((View) this.f12151n.f2030b).getWidth() * this.f12142d) {
                c();
                return;
            }
            int abs = Math.abs(i3);
            int i11 = this.f12143f;
            if (abs <= i11 && Math.abs(i10) <= i11) {
                if (a()) {
                    c();
                    return;
                }
                int i12 = this.e;
                g gVar = this.f12151n;
                if (gVar != null) {
                    gVar.b(this.r, getScrollX(), i12);
                    invalidate();
                    return;
                }
                return;
            }
            h hVar = this.f12149l;
            if ((hVar != null && getScrollX() < (-((View) hVar.f2030b).getWidth()) * hVar.f2029a) || ((lVar = this.f12150m) != null && getScrollX() > (-((View) lVar.f2030b).getWidth()) * lVar.f2029a)) {
                c();
                return;
            }
            int i13 = this.e;
            g gVar2 = this.f12151n;
            if (gVar2 != null) {
                gVar2.b(this.r, getScrollX(), i13);
                invalidate();
            }
        }
    }

    public final void c() {
        int i3 = this.e;
        g gVar = this.f12151n;
        if (gVar != null) {
            gVar.a(this.r, getScrollX(), i3);
            invalidate();
        }
    }

    @Override // android.view.View
    public final void computeScroll() {
        g gVar;
        OverScroller overScroller = this.r;
        if (!overScroller.computeScrollOffset() || (gVar = this.f12151n) == null) {
            return;
        }
        if (gVar instanceof l) {
            scrollTo(Math.abs(overScroller.getCurrX()), 0);
            invalidate();
        } else {
            scrollTo(-Math.abs(overScroller.getCurrX()), 0);
            invalidate();
        }
    }

    public float getOpenPercent() {
        return this.f12142d;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.f12139a;
        if (i3 != 0 && this.f12149l == null) {
            this.f12149l = new h(1, findViewById(i3));
        }
        int i10 = this.f12141c;
        if (i10 != 0 && this.f12150m == null) {
            this.f12150m = new l(-1, findViewById(i10));
        }
        int i11 = this.f12140b;
        if (i11 != 0 && this.f12148k == null) {
            this.f12148k = findViewById(i11);
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setClickable(true);
        textView.setGravity(17);
        textView.setTextSize(16.0f);
        textView.setText("You may not have set the ContentView.");
        this.f12148k = textView;
        addView(textView);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.f12154q) {
            int action = motionEvent.getAction();
            if (action == 0) {
                int x10 = (int) motionEvent.getX();
                this.f12144g = x10;
                this.f12146i = x10;
                this.f12147j = (int) motionEvent.getY();
                return false;
            }
            if (action == 1) {
                g gVar = this.f12151n;
                if (gVar != null) {
                    if (gVar.r(motionEvent.getX(), getWidth())) {
                        z5 = true;
                        if (a() && z5) {
                            c();
                            return true;
                        }
                    }
                }
                z5 = false;
                if (a()) {
                    c();
                    return true;
                }
            } else if (action == 2) {
                int x11 = (int) (motionEvent.getX() - this.f12146i);
                int y4 = (int) (motionEvent.getY() - this.f12147j);
                if (Math.abs(x11) > this.f12143f && Math.abs(x11) > Math.abs(y4)) {
                    return true;
                }
            } else if (action == 3) {
                OverScroller overScroller = this.r;
                if (!overScroller.isFinished()) {
                    overScroller.abortAnimation();
                    return false;
                }
            }
            return false;
        }
        return onInterceptTouchEvent;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        View view = this.f12148k;
        if (view != null) {
            int measuredWidthAndState = view.getMeasuredWidthAndState();
            int measuredHeightAndState = this.f12148k.getMeasuredHeightAndState();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12148k.getLayoutParams();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop() + layoutParams.topMargin;
            this.f12148k.layout(paddingLeft, paddingTop, measuredWidthAndState + paddingLeft, measuredHeightAndState + paddingTop);
        }
        h hVar = this.f12149l;
        if (hVar != null) {
            View view2 = (View) hVar.f2030b;
            int measuredWidthAndState2 = view2.getMeasuredWidthAndState();
            int measuredHeightAndState2 = view2.getMeasuredHeightAndState();
            int paddingTop2 = getPaddingTop() + ((FrameLayout.LayoutParams) view2.getLayoutParams()).topMargin;
            view2.layout(-measuredWidthAndState2, paddingTop2, 0, measuredHeightAndState2 + paddingTop2);
        }
        l lVar = this.f12150m;
        if (lVar != null) {
            View view3 = (View) lVar.f2030b;
            int measuredWidthAndState3 = view3.getMeasuredWidthAndState();
            int measuredHeightAndState3 = view3.getMeasuredHeightAndState();
            int paddingTop3 = getPaddingTop() + ((FrameLayout.LayoutParams) view3.getLayoutParams()).topMargin;
            int measuredWidthAndState4 = getMeasuredWidthAndState();
            view3.layout(measuredWidthAndState4, paddingTop3, measuredWidthAndState3 + measuredWidthAndState4, measuredHeightAndState3 + paddingTop3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x01cf, code lost:
    
        if (r4 != 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e8, code lost:
    
        if (r4 != 0) goto L80;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.recyclerview.SwipeMenuLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final void scrollTo(int i3, int i10) {
        g gVar = this.f12151n;
        if (gVar == null) {
            super.scrollTo(i3, i10);
            return;
        }
        og.g c9 = gVar.c(i3, i10);
        this.f12152o = c9.f16944c;
        if (c9.f16942a != getScrollX()) {
            super.scrollTo(c9.f16942a, c9.f16943b);
        }
    }

    public void setOpenPercent(float f2) {
        this.f12142d = f2;
    }

    public void setScrollerDuration(int i3) {
        this.e = i3;
    }

    public void setSwipeEnable(boolean z5) {
        this.f12154q = z5;
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f12139a = 0;
        this.f12140b = 0;
        this.f12141c = 0;
        this.f12142d = 0.5f;
        this.e = 200;
        this.f12154q = true;
        setClickable(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SwipeMenuLayout);
        this.f12139a = obtainStyledAttributes.getResourceId(R$styleable.SwipeMenuLayout_leftViewId, 0);
        this.f12140b = obtainStyledAttributes.getResourceId(R$styleable.SwipeMenuLayout_contentViewId, 0);
        this.f12141c = obtainStyledAttributes.getResourceId(R$styleable.SwipeMenuLayout_rightViewId, 0);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f12143f = viewConfiguration.getScaledTouchSlop();
        this.f12156t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f12157u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.r = new OverScroller(getContext());
    }
}
