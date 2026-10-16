package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.view.PreviewView;
import com.example.blesdk.bean.function.LocationInfoBean;
import com.example.network.base.HttpModel;
import com.example.network.bean.LocationServerInfoBean;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final /* synthetic */ class h0 implements n0.g, vg.g, t.e1, ia.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1409a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1410b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1411c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1412d;

    public /* synthetic */ h0(Object obj, int i3, Object obj2, Object obj3) {
        this.f1409a = i3;
        this.f1410b = obj;
        this.f1411c = obj2;
        this.f1412d = obj3;
    }

    public void a() {
        androidx.camera.view.a aVar;
        AtomicReference atomicReference = ((androidx.camera.view.d) this.f1410b).f1597a.f1572g;
        while (true) {
            aVar = (androidx.camera.view.a) this.f1411c;
            if (atomicReference.compareAndSet(aVar, null)) {
                aVar.b(PreviewView.StreamState.IDLE);
                break;
            } else if (atomicReference.get() != aVar) {
                break;
            }
        }
        x.d dVar = aVar.e;
        if (dVar != null) {
            dVar.cancel(false);
            aVar.e = null;
        }
        ((v) this.f1412d).l().d(aVar);
    }

    @Override // n0.g
    public Object b(androidx.concurrent.futures.b bVar) {
        switch (this.f1409a) {
            case 0:
                n0.i iVar = (n0.i) this.f1410b;
                androidx.activity.b bVar2 = new androidx.activity.b(iVar, 7);
                androidx.camera.core.impl.utils.executor.b bVar3 = (androidx.camera.core.impl.utils.executor.b) this.f1411c;
                n0.j jVar = bVar.f1607c;
                if (jVar != null) {
                    jVar.a(bVar2, bVar3);
                }
                iVar.a(new x.h(0, iVar, new i0(bVar, 0)), bVar3);
                return "surfaceList[" + ((List) this.f1412d) + "]";
            default:
                ((androidx.camera.view.a) this.f1410b).getClass();
                u uVar = (u) this.f1411c;
                h0.c cVar = new h0.c(bVar, uVar);
                ((ArrayList) this.f1412d).add(cVar);
                uVar.l(a6.a(), cVar);
                return "waitForCaptureResult";
        }
    }

    @Override // vg.g
    public void f(Object obj) {
        HttpModel httpModel = (HttpModel) obj;
        com.example.test.utils.s sVar = (com.example.test.utils.s) this.f1410b;
        sVar.getClass();
        if (!httpModel.isSuccess().booleanValue() || httpModel.getResults() == null) {
            sVar.c();
            return;
        }
        ((LocationServerInfoBean) httpModel.getResults()).setLat(((int) (Math.pow(10.0d, 6.0d) * Double.parseDouble((String) this.f1411c))) / Math.pow(10.0d, 6.0d));
        ((LocationServerInfoBean) httpModel.getResults()).setLng(((int) (Math.pow(10.0d, 6.0d) * Double.parseDouble((String) this.f1412d))) / Math.pow(10.0d, 6.0d));
        LocationServerInfoBean locationServerInfoBean = (LocationServerInfoBean) httpModel.getResults();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationInfoUtils", "同步位置到手表");
        LocationInfoBean locationInfoBean = new LocationInfoBean();
        locationInfoBean.setLat(locationServerInfoBean.getLat());
        locationInfoBean.setLng(locationServerInfoBean.getLng());
        locationInfoBean.setLocationInfo(locationServerInfoBean.getAddress());
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 54);
            return;
        }
        String locationInfo = locationInfoBean.getLocationInfo();
        if (locationInfo == null || locationInfo.length() == 0) {
            x5.b.I0().G0((byte) 54);
            return;
        }
        x5.d c9 = x5.d.c();
        byte[] n4 = y5.b.n(locationInfoBean.getLocationInfo());
        byte[] bArr = new byte[n4.length + 9];
        double lat = locationInfoBean.getLat();
        double d5 = PlaybackException.CUSTOM_ERROR_CODE_BASE;
        byte[] r = y5.b.r((long) (lat * d5));
        byte[] r8 = y5.b.r((long) (locationInfoBean.getLng() * d5));
        bArr[0] = r8[3];
        bArr[1] = r8[2];
        bArr[2] = r8[1];
        bArr[3] = r8[0];
        bArr[4] = r[3];
        bArr[5] = r[2];
        bArr[6] = r[1];
        bArr[7] = r[0];
        bArr[8] = (byte) (n4.length & 255);
        System.arraycopy(n4, 0, bArr, 9, n4.length);
        c9.j((byte) 54, bArr);
    }

    @Override // t.e1
    public void g(t.l lVar) {
        h0.e eVar;
        androidx.camera.view.d dVar = (androidx.camera.view.d) this.f1410b;
        dVar.getClass();
        com.google.android.gms.internal.mlkit_vision_common.a0.a("PreviewView", "Preview transformation info updated. " + lVar);
        boolean z5 = ((v) this.f1411c).h().b() == 0;
        PreviewView previewView = dVar.f1597a;
        Size size = ((t.f1) this.f1412d).f18320b;
        androidx.camera.view.c cVar = previewView.f1570d;
        cVar.getClass();
        com.google.android.gms.internal.mlkit_vision_common.a0.a("PreviewTransform", "Transformation info set: " + lVar + " " + size + " " + z5);
        cVar.f1591b = lVar.f18354a;
        cVar.f1592c = lVar.f18355b;
        int i3 = lVar.f18356c;
        cVar.e = i3;
        cVar.f1590a = size;
        cVar.f1594f = z5;
        cVar.f1595g = lVar.f18357d;
        cVar.f1593d = lVar.e;
        if (i3 == -1 || ((eVar = previewView.f1568b) != null && (eVar instanceof h0.j))) {
            previewView.e = true;
        } else {
            previewView.e = false;
        }
        previewView.a();
    }

    @Override // ia.c
    public void w(Exception exc) {
        ((ConcurrentLinkedQueue) ((de.o) this.f1410b).f12377b).add((byte[]) this.f1411c);
        ((fe.d) ((com.example.test.ui.device.activity.i0) this.f1412d).f7866b).f13588m.i(null);
    }

    public /* synthetic */ h0(n0.i iVar, androidx.camera.core.impl.utils.executor.b bVar, List list) {
        this.f1409a = 0;
        this.f1410b = iVar;
        this.f1411c = bVar;
        this.f1412d = list;
    }
}
