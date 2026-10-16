package com.amap.api.col.p0003sl;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: classes.dex */
abstract class w5 extends Dialog {
    public w5(Context context) {
        super(context);
        a();
    }

    public void a() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            b();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 80;
            }
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(R.color.transparent);
        }
    }

    public abstract void b();
}
