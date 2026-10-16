package p1;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import com.google.android.gms.internal.mlkit_vision_barcode.sf;
import java.util.Arrays;
import java.util.WeakHashMap;
import l1.z0;
import n2.e;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: x, reason: collision with root package name */
    public static final e f17368x = new e(1);

    /* renamed from: a, reason: collision with root package name */
    public int f17369a;

    /* renamed from: b, reason: collision with root package name */
    public int f17370b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f17372d;
    public float[] e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f17373f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f17374g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f17375h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f17376i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f17377j;

    /* renamed from: k, reason: collision with root package name */
    public int f17378k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f17379l;

    /* renamed from: m, reason: collision with root package name */
    public final float f17380m;

    /* renamed from: n, reason: collision with root package name */
    public float f17381n;

    /* renamed from: o, reason: collision with root package name */
    public int f17382o;

    /* renamed from: p, reason: collision with root package name */
    public final int f17383p;

    /* renamed from: q, reason: collision with root package name */
    public int f17384q;
    public final OverScroller r;

    /* renamed from: s, reason: collision with root package name */
    public final sf f17385s;

    /* renamed from: t, reason: collision with root package name */
    public View f17386t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f17387u;

    /* renamed from: v, reason: collision with root package name */
    public final ViewGroup f17388v;

    /* renamed from: c, reason: collision with root package name */
    public int f17371c = -1;

    /* renamed from: w, reason: collision with root package name */
    public final androidx.activity.e f17389w = new androidx.activity.e(this, 28);

    public d(Context context, ViewGroup viewGroup, sf sfVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (sfVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f17388v = viewGroup;
        this.f17385s = sfVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i3 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f17383p = i3;
        this.f17382o = i3;
        this.f17370b = viewConfiguration.getScaledTouchSlop();
        this.f17380m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f17381n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(context, f17368x);
    }

    public final void a() {
        this.f17371c = -1;
        float[] fArr = this.f17372d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f17373f, 0.0f);
            Arrays.fill(this.f17374g, 0.0f);
            Arrays.fill(this.f17375h, 0);
            Arrays.fill(this.f17376i, 0);
            Arrays.fill(this.f17377j, 0);
            this.f17378k = 0;
        }
        VelocityTracker velocityTracker = this.f17379l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f17379l = null;
        }
    }

    public final void b(int i3, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f17388v;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f17386t = view;
        this.f17371c = i3;
        this.f17385s.g(i3, view);
        p(1);
    }

    public final boolean c(float f2, float f10, int i3, int i10) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f10);
        if ((this.f17375h[i3] & i10) != i10 || (this.f17384q & i10) == 0 || (this.f17377j[i3] & i10) == i10 || (this.f17376i[i3] & i10) == i10) {
            return false;
        }
        float f11 = this.f17370b;
        if (abs <= f11 && abs2 <= f11) {
            return false;
        }
        if (abs < abs2 * 0.5f) {
            this.f17385s.getClass();
        }
        return (this.f17376i[i3] & i10) == 0 && abs > ((float) this.f17370b);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            goto L45
        L4:
            com.google.android.gms.internal.mlkit_vision_barcode.sf r1 = r3.f17385s
            int r4 = r1.c(r4)
            r2 = 1
            if (r4 <= 0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r0
        L10:
            int r1 = r1.d()
            if (r1 <= 0) goto L18
            r1 = r2
            goto L19
        L18:
            r1 = r0
        L19:
            if (r4 == 0) goto L29
            if (r1 == 0) goto L29
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r4 = r3.f17370b
            int r4 = r4 * r4
            float r4 = (float) r4
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 <= 0) goto L45
            goto L44
        L29:
            if (r4 == 0) goto L37
            float r4 = java.lang.Math.abs(r5)
            int r5 = r3.f17370b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L45
            goto L44
        L37:
            if (r1 == 0) goto L45
            float r4 = java.lang.Math.abs(r6)
            int r5 = r3.f17370b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L45
        L44:
            return r2
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.d.d(android.view.View, float, float):boolean");
    }

    public final void e(int i3) {
        float[] fArr = this.f17372d;
        if (fArr != null) {
            int i10 = this.f17378k;
            int i11 = 1 << i3;
            if ((i10 & i11) != 0) {
                fArr[i3] = 0.0f;
                this.e[i3] = 0.0f;
                this.f17373f[i3] = 0.0f;
                this.f17374g[i3] = 0.0f;
                this.f17375h[i3] = 0;
                this.f17376i[i3] = 0;
                this.f17377j[i3] = 0;
                this.f17378k = (~i11) & i10;
            }
        }
    }

    public final int f(int i3, int i10, int i11) {
        if (i3 == 0) {
            return 0;
        }
        float width = this.f17388v.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(i3) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int abs = Math.abs(i10);
        return Math.min(abs > 0 ? Math.round(Math.abs(sin / abs) * 1000.0f) * 4 : (int) (((Math.abs(i3) / i11) + 1.0f) * 256.0f), FontStyle.WEIGHT_SEMI_BOLD);
    }

    public final boolean g() {
        if (this.f17369a == 2) {
            OverScroller overScroller = this.r;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f17386t.getLeft();
            int top = currY - this.f17386t.getTop();
            if (left != 0) {
                View view = this.f17386t;
                WeakHashMap weakHashMap = z0.f15748a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f17386t;
                WeakHashMap weakHashMap2 = z0.f15748a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f17385s.i(this.f17386t, currX, currY);
            }
            if (computeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.f17388v.post(this.f17389w);
            }
        }
        return this.f17369a == 2;
    }

    public final View h(int i3, int i10) {
        ViewGroup viewGroup = this.f17388v;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f17385s.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i10 >= childAt.getTop() && i10 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean i(int i3, int i10, int i11, int i12) {
        float f2;
        float f10;
        float f11;
        float f12;
        int left = this.f17386t.getLeft();
        int top = this.f17386t.getTop();
        int i13 = i3 - left;
        int i14 = i10 - top;
        OverScroller overScroller = this.r;
        if (i13 == 0 && i14 == 0) {
            overScroller.abortAnimation();
            p(0);
            return false;
        }
        View view = this.f17386t;
        int i15 = (int) this.f17381n;
        int i16 = (int) this.f17380m;
        int abs = Math.abs(i11);
        if (abs < i15) {
            i11 = 0;
        } else if (abs > i16) {
            i11 = i11 > 0 ? i16 : -i16;
        }
        int i17 = (int) this.f17381n;
        int abs2 = Math.abs(i12);
        if (abs2 < i17) {
            i12 = 0;
        } else if (abs2 > i16) {
            i12 = i12 > 0 ? i16 : -i16;
        }
        int abs3 = Math.abs(i13);
        int abs4 = Math.abs(i14);
        int abs5 = Math.abs(i11);
        int abs6 = Math.abs(i12);
        int i18 = abs5 + abs6;
        int i19 = abs3 + abs4;
        if (i11 != 0) {
            f2 = abs5;
            f10 = i18;
        } else {
            f2 = abs3;
            f10 = i19;
        }
        float f13 = f2 / f10;
        if (i12 != 0) {
            f11 = abs6;
            f12 = i18;
        } else {
            f11 = abs4;
            f12 = i19;
        }
        float f14 = f11 / f12;
        sf sfVar = this.f17385s;
        overScroller.startScroll(left, top, i13, i14, (int) ((f(i14, i12, sfVar.d()) * f14) + (f(i13, i11, sfVar.c(view)) * f13)));
        p(2);
        return true;
    }

    public final boolean j(int i3) {
        if ((this.f17378k & (1 << i3)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i3 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void k(MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f17379l == null) {
            this.f17379l = VelocityTracker.obtain();
        }
        this.f17379l.addMovement(motionEvent);
        int i10 = 0;
        sf sfVar = this.f17385s;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y4 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View h4 = h((int) x10, (int) y4);
            n(x10, y4, pointerId);
            t(pointerId, h4);
            if ((this.f17375h[pointerId] & this.f17384q) != 0) {
                sfVar.f();
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f17369a == 1) {
                l();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f17369a != 1) {
                int pointerCount = motionEvent.getPointerCount();
                while (i10 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i10);
                    if (j(pointerId2)) {
                        float x11 = motionEvent.getX(i10);
                        float y10 = motionEvent.getY(i10);
                        float f2 = x11 - this.f17372d[pointerId2];
                        float f10 = y10 - this.e[pointerId2];
                        m(f2, f10, pointerId2);
                        if (this.f17369a != 1) {
                            View h10 = h((int) x11, (int) y10);
                            if (d(h10, f2, f10) && t(pointerId2, h10)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i10++;
                }
                o(motionEvent);
                return;
            }
            if (j(this.f17371c)) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f17371c);
                float x12 = motionEvent.getX(findPointerIndex);
                float y11 = motionEvent.getY(findPointerIndex);
                float[] fArr = this.f17373f;
                int i11 = this.f17371c;
                int i12 = (int) (x12 - fArr[i11]);
                int i13 = (int) (y11 - this.f17374g[i11]);
                int left = this.f17386t.getLeft() + i12;
                int top = this.f17386t.getTop() + i13;
                int left2 = this.f17386t.getLeft();
                int top2 = this.f17386t.getTop();
                if (i12 != 0) {
                    left = sfVar.a(left, this.f17386t);
                    WeakHashMap weakHashMap = z0.f15748a;
                    this.f17386t.offsetLeftAndRight(left - left2);
                }
                if (i13 != 0) {
                    top = sfVar.b(top, this.f17386t);
                    WeakHashMap weakHashMap2 = z0.f15748a;
                    this.f17386t.offsetTopAndBottom(top - top2);
                }
                if (i12 != 0 || i13 != 0) {
                    sfVar.i(this.f17386t, left, top);
                }
                o(motionEvent);
                return;
            }
            return;
        }
        if (actionMasked == 3) {
            if (this.f17369a == 1) {
                this.f17387u = true;
                sfVar.j(this.f17386t, 0.0f, 0.0f);
                this.f17387u = false;
                if (this.f17369a == 1) {
                    p(0);
                }
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x13 = motionEvent.getX(actionIndex);
            float y12 = motionEvent.getY(actionIndex);
            n(x13, y12, pointerId3);
            if (this.f17369a == 0) {
                t(pointerId3, h((int) x13, (int) y12));
                if ((this.f17375h[pointerId3] & this.f17384q) != 0) {
                    sfVar.f();
                    return;
                }
                return;
            }
            int i14 = (int) x13;
            int i15 = (int) y12;
            View view = this.f17386t;
            if (view != null && i14 >= view.getLeft() && i14 < view.getRight() && i15 >= view.getTop() && i15 < view.getBottom()) {
                t(pointerId3, this.f17386t);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f17369a == 1 && pointerId4 == this.f17371c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i10 >= pointerCount2) {
                    i3 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i10);
                if (pointerId5 != this.f17371c) {
                    View h11 = h((int) motionEvent.getX(i10), (int) motionEvent.getY(i10));
                    View view2 = this.f17386t;
                    if (h11 == view2 && t(pointerId5, view2)) {
                        i3 = this.f17371c;
                        break;
                    }
                }
                i10++;
            }
            if (i3 == -1) {
                l();
            }
        }
        e(pointerId4);
    }

    public final void l() {
        VelocityTracker velocityTracker = this.f17379l;
        float f2 = this.f17380m;
        velocityTracker.computeCurrentVelocity(1000, f2);
        float xVelocity = this.f17379l.getXVelocity(this.f17371c);
        float f10 = this.f17381n;
        float abs = Math.abs(xVelocity);
        if (abs < f10) {
            xVelocity = 0.0f;
        } else if (abs > f2) {
            xVelocity = xVelocity > 0.0f ? f2 : -f2;
        }
        float yVelocity = this.f17379l.getYVelocity(this.f17371c);
        float f11 = this.f17381n;
        float abs2 = Math.abs(yVelocity);
        if (abs2 < f11) {
            f2 = 0.0f;
        } else if (abs2 <= f2) {
            f2 = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f2 = -f2;
        }
        this.f17387u = true;
        this.f17385s.j(this.f17386t, xVelocity, f2);
        this.f17387u = false;
        if (this.f17369a == 1) {
            p(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.android.gms.internal.mlkit_vision_barcode.sf] */
    public final void m(float f2, float f10, int i3) {
        boolean c9 = c(f2, f10, i3, 1);
        boolean z5 = c9;
        if (c(f10, f2, i3, 4)) {
            z5 = (c9 ? 1 : 0) | 4;
        }
        boolean z6 = z5;
        if (c(f2, f10, i3, 2)) {
            z6 = (z5 ? 1 : 0) | 2;
        }
        ?? r02 = z6;
        if (c(f10, f2, i3, 8)) {
            r02 = (z6 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f17376i;
            iArr[i3] = iArr[i3] | r02;
            this.f17385s.e(r02, i3);
        }
    }

    public final void n(float f2, float f10, int i3) {
        float[] fArr = this.f17372d;
        if (fArr == null || fArr.length <= i3) {
            int i10 = i3 + 1;
            float[] fArr2 = new float[i10];
            float[] fArr3 = new float[i10];
            float[] fArr4 = new float[i10];
            float[] fArr5 = new float[i10];
            int[] iArr = new int[i10];
            int[] iArr2 = new int[i10];
            int[] iArr3 = new int[i10];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f17373f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f17374g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f17375h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f17376i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f17377j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f17372d = fArr2;
            this.e = fArr3;
            this.f17373f = fArr4;
            this.f17374g = fArr5;
            this.f17375h = iArr;
            this.f17376i = iArr2;
            this.f17377j = iArr3;
        }
        float[] fArr9 = this.f17372d;
        this.f17373f[i3] = f2;
        fArr9[i3] = f2;
        float[] fArr10 = this.e;
        this.f17374g[i3] = f10;
        fArr10[i3] = f10;
        int[] iArr7 = this.f17375h;
        int i11 = (int) f2;
        int i12 = (int) f10;
        ViewGroup viewGroup = this.f17388v;
        int i13 = i11 < viewGroup.getLeft() + this.f17382o ? 1 : 0;
        if (i12 < viewGroup.getTop() + this.f17382o) {
            i13 |= 4;
        }
        if (i11 > viewGroup.getRight() - this.f17382o) {
            i13 |= 2;
        }
        if (i12 > viewGroup.getBottom() - this.f17382o) {
            i13 |= 8;
        }
        iArr7[i3] = i13;
        this.f17378k |= 1 << i3;
    }

    public final void o(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (j(pointerId)) {
                float x10 = motionEvent.getX(i3);
                float y4 = motionEvent.getY(i3);
                this.f17373f[pointerId] = x10;
                this.f17374g[pointerId] = y4;
            }
        }
    }

    public final void p(int i3) {
        this.f17388v.removeCallbacks(this.f17389w);
        if (this.f17369a != i3) {
            this.f17369a = i3;
            this.f17385s.h(i3);
            if (this.f17369a == 0) {
                this.f17386t = null;
            }
        }
    }

    public final boolean q(int i3, int i10) {
        if (this.f17387u) {
            return i(i3, i10, (int) this.f17379l.getXVelocity(this.f17371c), (int) this.f17379l.getYVelocity(this.f17371c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d4, code lost:
    
        if (r13 != r12) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.d.r(android.view.MotionEvent):boolean");
    }

    public final boolean s(View view, int i3, int i10) {
        this.f17386t = view;
        this.f17371c = -1;
        boolean i11 = i(i3, i10, 0, 0);
        if (!i11 && this.f17369a == 0 && this.f17386t != null) {
            this.f17386t = null;
        }
        return i11;
    }

    public final boolean t(int i3, View view) {
        if (view == this.f17386t && this.f17371c == i3) {
            return true;
        }
        if (view == null || !this.f17385s.k(i3, view)) {
            return false;
        }
        this.f17371c = i3;
        b(i3, view);
        return true;
    }
}
