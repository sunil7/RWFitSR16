package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class z6 extends f6<NearbySearch.NearbyQuery, NearbySearchResult> {

    /* renamed from: s, reason: collision with root package name */
    private Context f5567s;

    /* renamed from: t, reason: collision with root package name */
    private NearbySearch.NearbyQuery f5568t;

    public z6(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.f5567s = context;
        this.f5568t = nearbyQuery;
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z5 = true;
            if (this.f5568t.getType() != 1) {
                z5 = false;
            }
            ArrayList<NearbyInfo> a3 = u6.a(jSONObject, z5);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(a3);
            return nearbySearchResult;
        } catch (JSONException e) {
            d6.a(e, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.f(this.f5567s) + "/nearby/around";
    }

    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f5567s));
        LatLonPoint centerPoint = this.f5568t.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(Const.STR_MART_COMMA);
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.f5568t.getRadius());
        stringBuffer.append("&limit=30&searchtype=");
        stringBuffer.append(this.f5568t.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.f5568t.getTimeRange());
        return stringBuffer.toString();
    }
}
