package com.dh.imagepick.crop.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.g;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ImageItem implements Serializable, Parcelable {
    public static final Parcelable.Creator<ImageItem> CREATOR = new g(23);
    public long addTime;
    public int height;
    public String mimeType;
    public String name;
    public String path;
    public long size;
    public int width;

    public ImageItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageItem)) {
            return super.equals(obj);
        }
        ImageItem imageItem = (ImageItem) obj;
        return this.path.equalsIgnoreCase(imageItem.path) && this.addTime == imageItem.addTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.name);
        parcel.writeString(this.path);
        parcel.writeLong(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.mimeType);
        parcel.writeLong(this.addTime);
    }

    public ImageItem(Parcel parcel) {
        this.name = parcel.readString();
        this.path = parcel.readString();
        this.size = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.mimeType = parcel.readString();
        this.addTime = parcel.readLong();
    }
}
