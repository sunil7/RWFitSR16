package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import a8.b;
import a8.i;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import de.o;
import f8.e;
import f8.g;
import j8.a;

/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f8839a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i3 = intent.getExtras().getInt("attemptNumber");
        i.b(context);
        o a3 = b.a();
        if (queryParameter == null) {
            throw new NullPointerException("Null backendName");
        }
        a3.f12377b = queryParameter;
        a3.f12378c = a.b(intValue);
        if (queryParameter2 != null) {
            a3.f12379d = Base64.decode(queryParameter2, 0);
        }
        g gVar = i.a().f140d;
        b i10 = a3.i();
        f8.a aVar = f8.a.f13502a;
        gVar.getClass();
        gVar.e.execute(new e(gVar, i10, i3, aVar));
    }
}
