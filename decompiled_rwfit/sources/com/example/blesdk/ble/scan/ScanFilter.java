package com.example.blesdk.ble.scan;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.internal.mlkit_vision_common.d0;
import java.util.Arrays;
import q9.o;

/* loaded from: classes.dex */
public final class ScanFilter implements Parcelable {
    private final String deviceAddress;
    private final String deviceName;
    private final byte[] manufacturerData;
    private final byte[] manufacturerDataMask;
    private final int manufacturerId;
    private final byte[] serviceData;
    private final byte[] serviceDataMask;
    private final ParcelUuid serviceDataUuid;
    private final ParcelUuid serviceUuid;
    private final ParcelUuid serviceUuidMask;
    private static final ScanFilter EMPTY = new ScanFilter(null, null, null, null, null, null, null, -1, null, null);
    public static final Parcelable.Creator<ScanFilter> CREATOR = new o(18);

    public ScanFilter(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i3, byte[] bArr3, byte[] bArr4) {
        this.deviceName = str;
        this.serviceUuid = parcelUuid;
        this.serviceUuidMask = parcelUuid2;
        this.deviceAddress = str2;
        this.serviceDataUuid = parcelUuid3;
        this.serviceData = bArr;
        this.serviceDataMask = bArr2;
        this.manufacturerId = i3;
        this.manufacturerData = bArr3;
        this.manufacturerDataMask = bArr4;
    }

    public static boolean p(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            if (bArr3 != null) {
                return true;
            }
        } else if (bArr3 != null && bArr3.length >= bArr.length) {
            if (bArr2 == null) {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr3[i3] == bArr[i3]) {
                    }
                }
                return true;
            }
            for (int i10 = 0; i10 < bArr.length; i10++) {
                byte b3 = bArr2[i10];
                if ((bArr3[i10] & b3) == (b3 & bArr[i10])) {
                }
            }
            return true;
        }
        return false;
    }

    public final String a() {
        return this.deviceAddress;
    }

    public final String b() {
        return this.deviceName;
    }

    public final byte[] d() {
        return this.manufacturerData;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ScanFilter.class == obj.getClass()) {
            ScanFilter scanFilter = (ScanFilter) obj;
            if (d0.b(this.deviceName, scanFilter.deviceName) && d0.b(this.deviceAddress, scanFilter.deviceAddress) && this.manufacturerId == scanFilter.manufacturerId && d0.a(this.manufacturerData, scanFilter.manufacturerData) && d0.a(this.manufacturerDataMask, scanFilter.manufacturerDataMask) && d0.b(this.serviceDataUuid, scanFilter.serviceDataUuid) && d0.a(this.serviceData, scanFilter.serviceData) && d0.a(this.serviceDataMask, scanFilter.serviceDataMask) && d0.b(this.serviceUuid, scanFilter.serviceUuid) && d0.b(this.serviceUuidMask, scanFilter.serviceUuidMask)) {
                return true;
            }
        }
        return false;
    }

    public final byte[] h() {
        return this.manufacturerDataMask;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.deviceName, this.deviceAddress, Integer.valueOf(this.manufacturerId), Integer.valueOf(Arrays.hashCode(this.manufacturerData)), Integer.valueOf(Arrays.hashCode(this.manufacturerDataMask)), this.serviceDataUuid, Integer.valueOf(Arrays.hashCode(this.serviceData)), Integer.valueOf(Arrays.hashCode(this.serviceDataMask)), this.serviceUuid, this.serviceUuidMask});
    }

    public final int i() {
        return this.manufacturerId;
    }

    public final byte[] j() {
        return this.serviceData;
    }

    public final byte[] k() {
        return this.serviceDataMask;
    }

    public final ParcelUuid l() {
        return this.serviceDataUuid;
    }

    public final ParcelUuid m() {
        return this.serviceUuid;
    }

    public final ParcelUuid n() {
        return this.serviceUuidMask;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a8, code lost:
    
        if (r3 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c5, code lost:
    
        if (p(r6, r7, r8 == null ? null : (byte[]) r8.get(r3)) == false) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(com.example.blesdk.ble.scan.ScanResult r20) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.blesdk.ble.scan.ScanFilter.o(com.example.blesdk.ble.scan.ScanResult):boolean");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BluetoothLeScanFilter [deviceName=");
        sb2.append(this.deviceName);
        sb2.append(", deviceAddress=");
        sb2.append(this.deviceAddress);
        sb2.append(", mUuid=");
        sb2.append(this.serviceUuid);
        sb2.append(", uuidMask=");
        sb2.append(this.serviceUuidMask);
        sb2.append(", serviceDataUuid=");
        ParcelUuid parcelUuid = this.serviceDataUuid;
        sb2.append(parcelUuid == null ? "null" : parcelUuid.toString());
        sb2.append(", serviceData=");
        sb2.append(Arrays.toString(this.serviceData));
        sb2.append(", serviceDataMask=");
        sb2.append(Arrays.toString(this.serviceDataMask));
        sb2.append(", manufacturerId=");
        sb2.append(this.manufacturerId);
        sb2.append(", manufacturerData=");
        sb2.append(Arrays.toString(this.manufacturerData));
        sb2.append(", manufacturerDataMask=");
        sb2.append(Arrays.toString(this.manufacturerDataMask));
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.deviceName == null ? 0 : 1);
        String str = this.deviceName;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.deviceAddress == null ? 0 : 1);
        String str2 = this.deviceAddress;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeInt(this.serviceUuid == null ? 0 : 1);
        ParcelUuid parcelUuid = this.serviceUuid;
        if (parcelUuid != null) {
            parcel.writeParcelable(parcelUuid, i3);
            parcel.writeInt(this.serviceUuidMask == null ? 0 : 1);
            ParcelUuid parcelUuid2 = this.serviceUuidMask;
            if (parcelUuid2 != null) {
                parcel.writeParcelable(parcelUuid2, i3);
            }
        }
        parcel.writeInt(this.serviceDataUuid == null ? 0 : 1);
        ParcelUuid parcelUuid3 = this.serviceDataUuid;
        if (parcelUuid3 != null) {
            parcel.writeParcelable(parcelUuid3, i3);
            parcel.writeInt(this.serviceData == null ? 0 : 1);
            byte[] bArr = this.serviceData;
            if (bArr != null) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.serviceData);
                parcel.writeInt(this.serviceDataMask == null ? 0 : 1);
                byte[] bArr2 = this.serviceDataMask;
                if (bArr2 != null) {
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(this.serviceDataMask);
                }
            }
        }
        parcel.writeInt(this.manufacturerId);
        parcel.writeInt(this.manufacturerData == null ? 0 : 1);
        byte[] bArr3 = this.manufacturerData;
        if (bArr3 != null) {
            parcel.writeInt(bArr3.length);
            parcel.writeByteArray(this.manufacturerData);
            parcel.writeInt(this.manufacturerDataMask == null ? 0 : 1);
            byte[] bArr4 = this.manufacturerDataMask;
            if (bArr4 != null) {
                parcel.writeInt(bArr4.length);
                parcel.writeByteArray(this.manufacturerDataMask);
            }
        }
    }
}
