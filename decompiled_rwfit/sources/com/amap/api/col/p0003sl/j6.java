package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class j6<T, V> extends f6<T, V> {
    public j6(Context context, T t8) {
        super(context, t8);
        this.f3984m = false;
    }

    public CloudItemDetail a(JSONObject jSONObject) throws JSONException {
        String optString;
        CloudItemDetail cloudItemDetail = new CloudItemDetail(u6.d(jSONObject, "id"), new LatLonPoint(jSONObject.optDouble("point_y"), jSONObject.optDouble("point_x")), u6.d(jSONObject, "title"), u6.d(jSONObject, Const.JSON_KEY_ADDRESS));
        cloudItemDetail.setCreatetime(u6.d(jSONObject, "gmt_create"));
        cloudItemDetail.setUpdatetime(u6.d(jSONObject, "gmt_modified"));
        if (jSONObject.has("_distance") && (optString = jSONObject.optString("_distance")) != null && !optString.equals("") && !optString.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            cloudItemDetail.setDistance(Integer.parseInt(optString));
        }
        return cloudItemDetail;
    }

    @Override // com.amap.api.col.p0003sl.f6, com.amap.api.col.p0003sl.pb
    public byte[] getEntityBytes() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.f6, com.amap.api.col.p0003sl.e6, com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 9.7.4");
        hashMap.put("X-INFO", e9.b(this.f3987p));
        hashMap.put("platinfo", "platform=Android&sdkversion=9.7.4&product=cloud");
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    public void a(CloudItem cloudItem, JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        HashMap<String, String> hashMap = new HashMap<>();
        if (keys == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            if (next != null) {
                hashMap.put(next.toString(), jSONObject.optString(next.toString()));
            }
        }
        cloudItem.setCustomfield(hashMap);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            d6.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        d6.e(str);
        return b(str);
    }
}
