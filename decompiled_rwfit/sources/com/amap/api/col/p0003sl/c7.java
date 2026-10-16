package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.l7;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c7 extends b7<String, PoiItem> {

    /* renamed from: s, reason: collision with root package name */
    private PoiSearch.Query f3811s;

    public c7(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.f3811s = query;
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        JSONObject optJSONObject;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("pois");
            if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                return u6.d(optJSONObject);
            }
            return null;
        } catch (JSONException e) {
            d6.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e10) {
            d6.a(e10, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.e6
    public l7.b f() {
        l7.b bVar = new l7.b();
        bVar.f4475a = getURL() + h() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.b(this.f3987p) + "/place/detail?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuilder sb2 = new StringBuilder("id=");
        sb2.append((String) this.f3985n);
        sb2.append("&output=json");
        PoiSearch.Query query = this.f3811s;
        if (query == null || e(query.getExtensions())) {
            sb2.append("&extensions=base");
        } else {
            sb2.append("&extensions=");
            sb2.append(this.f3811s.getExtensions());
        }
        sb2.append("&children=1");
        sb2.append("&key=" + b9.e(this.f3987p));
        PoiSearch.Query query2 = this.f3811s;
        if (query2 != null) {
            Map<String, String> customParams = query2.getCustomParams();
            if (!customParams.isEmpty()) {
                for (Map.Entry<String, String> entry : customParams.entrySet()) {
                    sb2.append(Const.STR_MART_ADD);
                    sb2.append(entry.getKey());
                    sb2.append("=");
                    sb2.append(entry.getValue());
                }
            }
        }
        return sb2.toString();
    }
}
