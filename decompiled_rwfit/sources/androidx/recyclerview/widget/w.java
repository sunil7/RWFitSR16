package androidx.recyclerview.widget;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.appcompat.widget.r2;
import com.amap.api.services.core.AMapException;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class w extends g1 implements m1 {
    public static final int[] C = {R.attr.state_pressed};
    public static final int[] D = new int[0];
    public int A;
    public final t B;

    /* renamed from: a, reason: collision with root package name */
    public final int f2758a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2759b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f2760c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f2761d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2762f;

    /* renamed from: g, reason: collision with root package name */
    public final StateListDrawable f2763g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f2764h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2765i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2766j;

    /* renamed from: k, reason: collision with root package name */
    public int f2767k;

    /* renamed from: l, reason: collision with root package name */
    public int f2768l;

    /* renamed from: m, reason: collision with root package name */
    public float f2769m;

    /* renamed from: n, reason: collision with root package name */
    public int f2770n;

    /* renamed from: o, reason: collision with root package name */
    public int f2771o;

    /* renamed from: p, reason: collision with root package name */
    public float f2772p;

    /* renamed from: s, reason: collision with root package name */
    public final RecyclerView f2774s;

    /* renamed from: z, reason: collision with root package name */
    public final ValueAnimator f2781z;

    /* renamed from: q, reason: collision with root package name */
    public int f2773q = 0;
    public int r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2775t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2776u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f2777v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f2778w = 0;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f2779x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    public final int[] f2780y = new int[2];

    public w(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i3, int i10, int i11) {
        int i12 = 0;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2781z = ofFloat;
        this.A = 0;
        t tVar = new t(this, i12);
        this.B = tVar;
        u uVar = new u(this);
        this.f2760c = stateListDrawable;
        this.f2761d = drawable;
        this.f2763g = stateListDrawable2;
        this.f2764h = drawable2;
        this.e = Math.max(i3, stateListDrawable.getIntrinsicWidth());
        this.f2762f = Math.max(i3, drawable.getIntrinsicWidth());
        this.f2765i = Math.max(i3, stateListDrawable2.getIntrinsicWidth());
        this.f2766j = Math.max(i3, drawable2.getIntrinsicWidth());
        this.f2758a = i10;
        this.f2759b = i11;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new r2(this, 1));
        ofFloat.addUpdateListener(new v(this, i12));
        RecyclerView recyclerView2 = this.f2774s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.b0(this);
            this.f2774s.removeOnItemTouchListener(this);
            this.f2774s.removeOnScrollListener(uVar);
            this.f2774s.removeCallbacks(tVar);
        }
        this.f2774s = recyclerView;
        recyclerView.g(this);
        this.f2774s.addOnItemTouchListener(this);
        this.f2774s.addOnScrollListener(uVar);
    }

    public static int j(float f2, float f10, int[] iArr, int i3, int i10, int i11) {
        int i12 = iArr[1] - iArr[0];
        if (i12 != 0) {
            int i13 = i3 - i11;
            int i14 = (int) (((f10 - f2) / i12) * i13);
            int i15 = i10 + i14;
            if (i15 < i13 && i15 >= 0) {
                return i14;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.m1
    public final boolean b(MotionEvent motionEvent) {
        int i3 = this.f2777v;
        if (i3 != 1) {
            return i3 == 2;
        }
        boolean i10 = i(motionEvent.getX(), motionEvent.getY());
        boolean h4 = h(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!i10 && !h4) {
            return false;
        }
        if (h4) {
            this.f2778w = 1;
            this.f2772p = (int) motionEvent.getX();
        } else if (i10) {
            this.f2778w = 2;
            this.f2769m = (int) motionEvent.getY();
        }
        k(2);
        return true;
    }

    @Override // androidx.recyclerview.widget.m1
    public final void d(boolean z5) {
    }

    @Override // androidx.recyclerview.widget.g1
    public final void g(Canvas canvas, RecyclerView recyclerView) {
        int i3 = this.f2773q;
        RecyclerView recyclerView2 = this.f2774s;
        if (i3 != recyclerView2.getWidth() || this.r != recyclerView2.getHeight()) {
            this.f2773q = recyclerView2.getWidth();
            this.r = recyclerView2.getHeight();
            k(0);
            return;
        }
        if (this.A != 0) {
            if (this.f2775t) {
                int i10 = this.f2773q;
                int i11 = this.e;
                int i12 = i10 - i11;
                int i13 = this.f2768l;
                int i14 = this.f2767k;
                int i15 = i13 - (i14 / 2);
                StateListDrawable stateListDrawable = this.f2760c;
                stateListDrawable.setBounds(0, 0, i11, i14);
                int i16 = this.r;
                int i17 = this.f2762f;
                Drawable drawable = this.f2761d;
                drawable.setBounds(0, 0, i17, i16);
                WeakHashMap weakHashMap = l1.z0.f15748a;
                if (l1.i0.d(recyclerView2) == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i11, i15);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i11, -i15);
                } else {
                    canvas.translate(i12, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i15);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i12, -i15);
                }
            }
            if (this.f2776u) {
                int i18 = this.r;
                int i19 = this.f2765i;
                int i20 = i18 - i19;
                int i21 = this.f2771o;
                int i22 = this.f2770n;
                int i23 = i21 - (i22 / 2);
                StateListDrawable stateListDrawable2 = this.f2763g;
                stateListDrawable2.setBounds(0, 0, i22, i19);
                int i24 = this.f2773q;
                int i25 = this.f2766j;
                Drawable drawable2 = this.f2764h;
                drawable2.setBounds(0, 0, i24, i25);
                canvas.translate(0.0f, i20);
                drawable2.draw(canvas);
                canvas.translate(i23, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i23, -i20);
            }
        }
    }

    public final boolean h(float f2, float f10) {
        if (f10 < this.r - this.f2765i) {
            return false;
        }
        int i3 = this.f2771o;
        int i10 = this.f2770n;
        return f2 >= ((float) (i3 - (i10 / 2))) && f2 <= ((float) ((i10 / 2) + i3));
    }

    public final boolean i(float f2, float f10) {
        RecyclerView recyclerView = this.f2774s;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        boolean z5 = l1.i0.d(recyclerView) == 1;
        int i3 = this.e;
        if (!z5 ? f2 >= this.f2773q - i3 : f2 <= i3) {
            int i10 = this.f2768l;
            int i11 = this.f2767k / 2;
            if (f10 >= i10 - i11 && f10 <= i11 + i10) {
                return true;
            }
        }
        return false;
    }

    public final void k(int i3) {
        t tVar = this.B;
        StateListDrawable stateListDrawable = this.f2760c;
        if (i3 == 2 && this.f2777v != 2) {
            stateListDrawable.setState(C);
            this.f2774s.removeCallbacks(tVar);
        }
        if (i3 == 0) {
            this.f2774s.invalidate();
        } else {
            l();
        }
        if (this.f2777v == 2 && i3 != 2) {
            stateListDrawable.setState(D);
            this.f2774s.removeCallbacks(tVar);
            this.f2774s.postDelayed(tVar, AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
        } else if (i3 == 1) {
            this.f2774s.removeCallbacks(tVar);
            this.f2774s.postDelayed(tVar, 1500);
        }
        this.f2777v = i3;
    }

    public final void l() {
        int i3 = this.A;
        ValueAnimator valueAnimator = this.f2781z;
        if (i3 != 0) {
            if (i3 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override // androidx.recyclerview.widget.m1
    public final void onTouchEvent(MotionEvent motionEvent) {
        if (this.f2777v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean i3 = i(motionEvent.getX(), motionEvent.getY());
            boolean h4 = h(motionEvent.getX(), motionEvent.getY());
            if (i3 || h4) {
                if (h4) {
                    this.f2778w = 1;
                    this.f2772p = (int) motionEvent.getX();
                } else if (i3) {
                    this.f2778w = 2;
                    this.f2769m = (int) motionEvent.getY();
                }
                k(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f2777v == 2) {
            this.f2769m = 0.0f;
            this.f2772p = 0.0f;
            k(1);
            this.f2778w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f2777v == 2) {
            l();
            int i10 = this.f2778w;
            int i11 = this.f2759b;
            if (i10 == 1) {
                float x10 = motionEvent.getX();
                int[] iArr = this.f2780y;
                iArr[0] = i11;
                int i12 = this.f2773q - i11;
                iArr[1] = i12;
                float max = Math.max(i11, Math.min(i12, x10));
                if (Math.abs(this.f2771o - max) >= 2.0f) {
                    int j4 = j(this.f2772p, max, iArr, this.f2774s.computeHorizontalScrollRange(), this.f2774s.computeHorizontalScrollOffset(), this.f2773q);
                    if (j4 != 0) {
                        this.f2774s.scrollBy(j4, 0);
                    }
                    this.f2772p = max;
                }
            }
            if (this.f2778w == 2) {
                float y4 = motionEvent.getY();
                int[] iArr2 = this.f2779x;
                iArr2[0] = i11;
                int i13 = this.r - i11;
                iArr2[1] = i13;
                float max2 = Math.max(i11, Math.min(i13, y4));
                if (Math.abs(this.f2768l - max2) < 2.0f) {
                    return;
                }
                int j10 = j(this.f2769m, max2, iArr2, this.f2774s.computeVerticalScrollRange(), this.f2774s.computeVerticalScrollOffset(), this.r);
                if (j10 != 0) {
                    this.f2774s.scrollBy(0, j10);
                }
                this.f2769m = max2;
            }
        }
    }
}
