package ad;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.ArrayList;
import java.util.EnumMap;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f253c = {1, 1, 2};

    /* renamed from: a, reason: collision with root package name */
    public final Object f254a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f255b;

    public j(int i3) {
        switch (i3) {
            case 1:
                this.f254a = new ArrayList();
                this.f255b = new ArrayList();
                break;
            default:
                this.f254a = new i(1);
                this.f255b = new i(0);
                break;
        }
    }

    public void a(String str, int[] iArr) {
        ((ArrayList) this.f254a).add(iArr);
        ((ArrayList) this.f255b).add(str);
    }

    public com.google.zxing.g b(int i3, int i10, sc.a aVar) {
        EnumMap enumMap;
        int[] m10 = k.m(aVar, i10, false, f253c, new int[3]);
        try {
            return ((i) this.f255b).a(i3, aVar, m10);
        } catch (ReaderException unused) {
            i iVar = (i) this.f254a;
            StringBuilder sb2 = iVar.f252b;
            sb2.setLength(0);
            int[] iArr = iVar.f251a;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            int i11 = aVar.f18220b;
            int i12 = m10[1];
            int i13 = 0;
            for (int i14 = 0; i14 < 2 && i12 < i11; i14++) {
                int i15 = k.i(aVar, iArr, i12, k.f258g);
                sb2.append((char) ((i15 % 10) + 48));
                for (int i16 : iArr) {
                    i12 += i16;
                }
                if (i15 >= 10) {
                    i13 |= 1 << (1 - i14);
                }
                if (i14 != 1) {
                    i12 = aVar.f(aVar.e(i12));
                }
            }
            if (sb2.length() != 2) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (Integer.parseInt(sb2.toString()) % 4 != i13) {
                throw NotFoundException.getNotFoundInstance();
            }
            String sb3 = sb2.toString();
            if (sb3.length() != 2) {
                enumMap = null;
            } else {
                enumMap = new EnumMap(ResultMetadataType.class);
                enumMap.put((EnumMap) ResultMetadataType.ISSUE_NUMBER, (ResultMetadataType) Integer.valueOf(sb3));
            }
            float f2 = i3;
            com.google.zxing.g gVar = new com.google.zxing.g(sb3, null, new com.google.zxing.h[]{new com.google.zxing.h((m10[0] + m10[1]) / 2.0f, f2), new com.google.zxing.h(i12, f2)}, BarcodeFormat.UPC_EAN_EXTENSION);
            if (enumMap != null) {
                gVar.a(enumMap);
            }
            return gVar;
        }
    }
}
