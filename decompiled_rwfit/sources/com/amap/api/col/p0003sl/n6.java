package com.amap.api.col.p0003sl;

import android.content.Context;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class n6 extends f6<DistanceSearch.DistanceQuery, DistanceResult> {
    public n6(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("results")) {
                return null;
            }
            DistanceResult distanceResult = new DistanceResult();
            JSONArray optJSONArray = jSONObject.optJSONArray("results");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                DistanceItem distanceItem = new DistanceItem();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                distanceItem.setOriginId(u6.m(u6.d(jSONObject2, "origin_id")));
                distanceItem.setDestId(u6.m(u6.d(jSONObject2, "dest_id")));
                distanceItem.setDistance(u6.l(u6.d(jSONObject2, "distance")));
                distanceItem.setDuration(u6.l(u6.d(jSONObject2, "duration")));
                String d5 = u6.d(jSONObject2, "info");
                if (!TextUtils.isEmpty(d5)) {
                    distanceItem.setErrorInfo(d5);
                    distanceItem.setErrorCode(u6.m(u6.d(jSONObject2, "code")));
                }
                arrayList.add(distanceItem);
            }
            distanceResult.setDistanceResults(arrayList);
            return distanceResult;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "parseRouteDistance", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.b(this.f3987p) + "/distance?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) this.f3985n).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i3 = 0; i3 < size; i3++) {
                LatLonPoint latLonPoint = origins.get(i3);
                if (latLonPoint != null) {
                    double a3 = d6.a(latLonPoint.getLatitude());
                    stringBuffer.append(d6.a(latLonPoint.getLongitude()));
                    stringBuffer.append(Const.STR_MART_COMMA);
                    stringBuffer.append(a3);
                    if (i3 < size) {
                        stringBuffer.append("|");
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) this.f3985n).getDestination();
        if (destination != null) {
            double a10 = d6.a(destination.getLatitude());
            double a11 = d6.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(a11);
            stringBuffer.append(Const.STR_MART_COMMA);
            stringBuffer.append(a10);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) this.f3985n).getType());
        if (TextUtils.isEmpty(((DistanceSearch.DistanceQuery) this.f3985n).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.f3985n).getExtensions());
        }
        stringBuffer.append("&output=json");
        if (((DistanceSearch.DistanceQuery) this.f3985n).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.f3985n).getMode());
        }
        return stringBuffer.toString();
    }
}
