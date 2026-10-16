package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.amap.api.col.p0003sl.g;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;

/* loaded from: classes.dex */
public class APSService extends Service {

    /* renamed from: a, reason: collision with root package name */
    g f5671a;

    /* renamed from: b, reason: collision with root package name */
    int f5672b = 0;

    /* renamed from: c, reason: collision with root package name */
    boolean f5673c = false;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return this.f5671a.a(intent);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "APSService", "onBind");
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            if (this.f5671a == null) {
                this.f5671a = new g(this);
            }
            this.f5671a.a();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "APSService", "onCreate");
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.f5671a.b();
            if (this.f5673c) {
                stopForeground(true);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i10) {
        int i11;
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra(Const.INTENT_KEY_BACKGROUND_COMMAND, 0);
                if (intExtra == 1) {
                    int intExtra2 = intent.getIntExtra(Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, 0);
                    Notification notification = (Notification) intent.getParcelableExtra(Const.INTENT_KEY_BACKGROUND_NOTIFICATION);
                    if (intExtra2 != 0 && notification != null) {
                        startForeground(intExtra2, notification);
                        this.f5673c = true;
                        this.f5672b++;
                    }
                } else if (intExtra == 2) {
                    if (intent.getBooleanExtra(Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, true) && (i11 = this.f5672b) > 0) {
                        this.f5672b = i11 - 1;
                    }
                    if (this.f5672b <= 0) {
                        stopForeground(true);
                        this.f5673c = false;
                    } else {
                        stopForeground(false);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        try {
            return this.f5671a.c();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i3, i10);
        }
    }
}
