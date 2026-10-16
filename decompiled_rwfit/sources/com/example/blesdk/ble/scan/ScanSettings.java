package com.example.blesdk.ble.scan;

import android.os.Parcel;
import android.os.Parcelable;
import q9.o;

/* loaded from: classes.dex */
public final class ScanSettings implements Parcelable {
    public static final int CALLBACK_TYPE_ALL_MATCHES = 1;
    public static final int CALLBACK_TYPE_FIRST_MATCH = 2;
    public static final int CALLBACK_TYPE_MATCH_LOST = 4;
    public static final Parcelable.Creator<ScanSettings> CREATOR = new o(20);
    public static final long MATCH_LOST_DEVICE_TIMEOUT_DEFAULT = 10000;
    public static final long MATCH_LOST_TASK_INTERVAL_DEFAULT = 10000;
    public static final int MATCH_MODE_AGGRESSIVE = 1;
    public static final int MATCH_MODE_STICKY = 2;
    public static final int MATCH_NUM_FEW_ADVERTISEMENT = 2;
    public static final int MATCH_NUM_MAX_ADVERTISEMENT = 3;
    public static final int MATCH_NUM_ONE_ADVERTISEMENT = 1;
    public static final int PHY_LE_ALL_SUPPORTED = 255;
    public static final int SCAN_MODE_BALANCED = 1;
    public static final int SCAN_MODE_LOW_LATENCY = 2;
    public static final int SCAN_MODE_LOW_POWER = 0;
    public static final int SCAN_MODE_OPPORTUNISTIC = -1;
    private final int callbackType;
    private final boolean legacy;
    private final long matchLostDeviceTimeout;
    private final long matchLostTaskInterval;
    private final int matchMode;
    private final int numOfMatchesPerFilter;
    private final int phy;
    private final long powerSaveRestInterval;
    private final long powerSaveScanInterval;
    private final long reportDelayMillis;
    private final int scanMode;
    private final boolean useHardwareBatchingIfSupported;
    private boolean useHardwareCallbackTypesIfSupported;
    private final boolean useHardwareFilteringIfSupported;

    public ScanSettings(int i3, int i10, long j4, int i11, int i12, boolean z5, int i13, boolean z6, boolean z8, boolean z10, long j10, long j11, long j12, long j13) {
        this.scanMode = i3;
        this.callbackType = i10;
        this.reportDelayMillis = j4;
        this.numOfMatchesPerFilter = i12;
        this.matchMode = i11;
        this.legacy = z5;
        this.phy = i13;
        this.useHardwareFilteringIfSupported = z6;
        this.useHardwareBatchingIfSupported = z8;
        this.useHardwareCallbackTypesIfSupported = z10;
        this.matchLostDeviceTimeout = j10 * 1000000;
        this.matchLostTaskInterval = j11;
        this.powerSaveScanInterval = j12;
        this.powerSaveRestInterval = j13;
    }

    public final void a() {
        this.useHardwareCallbackTypesIfSupported = false;
    }

    public final int b() {
        return this.callbackType;
    }

    public final boolean d() {
        return this.legacy;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final long h() {
        return this.matchLostDeviceTimeout;
    }

    public final long i() {
        return this.matchLostTaskInterval;
    }

    public final int j() {
        return this.matchMode;
    }

    public final int k() {
        return this.numOfMatchesPerFilter;
    }

    public final int l() {
        return this.phy;
    }

    public final long m() {
        return this.reportDelayMillis;
    }

    public final int n() {
        return this.scanMode;
    }

    public final boolean o() {
        return this.useHardwareBatchingIfSupported;
    }

    public final boolean p() {
        return this.useHardwareCallbackTypesIfSupported;
    }

    public final boolean q() {
        return this.useHardwareFilteringIfSupported;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.scanMode);
        parcel.writeInt(this.callbackType);
        parcel.writeLong(this.reportDelayMillis);
        parcel.writeInt(this.matchMode);
        parcel.writeInt(this.numOfMatchesPerFilter);
        parcel.writeInt(this.legacy ? 1 : 0);
        parcel.writeInt(this.phy);
        parcel.writeInt(this.useHardwareFilteringIfSupported ? 1 : 0);
        parcel.writeInt(this.useHardwareBatchingIfSupported ? 1 : 0);
        parcel.writeLong(this.matchLostDeviceTimeout);
        parcel.writeLong(this.matchLostTaskInterval);
        parcel.writeLong(this.powerSaveScanInterval);
        parcel.writeLong(this.powerSaveRestInterval);
    }

    public ScanSettings(Parcel parcel) {
        this.scanMode = parcel.readInt();
        this.callbackType = parcel.readInt();
        this.reportDelayMillis = parcel.readLong();
        this.matchMode = parcel.readInt();
        this.numOfMatchesPerFilter = parcel.readInt();
        this.legacy = parcel.readInt() != 0;
        this.phy = parcel.readInt();
        this.useHardwareFilteringIfSupported = parcel.readInt() == 1;
        this.useHardwareBatchingIfSupported = parcel.readInt() == 1;
        this.matchLostDeviceTimeout = parcel.readLong();
        this.matchLostTaskInterval = parcel.readLong();
        this.powerSaveScanInterval = parcel.readLong();
        this.powerSaveRestInterval = parcel.readLong();
    }
}
