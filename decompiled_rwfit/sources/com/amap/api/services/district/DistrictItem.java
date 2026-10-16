package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5982a;

    /* renamed from: b, reason: collision with root package name */
    private String f5983b;

    /* renamed from: c, reason: collision with root package name */
    private String f5984c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f5985d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private List<DistrictItem> f5986f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f5987g;

    public static class a implements Parcelable.Creator<DistrictItem> {
        @Override // android.os.Parcelable.Creator
        public DistrictItem createFromParcel(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DistrictItem[] newArray(int i3) {
            return new DistrictItem[i3];
        }
    }

    public DistrictItem() {
        this.f5986f = new ArrayList();
        this.f5987g = new String[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[] districtBoundary() {
        return this.f5987g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictItem.class != obj.getClass()) {
            return false;
        }
        DistrictItem districtItem = (DistrictItem) obj;
        String str = this.f5983b;
        if (str == null) {
            if (districtItem.f5983b != null) {
                return false;
            }
        } else if (!str.equals(districtItem.f5983b)) {
            return false;
        }
        LatLonPoint latLonPoint = this.f5985d;
        if (latLonPoint == null) {
            if (districtItem.f5985d != null) {
                return false;
            }
        } else if (!latLonPoint.equals(districtItem.f5985d)) {
            return false;
        }
        String str2 = this.f5982a;
        if (str2 == null) {
            if (districtItem.f5982a != null) {
                return false;
            }
        } else if (!str2.equals(districtItem.f5982a)) {
            return false;
        }
        if (!Arrays.equals(this.f5987g, districtItem.f5987g)) {
            return false;
        }
        List<DistrictItem> list = this.f5986f;
        if (list == null) {
            if (districtItem.f5986f != null) {
                return false;
            }
        } else if (!list.equals(districtItem.f5986f)) {
            return false;
        }
        String str3 = this.e;
        if (str3 == null) {
            if (districtItem.e != null) {
                return false;
            }
        } else if (!str3.equals(districtItem.e)) {
            return false;
        }
        String str4 = this.f5984c;
        if (str4 == null) {
            if (districtItem.f5984c != null) {
                return false;
            }
        } else if (!str4.equals(districtItem.f5984c)) {
            return false;
        }
        return true;
    }

    public String getAdcode() {
        return this.f5983b;
    }

    public LatLonPoint getCenter() {
        return this.f5985d;
    }

    public String getCitycode() {
        return this.f5982a;
    }

    public String getLevel() {
        return this.e;
    }

    public String getName() {
        return this.f5984c;
    }

    public List<DistrictItem> getSubDistrict() {
        return this.f5986f;
    }

    public int hashCode() {
        String str = this.f5983b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f5985d;
        int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        String str2 = this.f5982a;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Arrays.hashCode(this.f5987g)) * 31;
        List<DistrictItem> list = this.f5986f;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f5984c;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public void setAdcode(String str) {
        this.f5983b = str;
    }

    public void setCenter(LatLonPoint latLonPoint) {
        this.f5985d = latLonPoint;
    }

    public void setCitycode(String str) {
        this.f5982a = str;
    }

    public void setDistrictBoundary(String[] strArr) {
        this.f5987g = strArr;
    }

    public void setLevel(String str) {
        this.e = str;
    }

    public void setName(String str) {
        this.f5984c = str;
    }

    public void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f5986f = arrayList;
    }

    public String toString() {
        return "DistrictItem [mCitycode=" + this.f5982a + ", mAdcode=" + this.f5983b + ", mName=" + this.f5984c + ", mCenter=" + this.f5985d + ", mLevel=" + this.e + ", mDistricts=" + this.f5986f + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5982a);
        parcel.writeString(this.f5983b);
        parcel.writeString(this.f5984c);
        parcel.writeParcelable(this.f5985d, i3);
        parcel.writeString(this.e);
        parcel.writeTypedList(this.f5986f);
        parcel.writeInt(this.f5987g.length);
        parcel.writeStringArray(this.f5987g);
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f5986f = new ArrayList();
        this.f5987g = new String[0];
        this.f5984c = str;
        this.f5982a = str2;
        this.f5983b = str3;
        this.f5985d = latLonPoint;
        this.e = str4;
    }

    public DistrictItem(Parcel parcel) {
        this.f5986f = new ArrayList();
        this.f5987g = new String[0];
        this.f5982a = parcel.readString();
        this.f5983b = parcel.readString();
        this.f5984c = parcel.readString();
        this.f5985d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.e = parcel.readString();
        this.f5986f = parcel.createTypedArrayList(CREATOR);
        int readInt = parcel.readInt();
        if (readInt <= 0 || readInt > 52428800) {
            return;
        }
        String[] strArr = new String[readInt];
        this.f5987g = strArr;
        parcel.readStringArray(strArr);
    }
}
