package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* loaded from: classes.dex */
public class r6 extends f6<RouteSearchV2.DriveRouteQuery, DriveRouteResultV2> {
    public r6(Context context, RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        return u6.c(str);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.d(this.f3987p) + "/direction/driving?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        if (((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(d6.a(((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo().getFrom()));
            if (!u6.a(((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&origin_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(d6.a(((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo().getTo()));
            if (!u6.a(((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destination_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo().getDestinationPoiID());
            }
            if (!u6.a(((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origin_type=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo().getOriginType());
            }
            if (!u6.a(((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&plate=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f3985n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearchV2.DriveRouteQuery) this.f3985n).getMode().getValue());
        int showFields = ((RouteSearchV2.DriveRouteQuery) this.f3985n).getShowFields();
        stringBuffer.append("&show_fields=");
        stringBuffer.append(d6.a(showFields));
        RouteSearchV2.NewEnergy newEnergy = ((RouteSearchV2.DriveRouteQuery) this.f3985n).getNewEnergy();
        if (newEnergy != null) {
            stringBuffer.append(newEnergy.buildParam());
            stringBuffer.append("&force_new_version=true");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearchV2.DriveRouteQuery) this.f3985n).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        stringBuffer.append("" + ((RouteSearchV2.DriveRouteQuery) this.f3985n).getCarType());
        if (((RouteSearchV2.DriveRouteQuery) this.f3985n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f3985n).getPassedPointStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) this.f3985n).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f3985n).getAvoidpolygonsStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) this.f3985n).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(d(((RouteSearchV2.DriveRouteQuery) this.f3985n).getAvoidRoad()));
        }
        stringBuffer.append("&output=json&geometry=false");
        if (((RouteSearchV2.DriveRouteQuery) this.f3985n).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f3985n).getExclude());
        }
        return stringBuffer.toString();
    }
}
