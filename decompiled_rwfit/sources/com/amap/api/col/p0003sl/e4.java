package com.amap.api.col.p0003sl;

import com.autonavi.aps.amapapi.config.Const;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class e4 extends b4 {
    public e4() {
        setProxy(e9.d(a1.f3562f));
        setConnectionTimeout(5000);
        setSoTimeout(50000);
    }

    public String appendTsScode(String str) {
        String[] split = str.split(Const.STR_MART_ADD);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            if (str2 != null) {
                try {
                    str2 = URLDecoder.decode(str2, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    ka.a(e, "AbstractProtocalHandler", "strReEncoder");
                    str2 = "";
                    stringBuffer.append(str2);
                    stringBuffer.append(Const.STR_MART_ADD);
                } catch (Exception e10) {
                    ka.a(e10, "AbstractProtocalHandler", "strReEncoderException");
                    str2 = "";
                    stringBuffer.append(str2);
                    stringBuffer.append(Const.STR_MART_ADD);
                }
            }
            stringBuffer.append(str2);
            stringBuffer.append(Const.STR_MART_ADD);
        }
        String stringBuffer2 = stringBuffer.toString();
        String str3 = stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(str);
        String c9 = e9.c();
        stringBuffer3.append("&ts=" + c9);
        stringBuffer3.append("&scode=" + e9.a(a1.f3562f, c9, str3));
        return stringBuffer3.toString();
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getIPV6URL() {
        String url = getURL();
        String str = "http://" + g9.b(a1.f3562f).a(41);
        if (url == null) {
            return url;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("/v4/gridmap?");
        return url.contains(sb2.toString()) ? v4.a(url, a1.f3562f) : url;
    }

    @Override // com.amap.api.col.p0003sl.b4, com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", v0.f5168c);
        hashtable.put("Accept-Encoding", "gzip");
        Locale locale = Locale.US;
        hashtable.put("platinfo", "platform=Android&sdkversion=11.1.063&product=3dmap");
        hashtable.put("x-INFO", e9.c(a1.f3562f));
        hashtable.put("key", b9.e(a1.f3562f));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public boolean isSupportIPV6() {
        String url = getURL();
        String str = "http://" + g9.b(a1.f3562f).a(41);
        if (url == null) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("/v4/gridmap?");
        return url.contains(sb2.toString());
    }
}
