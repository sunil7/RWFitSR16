package androidx.appcompat.app;

import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.hardware.camera2.TotalCaptureResult;
import android.util.ArrayMap;
import android.util.Size;
import android.view.Surface;
import android.widget.TextView;
import androidx.camera.core.impl.SessionConfig$SessionError;
import androidx.camera.core.impl.p1;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.u0;
import androidx.camera.core.impl.v0;
import androidx.camera.core.impl.y1;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.aps.amapapi.config.Const;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.dh.keeplive.service.KeepLiveJobService;
import com.dh.keeplive.workmanager.KeepLiveWorker;
import com.example.test.presenter.main.c1;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.SleepChartData;
import com.example.test.ui.model.chart.chart.SleepItemData;
import com.example.test.ui.sport.activity.SportNewRecordDetailActivity;
import com.example.test.ui.testui.TRingBloodPressureStatisticsActivity;
import com.example.test.ui.testui.TRingBloodSugarStatisticsActivity;
import com.example.test.ui.testui.TRingSleepFragment;
import com.example.test.ui.testui.TRingStressStatisticsActivity;
import com.example.test.ui.view.TRingSleepChartView;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import f6.o2;
import f6.o3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import t.f1;

/* loaded from: classes.dex */
public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f508a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f509b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f510c;

    public /* synthetic */ i0(int i3, Object obj, Object obj2) {
        this.f508a = i3;
        this.f509b = obj;
        this.f510c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        int i3 = 0;
        int i10 = 1;
        switch (this.f508a) {
            case 0:
                Runnable runnable = (Runnable) this.f510c;
                j0 j0Var = (j0) this.f509b;
                j0Var.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    j0Var.a();
                }
            case 1:
                androidx.camera.core.impl.g0 g0Var = (androidx.camera.core.impl.g0) this.f509b;
                String str = (String) this.f510c;
                g0Var.getClass();
                try {
                    g0Var.e.get();
                    g0Var.e(androidx.camera.core.impl.g0.f1391n.decrementAndGet(), androidx.camera.core.impl.g0.f1390m.get(), "Surface terminated");
                    return;
                } catch (Exception e) {
                    com.google.android.gms.internal.mlkit_vision_common.a0.b("DeferrableSurface", "Unexpected surface termination for " + g0Var + "\nStack Trace:\n" + str);
                    synchronized (g0Var.f1392a) {
                        throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", g0Var, Boolean.valueOf(g0Var.f1394c), Integer.valueOf(g0Var.f1393b)), e);
                    }
                }
            case 2:
                ((androidx.lifecycle.b0) ((ef.i) this.f509b).f12629b).j((u0) this.f510c);
                return;
            case 3:
                u0 u0Var = (u0) this.f509b;
                if (u0Var.f1494a.get()) {
                    v0 v0Var = (v0) this.f510c;
                    v0Var.getClass();
                    u0Var.f1495b.a(v0Var.f1510a);
                    return;
                }
                return;
            case 4:
                ((b1.b) this.f509b).e((Typeface) this.f510c);
                return;
            case 5:
                c0.f fVar = (c0.f) this.f509b;
                w.c cVar = fVar.f3293c;
                c0.o oVar = (c0.o) this.f510c;
                Surface c9 = oVar.c(cVar, new c0.d(i3, fVar, oVar));
                fVar.f3291a.g(c9);
                fVar.f3297h.put(oVar, c9);
                return;
            case 6:
                final c0.f fVar2 = (c0.f) this.f509b;
                fVar2.f3298i++;
                c0.h hVar = fVar2.f3291a;
                e0.h.d(hVar.f3303a, true);
                e0.h.c(hVar.f3305c);
                final SurfaceTexture surfaceTexture = new SurfaceTexture(hVar.f3314m);
                final f1 f1Var = (f1) this.f510c;
                Size size = f1Var.f18320b;
                surfaceTexture.setDefaultBufferSize(size.getWidth(), size.getHeight());
                final Surface surface = new Surface(surfaceTexture);
                c0.b bVar = new c0.b(i10, fVar2, f1Var);
                w.c cVar2 = fVar2.f3293c;
                f1Var.b(cVar2, bVar);
                f1Var.a(surface, cVar2, new k1.a() { // from class: c0.e
                    @Override // k1.a
                    public final void f(Object obj) {
                        f fVar3 = f.this;
                        f1 f1Var2 = f1Var;
                        SurfaceTexture surfaceTexture2 = surfaceTexture;
                        Surface surface2 = surface;
                        fVar3.getClass();
                        synchronized (f1Var2.f18319a) {
                            f1Var2.f18330m = null;
                            f1Var2.f18331n = null;
                        }
                        surfaceTexture2.setOnFrameAvailableListener(null);
                        surfaceTexture2.release();
                        surface2.release();
                        fVar3.f3298i--;
                        fVar3.a();
                    }
                });
                surfaceTexture.setOnFrameAvailableListener(fVar2, fVar2.f3294d);
                return;
            case 7:
                c0.o oVar2 = (c0.o) this.f509b;
                oVar2.getClass();
                ((k1.a) ((AtomicReference) this.f510c).get()).f(new t.j(oVar2));
                return;
            case 8:
                qd.g gVar = (qd.g) ((c5.a) this.f509b).f3384c;
                if (gVar != null) {
                    gVar.a((androidx.recyclerview.widget.x) this.f510c);
                    return;
                }
                return;
            case 9:
                qd.g gVar2 = (qd.g) ((c5.a) this.f509b).f3384c;
                if (gVar2 != null) {
                    gVar2.onSuccess((byte[]) this.f510c);
                    return;
                }
                return;
            case 10:
                int i11 = SportNewRecordDetailActivity.M;
                SportNewRecordDetailActivity this$0 = (SportNewRecordDetailActivity) this.f509b;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                ArrayList it = (ArrayList) this.f510c;
                kotlin.jvm.internal.e.f(it, "$it");
                AMap aMap = this$0.F;
                if (aMap != null) {
                    aMap.addPolyline(new PolylineOptions().addAll(it).width(10.0f).color(Color.argb(235, 1, 180, 247)));
                }
                LatLngBounds.Builder builder = LatLngBounds.builder();
                int size2 = it.size();
                while (i3 < size2) {
                    Object obj = it.get(i3);
                    i3++;
                    builder.include((LatLng) obj);
                }
                AMap aMap2 = this$0.F;
                if (aMap2 != null) {
                    aMap2.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 10));
                    return;
                }
                return;
            case 11:
                int i12 = TRingBloodPressureStatisticsActivity.J;
                TRingBloodPressureStatisticsActivity this$02 = (TRingBloodPressureStatisticsActivity) this.f509b;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                EventBusBeans.SyncDataEvent syncEvent = (EventBusBeans.SyncDataEvent) this.f510c;
                kotlin.jvm.internal.e.f(syncEvent, "$syncEvent");
                f6.i iVar = (f6.i) this$02.f7247z.getValue();
                textView = iVar != null ? iVar.f12971o : null;
                if (textView == null) {
                    return;
                }
                textView.setText(syncEvent.getSp() + "/" + syncEvent.getDp());
                return;
            case 12:
                int i13 = TRingBloodSugarStatisticsActivity.J;
                TRingBloodSugarStatisticsActivity this$03 = (TRingBloodSugarStatisticsActivity) this.f509b;
                kotlin.jvm.internal.e.f(this$03, "this$0");
                kotlin.jvm.internal.e.f((EventBusBeans.SyncDataEvent) this.f510c, "$syncEvent");
                eh.b bVar2 = this$03.f7247z;
                f6.j jVar = (f6.j) bVar2.getValue();
                textView = jVar != null ? jVar.f13011o : null;
                if (textView != null) {
                    android.support.v4.media.session.e.A(new Object[]{Float.valueOf(r5.getData() / 10.0f)}, 1, "%.1f", textView);
                }
                ((f6.j) bVar2.getValue()).f13012p.setText("mmol/L");
                return;
            case 13:
                TRingSleepFragment this$04 = (TRingSleepFragment) this.f509b;
                kotlin.jvm.internal.e.f(this$04, "this$0");
                SleepChartData sleepChartData = (SleepChartData) this.f510c;
                o3 o3Var = (o3) this$04.f7251b;
                if (o3Var != null) {
                    TRingSleepChartView tRingSleepChartView = o3Var.f13185c;
                    c1 c1Var = (c1) this$04.X();
                    List<SleepItemData> items = sleepChartData.getItems();
                    kotlin.jvm.internal.e.e(items, "getItems(...)");
                    c1Var.l(items, tRingSleepChartView.getWidth(), tRingSleepChartView.getHeight());
                    o3 o3Var2 = (o3) this$04.f7251b;
                    TextView textView2 = o3Var2 != null ? o3Var2.f13201u : null;
                    if (textView2 != null) {
                        textView2.setText(sleepChartData.getStartTime());
                    }
                    o3 o3Var3 = (o3) this$04.f7251b;
                    textView = o3Var3 != null ? o3Var3.f13200t : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setText(sleepChartData.getEndTime());
                    return;
                }
                return;
            case 14:
                int i14 = TRingStressStatisticsActivity.J;
                TRingStressStatisticsActivity tRingStressStatisticsActivity = (TRingStressStatisticsActivity) this.f509b;
                EventBusBeans.SyncDataEvent syncDataEvent = (EventBusBeans.SyncDataEvent) this.f510c;
                eh.b bVar3 = tRingStressStatisticsActivity.f7247z;
                o2 o2Var = (o2) bVar3.getValue();
                textView = o2Var != null ? o2Var.f13180o : null;
                if (textView != null) {
                    textView.setText(String.valueOf(syncDataEvent.getData()));
                }
                ((o2) bVar3.getValue()).f13181p.setText(ca.k(tRingStressStatisticsActivity, syncDataEvent.getData()));
                return;
            case 15:
                final d0.e eVar = (d0.e) this.f509b;
                eVar.e++;
                f1 f1Var2 = (f1) this.f510c;
                d0.c cVar3 = eVar.f12188a;
                e0.h.d(cVar3.f3303a, true);
                e0.h.c(cVar3.f3305c);
                boolean z5 = f1Var2.e;
                final SurfaceTexture surfaceTexture2 = new SurfaceTexture(z5 ? cVar3.f12181n : cVar3.f12182o);
                Size size3 = f1Var2.f18320b;
                surfaceTexture2.setDefaultBufferSize(size3.getWidth(), size3.getHeight());
                final Surface surface2 = new Surface(surfaceTexture2);
                f1Var2.a(surface2, eVar.f12190c, new k1.a() { // from class: d0.d
                    @Override // k1.a
                    public final void f(Object obj2) {
                        e eVar2 = e.this;
                        eVar2.getClass();
                        SurfaceTexture surfaceTexture3 = surfaceTexture2;
                        surfaceTexture3.setOnFrameAvailableListener(null);
                        surfaceTexture3.release();
                        surface2.release();
                        eVar2.e--;
                        eVar2.a();
                    }
                });
                if (z5) {
                    eVar.f12195i = surfaceTexture2;
                    return;
                } else {
                    eVar.f12196j = surfaceTexture2;
                    surfaceTexture2.setOnFrameAvailableListener(eVar, eVar.f12191d);
                    return;
                }
            case 16:
                d0.e eVar2 = (d0.e) this.f509b;
                w.c cVar4 = eVar2.f12190c;
                c0.o oVar3 = (c0.o) this.f510c;
                Surface c10 = oVar3.c(cVar4, new c0.d(i10, eVar2, oVar3));
                eVar2.f12188a.g(c10);
                eVar2.f12194h.put(oVar3, c10);
                return;
            case 17:
                ((ud.a) this.f509b).e.g((vd.b) this.f510c);
                return;
            case 18:
                ((androidx.camera.view.d) this.f509b).f1597a.f1577l.b((f1) this.f510c);
                return;
            case 19:
                h0.l lVar = (h0.l) this.f509b;
                f1 f1Var3 = lVar.f14243h;
                if (f1Var3 != null && f1Var3 == ((f1) this.f510c)) {
                    lVar.f14243h = null;
                    lVar.f14242g = null;
                }
                androidx.camera.core.impl.h0 h0Var = lVar.f14247l;
                if (h0Var != null) {
                    h0Var.a();
                    lVar.f14247l = null;
                    return;
                }
                return;
            case 20:
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) this.f509b;
                SurfaceTexture surfaceTexture3 = sphericalGLSurfaceView.f9061g;
                Surface surface3 = sphericalGLSurfaceView.f9062h;
                SurfaceTexture surfaceTexture4 = (SurfaceTexture) this.f510c;
                Surface surface4 = new Surface(surfaceTexture4);
                sphericalGLSurfaceView.f9061g = surfaceTexture4;
                sphericalGLSurfaceView.f9062h = surface4;
                Iterator it2 = sphericalGLSurfaceView.f9056a.iterator();
                if (it2.hasNext()) {
                    ((com.google.android.exoplayer2.q) it2.next()).getClass();
                    throw null;
                }
                if (surfaceTexture3 != null) {
                    surfaceTexture3.release();
                }
                if (surface3 != null) {
                    surface3.release();
                    return;
                }
                return;
            case 21:
                final n.h hVar2 = (n.h) this.f509b;
                final long v6 = hVar2.v();
                x.i.e(true, ve.a(new n0.g() { // from class: n.e
                    @Override // n0.g
                    public final Object b(final androidx.concurrent.futures.b bVar4) {
                        h hVar3 = h.this;
                        hVar3.getClass();
                        final long j4 = v6;
                        hVar3.k(new g() { // from class: n.f
                            @Override // n.g
                            public final boolean a(TotalCaptureResult totalCaptureResult) {
                                if (!h.s(totalCaptureResult, j4)) {
                                    return false;
                                }
                                bVar4.a(null);
                                return true;
                            }
                        });
                        return "waitForSessionUpdateId:" + j4;
                    }
                }), (androidx.concurrent.futures.b) this.f510c, a6.a());
                return;
            case 22:
                h0.c cVar5 = ((n.h) this.f509b).f16199x;
                HashSet hashSet = (HashSet) cVar5.f14217b;
                androidx.camera.core.impl.k kVar = (androidx.camera.core.impl.k) this.f510c;
                hashSet.remove(kVar);
                ((ArrayMap) cVar5.f14218c).remove(kVar);
                return;
            case 23:
                androidx.camera.camera2.internal.compat.f fVar3 = (androidx.camera.camera2.internal.compat.f) this.f509b;
                HashSet hashSet2 = new HashSet();
                HashSet hashSet3 = (HashSet) fVar3.f1165c;
                Iterator it3 = hashSet3.iterator();
                while (it3.hasNext()) {
                    n.g gVar3 = (n.g) it3.next();
                    if (gVar3.a((TotalCaptureResult) this.f510c)) {
                        hashSet2.add(gVar3);
                    }
                }
                if (hashSet2.isEmpty()) {
                    return;
                }
                hashSet3.removeAll(hashSet2);
                return;
            case 24:
                ((p1) this.f509b).a((s1) this.f510c, SessionConfig$SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
                return;
            case 25:
                ((Surface) this.f509b).release();
                ((SurfaceTexture) this.f510c).release();
                return;
            case 26:
                androidx.camera.camera2.internal.i iVar2 = (androidx.camera.camera2.internal.i) this.f509b;
                n.g0 g0Var2 = iVar2.f1259x;
                androidx.concurrent.futures.b bVar4 = (androidx.concurrent.futures.b) this.f510c;
                if (g0Var2 == null) {
                    bVar4.a(Boolean.FALSE);
                    return;
                } else {
                    bVar4.a(Boolean.valueOf(iVar2.f1238a.z(androidx.camera.camera2.internal.i.v(g0Var2))));
                    return;
                }
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                ArrayList arrayList = (ArrayList) this.f510c;
                androidx.camera.camera2.internal.i iVar3 = (androidx.camera.camera2.internal.i) this.f509b;
                n.h hVar3 = iVar3.f1244h;
                try {
                    iVar3.G(arrayList);
                    return;
                } finally {
                    hVar3.l();
                }
            case Const.ANDROID_VERSION_28 /* 28 */:
                androidx.camera.camera2.internal.i iVar4 = (androidx.camera.camera2.internal.i) this.f509b;
                iVar4.getClass();
                StringBuilder sb2 = new StringBuilder("Use case ");
                String str2 = (String) this.f510c;
                sb2.append(str2);
                sb2.append(" INACTIVE");
                iVar4.s(sb2.toString(), null);
                LinkedHashMap linkedHashMap = (LinkedHashMap) iVar4.f1238a.f8774c;
                if (linkedHashMap.containsKey(str2)) {
                    y1 y1Var = (y1) linkedHashMap.get(str2);
                    y1Var.f1533f = false;
                    if (!y1Var.e) {
                        linkedHashMap.remove(str2);
                    }
                }
                iVar4.J();
                return;
            default:
                KeepLiveConfig keepLiveConfig = (KeepLiveConfig) this.f509b;
                kotlin.jvm.internal.e.f(keepLiveConfig, "$keepLiveConfig");
                KeepLiveJobService keepLiveJobService = (KeepLiveJobService) this.f510c;
                if (!keepLiveConfig.getDefaultConfig().getWorkerEnabled()) {
                    com.dh.keeplive.ext.a.l(keepLiveJobService);
                    return;
                }
                if (com.dh.keeplive.ext.a.c(keepLiveJobService) && com.dh.keeplive.ext.a.f7211c) {
                    try {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        new p2.e(p2.l.a(keepLiveJobService), KeepLiveWorker.class.getName(), ExistingPeriodicWorkPolicy.REPLACE == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE, Collections.singletonList((o2.t) new o2.n().a())).a();
                        return;
                    } catch (Exception unused) {
                        com.dh.keeplive.ext.a.l(keepLiveJobService);
                        com.dh.keeplive.ext.a.d("WorkManager registration failed");
                        return;
                    }
                }
                return;
        }
    }
}
