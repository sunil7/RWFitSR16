package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import java.util.Locale;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f11982a;

    /* renamed from: b, reason: collision with root package name */
    private static String f11983b;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f11982a)) {
            return f11982a;
        }
        if (context == null) {
            return "";
        }
        f11982a = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            f11982a = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f11982a;
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }
}
