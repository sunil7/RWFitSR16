package com.amap.api.services.auto;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.c8;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IAutoTSearch;

/* loaded from: classes.dex */
public class AutoTSearch {

    /* renamed from: a, reason: collision with root package name */
    private IAutoTSearch f5836a;

    public static class FilterBox implements Cloneable, Parcelable {
        public static final Parcelable.Creator<FilterBox> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private String f5837a;

        /* renamed from: b, reason: collision with root package name */
        private String f5838b;

        /* renamed from: c, reason: collision with root package name */
        private String f5839c;

        /* renamed from: d, reason: collision with root package name */
        private String f5840d;
        private String e;

        public static class a implements Parcelable.Creator<FilterBox> {
            @Override // android.os.Parcelable.Creator
            public FilterBox createFromParcel(Parcel parcel) {
                return new FilterBox(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public FilterBox[] newArray(int i3) {
                return new FilterBox[i3];
            }
        }

        public FilterBox() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCheckedLevel() {
            return this.f5838b;
        }

        public String getClassifyV2Data() {
            return this.f5839c;
        }

        public String getClassifyV2Level2Data() {
            return this.f5840d;
        }

        public String getClassifyV2Level3Data() {
            return this.e;
        }

        public String getRetainState() {
            return this.f5837a;
        }

        public void setCheckedLevel(String str) {
            this.f5838b = str;
        }

        public void setClassifyV2Data(String str) {
            this.f5839c = str;
        }

        public void setClassifyV2Level2Data(String str) {
            this.f5840d = str;
        }

        public void setClassifyV2Level3Data(String str) {
            this.e = str;
        }

        public void setRetainState(String str) {
            this.f5837a = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f5837a);
            parcel.writeString(this.f5838b);
            parcel.writeString(this.f5839c);
            parcel.writeString(this.f5840d);
            parcel.writeString(this.e);
        }

        public FilterBox(Parcel parcel) {
            this.f5837a = parcel.readString();
            this.f5838b = parcel.readString();
            this.f5839c = parcel.readString();
            this.f5840d = parcel.readString();
            this.e = parcel.readString();
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FilterBox m16clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            FilterBox filterBox = new FilterBox();
            filterBox.setRetainState(this.f5837a);
            filterBox.setCheckedLevel(this.f5838b);
            filterBox.setClassifyV2Data(this.f5839c);
            filterBox.setClassifyV2Level2Data(this.f5840d);
            filterBox.setClassifyV2Level3Data(this.e);
            return filterBox;
        }
    }

    public interface OnChargeStationListener {
        void onChargeStationSearched(AutoTChargeStationResult autoTChargeStationResult, int i3);
    }

    public static class Query implements Cloneable, Parcelable {
        public static final Parcelable.Creator<Query> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private String f5841a;

        /* renamed from: b, reason: collision with root package name */
        private String f5842b;

        /* renamed from: c, reason: collision with root package name */
        private String f5843c;

        /* renamed from: d, reason: collision with root package name */
        private String f5844d;
        private String e;

        /* renamed from: f, reason: collision with root package name */
        private int f5845f;

        /* renamed from: g, reason: collision with root package name */
        private int f5846g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f5847h;

        /* renamed from: i, reason: collision with root package name */
        private String f5848i;

        /* renamed from: j, reason: collision with root package name */
        private int f5849j;

        /* renamed from: k, reason: collision with root package name */
        private LatLonPoint f5850k;

        /* renamed from: l, reason: collision with root package name */
        private String f5851l;

        /* renamed from: m, reason: collision with root package name */
        private String f5852m;

        /* renamed from: n, reason: collision with root package name */
        private FilterBox f5853n;

        /* renamed from: o, reason: collision with root package name */
        private String f5854o;

        /* renamed from: p, reason: collision with root package name */
        private String f5855p;

