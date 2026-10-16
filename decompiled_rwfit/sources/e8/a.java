package e8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryChargingProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$NetworkStateProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$StorageNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import b8.g;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.material.appbar.AppBarLayout;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import de.o;
import ff.n;
import ff.q;
import ia.f;
import ia.j;
import ia.m;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import ka.e;
import l1.h0;
import o2.l;
import qf.i;
import x.h;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12473a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12474b;

    /* renamed from: c, reason: collision with root package name */
    public Object f12475c;

    /* renamed from: d, reason: collision with root package name */
    public Object f12476d;

    public /* synthetic */ a(int i3) {
        this.f12473a = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar;
        OverScroller overScroller;
        Object obj = null;
        boolean z5 = true;
        switch (this.f12473a) {
            case 0:
                b bVar = (b) this.f12474b;
                a8.b bVar2 = (a8.b) this.f12475c;
                String str = bVar2.f120a;
                a8.a aVar = (a8.a) this.f12476d;
                Logger logger = b.f12477f;
                try {
                    g a3 = bVar.f12480c.a(str);
                    if (a3 == null) {
                        String str2 = "Transport backend '" + str + "' is not registered";
                        logger.warning(str2);
                        new IllegalArgumentException(str2);
                    } else {
                        ((g8.g) bVar.e).f(new o(bVar, 19, bVar2, ((y7.b) a3).a(aVar)));
                    }
                    return;
                } catch (Exception e) {
                    logger.warning("Error scheduling event " + e.getMessage());
                    return;
                }
            case 1:
                n nVar = (n) this.f12476d;
                CaptureRequest.Builder builder = nVar.Z;
                Flash flash = (Flash) this.f12474b;
                boolean V = nVar.V(builder, flash);
                if (nVar.f13648d.e != CameraState.PREVIEW) {
                    if (V) {
                        nVar.Y();
                        return;
                    }
                    return;
                }
                nVar.f13656m = Flash.OFF;
                nVar.V(nVar.Z, flash);
                try {
                    nVar.Y.capture(nVar.Z.build(), null, null);
                    nVar.f13656m = (Flash) this.f12475c;
                    nVar.V(nVar.Z, flash);
                    nVar.Y();
                    return;
                } catch (CameraAccessException e10) {
                    throw n.c0(e10);
                }
            case 2:
                Facing facing = (Facing) this.f12474b;
                q qVar = (q) this.f12476d;
                if (qVar.c(facing)) {
                    qVar.z();
                    return;
                } else {
                    qVar.F = (Facing) this.f12475c;
                    return;
                }
            case 3:
                try {
                    obj = ((i1.c) this.f12474b).call();
                } catch (Exception unused) {
                }
                ((Handler) this.f12476d).post(new h(26, (c0.g) this.f12475c, obj));
                return;
            case 4:
                View view = (View) this.f12475c;
                if (view == null || (overScroller = (eVar = (e) this.f12476d).f15577d) == null) {
                    return;
                }
                boolean computeScrollOffset = overScroller.computeScrollOffset();
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f12474b;
                if (computeScrollOffset) {
                    eVar.v(coordinatorLayout, view, eVar.f15577d.getCurrY(), Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO);
                    h0.m(view, this);
                    return;
                }
                AppBarLayout appBarLayout = (AppBarLayout) view;
                ((AppBarLayout.BaseBehavior) eVar).z(coordinatorLayout, appBarLayout);
                if (appBarLayout.f10175k) {
                    appBarLayout.e(appBarLayout.f(AppBarLayout.BaseBehavior.x(coordinatorLayout)));
                    return;
                }
                return;
            case 5:
                try {
                    nf.e.f16609h.b(1, ((nf.b) this.f12474b).f16596a.toUpperCase(), "- Executing.");
                    f fVar = (f) ((nf.b) this.f12474b).f16598c.call();
                    i iVar = (i) this.f12475c;
                    mc.g gVar = new mc.g(this, 5);
                    if (fVar.e()) {
                        j jVar = new j(8, gVar, fVar);
                        iVar.getClass();
                        if (Thread.currentThread() == iVar.f17955b) {
                            jVar.run();
                        } else {
                            iVar.f17956c.post(jVar);
                        }
                    } else {
                        m mVar = (m) fVar;
                        mVar.f14399b.f(new ia.i(iVar.f17957d, gVar));
                        mVar.k();
                    }
                    return;
                } catch (Exception e11) {
                    nf.e.f16609h.b(1, ((nf.b) this.f12474b).f16596a.toUpperCase(), "- Finished with ERROR.", e11);
                    if (((nf.b) this.f12474b).f16599d) {
                        q.b(((nf.e) this.f12476d).f16610a.f13671a, e11, false);
                    }
                    ((nf.b) this.f12474b).f16597b.b(e11);
                    synchronized (((nf.e) this.f12476d).f16613d) {
                        nf.e.a((nf.e) this.f12476d, (nf.b) this.f12474b);
                        return;
                    }
                }
            case 6:
                try {
                    z5 = ((Boolean) ((androidx.work.impl.utils.futures.b) this.f12476d).get()).booleanValue();
                } catch (InterruptedException | ExecutionException unused2) {
                }
                ((p2.b) this.f12474b).a((String) this.f12475c, z5);
                return;
            case 7:
                androidx.work.impl.utils.futures.b bVar3 = (androidx.work.impl.utils.futures.b) this.f12475c;
                p2.m mVar2 = (p2.m) this.f12476d;
                try {
                    ((androidx.work.impl.utils.futures.b) this.f12474b).get();
                    o2.m.g().d(p2.m.f17433s, "Starting work for " + mVar2.f17437d.f19751c, new Throwable[0]);
                    androidx.work.impl.utils.futures.b d5 = mVar2.e.d();
                    mVar2.f17449q = d5;
                    bVar3.l(d5);
                    return;
                } catch (Throwable th2) {
                    bVar3.k(th2);
                    return;
                }
            case 8:
                String str3 = (String) this.f12475c;
                p2.m mVar3 = (p2.m) this.f12476d;
                try {
                    try {
                        l lVar = (l) ((androidx.work.impl.utils.futures.b) this.f12474b).get();
                        if (lVar == null) {
                            o2.m.g().f(p2.m.f17433s, mVar3.f17437d.f19751c + " returned a null result. Treating it as a failure.", new Throwable[0]);
                        } else {
                            o2.m.g().d(p2.m.f17433s, String.format("%s returned a %s result.", mVar3.f17437d.f19751c, lVar), new Throwable[0]);
                            mVar3.f17439g = lVar;
                        }
                    } catch (Throwable th3) {
                        mVar3.c();
                        throw th3;
                    }
                } catch (InterruptedException e12) {
                    e = e12;
                    o2.m.g().f(p2.m.f17433s, str3 + " failed because it threw an exception/error", e);
                } catch (CancellationException e13) {
                    o2.m.g().h(p2.m.f17433s, str3 + " was cancelled", e13);
                } catch (ExecutionException e14) {
                    e = e14;
                    o2.m.g().f(p2.m.f17433s, str3 + " failed because it threw an exception/error", e);
                }
                mVar3.c();
                return;
            case 9:
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.f12476d;
                Context context = (Context) this.f12475c;
                Intent intent = (Intent) this.f12474b;
                try {
                    boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    o2.m.g().d(ConstraintProxyUpdateReceiver.f3014a, "Updating proxies: BatteryNotLowProxy enabled (" + booleanExtra + "), BatteryChargingProxy enabled (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy enabled (" + booleanExtra4 + ")", new Throwable[0]);
                    y2.g.a(context, ConstraintProxy$BatteryNotLowProxy.class, booleanExtra);
                    y2.g.a(context, ConstraintProxy$BatteryChargingProxy.class, booleanExtra2);
                    y2.g.a(context, ConstraintProxy$StorageNotLowProxy.class, booleanExtra3);
                    y2.g.a(context, ConstraintProxy$NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    pendingResult.finish();
                }
            case 10:
                x2.h h4 = ((WorkDatabase) this.f12474b).n().h((String) this.f12475c);
                if (h4 == null || !h4.b()) {
                    return;
                }
                synchronized (((w2.a) this.f12476d).f19470c) {
                    ((w2.a) this.f12476d).f19472f.put((String) this.f12475c, h4);
                    ((w2.a) this.f12476d).f19473g.add(h4);
                    w2.a aVar2 = (w2.a) this.f12476d;
                    aVar2.f19474h.b(aVar2.f19473g);
                }
                return;
            default:
                ((p2.l) this.f12474b).f17429f.g((String) this.f12475c, (eb.e) this.f12476d);
                return;
        }
    }

    public /* synthetic */ a(Object obj, int i3, Object obj2, Object obj3) {
        this.f12473a = i3;
        this.f12474b = obj;
        this.f12475c = obj2;
        this.f12476d = obj3;
    }

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i3, boolean z5) {
        this.f12473a = i3;
        this.f12476d = obj;
        this.f12474b = obj2;
        this.f12475c = obj3;
    }
}
