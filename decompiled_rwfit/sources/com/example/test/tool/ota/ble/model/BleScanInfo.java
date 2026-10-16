package com.example.test.tool.ota.ble.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import ee.b;
import ha.d;

/* loaded from: classes.dex */
public class BleScanInfo implements Parcelable {
    public static final Parcelable.Creator<BleScanInfo> CREATOR = new d(9);
    private boolean isEnableConnect;
    private byte[] rawData;
    private int rssi;

    public BleScanInfo() {
        this.isEnableConnect = true;
    }

    public final void a(boolean z5) {
        this.isEnableConnect = z5;
    }

    public final void b(byte[] bArr) {
        this.rawData = bArr;
    }

    public final void d(int i3) {
        this.rssi = i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BleScanMessage{rawData=");
        sb2.append(b.c(this.rawData));
        sb2.append(", rssi=");
        sb2.append(this.rssi);
        sb2.append(", isEnableConnect=");
        return e.o(sb2, this.isEnableConnect, '}');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByteArray(this.rawData);
        parcel.writeInt(this.rssi);
        parcel.writeByte(this.isEnableConnect ? (byte) 1 : (byte) 0);
    }

    public BleScanInfo(Parcel parcel) {
        this.isEnableConnect = true;
        this.rawData = parcel.createByteArray();
        this.rssi = parcel.readInt();
        this.isEnableConnect = parcel.readByte() != 0;
    }
}
