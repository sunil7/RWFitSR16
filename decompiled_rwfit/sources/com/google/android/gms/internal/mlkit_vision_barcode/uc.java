package com.google.android.gms.internal.mlkit_vision_barcode;

import android.text.TextUtils;
import android.util.Log;
import com.king.logx.logger.Logger;
import java.net.UnknownHostException;

/* loaded from: classes.dex */
public abstract class uc {
    public static void a(String str, String str2, Exception exc) {
        String replace;
        if (exc != null) {
            Throwable th2 = exc;
            while (true) {
                if (th2 == null) {
                    replace = Log.getStackTraceString(exc).trim().replace("\t", Logger.INDENT);
                    break;
                } else {
                    if (th2 instanceof UnknownHostException) {
                        replace = "UnknownHostException (no network)";
                        break;
                    }
                    th2 = th2.getCause();
                }
            }
        } else {
            replace = null;
        }
        if (!TextUtils.isEmpty(replace)) {
            String valueOf = String.valueOf(str2);
            String replace2 = replace.replace("\n", "\n  ");
            StringBuilder sb2 = new StringBuilder(r5.a.a(valueOf.length() + 4, replace2));
            sb2.append(valueOf);
            sb2.append("\n  ");
            sb2.append(replace2);
            sb2.append('\n');
            str2 = sb2.toString();
        }
        Log.w(str, str2);
    }
}
