package t5;

import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f18550a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f18551b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f18552c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f18553d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final String f18554f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f18555g;

    public j(ArrayList arrayList, SparseArray sparseArray, HashMap hashMap, int i3, int i10, String str, byte[] bArr) {
        this.f18551b = arrayList;
        this.f18552c = sparseArray;
        this.f18553d = hashMap;
        this.f18554f = str;
        this.f18550a = i3;
        this.e = i10;
        this.f18555g = bArr;
    }

    public static j a(byte[] bArr) {
        ArrayList arrayList = null;
        if (bArr == null) {
            return null;
        }
        String str = null;
        int i3 = -1;
        byte b3 = -2147483648;
        int i10 = 0;
        SparseArray sparseArray = null;
        HashMap hashMap = null;
        while (i10 < bArr.length) {
            try {
                int i11 = i10 + 1;
                int i12 = bArr[i10] & 255;
                if (i12 == 0) {
                    return new j(arrayList, sparseArray, hashMap, i3, b3, str, bArr);
                }
                int i13 = i12 - 1;
                int i14 = i10 + 2;
                int i15 = bArr[i11] & 255;
                if (i15 != 22) {
                    if (i15 == 255) {
                        int i16 = ((bArr[i10 + 3] & 255) << 8) + (bArr[i14] & 255);
                        int i17 = i12 - 3;
                        byte[] bArr2 = new byte[i17];
                        System.arraycopy(bArr, i10 + 4, bArr2, 0, i17);
                        if (sparseArray == null) {
                            sparseArray = new SparseArray();
                        }
                        sparseArray.put(i16, bArr2);
                    } else if (i15 != 32 && i15 != 33) {
                        switch (i15) {
                            case 1:
                                i3 = bArr[i14] & 255;
                                break;
                            case 2:
                            case 3:
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                b(bArr, i14, i13, 2, arrayList);
                                break;
                            case 4:
                            case 5:
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                b(bArr, i14, i13, 4, arrayList);
                                break;
                            case 6:
                            case 7:
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                b(bArr, i14, i13, 16, arrayList);
                                break;
                            case 8:
                            case 9:
                                byte[] bArr3 = new byte[i13];
                                System.arraycopy(bArr, i14, bArr3, 0, i13);
                                str = new String(bArr3);
                                break;
                            case 10:
                                b3 = bArr[i14];
                                break;
                        }
                    }
                    i10 = i14 + i13;
                }
                int i18 = i15 == 32 ? 4 : i15 == 33 ? 16 : 2;
                byte[] bArr4 = new byte[i18];
                System.arraycopy(bArr, i14, bArr4, 0, i18);
                ParcelUuid a3 = g.a(bArr4);
                int i19 = i13 - i18;
                byte[] bArr5 = new byte[i19];
                System.arraycopy(bArr, i14 + i18, bArr5, 0, i19);
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(a3, bArr5);
                i10 = i14 + i13;
            } catch (Exception unused) {
                Log.e("ScanRecord", "unable to parse scan record: " + Arrays.toString(bArr));
                return new j(null, null, null, -1, Integer.MIN_VALUE, null, bArr);
            }
        }
        return new j(arrayList, sparseArray, hashMap, i3, b3, str, bArr);
    }

    public static void b(byte[] bArr, int i3, int i10, int i11, ArrayList arrayList) {
        while (i10 > 0) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i3, bArr2, 0, i11);
            arrayList.add(g.a(bArr2));
            i10 -= i11;
            i3 += i11;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f18555g, ((j) obj).f18555g);
    }

    public final String toString() {
        String sb2;
        StringBuilder sb3 = new StringBuilder("ScanRecord [advertiseFlags=");
        sb3.append(this.f18550a);
        sb3.append(", serviceUuids=");
        sb3.append(this.f18551b);
        sb3.append(", manufacturerSpecificData=");
        String str = "{}";
        SparseArray sparseArray = this.f18552c;
        if (sparseArray == null) {
            sb2 = "null";
        } else if (sparseArray.size() == 0) {
            sb2 = "{}";
        } else {
            StringBuilder sb4 = new StringBuilder(Const.STR_MART_JSON_BEGIN);
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                sb4.append(sparseArray.keyAt(i3));
                sb4.append("=");
                sb4.append(Arrays.toString((byte[]) sparseArray.valueAt(i3)));
            }
            sb4.append('}');
            sb2 = sb4.toString();
        }
        sb3.append(sb2);
        sb3.append(", serviceData=");
        HashMap hashMap = this.f18553d;
        if (hashMap == null) {
            str = "null";
        } else if (!hashMap.isEmpty()) {
            StringBuilder sb5 = new StringBuilder(Const.STR_MART_JSON_BEGIN);
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Object key = ((Map.Entry) it.next()).getKey();
                sb5.append(key);
                sb5.append("=");
                sb5.append(Arrays.toString((byte[]) hashMap.get(key)));
                if (it.hasNext()) {
                    sb5.append(", ");
                }
            }
            sb5.append('}');
            str = sb5.toString();
        }
        sb3.append(str);
        sb3.append(", txPowerLevel=");
        sb3.append(this.e);
        sb3.append(", deviceName=");
        return r5.a.f(sb3, this.f18554f, "]");
    }
}
