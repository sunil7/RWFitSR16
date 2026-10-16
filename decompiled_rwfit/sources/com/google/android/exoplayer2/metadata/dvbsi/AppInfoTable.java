package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import ha.d;
import r5.a;

/* loaded from: classes.dex */
public final class AppInfoTable implements Metadata.Entry {
    public static final int CONTROL_CODE_AUTOSTART = 1;
    public static final int CONTROL_CODE_PRESENT = 2;
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new d(17);
    public final int controlCode;
    public final String url;

    public AppInfoTable(int i3, String str) {
        this.controlCode = i3;
        this.url = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        int i3 = this.controlCode;
        String str = this.url;
        StringBuilder sb2 = new StringBuilder(a.a(33, str));
        sb2.append("Ait(controlCode=");
        sb2.append(i3);
        sb2.append(",url=");
        sb2.append(str);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.url);
        parcel.writeInt(this.controlCode);
    }
}
