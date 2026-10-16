package x;

import a2.m;
import android.app.job.JobParameters;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.widget.b0;
import androidx.camera.core.impl.y0;
import androidx.recyclerview.widget.o;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.R$string;
import com.example.test.ui.device.activity.TakePhotoActivity;
import com.example.test.ui.device.activity.f0;
import com.example.test.ui.device.activity.g0;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.internal.mlkit_vision_barcode.ac;
import com.google.android.gms.internal.mlkit_vision_barcode.ag;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.u0;
import com.google.android.gms.internal.mlkit_vision_barcode.wf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_common.i0;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.material.textfield.p;
import com.google.mlkit.common.MlKitException;
import com.jieli.jl_bt_ota.tool.DataInfoCache;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.markers.MarkerLayout;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import f6.q2;
import ff.n;
import ff.q;
import java.io.FileOutputStream;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19704a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19705b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f19706c;

    public /* synthetic */ h(int i3, Object obj, Object obj2) {
        this.f19704a = i3;
        this.f19705b = obj;
        this.f19706c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int max;
        int i3;
        int i10 = 0;
        switch (this.f19704a) {
            case 0:
                c cVar = (c) this.f19706c;
                try {
                    cVar.onSuccess(i.a((ob.a) this.f19705b));
                    return;
                } catch (Error e) {
                    e = e;
                    cVar.C(e);
                    return;
                } catch (RuntimeException e10) {
                    e = e10;
                    cVar.C(e);
                    return;
                } catch (ExecutionException e11) {
                    Throwable cause = e11.getCause();
                    if (cause == null) {
                        cVar.C(e11);
                        return;
                    } else {
                        cVar.C(cause);
                        return;
                    }
                }
            case 1:
                a2.b bVar = (a2.b) this.f19706c;
                a2.c cVar2 = (a2.c) bVar.f13f;
                if (cVar2.f19g == bVar.f10b) {
                    a2.k kVar = (a2.k) bVar.e;
                    a2.k kVar2 = (a2.k) bVar.f12d;
                    int i11 = ((a2.k) bVar.f11c).e;
                    a2.k kVar3 = cVar2.f18f;
                    if (kVar3 == null || cVar2.e != null) {
                        throw new IllegalStateException("must be in snapshot state to apply diff");
                    }
                    cVar2.e = kVar;
                    cVar2.f18f = null;
                    m mVar = kVar3.f55d;
                    int c9 = mVar.c();
                    m mVar2 = kVar.f55d;
                    int c10 = mVar2.c();
                    int a3 = mVar.a();
                    int a10 = mVar2.a();
                    o oVar = (o) this.f19705b;
                    androidx.recyclerview.widget.b bVar2 = cVar2.f14a;
                    if (c9 == 0 && c10 == 0 && a3 == 0 && a10 == 0) {
                        oVar.a(bVar2);
                    } else {
                        if (c9 > c10) {
                            int i12 = c9 - c10;
                            bVar2.onRemoved(mVar.size() - i12, i12);
                        } else if (c9 < c10) {
                            bVar2.onInserted(mVar.size(), c10 - c9);
                        }
                        if (a3 > a10) {
                            bVar2.onRemoved(0, a3 - a10);
                        } else if (a3 < a10) {
                            bVar2.onInserted(0, a10 - a3);
                        }
                        if (a10 != 0) {
                            oVar.a(new d6.a(a10, bVar2));
                        } else {
                            oVar.a(bVar2);
                        }
                    }
                    kVar.a(kVar2, cVar2.f20h);
                    if (!cVar2.e.isEmpty()) {
                        int a11 = mVar.a();
                        int i13 = i11 - a11;
                        int size = (mVar.size() - a11) - mVar.c();
                        m mVar3 = kVar2.f55d;
                        if (i13 >= 0 && i13 < size) {
                            for (int i14 = 0; i14 < 30; i14++) {
                                int i15 = ((i14 / 2) * (i14 % 2 == 1 ? -1 : 1)) + i13;
                                if (i15 >= 0 && i15 < mVar.f67f) {
                                    try {
                                        i3 = oVar.e;
                                    } catch (IndexOutOfBoundsException unused) {
                                    }
                                    if (i15 < 0 || i15 >= i3) {
                                        throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i15 + ", old list size = " + i3);
                                    }
                                    int i16 = oVar.f2681b[i15];
                                    int i17 = (i16 & 15) == 0 ? -1 : i16 >> 4;
                                    if (i17 != -1) {
                                        max = i17 + mVar3.f63a;
                                        a2.k kVar4 = cVar2.e;
                                        kVar4.i(Math.max(0, Math.min(kVar4.f55d.size() - 1, max)));
                                    }
                                }
                            }
                        }
                        max = Math.max(0, Math.min(i11, mVar3.size() - 1));
                        a2.k kVar42 = cVar2.e;
                        kVar42.i(Math.max(0, Math.min(kVar42.f55d.size() - 1, max)));
                    }
                    cVar2.a();
                    return;
                }
                return;
            case 2:
                ((a2.d) ((a2.g) this.f19706c).f33b).o((a2.j) this.f19705b);
                return;
            case 3:
                synchronized (((ConstraintTrackingWorker) this.f19706c).f3033g) {
                    if (((ConstraintTrackingWorker) this.f19706c).f3034h) {
                        ((ConstraintTrackingWorker) this.f19706c).f3035i.j(new o2.j());
                    } else {
                        ((ConstraintTrackingWorker) this.f19706c).f3035i.l((ob.a) this.f19705b);
                    }
                }
                return;
            case 4:
                ((EditText) this.f19705b).removeTextChangedListener(((com.google.android.material.textfield.e) ((com.google.android.material.textfield.b) this.f19706c).f10890b).f10895d);
                return;
            case 5:
                boolean isPopupShowing = ((AutoCompleteTextView) this.f19705b).isPopupShowing();
                com.google.android.material.textfield.h hVar = (com.google.android.material.textfield.h) this.f19706c;
                ((com.google.android.material.textfield.l) hVar.f10905b).g(isPopupShowing);
                ((com.google.android.material.textfield.l) hVar.f10905b).f10913i = isPopupShowing;
                return;
            case 6:
                ((AutoCompleteTextView) this.f19705b).removeTextChangedListener(((com.google.android.material.textfield.l) ((com.google.android.material.textfield.b) this.f19706c).f10890b).f10909d);
                return;
            case 7:
                ((EditText) this.f19705b).removeTextChangedListener(((p) ((com.google.android.material.textfield.b) this.f19706c).f10890b).f10947d);
                return;
            case 8:
                ArrayList arrayList = (ArrayList) this.f19705b;
                if (arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                de.l lVar = (de.l) this.f19706c;
                ArrayList arrayList2 = new ArrayList(arrayList);
                int size2 = arrayList2.size();
                while (i10 < size2) {
                    Object obj = arrayList2.get(i10);
                    i10++;
                    lVar.k(obj);
                }
                return;
            case 9:
                ud.a aVar = (ud.a) this.f19705b;
                vd.a aVar2 = aVar.f19050c;
                de.i iVar = (de.i) this.f19706c;
                ee.c.b(4, (String) iVar.f12357b, "send data timeout  --> opCode : " + aVar2.f19220c + ", sn : " + aVar2.f19222f + ", resend Count : " + aVar.f19053g);
                int i18 = aVar.f19053g;
                if (i18 < 3) {
                    aVar.f19053g = i18 + 1;
                    ((DataInfoCache) iVar.e).remove(aVar);
                    iVar.c(aVar);
                    return;
                } else {
                    ((DataInfoCache) iVar.e).remove(aVar);
                    ((k6.b) iVar.f12358c).h(aVar.f19052f, aVar.f19050c);
                    iVar.a(aVar, i0.a(12295));
                    return;
                }
            case 10:
                ef.i iVar2 = (ef.i) this.f19706c;
                ef.b bVar3 = (ef.b) iVar2.f12629b;
                pf.b bVar4 = (pf.b) this.f19705b;
                bVar3.b(0, "dispatchFrame: executing. Passing", Long.valueOf(bVar4.a()), "to processors.");
                Iterator it = ((CameraView) iVar2.f12630c).f11558s.iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    try {
                        throw null;
                        break;
                    } catch (Exception e12) {
                        ((ef.b) iVar2.f12629b).b(2, "Frame processor crashed:", e12);
                    }
                }
                bVar4.b();
                return;
            case 11:
                Iterator it2 = ((CameraView) ((ef.i) this.f19706c).f12630c).r.iterator();
                while (it2.hasNext()) {
                    ((g0) it2.next()).getClass();
                    ef.c options = (ef.c) this.f19705b;
                    kotlin.jvm.internal.e.f(options, "options");
                    Log.e("qob", "TakePhotoActivity onCameraOpened");
                }
                return;
            case 12:
                f0 f0Var = new f0((y0) this.f19705b);
                Iterator it3 = ((CameraView) ((ef.i) this.f19706c).f12630c).r.iterator();
                while (it3.hasNext()) {
                    g0 g0Var = (g0) it3.next();
                    g0Var.getClass();
                    Log.e("qob", "TakePhotoActivity onPictureTaken " + f0Var);
                    int i19 = TakePhotoActivity.I;
                    TakePhotoActivity takePhotoActivity = g0Var.f7861a;
                    ((q2) takePhotoActivity.f7247z.getValue()).f13261c.f11555o.getClass();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (takePhotoActivity.H == 0) {
                        takePhotoActivity.H = currentTimeMillis - 300;
                    }
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "onPictureTaken called! Launching activity. Delay:", Long.valueOf(currentTimeMillis - takePhotoActivity.H));
                    try {
                        String str = Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera/" + System.currentTimeMillis() + ".jpg";
                        FileOutputStream fileOutputStream = new FileOutputStream(str);
                        fileOutputStream.write((byte[]) f0Var.f7859b);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        takePhotoActivity.S0(str);
                    } catch (Throwable th2) {
                        takePhotoActivity.w0(R$string.str_save_fail);
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("保存相片失败：", th2.getMessage()));
                    }
                    takePhotoActivity.H = 0L;
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "onPictureTaken called! Launched activity.");
                }
                return;
            case 13:
                ef.i iVar3 = (ef.i) this.f19706c;
                MarkerLayout markerLayout = ((CameraView) iVar3.f12630c).f11564y;
                PointF[] pointFArr = {(PointF) this.f19705b};
                View view = (View) markerLayout.f11616a.get(1);
                if (view != null) {
                    view.clearAnimation();
                    PointF pointF = pointFArr[0];
                    float width = (int) (pointF.x - (view.getWidth() / 2));
                    float height = (int) (pointF.y - (view.getHeight() / 2));
                    view.setTranslationX(width);
                    view.setTranslationY(height);
                }
                CameraView cameraView = (CameraView) iVar3.f12630c;
                cameraView.getClass();
                Iterator it4 = cameraView.r.iterator();
                while (it4.hasNext()) {
                    ((g0) it4.next()).getClass();
                }
                return;
            case 14:
                int i20 = JobInfoSchedulerService.f8840a;
                ((JobInfoSchedulerService) this.f19705b).jobFinished((JobParameters) this.f19706c, false);
                return;
            case 15:
                ff.e eVar = (ff.e) this.f19706c;
                Camera.Parameters parameters = eVar.V.getParameters();
                if (eVar.V(parameters, (Flash) this.f19705b)) {
                    eVar.V.setParameters(parameters);
                    return;
                }
                return;
            case 16:
                ff.e eVar2 = (ff.e) this.f19706c;
                Camera.Parameters parameters2 = eVar2.V.getParameters();
                if (eVar2.a0(parameters2, (WhiteBalance) this.f19705b)) {
                    eVar2.V.setParameters(parameters2);
                    return;
                }
                return;
            case 17:
                ff.e eVar3 = (ff.e) this.f19706c;
                Camera.Parameters parameters3 = eVar3.V.getParameters();
                if (eVar3.W(parameters3, (Hdr) this.f19705b)) {
                    eVar3.V.setParameters(parameters3);
                    return;
                }
                return;
            case 18:
                n nVar = (n) this.f19706c;
                if (nVar.a0(nVar.Z, (WhiteBalance) this.f19705b)) {
                    nVar.Y();
                    return;
                }
                return;
            case 19:
                n nVar2 = (n) this.f19706c;
                if (nVar2.W(nVar2.Z, (Hdr) this.f19705b)) {
                    nVar2.Y();
                    return;
                }
                return;
            case 20:
                Throwable th3 = (Throwable) this.f19705b;
                boolean z5 = th3 instanceof CameraException;
                q qVar = (q) this.f19706c;
                if (z5) {
                    CameraException cameraException = (CameraException) th3;
                    if (cameraException.isUnrecoverable()) {
                        q.T.b(3, "EXCEPTION:", "Got CameraException. Since it is unrecoverable, executing destroy(false).");
                        qVar.f(0, false);
                    }
                    q.T.b(3, "EXCEPTION:", "Got CameraException. Dispatching to callback.");
                    qVar.f13647c.l(cameraException);
                    return;
                }
                ef.b bVar5 = q.T;
                bVar5.b(3, "EXCEPTION:", "Unexpected error! Executing destroy(true).");
                qVar.f(0, true);
                bVar5.b(3, "EXCEPTION:", "Unexpected error! Throwing.");
                if (!(th3 instanceof RuntimeException)) {
                    throw new RuntimeException(th3);
                }
                throw ((RuntimeException) th3);
            case 21:
                ReferenceQueue referenceQueue = (ReferenceQueue) this.f19705b;
                while (!((Set) this.f19706c).isEmpty()) {
                    try {
                        gc.i iVar4 = (gc.i) referenceQueue.remove();
                        if (iVar4.f14039a.remove(iVar4)) {
                            iVar4.clear();
                            iVar4.f14040b.getClass();
                        }
                    } catch (InterruptedException unused2) {
                    }
                }
                return;
            case 22:
                Callable callable = (Callable) this.f19705b;
                ia.g gVar = (ia.g) this.f19706c;
                ia.m mVar4 = gVar.f14382a;
                try {
                    gVar.a(callable.call());
                    return;
                } catch (MlKitException e13) {
                    mVar4.g(e13);
                    return;
                } catch (Exception e14) {
                    mVar4.g(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e14));
                    return;
                }
            case 23:
                mc.e eVar4 = (mc.e) this.f19705b;
                ia.g gVar2 = (ia.g) this.f19706c;
                int decrementAndGet = eVar4.f16014b.decrementAndGet();
                if (decrementAndGet < 0) {
                    throw new IllegalStateException();
                }
                if (decrementAndGet == 0) {
                    synchronized (eVar4) {
                        try {
                            eVar4.e.d();
                            mc.e.f16012j = true;
                            n.g0 g0Var2 = new n.g0();
                            zzra zzraVar = eVar4.f16020i ? zzra.TYPE_THICK : zzra.TYPE_THIN;
                            ag agVar = eVar4.f16017f;
                            g0Var2.f16176c = zzraVar;
                            u0 u0Var = new u0();
                            u0Var.f9539c = mc.a.a(eVar4.f16016d);
                            g0Var2.f16177d = new ac(u0Var);
                            com.google.mlkit.common.sdkinternal.a.c().execute(new wf((Object) agVar, (Object) new b0(g0Var2, 0), (Enum) zzrc.ON_DEVICE_BARCODE_CLOSE, agVar.c(), 0));
                        } finally {
                        }
                    }
                    eVar4.f16015c.set(false);
                }
                com.google.android.gms.internal.mlkit_common.g.f9173a.clear();
                com.google.android.gms.internal.mlkit_common.n.f9182a.clear();
                gVar2.a(null);
                return;
            case 24:
                a2.g gVar3 = (a2.g) this.f19705b;
                AtomicReference atomicReference = (AtomicReference) gVar3.f35d;
                if (((Thread) atomicReference.getAndSet(Thread.currentThread())) != null) {
                    throw new IllegalStateException();
                }
                try {
                    ((Runnable) this.f19706c).run();
                    atomicReference.set(null);
                    gVar3.k();
                    return;
                } finally {
                }
            case 25:
                b1.b bVar6 = (b1.b) ((y2.f) this.f19705b).f19953b;
                if (bVar6 != null) {
                    bVar6.e((Typeface) this.f19706c);
                    return;
                }
                return;
            case 26:
                ((c0.g) this.f19705b).f(this.f19706c);
                return;
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                if (((i6.g) this.f19705b) == null) {
                    return;
                }
                ef.i iVar5 = (ef.i) this.f19706c;
                if (((ArrayList) iVar5.f12629b).isEmpty()) {
                    return;
                }
                ArrayList arrayList3 = new ArrayList((ArrayList) iVar5.f12629b);
                int size3 = arrayList3.size();
                while (i10 < size3) {
                    Object obj2 = arrayList3.get(i10);
                    i10++;
                    r5.a.i(obj2);
                }
                return;
            case Const.ANDROID_VERSION_28 /* 28 */:
                ArrayList arrayList4 = (ArrayList) this.f19705b;
                if (arrayList4.isEmpty()) {
                    return;
                }
                i6.h hVar2 = (i6.h) this.f19706c;
                ArrayList arrayList5 = new ArrayList();
                arrayList5.addAll(arrayList4);
                int size4 = arrayList5.size();
                while (i10 < size4) {
                    Object obj3 = arrayList5.get(i10);
                    i10++;
                    hVar2.j(obj3);
                }
                return;
            default:
                ia.i iVar6 = (ia.i) this.f19706c;
                try {
                    n6.a aVar3 = (n6.a) iVar6.f14387c;
                    ia.f fVar = (ia.f) this.f19705b;
                    boolean f2 = fVar.f();
                    nf.c cVar3 = (nf.c) aVar3.f16381b;
                    if (f2 || cVar3.e) {
                        cVar3.f16604f.e = cVar3.f16602c;
                    }
                    w.a aVar4 = ia.h.f14384b;
                    fVar.b(aVar4, iVar6);
                    fVar.a(aVar4, iVar6);
                    ia.m mVar5 = (ia.m) fVar;
                    mVar5.f14399b.f(new ia.i(aVar4, (ia.a) iVar6));
                    mVar5.k();
                    return;
                } catch (RuntimeExecutionException e15) {
                    if (e15.getCause() instanceof Exception) {
                        ((ia.m) iVar6.f14388d).g((Exception) e15.getCause());
                        return;
                    } else {
                        ((ia.m) iVar6.f14388d).g(e15);
                        return;
                    }
                } catch (Exception e16) {
                    ((ia.m) iVar6.f14388d).g(e16);
                    return;
                }
        }
    }

    public String toString() {
        switch (this.f19704a) {
            case 0:
                return h.class.getSimpleName() + Const.STR_MART_COMMA + ((c) this.f19706c);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ h(Object obj, int i3, Object obj2, boolean z5) {
        this.f19704a = i3;
        this.f19706c = obj;
        this.f19705b = obj2;
    }

    public h(de.i iVar, ud.a aVar) {
        this.f19704a = 9;
        this.f19706c = iVar;
        this.f19705b = aVar;
        aVar.f19054h = System.currentTimeMillis();
    }

    public h(ArrayList callbacks, i6.h hVar) {
        this.f19704a = 28;
        kotlin.jvm.internal.e.f(callbacks, "callbacks");
        this.f19705b = callbacks;
        this.f19706c = hVar;
    }

    public h(ef.i iVar, PointF pointF, Gesture gesture) {
        this.f19704a = 13;
        this.f19706c = iVar;
        this.f19705b = pointF;
    }
}
