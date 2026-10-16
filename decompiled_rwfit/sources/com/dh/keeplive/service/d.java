package com.dh.keeplive.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.dh.keeplive.entity.IKeepLiveInterface;
import com.dh.keeplive.entity.KeepLiveConfig;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class d implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RemoteService f7243a;

    public d(RemoteService remoteService) {
        this.f7243a = remoteService;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.dh.keeplive.ext.a.d("onServiceConnected");
        if (iBinder != null) {
            IKeepLiveInterface asInterface = IKeepLiveInterface.Stub.asInterface(iBinder);
            RemoteService remoteService = this.f7243a;
            if (asInterface == null) {
                asInterface = null;
            } else if (asInterface.asBinder().isBinderAlive() && asInterface.asBinder().pingBinder()) {
                try {
                    remoteService.f7235b++;
                    KeepLiveConfig keepLiveConfig = remoteService.f7234a;
                    if (keepLiveConfig == null) {
                        e.m("mKeepLiveConfig");
                        throw null;
                    }
                    asInterface.wakeup(keepLiveConfig);
                    asInterface.connectionTimes(remoteService.f7235b);
                    if (!remoteService.e) {
                        remoteService.e = true;
                        asInterface.asBinder().linkToDeath(remoteService, 0);
                    }
                } catch (Exception unused) {
                    remoteService.f7235b--;
                }
            }
            remoteService.f7238f = asInterface;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.dh.keeplive.ext.a.d("onServiceDisconnected");
        RemoteService remoteService = this.f7243a;
        if (remoteService.f7236c) {
            return;
        }
        KeepLiveConfig keepLiveConfig = remoteService.f7234a;
        if (keepLiveConfig != null) {
            remoteService.f7237d = com.dh.keeplive.ext.a.h(remoteService, LocalService.class, this, keepLiveConfig, true);
        } else {
            e.m("mKeepLiveConfig");
            throw null;
        }
    }
}
