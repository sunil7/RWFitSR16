package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.d6;

/* loaded from: classes.dex */
public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new a();
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";

    /* renamed from: a, reason: collision with root package name */
    private int f5993a;

    /* renamed from: b, reason: collision with root package name */
    private int f5994b;

    /* renamed from: c, reason: collision with root package name */
    private String f5995c;

    /* renamed from: d, reason: collision with root package name */
    private String f5996d;
    private boolean e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5997f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5998g;

    /* renamed from: h, reason: collision with root package name */
    private int f5999h;

    public static class a implements Parcelable.Creator<DistrictSearchQuery> {
        @Override // android.os.Parcelable.Creator
        public DistrictSearchQuery createFromParcel(Parcel parcel) {
            DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
            districtSearchQuery.setKeywords(parcel.readString());
            districtSearchQuery.setKeywordsLevel(parcel.readString());
            districtSearchQuery.setPageNum(parcel.readInt());
            districtSearchQuery.setPageSize(parcel.readInt());
            districtSearchQuery.setShowChild(parcel.readByte() == 1);
            districtSearchQuery.setShowBoundary(parcel.readByte() == 1);
            districtSearchQuery.setShowBusinessArea(parcel.readByte() == 1);
            districtSearchQuery.setSubDistrict(parcel.readInt());
            return districtSearchQuery;
        }

        @Override // android.os.Parcelable.Creator
        public DistrictSearchQuery[] newArray(int i3) {
            return new DistrictSearchQuery[i3];
        }
    }

    public DistrictSearchQuery() {
        this.f5993a = 1;
        this.f5994b = 20;
        this.e = true;
        this.f5997f = false;
        this.f5998g = false;
        this.f5999h = 1;
    }

    public boolean checkKeyWords() {
        String str = this.f5995c;
        return (str == null || str.trim().equalsIgnoreCase("")) ? false : true;
    }

    public boolean checkLevels() {
        String str = this.f5996d;
        if (str == null) {
            return false;
        }
        return str.trim().equals("country") || this.f5996d.trim().equals("province") || this.f5996d.trim().equals("city") || this.f5996d.trim().equals("district") || this.f5996d.trim().equals(KEYWORDS_BUSINESS);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
        if (this.f5998g != districtSearchQuery.f5998g) {
            return false;
        }
        String str = this.f5995c;
        if (str == null) {
            if (districtSearchQuery.f5995c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f5995c)) {
            return false;
        }
        return this.f5993a == districtSearchQuery.f5993a && this.f5994b == districtSearchQuery.f5994b && this.e == districtSearchQuery.e && this.f5999h == districtSearchQuery.f5999h;
    }

    public String getKeywords() {
        return this.f5995c;
    }

    public String getKeywordsLevel() {
        return this.f5996d;
    }

    public int getPageNum() {
        int i3 = this.f5993a;
        if (i3 < 1) {
            return 1;
        }
        return i3;
    }

    public int getPageSize() {
        return this.f5994b;
    }

    public int getSubDistrict() {
        return this.f5999h;
    }

    public int hashCode() {
        int i3 = ((this.f5998g ? 1231 : 1237) + 31) * 31;
        String str = this.f5995c;
        int hashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f5996d;
        return ((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f5993a) * 31) + this.f5994b) * 31) + (this.e ? 1231 : 1237)) * 31) + this.f5999h;
    }

    public boolean isShowBoundary() {
        return this.f5998g;
    }

    public boolean isShowBusinessArea() {
        return this.f5997f;
    }

    public boolean isShowChild() {
        return this.e;
    }

    public void setKeywords(String str) {
        this.f5995c = str;
    }

    public void setKeywordsLevel(String str) {
        this.f5996d = str;
    }

    public void setPageNum(int i3) {
        this.f5993a = i3;
    }

    public void setPageSize(int i3) {
        this.f5994b = i3;
    }

    public void setShowBoundary(boolean z5) {
        this.f5998g = z5;
    }

    public void setShowBusinessArea(boolean z5) {
        this.f5997f = z5;
    }

    public void setShowChild(boolean z5) {
        this.e = z5;
    }

    public void setSubDistrict(int i3) {
        this.f5999h = i3;
    }

    public boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        String str = this.f5995c;
        if (str == null) {
            if (districtSearchQuery.f5995c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f5995c)) {
            return false;
        }
        return this.f5994b == districtSearchQuery.f5994b && this.e == districtSearchQuery.e && this.f5998g == districtSearchQuery.f5998g && this.f5999h == districtSearchQuery.f5999h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5995c);
        parcel.writeString(this.f5996d);
        parcel.writeInt(this.f5993a);
        parcel.writeInt(this.f5994b);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5998g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5997f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f5999h);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DistrictSearchQuery m22clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            d6.a(e, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(this.f5995c);
        districtSearchQuery.setKeywordsLevel(this.f5996d);
        districtSearchQuery.setPageNum(this.f5993a);
        districtSearchQuery.setPageSize(this.f5994b);
        districtSearchQuery.setShowChild(this.e);
        districtSearchQuery.setSubDistrict(this.f5999h);
        districtSearchQuery.setShowBoundary(this.f5998g);
        districtSearchQuery.setShowBusinessArea(this.f5997f);
        return districtSearchQuery;
    }

    public DistrictSearchQuery(String str, String str2, int i3) {
        this.f5994b = 20;
        this.e = true;
        this.f5997f = false;
        this.f5998g = false;
        this.f5999h = 1;
        this.f5995c = str;
        this.f5996d = str2;
        this.f5993a = i3;
    }

    public DistrictSearchQuery(String str, String str2, int i3, boolean z5, int i10) {
        this(str, str2, i3);
        this.e = z5;
        this.f5994b = i10;
    }
}
