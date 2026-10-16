package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.IntentSenderRequest;

/* loaded from: classes.dex */
public final class g extends androidx.activity.result.f {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f365i;

    public g(ComponentActivity componentActivity) {
        this.f365i = componentActivity;
    }

    @Override // androidx.activity.result.f
    public final void b(int i3, d.a aVar, Object obj) {
        Bundle bundle;
        int i10;
        ComponentActivity componentActivity = this.f365i;
        yh.i b3 = aVar.b(componentActivity, obj);
        if (b3 != null) {
            new Handler(Looper.getMainLooper()).post(new f(this, i3, b3, 0));
            return;
        }
        Intent a3 = aVar.a(componentActivity, obj);
        if (a3.getExtras() != null && a3.getExtras().getClassLoader() == null) {
            a3.setExtrasClassLoader(componentActivity.getClassLoader());
        }
        if (a3.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundle = a3.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            a3.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a3.getAction())) {
            String[] stringArrayExtra = a3.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            y0.d.d(componentActivity, stringArrayExtra, i3);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a3.getAction())) {
            y0.a.b(componentActivity, a3, i3, bundle2);
            return;
        }
        IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a3.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            i10 = i3;
            try {
                y0.a.c(componentActivity, intentSenderRequest.h(), i10, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.d(), 0, bundle2);
            } catch (IntentSender.SendIntentException e) {
                e = e;
                new Handler(Looper.getMainLooper()).post(new f(this, i10, e, 1));
            }
        } catch (IntentSender.SendIntentException e10) {
            e = e10;
            i10 = i3;
        }
    }
}
