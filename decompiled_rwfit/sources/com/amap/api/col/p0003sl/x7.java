package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;

/* loaded from: classes.dex */
public class x7 extends f6<RouteSearchV2.WalkRouteQuery, WalkRouteResultV2> {
    public x7(Context context, RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        return u6.i(str);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.d(this.f3987p) + "/direction/walking?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        stringBuffer.append("&origin=");
        stringBuffer.append(d6.a(((RouteSearchV2.WalkRouteQuery) this.f3985n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(d6.a(((RouteSearchV2.WalkRouteQuery) this.f3985n).getFromAndTo().getTo()));
        stringBuffer.append("&output=json&isindoor=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) this.f3985n).isIndoor() ? 1 : 0);
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) this.f3985n).getAlternativeRoute());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(d6.a(((RouteSearchV2.WalkRouteQuery) this.f3985n).getShowFields()));
        return stringBuffer.toString();
    }
}
