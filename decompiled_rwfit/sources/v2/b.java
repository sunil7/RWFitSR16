package v2;

import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import o2.m;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: i, reason: collision with root package name */
    public static final String f19131i = m.i("BatteryNotLowTracker");

    @Override // v2.d
    public final Object a() {
        Intent registerReceiver = this.f19136b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return Boolean.valueOf(registerReceiver.getIntExtra(FileDownloadModel.STATUS, -1) == 1 || ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)) > 0.15f);
        }
        m.g().f(f19131i, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }

    @Override // v2.c
    public final IntentFilter f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // v2.c
    public final void g(Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        m.g().d(f19131i, l0.n("Received ", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.getClass();
        if (action.equals("android.intent.action.BATTERY_OKAY")) {
            c(Boolean.TRUE);
        } else if (action.equals("android.intent.action.BATTERY_LOW")) {
            c(Boolean.FALSE);
        }
    }
}
