package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o6 extends f6<DistrictSearchQuery, DistrictResult> {
    public o6(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.f3985n, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt(Const.SP_KEY_CALL_LOC_COUNT));
            optJSONArray = jSONObject.optJSONArray("districts");
        } catch (JSONException e) {
            d6.a(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e10) {
            d6.a(e10, "DistrictServerHandler", "paseJSONException");
        }
        if (optJSONArray == null) {
            return districtResult;
        }
        u6.a(optJSONArray, arrayList, null);
        return districtResult;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.b(this.f3987p) + "/config/district?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("output=json&page=");
        stringBuffer.append(((DistrictSearchQuery) this.f3985n).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) this.f3985n).getPageSize());
        if (((DistrictSearchQuery) this.f3985n).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) this.f3985n).checkKeyWords()) {
            String d5 = d(((DistrictSearchQuery) this.f3985n).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(d5);
        }
        stringBuffer.append("&key=" + b9.e(this.f3987p));
        stringBuffer.append("&subdistrict=" + String.valueOf(((DistrictSearchQuery) this.f3985n).getSubDistrict()));
        return stringBuffer.toString();
    }
}
