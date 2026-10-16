package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.a3;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.kb;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

/* loaded from: classes.dex */
public class t2 implements kb.a {

    /* renamed from: a, reason: collision with root package name */
    u2 f5062a;

    /* renamed from: d, reason: collision with root package name */
    long f5065d;

    /* renamed from: f, reason: collision with root package name */
    private Context f5066f;

    /* renamed from: g, reason: collision with root package name */
    p2 f5067g;

    /* renamed from: h, reason: collision with root package name */
    private a3 f5068h;

    /* renamed from: i, reason: collision with root package name */
    private String f5069i;

    /* renamed from: j, reason: collision with root package name */
    private rb f5070j;

    /* renamed from: k, reason: collision with root package name */
    private q2 f5071k;

    /* renamed from: n, reason: collision with root package name */
    a f5074n;

    /* renamed from: b, reason: collision with root package name */
    long f5063b = 0;

    /* renamed from: c, reason: collision with root package name */
    long f5064c = 0;
    boolean e = true;

    /* renamed from: l, reason: collision with root package name */
    long f5072l = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5073m = false;

    public interface a {
    }

    public static class b extends b4 {

        /* renamed from: m, reason: collision with root package name */
        private final String f5075m;

        public b(String str) {
            this.f5075m = str;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getIPV6URL() {
            return this.f5075m;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getURL() {
            return this.f5075m;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public boolean isSupportIPV6() {
            return false;
        }
    }

    public t2(u2 u2Var, String str, Context context, a3 a3Var) throws IOException {
        this.f5062a = null;
        this.f5067g = p2.b(context.getApplicationContext());
        this.f5062a = u2Var;
        this.f5066f = context;
        this.f5069i = str;
        this.f5068h = a3Var;
        b();
    }

    private void a() {
        a3 a3Var;
        long currentTimeMillis = System.currentTimeMillis();
        u2 u2Var = this.f5062a;
        if (u2Var == null || currentTimeMillis - this.f5072l <= 500) {
            return;
        }
        this.f5067g.a(u2Var.a(), this.f5062a.b(), this.f5065d, this.f5063b, this.f5064c);
        this.f5072l = currentTimeMillis;
        long j4 = this.f5063b;
        long j10 = this.f5065d;
        if (j10 <= 0 || (a3Var = this.f5068h) == null) {
            return;
        }
        a3Var.a(j10, j4);
        this.f5072l = System.currentTimeMillis();
    }

    private void b() {
        File file = new File(this.f5062a.d() + this.f5062a.c());
        if (!file.exists()) {
            this.f5063b = 0L;
            this.f5064c = 0L;
            return;
        }
        this.e = false;
        this.f5063b = file.length();
        try {
            long d5 = d();
            this.f5065d = d5;
            this.f5064c = d5;
        } catch (IOException unused) {
            a3 a3Var = this.f5068h;
            if (a3Var != null) {
                a3Var.a(a3.a.file_io_exception);
            }
        }
    }

    private boolean c() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f5062a.d());
        sb2.append(File.separator);
        sb2.append(this.f5062a.c());
        return new File(sb2.toString()).length() >= 10;
    }

    private long d() throws IOException {
        Map<String, String> map;
        int i3 = -1;
        if (k9.a(this.f5066f, v4.b()).f4490a != k9.e.SuccessCode) {
            return -1;
        }
        try {
            map = ob.b().d(new b(this.f5062a.e()), MapsInitializer.getProtocol() == 2);
        } catch (a9 e) {
            e.printStackTrace();
            map = null;
        }
        if (map != null) {
            for (String str : map.keySet()) {
                if ("Content-Length".equalsIgnoreCase(str)) {
                    i3 = Integer.parseInt(map.get(str));
                }
            }
        }
        return i3;
    }

    private void e() throws IOException {
        b3 b3Var = new b3(this.f5069i);
        b3Var.setConnectionTimeout(Const.I_LOC_JUMP_DELAY);
        b3Var.setSoTimeout(Const.I_LOC_JUMP_DELAY);
        this.f5070j = new rb(b3Var, this.f5063b, this.f5064c, MapsInitializer.getProtocol() == 2);
        this.f5071k = new q2(this.f5062a.d() + File.separator + this.f5062a.c(), this.f5063b);
    }

