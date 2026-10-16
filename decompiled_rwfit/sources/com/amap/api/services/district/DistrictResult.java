package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR;

    /* renamed from: a, reason: collision with root package name */
    private DistrictSearchQuery f5988a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<DistrictItem> f5989b;

    /* renamed from: c, reason: collision with root package name */
    private int f5990c;

    /* renamed from: d, reason: collision with root package name */
    private AMapException f5991d;

    public class a implements Parcelable.Creator<DistrictResult> {
        public a(DistrictResult districtResult) {
        }

        @Override // android.os.Parcelable.Creator
        public DistrictResult createFromParcel(Parcel parcel) {
            return new DistrictResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DistrictResult[] newArray(int i3) {
            return new DistrictResult[i3];
        }
    }

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.f5989b = new ArrayList<>();
        this.CREATOR = new a(this);
        this.f5988a = districtSearchQuery;
        this.f5989b = arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictResult.class != obj.getClass()) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) obj;
        DistrictSearchQuery districtSearchQuery = this.f5988a;
        if (districtSearchQuery == null) {
            if (districtResult.f5988a != null) {
                return false;
            }
        } else if (!districtSearchQuery.equals(districtResult.f5988a)) {
            return false;
        }
        ArrayList<DistrictItem> arrayList = this.f5989b;
        if (arrayList == null) {
            if (districtResult.f5989b != null) {
                return false;
            }
        } else if (!arrayList.equals(districtResult.f5989b)) {
            return false;
        }
        return true;
    }

    public AMapException getAMapException() {
        return this.f5991d;
    }

    public ArrayList<DistrictItem> getDistrict() {
        return this.f5989b;
    }

    public int getPageCount() {
        return this.f5990c;
    }

    public DistrictSearchQuery getQuery() {
        return this.f5988a;
    }

    public int hashCode() {
        DistrictSearchQuery districtSearchQuery = this.f5988a;
        int hashCode = ((districtSearchQuery == null ? 0 : districtSearchQuery.hashCode()) + 31) * 31;
        ArrayList<DistrictItem> arrayList = this.f5989b;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public void setAMapException(AMapException aMapException) {
        this.f5991d = aMapException;
    }

    public void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.f5989b = arrayList;
    }

    public void setPageCount(int i3) {
        this.f5990c = i3;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f5988a = districtSearchQuery;
    }

    public String toString() {
        return "DistrictResult [mDisQuery=" + this.f5988a + ", mDistricts=" + this.f5989b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f5988a, i3);
        parcel.writeTypedList(this.f5989b);
    }

    public DistrictResult() {
        this.f5989b = new ArrayList<>();
        this.CREATOR = new a(this);
    }

    public DistrictResult(Parcel parcel) {
        this.f5989b = new ArrayList<>();
        this.CREATOR = new a(this);
        this.f5988a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f5989b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }
}
