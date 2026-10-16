package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.d6;
import com.amap.api.col.p0003sl.p8;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.RouteSearch;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RouteSearchV2 {

    /* renamed from: a, reason: collision with root package name */
    private IRouteSearchV2 f6375a;

    public class AlternativeRoute {
        public static final int ALTERNATIVE_ROUTE_ONE = 1;
        public static final int ALTERNATIVE_ROUTE_THREE = 3;
        public static final int ALTERNATIVE_ROUTE_TWO = 2;

        public AlternativeRoute(RouteSearchV2 routeSearchV2) {
        }
    }

    public static class BusMode {
        public static final int BUS_COMFORTABLE = 4;
        public static final int BUS_DEFAULT = 0;
        public static final int BUS_LEASE_CHANGE = 2;
        public static final int BUS_LEASE_WALK = 3;
        public static final int BUS_NO_SUBWAY = 5;
        public static final int BUS_SAVE_MONEY = 1;
        public static final int BUS_SUBWAY = 6;
        public static final int BUS_SUBWAY_FIRST = 7;
        public static final int BUS_WASTE_LESS = 8;
    }

    public static class BusRouteQuery implements Cloneable, Parcelable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f6376a;

        /* renamed from: b, reason: collision with root package name */
        private int f6377b;

        /* renamed from: c, reason: collision with root package name */
        private String f6378c;

        /* renamed from: d, reason: collision with root package name */
        private String f6379d;
        private String e;

        /* renamed from: f, reason: collision with root package name */
        private String f6380f;

        /* renamed from: g, reason: collision with root package name */
        private int f6381g;

        /* renamed from: h, reason: collision with root package name */
        private String f6382h;

        /* renamed from: i, reason: collision with root package name */
        private String f6383i;

        /* renamed from: j, reason: collision with root package name */
        private String f6384j;

        /* renamed from: k, reason: collision with root package name */
        private String f6385k;

        /* renamed from: l, reason: collision with root package name */
        private int f6386l;

        /* renamed from: m, reason: collision with root package name */
        private int f6387m;

        /* renamed from: n, reason: collision with root package name */
        private int f6388n;

        /* renamed from: o, reason: collision with root package name */
        private int f6389o;

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
            this.f6386l = 5;
            this.f6387m = 0;
            this.f6388n = 4;
            this.f6389o = 1;
            this.f6376a = fromAndTo;
            this.f6377b = i3;
            this.f6378c = str;
            this.f6381g = i10;
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
            if (this.f6377b == busRouteQuery.f6377b && this.f6381g == busRouteQuery.f6381g && this.f6382h.equals(busRouteQuery.f6382h) && this.f6383i.equals(busRouteQuery.f6383i) && this.f6386l == busRouteQuery.f6386l && this.f6387m == busRouteQuery.f6387m && this.f6388n == busRouteQuery.f6388n && this.f6389o == busRouteQuery.f6389o && this.f6376a.equals(busRouteQuery.f6376a) && this.f6378c.equals(busRouteQuery.f6378c) && this.f6379d.equals(busRouteQuery.f6379d) && this.e.equals(busRouteQuery.e) && this.f6380f.equals(busRouteQuery.f6380f) && this.f6384j.equals(busRouteQuery.f6384j)) {
                return this.f6385k.equals(busRouteQuery.f6385k);
            }
            return false;
        }

        public String getAd1() {
            return this.f6384j;
        }

        public String getAd2() {
            return this.f6385k;
        }

        public int getAlternativeRoute() {
            return this.f6386l;
        }

        public String getCity() {
            return this.f6378c;
        }

        public String getCityd() {
            return this.f6379d;
        }

        public String getDate() {
            return this.e;
        }

        public String getDestinationPoiId() {
            return this.f6383i;
        }

        public FromAndTo getFromAndTo() {
            return this.f6376a;
        }

        public int getMaxTrans() {
            return this.f6388n;
        }

        public int getMode() {
            return this.f6377b;
        }

        public int getMultiExport() {
            return this.f6387m;
        }

        public int getNightFlag() {
            return this.f6381g;
        }

        public String getOriginPoiId() {
            return this.f6382h;
        }

        public int getShowFields() {
            return this.f6389o;
        }

        public String getTime() {
            return this.f6380f;
        }

        public int hashCode() {
            return ((((((l0.d(l0.d(l0.d(l0.d((l0.d(l0.d(l0.d(l0.d(((this.f6376a.hashCode() * 31) + this.f6377b) * 31, 31, this.f6378c), 31, this.f6379d), 31, this.e), 31, this.f6380f) + this.f6381g) * 31, 31, this.f6382h), 31, this.f6383i), 31, this.f6384j), 31, this.f6385k) + this.f6386l) * 31) + this.f6387m) * 31) + this.f6388n) * 31) + this.f6389o;
        }

        public void setAd1(String str) {
            this.f6384j = str;
        }

        public void setAd2(String str) {
            this.f6385k = str;
        }

        public void setAlternativeRoute(int i3) {
            this.f6386l = i3;
        }

        public void setCityd(String str) {
            this.f6379d = str;
        }

        public void setDate(String str) {
            this.e = str;
        }

        public void setDestinationPoiId(String str) {
            this.f6383i = str;
        }

        public void setMaxTrans(int i3) {
            this.f6388n = i3;
        }

        public void setMultiExport(int i3) {
            this.f6387m = i3;
        }

        public void setOriginPoiId(String str) {
            this.f6382h = str;
        }

        public void setShowFields(int i3) {
            this.f6389o = i3;
        }

        public void setTime(String str) {
            this.f6380f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6376a, i3);
            parcel.writeInt(this.f6377b);
            parcel.writeString(this.f6378c);
            parcel.writeInt(this.f6381g);
            parcel.writeString(this.f6379d);
            parcel.writeInt(this.f6389o);
            parcel.writeString(this.f6382h);
            parcel.writeString(this.f6383i);
            parcel.writeString(this.f6384j);
            parcel.writeString(this.f6385k);
            parcel.writeInt(this.f6386l);
            parcel.writeInt(this.f6388n);
            parcel.writeInt(this.f6387m);
            parcel.writeString(this.e);
            parcel.writeString(this.f6380f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BusRouteQuery m35clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearchV2", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f6376a, this.f6377b, this.f6378c, this.f6381g);
            busRouteQuery.setCityd(this.f6379d);
            busRouteQuery.setShowFields(this.f6389o);
            busRouteQuery.setDate(this.e);
            busRouteQuery.setTime(this.f6380f);
            busRouteQuery.setAd1(this.f6384j);
            busRouteQuery.setAd2(this.f6385k);
            busRouteQuery.setOriginPoiId(this.f6382h);
            busRouteQuery.setDestinationPoiId(this.f6383i);
            busRouteQuery.setMaxTrans(this.f6388n);
            busRouteQuery.setMultiExport(this.f6387m);
            busRouteQuery.setAlternativeRoute(this.f6386l);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.f6377b = 0;
            this.f6381g = 0;
            this.f6386l = 5;
            this.f6387m = 0;
            this.f6388n = 4;
            this.f6389o = 1;
            this.f6376a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f6377b = parcel.readInt();
            this.f6378c = parcel.readString();
            this.f6381g = parcel.readInt();
            this.f6379d = parcel.readString();
            this.f6389o = parcel.readInt();
            this.f6382h = parcel.readString();
            this.f6383i = parcel.readString();
            this.e = parcel.readString();
            this.f6380f = parcel.readString();
            this.f6388n = parcel.readInt();
            this.f6387m = parcel.readInt();
            this.f6386l = parcel.readInt();
            this.f6384j = parcel.readString();
            this.f6385k = parcel.readString();
        }

        public BusRouteQuery() {
            this.f6377b = 0;
            this.f6381g = 0;
            this.f6386l = 5;
            this.f6387m = 0;
            this.f6388n = 4;
            this.f6389o = 1;
        }
    }

    public static class CurveCost {

        /* renamed from: a, reason: collision with root package name */
        private float f6390a;

        /* renamed from: b, reason: collision with root package name */
        private float f6391b;

        public float getAccess() {
            return this.f6390a;
        }

        public float getValue() {
            return this.f6391b;
        }

        public void setAccess(float f2) {
            this.f6390a = f2;
        }

        public void setValue(float f2) {
            this.f6391b = f2;
        }
    }

    public static class CustomCostMode {

        /* renamed from: a, reason: collision with root package name */
        private List<SpeedCost> f6392a;

        /* renamed from: b, reason: collision with root package name */
        private CurveCost f6393b;

        /* renamed from: c, reason: collision with root package name */
        private SlopeCost f6394c;

        /* renamed from: d, reason: collision with root package name */
        private float f6395d;
        private TransCost e;

        /* renamed from: f, reason: collision with root package name */
        private float f6396f;

        /* renamed from: g, reason: collision with root package name */
        private PowerTrainLoss f6397g;

        public float getAuxCost() {
            return this.f6395d;
        }

        public CurveCost getCurveCost() {
            return this.f6393b;
        }

        public float getFerryCost() {
            return this.f6396f;
        }

        public PowerTrainLoss getPowerTrainLosses() {
            return this.f6397g;
        }

        public SlopeCost getSlopeCost() {
            return this.f6394c;
        }

        public List<SpeedCost> getSpeedCosts() {
            return this.f6392a;
        }

        public TransCost getTransCost() {
            return this.e;
        }

        public void setAuxCost(float f2) {
            this.f6395d = f2;
        }

        public void setCurveCost(CurveCost curveCost) {
            this.f6393b = curveCost;
        }

        public void setFerryCost(float f2) {
            this.f6396f = f2;
        }

        public void setPowerTrainLosses(PowerTrainLoss powerTrainLoss) {
            this.f6397g = powerTrainLoss;
        }

        public void setSlopeCost(SlopeCost slopeCost) {
            this.f6394c = slopeCost;
        }

        public void setSpeedCosts(List<SpeedCost> list) {
            this.f6392a = list;
        }

        public void setTransCost(TransCost transCost) {
            this.e = transCost;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                List<SpeedCost> list = this.f6392a;
                if (list != null) {
                    for (SpeedCost speedCost : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(Const.JSON_KEY_SPEED, speedCost.getSpeed());
                        jSONObject2.put("value", speedCost.getValue());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("speed_cost", jSONArray);
                }
                if (this.f6393b != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("access", this.f6393b.getAccess());
                    jSONObject3.put("value", this.f6393b.getValue());
                    jSONObject.put("curve_cost", jSONObject3);
                }
                if (this.f6394c != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("up", this.f6394c.getUp());
                    jSONObject4.put("down", this.f6394c.getDown());
                    jSONObject.put("slope_cost", jSONObject4);
                }
                jSONObject.put("aux_cost", this.f6395d);
                if (this.e != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("access", this.e.getAccess());
                    jSONObject5.put("decess", this.e.getDecess());
                    jSONObject.put("trans_cost", jSONObject5);
                }
                jSONObject.put("ferry_cost", this.f6396f);
                if (this.f6397g != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("powerdemand", this.f6397g.getPowerDemand());
                    jSONObject6.put("value", this.f6397g.getPowerDemandValue());
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put(Const.JSON_KEY_SPEED, this.f6397g.getSpeed());
                    jSONObject7.put("value", this.f6397g.getSpeedValue());
                    jSONArray2.put(jSONObject6);
                    jSONArray2.put(jSONObject7);
                    jSONObject.put("powertrain_loss", jSONArray2);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f6398a;

        /* renamed from: b, reason: collision with root package name */
        private NewEnergy f6399b;

        /* renamed from: c, reason: collision with root package name */
        private int f6400c;

        /* renamed from: d, reason: collision with root package name */
        private List<LatLonPoint> f6401d;
        private List<List<LatLonPoint>> e;

        /* renamed from: f, reason: collision with root package name */
        private String f6402f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f6403g;

        /* renamed from: h, reason: collision with root package name */
        private int f6404h;

        /* renamed from: i, reason: collision with root package name */
        private String f6405i;

        /* renamed from: j, reason: collision with root package name */
        private int f6406j;

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

        public DriveRouteQuery(FromAndTo fromAndTo, DrivingStrategy drivingStrategy, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f6400c = DrivingStrategy.DEFAULT.getValue();
            this.f6403g = true;
            this.f6404h = 0;
            this.f6405i = null;
            this.f6406j = 1;
            this.f6398a = fromAndTo;
            this.f6400c = drivingStrategy.getValue();
            this.f6401d = list;
            this.e = list2;
            this.f6402f = str;
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
            String str = this.f6402f;
            if (str == null) {
                if (driveRouteQuery.f6402f != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.f6402f)) {
                return false;
            }
            List<List<LatLonPoint>> list = this.e;
            if (list == null) {
                if (driveRouteQuery.e != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.e)) {
                return false;
            }
            FromAndTo fromAndTo = this.f6398a;
            if (fromAndTo == null) {
                if (driveRouteQuery.f6398a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.f6398a)) {
                return false;
            }
            if (this.f6400c != driveRouteQuery.f6400c) {
                return false;
            }
            List<LatLonPoint> list2 = this.f6401d;
            if (list2 == null) {
                if (driveRouteQuery.f6401d != null) {
                    return false;
                }
            } else if (!list2.equals(driveRouteQuery.f6401d) || this.f6403g != driveRouteQuery.isUseFerry() || this.f6404h != driveRouteQuery.f6404h || this.f6406j != driveRouteQuery.f6406j) {
                return false;
            }
            return true;
        }

        public String getAvoidRoad() {
            return this.f6402f;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.e;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.e;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                List<LatLonPoint> list2 = this.e.get(i3);
                for (int i10 = 0; i10 < list2.size(); i10++) {
                    LatLonPoint latLonPoint = list2.get(i10);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(Const.STR_MART_COMMA);
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i10 < list2.size() - 1) {
                        stringBuffer.append(Const.STR_MART_SEMICOLON);
                    }
                }
                if (i3 < this.e.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f6404h;
        }

        public String getExclude() {
            return this.f6405i;
        }

        public FromAndTo getFromAndTo() {
            return this.f6398a;
        }

        public DrivingStrategy getMode() {
            return DrivingStrategy.fromValue(this.f6400c);
        }

        public NewEnergy getNewEnergy() {
            return this.f6399b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f6401d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f6401d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i3 = 0; i3 < this.f6401d.size(); i3++) {
                LatLonPoint latLonPoint = this.f6401d.get(i3);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(Const.STR_MART_COMMA);
                stringBuffer.append(latLonPoint.getLatitude());
                if (i3 < this.f6401d.size() - 1) {
                    stringBuffer.append(Const.STR_MART_SEMICOLON);
                }
            }
            return stringBuffer.toString();
        }

        public int getShowFields() {
            return this.f6406j;
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
            String str = this.f6402f;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.e;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f6398a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f6400c) * 31;
            List<LatLonPoint> list2 = this.f6401d;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f6404h;
        }

        public boolean isUseFerry() {
            return this.f6403g;
        }

        public void setCarType(int i3) {
            this.f6404h = i3;
        }

        public void setExclude(String str) {
            this.f6405i = str;
        }

        public void setNewEnergy(NewEnergy newEnergy) {
            this.f6399b = newEnergy;
        }

        public void setShowFields(int i3) {
            this.f6406j = i3;
        }

        public void setUseFerry(boolean z5) {
            this.f6403g = z5;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6398a, i3);
            parcel.writeInt(this.f6400c);
            parcel.writeTypedList(this.f6401d);
            List<List<LatLonPoint>> list = this.e;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                Iterator<List<LatLonPoint>> it = this.e.iterator();
                while (it.hasNext()) {
                    parcel.writeTypedList(it.next());
                }
            }
            parcel.writeString(this.f6402f);
            parcel.writeInt(this.f6403g ? 1 : 0);
            parcel.writeInt(this.f6404h);
            parcel.writeString(this.f6405i);
            parcel.writeInt(this.f6406j);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DriveRouteQuery m36clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearchV2", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f6398a, DrivingStrategy.fromValue(this.f6400c), this.f6401d, this.e, this.f6402f);
            driveRouteQuery.setUseFerry(this.f6403g);
            driveRouteQuery.setCarType(this.f6404h);
            driveRouteQuery.setExclude(this.f6405i);
            driveRouteQuery.setShowFields(this.f6406j);
            driveRouteQuery.setNewEnergy(this.f6399b);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f6400c = DrivingStrategy.DEFAULT.getValue();
            this.f6403g = true;
            this.f6404h = 0;
            this.f6405i = null;
            this.f6406j = 1;
            this.f6398a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f6400c = parcel.readInt();
            this.f6401d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.e = null;
            } else {
                this.e = new ArrayList();
            }
            for (int i3 = 0; i3 < readInt; i3++) {
                this.e.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f6402f = parcel.readString();
            this.f6403g = parcel.readInt() == 1;
            this.f6404h = parcel.readInt();
            this.f6405i = parcel.readString();
            this.f6406j = parcel.readInt();
        }

        public DriveRouteQuery() {
            this.f6400c = DrivingStrategy.DEFAULT.getValue();
            this.f6403g = true;
            this.f6404h = 0;
            this.f6405i = null;
            this.f6406j = 1;
        }
    }

    public enum DrivingStrategy {
        DEFAULT(32),
        AVOID_CONGESTION(33),
        HIGHWAY_PRIORITY(34),
        AVOID_HIGHWAY(35),
        LESS_CHARGE(36),
        ROAD_PRIORITY(37),
        SPEED_PRIORITY(38),
        AVOID_CONGESTION_HIGHWAY_PRIORITY(39),
        AVOID_CONGESTION_AVOID_HIGHWAY(40),
        AVOID_CONGESTION_LESS_CHARGE(41),
        LESS_CHARGE_AVOID_HIGHWAY(42),
        AVOID_CONGESTION_LESS_CHARGE_AVOID_HIGHWAY(43),
        AVOID_CONGESTION_ROAD_PRIORITY(44),
        AVOID_CONGESTION_SPEED_PRIORITY(45);


        /* renamed from: a, reason: collision with root package name */
        int f6408a;

        DrivingStrategy(int i3) {
            this.f6408a = i3;
        }

        public static DrivingStrategy fromValue(int i3) {
            return values()[i3 - 32];
        }

        public int getValue() {
            return this.f6408a;
        }
    }

    public static class FromAndTo implements Cloneable, Parcelable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f6409a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f6410b;

        /* renamed from: c, reason: collision with root package name */
        private String f6411c;

        /* renamed from: d, reason: collision with root package name */
        private String f6412d;
        private String e;

        /* renamed from: f, reason: collision with root package name */
        private String f6413f;

        /* renamed from: g, reason: collision with root package name */
        private String f6414g;

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
            this.f6409a = latLonPoint;
            this.f6410b = latLonPoint2;
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
            String str = this.f6412d;
            if (str == null) {
                if (fromAndTo.f6412d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.f6412d)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f6409a;
            if (latLonPoint == null) {
                if (fromAndTo.f6409a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.f6409a)) {
                return false;
            }
            String str2 = this.f6411c;
            if (str2 == null) {
                if (fromAndTo.f6411c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.f6411c)) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f6410b;
            if (latLonPoint2 == null) {
                if (fromAndTo.f6410b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.f6410b)) {
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
            String str4 = this.f6413f;
            if (str4 == null) {
                if (fromAndTo.f6413f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f6413f)) {
                return false;
            }
            return true;
        }

        public String getDestinationPoiID() {
            return this.f6412d;
        }

        public String getDestinationType() {
            return this.f6413f;
        }

        public LatLonPoint getFrom() {
            return this.f6409a;
        }

        public String getOriginType() {
            return this.e;
        }

        public String getPlateNumber() {
            return this.f6414g;
        }

        public String getStartPoiID() {
            return this.f6411c;
        }

        public LatLonPoint getTo() {
            return this.f6410b;
        }

        public int hashCode() {
            String str = this.f6412d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f6409a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f6411c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f6410b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f6413f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f6412d = str;
        }

        public void setDestinationType(String str) {
            this.f6413f = str;
        }

        public void setOriginType(String str) {
            this.e = str;
        }

        public void setPlateNumber(String str) {
            this.f6414g = str;
        }

        public void setStartPoiID(String str) {
            this.f6411c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6409a, i3);
            parcel.writeParcelable(this.f6410b, i3);
            parcel.writeString(this.f6411c);
            parcel.writeString(this.f6412d);
            parcel.writeString(this.e);
            parcel.writeString(this.f6413f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FromAndTo m37clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearchV2", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f6409a, this.f6410b);
            fromAndTo.setStartPoiID(this.f6411c);
            fromAndTo.setDestinationPoiID(this.f6412d);
            fromAndTo.setOriginType(this.e);
            fromAndTo.setDestinationType(this.f6413f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.f6409a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f6410b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f6411c = parcel.readString();
            this.f6412d = parcel.readString();
            this.e = parcel.readString();
            this.f6413f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    public static class NewEnergy {

        /* renamed from: a, reason: collision with root package name */
        private String f6415a;

        /* renamed from: b, reason: collision with root package name */
        private CustomCostMode f6416b;

        /* renamed from: i, reason: collision with root package name */
        private String f6422i;

        /* renamed from: c, reason: collision with root package name */
        private float f6417c = -1.0f;

        /* renamed from: d, reason: collision with root package name */
        private float f6418d = -1.0f;
        private float e = 1.5f;

        /* renamed from: f, reason: collision with root package name */
        private float f6419f = 100.0f;

        /* renamed from: g, reason: collision with root package name */
        private float f6420g = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        private float f6421h = 0.0f;

        /* renamed from: j, reason: collision with root package name */
        private int f6423j = 0;

        public String buildParam() {
            StringBuilder sb2 = new StringBuilder();
            if (this.f6415a != null) {
                sb2.append("&key=");
                sb2.append(this.f6415a);
            }
            if (this.f6416b != null) {
                sb2.append("&custom_cost_mode=");
                sb2.append(this.f6416b.toJson());
            }
            if (this.f6417c > 0.0f) {
                sb2.append("&max_vehicle_charge=");
                sb2.append(this.f6417c);
            }
            if (this.f6418d > 0.0f) {
                sb2.append("&vehicle_charge=");
                sb2.append(this.f6418d);
            }
            sb2.append("&load=");
            sb2.append(this.e);
            sb2.append("&leaving_percent=");
            sb2.append(this.f6419f);
            sb2.append("&arriving_percent=");
            sb2.append(this.f6420g);
            sb2.append("&destination_arriving_percent=");
            sb2.append(this.f6421h);
            if (this.f6422i != null) {
                sb2.append("&custom_charging_arguments=");
                sb2.append(this.f6422i);
            }
            if (this.f6423j > 0) {
                sb2.append("&waypoints_arriving_percent=");
                sb2.append(this.f6423j);
            }
            return sb2.toString();
        }

        public float getArrivingPercent() {
            return this.f6420g;
        }

        public String getCustomChargingArguments() {
            return this.f6422i;
        }

        public CustomCostMode getCustomCostMode() {
            return this.f6416b;
        }

        public float getDestinationArrivingPercent() {
            return this.f6421h;
        }

        public String getKey() {
            return this.f6415a;
        }

        public float getLeavingPercent() {
            return this.f6419f;
        }

        public float getLoad() {
            return this.e;
        }

        public float getMaxVehicleCharge() {
            return this.f6417c;
        }

        public float getVehicleCharge() {
            return this.f6418d;
        }

        public int getWaypointsArrivingPercent() {
            return this.f6423j;
        }

        public void setArrivingPercent(float f2) {
            this.f6420g = f2;
        }

        public void setCustomChargingArguments(String str) {
            this.f6422i = str;
        }

        public void setCustomCostMode(CustomCostMode customCostMode) {
            this.f6416b = customCostMode;
        }

        public void setDestinationArrivingPercent(float f2) {
            this.f6421h = f2;
        }

        public void setKey(String str) {
            this.f6415a = str;
        }

        public void setLeavingPercent(float f2) {
            this.f6419f = f2;
        }

        public void setLoad(float f2) {
            this.e = f2;
        }

        public void setMaxVehicleCharge(float f2) {
            this.f6417c = f2;
        }

        public void setVehicleCharge(float f2) {
            this.f6418d = f2;
        }

        public void setWaypointsArrivingPercent(int i3) {
            this.f6423j = i3;
        }
    }

    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i3);
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResultV2 busRouteResultV2, int i3);

        void onDriveRouteSearched(DriveRouteResultV2 driveRouteResultV2, int i3);

        void onRideRouteSearched(RideRouteResultV2 rideRouteResultV2, int i3);

        void onWalkRouteSearched(WalkRouteResultV2 walkRouteResultV2, int i3);
    }

    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i3);
    }

    public static class PowerTrainLoss {

        /* renamed from: a, reason: collision with root package name */
        private int f6424a;

        /* renamed from: b, reason: collision with root package name */
        private float f6425b;

        /* renamed from: c, reason: collision with root package name */
        private int f6426c;

        /* renamed from: d, reason: collision with root package name */
        private int f6427d;

        public int getPowerDemand() {
            return this.f6424a;
        }

        public float getPowerDemandValue() {
            return this.f6425b;
        }

        public int getSpeed() {
            return this.f6426c;
        }

        public int getSpeedValue() {
            return this.f6427d;
        }

        public void setPowerDemand(int i3) {
            this.f6424a = i3;
        }

        public void setPowerDemandValue(float f2) {
            this.f6425b = f2;
        }

        public void setSpeed(int i3) {
            this.f6426c = i3;
        }

        public void setSpeedValue(int i3) {
            this.f6427d = i3;
        }
    }

    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f6428a;

        /* renamed from: b, reason: collision with root package name */
        private int f6429b;

        /* renamed from: c, reason: collision with root package name */
        private int f6430c;

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

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f6429b = 1;
            this.f6430c = 1;
            this.f6428a = fromAndTo;
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
            FromAndTo fromAndTo = this.f6428a;
            if (fromAndTo == null) {
                if (rideRouteQuery.f6428a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(rideRouteQuery.f6428a)) {
                return false;
            }
            return this.f6429b == rideRouteQuery.f6429b && this.f6430c == rideRouteQuery.f6430c;
        }

        public int getAlternativeRoute() {
            return this.f6430c;
        }

        public FromAndTo getFromAndTo() {
            return this.f6428a;
        }

        public int getShowFields() {
            return this.f6429b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f6428a;
            return (((((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f6429b) * 31) + this.f6430c;
        }

        public void setAlternativeRoute(int i3) {
            this.f6430c = i3;
        }

        public void setShowFields(int i3) {
            this.f6429b = i3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6428a, i3);
            parcel.writeInt(this.f6430c);
            parcel.writeInt(this.f6429b);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public RideRouteQuery m38clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearchV2", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f6428a);
            rideRouteQuery.setShowFields(this.f6429b);
            rideRouteQuery.setAlternativeRoute(this.f6430c);
            return rideRouteQuery;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f6429b = 1;
            this.f6430c = 1;
            this.f6428a = (FromAndTo) parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
            this.f6430c = parcel.readInt();
            this.f6429b = parcel.readInt();
        }

        public RideRouteQuery() {
            this.f6429b = 1;
            this.f6430c = 1;
        }
    }

    public static class ShowFields {
        public static final int ALL = -1;
        public static final int CHARGE_STATION_INFO = 64;
        public static final int CITIES = 8;
        public static final int COST = 1;
        public static final int ELEC_COSUME_INFO = 32;
        public static final int NAVI = 4;
        public static final int POLINE = 16;
        public static final int TMCS = 2;
    }

    public static class SlopeCost {

        /* renamed from: a, reason: collision with root package name */
        private float f6431a;

        /* renamed from: b, reason: collision with root package name */
        private float f6432b;

        public float getDown() {
            return this.f6432b;
        }

        public float getUp() {
            return this.f6431a;
        }

        public void setDown(float f2) {
            this.f6432b = f2;
        }

        public void setUp(float f2) {
            this.f6431a = f2;
        }
    }

    public static class SpeedCost {

        /* renamed from: a, reason: collision with root package name */
        private int f6433a;

        /* renamed from: b, reason: collision with root package name */
        private float f6434b;

        public int getSpeed() {
            return this.f6433a;
        }

        public float getValue() {
            return this.f6434b;
        }

        public void setSpeed(int i3) {
            this.f6433a = i3;
        }

        public void setValue(float f2) {
            this.f6434b = f2;
        }
    }

    public static class TransCost {

        /* renamed from: a, reason: collision with root package name */
        private float f6435a;

        /* renamed from: b, reason: collision with root package name */
        private float f6436b;

        public float getAccess() {
            return this.f6435a;
        }

        public float getDecess() {
            return this.f6436b;
        }

        public void setAccess(float f2) {
            this.f6435a = f2;
        }

        public void setDecess(float f2) {
            this.f6436b = f2;
        }
    }

    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f6437a;

        /* renamed from: b, reason: collision with root package name */
        private int f6438b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f6439c;

        /* renamed from: d, reason: collision with root package name */
        private int f6440d;

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

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f6438b = 1;
            this.f6439c = false;
            this.f6440d = 1;
            this.f6437a = fromAndTo;
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
            if (this.f6438b == walkRouteQuery.f6438b && this.f6439c == walkRouteQuery.f6439c && this.f6440d == walkRouteQuery.f6440d) {
                return this.f6437a.equals(walkRouteQuery.f6437a);
            }
            return false;
        }

        public int getAlternativeRoute() {
            return this.f6440d;
        }

        public FromAndTo getFromAndTo() {
            return this.f6437a;
        }

        public int getShowFields() {
            return this.f6438b;
        }

        public int hashCode() {
            return (((((this.f6437a.hashCode() * 31) + this.f6438b) * 31) + (this.f6439c ? 1 : 0)) * 31) + this.f6440d;
        }

        public boolean isIndoor() {
            return this.f6439c;
        }

        public void setAlternativeRoute(int i3) {
            this.f6440d = i3;
        }

        public void setIndoor(boolean z5) {
            this.f6439c = z5;
        }

        public void setShowFields(int i3) {
            this.f6438b = i3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable(this.f6437a, i3);
            parcel.writeBooleanArray(new boolean[]{this.f6439c});
            parcel.writeInt(this.f6440d);
            parcel.writeInt(this.f6438b);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WalkRouteQuery m39clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "RouteSearchV2", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f6437a);
            walkRouteQuery.setShowFields(this.f6438b);
            walkRouteQuery.setIndoor(this.f6439c);
            walkRouteQuery.setAlternativeRoute(this.f6440d);
            return walkRouteQuery;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f6438b = 1;
            this.f6439c = false;
            this.f6440d = 1;
            this.f6437a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            this.f6439c = zArr[0];
            this.f6440d = parcel.readInt();
            this.f6438b = parcel.readInt();
        }

        public WalkRouteQuery() {
            this.f6438b = 1;
            this.f6439c = false;
            this.f6440d = 1;
        }
    }

    public RouteSearchV2(Context context) throws AMapException {
        if (this.f6375a == null) {
            try {
                this.f6375a = new p8(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public BusRouteResultV2 calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f6375a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f6375a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRouteResultV2 calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f6375a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f6375a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResultV2 calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f6375a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f6375a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public WalkRouteResultV2 calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f6375a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f6375a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearchV2 iRouteSearchV2 = this.f6375a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
