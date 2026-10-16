package com.example.test.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import com.example.test.XXApplication;

/* loaded from: classes.dex */
public class PhoneReceiver extends BroadcastReceiver {
    public static void a(XXApplication xXApplication) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PhoneReceiver", "注册电话广播");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentFilter.setPriority(1000);
        xXApplication.registerReceiver(new PhoneReceiver(), intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        getResultData();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PhoneReceiver", "收到电话广播" + action);
        if (action == null) {
            return;
        }
        if (action.equals("android.intent.action.NEW_OUTGOING_CALL")) {
            intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
            return;
        }
        String stringExtra = intent.getStringExtra("state");
        String stringExtra2 = intent.getStringExtra("incoming_number");
        if (stringExtra2 == null) {
            stringExtra2 = (((a) a2.d.b().f23b) == null || ((a) a2.d.b().f23b).f7648a == null) ? "" : ((a) a2.d.b().f23b).f7648a;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PhoneReceiver", "来电状态：", com.google.android.gms.internal.mlkit_vision_barcode.l0.p("电话响铃 state:", stringExtra, "|phone:", stringExtra2));
        int i3 = stringExtra != null ? stringExtra.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING) ? 0 : stringExtra.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE) ? 2 : stringExtra.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK) ? 1 : -1 : ((a) a2.d.b().f23b).f7649b;
        if (i3 < 0) {
            i3 = ((a) a2.d.b().f23b).f7649b;
        }
        q0.a().b(i3, stringExtra2);
    }
}
