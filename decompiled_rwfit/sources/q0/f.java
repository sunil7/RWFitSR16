package q0;

import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class f {
    public float A;
    public int[] B;
    public float C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public final d I;
    public final d J;
    public final d K;
    public final d L;
    public final d M;
    public final d N;
    public final d O;
    public final d P;
    public final d[] Q;
    public final ArrayList R;
    public final boolean[] S;
    public ConstraintWidget$DimensionBehaviour[] T;
    public f U;
    public int V;
    public int W;
    public float X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f17645a0;

    /* renamed from: b, reason: collision with root package name */
    public r0.c f17646b;

    /* renamed from: b0, reason: collision with root package name */
    public int f17647b0;

    /* renamed from: c, reason: collision with root package name */
    public r0.c f17648c;

    /* renamed from: c0, reason: collision with root package name */
    public int f17649c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f17651d0;

    /* renamed from: e0, reason: collision with root package name */
    public float f17652e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f17654f0;

    /* renamed from: g0, reason: collision with root package name */
    public View f17656g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f17658h0;
    public String i0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f17660j;

    /* renamed from: j0, reason: collision with root package name */
    public int f17661j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f17662k;

    /* renamed from: k0, reason: collision with root package name */
    public int f17663k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f17664l;

    /* renamed from: l0, reason: collision with root package name */
    public final float[] f17665l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f17666m;

    /* renamed from: m0, reason: collision with root package name */
    public final f[] f17667m0;

    /* renamed from: n, reason: collision with root package name */
    public int f17668n;

    /* renamed from: n0, reason: collision with root package name */
    public final f[] f17669n0;

    /* renamed from: o, reason: collision with root package name */
    public int f17670o;

    /* renamed from: o0, reason: collision with root package name */
    public f f17671o0;

    /* renamed from: p, reason: collision with root package name */
    public int f17672p;

    /* renamed from: p0, reason: collision with root package name */
    public f f17673p0;

    /* renamed from: q, reason: collision with root package name */
    public int f17674q;

    /* renamed from: q0, reason: collision with root package name */
    public int f17675q0;
    public int r;

    /* renamed from: r0, reason: collision with root package name */
    public int f17676r0;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f17677s;

    /* renamed from: t, reason: collision with root package name */
    public int f17678t;

    /* renamed from: u, reason: collision with root package name */
    public int f17679u;

    /* renamed from: v, reason: collision with root package name */
    public float f17680v;

    /* renamed from: w, reason: collision with root package name */
    public int f17681w;

    /* renamed from: x, reason: collision with root package name */
    public int f17682x;

    /* renamed from: y, reason: collision with root package name */
    public float f17683y;

    /* renamed from: z, reason: collision with root package name */
    public int f17684z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f17644a = false;

    /* renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.e f17650d = null;
    public androidx.constraintlayout.core.widgets.analyzer.g e = null;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f17653f = {true, true};

    /* renamed from: g, reason: collision with root package name */
    public boolean f17655g = true;

    /* renamed from: h, reason: collision with root package name */
    public int f17657h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f17659i = -1;

    public f() {
        new HashMap();
        this.f17660j = false;
        this.f17662k = false;
        this.f17664l = false;
        this.f17666m = false;
        this.f17668n = -1;
        this.f17670o = -1;
        this.f17672p = 0;
        this.f17674q = 0;
        this.r = 0;
        this.f17677s = new int[2];
        this.f17678t = 0;
        this.f17679u = 0;
        this.f17680v = 1.0f;
        this.f17681w = 0;
        this.f17682x = 0;
        this.f17683y = 1.0f;
        this.f17684z = -1;
        this.A = 1.0f;
        this.B = new int[]{SubsamplingScaleImageView.TILE_SIZE_AUTO, SubsamplingScaleImageView.TILE_SIZE_AUTO};
        this.C = 0.0f;
        this.D = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        d dVar = new d(this, ConstraintAnchor$Type.LEFT);
        this.I = dVar;
        d dVar2 = new d(this, ConstraintAnchor$Type.TOP);
        this.J = dVar2;
        d dVar3 = new d(this, ConstraintAnchor$Type.RIGHT);
        this.K = dVar3;
        d dVar4 = new d(this, ConstraintAnchor$Type.BOTTOM);
        this.L = dVar4;
        d dVar5 = new d(this, ConstraintAnchor$Type.BASELINE);
        this.M = dVar5;
        d dVar6 = new d(this, ConstraintAnchor$Type.CENTER_X);
        this.N = dVar6;
        d dVar7 = new d(this, ConstraintAnchor$Type.CENTER_Y);
        this.O = dVar7;
        d dVar8 = new d(this, ConstraintAnchor$Type.CENTER);
        this.P = dVar8;
        this.Q = new d[]{dVar, dVar3, dVar2, dVar4, dVar5, dVar8};
        ArrayList arrayList = new ArrayList();
        this.R = arrayList;
        this.S = new boolean[2];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
        this.T = new ConstraintWidget$DimensionBehaviour[]{constraintWidget$DimensionBehaviour, constraintWidget$DimensionBehaviour};
        this.U = null;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.f17645a0 = 0;
        this.f17647b0 = 0;
        this.f17652e0 = 0.5f;
        this.f17654f0 = 0.5f;
        this.f17658h0 = 0;
        this.i0 = null;
        this.f17661j0 = 0;
        this.f17663k0 = 0;
        this.f17665l0 = new float[]{-1.0f, -1.0f};
        this.f17667m0 = new f[]{null, null};
        this.f17669n0 = new f[]{null, null};
        this.f17671o0 = null;
        this.f17673p0 = null;
        this.f17675q0 = -1;
        this.f17676r0 = -1;
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        arrayList.add(dVar4);
        arrayList.add(dVar6);
        arrayList.add(dVar7);
        arrayList.add(dVar8);
        arrayList.add(dVar5);
    }

    public void A() {
        this.I.j();
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.U = null;
        this.C = 0.0f;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.f17645a0 = 0;
        this.f17647b0 = 0;
        this.f17649c0 = 0;
        this.f17651d0 = 0;
        this.f17652e0 = 0.5f;
        this.f17654f0 = 0.5f;
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = this.T;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
        constraintWidget$DimensionBehaviourArr[0] = constraintWidget$DimensionBehaviour;
        constraintWidget$DimensionBehaviourArr[1] = constraintWidget$DimensionBehaviour;
        this.f17656g0 = null;
        this.f17658h0 = 0;
        this.f17661j0 = 0;
        this.f17663k0 = 0;
        float[] fArr = this.f17665l0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f17668n = -1;
        this.f17670o = -1;
        int[] iArr = this.B;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f17674q = 0;
        this.r = 0;
        this.f17680v = 1.0f;
        this.f17683y = 1.0f;
        this.f17679u = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f17682x = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f17678t = 0;
        this.f17681w = 0;
        this.f17684z = -1;
        this.A = 1.0f;
        boolean[] zArr = this.f17653f;
        zArr[0] = true;
        zArr[1] = true;
        this.F = false;
        boolean[] zArr2 = this.S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f17655g = true;
        int[] iArr2 = this.f17677s;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f17657h = -1;
        this.f17659i = -1;
    }

    public final void B() {
        f fVar = this.U;
        if (fVar != null && (fVar instanceof g)) {
            ((g) fVar).getClass();
        }
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((d) arrayList.get(i3)).j();
        }
    }

    public final void C() {
        this.f17660j = false;
        this.f17662k = false;
        this.f17664l = false;
        this.f17666m = false;
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) arrayList.get(i3);
            dVar.f17636c = false;
            dVar.f17635b = 0;
        }
    }

    public void D(n.l lVar) {
        this.I.k();
        this.J.k();
        this.K.k();
        this.L.k();
        this.M.k();
        this.P.k();
        this.N.k();
        this.O.k();
    }

    public final void E(int i3) {
        this.f17647b0 = i3;
        this.D = i3 > 0;
    }

    public final void F(int i3, int i10) {
        if (this.f17660j) {
            return;
        }
        this.I.l(i3);
        this.K.l(i10);
        this.Z = i3;
        this.V = i10 - i3;
        this.f17660j = true;
    }

    public final void G(int i3, int i10) {
        if (this.f17662k) {
            return;
        }
        this.J.l(i3);
        this.L.l(i10);
        this.f17645a0 = i3;
        this.W = i10 - i3;
        if (this.D) {
            this.M.l(i3 + this.f17647b0);
        }
        this.f17662k = true;
    }

    public final void H(int i3) {
        this.W = i3;
        int i10 = this.f17651d0;
        if (i3 < i10) {
            this.W = i10;
        }
    }

    public final void I(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour) {
        this.T[0] = constraintWidget$DimensionBehaviour;
    }

    public final void J(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour) {
        this.T[1] = constraintWidget$DimensionBehaviour;
    }

    public final void K(int i3) {
        this.V = i3;
        int i10 = this.f17649c0;
        if (i3 < i10) {
            this.V = i10;
        }
    }

    public void L(boolean z5, boolean z6) {
        int i3;
        int i10;
        androidx.constraintlayout.core.widgets.analyzer.e eVar = this.f17650d;
        boolean z8 = z5 & eVar.f1636g;
        androidx.constraintlayout.core.widgets.analyzer.g gVar = this.e;
        boolean z10 = z6 & gVar.f1636g;
        int i11 = eVar.f1637h.f1619g;
        int i12 = gVar.f1637h.f1619g;
        int i13 = eVar.f1638i.f1619g;
        int i14 = gVar.f1638i.f1619g;
        int i15 = i14 - i12;
        if (i13 - i11 < 0 || i15 < 0 || i11 == Integer.MIN_VALUE || i11 == Integer.MAX_VALUE || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE) {
            i13 = 0;
            i14 = 0;
            i11 = 0;
            i12 = 0;
        }
        int i16 = i13 - i11;
        int i17 = i14 - i12;
        if (z8) {
            this.Z = i11;
        }
        if (z10) {
            this.f17645a0 = i12;
        }
        if (this.f17658h0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        if (z8) {
            if (this.T[0] == ConstraintWidget$DimensionBehaviour.FIXED && i16 < (i10 = this.V)) {
                i16 = i10;
            }
            this.V = i16;
            int i18 = this.f17649c0;
            if (i16 < i18) {
                this.V = i18;
            }
        }
        if (z10) {
            if (this.T[1] == ConstraintWidget$DimensionBehaviour.FIXED && i17 < (i3 = this.W)) {
                i17 = i3;
            }
            this.W = i17;
            int i19 = this.f17651d0;
            if (i17 < i19) {
                this.W = i19;
            }
        }
    }

    public void M(o0.c cVar, boolean z5) {
        int i3;
        int i10;
        androidx.constraintlayout.core.widgets.analyzer.g gVar;
        androidx.constraintlayout.core.widgets.analyzer.e eVar;
        d dVar = this.I;
        cVar.getClass();
        int n4 = o0.c.n(dVar);
        int n8 = o0.c.n(this.J);
        int n10 = o0.c.n(this.K);
        int n11 = o0.c.n(this.L);
        if (z5 && (eVar = this.f17650d) != null) {
            androidx.constraintlayout.core.widgets.analyzer.a aVar = eVar.f1637h;
            if (aVar.f1622j) {
                androidx.constraintlayout.core.widgets.analyzer.a aVar2 = eVar.f1638i;
                if (aVar2.f1622j) {
                    n4 = aVar.f1619g;
                    n10 = aVar2.f1619g;
                }
            }
        }
        if (z5 && (gVar = this.e) != null) {
            androidx.constraintlayout.core.widgets.analyzer.a aVar3 = gVar.f1637h;
            if (aVar3.f1622j) {
                androidx.constraintlayout.core.widgets.analyzer.a aVar4 = gVar.f1638i;
                if (aVar4.f1622j) {
                    n8 = aVar3.f1619g;
                    n11 = aVar4.f1619g;
                }
            }
        }
        int i11 = n11 - n8;
        if (n10 - n4 < 0 || i11 < 0 || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n8 == Integer.MIN_VALUE || n8 == Integer.MAX_VALUE || n10 == Integer.MIN_VALUE || n10 == Integer.MAX_VALUE || n11 == Integer.MIN_VALUE || n11 == Integer.MAX_VALUE) {
            n4 = 0;
            n8 = 0;
            n10 = 0;
            n11 = 0;
        }
        int i12 = n10 - n4;
        int i13 = n11 - n8;
        this.Z = n4;
        this.f17645a0 = n8;
        if (this.f17658h0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = this.T;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviourArr[0];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 && i12 < (i10 = this.V)) {
            i12 = i10;
        }
        if (constraintWidget$DimensionBehaviourArr[1] == constraintWidget$DimensionBehaviour2 && i13 < (i3 = this.W)) {
            i13 = i3;
        }
        this.V = i12;
        this.W = i13;
        int i14 = this.f17651d0;
        if (i13 < i14) {
            this.W = i14;
        }
        int i15 = this.f17649c0;
        if (i12 < i15) {
            this.V = i15;
        }
        int i16 = this.f17679u;
        if (i16 > 0 && constraintWidget$DimensionBehaviour == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
            this.V = Math.min(this.V, i16);
        }
        int i17 = this.f17682x;
        if (i17 > 0 && this.T[1] == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
            this.W = Math.min(this.W, i17);
        }
        int i18 = this.V;
        if (i12 != i18) {
            this.f17657h = i18;
        }
        int i19 = this.W;
        if (i13 != i19) {
            this.f17659i = i19;
        }
    }

    public final void a(g gVar, o0.c cVar, HashSet hashSet, int i3, boolean z5) {
        if (z5) {
            if (!hashSet.contains(this)) {
                return;
            }
            m.b(gVar, cVar, this);
            hashSet.remove(this);
            b(cVar, gVar.S(64));
        }
        if (i3 == 0) {
            HashSet hashSet2 = this.I.f17634a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f17637d.a(gVar, cVar, hashSet, i3, true);
                }
            }
            HashSet hashSet3 = this.K.f17634a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).f17637d.a(gVar, cVar, hashSet, i3, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.J.f17634a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).f17637d.a(gVar, cVar, hashSet, i3, true);
            }
        }
        HashSet hashSet5 = this.L.f17634a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).f17637d.a(gVar, cVar, hashSet, i3, true);
            }
        }
        HashSet hashSet6 = this.M.f17634a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((d) it5.next()).f17637d.a(gVar, cVar, hashSet, i3, true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        if (r13 != 3) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x05e4, code lost:
    
        if (r59.f17658h0 == r9) goto L377;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02b9  */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33, types: [int] */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r13v46, types: [q0.g] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v15 */
    /* JADX WARN: Type inference failed for: r17v16 */
    /* JADX WARN: Type inference failed for: r17v18 */
    /* JADX WARN: Type inference failed for: r17v20 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v11 */
    /* JADX WARN: Type inference failed for: r19v14 */
    /* JADX WARN: Type inference failed for: r19v15 */
    /* JADX WARN: Type inference failed for: r19v16 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r59v0, types: [q0.f] */
    /* JADX WARN: Type inference failed for: r9v15, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(o0.c r60, boolean r61) {
        /*
            Method dump skipped, instructions count: 1934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.f.b(o0.c, boolean):void");
    }

    public boolean c() {
        return this.f17658h0 != 8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:280:0x052f, code lost:
    
        if (r2[1] == r5) goto L342;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0456 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x04fd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:289:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a5 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(o0.c r29, boolean r30, boolean r31, boolean r32, boolean r33, o0.e r34, o0.e r35, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r36, boolean r37, q0.d r38, q0.d r39, int r40, int r41, int r42, int r43, float r44, boolean r45, boolean r46, boolean r47, boolean r48, boolean r49, int r50, int r51, int r52, int r53, float r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.f.d(o0.c, boolean, boolean, boolean, boolean, o0.e, o0.e, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, q0.d, q0.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void e(ConstraintAnchor$Type constraintAnchor$Type, f fVar, ConstraintAnchor$Type constraintAnchor$Type2, int i3) {
        ConstraintAnchor$Type constraintAnchor$Type3;
        ConstraintAnchor$Type constraintAnchor$Type4;
        boolean z5;
        ConstraintAnchor$Type constraintAnchor$Type5 = ConstraintAnchor$Type.CENTER;
        if (constraintAnchor$Type == constraintAnchor$Type5) {
            if (constraintAnchor$Type2 != constraintAnchor$Type5) {
                ConstraintAnchor$Type constraintAnchor$Type6 = ConstraintAnchor$Type.LEFT;
                if (constraintAnchor$Type2 == constraintAnchor$Type6 || constraintAnchor$Type2 == ConstraintAnchor$Type.RIGHT) {
                    e(constraintAnchor$Type6, fVar, constraintAnchor$Type2, 0);
                    e(ConstraintAnchor$Type.RIGHT, fVar, constraintAnchor$Type2, 0);
                    j(constraintAnchor$Type5).a(fVar.j(constraintAnchor$Type2), 0);
                    return;
                }
                ConstraintAnchor$Type constraintAnchor$Type7 = ConstraintAnchor$Type.TOP;
                if (constraintAnchor$Type2 == constraintAnchor$Type7 || constraintAnchor$Type2 == ConstraintAnchor$Type.BOTTOM) {
                    e(constraintAnchor$Type7, fVar, constraintAnchor$Type2, 0);
                    e(ConstraintAnchor$Type.BOTTOM, fVar, constraintAnchor$Type2, 0);
                    j(constraintAnchor$Type5).a(fVar.j(constraintAnchor$Type2), 0);
                    return;
                }
                return;
            }
            ConstraintAnchor$Type constraintAnchor$Type8 = ConstraintAnchor$Type.LEFT;
            d j4 = j(constraintAnchor$Type8);
            ConstraintAnchor$Type constraintAnchor$Type9 = ConstraintAnchor$Type.RIGHT;
            d j10 = j(constraintAnchor$Type9);
            ConstraintAnchor$Type constraintAnchor$Type10 = ConstraintAnchor$Type.TOP;
            d j11 = j(constraintAnchor$Type10);
            ConstraintAnchor$Type constraintAnchor$Type11 = ConstraintAnchor$Type.BOTTOM;
            d j12 = j(constraintAnchor$Type11);
            boolean z6 = true;
            if ((j4 == null || !j4.h()) && (j10 == null || !j10.h())) {
                e(constraintAnchor$Type8, fVar, constraintAnchor$Type8, 0);
                e(constraintAnchor$Type9, fVar, constraintAnchor$Type9, 0);
                z5 = true;
            } else {
                z5 = false;
            }
            if ((j11 == null || !j11.h()) && (j12 == null || !j12.h())) {
                e(constraintAnchor$Type10, fVar, constraintAnchor$Type10, 0);
                e(constraintAnchor$Type11, fVar, constraintAnchor$Type11, 0);
            } else {
                z6 = false;
            }
            if (z5 && z6) {
                j(constraintAnchor$Type5).a(fVar.j(constraintAnchor$Type5), 0);
                return;
            }
            if (z5) {
                ConstraintAnchor$Type constraintAnchor$Type12 = ConstraintAnchor$Type.CENTER_X;
                j(constraintAnchor$Type12).a(fVar.j(constraintAnchor$Type12), 0);
                return;
            } else {
                if (z6) {
                    ConstraintAnchor$Type constraintAnchor$Type13 = ConstraintAnchor$Type.CENTER_Y;
                    j(constraintAnchor$Type13).a(fVar.j(constraintAnchor$Type13), 0);
                    return;
                }
                return;
            }
        }
        ConstraintAnchor$Type constraintAnchor$Type14 = ConstraintAnchor$Type.CENTER_X;
        if (constraintAnchor$Type == constraintAnchor$Type14 && (constraintAnchor$Type2 == (constraintAnchor$Type4 = ConstraintAnchor$Type.LEFT) || constraintAnchor$Type2 == ConstraintAnchor$Type.RIGHT)) {
            d j13 = j(constraintAnchor$Type4);
            d j14 = fVar.j(constraintAnchor$Type2);
            d j15 = j(ConstraintAnchor$Type.RIGHT);
            j13.a(j14, 0);
            j15.a(j14, 0);
            j(constraintAnchor$Type14).a(j14, 0);
            return;
        }
        ConstraintAnchor$Type constraintAnchor$Type15 = ConstraintAnchor$Type.CENTER_Y;
        if (constraintAnchor$Type == constraintAnchor$Type15 && (constraintAnchor$Type2 == (constraintAnchor$Type3 = ConstraintAnchor$Type.TOP) || constraintAnchor$Type2 == ConstraintAnchor$Type.BOTTOM)) {
            d j16 = fVar.j(constraintAnchor$Type2);
            j(constraintAnchor$Type3).a(j16, 0);
            j(ConstraintAnchor$Type.BOTTOM).a(j16, 0);
            j(constraintAnchor$Type15).a(j16, 0);
            return;
        }
        if (constraintAnchor$Type == constraintAnchor$Type14 && constraintAnchor$Type2 == constraintAnchor$Type14) {
            ConstraintAnchor$Type constraintAnchor$Type16 = ConstraintAnchor$Type.LEFT;
            j(constraintAnchor$Type16).a(fVar.j(constraintAnchor$Type16), 0);
            ConstraintAnchor$Type constraintAnchor$Type17 = ConstraintAnchor$Type.RIGHT;
            j(constraintAnchor$Type17).a(fVar.j(constraintAnchor$Type17), 0);
            j(constraintAnchor$Type14).a(fVar.j(constraintAnchor$Type2), 0);
            return;
        }
        if (constraintAnchor$Type == constraintAnchor$Type15 && constraintAnchor$Type2 == constraintAnchor$Type15) {
            ConstraintAnchor$Type constraintAnchor$Type18 = ConstraintAnchor$Type.TOP;
            j(constraintAnchor$Type18).a(fVar.j(constraintAnchor$Type18), 0);
            ConstraintAnchor$Type constraintAnchor$Type19 = ConstraintAnchor$Type.BOTTOM;
            j(constraintAnchor$Type19).a(fVar.j(constraintAnchor$Type19), 0);
            j(constraintAnchor$Type15).a(fVar.j(constraintAnchor$Type2), 0);
            return;
        }
        d j17 = j(constraintAnchor$Type);
        d j18 = fVar.j(constraintAnchor$Type2);
        if (j17.i(j18)) {
            ConstraintAnchor$Type constraintAnchor$Type20 = ConstraintAnchor$Type.BASELINE;
            if (constraintAnchor$Type == constraintAnchor$Type20) {
                d j19 = j(ConstraintAnchor$Type.TOP);
                d j20 = j(ConstraintAnchor$Type.BOTTOM);
                if (j19 != null) {
                    j19.j();
                }
                if (j20 != null) {
                    j20.j();
                }
            } else if (constraintAnchor$Type == ConstraintAnchor$Type.TOP || constraintAnchor$Type == ConstraintAnchor$Type.BOTTOM) {
                d j21 = j(constraintAnchor$Type20);
                if (j21 != null) {
                    j21.j();
                }
                d j22 = j(constraintAnchor$Type5);
                if (j22.f17638f != j18) {
                    j22.j();
                }
                d f2 = j(constraintAnchor$Type).f();
                d j23 = j(constraintAnchor$Type15);
                if (j23.h()) {
                    f2.j();
                    j23.j();
                }
            } else if (constraintAnchor$Type == ConstraintAnchor$Type.LEFT || constraintAnchor$Type == ConstraintAnchor$Type.RIGHT) {
                d j24 = j(constraintAnchor$Type5);
                if (j24.f17638f != j18) {
                    j24.j();
                }
                d f10 = j(constraintAnchor$Type).f();
                d j25 = j(constraintAnchor$Type14);
                if (j25.h()) {
                    f10.j();
                    j25.j();
                }
            }
            j17.a(j18, i3);
        }
    }

    public final void f(d dVar, d dVar2, int i3) {
        if (dVar.f17637d == this) {
            e(dVar.e, dVar2.f17637d, dVar2.e, i3);
        }
    }

    public void g(f fVar, HashMap hashMap) {
        this.f17668n = fVar.f17668n;
        this.f17670o = fVar.f17670o;
        this.f17674q = fVar.f17674q;
        this.r = fVar.r;
        int[] iArr = fVar.f17677s;
        int i3 = iArr[0];
        int[] iArr2 = this.f17677s;
        iArr2[0] = i3;
        iArr2[1] = iArr[1];
        this.f17678t = fVar.f17678t;
        this.f17679u = fVar.f17679u;
        this.f17681w = fVar.f17681w;
        this.f17682x = fVar.f17682x;
        this.f17683y = fVar.f17683y;
        this.f17684z = fVar.f17684z;
        this.A = fVar.A;
        int[] iArr3 = fVar.B;
        this.B = Arrays.copyOf(iArr3, iArr3.length);
        this.C = fVar.C;
        this.D = fVar.D;
        this.E = fVar.E;
        this.I.j();
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.T = (ConstraintWidget$DimensionBehaviour[]) Arrays.copyOf(this.T, 2);
        this.U = this.U == null ? null : (f) hashMap.get(fVar.U);
        this.V = fVar.V;
        this.W = fVar.W;
        this.X = fVar.X;
        this.Y = fVar.Y;
        this.Z = fVar.Z;
        this.f17645a0 = fVar.f17645a0;
        this.f17647b0 = fVar.f17647b0;
        this.f17649c0 = fVar.f17649c0;
        this.f17651d0 = fVar.f17651d0;
        this.f17652e0 = fVar.f17652e0;
        this.f17654f0 = fVar.f17654f0;
        this.f17656g0 = fVar.f17656g0;
        this.f17658h0 = fVar.f17658h0;
        this.i0 = fVar.i0;
        this.f17661j0 = fVar.f17661j0;
        this.f17663k0 = fVar.f17663k0;
        float[] fArr = fVar.f17665l0;
        float f2 = fArr[0];
        float[] fArr2 = this.f17665l0;
        fArr2[0] = f2;
        fArr2[1] = fArr[1];
        f[] fVarArr = fVar.f17667m0;
        f fVar2 = fVarArr[0];
        f[] fVarArr2 = this.f17667m0;
        fVarArr2[0] = fVar2;
        fVarArr2[1] = fVarArr[1];
        f[] fVarArr3 = fVar.f17669n0;
        f fVar3 = fVarArr3[0];
        f[] fVarArr4 = this.f17669n0;
        fVarArr4[0] = fVar3;
        fVarArr4[1] = fVarArr3[1];
        f fVar4 = fVar.f17671o0;
        this.f17671o0 = fVar4 == null ? null : (f) hashMap.get(fVar4);
        f fVar5 = fVar.f17673p0;
        this.f17673p0 = fVar5 != null ? (f) hashMap.get(fVar5) : null;
    }

    public final void h(o0.c cVar) {
        cVar.k(this.I);
        cVar.k(this.J);
        cVar.k(this.K);
        cVar.k(this.L);
        if (this.f17647b0 > 0) {
            cVar.k(this.M);
        }
    }

    public final void i() {
        if (this.f17650d == null) {
            this.f17650d = new androidx.constraintlayout.core.widgets.analyzer.e(this);
        }
        if (this.e == null) {
            this.e = new androidx.constraintlayout.core.widgets.analyzer.g(this);
        }
    }

    public d j(ConstraintAnchor$Type constraintAnchor$Type) {
        switch (e.f17642a[constraintAnchor$Type.ordinal()]) {
            case 1:
                return this.I;
            case 2:
                return this.J;
            case 3:
                return this.K;
            case 4:
                return this.L;
            case 5:
                return this.M;
            case 6:
                return this.P;
            case 7:
                return this.N;
            case 8:
                return this.O;
            case 9:
                return null;
            default:
                throw new AssertionError(constraintAnchor$Type.name());
        }
    }

    public final ConstraintWidget$DimensionBehaviour k(int i3) {
        if (i3 == 0) {
            return this.T[0];
        }
        if (i3 == 1) {
            return this.T[1];
        }
        return null;
    }

    public final int l() {
        if (this.f17658h0 == 8) {
            return 0;
        }
        return this.W;
    }

    public final f m(int i3) {
        d dVar;
        d dVar2;
        if (i3 != 0) {
            if (i3 == 1 && (dVar2 = (dVar = this.L).f17638f) != null && dVar2.f17638f == dVar) {
                return dVar2.f17637d;
            }
            return null;
        }
        d dVar3 = this.K;
        d dVar4 = dVar3.f17638f;
        if (dVar4 == null || dVar4.f17638f != dVar3) {
            return null;
        }
        return dVar4.f17637d;
    }

    public final f n(int i3) {
        d dVar;
        d dVar2;
        if (i3 != 0) {
            if (i3 == 1 && (dVar2 = (dVar = this.J).f17638f) != null && dVar2.f17638f == dVar) {
                return dVar2.f17637d;
            }
            return null;
        }
        d dVar3 = this.I;
        d dVar4 = dVar3.f17638f;
        if (dVar4 == null || dVar4.f17638f != dVar3) {
            return null;
        }
        return dVar4.f17637d;
    }

    public final int o() {
        if (this.f17658h0 == 8) {
            return 0;
        }
        return this.V;
    }

    public final int p() {
        f fVar = this.U;
        return (fVar == null || !(fVar instanceof g)) ? this.Z : ((g) fVar).f17692z0 + this.Z;
    }

    public final int q() {
        f fVar = this.U;
        return (fVar == null || !(fVar instanceof g)) ? this.f17645a0 : ((g) fVar).A0 + this.f17645a0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(int r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L1b
            q0.d r5 = r4.I
            q0.d r5 = r5.f17638f
            if (r5 == 0) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r1
        Le:
            q0.d r3 = r4.K
            q0.d r3 = r3.f17638f
            if (r3 == 0) goto L16
            r3 = r2
            goto L17
        L16:
            r3 = r1
        L17:
            int r5 = r5 + r3
            if (r5 >= r0) goto L3b
            goto L3a
        L1b:
            q0.d r5 = r4.J
            q0.d r5 = r5.f17638f
            if (r5 == 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            q0.d r3 = r4.L
            q0.d r3 = r3.f17638f
            if (r3 == 0) goto L2c
            r3 = r2
            goto L2d
        L2c:
            r3 = r1
        L2d:
            int r5 = r5 + r3
            q0.d r3 = r4.M
            q0.d r3 = r3.f17638f
            if (r3 == 0) goto L36
            r3 = r2
            goto L37
        L36:
            r3 = r1
        L37:
            int r5 = r5 + r3
            if (r5 >= r0) goto L3b
        L3a:
            return r2
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.f.r(int):boolean");
    }

    public final boolean s(int i3, int i10) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        if (i3 == 0) {
            d dVar5 = this.I;
            d dVar6 = dVar5.f17638f;
            if (dVar6 == null || !dVar6.f17636c || (dVar4 = (dVar3 = this.K).f17638f) == null || !dVar4.f17636c) {
                return false;
            }
            return (dVar4.d() - dVar3.e()) - (dVar5.e() + dVar5.f17638f.d()) >= i10;
        }
        d dVar7 = this.J;
        d dVar8 = dVar7.f17638f;
        if (dVar8 == null || !dVar8.f17636c || (dVar2 = (dVar = this.L).f17638f) == null || !dVar2.f17636c) {
            return false;
        }
        return (dVar2.d() - dVar.e()) - (dVar7.e() + dVar7.f17638f.d()) >= i10;
    }

    public final void t(ConstraintAnchor$Type constraintAnchor$Type, f fVar, ConstraintAnchor$Type constraintAnchor$Type2, int i3, int i10) {
        j(constraintAnchor$Type).b(fVar.j(constraintAnchor$Type2), i3, i10, true);
    }

    public String toString() {
        StringBuilder t8 = l0.t("");
        t8.append(this.i0 != null ? r5.a.f(new StringBuilder("id: "), this.i0, " ") : "");
        t8.append("(");
        t8.append(this.Z);
        t8.append(", ");
        t8.append(this.f17645a0);
        t8.append(") - (");
        t8.append(this.V);
        t8.append(" x ");
        return r5.a.e(t8, this.W, ")");
    }

    public final boolean u(int i3) {
        d dVar;
        d dVar2;
        int i10 = i3 * 2;
        d[] dVarArr = this.Q;
        d dVar3 = dVarArr[i10];
        d dVar4 = dVar3.f17638f;
        return (dVar4 == null || dVar4.f17638f == dVar3 || (dVar2 = (dVar = dVarArr[i10 + 1]).f17638f) == null || dVar2.f17638f != dVar) ? false : true;
    }

    public final boolean v() {
        d dVar = this.I;
        d dVar2 = dVar.f17638f;
        if (dVar2 != null && dVar2.f17638f == dVar) {
            return true;
        }
        d dVar3 = this.K;
        d dVar4 = dVar3.f17638f;
        return dVar4 != null && dVar4.f17638f == dVar3;
    }

    public final boolean w() {
        d dVar = this.J;
        d dVar2 = dVar.f17638f;
        if (dVar2 != null && dVar2.f17638f == dVar) {
            return true;
        }
        d dVar3 = this.L;
        d dVar4 = dVar3.f17638f;
        return dVar4 != null && dVar4.f17638f == dVar3;
    }

    public final boolean x() {
        return this.f17655g && this.f17658h0 != 8;
    }

    public boolean y() {
        if (this.f17660j) {
            return true;
        }
        return this.I.f17636c && this.K.f17636c;
    }

    public boolean z() {
        if (this.f17662k) {
            return true;
        }
        return this.J.f17636c && this.L.f17636c;
    }
}
