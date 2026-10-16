package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* loaded from: classes.dex */
public class q6 extends f6<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public q6(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        return u6.b(str);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.b(this.f3987p) + "/direction/driving?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        if (((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(d6.a(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getFrom()));
            if (!u6.a(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(d6.a(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getTo()));
            if (!u6.a(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getDestinationPoiID());
            }
            if (!u6.a(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getOriginType());
            }
            if (!u6.a(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getDestinationType());
            }
            if (!u6.a(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getPlateProvince());
            }
            if (!u6.a(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3985n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearch.DriveRouteQuery) this.f3985n).getMode());
        if (TextUtils.isEmpty(((RouteSearch.DriveRouteQuery) this.f3985n).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3985n).getExtensions());
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearch.DriveRouteQuery) this.f3985n).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        stringBuffer.append("" + ((RouteSearch.DriveRouteQuery) this.f3985n).getCarType());
        if (((RouteSearch.DriveRouteQuery) this.f3985n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3985n).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f3985n).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3985n).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f3985n).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(d(((RouteSearch.DriveRouteQuery) this.f3985n).getAvoidRoad()));
        }
        stringBuffer.append("&output=json&geometry=false");
        if (((RouteSearch.DriveRouteQuery) this.f3985n).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f3985n).getExclude());
        }
        return stringBuffer.toString();
    }
}
