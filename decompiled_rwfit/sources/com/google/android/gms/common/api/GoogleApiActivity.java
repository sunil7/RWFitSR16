package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import q9.n;

@KeepName
/* loaded from: classes.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f9075b = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f9076a = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int i3, int i10, Intent intent) {
        super.onActivityResult(i3, i10, intent);
        if (i3 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f9076a = 0;
            setResult(i10, intent);
            if (booleanExtra) {
                o9.c e = o9.c.e(this);
                if (i10 == -1) {
                    c5.b bVar = e.f16862m;
                    bVar.sendMessage(bVar.obtainMessage(3));
                } else if (i10 == 0) {
                    e.f(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i3 == 2) {
            this.f9076a = 0;
            setResult(i10, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f9076a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        GoogleApiActivity googleApiActivity;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f9076a = bundle.getInt("resolution");
        }
        if (this.f9076a == 1) {
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
            return;
        }
        if (pendingIntent == null) {
            n.e(num);
            n9.b.f16438d.d(this, num.intValue(), this);
            this.f9076a = 1;
            return;
        }
        try {
            googleApiActivity = this;
            try {
                googleApiActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                googleApiActivity.f9076a = 1;
            } catch (ActivityNotFoundException e) {
                e = e;
                if (extras.getBoolean("notify_manager", true)) {
                    o9.c.e(this).f(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String o3 = l0.o("Activity not found while launching ", pendingIntent.toString(), ".");
                    if (Build.FINGERPRINT.contains("generic")) {
                        o3 = o3.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", o3, e);
                }
                googleApiActivity.f9076a = 1;
                finish();
            } catch (IntentSender.SendIntentException e10) {
                e = e10;
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                finish();
            }
        } catch (ActivityNotFoundException e11) {
            e = e11;
            googleApiActivity = this;
        } catch (IntentSender.SendIntentException e12) {
            e = e12;
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f9076a);
        super.onSaveInstanceState(bundle);
    }
}
