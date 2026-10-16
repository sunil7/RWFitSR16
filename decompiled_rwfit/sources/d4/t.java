package d4;

import android.bluetooth.BluetoothDevice;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f12284a;

    public t(int i3) {
        switch (i3) {
            case 1:
                this.f12284a = new HashMap();
                break;
            case 2:
                this.f12284a = new HashMap();
                break;
            default:
                this.f12284a = new HashMap();
                break;
        }
    }

    public static String a(BluetoothDevice bluetoothDevice, int i3, int i10) {
        String address = bluetoothDevice == null ? Const.STR_DEF_SMAC : bluetoothDevice.getAddress();
        Locale locale = Locale.ENGLISH;
        return address + "-" + i3 + "-" + i10;
    }

    public void b(HashMap hashMap) {
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            HashMap hashMap2 = this.f12284a;
            if (value == null) {
                hashMap2.put(str, null);
            } else {
                Class<?> cls = value.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    hashMap2.put(str, value);
                } else {
                    int i3 = 0;
                    if (cls == boolean[].class) {
                        boolean[] zArr = (boolean[]) value;
                        String str2 = o2.f.f16709b;
                        Boolean[] boolArr = new Boolean[zArr.length];
                        while (i3 < zArr.length) {
                            boolArr[i3] = Boolean.valueOf(zArr[i3]);
                            i3++;
                        }
                        hashMap2.put(str, boolArr);
                    } else if (cls == byte[].class) {
                        byte[] bArr = (byte[]) value;
                        String str3 = o2.f.f16709b;
                        Byte[] bArr2 = new Byte[bArr.length];
                        while (i3 < bArr.length) {
                            bArr2[i3] = Byte.valueOf(bArr[i3]);
                            i3++;
                        }
                        hashMap2.put(str, bArr2);
                    } else if (cls == int[].class) {
                        int[] iArr = (int[]) value;
                        String str4 = o2.f.f16709b;
                        Integer[] numArr = new Integer[iArr.length];
                        while (i3 < iArr.length) {
                            numArr[i3] = Integer.valueOf(iArr[i3]);
                            i3++;
                        }
                        hashMap2.put(str, numArr);
                    } else if (cls == long[].class) {
                        long[] jArr = (long[]) value;
                        String str5 = o2.f.f16709b;
                        Long[] lArr = new Long[jArr.length];
                        while (i3 < jArr.length) {
                            lArr[i3] = Long.valueOf(jArr[i3]);
                            i3++;
                        }
                        hashMap2.put(str, lArr);
                    } else if (cls == float[].class) {
                        float[] fArr = (float[]) value;
                        String str6 = o2.f.f16709b;
                        Float[] fArr2 = new Float[fArr.length];
                        while (i3 < fArr.length) {
                            fArr2[i3] = Float.valueOf(fArr[i3]);
                            i3++;
                        }
                        hashMap2.put(str, fArr2);
                    } else {
                        if (cls != double[].class) {
                            throw new IllegalArgumentException("Key " + str + " has invalid type " + cls);
                        }
                        double[] dArr = (double[]) value;
                        String str7 = o2.f.f16709b;
                        Double[] dArr2 = new Double[dArr.length];
                        while (i3 < dArr.length) {
                            dArr2[i3] = Double.valueOf(dArr[i3]);
                            i3++;
                        }
                        hashMap2.put(str, dArr2);
                    }
                }
            }
        }
    }
}
