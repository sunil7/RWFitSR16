package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g6 extends f6<RouteSearch.BusRouteQuery, BusRouteResult> {
    public g6(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
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
            BusRouteResult busRouteResult = new BusRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject != null) {
                busRouteResult.setStartPos(u6.b(optJSONObject, "origin"));
                busRouteResult.setTargetPos(u6.b(optJSONObject, "destination"));
                busRouteResult.setTaxiCost(u6.l(u6.d(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("transits") && (optJSONArray = optJSONObject.optJSONArray("transits")) != null) {
                    busRouteResult.setPaths(u6.c(optJSONArray));
                    return busRouteResult;
                }
            }
            return busRouteResult;
        } catch (JSONException unused) {
            throw new AMapException(AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.b(this.f3987p) + "/direction/transit/integrated?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        stringBuffer.append("&origin=");
        stringBuffer.append(d6.a(((RouteSearch.BusRouteQuery) this.f3985n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(d6.a(((RouteSearch.BusRouteQuery) this.f3985n).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.f3985n).getCity();
        if (!u6.a(city)) {
            city = d(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!u6.a(((RouteSearch.BusRouteQuery) this.f3985n).getCity())) {
            String d5 = d(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(d5);
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearch.BusRouteQuery) this.f3985n).getMode());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) this.f3985n).getNightFlag());
        if (TextUtils.isEmpty(((RouteSearch.BusRouteQuery) this.f3985n).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) this.f3985n).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }
}
