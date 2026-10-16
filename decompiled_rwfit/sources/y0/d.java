package y0;

import android.app.Activity;
import android.text.TextUtils;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class d extends a1.g {
    /* JADX WARN: Multi-variable type inference failed */
    public static void d(Activity activity, String[] strArr, int i3) {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (TextUtils.isEmpty(strArr[i10])) {
                throw new IllegalArgumentException(r5.a.f(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
            if (!ic.b() && TextUtils.equals(strArr[i10], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i10));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < strArr.length; i12++) {
                if (!hashSet.contains(Integer.valueOf(i12))) {
                    strArr2[i11] = strArr[i12];
                    i11++;
                }
            }
        }
        if (activity instanceof c) {
        }
        b.b(activity, strArr, i3);
    }
}
