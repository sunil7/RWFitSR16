package com.dh.keeplive;

import android.content.Intent;
import com.dh.keeplive.entity.DefaultConfig;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.dh.keeplive.entity.NotificationConfig;
import com.example.test.XXApplication;
import eh.b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f7201c = com.dh.keeplive.ext.a.a("work");

    /* renamed from: d, reason: collision with root package name */
    public static final String f7202d = com.dh.keeplive.ext.a.a("stop");
    public static final String e = com.dh.keeplive.ext.a.a("background");

    /* renamed from: f, reason: collision with root package name */
    public static final String f7203f = com.dh.keeplive.ext.a.a("foreground");

    /* renamed from: g, reason: collision with root package name */
    public static final b f7204g = kotlin.a.b(new oh.a() { // from class: com.dh.keeplive.KeepLive$Companion$instance$2
        @Override // oh.a
        public final a invoke() {
            return new a();
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public final NotificationConfig f7205a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultConfig f7206b;

    public a() {
        new KeepLiveConfig(null, null, 3, null);
        this.f7205a = new NotificationConfig(0, null, null, null, null, 0, 0, null, false, false, null, null, null, null, null, 32767, null);
        this.f7206b = new DefaultConfig(false, false, false, 0L, 0, false, false, false, false, null, 1023, null);
    }

    public static void a(XXApplication xXApplication) {
        try {
            com.dh.keeplive.ext.a.d("isKeepLiveRunning =" + com.dh.keeplive.ext.a.c(xXApplication) + ",sRegistered=" + com.dh.keeplive.ext.a.f7211c);
            if (!com.dh.keeplive.ext.a.c(xXApplication) || !com.dh.keeplive.ext.a.f7211c) {
                com.dh.keeplive.ext.a.d("keeplive is not running，Please make sure Cactus is running!!");
                return;
            }
            com.dh.keeplive.ext.a.d("keeplive 注销");
            com.dh.keeplive.ext.a.f7211c = false;
            KeepLiveConfig keepLiveConfig = com.dh.keeplive.ext.a.f7214g;
            if (keepLiveConfig != null && keepLiveConfig.getDefaultConfig().getWorkerEnabled()) {
                com.dh.keeplive.ext.a.l(xXApplication);
            }
            xXApplication.sendBroadcast(new Intent("com.xj.keeplive.flag.stop." + xXApplication.getPackageName()));
            com.dh.keeplive.ext.a.b().postDelayed(new m5.a(xXApplication, 6), 0L);
        } catch (Exception unused) {
        }
    }
}
