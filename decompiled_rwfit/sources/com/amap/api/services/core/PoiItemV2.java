package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItemV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<PoiItemV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5958a;

    /* renamed from: b, reason: collision with root package name */
    private String f5959b;

    /* renamed from: c, reason: collision with root package name */
    private String f5960c;

    /* renamed from: d, reason: collision with root package name */
    private String f5961d;
    private final LatLonPoint e;

    /* renamed from: f, reason: collision with root package name */
    private final String f5962f;

    /* renamed from: g, reason: collision with root package name */
    private final String f5963g;

    /* renamed from: h, reason: collision with root package name */
    private String f5964h;

    /* renamed from: i, reason: collision with root package name */
    private String f5965i;

    /* renamed from: j, reason: collision with root package name */
    private String f5966j;

    /* renamed from: k, reason: collision with root package name */
    private String f5967k;

    /* renamed from: l, reason: collision with root package name */
    private String f5968l;

    /* renamed from: m, reason: collision with root package name */
    private List<SubPoiItemV2> f5969m;

    /* renamed from: n, reason: collision with root package name */
    private Business f5970n;

    /* renamed from: o, reason: collision with root package name */
    private IndoorDataV2 f5971o;

    /* renamed from: p, reason: collision with root package name */
    private PoiNavi f5972p;

    /* renamed from: q, reason: collision with root package name */
    private List<Photo> f5973q;

    public static class a implements Parcelable.Creator<PoiItemV2> {
        @Override // android.os.Parcelable.Creator
        public PoiItemV2 createFromParcel(Parcel parcel) {
            return new PoiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PoiItemV2[] newArray(int i3) {
            return new PoiItemV2[i3];
        }
    }

    public PoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f5961d = "";
        this.f5969m = new ArrayList();
        this.f5973q = new ArrayList();
        this.f5958a = str;
        this.e = latLonPoint;
        this.f5962f = str2;
        this.f5963g = str3;
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
        PoiItemV2 poiItemV2 = (PoiItemV2) obj;
        String str = this.f5958a;
        if (str == null) {
            if (poiItemV2.f5958a != null) {
                return false;
            }
        } else if (!str.equals(poiItemV2.f5958a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.f5959b;
    }

    public String getAdName() {
        return this.f5967k;
    }

    public Business getBusiness() {
        return this.f5970n;
    }

    public String getCityCode() {
        return this.f5960c;
    }

    public String getCityName() {
        return this.f5966j;
    }

    public IndoorDataV2 getIndoorData() {
        return this.f5971o;
    }

    public LatLonPoint getLatLonPoint() {
        return this.e;
    }

    public List<Photo> getPhotos() {
        return this.f5973q;
    }

    public String getPoiId() {
        return this.f5958a;
    }

    public PoiNavi getPoiNavi() {
        return this.f5972p;
    }

    public String getProvinceCode() {
        return this.f5968l;
    }

    public String getProvinceName() {
        return this.f5965i;
    }

    public String getSnippet() {
        return this.f5963g;
    }

    public List<SubPoiItemV2> getSubPois() {
        return this.f5969m;
    }

    public String getTitle() {
        return this.f5962f;
    }

    public String getTypeCode() {
        return this.f5964h;
    }

    public String getTypeDes() {
        return this.f5961d;
    }

    public int hashCode() {
        String str = this.f5958a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f5959b = str;
    }

    public void setAdName(String str) {
        this.f5967k = str;
    }

    public void setBusiness(Business business) {
        this.f5970n = business;
    }

    public void setCityCode(String str) {
        this.f5960c = str;
    }

    public void setCityName(String str) {
        this.f5966j = str;
    }

    public void setIndoorData(IndoorDataV2 indoorDataV2) {
        this.f5971o = indoorDataV2;
    }

    public void setPhotos(List<Photo> list) {
        this.f5973q = list;
    }

    public void setPoiNavi(PoiNavi poiNavi) {
        this.f5972p = poiNavi;
    }

    public void setProvinceCode(String str) {
        this.f5968l = str;
    }

    public void setProvinceName(String str) {
        this.f5965i = str;
    }

    public void setSubPois(List<SubPoiItemV2> list) {
        this.f5969m = list;
    }

    public void setTypeCode(String str) {
        this.f5964h = str;
    }

    public void setTypeDes(String str) {
        this.f5961d = str;
    }

    public String toString() {
        return this.f5962f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5958a);
        parcel.writeString(this.f5959b);
        parcel.writeString(this.f5961d);
        parcel.writeValue(this.e);
        parcel.writeString(this.f5962f);
        parcel.writeString(this.f5963g);
        parcel.writeString(this.f5960c);
        parcel.writeString(this.f5965i);
        parcel.writeString(this.f5966j);
        parcel.writeString(this.f5967k);
        parcel.writeString(this.f5968l);
        parcel.writeString(this.f5964h);
        parcel.writeList(this.f5969m);
        parcel.writeValue(this.f5970n);
        parcel.writeValue(this.f5971o);
        parcel.writeValue(this.f5972p);
        parcel.writeTypedList(this.f5973q);
    }

    public PoiItemV2(Parcel parcel) {
        this.f5961d = "";
        this.f5969m = new ArrayList();
        this.f5973q = new ArrayList();
        this.f5958a = parcel.readString();
        this.f5959b = parcel.readString();
        this.f5961d = parcel.readString();
        this.e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f5962f = parcel.readString();
        this.f5963g = parcel.readString();
        this.f5960c = parcel.readString();
        this.f5965i = parcel.readString();
        this.f5966j = parcel.readString();
        this.f5967k = parcel.readString();
        this.f5968l = parcel.readString();
        this.f5964h = parcel.readString();
        this.f5969m = parcel.readArrayList(SubPoiItemV2.class.getClassLoader());
        this.f5970n = (Business) parcel.readValue(Business.class.getClassLoader());
        this.f5971o = (IndoorDataV2) parcel.readValue(IndoorDataV2.class.getClassLoader());
        this.f5972p = (PoiNavi) parcel.readValue(PoiNavi.class.getClassLoader());
        this.f5973q = parcel.createTypedArrayList(Photo.CREATOR);
    }
}
