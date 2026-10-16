package com.example.blesdk.bean.function;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class DialInfoBean implements Parcelable {
    public static final Parcelable.Creator<DialInfoBean> CREATOR = new Parcelable.Creator<DialInfoBean>() { // from class: com.example.blesdk.bean.function.DialInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialInfoBean createFromParcel(Parcel parcel) {
            return new DialInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialInfoBean[] newArray(int i3) {
            return new DialInfoBean[i3];
        }
    };
    private int dialType;
    private int height;
    private int width;

    public DialInfoBean() {
        this.dialType = 0;
        this.width = 460;
        this.height = 460;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDialType() {
        return this.dialType;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDialType(int i3) {
        this.dialType = i3;
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public void setWidth(int i3) {
        this.width = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DialInfoBean{dialType=");
        sb2.append(this.dialType);
        sb2.append(", width=");
        sb2.append(this.width);
        sb2.append(", height=");
        return e.m(sb2, this.height, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.dialType);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public DialInfoBean(Parcel parcel) {
        this.dialType = 0;
        this.width = 460;
        this.height = 460;
        this.dialType = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
