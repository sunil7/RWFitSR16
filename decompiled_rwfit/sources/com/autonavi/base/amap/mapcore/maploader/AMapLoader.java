package com.autonavi.base.amap.mapcore.maploader;

import android.content.Context;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.b4;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.e9;
import com.amap.api.col.p0003sl.f9;
import com.amap.api.col.p0003sl.g9;
import com.amap.api.col.p0003sl.h9;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.kb;
import com.amap.api.col.p0003sl.m9;
import com.amap.api.col.p0003sl.n9;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.col.p0003sl.w4;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.ae.gmap.NetworkProxyManager;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import r5.a;

/* loaded from: classes.dex */
public class AMapLoader implements kb.a {
    private static final int GET_METHOD = 0;
    private static final String NETWORK_RESPONSE_CODE_STRING = "网络异常状态码：";
    private Context context;
    private kb downloadManager;
    private volatile boolean isCanceled;
    private ADataRequestParam mDataRequestParam;
    private NetworkProxyManager networkProxyManager;
    private long requestMapDataTimestamp = 0;
    private long requestMapDataPackageSize = 0;

    public static class ADataRequestParam {
        public int bodyType;
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public byte[] requestUrl;
        public Map<String, String> headers = new LinkedHashMap();
        public Map<String, String> queries = new LinkedHashMap();
        public List<String> signs = new ArrayList();

        public String toString() {
            StringBuilder sb2 = new StringBuilder("ADataRequestParam{requestBaseUrl='");
            sb2.append(this.requestBaseUrl);
            sb2.append("', requestUrl='");
            sb2.append(this.requestUrl);
            sb2.append("', headers=");
            sb2.append(this.headers);
            sb2.append(", queries=");
            sb2.append(this.queries);
            sb2.append(", signs=");
            sb2.append(this.signs);
            sb2.append(", handler=");
            sb2.append(this.handler);
            sb2.append(", nRequestType=");
            sb2.append(this.nRequestType);
            sb2.append(", enCodeString=");
            sb2.append(Arrays.toString(this.enCodeString));
            sb2.append(", nCompress=");
            sb2.append(this.nCompress);
            sb2.append(", bodyType=");
            return e.m(sb2, this.bodyType, '}');
        }
    }

    public static abstract class AMapDownloadRequest extends b4 {
        protected final Context context;
        protected ADataRequestParam dataRequestParam;
        protected String userAgent;
        protected String url = buildUrl();
        protected byte[] postEntityBytes = buildParams();

        public AMapDownloadRequest(Context context, String str, ADataRequestParam aDataRequestParam) {
            this.context = context;
            this.userAgent = str;
            this.dataRequestParam = aDataRequestParam;
            int i3 = aDataRequestParam.nRequestType;
            RequestType requestType = RequestType.GET;
            this.isPostFlag = i3 == 1;
        }

        public abstract byte[] buildParams();

        public abstract String buildUrl();

        @Override // com.amap.api.col.p0003sl.pb
        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getIPV6URL() {
            return isSupportIPV6() ? v4.a(getURL(), this.context) : this.url;
        }

