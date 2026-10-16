package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class za {
    public static String a(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String sb2;
        int i3 = 0;
        int i10 = 0;
        while (true) {
            length = objArr.length;
            if (i10 >= length) {
                break;
            }
            Object obj = objArr[i10];
            if (obj == null) {
                sb2 = "null";
            } else {
                try {
                    sb2 = obj.toString();
                } catch (Exception e) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str2), (Throwable) e);
                    StringBuilder r = android.support.v4.media.session.e.r("<", str2, " threw ");
                    r.append(e.getClass().getName());
                    r.append(">");
                    sb2 = r.toString();
                }
            }
            objArr[i10] = sb2;
            i10++;
        }
        StringBuilder sb3 = new StringBuilder(str.length() + (length * 16));
        int i11 = 0;
        while (true) {
            length2 = objArr.length;
            if (i3 >= length2 || (indexOf = str.indexOf("%s", i11)) == -1) {
                break;
            }
            sb3.append((CharSequence) str, i11, indexOf);
            sb3.append(objArr[i3]);
            i3++;
            i11 = indexOf + 2;
        }
        sb3.append((CharSequence) str, i11, str.length());
        if (i3 < length2) {
            sb3.append(" [");
            sb3.append(objArr[i3]);
            for (int i12 = i3 + 1; i12 < objArr.length; i12++) {
                sb3.append(", ");
                sb3.append(objArr[i12]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }
}
