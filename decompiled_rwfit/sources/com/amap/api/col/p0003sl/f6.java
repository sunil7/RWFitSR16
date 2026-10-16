package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.ServiceSettings;
import com.autonavi.aps.amapapi.config.Const;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class f6<T, V> extends e6<T, V> {
    public f6(Context context, T t8) {
        super(context, t8);
    }

    public String c(String str) {
        String[] split = str.split(Const.STR_MART_ADD);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            if (str2 != null) {
                try {
                    str2 = URLDecoder.decode(str2, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    d6.a(e, "ProtocalHandler", "strReEncoder");
                    str2 = "";
                    stringBuffer.append(str2);
                    stringBuffer.append(Const.STR_MART_ADD);
                } catch (Exception e10) {
                    d6.a(e10, "ProtocalHandler", "strReEncoderException");
                    str2 = "";
                    stringBuffer.append(str2);
                    stringBuffer.append(Const.STR_MART_ADD);
                }
            }
            stringBuffer.append(str2);
            stringBuffer.append(Const.STR_MART_ADD);
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    public String d(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            d6.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e10) {
            d6.a(e10, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    @Override // com.amap.api.col.p0003sl.e6
    public V g() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public byte[] getEntityBytes() {
        try {
            String h4 = h();
            StringBuffer stringBuffer = new StringBuffer();
            if (h4 != null) {
                stringBuffer.append(h4);
                stringBuffer.append(Const.STR_MART_ADD);
            }
            stringBuffer.append("language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String stringBuffer2 = stringBuffer.toString();
            String c9 = c(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String c10 = e9.c();
            stringBuffer3.append("&ts=" + c10);
            stringBuffer3.append("&scode=" + e9.a(this.f3987p, c10, c9));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th2) {
            d6.a(th2, "ProtocalHandler", "getEntity");
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.e6, com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 9.7.4");
        hashMap.put("X-INFO", e9.b(this.f3987p));
        hashMap.put("platinfo", "platform=Android&sdkversion=9.7.4&product=sea");
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    public abstract String h();
}
