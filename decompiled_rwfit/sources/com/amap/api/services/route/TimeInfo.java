package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TimeInfo implements Parcelable {
    public static final Parcelable.Creator<TimeInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private long f6459a;

    /* renamed from: b, reason: collision with root package name */
    private List<TimeInfosElement> f6460b;

    public static class a implements Parcelable.Creator<TimeInfo> {
        @Override // android.os.Parcelable.Creator
        public TimeInfo createFromParcel(Parcel parcel) {
            return new TimeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimeInfo[] newArray(int i3) {
            return null;
        }
    }

    public TimeInfo(Parcel parcel) {
        this.f6460b = new ArrayList();
        this.f6459a = parcel.readInt();
        this.f6460b = parcel.createTypedArrayList(TimeInfosElement.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TimeInfosElement> getElements() {
        return this.f6460b;
    }

    public long getStartTime() {
        return this.f6459a;
    }

    public void setElements(List<TimeInfosElement> list) {
        this.f6460b = list;
    }

    public void setStartTime(long j4) {
        this.f6459a = j4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f6459a);
        parcel.writeTypedList(this.f6460b);
    }

    public TimeInfo() {
        this.f6460b = new ArrayList();
    }
}
