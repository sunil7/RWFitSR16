package com.example.blesdk.ble.scan;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import com.google.android.gms.internal.mlkit_vision_common.d0;
import java.util.Arrays;
import q9.o;
import t5.j;

/* loaded from: classes.dex */
public final class ScanResult implements Parcelable {
    public static final Parcelable.Creator<ScanResult> CREATOR = new o(19);
    public static final int DATA_COMPLETE = 0;
    public static final int DATA_TRUNCATED = 2;
    public static final int PERIODIC_INTERVAL_NOT_PRESENT = 0;
    public static final int PHY_UNUSED = 0;
    public static final int SID_NOT_PRESENT = 255;
    public static final int TX_POWER_NOT_PRESENT = 127;
    private final int advertisingSid;
    private final BluetoothDevice device;
    private final int eventType;
    private final int periodicAdvertisingInterval;
    private final int primaryPhy;
    private final int rssi;
    private j scanRecord;
    private final int secondaryPhy;
    private final long timestampNanos;
    private final int txPower;

    public ScanResult(BluetoothDevice bluetoothDevice, int i3, int i10, int i11, int i12, int i13, int i14, int i15, j jVar, long j4) {
        this.device = bluetoothDevice;
        this.eventType = i3;
        this.primaryPhy = i10;
        this.secondaryPhy = i11;
        this.advertisingSid = i12;
        this.txPower = i13;
        this.rssi = i14;
        this.periodicAdvertisingInterval = i15;
        this.scanRecord = jVar;
        this.timestampNanos = j4;
    }

    public final BluetoothDevice a() {
        return this.device;
    }

    public final int b() {
        return this.rssi;
    }

    public final j d() {
        return this.scanRecord;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ScanResult.class == obj.getClass()) {
            ScanResult scanResult = (ScanResult) obj;
            if (d0.b(this.device, scanResult.device) && this.rssi == scanResult.rssi && d0.b(this.scanRecord, scanResult.scanRecord) && this.timestampNanos == scanResult.timestampNanos && this.eventType == scanResult.eventType && this.primaryPhy == scanResult.primaryPhy && this.secondaryPhy == scanResult.secondaryPhy && this.advertisingSid == scanResult.advertisingSid && this.txPower == scanResult.txPower && this.periodicAdvertisingInterval == scanResult.periodicAdvertisingInterval) {
                return true;
            }
        }
        return false;
    }

    public final long h() {
        return this.timestampNanos;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.device, Integer.valueOf(this.rssi), this.scanRecord, Long.valueOf(this.timestampNanos), Integer.valueOf(this.eventType), Integer.valueOf(this.primaryPhy), Integer.valueOf(this.secondaryPhy), Integer.valueOf(this.advertisingSid), Integer.valueOf(this.txPower), Integer.valueOf(this.periodicAdvertisingInterval)});
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ScanResult{device=");
        sb2.append(this.device);
        sb2.append(", scanRecord=");
        j jVar = this.scanRecord;
        sb2.append(jVar == null ? "null" : jVar.toString());
        sb2.append(", rssi=");
        sb2.append(this.rssi);
        sb2.append(", timestampNanos=");
        sb2.append(this.timestampNanos);
        sb2.append(", eventType=");
        sb2.append(this.eventType);
        sb2.append(", primaryPhy=");
        sb2.append(this.primaryPhy);
        sb2.append(", secondaryPhy=");
        sb2.append(this.secondaryPhy);
        sb2.append(", advertisingSid=");
        sb2.append(this.advertisingSid);
        sb2.append(", txPower=");
        sb2.append(this.txPower);
        sb2.append(", periodicAdvertisingInterval=");
        return e.m(sb2, this.periodicAdvertisingInterval, '}');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        this.device.writeToParcel(parcel, i3);
        if (this.scanRecord != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(this.scanRecord.f18555g);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.rssi);
        parcel.writeLong(this.timestampNanos);
        parcel.writeInt(this.eventType);
        parcel.writeInt(this.primaryPhy);
        parcel.writeInt(this.secondaryPhy);
        parcel.writeInt(this.advertisingSid);
        parcel.writeInt(this.txPower);
        parcel.writeInt(this.periodicAdvertisingInterval);
    }

    public ScanResult(Parcel parcel) {
        this.device = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
        if (parcel.readInt() == 1) {
            this.scanRecord = j.a(parcel.createByteArray());
        }
        this.rssi = parcel.readInt();
        this.timestampNanos = parcel.readLong();
        this.eventType = parcel.readInt();
        this.primaryPhy = parcel.readInt();
        this.secondaryPhy = parcel.readInt();
        this.advertisingSid = parcel.readInt();
        this.txPower = parcel.readInt();
        this.periodicAdvertisingInterval = parcel.readInt();
    }
}
