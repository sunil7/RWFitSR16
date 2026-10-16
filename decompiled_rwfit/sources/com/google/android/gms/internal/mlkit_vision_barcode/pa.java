package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class pa {
    public static String a(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String q5;
        int i3 = 0;
        int i10 = 0;
        while (true) {
            length = objArr.length;
            if (i10 >= length) {
                break;
            }
            Object obj = objArr[i10];
            if (obj == null) {
                q5 = "null";
            } else {
                try {
                    q5 = obj.toString();
                } catch (Exception e) {
                    String c9 = r5.a.c(obj.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(obj)));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(c9), (Throwable) e);
                    q5 = l0.q("<", c9, " threw ", e.getClass().getName(), ">");
                }
            }
            objArr[i10] = q5;
            i10++;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + (length * 16));
        int i11 = 0;
        while (true) {
            length2 = objArr.length;
            if (i3 >= length2 || (indexOf = str.indexOf("%s", i11)) == -1) {
                break;
            }
            sb2.append((CharSequence) str, i11, indexOf);
            sb2.append(objArr[i3]);
            i3++;
            i11 = indexOf + 2;
        }
        sb2.append((CharSequence) str, i11, str.length());
        if (i3 < length2) {
            sb2.append(" [");
            sb2.append(objArr[i3]);
            for (int i12 = i3 + 1; i12 < objArr.length; i12++) {
                sb2.append(", ");
                sb2.append(objArr[i12]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }
}
