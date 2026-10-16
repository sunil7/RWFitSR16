package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.utils.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

/* loaded from: classes2.dex */
public final class e {
    public static byte[] a(String str) {
        String str2;
        StringBuilder sb2;
        if (str != null && str.length() != 0) {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(str);
            try {
                HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), 60000);
                HttpResponse execute = defaultHttpClient.execute(httpGet);
                if (execute.getStatusLine().getStatusCode() == 200) {
                    return EntityUtils.toByteArray(execute.getEntity());
                }
                Log.e("MicroMsg.SDK.NetUtil", "httpGet fail, status code = " + execute.getStatusLine().getStatusCode());
                return null;
            } catch (Exception e) {
                e = e;
                sb2 = new StringBuilder("httpGet, Exception ex = ");
                sb2.append(e.getMessage());
                str2 = sb2.toString();
                Log.e("MicroMsg.SDK.NetUtil", str2);
                return null;
            } catch (IncompatibleClassChangeError e10) {
                e = e10;
                sb2 = new StringBuilder("httpGet, IncompatibleClassChangeError ex = ");
                sb2.append(e.getMessage());
                str2 = sb2.toString();
                Log.e("MicroMsg.SDK.NetUtil", str2);
                return null;
            } catch (Throwable th2) {
                e = th2;
                sb2 = new StringBuilder("httpGet, Throwable ex = ");
                sb2.append(e.getMessage());
                str2 = sb2.toString();
                Log.e("MicroMsg.SDK.NetUtil", str2);
                return null;
            }
        }
        str2 = "httpGet, url is null";
        Log.e("MicroMsg.SDK.NetUtil", str2);
        return null;
    }
}
