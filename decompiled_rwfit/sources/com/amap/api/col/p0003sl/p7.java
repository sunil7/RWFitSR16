package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.l7;
import com.amap.api.col.p0003sl.n7;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.autonavi.aps.amapapi.config.Const;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p7 extends f6<RegeocodeQuery, RegeocodeAddress> {
    public p7(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String a(boolean z5) {
        StringBuilder sb2 = new StringBuilder("output=json&location=");
        if (z5) {
            sb2.append(d6.a(((RegeocodeQuery) this.f3985n).getPoint().getLongitude()));
            sb2.append(Const.STR_MART_COMMA);
            sb2.append(d6.a(((RegeocodeQuery) this.f3985n).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f3985n).getPoiType())) {
            sb2.append("&poitype=");
            sb2.append(((RegeocodeQuery) this.f3985n).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f3985n).getMode())) {
            sb2.append("&mode=");
            sb2.append(((RegeocodeQuery) this.f3985n).getMode());
        }
        if (TextUtils.isEmpty(((RegeocodeQuery) this.f3985n).getExtensions())) {
            sb2.append("&extensions=base");
        } else {
            sb2.append("&extensions=");
            sb2.append(((RegeocodeQuery) this.f3985n).getExtensions());
        }
        sb2.append("&radius=");
        sb2.append((int) ((RegeocodeQuery) this.f3985n).getRadius());
        sb2.append("&coordsys=");
        sb2.append(((RegeocodeQuery) this.f3985n).getLatLonType());
        sb2.append("&key=");
        sb2.append(b9.e(this.f3987p));
        return sb2.toString();
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (optJSONObject != null) {
                regeocodeAddress.setFormatAddress(u6.d(optJSONObject, "formatted_address"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
                if (optJSONObject2 != null) {
                    u6.a(optJSONObject2, regeocodeAddress);
                }
                regeocodeAddress.setPois(u6.k(optJSONObject));
                JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
                if (optJSONArray != null) {
                    u6.a(optJSONArray, regeocodeAddress);
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
                if (optJSONArray2 != null) {
                    u6.c(optJSONArray2, regeocodeAddress);
                }
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
                if (optJSONArray3 != null) {
                    u6.b(optJSONArray3, regeocodeAddress);
                    return regeocodeAddress;
                }
            }
        } catch (JSONException e) {
            d6.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
        return regeocodeAddress;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.e6
    public l7.b f() {
        m7 a3 = l7.a().a("regeo");
        n7 n7Var = a3 == null ? null : (n7) a3;
        double b3 = n7Var != null ? n7Var.b() : 0.0d;
        l7.b bVar = new l7.b();
        bVar.f4475a = getURL() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        T t8 = this.f3985n;
        if (t8 != 0 && ((RegeocodeQuery) t8).getPoint() != null) {
            bVar.f4476b = new n7.a(((RegeocodeQuery) this.f3985n).getPoint().getLatitude(), ((RegeocodeQuery) this.f3985n).getPoint().getLongitude(), b3);
        }
        return bVar;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.b(this.f3987p) + "/geocode/regeo?";
    }

    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        return a(true);
    }
}
