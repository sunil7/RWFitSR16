package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.List;
import u8.b;

/* loaded from: classes2.dex */
public class FileDownloadHeader implements Parcelable {
    public static final Parcelable.Creator<FileDownloadHeader> CREATOR = new b(6);
    private HashMap<String, List<String>> mHeaderMap;

    public FileDownloadHeader(Parcel parcel) {
        this.mHeaderMap = parcel.readHashMap(String.class.getClassLoader());
    }

    public final HashMap a() {
        return this.mHeaderMap;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.mHeaderMap.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeMap(this.mHeaderMap);
    }
}
