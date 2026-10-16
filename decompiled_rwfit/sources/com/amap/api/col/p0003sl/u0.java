package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
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
public class u0 {

    /* renamed from: a, reason: collision with root package name */
    private Context f5107a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<IAMapDelegate> f5108b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f5109c;

    /* renamed from: d, reason: collision with root package name */
    private c f5110d;
    private final Runnable e = new a();

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f5111f = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u0.this.f5110d == null) {
                u0 u0Var = u0.this;
                u0Var.f5110d = new c(u0Var.f5107a, u0.this);
            }
            u4.b().a(u0.this.f5110d);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IAMapDelegate iAMapDelegate = (IAMapDelegate) u0.this.f5108b.get();
            if (iAMapDelegate != null) {
                iAMapDelegate.setTerrainAuth(false);
            }
            c4.a(u0.this.f5107a, n1.a(R.string.O105492_285));
        }
    }

    public static class c extends rc {

        /* renamed from: a, reason: collision with root package name */
        private Context f5114a;

        /* renamed from: b, reason: collision with root package name */
        private u0 f5115b;

        /* renamed from: c, reason: collision with root package name */
        private d f5116c;

        public c(Context context, u0 u0Var) {
            this.f5114a = context;
            this.f5115b = u0Var;
            this.f5116c = new d(context, "");
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            try {
                e c9 = this.f5116c.c();
                if (c9 == null) {
                    this.f5115b.a(30000L);
                } else {
                    if (c9.f5117a) {
                        return;
                    }
                    u0.d(this.f5115b);
                }
            } catch (s8 e) {
                e.printStackTrace();
                this.f5115b.a(30000L);
            }
        }
    }

    public static class d extends t8<String, e> {
        private boolean r;

        public d(Context context, String str) {
            super(context, str);
            this.f5096p = "/rest/feedback/terrain";
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
                eVar.f5117a = !TextUtils.isEmpty(optString) && TextUtils.equals(optString, "10000");
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

    public u0(Context context, IAMapDelegate iAMapDelegate) {
        this.f5107a = context.getApplicationContext();
        this.f5108b = new WeakReference<>(iAMapDelegate);
        b();
    }

    public static void d(u0 u0Var) {
        Handler handler = u0Var.f5109c;
        if (handler != null) {
            handler.postDelayed(u0Var.f5111f, 1000L);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public boolean f5117a;

        private e() {
            this.f5117a = false;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    private void b() {
        if (this.f5109c == null) {
            this.f5109c = new Handler(Looper.getMainLooper());
        }
    }

    public void a(long j4) {
        Handler handler = this.f5109c;
        if (handler != null) {
            handler.postDelayed(this.e, j4);
        }
    }

    public void a() {
        Handler handler = this.f5109c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f5109c = null;
        }
    }
}
