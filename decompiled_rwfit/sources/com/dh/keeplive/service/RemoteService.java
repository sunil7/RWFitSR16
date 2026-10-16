package com.dh.keeplive.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.dh.keeplive.entity.IKeepLiveInterface;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.dh.keeplive.entity.KeepLiveConstant;
import com.dh.keeplive.receiver.StopReceiver;
import com.google.android.gms.internal.mlkit_vision_barcode.af;
import com.google.android.gms.internal.mlkit_vision_barcode.cf;
import eh.g;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class RemoteService extends Service implements IBinder.DeathRecipient {

    /* renamed from: a, reason: collision with root package name */
    public KeepLiveConfig f7234a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7236c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7237d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public IKeepLiveInterface f7238f;

    /* renamed from: b, reason: collision with root package name */
    public int f7235b = com.dh.keeplive.ext.a.e;

    /* renamed from: g, reason: collision with root package name */
    public final d f7239g = new d(this);

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        com.dh.keeplive.ext.a.d("binderDied");
        try {
            com.dh.keeplive.ext.a.k(this, this.f7238f, new oh.a() { // from class: com.dh.keeplive.service.RemoteService$binderDied$1
                {
                    super(0);
                }

                @Override // oh.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m49invoke();
                    return g.f12633a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m49invoke() {
                    RemoteService remoteService = RemoteService.this;
                    remoteService.e = false;
                    remoteService.f7238f = null;
                    if (remoteService.f7236c) {
                        return;
                    }
                    KeepLiveConfig keepLiveConfig = remoteService.f7234a;
                    if (keepLiveConfig == null) {
                        e.m("mKeepLiveConfig");
                        throw null;
                    }
                    WeakReference weakReference = com.dh.keeplive.ext.a.f7209a;
                    d serviceConnection = remoteService.f7239g;
                    e.f(serviceConnection, "serviceConnection");
                    remoteService.f7237d = com.dh.keeplive.ext.a.h(remoteService, LocalService.class, serviceConnection, keepLiveConfig, true);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new c(this);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.dh.keeplive.service.RemoteService$onCreate$1, kotlin.jvm.internal.Lambda] */
    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            com.dh.keeplive.ext.a.d("handleNotification");
            KeepLiveConfig a3 = af.a(this);
            this.f7234a = a3;
            cf.b(this, a3.getNotificationConfig());
        } catch (Exception unused) {
        }
        ?? r02 = new oh.a() { // from class: com.dh.keeplive.service.RemoteService$onCreate$1
            {
                super(0);
            }

            @Override // oh.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m50invoke();
                return g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m50invoke() {
                RemoteService remoteService = RemoteService.this;
                remoteService.f7236c = true;
                com.dh.keeplive.ext.a.e = remoteService.f7235b;
                com.dh.keeplive.ext.a.j(remoteService);
            }
        };
        WeakReference weakReference = com.dh.keeplive.ext.a.f7209a;
        new StopReceiver(this).f7217b = r02;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        try {
            if (this.e) {
                this.e = false;
                com.dh.keeplive.ext.a.k(this, this.f7238f, null);
            }
            if (this.f7237d) {
                unbindService(this.f7239g);
                this.f7237d = false;
            }
        } catch (Exception unused) {
        }
        com.dh.keeplive.ext.a.d("RemoteService has stopped");
        Process.killProcess(Process.myPid());
        System.exit(10);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        KeepLiveConfig keepLiveConfig;
        if (intent != null && (keepLiveConfig = (KeepLiveConfig) intent.getParcelableExtra(KeepLiveConstant.KEEP_LIVE_CONFIG)) != null) {
            com.dh.keeplive.ext.a.f7214g = keepLiveConfig;
            this.f7234a = keepLiveConfig;
        }
        KeepLiveConfig keepLiveConfig2 = this.f7234a;
        if (keepLiveConfig2 == null) {
            e.m("mKeepLiveConfig");
            throw null;
        }
        cf.b(this, keepLiveConfig2.getNotificationConfig());
        KeepLiveConfig keepLiveConfig3 = this.f7234a;
        if (keepLiveConfig3 == null) {
            e.m("mKeepLiveConfig");
            throw null;
        }
        WeakReference weakReference = com.dh.keeplive.ext.a.f7209a;
        d serviceConnection = this.f7239g;
        e.f(serviceConnection, "serviceConnection");
        this.f7237d = com.dh.keeplive.ext.a.h(this, LocalService.class, serviceConnection, keepLiveConfig3, false);
        com.dh.keeplive.ext.a.d("RemoteService is running");
        return 1;
    }
}
