package com.example.test.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.ee;

/* loaded from: classes.dex */
public final class LangService extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7641a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (kotlin.jvm.internal.e.a(intent != null ? intent.getAction() : null, "android.intent.action.LOCALE_CHANGED")) {
            Log.e("qob", "onReceive " + intent.getAction());
            XXApplication xXApplication = XXApplication.f7400h;
            XXApplication a3 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
            String str = com.dh.keeplive.a.f7201c;
            ee.a().getClass();
            com.dh.keeplive.a.a(a3);
            a3.a();
            Process.killProcess(Process.myPid());
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }
}
