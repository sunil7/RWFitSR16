package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.activity.b;
import com.example.test.ui.view.p;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import g9.i0;
import g9.j0;
import i9.g;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public class DefaultTimeBar extends View implements j0 {
    public static final /* synthetic */ int P = 0;
    public int A;
    public long B;
    public int C;
    public Rect D;
    public final ValueAnimator E;
    public float F;
    public boolean G;
    public boolean H;
    public long I;
    public long J;
    public long K;
    public long L;
    public int M;
    public long[] N;
    public boolean[] O;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f8905a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f8906b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f8907c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f8908d;
    public final Paint e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f8909f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f8910g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f8911h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f8912i;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f8913j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable f8914k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8915l;

    /* renamed from: m, reason: collision with root package name */
    public final int f8916m;

    /* renamed from: n, reason: collision with root package name */
    public final int f8917n;

    /* renamed from: o, reason: collision with root package name */
    public final int f8918o;

    /* renamed from: p, reason: collision with root package name */
    public final int f8919p;

    /* renamed from: q, reason: collision with root package name */
    public final int f8920q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public final int f8921s;

    /* renamed from: t, reason: collision with root package name */
    public final int f8922t;

    /* renamed from: u, reason: collision with root package name */
    public final StringBuilder f8923u;

    /* renamed from: v, reason: collision with root package name */
    public final Formatter f8924v;

    /* renamed from: w, reason: collision with root package name */
    public final b f8925w;

    /* renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArraySet f8926x;

    /* renamed from: y, reason: collision with root package name */
    public final Point f8927y;

    /* renamed from: z, reason: collision with root package name */
    public final float f8928z;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    public static int a(float f2, int i3) {
        return (int) ((i3 * f2) + 0.5f);
    }

    private long getPositionIncrement() {
        long j4 = this.B;
        if (j4 != -9223372036854775807L) {
            return j4;
        }
        long j10 = this.J;
        if (j10 == -9223372036854775807L) {
            return 0L;
        }
        return j10 / this.A;
    }

    private String getProgressText() {
        return g.d(this.f8923u, this.f8924v, this.K);
    }

    private long getScrubberPosition() {
        if (this.f8906b.width() <= 0 || this.J == -9223372036854775807L) {
            return 0L;
        }
        return (this.f8908d.width() * this.J) / r0.width();
    }

    @Override // g9.j0
    public void addListener(i0 i0Var) {
        i0Var.getClass();
        this.f8926x.add(i0Var);
    }

    public final boolean b(long j4) {
        long j10 = this.J;
        if (j10 <= 0) {
            return false;
        }
        long j11 = this.H ? this.I : this.K;
        long c9 = g.c(j11 + j4, 0L, j10);
        if (c9 == j11) {
            return false;
        }
        if (this.H) {
            f(c9);
        } else {
            c(c9);
        }
        e();
        return true;
    }

    public final void c(long j4) {
        this.I = j4;
        this.H = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.f8926x.iterator();
        while (it.hasNext()) {
            ((i0) it.next()).a(j4);
        }
    }

    public final void d(boolean z5) {
        removeCallbacks(this.f8925w);
        this.H = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.f8926x.iterator();
        while (it.hasNext()) {
            ((i0) it.next()).b(this.I, z5);
        }
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f8914k;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void e() {
        Rect rect = this.f8907c;
        Rect rect2 = this.f8906b;
        rect.set(rect2);
        Rect rect3 = this.f8908d;
        rect3.set(rect2);
        long j4 = this.H ? this.I : this.K;
        if (this.J > 0) {
            rect.right = Math.min(rect2.left + ((int) ((rect2.width() * this.L) / this.J)), rect2.right);
            rect3.right = Math.min(rect2.left + ((int) ((rect2.width() * j4) / this.J)), rect2.right);
        } else {
            int i3 = rect2.left;
            rect.right = i3;
            rect3.right = i3;
        }
        invalidate(this.f8905a);
    }

    public final void f(long j4) {
        if (this.I == j4) {
            return;
        }
        this.I = j4;
        Iterator it = this.f8926x.iterator();
        while (it.hasNext()) {
            ((i0) it.next()).c(j4);
        }
    }

    @Override // g9.j0
    public long getPreferredUpdateDelay() {
        int width = (int) (this.f8906b.width() / this.f8928z);
        if (width == 0) {
            return Format.OFFSET_SAMPLE_RELATIVE;
        }
        long j4 = this.J;
        return (j4 == 0 || j4 == -9223372036854775807L) ? Format.OFFSET_SAMPLE_RELATIVE : j4 / width;
    }

    @Override // android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8914k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        Rect rect = this.f8906b;
        int height = rect.height();
        int centerY = rect.centerY() - (height / 2);
        int i3 = centerY + height;
        long j4 = this.J;
        Paint paint = this.f8910g;
        Rect rect2 = this.f8908d;
        if (j4 <= 0) {
            canvas2 = canvas;
            canvas2.drawRect(rect.left, centerY, rect.right, i3, paint);
        } else {
            Rect rect3 = this.f8907c;
            int i10 = rect3.left;
            int i11 = rect3.right;
            int max = Math.max(Math.max(rect.left, i11), rect2.right);
            int i12 = rect.right;
            if (max < i12) {
                canvas.drawRect(max, centerY, i12, i3, paint);
            }
            int max2 = Math.max(i10, rect2.right);
            if (i11 > max2) {
                canvas.drawRect(max2, centerY, i11, i3, this.f8909f);
            }
            if (rect2.width() > 0) {
                canvas.drawRect(rect2.left, centerY, rect2.right, i3, this.e);
            }
            if (this.M != 0) {
                long[] jArr = this.N;
                jArr.getClass();
                boolean[] zArr = this.O;
                zArr.getClass();
                int i13 = this.f8918o;
                int i14 = i13 / 2;
                int i15 = 0;
                int i16 = 0;
                while (i16 < this.M) {
                    int i17 = i16;
                    canvas.drawRect(Math.min(rect.width() - i13, Math.max(i15, ((int) ((rect.width() * g.c(jArr[i16], 0L, this.J)) / this.J)) - i14)) + rect.left, centerY, r3 + i13, i3, zArr[i16] ? this.f8912i : this.f8911h);
                    i16 = i17 + 1;
                    i15 = i15;
                }
            }
            canvas2 = canvas;
        }
        if (this.J > 0) {
            int b3 = g.b(rect2.right, rect2.left, rect.right);
            int centerY2 = rect2.centerY();
            Drawable drawable = this.f8914k;
            if (drawable == null) {
                canvas2.drawCircle(b3, centerY2, (int) ((((this.H || isFocused()) ? this.r : isEnabled() ? this.f8919p : this.f8920q) * this.F) / 2.0f), this.f8913j);
            } else {
                int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.F)) / 2;
                int intrinsicHeight = ((int) (drawable.getIntrinsicHeight() * this.F)) / 2;
                drawable.setBounds(b3 - intrinsicWidth, centerY2 - intrinsicHeight, b3 + intrinsicWidth, centerY2 + intrinsicHeight);
                drawable.draw(canvas2);
            }
        }
        canvas2.restore();
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z5, int i3, Rect rect) {
        super.onFocusChanged(z5, i3, rect);
        if (!this.H || z5) {
            return;
        }
        d(false);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.J <= 0) {
            return;
        }
        if (g.f14378a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L2e
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L25
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L25;
                default: goto L12;
            }
        L12:
            goto L2e
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.b(r0)
            if (r0 == 0) goto L2e
            androidx.activity.b r5 = r4.f8925w
            r4.removeCallbacks(r5)
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L25:
            boolean r0 = r4.H
            if (r0 == 0) goto L2e
            r5 = 0
            r4.d(r5)
            return r3
        L2e:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int i13;
        int i14;
        Rect rect;
        int i15 = i11 - i3;
        int i16 = i12 - i10;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i15 - getPaddingRight();
        int i17 = this.G ? 0 : this.f8921s;
        int i18 = this.f8917n;
        int i19 = this.f8915l;
        int i20 = this.f8916m;
        if (i18 == 1) {
            i13 = (i16 - getPaddingBottom()) - i20;
            i14 = ((i16 - getPaddingBottom()) - i19) - Math.max(i17 - (i19 / 2), 0);
        } else {
            i13 = (i16 - i20) / 2;
            i14 = (i16 - i19) / 2;
        }
        Rect rect2 = this.f8905a;
        rect2.set(paddingLeft, i13, paddingRight, i20 + i13);
        this.f8906b.set(rect2.left + i17, i14, rect2.right - i17, i19 + i14);
        if (g.f14378a >= 29 && ((rect = this.D) == null || rect.width() != i15 || this.D.height() != i16)) {
            Rect rect3 = new Rect(0, 0, i15, i16);
            this.D = rect3;
            setSystemGestureExclusionRects(Collections.singletonList(rect3));
        }
        e();
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int i11 = this.f8916m;
        if (mode == 0) {
            size = i11;
        } else if (mode != 1073741824) {
            size = Math.min(i11, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i3), size);
        Drawable drawable = this.f8914k;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i3) {
        Drawable drawable = this.f8914k;
        if (drawable == null || g.f14378a < 23 || !drawable.setLayoutDirection(i3)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        if (r3 != 3) goto L34;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.isEnabled()
            r1 = 0
            if (r0 == 0) goto La1
            long r2 = r9.J
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L11
            goto La1
        L11:
            android.graphics.Point r0 = r9.f8927y
            float r2 = r10.getX()
            int r2 = (int) r2
            float r3 = r10.getY()
            int r3 = (int) r3
            r0.set(r2, r3)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r10.getAction()
            android.graphics.Rect r4 = r9.f8908d
            android.graphics.Rect r5 = r9.f8906b
            r6 = 1
            if (r3 == 0) goto L7d
            r7 = 3
            if (r3 == r6) goto L6e
            r8 = 2
            if (r3 == r8) goto L38
            if (r3 == r7) goto L6e
            goto La1
        L38:
            boolean r10 = r9.H
            if (r10 == 0) goto La1
            int r10 = r9.f8922t
            if (r0 >= r10) goto L52
            int r10 = r9.C
            int r2 = r2 - r10
            int r2 = r2 / r7
            int r2 = r2 + r10
            float r10 = (float) r2
            int r10 = (int) r10
            int r0 = r5.left
            int r1 = r5.right
            int r10 = i9.g.b(r10, r0, r1)
            r4.right = r10
            goto L60
        L52:
            r9.C = r2
            float r10 = (float) r2
            int r10 = (int) r10
            int r0 = r5.left
            int r1 = r5.right
            int r10 = i9.g.b(r10, r0, r1)
            r4.right = r10
        L60:
            long r0 = r9.getScrubberPosition()
            r9.f(r0)
            r9.e()
            r9.invalidate()
            return r6
        L6e:
            boolean r0 = r9.H
            if (r0 == 0) goto La1
            int r10 = r10.getAction()
            if (r10 != r7) goto L79
            r1 = r6
        L79:
            r9.d(r1)
            return r6
        L7d:
            float r10 = (float) r2
            float r0 = (float) r0
            int r10 = (int) r10
            int r0 = (int) r0
            android.graphics.Rect r2 = r9.f8905a
            boolean r0 = r2.contains(r10, r0)
            if (r0 == 0) goto La1
            int r0 = r5.left
            int r1 = r5.right
            int r10 = i9.g.b(r10, r0, r1)
            r4.right = r10
            long r0 = r9.getScrubberPosition()
            r9.c(r0)
            r9.e()
            r9.invalidate()
            return r6
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i3, Bundle bundle) {
        if (super.performAccessibilityAction(i3, bundle)) {
            return true;
        }
        if (this.J <= 0) {
            return false;
        }
        if (i3 == 8192) {
            if (b(-getPositionIncrement())) {
                d(false);
            }
        } else {
            if (i3 != 4096) {
                return false;
            }
            if (b(getPositionIncrement())) {
                d(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @Override // g9.j0
    public void removeListener(i0 i0Var) {
        this.f8926x.remove(i0Var);
    }

    public void setAdMarkerColor(int i3) {
        this.f8911h.setColor(i3);
        invalidate(this.f8905a);
    }

    public void setBufferedColor(int i3) {
        this.f8909f.setColor(i3);
        invalidate(this.f8905a);
    }

    @Override // g9.j0
    public void setBufferedPosition(long j4) {
        if (this.L == j4) {
            return;
        }
        this.L = j4;
        e();
    }

    @Override // g9.j0
    public void setDuration(long j4) {
        if (this.J == j4) {
            return;
        }
        this.J = j4;
        if (this.H && j4 == -9223372036854775807L) {
            d(true);
        }
        e();
    }

    @Override // android.view.View, g9.j0
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        if (!this.H || z5) {
            return;
        }
        d(true);
    }

    public void setKeyCountIncrement(int i3) {
        pc.a(i3 > 0);
        this.A = i3;
        this.B = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j4) {
        pc.a(j4 > 0);
        this.A = -1;
        this.B = j4;
    }

    public void setPlayedAdMarkerColor(int i3) {
        this.f8912i.setColor(i3);
        invalidate(this.f8905a);
    }

    public void setPlayedColor(int i3) {
        this.e.setColor(i3);
        invalidate(this.f8905a);
    }

    @Override // g9.j0
    public void setPosition(long j4) {
        if (this.K == j4) {
            return;
        }
        this.K = j4;
        setContentDescription(getProgressText());
        e();
    }

    public void setScrubberColor(int i3) {
        this.f8913j.setColor(i3);
        invalidate(this.f8905a);
    }

    public void setUnplayedColor(int i3) {
        this.f8910g.setColor(i3);
        invalidate(this.f8905a);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i3, AttributeSet attributeSet2, int i10) {
        super(context, attributeSet, i3);
        this.f8905a = new Rect();
        this.f8906b = new Rect();
        this.f8907c = new Rect();
        this.f8908d = new Rect();
        Paint paint = new Paint();
        this.e = paint;
        Paint paint2 = new Paint();
        this.f8909f = paint2;
        Paint paint3 = new Paint();
        this.f8910g = paint3;
        Paint paint4 = new Paint();
        this.f8911h = paint4;
        Paint paint5 = new Paint();
        this.f8912i = paint5;
        Paint paint6 = new Paint();
        this.f8913j = paint6;
        paint6.setAntiAlias(true);
        this.f8926x = new CopyOnWriteArraySet();
        this.f8927y = new Point();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f8928z = f2;
        this.f8922t = a(f2, -50);
        int a3 = a(f2, 4);
        int a10 = a(f2, 26);
        int a11 = a(f2, 4);
        int a12 = a(f2, 12);
        int a13 = a(f2, 0);
        int a14 = a(f2, 16);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.DefaultTimeBar, i3, i10);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.DefaultTimeBar_scrubber_drawable);
                this.f8914k = drawable;
                if (drawable != null) {
                    int i11 = g.f14378a;
                    if (i11 >= 23) {
                        int layoutDirection = getLayoutDirection();
                        if (i11 < 23 || !drawable.setLayoutDirection(layoutDirection)) {
                        }
                    }
                    a10 = Math.max(drawable.getMinimumHeight(), a10);
                }
                this.f8915l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_bar_height, a3);
                this.f8916m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_touch_target_height, a10);
                this.f8917n = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_bar_gravity, 0);
                this.f8918o = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_ad_marker_width, a11);
                this.f8919p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_enabled_size, a12);
                this.f8920q = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_disabled_size, a13);
                this.r = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_dragged_size, a14);
                int i12 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_color, -1);
                int i13 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_scrubber_color, -1);
                int i14 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_buffered_color, -855638017);
                int i15 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_unplayed_color, 872415231);
                int i16 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                int i17 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i12);
                paint6.setColor(i13);
                paint2.setColor(i14);
                paint3.setColor(i15);
                paint4.setColor(i16);
                paint5.setColor(i17);
                obtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                obtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            this.f8915l = a3;
            this.f8916m = a10;
            this.f8917n = 0;
            this.f8918o = a11;
            this.f8919p = a12;
            this.f8920q = a13;
            this.r = a14;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f8914k = null;
        }
        StringBuilder sb2 = new StringBuilder();
        this.f8923u = sb2;
        this.f8924v = new Formatter(sb2, Locale.getDefault());
        this.f8925w = new b(this, 26);
        Drawable drawable2 = this.f8914k;
        if (drawable2 != null) {
            this.f8921s = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f8921s = (Math.max(this.f8920q, Math.max(this.f8919p, this.r)) + 1) / 2;
        }
        this.F = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.E = valueAnimator;
        valueAnimator.addUpdateListener(new p(1, this));
        this.J = -9223372036854775807L;
        this.B = -9223372036854775807L;
        this.A = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
