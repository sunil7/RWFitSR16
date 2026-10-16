package bd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.g;
import com.google.zxing.h;
import java.util.ArrayList;
import java.util.EnumMap;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f3218i = {1, 10, 34, 70, WebSocketProtocol.PAYLOAD_SHORT};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f3219j = {4, 20, 48, 81};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f3220k = {0, 161, 961, 2015, 2715};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f3221l = {0, 336, 1036, 1516};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f3222m = {8, 6, 4, 3, 1};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f3223n = {2, 4, 6, 8};

    /* renamed from: o, reason: collision with root package name */
    public static final int[][] f3224o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f3225g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f3226h = new ArrayList();

    public static void k(ArrayList arrayList, d dVar) {
        if (dVar == null) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            d dVar2 = (d) obj;
            if (dVar2.f3211a == dVar.f3211a) {
                dVar2.f3217d++;
                return;
            }
        }
        arrayList.add(dVar);
    }

    @Override // ad.h, com.google.zxing.f
    public final void b() {
        this.f3225g.clear();
        this.f3226h.clear();
    }

    @Override // ad.h
    public final g c(int i3, sc.a aVar, EnumMap enumMap) {
        d m10 = m(aVar, false, i3, enumMap);
        ArrayList arrayList = this.f3225g;
        k(arrayList, m10);
        aVar.i();
        d m11 = m(aVar, true, i3, enumMap);
        ArrayList arrayList2 = this.f3226h;
        k(arrayList2, m11);
        aVar.i();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            d dVar = (d) obj;
            if (dVar.f3217d > 1) {
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    d dVar2 = (d) obj2;
                    if (dVar2.f3217d > 1) {
                        int i12 = ((dVar2.f3212b * 16) + dVar.f3212b) % 79;
                        c cVar = dVar.f3216c;
                        int i13 = cVar.f3213a * 9;
                        c cVar2 = dVar2.f3216c;
                        int i14 = i13 + cVar2.f3213a;
                        if (i14 > 72) {
                            i14--;
                        }
                        if (i14 > 8) {
                            i14--;
                        }
                        if (i12 == i14) {
                            String valueOf = String.valueOf((dVar.f3211a * 4537077) + dVar2.f3211a);
                            StringBuilder sb2 = new StringBuilder(14);
                            for (int length = 13 - valueOf.length(); length > 0; length--) {
                                sb2.append('0');
                            }
                            sb2.append(valueOf);
                            int i15 = 0;
                            for (int i16 = 0; i16 < 13; i16++) {
                                int charAt = sb2.charAt(i16) - '0';
                                if ((i16 & 1) == 0) {
                                    charAt *= 3;
                                }
                                i15 += charAt;
                            }
                            int i17 = 10 - (i15 % 10);
                            if (i17 == 10) {
                                i17 = 0;
                            }
                            sb2.append(i17);
                            h[] hVarArr = cVar.f3215c;
                            h[] hVarArr2 = cVar2.f3215c;
                            g gVar = new g(sb2.toString(), null, new h[]{hVarArr[0], hVarArr[1], hVarArr2[0], hVarArr2[1]}, BarcodeFormat.RSS_14);
                            gVar.b(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
                            return gVar;
                        }
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x0093, code lost:
    
        if (r6 < 4) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0095, code lost:
    
        r17 = false;
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x009a, code lost:
    
        r16 = false;
        r17 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00b1, code lost:
    
        if (r6 < 4) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final bd.b l(sc.a r20, bd.c r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bd.e.l(sc.a, bd.c, boolean):bd.b");
    }

    public final d m(sc.a aVar, boolean z5, int i3, EnumMap enumMap) {
        try {
            c o3 = o(aVar, i3, z5, n(aVar, z5));
            if (enumMap != null && enumMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK) != null) {
                throw new ClassCastException();
            }
            b l3 = l(aVar, o3, true);
            b l5 = l(aVar, o3, false);
            return new d((l3.f3211a * 1597) + l5.f3211a, (l5.f3212b * 4) + l3.f3212b, o3);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public final int[] n(sc.a aVar, boolean z5) {
        int[] iArr = this.f3206a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i3 = aVar.f18220b;
        int i10 = 0;
        boolean z6 = false;
        while (i10 < i3) {
            z6 = !aVar.d(i10);
            if (z5 == z6) {
                break;
            }
            i10++;
        }
        int i11 = 0;
        int i12 = i10;
        while (i10 < i3) {
            if (aVar.d(i10) != z6) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 != 3) {
                    i11++;
                } else {
                    if (a.j(iArr)) {
                        return new int[]{i12, i10};
                    }
                    i12 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i11--;
                }
                iArr[i11] = 1;
                z6 = !z6;
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final c o(sc.a aVar, int i3, boolean z5, int[] iArr) {
        int i10;
        int i11;
        boolean d5 = aVar.d(iArr[0]);
        int i12 = iArr[0] - 1;
        while (i12 >= 0 && d5 != aVar.d(i12)) {
            i12--;
        }
        int i13 = i12 + 1;
        int i14 = iArr[0] - i13;
        int[] iArr2 = this.f3206a;
        System.arraycopy(iArr2, 0, iArr2, 1, iArr2.length - 1);
        iArr2[0] = i14;
        int[][] iArr3 = f3224o;
        for (int i15 = 0; i15 < 9; i15++) {
            if (ad.h.e(iArr2, iArr3[i15], 0.45f) < 0.2f) {
                int i16 = iArr[1];
                if (z5) {
                    int i17 = aVar.f18220b - 1;
                    i10 = i17 - i16;
                    i11 = i17 - i13;
                } else {
                    i10 = i16;
                    i11 = i13;
                }
                return new c(i15, i11, i10, i3, new int[]{i13, i16});
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
