package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new a();
    private String A;
    private String B;

    /* renamed from: a, reason: collision with root package name */
    private String f5934a;

    /* renamed from: b, reason: collision with root package name */
    private String f5935b;

    /* renamed from: c, reason: collision with root package name */
    private String f5936c;

    /* renamed from: d, reason: collision with root package name */
    private String f5937d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private int f5938f;

    /* renamed from: g, reason: collision with root package name */
    private final LatLonPoint f5939g;

    /* renamed from: h, reason: collision with root package name */
    private final String f5940h;

    /* renamed from: i, reason: collision with root package name */
    private final String f5941i;

    /* renamed from: j, reason: collision with root package name */
    private LatLonPoint f5942j;

    /* renamed from: k, reason: collision with root package name */
    private LatLonPoint f5943k;

    /* renamed from: l, reason: collision with root package name */
    private String f5944l;

    /* renamed from: m, reason: collision with root package name */
    private String f5945m;

    /* renamed from: n, reason: collision with root package name */
    private String f5946n;

    /* renamed from: o, reason: collision with root package name */
    private String f5947o;

    /* renamed from: p, reason: collision with root package name */
    private String f5948p;

    /* renamed from: q, reason: collision with root package name */
    private String f5949q;
    private String r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f5950s;

    /* renamed from: t, reason: collision with root package name */
    private IndoorData f5951t;

    /* renamed from: u, reason: collision with root package name */
    private String f5952u;

    /* renamed from: v, reason: collision with root package name */
    private String f5953v;

    /* renamed from: w, reason: collision with root package name */
    private String f5954w;

    /* renamed from: x, reason: collision with root package name */
    private List<SubPoiItem> f5955x;

    /* renamed from: y, reason: collision with root package name */
    private List<Photo> f5956y;

    /* renamed from: z, reason: collision with root package name */
    private PoiItemExtension f5957z;

    public static class a implements Parcelable.Creator<PoiItem> {
        @Override // android.os.Parcelable.Creator
        public PoiItem createFromParcel(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PoiItem[] newArray(int i3) {
            return new PoiItem[i3];
        }
    }

    public PoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.e = "";
        this.f5938f = -1;
        this.f5955x = new ArrayList();
        this.f5956y = new ArrayList();
        this.f5934a = str;
        this.f5939g = latLonPoint;
        this.f5940h = str2;
        this.f5941i = str3;
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
        PoiItem poiItem = (PoiItem) obj;
        String str = this.f5934a;
        if (str == null) {
            if (poiItem.f5934a != null) {
                return false;
            }
        } else if (!str.equals(poiItem.f5934a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.f5936c;
    }

    public String getAdName() {
        return this.r;
    }

    public String getBusinessArea() {
        return this.f5953v;
    }

    public String getCityCode() {
        return this.f5937d;
    }

    public String getCityName() {
        return this.f5949q;
    }

    public String getDirection() {
        return this.f5947o;
    }

    public int getDistance() {
        return this.f5938f;
    }

    public String getEmail() {
        return this.f5946n;
    }

    public LatLonPoint getEnter() {
        return this.f5942j;
    }

    public LatLonPoint getExit() {
        return this.f5943k;
    }

    public IndoorData getIndoorData() {
        return this.f5951t;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f5939g;
    }

    public String getParkingType() {
        return this.f5954w;
    }

    public List<Photo> getPhotos() {
        return this.f5956y;
    }

    public PoiItemExtension getPoiExtension() {
        return this.f5957z;
    }

    public String getPoiId() {
        return this.f5934a;
    }

    public String getPostcode() {
        return this.f5945m;
    }

    public String getProvinceCode() {
        return this.f5952u;
    }

    public String getProvinceName() {
        return this.f5948p;
    }

    public String getShopID() {
        return this.B;
    }

    public String getSnippet() {
        return this.f5941i;
    }

    public List<SubPoiItem> getSubPois() {
        return this.f5955x;
    }

    public String getTel() {
        return this.f5935b;
    }

    public String getTitle() {
        return this.f5940h;
    }

    public String getTypeCode() {
        return this.A;
    }

    public String getTypeDes() {
        return this.e;
    }

    public String getWebsite() {
        return this.f5944l;
    }

    public int hashCode() {
        String str = this.f5934a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public boolean isIndoorMap() {
        return this.f5950s;
    }

    public void setAdCode(String str) {
        this.f5936c = str;
    }

    public void setAdName(String str) {
        this.r = str;
    }

    public void setBusinessArea(String str) {
        this.f5953v = str;
    }

    public void setCityCode(String str) {
        this.f5937d = str;
    }

    public void setCityName(String str) {
        this.f5949q = str;
    }

    public void setDirection(String str) {
        this.f5947o = str;
    }

    public void setDistance(int i3) {
        this.f5938f = i3;
    }

    public void setEmail(String str) {
        this.f5946n = str;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f5942j = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f5943k = latLonPoint;
    }

    public void setIndoorDate(IndoorData indoorData) {
        this.f5951t = indoorData;
    }

    public void setIndoorMap(boolean z5) {
        this.f5950s = z5;
    }

    public void setParkingType(String str) {
        this.f5954w = str;
    }

    public void setPhotos(List<Photo> list) {
        this.f5956y = list;
    }

    public void setPoiExtension(PoiItemExtension poiItemExtension) {
        this.f5957z = poiItemExtension;
    }

    public void setPostcode(String str) {
        this.f5945m = str;
    }

    public void setProvinceCode(String str) {
        this.f5952u = str;
    }

    public void setProvinceName(String str) {
        this.f5948p = str;
    }

    public void setShopID(String str) {
        this.B = str;
    }

    public void setSubPois(List<SubPoiItem> list) {
        this.f5955x = list;
    }

    public void setTel(String str) {
        this.f5935b = str;
    }

    public void setTypeCode(String str) {
        this.A = str;
    }

    public void setTypeDes(String str) {
        this.e = str;
    }

    public void setWebsite(String str) {
        this.f5944l = str;
    }

    public String toString() {
        return this.f5940h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5934a);
        parcel.writeString(this.f5936c);
        parcel.writeString(this.f5935b);
        parcel.writeString(this.e);
        parcel.writeInt(this.f5938f);
        parcel.writeValue(this.f5939g);
        parcel.writeString(this.f5940h);
        parcel.writeString(this.f5941i);
        parcel.writeString(this.f5937d);
        parcel.writeValue(this.f5942j);
        parcel.writeValue(this.f5943k);
        parcel.writeString(this.f5944l);
        parcel.writeString(this.f5945m);
        parcel.writeString(this.f5946n);
        parcel.writeBooleanArray(new boolean[]{this.f5950s});
        parcel.writeString(this.f5947o);
        parcel.writeString(this.f5948p);
        parcel.writeString(this.f5949q);
        parcel.writeString(this.r);
        parcel.writeString(this.f5952u);
        parcel.writeString(this.f5953v);
        parcel.writeString(this.f5954w);
        parcel.writeList(this.f5955x);
        parcel.writeValue(this.f5951t);
        parcel.writeTypedList(this.f5956y);
        parcel.writeParcelable(this.f5957z, i3);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
    }

    public PoiItem(Parcel parcel) {
        this.e = "";
        this.f5938f = -1;
        this.f5955x = new ArrayList();
        this.f5956y = new ArrayList();
        this.f5934a = parcel.readString();
        this.f5936c = parcel.readString();
        this.f5935b = parcel.readString();
        this.e = parcel.readString();
        this.f5938f = parcel.readInt();
        this.f5939g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f5940h = parcel.readString();
        this.f5941i = parcel.readString();
        this.f5937d = parcel.readString();
        this.f5942j = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f5943k = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f5944l = parcel.readString();
        this.f5945m = parcel.readString();
        this.f5946n = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f5950s = zArr[0];
        this.f5947o = parcel.readString();
        this.f5948p = parcel.readString();
        this.f5949q = parcel.readString();
        this.r = parcel.readString();
        this.f5952u = parcel.readString();
        this.f5953v = parcel.readString();
        this.f5954w = parcel.readString();
        this.f5955x = parcel.readArrayList(SubPoiItem.class.getClassLoader());
        this.f5951t = (IndoorData) parcel.readValue(IndoorData.class.getClassLoader());
        this.f5956y = parcel.createTypedArrayList(Photo.CREATOR);
        this.f5957z = (PoiItemExtension) parcel.readParcelable(PoiItemExtension.class.getClassLoader());
        this.A = parcel.readString();
        this.B = parcel.readString();
    }
}
