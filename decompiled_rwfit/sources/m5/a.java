package m5;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.g;
import androidx.camera.camera2.internal.i;
import androidx.camera.camera2.internal.m;
import com.example.test.XXApplication;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import ia.j;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.e;
import n.l;
import n.n0;
import o6.h;
import t.i0;
import t.p0;
import x5.d;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15968a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15969b;

    public /* synthetic */ a(Object obj, int i3) {
        this.f15968a = i3;
        this.f15969b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6, types: [int] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        c cVar;
        Application application;
        Handler handler;
        int i3 = 25;
        boolean z5 = true;
        boolean z6 = false;
        switch (this.f15968a) {
            case 0:
                c this$0 = (c) this.f15969b;
                e.f(this$0, "this$0");
                if (this$0.f15975b == 0) {
                    this$0.e();
                    return;
                }
                return;
            case 1:
                i iVar = (i) this.f15969b;
                iVar.f1257v = false;
                iVar.f1256u = false;
                iVar.s("OpenCameraConfigAndClose is done, state: " + iVar.e, null);
                int ordinal = iVar.e.ordinal();
                if (ordinal == 1 || ordinal == 4) {
                    pd.f(null, iVar.f1250n.isEmpty());
                    iVar.t();
                    return;
                }
                if (ordinal != 6) {
                    iVar.s("OpenCameraConfigAndClose finished while in state: " + iVar.e, null);
                    return;
                }
                int i10 = iVar.f1248l;
                if (i10 == 0) {
                    iVar.I(false);
                    return;
                } else {
                    iVar.s("OpenCameraConfigAndClose in error: ".concat(i.u(i10)), null);
                    iVar.f1245i.b();
                    return;
                }
            case 2:
                ((CameraDevice) this.f15969b).close();
                return;
            case 3:
                l lVar = (l) this.f15969b;
                if (((AtomicBoolean) lVar.f16246c).getAndSet(true)) {
                    return;
                }
                ((i) ((y) lVar.f16247d).f8774c).f1240c.execute(new g(lVar, false ? 1 : 0));
                return;
            case 4:
                m mVar = (m) this.f15969b;
                synchronized (mVar.f1267a) {
                    if (mVar.f1268b.isEmpty()) {
                        return;
                    }
                    try {
                        mVar.h(mVar.f1268b);
                        return;
                    } finally {
                        mVar.f1268b.clear();
                    }
                }
            case 5:
                for (n0 n0Var : (LinkedHashSet) this.f15969b) {
                    n0Var.getClass();
                    n0Var.c(n0Var);
                }
                return;
            case 6:
                XXApplication xXApplication = (XXApplication) this.f15969b;
                c cVar2 = com.dh.keeplive.ext.a.f7215h;
                if (cVar2 != null) {
                    cVar2.e = false;
                    xXApplication.unregisterActivityLifecycleCallbacks(cVar2);
                    com.dh.keeplive.ext.a.f7215h = null;
                    return;
                }
                return;
            case 7:
                Service this_stopService = (Service) this.f15969b;
                e.f(this_stopService, "$this_stopService");
                try {
                    this_stopService.stopSelf();
                    return;
                } catch (Exception unused) {
                    return;
                }
            case 8:
                ((o6.b) this.f15969b).f16749d.getClass();
                return;
            case 9:
                ((h) this.f15969b).f16770f.getClass();
                return;
            case 10:
                s.c cVar3 = (s.c) this.f15969b;
                androidx.concurrent.futures.b bVar = cVar3.f18155g;
                if (bVar != null) {
                    bVar.a(null);
                    cVar3.f18155g = null;
                    return;
                }
                return;
            case 11:
                i0 i0Var = (i0) this.f15969b;
                synchronized (i0Var.f18347u) {
                    try {
                        i0Var.f18349w = null;
                        p0 p0Var = i0Var.f18348v;
                        if (p0Var != null) {
                            i0Var.f18348v = null;
                            i0Var.f(p0Var);
                        }
                    } finally {
                    }
                }
                return;
            case 12:
                ((androidx.camera.core.c) this.f15969b).o();
                return;
            case 13:
                ((u.c) ((g0.g) this.f15969b).f13772b).getClass();
                return;
            case 14:
                ((u.e) this.f15969b).c();
                return;
            case 15:
                ((ScheduledFuture) this.f15969b).cancel(true);
                return;
            case 16:
                ((androidx.concurrent.futures.b) this.f15969b).a(null);
                return;
            case 17:
                ((x5.c) this.f15969b).d();
                return;
            case 18:
                ((d) this.f15969b).f();
                return;
            default:
                Activity activity = (Activity) this.f15969b;
                if (activity.isFinishing()) {
                    return;
                }
                ?? r52 = Build.VERSION.SDK_INT;
                if (r52 >= 28) {
                    Class cls = y0.e.f19863a;
                    activity.recreate();
                    return;
                }
                Class cls2 = y0.e.f19863a;
                ?? r62 = 27;
                ?? r72 = 26;
                boolean z8 = r52 == 26 || r52 == 27;
                Method method = y0.e.f19867f;
                if ((!z8 || method != null) && (y0.e.e != null || y0.e.f19866d != null)) {
                    try {
                        Object obj2 = y0.e.f19865c.get(activity);
                        if (obj2 != null && (obj = y0.e.f19864b.get(activity)) != null) {
                            Application application2 = activity.getApplication();
                            c cVar4 = new c(activity);
                            application2.registerActivityLifecycleCallbacks(cVar4);
                            Handler handler2 = y0.e.f19868g;
                            handler2.post(new j(cVar4, 24, obj2, z6));
                            if (r52 != 26 && r52 != 27) {
                                z5 = false;
                            }
                            try {
                                if (z5) {
                                    Handler handler3 = handler2;
                                    try {
                                        Boolean bool = Boolean.FALSE;
                                        r62 = application2;
                                        r72 = cVar4;
                                        method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                        r52 = handler3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        application = application2;
                                        cVar = cVar4;
                                        handler = handler3;
                                        handler.post(new j(application, i3, cVar, false ? 1 : 0));
                                        throw th;
                                    }
                                } else {
                                    r62 = application2;
                                    r72 = cVar4;
                                    r52 = handler2;
                                    activity.recreate();
                                }
                                r52.post(new j(r62, i3, r72, false ? 1 : 0));
                                return;
                            } catch (Throwable th3) {
                                th = th3;
                                handler = r52;
                                application = r62;
                                cVar = r72;
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                activity.recreate();
                return;
        }
    }

    public /* synthetic */ a(Thread thread, long j4, int i3) {
        this.f15968a = i3;
        this.f15969b = thread;
    }
}
