package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.autonavi.amap.mapcore.AMapEngineUtils;

/* loaded from: classes.dex */
public abstract class y9 {
    public static void a(Context context) {
        kotlin.jvm.internal.e.f(context, "context");
        try {
            try {
                Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Intent intent2 = new Intent();
                intent2.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                intent2.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$NotificationAccessSettingsActivity"));
                intent2.putExtra(":settings:show_fragment", "NotificationAccessSettings");
                context.startActivity(intent2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
