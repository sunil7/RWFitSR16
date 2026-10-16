package com.dh.keeplive.service;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import b1.m;
import com.dh.keeplive.entity.IKeepLiveInterface;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.dh.keeplive.entity.KeepLiveConstant;
import com.dh.keeplive.service.LocalService;
import com.dh.keeplive.service.LocalService.ServiceReceiver;
import java.util.ArrayList;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class a extends IKeepLiveInterface.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocalService f7240a;

    public a(LocalService localService) {
        this.f7240a = localService;
    }

    @Override // com.dh.keeplive.entity.IKeepLiveInterface
    public final void connectionTimes(int i3) {
        LocalService localService = this.f7240a;
        localService.f7228d = i3;
        if (i3 > 3 && i3 % 2 == 0) {
            localService.f7228d = i3 + 1;
        }
        int i10 = localService.f7228d;
        com.dh.keeplive.ext.a.e = i10;
        int i11 = (i10 + 1) / 2;
        if (localService.f7227c) {
            return;
        }
        localService.f7227c = true;
        com.dh.keeplive.ext.a.d("LocalService is run >>>> do work times = " + i11);
        if (localService.f7226b == null) {
            localService.f7226b = localService.new ServiceReceiver();
        }
        LocalService.ServiceReceiver serviceReceiver = localService.f7226b;
        if (serviceReceiver != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction(com.dh.keeplive.a.e);
            intentFilter.addAction(com.dh.keeplive.a.f7203f);
            localService.registerReceiver(serviceReceiver, intentFilter);
        }
        localService.sendBroadcast(new Intent(com.dh.keeplive.a.f7201c).putExtra("times", i11));
        int i12 = 0;
        if (i11 > 1 && com.dh.keeplive.ext.a.f7213f == 1) {
            KeepLiveConfig keepLiveConfig = localService.f7225a;
            if (keepLiveConfig == null) {
                e.m("mKeepLiveConfig");
                throw null;
            }
            Intent restartIntent = keepLiveConfig.getDefaultConfig().getRestartIntent();
            if (restartIntent != null) {
                try {
                    PendingIntent.getActivity(localService, 0, restartIntent, 67108864).send();
                } catch (Exception unused) {
                }
            }
        }
        KeepLiveConstant keepLiveConstant = KeepLiveConstant.INSTANCE;
        if (keepLiveConstant.getCALLBACKS$keeplive_release().isEmpty()) {
            return;
        }
        ArrayList<com.example.test.b> cALLBACKS$keeplive_release = keepLiveConstant.getCALLBACKS$keeplive_release();
        int size = cALLBACKS$keeplive_release.size();
        while (i12 < size) {
            com.example.test.b bVar = cALLBACKS$keeplive_release.get(i12);
            i12++;
            com.example.test.b bVar2 = bVar;
            KeepLiveConfig keepLiveConfig2 = localService.f7225a;
            if (keepLiveConfig2 == null) {
                e.m("mKeepLiveConfig");
                throw null;
            }
            if (keepLiveConfig2.getDefaultConfig().getWorkOnMainThread()) {
                com.dh.keeplive.ext.a.b().post(new m(i11, 1, bVar2));
            } else {
                bVar2.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseApplication", "doWork:" + i11);
            }
        }
    }

    @Override // com.dh.keeplive.entity.IKeepLiveInterface
    public final void wakeup(KeepLiveConfig config) {
        e.f(config, "config");
        this.f7240a.f7225a = config;
    }
}
