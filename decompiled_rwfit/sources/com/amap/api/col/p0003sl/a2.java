package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public class a2 {

    /* renamed from: n, reason: collision with root package name */
    public static String f3568n = "";

    /* renamed from: o, reason: collision with root package name */
    public static boolean f3569o = false;

    /* renamed from: p, reason: collision with root package name */
    private static volatile a2 f3570p = null;

    /* renamed from: q, reason: collision with root package name */
    public static String f3571q = "";

    /* renamed from: a, reason: collision with root package name */
    private Context f3572a;

    /* renamed from: d, reason: collision with root package name */
    private d f3575d;
    private j2 e;

    /* renamed from: f, reason: collision with root package name */
    private p2 f3576f;

    /* renamed from: k, reason: collision with root package name */
    public e2 f3581k;

    /* renamed from: l, reason: collision with root package name */
    g2 f3582l;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3573b = true;

    /* renamed from: c, reason: collision with root package name */
    List<z1> f3574c = new Vector();

    /* renamed from: g, reason: collision with root package name */
    private qc f3577g = null;

    /* renamed from: h, reason: collision with root package name */
    private qc f3578h = null;

    /* renamed from: i, reason: collision with root package name */
    private qc f3579i = null;

    /* renamed from: j, reason: collision with root package name */
    e f3580j = null;

    /* renamed from: m, reason: collision with root package name */
    d2 f3583m = null;

    public class a extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3584a;

        public a(String str) {
            this.f3584a = str;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            z1 c9 = a2.this.c(this.f3584a);
            if (c9 != null) {
                try {
                    if (!c9.f5534v.equals(c9.f5526m) && !c9.f5534v.equals(c9.f5528o)) {
                        String pinyin = c9.getPinyin();
                        if (pinyin.length() > 0) {
                            String d5 = a2.this.f3576f.d(pinyin);
                            if (d5 == null) {
                                d5 = c9.getVersion();
                            }
                            if (a2.f3571q.length() > 0 && d5 != null && a2.this.a(a2.f3571q, d5)) {
                                c9.f5534v.equals(c9.f5529p);
                                c9.f5534v.f();
                            }
                        }
                    }
                    if (a2.this.f3575d != null) {
                        synchronized (a2.this) {
                            try {
                                a2.this.f3575d.b(c9);
                            } finally {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    if (a2.this.f3575d != null) {
                        synchronized (a2.this) {
                            try {
                                a2.this.f3575d.b(c9);
                            } finally {
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    if (a2.this.f3575d != null) {
                        synchronized (a2.this) {
                            try {
                                a2.this.f3575d.b(c9);
                            } finally {
                                throw th2;
                            }
                        }
                    }
                    throw th2;
                }
            }
            a2.b(a2.this);
            b2 a3 = new c2(a2.this.f3572a, a2.f3571q).a();
            if (a2.this.f3575d != null) {
                if (a3 == null) {
                    if (a2.this.f3575d != null) {
                        synchronized (a2.this) {
                            try {
                                a2.this.f3575d.b(c9);
                            } finally {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (a3.a()) {
                    a2.this.f();
                }
            }
            if (a2.this.f3575d != null) {
                synchronized (a2.this) {
                    try {
                        a2.this.f3575d.b(c9);
                    } finally {
                    }
                }
            }
        }
    }

    public class b extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ z1 f3586a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f3587b;

        public b(z1 z1Var, boolean z5) {
            this.f3586a = z1Var;
            this.f3587b = z5;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            try {
                z1 z1Var = this.f3586a;
                if (z1Var.f5534v.equals(z1Var.f5524k)) {
                    if (a2.this.f3575d != null) {
                        a2.this.f3575d.c(this.f3586a);
                        return;
                    }
                    return;
                }
                if (this.f3586a.getState() != 7 && this.f3586a.getState() != -1) {
                    a2.this.f3582l.b(this.f3586a);
                    if (a2.this.f3575d != null) {
                        a2.this.f3575d.c(this.f3586a);
                        return;
                    }
                    return;
                }
                a2.this.f3582l.b(this.f3586a);
                if (!this.f3587b || a2.this.f3575d == null) {
                    return;
                }
                a2.this.f3575d.c(this.f3586a);
            } catch (Throwable th2) {
                ka.a(th2, "requestDelete", "removeExcecRunnable");
            }
        }
    }

    public class c extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ z1 f3589a;

        public c(z1 z1Var) {
            this.f3589a = z1Var;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            try {
                if (a2.this.f3573b) {
                    a2.b(a2.this);
                    b2 a3 = new c2(a2.this.f3572a, a2.f3571q).a();
                    if (a3 != null) {
                        a2.this.f3573b = false;
                        if (a3.a()) {
                            a2.this.f();
                        }
                    }
                }
                this.f3589a.setVersion(a2.f3571q);
                this.f3589a.j();
            } catch (AMapException e) {
                e.printStackTrace();
            } catch (Throwable th2) {
                ka.a(th2, "OfflineDownloadManager", "startDownloadRunnable");
            }
        }
    }

    public interface d {
        void a(z1 z1Var);

        void b(z1 z1Var);

        void c(z1 z1Var);

        void onVerifyComplete();
    }

    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof z1) {
                    z1 z1Var = (z1) obj;
                    z1Var.getCity();
                    z1Var.getcompleteCode();
                    z1Var.getState();
                    if (a2.this.f3575d != null) {
                        a2.this.f3575d.a(z1Var);
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private a2(Context context) {
        this.f3572a = context;
    }

    public void b() {
        p2 b3 = p2.b(this.f3572a.getApplicationContext());
        this.f3576f = b3;
        try {
            k2 c9 = b3.c("000001");
            if (c9 != null) {
                this.f3576f.a("000001");
                c9.c("100000");
                this.f3576f.b(c9);
            }
        } catch (Throwable th2) {
            ka.a(th2, "OfflineDownloadManager", "changeBadCase");
        }
        this.f3580j = new e(this.f3572a.getMainLooper());
        this.f3581k = new e2(this.f3572a);
        this.e = j2.a(1);
        f3568n = v4.a(this.f3572a);
        try {
            e();
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        synchronized (this.f3574c) {
            try {
                ArrayList<OfflineMapProvince> b10 = this.f3581k.b();
                int size = b10.size();
                int i3 = 0;
                while (i3 < size) {
                    OfflineMapProvince offlineMapProvince = b10.get(i3);
                    i3++;
                    ArrayList<OfflineMapCity> cityList = offlineMapProvince.getCityList();
                    int size2 = cityList.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        OfflineMapCity offlineMapCity = cityList.get(i10);
                        i10++;
                        OfflineMapCity offlineMapCity2 = offlineMapCity;
                        if (offlineMapCity2 != null) {
                            this.f3574c.add(new z1(this.f3572a, offlineMapCity2));
                        }
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        d2 d2Var = new d2(this.f3572a);
        this.f3583m = d2Var;
        d2Var.start();
    }

    public void f() throws AMapException {
        if (this.f3581k == null) {
            return;
        }
        h2 h2Var = new h2(this.f3572a, "");
        h2Var.a(this.f3572a);
        List<OfflineMapProvince> a3 = h2Var.a();
        if (this.f3574c != null) {
            this.f3581k.a(a3);
        }
        List<z1> list = this.f3574c;
        if (list != null) {
            synchronized (list) {
                try {
                    ArrayList<OfflineMapProvince> b3 = this.f3581k.b();
                    int size = b3.size();
                    int i3 = 0;
                    while (i3 < size) {
                        OfflineMapProvince offlineMapProvince = b3.get(i3);
                        i3++;
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince.getCityList();
                        int size2 = cityList.size();
                        int i10 = 0;
                        while (i10 < size2) {
                            OfflineMapCity offlineMapCity = cityList.get(i10);
                            i10++;
                            OfflineMapCity offlineMapCity2 = offlineMapCity;
                            for (z1 z1Var : this.f3574c) {
                                if (offlineMapCity2.getPinyin().equals(z1Var.getPinyin())) {
                                    String version = z1Var.getVersion();
                                    if (z1Var.getState() == 4 && f3571q.length() > 0 && a(f3571q, version)) {
                                        z1Var.f5534v.equals(z1Var.f5529p);
                                        z1Var.f5534v.f();
                                        z1Var.setUrl(offlineMapCity2.getUrl());
                                        z1Var.o();
                                    } else {
                                        z1Var.setCity(offlineMapCity2.getCity());
                                        z1Var.setUrl(offlineMapCity2.getUrl());
                                        z1Var.o();
                                        z1Var.setAdcode(offlineMapCity2.getAdcode());
                                        z1Var.setVersion(offlineMapCity2.getVersion());
                                        z1Var.setSize(offlineMapCity2.getSize());
                                        z1Var.setCode(offlineMapCity2.getCode());
                                        z1Var.setJianpin(offlineMapCity2.getJianpin());
                                        z1Var.setPinyin(offlineMapCity2.getPinyin());
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void g() {
        ArrayList<k2> b3 = this.f3576f.b();
        int size = b3.size();
        int i3 = 0;
        while (i3 < size) {
            k2 k2Var = b3.get(i3);
            i3++;
            k2 k2Var2 = k2Var;
            if (k2Var2 != null && k2Var2.c() != null && k2Var2.a().length() >= 1) {
                int i10 = k2Var2.f4686l;
                if (i10 != 4 && i10 != 7 && i10 >= 0) {
                    k2Var2.f4686l = 3;
                }
                z1 c9 = c(k2Var2.c());
                if (c9 != null) {
                    String e10 = k2Var2.e();
                    if (e10 == null || !a(f3571q, e10)) {
                        c9.b(k2Var2.f4686l);
                        c9.setCompleteCode(k2Var2.b());
                    } else {
                        c9.b(7);
                    }
                    if (k2Var2.e().length() > 0) {
                        c9.setVersion(k2Var2.e());
                    }
                    List<String> b10 = this.f3576f.b(k2Var2.a());
                    StringBuffer stringBuffer = new StringBuffer();
                    ArrayList arrayList = (ArrayList) b10;
                    int size2 = arrayList.size();
                    int i11 = 0;
                    while (i11 < size2) {
                        Object obj = arrayList.get(i11);
                        i11++;
                        stringBuffer.append((String) obj);
                        stringBuffer.append(Const.STR_MART_SEMICOLON);
                    }
                    c9.b(stringBuffer.toString());
                    e2 e2Var = this.f3581k;
                    if (e2Var != null) {
                        e2Var.a(c9);
                    }
                }
            }
        }
        d dVar = this.f3575d;
        if (dVar != null) {
            try {
                dVar.onVerifyComplete();
            } catch (Throwable th2) {
                ka.a(th2, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(java.lang.String r5) throws com.amap.api.maps.AMapException {
        /*
            r4 = this;
            if (r5 == 0) goto L31
            int r0 = r5.length()
            r1 = 1
            if (r0 >= r1) goto La
            goto L31
        La:
            java.util.List<com.amap.api.col.3sl.z1> r0 = r4.f3574c
            monitor-enter(r0)
            java.util.List<com.amap.api.col.3sl.z1> r1 = r4.f3574c     // Catch: java.lang.Throwable -> L2b
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L2b
        L13:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L2b
            if (r2 == 0) goto L2d
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L2b
            com.amap.api.col.3sl.z1 r2 = (com.amap.api.col.p0003sl.z1) r2     // Catch: java.lang.Throwable -> L2b
            java.lang.String r3 = r2.getCode()     // Catch: java.lang.Throwable -> L2b
            boolean r3 = r5.equals(r3)     // Catch: java.lang.Throwable -> L2b
            if (r3 == 0) goto L13
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            goto L32
        L2b:
            r5 = move-exception
            goto L2f
        L2d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            goto L31
        L2f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            throw r5
        L31:
            r2 = 0
        L32:
            if (r2 == 0) goto L38
            r4.e(r2)
            return
        L38:
            com.amap.api.maps.AMapException r5 = new com.amap.api.maps.AMapException
            java.lang.String r0 = com.amap.api.maps.AMapException.ERROR_INVALID_PARAMETER
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.a2.h(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00fa, code lost:
    
        if (r3 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fc, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0100, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0101, code lost:
    
        r2.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00e3, code lost:
    
        if (r3 == null) goto L78;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x009f: MOVE (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:117:0x009f */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e() {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.a2.e():void");
    }

    public void c(z1 z1Var) {
        a(z1Var, false);
    }

    public boolean d(String str) {
        return c(str) != null;
    }

    public void c() {
        synchronized (this.f3574c) {
            try {
                for (z1 z1Var : this.f3574c) {
                    if (!z1Var.f5534v.equals(z1Var.f5526m) && !z1Var.f5534v.equals(z1Var.f5525l)) {
                    }
                    j2 j2Var = this.e;
                    if (j2Var != null) {
                        j2Var.b(z1Var);
                    }
                    z1Var.f5534v.g();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void d(z1 z1Var) {
        try {
            j2 j2Var = this.e;
            if (j2Var != null) {
                j2Var.a(z1Var, this.f3572a, null);
            }
        } catch (a9 e10) {
            e10.printStackTrace();
        }
    }

    public static a2 a(Context context) {
        if (f3570p == null) {
            synchronized (a2.class) {
                try {
                    if (f3570p == null && !f3569o) {
                        f3570p = new a2(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f3570p;
    }

    public void d() {
        synchronized (this.f3574c) {
            try {
                Iterator<z1> it = this.f3574c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    z1 next = it.next();
                    if (next.f5534v.equals(next.f5526m)) {
                        next.f5534v.g();
                        break;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(String str) {
        try {
            if (str == null) {
                d dVar = this.f3575d;
                if (dVar != null) {
                    dVar.b(null);
                    return;
                }
                return;
            }
            if (this.f3577g == null) {
                this.f3577g = x.b("AMapOfflineCheckUpdate");
            }
            this.f3577g.b(new a(str));
        } catch (Throwable th2) {
            ka.a(th2, "OfflineDownloadManager", "checkUpdate");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z1 c(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        synchronized (this.f3574c) {
            try {
                for (z1 z1Var : this.f3574c) {
                    if (!str.equals(z1Var.getCity()) && !str.equals(z1Var.getPinyin())) {
                    }
                    return z1Var;
                }
                return null;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        for (int i3 = 0; i3 < str2.length(); i3++) {
            try {
                if (str.charAt(i3) > str2.charAt(i3)) {
                    return true;
                }
                if (str.charAt(i3) < str2.charAt(i3)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void a(z1 z1Var, boolean z5) {
        if (this.f3582l == null) {
            this.f3582l = new g2(this.f3572a);
        }
        if (this.f3578h == null) {
            this.f3578h = x.b("AMapOfflineRemove");
        }
        try {
            this.f3578h.b(new b(z1Var, z5));
        } catch (Throwable th2) {
            ka.a(th2, "requestDelete", "removeExcecRunnable");
        }
    }

    public static void b(a2 a2Var) throws AMapException {
        if (!v4.d(a2Var.f3572a)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    public void g(String str) throws AMapException {
        z1 c9 = c(str);
        if (str != null && str.length() >= 1 && c9 != null) {
            e(c9);
            return;
        }
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
    }

    public void a() {
        qc qcVar = this.f3577g;
        if (qcVar != null) {
            qcVar.a();
        }
        qc qcVar2 = this.f3579i;
        if (qcVar2 != null) {
            qcVar2.a();
            this.f3579i = null;
        }
        d2 d2Var = this.f3583m;
        if (d2Var != null) {
            if (d2Var.isAlive()) {
                this.f3583m.interrupt();
            }
            this.f3583m = null;
        }
        e eVar = this.f3580j;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
            this.f3580j = null;
        }
        j2 j2Var = this.e;
        if (j2Var != null) {
            j2Var.a();
            this.e = null;
        }
        e2 e2Var = this.f3581k;
        if (e2Var != null) {
            e2Var.a();
        }
        f3570p = null;
        f3569o = true;
        this.f3573b = true;
        synchronized (this) {
            this.f3575d = null;
        }
    }

    public void b(z1 z1Var) {
        j2 j2Var = this.e;
        if (j2Var != null) {
            j2Var.b(z1Var);
        }
    }

    public String b(String str) {
        z1 c9 = c(str);
        return c9 == null ? "" : c9.getAdcode();
    }

    public void f(String str) {
        z1 c9 = c(str);
        if (c9 == null) {
            d dVar = this.f3575d;
            if (dVar != null) {
                try {
                    dVar.c(c9);
                    return;
                } catch (Throwable th2) {
                    ka.a(th2, "OfflineDownloadManager", "remove");
                    return;
                }
            }
            return;
        }
        j2 j2Var = this.e;
        if (j2Var != null) {
            j2Var.b(c9);
        }
        a(c9, true);
    }

    public void a(z1 z1Var) {
        j2 j2Var = this.e;
        if (j2Var != null) {
            j2Var.a(z1Var);
        }
    }

    public void a(d dVar) {
        this.f3575d = dVar;
    }

    private void e(z1 z1Var) throws AMapException {
        if (!v4.d(this.f3572a)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
        if (z1Var != null) {
            if (this.f3579i == null) {
                this.f3579i = x.b("AMapOfflineDownload");
            }
            try {
                this.f3579i.b(new c(z1Var));
                return;
            } catch (Throwable th2) {
                ka.a(th2, "startDownload", "downloadExcecRunnable");
                return;
            }
        }
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
    }

    public void e(String str) {
        z1 c9 = c(str);
        if (c9 != null) {
            c9.j();
        }
    }
}
