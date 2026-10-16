package ad;

import com.amap.api.maps.utils.SpatialRelationUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.open.log.TraceLevel;
import java.util.EnumMap;

/* loaded from: classes.dex */
public final class e extends k {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f237j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f238k = {1, 1, 1, 1, 1, 1};

    /* renamed from: l, reason: collision with root package name */
    public static final int[][] f239l = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f240h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f241i;

    public e(int i3) {
        this.f240h = i3;
        switch (i3) {
            case 1:
                this.f241i = new int[4];
                break;
            case 2:
                this.f241i = new int[4];
                break;
            case 3:
                this.f241i = new e(0);
                break;
            default:
                this.f241i = new int[4];
                break;
        }
    }

    public static com.google.zxing.g p(com.google.zxing.g gVar) {
        String str = gVar.f11243a;
        if (str.charAt(0) != '0') {
            throw FormatException.getFormatInstance();
        }
        com.google.zxing.g gVar2 = new com.google.zxing.g(str.substring(1), null, gVar.f11245c, BarcodeFormat.UPC_A);
        EnumMap enumMap = gVar.e;
        if (enumMap != null) {
            gVar2.a(enumMap);
        }
        return gVar2;
    }

    @Override // ad.h, com.google.zxing.f
    public com.google.zxing.g a(com.google.zxing.a aVar, EnumMap enumMap) {
        switch (this.f240h) {
            case 3:
                return p(((e) this.f241i).a(aVar, enumMap));
            default:
                return super.a(aVar, enumMap);
        }
    }

    @Override // ad.k, ad.h
    public com.google.zxing.g c(int i3, sc.a aVar, EnumMap enumMap) {
        switch (this.f240h) {
            case 3:
                return p(((e) this.f241i).c(i3, aVar, enumMap));
            default:
                return super.c(i3, aVar, enumMap);
        }
    }

    @Override // ad.k
    public boolean h(String str) {
        switch (this.f240h) {
            case 1:
                char[] cArr = new char[6];
                str.getChars(1, 7, cArr, 0);
                StringBuilder sb2 = new StringBuilder(12);
                sb2.append(str.charAt(0));
                char c9 = cArr[5];
                switch (c9) {
                    case TraceLevel.ABOVE_WARN /* 48 */:
                    case '1':
                    case SpatialRelationUtil.MIN_OFFSET_DEGREE /* 50 */:
                        sb2.append(cArr, 0, 2);
                        sb2.append(c9);
                        sb2.append("0000");
                        sb2.append(cArr, 2, 3);
                        break;
                    case '3':
                        sb2.append(cArr, 0, 3);
                        sb2.append("00000");
                        sb2.append(cArr, 3, 2);
                        break;
                    case '4':
                        sb2.append(cArr, 0, 4);
                        sb2.append("00000");
                        sb2.append(cArr[4]);
                        break;
                    default:
                        sb2.append(cArr, 0, 5);
                        sb2.append("0000");
                        sb2.append(c9);
                        break;
                }
                if (str.length() >= 8) {
                    sb2.append(str.charAt(7));
                }
                return super.h(sb2.toString());
            default:
                return super.h(str);
        }
    }

    @Override // ad.k
    public int[] j(sc.a aVar, int i3) {
        switch (this.f240h) {
            case 1:
                return k.m(aVar, i3, true, f238k, new int[6]);
            default:
                return super.j(aVar, i3);
        }
    }

    @Override // ad.k
    public final int k(sc.a aVar, int[] iArr, StringBuilder sb2) {
        int[][] iArr2;
        switch (this.f240h) {
            case 0:
                int[] iArr3 = (int[]) this.f241i;
                iArr3[0] = 0;
                iArr3[1] = 0;
                iArr3[2] = 0;
                iArr3[3] = 0;
                int i3 = aVar.f18220b;
                int i10 = iArr[1];
                int i11 = 0;
                for (int i12 = 0; i12 < 6 && i10 < i3; i12++) {
                    int i13 = k.i(aVar, iArr3, i10, k.f258g);
                    sb2.append((char) ((i13 % 10) + 48));
                    for (int i14 : iArr3) {
                        i10 += i14;
                    }
                    if (i13 >= 10) {
                        i11 |= 1 << (5 - i12);
                    }
                }
                for (int i15 = 0; i15 < 10; i15++) {
                    if (i11 == f237j[i15]) {
                        sb2.insert(0, (char) (i15 + 48));
                        int i16 = k.m(aVar, i10, true, k.e, new int[5])[1];
                        for (int i17 = 0; i17 < 6 && i16 < i3; i17++) {
                            sb2.append((char) (k.i(aVar, iArr3, i16, k.f257f) + 48));
                            for (int i18 : iArr3) {
                                i16 += i18;
                            }
                        }
                        return i16;
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            case 1:
                int[] iArr4 = (int[]) this.f241i;
                iArr4[0] = 0;
                iArr4[1] = 0;
                iArr4[2] = 0;
                iArr4[3] = 0;
                int i19 = aVar.f18220b;
                int i20 = iArr[1];
                int i21 = 0;
                for (int i22 = 0; i22 < 6 && i20 < i19; i22++) {
                    int i23 = k.i(aVar, iArr4, i20, k.f258g);
                    sb2.append((char) ((i23 % 10) + 48));
                    for (int i24 : iArr4) {
                        i20 += i24;
                    }
                    if (i23 >= 10) {
                        i21 |= 1 << (5 - i22);
                    }
                }
                for (int i25 = 0; i25 <= 1; i25++) {
                    for (int i26 = 0; i26 < 10; i26++) {
                        if (i21 == f239l[i25][i26]) {
                            sb2.insert(0, (char) (i25 + 48));
                            sb2.append((char) (i26 + 48));
                            return i20;
                        }
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            case 2:
                int[] iArr5 = (int[]) this.f241i;
                iArr5[0] = 0;
                iArr5[1] = 0;
                iArr5[2] = 0;
                iArr5[3] = 0;
                int i27 = aVar.f18220b;
                int i28 = iArr[1];
                int i29 = 0;
                while (true) {
                    iArr2 = k.f257f;
                    if (i29 < 4 && i28 < i27) {
                        sb2.append((char) (k.i(aVar, iArr5, i28, iArr2) + 48));
                        for (int i30 : iArr5) {
                            i28 += i30;
                        }
                        i29++;
                    }
                }
                int i31 = k.m(aVar, i28, true, k.e, new int[5])[1];
                for (int i32 = 0; i32 < 4 && i31 < i27; i32++) {
                    sb2.append((char) (k.i(aVar, iArr5, i31, iArr2) + 48));
                    for (int i33 : iArr5) {
                        i31 += i33;
                    }
                }
                return i31;
            default:
                return ((e) this.f241i).k(aVar, iArr, sb2);
        }
    }

    @Override // ad.k
    public com.google.zxing.g l(int i3, sc.a aVar, int[] iArr, EnumMap enumMap) {
        switch (this.f240h) {
            case 3:
                return p(((e) this.f241i).l(i3, aVar, iArr, enumMap));
            default:
                return super.l(i3, aVar, iArr, enumMap);
        }
    }

    @Override // ad.k
    public final BarcodeFormat o() {
        switch (this.f240h) {
            case 0:
                return BarcodeFormat.EAN_13;
            case 1:
                return BarcodeFormat.UPC_E;
            case 2:
                return BarcodeFormat.EAN_8;
            default:
                return BarcodeFormat.UPC_A;
        }
    }
}
