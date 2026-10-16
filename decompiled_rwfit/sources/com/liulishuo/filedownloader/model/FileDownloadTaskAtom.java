package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import u8.b;

/* loaded from: classes2.dex */
public class FileDownloadTaskAtom implements Parcelable {
    public static final Parcelable.Creator<FileDownloadTaskAtom> CREATOR = new b(8);

    /* renamed from: id, reason: collision with root package name */
    private int f11468id;
    private String path;
    private long totalBytes;
    private String url;

    public FileDownloadTaskAtom(Parcel parcel) {
        this.url = parcel.readString();
        this.path = parcel.readString();
        this.totalBytes = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeLong(this.totalBytes);
    }
}
