package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.helper.widget.MotionEffect;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.widget.NestedScrollView;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.g0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import l1.u;
import p0.e;
import q0.f;
import u0.l;
import u0.n;
import u0.o;
import u0.p;
import u0.q;
import u0.r;
import u0.s;
import u0.v;
import u0.w;
import u0.x;
import w0.g;
import w0.h;
import w0.t;

/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements u {

    /* renamed from: q1, reason: collision with root package name */
    public static boolean f1692q1;
    public int A;
    public boolean B;
    public final HashMap C;
    public long D;
    public float E;
    public float F;
    public float G;
    public long H;
    public float I;
    public boolean J;
    public boolean K;
    public u0.u L;
    public int M;
    public r N;
    public boolean O;
    public final t0.a P;
    public final q Q;
    public u0.a R;
    public int S;
    public int T;
    public boolean U;
    public float U0;
    public float V;
    public boolean V0;
    public float W;
    public int W0;
    public int X0;
    public int Y0;
    public int Z0;

    /* renamed from: a0, reason: collision with root package name */
    public long f1693a0;

    /* renamed from: a1, reason: collision with root package name */
    public int f1694a1;

    /* renamed from: b0, reason: collision with root package name */
    public float f1695b0;

    /* renamed from: b1, reason: collision with root package name */
    public int f1696b1;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f1697c0;

    /* renamed from: c1, reason: collision with root package name */
    public float f1698c1;

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList f1699d0;

    /* renamed from: d1, reason: collision with root package name */
    public final e f1700d1;

    /* renamed from: e0, reason: collision with root package name */
    public ArrayList f1701e0;

    /* renamed from: e1, reason: collision with root package name */
    public boolean f1702e1;

    /* renamed from: f0, reason: collision with root package name */
    public ArrayList f1703f0;
    public b f1;

    /* renamed from: g0, reason: collision with root package name */
    public CopyOnWriteArrayList f1704g0;

    /* renamed from: g1, reason: collision with root package name */
    public n5.a f1705g1;

    /* renamed from: h0, reason: collision with root package name */
    public int f1706h0;

    /* renamed from: h1, reason: collision with root package name */
    public final Rect f1707h1;
    public long i0;

    /* renamed from: i1, reason: collision with root package name */
    public boolean f1708i1;

    /* renamed from: j0, reason: collision with root package name */
    public float f1709j0;

    /* renamed from: j1, reason: collision with root package name */
    public TransitionState f1710j1;

    /* renamed from: k0, reason: collision with root package name */
    public int f1711k0;

    /* renamed from: k1, reason: collision with root package name */
    public final s f1712k1;

    /* renamed from: l1, reason: collision with root package name */
    public boolean f1713l1;

    /* renamed from: m1, reason: collision with root package name */
    public final RectF f1714m1;

    /* renamed from: n1, reason: collision with root package name */
    public View f1715n1;

    /* renamed from: o1, reason: collision with root package name */
    public Matrix f1716o1;

    /* renamed from: p1, reason: collision with root package name */
    public final ArrayList f1717p1;

    /* renamed from: s, reason: collision with root package name */
    public c f1718s;

    /* renamed from: t, reason: collision with root package name */
    public o f1719t;

    /* renamed from: u, reason: collision with root package name */
    public Interpolator f1720u;

    /* renamed from: v, reason: collision with root package name */
    public float f1721v;

    /* renamed from: w, reason: collision with root package name */
    public int f1722w;

    /* renamed from: x, reason: collision with root package name */
    public int f1723x;

    /* renamed from: y, reason: collision with root package name */
    public int f1724y;

    /* renamed from: z, reason: collision with root package name */
    public int f1725z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TransitionState {
        public static final TransitionState FINISHED;
        public static final TransitionState MOVING;
        public static final TransitionState SETUP;
        public static final TransitionState UNDEFINED;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TransitionState[] f1726a;

        static {
            TransitionState transitionState = new TransitionState("UNDEFINED", 0);
            UNDEFINED = transitionState;
            TransitionState transitionState2 = new TransitionState("SETUP", 1);
            SETUP = transitionState2;
            TransitionState transitionState3 = new TransitionState("MOVING", 2);
            MOVING = transitionState3;
            TransitionState transitionState4 = new TransitionState("FINISHED", 3);
            FINISHED = transitionState4;
            f1726a = new TransitionState[]{transitionState, transitionState2, transitionState3, transitionState4};
        }

        public static TransitionState valueOf(String str) {
            return (TransitionState) Enum.valueOf(TransitionState.class, str);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) f1726a.clone();
        }
    }

    public MotionLayout(Context context) {
        super(context);
        this.f1720u = null;
        this.f1721v = 0.0f;
        this.f1722w = -1;
        this.f1723x = -1;
        this.f1724y = -1;
        this.f1725z = 0;
        this.A = 0;
        this.B = true;
        this.C = new HashMap();
        this.D = 0L;
        this.E = 1.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.I = 0.0f;
        this.K = false;
        this.M = 0;
        this.O = false;
        this.P = new t0.a();
        this.Q = new q(this);
        this.U = false;
        this.f1697c0 = false;
        this.f1699d0 = null;
        this.f1701e0 = null;
        this.f1703f0 = null;
        this.f1704g0 = null;
        this.f1706h0 = 0;
        this.i0 = -1L;
        this.f1709j0 = 0.0f;
        this.f1711k0 = 0;
        this.U0 = 0.0f;
        this.V0 = false;
        this.f1700d1 = new e(1);
        this.f1702e1 = false;
        this.f1705g1 = null;
        new HashMap();
        this.f1707h1 = new Rect();
        this.f1708i1 = false;
        this.f1710j1 = TransitionState.UNDEFINED;
        this.f1712k1 = new s(this);
        this.f1713l1 = false;
        this.f1714m1 = new RectF();
        this.f1715n1 = null;
        this.f1716o1 = null;
        this.f1717p1 = new ArrayList();
        y(null);
    }

    public static Rect p(MotionLayout motionLayout, f fVar) {
        int q5 = fVar.q();
        Rect rect = motionLayout.f1707h1;
        rect.top = q5;
        rect.left = fVar.p();
        rect.right = fVar.o() + rect.left;
        rect.bottom = fVar.l() + rect.top;
        return rect;
    }

    public final void A() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (this.L == null && ((copyOnWriteArrayList = this.f1704g0) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        ArrayList arrayList = this.f1717p1;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Integer num = (Integer) obj;
            u0.u uVar = this.L;
            if (uVar != null) {
                uVar.a(num.intValue());
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.f1704g0;
            if (copyOnWriteArrayList2 != null) {
                Iterator it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    ((u0.u) it.next()).a(num.intValue());
                }
            }
        }
        arrayList.clear();
    }

    public final void B() {
        this.f1712k1.f();
        invalidate();
    }

    public final void C(float f2, float f10) {
        if (!super.isAttachedToWindow()) {
            if (this.f1 == null) {
                this.f1 = new b(this);
            }
            b bVar = this.f1;
            bVar.f1728a = f2;
            bVar.f1729b = f10;
            return;
        }
        setProgress(f2);
        setState(TransitionState.MOVING);
        this.f1721v = f10;
        if (f10 != 0.0f) {
            q(f10 > 0.0f ? 1.0f : 0.0f);
        } else {
            if (f2 == 0.0f || f2 == 1.0f) {
                return;
            }
            q(f2 > 0.5f ? 1.0f : 0.0f);
        }
    }

    public final void D(int i3) {
        setState(TransitionState.SETUP);
        this.f1723x = i3;
        this.f1722w = -1;
        this.f1724y = -1;
        he.b bVar = this.f1865k;
        if (bVar == null) {
            c cVar = this.f1718s;
            if (cVar != null) {
                cVar.b(i3).b(this);
                return;
            }
            return;
        }
        float f2 = -1;
        int i10 = bVar.f14314a;
        SparseArray sparseArray = (SparseArray) bVar.f14317d;
        int i11 = 0;
        ConstraintLayout constraintLayout = (ConstraintLayout) bVar.f14316c;
        if (i10 == i3) {
            g gVar = i3 == -1 ? (g) sparseArray.valueAt(0) : (g) sparseArray.get(i10);
            int i12 = bVar.f14315b;
            if (i12 == -1 || !((h) gVar.f19341b.get(i12)).a(f2, f2)) {
                while (true) {
                    ArrayList arrayList = gVar.f19341b;
                    if (i11 >= arrayList.size()) {
                        i11 = -1;
                        break;
                    } else if (((h) arrayList.get(i11)).a(f2, f2)) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (bVar.f14315b == i11) {
                    return;
                }
                ArrayList arrayList2 = gVar.f19341b;
                w0.o oVar = i11 == -1 ? null : ((h) arrayList2.get(i11)).f19348f;
                if (i11 != -1) {
                    int i13 = ((h) arrayList2.get(i11)).e;
                }
                if (oVar == null) {
                    return;
                }
                bVar.f14315b = i11;
                oVar.b(constraintLayout);
                return;
            }
            return;
        }
        bVar.f14314a = i3;
        g gVar2 = (g) sparseArray.get(i3);
        while (true) {
            ArrayList arrayList3 = gVar2.f19341b;
            if (i11 >= arrayList3.size()) {
                i11 = -1;
                break;
            } else if (((h) arrayList3.get(i11)).a(f2, f2)) {
                break;
            } else {
                i11++;
            }
        }
        ArrayList arrayList4 = gVar2.f19341b;
        w0.o oVar2 = i11 == -1 ? gVar2.f19343d : ((h) arrayList4.get(i11)).f19348f;
        if (i11 != -1) {
            int i14 = ((h) arrayList4.get(i11)).e;
        }
        if (oVar2 != null) {
            bVar.f14315b = i11;
            oVar2.b(constraintLayout);
            return;
        }
        StringBuilder sb2 = new StringBuilder(79);
        sb2.append("NO Constraint set found ! id=");
        sb2.append(i3);
        sb2.append(", dim =-1.0, -1.0");
        Log.v("ConstraintLayoutStates", sb2.toString());
    }

    public final void E(int i3, int i10) {
        if (!super.isAttachedToWindow()) {
            if (this.f1 == null) {
                this.f1 = new b(this);
            }
            b bVar = this.f1;
            bVar.f1730c = i3;
            bVar.f1731d = i10;
            return;
        }
        c cVar = this.f1718s;
        if (cVar != null) {
            this.f1722w = i3;
            this.f1724y = i10;
            cVar.n(i3, i10);
            this.f1712k1.e(this.f1718s.b(i3), this.f1718s.b(i10));
            B();
            this.G = 0.0f;
            q(0.0f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        if (r16 != 7) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        if ((((r15 * r4) - (((r1 * r4) * r4) / 2.0f)) + r0) > 1.0f) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
    
        r1 = r13.G;
        r4 = r13.E;
        r5 = r13.f1718s.g();
        r0 = r13.f1718s.f1734c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008e, code lost:
    
        if (r0 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
    
        r0 = r0.f18793l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
    
        if (r0 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0094, code lost:
    
        r6 = r0.f1765s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0099, code lost:
    
        r13.P.b(r1, r14, r15, r4, r5, r6);
        r13.f1721v = 0.0f;
        r0 = r13.f1723x;
        r13.I = r14;
        r13.f1723x = r0;
        r13.f1719t = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
    
        r6 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        r14 = r13.G;
        r0 = r13.f1718s.g();
        r11.f18739a = r15;
        r11.f18740b = r14;
        r11.f18741c = r0;
        r13.f1719t = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        if ((((((r1 * r2) * r2) / 2.0f) + (r15 * r2)) + r0) < 0.0f) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(float r14, float r15, int r16) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.F(float, float, int):void");
    }

    public final void G(int i3) {
        d6.a aVar;
        if (!super.isAttachedToWindow()) {
            if (this.f1 == null) {
                this.f1 = new b(this);
            }
            this.f1.f1731d = i3;
            return;
        }
        c cVar = this.f1718s;
        if (cVar != null && (aVar = cVar.f1733b) != null) {
            int i10 = this.f1723x;
            float f2 = -1;
            t tVar = (t) ((SparseArray) aVar.f12306b).get(i3);
            if (tVar == null) {
                i10 = i3;
            } else {
                ArrayList arrayList = tVar.f19457b;
                int i11 = tVar.f19458c;
                if (f2 != -1.0f && f2 != -1.0f) {
                    int size = arrayList.size();
                    w0.u uVar = null;
                    int i12 = 0;
                    while (true) {
                        if (i12 < size) {
                            Object obj = arrayList.get(i12);
                            i12++;
                            w0.u uVar2 = (w0.u) obj;
                            if (uVar2.a(f2, f2)) {
                                if (i10 == uVar2.e) {
                                    break;
                                } else {
                                    uVar = uVar2;
                                }
                            }
                        } else if (uVar != null) {
                            i10 = uVar.e;
                        }
                    }
                } else if (i11 != i10) {
                    int size2 = arrayList.size();
                    int i13 = 0;
                    while (i13 < size2) {
                        Object obj2 = arrayList.get(i13);
                        i13++;
                        if (i10 == ((w0.u) obj2).e) {
                            break;
                        }
                    }
                    i10 = i11;
                }
            }
            if (i10 != -1) {
                i3 = i10;
            }
        }
        int i14 = this.f1723x;
        if (i14 == i3) {
            return;
        }
        if (this.f1722w == i3) {
            q(0.0f);
            return;
        }
        if (this.f1724y == i3) {
            q(1.0f);
            return;
        }
        this.f1724y = i3;
        if (i14 != -1) {
            E(i14, i3);
            q(1.0f);
            this.G = 0.0f;
            q(1.0f);
            this.f1705g1 = null;
            return;
        }
        this.O = false;
        this.I = 1.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = getNanoTime();
        this.D = getNanoTime();
        this.J = false;
        this.f1719t = null;
        this.E = this.f1718s.c() / 1000.0f;
        this.f1722w = -1;
        this.f1718s.n(-1, this.f1724y);
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        HashMap hashMap = this.C;
        hashMap.clear();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            hashMap.put(childAt, new n(childAt));
            sparseArray.put(childAt.getId(), (n) hashMap.get(childAt));
        }
        this.K = true;
        w0.o b3 = this.f1718s.b(i3);
        s sVar = this.f1712k1;
        sVar.e(null, b3);
        B();
        sVar.a();
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            View childAt2 = getChildAt(i16);
            n nVar = (n) hashMap.get(childAt2);
            if (nVar != null) {
                v vVar = nVar.f18717f;
                vVar.f18766c = 0.0f;
                vVar.f18767d = 0.0f;
                vVar.d(childAt2.getX(), childAt2.getY(), childAt2.getWidth(), childAt2.getHeight());
                l lVar = nVar.f18719h;
                lVar.getClass();
                childAt2.getX();
                childAt2.getY();
                childAt2.getWidth();
                childAt2.getHeight();
                lVar.f18697c = childAt2.getVisibility();
                lVar.f18695a = childAt2.getVisibility() != 0 ? 0.0f : childAt2.getAlpha();
                lVar.f18698d = childAt2.getElevation();
                lVar.e = childAt2.getRotation();
                lVar.f18699f = childAt2.getRotationX();
                lVar.f18700g = childAt2.getRotationY();
                lVar.f18701h = childAt2.getScaleX();
                lVar.f18702i = childAt2.getScaleY();
                lVar.f18703j = childAt2.getPivotX();
                lVar.f18704k = childAt2.getPivotY();
                lVar.f18705l = childAt2.getTranslationX();
                lVar.f18706m = childAt2.getTranslationY();
                lVar.f18707n = childAt2.getTranslationZ();
            }
        }
        int width = getWidth();
        int height = getHeight();
        if (this.f1703f0 != null) {
            for (int i17 = 0; i17 < childCount; i17++) {
                n nVar2 = (n) hashMap.get(getChildAt(i17));
                if (nVar2 != null) {
                    this.f1718s.f(nVar2);
                }
            }
            ArrayList arrayList2 = this.f1703f0;
            int size3 = arrayList2.size();
            int i18 = 0;
            while (i18 < size3) {
                Object obj3 = arrayList2.get(i18);
                i18++;
                ((MotionHelper) obj3).r(this, hashMap);
            }
            for (int i19 = 0; i19 < childCount; i19++) {
                n nVar3 = (n) hashMap.get(getChildAt(i19));
                if (nVar3 != null) {
                    nVar3.h(width, height, getNanoTime());
                }
            }
        } else {
            for (int i20 = 0; i20 < childCount; i20++) {
                n nVar4 = (n) hashMap.get(getChildAt(i20));
                if (nVar4 != null) {
                    this.f1718s.f(nVar4);
                    nVar4.h(width, height, getNanoTime());
                }
            }
        }
        x xVar = this.f1718s.f1734c;
        float f10 = xVar != null ? xVar.f18790i : 0.0f;
        if (f10 != 0.0f) {
            float f11 = Float.MAX_VALUE;
            float f12 = -3.4028235E38f;
            for (int i21 = 0; i21 < childCount; i21++) {
                v vVar2 = ((n) hashMap.get(getChildAt(i21))).f18718g;
                float f13 = vVar2.f18768f + vVar2.e;
                f11 = Math.min(f11, f13);
                f12 = Math.max(f12, f13);
            }
            for (int i22 = 0; i22 < childCount; i22++) {
                n nVar5 = (n) hashMap.get(getChildAt(i22));
                v vVar3 = nVar5.f18718g;
                float f14 = vVar3.e;
                float f15 = vVar3.f18768f;
                nVar5.f18725n = 1.0f / (1.0f - f10);
                nVar5.f18724m = f10 - ((((f14 + f15) - f11) * f10) / (f12 - f11));
            }
        }
        this.F = 0.0f;
        this.G = 0.0f;
        this.K = true;
        invalidate();
    }

    public final void H(int i3, w0.o oVar) {
        c cVar = this.f1718s;
        if (cVar != null) {
            cVar.f1737g.put(i3, oVar);
        }
        this.f1712k1.e(this.f1718s.b(this.f1722w), this.f1718s.b(this.f1724y));
        B();
        if (this.f1723x == i3) {
            oVar.b(this);
        }
    }

    @Override // l1.t
    public final void a(View view, View view2, int i3, int i10) {
        this.f1693a0 = getNanoTime();
        this.f1695b0 = 0.0f;
        this.V = 0.0f;
        this.W = 0.0f;
    }

    @Override // l1.t
    public final void b(View view, int i3, int i10, int[] iArr, int i11) {
        x xVar;
        boolean z5;
        float f2;
        d dVar;
        float f10;
        d dVar2;
        d dVar3;
        d dVar4;
        int i12;
        c cVar = this.f1718s;
        if (cVar == null || (xVar = cVar.f1734c) == null || (z5 = xVar.f18796o)) {
            return;
        }
        int i13 = -1;
        if (z5 || (dVar4 = xVar.f18793l) == null || (i12 = dVar4.e) == -1 || view.getId() == i12) {
            x xVar2 = cVar.f1734c;
            if ((xVar2 == null || (dVar3 = xVar2.f18793l) == null) ? false : dVar3.f1767u) {
                d dVar5 = xVar.f18793l;
                if (dVar5 != null && (dVar5.f1769w & 4) != 0) {
                    i13 = i10;
                }
                float f11 = this.F;
                if ((f11 == 1.0f || f11 == 0.0f) && view.canScrollVertically(i13)) {
                    return;
                }
            }
            d dVar6 = xVar.f18793l;
            if (dVar6 == null || (dVar6.f1769w & 1) == 0) {
                f2 = 0.0f;
            } else {
                float f12 = i3;
                float f13 = i10;
                x xVar3 = cVar.f1734c;
                if (xVar3 == null || (dVar2 = xVar3.f18793l) == null) {
                    f2 = 0.0f;
                    f10 = 0.0f;
                } else {
                    f2 = 0.0f;
                    dVar2.r.v(dVar2.f1752d, dVar2.r.getProgress(), dVar2.f1755h, dVar2.f1754g, dVar2.f1761n);
                    float f14 = dVar2.f1758k;
                    float[] fArr = dVar2.f1761n;
                    if (f14 != 0.0f) {
                        if (fArr[0] == 0.0f) {
                            fArr[0] = 1.0E-7f;
                        }
                        f10 = (f12 * f14) / fArr[0];
                    } else {
                        if (fArr[1] == 0.0f) {
                            fArr[1] = 1.0E-7f;
                        }
                        f10 = (f13 * dVar2.f1759l) / fArr[1];
                    }
                }
                float f15 = this.G;
                if ((f15 <= f2 && f10 < f2) || (f15 >= 1.0f && f10 > f2)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new p((ViewGroup) view, 0));
                    return;
                }
            }
            float f16 = this.F;
            long nanoTime = getNanoTime();
            float f17 = i3;
            this.V = f17;
            float f18 = i10;
            this.W = f18;
            this.f1695b0 = (float) ((nanoTime - this.f1693a0) * 1.0E-9d);
            this.f1693a0 = nanoTime;
            x xVar4 = cVar.f1734c;
            if (xVar4 != null && (dVar = xVar4.f18793l) != null) {
                MotionLayout motionLayout = dVar.r;
                float progress = motionLayout.getProgress();
                if (!dVar.f1760m) {
                    dVar.f1760m = true;
                    motionLayout.setProgress(progress);
                }
                dVar.r.v(dVar.f1752d, progress, dVar.f1755h, dVar.f1754g, dVar.f1761n);
                float f19 = dVar.f1758k;
                float[] fArr2 = dVar.f1761n;
                if (Math.abs((dVar.f1759l * fArr2[1]) + (f19 * fArr2[0])) < 0.01d) {
                    fArr2[0] = 0.01f;
                    fArr2[1] = 0.01f;
                }
                float f20 = dVar.f1758k;
                float max = Math.max(Math.min(progress + (f20 != f2 ? (f17 * f20) / fArr2[0] : (f18 * dVar.f1759l) / fArr2[1]), 1.0f), f2);
                if (max != motionLayout.getProgress()) {
                    motionLayout.setProgress(max);
                }
            }
            if (f16 != this.F) {
                iArr[0] = i3;
                iArr[1] = i10;
            }
            s(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.U = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0586 A[ORIG_RETURN, RETURN] */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchDraw(android.graphics.Canvas r39) {
        /*
            Method dump skipped, instructions count: 1415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    @Override // l1.t
    public final void f(int i3, View view) {
        d dVar;
        c cVar = this.f1718s;
        if (cVar != null) {
            float f2 = this.f1695b0;
            if (f2 == 0.0f) {
                return;
            }
            float f10 = this.V / f2;
            float f11 = this.W / f2;
            x xVar = cVar.f1734c;
            if (xVar == null || (dVar = xVar.f18793l) == null) {
                return;
            }
            dVar.f1760m = false;
            MotionLayout motionLayout = dVar.r;
            float progress = motionLayout.getProgress();
            dVar.r.v(dVar.f1752d, progress, dVar.f1755h, dVar.f1754g, dVar.f1761n);
            float f12 = dVar.f1758k;
            float[] fArr = dVar.f1761n;
            float f13 = f12 != 0.0f ? (f10 * f12) / fArr[0] : (f11 * dVar.f1759l) / fArr[1];
            if (!Float.isNaN(f13)) {
                progress += f13 / 3.0f;
            }
            if (progress != 0.0f) {
                boolean z5 = progress != 1.0f;
                int i10 = dVar.f1751c;
                if ((i10 != 3) && z5) {
                    motionLayout.F(((double) progress) >= 0.5d ? 1.0f : 0.0f, f13, i10);
                }
            }
        }
    }

    @Override // l1.u
    public final void g(View view, int i3, int i10, int i11, int i12, int i13, int[] iArr) {
        if (this.U || i3 != 0 || i10 != 0) {
            iArr[0] = iArr[0] + i11;
            iArr[1] = iArr[1] + i12;
        }
        this.U = false;
    }

    public int[] getConstraintSetIds() {
        c cVar = this.f1718s;
        if (cVar == null) {
            return null;
        }
        SparseArray sparseArray = cVar.f1737g;
        int size = sparseArray.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = sparseArray.keyAt(i3);
        }
        return iArr;
    }

    public int getCurrentState() {
        return this.f1723x;
    }

    public ArrayList<x> getDefinedTransitions() {
        c cVar = this.f1718s;
        if (cVar == null) {
            return null;
        }
        return cVar.f1735d;
    }

    public u0.a getDesignTool() {
        if (this.R == null) {
            this.R = new u0.a();
        }
        return this.R;
    }

    public int getEndState() {
        return this.f1724y;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.G;
    }

    public c getScene() {
        return this.f1718s;
    }

    public int getStartState() {
        return this.f1722w;
    }

    public float getTargetPosition() {
        return this.I;
    }

    public Bundle getTransitionState() {
        if (this.f1 == null) {
            this.f1 = new b(this);
        }
        b bVar = this.f1;
        MotionLayout motionLayout = bVar.e;
        bVar.f1731d = motionLayout.f1724y;
        bVar.f1730c = motionLayout.f1722w;
        bVar.f1729b = motionLayout.getVelocity();
        bVar.f1728a = motionLayout.getProgress();
        b bVar2 = this.f1;
        bVar2.getClass();
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", bVar2.f1728a);
        bundle.putFloat("motion.velocity", bVar2.f1729b);
        bundle.putInt("motion.StartState", bVar2.f1730c);
        bundle.putInt("motion.EndState", bVar2.f1731d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        if (this.f1718s != null) {
            this.E = r0.c() / 1000.0f;
        }
        return (long) (this.E * 1000.0f);
    }

    public float getVelocity() {
        return this.f1721v;
    }

    @Override // l1.t
    public final void i(View view, int i3, int i10, int i11, int i12, int i13) {
    }

    @Override // l1.t
    public final boolean j(View view, View view2, int i3, int i10) {
        x xVar;
        d dVar;
        c cVar = this.f1718s;
        return (cVar == null || (xVar = cVar.f1734c) == null || (dVar = xVar.f18793l) == null || (dVar.f1769w & 2) != 0) ? false : true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public final void l(int i3) {
        this.f1865k = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        x xVar;
        int i3;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            display.getRotation();
        }
        c cVar = this.f1718s;
        if (cVar != null && (i3 = this.f1723x) != -1) {
            w0.o b3 = cVar.b(i3);
            c cVar2 = this.f1718s;
            int i10 = 0;
            int i11 = 0;
            loop0: while (true) {
                SparseArray sparseArray = cVar2.f1737g;
                if (i11 >= sparseArray.size()) {
                    break;
                }
                int keyAt = sparseArray.keyAt(i11);
                SparseIntArray sparseIntArray = cVar2.f1739i;
                int i12 = sparseIntArray.get(keyAt);
                int size = sparseIntArray.size();
                while (i12 > 0) {
                    if (i12 == keyAt) {
                        break loop0;
                    }
                    int i13 = size - 1;
                    if (size < 0) {
                        break loop0;
                    }
                    i12 = sparseIntArray.get(i12);
                    size = i13;
                }
                cVar2.m(keyAt, this);
                i11++;
            }
            Log.e("MotionScene", "Cannot be derived from yourself");
            ArrayList arrayList = this.f1703f0;
            if (arrayList != null) {
                int size2 = arrayList.size();
                while (i10 < size2) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((MotionHelper) obj).getClass();
                }
            }
            if (b3 != null) {
                b3.b(this);
            }
            this.f1722w = this.f1723x;
        }
        z();
        b bVar = this.f1;
        if (bVar != null) {
            if (this.f1708i1) {
                post(new p(this, 1));
                return;
            } else {
                bVar.a();
                return;
            }
        }
        c cVar3 = this.f1718s;
        if (cVar3 == null || (xVar = cVar3.f1734c) == null || xVar.f18795n != 4) {
            return;
        }
        q(1.0f);
        this.f1705g1 = null;
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r27) {
        /*
            Method dump skipped, instructions count: 1226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        MotionLayout motionLayout;
        this.f1702e1 = true;
        try {
            if (this.f1718s == null) {
                super.onLayout(z5, i3, i10, i11, i12);
                this.f1702e1 = false;
                return;
            }
            motionLayout = this;
            int i13 = i11 - i3;
            int i14 = i12 - i10;
            try {
                if (motionLayout.S == i13) {
                    if (motionLayout.T != i14) {
                    }
                    motionLayout.S = i13;
                    motionLayout.T = i14;
                    motionLayout.f1702e1 = false;
                }
                B();
                s(true);
                motionLayout.S = i13;
                motionLayout.T = i14;
                motionLayout.f1702e1 = false;
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                motionLayout.f1702e1 = false;
                throw th3;
            }
        } catch (Throwable th4) {
            th = th4;
            motionLayout = this;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        boolean z5;
        if (this.f1718s == null) {
            super.onMeasure(i3, i10);
            return;
        }
        boolean z6 = true;
        boolean z8 = (this.f1725z == i3 && this.A == i10) ? false : true;
        if (this.f1713l1) {
            this.f1713l1 = false;
            z();
            A();
            z8 = true;
        }
        if (this.f1862h) {
            z8 = true;
        }
        this.f1725z = i3;
        this.A = i10;
        int h4 = this.f1718s.h();
        x xVar = this.f1718s.f1734c;
        int i11 = xVar == null ? -1 : xVar.f18785c;
        q0.g gVar = this.f1858c;
        s sVar = this.f1712k1;
        if ((!z8 && h4 == sVar.e && i11 == sVar.f18760f) || this.f1722w == -1) {
            if (z8) {
                super.onMeasure(i3, i10);
            }
            z5 = true;
        } else {
            super.onMeasure(i3, i10);
            sVar.e(this.f1718s.b(h4), this.f1718s.b(i11));
            sVar.f();
            sVar.e = h4;
            sVar.f18760f = i11;
            z5 = false;
        }
        if (this.V0 || z5) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int o3 = gVar.o() + getPaddingRight() + getPaddingLeft();
            int l3 = gVar.l() + paddingBottom;
            int i12 = this.f1694a1;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                o3 = (int) ((this.f1698c1 * (this.Y0 - r1)) + this.W0);
                requestLayout();
            }
            int i13 = this.f1696b1;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                l3 = (int) ((this.f1698c1 * (this.Z0 - r2)) + this.X0);
                requestLayout();
            }
            setMeasuredDimension(o3, l3);
        }
        float signum = Math.signum(this.I - this.G);
        long nanoTime = getNanoTime();
        o oVar = this.f1719t;
        float f2 = this.G + (!(oVar instanceof t0.a) ? (((nanoTime - this.H) * signum) * 1.0E-9f) / this.E : 0.0f);
        if (this.J) {
            f2 = this.I;
        }
        if ((signum <= 0.0f || f2 < this.I) && (signum > 0.0f || f2 > this.I)) {
            z6 = false;
        } else {
            f2 = this.I;
        }
        if (oVar != null && !z6) {
            f2 = this.O ? oVar.getInterpolation((nanoTime - this.D) * 1.0E-9f) : oVar.getInterpolation(f2);
        }
        if ((signum > 0.0f && f2 >= this.I) || (signum <= 0.0f && f2 <= this.I)) {
            f2 = this.I;
        }
        this.f1698c1 = f2;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator = this.f1720u;
        if (interpolator != null) {
            f2 = interpolator.getInterpolation(f2);
        }
        float f10 = f2;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            n nVar = (n) this.C.get(childAt);
            if (nVar != null) {
                nVar.e(f10, nanoTime2, childAt, this.f1700d1);
            }
        }
        if (this.V0) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f10, boolean z5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f10) {
        return false;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i3) {
        d dVar;
        c cVar = this.f1718s;
        if (cVar != null) {
            boolean k10 = k();
            cVar.f1746p = k10;
            x xVar = cVar.f1734c;
            if (xVar == null || (dVar = xVar.f18793l) == null) {
                return;
            }
            dVar.c(k10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0814  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0819 A[RETURN] */
    /* JADX WARN: Type inference failed for: r19v15 */
    /* JADX WARN: Type inference failed for: r19v20 */
    /* JADX WARN: Type inference failed for: r19v21 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r39) {
        /*
            Method dump skipped, instructions count: 2081
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f1704g0 == null) {
                this.f1704g0 = new CopyOnWriteArrayList();
            }
            this.f1704g0.add(motionHelper);
            if (motionHelper.f1688i) {
                if (this.f1699d0 == null) {
                    this.f1699d0 = new ArrayList();
                }
                this.f1699d0.add(motionHelper);
            }
            if (motionHelper.f1689j) {
                if (this.f1701e0 == null) {
                    this.f1701e0 = new ArrayList();
                }
                this.f1701e0.add(motionHelper);
            }
            if (motionHelper instanceof MotionEffect) {
                if (this.f1703f0 == null) {
                    this.f1703f0 = new ArrayList();
                }
                this.f1703f0.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.f1699d0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.f1701e0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public final void q(float f2) {
        if (this.f1718s == null) {
            return;
        }
        float f10 = this.G;
        float f11 = this.F;
        if (f10 != f11 && this.J) {
            this.G = f11;
        }
        float f12 = this.G;
        if (f12 == f2) {
            return;
        }
        this.O = false;
        this.I = f2;
        this.E = r0.c() / 1000.0f;
        setProgress(this.I);
        this.f1719t = null;
        this.f1720u = this.f1718s.e();
        this.J = false;
        this.D = getNanoTime();
        this.K = true;
        this.F = f12;
        this.G = f12;
        invalidate();
    }

    public final void r() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            n nVar = (n) this.C.get(getChildAt(i3));
            if (nVar != null) {
                "button".equals(g0.d(nVar.f18714b));
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        c cVar;
        x xVar;
        if (!this.V0 && this.f1723x == -1 && (cVar = this.f1718s) != null && (xVar = cVar.f1734c) != null) {
            int i3 = xVar.f18798q;
            if (i3 == 0) {
                return;
            }
            if (i3 == 2) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    ((n) this.C.get(getChildAt(i10))).f18716d = true;
                }
                return;
            }
        }
        super.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(boolean r21) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.s(boolean):void");
    }

    public void setDebugMode(int i3) {
        this.M = i3;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z5) {
        this.f1708i1 = z5;
    }

    public void setInteractionEnabled(boolean z5) {
        this.B = z5;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.f1718s != null) {
            setState(TransitionState.MOVING);
            Interpolator e = this.f1718s.e();
            if (e != null) {
                setProgress(e.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList arrayList = this.f1701e0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((MotionHelper) this.f1701e0.get(i3)).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList arrayList = this.f1699d0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((MotionHelper) this.f1699d0.get(i3)).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!super.isAttachedToWindow()) {
            if (this.f1 == null) {
                this.f1 = new b(this);
            }
            this.f1.f1728a = f2;
            return;
        }
        if (f2 <= 0.0f) {
            if (this.G == 1.0f && this.f1723x == this.f1724y) {
                setState(TransitionState.MOVING);
            }
            this.f1723x = this.f1722w;
            if (this.G == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f2 >= 1.0f) {
            if (this.G == 0.0f && this.f1723x == this.f1722w) {
                setState(TransitionState.MOVING);
            }
            this.f1723x = this.f1724y;
            if (this.G == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.f1723x = -1;
            setState(TransitionState.MOVING);
        }
        if (this.f1718s == null) {
            return;
        }
        this.J = true;
        this.I = f2;
        this.F = f2;
        this.H = -1L;
        this.D = -1L;
        this.f1719t = null;
        this.K = true;
        invalidate();
    }

    public void setScene(c cVar) {
        d dVar;
        this.f1718s = cVar;
        boolean k10 = k();
        cVar.f1746p = k10;
        x xVar = cVar.f1734c;
        if (xVar != null && (dVar = xVar.f18793l) != null) {
            dVar.c(k10);
        }
        B();
    }

    public void setStartState(int i3) {
        if (super.isAttachedToWindow()) {
            this.f1723x = i3;
            return;
        }
        if (this.f1 == null) {
            this.f1 = new b(this);
        }
        b bVar = this.f1;
        bVar.f1730c = i3;
        bVar.f1731d = i3;
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.f1723x == -1) {
            return;
        }
        TransitionState transitionState3 = this.f1710j1;
        this.f1710j1 = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            t();
        }
        int i3 = a.f1727a[transitionState3.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 && transitionState == transitionState2) {
                u();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            t();
        }
        if (transitionState == transitionState2) {
            u();
        }
    }

    public void setTransition(int i3) {
        if (this.f1718s != null) {
            x w8 = w(i3);
            this.f1722w = w8.f18786d;
            this.f1724y = w8.f18785c;
            if (!super.isAttachedToWindow()) {
                if (this.f1 == null) {
                    this.f1 = new b(this);
                }
                b bVar = this.f1;
                bVar.f1730c = this.f1722w;
                bVar.f1731d = this.f1724y;
                return;
            }
            int i10 = this.f1723x;
            float f2 = i10 == this.f1722w ? 0.0f : i10 == this.f1724y ? 1.0f : Float.NaN;
            c cVar = this.f1718s;
            cVar.f1734c = w8;
            d dVar = w8.f18793l;
            if (dVar != null) {
                dVar.c(cVar.f1746p);
            }
            this.f1712k1.e(this.f1718s.b(this.f1722w), this.f1718s.b(this.f1724y));
            B();
            if (this.G != f2) {
                if (f2 == 0.0f) {
                    r();
                    this.f1718s.b(this.f1722w).b(this);
                } else if (f2 == 1.0f) {
                    r();
                    this.f1718s.b(this.f1724y).b(this);
                }
            }
            this.G = Float.isNaN(f2) ? 0.0f : f2;
            if (!Float.isNaN(f2)) {
                setProgress(f2);
            } else {
                Log.v("MotionLayout", String.valueOf(g0.b()).concat(" transitionToStart "));
                q(0.0f);
            }
        }
    }

    public void setTransitionDuration(int i3) {
        c cVar = this.f1718s;
        if (cVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
            return;
        }
        x xVar = cVar.f1734c;
        if (xVar != null) {
            xVar.f18789h = Math.max(i3, 8);
        } else {
            cVar.f1740j = i3;
        }
    }

    public void setTransitionListener(u0.u uVar) {
        this.L = uVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f1 == null) {
            this.f1 = new b(this);
        }
        b bVar = this.f1;
        bVar.getClass();
        bVar.f1728a = bundle.getFloat("motion.progress");
        bVar.f1729b = bundle.getFloat("motion.velocity");
        bVar.f1730c = bundle.getInt("motion.StartState");
        bVar.f1731d = bundle.getInt("motion.EndState");
        if (super.isAttachedToWindow()) {
            this.f1.a();
        }
    }

    public final void t() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        if ((this.L == null && ((copyOnWriteArrayList2 = this.f1704g0) == null || copyOnWriteArrayList2.isEmpty())) || this.U0 == this.F) {
            return;
        }
        if (this.f1711k0 != -1 && (copyOnWriteArrayList = this.f1704g0) != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((u0.u) it.next()).getClass();
            }
        }
        this.f1711k0 = -1;
        this.U0 = this.F;
        CopyOnWriteArrayList copyOnWriteArrayList3 = this.f1704g0;
        if (copyOnWriteArrayList3 != null) {
            Iterator it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                ((u0.u) it2.next()).getClass();
            }
        }
    }

    @Override // android.view.View
    public final String toString() {
        Context context = getContext();
        String c9 = g0.c(context, this.f1722w);
        String c10 = g0.c(context, this.f1724y);
        float f2 = this.G;
        float f10 = this.f1721v;
        StringBuilder g10 = r5.a.g(r5.a.a(r5.a.a(47, c9), c10), c9, "->", c10, " (pos:");
        g10.append(f2);
        g10.append(" Dpos/Dt:");
        g10.append(f10);
        return g10.toString();
    }

    public final void u() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.L != null || ((copyOnWriteArrayList = this.f1704g0) != null && !copyOnWriteArrayList.isEmpty())) && this.f1711k0 == -1) {
            this.f1711k0 = this.f1723x;
            ArrayList arrayList = this.f1717p1;
            int intValue = !arrayList.isEmpty() ? ((Integer) l0.h(1, arrayList)).intValue() : -1;
            int i3 = this.f1723x;
            if (intValue != i3 && i3 != -1) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        A();
        n5.a aVar = this.f1705g1;
        if (aVar != null) {
            aVar.run();
        }
    }

    public final void v(int i3, float f2, float f10, float f11, float[] fArr) {
        String resourceName;
        View d5 = d(i3);
        n nVar = (n) this.C.get(d5);
        if (nVar != null) {
            nVar.d(f2, f10, f11, fArr);
            d5.getY();
            return;
        }
        if (d5 == null) {
            StringBuilder sb2 = new StringBuilder(11);
            sb2.append(i3);
            resourceName = sb2.toString();
        } else {
            resourceName = d5.getContext().getResources().getResourceName(i3);
        }
        String valueOf = String.valueOf(resourceName);
        Log.w("MotionLayout", valueOf.length() != 0 ? "WARNING could not find view id ".concat(valueOf) : new String("WARNING could not find view id "));
    }

    public final x w(int i3) {
        ArrayList arrayList = this.f1718s.f1735d;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            x xVar = (x) obj;
            if (xVar.f18783a == i3) {
                return xVar;
            }
        }
        return null;
    }

    public final boolean x(float f2, float f10, View view, MotionEvent motionEvent) {
        boolean z5;
        boolean onTouchEvent;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (x((r3.getLeft() + f2) - view.getScrollX(), (r3.getTop() + f10) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z5 = true;
                    break;
                }
            }
        }
        z5 = false;
        if (!z5) {
            RectF rectF = this.f1714m1;
            rectF.set(f2, f10, (view.getRight() + f2) - view.getLeft(), (view.getBottom() + f10) - view.getTop());
            if (motionEvent.getAction() != 0 || rectF.contains(motionEvent.getX(), motionEvent.getY())) {
                float f11 = -f2;
                float f12 = -f10;
                Matrix matrix = view.getMatrix();
                if (matrix.isIdentity()) {
                    motionEvent.offsetLocation(f11, f12);
                    onTouchEvent = view.onTouchEvent(motionEvent);
                    motionEvent.offsetLocation(-f11, -f12);
                } else {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(f11, f12);
                    if (this.f1716o1 == null) {
                        this.f1716o1 = new Matrix();
                    }
                    matrix.invert(this.f1716o1);
                    obtain.transform(this.f1716o1);
                    onTouchEvent = view.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (onTouchEvent) {
                    return true;
                }
            }
        }
        return z5;
    }

    public final void y(AttributeSet attributeSet) {
        c cVar;
        f1692q1 = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z5 = true;
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.MotionLayout_layoutDescription) {
                    this.f1718s = new c(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R$styleable.MotionLayout_currentState) {
                    this.f1723x = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R$styleable.MotionLayout_motionProgress) {
                    this.I = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.K = true;
                } else if (index == R$styleable.MotionLayout_applyMotionScene) {
                    z5 = obtainStyledAttributes.getBoolean(index, z5);
                } else if (index == R$styleable.MotionLayout_showPaths) {
                    if (this.M == 0) {
                        this.M = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R$styleable.MotionLayout_motionDebug) {
                    this.M = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f1718s == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z5) {
                this.f1718s = null;
            }
        }
        if (this.M != 0) {
            c cVar2 = this.f1718s;
            if (cVar2 == null) {
                Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            } else {
                int h4 = cVar2.h();
                c cVar3 = this.f1718s;
                w0.o b3 = cVar3.b(cVar3.h());
                String c9 = g0.c(getContext(), h4);
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    int id2 = childAt.getId();
                    if (id2 == -1) {
                        String name = childAt.getClass().getName();
                        StringBuilder g10 = r5.a.g(name.length() + r5.a.a(45, c9), "CHECK: ", c9, " ALL VIEWS SHOULD HAVE ID's ", name);
                        g10.append(" does not!");
                        Log.w("MotionLayout", g10.toString());
                    }
                    if (b3.i(id2) == null) {
                        String d5 = g0.d(childAt);
                        StringBuilder sb2 = new StringBuilder(r5.a.a(r5.a.a(27, c9), d5));
                        sb2.append("CHECK: ");
                        sb2.append(c9);
                        sb2.append(" NO CONSTRAINTS for ");
                        sb2.append(d5);
                        Log.w("MotionLayout", sb2.toString());
                    }
                }
                Integer[] numArr = (Integer[]) b3.f19444f.keySet().toArray(new Integer[0]);
                int length = numArr.length;
                int[] iArr = new int[length];
                for (int i11 = 0; i11 < length; i11++) {
                    iArr[i11] = numArr[i11].intValue();
                }
                for (int i12 = 0; i12 < length; i12++) {
                    int i13 = iArr[i12];
                    String c10 = g0.c(getContext(), i13);
                    if (findViewById(iArr[i12]) == null) {
                        StringBuilder sb3 = new StringBuilder(r5.a.a(r5.a.a(27, c9), c10));
                        sb3.append("CHECK: ");
                        sb3.append(c9);
                        sb3.append(" NO View matches id ");
                        sb3.append(c10);
                        Log.w("MotionLayout", sb3.toString());
                    }
                    if (b3.h(i13).e.f19374d == -1) {
                        StringBuilder g11 = r5.a.g(r5.a.a(r5.a.a(26, c9), c10), "CHECK: ", c9, "(", c10);
                        g11.append(") no LAYOUT_HEIGHT");
                        Log.w("MotionLayout", g11.toString());
                    }
                    if (b3.h(i13).e.f19372c == -1) {
                        StringBuilder g12 = r5.a.g(r5.a.a(r5.a.a(26, c9), c10), "CHECK: ", c9, "(", c10);
                        g12.append(") no LAYOUT_HEIGHT");
                        Log.w("MotionLayout", g12.toString());
                    }
                }
                SparseIntArray sparseIntArray = new SparseIntArray();
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                ArrayList arrayList = this.f1718s.f1735d;
                int size = arrayList.size();
                int i14 = 0;
                while (i14 < size) {
                    Object obj = arrayList.get(i14);
                    i14++;
                    x xVar = (x) obj;
                    if (xVar == this.f1718s.f1734c) {
                        Log.v("MotionLayout", "CHECK: CURRENT");
                    }
                    if (xVar.f18786d == xVar.f18785c) {
                        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
                    }
                    int i15 = xVar.f18786d;
                    int i16 = xVar.f18785c;
                    String c11 = g0.c(getContext(), i15);
                    String c12 = g0.c(getContext(), i16);
                    if (sparseIntArray.get(i15) == i16) {
                        StringBuilder sb4 = new StringBuilder(r5.a.a(r5.a.a(53, c11), c12));
                        sb4.append("CHECK: two transitions with the same start and end ");
                        sb4.append(c11);
                        sb4.append("->");
                        sb4.append(c12);
                        Log.e("MotionLayout", sb4.toString());
                    }
                    if (sparseIntArray2.get(i16) == i15) {
                        StringBuilder sb5 = new StringBuilder(r5.a.a(r5.a.a(43, c11), c12));
                        sb5.append("CHECK: you can't have reverse transitions");
                        sb5.append(c11);
                        sb5.append("->");
                        sb5.append(c12);
                        Log.e("MotionLayout", sb5.toString());
                    }
                    sparseIntArray.put(i15, i16);
                    sparseIntArray2.put(i16, i15);
                    if (this.f1718s.b(i15) == null) {
                        String valueOf = String.valueOf(c11);
                        Log.e("MotionLayout", valueOf.length() != 0 ? " no such constraintSetStart ".concat(valueOf) : new String(" no such constraintSetStart "));
                    }
                    if (this.f1718s.b(i16) == null) {
                        String valueOf2 = String.valueOf(c11);
                        Log.e("MotionLayout", valueOf2.length() != 0 ? " no such constraintSetEnd ".concat(valueOf2) : new String(" no such constraintSetEnd "));
                    }
                }
            }
        }
        if (this.f1723x != -1 || (cVar = this.f1718s) == null) {
            return;
        }
        this.f1723x = cVar.h();
        this.f1722w = this.f1718s.h();
        x xVar2 = this.f1718s.f1734c;
        this.f1724y = xVar2 != null ? xVar2.f18785c : -1;
    }

    public final void z() {
        x xVar;
        d dVar;
        View view;
        c cVar = this.f1718s;
        if (cVar == null) {
            return;
        }
        if (cVar.a(this.f1723x, this)) {
            requestLayout();
            return;
        }
        int i3 = this.f1723x;
        if (i3 != -1) {
            c cVar2 = this.f1718s;
            ArrayList arrayList = cVar2.f1735d;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                x xVar2 = (x) obj;
                if (xVar2.f18794m.size() > 0) {
                    ArrayList arrayList2 = xVar2.f18794m;
                    int size2 = arrayList2.size();
                    int i11 = 0;
                    while (i11 < size2) {
                        Object obj2 = arrayList2.get(i11);
                        i11++;
                        ((w) obj2).b(this);
                    }
                }
            }
            ArrayList arrayList3 = cVar2.f1736f;
            int size3 = arrayList3.size();
            int i12 = 0;
            while (i12 < size3) {
                Object obj3 = arrayList3.get(i12);
                i12++;
                x xVar3 = (x) obj3;
                if (xVar3.f18794m.size() > 0) {
                    ArrayList arrayList4 = xVar3.f18794m;
                    int size4 = arrayList4.size();
                    int i13 = 0;
                    while (i13 < size4) {
                        Object obj4 = arrayList4.get(i13);
                        i13++;
                        ((w) obj4).b(this);
                    }
                }
            }
            int size5 = arrayList.size();
            int i14 = 0;
            while (i14 < size5) {
                Object obj5 = arrayList.get(i14);
                i14++;
                x xVar4 = (x) obj5;
                if (xVar4.f18794m.size() > 0) {
                    ArrayList arrayList5 = xVar4.f18794m;
                    int size6 = arrayList5.size();
                    int i15 = 0;
                    while (i15 < size6) {
                        Object obj6 = arrayList5.get(i15);
                        i15++;
                        ((w) obj6).a(this, i3, xVar4);
                    }
                }
            }
            int size7 = arrayList3.size();
            int i16 = 0;
            while (i16 < size7) {
                Object obj7 = arrayList3.get(i16);
                i16++;
                x xVar5 = (x) obj7;
                if (xVar5.f18794m.size() > 0) {
                    ArrayList arrayList6 = xVar5.f18794m;
                    int size8 = arrayList6.size();
                    int i17 = 0;
                    while (i17 < size8) {
                        Object obj8 = arrayList6.get(i17);
                        i17++;
                        ((w) obj8).a(this, i3, xVar5);
                    }
                }
            }
        }
        if (!this.f1718s.o() || (xVar = this.f1718s.f1734c) == null || (dVar = xVar.f18793l) == null) {
            return;
        }
        int i18 = dVar.f1752d;
        if (i18 != -1) {
            MotionLayout motionLayout = dVar.r;
            view = motionLayout.findViewById(i18);
            if (view == null) {
                String valueOf = String.valueOf(g0.c(motionLayout.getContext(), dVar.f1752d));
                Log.e("TouchResponse", valueOf.length() != 0 ? "cannot find TouchAnchorId @id/".concat(valueOf) : new String("cannot find TouchAnchorId @id/"));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new fb.c(2));
            nestedScrollView.setOnScrollChangeListener(new eb.e(21));
        }
    }

    public void setTransition(x xVar) {
        d dVar;
        c cVar = this.f1718s;
        cVar.f1734c = xVar;
        if (xVar != null && (dVar = xVar.f18793l) != null) {
            dVar.c(cVar.f1746p);
        }
        setState(TransitionState.SETUP);
        int i3 = this.f1723x;
        x xVar2 = this.f1718s.f1734c;
        if (i3 == (xVar2 == null ? -1 : xVar2.f18785c)) {
            this.G = 1.0f;
            this.F = 1.0f;
            this.I = 1.0f;
        } else {
            this.G = 0.0f;
            this.F = 0.0f;
            this.I = 0.0f;
        }
        this.H = (xVar.r & 1) != 0 ? -1L : getNanoTime();
        int h4 = this.f1718s.h();
        c cVar2 = this.f1718s;
        x xVar3 = cVar2.f1734c;
        int i10 = xVar3 != null ? xVar3.f18785c : -1;
        if (h4 == this.f1722w && i10 == this.f1724y) {
            return;
        }
        this.f1722w = h4;
        this.f1724y = i10;
        cVar2.n(h4, i10);
        w0.o b3 = this.f1718s.b(this.f1722w);
        w0.o b10 = this.f1718s.b(this.f1724y);
        s sVar = this.f1712k1;
        sVar.e(b3, b10);
        int i11 = this.f1722w;
        int i12 = this.f1724y;
        sVar.e = i11;
        sVar.f18760f = i12;
        sVar.f();
        B();
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1720u = null;
        this.f1721v = 0.0f;
        this.f1722w = -1;
        this.f1723x = -1;
        this.f1724y = -1;
        this.f1725z = 0;
        this.A = 0;
        this.B = true;
        this.C = new HashMap();
        this.D = 0L;
        this.E = 1.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.I = 0.0f;
        this.K = false;
        this.M = 0;
        this.O = false;
        this.P = new t0.a();
        this.Q = new q(this);
        this.U = false;
        this.f1697c0 = false;
        this.f1699d0 = null;
        this.f1701e0 = null;
        this.f1703f0 = null;
        this.f1704g0 = null;
        this.f1706h0 = 0;
        this.i0 = -1L;
        this.f1709j0 = 0.0f;
        this.f1711k0 = 0;
        this.U0 = 0.0f;
        this.V0 = false;
        this.f1700d1 = new e(1);
        this.f1702e1 = false;
        this.f1705g1 = null;
        new HashMap();
        this.f1707h1 = new Rect();
        this.f1708i1 = false;
        this.f1710j1 = TransitionState.UNDEFINED;
        this.f1712k1 = new s(this);
        this.f1713l1 = false;
        this.f1714m1 = new RectF();
        this.f1715n1 = null;
        this.f1716o1 = null;
        this.f1717p1 = new ArrayList();
        y(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1720u = null;
        this.f1721v = 0.0f;
        this.f1722w = -1;
        this.f1723x = -1;
        this.f1724y = -1;
        this.f1725z = 0;
        this.A = 0;
        this.B = true;
        this.C = new HashMap();
        this.D = 0L;
        this.E = 1.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.I = 0.0f;
        this.K = false;
        this.M = 0;
        this.O = false;
        this.P = new t0.a();
        this.Q = new q(this);
        this.U = false;
        this.f1697c0 = false;
        this.f1699d0 = null;
        this.f1701e0 = null;
        this.f1703f0 = null;
        this.f1704g0 = null;
        this.f1706h0 = 0;
        this.i0 = -1L;
        this.f1709j0 = 0.0f;
        this.f1711k0 = 0;
        this.U0 = 0.0f;
        this.V0 = false;
        this.f1700d1 = new e(1);
        this.f1702e1 = false;
        this.f1705g1 = null;
        new HashMap();
        this.f1707h1 = new Rect();
        this.f1708i1 = false;
        this.f1710j1 = TransitionState.UNDEFINED;
        this.f1712k1 = new s(this);
        this.f1713l1 = false;
        this.f1714m1 = new RectF();
        this.f1715n1 = null;
        this.f1716o1 = null;
        this.f1717p1 = new ArrayList();
        y(attributeSet);
    }
}
