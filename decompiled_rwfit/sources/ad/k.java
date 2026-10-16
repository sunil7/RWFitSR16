package ad;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;

/* loaded from: classes.dex */
public abstract class k extends h {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f256d = {1, 1, 1};
    public static final int[] e = {1, 1, 1, 1, 1};

    /* renamed from: f, reason: collision with root package name */
    public static final int[][] f257f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[][] f258g;

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f259a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    public final j f260b = new j(0);

    /* renamed from: c, reason: collision with root package name */
    public final j f261c = new j(1);

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f257f = iArr;
        int[][] iArr2 = new int[20][];
        f258g = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i3 = 10; i3 < 20; i3++) {
            int[] iArr3 = f257f[i3 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i10 = 0; i10 < iArr3.length; i10++) {
                iArr4[i10] = iArr3[(iArr3.length - i10) - 1];
            }
            f258g[i3] = iArr4;
        }
    }

    public static int i(sc.a aVar, int[] iArr, int i3, int[][] iArr2) {
        h.f(i3, aVar, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            float e10 = h.e(iArr, iArr2[i11], 0.7f);
            if (e10 < f2) {
                i10 = i11;
                f2 = e10;
            }
        }
        if (i10 >= 0) {
            return i10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] m(sc.a aVar, int i3, boolean z5, int[] iArr, int[] iArr2) {
        int i10 = aVar.f18220b;
        int f2 = z5 ? aVar.f(i3) : aVar.e(i3);
        int length = iArr.length;
        boolean z6 = z5;
        int i11 = 0;
        int i12 = f2;
        while (f2 < i10) {
            if (aVar.d(f2) != z6) {
                iArr2[i11] = iArr2[i11] + 1;
            } else {
                if (i11 != length - 1) {
                    i11++;
                } else {
                    if (h.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i12, f2};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i13 = i11 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i11] = 0;
                    i11--;
                }
                iArr2[i11] = 1;
                z6 = !z6;
            }
            f2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] n(sc.a aVar) {
        int[] iArr = new int[3];
        int[] iArr2 = null;
        boolean z5 = false;
        int i3 = 0;
        while (!z5) {
            Arrays.fill(iArr, 0, 3, 0);
            iArr2 = m(aVar, i3, false, f256d, iArr);
            int i10 = iArr2[0];
            int i11 = iArr2[1];
            int i12 = i10 - (i11 - i10);
            if (i12 >= 0) {
                z5 = aVar.h(i12, i10);
            }
            i3 = i11;
        }
        return iArr2;
    }

    @Override // ad.h
    public com.google.zxing.g c(int i3, sc.a aVar, EnumMap enumMap) {
        return l(i3, aVar, n(aVar), enumMap);
    }

    public boolean h(String str) {
        int length = str.length();
        if (length != 0) {
            int i3 = length - 1;
            int digit = Character.digit(str.charAt(i3), 10);
            CharSequence subSequence = str.subSequence(0, i3);
            int length2 = subSequence.length();
            int i10 = 0;
            for (int i11 = length2 - 1; i11 >= 0; i11 -= 2) {
                int charAt = subSequence.charAt(i11) - '0';
                if (charAt < 0 || charAt > 9) {
                    throw FormatException.getFormatInstance();
                }
                i10 += charAt;
            }
            int i12 = i10 * 3;
            for (int i13 = length2 - 2; i13 >= 0; i13 -= 2) {
                int charAt2 = subSequence.charAt(i13) - '0';
                if (charAt2 < 0 || charAt2 > 9) {
                    throw FormatException.getFormatInstance();
                }
                i12 += charAt2;
            }
            if ((1000 - i12) % 10 == digit) {
                return true;
            }
        }
        return false;
    }

    public int[] j(sc.a aVar, int i3) {
        return m(aVar, i3, false, f256d, new int[3]);
    }

    public abstract int k(sc.a aVar, int[] iArr, StringBuilder sb2);

    public com.google.zxing.g l(int i3, sc.a aVar, int[] iArr, EnumMap enumMap) {
        int i10;
        if (enumMap != null && enumMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK) != null) {
            throw new ClassCastException();
        }
        StringBuilder sb2 = this.f259a;
        sb2.setLength(0);
        int[] j4 = j(aVar, k(aVar, iArr, sb2));
        int i11 = j4[1];
        int i12 = (i11 - j4[0]) + i11;
        if (i12 >= aVar.f18220b || !aVar.h(i11, i12)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String sb3 = sb2.toString();
        if (sb3.length() < 8) {
            throw FormatException.getFormatInstance();
        }
        if (!h(sb3)) {
            throw ChecksumException.getChecksumInstance();
        }
        BarcodeFormat o3 = o();
        float f2 = i3;
        String str = null;
        com.google.zxing.g gVar = new com.google.zxing.g(sb3, null, new com.google.zxing.h[]{new com.google.zxing.h((iArr[1] + iArr[0]) / 2.0f, f2), new com.google.zxing.h((j4[1] + j4[0]) / 2.0f, f2)}, o3);
        try {
            com.google.zxing.g b3 = this.f260b.b(i3, j4[1], aVar);
            gVar.b(ResultMetadataType.UPC_EAN_EXTENSION, b3.f11243a);
            gVar.a(b3.e);
            com.google.zxing.h[] hVarArr = b3.f11245c;
            com.google.zxing.h[] hVarArr2 = gVar.f11245c;
            if (hVarArr2 == null) {
                gVar.f11245c = hVarArr;
            } else if (hVarArr != null && hVarArr.length > 0) {
                com.google.zxing.h[] hVarArr3 = new com.google.zxing.h[hVarArr2.length + hVarArr.length];
                System.arraycopy(hVarArr2, 0, hVarArr3, 0, hVarArr2.length);
                System.arraycopy(hVarArr, 0, hVarArr3, hVarArr2.length, hVarArr.length);
                gVar.f11245c = hVarArr3;
            }
            i10 = b3.f11243a.length();
        } catch (ReaderException unused) {
            i10 = 0;
        }
        int[] iArr2 = enumMap == null ? null : (int[]) enumMap.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
        if (iArr2 != null) {
            for (int i13 : iArr2) {
                if (i10 != i13) {
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        if (o3 == BarcodeFormat.EAN_13 || o3 == BarcodeFormat.UPC_A) {
            j jVar = this.f261c;
            synchronized (jVar) {
                if (((ArrayList) jVar.f254a).isEmpty()) {
                    jVar.a("US/CA", new int[]{0, 19});
                    jVar.a("US", new int[]{30, 39});
                    jVar.a("US/CA", new int[]{60, 139});
                    jVar.a("FR", new int[]{300, 379});
                    jVar.a("BG", new int[]{380});
                    jVar.a("SI", new int[]{383});
                    jVar.a("HR", new int[]{385});
                    jVar.a("BA", new int[]{387});
                    jVar.a("DE", new int[]{400, 440});
                    jVar.a("JP", new int[]{450, 459});
                    jVar.a("RU", new int[]{460, 469});
                    jVar.a("TW", new int[]{471});
                    jVar.a("EE", new int[]{474});
                    jVar.a("LV", new int[]{475});
                    jVar.a("AZ", new int[]{476});
                    jVar.a("LT", new int[]{477});
                    jVar.a("UZ", new int[]{478});
                    jVar.a("LK", new int[]{479});
                    jVar.a("PH", new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH});
                    jVar.a("BY", new int[]{481});
                    jVar.a("UA", new int[]{482});
                    jVar.a("MD", new int[]{484});
                    jVar.a("AM", new int[]{485});
                    jVar.a("GE", new int[]{486});
                    jVar.a("KZ", new int[]{487});
                    jVar.a("HK", new int[]{489});
                    jVar.a("JP", new int[]{490, 499});
                    jVar.a("GB", new int[]{500, 509});
                    jVar.a("GR", new int[]{520});
                    jVar.a("LB", new int[]{528});
                    jVar.a("CY", new int[]{529});
                    jVar.a("MK", new int[]{531});
                    jVar.a("MT", new int[]{535});
                    jVar.a("IE", new int[]{539});
                    jVar.a("BE/LU", new int[]{540, 549});
                    jVar.a("PT", new int[]{560});
                    jVar.a("IS", new int[]{569});
                    jVar.a("DK", new int[]{570, 579});
                    jVar.a("PL", new int[]{590});
                    jVar.a("RO", new int[]{594});
                    jVar.a("HU", new int[]{599});
                    jVar.a("ZA", new int[]{FontStyle.WEIGHT_SEMI_BOLD, 601});
                    jVar.a("GH", new int[]{603});
                    jVar.a("BH", new int[]{608});
                    jVar.a("MU", new int[]{609});
                    jVar.a("MA", new int[]{611});
                    jVar.a("DZ", new int[]{613});
                    jVar.a("KE", new int[]{616});
                    jVar.a("CI", new int[]{618});
                    jVar.a("TN", new int[]{619});
                    jVar.a("SY", new int[]{621});
                    jVar.a("EG", new int[]{622});
                    jVar.a("LY", new int[]{624});
                    jVar.a("JO", new int[]{625});
                    jVar.a("IR", new int[]{626});
                    jVar.a("KW", new int[]{627});
                    jVar.a("SA", new int[]{628});
                    jVar.a("AE", new int[]{629});
                    jVar.a("FI", new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, 649});
                    jVar.a("CN", new int[]{690, 695});
                    jVar.a("NO", new int[]{FontStyle.WEIGHT_BOLD, 709});
                    jVar.a("IL", new int[]{729});
                    jVar.a("SE", new int[]{730, 739});
                    jVar.a("GT", new int[]{740});
                    jVar.a("SV", new int[]{741});
                    jVar.a("HN", new int[]{742});
                    jVar.a("NI", new int[]{743});
                    jVar.a("CR", new int[]{744});
                    jVar.a("PA", new int[]{745});
                    jVar.a("DO", new int[]{746});
                    jVar.a("MX", new int[]{750});
                    jVar.a("CA", new int[]{754, 755});
                    jVar.a("VE", new int[]{759});
                    jVar.a("CH", new int[]{760, 769});
                    jVar.a("CO", new int[]{770});
                    jVar.a("UY", new int[]{773});
                    jVar.a("PE", new int[]{775});
                    jVar.a("BO", new int[]{777});
                    jVar.a("AR", new int[]{779});
                    jVar.a("CL", new int[]{780});
                    jVar.a("PY", new int[]{784});
                    jVar.a("PE", new int[]{785});
                    jVar.a("EC", new int[]{786});
                    jVar.a("BR", new int[]{789, 790});
                    jVar.a("IT", new int[]{800, 839});
                    jVar.a("ES", new int[]{840, 849});
                    jVar.a("CU", new int[]{850});
                    jVar.a("SK", new int[]{858});
                    jVar.a("CZ", new int[]{859});
                    jVar.a("YU", new int[]{860});
                    jVar.a("MN", new int[]{865});
                    jVar.a("KP", new int[]{867});
                    jVar.a("TR", new int[]{868, 869});
                    jVar.a("NL", new int[]{870, 879});
                    jVar.a("KR", new int[]{880});
                    jVar.a("TH", new int[]{885});
                    jVar.a("SG", new int[]{888});
                    jVar.a("IN", new int[]{890});
                    jVar.a("VN", new int[]{893});
                    jVar.a("PK", new int[]{896});
                    jVar.a("ID", new int[]{899});
                    jVar.a("AT", new int[]{FontStyle.WEIGHT_BLACK, 919});
                    jVar.a("AU", new int[]{930, 939});
                    jVar.a("AZ", new int[]{940, 949});
                    jVar.a("MY", new int[]{955});
                    jVar.a("MO", new int[]{958});
                }
            }
            int parseInt = Integer.parseInt(sb3.substring(0, 3));
            int size = ((ArrayList) jVar.f254a).size();
            int i14 = 0;
            while (true) {
                if (i14 >= size) {
                    break;
                }
                int[] iArr3 = (int[]) ((ArrayList) jVar.f254a).get(i14);
                int i15 = iArr3[0];
                if (parseInt < i15) {
                    break;
                }
                if (iArr3.length != 1) {
                    i15 = iArr3[1];
                }
                if (parseInt <= i15) {
                    str = (String) ((ArrayList) jVar.f255b).get(i14);
                    break;
                }
                i14++;
            }
            if (str != null) {
                gVar.b(ResultMetadataType.POSSIBLE_COUNTRY, str);
            }
        }
        gVar.b(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]E" + (o3 == BarcodeFormat.EAN_8 ? 4 : 0));
        return gVar;
    }

    public abstract BarcodeFormat o();
}
