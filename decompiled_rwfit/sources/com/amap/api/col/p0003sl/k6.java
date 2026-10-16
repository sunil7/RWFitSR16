package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.tencent.connect.common.Constants;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k6 extends j6<h7, CloudItemDetail> {
    public k6(Context context, h7 h7Var) {
        super(context, h7Var);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        if (str != null && !str.equals("")) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(AeUtil.ROOT_DATA_PATH_OLD_NAME);
                JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("list") : null;
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(0);
                    CloudItemDetail a3 = a(jSONObject);
                    a(a3, jSONObject);
                    return a3;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6, com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", b9.e(this.f3987p));
        hashtable.put("layerId", ((h7) this.f3985n).f4259a);
        hashtable.put("output", "json");
        hashtable.put("id", ((h7) this.f3985n).f4260b);
        String c9 = e9.c();
        String a3 = e9.a(this.f3987p, c9, n9.a(hashtable));
        hashtable.put(Constants.TS, c9);
        hashtable.put("scode", a3);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.e(this.f3987p) + "/datasearch/id";
    }

    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        return null;
    }
}