        public static class a implements Parcelable.Creator<Query> {
            @Override // android.os.Parcelable.Creator
            public Query createFromParcel(Parcel parcel) {
                return new Query(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Query[] newArray(int i3) {
                return new Query[i3];
            }
        }

        public Query() {
            this.f5847h = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAccessKey() {
            return this.f5854o;
        }

        public String getAdCode() {
            return this.f5841a;
        }

        public String getCity() {
            return this.f5842b;
        }

        public String getDataType() {
            return this.f5843c;
        }

        public FilterBox getFilterBox() {
            return this.f5853n;
        }

        public String getGeoObj() {
            return this.f5844d;
        }

        public String getKeywords() {
            return this.e;
        }

        public LatLonPoint getLatLonPoint() {
            return this.f5850k;
        }

        public int getPageNum() {
            return this.f5845f;
        }

        public int getPageSize() {
            return this.f5846g;
        }

        public String getQueryType() {
            return this.f5848i;
        }

        public int getRange() {
            return this.f5849j;
        }

        public String getSecretKey() {
            return this.f5855p;
        }

        public String getUserCity() {
            return this.f5852m;
        }

        public String getUserLoc() {
            return this.f5851l;
        }

        public boolean isQii() {
            return this.f5847h;
        }

        public void setAccessKey(String str) {
            this.f5854o = str;
        }

        public void setAdCode(String str) {
            this.f5841a = str;
        }

        public void setCity(String str) {
            this.f5842b = str;
        }

        public void setDataType(String str) {
            this.f5843c = str;
        }

        public void setFilterBox(FilterBox filterBox) {
            this.f5853n = filterBox;
        }

        public void setGeoObj(String str) {
            this.f5844d = str;
        }

        public void setKeywords(String str) {
            this.e = str;
        }

        public void setLatLonPoint(LatLonPoint latLonPoint) {
            this.f5850k = latLonPoint;
        }

        public void setPageNum(int i3) {
            this.f5845f = i3;
        }

        public void setPageSize(int i3) {
            this.f5846g = i3;
        }

        public void setQii(boolean z5) {
            this.f5847h = z5;
        }

        public void setQueryType(String str) {
            this.f5848i = str;
        }

        public void setRange(int i3) {
            this.f5849j = i3;
        }

        public void setSecretKey(String str) {
            this.f5855p = str;
        }

        public void setUserCity(String str) {
            this.f5852m = str;
        }

        public void setUserLoc(String str) {
            this.f5851l = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f5841a);
            parcel.writeString(this.f5842b);
            parcel.writeString(this.f5843c);
            parcel.writeString(this.f5844d);
            parcel.writeString(this.e);
            parcel.writeInt(this.f5845f);
            parcel.writeInt(this.f5846g);
            parcel.writeByte(this.f5847h ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f5848i);
            parcel.writeInt(this.f5849j);
            parcel.writeParcelable(this.f5850k, i3);
            parcel.writeString(this.f5851l);
            parcel.writeString(this.f5852m);
            parcel.writeParcelable(this.f5853n, i3);
            parcel.writeString(this.f5854o);
            parcel.writeString(this.f5855p);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m17clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            Query query = new Query();
            query.setAdCode(this.f5841a);
            query.setCity(this.f5842b);
            query.setDataType(this.f5843c);
            query.setGeoObj(this.f5844d);
            query.setKeywords(this.e);
            query.setPageNum(this.f5845f);
            query.setPageSize(this.f5846g);
            query.setQii(this.f5847h);
            query.setQueryType(this.f5848i);
            query.setRange(this.f5849j);
            query.setLatLonPoint(this.f5850k);
            query.setUserLoc(this.f5851l);
            query.setUserCity(this.f5852m);
            query.setAccessKey(this.f5854o);
            query.setSecretKey(this.f5855p);
            query.setFilterBox(this.f5853n);
            return query;
        }

        public Query(Parcel parcel) {
            this.f5847h = false;
            this.f5841a = parcel.readString();
            this.f5842b = parcel.readString();
            this.f5843c = parcel.readString();
            this.f5844d = parcel.readString();
            this.e = parcel.readString();
            this.f5845f = parcel.readInt();
            this.f5846g = parcel.readInt();
            this.f5847h = parcel.readByte() != 0;
            this.f5848i = parcel.readString();
            this.f5849j = parcel.readInt();
            this.f5850k = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f5851l = parcel.readString();
            this.f5852m = parcel.readString();
            this.f5853n = (FilterBox) parcel.readParcelable(FilterBox.class.getClassLoader());
            this.f5854o = parcel.readString();
            this.f5855p = parcel.readString();
        }
    }

    public AutoTSearch(Context context) throws AMapException {
        if (this.f5836a == null) {
            try {
                this.f5836a = new c8(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public AutoTChargeStationResult searchChargeStation() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f5836a;
        if (iAutoTSearch == null) {
            return null;
        }
        return iAutoTSearch.searchChargeStation();
    }

    public void searchChargeStationAsync() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f5836a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.searchChargeStationAsync();
    }

    public void setChargeStationListener(OnChargeStationListener onChargeStationListener) {
        IAutoTSearch iAutoTSearch = this.f5836a;
        if (iAutoTSearch == null || onChargeStationListener == null) {
            return;
        }
        iAutoTSearch.setChargeStationListener(onChargeStationListener);
    }

    public void setQuery(Query query) {
        IAutoTSearch iAutoTSearch = this.f5836a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.setQuery(query);
    }
}
