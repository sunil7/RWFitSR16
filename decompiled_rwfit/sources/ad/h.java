package ad;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.EnumMap;

/* loaded from: classes.dex */
public abstract class h implements com.google.zxing.f {
    public static float e(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i3 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            i3 += iArr[i11];
            i10 += iArr2[i11];
        }
        if (i3 < i10) {
            return Float.POSITIVE_INFINITY;
        }
        float f10 = i3;
        float f11 = f10 / i10;
        float f12 = f2 * f11;
        float f13 = 0.0f;
        for (int i12 = 0; i12 < length; i12++) {
            float f14 = iArr2[i12] * f11;
            float f15 = iArr[i12];
            float f16 = f15 > f14 ? f15 - f14 : f14 - f15;
            if (f16 > f12) {
                return Float.POSITIVE_INFINITY;
            }
            f13 += f16;
        }
        return f13 / f10;
    }

    public static void f(int i3, sc.a aVar, int[] iArr) {
        int length = iArr.length;
        int i10 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int i11 = aVar.f18220b;
        if (i3 >= i11) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z5 = !aVar.d(i3);
        while (i3 < i11) {
            if (aVar.d(i3) != z5) {
                iArr[i10] = iArr[i10] + 1;
            } else {
                i10++;
                if (i10 == length) {
                    break;
                }
                iArr[i10] = 1;
                z5 = !z5;
            }
            i3++;
        }
        if (i10 != length) {
            if (i10 != length - 1 || i3 != i11) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static void g(int i3, sc.a aVar, int[] iArr) {
        int length = iArr.length;
        boolean d5 = aVar.d(i3);
        while (i3 > 0 && length >= 0) {
            i3--;
            if (aVar.d(i3) != d5) {
                length--;
                d5 = !d5;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        f(i3 + 1, aVar, iArr);
    }

    @Override // com.google.zxing.f
    public com.google.zxing.g a(com.google.zxing.a aVar, EnumMap enumMap) {
        try {
            return d(aVar, enumMap);
        } catch (NotFoundException e) {
            if (enumMap != null) {
                enumMap.containsKey(DecodeHintType.TRY_HARDER);
            }
            throw e;
        }
    }

    @Override // com.google.zxing.f
    public void b() {
    }

    public abstract com.google.zxing.g c(int i3, sc.a aVar, EnumMap enumMap);

    public final com.google.zxing.g d(com.google.zxing.a aVar, EnumMap enumMap) {
        EnumMap enumMap2;
        int i3;
        com.google.zxing.h hVar;
        com.google.zxing.a aVar2 = aVar;
        EnumMap enumMap3 = enumMap;
        com.google.zxing.b bVar = (com.google.zxing.b) aVar2.f11216a.f18241b;
        int i10 = bVar.f11226a;
        sc.a aVar3 = new sc.a(i10);
        int i11 = 1;
        boolean z5 = enumMap3 != null && enumMap3.containsKey(DecodeHintType.TRY_HARDER);
        int i12 = z5 ? 8 : 5;
        int i13 = bVar.f11227b;
        int max = Math.max(1, i13 >> i12);
        int i14 = z5 ? i13 : 15;
        int i15 = i13 / 2;
        int i16 = 0;
        while (i16 < i14) {
            int i17 = i16 + 1;
            int i18 = i17 / 2;
            if ((i16 & 1) != 0) {
                i18 = -i18;
            }
            int i19 = (i18 * max) + i15;
            if (i19 < 0 || i19 >= i13) {
                break;
            }
            try {
                aVar3 = aVar2.b(aVar3, i19);
                int i20 = 0;
                while (i20 < 2) {
                    if (i20 == i11) {
                        aVar3.i();
                        if (enumMap3 != null) {
                            DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                            if (enumMap3.containsKey(decodeHintType)) {
                                EnumMap enumMap4 = new EnumMap(DecodeHintType.class);
                                enumMap4.putAll(enumMap3);
                                enumMap4.remove(decodeHintType);
                                enumMap3 = enumMap4;
                            }
                        }
                    }
                    try {
                        com.google.zxing.g c9 = c(i19, aVar3, enumMap3);
                        if (i20 == i11) {
                            i3 = i11;
                            try {
                                c9.b(ResultMetadataType.ORIENTATION, 180);
                                com.google.zxing.h[] hVarArr = c9.f11245c;
                                if (hVarArr != null) {
                                    float f2 = i10;
                                    try {
                                        hVar = hVarArr[0];
                                        enumMap2 = enumMap3;
                                    } catch (ReaderException unused) {
                                        enumMap2 = enumMap3;
                                    }
                                    try {
                                        hVarArr[0] = new com.google.zxing.h((f2 - hVar.f11247a) - 1.0f, hVar.f11248b);
                                        com.google.zxing.h hVar2 = hVarArr[i3];
                                        hVarArr[i3] = new com.google.zxing.h((f2 - hVar2.f11247a) - 1.0f, hVar2.f11248b);
                                    } catch (ReaderException unused2) {
                                        continue;
                                        i20++;
                                        enumMap3 = enumMap2;
                                        i11 = i3;
                                    }
                                }
                            } catch (ReaderException unused3) {
                                enumMap2 = enumMap3;
                                i20++;
                                enumMap3 = enumMap2;
                                i11 = i3;
                            }
                        }
                        return c9;
                    } catch (ReaderException unused4) {
                        enumMap2 = enumMap3;
                        i3 = i11;
                    }
                }
            } catch (NotFoundException unused5) {
            }
            aVar2 = aVar;
            i16 = i17;
            i11 = i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
