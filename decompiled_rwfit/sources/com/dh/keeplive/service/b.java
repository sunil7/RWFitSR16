package com.dh.keeplive.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.dh.keeplive.entity.IKeepLiveInterface;
import com.dh.keeplive.entity.KeepLiveConfig;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocalService f7241a;

    public b(LocalService localService) {
        this.f7241a = localService;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.dh.keeplive.ext.a.d("onServiceConnected");
        if (iBinder != null) {
            IKeepLiveInterface asInterface = IKeepLiveInterface.Stub.asInterface(iBinder);
            LocalService localService = this.f7241a;
            if (asInterface == null) {
                asInterface = null;
            } else if (asInterface.asBinder().isBinderAlive() && asInterface.asBinder().pingBinder()) {
                try {
                    localService.f7228d++;
                    KeepLiveConfig keepLiveConfig = localService.f7225a;
                    if (keepLiveConfig == null) {
                        e.m("mKeepLiveConfig");
                        throw null;
                    }
                    asInterface.wakeup(keepLiveConfig);
                    asInterface.connectionTimes(localService.f7228d);
                    if (!localService.f7230g) {
                        localService.f7230g = true;
                        asInterface.asBinder().linkToDeath(localService, 0);
                    }
                } catch (Exception unused) {
                    localService.f7228d--;
                }
            }
            localService.f7231h = asInterface;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.dh.keeplive.ext.a.d("onServiceDisconnected");
        LocalService localService = this.f7241a;
        if (localService.e) {
            return;
        }
        KeepLiveConfig keepLiveConfig = localService.f7225a;
        if (keepLiveConfig != null) {
            localService.f7229f = com.dh.keeplive.ext.a.i(localService, this, keepLiveConfig);
        } else {
            e.m("mKeepLiveConfig");
            throw null;
        }
    }
}
