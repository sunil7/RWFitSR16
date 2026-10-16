package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.q0;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class p implements j {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2056a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.camera.core.impl.e f2057b;

    /* renamed from: c, reason: collision with root package name */
    public final gc.b f2058c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2059d;
    public Handler e;

    /* renamed from: f, reason: collision with root package name */
    public ThreadPoolExecutor f2060f;

    /* renamed from: g, reason: collision with root package name */
    public ThreadPoolExecutor f2061g;

    /* renamed from: h, reason: collision with root package name */
    public q0 f2062h;

    public p(Context context, androidx.camera.core.impl.e eVar) {
        gc.b bVar = q.f2063d;
        this.f2059d = new Object();
        pd.e(context, "Context cannot be null");
        this.f2056a = context.getApplicationContext();
        this.f2057b = eVar;
        this.f2058c = bVar;
    }

    @Override // androidx.emoji2.text.j
    public final void a(q0 q0Var) {
        synchronized (this.f2059d) {
            this.f2062h = q0Var;
        }
        synchronized (this.f2059d) {
            try {
                if (this.f2062h == null) {
                    return;
                }
                if (this.f2060f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f2061g = threadPoolExecutor;
                    this.f2060f = threadPoolExecutor;
                }
                this.f2060f.execute(new androidx.activity.b(this, 8));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b() {
        synchronized (this.f2059d) {
            try {
                this.f2062h = null;
                Handler handler = this.e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f2061g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f2060f = null;
                this.f2061g = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final i1.f c() {
        try {
            gc.b bVar = this.f2058c;
            Context context = this.f2056a;
            androidx.camera.core.impl.e eVar = this.f2057b;
            bVar.getClass();
            d6.a a3 = i1.b.a(context, eVar);
            int i3 = a3.f12305a;
            if (i3 != 0) {
                throw new RuntimeException(l0.k(i3, "fetchFonts failed (", ")"));
            }
            i1.f[] fVarArr = (i1.f[]) a3.f12306b;
            if (fVarArr == null || fVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return fVarArr[0];
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("provider not found", e);
        }
    }
}
