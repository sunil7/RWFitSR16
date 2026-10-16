package com.autonavi.aps.amapapi.trans;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.f9;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.restruct.Cgi;
import com.autonavi.aps.amapapi.restruct.CgiManager;
import com.autonavi.aps.amapapi.restruct.HistoryLocation;
import com.autonavi.aps.amapapi.restruct.HistoryLocationRecorder;
import com.autonavi.aps.amapapi.restruct.WifiInfoWrapper;
import com.autonavi.aps.amapapi.restruct.WifiManagerWrapper;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k3.a;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class Req {
    protected static String adiu;
    protected static String utdid;
    public String action = "1";
    protected short respctrl = 0;
    protected String src = null;
    protected String license = null;
    protected String srvip = null;
    protected String model = null;
    protected String os = null;
    public String appname = null;
    public String iscdma = null;
    protected String gtype = null;
    protected String gmock = null;
    protected String glon = null;
    protected String glat = null;
    protected String accu = null;
    protected String extrakey = null;
    protected String imeimeid = null;
    protected String imsi = null;
    protected String uuid = null;

    /* renamed from: id, reason: collision with root package name */
    protected String f6788id = null;
    protected String smac = null;
    protected String phnum = null;
    protected String sdkv = null;
    protected String colv = null;
    protected String nettype = null;
    protected String inftype = null;
    protected int cgiflag = 0;
    protected ArrayList<Cgi> cellsV1 = new ArrayList<>();
    protected ArrayList<Cgi> cellsV2 = new ArrayList<>();
    protected String networkOperator = null;
    protected String mmac = null;
    protected ArrayList<a> wifiScanResultList = new ArrayList<>();
    protected String macsage = null;
    protected String poiid = null;
    protected byte[] cor = null;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f6784a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f6785b = 0;
    protected String sCxtFromServer = null;
    protected String clientContext = null;
    protected String sn = null;
    protected String oaid = null;
    protected int mmacAge = 0;

    /* renamed from: c, reason: collision with root package name */
    private List<HistoryLocation> f6786c = null;

    /* renamed from: d, reason: collision with root package name */
    private List<Cgi> f6787d = Collections.synchronizedList(new ArrayList());

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:24:0x000c, B:8:0x001f, B:10:0x0022, B:12:0x002b, B:13:0x0033, B:3:0x0012, B:5:0x0017), top: B:23:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 6
            byte[] r2 = new byte[r1]
            r3 = 0
            if (r0 == 0) goto L12
            int r4 = r0.length     // Catch: java.lang.Throwable -> L10
            if (r4 == r1) goto L1e
            goto L12
        L10:
            r0 = move-exception
            goto L42
        L12:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L10
            r4 = r3
        L15:
            if (r4 >= r1) goto L1e
            java.lang.String r5 = "0"
            r0[r4] = r5     // Catch: java.lang.Throwable -> L10
            int r4 = r4 + 1
            goto L15
        L1e:
            r1 = r3
        L1f:
            int r4 = r0.length     // Catch: java.lang.Throwable -> L10
            if (r1 >= r4) goto L41
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L10
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L10
            r5 = 2
            if (r4 <= r5) goto L33
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L10
            java.lang.String r4 = r4.substring(r3, r5)     // Catch: java.lang.Throwable -> L10
            r0[r1] = r4     // Catch: java.lang.Throwable -> L10
        L33:
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L10
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch: java.lang.Throwable -> L10
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L10
            r2[r1] = r4     // Catch: java.lang.Throwable -> L10
            int r1 = r1 + 1
            goto L1f
        L41:
            return r2
        L42:
            java.lang.String r1 = "getMacBa "
            java.lang.String r7 = r1.concat(r7)
            java.lang.String r1 = "Req"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r7 = r6.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.Req.a(java.lang.String):byte[]");
    }

    public static void addHistoryCell(Cgi cgi, List<Cgi> list, int i3) {
        if (cgi == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(cgi);
            return;
        }
        int i10 = -1;
        long j4 = Format.OFFSET_SAMPLE_RELATIVE;
        int i11 = 0;
        int i12 = -1;
        while (true) {
            if (i11 >= size) {
                i10 = i12;
                break;
            }
            Cgi cgi2 = list.get(i11);
            if (cgi.getKeyWithDifferentApi() == null || !cgi.getKeyWithDifferentApi().equals(cgi2.getKeyWithDifferentApi())) {
                j4 = Math.min(j4, cgi2.lastUpdateUtcMills);
                if (j4 == cgi2.lastUpdateUtcMills) {
                    i12 = i11;
                }
                i11++;
            } else {
                int i13 = cgi.signalStrength;
                if (i13 != cgi2.signalStrength) {
                    cgi2.lastUpdateUtcMills = cgi.lastUpdateUtcMills;
                    cgi2.signalStrength = i13;
                }
            }
        }
        if (i10 >= 0) {
            if (size < i3) {
                list.add(cgi);
            } else {
                if (cgi.lastUpdateUtcMills <= j4 || i10 >= size) {
                    return;
                }
                list.remove(i10);
                list.add(cgi);
            }
        }
    }

    public static void save(byte[] bArr, int i3) {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(48:12|13|14|(18:283|284|(1:286)(1:388)|287|(7:289|(1:291)(1:365)|292|(1:294)(1:364)|295|(1:297)(1:363)|298)(12:(11:367|(1:369)(1:387)|370|(1:372)(1:386)|373|(1:375)(1:385)|376|(1:378)(1:384)|379|(1:381)(1:383)|382)|300|(1:302)(1:362)|(1:361)|305|(1:307)(1:360)|308|(1:310)|311|(1:313)(1:359)|314|(2:316|(2:318|319)(3:320|(11:322|(1:324)(1:354)|325|(1:327)(1:353)|328|(1:330)(1:352)|331|(1:351)|335|(1:350)(8:337|(1:339)(1:349)|340|(1:342)|343|(1:345)|346|347)|348)|355))(1:(2:357|319)(1:358)))|299|300|(0)(0)|(0)|361|305|(0)(0)|308|(0)|311|(0)(0)|314|(0)(0))(1:17)|18|(1:282)(42:22|23|24|25|(1:278)(4:28|(12:30|(3:81|(1:83)|84)(5:(3:37|(1:39)|40)(1:(3:76|(1:78)|79))|41|(1:74)|45|(4:64|(5:66|(1:68)|(1:70)|71|(2:73|61))|62|63)(4:51|(5:55|(1:57)|(1:59)|60|61)|62|63))|80|41|(1:43)|74|45|(1:47)|64|(0)|62|63)|85|86)|87|(1:277)(15:91|92|93|94|95|96|(1:98)|99|100|101|(1:270)(1:103)|104|105|(2:107|108)|110)|111|(1:113)(7:234|(1:236)(1:269)|(1:238)|239|(12:241|242|243|244|245|(1:263)(1:247)|248|249|(4:251|(1:253)(1:259)|(2:255|256)(1:258)|257)(1:262)|261|(0)(0)|257)|267|268)|114|115|116|(1:118)(3:226|(1:228)|(1:230)(30:231|232|120|121|122|123|(1:125)|126|127|128|(3:218|219|220)|130|131|132|133|134|135|136|(1:138)(1:213)|139|140|(1:142)|143|(5:145|(1:147)(1:185)|148|(5:151|152|(9:155|(5:162|(3:164|(1:166)|167)(4:171|(3:173|(1:175)|176)|169|170)|168|169|170)|177|(1:179)|180|168|169|170|153)|181|182)|150)|186|(4:188|(1:190)(1:206)|191|(3:193|(6:196|(1:198)|199|(2:201|202)(1:204)|203|194)|205))|207|(1:209)|210|211))|119|120|121|122|123|(0)|126|127|128|(0)|130|131|132|133|134|135|136|(0)(0)|139|140|(0)|143|(0)|186|(0)|207|(0)|210|211)|281|25|(0)|278|87|(1:89)|277|111|(0)(0)|114|115|116|(0)(0)|119|120|121|122|123|(0)|126|127|128|(0)|130|131|132|133|134|135|136|(0)(0)|139|140|(0)|143|(0)|186|(0)|207|(0)|210|211) */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x070f, code lost:
    
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0725, code lost:
    
        r2 = r2 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x06ed, code lost:
    
        r11[r0] = 0;
        r32 = 1;
        r2 = r0 + 1;
        r14 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0680, code lost:
    
        if (r7 < 0) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0657, code lost:
    
        if (r14 < (-128)) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0593, code lost:
    
        if (r0 < (-128)) goto L226;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x06c8 A[Catch: all -> 0x06ed, TryCatch #9 {all -> 0x06ed, blocks: (B:116:0x06c4, B:118:0x06c8, B:119:0x06d9, B:226:0x06cb, B:230:0x06d7, B:231:0x06e0), top: B:115:0x06c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0703 A[Catch: all -> 0x070f, TryCatch #10 {all -> 0x070f, blocks: (B:123:0x06fb, B:125:0x0703, B:127:0x0711), top: B:122:0x06fb }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x073f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0750  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0904  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0742  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0717 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x06cb A[Catch: all -> 0x06ed, TryCatch #9 {all -> 0x06ed, blocks: (B:116:0x06c4, B:118:0x06c8, B:119:0x06d9, B:226:0x06cb, B:230:0x06d7, B:231:0x06e0), top: B:115:0x06c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x068a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0376 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0228 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x053d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] buildBinary() {
        /*
            Method dump skipped, instructions count: 2355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.Req.buildBinary():byte[]");
    }

    public void createReq(Context context, boolean z5, boolean z6, CgiManager cgiManager, WifiManagerWrapper wifiManagerWrapper, ConnectivityManager connectivityManager, String str, String str2, boolean z8, HistoryLocationRecorder historyLocationRecorder) {
        String str3;
        String str4;
        int i3;
        NetworkInfo networkInfo;
        String str5;
        WifiManagerWrapper wifiManagerWrapper2;
        ArrayList<a> arrayList;
        int i10;
        String e = b9.e(context);
        int randomInt = Utils.randomInt(-32768, 32767);
        this.sCxtFromServer = str2;
        this.f6786c = null;
        if (z6) {
            str3 = CoreUtil.AMAP_SRC;
            str4 = CoreUtil.AMAP_LICENSE;
        } else {
            str3 = CoreUtil.STR_ORIGN_SRC;
            str4 = CoreUtil.STR_ORIGN_LICENSE;
        }
        String str6 = str4;
        String str7 = str3;
        StringBuilder sb2 = new StringBuilder();
        int cgiFlag = cgiManager.getCgiFlag();
        int mainCgiTypeMasked = cgiManager.getMainCgiTypeMasked();
        TelephonyManager telephonyManagerInstance = cgiManager.getTelephonyManagerInstance();
        ArrayList<Cgi> detectedCgiList = cgiManager.getDetectedCgiList();
        ArrayList<Cgi> detectedCgiV2List = cgiManager.getDetectedCgiV2List();
        ArrayList<a> scanResultsParam = wifiManagerWrapper.getScanResultsParam();
        String str8 = "1";
        String str9 = mainCgiTypeMasked == 2 ? "1" : "0";
        if (telephonyManagerInstance != null) {
            if (TextUtils.isEmpty(CoreUtil.strImeiMeid)) {
                try {
                    CoreUtil.strImeiMeid = f9.b();
                } catch (Throwable th2) {
                    CoreUtil.reportError(th2, "Aps", "getApsReq part4");
                }
            }
            i3 = randomInt;
            if (TextUtils.isEmpty(CoreUtil.strImeiMeid) && Build.VERSION.SDK_INT < 29) {
                CoreUtil.strImeiMeid = "888888888888888";
            }
            if (TextUtils.isEmpty(CoreUtil.strImsi)) {
                try {
                    f9.d dVar = f9.e;
                    CoreUtil.strImsi = "";
                } catch (SecurityException unused) {
                } catch (Throwable th3) {
                    CoreUtil.reportError(th3, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(CoreUtil.strImsi) && Build.VERSION.SDK_INT < 29) {
                CoreUtil.strImsi = "888888888888888";
            }
        } else {
            i3 = randomInt;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th4) {
            CoreUtil.reportError(th4, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean wifiAccess = wifiManagerWrapper.wifiAccess(connectivityManager);
        if (Utils.getNetT(networkInfo) != -1) {
            str5 = Utils.getNetMode(context, connectivityManager);
            if (wifiAccess) {
                str8 = "2";
            }
        } else {
            str5 = "";
            str8 = str5;
        }
        if ((cgiFlag & 4) != 4 || detectedCgiV2List.isEmpty()) {
            this.cellsV2.clear();
        } else {
            this.cellsV2.clear();
            this.cellsV2.addAll(detectedCgiV2List);
        }
        this.cellsV1.clear();
        this.cellsV1.addAll(detectedCgiList);
        StringBuilder sb3 = new StringBuilder();
        if (wifiManagerWrapper.isWifiEnabled()) {
            if (wifiAccess) {
                WifiInfoWrapper wifiAccess2 = wifiManagerWrapper.getWifiAccess();
                wifiManagerWrapper2 = wifiManagerWrapper;
                if (wifiManagerWrapper2.wifiUseful(wifiAccess2)) {
                    sb3.append(wifiAccess2.getBSSID());
                    sb3.append(Const.STR_MART_COMMA);
                    int rssi = wifiAccess2.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(Const.STR_MART_COMMA);
                    String ssid = wifiAccess2.getSSID();
                    try {
                        i10 = ssid.getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        i10 = 32;
                    }
                    if (i10 >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace("*", "."));
                }
            } else {
                wifiManagerWrapper2 = wifiManagerWrapper;
            }
            if (scanResultsParam != null && (arrayList = this.wifiScanResultList) != null) {
                arrayList.clear();
                this.wifiScanResultList.addAll(scanResultsParam);
            }
        } else {
            wifiManagerWrapper2 = wifiManagerWrapper;
            wifiManagerWrapper2.resetWifiData();
            ArrayList<a> arrayList2 = this.wifiScanResultList;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.respctrl = (short) 0;
        if (!z5) {
            this.respctrl = (short) 2;
        }
        if (z8) {
            this.respctrl = (short) (this.respctrl | 22);
        }
        this.src = str7;
        this.license = str6;
        this.model = Build.MODEL;
        this.os = "android" + Build.VERSION.RELEASE;
        this.appname = Utils.getAppName(context);
        this.iscdma = str9;
        this.gtype = "0";
        this.gmock = "0";
        this.glon = "0";
        this.glat = "0";
        this.accu = "0";
        this.extrakey = e;
        this.imeimeid = CoreUtil.strImeiMeid;
        this.imsi = CoreUtil.strImsi;
        this.f6788id = String.valueOf(i3);
        this.smac = Utils.getDeviceMac(context);
        this.sdkv = CoreUtil.STR_CONFIG_VERSION;
        this.colv = str;
        this.phnum = "";
        this.nettype = str5;
        this.inftype = str8;
        this.cgiflag = cgiFlag;
        this.networkOperator = cgiManager.getRawOperatorStr();
        this.macsage = wifiManagerWrapper2.getWifiAge();
        this.mmac = sb3.toString();
        this.mmacAge = (int) ((Utils.getTimeBoot() - wifiManagerWrapper2.getMMacUpdateTime()) / 1000);
        try {
            if (TextUtils.isEmpty(utdid)) {
                utdid = f9.t(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(adiu)) {
                adiu = f9.f(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.sn)) {
                f9.d dVar2 = f9.e;
                this.sn = "";
            }
        } catch (Throwable unused5) {
        }
        try {
            if (TextUtils.isEmpty(this.oaid)) {
                this.oaid = f9.q(context);
            }
        } catch (Throwable unused6) {
        }
        try {
            this.f6786c = historyLocationRecorder.produceContextContent(this.cellsV2, this.wifiScanResultList);
            ArrayList<Cgi> arrayList3 = this.cellsV1;
            ArrayList<Cgi> arrayList4 = this.cellsV2;
            if (arrayList4 != null && arrayList4.size() > 0) {
                int size = arrayList4.size();
                int i11 = 0;
                while (i11 < size) {
                    Cgi cgi = arrayList4.get(i11);
                    i11++;
                    Cgi cgi2 = cgi;
                    if (cgi2.newApi && cgi2.isMain) {
                        addHistoryCell(cgi2, this.f6787d, 3);
                        break;
                    }
                }
            }
            if (arrayList3 != null && arrayList3.size() > 0) {
                addHistoryCell(arrayList3.get(0), this.f6787d, 3);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        sb2.delete(0, sb2.length());
        sb3.delete(0, sb3.length());
    }

    public void a() {
        String[] strArr = new String[27];
        strArr[0] = this.action;
        strArr[1] = this.src;
        strArr[2] = this.license;
        strArr[3] = this.srvip;
        strArr[4] = this.model;
        strArr[5] = this.os;
        strArr[6] = this.appname;
        strArr[7] = this.iscdma;
        strArr[8] = this.glon;
        strArr[9] = this.glat;
        strArr[10] = this.accu;
        strArr[11] = this.extrakey;
        strArr[12] = this.imeimeid;
        strArr[13] = this.imsi;
        strArr[14] = this.uuid;
        strArr[15] = this.f6788id;
        strArr[16] = this.smac;
        strArr[17] = this.phnum;
        strArr[18] = this.sdkv;
        strArr[19] = this.colv;
        strArr[20] = this.nettype;
        strArr[21] = this.mmac;
        strArr[22] = this.macsage;
        strArr[23] = this.poiid;
        strArr[24] = utdid;
        strArr[25] = this.sn;
        strArr[26] = this.oaid;
        for (int i3 = 0; i3 < 27; i3++) {
            if (TextUtils.isEmpty(strArr[i3])) {
                strArr[i3] = "";
            }
        }
        if (TextUtils.isEmpty(this.gtype)) {
            this.gtype = "0";
        } else if (!"0".equals(this.gtype) && !"2".equals(this.gtype)) {
            this.gtype = "0";
        }
        if (TextUtils.isEmpty(this.gmock)) {
            this.gmock = "0";
        } else if (!"0".equals(this.gmock) && !"1".equals(this.gmock)) {
            this.gmock = "0";
        }
        if (TextUtils.isEmpty(this.inftype)) {
            this.inftype = "0";
        } else if (!"1".equals(this.inftype) && !"2".equals(this.inftype)) {
            this.inftype = "0";
        }
        if (!CgiManager.isValidCgiFlag(this.cgiflag)) {
            this.cgiflag = 0;
        }
        if (this.cor == null) {
            this.cor = new byte[0];
        }
    }

    private int a(String str, byte[] bArr, int i3) {
        try {
            if (TextUtils.isEmpty(str)) {
                bArr[i3] = 0;
                return i3 + 1;
            }
            byte[] bytes = str.getBytes(Const.STR_APS_ENCODE);
            int length = bytes.length;
            if (length > 127) {
                length = 127;
            }
            bArr[i3] = (byte) length;
            int i10 = i3 + 1;
            System.arraycopy(bytes, 0, bArr, i10, length);
            return i10 + length;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Req", "copyContentWithByteLen");
            bArr[i3] = 0;
            return i3 + 1;
        }
    }
}
