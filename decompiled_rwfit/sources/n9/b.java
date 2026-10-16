package n9;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.u0;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.q6;
import q9.n;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f16437c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final b f16438d = new b();

    public static AlertDialog e(Activity activity, int i3, q9.h hVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i3 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(q9.g.b(activity, i3));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i3 != 1 ? i3 != 2 ? i3 != 3 ? resources.getString(R.string.ok) : resources.getString(R$string.common_google_play_services_enable_button) : resources.getString(R$string.common_google_play_services_update_button) : resources.getString(R$string.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, hVar);
        }
        String c9 = q9.g.c(activity, i3);
        if (c9 != null) {
            builder.setTitle(c9);
        }
        Log.w("GoogleApiAvailability", l0.j(i3, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void f(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                u0 C0 = ((FragmentActivity) activity).C0();
                f fVar = new f();
                n.f(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                fVar.f16446q = alertDialog;
                if (onCancelListener != null) {
                    fVar.r = onCancelListener;
                }
                fVar.f2248n = false;
                fVar.f2249o = true;
                C0.getClass();
                androidx.fragment.app.a aVar = new androidx.fragment.app.a(C0);
                aVar.e(0, fVar, str, 1);
                aVar.d(false);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        a aVar2 = new a();
        n.f(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        aVar2.f16434a = alertDialog;
        if (onCancelListener != null) {
            aVar2.f16435b = onCancelListener;
        }
        aVar2.show(fragmentManager, str);
    }

    public final void d(GoogleApiActivity googleApiActivity, int i3, GoogleApiActivity googleApiActivity2) {
        AlertDialog e = e(googleApiActivity, i3, new q9.h(super.b(googleApiActivity, i3, Const.INTENT_KEY_UMID), googleApiActivity, 0), googleApiActivity2);
        if (e == null) {
            return;
        }
        f(googleApiActivity, e, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void g(Context context, int i3, PendingIntent pendingIntent) {
        int i10;
        Log.w("GoogleApiAvailability", l0.k(i3, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i3 == 18) {
            new g(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i3 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String e = i3 == 6 ? q9.g.e(context, "common_google_play_services_resolution_required_title") : q9.g.c(context, i3);
        if (e == null) {
            e = context.getResources().getString(R$string.common_google_play_services_notification_ticker);
        }
        String d5 = (i3 == 6 || i3 == 19) ? q9.g.d(context, "common_google_play_services_resolution_required_text", q9.g.a(context)) : q9.g.b(context, i3);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        n.e(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        y0.l lVar = new y0.l(context, null);
        lVar.f19888l = true;
        lVar.c(16, true);
        lVar.e = y0.l.b(e);
        o4.c cVar = new o4.c();
        cVar.f16733b = y0.l.b(d5);
        lVar.d(cVar);
        if (q6.a(context)) {
            lVar.r.icon = context.getApplicationInfo().icon;
            lVar.f19885i = 2;
            if (q6.b(context)) {
                lVar.f19879b.add(new y0.k(R$drawable.common_full_open_on_phone, resources.getString(R$string.common_open_on_phone), pendingIntent));
            } else {
                lVar.f19883g = pendingIntent;
            }
        } else {
            lVar.r.icon = R.drawable.stat_sys_warning;
            lVar.r.tickerText = y0.l.b(resources.getString(R$string.common_google_play_services_notification_ticker));
            lVar.r.when = System.currentTimeMillis();
            lVar.f19883g = pendingIntent;
            lVar.f19882f = y0.l.b(d5);
        }
        synchronized (f16437c) {
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
        String string = context.getResources().getString(R$string.common_google_play_services_notification_channel_name);
        if (notificationChannel == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
        } else if (!string.contentEquals(notificationChannel.getName())) {
            notificationChannel.setName(string);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        lVar.f19892p = "com.google.android.gms.availability";
        Notification a3 = lVar.a();
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            d.f16441a.set(false);
            i10 = 10436;
        } else {
            i10 = 39789;
        }
        notificationManager.notify(i10, a3);
    }

    public final void h(Activity activity, o9.e eVar, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog e = e(activity, i3, new q9.h(super.b(activity, i3, Const.INTENT_KEY_UMID), eVar, 1), onCancelListener);
        if (e == null) {
            return;
        }
        f(activity, e, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
