package kotlin.collections;

import com.google.android.gms.internal.mlkit_vision_barcode.vd;
import com.google.android.gms.internal.mlkit_vision_barcode.wd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class g extends vd {
    public static boolean b(int i3, int[] iArr) {
        kotlin.jvm.internal.e.f(iArr, "<this>");
        int length = iArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (i3 == iArr[i10]) {
                break;
            }
            i10++;
        }
        return i10 >= 0;
    }

    public static void c(byte[] bArr, int i3, int i10, byte[] destination, int i11) {
        kotlin.jvm.internal.e.f(bArr, "<this>");
        kotlin.jvm.internal.e.f(destination, "destination");
        System.arraycopy(bArr, i10, destination, i3, i11 - i10);
    }

    public static byte[] d(int i3, int i10, byte[] bArr) {
        kotlin.jvm.internal.e.f(bArr, "<this>");
        vd.a(i10, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i3, i10);
        kotlin.jvm.internal.e.e(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static ArrayList e(Object[] objArr) {
        kotlin.jvm.internal.e.f(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object f(int i3, Object[] objArr) {
        kotlin.jvm.internal.e.f(objArr, "<this>");
        if (i3 < 0 || i3 > objArr.length - 1) {
            return null;
        }
        return objArr[i3];
    }

    public static List g(Object[] objArr) {
        kotlin.jvm.internal.e.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new f(objArr, false)) : wd.a(objArr[0]) : EmptyList.INSTANCE;
    }
}
