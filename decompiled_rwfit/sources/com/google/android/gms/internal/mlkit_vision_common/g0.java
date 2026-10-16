package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.view.View;
import com.tencent.connect.common.Constants;

/* loaded from: classes.dex */
public abstract class g0 {
    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String fileName = stackTraceElement.getFileName();
        int lineNumber = stackTraceElement.getLineNumber();
        String methodName = stackTraceElement.getMethodName();
        StringBuilder sb2 = new StringBuilder(r5.a.a(r5.a.a(18, fileName), methodName));
        sb2.append(".(");
        sb2.append(fileName);
        sb2.append(":");
        sb2.append(lineNumber);
        sb2.append(") ");
        sb2.append(methodName);
        sb2.append("()");
        return sb2.toString();
    }

    public static String b() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String fileName = stackTraceElement.getFileName();
        int lineNumber = stackTraceElement.getLineNumber();
        StringBuilder sb2 = new StringBuilder(r5.a.a(15, fileName));
        sb2.append(".(");
        sb2.append(fileName);
        sb2.append(":");
        sb2.append(lineNumber);
        sb2.append(")");
        return sb2.toString();
    }

    public static String c(Context context, int i3) {
        if (i3 == -1) {
            return Constants.APP_VERSION_UNKNOWN;
        }
        try {
            return context.getResources().getResourceEntryName(i3);
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder(12);
            sb2.append("?");
            sb2.append(i3);
            return sb2.toString();
        }
    }

    public static String d(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return Constants.APP_VERSION_UNKNOWN;
        }
    }
}
