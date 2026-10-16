package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import ha.d;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new d(8);
    private int ashmemFD;
    private int ashmemMetaFD;
    private String cryptKey;
    private final String mmapID;

    public ParcelableMMKV(MMKV mmkv) {
        this.ashmemFD = -1;
        this.ashmemMetaFD = -1;
        this.cryptKey = null;
        this.mmapID = mmkv.mmapID();
        this.ashmemFD = mmkv.ashmemFD();
        this.ashmemMetaFD = mmkv.ashmemMetaFD();
        this.cryptKey = mmkv.cryptKey();
    }

    public final MMKV a() {
        int i3;
        int i10 = this.ashmemFD;
        if (i10 < 0 || (i3 = this.ashmemMetaFD) < 0) {
            return null;
        }
        return MMKV.q(i10, i3, this.mmapID, this.cryptKey);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeString(this.mmapID);
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.ashmemFD);
            ParcelFileDescriptor fromFd2 = ParcelFileDescriptor.fromFd(this.ashmemMetaFD);
            int i10 = i3 | 1;
            fromFd.writeToParcel(parcel, i10);
            fromFd2.writeToParcel(parcel, i10);
            String str = this.cryptKey;
            if (str != null) {
                parcel.writeString(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ParcelableMMKV(int i3, int i10, String str, String str2) {
        this.mmapID = str;
        this.ashmemFD = i3;
        this.ashmemMetaFD = i10;
        this.cryptKey = str2;
    }
}