        @Override // com.amap.api.col.p0003sl.b4, com.amap.api.col.p0003sl.pb
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public Map<String, String> getRequestHead() {
            m9 b3 = v4.b();
            String e = b3 != null ? b3.e() : null;
            String e10 = b9.e(this.context);
            try {
                e10 = URLEncoder.encode(e10, "UTF-8");
            } catch (Throwable unused) {
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            Locale locale = Locale.US;
            hashtable.put("platinfo", "platform=Android&sdkversion=" + e + "&product=3dmap");
            hashtable.put("x-INFO", e9.c(this.context));
            hashtable.put("key", e10);
            hashtable.put("logversion", "2.1");
            hashtable.putAll(this.dataRequestParam.headers);
            return hashtable;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getURL() {
            return this.url;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public boolean isSupportIPV6() {
            return true;
        }
    }

    public static class AMapM5DownloadRequest extends AMapDownloadRequest {
        public AMapM5DownloadRequest(Context context, String str, ADataRequestParam aDataRequestParam) {
            super(context, str, aDataRequestParam);
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest
        public byte[] buildParams() {
            String replaceAll = new String(this.dataRequestParam.requestUrl).replaceAll(Const.STR_MART_SEMICOLON, AMapLoader.getEncodeRequestParams(Const.STR_MART_SEMICOLON));
            StringBuilder sb2 = new StringBuilder(replaceAll);
            sb2.append("&channel=amap7&div=GNaviMap&diu=");
            sb2.append(f9.f(this.context));
            if (!replaceAll.contains("&sign=")) {
                String generateAosSign = AMapLoader.generateAosSign(this.dataRequestParam.signs, sb2.toString());
                if (!TextUtils.isEmpty(generateAosSign)) {
                    sb2.append("&sign=");
                    sb2.append(generateAosSign.toUpperCase());
                }
            }
            return sb2.toString().getBytes(StandardCharsets.UTF_8);
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest
        public String buildUrl() {
            String str = this.dataRequestParam.requestBaseUrl;
            if (!str.endsWith("?")) {
                str = str.concat("?");
            }
            StringBuilder sb2 = new StringBuilder();
            int i3 = this.dataRequestParam.nRequestType;
            RequestType requestType = RequestType.GET;
            if (i3 == 1) {
                sb2.append("csid=");
                sb2.append(UUID.randomUUID().toString());
            }
            StringBuilder t8 = l0.t(str);
            t8.append(AMapLoader.generateQueryString(this.context, sb2.toString()));
            return t8.toString();
        }
    }

    public static class AMapMpsDownloadRequest extends AMapDownloadRequest {
        public AMapMpsDownloadRequest(Context context, String str, ADataRequestParam aDataRequestParam) {
            super(context, str, aDataRequestParam);
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest
        public byte[] buildParams() {
            StringBuilder sb2 = new StringBuilder(new String(this.dataRequestParam.requestUrl).replaceAll(Const.STR_MART_SEMICOLON, AMapLoader.getEncodeRequestParams(Const.STR_MART_SEMICOLON)));
            sb2.append("&div=GNaviMap&channel=amapapi&diu=");
            sb2.append(f9.f(this.context));
            String generateAosSign = AMapLoader.generateAosSign(this.dataRequestParam.signs, sb2.toString());
            if (!TextUtils.isEmpty(generateAosSign)) {
                sb2.append("&sign=");
                sb2.append(generateAosSign.toUpperCase());
            }
            return sb2.toString().getBytes();
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest
        public String buildUrl() {
            String str = this.dataRequestParam.requestBaseUrl;
            if (!str.endsWith("?")) {
                str = str.concat("?");
            }
            StringBuilder sb2 = new StringBuilder();
            int i3 = this.dataRequestParam.nRequestType;
            RequestType requestType = RequestType.GET;
            if (i3 == 1) {
                sb2.append("csid=");
                sb2.append(UUID.randomUUID().toString());
            }
            StringBuilder t8 = l0.t(str);
            t8.append(AMapLoader.generateQueryString(this.context, sb2.toString()));
            return t8.toString();
        }
    }

    public static class AMapRenderCDNRequest extends AMapDownloadRequest {
        public AMapRenderCDNRequest(Context context, String str, ADataRequestParam aDataRequestParam) {
            super(context, str, aDataRequestParam);
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest
        public byte[] buildParams() {
            return new byte[0];
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest
        public String buildUrl() {
            String str;
            String str2 = this.dataRequestParam.requestBaseUrl;
            int i3 = 0;
            if (!str2.contains("?")) {
                str2 = str2.substring(0, this.dataRequestParam.requestBaseUrl.length() - 1);
                if (!str2.endsWith("?")) {
                    str2 = str2.concat("?");
                }
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.dataRequestParam.queries.size() > 0) {
                for (Map.Entry<String, String> entry : this.dataRequestParam.queries.entrySet()) {
                    sb2.append(entry.getKey());
                    sb2.append("=");
                    sb2.append(entry.getValue());
                    if (i3 != this.dataRequestParam.queries.size() - 1) {
                        sb2.append(Const.STR_MART_ADD);
                    }
                    i3++;
                }
            }
            int i10 = this.dataRequestParam.bodyType;
            RequestBodyType requestBodyType = RequestBodyType.CUSTOM;
            if (i10 != 0) {
                return str2;
            }
            StringBuilder sb3 = new StringBuilder("channel=amap7&div=GNaviMap&diu=");
            sb3.append(f9.f(this.context));
            String generateAosSign = AMapLoader.generateAosSign(this.dataRequestParam.signs, sb3.toString());
            if (!TextUtils.isEmpty(generateAosSign)) {
                sb3.append("&sign=");
                sb3.append(generateAosSign.toUpperCase());
            }
            try {
                str = URLEncoder.encode(h9.c(w4.a(sb3.toString().getBytes(), n9.b("KTFhsdldhb3NNY0pDSndWbg==").getBytes())), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                str = null;
            }
            if (str != null) {
                sb2.append("&in=");
                sb2.append(str);
            }
            sb2.append("&ent=2&dip=16300");
            return str2 + ((Object) sb2);
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest, com.amap.api.col.p0003sl.pb
        public boolean isSupportIPV6() {
            return false;
        }
    }

    public static class AMapRenderDownloadRequest extends AMapDownloadRequest {
        public AMapRenderDownloadRequest(Context context, String str, ADataRequestParam aDataRequestParam) {
            super(context, str, aDataRequestParam);
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest
        public byte[] buildParams() {
            ADataRequestParam aDataRequestParam = this.dataRequestParam;
            int i3 = aDataRequestParam.bodyType;
            RequestBodyType requestBodyType = RequestBodyType.CUSTOM;
            return i3 == 0 ? h9.c(w4.a(aDataRequestParam.requestUrl, n9.b("KTFhsdldhb3NNY0pDSndWbg==").getBytes())).getBytes(StandardCharsets.UTF_8) : new byte[0];
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest
        public String buildUrl() {
            String str;
            String str2 = this.dataRequestParam.requestBaseUrl;
            if (str2.contains("?")) {
                if (!str2.endsWith(Const.STR_MART_ADD)) {
                    str2 = str2.concat(Const.STR_MART_ADD);
                }
            } else if (!str2.endsWith("?")) {
                str2 = str2.concat("?");
            }
            StringBuilder sb2 = new StringBuilder();
            int i3 = this.dataRequestParam.nRequestType;
            RequestType requestType = RequestType.GET;
            if (i3 == 1) {
                sb2.append("csid=");
                sb2.append(UUID.randomUUID().toString());
            }
            int i10 = this.dataRequestParam.bodyType;
            RequestBodyType requestBodyType = RequestBodyType.CUSTOM;
            if (i10 != 0) {
                return str2;
            }
            StringBuilder sb3 = new StringBuilder("channel=amap7&div=GNaviMap&adiu=");
            sb3.append(f9.f(this.context));
            sb3.append("&diu=");
            sb3.append(f9.f(this.context));
            String generateAosSign = AMapLoader.generateAosSign(this.dataRequestParam.signs, sb3.toString());
            if (!TextUtils.isEmpty(generateAosSign)) {
                sb3.append("&sign=");
                sb3.append(generateAosSign.toUpperCase());
            }
            try {
                str = URLEncoder.encode(h9.c(w4.a(sb3.toString().getBytes(), n9.b("KTFhsdldhb3NNY0pDSndWbg==").getBytes())), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                str = null;
            }
            if (str != null) {
                sb2.append("&in=");
                sb2.append(str);
            }
            sb2.append("&ent=2");
            return str2 + AMapLoader.generateQueryString(this.context, sb2.toString());
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest, com.amap.api.col.p0003sl.pb
        public boolean isSupportIPV6() {
            return false;
        }
    }

    public static class AMapRestRequest extends AMapDownloadRequest {
        public AMapRestRequest(Context context, String str, ADataRequestParam aDataRequestParam) {
            super(context, str, aDataRequestParam);
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest
        public byte[] buildParams() {
            return this.dataRequestParam.requestUrl;
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest
        public String buildUrl() {
            String str;
            String str2;
            String[] split = this.dataRequestParam.requestBaseUrl.split("\\?");
            if (split.length > 1) {
                str = split[0];
                str2 = split[1];
            } else {
                str = split[0];
                str2 = "";
            }
            StringBuilder u10 = l0.u(str2, "&adiu=");
            u10.append(f9.f(this.context));
            return a.c(str, "?", AMapLoader.generateQueryString(this.context, e.l(u10.toString(), "&div=GNaviMap")));
        }

        @Override // com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapDownloadRequest, com.amap.api.col.p0003sl.pb
        public Map<String, String> getRequestHead() {
            return super.getRequestHead();
        }
    }

    public enum RequestBodyType {
        CUSTOM,
        FORM
    }

    public enum RequestType {
        GET,
        POST
    }

    public AMapLoader(Context context, ADataRequestParam aDataRequestParam, NetworkProxyManager networkProxyManager) {
        this.isCanceled = false;
        this.context = context.getApplicationContext();
        this.mDataRequestParam = aDataRequestParam;
        this.networkProxyManager = networkProxyManager;
        this.isCanceled = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateAosSign(List<String> list, String str) {
        String b3 = n9.b("QMTA3MWEyYTRlM2d0ZTJVYzMyY1kzYTk4VGYzM0gxYzRHYzIzZg==");
        ArrayList arrayList = new ArrayList();
        LinkedHashMap<String, String> a3 = v4.a(str, "=");
        for (String str2 : list) {
            if (a3.containsKey(str2)) {
                arrayList.add(a3.get(str2));
            }
        }
        return generateAosSignInternal(arrayList, b3);
    }

    private static String generateAosSignInternal(List<String> list, String str) {
        StringBuilder sb2 = new StringBuilder("");
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
            }
            sb2.append("@");
            sb2.append(str);
            return e9.a(sb2.toString());
        } catch (Throwable th2) {
            ka.a(th2, "AbstractProtocalHandler", "generateAosSignInternal");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateQueryString(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        String e = b9.e(context);
        try {
            e = URLEncoder.encode(e, "UTF-8");
        } catch (Throwable unused) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(e);
        stringBuffer.append("&dip=16300");
        String sortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        String c9 = e9.c();
        stringBuffer.append("&ts=" + c9);
        stringBuffer.append("&scode=" + e9.a(context, c9, sortReEncoderParams));
        return stringBuffer.toString();
    }

    private String getDomainAndPath(String str) {
        try {
            URL url = new URL(str);
            return url.getHost() + url.getPath();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getNetworkFailedReason(String str) {
        return !this.networkProxyManager.isNetworkConnected() ? "无网络" : str;
    }

    private void onCancel() {
        ADataRequestParam aDataRequestParam = this.mDataRequestParam;
        if (aDataRequestParam != null) {
            this.networkProxyManager.netCancel(aDataRequestParam.handler, -1);
        }
    }

    private static String sortReEncoderParams(String str) {
        String[] split = str.split(Const.STR_MART_ADD);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(strReEncoder(str2));
            stringBuffer.append(Const.STR_MART_ADD);
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private void staticNetworkPerformance() {
    }

    private static String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            ka.a(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e10) {
            ka.a(e10, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public void doCancel() {
        if (this.downloadManager == null || this.isCanceled) {
            return;
        }
        synchronized (this.downloadManager) {
            try {
                this.isCanceled = true;
                this.downloadManager.a();
            } finally {
            }
        }
    }

    public void doCancelAndNotify() {
        onCancel();
        doCancel();
    }

    public void doRequest() {
        b4 aMapRenderCDNRequest;
        if (k9.a(this.context, v4.b()).f4490a != k9.e.SuccessCode) {
            ADataRequestParam aDataRequestParam = this.mDataRequestParam;
            if (aDataRequestParam != null) {
                this.networkProxyManager.netError(aDataRequestParam.handler, -1, -1);
                return;
            }
            return;
        }
        if (this.isCanceled) {
            ADataRequestParam aDataRequestParam2 = this.mDataRequestParam;
            if (aDataRequestParam2 != null) {
                this.networkProxyManager.netError(aDataRequestParam2.handler, -1, -1);
                return;
            }
            return;
        }
        if (MapsInitializer.isLoadWorldVectorMap() && this.networkProxyManager.isLocationOversea() && !this.networkProxyManager.isOverseaAuthed()) {
            ADataRequestParam aDataRequestParam3 = this.mDataRequestParam;
            if (aDataRequestParam3 != null) {
                this.networkProxyManager.netError(aDataRequestParam3.handler, -1, -1);
                return;
            }
            return;
        }
        String str = this.mDataRequestParam.requestBaseUrl;
        g9 b3 = g9.b(this.context);
        String str2 = "http://" + b3.a(24) + "/";
        String str3 = "http://" + b3.a(25) + "/";
        String str4 = "http://" + b3.a(20) + "/";
        int i3 = this.mDataRequestParam.nRequestType;
        RequestType requestType = RequestType.GET;
        if (i3 == 1) {
            String str5 = "http://" + b3.a(21) + "/";
            String str6 = "http://" + b3.a(41) + "/";
            String str7 = "http://" + b3.a(23);
            if (str.contains(getDomainAndPath(str5))) {
                aMapRenderCDNRequest = new AMapMpsDownloadRequest(this.context, this.networkProxyManager.getUserAgent(), this.mDataRequestParam);
            } else if (str.contains(getDomainAndPath(str7))) {
                aMapRenderCDNRequest = new AMapM5DownloadRequest(this.context, this.networkProxyManager.getUserAgent(), this.mDataRequestParam);
            } else if (str.contains(getDomainAndPath(str4))) {
                aMapRenderCDNRequest = new AMapRenderDownloadRequest(this.context, this.networkProxyManager.getUserAgent(), this.mDataRequestParam);
            } else {
                if (str.contains(getDomainAndPath(str6))) {
                    aMapRenderCDNRequest = new AMapRestRequest(this.context, this.networkProxyManager.getUserAgent(), this.mDataRequestParam);
                }
                aMapRenderCDNRequest = null;
            }
        } else {
            if (str.contains(getDomainAndPath(str4)) || str.contains(getDomainAndPath(str3)) || str.contains(getDomainAndPath(str2))) {
                aMapRenderCDNRequest = new AMapRenderCDNRequest(this.context, this.networkProxyManager.getUserAgent(), this.mDataRequestParam);
            }
            aMapRenderCDNRequest = null;
        }
        b4 b4Var = aMapRenderCDNRequest;
        if (b4Var == null) {
            ADataRequestParam aDataRequestParam4 = this.mDataRequestParam;
            if (aDataRequestParam4 != null) {
                this.networkProxyManager.netError(aDataRequestParam4.handler, -1, -1);
                return;
            }
            return;
        }
        try {
            b4Var.setConnectionTimeout(Const.I_LOC_JUMP_DELAY);
            b4Var.setSoTimeout(Const.I_LOC_JUMP_DELAY);
            this.requestMapDataTimestamp = System.currentTimeMillis();
            this.requestMapDataPackageSize = b4Var.getEntityBytes() == null ? 0L : b4Var.getEntityBytes().length;
            if (!str.contains(getDomainAndPath(str4)) && !str.contains(getDomainAndPath(str3)) && !str.contains(getDomainAndPath(str2))) {
                kb kbVar = new kb(b4Var, 0L, -1L, MapsInitializer.getProtocol() == 2);
                this.downloadManager = kbVar;
                kbVar.a(this);
            }
            onDownload(b4Var.makeHttpRequestWithInterrupted(), r0.length);
            onFinish();
        } catch (Throwable th2) {
            try {
                onException(th2);
            } finally {
                doCancel();
            }
        }
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onDownload(byte[] bArr, long j4) {
        ADataRequestParam aDataRequestParam;
        if (bArr == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        this.networkProxyManager.receiveNetData(aDataRequestParam.handler, bArr, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
    
        if (r2 != null) goto L16;
     */
    @Override // com.amap.api.col.3sl.kb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onException(java.lang.Throwable r7) {
        /*
            r6 = this;
            java.lang.String r0 = "UTF-8"
            r1 = -1
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = r7.getMessage()     // Catch: java.lang.Throwable -> L31
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L31
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L31
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L31
            if (r0 != 0) goto L2b
            java.lang.String r0 = "网络异常状态码："
            int r0 = r2.indexOf(r0)     // Catch: java.lang.Throwable -> L31
            if (r0 == r1) goto L2b
            int r3 = r0 + 8
            int r0 = r0 + 11
            java.lang.String r0 = r2.substring(r3, r0)     // Catch: java.lang.Throwable -> L31
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L31
            goto L2c
        L2b:
            r0 = r1
        L2c:
            com.autonavi.base.amap.mapcore.maploader.AMapLoader$ADataRequestParam r2 = r6.mDataRequestParam
            if (r2 == 0) goto L3d
            goto L36
        L31:
            com.autonavi.base.amap.mapcore.maploader.AMapLoader$ADataRequestParam r2 = r6.mDataRequestParam
            if (r2 == 0) goto L3d
            r0 = r1
        L36:
            com.autonavi.base.ae.gmap.NetworkProxyManager r3 = r6.networkProxyManager
            long r4 = r2.handler
            r3.netError(r4, r1, r0)
        L3d:
            java.lang.String r0 = "AMapLoader"
            java.lang.String r1 = "download onException"
            com.amap.api.col.p0003sl.ka.a(r7, r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "map loader exception "
            r0.<init>(r1)
            java.lang.String r7 = r7.getMessage()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "[map][network]"
            com.amap.api.col.p0003sl.y4.a(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.maploader.AMapLoader.onException(java.lang.Throwable):void");
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onFinish() {
        ADataRequestParam aDataRequestParam = this.mDataRequestParam;
        if (aDataRequestParam != null) {
            this.networkProxyManager.finishDownLoad(aDataRequestParam.handler);
        }
        staticNetworkPerformance();
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onStop() {
        ADataRequestParam aDataRequestParam = this.mDataRequestParam;
        if (aDataRequestParam != null) {
            this.networkProxyManager.netStop(aDataRequestParam.handler, -1);
        }
        staticNetworkPerformance();
    }
}
