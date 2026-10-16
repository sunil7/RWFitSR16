package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.SharedPreferences;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.dh.keeplive.entity.KeepLiveConstant;

/* loaded from: classes.dex */
public abstract class af {
    public static final KeepLiveConfig a(Context context) {
        KeepLiveConfig keepLiveConfig;
        kotlin.jvm.internal.e.f(context, "<this>");
        KeepLiveConfig keepLiveConfig2 = com.dh.keeplive.ext.a.f7214g;
        if (keepLiveConfig2 != null) {
            return keepLiveConfig2;
        }
        String string = context.getSharedPreferences(KeepLiveConstant.KEEP_LIVE_TAG, 0).getString(KeepLiveConstant.KEEP_LIVE_CONFIG, null);
        if (string != null) {
            Class cls = KeepLiveConfig.class;
            Object b3 = new com.google.gson.e().b(string, cls);
            if (cls == Integer.TYPE) {
                cls = Integer.class;
            } else if (cls == Float.TYPE) {
                cls = Float.class;
            } else if (cls == Byte.TYPE) {
                cls = Byte.class;
            } else if (cls == Double.TYPE) {
                cls = Double.class;
            } else if (cls == Long.TYPE) {
                cls = Long.class;
            } else if (cls == Character.TYPE) {
                cls = Character.class;
            } else if (cls == Boolean.TYPE) {
                cls = Boolean.class;
            } else if (cls == Short.TYPE) {
                cls = Short.class;
            } else if (cls == Void.TYPE) {
                cls = Void.class;
            }
            keepLiveConfig = (KeepLiveConfig) cls.cast(b3);
        } else {
            keepLiveConfig = null;
        }
        return keepLiveConfig == null ? new KeepLiveConfig(null, null, 3, null) : keepLiveConfig;
    }

    public static final void b(Context context, KeepLiveConfig keepLiveConfig) {
        kotlin.jvm.internal.e.f(context, "<this>");
        com.dh.keeplive.ext.a.f7214g = keepLiveConfig;
        int i3 = context.getSharedPreferences(KeepLiveConstant.KEEP_LIVE_TAG, 0).getInt(KeepLiveConstant.KEEP_LIVE_SERVICE_ID, -1);
        if (i3 > 0) {
            keepLiveConfig.getNotificationConfig().setServiceId(i3);
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(KeepLiveConstant.KEEP_LIVE_TAG, 0).edit();
        edit.putString(KeepLiveConstant.KEEP_LIVE_CONFIG, new com.google.gson.e().e(keepLiveConfig));
        if (i3 <= 0) {
            edit.putInt(KeepLiveConstant.KEEP_LIVE_SERVICE_ID, keepLiveConfig.getNotificationConfig().getServiceId());
        }
        edit.apply();
    }
}
