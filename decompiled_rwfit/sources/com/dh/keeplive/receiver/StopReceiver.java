package com.dh.keeplive.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class StopReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7216a;

    /* renamed from: b, reason: collision with root package name */
    public Lambda f7217b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7218c;

    public StopReceiver(Context context) {
        this.f7216a = context;
        String n4 = l0.n("com.xj.keeplive.flag.stop.", context.getPackageName());
        this.f7218c = n4;
        context.registerReceiver(this, new IntentFilter(n4), 4);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [kotlin.jvm.internal.Lambda, oh.a] */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null || !action.equals(this.f7218c)) {
            return;
        }
        this.f7216a.unregisterReceiver(this);
        ?? r12 = this.f7217b;
        if (r12 != 0) {
            r12.invoke();
        }
    }
}
