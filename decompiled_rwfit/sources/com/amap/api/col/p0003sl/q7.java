package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;

/* loaded from: classes.dex */
public class q7 extends f6<RouteSearch.RideRouteQuery, RideRouteResult> {
    public q7(Context context, RouteSearch.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        return u6.e(str);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.c(this.f3987p) + "/direction/bicycling?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        stringBuffer.append("&origin=");
        stringBuffer.append(d6.a(((RouteSearch.RideRouteQuery) this.f3985n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(d6.a(((RouteSearch.RideRouteQuery) this.f3985n).getFromAndTo().getTo()));
        stringBuffer.append("&output=json&geometry=false");
        if (TextUtils.isEmpty(((RouteSearch.RideRouteQuery) this.f3985n).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.RideRouteQuery) this.f3985n).getExtensions());
        }
        return stringBuffer.toString();
    }
}
