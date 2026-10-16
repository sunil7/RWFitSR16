package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.d6;
import com.amap.api.col.p0003sl.o8;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class RouteSearch {
    public static final int BUS_COMFORTABLE = 4;
    public static final int BUS_DEFAULT = 0;
    public static final int BUS_LEASE_CHANGE = 2;
    public static final int BUS_LEASE_WALK = 3;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_SAVE_MONEY = 1;
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_FASTEST_SAVE_MONEY = 11;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY = 6;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int DRIVEING_PLAN_CHOICE_HIGHWAY = 8;
    public static final int DRIVEING_PLAN_DEFAULT = 1;
    public static final int DRIVEING_PLAN_FASTEST_SHORTEST = 10;
    public static final int DRIVEING_PLAN_NO_HIGHWAY = 2;
    public static final int DRIVEING_PLAN_SAVE_MONEY = 3;
    public static final int DRIVEING_PLAN_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final String DRIVING_EXCLUDE_FERRY = "ferry";
    public static final String DRIVING_EXCLUDE_MOTORWAY = "motorway";
    public static final String DRIVING_EXCLUDE_TOLL = "toll";
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION = 12;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY = 15;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY_SAVE_MONEY = 18;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_SAVE_MONEY = 17;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY = 19;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY_AVOID_CONGESTION = 20;
    public static final int DRIVING_MULTI_CHOICE_NO_HIGHWAY = 13;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY = 14;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY_NO_HIGHWAY = 16;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SAVE_MONEY_SHORTEST = 5;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST = 11;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION = 10;
    public static final int DRIVING_NORMAL_CAR = 0;
    public static final int DRIVING_PLUGIN_HYBRID_CAR = 2;
    public static final int DRIVING_PURE_ELECTRIC_VEHICLE = 1;
    public static final int DRIVING_SINGLE_AVOID_CONGESTION = 4;
    public static final int DRIVING_SINGLE_DEFAULT = 0;
    public static final int DRIVING_SINGLE_NO_EXPRESSWAYS = 3;
    public static final int DRIVING_SINGLE_NO_HIGHWAY = 6;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY = 7;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 9;
    public static final int DRIVING_SINGLE_SAVE_MONEY = 1;
    public static final int DRIVING_SINGLE_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SINGLE_SHORTEST = 2;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int RIDING_DEFAULT = 0;
    public static final int RIDING_FAST = 2;
    public static final int RIDING_RECOMMEND = 1;
    public static final int RidingDefault = 0;
    public static final int RidingFast = 2;
    public static final int RidingRecommend = 1;
    public static final int TRUCK_AVOID_CONGESTION = 1;
    public static final int TRUCK_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int TRUCK_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY = 6;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int TRUCK_CHOICE_HIGHWAY = 8;
    public static final int TRUCK_NO_HIGHWAY = 2;
    public static final int TRUCK_SAVE_MONEY = 3;
    public static final int TRUCK_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final int TRUCK_SIZE_HEAVY = 4;
    public static final int TRUCK_SIZE_LIGHT = 2;
    public static final int TRUCK_SIZE_MEDIUM = 3;
    public static final int TRUCK_SIZE_MINI = 1;
    public static final int WALK_DEFAULT = 0;
    public static final int WALK_MULTI_PATH = 1;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;

    /* renamed from: a, reason: collision with root package name */
    private IRouteSearch f6332a;

    public static class BusRouteQuery implements Cloneable, Parcelable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f6333a;

        /* renamed from: b, reason: collision with root package name */
        private int f6334b;

        /* renamed from: c, reason: collision with root package name */
        private String f6335c;

        /* renamed from: d, reason: collision with root package name */
        private String f6336d;
        private int e;

        /* renamed from: f, reason: collision with root package name */
        private String f6337f;

        public static class a implements Parcelable.Creator<BusRouteQuery> {
            @Override // android.os.Parcelable.Creator
            public BusRouteQuery createFromParcel(Parcel parcel) {
                return new BusRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public BusRouteQuery[] newArray(int i3) {
                return new BusRouteQuery[i3];
            }
        }

        public BusRouteQuery(FromAndTo fromAndTo, int i3, String str, int i10) {
            this.f6337f = "base";
            this.f6333a = fromAndTo;
            this.f6334b = i3;
            this.f6335c = str;
            this.e = i10;
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
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            String str = this.f6335c;
            if (str == null) {
                if (busRouteQuery.f6335c != null) {
                    return false;
                }
            } else if (!str.equals(busRouteQuery.f6335c)) {
                return false;
            }
            String str2 = this.f6336d;
            if (str2 == null) {
                if (busRouteQuery.f6336d != null) {
                    return false;
                }
            } else if (!str2.equals(busRouteQuery.f6336d)) {
                return false;
            }
            String str3 = this.f6337f;
            if (str3 == null) {
                if (busRouteQuery.f6337f != null) {
                    return false;
                }
            } else if (!str3.equals(busRouteQuery.f6337f)) {
                return false;
            }
            FromAndTo fromAndTo = this.f6333a;
            if (fromAndTo == null) {
                if (busRouteQuery.f6333a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(busRouteQuery.f6333a)) {
                return false;
            }
            return this.f6334b == busRouteQuery.f6334b && this.e == busRouteQuery.e;
        }

        public String getCity() {
            return this.f6335c;
        }

        public String getCityd() {
            return this.f6336d;
        }

        public String getExtensions() {
            return this.f6337f;
        }

        public FromAndTo getFromAndTo() {
            return this.f6333a;
        }

        public int getMode() {
            return this.f6334b;
        }

        public int getNightFlag() {
            return this.e;
        }

        public int hashCode() {
            String str = this.f6335c;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            FromAndTo fromAndTo = this.f6333a;
            int hashCode2 = (((((hashCode + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f6334b) * 31) + this.e) * 31;
            String str2 = this.f6336d;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public void setCityd(String str) {
            this.f6336d = str;
        }

        public void setExtensions(String str) {
            this.f6337f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6333a, i3);
            parcel.writeInt(this.f6334b);
            parcel.writeString(this.f6335c);
            parcel.writeInt(this.e);
            parcel.writeString(this.f6336d);
            parcel.writeString(this.f6337f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BusRouteQuery m28clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearch", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f6333a, this.f6334b, this.f6335c, this.e);
            busRouteQuery.setCityd(this.f6336d);
            busRouteQuery.setExtensions(this.f6337f);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.f6337f = "base";
            this.f6333a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f6334b = parcel.readInt();
            this.f6335c = parcel.readString();
            this.e = parcel.readInt();
            this.f6336d = parcel.readString();
            this.f6337f = parcel.readString();
        }

        public BusRouteQuery() {
            this.f6337f = "base";
        }
    }

    public static class DrivePlanQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DrivePlanQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f6338a;

        /* renamed from: b, reason: collision with root package name */
        private String f6339b;

        /* renamed from: c, reason: collision with root package name */
        private int f6340c;

        /* renamed from: d, reason: collision with root package name */
        private int f6341d;
        private int e;

        /* renamed from: f, reason: collision with root package name */
        private int f6342f;

        /* renamed from: g, reason: collision with root package name */
        private int f6343g;

        public static class a implements Parcelable.Creator<DrivePlanQuery> {
            @Override // android.os.Parcelable.Creator
            public DrivePlanQuery createFromParcel(Parcel parcel) {
                return new DrivePlanQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DrivePlanQuery[] newArray(int i3) {
                return new DrivePlanQuery[i3];
            }
        }

        public DrivePlanQuery(FromAndTo fromAndTo, int i3, int i10, int i11) {
            this.f6340c = 1;
            this.f6341d = 0;
            this.f6338a = fromAndTo;
            this.e = i3;
            this.f6342f = i10;
            this.f6343g = i11;
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
            DrivePlanQuery drivePlanQuery = (DrivePlanQuery) obj;
            FromAndTo fromAndTo = this.f6338a;
            if (fromAndTo == null) {
                if (drivePlanQuery.f6338a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(drivePlanQuery.f6338a)) {
                return false;
            }
            String str = this.f6339b;
            if (str == null) {
                if (drivePlanQuery.f6339b != null) {
                    return false;
                }
            } else if (!str.equals(drivePlanQuery.f6339b)) {
                return false;
            }
            return this.f6340c == drivePlanQuery.f6340c && this.f6341d == drivePlanQuery.f6341d && this.e == drivePlanQuery.e && this.f6342f == drivePlanQuery.f6342f && this.f6343g == drivePlanQuery.f6343g;
        }

        public int getCarType() {
            return this.f6341d;
        }

        public int getCount() {
            return this.f6343g;
        }

        public String getDestParentPoiID() {
            return this.f6339b;
        }

        public int getFirstTime() {
            return this.e;
        }

        public FromAndTo getFromAndTo() {
            return this.f6338a;
        }

        public int getInterval() {
            return this.f6342f;
        }

        public int getMode() {
            return this.f6340c;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f6338a;
            int hashCode = ((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31;
            String str = this.f6339b;
            return ((((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f6340c) * 31) + this.f6341d) * 31) + this.e) * 31) + this.f6342f) * 31) + this.f6343g;
        }

        public void setCarType(int i3) {
            this.f6341d = i3;
        }

        public void setDestParentPoiID(String str) {
            this.f6339b = str;
        }

        public void setMode(int i3) {
            this.f6340c = i3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6338a, i3);
            parcel.writeString(this.f6339b);
            parcel.writeInt(this.f6340c);
            parcel.writeInt(this.f6341d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f6342f);
            parcel.writeInt(this.f6343g);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DrivePlanQuery m29clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearch", "DriveRouteQueryclone");
            }
            DrivePlanQuery drivePlanQuery = new DrivePlanQuery(this.f6338a, this.e, this.f6342f, this.f6343g);
            drivePlanQuery.setDestParentPoiID(this.f6339b);
            drivePlanQuery.setMode(this.f6340c);
            drivePlanQuery.setCarType(this.f6341d);
            return drivePlanQuery;
        }

        public DrivePlanQuery() {
            this.f6340c = 1;
            this.f6341d = 0;
            this.e = 0;
            this.f6342f = 0;
            this.f6343g = 48;
        }

        public DrivePlanQuery(Parcel parcel) {
            this.f6340c = 1;
            this.f6341d = 0;
            this.e = 0;
            this.f6342f = 0;
            this.f6343g = 48;
            this.f6338a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f6339b = parcel.readString();
            this.f6340c = parcel.readInt();
            this.f6341d = parcel.readInt();
            this.e = parcel.readInt();
            this.f6342f = parcel.readInt();
            this.f6343g = parcel.readInt();
        }
    }

    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f6344a;

        /* renamed from: b, reason: collision with root package name */
        private int f6345b;

        /* renamed from: c, reason: collision with root package name */
        private List<LatLonPoint> f6346c;

        /* renamed from: d, reason: collision with root package name */
        private List<List<LatLonPoint>> f6347d;
        private String e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f6348f;

        /* renamed from: g, reason: collision with root package name */
        private int f6349g;

        /* renamed from: h, reason: collision with root package name */
        private String f6350h;

        /* renamed from: i, reason: collision with root package name */
        private String f6351i;

        public static class a implements Parcelable.Creator<DriveRouteQuery> {
            @Override // android.os.Parcelable.Creator
            public DriveRouteQuery createFromParcel(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DriveRouteQuery[] newArray(int i3) {
                return new DriveRouteQuery[i3];
            }
        }

        public DriveRouteQuery(FromAndTo fromAndTo, int i3, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f6348f = true;
            this.f6349g = 0;
            this.f6350h = null;
            this.f6351i = "base";
            this.f6344a = fromAndTo;
            this.f6345b = i3;
            this.f6346c = list;
            this.f6347d = list2;
            this.e = str;
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
            DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
            String str = this.e;
            if (str == null) {
                if (driveRouteQuery.e != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.e)) {
                return false;
            }
            List<List<LatLonPoint>> list = this.f6347d;
            if (list == null) {
                if (driveRouteQuery.f6347d != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.f6347d)) {
                return false;
            }
            FromAndTo fromAndTo = this.f6344a;
            if (fromAndTo == null) {
                if (driveRouteQuery.f6344a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.f6344a)) {
                return false;
            }
            if (this.f6345b != driveRouteQuery.f6345b) {
                return false;
            }
            List<LatLonPoint> list2 = this.f6346c;
            if (list2 == null) {
                if (driveRouteQuery.f6346c != null) {
                    return false;
                }
            } else if (!list2.equals(driveRouteQuery.f6346c) || this.f6348f != driveRouteQuery.isUseFerry() || this.f6349g != driveRouteQuery.f6349g) {
                return false;
            }
            String str2 = this.f6351i;
            if (str2 == null) {
                if (driveRouteQuery.f6351i != null) {
                    return false;
                }
            } else if (!str2.equals(driveRouteQuery.f6351i)) {
                return false;
            }
            return true;
        }

        public String getAvoidRoad() {
            return this.e;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f6347d;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f6347d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i3 = 0; i3 < this.f6347d.size(); i3++) {
                List<LatLonPoint> list2 = this.f6347d.get(i3);
                for (int i10 = 0; i10 < list2.size(); i10++) {
                    LatLonPoint latLonPoint = list2.get(i10);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(Const.STR_MART_COMMA);
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i10 < list2.size() - 1) {
                        stringBuffer.append(Const.STR_MART_SEMICOLON);
                    }
                }
                if (i3 < this.f6347d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f6349g;
        }

        public String getExclude() {
            return this.f6350h;
        }

        public String getExtensions() {
            return this.f6351i;
        }

        public FromAndTo getFromAndTo() {
            return this.f6344a;
        }

        public int getMode() {
            return this.f6345b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f6346c;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f6346c;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i3 = 0; i3 < this.f6346c.size(); i3++) {
                LatLonPoint latLonPoint = this.f6346c.get(i3);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(Const.STR_MART_COMMA);
                stringBuffer.append(latLonPoint.getLatitude());
                if (i3 < this.f6346c.size() - 1) {
                    stringBuffer.append(Const.STR_MART_SEMICOLON);
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidRoad() {
            return !d6.a(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !d6.a(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !d6.a(getPassedPointStr());
        }

        public int hashCode() {
            String str = this.e;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f6347d;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f6344a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f6345b) * 31;
            List<LatLonPoint> list2 = this.f6346c;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f6349g;
        }

        public boolean isUseFerry() {
            return this.f6348f;
        }

        public void setCarType(int i3) {
            this.f6349g = i3;
        }

        public void setExclude(String str) {
            this.f6350h = str;
        }

        public void setExtensions(String str) {
            this.f6351i = str;
        }

        public void setUseFerry(boolean z5) {
            this.f6348f = z5;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6344a, i3);
            parcel.writeInt(this.f6345b);
            parcel.writeTypedList(this.f6346c);
            List<List<LatLonPoint>> list = this.f6347d;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                Iterator<List<LatLonPoint>> it = this.f6347d.iterator();
                while (it.hasNext()) {
                    parcel.writeTypedList(it.next());
                }
            }
            parcel.writeString(this.e);
            parcel.writeInt(this.f6348f ? 1 : 0);
            parcel.writeInt(this.f6349g);
            parcel.writeString(this.f6350h);
            parcel.writeString(this.f6351i);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DriveRouteQuery m30clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearch", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f6344a, this.f6345b, this.f6346c, this.f6347d, this.e);
            driveRouteQuery.setUseFerry(this.f6348f);
            driveRouteQuery.setCarType(this.f6349g);
            driveRouteQuery.setExclude(this.f6350h);
            driveRouteQuery.setExtensions(this.f6351i);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f6348f = true;
            this.f6349g = 0;
            this.f6350h = null;
            this.f6351i = "base";
            this.f6344a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f6345b = parcel.readInt();
            this.f6346c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f6347d = null;
            } else {
                this.f6347d = new ArrayList();
            }
            for (int i3 = 0; i3 < readInt; i3++) {
                this.f6347d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.e = parcel.readString();
            this.f6348f = parcel.readInt() == 1;
            this.f6349g = parcel.readInt();
            this.f6350h = parcel.readString();
            this.f6351i = parcel.readString();
        }

        public DriveRouteQuery() {
            this.f6348f = true;
            this.f6349g = 0;
            this.f6350h = null;
            this.f6351i = "base";
        }
    }

    public static class FromAndTo implements Cloneable, Parcelable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f6352a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f6353b;

        /* renamed from: c, reason: collision with root package name */
        private String f6354c;

        /* renamed from: d, reason: collision with root package name */
        private String f6355d;
        private String e;

        /* renamed from: f, reason: collision with root package name */
        private String f6356f;

        /* renamed from: g, reason: collision with root package name */
        private String f6357g;

        /* renamed from: h, reason: collision with root package name */
        private String f6358h;

        public static class a implements Parcelable.Creator<FromAndTo> {
            @Override // android.os.Parcelable.Creator
            public FromAndTo createFromParcel(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public FromAndTo[] newArray(int i3) {
                return new FromAndTo[i3];
            }
        }

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f6352a = latLonPoint;
            this.f6353b = latLonPoint2;
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
            FromAndTo fromAndTo = (FromAndTo) obj;
            String str = this.f6355d;
            if (str == null) {
                if (fromAndTo.f6355d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.f6355d)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f6352a;
            if (latLonPoint == null) {
                if (fromAndTo.f6352a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.f6352a)) {
                return false;
            }
            String str2 = this.f6354c;
            if (str2 == null) {
                if (fromAndTo.f6354c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.f6354c)) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f6353b;
            if (latLonPoint2 == null) {
                if (fromAndTo.f6353b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.f6353b)) {
                return false;
            }
            String str3 = this.e;
            if (str3 == null) {
                if (fromAndTo.e != null) {
                    return false;
                }
            } else if (!str3.equals(fromAndTo.e)) {
                return false;
            }
            String str4 = this.f6356f;
            if (str4 == null) {
                if (fromAndTo.f6356f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f6356f)) {
                return false;
            }
            return true;
        }

        public String getDestinationPoiID() {
            return this.f6355d;
        }

        public String getDestinationType() {
            return this.f6356f;
        }

        public LatLonPoint getFrom() {
            return this.f6352a;
        }

        public String getOriginType() {
            return this.e;
        }

        public String getPlateNumber() {
            return this.f6358h;
        }

        public String getPlateProvince() {
            return this.f6357g;
        }

        public String getStartPoiID() {
            return this.f6354c;
        }

        public LatLonPoint getTo() {
            return this.f6353b;
        }

        public int hashCode() {
            String str = this.f6355d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f6352a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f6354c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f6353b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f6356f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f6355d = str;
        }

        public void setDestinationType(String str) {
            this.f6356f = str;
        }

        public void setOriginType(String str) {
            this.e = str;
        }

        public void setPlateNumber(String str) {
            this.f6358h = str;
        }

        public void setPlateProvince(String str) {
            this.f6357g = str;
        }

        public void setStartPoiID(String str) {
            this.f6354c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6352a, i3);
            parcel.writeParcelable(this.f6353b, i3);
            parcel.writeString(this.f6354c);
            parcel.writeString(this.f6355d);
            parcel.writeString(this.e);
            parcel.writeString(this.f6356f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FromAndTo m31clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f6352a, this.f6353b);
            fromAndTo.setStartPoiID(this.f6354c);
            fromAndTo.setDestinationPoiID(this.f6355d);
            fromAndTo.setOriginType(this.e);
            fromAndTo.setDestinationType(this.f6356f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.f6352a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f6353b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f6354c = parcel.readString();
            this.f6355d = parcel.readString();
            this.e = parcel.readString();
            this.f6356f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i3);
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i3);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i3);

        void onRideRouteSearched(RideRouteResult rideRouteResult, int i3);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i3);
    }

    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i3);
    }

    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f6359a;

        /* renamed from: b, reason: collision with root package name */
        private int f6360b;

        /* renamed from: c, reason: collision with root package name */
        private String f6361c;

        public static class a implements Parcelable.Creator<RideRouteQuery> {
            @Override // android.os.Parcelable.Creator
            public RideRouteQuery createFromParcel(Parcel parcel) {
                return new RideRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public RideRouteQuery[] newArray(int i3) {
                return new RideRouteQuery[i3];
            }
        }

        public RideRouteQuery(FromAndTo fromAndTo, int i3) {
            this.f6361c = "base";
            this.f6359a = fromAndTo;
            this.f6360b = i3;
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
            RideRouteQuery rideRouteQuery = (RideRouteQuery) obj;
            FromAndTo fromAndTo = this.f6359a;
            if (fromAndTo == null) {
                if (rideRouteQuery.f6359a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(rideRouteQuery.f6359a)) {
                return false;
            }
            return this.f6360b == rideRouteQuery.f6360b;
        }

        public String getExtensions() {
            return this.f6361c;
        }

        public FromAndTo getFromAndTo() {
            return this.f6359a;
        }

        public int getMode() {
            return this.f6360b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f6359a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f6360b;
        }

        public void setExtensions(String str) {
            this.f6361c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6359a, i3);
            parcel.writeInt(this.f6360b);
            parcel.writeString(this.f6361c);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public RideRouteQuery m32clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearch", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f6359a);
            rideRouteQuery.setExtensions(this.f6361c);
            return rideRouteQuery;
        }

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f6361c = "base";
            this.f6359a = fromAndTo;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f6361c = "base";
            this.f6359a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f6360b = parcel.readInt();
            this.f6361c = parcel.readString();
        }

        public RideRouteQuery() {
            this.f6361c = "base";
        }
    }

    public static class TruckRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<TruckRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f6362a;

        /* renamed from: b, reason: collision with root package name */
        private int f6363b;

        /* renamed from: c, reason: collision with root package name */
        private int f6364c;

        /* renamed from: d, reason: collision with root package name */
        private List<LatLonPoint> f6365d;
        private float e;

        /* renamed from: f, reason: collision with root package name */
        private float f6366f;

        /* renamed from: g, reason: collision with root package name */
        private float f6367g;

        /* renamed from: h, reason: collision with root package name */
        private float f6368h;

        /* renamed from: i, reason: collision with root package name */
        private float f6369i;

        /* renamed from: j, reason: collision with root package name */
        private String f6370j;

        public static class a implements Parcelable.Creator<TruckRouteQuery> {
            @Override // android.os.Parcelable.Creator
            public TruckRouteQuery createFromParcel(Parcel parcel) {
                return new TruckRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public TruckRouteQuery[] newArray(int i3) {
                return new TruckRouteQuery[i3];
            }
        }

        public TruckRouteQuery(FromAndTo fromAndTo, int i3, List<LatLonPoint> list, int i10) {
            this.f6370j = "base";
            this.f6362a = fromAndTo;
            this.f6364c = i3;
            this.f6365d = list;
            this.f6363b = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getExtensions() {
            return this.f6370j;
        }

        public FromAndTo getFromAndTo() {
            return this.f6362a;
        }

        public int getMode() {
            return this.f6364c;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f6365d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f6365d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i3 = 0; i3 < this.f6365d.size(); i3++) {
                LatLonPoint latLonPoint = this.f6365d.get(i3);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(Const.STR_MART_COMMA);
                stringBuffer.append(latLonPoint.getLatitude());
                if (i3 < this.f6365d.size() - 1) {
                    stringBuffer.append(Const.STR_MART_SEMICOLON);
                }
            }
            return stringBuffer.toString();
        }

        public float getTruckAxis() {
            return this.f6369i;
        }

        public float getTruckHeight() {
            return this.e;
        }

        public float getTruckLoad() {
            return this.f6367g;
        }

        public int getTruckSize() {
            return this.f6363b;
        }

        public float getTruckWeight() {
            return this.f6368h;
        }

        public float getTruckWidth() {
            return this.f6366f;
        }

        public boolean hasPassPoint() {
            return !d6.a(getPassedPointStr());
        }

        public void setExtensions(String str) {
            this.f6370j = str;
        }

        public void setMode(int i3) {
            this.f6364c = i3;
        }

        public void setTruckAxis(float f2) {
            this.f6369i = f2;
        }

        public void setTruckHeight(float f2) {
            this.e = f2;
        }

        public void setTruckLoad(float f2) {
            this.f6367g = f2;
        }

        public void setTruckSize(int i3) {
            this.f6363b = i3;
        }

        public void setTruckWeight(float f2) {
            this.f6368h = f2;
        }

        public void setTruckWidth(float f2) {
            this.f6366f = f2;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6362a, i3);
            parcel.writeInt(this.f6363b);
            parcel.writeInt(this.f6364c);
            parcel.writeTypedList(this.f6365d);
            parcel.writeFloat(this.e);
            parcel.writeFloat(this.f6366f);
            parcel.writeFloat(this.f6367g);
            parcel.writeFloat(this.f6368h);
            parcel.writeFloat(this.f6369i);
            parcel.writeString(this.f6370j);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public TruckRouteQuery m33clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearch", "TruckRouteQueryclone");
            }
            TruckRouteQuery truckRouteQuery = new TruckRouteQuery(this.f6362a, this.f6364c, this.f6365d, this.f6363b);
            truckRouteQuery.setExtensions(this.f6370j);
            return truckRouteQuery;
        }

        public TruckRouteQuery(Parcel parcel) {
            this.f6363b = 2;
            this.f6370j = "base";
            this.f6362a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f6363b = parcel.readInt();
            this.f6364c = parcel.readInt();
            this.f6365d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.e = parcel.readFloat();
            this.f6366f = parcel.readFloat();
            this.f6367g = parcel.readFloat();
            this.f6368h = parcel.readFloat();
            this.f6369i = parcel.readFloat();
            this.f6370j = parcel.readString();
        }
    }

    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f6371a;

        /* renamed from: b, reason: collision with root package name */
        private int f6372b;

        /* renamed from: c, reason: collision with root package name */
        private String f6373c;

        public static class a implements Parcelable.Creator<WalkRouteQuery> {
            @Override // android.os.Parcelable.Creator
            public WalkRouteQuery createFromParcel(Parcel parcel) {
                return new WalkRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public WalkRouteQuery[] newArray(int i3) {
                return new WalkRouteQuery[i3];
            }
        }

        public WalkRouteQuery(FromAndTo fromAndTo, int i3) {
            this.f6373c = "base";
            this.f6371a = fromAndTo;
            this.f6372b = i3;
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
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            FromAndTo fromAndTo = this.f6371a;
            if (fromAndTo == null) {
                if (walkRouteQuery.f6371a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(walkRouteQuery.f6371a)) {
                return false;
            }
            String str = this.f6373c;
            if (str == null) {
                if (walkRouteQuery.f6373c != null) {
                    return false;
                }
            } else if (!str.equals(walkRouteQuery.f6373c)) {
                return false;
            }
            return this.f6372b == walkRouteQuery.f6372b;
        }

        public String getExtensions() {
            return this.f6373c;
        }

        public FromAndTo getFromAndTo() {
            return this.f6371a;
        }

        public int getMode() {
            return this.f6372b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f6371a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f6372b;
        }

        public void setExtensions(String str) {
            this.f6373c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6371a, i3);
            parcel.writeInt(this.f6372b);
            parcel.writeString(this.f6373c);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WalkRouteQuery m34clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearch", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f6371a);
            walkRouteQuery.setExtensions(this.f6373c);
            return walkRouteQuery;
        }

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f6373c = "base";
            this.f6371a = fromAndTo;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f6373c = "base";
            this.f6371a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f6372b = parcel.readInt();
            this.f6373c = parcel.readString();
        }

        public WalkRouteQuery() {
            this.f6373c = "base";
        }
    }

    public RouteSearch(Context context) throws AMapException {
        if (this.f6332a == null) {
            try {
                this.f6332a = new o8(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRoutePlanResult calculateDrivePlan(DrivePlanQuery drivePlanQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDrivePlan(drivePlanQuery);
        }
        return null;
    }

    public void calculateDrivePlanAsyn(DrivePlanQuery drivePlanQuery) {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDrivePlanAsyn(drivePlanQuery);
        }
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResult calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public TruckRouteRestult calculateTruckRoute(TruckRouteQuery truckRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateTruckRoute(truckRouteQuery);
        }
        return null;
    }

    public void calculateTruckRouteAsyn(TruckRouteQuery truckRouteQuery) {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateTruckRouteAsyn(truckRouteQuery);
        }
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setOnRoutePlanSearchListener(OnRoutePlanSearchListener onRoutePlanSearchListener) {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnRoutePlanSearchListener(onRoutePlanSearchListener);
        }
    }

    public void setOnTruckRouteSearchListener(OnTruckRouteSearchListener onTruckRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnTruckRouteSearchListener(onTruckRouteSearchListener);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f6332a;
        if (iRouteSearch != null) {
            iRouteSearch.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
