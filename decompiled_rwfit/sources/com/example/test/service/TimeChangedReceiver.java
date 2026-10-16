package com.example.test.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.format.DateFormat;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.example.blesdk.bean.function.UnitBean;
import com.example.database.table.User;
import com.google.android.gms.internal.mlkit_vision_barcode.f2;
import java.util.Calendar;

/* loaded from: classes.dex */
public class TimeChangedReceiver extends BroadcastReceiver {
    public static void a(FragmentActivity fragmentActivity) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        fragmentActivity.registerReceiver(new TimeChangedReceiver(), intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.TIME_TICK".equals(intent.getAction()) || "android.intent.action.DATE_CHANGED".equals(intent.getAction())) {
            if ("android.intent.action.DATE_CHANGED".equals(intent.getAction())) {
                if (y5.d.f20005b) {
                    com.google.android.gms.internal.mlkit_vision_common.p.v(Calendar.getInstance().getTime());
                } else {
                    com.google.android.gms.internal.mlkit_vision_common.p.u(Calendar.getInstance().getTime());
                }
            }
            com.example.test.utils.z0.d().f(false);
            Object obj = g1.e;
            com.google.android.gms.internal.mlkit_vision_barcode.p1.a().o(false);
        }
        if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                if (kVar == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                User d5 = com.example.test.utils.k.f8731b.d();
                if (d5 != null) {
                    Log.e("qob", "ACTION_TIME_CHANGED isJLPlatform " + y5.d.f20005b);
                    if (y5.d.f20005b) {
                        com.google.android.gms.internal.mlkit_vision_common.p.w(d5.getMeterUnit());
                        com.google.android.gms.internal.mlkit_vision_common.p.I(d5.getTempUnit());
                        int a3 = f2.a();
                        if (r5.b.k().f18054c) {
                            x5.c b3 = x5.c.b();
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(a3, "getLanguageCmd "));
                            char[] cArr = y5.b.f20001a;
                            b3.g((byte) -15, new byte[]{2, 15, 0, (byte) (a3 & 255)}, new boolean[0]);
                        } else {
                            x5.b.I0().F0((byte) -15);
                        }
                        kotlin.jvm.internal.e.f(context, "context");
                        int i3 = !DateFormat.is24HourFormat(context) ? 1 : 0;
                        if (r5.b.k().f18054c) {
                            x5.c b10 = x5.c.b();
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "getTimeFontCmd "));
                            char[] cArr2 = y5.b.f20001a;
                            b10.g((byte) -16, new byte[]{2, 14, 0, (byte) (i3 & 255)}, new boolean[0]);
                        } else {
                            x5.b.I0().F0((byte) -16);
                        }
                    } else {
                        UnitBean unitBean = new UnitBean();
                        unitBean.setMeasureUnit(d5.getMeterUnit());
                        unitBean.setTempUnit(d5.getTempUnit());
                        kotlin.jvm.internal.e.f(context, "context");
                        unitBean.setTimeFont(!DateFormat.is24HourFormat(context) ? 1 : 0);
                        unitBean.setLang(f2.b());
                        com.google.android.gms.internal.mlkit_vision_common.p.P(unitBean);
                    }
                }
                if (y5.d.f20005b) {
                    com.google.android.gms.internal.mlkit_vision_common.p.v(Calendar.getInstance().getTime());
                } else {
                    com.google.android.gms.internal.mlkit_vision_common.p.u(Calendar.getInstance().getTime());
                }
            }
        }
    }
}
