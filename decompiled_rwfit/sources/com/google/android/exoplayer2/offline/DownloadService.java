package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import com.google.android.gms.internal.mlkit_vision_common.z5;
import java.util.HashMap;
import v8.a;

/* loaded from: classes.dex */
public abstract class DownloadService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f8893a = new HashMap();

    public abstract z5 a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public final void onCreate() {
        a();
        throw null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        a aVar = (a) f8893a.get(getClass());
        aVar.getClass();
        pc.b(aVar.f19215a == this);
        aVar.f19215a = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        if (intent != null) {
            String action = intent.getAction();
            intent.getStringExtra("content_id");
            if (!intent.getBooleanExtra("foreground", false)) {
                "com.google.android.exoplayer.downloadService.action.RESTART".equals(action);
            }
        }
        throw null;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
    }
}
