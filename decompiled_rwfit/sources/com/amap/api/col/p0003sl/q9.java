package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.la;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class q9 {

    /* renamed from: a, reason: collision with root package name */
    private Context f4908a;

    /* renamed from: b, reason: collision with root package name */
    private m9 f4909b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4910c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4911d = false;
    private boolean e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4912f = false;

    /* renamed from: g, reason: collision with root package name */
    private List<String> f4913g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private s9 f4914h = new s9((byte) 0);

    /* renamed from: i, reason: collision with root package name */
    private s9 f4915i = new s9();

    /* renamed from: j, reason: collision with root package name */
    private la.d f4916j = new a();

    /* renamed from: k, reason: collision with root package name */
    private la.d f4917k = new b();

    /* renamed from: l, reason: collision with root package name */
    private Handler f4918l = null;

    /* renamed from: m, reason: collision with root package name */
    private ub f4919m = null;

    /* renamed from: n, reason: collision with root package name */
    private ub f4920n = null;

    public class a implements la.d {

        /* renamed from: com.amap.api.col.3sl.q9$a$a, reason: collision with other inner class name */
        public class RunnableC0006a implements Runnable {
            public RunnableC0006a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                q9.this.a(false);
            }
        }

        public a() {
        }

        @Override // com.amap.api.col.3sl.la.d
        public final void a(int i3) {
            if (i3 > 0 && q9.a(q9.this) != null) {
                ((r9) q9.b(q9.this).f5154f).b(i3);
                q9.a(q9.this, "error", String.valueOf(((r9) q9.b(q9.this).f5154f).d()));
                q9.a(q9.this).postDelayed(new RunnableC0006a(), 660000L);
            }
        }
    }

    public class b implements la.d {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                q9.this.b(false);
            }
        }

        public b() {
        }

        @Override // com.amap.api.col.3sl.la.d
        public final void a(int i3) {
            if (i3 <= 0) {
                return;
            }
            ((r9) q9.d(q9.this).f5154f).b(i3);
            q9.a(q9.this, "info", String.valueOf(((r9) q9.d(q9.this).f5154f).d()));
            if (q9.a(q9.this) == null) {
                return;
            }
            q9.a(q9.this).postDelayed(new a(), 660000L);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, q9> f4925a = new HashMap();
    }

    public q9(m9 m9Var) {
        this.f4909b = m9Var;
    }

    public static q9 a(m9 m9Var) {
        if (m9Var == null || TextUtils.isEmpty(m9Var.d())) {
            return null;
        }
        if (c.f4925a.get(m9Var.d()) == null) {
            c.f4925a.put(m9Var.d(), new q9(m9Var));
        }
        return c.f4925a.get(m9Var.d());
    }

    private boolean b() {
        return this.f4908a != null;
    }

    public static ub d(q9 q9Var) {
        ub ubVar = q9Var.f4919m;
        if (ubVar != null) {
            return ubVar;
        }
        q9Var.d();
        return q9Var.f4919m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z5) {
        ub b3 = b(1);
        if (z5) {
            ((r9) b3.f5154f).b(z5);
        }
        Context context = this.f4908a;
        if (context == null) {
            return;
        }
        la.a(context, b3, this.f4917k);
    }

    public void c(boolean z5) {
        if (b()) {
            a(z5);
            b(z5);
        }
    }

    public void e() {
        if (b()) {
            a(2);
            a(1);
        }
    }

    private ub d() {
        Context context = this.f4908a;
        if (context == null) {
            return null;
        }
        ub ubVar = new ub();
        this.f4919m = ubVar;
        ubVar.f5150a = a(context, "CAF9B6B99962BF5C2264824231D7A40C", this.f4909b);
        ub ubVar2 = this.f4919m;
        ubVar2.f5151b = 512000000L;
        ubVar2.f5153d = 12500;
        ubVar2.f5152c = "1";
        ubVar2.f5156h = -1;
        ubVar2.f5157i = "inlkey";
        long a3 = a("info");
        ub ubVar3 = this.f4919m;
        ubVar3.f5154f = new r9(this.f4912f, new oc(this.f4908a, this.f4911d), a3, 30000000);
        ubVar3.f5155g = null;
        return ubVar3;
    }

    private ub c() {
        Context context = this.f4908a;
        if (context == null) {
            return null;
        }
        ub ubVar = new ub();
        this.f4920n = ubVar;
        ubVar.f5150a = a(context, "CB5E100E5A9A3E7F6D1FD97512215282", this.f4909b);
        ub ubVar2 = this.f4920n;
        ubVar2.f5151b = 512000000L;
        ubVar2.f5153d = 12500;
        ubVar2.f5152c = "1";
        ubVar2.f5156h = -1;
        ubVar2.f5157i = "elkey";
        long a3 = a("error");
        ub ubVar3 = this.f4920n;
        ubVar3.f5154f = new r9(true, new oc(this.f4908a, this.f4911d), a3, 10000000);
        ubVar3.f5155g = null;
        return ubVar3;
    }

    public void a(Context context) {
        this.f4908a = context.getApplicationContext();
    }

    private ub b(int i3) {
        if (i3 == 2) {
            ub ubVar = this.f4920n;
            if (ubVar == null) {
                if (ubVar == null) {
                    c();
                    ubVar = this.f4920n;
                }
                this.f4920n = ubVar;
            }
            return this.f4920n;
        }
        ub ubVar2 = this.f4919m;
        if (ubVar2 == null) {
            if (ubVar2 == null) {
                d();
                ubVar2 = this.f4919m;
            }
            this.f4919m = ubVar2;
        }
        return this.f4919m;
    }

    public void a(boolean z5, boolean z6, boolean z8, boolean z10, List<String> list) {
        this.f4910c = z5;
        this.f4911d = z6;
        this.e = z8;
        this.f4912f = z10;
        this.f4913g = list;
        c();
        d();
    }

    public void a(p9 p9Var) {
        s9 s9Var;
        if (b() && this.f4910c && !TextUtils.isEmpty(p9Var.b())) {
            List<String> list = this.f4913g;
            if (list != null && list.size() != 0) {
                for (int i3 = 0; i3 < this.f4913g.size(); i3++) {
                    if (!TextUtils.isEmpty(this.f4913g.get(i3)) && p9Var.b().contains(this.f4913g.get(i3))) {
                        return;
                    }
                }
            }
            if (this.e || p9Var.c() != 1) {
                if (p9Var.c() == 2) {
                    s9Var = this.f4915i;
                } else {
                    s9Var = this.f4914h;
                }
                if (s9Var.a(p9Var.b())) {
                    String a3 = p9.a(this.f4908a, s9Var.a());
                    if (this.f4908a == null || TextUtils.isEmpty(a3) || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(a3)) {
                        return;
                    }
                    la.a(this.f4908a, this.f4909b, p9Var.a(), b(p9Var.c()), a3, a());
                    a(false);
                    b(false);
                    s9Var.b();
                }
                s9Var.a(p9Var);
            }
        }
    }

    public static ub b(q9 q9Var) {
        ub ubVar = q9Var.f4920n;
        if (ubVar != null) {
            return ubVar;
        }
        q9Var.c();
        return q9Var.f4920n;
    }

    private String a() {
        try {
            StringBuilder sb2 = new StringBuilder();
            u9 a3 = u9.a(this.f4908a);
            a3.getClass();
            sb2.append(a3.a() + "|");
            sb2.append("0|1|debug|");
            sb2.append(Thread.currentThread().getName());
            return sb2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a(int i3) {
        s9 s9Var;
        if (i3 == 2) {
            s9Var = this.f4915i;
        } else {
            s9Var = this.f4914h;
        }
        String a3 = p9.a(this.f4908a, s9Var.a());
        if (TextUtils.isEmpty(a3) || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(a3) || this.f4908a == null) {
            return;
        }
        la.a(this.f4908a, this.f4909b, i3 == 2 ? "error" : "info", b(i3), a3, a());
        s9Var.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z5) {
        ub b3 = b(2);
        if (z5) {
            ((r9) b3.f5154f).b(z5);
        }
        Context context = this.f4908a;
        if (context == null) {
            return;
        }
        la.a(context, b3, this.f4916j);
    }

    private long a(String str) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            return Long.parseLong(t9.a(this.f4909b).a(this.f4908a, "", "", format + str));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static String a(Context context, String str, m9 m9Var) {
        String c9;
        if (context == null) {
            return null;
        }
        if (m9Var != null) {
            try {
                if (!TextUtils.isEmpty(m9Var.d())) {
                    c9 = e9.c(m9Var.d());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(context.getFilesDir().getAbsolutePath());
                    String str2 = File.separator;
                    sb2.append(str2);
                    sb2.append("EBDEC84EF205FEA2DF0719DEB822869E");
                    sb2.append(str2);
                    sb2.append(str);
                    sb2.append(str2);
                    sb2.append(c9);
                    return sb2.toString();
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        c9 = Const.INTENT_KEY_APIKEY;
        StringBuilder sb22 = new StringBuilder();
        sb22.append(context.getFilesDir().getAbsolutePath());
        String str22 = File.separator;
        sb22.append(str22);
        sb22.append("EBDEC84EF205FEA2DF0719DEB822869E");
        sb22.append(str22);
        sb22.append(str);
        sb22.append(str22);
        sb22.append(c9);
        return sb22.toString();
    }

    public static /* synthetic */ Handler a(q9 q9Var) {
        if (q9Var.f4908a == null) {
            return null;
        }
        if (q9Var.f4918l == null) {
            q9Var.f4918l = new Handler(q9Var.f4908a.getMainLooper());
        }
        return q9Var.f4918l;
    }

    public static /* synthetic */ void a(q9 q9Var, String str, String str2) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            t9.a(q9Var.f4909b).a(q9Var.f4908a, "", "", format + str, str2);
        } catch (Throwable unused) {
        }
    }
}
