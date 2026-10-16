package com.amap.api.col.p0003sl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.col.p0003sl.pb;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class mb {
    private static SoftReference<SSLContext> r;

    /* renamed from: s, reason: collision with root package name */
    private static SoftReference<nb> f4608s;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4609a;

    /* renamed from: b, reason: collision with root package name */
    private SSLContext f4610b;

    /* renamed from: c, reason: collision with root package name */
    private Proxy f4611c;

    /* renamed from: g, reason: collision with root package name */
    private String f4614g;

    /* renamed from: h, reason: collision with root package name */
    private ib.a f4615h;

    /* renamed from: i, reason: collision with root package name */
    private d f4616i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4618k;

    /* renamed from: l, reason: collision with root package name */
    private String f4619l;

    /* renamed from: m, reason: collision with root package name */
    private String f4620m;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f4612d = false;
    private long e = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f4613f = 0;

    /* renamed from: j, reason: collision with root package name */
    private String f4617j = "";

    /* renamed from: n, reason: collision with root package name */
    private boolean f4621n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4622o = false;

    /* renamed from: p, reason: collision with root package name */
    private String f4623p = "";

    /* renamed from: q, reason: collision with root package name */
    private f f4624q = new f();

    public static class a implements Cloneable, Comparable {

        /* renamed from: a, reason: collision with root package name */
        public String f4625a;

        /* renamed from: b, reason: collision with root package name */
        public String f4626b;

        /* renamed from: c, reason: collision with root package name */
        public String f4627c;

        /* renamed from: d, reason: collision with root package name */
        public String f4628d;
        public int e;

        /* renamed from: f, reason: collision with root package name */
        public int f4629f;

        /* renamed from: g, reason: collision with root package name */
        public int f4630g;

        /* renamed from: h, reason: collision with root package name */
        public long f4631h;

        /* renamed from: i, reason: collision with root package name */
        public volatile AtomicInteger f4632i = new AtomicInteger(1);

        public a(c cVar) {
            this.f4625a = cVar.f4637c;
            this.f4626b = cVar.e;
            this.f4628d = cVar.f4638d;
            this.e = cVar.f4646m;
            this.f4629f = cVar.f4647n;
            this.f4630g = cVar.f4636b.a();
            this.f4627c = cVar.f4635a;
            this.f4631h = cVar.f4639f;
        }

        public a a() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public String b() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.e + Const.STR_MART_WELL;
                if (TextUtils.isEmpty(this.f4628d)) {
                    str = str5 + "-#";
                } else {
                    str = str5 + this.f4628d + Const.STR_MART_WELL;
                }
                String str6 = (str + this.f4630g + Const.STR_MART_WELL) + this.f4632i + Const.STR_MART_WELL;
                if (TextUtils.isEmpty(this.f4625a)) {
                    str2 = str6 + "-#";
                } else {
                    str2 = str6 + this.f4625a + Const.STR_MART_WELL;
                }
                if (this.e == 1) {
                    str3 = str2 + this.f4627c + Const.STR_MART_WELL;
                } else {
                    str3 = str2 + "-#";
                }
                if (this.e == 1) {
                    str4 = str3 + this.f4631h + Const.STR_MART_WELL;
                } else {
                    str4 = str3 + "-#";
                }
                return h9.c(eb.a(((str4 + this.f4626b + Const.STR_MART_WELL) + this.f4629f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            } catch (Exception unused) {
                return null;
            }
        }

        public Object clone() throws CloneNotSupportedException {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            ((a) obj).getClass();
            return 0;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public HttpURLConnection f4633a;

        /* renamed from: b, reason: collision with root package name */
        public int f4634b = this.f4634b;

        /* renamed from: b, reason: collision with root package name */
        public int f4634b = this.f4634b;

        public b(HttpURLConnection httpURLConnection) {
            this.f4633a = httpURLConnection;
        }
    }

    public static class c implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        public String f4635a = "";

        /* renamed from: b, reason: collision with root package name */
        public pb.b f4636b = pb.b.FIRST_NONDEGRADE;

        /* renamed from: c, reason: collision with root package name */
        public String f4637c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f4638d = "";
        public String e = "";

        /* renamed from: f, reason: collision with root package name */
        public long f4639f = 0;

        /* renamed from: g, reason: collision with root package name */
        public long f4640g = 0;

        /* renamed from: h, reason: collision with root package name */
        public long f4641h = 0;

        /* renamed from: i, reason: collision with root package name */
        public long f4642i = 0;

        /* renamed from: j, reason: collision with root package name */
        public long f4643j = 0;

        /* renamed from: k, reason: collision with root package name */
        public String f4644k = "-";

        /* renamed from: l, reason: collision with root package name */
        public String f4645l = "-";

        /* renamed from: m, reason: collision with root package name */
        public int f4646m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f4647n = 0;

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public String b() {
            String f2 = !TextUtils.isEmpty(this.f4637c) ? r5.a.f(new StringBuilder(), this.f4637c, Const.STR_MART_WELL) : "-#";
            StringBuilder t8 = l0.t(!TextUtils.isEmpty(this.f4638d) ? r5.a.f(l0.t(f2), this.f4638d, Const.STR_MART_WELL) : android.support.v4.media.session.e.l(f2, "-#"));
            t8.append(this.f4636b.a());
            t8.append(Const.STR_MART_WELL);
            StringBuilder t10 = l0.t(android.support.v4.media.session.e.n(l0.t(android.support.v4.media.session.e.n(l0.t(t8.toString()), this.f4641h, Const.STR_MART_WELL)), this.f4643j, Const.STR_MART_WELL));
            t10.append(this.f4639f);
            return h9.c(eb.a(t10.toString().getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("RequestInfo{csid='");
            sb2.append(this.f4635a);
            sb2.append("', degradeType=");
            sb2.append(this.f4636b);
            sb2.append(", serverIp='");
            sb2.append(this.f4637c);
            sb2.append("', path='");
            sb2.append(this.f4638d);
            sb2.append("', hostname='");
            sb2.append(this.e);
            sb2.append("', totalTime=");
            sb2.append(this.f4639f);
            sb2.append(", DNSTime=");
            sb2.append(this.f4640g);
            sb2.append(", connectionTime=");
            sb2.append(this.f4641h);
            sb2.append(", writeTime=");
            sb2.append(this.f4642i);
            sb2.append(", readTime=");
            sb2.append(this.f4643j);
            sb2.append(", serverTime='");
            sb2.append(this.f4644k);
            sb2.append("', datasize='");
            sb2.append(this.f4645l);
            sb2.append("', errorcode=");
            sb2.append(this.f4646m);
            sb2.append(", errorcodeSub=");
            return android.support.v4.media.session.e.m(sb2, this.f4647n, '}');
        }
    }

    public static class e implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        private String f4650a;

        /* renamed from: b, reason: collision with root package name */
        private String f4651b;

        private e() {
        }

        public final void a(String str) {
            String[] split;
            if (TextUtils.isEmpty(this.f4650a) || !str.contains(":") || (split = str.split(":")) == null || split.length <= 0) {
                this.f4650a = str;
            } else {
                this.f4650a = split[0];
            }
        }

        public final void b(String str) {
            this.f4651b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.f4650a) ? this.f4650a.equals(str) : !TextUtils.isEmpty(this.f4651b) ? defaultHostnameVerifier.verify(this.f4651b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }

        public /* synthetic */ e(byte b3) {
            this();
        }

        public final String a() {
            return this.f4651b;
        }
    }

    public class f {

        /* renamed from: a, reason: collision with root package name */
        long f4652a = 0;

        /* renamed from: b, reason: collision with root package name */
        long f4653b = 0;

        /* renamed from: c, reason: collision with root package name */
        c f4654c = new c();

        /* renamed from: d, reason: collision with root package name */
        a f4655d;
        c e;

        /* renamed from: f, reason: collision with root package name */
        String f4656f;

        /* renamed from: g, reason: collision with root package name */
        URL f4657g;

        public f() {
        }

        public final void a() {
            this.f4654c.f4641h = SystemClock.elapsedRealtime() - this.f4653b;
        }

        public final void b() {
            this.f4654c.f4642i = SystemClock.elapsedRealtime() - this.f4653b;
        }

        public final void c() {
            this.f4654c.f4643j = SystemClock.elapsedRealtime() - this.f4653b;
        }

        public final void d() {
            c clone = this.f4654c.clone();
            if (this.f4654c.f4639f > c9.f3830o) {
                clone.f4646m = 1;
            }
            if (clone == null || c9.f3819c == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("serverip", clone.f4637c);
            hashMap.put("hostname", clone.e);
            hashMap.put(FileDownloadModel.PATH, clone.f4638d);
            hashMap.put("csid", clone.f4635a);
            hashMap.put("degrade", String.valueOf(clone.f4636b.a()));
            hashMap.put("errorcode", String.valueOf(clone.f4646m));
            hashMap.put("errorsubcode", String.valueOf(clone.f4647n));
            hashMap.put("connecttime", String.valueOf(clone.f4641h));
            hashMap.put("writetime", String.valueOf(clone.f4642i));
            hashMap.put("readtime", String.valueOf(clone.f4643j));
            hashMap.put("datasize", String.valueOf(clone.f4645l));
            hashMap.put("totaltime", String.valueOf(clone.f4639f));
            String jSONObject = new JSONObject(hashMap).toString();
            "--埋点--".concat(String.valueOf(jSONObject));
            if (TextUtils.isEmpty(jSONObject)) {
                return;
            }
            try {
                zb zbVar = new zb(c9.f3819c, "core", "2.0", "O008");
                zbVar.a(jSONObject);
                ac.a(zbVar, c9.f3819c);
            } catch (a9 unused) {
            }
        }

        public final void a(qb qbVar) {
            c clone;
            try {
                this.f4654c.f4639f = SystemClock.elapsedRealtime() - this.f4652a;
                if (qbVar != null) {
                    qbVar.e = this.f4654c.f4636b.b();
                }
                if (this.f4654c.f4636b.e()) {
                    c cVar = this.f4654c;
                    if (cVar.f4639f > 10000) {
                        c9.a(false, cVar.e);
                    }
                }
                if (this.f4654c.f4636b.c()) {
                    c9.a(false, this.f4656f);
                }
                boolean a3 = mb.this.a(this.f4654c.e);
                if (a3) {
                    c9.b(this.f4654c);
                    c9.a(true, this.f4655d);
                    c cVar2 = this.f4654c;
                    if (cVar2.f4639f > c9.f3830o && (clone = cVar2.clone()) != null) {
                        clone.f4646m = 1;
                        c9.a(clone);
                        clone.toString();
                    }
                }
                c9.a(this.f4657g.toString(), this.f4654c.f4636b.b(), false, a3);
                this.f4654c.toString();
            } catch (Throwable unused) {
            }
        }

        public final void b(int i3) {
            this.f4654c.f4647n = i3;
        }

        public final void a(int i3) {
            "----errorcode-----".concat(String.valueOf(i3));
            try {
                this.f4654c.f4639f = SystemClock.elapsedRealtime() - this.f4652a;
                c cVar = this.f4654c;
                cVar.f4646m = i3;
                if (cVar.f4636b.d()) {
                    c9.a(false, this.f4654c.e);
                }
                boolean a3 = mb.this.a(this.f4654c.e);
                if (a3) {
                    if (mb.this.f4622o && !TextUtils.isEmpty(mb.this.f4620m) && this.f4654c.f4636b.e()) {
                        c9.b();
                    }
                    if (this.f4654c.f4636b.b()) {
                        c9.a(this.f4654c.f4636b.b(), this.f4654c.e);
                    }
                    c9.b(this.e);
                    c9.a(false, this.f4655d);
                    c9.a(this.f4654c);
                }
                c9.a(this.f4657g.toString(), this.f4654c.f4636b.b(), true, a3);
                this.f4654c.toString();
            } catch (Throwable unused) {
            }
        }

        public final void a(long j4) {
            this.f4654c.f4645l = new DecimalFormat("0.00").format(j4 / 1024.0f);
        }
    }

    public mb() {
        c9.h();
        try {
            this.f4614g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th2) {
            ga.a(th2, "ht", "ic");
        }
    }

    private void d(pb pbVar) throws a9 {
        this.f4616i = new d((byte) 0);
        this.f4622o = pbVar.isIPV6Request();
        this.f4611c = pbVar.getProxy();
        this.f4615h = pbVar.getUrlConnectionImpl();
        this.f4618k = pbVar.isBinary();
        this.f4617j = pbVar.parseSdkNameFromRequest();
        this.f4609a = i9.a().a(pbVar.isHttps());
        String b3 = pbVar.getDegradeType().e() ? pbVar.b() : pbVar.a();
        this.f4619l = b3;
        String b10 = lb.b(b3, this.f4617j);
        this.f4619l = b10;
        "restrictionURLTest: ".concat(String.valueOf(b10));
        if (sb.a().a(b10)) {
            "restriction hit: ".concat(String.valueOf(b10));
            throw new a9("限制访问的接口");
        }
        this.f4620m = pbVar.getIPDNSName();
        if ("loc".equals(this.f4617j)) {
            String a3 = pbVar.a();
            String b11 = pbVar.b();
            if (!TextUtils.isEmpty(a3)) {
                try {
                    new URL(a3).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(b11)) {
                return;
            }
            try {
                if (TextUtils.isEmpty(this.f4620m)) {
                    new URL(b11).getHost();
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:10|11|(8:13|(1:15)|(9:19|20|21|22|23|24|25|(1:27)|28)|44|45|46|47|48)|52|(1:54)|(10:17|19|20|21|22|23|24|25|(0)|28)|44|45|46|47|48) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c5, code lost:
    
        com.amap.api.col.p0003sl.ga.a(r0, "ht", "mPt");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c A[Catch: all -> 0x0040, a9 -> 0x0044, SocketTimeoutException -> 0x0048, SocketException -> 0x004c, ConnectTimeoutException -> 0x0050, ConnectException -> 0x0054, SSLException -> 0x0058, IOException -> 0x00ce, InterruptedIOException -> 0x00d0, UnknownHostException -> 0x00d2, MalformedURLException -> 0x00d5, TryCatch #10 {a9 -> 0x0044, ConnectException -> 0x0054, MalformedURLException -> 0x00d5, SocketException -> 0x004c, SocketTimeoutException -> 0x0048, UnknownHostException -> 0x00d2, ConnectTimeoutException -> 0x0050, InterruptedIOException -> 0x00d0, SSLException -> 0x0058, IOException -> 0x00ce, all -> 0x0040, blocks: (B:11:0x0026, B:13:0x003c, B:17:0x0070, B:25:0x0087, B:27:0x008c, B:28:0x008f, B:33:0x009e, B:35:0x00a3, B:36:0x00a6, B:37:0x00ab, B:44:0x00ac, B:52:0x005c, B:54:0x006a), top: B:10:0x0026 }] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.amap.api.col.p0003sl.qb c(com.amap.api.col.p0003sl.pb r15) throws com.amap.api.col.p0003sl.a9 {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.mb.c(com.amap.api.col.3sl.pb):com.amap.api.col.3sl.qb");
    }

    public final void b(long j4) {
        this.e = j4;
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private Vector<e> f4648a;

        /* renamed from: b, reason: collision with root package name */
        private volatile e f4649b;

        private d() {
            this.f4648a = new Vector<>();
            this.f4649b = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f4649b;
            }
            byte b3 = 0;
            for (int i3 = 0; i3 < this.f4648a.size(); i3++) {
                e eVar = this.f4648a.get(i3);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e(b3);
            eVar2.b(str);
            this.f4648a.add(eVar2);
            return eVar2;
        }

        public /* synthetic */ d(byte b3) {
            this();
        }
    }

    public final void a() {
        this.f4612d = true;
    }

    public final qb b(pb pbVar) throws a9 {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    d(pbVar);
                                    String a3 = a(this.f4619l, pbVar.getParams());
                                    this.f4619l = a3;
                                    qb a10 = lb.a(a3, this.f4617j);
                                    if (a10 != null) {
                                        this.f4624q.d();
                                        return a10;
                                    }
                                    b a11 = a(pbVar, false, true);
                                    httpURLConnection = a11.f4633a;
                                    this.f4624q.f4653b = SystemClock.elapsedRealtime();
                                    httpURLConnection.connect();
                                    this.f4624q.a();
                                    qb a12 = a(a11, pbVar.isIgnoreGZip());
                                    this.f4624q.a(a12);
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th2) {
                                        ga.a(th2, "ht", "mgr");
                                    }
                                    this.f4624q.d();
                                    return a12;
                                } catch (MalformedURLException unused) {
                                    this.f4624q.a(8);
                                    throw new a9(AMapException.AMAP_CLIENT_URL_EXCEPTION);
                                }
                            } catch (SSLException e10) {
                                e10.printStackTrace();
                                this.f4624q.f4654c.f4647n = a(e10);
                                this.f4624q.a(4);
                                throw new a9(AMapException.AMAP_CLIENT_IO_EXCEPTION);
                            } catch (IOException unused2) {
                                this.f4624q.a(7);
                                throw new a9(AMapException.AMAP_CLIENT_IO_EXCEPTION);
                            }
                        } catch (SocketTimeoutException e11) {
                            this.f4624q.f4654c.f4647n = a(e11);
                            this.f4624q.a(2);
                            throw new a9(AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION);
                        } catch (ConnectTimeoutException e12) {
                            e12.printStackTrace();
                            this.f4624q.f4654c.f4647n = a(e12);
                            this.f4624q.a(2);
                            throw new a9(AMapException.AMAP_CLIENT_IO_EXCEPTION);
                        }
                    } catch (a9 e13) {
                        if (!e13.h() && e13.a() != 10) {
                            this.f4624q.a(e13.c());
                        }
                        throw e13;
                    } catch (InterruptedIOException unused3) {
                        f fVar = this.f4624q;
                        fVar.f4654c.f4647n = 7101;
                        fVar.a(7);
                        throw new a9("未知的错误");
                    }
                } catch (ConnectException e14) {
                    this.f4624q.f4654c.f4647n = a(e14);
                    this.f4624q.a(6);
                    throw new a9("http连接失败 - ConnectionException");
                } catch (SocketException e15) {
                    this.f4624q.f4654c.f4647n = a(e15);
                    this.f4624q.a(6);
                    throw new a9("socket 连接异常 - SocketException");
                }
            } catch (UnknownHostException unused4) {
                this.f4624q.a(9);
                throw new a9(AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION);
            } catch (Throwable th3) {
                th3.printStackTrace();
                this.f4624q.a(9);
                throw new a9("未知的错误");
            }
        } catch (Throwable th4) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th5) {
                    ga.a(th5, "ht", "mgr");
                }
            }
            this.f4624q.d();
            throw th4;
        }
    }

    public final void a(long j4) {
        this.f4613f = j4;
    }

    private static String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() <= 0) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf >= 0) {
            HashMap hashMap = new HashMap();
            String substring = str.substring(indexOf);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (!substring.matches(".*[\\?\\&]" + URLEncoder.encode(key) + "=.*")) {
                    hashMap.put(key, value);
                }
            }
            map = hashMap;
        }
        if (map.size() == 0) {
            return str;
        }
        String a3 = a(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (indexOf >= 0) {
            if (!str.endsWith("?") && !str.endsWith(Const.STR_MART_ADD)) {
                stringBuffer.append(Const.STR_MART_ADD);
            }
        } else {
            stringBuffer.append("?");
        }
        if (a3 != null) {
            stringBuffer.append(a3);
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:(3:6|7|8)|(3:369|370|(18:372|11|12|13|14|(3:16|17|18)(1:334)|19|20|21|(1:23)(1:288)|24|(1:26)|27|(3:29|30|31)(11:44|45|46|47|(6:54|(1:59)|84|85|83|48)|60|(1:62)(1:79)|63|(2:71|72)|65|66)|35|36|33|34))|10|11|12|13|14|(0)(0)|19|20|21|(0)(0)|24|(0)|27|(0)(0)|35|36|33|34) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0326, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0471, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03d9, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0388, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0357, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x03b0, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0441, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x040d, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x02f7, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x02a0, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0213, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0214, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0240, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0241, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0231, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0232, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0227, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0228, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0222, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0223, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x021d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x021e, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x022c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x022d, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x023b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x023c, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0236, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0237, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0218, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0219, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x020e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x020f, code lost:
    
        r8 = null;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x015d, code lost:
    
        if (r13 == 0) goto L387;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x00e4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x00e5, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0108, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0109, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x00f0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x00f1, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x00ec, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x00ed, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x00fc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x00fd, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x00f4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x00f5, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x00f8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x00f9, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x0104, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x0105, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0100, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0101, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x00e8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x00e9, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x00e0, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x00e1, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0477, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0478, code lost:
    
        com.amap.api.col.p0003sl.ga.a(r0, "ht", "mdr");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x020a, code lost:
    
        if (r13 == 0) goto L387;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01bf, code lost:
    
        r20.onDownload(r12, r18.f4613f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02cf, code lost:
    
        if (r13 != 0) goto L418;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x031e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x030f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0469 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x045a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0380 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094 A[Catch: all -> 0x00e0, a9 -> 0x00e4, IOException -> 0x00e8, InterruptedIOException -> 0x00ec, SocketTimeoutException -> 0x00f0, SocketException -> 0x00f4, UnknownHostException -> 0x00f8, MalformedURLException -> 0x00fc, ConnectTimeoutException -> 0x0100, SSLException -> 0x0104, ConnectException -> 0x0108, TRY_LEAVE, TryCatch #40 {a9 -> 0x00e4, ConnectException -> 0x0108, SocketTimeoutException -> 0x00f0, InterruptedIOException -> 0x00ec, MalformedURLException -> 0x00fc, SocketException -> 0x00f4, UnknownHostException -> 0x00f8, SSLException -> 0x0104, ConnectTimeoutException -> 0x0100, IOException -> 0x00e8, all -> 0x00e0, blocks: (B:14:0x0068, B:16:0x0094), top: B:13:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0371 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x034f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0340 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0399 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0439 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x042a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0405 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x02ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x02e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0298 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0289 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0125 A[Catch: all -> 0x00b4, a9 -> 0x00b8, IOException -> 0x00bc, InterruptedIOException -> 0x00c0, SocketTimeoutException -> 0x00c4, SocketException -> 0x00c8, UnknownHostException -> 0x00cc, MalformedURLException -> 0x00d0, ConnectTimeoutException -> 0x00d4, SSLException -> 0x00d8, ConnectException -> 0x00dc, TRY_ENTER, TRY_LEAVE, TryCatch #41 {a9 -> 0x00b8, InterruptedIOException -> 0x00c0, ConnectException -> 0x00dc, MalformedURLException -> 0x00d0, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c4, UnknownHostException -> 0x00cc, SSLException -> 0x00d8, ConnectTimeoutException -> 0x00d4, IOException -> 0x00bc, all -> 0x00b4, blocks: (B:18:0x00a5, B:29:0x0125), top: B:17:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0161 A[Catch: all -> 0x020e, a9 -> 0x0213, IOException -> 0x0218, InterruptedIOException -> 0x021d, SocketTimeoutException -> 0x0222, SocketException -> 0x0227, UnknownHostException -> 0x022c, MalformedURLException -> 0x0231, ConnectTimeoutException -> 0x0236, SSLException -> 0x023b, ConnectException -> 0x0240, TRY_ENTER, TRY_LEAVE, TryCatch #42 {a9 -> 0x0213, ConnectException -> 0x0240, MalformedURLException -> 0x0231, SocketException -> 0x0227, SocketTimeoutException -> 0x0222, InterruptedIOException -> 0x021d, UnknownHostException -> 0x022c, SSLException -> 0x023b, ConnectTimeoutException -> 0x0236, IOException -> 0x0218, all -> 0x020e, blocks: (B:20:0x010d, B:44:0x0161), top: B:19:0x010d }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v42, types: [java.io.DataOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r13v46 */
    /* JADX WARN: Type inference failed for: r13v47 */
    /* JADX WARN: Type inference failed for: r13v48 */
    /* JADX WARN: Type inference failed for: r13v49 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v50 */
    /* JADX WARN: Type inference failed for: r13v51 */
    /* JADX WARN: Type inference failed for: r13v52 */
    /* JADX WARN: Type inference failed for: r13v53 */
    /* JADX WARN: Type inference failed for: r13v54 */
    /* JADX WARN: Type inference failed for: r13v55 */
    /* JADX WARN: Type inference failed for: r13v56 */
    /* JADX WARN: Type inference failed for: r13v57 */
    /* JADX WARN: Type inference failed for: r13v58 */
    /* JADX WARN: Type inference failed for: r13v59 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v60 */
    /* JADX WARN: Type inference failed for: r13v61 */
    /* JADX WARN: Type inference failed for: r13v62 */
    /* JADX WARN: Type inference failed for: r13v63 */
    /* JADX WARN: Type inference failed for: r13v64 */
    /* JADX WARN: Type inference failed for: r13v65 */
    /* JADX WARN: Type inference failed for: r13v66 */
    /* JADX WARN: Type inference failed for: r13v67 */
    /* JADX WARN: Type inference failed for: r13v68 */
    /* JADX WARN: Type inference failed for: r13v69 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v70 */
    /* JADX WARN: Type inference failed for: r13v71 */
    /* JADX WARN: Type inference failed for: r13v72 */
    /* JADX WARN: Type inference failed for: r13v73 */
    /* JADX WARN: Type inference failed for: r13v74 */
    /* JADX WARN: Type inference failed for: r13v75 */
    /* JADX WARN: Type inference failed for: r13v76 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.amap.api.col.3sl.kb$a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.amap.api.col.p0003sl.pb r19, com.amap.api.col.3sl.kb.a r20) {
        /*
            Method dump skipped, instructions count: 1194
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.mb.a(com.amap.api.col.3sl.pb, com.amap.api.col.3sl.kb$a):void");
    }

    private static String b(Map<String, List<String>> map) {
        try {
            List<String> list = map.get("sc");
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!str.contains(Const.STR_MART_WELL)) {
                return str;
            }
            String[] split = str.split(Const.STR_MART_WELL);
            return split.length > 1 ? split[0] : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean b(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    public final Map<String, String> a(pb pbVar) throws a9 {
        int i3;
        HttpURLConnection httpURLConnection;
        String headerFieldKey;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                d(pbVar);
                this.f4619l = a(this.f4619l, pbVar.getParams());
                httpURLConnection = a(pbVar, false, false).f4633a;
            } finally {
                if (0 != 0) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th2) {
                        ga.a(th2, "hth", "mgr");
                    }
                }
                this.f4624q.d();
            }
        } catch (a9 e10) {
            e = e10;
        } catch (ConnectException e11) {
            e = e11;
        } catch (SocketTimeoutException e12) {
            e = e12;
        } catch (InterruptedIOException unused) {
        } catch (MalformedURLException unused2) {
        } catch (SocketException e13) {
            e = e13;
        } catch (UnknownHostException unused3) {
        } catch (SSLException e14) {
            e = e14;
        } catch (ConnectTimeoutException e15) {
            e = e15;
        } catch (IOException unused4) {
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            this.f4624q.f4653b = SystemClock.elapsedRealtime();
            httpURLConnection.connect();
            this.f4624q.a();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                HashMap hashMap = new HashMap();
                for (i3 = 0; i3 < 50 && (headerFieldKey = httpURLConnection.getHeaderFieldKey(i3)) != null; i3++) {
                    hashMap.put(headerFieldKey.toLowerCase(), httpURLConnection.getHeaderField(headerFieldKey));
                }
                this.f4624q.a((qb) null);
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    ga.a(th4, "hth", "mgr");
                }
                this.f4624q.d();
                return hashMap;
            }
            this.f4624q.b(responseCode);
            this.f4624q.a(10);
            a9 a9Var = new a9("http读取header失败");
            a9Var.b(responseCode);
            throw a9Var;
        } catch (a9 e16) {
            e = e16;
            this.f4624q.a(e.a());
            throw e;
        } catch (InterruptedIOException unused5) {
            f fVar = this.f4624q;
            fVar.f4654c.f4647n = 7101;
            fVar.a(7);
            throw new a9("未知的错误");
        } catch (ConnectException e17) {
            e = e17;
            this.f4624q.f4654c.f4647n = a(e);
            this.f4624q.a(6);
            throw new a9("http连接失败 - ConnectionException");
        } catch (MalformedURLException unused6) {
            this.f4624q.a(8);
            throw new a9(AMapException.AMAP_CLIENT_URL_EXCEPTION);
        } catch (SocketException e18) {
            e = e18;
            this.f4624q.f4654c.f4647n = a(e);
            this.f4624q.a(6);
            throw new a9("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e19) {
            e = e19;
            this.f4624q.f4654c.f4647n = a(e);
            this.f4624q.a(2);
            throw new a9(AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION);
        } catch (UnknownHostException unused7) {
            this.f4624q.a(9);
            throw new a9(AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION);
        } catch (SSLException e20) {
            e = e20;
            e.printStackTrace();
            this.f4624q.f4654c.f4647n = a(e);
            this.f4624q.a(4);
            throw new a9(AMapException.AMAP_CLIENT_IO_EXCEPTION);
        } catch (ConnectTimeoutException e21) {
            e = e21;
            e.printStackTrace();
            this.f4624q.f4654c.f4647n = a(e);
            this.f4624q.a(2);
            throw new a9(AMapException.AMAP_CLIENT_IO_EXCEPTION);
        } catch (IOException unused8) {
            this.f4624q.a(7);
            throw new a9(AMapException.AMAP_CLIENT_IO_EXCEPTION);
        } catch (Throwable th5) {
            th = th5;
            this.f4624q.a(9);
            th.printStackTrace();
            throw new a9("未知的错误");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0038, code lost:
    
        if ("1".equals(r1[1]) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "lct"
            java.lang.String r1 = "#"
            r2 = 0
            java.lang.String r3 = "sc"
            java.lang.Object r3 = r7.get(r3)     // Catch: java.lang.Throwable -> L5d
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L5d
            if (r3 == 0) goto L5d
            int r4 = r3.size()     // Catch: java.lang.Throwable -> L5d
            if (r4 <= 0) goto L5d
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L5d
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L5d
            if (r4 != 0) goto L5d
            boolean r4 = r3.contains(r1)     // Catch: java.lang.Throwable -> L5d
            r5 = 1
            if (r4 != 0) goto L29
            goto L3a
        L29:
            java.lang.String[] r1 = r3.split(r1)     // Catch: java.lang.Throwable -> L5d
            int r3 = r1.length     // Catch: java.lang.Throwable -> L5d
            if (r3 <= r5) goto L5d
            java.lang.String r3 = "1"
            r1 = r1[r5]     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L5d
        L3a:
            if (r8 == 0) goto L5c
            boolean r8 = r7.containsKey(r0)     // Catch: java.lang.Throwable -> L5d
            if (r8 == 0) goto L5b
            java.lang.Object r7 = r7.get(r0)     // Catch: java.lang.Throwable -> L5d
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> L5d
            if (r7 == 0) goto L5b
            int r8 = r7.size()     // Catch: java.lang.Throwable -> L5d
            if (r8 <= 0) goto L5b
            long r7 = com.amap.api.col.p0003sl.c9.a(r7)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r0 = r6.f4617j     // Catch: java.lang.Throwable -> L5d
            boolean r7 = com.amap.api.col.p0003sl.c9.a(r0, r7)     // Catch: java.lang.Throwable -> L5d
            return r7
        L5b:
            return r2
        L5c:
            return r5
        L5d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.mb.a(java.util.Map, boolean):boolean");
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb2.length() > 0) {
                sb2.append(Const.STR_MART_ADD);
            }
            sb2.append(URLEncoder.encode(key));
            sb2.append("=");
            sb2.append(URLEncoder.encode(value));
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (this.f4618k) {
            return true;
        }
        return (!TextUtils.isEmpty(this.f4620m) && (this.f4620m.contains("rest") || this.f4620m.contains("apilocate"))) || b(str);
    }

    public int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof SSLKeyException) {
            return 4102;
        }
        if (exc instanceof SSLProtocolException) {
            return 4103;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 4104;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        if (exc instanceof ConnectTimeoutException) {
            return 2101;
        }
        if (exc instanceof SocketTimeoutException) {
            return ReportUtil.EXCEPTION_CODE_SERVERAUTHCLIENSCODE;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x028d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02ae A[Catch: all -> 0x0298, TryCatch #3 {all -> 0x0298, blocks: (B:199:0x028d, B:201:0x0291, B:204:0x02aa, B:206:0x02ae, B:208:0x02ba, B:215:0x029a), top: B:198:0x028d }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02ba A[Catch: all -> 0x0298, TRY_LEAVE, TryCatch #3 {all -> 0x0298, blocks: (B:199:0x028d, B:201:0x0291, B:204:0x02aa, B:206:0x02ae, B:208:0x02ba, B:215:0x029a), top: B:198:0x028d }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0275 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018b A[Catch: all -> 0x01f8, TryCatch #4 {all -> 0x01f8, blocks: (B:41:0x011a, B:43:0x012e, B:45:0x0131, B:47:0x0135, B:49:0x013b, B:53:0x0146, B:56:0x0150, B:58:0x0153, B:62:0x0159, B:63:0x0185, B:65:0x018b, B:67:0x0195, B:68:0x01a6, B:70:0x01aa, B:72:0x01ce, B:74:0x01ef, B:75:0x01f2, B:60:0x016f, B:80:0x0173, B:82:0x0176, B:86:0x017c, B:84:0x0181), top: B:40:0x011a }] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.amap.api.col.3sl.mb.b a(com.amap.api.col.p0003sl.pb r17, boolean r18, boolean r19) throws java.io.IOException, com.amap.api.col.p0003sl.a9 {
        /*
            Method dump skipped, instructions count: 1130
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.mb.a(com.amap.api.col.3sl.pb, boolean, boolean):com.amap.api.col.3sl.mb$b");
    }

    private static String a(HttpURLConnection httpURLConnection) {
        List<String> list;
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (headerFields != null && (list = headerFields.get("gsid")) != null && list.size() > 0) {
                return list.get(0);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01da A[Catch: all -> 0x01fd, TRY_LEAVE, TryCatch #18 {all -> 0x01fd, blocks: (B:106:0x01d6, B:108:0x01da, B:110:0x01de, B:112:0x01ed, B:114:0x01f9, B:117:0x01ff, B:118:0x0200, B:177:0x0204, B:181:0x0208), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0200 A[Catch: all -> 0x01fd, TryCatch #18 {all -> 0x01fd, blocks: (B:106:0x01d6, B:108:0x01da, B:110:0x01de, B:112:0x01ed, B:114:0x01f9, B:117:0x01ff, B:118:0x0200, B:177:0x0204, B:181:0x0208), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0238 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x022a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x021c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x020e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.amap.api.col.p0003sl.qb a(com.amap.api.col.3sl.mb.b r12, boolean r13) throws com.amap.api.col.p0003sl.a9, java.io.IOException {
        /*
            Method dump skipped, instructions count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.mb.a(com.amap.api.col.3sl.mb$b, boolean):com.amap.api.col.3sl.qb");
    }
}
