package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.amap.api.col.p0003sl.ib;
import com.autonavi.aps.amapapi.config.Const;
import java.net.Proxy;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class pb {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;

    /* renamed from: f, reason: collision with root package name */
    ib.a f4833f;

    /* renamed from: h, reason: collision with root package name */
    private String f4835h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4836i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4837j;

    /* renamed from: c, reason: collision with root package name */
    int f4831c = Const.I_CITY_TILE_LEN;

    /* renamed from: d, reason: collision with root package name */
    int f4832d = Const.I_CITY_TILE_LEN;
    Proxy e = null;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4829a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f4830b = Const.I_CITY_TILE_LEN;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4834g = true;

    /* renamed from: k, reason: collision with root package name */
    private a f4838k = a.NORMAL;

    /* renamed from: l, reason: collision with root package name */
    private b f4839l = b.FIRST_NONDEGRADE;

    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);

        a(int i3) {
        }
    }

    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);


        /* renamed from: a, reason: collision with root package name */
        private int f4852a;

        b(int i3) {
            this.f4852a = i3;
        }

        public final int a() {
            return this.f4852a;
        }

        public final boolean b() {
            int i3 = this.f4852a;
            return i3 == 2 || i3 == 3 || i3 == 5 || i3 == 6;
        }

        public final boolean c() {
            int i3 = this.f4852a;
            return i3 == 2 || i3 == 5;
        }

        public final boolean d() {
            return this.f4852a == 1;
        }

        public final boolean e() {
            int i3 = this.f4852a;
            return i3 == 0 || i3 == 1 || i3 == 4;
        }
    }

    public enum c {
        HTTP(0),
        HTTPS(1);

        c(int i3) {
        }
    }

    public final String a() {
        return a(getURL());
    }

    public final String b() {
        return a(getIPV6URL());
    }

    public int getConntectionTimeout() {
        return this.f4831c;
    }

    public a getDegradeAbility() {
        return this.f4838k;
    }

    public b getDegradeType() {
        return this.f4839l;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    public String getIPDNSName() {
        return "";
    }

    public String getIPV6URL() {
        return getURL();
    }

    public String getNon_degrade_final_Host() {
        return this.f4835h;
    }

    public abstract Map<String, String> getParams();

    public Proxy getProxy() {
        return this.e;
    }

    public int getReal_max_timeout() {
        return this.f4830b;
    }

    public abstract Map<String, String> getRequestHead();

    public String getSDKName() {
        return "";
    }

    public int getSoTimeout() {
        return this.f4832d;
    }

    public abstract String getURL();

    public ib.a getUrlConnectionImpl() {
        return this.f4833f;
    }

    public boolean isBinary() {
        return this.f4829a;
    }

    public boolean isHostToIP() {
        return this.f4834g;
    }

    public boolean isHttps() {
        return this.f4837j;
    }

    public boolean isIPRequest() {
        return !TextUtils.isEmpty(getIPDNSName());
    }

    public boolean isIPV6Request() {
        return this.f4836i;
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    public String parseSDKNameFromPlatInfo(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(Const.STR_MART_ADD);
                if (split.length > 1) {
                    int length = split.length;
                    int i3 = 0;
                    String str4 = "";
                    while (true) {
                        if (i3 >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i3];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i3++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(ca.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    ca.a(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
            return str3;
        } catch (Throwable th2) {
            ga.a(th2, "ht", "pnfp");
            return str3;
        }
    }

    public String parseSdkNameFromHeader(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return parseSDKNameFromPlatInfo(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th2) {
            ga.a(th2, "ht", "pnfh");
            return null;
        }
    }

    public String parseSdkNameFromRequest() {
        String str;
        try {
            str = getSDKName();
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
        try {
            return TextUtils.isEmpty(str) ? this.f4829a ? parseSDKNameFromPlatInfo(((jb) this).getPlatInfo()) : parseSdkNameFromHeader(getRequestHead()) : str;
        } catch (Throwable th3) {
            th = th3;
            ga.a(th, "ht", "pnfr");
            return str;
        }
    }

    public void setBinary(boolean z5) {
        this.f4829a = z5;
    }

    public final void setConnectionTimeout(int i3) {
        this.f4831c = i3;
    }

    public void setDegradeAbility(a aVar) {
        this.f4838k = aVar;
    }

    public void setDegradeType(b bVar) {
        this.f4839l = bVar;
    }

    public void setHostToIP(boolean z5) {
        this.f4834g = z5;
    }

    public void setHttpProtocol(c cVar) {
        this.f4837j = cVar == c.HTTPS;
    }

    public void setIPV6Request(boolean z5) {
        this.f4836i = z5;
    }

    public void setNon_degrade_final_Host(String str) {
        this.f4835h = str;
    }

    public final void setProxy(Proxy proxy) {
        this.e = proxy;
    }

    public void setReal_max_timeout(int i3) {
        this.f4830b = i3;
    }

    public final void setSoTimeout(int i3) {
        this.f4832d = i3;
    }

    public void setUrlConnectionImpl(ib.a aVar) {
        this.f4833f = aVar;
    }

    private String a(String str) {
        Map<String, String> params;
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0 || (params = getParams()) == null) {
            return str;
        }
        String a3 = mb.a(params);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(a3);
        return stringBuffer.toString();
    }
}
