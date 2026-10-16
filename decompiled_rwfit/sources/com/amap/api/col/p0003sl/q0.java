package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.p0003sl.r0;
import com.amap.api.map3d.R;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class q0 extends Thread {
    private static int e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f4871f = false;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f4872g = 0;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f4873a;

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f4874b;

    /* renamed from: c, reason: collision with root package name */
    private b f4875c = null;

    /* renamed from: d, reason: collision with root package name */
    private Handler f4876d = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (q0.f4871f) {
                return;
            }
            if (q0.this.f4875c == null) {
                q0 q0Var = q0.this;
                q0Var.f4875c = new b(q0Var.f4874b, q0.this.f4873a == null ? null : (Context) q0.this.f4873a.get());
            }
            u4.b().a(q0.this.f4875c);
        }
    }

    public static class b extends rc {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IAMapDelegate> f4878a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<Context> f4879b;

        /* renamed from: c, reason: collision with root package name */
        private r0 f4880c;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ IAMapDelegate f4881a;

            public a(IAMapDelegate iAMapDelegate) {
                this.f4881a = iAMapDelegate;
            }

            @Override // java.lang.Runnable
            public void run() {
                IAMapDelegate iAMapDelegate = this.f4881a;
                if (iAMapDelegate == null || iAMapDelegate.getMapConfig() == null) {
                    return;
                }
                MapConfig mapConfig = this.f4881a.getMapConfig();
                mapConfig.setProFunctionAuthEnable(false);
                if (mapConfig.isUseProFunction()) {
                    this.f4881a.setMapCustomEnable(mapConfig.isCustomStyleEnable(), true);
                    this.f4881a.reloadMapCustomStyle();
                    c4.a(b.this.f4879b == null ? null : (Context) b.this.f4879b.get(), n1.a(R.string.O105492_284));
                }
            }
        }

        public b(IAMapDelegate iAMapDelegate, Context context) {
            this.f4878a = null;
            this.f4879b = null;
            this.f4878a = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.f4879b = new WeakReference<>(context);
            }
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            r0.a c9;
            WeakReference<Context> weakReference;
            try {
                if (q0.f4871f) {
                    return;
                }
                if (this.f4880c == null && (weakReference = this.f4879b) != null && weakReference.get() != null) {
                    this.f4880c = new r0(this.f4879b.get(), "");
                }
                q0.c();
                if (q0.e > 3) {
                    boolean unused = q0.f4871f = true;
                    a();
                    return;
                }
                r0 r0Var = this.f4880c;
                if (r0Var == null || (c9 = r0Var.c()) == null) {
                    return;
                }
                if (!c9.f4933a) {
                    a();
                }
                boolean unused2 = q0.f4871f = true;
            } catch (Throwable th2) {
                ka.a(th2, "authForPro", "loadConfigData_uploadException");
                y4.a("[map][network]", "auth exception get data " + th2.getMessage());
            }
        }

        private void a() {
            IAMapDelegate iAMapDelegate;
            WeakReference<IAMapDelegate> weakReference = this.f4878a;
            if (weakReference == null || weakReference.get() == null || (iAMapDelegate = this.f4878a.get()) == null || iAMapDelegate.getMapConfig() == null) {
                return;
            }
            iAMapDelegate.queueEvent(new a(iAMapDelegate));
        }
    }

    public q0(Context context, IAMapDelegate iAMapDelegate) {
        this.f4873a = null;
        if (context != null) {
            this.f4873a = new WeakReference<>(context);
        }
        this.f4874b = iAMapDelegate;
        d();
    }

    public static void d() {
        e = 0;
        f4871f = false;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        this.f4874b = null;
        this.f4873a = null;
        Handler handler = this.f4876d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f4876d = null;
        this.f4875c = null;
        e = 0;
        f4871f = false;
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (f4871f) {
                return;
            }
            int i3 = 0;
            while (i3 <= 3) {
                i3++;
                this.f4876d.sendEmptyMessageDelayed(0, i3 * 30000);
            }
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th2.printStackTrace();
            y4.a("[map][network]", "auth pro exception " + th2.getMessage());
        }
    }

    public static /* synthetic */ int c() {
        int i3 = e;
        e = i3 + 1;
        return i3;
    }
}
