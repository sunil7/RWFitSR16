package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.c9;
import com.amap.api.col.p0003sl.l7;
import com.amap.api.services.core.AMapException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class v6 {

    /* renamed from: c, reason: collision with root package name */
    private static v6 f5190c;

    /* renamed from: d, reason: collision with root package name */
    private static Context f5191d;

    /* renamed from: a, reason: collision with root package name */
    private b f5192a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f5193b = new a("manifestThread");

    public class a extends HandlerThread {

        /* renamed from: com.amap.api.col.3sl.v6$a$a, reason: collision with other inner class name */
        public class C0007a implements c9.b {
            public C0007a() {
            }

            @Override // com.amap.api.col.3sl.c9.b
            public void onReceiveAuthConfig(c9.c cVar) {
                JSONObject optJSONObject;
                JSONObject optJSONObject2;
                Message message = new Message();
                try {
                    c9.c.a aVar = cVar.f3848d;
                    if (aVar != null) {
                        message.obj = new w6(false, aVar.f3849a);
                    }
                    JSONObject jSONObject = cVar.f3847c;
                    if (jSONObject != null && (optJSONObject2 = jSONObject.optJSONObject("184")) != null) {
                        v6.this.a(optJSONObject2);
                        x.c(v6.f5191d, "amap_search", "cache_control", optJSONObject2.toString());
                    }
                    JSONObject jSONObject2 = cVar.f3847c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("185")) != null) {
                        v6.this.b(optJSONObject);
                        x.c(v6.f5191d, "amap_search", "parm_control", optJSONObject.toString());
                    }
                    message.what = 3;
                    if (v6.this.f5192a == null) {
                    }
                } catch (Throwable th2) {
                    try {
                        d6.a(th2, "ManifestConfig", "run");
                    } finally {
                        message.what = 3;
                        if (v6.this.f5192a != null) {
                            v6.this.f5192a.sendMessage(message);
                        }
                    }
                }
            }
        }

        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            m9 a3 = m6.a(false);
            v6.a(v6.this, v6.f5191d);
            c9.a(v6.f5191d, a3, "11K;001;184;185", new C0007a());
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        String f5196a;

        public b(v6 v6Var, Looper looper) {
            super(looper);
            this.f5196a = "handleMessage";
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    w6 w6Var = (w6) message.obj;
                    if (w6Var == null) {
                        w6Var = new w6(false, false);
                    }
                    ka.a(v6.f5191d, m6.a(w6Var.a()));
                    m6.a(w6Var.a());
                } catch (Throwable th2) {
                    d6.a(th2, "ManifestConfig", this.f5196a);
                }
            }
        }
    }

    private v6(Context context) {
        f5191d = context;
        m6.a(false);
        try {
            b();
            this.f5192a = new b(this, Looper.getMainLooper());
            this.f5193b.start();
        } catch (Throwable th2) {
            d6.a(th2, "ManifestConfig", "ManifestConfig");
        }
    }

    public static void a(v6 v6Var, Context context) {
        v6Var.getClass();
        try {
            String str = (String) x.a(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                v6Var.a(new JSONObject(str));
            }
            String str2 = (String) x.a(context, "amap_search", "parm_control", "");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            v6Var.b(new JSONObject(str2));
        } catch (Throwable th2) {
            d6.a(th2, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    private void b() {
        k7.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean a3 = c9.a(jSONObject.optString("passAreaAble"), true);
                boolean a10 = c9.a(jSONObject.optString("truckAble"), true);
                boolean a11 = c9.a(jSONObject.optString("poiPageAble"), true);
                boolean a12 = c9.a(jSONObject.optString("rideAble"), true);
                boolean a13 = c9.a(jSONObject.optString("walkAble"), true);
                boolean a14 = c9.a(jSONObject.optString("passPointAble"), true);
                boolean a15 = c9.a(jSONObject.optString("keyWordLenAble"), true);
                int optInt = jSONObject.optInt("poiPageMaxSize", 25);
                int optInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int optInt3 = jSONObject.optInt("walkMaxLength", 100);
                int optInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int optInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int optInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int optInt7 = jSONObject.optInt("rideMaxLength", AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
                int optInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int optInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int optInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                o7.a().f4745a = a3;
                o7.a().f4753j = optInt2;
                o7.a().f4759p = optInt8;
                o7.a().f4760q = optInt9;
                o7.a().f4747c = a10;
                o7.a().f4757n = optInt6;
                o7.a().f4748d = a11;
                o7.a().f4756m = optInt5;
                o7.a().f4751h = optInt;
                o7.a().f4752i = optInt10;
                o7.a().f4746b = a15;
                o7.a().e = a12;
                o7.a().f4758o = optInt7;
                o7.a().f4749f = a13;
                o7.a().f4754k = optInt3;
                o7.a().f4750g = a14;
                o7.a().f4755l = optInt4;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static v6 a(Context context) {
        if (f5190c == null) {
            f5190c = new v6(context);
        }
        return f5190c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    l7.a a3 = a(jSONObject, true, (l7.a) null);
                    l7.a().a(a3);
                    if (a3.d()) {
                        a("regeo", jSONObject, a3);
                        a("geo", jSONObject, a3);
                        a("placeText", jSONObject, a3);
                        a("placeAround", jSONObject, a3);
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void a(String str, JSONObject jSONObject, l7.a aVar) {
        if (jSONObject.has(str)) {
            l7.a().a(str, a(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    private l7.a a(JSONObject jSONObject, boolean z5, l7.a aVar) {
        l7.a aVar2;
        boolean z6;
        boolean optBoolean;
        l7.a aVar3 = null;
        if (jSONObject != null) {
            try {
                aVar2 = new l7.a();
                z6 = true;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                if (z5) {
                    String optString = jSONObject.optString("able");
                    if (aVar != null && !aVar.d()) {
                        z6 = false;
                    }
                    optBoolean = c9.a(optString, z6);
                } else {
                    if (aVar != null && !aVar.d()) {
                        z6 = false;
                    }
                    optBoolean = jSONObject.optBoolean("able", z6);
                }
                int optInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.c() : 86400);
                int optInt2 = jSONObject.optInt("num", aVar != null ? aVar.b() : 10);
                double optDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.a() : 0.0d);
                aVar2.a(optBoolean);
                aVar2.a(optInt);
                aVar2.a(optInt2);
                aVar2.a(optDouble);
                return aVar2;
            } catch (Throwable th3) {
                th = th3;
                aVar3 = aVar2;
                th.printStackTrace();
                return aVar3;
            }
        }
        return aVar3;
    }
}
