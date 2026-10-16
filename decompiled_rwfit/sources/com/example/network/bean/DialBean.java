package com.example.network.bean;

import android.os.Parcel;
import android.os.Parcelable;
import r5.a;

/* loaded from: classes.dex */
public class DialBean implements Parcelable {
    public static final Parcelable.Creator<DialBean> CREATOR = new Parcelable.Creator<DialBean>() { // from class: com.example.network.bean.DialBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialBean createFromParcel(Parcel parcel) {
            return new DialBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialBean[] newArray(int i3) {
            return new DialBean[i3];
        }
    };
    private String checkValue;
    private String classify;
    private String description;
    private String downloadUrl;
    private int free;

    /* renamed from: id, reason: collision with root package name */
    private int f7395id;
    private int index;
    private String name;
    private String previewUrl;
    private long size;
    private String thumbnailUrl;
    private int useCount;

    public DialBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCheckValue() {
        return this.checkValue;
    }

    public String getClassify() {
        return this.classify;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getFree() {
        return this.free;
    }

    public int getId() {
        return this.f7395id;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public long getSize() {
        return this.size;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public int getUseCount() {
        return this.useCount;
    }

    public void setCheckValue(String str) {
        this.checkValue = str;
    }

    public void setClassify(String str) {
        this.classify = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setFree(int i3) {
        this.free = i3;
    }

    public void setId(int i3) {
        this.f7395id = i3;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPreviewUrl(String str) {
        this.previewUrl = str;
    }

    public void setSize(long j4) {
        this.size = j4;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void setUseCount(int i3) {
        this.useCount = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DialBean{id=");
        sb2.append(this.f7395id);
        sb2.append(", classify='");
        sb2.append(this.classify);
        sb2.append("', name='");
        sb2.append(this.name);
        sb2.append("', description='");
        sb2.append(this.description);
        sb2.append("', downloadUrl='");
        sb2.append(this.downloadUrl);
        sb2.append("', previewUrl='");
        sb2.append(this.previewUrl);
        sb2.append("', size=");
        sb2.append(this.size);
        sb2.append(", checkValue='");
        sb2.append(this.checkValue);
        sb2.append("', index=");
        sb2.append(this.index);
        sb2.append(", free=");
        sb2.append(this.free);
        sb2.append(", useCount=");
        sb2.append(this.useCount);
        sb2.append(", thumbnailUrl='");
        return a.f(sb2, this.thumbnailUrl, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f7395id);
        parcel.writeString(this.classify);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.previewUrl);
        parcel.writeLong(this.size);
        parcel.writeString(this.checkValue);
        parcel.writeInt(this.index);
        parcel.writeInt(this.free);
        parcel.writeInt(this.useCount);
        parcel.writeString(this.thumbnailUrl);
    }

    public DialBean(Parcel parcel) {
        this.f7395id = parcel.readInt();
        this.classify = parcel.readString();
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.previewUrl = parcel.readString();
        this.size = parcel.readLong();
        this.checkValue = parcel.readString();
        this.index = parcel.readInt();
        this.free = parcel.readInt();
        this.useCount = parcel.readInt();
        this.thumbnailUrl = parcel.readString();
    }
}
