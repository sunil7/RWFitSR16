package q0;

import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean[] f17722a = new boolean[3];

    /* JADX WARN: Code restructure failed: missing block: B:162:0x02a0, code lost:
    
        if (r8.f17637d == r6) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0113, code lost:
    
        if (r4.f17637d == r7) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:190:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0451 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x069d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x06d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x06f4 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x06c0  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x06b7  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0597 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x068d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(q0.g r39, o0.c r40, java.util.ArrayList r41, int r42) {
        /*
            Method dump skipped, instructions count: 1795
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.m.a(q0.g, o0.c, java.util.ArrayList, int):void");
    }

    public static void b(g gVar, o0.c cVar, f fVar) {
        fVar.f17668n = -1;
        fVar.f17670o = -1;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = gVar.T[0];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (constraintWidget$DimensionBehaviour != constraintWidget$DimensionBehaviour2 && fVar.T[0] == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) {
            d dVar = fVar.I;
            int i3 = dVar.f17639g;
            int o3 = gVar.o();
            d dVar2 = fVar.K;
            int i10 = o3 - dVar2.f17639g;
            dVar.f17641i = cVar.k(dVar);
            dVar2.f17641i = cVar.k(dVar2);
            cVar.d(dVar.f17641i, i3);
            cVar.d(dVar2.f17641i, i10);
            fVar.f17668n = 2;
            fVar.Z = i3;
            int i11 = i10 - i3;
            fVar.V = i11;
            int i12 = fVar.f17649c0;
            if (i11 < i12) {
                fVar.V = i12;
            }
        }
        if (gVar.T[1] == constraintWidget$DimensionBehaviour2 || fVar.T[1] != ConstraintWidget$DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        d dVar3 = fVar.J;
        int i13 = dVar3.f17639g;
        int l3 = gVar.l();
        d dVar4 = fVar.L;
        int i14 = l3 - dVar4.f17639g;
        dVar3.f17641i = cVar.k(dVar3);
        dVar4.f17641i = cVar.k(dVar4);
        cVar.d(dVar3.f17641i, i13);
        cVar.d(dVar4.f17641i, i14);
        if (fVar.f17647b0 > 0 || fVar.f17658h0 == 8) {
            d dVar5 = fVar.M;
            dVar5.f17641i = cVar.k(dVar5);
            cVar.d(dVar5.f17641i, fVar.f17647b0 + i13);
        }
        fVar.f17670o = 2;
        fVar.f17645a0 = i13;
        int i15 = i14 - i13;
        fVar.W = i15;
        int i16 = fVar.f17651d0;
        if (i15 < i16) {
            fVar.W = i16;
        }
    }

    public static final boolean c(int i3, int i10) {
        return (i3 & i10) == i10;
    }
}
