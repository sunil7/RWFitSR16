package com.google.android.exoplayer2.scheduler;

import android.os.Parcel;
import android.os.Parcelable;
import u8.b;

/* loaded from: classes.dex */
public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new b(9);
    public static final int DEVICE_CHARGING = 8;
    public static final int DEVICE_IDLE = 4;
    public static final int DEVICE_STORAGE_NOT_LOW = 16;
    public static final int NETWORK = 1;
    public static final int NETWORK_UNMETERED = 2;
    private final int requirements;

    public Requirements(int i3) {
        this.requirements = (i3 & 2) != 0 ? i3 | 1 : i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        if (r5.hasCapability(16) != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(com.google.android.exoplayer2.scheduler.PlatformScheduler$PlatformSchedulerService r10) {
        /*
            r9 = this;
            int r0 = r9.requirements
            r1 = 1
            r0 = r0 & r1
            r2 = 16
            r3 = 2
            r4 = 0
            if (r0 == 0) goto L48
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r10.getSystemService(r0)
            r0.getClass()
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r5 = r0.getActiveNetworkInfo()
            if (r5 == 0) goto L4a
            boolean r5 = r5.isConnected()
            if (r5 == 0) goto L4a
            int r5 = i9.g.f14378a
            r6 = 24
            if (r5 >= r6) goto L28
            goto L3b
        L28:
            android.net.Network r5 = r0.getActiveNetwork()
            if (r5 != 0) goto L2f
            goto L4a
        L2f:
            android.net.NetworkCapabilities r5 = r0.getNetworkCapabilities(r5)     // Catch: java.lang.SecurityException -> L3b
            if (r5 == 0) goto L4a
            boolean r5 = r5.hasCapability(r2)     // Catch: java.lang.SecurityException -> L3b
            if (r5 == 0) goto L4a
        L3b:
            int r5 = r9.requirements
            r5 = r5 & r3
            if (r5 == 0) goto L48
            boolean r0 = r0.isActiveNetworkMetered()
            if (r0 == 0) goto L48
            r0 = r3
            goto L4e
        L48:
            r0 = r4
            goto L4e
        L4a:
            int r0 = r9.requirements
            r0 = r0 & 3
        L4e:
            int r5 = r9.requirements
            r5 = r5 & 8
            r6 = 0
            if (r5 == 0) goto L72
            android.content.IntentFilter r5 = new android.content.IntentFilter
            java.lang.String r7 = "android.intent.action.BATTERY_CHANGED"
            r5.<init>(r7)
            android.content.Intent r5 = r10.registerReceiver(r6, r5)
            if (r5 != 0) goto L63
            goto L70
        L63:
            java.lang.String r7 = "status"
            r8 = -1
            int r5 = r5.getIntExtra(r7, r8)
            if (r5 == r3) goto L72
            r3 = 5
            if (r5 != r3) goto L70
            goto L72
        L70:
            r0 = r0 | 8
        L72:
            int r3 = r9.requirements
            r3 = r3 & 4
            if (r3 == 0) goto La7
            java.lang.String r3 = "power"
            java.lang.Object r3 = r10.getSystemService(r3)
            r3.getClass()
            android.os.PowerManager r3 = (android.os.PowerManager) r3
            int r5 = i9.g.f14378a
            r7 = 23
            if (r5 < r7) goto L8e
            boolean r3 = r3.isDeviceIdleMode()
            goto La3
        L8e:
            r7 = 20
            if (r5 < r7) goto L9c
            boolean r3 = r3.isInteractive()
            if (r3 != 0) goto L9a
        L98:
            r3 = r1
            goto La3
        L9a:
            r3 = r4
            goto La3
        L9c:
            boolean r3 = r3.isScreenOn()
            if (r3 != 0) goto L9a
            goto L98
        La3:
            if (r3 != 0) goto La7
            r0 = r0 | 4
        La7:
            int r3 = r9.requirements
            r2 = r2 & r3
            if (r2 == 0) goto Lae
            r2 = r1
            goto Laf
        Lae:
            r2 = r4
        Laf:
            if (r2 == 0) goto Lc4
            android.content.IntentFilter r2 = new android.content.IntentFilter
            java.lang.String r3 = "android.intent.action.DEVICE_STORAGE_LOW"
            r2.<init>(r3)
            android.content.Intent r10 = r10.registerReceiver(r6, r2)
            if (r10 != 0) goto Lbf
            goto Lc0
        Lbf:
            r1 = r4
        Lc0:
            if (r1 != 0) goto Lc4
            r0 = r0 | 16
        Lc4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.scheduler.Requirements.a(com.google.android.exoplayer2.scheduler.PlatformScheduler$PlatformSchedulerService):int");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Requirements.class == obj.getClass() && this.requirements == ((Requirements) obj).requirements;
    }

    public final int hashCode() {
        return this.requirements;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.requirements);
    }
}
