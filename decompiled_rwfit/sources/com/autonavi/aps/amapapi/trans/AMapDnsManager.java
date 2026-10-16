package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.c9;
import com.amap.api.col.p0003sl.g9;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.col.p0003sl.pb;
import com.amap.api.col.p0003sl.qc;
import com.amap.api.col.p0003sl.rc;
import com.autonavi.aps.amapapi.DNSIPDelegate;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.SPUtil;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AMapDnsManager {
    public static int IPV4_TYPE = 1;
    public static int IPV6_TYPE = 2;

    /* renamed from: i, reason: collision with root package name */
    private static AMapDnsManager f6753i;

    /* renamed from: f, reason: collision with root package name */
    private Context f6758f;

    /* renamed from: g, reason: collision with root package name */
    private String f6759g;

    /* renamed from: a, reason: collision with root package name */
    private long f6754a = 0;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f6755b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private DNSIPDelegate f6756c = new DNSIPDelegate();

    /* renamed from: d, reason: collision with root package name */
    private DNSIPDelegate f6757d = new DNSIPDelegate();
    private long e = 120000;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6760h = false;

    private AMapDnsManager(Context context) {
        this.f6758f = context;
    }

    public static String[] a(AMapDnsManager aMapDnsManager, JSONArray jSONArray, int i3) throws JSONException {
        aMapDnsManager.getClass();
        if (jSONArray == null || jSONArray.length() == 0) {
            return new String[0];
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String string = jSONArray.getString(i10);
            if (!TextUtils.isEmpty(string)) {
                if (i3 == IPV6_TYPE) {
                    string = l0.o("[", string, "]");
                }
                strArr[i10] = string;
            }
        }
        return strArr;
    }

    public static void b(AMapDnsManager aMapDnsManager, int i3) {
        if ((i3 == IPV6_TYPE ? aMapDnsManager.f6757d : aMapDnsManager.f6756c).getLocationIPs() != null) {
            if ((i3 == IPV6_TYPE ? aMapDnsManager.f6757d : aMapDnsManager.f6756c).getLocationIPs().length <= 0) {
                return;
            }
            String str = (i3 == IPV6_TYPE ? aMapDnsManager.f6757d : aMapDnsManager.f6756c).getLocationIPs()[0];
            if (str.equals(aMapDnsManager.f6759g) || aMapDnsManager.f6755b.contains(str)) {
                return;
            }
            aMapDnsManager.f6759g = str;
            SharedPreferences.Editor startEdit = SPUtil.startEdit(aMapDnsManager.f6758f, Const.STR_PREF_KEY7);
            SPUtil.setPrefsStr(startEdit, aMapDnsManager.a(i3), str);
            SPUtil.endEdit(startEdit);
        }
    }

    public static synchronized AMapDnsManager getInstance(Context context) {
        AMapDnsManager aMapDnsManager;
        synchronized (AMapDnsManager.class) {
            try {
                if (f6753i == null) {
                    f6753i = new AMapDnsManager(context);
                }
                aMapDnsManager = f6753i;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aMapDnsManager;
    }

    public String changeLocationRequestURLAndHost(LocationRequest locationRequest, int i3) {
        try {
            if (AuthUtil.getHttpDNSAble() && locationRequest != null) {
                String url = locationRequest.getURL();
                String host = new URL(url).getHost();
                g9 b3 = g9.b(this.f6758f);
                String a3 = b3.a(40);
                if (!("http://" + b3.a(40) + ReportUtil.PATH_LOC).equals(url) && !a3.equals(host)) {
                    String str = b3.a(43).equalsIgnoreCase(host) ? CoreUtil.STR_API_DEFAULT_DNS_HOST : host;
                    if (!c9.g(str)) {
                        return null;
                    }
                    String b10 = b(i3);
                    if (!TextUtils.isEmpty(b10)) {
                        locationRequest.setIPV6Url(url.replace(host, b10));
                        locationRequest.getRequestHead().put("host", str);
                        locationRequest.setDnsHostName(str);
                        locationRequest.setIPV6Request(i3 == IPV6_TYPE);
                        return b10;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public void removeCacheIP(int i3) {
        if ((i3 == IPV6_TYPE ? this.f6757d : this.f6756c).isHasLocalCache()) {
            SharedPreferences.Editor startEdit = SPUtil.startEdit(this.f6758f, Const.STR_PREF_KEY7);
            SPUtil.removeKeyData(startEdit, a(i3));
            SPUtil.endEdit(startEdit);
            (i3 == IPV6_TYPE ? this.f6757d : this.f6756c).setHasLocalCache(false);
        }
    }

    public void setDomainRequestStatus(boolean z5, int i3) {
        if (z5) {
            if (!(i3 == IPV6_TYPE ? this.f6757d : this.f6756c).isIsDNSOK()) {
                this.f6755b.add((i3 == IPV6_TYPE ? this.f6757d : this.f6756c).getUseIp());
                removeCacheIP(i3);
                a(true, i3);
                return;
            }
        }
        removeCacheIP(i3);
    }

    public void setRequestStatus(boolean z5, int i3) {
        (i3 == IPV6_TYPE ? this.f6757d : this.f6756c).setIsDNSOK(z5);
        if (z5) {
            String cacheIp = (i3 == IPV6_TYPE ? this.f6757d : this.f6756c).getCacheIp();
            String useIp = (i3 == IPV6_TYPE ? this.f6757d : this.f6756c).getUseIp();
            if (TextUtils.isEmpty(useIp) || useIp.equals(cacheIp)) {
                return;
            }
            SharedPreferences.Editor startEdit = SPUtil.startEdit(this.f6758f, Const.STR_PREF_KEY7);
            SPUtil.setPrefsStr(startEdit, a(i3), useIp);
            SPUtil.endEdit(startEdit);
        }
    }

    public static boolean a(AMapDnsManager aMapDnsManager, String[] strArr, String[] strArr2) {
        aMapDnsManager.getClass();
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0 && strArr.length == strArr2.length) {
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (strArr[i3].equals(strArr2[i3])) {
                }
            }
            return true;
        }
        return false;
    }

    private String b(int i3) {
        DNSIPDelegate dNSIPDelegate;
        DNSIPDelegate dNSIPDelegate2;
        DNSIPDelegate dNSIPDelegate3;
        DNSIPDelegate dNSIPDelegate4;
        DNSIPDelegate dNSIPDelegate5;
        String str;
        DNSIPDelegate dNSIPDelegate6;
        int i10 = 0;
        a(false, i3);
        if (i3 == IPV6_TYPE) {
            dNSIPDelegate = this.f6757d;
        } else {
            dNSIPDelegate = this.f6756c;
        }
        String[] locationIPs = dNSIPDelegate.getLocationIPs();
        if (locationIPs != null && locationIPs.length > 0) {
            int length = locationIPs.length;
            while (true) {
                if (i10 >= length) {
                    str = null;
                    break;
                }
                str = locationIPs[i10];
                if (!this.f6755b.contains(str)) {
                    break;
                }
                i10++;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (i3 == IPV6_TYPE) {
                dNSIPDelegate6 = this.f6757d;
            } else {
                dNSIPDelegate6 = this.f6756c;
            }
            dNSIPDelegate6.setUseIp(str);
            return str;
        }
        String prefsStr = SPUtil.getPrefsStr(this.f6758f, Const.STR_PREF_KEY7, a(i3), null);
        if (!TextUtils.isEmpty(prefsStr) && !this.f6755b.contains(prefsStr)) {
            if (i3 == IPV6_TYPE) {
                dNSIPDelegate3 = this.f6757d;
            } else {
                dNSIPDelegate3 = this.f6756c;
            }
            dNSIPDelegate3.setUseIp(prefsStr);
            if (i3 == IPV6_TYPE) {
                dNSIPDelegate4 = this.f6757d;
            } else {
                dNSIPDelegate4 = this.f6756c;
            }
            dNSIPDelegate4.setCacheIp(prefsStr);
            if (i3 == IPV6_TYPE) {
                dNSIPDelegate5 = this.f6757d;
            } else {
                dNSIPDelegate5 = this.f6756c;
            }
            dNSIPDelegate5.setHasLocalCache(true);
        }
        if (i3 == IPV6_TYPE) {
            dNSIPDelegate2 = this.f6757d;
        } else {
            dNSIPDelegate2 = this.f6756c;
        }
        return dNSIPDelegate2.getUseIp();
    }

    public static DNSIPDelegate a(AMapDnsManager aMapDnsManager, int i3) {
        if (i3 == IPV6_TYPE) {
            return aMapDnsManager.f6757d;
        }
        return aMapDnsManager.f6756c;
    }

    private String a(int i3) {
        return i3 == IPV6_TYPE ? "last_ip_6" : "last_ip_4";
    }

    private synchronized void a(boolean z5, final int i3) {
        if (!z5) {
            if (!AuthUtil.getNeedRefresh() && this.f6760h) {
                return;
            }
        }
        if (this.f6754a != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f6754a;
            if (currentTimeMillis < this.e) {
                return;
            }
            if (currentTimeMillis < 60000) {
                return;
            }
        }
        this.f6754a = System.currentTimeMillis();
        this.f6760h = true;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuffer.append(stackTraceElement.getClassName() + "(" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + "),");
        }
        qc.d().b(new rc() { // from class: com.autonavi.aps.amapapi.trans.AMapDnsManager.1
            @Override // com.amap.api.col.p0003sl.rc
            public void runTask() {
                int i10;
                String a3 = g9.b(AMapDnsManager.this.f6758f).a(44);
                StringBuilder sb2 = new StringBuilder("http://");
                sb2.append(AuthUtil.getHost());
                sb2.append("?host=");
                sb2.append(a3);
                sb2.append("&query=");
                sb2.append(i3 == AMapDnsManager.IPV6_TYPE ? 6 : 4);
                String sb3 = sb2.toString();
                HttpRequest httpRequest = new HttpRequest();
                httpRequest.setUrl(sb3);
                httpRequest.setIpv6Url(sb3);
                httpRequest.setDegradeAbility(pb.a.SINGLE);
                httpRequest.setHttpProtocol(pb.c.HTTP);
                try {
                    JSONObject jSONObject = new JSONObject(new String(ib.a().a(httpRequest).f4927a));
                    String[] a10 = AMapDnsManager.a(AMapDnsManager.this, jSONObject.optJSONArray("ips"), AMapDnsManager.IPV4_TYPE);
                    if (a10.length > 0) {
                        AMapDnsManager aMapDnsManager = AMapDnsManager.this;
                        if (!AMapDnsManager.a(aMapDnsManager, a10, AMapDnsManager.a(aMapDnsManager, AMapDnsManager.IPV4_TYPE).getLocationIPs())) {
                            AMapDnsManager.a(AMapDnsManager.this, AMapDnsManager.IPV4_TYPE).setLocationIPs(a10);
                            AMapDnsManager.b(AMapDnsManager.this, AMapDnsManager.IPV4_TYPE);
                        }
                    }
                    String[] a11 = AMapDnsManager.a(AMapDnsManager.this, jSONObject.optJSONArray("ipsv6"), AMapDnsManager.IPV6_TYPE);
                    if (a11.length > 0) {
                        AMapDnsManager aMapDnsManager2 = AMapDnsManager.this;
                        if (!AMapDnsManager.a(aMapDnsManager2, a11, AMapDnsManager.a(aMapDnsManager2, AMapDnsManager.IPV6_TYPE).getLocationIPs())) {
                            AMapDnsManager.a(AMapDnsManager.this, AMapDnsManager.IPV6_TYPE).setLocationIPs(a11);
                            AMapDnsManager.b(AMapDnsManager.this, AMapDnsManager.IPV6_TYPE);
                        }
                    }
                    if ((jSONObject.has("ips") || jSONObject.has("ipsv6")) && jSONObject.has("ttl") && (i10 = jSONObject.getInt("ttl")) > 30) {
                        AMapDnsManager.this.e = i10 * 1000;
                    }
                } catch (Throwable th2) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("key", "dnsError");
                        jSONObject2.put("reason", th2.getMessage());
                    } catch (Throwable unused) {
                    }
                    ReportUtil.applyStatistics(AMapDnsManager.this.f6758f, ReportUtil.STATICS_ID_LOCATE_Error, jSONObject2);
                }
            }
        });
    }
}
