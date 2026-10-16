package com.autonavi.aps.amapapi.trans;

import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class Parser {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f6782a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    private AMapLocationClientOption f6783b = new AMapLocationClientOption();

    private void a(AMapLocationServer aMapLocationServer, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str2)) {
            if (this.f6783b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
                if (!str2.equals(str)) {
                    sb2.append(str2);
                    sb2.append(" ");
                }
            } else if (!str.contains(Const.STR_KEY_WORD_CITY) || !str.equals(str2)) {
                sb2.append(str2);
                sb2.append(" ");
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(str3);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb2.append(str4);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb2.append(str5);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            if (TextUtils.isEmpty(str7) || this.f6783b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
                sb2.append("Near " + str6);
                aMapLocationServer.setDescription("Near " + str6);
            } else {
                sb2.append("靠近");
                sb2.append(str6);
                sb2.append(" ");
                aMapLocationServer.setDescription("在" + str6 + "附近");
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString(Const.JSON_KEY_CITYCODE, aMapLocationServer.getCityCode());
        bundle.putString("desc", sb2.toString());
        bundle.putString(Const.JSON_KEY_ADCODE, aMapLocationServer.getAdCode());
        aMapLocationServer.setExtras(bundle);
        aMapLocationServer.setDesc(sb2.toString());
        String adCode = aMapLocationServer.getAdCode();
        if (adCode == null || adCode.trim().length() <= 0 || this.f6783b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            aMapLocationServer.setAddress(sb2.toString());
        } else {
            aMapLocationServer.setAddress(sb2.toString().replace(" ", ""));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0285 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.autonavi.aps.amapapi.model.AMapLocationServer parseBinaryResult(com.autonavi.aps.amapapi.model.AMapLocationServer r17, byte[] r18, com.autonavi.aps.amapapi.AMapLocationStaticsEntity r19) {
        /*
            Method dump skipped, instructions count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.Parser.parseBinaryResult(com.autonavi.aps.amapapi.model.AMapLocationServer, byte[], com.autonavi.aps.amapapi.AMapLocationStaticsEntity):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        if (r3.length() <= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        r2.setCity(r3);
        r5 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081 A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:13:0x007b, B:15:0x0081, B:16:0x0087, B:19:0x00d3, B:20:0x00e5, B:22:0x00f1, B:23:0x0100, B:30:0x0071, B:32:0x0077), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3 A[Catch: all -> 0x0105, TRY_ENTER, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:13:0x007b, B:15:0x0081, B:16:0x0087, B:19:0x00d3, B:20:0x00e5, B:22:0x00f1, B:23:0x0100, B:30:0x0071, B:32:0x0077), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f1 A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:13:0x007b, B:15:0x0081, B:16:0x0087, B:19:0x00d3, B:20:0x00e5, B:22:0x00f1, B:23:0x0100, B:30:0x0071, B:32:0x0077), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.autonavi.aps.amapapi.model.AMapLocationServer parseGeoJsonResult(java.lang.String r13) {
        /*
            r12 = this;
            r0 = 0
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = new com.autonavi.aps.amapapi.model.AMapLocationServer     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = ""
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L105
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L105
            r1.<init>(r13)     // Catch: java.lang.Throwable -> L105
            java.lang.String r13 = "regeocode"
            org.json.JSONObject r13 = r1.optJSONObject(r13)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = "addressComponent"
            org.json.JSONObject r1 = r13.optJSONObject(r1)     // Catch: java.lang.Throwable -> L105
            java.lang.String r3 = "country"
            java.lang.String r3 = r1.optString(r3)     // Catch: java.lang.Throwable -> L105
            java.lang.String r3 = r12.a(r3)     // Catch: java.lang.Throwable -> L105
            r2.setCountry(r3)     // Catch: java.lang.Throwable -> L105
            java.lang.String r3 = "province"
            java.lang.String r3 = r1.optString(r3)     // Catch: java.lang.Throwable -> L105
            java.lang.String r3 = r12.a(r3)     // Catch: java.lang.Throwable -> L105
            r2.setProvince(r3)     // Catch: java.lang.Throwable -> L105
            java.lang.String r4 = "citycode"
            java.lang.String r4 = r1.optString(r4)     // Catch: java.lang.Throwable -> L105
            java.lang.String r4 = r12.a(r4)     // Catch: java.lang.Throwable -> L105
            r2.setCityCode(r4)     // Catch: java.lang.Throwable -> L105
            java.lang.String r5 = "city"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = "010"
            boolean r6 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> L105
            if (r6 != 0) goto L6f
            java.lang.String r6 = "021"
            boolean r6 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> L105
            if (r6 != 0) goto L6f
            java.lang.String r6 = "022"
            boolean r6 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> L105
            if (r6 != 0) goto L6f
            java.lang.String r6 = "023"
            boolean r4 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> L105
            if (r4 == 0) goto L67
            goto L6f
        L67:
            java.lang.String r5 = r12.a(r5)     // Catch: java.lang.Throwable -> L105
            r2.setCity(r5)     // Catch: java.lang.Throwable -> L105
            goto L7b
        L6f:
            if (r3 == 0) goto L7b
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L105
            if (r4 <= 0) goto L7b
            r2.setCity(r3)     // Catch: java.lang.Throwable -> L105
            r5 = r3
        L7b:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L105
            if (r4 == 0) goto L86
            r2.setCity(r3)     // Catch: java.lang.Throwable -> L105
            r4 = r3
            goto L87
        L86:
            r4 = r5
        L87:
            java.lang.String r5 = "district"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> L105
            java.lang.String r5 = r12.a(r5)     // Catch: java.lang.Throwable -> L105
            r2.setDistrict(r5)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = "adcode"
            java.lang.String r6 = r1.optString(r6)     // Catch: java.lang.Throwable -> L105
            java.lang.String r9 = r12.a(r6)     // Catch: java.lang.Throwable -> L105
            r2.setAdCode(r9)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = "streetNumber"
            org.json.JSONObject r1 = r1.optJSONObject(r6)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = "street"
            java.lang.String r6 = r1.optString(r6)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = r12.a(r6)     // Catch: java.lang.Throwable -> L105
            r2.setStreet(r6)     // Catch: java.lang.Throwable -> L105
            r2.setRoad(r6)     // Catch: java.lang.Throwable -> L105
            java.lang.String r7 = "number"
            java.lang.String r1 = r1.optString(r7)     // Catch: java.lang.Throwable -> L105
            java.lang.String r7 = r12.a(r1)     // Catch: java.lang.Throwable -> L105
            r2.setNumber(r7)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = "pois"
            org.json.JSONArray r1 = r13.optJSONArray(r1)     // Catch: java.lang.Throwable -> L105
            int r8 = r1.length()     // Catch: java.lang.Throwable -> L105
            java.lang.String r10 = "name"
            r11 = 0
            if (r8 <= 0) goto Le4
            org.json.JSONObject r1 = r1.getJSONObject(r11)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = r1.optString(r10)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = r12.a(r1)     // Catch: java.lang.Throwable -> L105
            r2.setPoiName(r1)     // Catch: java.lang.Throwable -> L105
            r8 = r1
            goto Le5
        Le4:
            r8 = r0
        Le5:
            java.lang.String r1 = "aois"
            org.json.JSONArray r13 = r13.optJSONArray(r1)     // Catch: java.lang.Throwable -> L105
            int r1 = r13.length()     // Catch: java.lang.Throwable -> L105
            if (r1 <= 0) goto L100
            org.json.JSONObject r13 = r13.getJSONObject(r11)     // Catch: java.lang.Throwable -> L105
            java.lang.String r13 = r13.optString(r10)     // Catch: java.lang.Throwable -> L105
            java.lang.String r13 = r12.a(r13)     // Catch: java.lang.Throwable -> L105
            r2.setAoiName(r13)     // Catch: java.lang.Throwable -> L105
        L100:
            r1 = r12
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L105
            return r2
        L105:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.Parser.parseGeoJsonResult(java.lang.String):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0099 A[Catch: all -> 0x006e, TRY_LEAVE, TryCatch #1 {all -> 0x006e, blocks: (B:11:0x005a, B:14:0x0067, B:17:0x0083, B:19:0x0099, B:26:0x0070), top: B:10:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.autonavi.aps.amapapi.model.AMapLocationServer paseAuthFailurJson(java.lang.String r10, android.content.Context r11, com.amap.api.col.p0003sl.qb r12, com.autonavi.aps.amapapi.AMapLocationStaticsEntity r13) {
        /*
            r9 = this;
            java.lang.String r0 = "#0701"
            java.lang.String r1 = "#0702"
            java.lang.String r2 = "status"
            java.lang.String r3 = "#csid#"
            com.autonavi.aps.amapapi.model.AMapLocationServer r4 = new com.autonavi.aps.amapapi.model.AMapLocationServer
            java.lang.String r5 = ""
            r4.<init>(r5)
            r5 = 7
            r4.setErrorCode(r5)
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>()
            r6 = 0
            java.lang.String r7 = "#SHA1AndPackage#"
            r5.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r11 = com.amap.api.col.p0003sl.b9.g(r11)     // Catch: java.lang.Throwable -> L5a
            r5.append(r11)     // Catch: java.lang.Throwable -> L5a
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11 = r12.f4928b     // Catch: java.lang.Throwable -> L5a
            java.lang.String r7 = "gsid"
            java.lang.Object r11 = r11.get(r7)     // Catch: java.lang.Throwable -> L5a
            java.util.List r11 = (java.util.List) r11     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r11 = r11.get(r6)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L5a
            boolean r7 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L5a
            if (r7 != 0) goto L43
            java.lang.String r7 = "#gsid#"
            r5.append(r7)     // Catch: java.lang.Throwable -> L5a
            r5.append(r11)     // Catch: java.lang.Throwable -> L5a
        L43:
            java.lang.String r11 = r12.f4929c     // Catch: java.lang.Throwable -> L5a
            boolean r7 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L5a
            if (r7 != 0) goto L5a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L5a
            r7.append(r11)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r11 = r7.toString()     // Catch: java.lang.Throwable -> L5a
            r5.append(r11)     // Catch: java.lang.Throwable -> L5a
        L5a:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6e
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L6e
            boolean r3 = r11.has(r2)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r7 = "info"
            if (r3 == 0) goto L70
            boolean r3 = r11.has(r7)     // Catch: java.lang.Throwable -> L6e
            if (r3 != 0) goto L83
            goto L70
        L6e:
            r10 = move-exception
            goto Lb2
        L70:
            r13.setReason(r1)     // Catch: java.lang.Throwable -> L6e
            java.lang.StringBuilder r3 = r9.f6782a     // Catch: java.lang.Throwable -> L6e
            java.lang.String r8 = "json is error:"
            r3.append(r8)     // Catch: java.lang.Throwable -> L6e
            r3.append(r10)     // Catch: java.lang.Throwable -> L6e
            r3.append(r5)     // Catch: java.lang.Throwable -> L6e
            r3.append(r1)     // Catch: java.lang.Throwable -> L6e
        L83:
            java.lang.String r10 = r11.getString(r2)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = r11.getString(r7)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r2 = "infocode"
            java.lang.String r11 = r11.getString(r2)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r2 = "0"
            boolean r10 = r2.equals(r10)     // Catch: java.lang.Throwable -> L6e
            if (r10 == 0) goto Ld2
            r13.setReason(r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.StringBuilder r10 = r9.f6782a     // Catch: java.lang.Throwable -> L6e
            java.lang.String r2 = "auth fail:"
            r10.append(r2)     // Catch: java.lang.Throwable -> L6e
            r10.append(r1)     // Catch: java.lang.Throwable -> L6e
            r10.append(r5)     // Catch: java.lang.Throwable -> L6e
            r10.append(r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r10 = r12.f4930d     // Catch: java.lang.Throwable -> L6e
            com.autonavi.aps.amapapi.utils.ReportUtil.reportLocError(r10, r11, r1)     // Catch: java.lang.Throwable -> L6e
            goto Ld2
        Lb2:
            java.lang.String r11 = "#0703"
            r13.setReason(r11)
            java.lang.StringBuilder r12 = r9.f6782a
            java.lang.String r13 = "json exception error:"
            r12.append(r13)
            java.lang.String r13 = r10.getMessage()
            r12.append(r13)
            r12.append(r5)
            r12.append(r11)
            java.lang.String r11 = "parser"
            java.lang.String r12 = "paseAuthFailurJson"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r10, r11, r12)
        Ld2:
            java.lang.StringBuilder r10 = r9.f6782a
            java.lang.String r10 = r10.toString()
            r4.setLocationDetail(r10)
            java.lang.StringBuilder r10 = r9.f6782a
            int r10 = r10.length()
            if (r10 <= 0) goto Lec
            java.lang.StringBuilder r10 = r9.f6782a
            int r11 = r10.length()
            r10.delete(r6, r11)
        Lec:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.Parser.paseAuthFailurJson(java.lang.String, android.content.Context, com.amap.api.col.3sl.qb, com.autonavi.aps.amapapi.AMapLocationStaticsEntity):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public void setOption(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.f6783b = new AMapLocationClientOption();
        } else {
            this.f6783b = aMapLocationClientOption;
        }
    }

    private String a(String str) {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(str) ? "" : str;
    }
}
