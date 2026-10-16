package com.tencent.open.a;

import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static f f11956a;

    /* renamed from: b, reason: collision with root package name */
    private i f11957b;

    /* renamed from: c, reason: collision with root package name */
    private a f11958c;

    public f() {
        b();
    }

    public static f a() {
        if (f11956a == null) {
            synchronized (f.class) {
                try {
                    if (f11956a == null) {
                        f11956a = new f();
                    }
                } finally {
                }
            }
        }
        f11956a.c();
        return f11956a;
    }

    private void b() {
        String str = "AndroidSDK_" + Build.VERSION.SDK + "_" + com.tencent.open.utils.f.a().b(com.tencent.open.utils.g.a()) + "_" + Build.VERSION.RELEASE;
        try {
            this.f11958c = new e(str);
        } catch (NoClassDefFoundError e) {
            SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch error", e);
        } catch (Throwable th2) {
            SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch throwable", th2);
        }
        if (this.f11958c == null) {
            this.f11958c = new b(str);
        }
    }

    private void c() {
        i iVar = this.f11957b;
        if (iVar == null) {
            return;
        }
        int a3 = iVar.a("Common_HttpConnectionTimeout");
        if (a3 == 0) {
            a3 = 15000;
        }
        int a10 = this.f11957b.a("Common_SocketConnectionTimeout");
        if (a10 == 0) {
            a10 = Const.I_LOC_JUMP_DELAY;
        }
        a(a3, a10);
    }

    public void a(i iVar) {
        this.f11957b = iVar;
        c();
    }

    public g b(String str, Map<String, String> map) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "post data");
        return this.f11958c.a(str, map);
    }

    public void a(long j4, long j10) {
        a aVar = this.f11958c;
        if (aVar != null) {
            aVar.a(j4, j10);
        }
    }

    public g a(String str, Map<String, String> map) throws IOException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb2 = new StringBuilder("");
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    sb2.append(URLEncoder.encode(str2, "UTF-8"));
                    sb2.append("=");
                    sb2.append(URLEncoder.encode(str3, "UTF-8"));
                    sb2.append(Const.STR_MART_ADD);
                }
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return a(str, sb2.toString());
        }
        return a(str, "");
    }

    public g a(String str, String str2) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "get.");
        return this.f11958c.a(str, str2);
    }

    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            return this.f11958c.a(str, map, map2);
        }
        return b(str, map);
    }
}
