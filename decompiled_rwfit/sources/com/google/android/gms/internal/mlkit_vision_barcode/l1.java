package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.IntentFilter;
import com.example.test.XXApplication;
import com.example.test.service.LangService;

/* loaded from: classes.dex */
public abstract class l1 {
    public static void a(XXApplication xXApplication) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.setPriority(1000);
        xXApplication.registerReceiver(new LangService(), intentFilter);
    }
}
