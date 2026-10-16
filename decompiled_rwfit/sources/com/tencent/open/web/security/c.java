package com.tencent.open.web.security;

import android.webkit.WebView;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.tencent.open.b;
import com.tencent.open.c.d;
import com.tencent.open.log.SLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class c extends b.a {

    /* renamed from: d, reason: collision with root package name */
    private String f12131d;

    public c(WebView webView, long j4, String str, String str2) {
        super(webView, j4, str);
        this.f12131d = str2;
    }

    private void b(String str) {
        WebView webView = this.f11965a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:if(!!");
            stringBuffer.append(this.f12131d);
            stringBuffer.append("){");
            stringBuffer.append(this.f12131d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }

    @Override // com.tencent.open.b.a
    public void a(Object obj) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.b.a
    public void a() {
        SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.b.a
    public void a(String str) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", !d.f12007a ? -4 : 0);
            jSONObject.put("sn", this.f11966b);
            jSONObject.put(AeUtil.ROOT_DATA_PATH_OLD_NAME, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
