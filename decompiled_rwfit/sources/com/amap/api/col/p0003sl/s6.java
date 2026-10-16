package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.l7;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class s6 extends f6<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public s6(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(Const.SP_KEY_CALL_LOC_COUNT) && jSONObject.getInt(Const.SP_KEY_CALL_LOC_COUNT) > 0) {
                return u6.i(jSONObject);
            }
        } catch (JSONException e) {
            d6.a(e, "GeocodingHandler", "paseJSONJSONException");
        } catch (Exception e10) {
            d6.a(e10, "GeocodingHandler", "paseJSONException");
        }
        return arrayList;
    }

    @Override // com.amap.api.col.p0003sl.e6
    public l7.b f() {
        l7.b bVar = new l7.b();
        bVar.f4475a = getURL() + h() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.b(this.f3987p) + "/geocode/geo?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("output=json&address=");
        stringBuffer.append(d(((GeocodeQuery) this.f3985n).getLocationName()));
        String city = ((GeocodeQuery) this.f3985n).getCity();
        if (!u6.a(city)) {
            String d5 = d(city);
            stringBuffer.append("&city=");
            stringBuffer.append(d5);
        }
        if (!u6.a(((GeocodeQuery) this.f3985n).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(d(((GeocodeQuery) this.f3985n).getCountry()));
        }
        stringBuffer.append("&key=" + b9.e(this.f3987p));
        return stringBuffer.toString();
    }
}
