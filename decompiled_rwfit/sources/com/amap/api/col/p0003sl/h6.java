package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h6 extends f6<RouteSearchV2.BusRouteQuery, BusRouteResultV2> {
    public h6(Context context, RouteSearchV2.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            BusRouteResultV2 busRouteResultV2 = new BusRouteResultV2();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject != null) {
                busRouteResultV2.setStartPos(u6.b(optJSONObject, "origin"));
                busRouteResultV2.setTargetPos(u6.b(optJSONObject, "destination"));
                busRouteResultV2.setDistance(u6.l(u6.d(optJSONObject, "distance")));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                if (optJSONObject2 != null) {
                    busRouteResultV2.setTaxiCost(u6.l(u6.d(optJSONObject2, "taxi_fee")));
                }
                if (optJSONObject.has("transits") && (optJSONArray = optJSONObject.optJSONArray("transits")) != null) {
                    busRouteResultV2.setPaths(u6.d(optJSONArray));
                    return busRouteResultV2;
                }
            }
            return busRouteResultV2;
        } catch (JSONException unused) {
            throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.d(this.f3987p) + "/direction/transit/integrated?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        stringBuffer.append("&origin=");
        stringBuffer.append(d6.a(((RouteSearchV2.BusRouteQuery) this.f3985n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(d6.a(((RouteSearchV2.BusRouteQuery) this.f3985n).getFromAndTo().getTo()));
        String city = ((RouteSearchV2.BusRouteQuery) this.f3985n).getCity();
        if (!u6.a(city)) {
            city = d(city);
            stringBuffer.append("&city1=");
            stringBuffer.append(city);
        }
        if (!u6.a(((RouteSearchV2.BusRouteQuery) this.f3985n).getCity())) {
            String d5 = d(city);
            stringBuffer.append("&city2=");
            stringBuffer.append(d5);
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearchV2.BusRouteQuery) this.f3985n).getMode());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f3985n).getNightFlag());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(d6.a(((RouteSearchV2.BusRouteQuery) this.f3985n).getShowFields()));
        String originPoiId = ((RouteSearchV2.BusRouteQuery) this.f3985n).getOriginPoiId();
        if (!TextUtils.isEmpty(originPoiId)) {
            stringBuffer.append("&originpoi=");
            stringBuffer.append(originPoiId);
        }
        String destinationPoiId = ((RouteSearchV2.BusRouteQuery) this.f3985n).getDestinationPoiId();
        if (!TextUtils.isEmpty(destinationPoiId)) {
            stringBuffer.append("&destinationpoi=");
            stringBuffer.append(destinationPoiId);
        }
        String ad1 = ((RouteSearchV2.BusRouteQuery) this.f3985n).getAd1();
        if (!TextUtils.isEmpty(ad1)) {
            stringBuffer.append("&ad1=");
            stringBuffer.append(ad1);
        }
        String ad2 = ((RouteSearchV2.BusRouteQuery) this.f3985n).getAd2();
        if (!TextUtils.isEmpty(ad2)) {
            stringBuffer.append("&ad2=");
            stringBuffer.append(ad2);
        }
        String date = ((RouteSearchV2.BusRouteQuery) this.f3985n).getDate();
        if (!TextUtils.isEmpty(date)) {
            stringBuffer.append("&date=");
            stringBuffer.append(date);
        }
        String time = ((RouteSearchV2.BusRouteQuery) this.f3985n).getTime();
        if (!TextUtils.isEmpty(time)) {
            stringBuffer.append("&time=");
            stringBuffer.append(time);
        }
        stringBuffer.append("&AlternativeRoute=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f3985n).getAlternativeRoute());
        stringBuffer.append("&multiexport=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f3985n).getMultiExport());
        stringBuffer.append("&max_trans=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) this.f3985n).getMaxTrans());
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }
}
