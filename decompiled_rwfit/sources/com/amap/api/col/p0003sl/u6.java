package com.amap.api.col.p0003sl;

import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.poisearch.SubPoiItemV2;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusPathV2;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.BusStepV2;
import com.amap.api.services.route.ChargeStationInfo;
import com.amap.api.services.route.Cost;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DrivePathV2;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.DriveStepV2;
import com.amap.api.services.route.ElecConsumeInfo;
import com.amap.api.services.route.Navi;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.TaxiItemV2;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class u6 {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f5144a = {Const.STR_CITY_CODE_BJ, Const.STR_CITY_CODE_SH, Const.STR_CITY_CODE_TJ, Const.STR_CITY_CODE_CQ, "1852", "1853"};

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> a(org.json.JSONObject r13, boolean r14) throws org.json.JSONException {
        /*
            java.lang.String r0 = "datas"
            org.json.JSONArray r13 = r13.optJSONArray(r0)
            if (r13 == 0) goto L81
            int r0 = r13.length()
            if (r0 != 0) goto L10
            goto L81
        L10:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r13.length()
            r2 = 0
            r3 = r2
        L1b:
            if (r3 >= r1) goto L80
            org.json.JSONObject r4 = r13.optJSONObject(r3)
            java.lang.String r5 = "userid"
            java.lang.String r5 = d(r4, r5)
            java.lang.String r6 = "location"
            java.lang.String r6 = d(r4, r6)
            if (r6 == 0) goto L47
            java.lang.String r7 = ","
            java.lang.String[] r6 = r6.split(r7)
            int r7 = r6.length
            r8 = 2
            if (r7 != r8) goto L47
            r7 = r6[r2]
            double r7 = k(r7)
            r9 = 1
            r6 = r6[r9]
            double r9 = k(r6)
            goto L4a
        L47:
            r7 = 0
            r9 = r7
        L4a:
            java.lang.String r6 = "distance"
            java.lang.String r6 = d(r4, r6)
            java.lang.String r11 = "updatetime"
            java.lang.String r4 = d(r4, r11)
            long r11 = n(r4)
            int r4 = m(r6)
            com.amap.api.services.core.LatLonPoint r6 = new com.amap.api.services.core.LatLonPoint
            r6.<init>(r9, r7)
            com.amap.api.services.nearby.NearbyInfo r7 = new com.amap.api.services.nearby.NearbyInfo
            r7.<init>()
            r7.setUserID(r5)
            r7.setTimeStamp(r11)
            r7.setPoint(r6)
            if (r14 == 0) goto L77
            r7.setDrivingDistance(r4)
            goto L7a
        L77:
            r7.setDistance(r4)
        L7a:
            r0.add(r7)
            int r3 = r3 + 1
            goto L1b
        L80:
            return r0
        L81:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.u6.a(org.json.JSONObject, boolean):java.util.ArrayList");
    }

    public static ArrayList<SuggestionCity> b(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray optJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (jSONObject.has("cities") && (optJSONArray = jSONObject.optJSONArray("cities")) != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    arrayList.add(new SuggestionCity(d(optJSONObject, "name"), d(optJSONObject, Const.JSON_KEY_CITYCODE), d(optJSONObject, Const.JSON_KEY_ADCODE), m(d(optJSONObject, "num"))));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<String> c(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
        }
        return arrayList;
    }

    public static PoiItem d(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        int i3;
        String str3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        String str4;
        String str5;
        String str6;
        String str7 = "id";
        String str8 = "location";
        String str9 = "name";
        PoiItem poiItem = new PoiItem(d(jSONObject, "id"), b(jSONObject, "location"), d(jSONObject, "name"), d(jSONObject, Const.JSON_KEY_ADDRESS));
        poiItem.setAdCode(d(jSONObject, Const.JSON_KEY_ADCODE));
        poiItem.setProvinceName(d(jSONObject, "pname"));
        poiItem.setCityName(d(jSONObject, "cityname"));
        poiItem.setAdName(d(jSONObject, "adname"));
        poiItem.setCityCode(d(jSONObject, Const.JSON_KEY_CITYCODE));
        poiItem.setProvinceCode(d(jSONObject, "pcode"));
        poiItem.setDirection(d(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String d5 = d(jSONObject, "distance");
            if (!a(d5)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(d5));
                } catch (NumberFormatException e) {
                    d6.a(e, "JSONHelper", "parseBasePoi");
                } catch (Exception e10) {
                    d6.a(e10, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(d(jSONObject, "tel"));
        poiItem.setTypeDes(d(jSONObject, "type"));
        poiItem.setEnter(b(jSONObject, "entr_location"));
        poiItem.setExit(b(jSONObject, "exit_location"));
        poiItem.setWebsite(d(jSONObject, "website"));
        poiItem.setPostcode(d(jSONObject, "postcode"));
        String d8 = d(jSONObject, "business_area");
        if (a(d8)) {
            d8 = d(jSONObject, "businessarea");
        }
        poiItem.setBusinessArea(d8);
        poiItem.setEmail(d(jSONObject, "email"));
        String d10 = d(jSONObject, "indoor_map");
        String str10 = "";
        if (d10 == null || d10.equals("") || d10.equals("0")) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(d(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray == null) {
                poiItem.setSubPois(arrayList);
            } else {
                int i10 = 0;
                while (i10 < optJSONArray.length()) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i10);
                    if (optJSONObject3 == null) {
                        str4 = str7;
                        str5 = str8;
                        str6 = str9;
                    } else {
                        str4 = str7;
                        str5 = str8;
                        str6 = str9;
                        SubPoiItem subPoiItem = new SubPoiItem(d(optJSONObject3, str7), b(optJSONObject3, str8), d(optJSONObject3, str9), d(optJSONObject3, Const.JSON_KEY_ADDRESS));
                        subPoiItem.setSubName(d(optJSONObject3, "sname"));
                        subPoiItem.setSubTypeDes(d(optJSONObject3, "subtype"));
                        if (optJSONObject3.has("distance")) {
                            String d11 = d(optJSONObject3, "distance");
                            if (!a(d11)) {
                                try {
                                    subPoiItem.setDistance((int) Float.parseFloat(d11));
                                } catch (NumberFormatException e11) {
                                    d6.a(e11, "JSONHelper", "parseSubPoiItem");
                                } catch (Exception e12) {
                                    d6.a(e12, "JSONHelper", "parseSubPoiItem");
                                }
                            }
                        }
                        arrayList.add(subPoiItem);
                    }
                    i10++;
                    str7 = str4;
                    str8 = str5;
                    str9 = str6;
                }
                poiItem.setSubPois(arrayList);
            }
        }
        if (jSONObject.has("indoor_data") && (optJSONObject2 = jSONObject.optJSONObject("indoor_data")) != null && optJSONObject2.has("cpid") && optJSONObject2.has(Const.JSON_KEY_FLOOR)) {
            str2 = d(optJSONObject2, "cpid");
            i3 = m(d(optJSONObject2, Const.JSON_KEY_FLOOR));
            str = d(optJSONObject2, "truefloor");
        } else {
            str = "";
            str2 = str;
            i3 = 0;
        }
        poiItem.setIndoorDate(new IndoorData(str2, i3, str));
        if (!jSONObject.has("biz_ext") || (optJSONObject = jSONObject.optJSONObject("biz_ext")) == null) {
            str3 = "";
        } else {
            str10 = d(optJSONObject, "open_time");
            str3 = d(optJSONObject, "rating");
        }
        poiItem.setPoiExtension(new PoiItemExtension(str10, str3));
        poiItem.setTypeCode(d(jSONObject, "typecode"));
        poiItem.setShopID(d(jSONObject, "shopid"));
        List<Photo> a3 = a(jSONObject.optJSONObject("deep_info"));
        if (((ArrayList) a3).size() == 0) {
            a3 = a(jSONObject);
        }
        poiItem.setPhotos(a3);
        return poiItem;
    }

    public static PoiItemV2 e(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        int i3;
        boolean z5;
        LatLonPoint latLonPoint;
        LatLonPoint latLonPoint2;
        String str13;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        PoiItemV2 poiItemV2 = new PoiItemV2(d(jSONObject, "id"), b(jSONObject, "location"), d(jSONObject, "name"), d(jSONObject, Const.JSON_KEY_ADDRESS));
        poiItemV2.setTypeDes(d(jSONObject, "type"));
        poiItemV2.setTypeCode(d(jSONObject, "typecode"));
        poiItemV2.setProvinceName(d(jSONObject, "pname"));
        poiItemV2.setCityName(d(jSONObject, "cityname"));
        poiItemV2.setAdName(d(jSONObject, "adname"));
        poiItemV2.setProvinceCode(d(jSONObject, "pcode"));
        poiItemV2.setAdCode(d(jSONObject, Const.JSON_KEY_ADCODE));
        poiItemV2.setCityCode(d(jSONObject, Const.JSON_KEY_CITYCODE));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray == null) {
                poiItemV2.setSubPois(arrayList);
            } else {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(i10);
                    if (optJSONObject4 != null) {
                        SubPoiItemV2 subPoiItemV2 = new SubPoiItemV2(d(optJSONObject4, "id"), b(optJSONObject4, "location"), d(optJSONObject4, "name"), d(optJSONObject4, Const.JSON_KEY_ADDRESS));
                        subPoiItemV2.setSubTypeDes(d(optJSONObject4, "subtype"));
                        subPoiItemV2.setTypeCode(d(optJSONObject4, "typecode"));
                        arrayList.add(subPoiItemV2);
                    }
                }
                poiItemV2.setSubPois(arrayList);
            }
        }
        String str14 = "";
        if (!jSONObject.has("business") || (optJSONObject3 = jSONObject.optJSONObject("business")) == null) {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
            str9 = str8;
            str10 = str9;
        } else {
            String d5 = d(optJSONObject3, "business_area");
            String d8 = d(optJSONObject3, "opentime_today");
            String d10 = d(optJSONObject3, "opentime_week");
            String d11 = d(optJSONObject3, "tel");
            String d12 = d(optJSONObject3, "tag");
            String d13 = d(optJSONObject3, "rating");
            String d14 = d(optJSONObject3, "cost");
            String d15 = d(optJSONObject3, "parking_type");
            String d16 = d(optJSONObject3, "alias");
            str = d(optJSONObject3, "cpid");
            str2 = d5;
            str3 = d8;
            str4 = d10;
            str5 = d11;
            str6 = d12;
            str7 = d13;
            str8 = d14;
            str9 = d15;
            str10 = d16;
        }
        Business business = new Business(str2, str3, str4, str5, str6, str7, str8, str9, str10);
        business.setCPID(str);
        poiItemV2.setBusiness(business);
        if (!jSONObject.has(Const.PROVIDER_INDOOR) || (optJSONObject2 = jSONObject.optJSONObject(Const.PROVIDER_INDOOR)) == null) {
            str11 = "";
            str12 = str11;
            i3 = 0;
            z5 = false;
        } else {
            z5 = m(d(optJSONObject2, "indoor_map")) == 1;
            str12 = d(optJSONObject2, "cpid");
            i3 = m(d(optJSONObject2, Const.JSON_KEY_FLOOR));
            str11 = d(optJSONObject2, "truefloor");
        }
        poiItemV2.setIndoorData(new IndoorDataV2(z5, str12, i3, str11));
        if (!jSONObject.has("navi") || (optJSONObject = jSONObject.optJSONObject("navi")) == null) {
            latLonPoint = null;
            latLonPoint2 = null;
            str13 = "";
        } else {
            str14 = d(optJSONObject, "navi_poiid");
            latLonPoint = b(optJSONObject, "entr_location");
            latLonPoint2 = b(optJSONObject, "exit_location");
            str13 = d(optJSONObject, "gridcode");
        }
        poiItemV2.setPoiNavi(new PoiNavi(str14, latLonPoint, latLonPoint2, str13));
        poiItemV2.setPhotos(a(jSONObject));
        return poiItemV2;
    }

    public static BusStationItem f(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(d(jSONObject, "name"));
        busStationItem.setBusStationId(d(jSONObject, "id"));
        busStationItem.setLatLonPoint(b(jSONObject, "location"));
        return busStationItem;
    }

    public static Doorway g(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(d(jSONObject, "name"));
        doorway.setLatLonPoint(b(jSONObject, "location"));
        return doorway;
    }

    private static ElecConsumeInfo h(JSONObject jSONObject) throws AMapException {
        try {
            ElecConsumeInfo elecConsumeInfo = new ElecConsumeInfo();
            elecConsumeInfo.setRunOutPoint(b(jSONObject, "runout_point"));
            elecConsumeInfo.setRunOutStepIndex(a(jSONObject, "runout_step_index"));
            elecConsumeInfo.setConsumeEnergy(a(jSONObject, "consume_energy"));
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("left_energy");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add(Integer.valueOf(optJSONArray.optInt(i3)));
                }
            }
            elecConsumeInfo.setLeftEnergy(arrayList);
            return elecConsumeInfo;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseElecConsumeInfo", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static ArrayList<GeocodeAddress> i(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    GeocodeAddress geocodeAddress = new GeocodeAddress();
                    geocodeAddress.setFormatAddress(d(optJSONObject, "formatted_address"));
                    geocodeAddress.setProvince(d(optJSONObject, "province"));
                    geocodeAddress.setCity(d(optJSONObject, "city"));
                    geocodeAddress.setDistrict(d(optJSONObject, "district"));
                    geocodeAddress.setTownship(d(optJSONObject, "township"));
                    geocodeAddress.setNeighborhood(d(optJSONObject.optJSONObject("neighborhood"), "name"));
                    geocodeAddress.setBuilding(d(optJSONObject.optJSONObject("building"), "name"));
                    geocodeAddress.setAdcode(d(optJSONObject, Const.JSON_KEY_ADCODE));
                    geocodeAddress.setLatLonPoint(b(optJSONObject, "location"));
                    geocodeAddress.setLevel(d(optJSONObject, "level"));
                    geocodeAddress.setCountry(d(optJSONObject, "country"));
                    geocodeAddress.setPostcode(d(optJSONObject, "postcode"));
                    arrayList.add(geocodeAddress);
                }
            }
        }
        return arrayList;
    }

    private static Navi j(JSONObject jSONObject) throws AMapException {
        try {
            Navi navi = new Navi();
            navi.setAction(d(jSONObject, "action"));
            navi.setAssistantAction(d(jSONObject, "assistant_action"));
            return navi;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseNavi", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static ArrayList<PoiItem> k(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    arrayList.add(d(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<PoiItemV2> l(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    arrayList.add(e(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static RouteRailwayItem m(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("id") || !jSONObject.has("name")) {
            return null;
        }
        RouteRailwayItem routeRailwayItem = new RouteRailwayItem();
        routeRailwayItem.setID(d(jSONObject, "id"));
        routeRailwayItem.setName(d(jSONObject, "name"));
        routeRailwayItem.setTime(d(jSONObject, Const.JSON_KEY_TIME));
        routeRailwayItem.setTrip(d(jSONObject, "trip"));
        routeRailwayItem.setDistance(l(d(jSONObject, "distance")));
        routeRailwayItem.setType(d(jSONObject, "type"));
        routeRailwayItem.setDeparturestop(n(jSONObject.optJSONObject("departure_stop")));
        routeRailwayItem.setArrivalstop(n(jSONObject.optJSONObject("arrival_stop")));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("via_stops");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    arrayList.add(n(optJSONObject));
                }
            }
        }
        routeRailwayItem.setViastops(arrayList);
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("alters");
        if (optJSONArray2 != null) {
            for (int i10 = 0; i10 < optJSONArray2.length(); i10++) {
                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i10);
                if (optJSONObject2 != null) {
                    Railway railway = new Railway();
                    railway.setID(d(optJSONObject2, "id"));
                    railway.setName(d(optJSONObject2, "name"));
                    arrayList2.add(railway);
                }
            }
        }
        routeRailwayItem.setAlters(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("spaces");
        if (optJSONArray3 != null) {
            for (int i11 = 0; i11 < optJSONArray3.length(); i11++) {
                JSONObject optJSONObject3 = optJSONArray3.optJSONObject(i11);
                if (optJSONObject3 != null) {
                    arrayList3.add(new RailwaySpace(d(optJSONObject3, "code"), l(d(optJSONObject3, "cost"))));
                }
            }
        }
        routeRailwayItem.setSpaces(arrayList3);
        return routeRailwayItem;
    }

    private static RailwayStationItem n(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(d(jSONObject, "id"));
        railwayStationItem.setName(d(jSONObject, "name"));
        railwayStationItem.setLocation(b(jSONObject, "location"));
        railwayStationItem.setAdcode(d(jSONObject, Const.JSON_KEY_ADCODE));
        railwayStationItem.setTime(d(jSONObject, Const.JSON_KEY_TIME));
        railwayStationItem.setisStart(j(d(jSONObject, "start")));
        railwayStationItem.setisEnd(j(d(jSONObject, "end")));
        railwayStationItem.setWait(l(d(jSONObject, "wait")));
        return railwayStationItem;
    }

    private static RidePath o(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(l(d(jSONObject, "distance")));
            ridePath.setDuration(n(d(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(d(optJSONObject, "instruction"));
                        rideStep.setOrientation(d(optJSONObject, "orientation"));
                        rideStep.setRoad(d(optJSONObject, Const.JSON_KEY_ROAD));
                        rideStep.setDistance(l(d(optJSONObject, "distance")));
                        rideStep.setDuration(l(d(optJSONObject, "duration")));
                        rideStep.setPolyline(c(optJSONObject, "polyline"));
                        rideStep.setAction(d(optJSONObject, "action"));
                        rideStep.setAssistantAction(d(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                c(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseRidePath", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    private static RidePath p(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(l(d(jSONObject, "distance")));
            ridePath.setDuration(n(d(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(d(optJSONObject, "instruction"));
                        rideStep.setOrientation(d(optJSONObject, "orientation"));
                        rideStep.setRoad(d(optJSONObject, "road_name"));
                        rideStep.setDistance(l(d(optJSONObject, "step_distance")));
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                        if (optJSONObject2 != null) {
                            rideStep.setDuration(l(d(optJSONObject2, "duration")));
                        }
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("navi");
                        if (optJSONObject3 != null) {
                            rideStep.setAction(d(optJSONObject3, "action"));
                            rideStep.setAssistantAction(d(optJSONObject3, "assistant_action"));
                            rideStep.setRoadType(m(d(optJSONObject3, "work_type")));
                        }
                        rideStep.setPolyline(c(optJSONObject, "polyline"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                c(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseRidePathV2", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    private static RoutePOIItem q(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(d(jSONObject, "id"));
        routePOIItem.setTitle(d(jSONObject, "name"));
        routePOIItem.setPoint(b(jSONObject, "location"));
        routePOIItem.setDistance(l(d(jSONObject, "distance")));
        routePOIItem.setDuration(l(d(jSONObject, "duration")));
        routePOIItem.setCPID(d(jSONObject, "cpid"));
        return routePOIItem;
    }

    public static ArrayList<RoutePOIItem> r(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        Object opt = jSONObject.opt("pois");
        if (opt instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        arrayList.add(q(optJSONObject));
                    }
                }
            }
        } else if (opt instanceof JSONObject) {
            arrayList.add(q(((JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    public static ArrayList<Tip> s(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                Tip tip = new Tip();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    tip.setName(d(optJSONObject, "name"));
                    tip.setDistrict(d(optJSONObject, "district"));
                    tip.setAdcode(d(optJSONObject, Const.JSON_KEY_ADCODE));
                    tip.setID(d(optJSONObject, "id"));
                    tip.setAddress(d(optJSONObject, Const.JSON_KEY_ADDRESS));
                    tip.setTypeCode(d(optJSONObject, "typecode"));
                    String d5 = d(optJSONObject, "location");
                    if (!TextUtils.isEmpty(d5)) {
                        String[] split = d5.split(Const.STR_MART_COMMA);
                        if (split.length == 2) {
                            tip.setPostion(new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                        }
                    }
                    arrayList.add(tip);
                }
            }
        }
        return arrayList;
    }

    public static BusLineItem t(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(d(jSONObject, "id"));
        busLineItem.setBusLineType(d(jSONObject, "type"));
        busLineItem.setBusLineName(d(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(c(jSONObject, "polyline"));
        busLineItem.setCityCode(d(jSONObject, Const.JSON_KEY_CITYCODE));
        busLineItem.setOriginatingStation(d(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(d(jSONObject, "end_stop"));
        return busLineItem;
    }

    public static ArrayList<BusLineItem> u(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    BusLineItem t8 = t(optJSONObject);
                    t8.setFirstBusTime(d6.b(d(optJSONObject, "start_time")));
                    t8.setLastBusTime(d6.b(d(optJSONObject, "end_time")));
                    t8.setBusCompany(d(optJSONObject, "company"));
                    t8.setDistance(l(d(optJSONObject, "distance")));
                    t8.setBasicPrice(l(d(optJSONObject, "basic_price")));
                    t8.setTotalPrice(l(d(optJSONObject, "total_price")));
                    t8.setBounds(c(optJSONObject, "bounds"));
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("busstops");
                    if (optJSONArray2 == null) {
                        t8.setBusStations(arrayList2);
                    } else {
                        for (int i10 = 0; i10 < optJSONArray2.length(); i10++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i10);
                            if (optJSONObject2 != null) {
                                arrayList2.add(v(optJSONObject2));
                            }
                        }
                        t8.setBusStations(arrayList2);
                    }
                    arrayList.add(t8);
                }
            }
        }
        return arrayList;
    }

    public static BusStationItem v(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(d(jSONObject, "id"));
        busStationItem.setLatLonPoint(b(jSONObject, "location"));
        busStationItem.setBusStationName(d(jSONObject, "name"));
        return busStationItem;
    }

    public static ArrayList<BusStationItem> w(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    BusStationItem v6 = v(optJSONObject);
                    v6.setAdCode(d(optJSONObject, Const.JSON_KEY_ADCODE));
                    v6.setCityCode(d(optJSONObject, Const.JSON_KEY_CITYCODE));
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("buslines");
                    ArrayList arrayList2 = new ArrayList();
                    if (optJSONArray2 == null) {
                        v6.setBusLineItems(arrayList2);
                    } else {
                        for (int i10 = 0; i10 < optJSONArray2.length(); i10++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i10);
                            if (optJSONObject2 != null) {
                                arrayList2.add(t(optJSONObject2));
                            }
                        }
                        v6.setBusLineItems(arrayList2);
                    }
                    arrayList.add(v6);
                }
            }
        }
        return arrayList;
    }

    public static List<BusStationItem> x(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("via_stops");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    arrayList.add(f(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static TruckRouteRestult g(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(AeUtil.ROOT_DATA_PATH_OLD_NAME)) {
                return null;
            }
            TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
            JSONObject optJSONObject = jSONObject.optJSONObject(AeUtil.ROOT_DATA_PATH_OLD_NAME).optJSONObject("route");
            truckRouteRestult.setStartPos(b(optJSONObject, "origin"));
            truckRouteRestult.setTargetPos(b(optJSONObject, "destination"));
            if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    TruckPath truckPath = new TruckPath();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    truckPath.setDistance(l(d(jSONObject2, "distance")));
                    truckPath.setDuration(n(d(jSONObject2, "duration")));
                    truckPath.setStrategy(d(jSONObject2, "strategy"));
                    truckPath.setTolls(l(d(jSONObject2, "tolls")));
                    truckPath.setTollDistance(l(d(jSONObject2, "toll_distance")));
                    truckPath.setTotalTrafficlights(m(d(jSONObject2, "traffic_lights")));
                    truckPath.setRestriction(m(d(jSONObject2, "restriction")));
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                    if (optJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i10 = 0; i10 < optJSONArray2.length(); i10++) {
                            TruckStep truckStep = new TruckStep();
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i10);
                            if (optJSONObject2 != null) {
                                truckStep.setInstruction(d(optJSONObject2, "instruction"));
                                truckStep.setOrientation(d(optJSONObject2, "orientation"));
                                truckStep.setRoad(d(optJSONObject2, Const.JSON_KEY_ROAD));
                                truckStep.setDistance(l(d(optJSONObject2, "distance")));
                                truckStep.setTolls(l(d(optJSONObject2, "tolls")));
                                truckStep.setTollDistance(l(d(optJSONObject2, "toll_distance")));
                                truckStep.setTollRoad(d(optJSONObject2, "toll_road"));
                                truckStep.setDuration(l(d(optJSONObject2, "duration")));
                                truckStep.setPolyline(c(optJSONObject2, "polyline"));
                                truckStep.setAction(d(optJSONObject2, "action"));
                                truckStep.setAssistantAction(d(optJSONObject2, "assistant_action"));
                                a(truckStep, optJSONObject2);
                                b(truckStep, optJSONObject2);
                                arrayList2.add(truckStep);
                            }
                        }
                        truckPath.setSteps(arrayList2);
                        arrayList.add(truckPath);
                    }
                }
                truckRouteRestult.setPaths(arrayList);
                return truckRouteRestult;
            }
            return truckRouteRestult;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseTruckRoute", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static void c(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                crossroad.setId(d(optJSONObject, "id"));
                crossroad.setDirection(d(optJSONObject, "direction"));
                crossroad.setDistance(l(d(optJSONObject, "distance")));
                crossroad.setCenterPoint(b(optJSONObject, "location"));
                crossroad.setFirstRoadId(d(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(d(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(d(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(d(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    public static RideRouteResultV2 f(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            RideRouteResultV2 rideRouteResultV2 = new RideRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            rideRouteResultV2.setStartPos(b(optJSONObject, "origin"));
            rideRouteResultV2.setTargetPos(b(optJSONObject, "destination"));
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResultV2.setPaths(arrayList);
                return rideRouteResultV2;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    RidePath p8 = p(optJSONArray.optJSONObject(i3));
                    if (p8 != null) {
                        arrayList.add(p8);
                    }
                }
            }
            rideRouteResultV2.setPaths(arrayList);
            return rideRouteResultV2;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseRideRouteV2", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static double k(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            d6.a(e, "JSONHelper", "str2float");
            return 0.0d;
        }
    }

    public static float l(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            d6.a(e, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    public static boolean j(String str) {
        return (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) || str.equals("0") || !str.equals("1")) ? false : true;
    }

    public static long n(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            d6.a(e, "JSONHelper", "str2long");
            return 0L;
        }
    }

    public static DriveRouteResult b(String str) throws AMapException {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            DriveRouteResult driveRouteResult = new DriveRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject != null) {
                driveRouteResult.setStartPos(b(optJSONObject, "origin"));
                driveRouteResult.setTargetPos(b(optJSONObject, "destination"));
                driveRouteResult.setTaxiCost(l(d(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    while (i3 < optJSONArray.length()) {
                        DrivePath drivePath = new DrivePath();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                        if (optJSONObject2 != null) {
                            drivePath.setDistance(l(d(optJSONObject2, "distance")));
                            drivePath.setDuration(n(d(optJSONObject2, "duration")));
                            drivePath.setStrategy(d(optJSONObject2, "strategy"));
                            drivePath.setTolls(l(d(optJSONObject2, "tolls")));
                            drivePath.setTollDistance(l(d(optJSONObject2, "toll_distance")));
                            drivePath.setTotalTrafficlights(m(d(optJSONObject2, "traffic_lights")));
                            drivePath.setRestriction(m(d(optJSONObject2, "restriction")));
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray2 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                int i10 = 0;
                                while (i10 < optJSONArray2.length()) {
                                    DriveStep driveStep = new DriveStep();
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i10);
                                    if (optJSONObject3 == null) {
                                        jSONArray2 = optJSONArray;
                                    } else {
                                        jSONArray2 = optJSONArray;
                                        driveStep.setInstruction(d(optJSONObject3, "instruction"));
                                        driveStep.setOrientation(d(optJSONObject3, "orientation"));
                                        driveStep.setRoad(d(optJSONObject3, Const.JSON_KEY_ROAD));
                                        driveStep.setDistance(l(d(optJSONObject3, "distance")));
                                        driveStep.setTolls(l(d(optJSONObject3, "tolls")));
                                        driveStep.setTollDistance(l(d(optJSONObject3, "toll_distance")));
                                        driveStep.setTollRoad(d(optJSONObject3, "toll_road"));
                                        driveStep.setDuration(l(d(optJSONObject3, "duration")));
                                        driveStep.setPolyline(c(optJSONObject3, "polyline"));
                                        driveStep.setAction(d(optJSONObject3, "action"));
                                        driveStep.setAssistantAction(d(optJSONObject3, "assistant_action"));
                                        a(driveStep, optJSONObject3);
                                        b(driveStep, optJSONObject3);
                                        arrayList2.add(driveStep);
                                    }
                                    i10++;
                                    optJSONArray = jSONArray2;
                                }
                                jSONArray = optJSONArray;
                                drivePath.setSteps(arrayList2);
                                a(drivePath, arrayList2);
                                arrayList.add(drivePath);
                                i3++;
                                optJSONArray = jSONArray;
                            }
                        }
                        jSONArray = optJSONArray;
                        i3++;
                        optJSONArray = jSONArray;
                    }
                    driveRouteResult.setPaths(arrayList);
                    return driveRouteResult;
                }
            }
            return driveRouteResult;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseDriveRoute", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        } catch (Throwable th2) {
            d6.a(th2, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static WalkRouteResult h(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            walkRouteResult.setStartPos(b(optJSONObject, "origin"));
            walkRouteResult.setTargetPos(b(optJSONObject, "destination"));
            if (!optJSONObject.has("paths")) {
                return walkRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(l(d(optJSONObject2, "distance")));
                    walkPath.setDuration(n(d(optJSONObject2, "duration")));
                    if (optJSONObject2.has("steps")) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i10 = 0; i10 < optJSONArray2.length(); i10++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i10);
                                if (optJSONObject3 != null) {
                                    walkStep.setInstruction(d(optJSONObject3, "instruction"));
                                    walkStep.setOrientation(d(optJSONObject3, "orientation"));
                                    walkStep.setRoad(d(optJSONObject3, Const.JSON_KEY_ROAD));
                                    walkStep.setDistance(l(d(optJSONObject3, "distance")));
                                    walkStep.setDuration(l(d(optJSONObject3, "duration")));
                                    walkStep.setPolyline(c(optJSONObject3, "polyline"));
                                    walkStep.setAction(d(optJSONObject3, "action"));
                                    walkStep.setAssistantAction(d(optJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            d(walkPath, arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResult.setPaths(arrayList);
            return walkRouteResult;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseWalkRoute", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static List<BusPath> c(JSONArray jSONArray) throws JSONException {
        int i3;
        int i10;
        JSONArray jSONArray2;
        float f2;
        int i11;
        JSONArray jSONArray3;
        JSONArray optJSONArray;
        JSONArray jSONArray4;
        int i12;
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        while (i13 < jSONArray.length()) {
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray.optJSONObject(i13);
            if (optJSONObject != null) {
                busPath.setCost(l(d(optJSONObject, "cost")));
                busPath.setDuration(n(d(optJSONObject, "duration")));
                busPath.setNightBus(j(d(optJSONObject, "nightflag")));
                busPath.setWalkDistance(l(d(optJSONObject, "walking_distance")));
                busPath.setDistance(l(d(optJSONObject, "distance")));
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("segments");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f10 = 0.0f;
                    float f11 = 0.0f;
                    int i14 = 0;
                    while (i14 < optJSONArray2.length()) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i14);
                        if (optJSONObject2 == null) {
                            i10 = i13;
                            jSONArray2 = optJSONArray2;
                            f2 = f11;
                            i11 = i14;
                        } else {
                            BusStep busStep = new BusStep();
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("walking");
                            i10 = i13;
                            if (optJSONObject3 != null) {
                                RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
                                jSONArray2 = optJSONArray2;
                                routeBusWalkItem.setOrigin(b(optJSONObject3, "origin"));
                                routeBusWalkItem.setDestination(b(optJSONObject3, "destination"));
                                routeBusWalkItem.setDistance(l(d(optJSONObject3, "distance")));
                                f2 = f11;
                                i11 = i14;
                                routeBusWalkItem.setDuration(n(d(optJSONObject3, "duration")));
                                if (optJSONObject3.has("steps") && (optJSONArray = optJSONObject3.optJSONArray("steps")) != null) {
                                    ArrayList arrayList3 = new ArrayList();
                                    int i15 = 0;
                                    while (i15 < optJSONArray.length()) {
                                        JSONObject optJSONObject4 = optJSONArray.optJSONObject(i15);
                                        if (optJSONObject4 == null) {
                                            jSONArray4 = optJSONArray;
                                            i12 = i15;
                                        } else {
                                            jSONArray4 = optJSONArray;
                                            WalkStep walkStep = new WalkStep();
                                            i12 = i15;
                                            walkStep.setInstruction(d(optJSONObject4, "instruction"));
                                            walkStep.setOrientation(d(optJSONObject4, "orientation"));
                                            walkStep.setRoad(d(optJSONObject4, Const.JSON_KEY_ROAD));
                                            walkStep.setDistance(l(d(optJSONObject4, "distance")));
                                            walkStep.setDuration(l(d(optJSONObject4, "duration")));
                                            walkStep.setPolyline(c(optJSONObject4, "polyline"));
                                            walkStep.setAction(d(optJSONObject4, "action"));
                                            walkStep.setAssistantAction(d(optJSONObject4, "assistant_action"));
                                            arrayList3.add(walkStep);
                                        }
                                        i15 = i12 + 1;
                                        optJSONArray = jSONArray4;
                                    }
                                    routeBusWalkItem.setSteps(arrayList3);
                                    d(routeBusWalkItem, arrayList3);
                                }
                                busStep.setWalk(routeBusWalkItem);
                            } else {
                                jSONArray2 = optJSONArray2;
                                f2 = f11;
                                i11 = i14;
                            }
                            JSONObject optJSONObject5 = optJSONObject2.optJSONObject("bus");
                            if (optJSONObject5 != null) {
                                ArrayList arrayList4 = new ArrayList();
                                JSONArray optJSONArray3 = optJSONObject5.optJSONArray("buslines");
                                if (optJSONArray3 != null) {
                                    int i16 = 0;
                                    while (i16 < optJSONArray3.length()) {
                                        JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i16);
                                        if (optJSONObject6 == null) {
                                            jSONArray3 = optJSONArray3;
                                        } else {
                                            RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
                                            jSONArray3 = optJSONArray3;
                                            routeBusLineItem.setDepartureBusStation(f(optJSONObject6.optJSONObject("departure_stop")));
                                            routeBusLineItem.setArrivalBusStation(f(optJSONObject6.optJSONObject("arrival_stop")));
                                            routeBusLineItem.setBusLineName(d(optJSONObject6, "name"));
                                            routeBusLineItem.setBusLineId(d(optJSONObject6, "id"));
                                            routeBusLineItem.setBusLineType(d(optJSONObject6, "type"));
                                            routeBusLineItem.setDistance(l(d(optJSONObject6, "distance")));
                                            routeBusLineItem.setDuration(l(d(optJSONObject6, "duration")));
                                            routeBusLineItem.setPolyline(c(optJSONObject6, "polyline"));
                                            routeBusLineItem.setFirstBusTime(d6.b(d(optJSONObject6, "start_time")));
                                            routeBusLineItem.setLastBusTime(d6.b(d(optJSONObject6, "end_time")));
                                            routeBusLineItem.setPassStationNum(m(d(optJSONObject6, "via_num")));
                                            routeBusLineItem.setPassStations(x(optJSONObject6));
                                            arrayList4.add(routeBusLineItem);
                                        }
                                        i16++;
                                        optJSONArray3 = jSONArray3;
                                    }
                                }
                                busStep.setBusLines(arrayList4);
                            }
                            JSONObject optJSONObject7 = optJSONObject2.optJSONObject("entrance");
                            if (optJSONObject7 != null) {
                                busStep.setEntrance(g(optJSONObject7));
                            }
                            JSONObject optJSONObject8 = optJSONObject2.optJSONObject("exit");
                            if (optJSONObject8 != null) {
                                busStep.setExit(g(optJSONObject8));
                            }
                            JSONObject optJSONObject9 = optJSONObject2.optJSONObject("railway");
                            if (optJSONObject9 != null) {
                                busStep.setRailway(m(optJSONObject9));
                            }
                            JSONObject optJSONObject10 = optJSONObject2.optJSONObject("taxi");
                            if (optJSONObject10 != null) {
                                TaxiItem taxiItem = new TaxiItem();
                                taxiItem.setOrigin(b(optJSONObject10, "origin"));
                                taxiItem.setDestination(b(optJSONObject10, "destination"));
                                taxiItem.setDistance(l(d(optJSONObject10, "distance")));
                                taxiItem.setDuration(l(d(optJSONObject10, "duration")));
                                taxiItem.setSname(d(optJSONObject10, "sname"));
                                taxiItem.setTname(d(optJSONObject10, "tname"));
                                busStep.setTaxi(taxiItem);
                            }
                            if ((busStep.getWalk() == null || busStep.getWalk().getSteps().size() == 0) && busStep.getBusLines().size() == 0 && busStep.getRailway() == null && busStep.getTaxi() == null) {
                                busStep = null;
                            }
                            if (busStep != null) {
                                arrayList2.add(busStep);
                                f11 = busStep.getWalk() != null ? busStep.getWalk().getDistance() + f2 : f2;
                                if (busStep.getBusLines() != null && busStep.getBusLines().size() > 0) {
                                    f10 = busStep.getBusLines().get(0).getDistance() + f10;
                                    i14 = i11 + 1;
                                    i13 = i10;
                                    optJSONArray2 = jSONArray2;
                                }
                                i14 = i11 + 1;
                                i13 = i10;
                                optJSONArray2 = jSONArray2;
                            }
                        }
                        f11 = f2;
                        i14 = i11 + 1;
                        i13 = i10;
                        optJSONArray2 = jSONArray2;
                    }
                    i3 = i13;
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f10);
                    busPath.setWalkDistance(f11);
                    arrayList.add(busPath);
                    i13 = i3 + 1;
                }
            }
            i3 = i13;
            i13 = i3 + 1;
        }
        return arrayList;
    }

    public static WalkRouteResultV2 i(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResultV2 walkRouteResultV2 = new WalkRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            walkRouteResultV2.setStartPos(b(optJSONObject, "origin"));
            walkRouteResultV2.setTargetPos(b(optJSONObject, "destination"));
            if (!optJSONObject.has("paths")) {
                return walkRouteResultV2;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResultV2.setPaths(arrayList);
                return walkRouteResultV2;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(l(d(optJSONObject2, "distance")));
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                    if (optJSONObject3 != null) {
                        walkPath.setDuration(n(d(optJSONObject3, "duration")));
                    }
                    if (optJSONObject2.has("steps")) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i10 = 0; i10 < optJSONArray2.length(); i10++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i10);
                                if (optJSONObject4 != null) {
                                    walkStep.setInstruction(d(optJSONObject4, "instruction"));
                                    walkStep.setOrientation(d(optJSONObject4, "orientation"));
                                    walkStep.setRoad(d(optJSONObject4, "road_name"));
                                    walkStep.setDistance(l(d(optJSONObject4, "step_distance")));
                                    JSONObject optJSONObject5 = optJSONObject4.optJSONObject("cost");
                                    if (optJSONObject5 != null) {
                                        walkStep.setDuration(l(d(optJSONObject5, "duration")));
                                    }
                                    JSONObject optJSONObject6 = optJSONObject4.optJSONObject("navi");
                                    if (optJSONObject6 != null) {
                                        walkStep.setAction(d(optJSONObject6, "action"));
                                        walkStep.setAssistantAction(d(optJSONObject6, "assistant_action"));
                                        walkStep.setRoadType(m(d(optJSONObject6, "work_type")));
                                    }
                                    walkStep.setPolyline(c(optJSONObject4, "polyline"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            d(walkPath, arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResultV2.setPaths(arrayList);
            return walkRouteResultV2;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseWalkRoute", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static void a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        String optString;
        if (jSONArray == null) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                DistrictItem districtItem2 = new DistrictItem();
                districtItem2.setCitycode(d(optJSONObject, Const.JSON_KEY_CITYCODE));
                districtItem2.setAdcode(d(optJSONObject, Const.JSON_KEY_ADCODE));
                districtItem2.setName(d(optJSONObject, "name"));
                districtItem2.setLevel(d(optJSONObject, "level"));
                districtItem2.setCenter(b(optJSONObject, "center"));
                if (optJSONObject.has("polyline") && (optString = optJSONObject.optString("polyline")) != null && optString.length() > 0) {
                    districtItem2.setDistrictBoundary(optString.split("\\|"));
                }
                a(optJSONObject.optJSONArray("districts"), new ArrayList(), districtItem2);
                arrayList.add(districtItem2);
            }
        }
        if (districtItem != null) {
            districtItem.setSubDistrict(arrayList);
        }
    }

    public static int m(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            d6.a(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    public static void a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                regeocodeRoad.setId(d(optJSONObject, "id"));
                regeocodeRoad.setName(d(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(b(optJSONObject, "location"));
                regeocodeRoad.setDirection(d(optJSONObject, "direction"));
                regeocodeRoad.setDistance(l(d(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    public static void a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        String cityCode;
        regeocodeAddress.setCountry(d(jSONObject, "country"));
        regeocodeAddress.setCountryCode(d(jSONObject, "countrycode"));
        regeocodeAddress.setProvince(d(jSONObject, "province"));
        regeocodeAddress.setCity(d(jSONObject, "city"));
        regeocodeAddress.setCityCode(d(jSONObject, Const.JSON_KEY_CITYCODE));
        regeocodeAddress.setAdCode(d(jSONObject, Const.JSON_KEY_ADCODE));
        regeocodeAddress.setDistrict(d(jSONObject, "district"));
        regeocodeAddress.setTownship(d(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(d(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(d(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(d(optJSONObject, Const.JSON_KEY_STREET));
        streetNumber.setNumber(d(optJSONObject, Const.JSON_KEY_NUMBER));
        streetNumber.setLatLonPoint(b(optJSONObject, "location"));
        streetNumber.setDirection(d(optJSONObject, "direction"));
        streetNumber.setDistance(l(d(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                BusinessArea businessArea = new BusinessArea();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    businessArea.setCenterPoint(b(optJSONObject2, "location"));
                    businessArea.setName(d(optJSONObject2, "name"));
                    arrayList.add(businessArea);
                }
            }
        }
        regeocodeAddress.setBusinessAreas(arrayList);
        regeocodeAddress.setTowncode(d(jSONObject, "towncode"));
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() < 1) && (cityCode = regeocodeAddress.getCityCode()) != null && cityCode.length() >= 1) {
            for (String str : f5144a) {
                if (cityCode.trim().equals(str.trim())) {
                    regeocodeAddress.setCity(regeocodeAddress.getProvince());
                    return;
                }
            }
        }
    }

    private static void b(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    tmc.setDistance(m(d(optJSONObject, "distance")));
                    tmc.setStatus(d(optJSONObject, FileDownloadModel.STATUS));
                    tmc.setPolyline(c(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            driveStep.setTMCs(arrayList);
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseTMCs", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    private static List<TMC> e(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                TMC tmc = new TMC();
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    tmc.setDistance(m(d(optJSONObject, "tmc_distance")));
                    tmc.setStatus(d(optJSONObject, "tmc_status"));
                    tmc.setPolyline(c(optJSONObject, "tmc_polyline"));
                    arrayList.add(tmc);
                }
            } catch (JSONException e) {
                throw e.b(e, "JSONHelper", "parseTMCsV5", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
            }
        }
        return arrayList;
    }

    public static RideRouteResult e(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(AeUtil.ROOT_DATA_PATH_OLD_NAME)) {
                return null;
            }
            RideRouteResult rideRouteResult = new RideRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject(AeUtil.ROOT_DATA_PATH_OLD_NAME);
            rideRouteResult.setStartPos(b(optJSONObject, "origin"));
            rideRouteResult.setTargetPos(b(optJSONObject, "destination"));
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    RidePath o3 = o(optJSONArray.optJSONObject(i3));
                    if (o3 != null) {
                        arrayList.add(o3);
                    }
                }
            } else if (opt instanceof JSONObject) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                if (!optJSONObject2.has(FileDownloadModel.PATH)) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                RidePath o8 = o(optJSONObject2.optJSONObject(FileDownloadModel.PATH));
                if (o8 != null) {
                    arrayList.add(o8);
                }
            }
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseRideRoute", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static List<RouteSearchCity> b(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(d(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(d(optJSONObject, Const.JSON_KEY_CITYCODE));
                    routeSearchCity.setSearchCityhAdCode(d(optJSONObject, Const.JSON_KEY_ADCODE));
                    a(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            } catch (JSONException e) {
                throw e.b(e, "JSONHelper", "parseCrossCity", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
            }
        }
        return arrayList;
    }

    public static List<BusPathV2> d(JSONArray jSONArray) throws JSONException {
        int i3;
        int i10;
        JSONArray jSONArray2;
        int i11;
        JSONArray jSONArray3;
        JSONArray optJSONArray;
        JSONArray jSONArray4;
        int i12;
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        while (i13 < jSONArray.length()) {
            BusPathV2 busPathV2 = new BusPathV2();
            JSONObject optJSONObject = jSONArray.optJSONObject(i13);
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                if (optJSONObject2 != null) {
                    busPathV2.setDuration(n(d(optJSONObject2, "duration")));
                    busPathV2.setCost(l(d(optJSONObject2, "transit_fee")));
                }
                busPathV2.setDistance(l(d(optJSONObject, "distance")));
                busPathV2.setNightBus(j(d(optJSONObject, "nightflag")));
                busPathV2.setWalkDistance(l(d(optJSONObject, "walking_distance")));
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("segments");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f2 = 0.0f;
                    float f10 = 0.0f;
                    int i14 = 0;
                    while (i14 < optJSONArray2.length()) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i14);
                        if (optJSONObject3 == null) {
                            i10 = i13;
                            jSONArray2 = optJSONArray2;
                            i11 = i14;
                        } else {
                            BusStepV2 busStepV2 = new BusStepV2();
                            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("walking");
                            i10 = i13;
                            if (optJSONObject4 != null) {
                                RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
                                routeBusWalkItem.setOrigin(b(optJSONObject4, "origin"));
                                routeBusWalkItem.setDestination(b(optJSONObject4, "destination"));
                                routeBusWalkItem.setDistance(l(d(optJSONObject4, "distance")));
                                JSONObject optJSONObject5 = optJSONObject4.optJSONObject("cost");
                                if (optJSONObject5 != null) {
                                    jSONArray2 = optJSONArray2;
                                    routeBusWalkItem.setDuration(n(d(optJSONObject5, "duration")));
                                } else {
                                    jSONArray2 = optJSONArray2;
                                }
                                if (optJSONObject4.has("steps") && (optJSONArray = optJSONObject4.optJSONArray("steps")) != null) {
                                    ArrayList arrayList3 = new ArrayList();
                                    i11 = i14;
                                    int i15 = 0;
                                    while (i15 < optJSONArray.length()) {
                                        JSONObject optJSONObject6 = optJSONArray.optJSONObject(i15);
                                        if (optJSONObject6 == null) {
                                            jSONArray4 = optJSONArray;
                                            i12 = i15;
                                        } else {
                                            jSONArray4 = optJSONArray;
                                            WalkStep walkStep = new WalkStep();
                                            i12 = i15;
                                            walkStep.setInstruction(d(optJSONObject6, "instruction"));
                                            walkStep.setOrientation(d(optJSONObject6, "orientation"));
                                            walkStep.setRoad(d(optJSONObject6, Const.JSON_KEY_ROAD));
                                            walkStep.setDistance(l(d(optJSONObject6, "distance")));
                                            walkStep.setDuration(l(d(optJSONObject6, "duration")));
                                            JSONObject optJSONObject7 = optJSONObject6.optJSONObject("polyline");
                                            if (optJSONObject7 != null) {
                                                walkStep.setPolyline(c(optJSONObject7, "polyline"));
                                            }
                                            JSONObject optJSONObject8 = optJSONObject6.optJSONObject("navi");
                                            if (optJSONObject8 != null) {
                                                walkStep.setAction(d(optJSONObject8, "action"));
                                                walkStep.setAssistantAction(d(optJSONObject8, "assistant_action"));
                                                walkStep.setRoadType(m(d(optJSONObject8, "walk_type")));
                                            }
                                            arrayList3.add(walkStep);
                                        }
                                        i15 = i12 + 1;
                                        optJSONArray = jSONArray4;
                                    }
                                    routeBusWalkItem.setSteps(arrayList3);
                                    d(routeBusWalkItem, arrayList3);
                                } else {
                                    i11 = i14;
                                }
                                busStepV2.setWalk(routeBusWalkItem);
                            } else {
                                jSONArray2 = optJSONArray2;
                                i11 = i14;
                            }
                            JSONObject optJSONObject9 = optJSONObject3.optJSONObject("bus");
                            if (optJSONObject9 != null) {
                                ArrayList arrayList4 = new ArrayList();
                                JSONArray optJSONArray3 = optJSONObject9.optJSONArray("buslines");
                                if (optJSONArray3 != null) {
                                    int i16 = 0;
                                    while (i16 < optJSONArray3.length()) {
                                        JSONObject optJSONObject10 = optJSONArray3.optJSONObject(i16);
                                        if (optJSONObject10 == null) {
                                            jSONArray3 = optJSONArray3;
                                        } else {
                                            RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
                                            jSONArray3 = optJSONArray3;
                                            routeBusLineItem.setDepartureBusStation(f(optJSONObject10.optJSONObject("departure_stop")));
                                            routeBusLineItem.setArrivalBusStation(f(optJSONObject10.optJSONObject("arrival_stop")));
                                            routeBusLineItem.setBusLineName(d(optJSONObject10, "name"));
                                            routeBusLineItem.setBusLineId(d(optJSONObject10, "id"));
                                            routeBusLineItem.setBusLineType(d(optJSONObject10, "type"));
                                            routeBusLineItem.setDistance(l(d(optJSONObject10, "distance")));
                                            JSONObject optJSONObject11 = optJSONObject10.optJSONObject("cost");
                                            if (optJSONObject11 != null) {
                                                routeBusLineItem.setDuration(l(d(optJSONObject11, "duration")));
                                            }
                                            JSONObject optJSONObject12 = optJSONObject10.optJSONObject("polyline");
                                            if (optJSONObject12 != null) {
                                                routeBusLineItem.setPolyline(c(optJSONObject12, "polyline"));
                                            }
                                            routeBusLineItem.setFirstBusTime(d6.b(d(optJSONObject10, "start_time")));
                                            routeBusLineItem.setLastBusTime(d6.b(d(optJSONObject10, "end_time")));
                                            routeBusLineItem.setPassStationNum(m(d(optJSONObject10, "via_num")));
                                            routeBusLineItem.setPassStations(x(optJSONObject10));
                                            arrayList4.add(routeBusLineItem);
                                        }
                                        i16++;
                                        optJSONArray3 = jSONArray3;
                                    }
                                }
                                busStepV2.setBusLines(arrayList4);
                            }
                            JSONObject optJSONObject13 = optJSONObject3.optJSONObject("entrance");
                            if (optJSONObject13 != null) {
                                busStepV2.setEntrance(g(optJSONObject13));
                            }
                            JSONObject optJSONObject14 = optJSONObject3.optJSONObject("exit");
                            if (optJSONObject14 != null) {
                                busStepV2.setExit(g(optJSONObject14));
                            }
                            JSONObject optJSONObject15 = optJSONObject3.optJSONObject("railway");
                            if (optJSONObject15 != null) {
                                busStepV2.setRailway(m(optJSONObject15));
                            }
                            JSONObject optJSONObject16 = optJSONObject3.optJSONObject("taxi");
                            if (optJSONObject16 != null) {
                                TaxiItemV2 taxiItemV2 = new TaxiItemV2();
                                taxiItemV2.setOrigin(b(optJSONObject16, "startpoint"));
                                taxiItemV2.setDestination(b(optJSONObject16, "endpoint"));
                                taxiItemV2.setDistance(l(d(optJSONObject16, "distance")));
                                taxiItemV2.setDuration(l(d(optJSONObject16, "drivetime")));
                                JSONObject optJSONObject17 = optJSONObject16.optJSONObject("polyline");
                                if (optJSONObject17 != null) {
                                    taxiItemV2.setPolyline(c(optJSONObject17, "polyline"));
                                }
                                taxiItemV2.setSname(d(optJSONObject16, "startname"));
                                taxiItemV2.setTname(d(optJSONObject16, "endname"));
                                busStepV2.setTaxi(taxiItemV2);
                            }
                            if ((busStepV2.getWalk() == null || busStepV2.getWalk().getSteps().size() == 0) && busStepV2.getBusLines().size() == 0 && busStepV2.getRailway() == null && busStepV2.getTaxi() == null) {
                                busStepV2 = null;
                            }
                            if (busStepV2 != null) {
                                arrayList2.add(busStepV2);
                                if (busStepV2.getWalk() != null) {
                                    f10 += busStepV2.getWalk().getDistance();
                                }
                                if (busStepV2.getBusLines() != null && busStepV2.getBusLines().size() > 0) {
                                    f2 = busStepV2.getBusLines().get(0).getDistance() + f2;
                                    i14 = i11 + 1;
                                    i13 = i10;
                                    optJSONArray2 = jSONArray2;
                                }
                            }
                        }
                        i14 = i11 + 1;
                        i13 = i10;
                        optJSONArray2 = jSONArray2;
                    }
                    i3 = i13;
                    busPathV2.setSteps(arrayList2);
                    busPathV2.setBusDistance(f2);
                    busPathV2.setWalkDistance(f10);
                    arrayList.add(busPathV2);
                    i13 = i3 + 1;
                }
            }
            i3 = i13;
            i13 = i3 + 1;
        }
        return arrayList;
    }

    private static List<ChargeStationInfo> a(JSONArray jSONArray) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                ChargeStationInfo chargeStationInfo = new ChargeStationInfo();
                chargeStationInfo.setName(d(jSONObject, "name"));
                chargeStationInfo.setPoiId(d(jSONObject, Const.JSON_KEY_POIID));
                chargeStationInfo.setBrandName(d(jSONObject, "brand_name"));
                chargeStationInfo.setShowPoint(b(jSONObject, "show_point"));
                chargeStationInfo.setProjectivePoint(b(jSONObject, "projective_point"));
                chargeStationInfo.setMaxPower(a(jSONObject, "max_power"));
                chargeStationInfo.setChargePercent(a(jSONObject, "charge_percent"));
                chargeStationInfo.setChargeTime(a(jSONObject, "charge_time"));
                chargeStationInfo.setRemainingCapacity(a(jSONObject, "remaining_capacity"));
                chargeStationInfo.setVoltage(a(jSONObject, "voltage"));
                chargeStationInfo.setAmperage(a(jSONObject, "amperage"));
                chargeStationInfo.setStepIndex(a(jSONObject, "step_index"));
                arrayList.add(chargeStationInfo);
            }
            return arrayList;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseChargeStationInfo", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static LatLonPoint b(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return d(jSONObject.optString(str));
        }
        return null;
    }

    public static void b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                aoiItem.setId(d(optJSONObject, "id"));
                aoiItem.setName(d(optJSONObject, "name"));
                aoiItem.setAdcode(d(optJSONObject, Const.JSON_KEY_ADCODE));
                aoiItem.setLocation(b(optJSONObject, "location"));
                aoiItem.setArea(Float.valueOf(l(d(optJSONObject, "area"))));
                aoiItem.setDistance(l(d(optJSONObject, "distance")));
                aoiItem.setType(d(optJSONObject, "type"));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    private static void b(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    tmc.setDistance(m(d(optJSONObject, "distance")));
                    tmc.setStatus(d(optJSONObject, FileDownloadModel.STATUS));
                    tmc.setPolyline(c(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            truckStep.setTMCs(arrayList);
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseTMCs", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    private static void a(Cost cost, JSONObject jSONObject) throws AMapException {
        try {
            cost.setTolls(l(d(jSONObject, "tolls")));
            cost.setTollDistance(l(d(jSONObject, "toll_distance")));
            cost.setTollRoad(d(jSONObject, "toll_road"));
            cost.setDuration(l(d(jSONObject, "duration")));
            cost.setTrafficLights(m(d(jSONObject, "traffic_lights")));
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseCostDetail", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static DriveRouteResultV2 c(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            DriveRouteResultV2 driveRouteResultV2 = new DriveRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject != null) {
                driveRouteResultV2.setStartPos(b(optJSONObject, "origin"));
                driveRouteResultV2.setTargetPos(b(optJSONObject, "destination"));
                driveRouteResultV2.setTaxiCost(l(d(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        DrivePathV2 drivePathV2 = new DrivePathV2();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                        if (optJSONObject2 != null) {
                            drivePathV2.setDistance(l(d(optJSONObject2, "distance")));
                            drivePathV2.setStrategy(d(optJSONObject2, "strategy"));
                            drivePathV2.setRestriction(m(d(optJSONObject2, "restriction")));
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                            if (optJSONObject3 != null) {
                                Cost cost = new Cost();
                                a(cost, optJSONObject3);
                                drivePathV2.setCost(cost);
                            }
                            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("elec_consume_info");
                            if (optJSONObject4 != null) {
                                drivePathV2.setElecConsumeInfo(h(optJSONObject4));
                            }
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("charge_station_info");
                            if (optJSONArray2 != null) {
                                drivePathV2.setChargeStationInfo(a(optJSONArray2));
                            }
                            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray3 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (int i10 = 0; i10 < optJSONArray3.length(); i10++) {
                                    DriveStepV2 driveStepV2 = new DriveStepV2();
                                    JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i10);
                                    if (optJSONObject5 != null) {
                                        driveStepV2.setInstruction(d(optJSONObject5, "instruction"));
                                        driveStepV2.setOrientation(d(optJSONObject5, "orientation"));
                                        driveStepV2.setStepDistance(m(d(optJSONObject5, "step_distance")));
                                        driveStepV2.setRoad(d(optJSONObject5, "road_name"));
                                        driveStepV2.setPolyline(c(optJSONObject5, "polyline"));
                                        JSONObject optJSONObject6 = optJSONObject5.optJSONObject("cost");
                                        if (optJSONObject6 != null) {
                                            Cost cost2 = new Cost();
                                            a(cost2, optJSONObject6);
                                            driveStepV2.setCostDetail(cost2);
                                        }
                                        JSONObject optJSONObject7 = optJSONObject5.optJSONObject("navi");
                                        if (optJSONObject7 != null) {
                                            driveStepV2.setNavi(j(optJSONObject7));
                                        }
                                        JSONArray optJSONArray4 = optJSONObject5.optJSONArray("cities");
                                        if (optJSONArray4 != null) {
                                            driveStepV2.setRouteSearchCityList(b(optJSONArray4));
                                        }
                                        JSONArray optJSONArray5 = optJSONObject5.optJSONArray("tmcs");
                                        if (optJSONArray5 != null) {
                                            driveStepV2.setTMCs(e(optJSONArray5));
                                        }
                                        arrayList2.add(driveStepV2);
                                    }
                                }
                                drivePathV2.setSteps(arrayList2);
                                b(drivePathV2, arrayList2);
                                arrayList.add(drivePathV2);
                            }
                        }
                    }
                    driveRouteResultV2.setPaths(arrayList);
                    return driveRouteResultV2;
                }
            }
            return driveRouteResultV2;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseDriveRoute", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        } catch (Throwable th2) {
            d6.a(th2, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static void a(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(d(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(d(optJSONObject, Const.JSON_KEY_CITYCODE));
                    routeSearchCity.setSearchCityhAdCode(d(optJSONObject, Const.JSON_KEY_ADCODE));
                    a(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            driveStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseCrossCity", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    private static void b(Path path, List<DriveStepV2> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStepV2 driveStepV2 : list) {
            if (driveStepV2 != null && driveStepV2.getPolyline() != null) {
                polyline.addAll(driveStepV2.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    public static void a(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    District district = new District();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        district.setDistrictName(d(optJSONObject, "name"));
                        district.setDistrictAdcode(d(optJSONObject, Const.JSON_KEY_ADCODE));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e) {
                throw e.b(e, "JSONHelper", "parseCrossDistricts", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
            }
        }
    }

    public static int a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.optInt(str);
        }
        return -1;
    }

    public static boolean a(String str) {
        return str == null || str.equals("");
    }

    private static List<Photo> a(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has("photos")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("photos");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                Photo photo = new Photo();
                photo.setTitle(d(optJSONObject, "title"));
                photo.setUrl(d(optJSONObject, "url"));
                arrayList.add(photo);
            }
        }
        return arrayList;
    }

    public static void a(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(d(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(d(optJSONObject, Const.JSON_KEY_CITYCODE));
                    routeSearchCity.setSearchCityhAdCode(d(optJSONObject, Const.JSON_KEY_ADCODE));
                    a(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            truckStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseCrossCity", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    public static ArrayList<LatLonPoint> c(JSONObject jSONObject, String str) throws JSONException {
        if (!jSONObject.has(str)) {
            return null;
        }
        String optString = jSONObject.optString(str);
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        for (String str2 : optString.split(Const.STR_MART_SEMICOLON)) {
            arrayList.add(d(str2));
        }
        return arrayList;
    }

    private static void c(Path path, List<RideStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (RideStep rideStep : list) {
            if (rideStep != null && rideStep.getPolyline() != null) {
                polyline.addAll(rideStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    public static String d(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || jSONObject.optString(str).equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) ? "" : jSONObject.optString(str).trim();
    }

    public static LatLonPoint d(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return null;
        }
        String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    private static void a(Path path, List<DriveStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStep driveStep : list) {
            if (driveStep != null && driveStep.getPolyline() != null) {
                polyline.addAll(driveStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static void d(Path path, List<WalkStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (WalkStep walkStep : list) {
            if (walkStep != null && walkStep.getPolyline() != null) {
                polyline.addAll(walkStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }
}
