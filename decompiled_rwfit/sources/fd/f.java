package fd;

import androidx.recyclerview.widget.j2;
import com.example.test.ui.device.activity.f0;
import com.google.zxing.h;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f0 f13573a = new f0(18);

    /* JADX WARN: Multi-variable type inference failed */
    public static b a(d dVar) {
        int i3;
        b bVar;
        int[] iArr;
        int i10;
        j2 j2Var;
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        j2 j2Var2 = null;
        if (dVar == null) {
            return null;
        }
        j2 Q = dVar.Q();
        int i11 = -1;
        j2[] j2VarArr = (j2[]) dVar.f12630c;
        boolean z5 = dVar.e;
        b bVar2 = (b) dVar.f12629b;
        if (Q == null) {
            iArr = null;
            bVar = 0;
        } else {
            h hVar5 = z5 ? bVar2.f13561b : bVar2.f13563d;
            h hVar6 = z5 ? bVar2.f13562c : bVar2.e;
            int z6 = dVar.z((int) hVar5.f11248b);
            int z8 = dVar.z((int) hVar6.f11248b);
            int i12 = -1;
            int i13 = 0;
            int i14 = 1;
            while (true) {
                i3 = Q.f2641f;
                if (z6 >= z8) {
                    break;
                }
                j2 j2Var3 = j2VarArr[z6];
                if (j2Var3 == null) {
                    j2Var = j2Var2;
                } else {
                    j2Var3.c();
                    int i15 = j2Var3.f2641f;
                    j2Var = j2Var2;
                    int i16 = i15 - i12;
                    if (i16 == 0) {
                        i13++;
                    } else if (i16 == 1) {
                        i14 = Math.max(i14, i13);
                        i12 = j2Var3.f2641f;
                        i13 = 1;
                    } else if (i15 >= i3) {
                        j2VarArr[z6] = j2Var;
                    } else {
                        i13 = 1;
                        i12 = i15;
                    }
                }
                z6++;
                j2Var2 = j2Var;
            }
            bVar = j2Var2;
            iArr = new int[i3];
            for (j2 j2Var4 : j2VarArr) {
                if (j2Var4 != null && (i10 = j2Var4.f2641f) < i3) {
                    iArr[i10] = iArr[i10] + 1;
                }
            }
        }
        if (iArr == null) {
            return bVar;
        }
        for (int i17 : iArr) {
            i11 = Math.max(i11, i17);
        }
        int i18 = 0;
        for (int i19 : iArr) {
            i18 += i11 - i19;
            if (i19 > 0) {
                break;
            }
        }
        for (int i20 = 0; i18 > 0 && j2VarArr[i20] == null; i20++) {
            i18--;
        }
        int i21 = 0;
        for (int length = iArr.length - 1; length >= 0; length--) {
            int i22 = iArr[length];
            i21 += i11 - i22;
            if (i22 > 0) {
                break;
            }
        }
        for (int length2 = j2VarArr.length - 1; i21 > 0 && j2VarArr[length2] == null; length2--) {
            i21--;
        }
        h hVar7 = bVar2.f13561b;
        h hVar8 = bVar2.f13563d;
        if (i18 > 0) {
            h hVar9 = z5 ? hVar7 : hVar8;
            h hVar10 = new h(hVar9.f11247a, ((int) hVar9.f11248b) - i18 >= 0 ? r6 : 0);
            if (z5) {
                hVar2 = hVar8;
                hVar = hVar10;
            } else {
                hVar = hVar7;
                hVar2 = hVar10;
            }
        } else {
            hVar = hVar7;
            hVar2 = hVar8;
        }
        h hVar11 = bVar2.f13562c;
        h hVar12 = bVar2.e;
        if (i21 > 0) {
            h hVar13 = z5 ? hVar11 : hVar12;
            int i23 = ((int) hVar13.f11248b) + i21;
            int i24 = bVar2.f13560a.f18222b;
            if (i23 >= i24) {
                i23 = i24 - 1;
            }
            h hVar14 = new h(hVar13.f11247a, i23);
            if (z5) {
                hVar4 = hVar12;
                hVar3 = hVar14;
            } else {
                hVar3 = hVar11;
                hVar4 = hVar14;
            }
        } else {
            hVar3 = hVar11;
            hVar4 = hVar12;
        }
        return new b(bVar2.f13560a, hVar, hVar3, hVar2, hVar4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0501, code lost:
    
        r8 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0505, code lost:
    
        if (r8 == 924) goto L283;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x050b, code lost:
    
        if (r15 >= r25[0]) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x050f, code lost:
    
        if (r25[r15] >= 900) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0517, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x051b, code lost:
    
        if (r7 >= 6) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x051d, code lost:
    
        ((java.lang.StringBuilder) r4.f18241b).append((char) (((byte) (r13 >> ((5 - r7) * 8))) & 255));
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0534, code lost:
    
        r20 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0497  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static sc.d b(int[] r25, int r26, int[] r27) {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.f.b(int[], int, int[]):sc.d");
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x0032, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0032, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0032, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c A[EDGE_INSN: B:31:0x005c->B:32:0x005c BREAK  A[LOOP:2: B:19:0x0043->B:27:0x0043], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.recyclerview.widget.j2 c(sc.b r19, int r20, int r21, boolean r22, int r23, int r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.f.c(sc.b, int, int, boolean, int, int, int, int):androidx.recyclerview.widget.j2");
    }

    public static d d(sc.b bVar, b bVar2, h hVar, boolean z5, int i3, int i10) {
        boolean z6 = z5;
        d dVar = new d(bVar2, z5);
        int i11 = 0;
        while (i11 < 2) {
            int i12 = i11 == 0 ? 1 : -1;
            int i13 = (int) hVar.f11247a;
            int i14 = (int) hVar.f11248b;
            while (i14 <= bVar2.f13567i && i14 >= bVar2.f13566h) {
                j2 c9 = c(bVar, 0, bVar.f18221a, z6, i13, i14, i3, i10);
                if (c9 != null) {
                    ((j2[]) dVar.f12630c)[dVar.z(i14)] = c9;
                    i13 = z5 ? c9.f2638b : c9.f2639c;
                }
                i14 += i12;
                z6 = z5;
            }
            i11++;
            z6 = z5;
        }
        return dVar;
    }
}