    public void f() {
        rb rbVar = this.f5070j;
        if (rbVar != null) {
            rbVar.a();
        }
    }

    public void g() {
        try {
            if (!v4.d(this.f5066f)) {
                a3 a3Var = this.f5068h;
                if (a3Var != null) {
                    a3Var.a(a3.a.network_exception);
                    return;
                }
                return;
            }
            if (c9.f3817a != 1) {
                for (int i3 = 0; i3 < 3; i3++) {
                    try {
                        c9.a(this.f5066f, v4.b(), "", (Map<String, String>) null);
                    } catch (Throwable th2) {
                        ka.a(th2, "SiteFileFetch", "authOffLineDownLoad");
                        th2.printStackTrace();
                    }
                    if (c9.f3817a == 1) {
                        break;
                    }
                }
            }
            if (c9.f3817a != 1) {
                a3 a3Var2 = this.f5068h;
                if (a3Var2 != null) {
                    a3Var2.a(a3.a.amap_exception);
                    return;
                }
                return;
            }
            if (!c()) {
                this.e = true;
            }
            if (this.e) {
                long d5 = d();
                this.f5065d = d5;
                if (d5 != -1 && d5 != -2) {
                    this.f5064c = d5;
                }
                this.f5063b = 0L;
            }
            a3 a3Var3 = this.f5068h;
            if (a3Var3 != null) {
                a3Var3.g();
            }
            if (this.f5063b >= this.f5064c) {
                onFinish();
            } else {
                e();
                this.f5070j.a(this);
            }
        } catch (AMapException e) {
            ka.a(e, "SiteFileFetch", "download");
            a3 a3Var4 = this.f5068h;
            if (a3Var4 != null) {
                a3Var4.a(a3.a.amap_exception);
            }
        } catch (IOException unused) {
            a3 a3Var5 = this.f5068h;
            if (a3Var5 != null) {
                a3Var5.a(a3.a.file_io_exception);
            }
        }
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onDownload(byte[] bArr, long j4) {
        try {
            q2 q2Var = this.f5071k;
            synchronized (q2Var) {
                q2Var.f4889a.write(bArr);
            }
            this.f5063b = j4;
            a();
        } catch (IOException e) {
            e.printStackTrace();
            ka.a(e, "fileAccessI", "fileAccessI.write(byte[] data)");
            a3 a3Var = this.f5068h;
            if (a3Var != null) {
                a3Var.a(a3.a.file_io_exception);
            }
            rb rbVar = this.f5070j;
            if (rbVar != null) {
                rbVar.a();
            }
        }
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onException(Throwable th2) {
        q2 q2Var;
        RandomAccessFile randomAccessFile;
        this.f5073m = true;
        rb rbVar = this.f5070j;
        if (rbVar != null) {
            rbVar.a();
        }
        a3 a3Var = this.f5068h;
        if (a3Var != null) {
            a3Var.a(a3.a.network_exception);
        }
        if ((th2 instanceof IOException) || (q2Var = this.f5071k) == null || (randomAccessFile = q2Var.f4889a) == null) {
            return;
        }
        try {
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        q2Var.f4889a = null;
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onFinish() {
        RandomAccessFile randomAccessFile;
        a();
        a3 a3Var = this.f5068h;
        if (a3Var != null) {
            a3Var.onFinish();
        }
        q2 q2Var = this.f5071k;
        if (q2Var != null && (randomAccessFile = q2Var.f4889a) != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            q2Var.f4889a = null;
        }
        a aVar = this.f5074n;
        if (aVar != null) {
            ((f2) aVar).c();
        }
    }

    @Override // com.amap.api.col.3sl.kb.a
    public void onStop() {
        if (this.f5073m) {
            return;
        }
        a3 a3Var = this.f5068h;
        if (a3Var != null) {
            a3Var.onCancel();
        }
        this.f5067g.a(this.f5062a.a(), this.f5062a.b(), this.f5065d, this.f5063b, this.f5064c);
    }

    public void a(a aVar) {
        this.f5074n = aVar;
    }
}
