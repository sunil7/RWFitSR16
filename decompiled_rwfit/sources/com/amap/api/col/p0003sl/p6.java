package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.RouteSearch;

/* loaded from: classes.dex */
public class p6 extends f6<RouteSearch.DrivePlanQuery, DriveRoutePlanResult> {
    public p6(Context context, RouteSearch.DrivePlanQuery drivePlanQuery) {
        super(context, drivePlanQuery);
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01be A[Catch: all -> 0x0029, JSONException -> 0x002c, TryCatch #2 {JSONException -> 0x002c, all -> 0x0029, blocks: (B:3:0x000e, B:5:0x001b, B:6:0x002f, B:10:0x0037, B:14:0x0044, B:17:0x004c, B:20:0x0054, B:21:0x005a, B:24:0x0064, B:28:0x0104, B:29:0x0075, B:32:0x0096, B:33:0x009c, B:35:0x00a2, B:39:0x00f3, B:40:0x00b5, B:43:0x00e6, B:47:0x00fa, B:50:0x010a, B:53:0x0115, B:56:0x011c, B:57:0x0122, B:59:0x0128, B:63:0x0222, B:64:0x013b, B:66:0x0142, B:69:0x0156, B:70:0x015c, B:72:0x0162, B:77:0x020b, B:78:0x0175, B:84:0x01b2, B:87:0x01be, B:88:0x01c6, B:90:0x01cc, B:94:0x01fc, B:95:0x01dc, B:98:0x0203, B:102:0x0216, B:106:0x022b), top: B:2:0x000e }] */
    @Override // com.amap.api.col.p0003sl.e6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r21) throws com.amap.api.services.core.AMapException {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.p6.b(java.lang.String):java.lang.Object");
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.c(this.f3987p) + "/etd/driving?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        if (((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(d6.a(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getFrom()));
            if (!u6.a(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(d6.a(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getTo()));
            if (!u6.a(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getDestinationPoiID());
            }
            if (!u6.a(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getOriginType());
            }
            if (!u6.a(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getDestinationType());
            }
            if (!u6.a(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getPlateProvince());
            }
            if (!u6.a(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.f3985n).getFromAndTo().getPlateNumber());
            }
        }
        if (((RouteSearch.DrivePlanQuery) this.f3985n).getDestParentPoiID() != null) {
            stringBuffer.append("&parentid=");
            stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f3985n).getDestParentPoiID());
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f3985n).getMode());
        stringBuffer.append("&cartype=");
        stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f3985n).getCarType());
        stringBuffer.append("&firsttime=");
        stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f3985n).getFirstTime());
        stringBuffer.append("&interval=");
        stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f3985n).getInterval());
        stringBuffer.append("&count=");
        stringBuffer.append("" + ((RouteSearch.DrivePlanQuery) this.f3985n).getCount());
        return stringBuffer.toString();
    }
}
