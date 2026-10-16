package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

/* loaded from: classes.dex */
public class v7 extends f6<RouteSearch.TruckRouteQuery, TruckRouteRestult> {
    public v7(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        return u6.g(str);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.c(this.f3987p) + "/direction/truck?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        if (((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(d6.a(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getFrom()));
            if (!u6.a(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(d6.a(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getTo()));
            if (!u6.a(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getDestinationPoiID());
            }
            if (!u6.a(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getOriginType());
            }
            if (!u6.a(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getDestinationType());
            }
            if (!u6.a(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getPlateProvince());
            }
            if (!u6.a(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getMode());
        if (((RouteSearch.TruckRouteQuery) this.f3985n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getTruckAxis());
        if (TextUtils.isEmpty(((RouteSearch.TruckRouteQuery) this.f3985n).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f3985n).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }
}
