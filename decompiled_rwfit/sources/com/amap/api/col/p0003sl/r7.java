package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* loaded from: classes.dex */
public class r7 extends f6<RouteSearchV2.RideRouteQuery, RideRouteResultV2> {
    public r7(Context context, RouteSearchV2.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        return u6.f(str);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.d(this.f3987p) + "/direction/bicycling?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        stringBuffer.append("&origin=");
        stringBuffer.append(d6.a(((RouteSearchV2.RideRouteQuery) this.f3985n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(d6.a(((RouteSearchV2.RideRouteQuery) this.f3985n).getFromAndTo().getTo()));
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.RideRouteQuery) this.f3985n).getAlternativeRoute());
        stringBuffer.append("&output=json&show_fields=");
        stringBuffer.append(d6.a(((RouteSearchV2.RideRouteQuery) this.f3985n).getShowFields()));
        return stringBuffer.toString();
    }
}
