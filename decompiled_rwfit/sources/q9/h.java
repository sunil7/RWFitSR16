package q9;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;

/* loaded from: classes.dex */
public final class h implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17819a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f17820b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f17821c;

    public /* synthetic */ h(Intent intent, Object obj, int i3) {
        this.f17819a = i3;
        this.f17820b = intent;
        this.f17821c = obj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, o9.e] */
    public final void a() {
        switch (this.f17819a) {
            case 0:
                Intent intent = this.f17820b;
                if (intent != null) {
                    ((GoogleApiActivity) this.f17821c).startActivityForResult(intent, 2);
                    break;
                }
                break;
            default:
                Intent intent2 = this.f17820b;
                if (intent2 != null) {
                    this.f17821c.a(intent2, 2);
                    break;
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
