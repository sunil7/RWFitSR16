package v2;

import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import o2.m;

/* loaded from: classes.dex */
public final class g extends c {

    /* renamed from: i, reason: collision with root package name */
    public static final String f19143i = m.i("StorageNotLowTracker");

    @Override // v2.d
    public final Object a() {
        Intent registerReceiver = this.f19136b.registerReceiver(null, f());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = registerReceiver.getAction();
        action.getClass();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // v2.c
    public final IntentFilter f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // v2.c
    public final void g(Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        m.g().d(f19143i, l0.n("Received ", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.getClass();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            c(Boolean.FALSE);
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            c(Boolean.TRUE);
        }
    }
}
