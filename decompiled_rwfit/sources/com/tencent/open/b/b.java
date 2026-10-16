package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f11968a;

    /* renamed from: b, reason: collision with root package name */
    private String f11969b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f11970c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f11971d = "";
    private String e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f11972f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f11973g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f11974h = "";

    /* renamed from: i, reason: collision with root package name */
    private List<Serializable> f11975i = Collections.synchronizedList(new ArrayList());

    /* renamed from: j, reason: collision with root package name */
    private List<Serializable> f11976j = Collections.synchronizedList(new ArrayList());

    /* renamed from: k, reason: collision with root package name */
    private Executor f11977k = l.b();

    /* renamed from: l, reason: collision with root package name */
    private boolean f11978l;

    private b() {
    }

    private void c() {
        while (!this.f11976j.isEmpty()) {
            c cVar = (c) this.f11976j.remove(0);
            cVar.f11981a.put("appid", this.f11969b);
            cVar.f11981a.put("app_name", this.f11970c);
            cVar.f11981a.put(Constants.PARAM_APP_VER, this.e);
            cVar.f11981a.put(Constants.PARAM_PKG_NAME, this.f11972f);
            cVar.f11981a.put("qq_install", this.f11973g);
            cVar.f11981a.put(Constants.PARAM_QQ_VER, this.f11974h);
            cVar.f11981a.put("openid", this.f11971d);
            cVar.f11981a.put("time_appid_openid", cVar.f11981a.get(Const.JSON_KEY_TIME) + "_" + this.f11969b + "_" + this.f11971d);
            StringBuilder sb2 = new StringBuilder("fixDirtyData--------------------------");
            sb2.append(cVar);
            SLog.i("AttaReporter", sb2.toString());
            this.f11975i.add(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (!this.f11978l) {
            List<Serializable> b3 = g.b("report_atta");
            this.f11978l = b3.isEmpty();
            this.f11975i.addAll(b3);
            Iterator<Serializable> it = b3.iterator();
            while (it.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread from db = " + it.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.f11975i.isEmpty()) {
            c cVar = (c) this.f11975i.remove(0);
            if (!b(cVar)) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            if (this.f11978l) {
                return;
            }
            SLog.i("AttaReporter", "attaReportAtSubThread clear db");
            g.a("report_atta");
            this.f11978l = true;
            return;
        }
        SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((c) ((Serializable) obj)));
        }
        g.a("report_atta", arrayList);
        this.f11978l = false;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f11968a == null) {
                    f11968a = new b();
                }
                bVar = f11968a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    private c b(String str, String str2, Object obj, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "09400051119");
        hashMap.put("token", "9389887874");
        hashMap.put("time_appid_openid", currentTimeMillis + "_" + this.f11969b + "_" + this.f11971d);
        hashMap.put(Const.JSON_KEY_TIME, String.valueOf(currentTimeMillis));
        hashMap.put("openid", this.f11971d);
        hashMap.put("appid", this.f11969b);
        hashMap.put("app_name", this.f11970c);
        hashMap.put(Constants.PARAM_APP_VER, this.e);
        hashMap.put(Constants.PARAM_PKG_NAME, this.f11972f);
        hashMap.put("os", "AND");
        hashMap.put("os_ver", Build.VERSION.RELEASE);
        hashMap.put(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
        hashMap.put(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
        hashMap.put("interface_name", str);
        hashMap.put("interface_data", str2);
        hashMap.put("interface_result", obj == null ? "" : obj.toString());
        hashMap.put("qq_install", this.f11973g);
        hashMap.put(Constants.PARAM_QQ_VER, this.f11974h);
        if (map != null && !map.isEmpty()) {
            Object obj2 = map.get("reserve1");
            hashMap.put("reserve1", obj2 == null ? "" : obj2.toString());
            Object obj3 = map.get("reserve2");
            hashMap.put("reserve2", obj3 == null ? "" : obj3.toString());
            Object obj4 = map.get("reserve3");
            hashMap.put("reserve3", obj4 == null ? "" : obj4.toString());
            Object obj5 = map.get("reserve4");
            hashMap.put("reserve4", obj5 != null ? obj5.toString() : "");
        }
        return new c((HashMap<String, String>) hashMap);
    }

    public void a(String str, Context context) {
        SLog.i("AttaReporter", "init");
        this.f11969b = str;
        this.f11970c = k.a(context);
        this.e = m.d(context, com.tencent.open.utils.g.b());
        this.f11972f = com.tencent.open.utils.g.b();
        this.f11973g = k.b(context) ? "1" : "0";
        this.f11974h = m.c(context, "com.tencent.mobileqq");
        c();
        g.a();
    }

    public void a(String str) {
        SLog.i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.f11971d = str;
    }

    public void a(String str, String str2) {
        a(str, str2, null);
    }

    public void a(String str, String str2, Map<String, Object> map) {
        a(str, str2, "", map);
    }

    public void a(String str, Object obj) {
        a(str, "", obj, null);
    }

    public void a(String str, String str2, Object obj, Map<String, Object> map) {
        c b3 = b(str, str2, obj, map);
        if (!TextUtils.isEmpty(this.f11969b) && !TextUtils.isEmpty(this.f11970c) && com.tencent.open.utils.g.a() != null) {
            a(b3);
            return;
        }
        SLog.i("AttaReporter", "attaReport cancel appid=" + this.f11969b + ", mAppName=" + this.f11970c + ", context=" + com.tencent.open.utils.g.a() + ", " + b3);
        this.f11976j.add(b3);
    }

    private void a(final c cVar) {
        this.f11977k.execute(new Runnable() { // from class: com.tencent.open.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f11975i.add(cVar);
                if (!m.b(com.tencent.open.utils.g.a())) {
                    SLog.i("AttaReporter", "attaReport net disconnect, " + cVar);
                } else {
                    try {
                        b.this.d();
                    } catch (Exception e) {
                        SLog.e("AttaReporter", "Exception", e);
                    }
                }
            }
        });
    }

    private boolean b(c cVar) {
        int i3 = 0;
        do {
            i3++;
            try {
                SLog.i("AttaReporter", "doAttaReportItem post " + cVar);
                return com.tencent.open.a.f.a().b("https://h.trace.qq.com/kv", cVar.f11981a).d() == 200;
            } catch (Exception e) {
                SLog.i("AttaReporter", "Exception", e);
            }
        } while (i3 < 2);
        return false;
    }

    public static String b() {
        return a().f11969b;
    }
}
