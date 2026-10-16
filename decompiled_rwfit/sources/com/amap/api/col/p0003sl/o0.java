package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o0 {

    /* renamed from: a, reason: collision with root package name */
    private Context f4717a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<IAMapDelegate> f4718b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f4719c;

    /* renamed from: d, reason: collision with root package name */
    private c f4720d;
    private final Runnable e = new a();

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f4721f = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o0.this.f4720d == null) {
                o0 o0Var = o0.this;
                o0Var.f4720d = new c(o0Var.f4717a, o0.this);
            }
            u4.b().a(o0.this.f4720d);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IAMapDelegate iAMapDelegate = (IAMapDelegate) o0.this.f4718b.get();
            if (iAMapDelegate != null) {
                iAMapDelegate.setLanguageAuth(false);
            }
            c4.a(o0.this.f4717a, "多语言鉴权失败，当前key没有多语言的使用权限，多语言，将不会呈现！");
        }
    }

    public static class c extends rc {

        /* renamed from: a, reason: collision with root package name */
        private Context f4724a;

        /* renamed from: b, reason: collision with root package name */
        private o0 f4725b;

        /* renamed from: c, reason: collision with root package name */
        private d f4726c;

        public c(Context context, o0 o0Var) {
            this.f4724a = context;
            this.f4725b = o0Var;
            this.f4726c = new d(context, "");
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            try {
                e c9 = this.f4726c.c();
                if (c9 == null) {
                    this.f4725b.a(30000L);
                } else if (c9.f4727a) {
                    f9.a(false);
                } else {
                    o0.d(this.f4725b);
                }
            } catch (s8 e) {
                e.printStackTrace();
                this.f4725b.a(30000L);
            }
        }
    }

    public static class d extends t8<String, e> {
        private boolean r;

        public d(Context context, String str) {
            super(context, str);
            this.f5096p = "/rest/feedback/languageCode";
            this.isPostFlag = false;
            this.r = true;
        }

        @Override // com.amap.api.col.p0003sl.t8
        public e a(byte[] bArr) throws s8 {
            String str;
            try {
                str = new String(bArr, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            if (str == null || "".equals(str)) {
                return null;
            }
            return b(str);
        }

        @Override // com.amap.api.col.p0003sl.t8
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public e b(String str) throws s8 {
            a aVar = null;
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.optString("info");
                String optString = jSONObject.optString("infocode");
                jSONObject.optString(FileDownloadModel.STATUS);
                e eVar = new e(aVar);
                eVar.f4727a = !TextUtils.isEmpty(optString) && TextUtils.equals(optString, "10000");
                return eVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getIPV6URL() {
            return v4.a(getURL(), this.f5095o);
        }

        @Override // com.amap.api.col.p0003sl.b4, com.amap.api.col.p0003sl.pb
        public Map<String, String> getParams() {
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("key", b9.e(this.f5095o));
            if (this.r) {
                hashtable.put("pname", "3dmap");
            }
            String c9 = e9.c();
            String a3 = e9.a(this.f5095o, c9, n9.a(hashtable));
            hashtable.put(Constants.TS, c9);
            hashtable.put("scode", a3);
            return hashtable;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getURL() {
            StringBuilder t8 = l0.t("http://" + g9.b(this.f5095o).a(41));
            t8.append(this.f5096p);
            return t8.toString();
        }

        @Override // com.amap.api.col.p0003sl.pb
        public boolean isSupportIPV6() {
            return true;
        }
    }

    public o0(Context context, IAMapDelegate iAMapDelegate) {
        this.f4717a = context.getApplicationContext();
        this.f4718b = new WeakReference<>(iAMapDelegate);
        a();
    }

    public static void d(o0 o0Var) {
        Handler handler = o0Var.f4719c;
        if (handler != null) {
            handler.postDelayed(o0Var.f4721f, 1000L);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4727a;

        private e() {
            this.f4727a = false;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    private void a() {
        if (this.f4719c == null) {
            this.f4719c = new Handler(Looper.getMainLooper());
        }
    }

    public void a(long j4) {
        Handler handler = this.f4719c;
        if (handler != null) {
            handler.postDelayed(this.e, j4);
        }
    }
}
