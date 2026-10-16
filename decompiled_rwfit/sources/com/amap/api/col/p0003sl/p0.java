package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.map3d.R;
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
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private Context f4782a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<IAMapDelegate> f4783b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f4784c;

    /* renamed from: d, reason: collision with root package name */
    private d f4785d;
    private int e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f4786f = new a();

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f4787g = new b();

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f4788h = new c();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p0.this.f4785d == null) {
                p0 p0Var = p0.this;
                p0Var.f4785d = new d(p0Var.f4782a, p0.this);
            }
            u4.b().a(p0.this.f4785d);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IAMapDelegate iAMapDelegate = (IAMapDelegate) p0.this.f4783b.get();
            if (iAMapDelegate != null) {
                iAMapDelegate.setOverseaAuth(true);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IAMapDelegate iAMapDelegate = (IAMapDelegate) p0.this.f4783b.get();
            if (iAMapDelegate != null) {
                try {
                    iAMapDelegate.removecache();
                    iAMapDelegate.setOverseaAuth(false);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
            c4.a(p0.this.f4782a, n1.a(R.string.O105492_165));
        }
    }

    public static class d extends rc {

        /* renamed from: a, reason: collision with root package name */
        private Context f4792a;

        /* renamed from: b, reason: collision with root package name */
        private p0 f4793b;

        /* renamed from: c, reason: collision with root package name */
        private e f4794c;

        public d(Context context, p0 p0Var) {
            this.f4792a = context;
            this.f4793b = p0Var;
            this.f4794c = new e(context, "");
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            try {
                f c9 = this.f4794c.c();
                if (c9 == null) {
                    this.f4793b.a(30000L);
                    return;
                }
                this.f4793b.e = 2;
                if (c9.f4795a) {
                    p0.e(this.f4793b);
                } else {
                    p0.d(this.f4793b);
                }
            } catch (s8 e) {
                e.printStackTrace();
                this.f4793b.a(30000L);
            }
        }
    }

    public static class e extends t8<String, f> {
        private boolean r;

        public e(Context context, String str) {
            super(context, str);
            this.f5096p = "/rest/feedback/3dmap-abroad";
            this.isPostFlag = false;
            this.r = true;
        }

        @Override // com.amap.api.col.p0003sl.t8
        public f a(byte[] bArr) throws s8 {
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
        public f b(String str) throws s8 {
            a aVar = null;
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.optString("info");
                String optString = jSONObject.optString("infocode");
                jSONObject.optString(FileDownloadModel.STATUS);
                f fVar = new f(aVar);
                fVar.f4795a = !TextUtils.isEmpty(optString) && TextUtils.equals(optString, "10000");
                return fVar;
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

    public p0(Context context, IAMapDelegate iAMapDelegate) {
        this.f4782a = context.getApplicationContext();
        this.f4783b = new WeakReference<>(iAMapDelegate);
        c();
    }

    public static void d(p0 p0Var) {
        Handler handler = p0Var.f4784c;
        if (handler != null) {
            handler.post(p0Var.f4788h);
        }
    }

    public static void e(p0 p0Var) {
        Handler handler = p0Var.f4784c;
        if (handler != null) {
            handler.post(p0Var.f4787g);
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4795a;

        private f() {
            this.f4795a = false;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    private void c() {
        if (this.f4784c == null) {
            this.f4784c = new Handler(Looper.getMainLooper());
        }
    }

    public int b() {
        return this.e;
    }

    public void a(long j4) {
        Handler handler = this.f4784c;
        if (handler != null) {
            this.e = 1;
            handler.postDelayed(this.f4786f, j4);
        }
    }

    public void a() {
        Handler handler = this.f4784c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f4784c = null;
        }
    }
}
