package com.dh.keeplive.service;

import com.dh.keeplive.entity.IKeepLiveInterface;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.google.android.gms.internal.mlkit_vision_barcode.cf;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class c extends IKeepLiveInterface.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RemoteService f7242a;

    public c(RemoteService remoteService) {
        this.f7242a = remoteService;
    }

    @Override // com.dh.keeplive.entity.IKeepLiveInterface
    public final void connectionTimes(int i3) {
        RemoteService remoteService = this.f7242a;
        remoteService.f7235b = i3;
        if (i3 > 4 && i3 % 2 == 1) {
            remoteService.f7235b = i3 + 1;
        }
        com.dh.keeplive.ext.a.e = remoteService.f7235b;
    }

    @Override // com.dh.keeplive.entity.IKeepLiveInterface
    public final void wakeup(KeepLiveConfig config) {
        e.f(config, "config");
        RemoteService remoteService = this.f7242a;
        remoteService.f7234a = config;
        cf.b(remoteService, config.getNotificationConfig());
    }
}
