package com.dh.keeplive.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.dh.keeplive.entity.KeepLiveConstant;
import com.dh.keeplive.entity.NotificationConfig;
import com.google.android.gms.internal.mlkit_vision_barcode.cf;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class HideForegroundService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7219a = 0;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        e.f(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        NotificationConfig notificationConfig;
        if (intent != null && (notificationConfig = (NotificationConfig) intent.getParcelableExtra(KeepLiveConstant.KEEP_LIVE_NOTIFICATION_CONFIG)) != null) {
            cf.b(this, notificationConfig);
        }
        com.dh.keeplive.ext.a.b().postDelayed(new androidx.activity.b(this, 14), 2000L);
        return 2;
    }
}
