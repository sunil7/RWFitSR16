package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.l7;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d7 extends b7<String, PoiItemV2> {

    /* renamed from: s, reason: collision with root package name */
    private PoiSearchV2.Query f3899s;

    public d7(Context context, String str, PoiSearchV2.Query query) {
        super(context, str);
        this.f3899s = query;
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        JSONObject optJSONObject;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("pois");
            if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                return u6.e(optJSONObject);
            }
            return null;
        } catch (JSONException e) {
            d6.a(e, "PoiSearchIdHandlerV2", "paseJSONJSONException");
            return null;
        } catch (Exception e10) {
            d6.a(e10, "PoiSearchIdHandlerV2", "paseJSONException");
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
        return m6.d(this.f3987p) + "/place/detail?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuilder sb2 = new StringBuilder("id=");
        sb2.append((String) this.f3985n);
        sb2.append("&output=json");
        PoiSearchV2.Query query = this.f3899s;
        String a3 = (query == null || query.getShowFields() == null) ? null : a(this.f3899s.getShowFields());
        if (a3 != null) {
            sb2.append("&show_fields=");
            sb2.append(a3);
        }
        sb2.append("&key=" + b9.e(this.f3987p));
        String channel = this.f3899s.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb2.append("&channel=");
            sb2.append(channel);
        }
        String premium = this.f3899s.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb2.append("&permium=");
            sb2.append(premium);
        }
        PoiSearchV2.Query query2 = this.f3899s;
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
