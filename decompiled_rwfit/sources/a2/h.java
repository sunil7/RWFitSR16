package a2;

import android.content.Context;
import android.content.IntentFilter;
import android.hardware.camera2.CameraDevice;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import androidx.appcompat.app.c0;
import androidx.appcompat.app.y;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import d4.q;
import d4.r;
import d4.x;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class h implements r, q7.e {

    /* renamed from: a, reason: collision with root package name */
    public Object f36a;

    /* renamed from: b, reason: collision with root package name */
    public Object f37b;

    public h() {
        this.f36a = new ArrayList();
        this.f37b = new Handler(Looper.getMainLooper());
    }

    public abstract void A();

    public abstract String B();

    public void C() {
        v();
        IntentFilter w8 = w();
        if (w8.countActions() == 0) {
            return;
        }
        if (((y) this.f36a) == null) {
            this.f36a = new y(this, 0);
        }
        ((c0) this.f37b).f432k.registerReceiver((y) this.f36a, w8);
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [o7.h] */
    @Override // q7.e
    public q7.c b(float f2, float f10) {
        o7.d dVar;
        PieRadarChartBase pieRadarChartBase = (PieRadarChartBase) this.f36a;
        if (pieRadarChartBase.r(f2, f10) <= pieRadarChartBase.getRadius()) {
            float s7 = pieRadarChartBase.s(f2, f10);
            if (pieRadarChartBase instanceof PieChart) {
                pieRadarChartBase.getAnimator().getClass();
                s7 /= 1.0f;
            }
            int t8 = pieRadarChartBase.t(s7);
            if (t8 >= 0) {
                ArrayList arrayList = pieRadarChartBase.getData().f16833i;
                if (arrayList == null || arrayList.isEmpty()) {
                    dVar = null;
                } else {
                    int i3 = 0;
                    dVar = (o7.d) arrayList.get(0);
                    int size = arrayList.size();
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        o7.d dVar2 = (o7.d) obj;
                        if (dVar2.f16820o.size() > dVar.f16820o.size()) {
                            dVar = dVar2;
                        }
                    }
                }
                if (t8 < dVar.f16820o.size()) {
                    y();
                    throw null;
                }
            }
        }
        return null;
    }

    @Override // d4.r
    public q c(x xVar) {
        Class cls = (Class) this.f37b;
        return new e4.d((Context) this.f36a, xVar.a(File.class, cls), xVar.a(Uri.class, cls), cls);
    }

    public void u(de.l lVar) {
        x.h hVar = new x.h(8, (ArrayList) this.f36a, lVar);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            hVar.run();
        } else {
            ((Handler) this.f37b).post(hVar);
        }
    }

    public void v() {
        y yVar = (y) this.f36a;
        if (yVar != null) {
            try {
                ((c0) this.f37b).f432k.unregisterReceiver(yVar);
            } catch (IllegalArgumentException unused) {
            }
            this.f36a = null;
        }
    }

    public abstract IntentFilter w();

    public abstract int x();

    public abstract q7.c y();

    public MenuItem z(MenuItem menuItem) {
        if (!(menuItem instanceof e1.a)) {
            return menuItem;
        }
        e1.a aVar = (e1.a) menuItem;
        if (((m0.k) this.f37b) == null) {
            this.f37b = new m0.k();
        }
        MenuItem menuItem2 = (MenuItem) ((m0.k) this.f37b).getOrDefault(aVar, null);
        if (menuItem2 != null) {
            return menuItem2;
        }
        h.r rVar = new h.r((Context) this.f36a, aVar);
        ((m0.k) this.f37b).put(aVar, rVar);
        return rVar;
    }

    public h(int i3) {
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        this.f37b = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        c3.b bVar = new c3.b();
        bVar.f19592c = 1;
        bVar.f19593d = null;
        bVar.e = 0;
        bVar.f19594f = false;
        bVar.f19595g = false;
        bVar.f19597i = new int[16];
        bVar.f19598j = 0;
        bVar.f19599k = 0;
        bVar.f19600l = wb.a.f19589n.newEncoder();
        bVar.m(allocate);
        this.f36a = bVar;
    }

    public h(Context context) {
        this.f36a = context;
    }

    public h(CameraDevice cameraDevice, androidx.camera.camera2.internal.compat.k kVar) {
        cameraDevice.getClass();
        this.f36a = cameraDevice;
        this.f37b = kVar;
    }

    public h(sc.a aVar) {
        this.f36a = aVar;
        this.f37b = new com.google.zxing.oned.rss.expanded.decoders.b(aVar);
    }

    public h(Context context, Class cls) {
        this.f36a = context;
        this.f37b = cls;
    }

    public h(c0 c0Var) {
        this.f37b = c0Var;
    }
}
