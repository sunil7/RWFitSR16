package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final String BUNDLE_KEY_CUSTOMID = "customId";
    public static final String BUNDLE_KEY_FENCE = "fence";
    public static final String BUNDLE_KEY_FENCEID = "fenceid";
    public static final String BUNDLE_KEY_FENCESTATUS = "event";
    public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final Parcelable.Creator<GeoFence> CREATOR = new a();
    public static final int ERROR_CODE_EXISTS = 17;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int ERROR_NO_VALIDFENCE = 16;
    public static final int STATUS_IN = 1;
    public static final int STATUS_LOCFAIL = 4;
    public static final int STATUS_OUT = 2;
    public static final int STATUS_STAYED = 3;
    public static final int STATUS_UNKNOWN = 0;
    public static final int TYPE_AMAPPOI = 2;
    public static final int TYPE_DISTRICT = 3;
    public static final int TYPE_POLYGON = 1;
    public static final int TYPE_ROUND = 0;

    /* renamed from: a, reason: collision with root package name */
    private String f5579a;

    /* renamed from: b, reason: collision with root package name */
    private String f5580b;

    /* renamed from: c, reason: collision with root package name */
    private String f5581c;

    /* renamed from: d, reason: collision with root package name */
    private PendingIntent f5582d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private PoiItem f5583f;

    /* renamed from: g, reason: collision with root package name */
    private List<DistrictItem> f5584g;

    /* renamed from: h, reason: collision with root package name */
    private List<List<DPoint>> f5585h;

    /* renamed from: i, reason: collision with root package name */
    private float f5586i;

    /* renamed from: j, reason: collision with root package name */
    private long f5587j;

    /* renamed from: k, reason: collision with root package name */
    private int f5588k;

    /* renamed from: l, reason: collision with root package name */
    private float f5589l;

    /* renamed from: m, reason: collision with root package name */
    private float f5590m;

    /* renamed from: n, reason: collision with root package name */
    private DPoint f5591n;

    /* renamed from: o, reason: collision with root package name */
    private int f5592o;

    /* renamed from: p, reason: collision with root package name */
    private long f5593p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5594q;
    private AMapLocation r;

    public static class a implements Parcelable.Creator<GeoFence> {
        @Override // android.os.Parcelable.Creator
        public GeoFence createFromParcel(Parcel parcel) {
            return new GeoFence(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GeoFence[] newArray(int i3) {
            return new GeoFence[i3];
        }
    }

    public GeoFence() {
        this.f5582d = null;
        this.e = 0;
        this.f5583f = null;
        this.f5584g = null;
        this.f5586i = 0.0f;
        this.f5587j = -1L;
        this.f5588k = 1;
        this.f5589l = 0.0f;
        this.f5590m = 0.0f;
        this.f5591n = null;
        this.f5592o = 0;
        this.f5593p = -1L;
        this.f5594q = true;
        this.r = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoFence)) {
            return false;
        }
        GeoFence geoFence = (GeoFence) obj;
        if (TextUtils.isEmpty(this.f5580b)) {
            if (!TextUtils.isEmpty(geoFence.f5580b)) {
                return false;
            }
        } else if (!this.f5580b.equals(geoFence.f5580b)) {
            return false;
        }
        DPoint dPoint = this.f5591n;
        if (dPoint == null) {
            if (geoFence.f5591n != null) {
                return false;
            }
        } else if (!dPoint.equals(geoFence.f5591n)) {
            return false;
        }
        if (this.f5586i != geoFence.f5586i) {
            return false;
        }
        List<List<DPoint>> list = this.f5585h;
        return list == null ? geoFence.f5585h == null : list.equals(geoFence.f5585h);
    }

    public int getActivatesAction() {
        return this.f5588k;
    }

    public DPoint getCenter() {
        return this.f5591n;
    }

    public AMapLocation getCurrentLocation() {
        return this.r;
    }

    public String getCustomId() {
        return this.f5580b;
    }

    public List<DistrictItem> getDistrictItemList() {
        return this.f5584g;
    }

    public long getEnterTime() {
        return this.f5593p;
    }

    public long getExpiration() {
        return this.f5587j;
    }

    public String getFenceId() {
        return this.f5579a;
    }

    public float getMaxDis2Center() {
        return this.f5590m;
    }

    public float getMinDis2Center() {
        return this.f5589l;
    }

    public PendingIntent getPendingIntent() {
        return this.f5582d;
    }

    public String getPendingIntentAction() {
        return this.f5581c;
    }

    public PoiItem getPoiItem() {
        return this.f5583f;
    }

    public List<List<DPoint>> getPointList() {
        return this.f5585h;
    }

    public float getRadius() {
        return this.f5586i;
    }

    public int getStatus() {
        return this.f5592o;
    }

    public int getType() {
        return this.e;
    }

    public int hashCode() {
        return this.f5591n.hashCode() + this.f5585h.hashCode() + this.f5580b.hashCode() + ((int) (this.f5586i * 100.0f));
    }

    public boolean isAble() {
        return this.f5594q;
    }

    public void setAble(boolean z5) {
        this.f5594q = z5;
    }

    public void setActivatesAction(int i3) {
        this.f5588k = i3;
    }

    public void setCenter(DPoint dPoint) {
        this.f5591n = dPoint;
    }

    public void setCurrentLocation(AMapLocation aMapLocation) {
        this.r = aMapLocation.m2clone();
    }

    public void setCustomId(String str) {
        this.f5580b = str;
    }

    public void setDistrictItemList(List<DistrictItem> list) {
        this.f5584g = list;
    }

    public void setEnterTime(long j4) {
        this.f5593p = j4;
    }

    public void setExpiration(long j4) {
        if (j4 < 0) {
            this.f5587j = -1L;
        } else {
            this.f5587j = Utils.getTimeBoot() + j4;
        }
    }

    public void setFenceId(String str) {
        this.f5579a = str;
    }

    public void setMaxDis2Center(float f2) {
        this.f5590m = f2;
    }

    public void setMinDis2Center(float f2) {
        this.f5589l = f2;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.f5582d = pendingIntent;
    }

    public void setPendingIntentAction(String str) {
        this.f5581c = str;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.f5583f = poiItem;
    }

    public void setPointList(List<List<DPoint>> list) {
        this.f5585h = list;
    }

    public void setRadius(float f2) {
        this.f5586i = f2;
    }

    public void setStatus(int i3) {
        this.f5592o = i3;
    }

    public void setType(int i3) {
        this.e = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5579a);
        parcel.writeString(this.f5580b);
        parcel.writeString(this.f5581c);
        parcel.writeParcelable(this.f5582d, i3);
        parcel.writeInt(this.e);
        parcel.writeParcelable(this.f5583f, i3);
        parcel.writeTypedList(this.f5584g);
        parcel.writeFloat(this.f5586i);
        parcel.writeLong(this.f5587j);
        parcel.writeInt(this.f5588k);
        parcel.writeFloat(this.f5589l);
        parcel.writeFloat(this.f5590m);
        parcel.writeParcelable(this.f5591n, i3);
        parcel.writeInt(this.f5592o);
        parcel.writeLong(this.f5593p);
        List<List<DPoint>> list = this.f5585h;
        if (list != null && !list.isEmpty()) {
            parcel.writeInt(this.f5585h.size());
            Iterator<List<DPoint>> it = this.f5585h.iterator();
            while (it.hasNext()) {
                parcel.writeTypedList(it.next());
            }
        }
        parcel.writeByte(this.f5594q ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.r, i3);
    }

    public GeoFence(Parcel parcel) {
        this.f5582d = null;
        this.e = 0;
        this.f5583f = null;
        this.f5584g = null;
        this.f5586i = 0.0f;
        this.f5587j = -1L;
        this.f5588k = 1;
        this.f5589l = 0.0f;
        this.f5590m = 0.0f;
        this.f5591n = null;
        this.f5592o = 0;
        this.f5593p = -1L;
        this.f5594q = true;
        this.r = null;
        this.f5579a = parcel.readString();
        this.f5580b = parcel.readString();
        this.f5581c = parcel.readString();
        this.f5582d = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.e = parcel.readInt();
        this.f5583f = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        this.f5584g = parcel.createTypedArrayList(DistrictItem.CREATOR);
        this.f5586i = parcel.readFloat();
        this.f5587j = parcel.readLong();
        this.f5588k = parcel.readInt();
        this.f5589l = parcel.readFloat();
        this.f5590m = parcel.readFloat();
        this.f5591n = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        this.f5592o = parcel.readInt();
        this.f5593p = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt != 0) {
            this.f5585h = new ArrayList();
            for (int i3 = 0; i3 < readInt; i3++) {
                this.f5585h.add(parcel.createTypedArrayList(DPoint.CREATOR));
            }
        }
        this.f5594q = parcel.readByte() != 0;
        this.r = (AMapLocation) parcel.readParcelable(AMapLocation.class.getClassLoader());
    }
}
