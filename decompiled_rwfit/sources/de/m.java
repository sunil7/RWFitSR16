package de;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: b, reason: collision with root package name */
    public static byte[] f12372b;

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f12371a = {-2, -36, -70};

    /* renamed from: c, reason: collision with root package name */
    public static int f12373c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f12374d = "0123456789ABCDEF".toCharArray();

    public static int a(int i3, int i10, byte[] bArr) {
        int length = bArr.length;
        while (i3 < length) {
            if (bArr[i3] == -2) {
                int i11 = length - i3;
                byte[] bArr2 = f12371a;
                if (i11 < 3) {
                    c(i3, i11, bArr);
                    return -1;
                }
                byte[] bArr3 = new byte[3];
                System.arraycopy(bArr, i3, bArr3, 0, 3);
                if (!Arrays.equals(bArr3, bArr2)) {
                    continue;
                } else {
                    if (i11 <= 7) {
                        c(i3, i11, bArr);
                        return -1;
                    }
                    int i12 = i3 + 3;
                    byte[] bArr4 = new byte[2];
                    System.arraycopy(bArr, i3 + 5, bArr4, 0, 2);
                    int d5 = ee.b.d(bArr4[0], bArr4[1]);
                    if (d5 > i10 - 8) {
                        Locale locale = Locale.ENGLISH;
                        ee.c.d("ParseHelper", "findPacketData", android.support.v4.media.session.e.g(d5, "data length[", i10, "] over MAX_RECEIVE_MTU[", "], cast away"));
                    } else {
                        if (i11 <= 7 + d5) {
                            int i13 = length - i12;
                            byte[] bArr5 = new byte[i13];
                            System.arraycopy(bArr, i12, bArr5, 0, i13);
                            int a3 = a(0, i10, bArr5);
                            ee.c.e("ParseHelper", "findPacketData", "check left data, index = " + a3);
                            if (a3 < 3) {
                                c(i3, i11, bArr);
                                return -1;
                            }
                            int i14 = i12 + a3;
                            ee.c.f("ParseHelper", "findPacketData", "found headIndex = " + i14);
                            return i14;
                        }
                        if (bArr[i3 + 7 + d5] == -17) {
                            return i12;
                        }
                    }
                    i3 += 2;
                }
            }
            i3++;
        }
        return -1;
    }

    public static int b(byte[] bArr) {
        if (bArr.length == 8) {
            StringBuilder sb2 = new StringBuilder();
            for (byte b3 : bArr) {
                sb2.append(b3 & 255);
            }
            try {
                return Integer.valueOf(sb2.toString(), 2).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void c(int i3, int i10, byte[] bArr) {
        if (bArr.length <= 0 || i3 < 0 || i10 <= 0 || i3 + i10 > bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[i10];
        f12372b = bArr2;
        System.arraycopy(bArr, i3, bArr2, 0, i10);
        f12373c = i10;
    }

    public static vd.b d(vd.a aVar, vd.b bVar) {
        wd.a aVar2;
        vd.b bVar2 = null;
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = com.google.android.gms.internal.mlkit_vision_common.m.f10033a;
        if (hashMap == null || hashMap.size() == 0) {
            HashMap hashMap2 = new HashMap();
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a = hashMap2;
            hashMap2.put(1, new wd.a(1));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(2, new wd.a(4));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(3, new wd.a(5));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(6, new wd.a(2));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(11, new wd.a(6));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(225, new wd.a(7));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(226, new wd.a(7));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(227, new wd.a(7));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(228, new wd.a(7));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(229, new wd.a(7));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(230, new wd.a(7));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(231, new wd.a(7));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(232, new wd.a(7));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(209, new wd.a(9));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(212, new wd.a(3));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(240, new wd.a(8));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(255, new wd.a(0));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(194, new wd.a(10));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(195, new wd.a(10));
            com.google.android.gms.internal.mlkit_vision_common.m.f10033a.put(196, new wd.a(10));
        }
        HashMap hashMap3 = com.google.android.gms.internal.mlkit_vision_common.m.f10033a;
        if (hashMap3 != null && (aVar2 = (wd.a) hashMap3.get(Integer.valueOf(aVar.f19220c))) != null) {
            bVar2 = aVar2.a(aVar, bVar);
        }
        return bVar2 != null ? bVar2 : new wd.a(8).a(aVar, bVar);
    }

    public static String e(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr.length == 6) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                int i10 = (bArr[i3] & 255) >> 4;
                char[] cArr = f12374d;
                sb2.append(cArr[i10]);
                sb2.append(cArr[bArr[i3] & 15]);
                if (i3 != bArr.length - 1) {
                    sb2.append(":");
                }
            }
        }
        return sb2.toString();
    }

    public static byte[] f(vd.a aVar) {
        int i3;
        int i10;
        if (aVar == null) {
            return null;
        }
        int i11 = aVar.f19221d;
        int i12 = i11 + 4;
        byte[] bArr = new byte[i11 + 8];
        byte[] bArr2 = new byte[i12];
        byte[] bArr3 = new byte[2];
        if (aVar.f19218a == 1) {
            bArr3[0] = (byte) (bArr3[0] | 128);
        }
        if (aVar.f19219b == 1) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        bArr3[1] = (byte) aVar.f19220c;
        byte[] h4 = ee.b.h(i11);
        byte[] bArr4 = new byte[i11];
        byte[] bArr5 = {(byte) aVar.e};
        byte[] bArr6 = {(byte) aVar.f19222f};
        if (aVar.f19218a == 1) {
            System.arraycopy(bArr6, 0, bArr4, 0, 1);
            if (aVar.f19220c == 1) {
                System.arraycopy(new byte[]{(byte) aVar.f19223g}, 0, bArr4, 1, 1);
                i3 = 2;
            } else {
                i3 = 1;
            }
            byte[] bArr7 = aVar.f19224h;
            if (bArr7 != null && bArr7.length >= (i10 = i11 - i3)) {
                System.arraycopy(bArr7, 0, bArr4, i3, i10);
                i3 += i10;
            }
        } else {
            System.arraycopy(bArr5, 0, bArr4, 0, 1);
            System.arraycopy(bArr6, 0, bArr4, 1, 1);
            if (aVar.f19220c == 1) {
                System.arraycopy(new byte[]{(byte) aVar.f19223g}, 0, bArr4, 2, 1);
                i3 = 3;
            } else {
                i3 = 2;
            }
            byte[] bArr8 = aVar.f19224h;
            if (bArr8 != null) {
                int i13 = i11 - i3;
                System.arraycopy(bArr8, 0, bArr4, i3, i13);
                i3 += i13;
            }
        }
        if (i3 != i11) {
            ee.c.d("ParseHelper", "packSendBasePacket", l0.i(i3, i11, "param data is error. index : ", ", paramLen : "));
            return null;
        }
        System.arraycopy(bArr3, 0, bArr2, 0, 2);
        System.arraycopy(h4, 0, bArr2, 2, 2);
        System.arraycopy(bArr4, 0, bArr2, 4, i11);
        System.arraycopy(new byte[]{-2, -36, -70}, 0, bArr, 0, 3);
        System.arraycopy(bArr2, 0, bArr, 3, i12);
        System.arraycopy(new byte[]{-17}, 0, bArr, i11 + 7, 1);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return wrap.array();
    }
}
