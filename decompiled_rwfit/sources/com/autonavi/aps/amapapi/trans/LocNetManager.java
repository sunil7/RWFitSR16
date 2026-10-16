package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.e9;
import com.amap.api.col.p0003sl.g9;
import com.amap.api.col.p0003sl.i9;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.col.p0003sl.n9;
import com.amap.api.col.p0003sl.pb;
import com.amap.api.col.p0003sl.qb;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DTileBuildType;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.OffsetUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class LocNetManager {

    /* renamed from: f, reason: collision with root package name */
    private static LocNetManager f6768f;

    /* renamed from: a, reason: collision with root package name */
    ib f6769a;

    /* renamed from: b, reason: collision with root package name */
    private Context f6770b;

    /* renamed from: c, reason: collision with root package name */
    private int f6771c = CoreUtil.iTo;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6772d = false;
    private int e = 0;

    private LocNetManager(Context context) {
        this.f6769a = null;
        this.f6770b = null;
        try {
            i9.a().a(context);
        } catch (Throwable unused) {
        }
        this.f6770b = context;
        this.f6769a = ib.a();
    }

    public static LocNetManager getInstance(Context context) {
        if (f6768f == null) {
            f6768f = new LocNetManager(context);
        }
        return f6768f;
    }

    public LocationRequest createLocationRequest(Context context, byte[] bArr, String str, String str2, boolean z5) {
        try {
            HashMap hashMap = new HashMap(16);
            LocationRequest locationRequest = new LocationRequest(context, CoreUtil.getSDKInfo());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", CoreUtil.HTTP_HEADER_USER_AGENT);
                hashMap.put("KEY", b9.e(context));
                hashMap.put("enginever", CoreUtil.ENGINE_VERSION);
                String c9 = e9.c();
                String a3 = e9.a(context, c9, "key=" + b9.e(context));
                hashMap.put(Constants.TS, c9);
                hashMap.put("scode", a3);
                if (Double.valueOf(CoreUtil.ENGINE_VERSION).doubleValue() >= 5.3d) {
                    hashMap.put("aps_s_src", "openapi");
                }
                hashMap.put("encr", "1");
                locationRequest.setHead(hashMap);
                String str3 = !z5 ? CoreUtil.PRODUCT_FIRST_LOC : "loc";
                locationRequest.setLocRequest(true);
                Locale locale = Locale.US;
                locationRequest.setPlatinfo("platform=Android&sdkversion=11.1.060&product=" + str3 + "&loc_channel=3");
                locationRequest.setIsXinfo(z5);
                locationRequest.setUrl(str);
                locationRequest.setIPV6Url(str2);
                locationRequest.setEntity(Utils.gz(bArr));
                locationRequest.setProxy(e9.d(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put("policy", AMap3DTileBuildType.AIRPORT_TERMINAL);
                int i3 = this.e;
                if (i3 == 0) {
                    hashMap2.remove(AMap.CUSTOM);
                } else if (i3 == 1) {
                    hashMap2.put(AMap.CUSTOM, "language:cn");
                } else if (i3 != 2) {
                    hashMap2.remove(AMap.CUSTOM);
                } else {
                    hashMap2.put(AMap.CUSTOM, "language:en");
                }
                locationRequest.setParamsMap(hashMap2);
                locationRequest.setConnectionTimeout(this.f6771c);
                locationRequest.setSoTimeout(this.f6771c);
                if (!this.f6772d) {
                    return locationRequest;
                }
                locationRequest.setHttpProtocol(pb.c.HTTPS);
                return locationRequest;
            } catch (Throwable unused) {
                return locationRequest;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public int getTimeOut() {
        return this.f6771c;
    }

    public String postReGeo(Context context, double d5, double d8, boolean z5) {
        try {
            if (CoreUtil.isChina(d5, d8) && !z5) {
                DPoint offset = OffsetUtil.offset(context, new DPoint(d5, d8));
                double latitude = offset.getLatitude();
                double longitude = offset.getLongitude();
                d5 = latitude;
                d8 = longitude;
            }
            HashMap hashMap = new HashMap(16);
            LocationRequest locationRequest = new LocationRequest(context, CoreUtil.getSDKInfo());
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", CoreUtil.HTTP_HEADER_USER_AGENT);
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put(AMap.CUSTOM, "26260A1F00020002");
            hashMap2.put("key", b9.e(context));
            int i3 = this.e;
            if (i3 == 0) {
                hashMap2.remove("language");
            } else if (i3 == 1) {
                hashMap2.put("language", "zh-CN");
            } else if (i3 != 2) {
                hashMap2.remove("language");
            } else {
                hashMap2.put("language", "en");
            }
            hashMap2.put("curLocationType", Utils.isCoarsePermOpen(this.f6770b) ? "coarseLoc" : "fineLoc");
            String c9 = e9.c();
            String a3 = e9.a(context, c9, n9.a(hashMap2));
            hashMap2.put(Constants.TS, c9);
            hashMap2.put("scode", a3);
            locationRequest.setAesEntity(("output=json&radius=1000&extensions=all&location=" + d8 + Const.STR_MART_COMMA + d5).getBytes("UTF-8"));
            locationRequest.setLocRequest(false);
            locationRequest.setIsXinfo(true);
            Locale locale = Locale.US;
            locationRequest.setPlatinfo("platform=Android&sdkversion=11.1.060&product=loc&loc_channel=3");
            locationRequest.setParamsMap(hashMap2);
            locationRequest.setHead(hashMap);
            locationRequest.setProxy(e9.d(context));
            locationRequest.setConnectionTimeout(CoreUtil.iTo);
            locationRequest.setSoTimeout(CoreUtil.iTo);
            try {
                String str = ("http://" + g9.b(context).a(41)) + CoreUtil.URL_PATH_STR_REGEO_SERVER;
                locationRequest.setIPV6Url(CoreUtil.STR_REGEO_IPV6_SERVER);
                locationRequest.setUrl(str);
                if (this.f6772d) {
                    locationRequest.setHttpProtocol(pb.c.HTTPS);
                }
                return new String(this.f6769a.a(locationRequest).f4927a, "utf-8");
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "LocNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public qb req(LocationRequest locationRequest) throws Throwable {
        if (this.f6772d) {
            locationRequest.setHttpProtocol(pb.c.HTTPS);
        }
        return this.f6769a.a(locationRequest);
    }

    public void setOption(long j4, boolean z5, int i3) {
        try {
            this.f6772d = z5;
            this.f6771c = Long.valueOf(j4).intValue();
            this.e = i3;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "LocNetManager", "setOption");
        }
    }

    public qb req(LocationRequest locationRequest, int i3) throws Throwable {
        if (this.f6772d) {
            locationRequest.setHttpProtocol(pb.c.HTTPS);
        }
        return this.f6769a.a(locationRequest);
    }
}
