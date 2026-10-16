package com.amap.api.col.p0003sl;

import android.os.Bundle;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.Utils;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static long f3794a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.amap.api.fence.DistrictItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.amap.api.col.3sl.c] */
    /* JADX WARN: Type inference failed for: r35v0, types: [java.util.List, java.util.List<com.amap.api.fence.GeoFence>] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.List] */
    public int a(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        ArrayList arrayList;
        String str2;
        int i3;
        String str3;
        String str4;
        float f2;
        long j4;
        float f10;
        long j10;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i10 = 0;
            int optInt = jSONObject.optInt(FileDownloadModel.STATUS, 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
            String string2 = bundle.getString("pendingIntentAction");
            float f11 = bundle.getFloat("fenceRadius");
            long j11 = bundle.getLong("expiration");
            int i11 = 1;
            int i12 = bundle.getInt("activatesAction", 1);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("districts")) != null) {
                int i13 = 0;
                while (i13 < optJSONArray.length()) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    GeoFence geoFence = new GeoFence();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i13);
                    String optString = jSONObject2.optString(Const.JSON_KEY_CITYCODE);
                    int i14 = i10;
                    String optString2 = jSONObject2.optString(Const.JSON_KEY_ADCODE);
                    int i15 = i11;
                    String optString3 = jSONObject2.optString("name");
                    JSONArray jSONArray = optJSONArray;
                    String string3 = jSONObject2.getString("center");
                    int i16 = i13;
                    DPoint dPoint = new DPoint();
                    int i17 = optInt2;
                    if (string3 != null) {
                        String[] split = string3.split(Const.STR_MART_COMMA);
                        arrayList = arrayList2;
                        str2 = optString3;
                        dPoint.setLatitude(Double.parseDouble(split[i15]));
                        dPoint.setLongitude(Double.parseDouble(split[i14]));
                        geoFence.setCenter(dPoint);
                    } else {
                        arrayList = arrayList2;
                        str2 = optString3;
                    }
                    geoFence.setCustomId(string);
                    geoFence.setPendingIntentAction(string2);
                    geoFence.setType(3);
                    geoFence.setRadius(f11);
                    geoFence.setExpiration(j11);
                    geoFence.setActivatesAction(i12);
                    geoFence.setFenceId("" + a());
                    String optString4 = jSONObject2.optString("polyline");
                    if (optString4 != null) {
                        String[] split2 = optString4.split("\\|");
                        int length = split2.length;
                        float f12 = Float.MIN_VALUE;
                        float f13 = Float.MAX_VALUE;
                        i3 = i12;
                        int i18 = i14;
                        while (i18 < length) {
                            int i19 = i18;
                            String str5 = split2[i19];
                            String[] strArr = split2;
                            ?? districtItem = new DistrictItem();
                            String str6 = string;
                            ?? arrayList4 = new ArrayList();
                            districtItem.setCitycode(optString);
                            districtItem.setAdcode(optString2);
                            String str7 = optString2;
                            String str8 = str2;
                            districtItem.setDistrictName(str8);
                            str2 = str8;
                            String[] split3 = str5.split(Const.STR_MART_SEMICOLON);
                            int i20 = i14;
                            String str9 = string2;
                            while (i20 < split3.length) {
                                String[] split4 = split3[i20].split(Const.STR_MART_COMMA);
                                String[] strArr2 = split3;
                                int i21 = i20;
                                int i22 = i15;
                                if (split4.length <= i22) {
                                    f10 = f11;
                                    j10 = j11;
                                } else {
                                    f10 = f11;
                                    j10 = j11;
                                    arrayList4.add(new DPoint(Double.parseDouble(split4[i22]), Double.parseDouble(split4[i14])));
                                }
                                i20 = i21 + 1;
                                split3 = strArr2;
                                f11 = f10;
                                j11 = j10;
                                i15 = 1;
                            }
                            float f14 = f11;
                            long j12 = j11;
                            if (arrayList4.size() > 100.0f) {
                                try {
                                    arrayList4 = a(arrayList4, 100.0f);
                                } catch (Throwable unused) {
                                    return 5;
                                }
                            }
                            arrayList3.add(arrayList4);
                            districtItem.setPolyline(arrayList4);
                            ArrayList arrayList5 = arrayList;
                            arrayList5.add(districtItem);
                            f12 = Math.max(f12, a.a(dPoint, (List<DPoint>) arrayList4));
                            f13 = Math.min(f13, a.b(dPoint, (List<DPoint>) arrayList4));
                            i18 = i19 + 1;
                            arrayList = arrayList5;
                            split2 = strArr;
                            string = str6;
                            optString2 = str7;
                            string2 = str9;
                            f11 = f14;
                            j11 = j12;
                            i15 = 1;
                        }
                        str3 = string;
                        str4 = string2;
                        f2 = f11;
                        j4 = j11;
                        geoFence.setMaxDis2Center(f12);
                        geoFence.setMinDis2Center(f13);
                        geoFence.setDistrictItemList(arrayList);
                        geoFence.setPointList(arrayList3);
                        list.add(geoFence);
                    } else {
                        i3 = i12;
                        str3 = string;
                        str4 = string2;
                        f2 = f11;
                        j4 = j11;
                    }
                    i13 = i16 + 1;
                    i10 = i14;
                    optJSONArray = jSONArray;
                    optInt2 = i17;
                    i12 = i3;
                    string = str3;
                    string2 = str4;
                    f11 = f2;
                    j11 = j4;
                    i11 = 1;
                }
            }
            return optInt2;
        } catch (Throwable unused2) {
            return 5;
        }
    }

    public int b(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        int i3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            char c9 = 0;
            int optInt = jSONObject.optInt(FileDownloadModel.STATUS, 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("pois")) != null) {
                int i10 = 0;
                while (i10 < optJSONArray.length()) {
                    GeoFence geoFence = new GeoFence();
                    PoiItem poiItem = new PoiItem();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i10);
                    poiItem.setPoiId(jSONObject2.optString("id"));
                    poiItem.setPoiName(jSONObject2.optString("name"));
                    poiItem.setPoiType(jSONObject2.optString("type"));
                    poiItem.setTypeCode(jSONObject2.optString("typecode"));
                    poiItem.setAddress(jSONObject2.optString(Const.JSON_KEY_ADDRESS));
                    String optString = jSONObject2.optString("location");
                    if (optString != null) {
                        String[] split = optString.split(Const.STR_MART_COMMA);
                        poiItem.setLongitude(Double.parseDouble(split[c9]));
                        poiItem.setLatitude(Double.parseDouble(split[1]));
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        i3 = optInt2;
                        DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                        arrayList2.add(dPoint);
                        arrayList.add(arrayList2);
                        geoFence.setPointList(arrayList);
                        geoFence.setCenter(dPoint);
                    } else {
                        i3 = optInt2;
                    }
                    poiItem.setTel(jSONObject2.optString("tel"));
                    poiItem.setProvince(jSONObject2.optString("pname"));
                    poiItem.setCity(jSONObject2.optString("cityname"));
                    poiItem.setAdname(jSONObject2.optString("adname"));
                    geoFence.setPoiItem(poiItem);
                    geoFence.setFenceId("" + a());
                    if (bundle != null) {
                        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
                        geoFence.setPendingIntentAction(bundle.getString("pendingIntentAction"));
                        geoFence.setType(2);
                        geoFence.setRadius(bundle.getFloat("fenceRadius"));
                        geoFence.setExpiration(bundle.getLong("expiration"));
                        geoFence.setActivatesAction(bundle.getInt("activatesAction", 1));
                    }
                    if (list != null) {
                        list.add(geoFence);
                    }
                    i10++;
                    optInt2 = i3;
                    c9 = 0;
                }
            }
            return optInt2;
        } catch (Throwable unused) {
            return 5;
        }
    }

    public static synchronized long a() {
        long j4;
        synchronized (c.class) {
            try {
                long timeBoot = Utils.getTimeBoot();
                long j10 = f3794a;
                if (timeBoot > j10) {
                    f3794a = timeBoot;
                } else {
                    f3794a = j10 + 1;
                }
                j4 = f3794a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j4;
    }

    public List<DPoint> a(List<DPoint> list, float f2) {
        double longitude;
        double latitude;
        if (list == null) {
            return null;
        }
        if (list.size() <= 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        DPoint dPoint = list.get(0);
        int i10 = 1;
        DPoint dPoint2 = list.get(list.size() - 1);
        double d5 = 0.0d;
        int i11 = 0;
        int i12 = 1;
        double d8 = 0.0d;
        while (i12 < list.size() - i10) {
            DPoint dPoint3 = list.get(i12);
            double longitude2 = dPoint3.getLongitude() - dPoint.getLongitude();
            double latitude2 = dPoint3.getLatitude() - dPoint.getLatitude();
            double longitude3 = dPoint2.getLongitude() - dPoint.getLongitude();
            double latitude3 = dPoint2.getLatitude() - dPoint.getLatitude();
            double d10 = ((latitude2 * latitude3) + (longitude2 * longitude3)) / ((latitude3 * latitude3) + (longitude3 * longitude3));
            int i13 = (dPoint.getLongitude() == dPoint2.getLongitude() && dPoint.getLatitude() == dPoint2.getLatitude()) ? i10 : i3;
            if (d10 < d5 || i13 != 0) {
                longitude = dPoint.getLongitude();
                latitude = dPoint.getLatitude();
            } else if (d10 > 1.0d) {
                longitude = dPoint2.getLongitude();
                latitude = dPoint2.getLatitude();
            } else {
                longitude = (longitude3 * d10) + dPoint.getLongitude();
                latitude = (d10 * latitude3) + dPoint.getLatitude();
            }
            int i14 = i10;
            double d11 = longitude;
            DPoint dPoint4 = dPoint;
            double d12 = latitude;
            int i15 = i12;
            double d13 = d8;
            double dist = Utils.dist(new DPoint(dPoint3.getLatitude(), dPoint3.getLongitude()), new DPoint(d12, d11));
            if (dist > d13) {
                i11 = i15;
            } else {
                dist = d13;
            }
            i12 = i15 + 1;
            dPoint = dPoint4;
            d8 = dist;
            i10 = i14;
            i3 = 0;
            d5 = 0.0d;
        }
        DPoint dPoint5 = dPoint;
        if (d8 < f2) {
            arrayList.add(dPoint5);
            arrayList.add(dPoint2);
            return arrayList;
        }
        List<DPoint> a3 = a(list.subList(0, i11 + 1), f2);
        List<DPoint> a10 = a(list.subList(i11, list.size()), f2);
        arrayList.addAll(a3);
        arrayList.remove(arrayList.size() - 1);
        arrayList.addAll(a10);
        return arrayList;
    }
}
