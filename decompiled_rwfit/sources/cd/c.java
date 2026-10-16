package cd;

import a2.h;
import com.amap.api.maps.offlinemap.OfflineMapStatus;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.y0;
import com.google.android.gms.internal.mlkit_vision_common.e0;
import com.google.mlkit.common.MlKitException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.g;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.TraceLevel;
import dd.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public final class c extends bd.a {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f3455k = {7, 5, 4, 3, 1};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f3456l = {4, 20, 52, 104, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f3457m = {0, 348, 1388, 2948, 3988};

    /* renamed from: n, reason: collision with root package name */
    public static final int[][] f3458n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: o, reason: collision with root package name */
    public static final int[][] f3459o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, 187, 139, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, 196, 166}, new int[]{76, 17, 51, 153, 37, AMapEngineUtils.ARROW_LINE_INNER_TEXTURE_ID, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, WebSocketProtocol.PAYLOAD_SHORT, 167}, new int[]{79, 26, 78, 23, 69, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, 199, 175}, new int[]{OfflineMapStatus.EXCEPTION_SDCARD, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 58, 174, 100, 89}};

    /* renamed from: p, reason: collision with root package name */
    public static final int[][] f3460p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f3461g = new ArrayList(11);

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f3462h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final int[] f3463i = new int[2];

    /* renamed from: j, reason: collision with root package name */
    public boolean f3464j;

    public static g n(List list) {
        h aVar;
        int size = list.size() * 2;
        int i3 = size - 1;
        if (((a) list.get(list.size() - 1)).f3451b == null) {
            i3 = size - 2;
        }
        sc.a aVar2 = new sc.a(i3 * 12);
        int i10 = ((a) list.get(0)).f3451b.f3211a;
        int i11 = 0;
        for (int i12 = 11; i12 >= 0; i12--) {
            if (((1 << i12) & i10) != 0) {
                aVar2.j(i11);
            }
            i11++;
        }
        for (int i13 = 1; i13 < list.size(); i13++) {
            a aVar3 = (a) list.get(i13);
            bd.b bVar = aVar3.f3450a;
            for (int i14 = 11; i14 >= 0; i14--) {
                if (((1 << i14) & bVar.f3211a) != 0) {
                    aVar2.j(i11);
                }
                i11++;
            }
            bd.b bVar2 = aVar3.f3451b;
            if (bVar2 != null) {
                for (int i15 = 11; i15 >= 0; i15--) {
                    if (((1 << i15) & bVar2.f3211a) != 0) {
                        aVar2.j(i11);
                    }
                    i11++;
                }
            }
        }
        if (aVar2.d(1)) {
            aVar = new dd.b(aVar2, 2);
        } else if (aVar2.d(2)) {
            int c9 = com.google.zxing.oned.rss.expanded.decoders.b.c(1, 4, aVar2);
            if (c9 == 4) {
                aVar = new dd.a(aVar2, 0);
            } else if (c9 != 5) {
                int c10 = com.google.zxing.oned.rss.expanded.decoders.b.c(1, 5, aVar2);
                if (c10 == 12) {
                    aVar = new dd.b(aVar2, 0);
                } else if (c10 != 13) {
                    switch (com.google.zxing.oned.rss.expanded.decoders.b.c(1, 7, aVar2)) {
                        case 56:
                            aVar = new dd.c(aVar2, "310", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                            break;
                        case 57:
                            aVar = new dd.c(aVar2, "320", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                            break;
                        case 58:
                            aVar = new dd.c(aVar2, "310", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                            break;
                        case 59:
                            aVar = new dd.c(aVar2, "320", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                            break;
                        case 60:
                            aVar = new dd.c(aVar2, "310", Constants.VIA_REPORT_TYPE_WPA_STATE);
                            break;
                        case 61:
                            aVar = new dd.c(aVar2, "320", Constants.VIA_REPORT_TYPE_WPA_STATE);
                            break;
                        case 62:
                            aVar = new dd.c(aVar2, "310", Constants.VIA_REPORT_TYPE_START_GROUP);
                            break;
                        case TraceLevel.ALL /* 63 */:
                            aVar = new dd.c(aVar2, "320", Constants.VIA_REPORT_TYPE_START_GROUP);
                            break;
                        default:
                            throw new IllegalStateException("unknown decoder: " + aVar2);
                    }
                } else {
                    aVar = new dd.b(aVar2, 1);
                }
            } else {
                aVar = new dd.a(aVar2, 1);
            }
        } else {
            aVar = new f(aVar2);
        }
        String B = aVar.B();
        com.google.zxing.h[] hVarArr = ((a) list.get(0)).f3452c.f3215c;
        com.google.zxing.h[] hVarArr2 = ((a) list.get(list.size() - 1)).f3452c.f3215c;
        g gVar = new g(B, null, new com.google.zxing.h[]{hVarArr[0], hVarArr[1], hVarArr2[0], hVarArr2[1]}, BarcodeFormat.RSS_EXPANDED);
        gVar.b(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return gVar;
    }

    @Override // ad.h, com.google.zxing.f
    public final void b() {
        this.f3461g.clear();
        this.f3462h.clear();
    }

    @Override // ad.h
    public final g c(int i3, sc.a aVar, EnumMap enumMap) {
        ArrayList arrayList = this.f3461g;
        arrayList.clear();
        this.f3464j = false;
        try {
            return n(p(aVar, i3));
        } catch (NotFoundException unused) {
            arrayList.clear();
            this.f3464j = true;
            return n(p(aVar, i3));
        }
    }

    public final boolean k() {
        ArrayList arrayList = this.f3461g;
        a aVar = (a) arrayList.get(0);
        bd.b bVar = aVar.f3450a;
        bd.b bVar2 = aVar.f3451b;
        if (bVar2 != null) {
            int i3 = 2;
            int i10 = bVar2.f3212b;
            for (int i11 = 1; i11 < arrayList.size(); i11++) {
                a aVar2 = (a) arrayList.get(i11);
                i10 += aVar2.f3450a.f3212b;
                int i12 = i3 + 1;
                bd.b bVar3 = aVar2.f3451b;
                if (bVar3 != null) {
                    i10 += bVar3.f3212b;
                    i3 += 2;
                } else {
                    i3 = i12;
                }
            }
            if (((i3 - 4) * 211) + (i10 % 211) == bVar.f3211a) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        if (k() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
    
        r1 = new java.util.ArrayList(r11);
        r1.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
    
        return l(r10 + 1, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List l(int r10, java.util.ArrayList r11) {
        /*
            r9 = this;
        L0:
            java.util.ArrayList r0 = r9.f3462h
            int r1 = r0.size()
            if (r10 >= r1) goto L73
            java.lang.Object r0 = r0.get(r10)
            cd.b r0 = (cd.b) r0
            java.util.ArrayList r1 = r9.f3461g
            r1.clear()
            int r2 = r11.size()
            r3 = 0
            r4 = r3
        L19:
            if (r4 >= r2) goto L29
            java.lang.Object r5 = r11.get(r4)
            int r4 = r4 + 1
            cd.b r5 = (cd.b) r5
            java.util.ArrayList r5 = r5.f3453a
            r1.addAll(r5)
            goto L19
        L29:
            java.util.ArrayList r2 = r0.f3453a
            r1.addAll(r2)
            int[][] r2 = cd.c.f3460p
            r4 = r3
        L31:
            r5 = 10
            if (r4 >= r5) goto L70
            r5 = r2[r4]
            int r6 = r1.size()
            int r7 = r5.length
            if (r6 > r7) goto L6d
            r6 = r3
        L3f:
            int r7 = r1.size()
            if (r6 >= r7) goto L57
            java.lang.Object r7 = r1.get(r6)
            cd.a r7 = (cd.a) r7
            bd.c r7 = r7.f3452c
            r8 = r5[r6]
            int r7 = r7.f3213a
            if (r7 == r8) goto L54
            goto L6d
        L54:
            int r6 = r6 + 1
            goto L3f
        L57:
            boolean r2 = r9.k()
            if (r2 == 0) goto L5e
            return r1
        L5e:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r11)
            r1.add(r0)
            int r0 = r10 + 1
            java.util.List r10 = r9.l(r0, r1)     // Catch: com.google.zxing.NotFoundException -> L70
            return r10
        L6d:
            int r4 = r4 + 1
            goto L31
        L70:
            int r10 = r10 + 1
            goto L0
        L73:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cd.c.l(int, java.util.ArrayList):java.util.List");
    }

    public final List m(boolean z5) {
        ArrayList arrayList = this.f3462h;
        List list = null;
        if (arrayList.size() > 25) {
            arrayList.clear();
            return null;
        }
        this.f3461g.clear();
        if (z5) {
            Collections.reverse(arrayList);
        }
        try {
            list = l(0, new ArrayList());
        } catch (NotFoundException unused) {
        }
        if (z5) {
            Collections.reverse(arrayList);
        }
        return list;
    }

    public final bd.b o(sc.a aVar, bd.c cVar, boolean z5, boolean z6) {
        boolean z8;
        boolean z10;
        boolean z11;
        boolean z12;
        int[][] iArr;
        int[] iArr2 = this.f3207b;
        Arrays.fill(iArr2, 0);
        if (z6) {
            ad.h.g(cVar.f3214b[0], aVar, iArr2);
        } else {
            ad.h.f(cVar.f3214b[1], aVar, iArr2);
            int i3 = 0;
            for (int length = iArr2.length - 1; i3 < length; length--) {
                int i10 = iArr2[i3];
                iArr2[i3] = iArr2[length];
                iArr2[length] = i10;
                i3++;
            }
        }
        float d5 = e0.d(iArr2) / 17;
        int[] iArr3 = cVar.f3214b;
        float f2 = (iArr3[1] - iArr3[0]) / 15.0f;
        if (Math.abs(d5 - f2) / f2 > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i11 = 0;
        while (true) {
            int length2 = iArr2.length;
            float[] fArr = this.f3209d;
            float[] fArr2 = this.f3208c;
            int[] iArr4 = this.f3210f;
            int[] iArr5 = this.e;
            if (i11 >= length2) {
                int d8 = e0.d(iArr5);
                int d10 = e0.d(iArr4);
                if (d8 > 13) {
                    z8 = false;
                    z10 = true;
                } else if (d8 < 4) {
                    z10 = false;
                    z8 = true;
                } else {
                    z8 = false;
                    z10 = false;
                }
                if (d10 > 13) {
                    z11 = false;
                    z12 = true;
                } else if (d10 < 4) {
                    z12 = false;
                    z11 = true;
                } else {
                    z11 = false;
                    z12 = false;
                }
                int i12 = (d8 + d10) - 17;
                boolean z13 = (d8 & 1) == 1;
                boolean z14 = (d10 & 1) == 0;
                boolean z15 = z8;
                boolean z16 = z10;
                boolean z17 = z11;
                boolean z18 = z12;
                if (i12 != -1) {
                    if (i12 != 0) {
                        if (i12 != 1) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        if (z13) {
                            if (z14) {
                                throw NotFoundException.getNotFoundInstance();
                            }
                            z16 = true;
                            z15 = z8;
                            z17 = z11;
                            z18 = z12;
                        } else {
                            if (!z14) {
                                throw NotFoundException.getNotFoundInstance();
                            }
                            z18 = true;
                            z15 = z8;
                            z16 = z10;
                            z17 = z11;
                        }
                    } else if (z13) {
                        if (!z14) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        if (d8 < d10) {
                            z15 = true;
                            z18 = true;
                            z16 = z10;
                            z17 = z11;
                        } else {
                            z16 = true;
                            z17 = true;
                            z15 = z8;
                            z18 = z12;
                        }
                    } else if (z14) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (z13) {
                    if (z14) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z15 = true;
                    z16 = z10;
                    z17 = z11;
                    z18 = z12;
                } else {
                    if (!z14) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z17 = true;
                    z15 = z8;
                    z16 = z10;
                    z18 = z12;
                }
                if (z15) {
                    if (z16) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    bd.a.i(iArr5, fArr2);
                }
                if (z16) {
                    bd.a.h(iArr5, fArr2);
                }
                if (z17) {
                    if (z18) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    bd.a.i(iArr4, fArr2);
                }
                if (z18) {
                    bd.a.h(iArr4, fArr);
                }
                int i13 = cVar.f3213a;
                int i14 = (((i13 * 4) + (z5 ? 0 : 2)) + (!z6 ? 1 : 0)) - 1;
                int length3 = iArr5.length - 1;
                int i15 = 0;
                int i16 = 0;
                while (true) {
                    iArr = f3459o;
                    if (length3 < 0) {
                        break;
                    }
                    if (i13 != 0 || !z5 || !z6) {
                        i15 += iArr5[length3] * iArr[i14][length3 * 2];
                    }
                    i16 += iArr5[length3];
                    length3--;
                }
                int i17 = 0;
                for (int length4 = iArr4.length - 1; length4 >= 0; length4--) {
                    if (i13 != 0 || !z5 || !z6) {
                        i17 += iArr4[length4] * iArr[i14][(length4 * 2) + 1];
                    }
                }
                int i18 = i15 + i17;
                if ((i16 & 1) != 0 || i16 > 13 || i16 < 4) {
                    throw NotFoundException.getNotFoundInstance();
                }
                int i19 = (13 - i16) / 2;
                int i20 = f3455k[i19];
                return new bd.b((y0.b(iArr5, i20, true) * f3456l[i19]) + y0.b(iArr4, 9 - i20, false) + f3457m[i19], i18);
            }
            float f10 = (iArr2[i11] * 1.0f) / d5;
            int i21 = (int) (0.5f + f10);
            if (i21 < 1) {
                if (f10 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i21 = 1;
            } else if (i21 > 8) {
                if (f10 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i21 = 8;
            }
            int i22 = i11 / 2;
            if ((i11 & 1) == 0) {
                iArr5[i22] = i21;
                fArr2[i22] = f10 - i21;
            } else {
                iArr4[i22] = i21;
                fArr[i22] = f10 - i21;
            }
            i11++;
        }
    }

    public final List p(sc.a aVar, int i3) {
        boolean z5;
        boolean z6;
        boolean z8 = false;
        while (true) {
            ArrayList arrayList = this.f3461g;
            if (z8) {
                if (k()) {
                    return arrayList;
                }
                ArrayList arrayList2 = this.f3462h;
                boolean isEmpty = arrayList2.isEmpty();
                int i10 = 0;
                boolean z10 = false;
                while (true) {
                    if (i10 >= arrayList2.size()) {
                        z5 = false;
                        break;
                    }
                    b bVar = (b) arrayList2.get(i10);
                    int i11 = bVar.f3454b;
                    ArrayList arrayList3 = bVar.f3453a;
                    if (i11 > i3) {
                        z5 = arrayList3.equals(arrayList);
                        break;
                    }
                    z10 = arrayList3.equals(arrayList);
                    i10++;
                }
                if (!z5 && !z10) {
                    int size = arrayList2.size();
                    int i12 = 0;
                    loop2: while (true) {
                        if (i12 >= size) {
                            z6 = false;
                            break;
                        }
                        Object obj = arrayList2.get(i12);
                        i12++;
                        b bVar2 = (b) obj;
                        int size2 = arrayList.size();
                        int i13 = 0;
                        while (i13 < size2) {
                            Object obj2 = arrayList.get(i13);
                            i13++;
                            a aVar2 = (a) obj2;
                            ArrayList arrayList4 = bVar2.f3453a;
                            int size3 = arrayList4.size();
                            int i14 = 0;
                            while (i14 < size3) {
                                Object obj3 = arrayList4.get(i14);
                                i14++;
                                if (aVar2.equals((a) obj3)) {
                                    break;
                                }
                            }
                        }
                        z6 = true;
                        break loop2;
                    }
                    if (!z6) {
                        arrayList2.add(i10, new b(i3, arrayList));
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            b bVar3 = (b) it.next();
                            if (bVar3.f3453a.size() != arrayList.size()) {
                                ArrayList arrayList5 = bVar3.f3453a;
                                int size4 = arrayList5.size();
                                int i15 = 0;
                                while (true) {
                                    if (i15 >= size4) {
                                        it.remove();
                                        break;
                                    }
                                    Object obj4 = arrayList5.get(i15);
                                    i15++;
                                    if (!arrayList.contains((a) obj4)) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!isEmpty) {
                    List m10 = m(false);
                    if (m10 != null) {
                        return m10;
                    }
                    List m11 = m(true);
                    if (m11 != null) {
                        return m11;
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            }
            try {
                arrayList.add(q(aVar, arrayList, i3));
            } catch (NotFoundException e) {
                if (arrayList.isEmpty()) {
                    throw e;
                }
                z8 = true;
            }
        }
    }

    public final a q(sc.a aVar, ArrayList arrayList, int i3) {
        int i10;
        int i11;
        int i12;
        int f2;
        int i13;
        bd.c cVar;
        int[][] iArr;
        int i14;
        int i15 = 2;
        int i16 = 0;
        int i17 = 1;
        boolean z5 = arrayList.size() % 2 == 0;
        if (this.f3464j) {
            z5 = !z5;
        }
        int i18 = -1;
        boolean z6 = true;
        while (true) {
            int[] iArr2 = this.f3206a;
            iArr2[i16] = i16;
            iArr2[i17] = i16;
            iArr2[i15] = i16;
            int i19 = 3;
            iArr2[3] = i16;
            int i20 = aVar.f18220b;
            int i21 = i18 >= 0 ? i18 : arrayList.isEmpty() ? i16 : ((a) l0.h(i17, arrayList)).f3452c.f3214b[i17];
            int i22 = arrayList.size() % i15 != 0 ? i17 : i16;
            if (this.f3464j) {
                i22 ^= 1;
            }
            boolean z8 = i16;
            while (true) {
                if (i21 >= i20) {
                    break;
                }
                boolean d5 = aVar.d(i21);
                boolean z10 = !d5;
                if (d5) {
                    z8 = z10;
                    break;
                }
                i21++;
                z8 = z10;
            }
            int i23 = i15;
            int i24 = i16;
            boolean z11 = z8;
            int i25 = i21;
            while (i21 < i20) {
                int i26 = i16;
                if (aVar.d(i21) != z11) {
                    iArr2[i24] = iArr2[i24] + i17;
                    i10 = i17;
                    i11 = i19;
                } else {
                    if (i24 == i19) {
                        if (i22 != 0) {
                            int length = iArr2.length;
                            i11 = i19;
                            int i27 = i26;
                            while (true) {
                                i12 = i17;
                                if (i27 >= length / 2) {
                                    break;
                                }
                                int i28 = iArr2[i27];
                                int i29 = (length - i27) - 1;
                                iArr2[i27] = iArr2[i29];
                                iArr2[i29] = i28;
                                i27++;
                                i17 = i12;
                            }
                        } else {
                            i12 = i17;
                            i11 = i19;
                        }
                        if (bd.a.j(iArr2)) {
                            int[] iArr3 = this.f3463i;
                            iArr3[i26] = i25;
                            iArr3[i12] = i21;
                            if (z5) {
                                int i30 = i25 - 1;
                                while (i30 >= 0 && !aVar.d(i30)) {
                                    i30--;
                                }
                                i25 = i30 + 1;
                                i13 = iArr3[i26] - i25;
                                f2 = iArr3[i12];
                            } else {
                                f2 = aVar.f(i21 + 1);
                                i13 = f2 - iArr3[i12];
                            }
                            int i31 = f2;
                            int i32 = i25;
                            System.arraycopy(iArr2, i26, iArr2, i12, iArr2.length - 1);
                            iArr2[i26] = i13;
                            bd.b bVar = null;
                            try {
                                iArr = f3458n;
                            } catch (NotFoundException unused) {
                                cVar = null;
                            }
                            for (i14 = 0; i14 < 6; i14++) {
                                if (ad.h.e(iArr2, iArr[i14], 0.45f) < 0.2f) {
                                    cVar = new bd.c(i14, i32, i31, i3, new int[]{i32, i31});
                                    if (cVar == null) {
                                        int i33 = iArr3[0];
                                        i18 = aVar.d(i33) ? aVar.e(aVar.f(i33)) : aVar.f(aVar.e(i33));
                                    } else {
                                        z6 = false;
                                    }
                                    if (!z6) {
                                        bd.b o3 = o(aVar, cVar, z5, true);
                                        if (!arrayList.isEmpty() && ((a) l0.h(1, arrayList)).f3451b == null) {
                                            throw NotFoundException.getNotFoundInstance();
                                        }
                                        try {
                                            bVar = o(aVar, cVar, z5, false);
                                        } catch (NotFoundException unused2) {
                                        }
                                        return new a(o3, bVar, cVar);
                                    }
                                    i15 = i23;
                                    i16 = 0;
                                    i17 = 1;
                                }
                            }
                            throw NotFoundException.getNotFoundInstance();
                        } else {
                            if (i22 != 0) {
                                int length2 = iArr2.length;
                                for (int i34 = 0; i34 < length2 / 2; i34++) {
                                    int i35 = iArr2[i34];
                                    int i36 = (length2 - i34) - 1;
                                    iArr2[i34] = iArr2[i36];
                                    iArr2[i36] = i35;
                                }
                            }
                            i10 = 1;
                            i26 = 0;
                            i25 += iArr2[0] + iArr2[1];
                            iArr2[0] = iArr2[i23];
                            iArr2[1] = iArr2[i11];
                            iArr2[i23] = 0;
                            iArr2[i11] = 0;
                            i24--;
                        }
                    } else {
                        i10 = i17;
                        i11 = i19;
                        i24++;
                    }
                    iArr2[i24] = i10;
                    z11 = !z11;
                }
                i21++;
                i16 = i26;
                i19 = i11;
                i17 = i10;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
