package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.autonavi.aps.amapapi.storage.LastLocationInfo;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.autonavi.aps.amapapi.utils.AMapLocationUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class v {

    /* renamed from: g, reason: collision with root package name */
    static LastLocationInfo f5158g;

    /* renamed from: h, reason: collision with root package name */
    static ta f5159h;

    /* renamed from: i, reason: collision with root package name */
    static long f5160i;

    /* renamed from: a, reason: collision with root package name */
    private Context f5161a;

    /* renamed from: b, reason: collision with root package name */
    String f5162b = null;

    /* renamed from: c, reason: collision with root package name */
    LastLocationInfo f5163c = null;

    /* renamed from: d, reason: collision with root package name */
    LastLocationInfo f5164d = null;
    long e = 0;

    /* renamed from: f, reason: collision with root package name */
    boolean f5165f = false;

    public v(Context context) {
        this.f5161a = context.getApplicationContext();
    }

    private void d() {
        Throwable th2;
        LastLocationInfo lastLocationInfo;
        ta taVar;
        byte[] aesDecrypt;
        byte[] aesDecrypt2;
        if (f5158g == null || Utils.getTimeBoot() - f5160i > Const.MIN_TIME_LOADLASTLOCFROMDB) {
            LastLocationInfo lastLocationInfo2 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            String str = null;
            String str2 = null;
            lastLocationInfo2 = null;
            if (this.f5161a != null) {
                c();
                try {
                    taVar = f5159h;
                } catch (Throwable th3) {
                    th2 = th3;
                    lastLocationInfo = null;
                }
                if (taVar != null) {
                    ArrayList arrayList = (ArrayList) taVar.b("_id=1", LastLocationInfo.class);
                    if (arrayList.size() > 0) {
                        lastLocationInfo = (LastLocationInfo) arrayList.get(0);
                        try {
                            byte[] a3 = h9.a(lastLocationInfo.getLocInfo());
                            String str3 = (a3 == null || a3.length <= 0 || (aesDecrypt2 = Encrypt.aesDecrypt(a3, this.f5162b)) == null || aesDecrypt2.length <= 0) ? null : new String(aesDecrypt2, "UTF-8");
                            byte[] a10 = h9.a(lastLocationInfo.getNb());
                            if (a10 != null && a10.length > 0 && (aesDecrypt = Encrypt.aesDecrypt(a10, this.f5162b)) != null && aesDecrypt.length > 0) {
                                str = new String(aesDecrypt, "UTF-8");
                            }
                            lastLocationInfo.setNb(str);
                            str2 = str3;
                        } catch (Throwable th4) {
                            th2 = th4;
                            CoreUtil.reportError(th2, "LastLocationManager", "readLastFix");
                            lastLocationInfo2 = lastLocationInfo;
                            f5160i = Utils.getTimeBoot();
                            if (lastLocationInfo2 == null) {
                            } else {
                                return;
                            }
                        }
                    } else {
                        lastLocationInfo = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        AMapLocation aMapLocation = new AMapLocation("");
                        CoreUtil.transformLocation(aMapLocation, new JSONObject(str2));
                        if (Utils.checkLoc(aMapLocation)) {
                            lastLocationInfo.setAmapLocation(aMapLocation);
                        }
                    }
                    lastLocationInfo2 = lastLocationInfo;
                }
            }
            f5160i = Utils.getTimeBoot();
            if (lastLocationInfo2 == null && Utils.locCorrect(lastLocationInfo2.getAmapLocation())) {
                f5158g = lastLocationInfo2;
            }
        }
    }

    public boolean a(AMapLocation aMapLocation, String str) {
        if (this.f5161a != null && aMapLocation != null && Utils.locCorrect(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            LastLocationInfo lastLocationInfo = new LastLocationInfo();
            lastLocationInfo.setAmapLocation(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                lastLocationInfo.setNb(null);
            } else {
                lastLocationInfo.setNb(str);
            }
            try {
                f5158g = lastLocationInfo;
                f5160i = Utils.getTimeBoot();
                this.f5163c = lastLocationInfo;
                LastLocationInfo lastLocationInfo2 = this.f5164d;
                if (lastLocationInfo2 != null && Utils.dist(lastLocationInfo2.getAmapLocation(), lastLocationInfo.getAmapLocation()) <= 500.0f) {
                    return false;
                }
                if (Utils.getTimeBoot() - this.e > 30000) {
                    return true;
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public AMapLocation b() {
        d();
        LastLocationInfo lastLocationInfo = f5158g;
        if (lastLocationInfo != null && Utils.locCorrect(lastLocationInfo.getAmapLocation())) {
            return f5158g.getAmapLocation();
        }
        return null;
    }

    public void c() {
        if (this.f5165f) {
            return;
        }
        try {
            if (this.f5162b == null) {
                this.f5162b = Encrypt.encode("MD5", f9.b());
            }
            if (f5159h == null) {
                f5159h = new ta(this.f5161a, ta.b(SdCardDbCreator.class));
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "LastLocationManager", "<init>:DBOperation");
        }
        this.f5165f = true;
    }

    public void e() {
        LastLocationInfo lastLocationInfo;
        String str;
        try {
            c();
            LastLocationInfo lastLocationInfo2 = this.f5163c;
            if (lastLocationInfo2 != null && Utils.locCorrect(lastLocationInfo2.getAmapLocation()) && f5159h != null && (lastLocationInfo = this.f5163c) != this.f5164d && lastLocationInfo.getTime() == 0) {
                String str2 = this.f5163c.getAmapLocation().toStr();
                String nb = this.f5163c.getNb();
                this.f5164d = this.f5163c;
                if (TextUtils.isEmpty(str2)) {
                    str = null;
                } else {
                    String c9 = h9.c(Encrypt.aesEncrypt(str2.getBytes("UTF-8"), this.f5162b));
                    str = TextUtils.isEmpty(nb) ? null : h9.c(Encrypt.aesEncrypt(nb.getBytes("UTF-8"), this.f5162b));
                    r4 = c9;
                }
                if (TextUtils.isEmpty(r4)) {
                    return;
                }
                LastLocationInfo lastLocationInfo3 = new LastLocationInfo();
                lastLocationInfo3.setLocInfo(r4);
                lastLocationInfo3.setTime(Utils.getTimeBoot());
                lastLocationInfo3.setNb(str);
                f5159h.a(lastLocationInfo3, "_id=1");
                this.e = Utils.getTimeBoot();
                LastLocationInfo lastLocationInfo4 = f5158g;
                if (lastLocationInfo4 != null) {
                    lastLocationInfo4.setTime(Utils.getTimeBoot());
                }
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "LastLocationManager", "saveLastFix");
        }
    }

    public AMapLocation a(AMapLocation aMapLocation, String str, long j4) {
        AMapLocation aMapLocation2;
        Throwable th2;
        boolean nbWifiSimiMem;
        if (aMapLocation != null && aMapLocation.getErrorCode() != 0 && aMapLocation.getLocationType() != 1 && aMapLocation.getErrorCode() != 7) {
            try {
                d();
                LastLocationInfo lastLocationInfo = f5158g;
                if (lastLocationInfo != null && lastLocationInfo.getAmapLocation() != null) {
                    if (TextUtils.isEmpty(str)) {
                        long timeBoot = Utils.getTimeBoot() - f5158g.getTime();
                        nbWifiSimiMem = timeBoot >= 0 && timeBoot <= j4;
                        aMapLocation.setTrustedLevel(3);
                    } else {
                        nbWifiSimiMem = Utils.nbWifiSimiMem(f5158g.getNb(), str);
                        aMapLocation.setTrustedLevel(2);
                    }
                    if (nbWifiSimiMem) {
                        aMapLocation2 = f5158g.getAmapLocation();
                        try {
                            AMapLocationUtil.cacheLocationType(aMapLocation2);
                            aMapLocation2.setLocationType(9);
                            aMapLocation2.setFixLastLocation(true);
                            aMapLocation2.setLocationDetail(aMapLocation.getLocationDetail());
                            return aMapLocation2;
                        } catch (Throwable th3) {
                            th2 = th3;
                            CoreUtil.reportError(th2, "LastLocationManager", "fixLastLocation");
                            return aMapLocation2;
                        }
                    }
                }
            } catch (Throwable th4) {
                aMapLocation2 = aMapLocation;
                th2 = th4;
            }
        }
        return aMapLocation;
    }

    public void a() {
        try {
            e();
            this.e = 0L;
            this.f5165f = false;
            this.f5163c = null;
            this.f5164d = null;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "LastLocationManager", "destroy");
        }
    }
}
