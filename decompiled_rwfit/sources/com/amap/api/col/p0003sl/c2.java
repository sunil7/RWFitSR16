package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.c9;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c2 extends y2<String, b2> {
    public c2(Context context, String str) {
        super(context, str);
    }

    @Override // com.amap.api.col.p0003sl.y2
    public JSONObject a(c9.c cVar) {
        JSONObject jSONObject = cVar.f3847c;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("016");
        }
        return null;
    }

    @Override // com.amap.api.col.p0003sl.y2
    public Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f5453a);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.y2
    public String c() {
        return "016";
    }

    @Override // com.amap.api.col.p0003sl.y2
    public b2 a(JSONObject jSONObject) throws AMapException {
        b2 b2Var = new b2();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                b2Var.a(false);
            } else if (optString.equals("1")) {
                b2Var.a(true);
            }
            jSONObject.optString("version", "");
            return b2Var;
        } catch (Throwable th2) {
            ka.a(th2, "OfflineInitHandlerAbstract", "loadData parseJson");
            return b2Var;
        }
    }
}
