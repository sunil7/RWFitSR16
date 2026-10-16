package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.fa;
import com.amap.api.col.p0003sl.g9;
import com.amap.api.col.p0003sl.n9;

/* loaded from: classes.dex */
public class UrlUtil {
    public static final String AMAP_HOST_ALOC_CONTROL_PLUS_AMAP_COM = "aloc-control-plus.amap.com";
    public static final String AMAP_HOST_ALOC_MODELDATA_AMAP_COM = "aloc-modeldata.amap.com";
    public static final String AMAP_HOST_ALOC_OFFLINE_AMAP_COM = "aloc-offline.amap.com";
    public static final String AMAP_HOST_APS_AMAP_COM = "aps.amap.com";
    public static final String AMAP_HOST_CGICOL_AMAP_COM = "cgicol.amap.com";
    public static final String AMAP_PATH_ALOC_UPDATABLE = "/aloc/updatable";
    public static final String AMAP_PATH_APS_R = "/APS/r";
    public static final String AMAP_PATH_COLLECTION_COLLECTDATA = "/collection/collectData";
    public static final String AMAP_PATH_DATAPIPELINE_UPLOADDATA = "/dataPipeline/uploadData";
    public static final String AMAP_PATH_LOADOFFLINEDATA_REPEATDATA = "/LoadOfflineData/repeatData";
    public static final String AMAP_PATH_MODEL_GET = "/model/get";
    public static final String OPEN_HOST_OUTOFCN_SERVER = "abroad.apilocate.amap.com";
    public static final String OPEN_HOST_PRE = "apilocate-pre-test.amap.com";
    public static final String OPEN_HOST_REL_V4 = "apilocate.amap.com";
    public static final String OPEN_HOST_REL_V6 = "dualstack-a.apilocate.amap.com";
    public static final String OPEN_PATH_ALOC_UPDATABLE = "/v5/aloc/updatable";
    public static final String OPEN_PATH_COLLECTION_COLLECTDATA = "/v5/collection/collectData";
    public static final String OPEN_PATH_DATAPIPELINE_UPLOADDATA = "/v5/dataPipeline/uploadData";
    public static final String OPEN_PATH_LOADOFFLINEDATA_REPEATDATA = "/v5/LoadOfflineData/repeatData";
    public static final String OPEN_PATH_MOBILE_BINARY = "/v5/mobile/binary";
    public static final String OPEN_PATH_MODEL_GET = "/v5/model/get";
    public static final int TYPE_IPV4 = 0;
    public static final int TYPE_IPV6 = 1;

