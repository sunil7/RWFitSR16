package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class t7 extends e6<String, String> {

    /* renamed from: s, reason: collision with root package name */
    private String f5092s;

    public t7(Context context, String str) {
        super(context, str);
        this.f5092s = str;
    }

    @Override // com.amap.api.col.p0003sl.e6
    public String b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String d5 = u6.d(jSONObject, "code");
            String d8 = u6.d(jSONObject, "message");
            if ("1".equals(d5)) {
                return u6.d(jSONObject, "transfer_url");
            }
            if ("0".equals(d5)) {
                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, d8);
            }
            if ("2".equals(d5)) {
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, d8);
            }
            if ("3".equals(d5)) {
                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, d8);
            }
            if (Constants.VIA_TO_TYPE_QZONE.equals(d5)) {
                throw new AMapException("用户签名未通过", 0, d8);
            }
            if ("5".equals(d5)) {
                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, d8);
            }
            return null;
        } catch (JSONException e) {
            d6.a(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        byte[] bArr;
        StringBuilder sb2 = new StringBuilder("channel=open_api&flag=1");
        sb2.append("&address=" + URLEncoder.encode(this.f5092s));
        StringBuffer stringBuffer = new StringBuffer("open_api1");
        stringBuffer.append(this.f5092s);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String c9 = e9.c(stringBuffer.toString());
        sb2.append("&sign=");
        sb2.append(c9.toUpperCase(Locale.US));
        sb2.append("&output=json");
        try {
            bArr = b8.a(sb2.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            d6.a(e, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", h9.c(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        g9 b3 = g9.b(this.f3987p);
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://" + b3.a(23) + "/ws/mapapi/shortaddress/transform";
        }
        return "https://" + b3.a(23) + "/ws/mapapi/shortaddress/transform";
    }
}
