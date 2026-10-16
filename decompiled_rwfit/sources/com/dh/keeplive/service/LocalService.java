package com.dh.keeplive.service;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.dh.keeplive.entity.IKeepLiveInterface;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.dh.keeplive.entity.KeepLiveConstant;
import com.google.android.gms.internal.mlkit_vision_barcode.af;
import com.google.android.gms.internal.mlkit_vision_barcode.bf;
import com.google.android.gms.internal.mlkit_vision_barcode.cf;
import eh.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class LocalService extends Service implements IBinder.DeathRecipient {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f7224j = 0;

    /* renamed from: a, reason: collision with root package name */
    public KeepLiveConfig f7225a;

    /* renamed from: b, reason: collision with root package name */
    public ServiceReceiver f7226b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7227c;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7229f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7230g;

    /* renamed from: h, reason: collision with root package name */
    public IKeepLiveInterface f7231h;

    /* renamed from: d, reason: collision with root package name */
    public int f7228d = com.dh.keeplive.ext.a.e;

    /* renamed from: i, reason: collision with root package name */
    public final b f7232i = new b(this);

    public final class ServiceReceiver extends BroadcastReceiver {
        public ServiceReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action;
            Activity activity;
            if (intent == null || (action = intent.getAction()) == null) {
                return;
            }
            boolean equals = action.equals("android.intent.action.SCREEN_OFF");
            LocalService localService = LocalService.this;
            if (equals) {
                com.dh.keeplive.ext.a.d("screen off");
                KeepLiveConfig keepLiveConfig = localService.f7225a;
                if (keepLiveConfig == null) {
                    e.m("mKeepLiveConfig");
                    throw null;
                }
                if (keepLiveConfig.getDefaultConfig().getOnePixEnabled()) {
                    com.dh.keeplive.ext.a.b().postDelayed(new androidx.activity.b(localService, 15), 1000L);
                }
                int i3 = LocalService.f7224j;
                return;
            }
            if (!action.equals("android.intent.action.SCREEN_ON")) {
                if (!action.equals(com.dh.keeplive.a.e)) {
                    if (action.equals(com.dh.keeplive.a.f7203f)) {
                        com.dh.keeplive.ext.a.d("foreground");
                        LocalService.a(localService);
                        return;
                    }
                    return;
                }
                com.dh.keeplive.ext.a.d("background");
                KeepLiveConfig keepLiveConfig2 = localService.f7225a;
                if (keepLiveConfig2 == null) {
                    e.m("mKeepLiveConfig");
                    throw null;
                }
                if (keepLiveConfig2.getDefaultConfig().getBackgroundMusicEnabled()) {
                    int i10 = LocalService.f7224j;
                }
                LocalService.a(localService);
                return;
            }
            com.dh.keeplive.ext.a.d("screen on");
            KeepLiveConfig keepLiveConfig3 = localService.f7225a;
            if (keepLiveConfig3 == null) {
                e.m("mKeepLiveConfig");
                throw null;
            }
            if (keepLiveConfig3.getDefaultConfig().getOnePixEnabled()) {
                WeakReference weakReference = com.dh.keeplive.ext.a.f7209a;
                if (weakReference != null && (activity = (Activity) weakReference.get()) != null && !com.dh.keeplive.ext.a.f7210b && bf.b(activity)) {
                    Intent intent2 = new Intent("android.intent.action.MAIN");
                    intent2.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
                    intent2.addCategory("android.intent.category.HOME");
                    activity.startActivity(intent2);
                }
                WeakReference weakReference2 = com.dh.keeplive.ext.a.f7209a;
                if (weakReference2 != null) {
                    Activity activity2 = (Activity) weakReference2.get();
                    if (activity2 != null) {
                        activity2.finish();
                    }
                    com.dh.keeplive.ext.a.f7209a = null;
                }
            }
            KeepLiveConfig keepLiveConfig4 = localService.f7225a;
            if (keepLiveConfig4 == null) {
                e.m("mKeepLiveConfig");
                throw null;
            }
            if (keepLiveConfig4.getDefaultConfig().getBackgroundMusicEnabled()) {
                return;
            }
            int i11 = LocalService.f7224j;
        }
    }

    public static final void a(LocalService localService) {
        KeepLiveConstant keepLiveConstant = KeepLiveConstant.INSTANCE;
        if (keepLiveConstant.getBACKGROUND_CALLBACKS$keeplive_release().isEmpty()) {
            return;
        }
        Iterator<T> it = keepLiveConstant.getBACKGROUND_CALLBACKS$keeplive_release().iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        com.dh.keeplive.ext.a.d("binderDied");
        try {
            com.dh.keeplive.ext.a.k(this, this.f7231h, new oh.a() { // from class: com.dh.keeplive.service.LocalService$binderDied$1
                {
                    super(0);
                }

                @Override // oh.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m47invoke();
                    return g.f12633a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m47invoke() {
                    LocalService localService = LocalService.this;
                    localService.f7230g = false;
                    localService.f7231h = null;
                    if (localService.e) {
                        return;
                    }
                    KeepLiveConfig keepLiveConfig = localService.f7225a;
                    if (keepLiveConfig != null) {
                        localService.f7229f = com.dh.keeplive.ext.a.i(localService, localService.f7232i, keepLiveConfig);
                    } else {
                        e.m("mKeepLiveConfig");
                        throw null;
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new a(this);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f7225a = af.a(this);
        com.dh.keeplive.ext.a.g(this, new oh.a() { // from class: com.dh.keeplive.service.LocalService$onCreate$1
            {
                super(0);
            }

            @Override // oh.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m48invoke();
                return g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m48invoke() {
                LocalService localService = LocalService.this;
                localService.e = true;
                com.dh.keeplive.ext.a.e = localService.f7228d;
                com.dh.keeplive.ext.a.j(localService);
            }
        });
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        int i3 = 0;
        try {
            if (this.f7230g) {
                this.f7230g = false;
                com.dh.keeplive.ext.a.k(this, this.f7231h, null);
            }
            if (this.f7229f) {
                unbindService(this.f7232i);
                this.f7229f = false;
            }
        } catch (Exception unused) {
        }
        stopService(new Intent(this, (Class<?>) RemoteService.class));
        if (this.f7227c) {
            this.f7227c = false;
            com.dh.keeplive.ext.a.d("LocalService is stop!");
            ServiceReceiver serviceReceiver = this.f7226b;
            if (serviceReceiver != null) {
                unregisterReceiver(serviceReceiver);
                this.f7226b = null;
            }
            sendBroadcast(new Intent(com.dh.keeplive.a.f7202d));
            KeepLiveConstant keepLiveConstant = KeepLiveConstant.INSTANCE;
            if (keepLiveConstant.getCALLBACKS$keeplive_release().isEmpty()) {
                return;
            }
            ArrayList<com.example.test.b> cALLBACKS$keeplive_release = keepLiveConstant.getCALLBACKS$keeplive_release();
            int size = cALLBACKS$keeplive_release.size();
            while (i3 < size) {
                com.example.test.b bVar = cALLBACKS$keeplive_release.get(i3);
                i3++;
                bVar.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseApplication", "onStop");
            }
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        KeepLiveConfig keepLiveConfig;
        if (intent != null && (keepLiveConfig = (KeepLiveConfig) intent.getParcelableExtra(KeepLiveConstant.KEEP_LIVE_CONFIG)) != null) {
            this.f7225a = keepLiveConfig;
        }
        KeepLiveConfig keepLiveConfig2 = this.f7225a;
        if (keepLiveConfig2 == null) {
            e.m("mKeepLiveConfig");
            throw null;
        }
        cf.b(this, keepLiveConfig2.getNotificationConfig());
        KeepLiveConfig keepLiveConfig3 = this.f7225a;
        if (keepLiveConfig3 != null) {
            this.f7229f = com.dh.keeplive.ext.a.i(this, this.f7232i, keepLiveConfig3);
            return 1;
        }
        e.m("mKeepLiveConfig");
        throw null;
    }
}