    private static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "?&key=" + b9.e(context);
        }
        StringBuilder r = e.r("?", str, "&key=");
        r.append(b9.e(context));
        return r.toString();
    }

    public static String getHost(Context context, int i3) {
        g9 b3 = g9.b(context);
        String a3 = b3.a(43);
        int i10 = n9.f4707d;
        return fa.a(context, false) ? b3.a(40) : i3 != 1 ? a3 : b3.a(44);
    }

    public static boolean isNeedTransform(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(AMAP_PATH_APS_R) || str.contains(AMAP_PATH_LOADOFFLINEDATA_REPEATDATA) || str.contains(AMAP_PATH_DATAPIPELINE_UPLOADDATA) || str.contains(AMAP_PATH_MODEL_GET) || str.contains(AMAP_PATH_COLLECTION_COLLECTDATA) || str.contains(AMAP_PATH_ALOC_UPDATABLE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0072 A[Catch: MalformedURLException -> 0x00b7, TRY_ENTER, TRY_LEAVE, TryCatch #0 {MalformedURLException -> 0x00b7, blocks: (B:3:0x0005, B:5:0x002a, B:7:0x0064, B:10:0x00a8, B:14:0x0072, B:17:0x007d, B:20:0x0088, B:23:0x0093, B:26:0x009e, B:29:0x0030, B:31:0x0038, B:32:0x003d, B:34:0x0045, B:35:0x004a, B:37:0x0052, B:38:0x0057, B:40:0x005f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String urlTransform(android.content.Context r4, int r5, java.lang.String r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.net.URL r1 = new java.net.URL     // Catch: java.net.MalformedURLException -> Lb7
            r1.<init>(r6)     // Catch: java.net.MalformedURLException -> Lb7
            java.lang.String r6 = r1.getHost()     // Catch: java.net.MalformedURLException -> Lb7
            java.lang.String r2 = r1.getPath()     // Catch: java.net.MalformedURLException -> Lb7
            java.lang.String r3 = r1.getQuery()     // Catch: java.net.MalformedURLException -> Lb7
            java.lang.String r1 = r1.getProtocol()     // Catch: java.net.MalformedURLException -> Lb7
            r0.append(r1)     // Catch: java.net.MalformedURLException -> Lb7
            java.lang.String r1 = "://"
            r0.append(r1)     // Catch: java.net.MalformedURLException -> Lb7
            java.lang.String r1 = "aps.amap.com"
            boolean r1 = android.text.TextUtils.equals(r1, r6)     // Catch: java.net.MalformedURLException -> Lb7
            if (r1 == 0) goto L30
            java.lang.String r5 = getHost(r4, r5)     // Catch: java.net.MalformedURLException -> Lb7
        L2e:
            r6 = r5
            goto L64
        L30:
            java.lang.String r1 = "aloc-offline.amap.com"
            boolean r1 = android.text.TextUtils.equals(r1, r6)     // Catch: java.net.MalformedURLException -> Lb7
            if (r1 == 0) goto L3d
            java.lang.String r5 = getHost(r4, r5)     // Catch: java.net.MalformedURLException -> Lb7
            goto L2e
        L3d:
            java.lang.String r1 = "cgicol.amap.com"
            boolean r1 = android.text.TextUtils.equals(r1, r6)     // Catch: java.net.MalformedURLException -> Lb7
            if (r1 == 0) goto L4a
            java.lang.String r5 = getHost(r4, r5)     // Catch: java.net.MalformedURLException -> Lb7
            goto L2e
        L4a:
            java.lang.String r1 = "aloc-modeldata.amap.com"
            boolean r1 = android.text.TextUtils.equals(r1, r6)     // Catch: java.net.MalformedURLException -> Lb7
            if (r1 == 0) goto L57
            java.lang.String r5 = getHost(r4, r5)     // Catch: java.net.MalformedURLException -> Lb7
            goto L2e
        L57:
            java.lang.String r1 = "aloc-control-plus.amap.com"
            boolean r1 = android.text.TextUtils.equals(r1, r6)     // Catch: java.net.MalformedURLException -> Lb7
            if (r1 == 0) goto L64
            java.lang.String r5 = getHost(r4, r5)     // Catch: java.net.MalformedURLException -> Lb7
            goto L2e
        L64:
            r0.append(r6)     // Catch: java.net.MalformedURLException -> Lb7
            java.lang.String r5 = "/APS/r"
            boolean r5 = android.text.TextUtils.equals(r5, r2)     // Catch: java.net.MalformedURLException -> Lb7
            if (r5 == 0) goto L72
            java.lang.String r2 = "/v5/mobile/binary"
            goto La8
        L72:
            java.lang.String r5 = "/LoadOfflineData/repeatData"
            boolean r5 = android.text.TextUtils.equals(r5, r2)     // Catch: java.net.MalformedURLException -> Lb7
            if (r5 == 0) goto L7d
            java.lang.String r2 = "/v5/LoadOfflineData/repeatData"
            goto La8
        L7d:
            java.lang.String r5 = "/dataPipeline/uploadData"
            boolean r5 = android.text.TextUtils.equals(r5, r2)     // Catch: java.net.MalformedURLException -> Lb7
            if (r5 == 0) goto L88
            java.lang.String r2 = "/v5/dataPipeline/uploadData"
            goto La8
        L88:
            java.lang.String r5 = "/model/get"
            boolean r5 = android.text.TextUtils.equals(r5, r2)     // Catch: java.net.MalformedURLException -> Lb7
            if (r5 == 0) goto L93
            java.lang.String r2 = "/v5/model/get"
            goto La8
        L93:
            java.lang.String r5 = "/collection/collectData"
            boolean r5 = android.text.TextUtils.equals(r5, r2)     // Catch: java.net.MalformedURLException -> Lb7
            if (r5 == 0) goto L9e
            java.lang.String r2 = "/v5/collection/collectData"
            goto La8
        L9e:
            java.lang.String r5 = "/aloc/updatable"
            boolean r5 = android.text.TextUtils.equals(r5, r2)     // Catch: java.net.MalformedURLException -> Lb7
            if (r5 == 0) goto La8
            java.lang.String r2 = "/v5/aloc/updatable"
        La8:
            r0.append(r2)     // Catch: java.net.MalformedURLException -> Lb7
            java.lang.String r4 = a(r4, r3)     // Catch: java.net.MalformedURLException -> Lb7
            r0.append(r4)     // Catch: java.net.MalformedURLException -> Lb7
            java.lang.String r4 = r0.toString()     // Catch: java.net.MalformedURLException -> Lb7
            return r4
        Lb7:
            r4 = move-exception
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.UrlUtil.urlTransform(android.content.Context, int, java.lang.String):java.lang.String");
    }
}
