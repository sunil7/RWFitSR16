package com.google.android.gms.internal.mlkit_vision_barcode;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import androidx.core.R$dimen;
import com.dh.keeplive.R$drawable;
import com.dh.keeplive.entity.NotificationConfig;
import com.dh.keeplive.exception.KeepLiveException;

/* loaded from: classes.dex */
public abstract class cf {
    public static final Notification a(ContextWrapper contextWrapper, NotificationConfig notificationConfig) {
        kotlin.jvm.internal.e.f(notificationConfig, "notificationConfig");
        y0.r rVar = new y0.r(contextWrapper);
        Notification notification = notificationConfig.getNotification();
        if (notification == null) {
            y0.l lVar = new y0.l(contextWrapper, notificationConfig.getChannelId());
            lVar.e = y0.l.b(notificationConfig.getTitle());
            lVar.f19882f = y0.l.b(notificationConfig.getContent());
            lVar.r.icon = notificationConfig.getHideNotification() ? !notificationConfig.getHideNotificationAfterO() ? notificationConfig.getSmallIcon() : R$drawable.icon_keeplive_trans : notificationConfig.getSmallIcon();
            Bitmap largeIconBitmap = notificationConfig.getLargeIconBitmap();
            if (largeIconBitmap == null) {
                largeIconBitmap = notificationConfig.getLargeIcon() == 0 ? null : BitmapFactory.decodeResource(contextWrapper.getResources(), notificationConfig.getLargeIcon());
            }
            if (largeIconBitmap != null && Build.VERSION.SDK_INT < 27) {
                Resources resources = lVar.f19878a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_height);
                if (largeIconBitmap.getWidth() > dimensionPixelSize || largeIconBitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(dimensionPixelSize / Math.max(1, largeIconBitmap.getWidth()), dimensionPixelSize2 / Math.max(1, largeIconBitmap.getHeight()));
                    largeIconBitmap = Bitmap.createScaledBitmap(largeIconBitmap, (int) Math.ceil(largeIconBitmap.getWidth() * min), (int) Math.ceil(largeIconBitmap.getHeight() * min), true);
                }
            }
            lVar.f19884h = largeIconBitmap;
            lVar.f19883g = notificationConfig.getPendingIntent();
            lVar.c(16, true);
            lVar.f19890n = -1;
            lVar.f19885i = -2;
            RemoteViews remoteViews = notificationConfig.getRemoteViews();
            if (remoteViews != null) {
                lVar.r.contentView = remoteViews;
            }
            RemoteViews bigRemoteViews = notificationConfig.getBigRemoteViews();
            if (bigRemoteViews != null) {
                lVar.f19891o = bigRemoteViews;
            }
            notification = lVar.a();
            kotlin.jvm.internal.e.e(notification, "build(...)");
        }
        String channelId = notification.getChannelId();
        NotificationManager notificationManager = rVar.f19913a;
        if (notificationManager.getNotificationChannel(channelId) == null) {
            if (notificationConfig.getNotificationChannel() == null || !(notificationConfig.getNotificationChannel() instanceof NotificationChannel)) {
                notificationConfig.setNotificationChannel(new NotificationChannel(notification.getChannelId(), notificationConfig.getChannelName(), 0));
            } else {
                Parcelable notificationChannel = notificationConfig.getNotificationChannel();
                kotlin.jvm.internal.e.d(notificationChannel, "null cannot be cast to non-null type android.app.NotificationChannel");
                if (!kotlin.jvm.internal.e.a(((NotificationChannel) notificationChannel).getId(), notification.getChannelId())) {
                    throw new KeepLiveException("保证渠道相同(The id of the NotificationChannel is different from the channel of the Notification.)");
                }
            }
            Parcelable notificationChannel2 = notificationConfig.getNotificationChannel();
            kotlin.jvm.internal.e.d(notificationChannel2, "null cannot be cast to non-null type android.app.NotificationChannel");
            notificationManager.createNotificationChannel((NotificationChannel) notificationChannel2);
        }
        return notification;
    }

    public static final void b(Service service, NotificationConfig notificationConfig) {
        kotlin.jvm.internal.e.f(notificationConfig, "notificationConfig");
        y0.r rVar = new y0.r(service);
        Notification a3 = a(service, notificationConfig);
        int serviceId = notificationConfig.getServiceId();
        Bundle bundle = a3.extras;
        if (bundle == null || !bundle.getBoolean("android.support.useSideChannel")) {
            rVar.f19913a.notify(null, serviceId, a3);
        } else {
            y0.n nVar = new y0.n(service.getPackageName(), serviceId, a3);
            synchronized (y0.r.e) {
                try {
                    if (y0.r.f19912f == null) {
                        y0.r.f19912f = new y0.q(service.getApplicationContext());
                    }
                    y0.r.f19912f.f19906b.obtainMessage(0, nVar).sendToTarget();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            rVar.f19913a.cancel(null, serviceId);
        }
        service.startForeground(notificationConfig.getServiceId(), a3);
        if (notificationConfig.getHideNotification()) {
            if (rVar.f19913a.getNotificationChannel(a3.getChannelId()) == null || !notificationConfig.getHideNotificationAfterO()) {
                return;
            }
            com.dh.keeplive.ext.a.b().postDelayed(new n5.a(0, rVar, a3), 1000L);
        }
    }
}
