package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AMapLocation extends Location implements Cloneable, Parcelable {
    public static final String COORD_TYPE_GCJ02 = "GCJ02";
    public static final String COORD_TYPE_WGS84 = "WGS84";
    public static final Parcelable.Creator<AMapLocation> CREATOR = new a();
    public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_COARSE_LOCATION = 20;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
    public static final int ERROR_CODE_NO_COMPENSATION_CACHE = 33;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final String LBS_REAL_LOCATION_TYPE = "realLocationType";
    public static final int LOCATION_COMPENSATION = 10;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_COARSE_LOCATION = 11;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
    public static final int LOCATION_TYPE_NETWORK = 12;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    public static final int TRUSTED_LEVEL_BAD = 4;
    public static final int TRUSTED_LEVEL_HIGH = 1;
    public static final int TRUSTED_LEVEL_LOW = 3;
    public static final int TRUSTED_LEVEL_NORMAL = 2;
    private int A;
    private boolean B;
    private String C;
    private boolean D;
    private int E;
    private String F;
    private int G;
    private int H;
    private int I;
    private int J;
    private long K;
    private long L;
    private String M;
    private int N;
    private boolean O;
    private int P;
    private int Q;
    private String R;
    private boolean S;
    private boolean T;
    private int U;
    private String V;
    private HashMap<String, Object> W;
    private boolean X;
    private String Y;
    private float Z;

    /* renamed from: a, reason: collision with root package name */
    private String f5607a;

    /* renamed from: a0, reason: collision with root package name */
    private float f5608a0;

    /* renamed from: b, reason: collision with root package name */
    private String f5609b;

    /* renamed from: b0, reason: collision with root package name */
    private float f5610b0;

    /* renamed from: c, reason: collision with root package name */
    private String f5611c;

    /* renamed from: c0, reason: collision with root package name */
    AMapLocationQualityReport f5612c0;

    /* renamed from: d, reason: collision with root package name */
    private String f5613d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f5614f;
    protected String floor;

    /* renamed from: g, reason: collision with root package name */
    private String f5615g;

    /* renamed from: h, reason: collision with root package name */
    private String f5616h;

    /* renamed from: i, reason: collision with root package name */
    private String f5617i;

    /* renamed from: j, reason: collision with root package name */
    private String f5618j;

    /* renamed from: k, reason: collision with root package name */
    private String f5619k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5620l;

    /* renamed from: m, reason: collision with root package name */
    private int f5621m;
    protected String mPoiid;

    /* renamed from: n, reason: collision with root package name */
    private String f5622n;

    /* renamed from: o, reason: collision with root package name */
    private String f5623o;

    /* renamed from: p, reason: collision with root package name */
    private int f5624p;

    /* renamed from: q, reason: collision with root package name */
    private double f5625q;
    private double r;

    /* renamed from: s, reason: collision with root package name */
    private double f5626s;

    /* renamed from: t, reason: collision with root package name */
    private float f5627t;

    /* renamed from: u, reason: collision with root package name */
    private float f5628u;

    /* renamed from: v, reason: collision with root package name */
    private Bundle f5629v;

    /* renamed from: w, reason: collision with root package name */
    private String f5630w;

    /* renamed from: x, reason: collision with root package name */
    private int f5631x;

    /* renamed from: y, reason: collision with root package name */
    private String f5632y;

    /* renamed from: z, reason: collision with root package name */
    private String f5633z;

    public static class a implements Parcelable.Creator<AMapLocation> {
        @Override // android.os.Parcelable.Creator
        public AMapLocation createFromParcel(Parcel parcel) {
            AMapLocation aMapLocation = new AMapLocation((Location) Location.CREATOR.createFromParcel(parcel));
            aMapLocation.e = parcel.readString();
            aMapLocation.f5614f = parcel.readString();
            aMapLocation.f5632y = parcel.readString();
            aMapLocation.mPoiid = parcel.readString();
            aMapLocation.f5609b = parcel.readString();
            aMapLocation.f5613d = parcel.readString();
            aMapLocation.f5616h = parcel.readString();
            aMapLocation.f5611c = parcel.readString();
            aMapLocation.f5621m = parcel.readInt();
            aMapLocation.f5622n = parcel.readString();
            aMapLocation.floor = parcel.readString();
            aMapLocation.f5633z = parcel.readString();
            aMapLocation.D = parcel.readInt() != 0;
            aMapLocation.f5620l = parcel.readInt() != 0;
            aMapLocation.f5625q = parcel.readDouble();
            aMapLocation.f5623o = parcel.readString();
            aMapLocation.f5624p = parcel.readInt();
            aMapLocation.r = parcel.readDouble();
            aMapLocation.B = parcel.readInt() != 0;
            aMapLocation.f5619k = parcel.readString();
            aMapLocation.f5615g = parcel.readString();
            aMapLocation.f5607a = parcel.readString();
            aMapLocation.f5617i = parcel.readString();
            aMapLocation.f5631x = parcel.readInt();
            aMapLocation.A = parcel.readInt();
            aMapLocation.f5618j = parcel.readString();
            aMapLocation.C = parcel.readString();
            aMapLocation.F = parcel.readString();
            aMapLocation.E = parcel.readInt();
            aMapLocation.G = parcel.readInt();
            aMapLocation.H = parcel.readInt();
            aMapLocation.I = parcel.readInt();
            aMapLocation.J = parcel.readInt();
            aMapLocation.K = parcel.readLong();
            aMapLocation.L = parcel.readLong();
            aMapLocation.M = parcel.readString();
            aMapLocation.Y = parcel.readString();
            aMapLocation.X = parcel.readInt() != 0;
            aMapLocation.N = parcel.readInt();
            aMapLocation.O = parcel.readInt() != 0;
            aMapLocation.P = parcel.readInt();
            aMapLocation.Q = parcel.readInt();
            aMapLocation.R = parcel.readString();
            aMapLocation.S = parcel.readInt() != 0;
            aMapLocation.T = parcel.readInt() != 0;
            aMapLocation.U = parcel.readInt();
            aMapLocation.V = parcel.readString();
            return aMapLocation;
        }

        @Override // android.os.Parcelable.Creator
        public AMapLocation[] newArray(int i3) {
            return new AMapLocation[i3];
        }
    }

    public AMapLocation(String str) {
        super(str);
        this.f5607a = "";
        this.f5609b = "";
        this.f5611c = "";
        this.f5613d = "";
        this.e = "";
        this.f5614f = "";
        this.f5615g = "";
        this.f5616h = "";
        this.f5617i = "";
        this.f5618j = "";
        this.f5619k = "";
        this.f5620l = true;
        this.f5621m = 0;
        this.f5622n = "success";
        this.f5623o = "";
        this.f5624p = 0;
        this.f5625q = 0.0d;
        this.r = 0.0d;
        this.f5626s = 0.0d;
        this.f5627t = 0.0f;
        this.f5628u = 0.0f;
        this.f5629v = null;
        this.f5631x = 0;
        this.f5632y = "";
        this.mPoiid = "";
        this.floor = "";
        this.f5633z = "";
        this.A = -1;
        this.B = false;
        this.C = "";
        this.D = false;
        this.E = -1;
        this.F = "GCJ02";
        this.G = 1;
        this.P = -1;
        this.Q = -1;
        this.X = false;
        this.Y = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.f5612c0 = new AMapLocationQualityReport();
        this.f5630w = str;
    }

    public synchronized void clearOptAttrs() {
        try {
            HashMap<String, Object> hashMap = this.W;
            if (hashMap != null) {
                hashMap.clear();
            }
        } catch (Exception unused) {
        }
    }

    public synchronized HashMap<String, Object> cloneOptAttrs() {
        HashMap<String, Object> hashMap;
        hashMap = this.W;
        return (hashMap == null || hashMap.size() <= 0) ? null : new HashMap<>(this.W);
    }

    @Override // android.location.Location, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.e;
    }

    public String getAddress() {
        return this.f5614f;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return this.f5626s;
    }

    public String getAoiName() {
        return this.f5632y;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.f5628u;
    }

    @Override // android.location.Location
    public float getBearingAccuracyDegrees() {
        return this.f5610b0;
    }

    public String getBuildingId() {
        return this.mPoiid;
    }

    public String getCity() {
        return this.f5609b;
    }

    public String getCityCode() {
        return this.f5613d;
    }

    public int getConScenario() {
        return this.H;
    }

    public int getCoord() {
        return this.E;
    }

    public String getCoordType() {
        return this.F;
    }

    public String getCountry() {
        return this.f5616h;
    }

    public String getDescription() {
        return this.C;
    }

    public int getDiagnosisType() {
        return this.N;
    }

    public String getDistrict() {
        return this.f5611c;
    }

    public int getErrorCode() {
        return this.f5621m;
    }

    public String getErrorInfo() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f5622n);
        if (this.f5621m != 0) {
            sb2.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            sb2.append(",错误详细信息:" + this.f5623o);
        }
        return sb2.toString();
    }

    @Override // android.location.Location
    public Bundle getExtras() {
        return this.f5629v;
    }

    public String getFloor() {
        return this.floor;
    }

    public String getFloorName() {
        return this.f5633z;
    }

    public String getGeoLanguage() {
        return this.Y;
    }

    public int getGpsAccuracyStatus() {
        return this.A;
    }

    public int getIod() {
        return this.P;
    }

    public int getIodConfidence() {
        return this.Q;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.f5625q;
    }

    public String getLocationDetail() {
        return this.f5623o;
    }

    public AMapLocationQualityReport getLocationQualityReport() {
        return this.f5612c0;
    }

    public long getLocationTickTime() {
        return this.L;
    }

    public int getLocationType() {
        return this.f5624p;
    }

    public long getLocationUtcTime() {
        return this.K;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.r;
    }

    public synchronized Object getOptAttr(String str) {
        HashMap<String, Object> hashMap = this.W;
        if (hashMap != null && hashMap.get(str) != null) {
            try {
                return this.W.get(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public synchronized boolean getOptAttrBoolean(String str, boolean z5) {
        if (has(str)) {
            try {
                Object obj = this.W.get(str);
                if (obj != null) {
                    return Boolean.parseBoolean(obj.toString());
                }
            } catch (Exception unused) {
            }
        }
        return z5;
    }

    public synchronized double getOptAttrDouble(String str, double d5) {
        if (has(str)) {
            try {
                Object obj = this.W.get(str);
                if (obj != null) {
                    return Double.parseDouble(obj.toString());
                }
            } catch (Exception unused) {
            }
        }
        return d5;
    }

    public synchronized float getOptAttrFloat(String str, float f2) {
        if (has(str)) {
            try {
                Object obj = this.W.get(str);
                if (obj != null) {
                    return Float.parseFloat(obj.toString());
                }
            } catch (Exception unused) {
            }
        }
        return f2;
    }

    public synchronized int getOptAttrInt(String str, int i3) {
        if (has(str)) {
            try {
                Object obj = this.W.get(str);
                if (obj != null) {
                    return Integer.parseInt(obj.toString());
                }
            } catch (Exception unused) {
            }
        }
        return i3;
    }

    public synchronized long getOptAttrLong(String str, long j4) {
        if (has(str)) {
            try {
                Object obj = this.W.get(str);
                if (obj != null) {
                    return Long.parseLong(obj.toString());
                }
            } catch (Exception unused) {
            }
        }
        return j4;
    }

    public synchronized String getOptAttrString(String str, String str2) {
        if (has(str)) {
            try {
                return (String) this.W.get(str);
            } catch (Exception unused) {
            }
        }
        return str2;
    }

    public String getOptContent() {
        return this.V;
    }

    public String getPoiName() {
        return this.f5615g;
    }

    public int getPriority() {
        return this.U;
    }

    @Override // android.location.Location
    public String getProvider() {
        return this.f5630w;
    }

    public String getProvince() {
        return this.f5607a;
    }

    public String getRoad() {
        return this.f5617i;
    }

    public int getSatellites() {
        return this.f5631x;
    }

    public String getSemantics() {
        return this.R;
    }

    public String getSource() {
        return this.M;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.f5627t;
    }

    @Override // android.location.Location
    public float getSpeedAccuracyMetersPerSecond() {
        return this.f5608a0;
    }

    public String getStreet() {
        return this.f5618j;
    }

    public String getStreetNum() {
        return this.f5619k;
    }

    public int getSubType() {
        return this.J;
    }

    public int getTrustedLevel() {
        return this.G;
    }

    public int getType() {
        return this.I;
    }

    @Override // android.location.Location
    public float getVerticalAccuracyMeters() {
        return this.Z;
    }

    public synchronized boolean has(String str) {
        boolean z5;
        HashMap<String, Object> hashMap = this.W;
        if (hashMap != null) {
            z5 = hashMap.get(str) != null;
        }
        return z5;
    }

    public boolean isCoorCanUseInMap() {
        return this.T;
    }

    public boolean isDim() {
        return this.O;
    }

    public boolean isFixLastLocation() {
        return this.D;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.B;
    }

    public boolean isOffset() {
        return this.f5620l;
    }

    public boolean isReversegeo() {
        return this.X;
    }

    public boolean isSpeedKmh() {
        return this.S;
    }

    public synchronized void putOptAttr(String str, Object obj) {
        try {
            if (this.W == null) {
                this.W = new HashMap<>();
            }
            this.W.put(str, obj);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void removeOptAttr(String str) {
        try {
            HashMap<String, Object> hashMap = this.W;
            if (hashMap != null) {
                hashMap.remove(str);
            }
        } catch (Exception unused) {
        }
    }

    public void setAMapErrorCode(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int amapErrorCode2OpenErrorCode = Utils.amapErrorCode2OpenErrorCode(str, i3);
        this.f5621m = amapErrorCode2OpenErrorCode;
        this.f5622n = Utils.getLocErrorInfo(amapErrorCode2OpenErrorCode);
    }

    public void setAdCode(String str) {
        this.e = str;
    }

    public void setAddress(String str) {
        this.f5614f = str;
    }

    @Override // android.location.Location
    public void setAltitude(double d5) {
        super.setAltitude(d5);
        this.f5626s = d5;
    }

    public void setAoiName(String str) {
        this.f5632y = str;
    }

    @Override // android.location.Location
    public void setBearing(float f2) {
        super.setBearing(f2);
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        while (f2 >= 360.0f) {
            f2 -= 360.0f;
        }
        this.f5628u = f2;
    }

    @Override // android.location.Location
    public void setBearingAccuracyDegrees(float f2) {
        this.f5610b0 = f2;
    }

    public void setBuildingId(String str) {
        this.mPoiid = str;
    }

    public void setCity(String str) {
        this.f5609b = str;
    }

    public void setCityCode(String str) {
        this.f5613d = str;
    }

    public void setConScenario(int i3) {
        this.H = i3;
    }

    public void setCoorCanUseInMap(boolean z5) {
        this.T = z5;
    }

    public void setCoord(int i3) {
        this.E = i3;
    }

    public void setCoordType(String str) {
        this.F = str;
    }

    public void setCountry(String str) {
        this.f5616h = str;
    }

    public void setDescription(String str) {
        this.C = str;
    }

    public void setDiagnosisType(int i3) {
        this.N = i3;
    }

    public void setDim(boolean z5) {
        this.O = z5;
    }

    public void setDistrict(String str) {
        this.f5611c = str;
    }

    public void setErrorCode(int i3) {
        if (this.f5621m != 0) {
            return;
        }
        this.f5622n = Utils.getLocErrorInfo(i3);
        this.f5621m = i3;
    }

    public void setErrorInfo(String str) {
        this.f5622n = str;
    }

    @Override // android.location.Location
    public void setExtras(Bundle bundle) {
        super.setExtras(bundle);
        this.f5629v = bundle == null ? null : new Bundle(bundle);
    }

    public void setFixLastLocation(boolean z5) {
        this.D = z5;
    }

    public void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.floor = str;
    }

    public void setFloorName(String str) {
        this.f5633z = str;
    }

    public void setGeoLanguage(String str) {
        this.Y = str;
    }

    public void setGpsAccuracyStatus(int i3) {
        this.A = i3;
    }

    public void setIod(int i3) {
        this.P = i3;
    }

    public void setIodConfidence(int i3) {
        this.Q = i3;
    }

    @Override // android.location.Location
    public void setLatitude(double d5) {
        this.f5625q = d5;
    }

    public void setLocationDetail(String str) {
        this.f5623o = str;
    }

    public void setLocationQualityReport(AMapLocationQualityReport aMapLocationQualityReport) {
        if (aMapLocationQualityReport == null) {
            return;
        }
        this.f5612c0 = aMapLocationQualityReport;
    }

    public void setLocationTickTime(long j4) {
        this.L = j4;
    }

    public void setLocationType(int i3) {
        this.f5624p = i3;
    }

    public void setLocationUtcTime(long j4) {
        this.K = j4;
    }

    @Override // android.location.Location
    public void setLongitude(double d5) {
        this.r = d5;
    }

    @Override // android.location.Location
    public void setMock(boolean z5) {
        this.B = z5;
    }

    public void setNumber(String str) {
        this.f5619k = str;
    }

    public void setOffset(boolean z5) {
        this.f5620l = z5;
    }

    public void setOptAttrs(HashMap<String, Object> hashMap) {
        this.W = hashMap;
    }

    public void setOptContent(String str) {
        this.V = str;
    }

    public void setPoiName(String str) {
        this.f5615g = str;
    }

    public void setPriority(int i3) {
        this.U = i3;
    }

    @Override // android.location.Location
    public void setProvider(String str) {
        super.setProvider(str);
        this.f5630w = str;
    }

    public void setProvince(String str) {
        this.f5607a = str;
    }

    public void setReversegeo(boolean z5) {
        this.X = z5;
    }

    public void setRoad(String str) {
        this.f5617i = str;
    }

    public void setSatellites(int i3) {
        this.f5631x = i3;
    }

    public void setSemantics(String str) {
        this.R = str;
    }

    public void setSource(String str) {
        this.M = str;
    }

    @Override // android.location.Location
    public void setSpeed(float f2) {
        super.setSpeed(f2);
        this.f5627t = f2;
    }

    @Override // android.location.Location
    public void setSpeedAccuracyMetersPerSecond(float f2) {
        this.f5608a0 = f2;
    }

    public void setSpeedKmh(boolean z5) {
        this.S = z5;
    }

    public void setStreet(String str) {
        this.f5618j = str;
    }

    public void setSubType(int i3) {
        this.J = i3;
    }

    public void setTrustedLevel(int i3) {
        this.G = i3;
    }

    public void setType(int i3) {
        this.I = i3;
    }

    @Override // android.location.Location
    public void setVerticalAccuracyMeters(float f2) {
        this.Z = f2;
    }

    public JSONObject toJson(int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i3 == 1) {
                try {
                    jSONObject.put("altitude", getAltitude());
                    jSONObject.put(Const.JSON_KEY_SPEED, getSpeed());
                    jSONObject.put(Const.JSON_KEY_BEARING, getBearing());
                } catch (Throwable unused) {
                }
                jSONObject.put(Const.JSON_KEY_CITYCODE, this.f5613d);
                jSONObject.put(Const.JSON_KEY_ADCODE, this.e);
                jSONObject.put("country", this.f5616h);
                jSONObject.put("province", this.f5607a);
                jSONObject.put("city", this.f5609b);
                jSONObject.put("district", this.f5611c);
                jSONObject.put(Const.JSON_KEY_ROAD, this.f5617i);
                jSONObject.put(Const.JSON_KEY_STREET, this.f5618j);
                jSONObject.put(Const.JSON_KEY_NUMBER, this.f5619k);
                jSONObject.put(Const.JSON_KEY_POINAME, this.f5615g);
                jSONObject.put("errorCode", this.f5621m);
                jSONObject.put("errorInfo", this.f5622n);
                jSONObject.put("locationType", this.f5624p);
                jSONObject.put(Const.JSON_KEY_LOCATIONDETAIL, this.f5623o);
                jSONObject.put(Const.JSON_KEY_AOINAME, this.f5632y);
                jSONObject.put(Const.JSON_KEY_ADDRESS, this.f5614f);
                jSONObject.put(Const.JSON_KEY_POIID, this.mPoiid);
                jSONObject.put(Const.JSON_KEY_FLOOR, this.floor);
                jSONObject.put("floorName", this.f5633z);
                jSONObject.put(SocialConstants.PARAM_COMMENT, this.C);
            } else if (i3 != 2) {
                if (i3 != 3) {
                    return jSONObject;
                }
                jSONObject.put(Const.JSON_KEY_PROVIDER, getProvider());
                jSONObject.put(Const.JSON_KEY_LON, getLongitude());
                jSONObject.put(Const.JSON_KEY_LAT, getLatitude());
                jSONObject.put(Const.JSON_KEY_ACCURACY, getAccuracy());
                jSONObject.put(Const.JSON_KEY_ISOFFSET, this.f5620l);
                jSONObject.put("isFixLastLocation", this.D);
                jSONObject.put(Const.JSON_KEY_COORD, this.E);
                jSONObject.put("coordType", this.F);
                return jSONObject;
            }
            jSONObject.put(Const.JSON_KEY_TIME, getTime());
            jSONObject.put(Const.JSON_KEY_PROVIDER, getProvider());
            jSONObject.put(Const.JSON_KEY_LON, getLongitude());
            jSONObject.put(Const.JSON_KEY_LAT, getLatitude());
            jSONObject.put(Const.JSON_KEY_ACCURACY, getAccuracy());
            jSONObject.put(Const.JSON_KEY_ISOFFSET, this.f5620l);
            jSONObject.put("isFixLastLocation", this.D);
            jSONObject.put(Const.JSON_KEY_COORD, this.E);
            jSONObject.put("coordType", this.F);
            return jSONObject;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AmapLoc", "toStr");
            return null;
        }
    }

    public String toStr() {
        return toStr(1);
    }

    @Override // android.location.Location
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.f5625q + Const.STR_MART_WELL);
            stringBuffer.append("longitude=" + this.r + Const.STR_MART_WELL);
            stringBuffer.append("province=" + this.f5607a + Const.STR_MART_WELL);
            stringBuffer.append("coord=" + this.E + Const.STR_MART_WELL);
            stringBuffer.append("coordType=" + this.F + Const.STR_MART_WELL);
            stringBuffer.append("city=" + this.f5609b + Const.STR_MART_WELL);
            stringBuffer.append("district=" + this.f5611c + Const.STR_MART_WELL);
            stringBuffer.append("cityCode=" + this.f5613d + Const.STR_MART_WELL);
            stringBuffer.append("adCode=" + this.e + Const.STR_MART_WELL);
            stringBuffer.append("address=" + this.f5614f + Const.STR_MART_WELL);
            stringBuffer.append("country=" + this.f5616h + Const.STR_MART_WELL);
            stringBuffer.append("road=" + this.f5617i + Const.STR_MART_WELL);
            stringBuffer.append("poiName=" + this.f5615g + Const.STR_MART_WELL);
            stringBuffer.append("street=" + this.f5618j + Const.STR_MART_WELL);
            stringBuffer.append("streetNum=" + this.f5619k + Const.STR_MART_WELL);
            stringBuffer.append("aoiName=" + this.f5632y + Const.STR_MART_WELL);
            stringBuffer.append("poiid=" + this.mPoiid + Const.STR_MART_WELL);
            stringBuffer.append("floor=" + this.floor + Const.STR_MART_WELL);
            stringBuffer.append("floorName=" + this.f5633z + Const.STR_MART_WELL);
            stringBuffer.append("errorCode=" + this.f5621m + Const.STR_MART_WELL);
            stringBuffer.append("errorInfo=" + this.f5622n + Const.STR_MART_WELL);
            stringBuffer.append("locationDetail=" + this.f5623o + Const.STR_MART_WELL);
            stringBuffer.append("description=" + this.C + Const.STR_MART_WELL);
            stringBuffer.append("locationType=" + this.f5624p + Const.STR_MART_WELL);
            StringBuilder sb2 = new StringBuilder("conScenario=");
            sb2.append(this.H);
            stringBuffer.append(sb2.toString());
            stringBuffer.append("mType=" + this.I);
            stringBuffer.append("mSubType=" + this.J);
            stringBuffer.append("mLocationUtcTime=" + this.K);
            stringBuffer.append("mLocationTickTime=" + this.L);
            stringBuffer.append("mSource=" + this.M);
            stringBuffer.append("isReversegeo=" + this.X);
            stringBuffer.append("geoLanguage=" + this.Y);
            stringBuffer.append("mDiagnosisType=" + this.N);
            stringBuffer.append("mDim=" + this.O);
            stringBuffer.append("mIod=" + this.P);
            stringBuffer.append("mIodConfidence=" + this.Q);
            stringBuffer.append("mSemantics=" + this.R);
            stringBuffer.append("mSpeedKmh=" + this.S);
            stringBuffer.append("mCoorCanUseInMap=" + this.T);
            stringBuffer.append("mPriority=" + this.U);
            stringBuffer.append("mOptContent=" + this.V);
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @Override // android.location.Location, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.e);
            parcel.writeString(this.f5614f);
            parcel.writeString(this.f5632y);
            parcel.writeString(this.mPoiid);
            parcel.writeString(this.f5609b);
            parcel.writeString(this.f5613d);
            parcel.writeString(this.f5616h);
            parcel.writeString(this.f5611c);
            parcel.writeInt(this.f5621m);
            parcel.writeString(this.f5622n);
            parcel.writeString(this.floor);
            parcel.writeString(this.f5633z);
            parcel.writeInt(this.D ? 1 : 0);
            parcel.writeInt(this.f5620l ? 1 : 0);
            parcel.writeDouble(this.f5625q);
            parcel.writeString(this.f5623o);
            parcel.writeInt(this.f5624p);
            parcel.writeDouble(this.r);
            parcel.writeInt(this.B ? 1 : 0);
            parcel.writeString(this.f5619k);
            parcel.writeString(this.f5615g);
            parcel.writeString(this.f5607a);
            parcel.writeString(this.f5617i);
            parcel.writeInt(this.f5631x);
            parcel.writeInt(this.A);
            parcel.writeString(this.f5618j);
            parcel.writeString(this.C);
            parcel.writeString(this.F);
            parcel.writeInt(this.E);
            parcel.writeInt(this.G);
            parcel.writeInt(this.H);
            parcel.writeInt(this.I);
            parcel.writeInt(this.J);
            parcel.writeLong(this.K);
            parcel.writeLong(this.L);
            parcel.writeString(this.M);
            parcel.writeString(this.Y);
            parcel.writeInt(this.X ? 1 : 0);
            parcel.writeInt(this.N);
            parcel.writeInt(this.O ? 1 : 0);
            parcel.writeInt(this.P);
            parcel.writeInt(this.Q);
            parcel.writeString(this.R);
            parcel.writeInt(this.S ? 1 : 0);
            parcel.writeInt(this.T ? 1 : 0);
            parcel.writeInt(this.U);
            parcel.writeString(this.V);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMapLocation", "writeToParcel");
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocation m2clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        AMapLocation aMapLocation = new AMapLocation(this);
        try {
            aMapLocation.setLatitude(this.f5625q);
            aMapLocation.setLongitude(this.r);
            aMapLocation.setAdCode(this.e);
            aMapLocation.setAddress(this.f5614f);
            aMapLocation.setAoiName(this.f5632y);
            aMapLocation.setBuildingId(this.mPoiid);
            aMapLocation.setCity(this.f5609b);
            aMapLocation.setCityCode(this.f5613d);
            aMapLocation.setCountry(this.f5616h);
            aMapLocation.setDistrict(this.f5611c);
            aMapLocation.setErrorCode(this.f5621m);
            aMapLocation.setErrorInfo(this.f5622n);
            aMapLocation.setFloor(this.floor);
            aMapLocation.setFloorName(this.f5633z);
            aMapLocation.setFixLastLocation(this.D);
            aMapLocation.setOffset(this.f5620l);
            aMapLocation.setLocationDetail(this.f5623o);
            aMapLocation.setLocationType(this.f5624p);
            aMapLocation.setMock(this.B);
            aMapLocation.setNumber(this.f5619k);
            aMapLocation.setPoiName(this.f5615g);
            aMapLocation.setProvince(this.f5607a);
            aMapLocation.setRoad(this.f5617i);
            aMapLocation.setSatellites(this.f5631x);
            aMapLocation.setGpsAccuracyStatus(this.A);
            aMapLocation.setStreet(this.f5618j);
            aMapLocation.setDescription(this.C);
            aMapLocation.setExtras(getExtras());
            AMapLocationQualityReport aMapLocationQualityReport = this.f5612c0;
            if (aMapLocationQualityReport != null) {
                aMapLocation.setLocationQualityReport(aMapLocationQualityReport.m4clone());
            }
            aMapLocation.setCoord(this.E);
            aMapLocation.setCoordType(this.F);
            aMapLocation.setTrustedLevel(this.G);
            aMapLocation.setConScenario(this.H);
            aMapLocation.setType(this.I);
            aMapLocation.setSubType(this.J);
            aMapLocation.setLocationUtcTime(this.K);
            aMapLocation.setLocationTickTime(this.L);
            aMapLocation.setSource(this.M);
            aMapLocation.setReversegeo(this.X);
            aMapLocation.setGeoLanguage(this.Y);
            aMapLocation.setDiagnosisType(this.N);
            aMapLocation.setDim(this.O);
            aMapLocation.setIod(this.P);
            aMapLocation.setIodConfidence(this.Q);
            aMapLocation.setSemantics(this.R);
            aMapLocation.setSpeedKmh(this.S);
            aMapLocation.setCoorCanUseInMap(this.T);
            aMapLocation.setPriority(this.U);
            aMapLocation.setOptContent(this.V);
            aMapLocation.setOptAttrs(cloneOptAttrs());
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMapLocation", "clone");
        }
        return aMapLocation;
    }

    public void setCoord(String str) {
        if (TextUtils.isEmpty(str)) {
            this.E = -1;
        } else if (str.equals("0")) {
            this.E = 0;
        } else if (str.equals("1")) {
            this.E = 1;
        } else {
            this.E = -1;
        }
        if (this.E == 0) {
            this.F = "WGS84";
        } else {
            this.F = "GCJ02";
        }
    }

    public String toStr(int i3) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i3);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public AMapLocation(Location location) {
        super(location);
        this.f5607a = "";
        this.f5609b = "";
        this.f5611c = "";
        this.f5613d = "";
        this.e = "";
        this.f5614f = "";
        this.f5615g = "";
        this.f5616h = "";
        this.f5617i = "";
        this.f5618j = "";
        this.f5619k = "";
        this.f5620l = true;
        this.f5621m = 0;
        this.f5622n = "success";
        this.f5623o = "";
        this.f5624p = 0;
        this.f5625q = 0.0d;
        this.r = 0.0d;
        this.f5626s = 0.0d;
        this.f5627t = 0.0f;
        this.f5628u = 0.0f;
        this.f5629v = null;
        this.f5631x = 0;
        this.f5632y = "";
        this.mPoiid = "";
        this.floor = "";
        this.f5633z = "";
        this.A = -1;
        this.B = false;
        this.C = "";
        this.D = false;
        this.E = -1;
        this.F = "GCJ02";
        this.G = 1;
        this.P = -1;
        this.Q = -1;
        this.X = false;
        this.Y = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.f5612c0 = new AMapLocationQualityReport();
        this.f5625q = location.getLatitude();
        this.r = location.getLongitude();
        this.f5626s = location.getAltitude();
        this.f5628u = location.getBearing();
        this.f5627t = location.getSpeed();
        this.f5630w = location.getProvider();
        this.f5629v = location.getExtras() != null ? new Bundle(location.getExtras()) : null;
    }
}
