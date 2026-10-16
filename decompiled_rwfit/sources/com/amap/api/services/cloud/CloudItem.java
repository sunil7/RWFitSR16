package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5900a;

    /* renamed from: b, reason: collision with root package name */
    private int f5901b;

    /* renamed from: c, reason: collision with root package name */
    private String f5902c;

    /* renamed from: d, reason: collision with root package name */
    private String f5903d;
    private HashMap<String, String> e;

    /* renamed from: f, reason: collision with root package name */
    private List<CloudImage> f5904f;
    protected final LatLonPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;

    public static class a implements Parcelable.Creator<CloudItem> {
        @Override // android.os.Parcelable.Creator
        public CloudItem createFromParcel(Parcel parcel) {
            return new CloudItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CloudItem[] newArray(int i3) {
            return new CloudItem[i3];
        }
    }

    public CloudItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f5901b = -1;
        this.f5900a = str;
        this.mPoint = latLonPoint;
        this.mTitle = str2;
        this.mSnippet = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CloudItem)) {
            return false;
        }
        CloudItem cloudItem = (CloudItem) obj;
        String str = this.f5900a;
        if (str == null) {
            if (cloudItem.f5900a != null) {
                return false;
            }
        } else if (!str.equals(cloudItem.f5900a)) {
            return false;
        }
        return true;
    }

    public List<CloudImage> getCloudImage() {
        return this.f5904f;
    }

    public String getCreatetime() {
        return this.f5902c;
    }

    public HashMap<String, String> getCustomfield() {
        return this.e;
    }

    public int getDistance() {
        return this.f5901b;
    }

    public String getID() {
        return this.f5900a;
    }

    public LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUpdatetime() {
        return this.f5903d;
    }

    public int hashCode() {
        String str = this.f5900a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setCreatetime(String str) {
        this.f5902c = str;
    }

    public void setCustomfield(HashMap<String, String> hashMap) {
        this.e = hashMap;
    }

    public void setDistance(int i3) {
        this.f5901b = i3;
    }

    public void setUpdatetime(String str) {
        this.f5903d = str;
    }

    public void setmCloudImage(List<CloudImage> list) {
        this.f5904f = list;
    }

    public String toString() {
        return this.mTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5900a);
        parcel.writeInt(this.f5901b);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.f5902c);
        parcel.writeString(this.f5903d);
        parcel.writeMap(this.e);
        parcel.writeList(this.f5904f);
    }

    public CloudItem(Parcel parcel) {
        this.f5901b = -1;
        this.f5900a = parcel.readString();
        this.f5901b = parcel.readInt();
        this.mPoint = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.f5902c = parcel.readString();
        this.f5903d = parcel.readString();
        HashMap<String, String> hashMap = new HashMap<>();
        this.e = hashMap;
        parcel.readMap(hashMap, HashMap.class.getClassLoader());
        List arrayList = new ArrayList();
        this.f5904f = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
    }
}
