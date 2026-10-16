package com.dh.keeplive.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class KeepLiveConfig implements Parcelable {
    private final DefaultConfig defaultConfig;
    private NotificationConfig notificationConfig;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<KeepLiveConfig> CREATOR = new Parcelable.Creator<KeepLiveConfig>() { // from class: com.dh.keeplive.entity.KeepLiveConfig$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeepLiveConfig createFromParcel(Parcel source) {
            e.f(source, "source");
            return new KeepLiveConfig(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeepLiveConfig[] newArray(int i3) {
            return new KeepLiveConfig[i3];
        }
    };

    public static final class Companion {
        public /* synthetic */ Companion(c cVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KeepLiveConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ KeepLiveConfig copy$default(KeepLiveConfig keepLiveConfig, NotificationConfig notificationConfig, DefaultConfig defaultConfig, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            notificationConfig = keepLiveConfig.notificationConfig;
        }
        if ((i3 & 2) != 0) {
            defaultConfig = keepLiveConfig.defaultConfig;
        }
        return keepLiveConfig.copy(notificationConfig, defaultConfig);
    }

    public final NotificationConfig component1() {
        return this.notificationConfig;
    }

    public final DefaultConfig component2() {
        return this.defaultConfig;
    }

    public final KeepLiveConfig copy(NotificationConfig notificationConfig, DefaultConfig defaultConfig) {
        e.f(notificationConfig, "notificationConfig");
        e.f(defaultConfig, "defaultConfig");
        return new KeepLiveConfig(notificationConfig, defaultConfig);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeepLiveConfig)) {
            return false;
        }
        KeepLiveConfig keepLiveConfig = (KeepLiveConfig) obj;
        return e.a(this.notificationConfig, keepLiveConfig.notificationConfig) && e.a(this.defaultConfig, keepLiveConfig.defaultConfig);
    }

    public final DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public final NotificationConfig getNotificationConfig() {
        return this.notificationConfig;
    }

    public int hashCode() {
        return this.defaultConfig.hashCode() + (this.notificationConfig.hashCode() * 31);
    }

    public final void setNotificationConfig(NotificationConfig notificationConfig) {
        e.f(notificationConfig, "<set-?>");
        this.notificationConfig = notificationConfig;
    }

    public String toString() {
        return "KeepLiveConfig(notificationConfig=" + this.notificationConfig + ", defaultConfig=" + this.defaultConfig + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        e.f(dest, "dest");
        dest.writeParcelable(this.notificationConfig, 0);
        dest.writeParcelable(this.defaultConfig, 0);
    }

    public KeepLiveConfig(NotificationConfig notificationConfig, DefaultConfig defaultConfig) {
        e.f(notificationConfig, "notificationConfig");
        e.f(defaultConfig, "defaultConfig");
        this.notificationConfig = notificationConfig;
        this.defaultConfig = defaultConfig;
    }

    public /* synthetic */ KeepLiveConfig(NotificationConfig notificationConfig, DefaultConfig defaultConfig, int i3, c cVar) {
        this((i3 & 1) != 0 ? new NotificationConfig(0, null, null, null, null, 0, 0, null, false, false, null, null, null, null, null, 32767, null) : notificationConfig, (i3 & 2) != 0 ? new DefaultConfig(false, false, false, 0L, 0, false, false, false, false, null, 1023, null) : defaultConfig);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public KeepLiveConfig(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.e.f(r3, r0)
            java.lang.Class<com.dh.keeplive.entity.NotificationConfig> r0 = com.dh.keeplive.entity.NotificationConfig.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r3.readParcelable(r0)
            kotlin.jvm.internal.e.c(r0)
            com.dh.keeplive.entity.NotificationConfig r0 = (com.dh.keeplive.entity.NotificationConfig) r0
            java.lang.Class<com.dh.keeplive.entity.DefaultConfig> r1 = com.dh.keeplive.entity.DefaultConfig.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r3 = r3.readParcelable(r1)
            kotlin.jvm.internal.e.c(r3)
            com.dh.keeplive.entity.DefaultConfig r3 = (com.dh.keeplive.entity.DefaultConfig) r3
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dh.keeplive.entity.KeepLiveConfig.<init>(android.os.Parcel):void");
    }
}
