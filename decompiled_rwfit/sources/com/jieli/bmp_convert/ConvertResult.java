package com.jieli.bmp_convert;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class ConvertResult implements Parcelable {
    public static final Parcelable.Creator<ConvertResult> CREATOR = new Parcelable.Creator<ConvertResult>() { // from class: com.jieli.bmp_convert.ConvertResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConvertResult createFromParcel(Parcel parcel) {
            return new ConvertResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConvertResult[] newArray(int i3) {
            return new ConvertResult[i3];
        }
    };
    private int algorithm;
    private int bufSize;
    private int compressMode;
    private int pixelFormat;
    private int result;

    public ConvertResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAlgorithm() {
        return this.algorithm;
    }

    public int getBufSize() {
        return this.bufSize;
    }

    public int getCompressMode() {
        return this.compressMode;
    }

    public int getPixelFormat() {
        return this.pixelFormat;
    }

    public int getResult() {
        return this.result;
    }

    public boolean isConvertSuccess() {
        return this.result > 0;
    }

    public ConvertResult setAlgorithm(int i3) {
        this.algorithm = i3;
        return this;
    }

    public ConvertResult setBufSize(int i3) {
        this.bufSize = i3;
        return this;
    }

    public ConvertResult setCompressMode(int i3) {
        this.compressMode = i3;
        return this;
    }

    public ConvertResult setPixelFormat(int i3) {
        this.pixelFormat = i3;
        return this;
    }

    public ConvertResult setResult(int i3) {
        this.result = i3;
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ConvertResult{result=");
        sb2.append(this.result);
        sb2.append(", algorithm=");
        sb2.append(this.algorithm);
        sb2.append(", bufSize=");
        sb2.append(this.bufSize);
        sb2.append(", pixelFormat=");
        sb2.append(this.pixelFormat);
        sb2.append(", compressMode=");
        return e.m(sb2, this.compressMode, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.result);
        parcel.writeInt(this.algorithm);
        parcel.writeInt(this.bufSize);
        parcel.writeInt(this.pixelFormat);
        parcel.writeInt(this.compressMode);
    }

    public ConvertResult(Parcel parcel) {
        this.result = parcel.readInt();
        this.algorithm = parcel.readInt();
        this.bufSize = parcel.readInt();
        this.pixelFormat = parcel.readInt();
        this.compressMode = parcel.readInt();
    }
}
