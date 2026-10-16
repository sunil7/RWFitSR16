package com.tencent.open;

import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: classes2.dex */
public class a {
    public static void a(Window window) {
        if (window == null) {
            return;
        }
        window.setFlags(1024, 1024);
        int i3 = Build.VERSION.SDK_INT;
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        if (i3 >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
    }
}
