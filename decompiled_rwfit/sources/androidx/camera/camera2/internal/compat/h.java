package androidx.camera.camera2.internal.compat;

import android.bluetooth.BluetoothDevice;
import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.c0;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.h0;
import androidx.camera.core.impl.u0;
import androidx.camera.core.impl.x0;
import androidx.lifecycle.b0;
import com.example.test.utils.s0;
import com.google.android.gms.internal.mlkit_vision_barcode.p0;
import com.google.android.gms.internal.mlkit_vision_barcode.q0;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.jieli.bmp_convert.BmpConvert;
import com.jieli.bmp_convert.OnConvertListener;
import com.jieli.jl_bt_ota.impl.RcspAuth;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import n.d0;
import n.v0;
import n.w0;
import t.f1;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1169a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1170b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1171c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1172d;

    public /* synthetic */ h(c0.f fVar, t.t tVar, androidx.concurrent.futures.b bVar) {
        this.f1169a = 4;
        Map map = Collections.EMPTY_MAP;
        this.f1170b = fVar;
        this.f1171c = tVar;
        this.f1172d = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v71, types: [n.a0, n.g] */
    @Override // java.lang.Runnable
    public final void run() {
        Rational rational;
        final long v6;
        y.b e;
        switch (this.f1169a) {
            case 0:
                ((CameraCaptureSession.StateCallback) ((i) this.f1170b).f1174b).onSurfacePrepared((CameraCaptureSession) this.f1171c, (Surface) this.f1172d);
                return;
            case 1:
                b0 b0Var = (b0) ((ef.i) this.f1170b).f12629b;
                u0 u0Var = (u0) this.f1171c;
                if (u0Var != null) {
                    b0Var.j(u0Var);
                }
                b0Var.f((u0) this.f1172d);
                return;
            case 2:
                a8.c cVar = (a8.c) this.f1170b;
                q0 q0Var = (q0) this.f1171c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f1172d;
                cVar.getClass();
                try {
                    androidx.emoji2.text.q a3 = p0.a(cVar.f123a);
                    if (a3 == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    androidx.emoji2.text.p pVar = (androidx.emoji2.text.p) ((androidx.emoji2.text.j) a3.f2030b);
                    synchronized (pVar.f2059d) {
                        pVar.f2060f = threadPoolExecutor;
                    }
                    ((androidx.emoji2.text.j) a3.f2030b).a(new androidx.emoji2.text.l(q0Var, threadPoolExecutor));
                    return;
                } catch (Throwable th2) {
                    q0Var.a(th2);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 3:
                if (((c0.f) this.f1170b).f3299j) {
                    ((Runnable) this.f1171c).run();
                    return;
                } else {
                    ((Runnable) this.f1172d).run();
                    return;
                }
            case 4:
                t.t tVar = (t.t) this.f1171c;
                Map map = Collections.EMPTY_MAP;
                androidx.concurrent.futures.b bVar = (androidx.concurrent.futures.b) this.f1172d;
                c0.f fVar = (c0.f) this.f1170b;
                fVar.getClass();
                try {
                    fVar.f3291a.e(tVar);
                    bVar.a(null);
                    return;
                } catch (RuntimeException e10) {
                    bVar.b(e10);
                    return;
                }
            case 5:
                ((de.o) this.f1170b).j((c0.n) this.f1171c, (Map.Entry) this.f1172d);
                return;
            case 6:
                ((BmpConvert) this.f1170b).a((OnConvertListener) this.f1171c, (String) this.f1172d);
                return;
            case 7:
                t.t tVar2 = (t.t) this.f1171c;
                Map map2 = Collections.EMPTY_MAP;
                androidx.concurrent.futures.b bVar2 = (androidx.concurrent.futures.b) this.f1172d;
                d0.e eVar = (d0.e) this.f1170b;
                eVar.getClass();
                try {
                    eVar.f12188a.e(tVar2);
                    bVar2.a(null);
                    return;
                } catch (RuntimeException e11) {
                    bVar2.b(e11);
                    return;
                }
            case 8:
                if (((d0.e) this.f1170b).f12192f) {
                    ((Runnable) this.f1171c).run();
                    return;
                } else {
                    ((Runnable) this.f1172d).run();
                    return;
                }
            case 9:
                de.i iVar = (de.i) this.f1170b;
                iVar.getClass();
                rd.a aVar = ((ud.a) this.f1171c).e;
                androidx.recyclerview.widget.x xVar = (androidx.recyclerview.widget.x) this.f1172d;
                if (aVar != null) {
                    aVar.m(xVar);
                }
                ((k6.b) iVar.f12358c).e(xVar);
                return;
            case 10:
                h0.i iVar2 = ((h0.j) this.f1170b).f14238f;
                iVar2.a();
                boolean z5 = iVar2.f14236g;
                f1 f1Var = (f1) this.f1171c;
                if (z5) {
                    iVar2.f14236g = false;
                    f1Var.c();
                    f1Var.f18326i.a(null);
                    return;
                }
                iVar2.f14232b = f1Var;
                iVar2.f14234d = (h0) this.f1172d;
                Size size = f1Var.f18320b;
                iVar2.f14231a = size;
                iVar2.f14235f = false;
                if (iVar2.b()) {
                    return;
                }
                a0.a("SurfaceViewImpl", "Wait for new Surface creation.");
                iVar2.f14237h.e.getHolder().setFixedSize(size.getWidth(), size.getHeight());
                return;
            case 11:
                h0.c cVar2 = ((n.h) this.f1170b).f16199x;
                HashSet hashSet = (HashSet) cVar2.f14217b;
                androidx.camera.core.impl.k kVar = (androidx.camera.core.impl.k) this.f1172d;
                hashSet.add(kVar);
                ((ArrayMap) cVar2.f14218c).put(kVar, (Executor) this.f1171c);
                return;
            case 12:
                final d0 d0Var = (d0) this.f1170b;
                androidx.concurrent.futures.b bVar3 = (androidx.concurrent.futures.b) this.f1171c;
                t.v vVar = (t.v) this.f1172d;
                if (!d0Var.f16154d) {
                    bVar3.b(new CameraControl$OperationCanceledException("Camera is not active."));
                    return;
                }
                Rect c9 = ((n.u0) d0Var.f16151a.f16185i.f16310f).c();
                if (d0Var.e != null) {
                    rational = d0Var.e;
                } else {
                    Rect c10 = ((n.u0) d0Var.f16151a.f16185i.f16310f).c();
                    rational = new Rational(c10.width(), c10.height());
                }
                List list = vVar.f18418b;
                Integer num = (Integer) d0Var.f16151a.e.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                List b3 = d0Var.b(list, num == null ? 0 : num.intValue(), rational, c9, 1);
                List list2 = vVar.f18419c;
                Integer num2 = (Integer) d0Var.f16151a.e.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
                List b10 = d0Var.b(list2, num2 == null ? 0 : num2.intValue(), rational, c9, 2);
                List list3 = vVar.f18420d;
                Integer num3 = (Integer) d0Var.f16151a.e.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
                List b11 = d0Var.b(list3, num3 == null ? 0 : num3.intValue(), rational, c9, 4);
                if (b3.isEmpty() && b10.isEmpty() && b11.isEmpty()) {
                    bVar3.b(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera."));
                    return;
                }
                ((HashSet) d0Var.f16151a.f16179b.f1165c).remove(d0Var.f16163n);
                androidx.concurrent.futures.b bVar4 = d0Var.r;
                if (bVar4 != null) {
                    bVar4.b(new CameraControl$OperationCanceledException("Cancelled by another startFocusAndMetering()"));
                    d0Var.r = null;
                }
                ((HashSet) d0Var.f16151a.f16179b.f1165c).remove(null);
                ScheduledFuture scheduledFuture = d0Var.f16158i;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    d0Var.f16158i = null;
                }
                d0Var.r = bVar3;
                MeteringRectangle[] meteringRectangleArr = d0.f16150t;
                MeteringRectangle[] meteringRectangleArr2 = (MeteringRectangle[]) b3.toArray(meteringRectangleArr);
                MeteringRectangle[] meteringRectangleArr3 = (MeteringRectangle[]) b10.toArray(meteringRectangleArr);
                MeteringRectangle[] meteringRectangleArr4 = (MeteringRectangle[]) b11.toArray(meteringRectangleArr);
                n.a0 a0Var = d0Var.f16163n;
                n.h hVar = d0Var.f16151a;
                ((HashSet) hVar.f16179b.f1165c).remove(a0Var);
                ScheduledFuture scheduledFuture2 = d0Var.f16158i;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(true);
                    d0Var.f16158i = null;
                }
                ScheduledFuture scheduledFuture3 = d0Var.f16159j;
                if (scheduledFuture3 != null) {
                    scheduledFuture3.cancel(true);
                    d0Var.f16159j = null;
                }
                d0Var.f16164o = meteringRectangleArr2;
                d0Var.f16165p = meteringRectangleArr3;
                d0Var.f16166q = meteringRectangleArr4;
                if (meteringRectangleArr2.length > 0) {
                    d0Var.f16156g = true;
                    d0Var.f16161l = false;
                    v6 = hVar.v();
                    if (d0Var.f16154d) {
                        c0 c0Var = new c0();
                        c0Var.f1356c = d0Var.f16162m;
                        c0Var.e = true;
                        x0 f2 = x0.f();
                        f2.m(m.b.Y(CaptureRequest.CONTROL_AF_TRIGGER), 1);
                        f2.l(m.b.Y(CaptureRequest.CONTROL_AE_MODE), Config$OptionPriority.HIGH_PRIORITY_REQUIRED, Integer.valueOf(n.h.o(d0Var.f16151a.e, 1)));
                        c0Var.c(new m.b(d1.a(f2), 12));
                        c0Var.b(new n.c0());
                        d0Var.f16151a.u(Collections.singletonList(c0Var.d()));
                    }
                } else {
                    d0Var.f16156g = false;
                    d0Var.f16161l = true;
                    v6 = hVar.v();
                }
                d0Var.f16157h = 0;
                final boolean z6 = hVar.p(1) == 1;
                ?? r02 = new n.g() { // from class: n.a0
                    @Override // n.g
                    public final boolean a(TotalCaptureResult totalCaptureResult) {
                        d0 d0Var2 = d0.this;
                        d0Var2.getClass();
                        Integer num4 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                        if (d0Var2.f16164o.length > 0) {
                            if (!z6 || num4 == null) {
                                d0Var2.f16161l = true;
                            } else if (d0Var2.f16157h.intValue() == 3) {
                                if (num4.intValue() == 4) {
                                    d0Var2.f16161l = true;
                                } else if (num4.intValue() == 5) {
                                    d0Var2.f16161l = true;
                                }
                            }
                        }
                        if (!d0Var2.f16161l || !h.s(totalCaptureResult, v6)) {
                            if (!d0Var2.f16157h.equals(num4) && num4 != null) {
                                d0Var2.f16157h = num4;
                            }
                            return false;
                        }
                        ScheduledFuture scheduledFuture4 = d0Var2.f16159j;
                        if (scheduledFuture4 != null) {
                            scheduledFuture4.cancel(true);
                            d0Var2.f16159j = null;
                        }
                        androidx.concurrent.futures.b bVar5 = d0Var2.r;
                        if (bVar5 != null) {
                            bVar5.a(new t.r0());
                            d0Var2.r = null;
                        }
                        return true;
                    }
                };
                d0Var.f16163n = r02;
                hVar.k(r02);
                long j4 = d0Var.f16160k + 1;
                d0Var.f16160k = j4;
                n.b0 b0Var2 = new n.b0(d0Var, j4, 0);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                w.c cVar3 = d0Var.f16153c;
                d0Var.f16159j = cVar3.schedule(b0Var2, 5000L, timeUnit);
                long j10 = vVar.f18417a;
                if (j10 > 0) {
                    d0Var.f16158i = cVar3.schedule(new n.b0(d0Var, j4, 1), j10, timeUnit);
                    return;
                }
                return;
            case 13:
                v0 v0Var = (v0) this.f1170b;
                androidx.concurrent.futures.b bVar5 = (androidx.concurrent.futures.b) this.f1171c;
                y.b bVar6 = (y.b) this.f1172d;
                if (v0Var.f16306a) {
                    ((n.u0) v0Var.f16310f).b(bVar6.f19831a, bVar5);
                    ((n.h) v0Var.f16307b).v();
                    return;
                }
                synchronized (((w0) v0Var.f16309d)) {
                    ((w0) v0Var.f16309d).e(1.0f);
                    e = y.b.e((w0) v0Var.f16309d);
                }
                v0Var.d(e);
                bVar5.b(new CameraControl$OperationCanceledException("Camera is not active."));
                return;
            case 14:
                s0 s0Var = (s0) this.f1170b;
                s0Var.getClass();
                Log.d("RequestMonitor", "RequestListener " + ((f) this.f1171c) + " done " + s0Var);
                ((List) s0Var.f8757b).remove((n0.i) this.f1172d);
                return;
            case 15:
                k6.b bVar7 = (k6.b) this.f1170b;
                File file = (File) this.f1171c;
                BluetoothDevice bluetoothDevice = (BluetoothDevice) this.f1172d;
                try {
                    bVar7.G = new RandomAccessFile(file, "r");
                    bVar7.I(bluetoothDevice);
                    return;
                } catch (Exception e12) {
                    e12.printStackTrace();
                    bVar7.M.post(new qd.c(bVar7, 3));
                    return;
                }
            default:
                ((RcspAuth) this.f1170b).lambda$startAuth$0((BluetoothDevice) this.f1171c, (qd.j) this.f1172d);
                return;
        }
    }

    public /* synthetic */ h(d0.e eVar, t.t tVar, androidx.concurrent.futures.b bVar) {
        this.f1169a = 7;
        Map map = Collections.EMPTY_MAP;
        this.f1170b = eVar;
        this.f1171c = tVar;
        this.f1172d = bVar;
    }

    public /* synthetic */ h(Object obj, int i3, Object obj2, Object obj3) {
        this.f1169a = i3;
        this.f1170b = obj;
        this.f1171c = obj2;
        this.f1172d = obj3;
    }
}
