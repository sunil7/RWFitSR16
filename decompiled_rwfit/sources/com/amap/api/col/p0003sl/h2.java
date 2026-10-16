package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.c9;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h2 extends y2<String, List<OfflineMapProvince>> {

    /* renamed from: c, reason: collision with root package name */
    private Context f4258c;

    public h2(Context context, String str) {
        super(context, str);
    }

    public void a(Context context) {
        this.f4258c = context;
    }

    @Override // com.amap.api.col.p0003sl.y2
    public Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f5453a);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.y2
    public String c() {
        return "015";
    }

    @Override // com.amap.api.col.p0003sl.y2
    public List<OfflineMapProvince> a(JSONObject jSONObject) throws AMapException {
        try {
            if (this.f4258c != null) {
                x2.b(jSONObject.toString(), this.f4258c);
            }
        } catch (Throwable th2) {
            ka.a(th2, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th2.printStackTrace();
        }
        try {
            Context context = this.f4258c;
            if (context != null) {
                return x2.a(jSONObject, context);
            }
        } catch (JSONException e) {
            ka.a(e, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.amap.api.col.p0003sl.y2
    public JSONObject a(c9.c cVar) {
        JSONObject jSONObject = cVar.f3847c;
        if (jSONObject == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("015");
        if (!optJSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return optJSONObject;
    }
}
