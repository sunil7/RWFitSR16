package com.example.test.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class ScreenStatusReceive extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7643a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode == -2128145023) {
                action.equals("android.intent.action.SCREEN_OFF");
                return;
            }
            if (hashCode == -1530327060) {
                action.equals("android.bluetooth.adapter.action.STATE_CHANGED");
            } else if (hashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenStatusReceive", "手机亮屏");
                e.h().n();
            }
        }
    }
}
