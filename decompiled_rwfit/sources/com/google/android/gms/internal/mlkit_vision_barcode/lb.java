package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class lb {
    public static String a(String str, Object... objArr) {
        int indexOf;
        String sb2;
        int i3 = 0;
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            try {
                sb2 = String.valueOf(obj);
            } catch (Exception e) {
                String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e);
                StringBuilder r = android.support.v4.media.session.e.r("<", str2, " threw ");
                r.append(e.getClass().getName());
                r.append(">");
                sb2 = r.toString();
            }
            objArr[i10] = sb2;
        }
        StringBuilder sb3 = new StringBuilder((objArr.length * 16) + str.length());
        int i11 = 0;
        while (i3 < objArr.length && (indexOf = str.indexOf("%s", i11)) != -1) {
            sb3.append((CharSequence) str, i11, indexOf);
            sb3.append(objArr[i3]);
            i11 = indexOf + 2;
            i3++;
        }
        sb3.append((CharSequence) str, i11, str.length());
        if (i3 < objArr.length) {
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
