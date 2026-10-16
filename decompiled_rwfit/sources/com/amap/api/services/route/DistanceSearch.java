package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.d6;
import com.amap.api.col.p0003sl.g8;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DistanceSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    public static final int TYPE_WALK_DISTANCE = 3;

    /* renamed from: a, reason: collision with root package name */
    private IDistanceSearch f6228a;

    public static class DistanceQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DistanceQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private int f6229a;

        /* renamed from: b, reason: collision with root package name */
        private List<LatLonPoint> f6230b;

        /* renamed from: c, reason: collision with root package name */
        private LatLonPoint f6231c;

        /* renamed from: d, reason: collision with root package name */
        private String f6232d;
        private int e;

        public static class a implements Parcelable.Creator<DistanceQuery> {
            @Override // android.os.Parcelable.Creator
            public DistanceQuery createFromParcel(Parcel parcel) {
                return new DistanceQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DistanceQuery[] newArray(int i3) {
                return new DistanceQuery[i3];
            }
        }

        public DistanceQuery() {
            this.f6229a = 1;
            this.f6230b = new ArrayList();
            this.f6232d = "base";
            this.e = 4;
        }

        public void addOrigins(LatLonPoint... latLonPointArr) {
            for (LatLonPoint latLonPoint : latLonPointArr) {
                if (latLonPoint != null) {
                    this.f6230b.add(latLonPoint);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public LatLonPoint getDestination() {
            return this.f6231c;
        }

        public String getExtensions() {
            return this.f6232d;
        }

        public int getMode() {
            return this.e;
        }

        public List<LatLonPoint> getOrigins() {
            return this.f6230b;
        }

        public int getType() {
            return this.f6229a;
        }

        public void setDestination(LatLonPoint latLonPoint) {
            this.f6231c = latLonPoint;
        }

        public void setExtensions(String str) {
            this.f6232d = str;
        }

        public void setMode(int i3) {
            this.e = i3;
        }

        public void setOrigins(List<LatLonPoint> list) {
            if (list != null) {
                this.f6230b = list;
            }
        }

        public void setType(int i3) {
            this.f6229a = i3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f6229a);
            parcel.writeTypedList(this.f6230b);
            parcel.writeParcelable(this.f6231c, i3);
            parcel.writeString(this.f6232d);
            parcel.writeInt(this.e);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DistanceQuery m27clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "DistanceSearch", "DistanceQueryclone");
            }
            DistanceQuery distanceQuery = new DistanceQuery();
            distanceQuery.setType(this.f6229a);
            distanceQuery.setOrigins(this.f6230b);
            distanceQuery.setDestination(this.f6231c);
            distanceQuery.setExtensions(this.f6232d);
            distanceQuery.setMode(this.e);
            return distanceQuery;
        }

        public DistanceQuery(Parcel parcel) {
            this.f6229a = 1;
            this.f6230b = new ArrayList();
            this.f6232d = "base";
            this.e = 4;
            this.f6229a = parcel.readInt();
            this.f6230b = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f6231c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f6232d = parcel.readString();
            this.e = parcel.readInt();
        }
    }

    public interface OnDistanceSearchListener {
        void onDistanceSearched(DistanceResult distanceResult, int i3);
    }

    public DistanceSearch(Context context) throws AMapException {
        if (this.f6228a == null) {
            try {
                this.f6228a = new g8(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public DistanceResult calculateRouteDistance(DistanceQuery distanceQuery) throws AMapException {
        IDistanceSearch iDistanceSearch = this.f6228a;
        if (iDistanceSearch != null) {
            return iDistanceSearch.calculateRouteDistance(distanceQuery);
        }
        return null;
    }

    public void calculateRouteDistanceAsyn(DistanceQuery distanceQuery) {
        IDistanceSearch iDistanceSearch = this.f6228a;
        if (iDistanceSearch != null) {
            iDistanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        }
    }

    public void setDistanceSearchListener(OnDistanceSearchListener onDistanceSearchListener) {
        IDistanceSearch iDistanceSearch = this.f6228a;
        if (iDistanceSearch != null) {
            iDistanceSearch.setDistanceSearchListener(onDistanceSearchListener);
        }
    }
}
