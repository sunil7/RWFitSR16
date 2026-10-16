package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class a7 extends f6<UploadInfo, Integer> {

    /* renamed from: s, reason: collision with root package name */
    private Context f3604s;

    /* renamed from: t, reason: collision with root package name */
    private UploadInfo f3605t;

    public a7(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.f3604s = context;
        this.f3605t = uploadInfo;
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        return 0;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.f(this.f3604s) + "/nearby/data/create";
    }

    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3604s));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f3605t.getUserID());
        LatLonPoint point = this.f3605t.getPoint();
        int longitude = (int) (point.getLongitude() * 1000000.0d);
        int latitude = (int) (point.getLatitude() * 1000000.0d);
        stringBuffer.append("&location=");
        stringBuffer.append(longitude / 1000000.0f);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(latitude / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.f3605t.getCoordType());
        return stringBuffer.toString();
    }
}
