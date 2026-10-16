package u0;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import com.google.android.gms.internal.mlkit_vision_common.g0;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public q0.g f18756a = new q0.g();

    /* renamed from: b, reason: collision with root package name */
    public q0.g f18757b = new q0.g();

    /* renamed from: c, reason: collision with root package name */
    public w0.o f18758c = null;

    /* renamed from: d, reason: collision with root package name */
    public w0.o f18759d = null;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f18760f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ MotionLayout f18761g;

    public s(MotionLayout motionLayout) {
        this.f18761g = motionLayout;
    }

    public static void c(q0.g gVar, q0.g gVar2) {
        ArrayList arrayList = gVar.f17685s0;
        HashMap hashMap = new HashMap();
        hashMap.put(gVar, gVar2);
        gVar2.f17685s0.clear();
        gVar2.g(gVar, hashMap);
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            q0.f fVar = (q0.f) obj;
            q0.f aVar = fVar instanceof q0.a ? new q0.a() : fVar instanceof q0.k ? new q0.k() : fVar instanceof q0.i ? new q0.i() : fVar instanceof q0.n ? new q0.n() : fVar instanceof q0.l ? new q0.l() : new q0.f();
            gVar2.f17685s0.add(aVar);
            q0.f fVar2 = aVar.U;
            if (fVar2 != null) {
                ((q0.g) fVar2).f17685s0.remove(aVar);
                aVar.A();
            }
            aVar.U = gVar2;
            hashMap.put(fVar, aVar);
        }
        int size2 = arrayList.size();
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            q0.f fVar3 = (q0.f) obj2;
            ((q0.f) hashMap.get(fVar3)).g(fVar3, hashMap);
        }
    }

    public static q0.f d(q0.g gVar, View view) {
        if (gVar.f17656g0 == view) {
            return gVar;
        }
        ArrayList arrayList = gVar.f17685s0;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            q0.f fVar = (q0.f) arrayList.get(i3);
            if (fVar.f17656g0 == view) {
                return fVar;
            }
        }
        return null;
    }

    public final void a() {
        int i3;
        SparseArray sparseArray;
        int[] iArr;
        int i10;
        MotionLayout motionLayout = this.f18761g;
        int childCount = motionLayout.getChildCount();
        motionLayout.C.clear();
        SparseArray sparseArray2 = new SparseArray();
        int[] iArr2 = new int[childCount];
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = motionLayout.getChildAt(i11);
            n nVar = new n(childAt);
            int id2 = childAt.getId();
            iArr2[i11] = id2;
            sparseArray2.put(id2, nVar);
            motionLayout.C.put(childAt, nVar);
        }
        int i12 = 0;
        while (i12 < childCount) {
            View childAt2 = motionLayout.getChildAt(i12);
            n nVar2 = (n) motionLayout.C.get(childAt2);
            if (nVar2 == null) {
                i3 = childCount;
                sparseArray = sparseArray2;
                iArr = iArr2;
                i10 = i12;
            } else {
                w0.o oVar = this.f18758c;
                v vVar = nVar2.f18717f;
                if (oVar != null) {
                    q0.f d5 = d(this.f18756a, childAt2);
                    if (d5 != null) {
                        Rect p8 = MotionLayout.p(motionLayout, d5);
                        w0.o oVar2 = this.f18758c;
                        int width = motionLayout.getWidth();
                        iArr = iArr2;
                        int height = motionLayout.getHeight();
                        i10 = i12;
                        int i13 = oVar2.f19442c;
                        sparseArray = sparseArray2;
                        if (i13 != 0) {
                            n.g(p8, nVar2.f18713a, i13, width, height);
                        }
                        vVar.f18766c = 0.0f;
                        vVar.f18767d = 0.0f;
                        nVar2.f(vVar);
                        i3 = childCount;
                        vVar.d(p8.left, p8.top, p8.width(), p8.height());
                        w0.j h4 = oVar2.h(nVar2.f18715c);
                        vVar.a(h4);
                        w0.l lVar = h4.f19363d;
                        nVar2.f18723l = lVar.f19412g;
                        nVar2.f18719h.c(p8, oVar2, i13, nVar2.f18715c);
                        nVar2.B = h4.f19364f.f19431i;
                        nVar2.D = lVar.f19415j;
                        nVar2.E = lVar.f19414i;
                        Context context = nVar2.f18714b.getContext();
                        int i14 = lVar.f19417l;
                        nVar2.F = i14 != -2 ? i14 != -1 ? i14 != 0 ? i14 != 1 ? i14 != 2 ? i14 != 4 ? i14 != 5 ? null : new OvershootInterpolator() : new BounceInterpolator() : new DecelerateInterpolator() : new AccelerateInterpolator() : new AccelerateDecelerateInterpolator() : new m(p0.e.d(lVar.f19416k), 0) : AnimationUtils.loadInterpolator(context, lVar.f19418m);
                    } else {
                        i3 = childCount;
                        sparseArray = sparseArray2;
                        iArr = iArr2;
                        i10 = i12;
                        if (motionLayout.M != 0) {
                            String b3 = g0.b();
                            String d8 = g0.d(childAt2);
                            String name = childAt2.getClass().getName();
                            StringBuilder g10 = r5.a.g(name.length() + r5.a.a(r5.a.a(18, b3), d8), b3, "no widget for  ", d8, " (");
                            g10.append(name);
                            g10.append(")");
                            Log.e("MotionLayout", g10.toString());
                        }
                    }
                } else {
                    i3 = childCount;
                    sparseArray = sparseArray2;
                    iArr = iArr2;
                    i10 = i12;
                }
                if (this.f18759d != null) {
                    q0.f d10 = d(this.f18757b, childAt2);
                    if (d10 != null) {
                        Rect p10 = MotionLayout.p(motionLayout, d10);
                        w0.o oVar3 = this.f18759d;
                        int width2 = motionLayout.getWidth();
                        int height2 = motionLayout.getHeight();
                        int i15 = oVar3.f19442c;
                        if (i15 != 0) {
                            n.g(p10, nVar2.f18713a, i15, width2, height2);
                            p10 = nVar2.f18713a;
                        }
                        v vVar2 = nVar2.f18718g;
                        vVar2.f18766c = 1.0f;
                        vVar2.f18767d = 1.0f;
                        nVar2.f(vVar2);
                        vVar2.d(p10.left, p10.top, p10.width(), p10.height());
                        vVar2.a(oVar3.h(nVar2.f18715c));
                        nVar2.f18720i.c(p10, oVar3, i15, nVar2.f18715c);
                    } else if (motionLayout.M != 0) {
                        String b10 = g0.b();
                        String d11 = g0.d(childAt2);
                        String name2 = childAt2.getClass().getName();
                        StringBuilder g11 = r5.a.g(name2.length() + r5.a.a(r5.a.a(18, b10), d11), b10, "no widget for  ", d11, " (");
                        g11.append(name2);
                        g11.append(")");
                        Log.e("MotionLayout", g11.toString());
                    }
                }
            }
            i12 = i10 + 1;
            iArr2 = iArr;
            sparseArray2 = sparseArray;
            childCount = i3;
        }
        int[] iArr3 = iArr2;
        int i16 = childCount;
        int i17 = 0;
        while (true) {
            SparseArray sparseArray3 = sparseArray2;
            if (i17 >= i16) {
                return;
            }
            sparseArray2 = sparseArray3;
            n nVar3 = (n) sparseArray2.get(iArr3[i17]);
            int i18 = nVar3.f18717f.f18773k;
            if (i18 != -1) {
                n nVar4 = (n) sparseArray2.get(i18);
                nVar3.f18717f.f(nVar4, nVar4.f18717f);
                nVar3.f18718g.f(nVar4, nVar4.f18718g);
            }
            i17++;
        }
    }

    public final void b(int i3, int i10) {
        MotionLayout motionLayout = this.f18761g;
        int optimizationLevel = motionLayout.getOptimizationLevel();
        if (motionLayout.f1723x == motionLayout.getStartState()) {
            q0.g gVar = this.f18757b;
            w0.o oVar = this.f18759d;
            motionLayout.n(gVar, optimizationLevel, (oVar == null || oVar.f19442c == 0) ? i3 : i10, (oVar == null || oVar.f19442c == 0) ? i10 : i3);
            w0.o oVar2 = this.f18758c;
            if (oVar2 != null) {
                q0.g gVar2 = this.f18756a;
                int i11 = oVar2.f19442c;
                int i12 = i11 == 0 ? i3 : i10;
                if (i11 == 0) {
                    i3 = i10;
                }
                motionLayout.n(gVar2, optimizationLevel, i12, i3);
                return;
            }
            return;
        }
        w0.o oVar3 = this.f18758c;
        if (oVar3 != null) {
            q0.g gVar3 = this.f18756a;
            int i13 = oVar3.f19442c;
            motionLayout.n(gVar3, optimizationLevel, i13 == 0 ? i3 : i10, i13 == 0 ? i10 : i3);
        }
        q0.g gVar4 = this.f18757b;
        w0.o oVar4 = this.f18759d;
        int i14 = (oVar4 == null || oVar4.f19442c == 0) ? i3 : i10;
        if (oVar4 == null || oVar4.f19442c == 0) {
            i3 = i10;
        }
        motionLayout.n(gVar4, optimizationLevel, i14, i3);
    }

    public final void e(w0.o oVar, w0.o oVar2) {
        this.f18758c = oVar;
        this.f18759d = oVar2;
        this.f18756a = new q0.g();
        q0.g gVar = new q0.g();
        this.f18757b = gVar;
        q0.g gVar2 = this.f18756a;
        boolean z5 = MotionLayout.f1692q1;
        MotionLayout motionLayout = this.f18761g;
        q0.g gVar3 = motionLayout.f1858c;
        w0.f fVar = gVar3.f17689w0;
        gVar2.f17689w0 = fVar;
        gVar2.f17687u0.f17973f = fVar;
        w0.f fVar2 = gVar3.f17689w0;
        gVar.f17689w0 = fVar2;
        gVar.f17687u0.f17973f = fVar2;
        gVar2.f17685s0.clear();
        this.f18757b.f17685s0.clear();
        c(motionLayout.f1858c, this.f18756a);
        c(motionLayout.f1858c, this.f18757b);
        if (motionLayout.G > 0.5d) {
            if (oVar != null) {
                g(this.f18756a, oVar);
            }
            g(this.f18757b, oVar2);
        } else {
            g(this.f18757b, oVar2);
            if (oVar != null) {
                g(this.f18756a, oVar);
            }
        }
        this.f18756a.f17690x0 = motionLayout.k();
        q0.g gVar4 = this.f18756a;
        gVar4.f17686t0.u(gVar4);
        this.f18757b.f17690x0 = motionLayout.k();
        q0.g gVar5 = this.f18757b;
        gVar5.f17686t0.u(gVar5);
        ViewGroup.LayoutParams layoutParams = motionLayout.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width == -2) {
                q0.g gVar6 = this.f18756a;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                gVar6.I(constraintWidget$DimensionBehaviour);
                this.f18757b.I(constraintWidget$DimensionBehaviour);
            }
            if (layoutParams.height == -2) {
                q0.g gVar7 = this.f18756a;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                gVar7.J(constraintWidget$DimensionBehaviour2);
                this.f18757b.J(constraintWidget$DimensionBehaviour2);
            }
        }
    }

    public final void f() {
        q0.g gVar;
        boolean z5;
        HashMap hashMap;
        MotionLayout motionLayout = this.f18761g;
        int i3 = motionLayout.f1725z;
        int i10 = motionLayout.A;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i10);
        motionLayout.f1694a1 = mode;
        motionLayout.f1696b1 = mode2;
        motionLayout.getOptimizationLevel();
        b(i3, i10);
        int i11 = 0;
        if (!(motionLayout.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
            b(i3, i10);
            motionLayout.W0 = this.f18756a.o();
            motionLayout.X0 = this.f18756a.l();
            motionLayout.Y0 = this.f18757b.o();
            int l3 = this.f18757b.l();
            motionLayout.Z0 = l3;
            motionLayout.V0 = (motionLayout.W0 == motionLayout.Y0 && motionLayout.X0 == l3) ? false : true;
        }
        int i12 = motionLayout.W0;
        int i13 = motionLayout.X0;
        int i14 = motionLayout.f1694a1;
        if (i14 == Integer.MIN_VALUE || i14 == 0) {
            i12 = (int) ((motionLayout.f1698c1 * (motionLayout.Y0 - i12)) + i12);
        }
        int i15 = motionLayout.f1696b1;
        if (i15 == Integer.MIN_VALUE || i15 == 0) {
            i13 = (int) ((motionLayout.f1698c1 * (motionLayout.Z0 - i13)) + i13);
        }
        q0.g gVar2 = this.f18756a;
        if (gVar2.G0 || this.f18757b.G0) {
            gVar = gVar2;
            z5 = true;
        } else {
            gVar = gVar2;
            z5 = false;
        }
        motionLayout.m(i3, i10, i12, i13, z5, gVar.H0 || this.f18757b.H0);
        int childCount = motionLayout.getChildCount();
        motionLayout.f1712k1.a();
        motionLayout.K = true;
        SparseArray sparseArray = new SparseArray();
        int i16 = 0;
        while (true) {
            hashMap = motionLayout.C;
            if (i16 >= childCount) {
                break;
            }
            View childAt = motionLayout.getChildAt(i16);
            sparseArray.put(childAt.getId(), (n) hashMap.get(childAt));
            i16++;
        }
        int width = motionLayout.getWidth();
        int height = motionLayout.getHeight();
        x xVar = motionLayout.f1718s.f1734c;
        int i17 = xVar != null ? xVar.f18797p : -1;
        if (i17 != -1) {
            for (int i18 = 0; i18 < childCount; i18++) {
                n nVar = (n) hashMap.get(motionLayout.getChildAt(i18));
                if (nVar != null) {
                    nVar.A = i17;
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[hashMap.size()];
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            n nVar2 = (n) hashMap.get(motionLayout.getChildAt(i20));
            int i21 = nVar2.f18717f.f18773k;
            if (i21 != -1) {
                sparseBooleanArray.put(i21, true);
                iArr[i19] = nVar2.f18717f.f18773k;
                i19++;
            }
        }
        if (motionLayout.f1703f0 != null) {
            for (int i22 = 0; i22 < i19; i22++) {
                n nVar3 = (n) hashMap.get(motionLayout.findViewById(iArr[i22]));
                if (nVar3 != null) {
                    motionLayout.f1718s.f(nVar3);
                }
            }
            ArrayList arrayList = motionLayout.f1703f0;
            int size = arrayList.size();
            int i23 = 0;
            while (i23 < size) {
                Object obj = arrayList.get(i23);
                i23++;
                ((MotionHelper) obj).r(motionLayout, hashMap);
            }
            for (int i24 = 0; i24 < i19; i24++) {
                n nVar4 = (n) hashMap.get(motionLayout.findViewById(iArr[i24]));
                if (nVar4 != null) {
                    nVar4.h(width, height, motionLayout.getNanoTime());
                }
            }
        } else {
            for (int i25 = 0; i25 < i19; i25++) {
                n nVar5 = (n) hashMap.get(motionLayout.findViewById(iArr[i25]));
                if (nVar5 != null) {
                    motionLayout.f1718s.f(nVar5);
                    nVar5.h(width, height, motionLayout.getNanoTime());
                }
            }
        }
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt2 = motionLayout.getChildAt(i26);
            n nVar6 = (n) hashMap.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && nVar6 != null) {
                motionLayout.f1718s.f(nVar6);
                nVar6.h(width, height, motionLayout.getNanoTime());
            }
        }
        x xVar2 = motionLayout.f1718s.f1734c;
        float f2 = xVar2 != null ? xVar2.f18790i : 0.0f;
        if (f2 != 0.0f) {
            boolean z6 = ((double) f2) < 0.0d;
            float abs = Math.abs(f2);
            float f10 = -3.4028235E38f;
            float f11 = Float.MAX_VALUE;
            float f12 = -3.4028235E38f;
            float f13 = Float.MAX_VALUE;
            for (int i27 = 0; i27 < childCount; i27++) {
                n nVar7 = (n) hashMap.get(motionLayout.getChildAt(i27));
                if (!Float.isNaN(nVar7.f18723l)) {
                    for (int i28 = 0; i28 < childCount; i28++) {
                        n nVar8 = (n) hashMap.get(motionLayout.getChildAt(i28));
                        if (!Float.isNaN(nVar8.f18723l)) {
                            f11 = Math.min(f11, nVar8.f18723l);
                            f10 = Math.max(f10, nVar8.f18723l);
                        }
                    }
                    while (i11 < childCount) {
                        n nVar9 = (n) hashMap.get(motionLayout.getChildAt(i11));
                        if (!Float.isNaN(nVar9.f18723l)) {
                            nVar9.f18725n = 1.0f / (1.0f - abs);
                            if (z6) {
                                nVar9.f18724m = abs - (((f10 - nVar9.f18723l) / (f10 - f11)) * abs);
                            } else {
                                nVar9.f18724m = abs - (((nVar9.f18723l - f11) * abs) / (f10 - f11));
                            }
                        }
                        i11++;
                    }
                    return;
                }
                v vVar = nVar7.f18718g;
                float f14 = vVar.e;
                float f15 = vVar.f18768f;
                float f16 = z6 ? f15 - f14 : f15 + f14;
                f13 = Math.min(f13, f16);
                f12 = Math.max(f12, f16);
            }
            while (i11 < childCount) {
                n nVar10 = (n) hashMap.get(motionLayout.getChildAt(i11));
                v vVar2 = nVar10.f18718g;
                float f17 = vVar2.e;
                float f18 = vVar2.f18768f;
                float f19 = z6 ? f18 - f17 : f18 + f17;
                nVar10.f18725n = 1.0f / (1.0f - abs);
                nVar10.f18724m = abs - (((f19 - f13) * abs) / (f12 - f13));
                i11++;
            }
        }
    }

    public final void g(q0.g gVar, w0.o oVar) {
        w0.j jVar;
        w0.j jVar2;
        SparseArray sparseArray = new SparseArray();
        w0.p pVar = new w0.p();
        sparseArray.clear();
        sparseArray.put(0, gVar);
        MotionLayout motionLayout = this.f18761g;
        sparseArray.put(motionLayout.getId(), gVar);
        if (oVar != null && oVar.f19442c != 0) {
            q0.g gVar2 = this.f18757b;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(motionLayout.getHeight(), 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(motionLayout.getWidth(), 1073741824);
            boolean z5 = MotionLayout.f1692q1;
            motionLayout.n(gVar2, optimizationLevel, makeMeasureSpec, makeMeasureSpec2);
        }
        ArrayList arrayList = gVar.f17685s0;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            q0.f fVar = (q0.f) obj;
            sparseArray.put(fVar.f17656g0.getId(), fVar);
        }
        ArrayList arrayList2 = gVar.f17685s0;
        int size2 = arrayList2.size();
        int i10 = 0;
        while (i10 < size2) {
            int i11 = i10 + 1;
            q0.f fVar2 = (q0.f) arrayList2.get(i10);
            View view = fVar2.f17656g0;
            int id2 = view.getId();
            HashMap hashMap = oVar.f19444f;
            if (hashMap.containsKey(Integer.valueOf(id2)) && (jVar2 = (w0.j) hashMap.get(Integer.valueOf(id2))) != null) {
                jVar2.a(pVar);
            }
            fVar2.K(oVar.h(view.getId()).e.f19372c);
            fVar2.H(oVar.h(view.getId()).e.f19374d);
            if (view instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) view;
                int id3 = constraintHelper.getId();
                HashMap hashMap2 = oVar.f19444f;
                if (hashMap2.containsKey(Integer.valueOf(id3)) && (jVar = (w0.j) hashMap2.get(Integer.valueOf(id3))) != null && (fVar2 instanceof q0.l)) {
                    constraintHelper.l(jVar, (q0.l) fVar2, pVar, sparseArray);
                }
                if (view instanceof Barrier) {
                    ((Barrier) view).q();
                }
            }
            pVar.resolveLayoutDirection(motionLayout.getLayoutDirection());
            boolean z6 = MotionLayout.f1692q1;
            motionLayout.c(false, view, fVar2, pVar, sparseArray);
            if (oVar.h(view.getId()).f19362c.f19421c == 1) {
                fVar2.f17658h0 = view.getVisibility();
            } else {
                fVar2.f17658h0 = oVar.h(view.getId()).f19362c.f19420b;
            }
            i10 = i11;
        }
        ArrayList arrayList3 = gVar.f17685s0;
        int size3 = arrayList3.size();
        int i12 = 0;
        while (i12 < size3) {
            Object obj2 = arrayList3.get(i12);
            i12++;
            q0.f fVar3 = (q0.f) obj2;
            if (fVar3 instanceof q0.o) {
                ConstraintHelper constraintHelper2 = (ConstraintHelper) fVar3.f17656g0;
                q0.l lVar = (q0.l) fVar3;
                constraintHelper2.p(lVar, sparseArray);
                q0.o oVar2 = (q0.o) lVar;
                for (int i13 = 0; i13 < oVar2.f17721t0; i13++) {
                    q0.f fVar4 = oVar2.f17720s0[i13];
                    if (fVar4 != null) {
                        fVar4.F = true;
                    }
                }
            }
        }
    }
}
