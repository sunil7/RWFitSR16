package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import o4.e;

/* loaded from: classes.dex */
public final class zabx extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public Context f9087a;

    /* renamed from: b, reason: collision with root package name */
    public final e f9088b;

    public zabx(e eVar) {
        this.f9088b = eVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            Object obj = this.f9088b.f16738b;
            throw null;
        }
    }
}
