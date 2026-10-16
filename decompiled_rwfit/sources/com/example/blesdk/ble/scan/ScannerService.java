package com.example.blesdk.ble.scan;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import t5.b;
import t5.h;
import t5.i;

/* loaded from: classes.dex */
public class ScannerService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7273a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public HashMap f7274b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f7275c;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f7274b = new HashMap();
        this.f7275c = new Handler();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        b a3 = b.a();
        Iterator it = this.f7274b.values().iterator();
        while (it.hasNext()) {
            try {
                a3.c((i) it.next());
            } catch (Exception unused) {
            }
        }
        this.f7274b.clear();
        this.f7274b = null;
        this.f7275c = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        boolean containsKey;
        i iVar;
        boolean isEmpty;
        boolean isEmpty2;
        if (intent != null) {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT");
            int intExtra = intent.getIntExtra("no.nordicsemi.android.support.v18.REQUEST_CODE", 0);
            boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_START", false);
            if (pendingIntent == null) {
                synchronized (this.f7273a) {
                    isEmpty2 = this.f7274b.isEmpty();
                }
                if (isEmpty2) {
                    stopSelf();
                    return 2;
                }
            } else {
                synchronized (this.f7273a) {
                    containsKey = this.f7274b.containsKey(Integer.valueOf(intExtra));
                }
                if (booleanExtra && !containsKey) {
                    List parcelableArrayListExtra = intent.getParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS");
                    ScanSettings scanSettings = (ScanSettings) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS");
                    if (parcelableArrayListExtra == null) {
                        parcelableArrayListExtra = Collections.EMPTY_LIST;
                    }
                    if (scanSettings == null) {
                        scanSettings = new ScanSettings(0, 1, 0L, 1, 3, true, 255, true, true, true, 10000L, 10000L, 500L, 4500L);
                    }
                    h hVar = new h(pendingIntent, scanSettings, this);
                    synchronized (this.f7273a) {
                        this.f7274b.put(Integer.valueOf(intExtra), hVar);
                    }
                    try {
                        b.a().b(parcelableArrayListExtra, scanSettings, hVar, this.f7275c);
                    } catch (Exception e) {
                        Log.w("ScannerService", "Starting scanning failed", e);
                    }
                } else if (!booleanExtra && containsKey) {
                    synchronized (this.f7273a) {
                        iVar = (i) this.f7274b.remove(Integer.valueOf(intExtra));
                        isEmpty = this.f7274b.isEmpty();
                    }
                    if (iVar != null) {
                        try {
                            b.a().c(iVar);
                        } catch (Exception e10) {
                            Log.w("ScannerService", "Stopping scanning failed", e10);
                        }
                        if (isEmpty) {
                            stopSelf();
                        }
                    }
                }
            }
        }
        return 2;
    }
}
