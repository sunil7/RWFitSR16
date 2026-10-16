package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.i9;
import com.amap.api.col.p0003sl.mb;
import com.amap.api.col.p0003sl.pb;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.tencent.connect.common.Constants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c9 {

    /* renamed from: a, reason: collision with root package name */
    public static int f3817a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static String f3818b = "";

    /* renamed from: c, reason: collision with root package name */
    public static Context f3819c = null;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f3820d = true;

    /* renamed from: z, reason: collision with root package name */
    private static volatile boolean f3840z;
    private static Vector<f> e = new Vector<>();

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, Integer> f3821f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private static String f3822g = null;

    /* renamed from: h, reason: collision with root package name */
    private static long f3823h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static volatile boolean f3824i = false;

    /* renamed from: j, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, h> f3825j = new ConcurrentHashMap<>(8);

    /* renamed from: k, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f3826k = new ConcurrentHashMap<>(8);

    /* renamed from: l, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, e> f3827l = new ConcurrentHashMap<>(8);

    /* renamed from: m, reason: collision with root package name */
    private static boolean f3828m = false;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f3829n = false;

    /* renamed from: o, reason: collision with root package name */
    public static int f3830o = 5000;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f3831p = true;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f3832q = false;
    private static int r = 3;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f3833s = true;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f3834t = false;

    /* renamed from: u, reason: collision with root package name */
    private static int f3835u = 3;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f3836v = false;

    /* renamed from: w, reason: collision with root package name */
    private static ConcurrentHashMap<String, Boolean> f3837w = new ConcurrentHashMap<>();

    /* renamed from: x, reason: collision with root package name */
    private static ConcurrentHashMap<String, Boolean> f3838x = new ConcurrentHashMap<>();

    /* renamed from: y, reason: collision with root package name */
    private static ArrayList<mb.a> f3839y = new ArrayList<>();
    private static Queue<mb.c> A = new LinkedList();

    public static class a extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3841a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3842b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3843c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3844d;

        public a(String str, String str2, String str3, String str4) {
            this.f3841a = str;
            this.f3842b = str2;
            this.f3843c = str3;
            this.f3844d = str4;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public final void runTask() {
            e eVar = (e) c9.f3827l.get(this.f3841a);
            if (eVar == null) {
                return;
            }
            b bVar = eVar.f3858c;
            c a3 = c9.a(c9.f3819c, eVar.f3856a, eVar.f3857b, null, false, "DEF_ID", this.f3842b, this.f3843c, this.f3844d);
            if (bVar != null) {
                bVar.onReceiveAuthConfig(a3);
            }
        }
    }

    public interface b {
        void onReceiveAuthConfig(c cVar);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f3845a;

        /* renamed from: b, reason: collision with root package name */
        public long f3846b = 0;

        /* renamed from: c, reason: collision with root package name */
        public JSONObject f3847c;

        /* renamed from: d, reason: collision with root package name */
        public a f3848d;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f3849a;

            /* renamed from: b, reason: collision with root package name */
            public JSONObject f3850b;
        }

        public static /* synthetic */ boolean a(c cVar, boolean z5) {
            return z5;
        }
    }

    public static class d extends jb {

        /* renamed from: m, reason: collision with root package name */
        private String f3851m;

        /* renamed from: n, reason: collision with root package name */
        private Map<String, String> f3852n;

        /* renamed from: o, reason: collision with root package name */
        private String f3853o;

        /* renamed from: p, reason: collision with root package name */
        private String f3854p;

        /* renamed from: q, reason: collision with root package name */
        private String f3855q;

        public d(Context context, m9 m9Var, String str, Map<String, String> map, String str2, String str3, String str4) {
            super(context, m9Var);
            this.f3851m = str;
            this.f3852n = map;
            this.f3853o = str2;
            this.f3854p = str3;
            this.f3855q = str4;
            setHttpProtocol(pb.c.HTTPS);
            setDegradeAbility(pb.a.FIX);
        }

        @Override // com.amap.api.col.p0003sl.pb
        public final String getIPDNSName() {
            return !TextUtils.isEmpty(this.f3855q) ? this.f3855q : super.getIPDNSName();
        }

        @Override // com.amap.api.col.p0003sl.j9, com.amap.api.col.p0003sl.pb
        public final String getIPV6URL() {
            String str = this.f3854p;
            try {
                return !TextUtils.isEmpty(str) ? Uri.parse("https://dualstack-arestapi.amap.com/v3/iasdkauth").buildUpon().encodedAuthority(str).build().toString() : "https://dualstack-arestapi.amap.com/v3/iasdkauth";
            } catch (Throwable unused) {
                return "https://dualstack-arestapi.amap.com/v3/iasdkauth";
            }
        }

        @Override // com.amap.api.col.p0003sl.jb
        public final String getLogVersion() {
            return "3.0";
        }

        @Override // com.amap.api.col.p0003sl.jb
        public final byte[] getRawDatas() {
            return null;
        }

        @Override // com.amap.api.col.p0003sl.jb, com.amap.api.col.p0003sl.pb
        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.f3855q)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f3855q);
            return hashMap;
        }

        @Override // com.amap.api.col.p0003sl.jb
        public final byte[] getRsaAesRawDatas() {
            String stringBuffer;
            String p8 = f9.p(this.mContext);
            if (!TextUtils.isEmpty(p8)) {
                p8 = e9.c(new StringBuilder(p8).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f3851m) ? "" : this.f3851m);
            hashMap.put("plattype", "android");
            hashMap.put("ccver", "1");
            hashMap.put("product", this.mSDKInfo.d());
            hashMap.put("version", this.mSDKInfo.e());
            hashMap.put("output", "json");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb2.toString());
            hashMap.put("deviceId", p8);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f3852n;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f3852n);
            }
            hashMap.put("abitype", n9.a(this.mContext));
            hashMap.put("ext", this.mSDKInfo.a());
            if (hashMap.size() == 0) {
                stringBuffer = null;
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                try {
                    boolean z5 = true;
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (z5) {
                            stringBuffer2.append((String) entry.getKey());
                            stringBuffer2.append("=");
                            stringBuffer2.append((String) entry.getValue());
                            z5 = false;
                        } else {
                            stringBuffer2.append(Const.STR_MART_ADD);
                            stringBuffer2.append((String) entry.getKey());
                            stringBuffer2.append("=");
                            stringBuffer2.append((String) entry.getValue());
                        }
                    }
                } catch (Throwable th2) {
                    ga.a(th2, "ut", "abP");
                }
                stringBuffer = stringBuffer2.toString();
            }
            return n9.e(stringBuffer);
        }

        @Override // com.amap.api.col.p0003sl.jb, com.amap.api.col.p0003sl.pb
        public final String getURL() {
            String str = this.f3853o;
            try {
                return !TextUtils.isEmpty(str) ? Uri.parse("https://restsdk.amap.com/v3/iasdkauth").buildUpon().encodedAuthority(str).build().toString() : "https://restsdk.amap.com/v3/iasdkauth";
            } catch (Throwable unused) {
                return "https://restsdk.amap.com/v3/iasdkauth";
            }
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        m9 f3856a;

        /* renamed from: b, reason: collision with root package name */
        String f3857b;

        /* renamed from: c, reason: collision with root package name */
        b f3858c;

        private e() {
        }

        public /* synthetic */ e(byte b3) {
            this();
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private String f3859a;

        /* renamed from: b, reason: collision with root package name */
        private String f3860b;

        /* renamed from: c, reason: collision with root package name */
        private AtomicInteger f3861c;

        public f(String str, String str2, int i3) {
            this.f3859a = str;
            this.f3860b = str2;
            this.f3861c = new AtomicInteger(i3);
        }

        public final void a(String str) {
            this.f3860b = str;
        }

        public final String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Const.INTENT_KEY_APIKEY, this.f3859a);
                jSONObject.put("f", this.f3860b);
                jSONObject.put(Const.INTENT_KEY_BACKGROUND_NOTIFICATION, this.f3861c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.f3861c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public static boolean f3862a = true;

        /* renamed from: b, reason: collision with root package name */
        public static boolean f3863b = false;

        /* renamed from: c, reason: collision with root package name */
        public static boolean f3864c = true;

        /* renamed from: d, reason: collision with root package name */
        public static int f3865d = 0;
        public static boolean e = false;

        /* renamed from: f, reason: collision with root package name */
        public static int f3866f;
    }

    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public long f3867a;

        /* renamed from: b, reason: collision with root package name */
        public String f3868b;

        public h(Long l3, String str) {
            this.f3867a = 0L;
            this.f3868b = "";
            this.f3867a = l3.longValue();
            this.f3868b = str;
        }
    }

    public static synchronized h b(String str) {
        synchronized (c9.class) {
            try {
                if (f3825j == null) {
                    f3825j = new ConcurrentHashMap<>(8);
                }
                if (f3825j.containsKey(str)) {
                    return f3825j.get(str);
                }
            } finally {
                return new h(0L, "");
            }
            return new h(0L, "");
        }
    }

    public static boolean c() {
        Integer num;
        Context context = f3819c;
        if (context == null) {
            return false;
        }
        String h4 = f9.h(context);
        return (TextUtils.isEmpty(h4) || (num = f3821f.get(h4.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static void d(Context context) {
        f3831p = xa.a(context, "open_common", "a13", true);
        f3833s = xa.a(context, "open_common", "a6", true);
        f3832q = xa.a(context, "open_common", "a7", false);
        f3830o = xa.a(context, "open_common", "a8", 5000);
        r = xa.a(context, "open_common", "a9", 3);
        f3834t = xa.a(context, "open_common", "a10", false);
        f3835u = xa.a(context, "open_common", "a11", 3);
        f3836v = xa.a(context, "open_common", "a12", false);
    }

    public static boolean e(String str) {
        f a3;
        try {
            if (!TextUtils.isEmpty(str) && f3834t && f3838x.get(str) == null) {
                Context context = f3819c;
                if (context == null || (a3 = a(context, b(str, "a15"), "open_common")) == null) {
                    return true;
                }
                if (a3.a() < f3835u) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean f() {
        f a3;
        Context context = f3819c;
        if (context != null) {
            try {
                String h4 = f9.h(context);
                if (TextUtils.isEmpty(f3822g) || TextUtils.isEmpty(h4) || !f3822g.equals(h4) || System.currentTimeMillis() - f3823h >= 60000) {
                    if (!TextUtils.isEmpty(h4)) {
                        f3822g = h4;
                    }
                    f3823h = System.currentTimeMillis();
                    f3821f.clear();
                    ArrayList list = Collections.list(NetworkInterface.getNetworkInterfaces());
                    int size = list.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = list.get(i3);
                        i3++;
                        NetworkInterface networkInterface = (NetworkInterface) obj;
                        if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                            String displayName = networkInterface.getDisplayName();
                            Iterator<InterfaceAddress> it = networkInterface.getInterfaceAddresses().iterator();
                            int i10 = 0;
                            while (it.hasNext()) {
                                InetAddress address = it.next().getAddress();
                                if (address instanceof Inet6Address) {
                                    if (!a((Inet6Address) address)) {
                                        i10 |= 2;
                                    }
                                } else if (address instanceof Inet4Address) {
                                    Inet4Address inet4Address = (Inet4Address) address;
                                    if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(n9.b("FMTkyLjE2OC40My4"))) {
                                        i10 |= 1;
                                    }
                                }
                            }
                            if (i10 != 0) {
                                if (displayName != null && displayName.startsWith("wlan")) {
                                    f3821f.put("WIFI", Integer.valueOf(i10));
                                } else if (displayName != null && displayName.startsWith("rmnet")) {
                                    f3821f.put("MOBILE", Integer.valueOf(i10));
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                ga.a(th2, "at", "ipstack");
            }
            if (!c()) {
                return false;
            }
            if (g()) {
                return true;
            }
        }
        return f3820d && (a3 = a(f3819c, "IPV6_CONFIG_NAME", "open_common")) != null && a3.a() < 5;
    }

    public static boolean g() {
        Integer num;
        Context context = f3819c;
        if (context == null) {
            return false;
        }
        String h4 = f9.h(context);
        return (TextUtils.isEmpty(h4) || (num = f3821f.get(h4.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static void h() {
        if (f3824i) {
            return;
        }
        try {
            Context context = f3819c;
            if (context == null) {
                return;
            }
            f3824i = true;
            i9.a.f4300a.a(context);
            f3820d = xa.a(context, "open_common", SdCardDbCreator.FIELD_LASTLOC_INFO, true);
            d(context);
            g.f3862a = xa.a(context, "open_common", "ucf", g.f3862a);
            g.f3863b = xa.a(context, "open_common", "fsv2", g.f3863b);
            g.f3864c = xa.a(context, "open_common", "usc", g.f3864c);
            g.f3865d = xa.a(context, "open_common", "umv", g.f3865d);
            g.e = xa.a(context, "open_common", "ust", g.e);
            g.f3866f = xa.a(context, "open_common", "ustv", g.f3866f);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str) {
        b9.a(context, str);
    }

    public static boolean a(String str, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return z5;
        }
        String[] split = URLDecoder.decode(str).split("/");
        return split[split.length - 1].charAt(4) % 2 == 1;
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        f3820d = xa.a(context, "open_common", SdCardDbCreator.FIELD_LASTLOC_INFO, true);
    }

    public static boolean g(String str) {
        f a3;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (f3831p && f3837w.get(str) == null) {
                Context context = f3819c;
                if (context == null || (a3 = a(context, b(str, "a14"), "open_common")) == null) {
                    return true;
                }
                if (a3.a() < r) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void b(Context context) {
        try {
            if (f3829n) {
                return;
            }
            a(xa.b(context, "open_common", "a16", ""), true);
            try {
                context.getSharedPreferences("open_common", 0).getLong("a17", Const.DAY_IN_MILLIS);
            } catch (Throwable th2) {
                ka.a(th2, "csp", "glv");
            }
            f3829n = true;
        } catch (Throwable unused) {
        }
    }

    public static m9 c(String str) {
        e eVar = f3827l.get(str);
        if (eVar != null) {
            return eVar.f3856a;
        }
        return null;
    }

    public static mb.a e() {
        if (f3840z) {
            return null;
        }
        synchronized (f3839y) {
            try {
                if (f3840z) {
                    return null;
                }
                Collections.sort(f3839y);
                if (f3839y.size() <= 0) {
                    return null;
                }
                mb.a a3 = f3839y.get(0).a();
                f3840z = true;
                return a3;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static synchronized void d(String str) {
        synchronized (c9.class) {
            if (f3826k == null) {
                return;
            }
            if (f3826k.containsKey(str)) {
                f3826k.remove(str);
            }
        }
    }

    public static c a(Context context, m9 m9Var, String str, Map<String, String> map) {
        return a(context, m9Var, str, map, false, "DEF_ID", null, null, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(1:3)|4|(3:5|6|7)|(5:(3:136|137|(12:139|140|141|142|143|11|12|13|14|15|(9:19|20|21|22|(5:26|(3:106|107|(1:109))|28|29|(2:32|(6:34|35|36|37|38|(7:40|(1:42)|43|(1:45)|46|47|(9:49|(1:51)(1:(8:(1:74)(1:86)|75|(1:77)|78|(1:80)(1:85)|81|82|(1:84)))|52|53|54|(1:56)|58|59|(5:61|62|63|(1:65)(1:68)|66))))))|113|37|38|(0))|17))|14|15|(0)|17)|9|10|11|12|13|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00de, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01a6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01a7, code lost:
    
        r27 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0197, code lost:
    
        r27 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x024d  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.amap.api.col.3sl.c9$c] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v10, types: [com.amap.api.col.3sl.c9$c] */
    /* JADX WARN: Type inference failed for: r8v11, types: [com.amap.api.col.3sl.c9$c] */
    /* JADX WARN: Type inference failed for: r8v12, types: [com.amap.api.col.3sl.c9$c] */
    /* JADX WARN: Type inference failed for: r8v17, types: [com.amap.api.col.3sl.c9$c] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.amap.api.col.3sl.c9.c a(android.content.Context r25, com.amap.api.col.p0003sl.m9 r26, java.lang.String r27, java.util.Map<java.lang.String, java.lang.String> r28, boolean r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 802
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.c9.a(android.content.Context, com.amap.api.col.3sl.m9, java.lang.String, java.util.Map, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.3sl.c9$c");
    }

    public static mb.c d() {
        synchronized (A) {
            try {
                mb.c poll = A.poll();
                if (poll != null) {
                    return poll;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static String b(String str, String str2) {
        return r5.a.c(str2, "_", e9.a(str.getBytes()));
    }

    public static void b(mb.c cVar) {
        if (cVar != null && f3836v) {
            synchronized (A) {
                A.offer(cVar);
            }
        }
    }

    public static void b() {
        try {
            f a3 = a(f3819c, "IPV6_CONFIG_NAME", "open_common");
            String a10 = n9.a(System.currentTimeMillis(), "yyyyMMdd");
            if (!a10.equals(a3.f3860b)) {
                a3.a(a10);
                a3.f3861c.set(0);
            }
            a3.f3861c.incrementAndGet();
            a(f3819c, "IPV6_CONFIG_NAME", "open_common", a3);
        } catch (Throwable unused) {
        }
    }

    public static synchronized boolean f(String str) {
        synchronized (c9.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f3827l == null) {
                return false;
            }
            if (f3826k == null) {
                f3826k = new ConcurrentHashMap<>(8);
            }
            if (f3827l.containsKey(str) && !f3826k.containsKey(str)) {
                f3826k.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    public static long a(List<String> list) {
        if (list == null) {
            return 0L;
        }
        try {
            if (list.size() <= 0) {
                return 0L;
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.valueOf(str).longValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x02e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0291 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(android.content.Context r20, com.amap.api.col.p0003sl.m9 r21, java.lang.String r22, com.amap.api.col.3sl.c9.c r23, org.json.JSONObject r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.c9.a(android.content.Context, com.amap.api.col.3sl.m9, java.lang.String, com.amap.api.col.3sl.c9$c, org.json.JSONObject):void");
    }

    public static void a(String str, boolean z5, boolean z6, boolean z8) {
        if (TextUtils.isEmpty(str) || f3819c == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z5));
        hashMap.put("ant", f9.g(f3819c) == 0 ? "0" : "1");
        if (z8) {
            hashMap.put("type", z5 ? Constants.VIA_SHARE_TYPE_MINI_PROGRAM : Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
        } else {
            hashMap.put("type", z5 ? Constants.VIA_SHARE_TYPE_INFO : Constants.VIA_TO_TYPE_QZONE);
        }
        hashMap.put(FileDownloadModel.STATUS, z6 ? "0" : "1");
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            zb zbVar = new zb(f3819c, "core", "2.0", "O002");
            zbVar.a(jSONObject);
            ac.a(zbVar, f3819c);
        } catch (a9 unused) {
        }
    }

    private static void a(Context context, m9 m9Var, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", m9Var.d());
        hashMap.put("amap_sdk_version", m9Var.b());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            zb zbVar = new zb(context, "core", "2.0", "O001");
            zbVar.a(jSONObject);
            ac.a(zbVar, context);
        } catch (a9 unused) {
        }
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static void a(Context context, String str, String str2, f fVar) {
        if (fVar == null || TextUtils.isEmpty(fVar.f3859a)) {
            return;
        }
        String b3 = fVar.b();
        if (TextUtils.isEmpty(b3) || context == null) {
            return;
        }
        SharedPreferences.Editor a3 = xa.a(context, str2);
        a3.putString(str, b3);
        xa.a(a3);
    }

    public static String a(String str) {
        e eVar;
        if (!f3827l.containsKey(str) || (eVar = f3827l.get(str)) == null) {
            return null;
        }
        return eVar.f3857b;
    }

    public static synchronized void a(Context context, m9 m9Var, String str, b bVar) {
        synchronized (c9.class) {
            if (context == null || m9Var == null) {
                return;
            }
            try {
                if (f3819c == null) {
                    f3819c = context.getApplicationContext();
                }
                String d5 = m9Var.d();
                if (TextUtils.isEmpty(d5)) {
                    return;
                }
                a(m9Var);
                if (f3827l == null) {
                    f3827l = new ConcurrentHashMap<>(8);
                }
                if (f3826k == null) {
                    f3826k = new ConcurrentHashMap<>(8);
                }
                if (f3825j == null) {
                    f3825j = new ConcurrentHashMap<>(8);
                }
                if (!f3827l.containsKey(d5)) {
                    e eVar = new e((byte) 0);
                    eVar.f3856a = m9Var;
                    eVar.f3857b = str;
                    eVar.f3858c = bVar;
                    f3827l.put(d5, eVar);
                    long j4 = 0;
                    try {
                        j4 = f3819c.getSharedPreferences("open_common", 0).getLong(d5, 0L);
                    } catch (Throwable th2) {
                        ka.a(th2, "csp", "glv");
                    }
                    f3825j.put(d5, new h(Long.valueOf(j4), xa.b(f3819c, "open_common", d5 + "lct-info", "")));
                    a(f3819c);
                    b(f3819c);
                }
            } catch (Throwable th3) {
                ga.a(th3, "at", "rglc");
            }
        }
    }

    public static synchronized boolean a(String str, long j4) {
        synchronized (c9.class) {
            boolean z5 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            h b3 = b(str);
            long j10 = 0;
            if (j4 != (b3 != null ? b3.f3867a : 0L)) {
                if (f3826k != null && f3826k.containsKey(str)) {
                    j10 = f3826k.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j10 > 30000) {
                    z5 = true;
                }
            }
            return z5;
        }
    }

    public static synchronized void a(String str, boolean z5, String str2, String str3, String str4) {
        synchronized (c9.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f3826k == null) {
                    f3826k = new ConcurrentHashMap<>(8);
                }
                f3826k.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (f3827l == null) {
                    return;
                }
                if (f3827l.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z5) {
                        lb.a(true, str);
                    }
                    qc.d().b(new a(str, str2, str3, str4));
                }
            } catch (Throwable th2) {
                ga.a(th2, "at", "lca");
            }
        }
    }

    private static synchronized void a(String str, long j4, String str2) {
        synchronized (c9.class) {
            try {
                if (f3827l != null && f3827l.containsKey(str)) {
                    if (f3825j == null) {
                        f3825j = new ConcurrentHashMap<>(8);
                    }
                    f3825j.put(str, new h(Long.valueOf(j4), str2));
                    Context context = f3819c;
                    if (context != null) {
                        SharedPreferences.Editor a3 = xa.a(context, "open_common");
                        xa.a(a3, str, j4);
                        xa.a(a3, str + "lct-info", str2);
                        xa.a(a3);
                    }
                }
            } catch (Throwable th2) {
                ga.a(th2, "at", "ucut");
            }
        }
    }

    private static void a(m9 m9Var) {
        if (m9Var != null) {
            try {
                if (TextUtils.isEmpty(m9Var.d())) {
                    return;
                }
                String b3 = m9Var.b();
                if (TextUtils.isEmpty(b3)) {
                    b3 = m9Var.e();
                }
                if (TextUtils.isEmpty(b3)) {
                    return;
                }
                ca.a(m9Var.d(), b3);
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(Context context) {
        try {
            if (f3828m) {
                return;
            }
            ca.f3870b = xa.a(context, "open_common", SdCardDbCreator.FIELD_LASTLOC_NB, true);
            ca.f3871c = xa.a(context, "open_common", "a5", true);
            f3828m = true;
        } catch (Throwable unused) {
        }
    }

    public static void a(boolean z5, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            if (f3831p || z5) {
                if ((f3834t || !z5) && !TextUtils.isEmpty(str)) {
                    if (!z5) {
                        if (f3837w.get(str) != null) {
                            return;
                        }
                        f3837w.put(str, Boolean.TRUE);
                        a(b(str, "a14"), "open_common");
                        return;
                    }
                    if (f3838x.get(str) != null) {
                        return;
                    }
                    f3838x.put(str, Boolean.TRUE);
                    a(b(str, "a15"), "open_common");
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2) {
        f a3 = a(f3819c, str, str2);
        String a10 = n9.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!a10.equals(a3.f3860b)) {
            a3.a(a10);
            a3.f3861c.set(0);
        }
        a3.f3861c.incrementAndGet();
        a(f3819c, str, str2, a3);
    }

    public static void a(mb.c cVar) {
        synchronized (f3839y) {
            boolean z5 = false;
            for (int i3 = 0; i3 < f3839y.size(); i3++) {
                try {
                    mb.a aVar = f3839y.get(i3);
                    if (cVar.f4637c.equals(aVar.f4625a) && cVar.f4638d.equals(aVar.f4628d)) {
                        int i10 = cVar.f4646m;
                        int i11 = aVar.e;
                        if (i10 == i11) {
                            z5 = true;
                            if (i11 == 1) {
                                aVar.f4631h = ((aVar.f4632i.get() * aVar.f4631h) + cVar.f4639f) / (aVar.f4632i.get() + 1);
                            }
                            aVar.f4632i.getAndIncrement();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (!z5) {
                f3839y.add(new mb.a(cVar));
            }
        }
    }

    public static void a(boolean z5, mb.a aVar) {
        if (!f3840z || aVar == null) {
            return;
        }
        synchronized (f3839y) {
            if (z5) {
                try {
                    Iterator<mb.a> it = f3839y.iterator();
                    while (it.hasNext()) {
                        mb.a next = it.next();
                        if (next.f4625a.equals(aVar.f4625a) && next.f4628d.equals(aVar.f4628d) && next.e == aVar.e) {
                            if (next.f4632i == aVar.f4632i) {
                                it.remove();
                            } else {
                                next.f4632i.set(next.f4632i.get() - aVar.f4632i.get());
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            int i3 = 0;
            f3840z = false;
            ArrayList<mb.a> arrayList = f3839y;
            int size = arrayList.size();
            while (i3 < size) {
                mb.a aVar2 = arrayList.get(i3);
                i3++;
                mb.a aVar3 = aVar2;
                String str = aVar3.f4628d;
                Objects.toString(aVar3.f4632i);
            }
        }
    }

    private static synchronized f a(Context context, String str, String str2) {
        f fVar;
        synchronized (c9.class) {
            f fVar2 = null;
            if (!TextUtils.isEmpty(str)) {
                for (int i3 = 0; i3 < e.size(); i3++) {
                    fVar = e.get(i3);
                    if (fVar != null && str.equals(fVar.f3859a)) {
                        break;
                    }
                }
            }
            fVar = null;
            if (fVar != null) {
                return fVar;
            }
            if (context == null) {
                return null;
            }
            String b3 = xa.b(context, str2, str, "");
            if (!TextUtils.isEmpty(b3)) {
                try {
                    JSONObject jSONObject = new JSONObject(b3);
                    fVar2 = new f(jSONObject.optString(Const.INTENT_KEY_APIKEY), jSONObject.optString("f"), jSONObject.optInt(Const.INTENT_KEY_BACKGROUND_NOTIFICATION));
                } catch (Throwable unused) {
                }
            }
            String a3 = n9.a(System.currentTimeMillis(), "yyyyMMdd");
            if (fVar2 == null) {
                fVar2 = new f(str, a3, 0);
            }
            if (!a3.equals(fVar2.f3860b)) {
                fVar2.a(a3);
                fVar2.f3861c.set(0);
            }
            e.add(fVar2);
            return fVar2;
        }
    }
}
