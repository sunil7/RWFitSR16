package com.dh.keeplive.entity;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class NotificationConfig implements Parcelable {
    private RemoteViews bigRemoteViews;
    private String channelId;
    private String channelName;
    private String content;
    private boolean hideNotification;
    private boolean hideNotificationAfterO;
    private int largeIcon;
    private Bitmap largeIconBitmap;
    private transient Notification notification;
    private transient Parcelable notificationChannel;
    private transient PendingIntent pendingIntent;
    private RemoteViews remoteViews;
    private int serviceId;
    private int smallIcon;
    private String title;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<NotificationConfig> CREATOR = new Parcelable.Creator<NotificationConfig>() { // from class: com.dh.keeplive.entity.NotificationConfig$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationConfig createFromParcel(Parcel source) {
            e.f(source, "source");
            return new NotificationConfig(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationConfig[] newArray(int i3) {
            return new NotificationConfig[i3];
        }
    };

    public static final class Companion {
        public /* synthetic */ Companion(c cVar) {
            this();
        }

        private Companion() {
        }
    }

    public NotificationConfig() {
        this(0, null, null, null, null, 0, 0, null, false, false, null, null, null, null, null, 32767, null);
    }

    public final boolean canUpdate(NotificationConfig notificationConfig) {
        boolean z5;
        boolean z6;
        e.f(notificationConfig, "notificationConfig");
        if ((this.serviceId == notificationConfig.serviceId && e.a(this.channelId, notificationConfig.channelId) && e.a(this.channelName, notificationConfig.channelName) && (z5 = this.hideNotification) == notificationConfig.hideNotification && (z6 = this.hideNotificationAfterO) == notificationConfig.hideNotificationAfterO && !z5 && !z6) && e.a(this.notificationChannel, notificationConfig.notificationChannel)) {
            Notification notification = this.notification;
            String channelId = notification != null ? notification.getChannelId() : null;
            Notification notification2 = notificationConfig.notification;
            if (e.a(channelId, notification2 != null ? notification2.getChannelId() : null)) {
                return true;
            }
        }
        return false;
    }

    public final int component1() {
        return this.serviceId;
    }

    public final boolean component10() {
        return this.hideNotification;
    }

    public final RemoteViews component11() {
        return this.remoteViews;
    }

    public final RemoteViews component12() {
        return this.bigRemoteViews;
    }

    public final PendingIntent component13() {
        return this.pendingIntent;
    }

    public final Notification component14() {
        return this.notification;
    }

    public final Parcelable component15() {
        return this.notificationChannel;
    }

    public final String component2() {
        return this.channelId;
    }

    public final String component3() {
        return this.channelName;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.content;
    }

    public final int component6() {
        return this.smallIcon;
    }

    public final int component7() {
        return this.largeIcon;
    }

    public final Bitmap component8() {
        return this.largeIconBitmap;
    }

    public final boolean component9() {
        return this.hideNotificationAfterO;
    }

    public final NotificationConfig copy(int i3, String channelId, String channelName, String title, String content, int i10, int i11, Bitmap bitmap, boolean z5, boolean z6, RemoteViews remoteViews, RemoteViews remoteViews2, PendingIntent pendingIntent, Notification notification, Parcelable parcelable) {
        e.f(channelId, "channelId");
        e.f(channelName, "channelName");
        e.f(title, "title");
        e.f(content, "content");
        return new NotificationConfig(i3, channelId, channelName, title, content, i10, i11, bitmap, z5, z6, remoteViews, remoteViews2, pendingIntent, notification, parcelable);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationConfig)) {
            return false;
        }
        NotificationConfig notificationConfig = (NotificationConfig) obj;
        return this.serviceId == notificationConfig.serviceId && e.a(this.channelId, notificationConfig.channelId) && e.a(this.channelName, notificationConfig.channelName) && e.a(this.title, notificationConfig.title) && e.a(this.content, notificationConfig.content) && this.smallIcon == notificationConfig.smallIcon && this.largeIcon == notificationConfig.largeIcon && e.a(this.largeIconBitmap, notificationConfig.largeIconBitmap) && this.hideNotificationAfterO == notificationConfig.hideNotificationAfterO && this.hideNotification == notificationConfig.hideNotification && e.a(this.remoteViews, notificationConfig.remoteViews) && e.a(this.bigRemoteViews, notificationConfig.bigRemoteViews) && e.a(this.pendingIntent, notificationConfig.pendingIntent) && e.a(this.notification, notificationConfig.notification) && e.a(this.notificationChannel, notificationConfig.notificationChannel);
    }

    public final RemoteViews getBigRemoteViews() {
        return this.bigRemoteViews;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getContent() {
        return this.content;
    }

    public final boolean getHideNotification() {
        return this.hideNotification;
    }

    public final boolean getHideNotificationAfterO() {
        return this.hideNotificationAfterO;
    }

    public final int getLargeIcon() {
        return this.largeIcon;
    }

    public final Bitmap getLargeIconBitmap() {
        return this.largeIconBitmap;
    }

    public final Notification getNotification() {
        return this.notification;
    }

    public final Parcelable getNotificationChannel() {
        return this.notificationChannel;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final RemoteViews getRemoteViews() {
        return this.remoteViews;
    }

    public final int getServiceId() {
        return this.serviceId;
    }

    public final int getSmallIcon() {
        return this.smallIcon;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = (Integer.hashCode(this.largeIcon) + ((Integer.hashCode(this.smallIcon) + l0.d(l0.d(l0.d(l0.d(Integer.hashCode(this.serviceId) * 31, 31, this.channelId), 31, this.channelName), 31, this.title), 31, this.content)) * 31)) * 31;
        Bitmap bitmap = this.largeIconBitmap;
        int hashCode2 = (hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        boolean z5 = this.hideNotificationAfterO;
        int i3 = z5;
        if (z5 != 0) {
            i3 = 1;
        }
        int i10 = (hashCode2 + i3) * 31;
        boolean z6 = this.hideNotification;
        int i11 = (i10 + (z6 ? 1 : z6 ? 1 : 0)) * 31;
        RemoteViews remoteViews = this.remoteViews;
        int hashCode3 = (i11 + (remoteViews == null ? 0 : remoteViews.hashCode())) * 31;
        RemoteViews remoteViews2 = this.bigRemoteViews;
        int hashCode4 = (hashCode3 + (remoteViews2 == null ? 0 : remoteViews2.hashCode())) * 31;
        PendingIntent pendingIntent = this.pendingIntent;
        int hashCode5 = (hashCode4 + (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 31;
        Notification notification = this.notification;
        int hashCode6 = (hashCode5 + (notification == null ? 0 : notification.hashCode())) * 31;
        Parcelable parcelable = this.notificationChannel;
        return hashCode6 + (parcelable != null ? parcelable.hashCode() : 0);
    }

    public final void setBigRemoteViews(RemoteViews remoteViews) {
        this.bigRemoteViews = remoteViews;
    }

    public final void setChannelId(String str) {
        e.f(str, "<set-?>");
        this.channelId = str;
    }

    public final void setChannelName(String str) {
        e.f(str, "<set-?>");
        this.channelName = str;
    }

    public final void setContent(String str) {
        e.f(str, "<set-?>");
        this.content = str;
    }

    public final void setHideNotification(boolean z5) {
        this.hideNotification = z5;
    }

    public final void setHideNotificationAfterO(boolean z5) {
        this.hideNotificationAfterO = z5;
    }

    public final void setLargeIcon(int i3) {
        this.largeIcon = i3;
    }

    public final void setLargeIconBitmap(Bitmap bitmap) {
        this.largeIconBitmap = bitmap;
    }

    public final void setNotification(Notification notification) {
        this.notification = notification;
    }

    public final void setNotificationChannel(Parcelable parcelable) {
        this.notificationChannel = parcelable;
    }

    public final void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    public final void setRemoteViews(RemoteViews remoteViews) {
        this.remoteViews = remoteViews;
    }

    public final void setServiceId(int i3) {
        this.serviceId = i3;
    }

    public final void setSmallIcon(int i3) {
        this.smallIcon = i3;
    }

    public final void setTitle(String str) {
        e.f(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        int i3 = this.serviceId;
        String str = this.channelId;
        String str2 = this.channelName;
        String str3 = this.title;
        String str4 = this.content;
        int i10 = this.smallIcon;
        int i11 = this.largeIcon;
        Bitmap bitmap = this.largeIconBitmap;
        boolean z5 = this.hideNotificationAfterO;
        boolean z6 = this.hideNotification;
        RemoteViews remoteViews = this.remoteViews;
        RemoteViews remoteViews2 = this.bigRemoteViews;
        PendingIntent pendingIntent = this.pendingIntent;
        Notification notification = this.notification;
        Parcelable parcelable = this.notificationChannel;
        StringBuilder sb2 = new StringBuilder("NotificationConfig(serviceId=");
        sb2.append(i3);
        sb2.append(", channelId=");
        sb2.append(str);
        sb2.append(", channelName=");
        android.support.v4.media.session.e.z(sb2, str2, ", title=", str3, ", content=");
        sb2.append(str4);
        sb2.append(", smallIcon=");
        sb2.append(i10);
        sb2.append(", largeIcon=");
        sb2.append(i11);
        sb2.append(", largeIconBitmap=");
        sb2.append(bitmap);
        sb2.append(", hideNotificationAfterO=");
        sb2.append(z5);
        sb2.append(", hideNotification=");
        sb2.append(z6);
        sb2.append(", remoteViews=");
        sb2.append(remoteViews);
        sb2.append(", bigRemoteViews=");
        sb2.append(remoteViews2);
        sb2.append(", pendingIntent=");
        sb2.append(pendingIntent);
        sb2.append(", notification=");
        sb2.append(notification);
        sb2.append(", notificationChannel=");
        sb2.append(parcelable);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        e.f(dest, "dest");
        dest.writeInt(this.serviceId);
        dest.writeString(this.channelId);
        dest.writeString(this.channelName);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeInt(this.smallIcon);
        dest.writeInt(this.largeIcon);
        dest.writeParcelable(this.largeIconBitmap, 0);
        dest.writeInt(this.hideNotificationAfterO ? 1 : 0);
        dest.writeInt(this.hideNotification ? 1 : 0);
        dest.writeParcelable(this.remoteViews, 0);
        dest.writeParcelable(this.bigRemoteViews, 0);
        dest.writeParcelable(this.pendingIntent, 0);
        dest.writeParcelable(this.notification, 0);
        dest.writeParcelable(this.notificationChannel, 0);
    }

    public NotificationConfig(int i3, String channelId, String channelName, String title, String content, int i10, int i11, Bitmap bitmap, boolean z5, boolean z6, RemoteViews remoteViews, RemoteViews remoteViews2, PendingIntent pendingIntent, Notification notification, Parcelable parcelable) {
        e.f(channelId, "channelId");
        e.f(channelName, "channelName");
        e.f(title, "title");
        e.f(content, "content");
        this.serviceId = i3;
        this.channelId = channelId;
        this.channelName = channelName;
        this.title = title;
        this.content = content;
        this.smallIcon = i10;
        this.largeIcon = i11;
        this.largeIconBitmap = bitmap;
        this.hideNotificationAfterO = z5;
        this.hideNotification = z6;
        this.remoteViews = remoteViews;
        this.bigRemoteViews = remoteViews2;
        this.pendingIntent = pendingIntent;
        this.notification = notification;
        this.notificationChannel = parcelable;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NotificationConfig(int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, int r23, android.graphics.Bitmap r24, boolean r25, boolean r26, android.widget.RemoteViews r27, android.widget.RemoteViews r28, android.app.PendingIntent r29, android.app.Notification r30, android.os.Parcelable r31, int r32, kotlin.jvm.internal.c r33) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dh.keeplive.entity.NotificationConfig.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, android.graphics.Bitmap, boolean, boolean, android.widget.RemoteViews, android.widget.RemoteViews, android.app.PendingIntent, android.app.Notification, android.os.Parcelable, int, kotlin.jvm.internal.c):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NotificationConfig(android.os.Parcel r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "source"
            kotlin.jvm.internal.e.f(r0, r1)
            int r3 = r0.readInt()
            java.lang.String r1 = r0.readString()
            java.lang.String r2 = "Cactus"
            if (r1 != 0) goto L15
            r4 = r2
            goto L16
        L15:
            r4 = r1
        L16:
            java.lang.String r1 = r0.readString()
            if (r1 != 0) goto L1e
            r5 = r2
            goto L1f
        L1e:
            r5 = r1
        L1f:
            java.lang.String r1 = r0.readString()
            if (r1 != 0) goto L27
            r6 = r2
            goto L28
        L27:
            r6 = r1
        L28:
            java.lang.String r1 = r0.readString()
            if (r1 != 0) goto L30
            java.lang.String r1 = "The app of cactus is running"
        L30:
            r7 = r1
            int r8 = r0.readInt()
            int r9 = r0.readInt()
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r0.readParcelable(r1)
            r10 = r1
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            int r1 = r0.readInt()
            r2 = 0
            r11 = 1
            if (r11 != r1) goto L50
            r1 = r11
            goto L51
        L50:
            r1 = r2
        L51:
            int r12 = r0.readInt()
            if (r11 != r12) goto L59
            r12 = r11
            goto L5a
        L59:
            r12 = r2
        L5a:
            java.lang.Class<android.widget.RemoteViews> r2 = android.widget.RemoteViews.class
            java.lang.ClassLoader r11 = r2.getClassLoader()
            android.os.Parcelable r11 = r0.readParcelable(r11)
            r13 = r11
            android.widget.RemoteViews r13 = (android.widget.RemoteViews) r13
            java.lang.ClassLoader r2 = r2.getClassLoader()
            android.os.Parcelable r2 = r0.readParcelable(r2)
            r14 = r2
            android.widget.RemoteViews r14 = (android.widget.RemoteViews) r14
            java.lang.Class<android.app.PendingIntent> r2 = android.app.PendingIntent.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            android.os.Parcelable r2 = r0.readParcelable(r2)
            r15 = r2
            android.app.PendingIntent r15 = (android.app.PendingIntent) r15
            java.lang.Class<android.app.Notification> r2 = android.app.Notification.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            android.os.Parcelable r2 = r0.readParcelable(r2)
            r16 = r2
            android.app.Notification r16 = (android.app.Notification) r16
            java.lang.Class<android.os.Parcelable> r2 = android.os.Parcelable.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            android.os.Parcelable r17 = r0.readParcelable(r2)
            r2 = r18
            r11 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dh.keeplive.entity.NotificationConfig.<init>(android.os.Parcel):void");
    }
}
