package ef;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.Surface;
import android.widget.ImageView;
import androidx.appcompat.app.i0;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.k;
import androidx.camera.camera2.internal.compat.p;
import androidx.camera.camera2.internal.compat.t;
import androidx.camera.camera2.internal.m;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.impl.a1;
import androidx.camera.core.impl.b1;
import androidx.camera.core.impl.u0;
import androidx.lifecycle.b0;
import androidx.recyclerview.widget.j2;
import androidx.recyclerview.widget.x;
import be.j;
import c0.o;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.database.table.Devices;
import com.example.network.bean.FirmwareInfoBean;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.presenter.device.s;
import com.example.test.service.k0;
import com.example.test.service.l0;
import com.example.test.service.p0;
import com.example.test.ui.device.activity.CustomJLDialActivity;
import com.example.test.ui.device.activity.e0;
import com.example.test.ui.device.activity.f0;
import com.example.test.ui.main.fragment.HeadsetFragment;
import com.example.test.ui.sport.activity.SportCountDownNewActivity;
import com.example.test.ui.view.r;
import com.example.test.utils.w0;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.c1;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.m1;
import com.google.android.gms.internal.mlkit_vision_barcode.tb;
import com.google.android.gms.internal.mlkit_vision_barcode.u1;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.gms.internal.mlkit_vision_common.na;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.gesture.Gesture;
import f6.u;
import g4.n;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public class i implements b1, x.c, com.example.test.utils.b, rd.b, r, rd.a, n, com.dh.imagepick.preview.widgets.d, vh.c {

    /* renamed from: d, reason: collision with root package name */
    public static i f12627d;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12628a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12629b;

    /* renamed from: c, reason: collision with root package name */
    public Object f12630c;

    public /* synthetic */ i(int i3, Object obj, Object obj2) {
        this.f12628a = i3;
        this.f12629b = obj;
        this.f12630c = obj2;
    }

    private final void F(Throwable th2) {
    }

    public static i y() {
        if (f12627d == null) {
            f12627d = new i(12, false);
        }
        return f12627d;
    }

    public boolean A() {
        return ((int[]) this.f12630c)[0] == 0;
    }

    public i B(int i3) {
        gd.a aVar = (gd.a) this.f12629b;
        if (i3 == 0) {
            return aVar.f14052c;
        }
        if (i3 == 1) {
            return this;
        }
        int[] iArr = (int[]) this.f12630c;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr2[i10] = aVar.c(iArr[i10], i3);
        }
        return new i(aVar, iArr2);
    }

    @Override // x.c
    public void C(Throwable th2) {
        switch (this.f12628a) {
            case 5:
                ((androidx.concurrent.futures.b) this.f12629b).b(th2);
                return;
            case 8:
                int i3 = ((c0.n) this.f12629b).f3333f;
                if (i3 == 2 && (th2 instanceof CancellationException)) {
                    a0.a("SurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                    return;
                }
                a0.f("SurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + c1.a(i3), th2);
                return;
            case 26:
                return;
            default:
                throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th2);
        }
    }

    public i D(i iVar) {
        gd.a aVar = (gd.a) iVar.f12629b;
        gd.a aVar2 = (gd.a) this.f12629b;
        if (!aVar2.equals(aVar)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (A() || iVar.A()) {
            return aVar2.f14052c;
        }
        int[] iArr = (int[]) this.f12630c;
        int length = iArr.length;
        int[] iArr2 = (int[]) iVar.f12630c;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i3 = 0; i3 < length; i3++) {
            int i10 = iArr[i3];
            for (int i11 = 0; i11 < length2; i11++) {
                int i12 = i3 + i11;
                iArr3[i12] = aVar2.a(iArr3[i12], aVar2.c(i10, iArr2[i11]));
            }
        }
        return new i(aVar2, iArr3);
    }

    public void E() {
        CameraView cameraView = (CameraView) this.f12630c;
        wf.b j4 = cameraView.f11555o.j(Reference.VIEW);
        if (j4 == null) {
            throw new RuntimeException("Preview stream size should not be null here.");
        }
        boolean equals = j4.equals(cameraView.f11556p);
        b bVar = (b) this.f12629b;
        if (equals) {
            bVar.b(1, "onCameraPreviewStreamSizeChanged:", "swallowing because the preview size has not changed.", j4);
        } else {
            bVar.b(1, "onCameraPreviewStreamSizeChanged: posting a requestLayout call.", "Preview stream size:", j4);
            cameraView.f11550j.post(new h(this, 2, (byte) 0));
        }
    }

    public void G(i1.d dVar) {
        int i3 = dVar.f14339b;
        Handler handler = (Handler) this.f12630c;
        y2.f fVar = (y2.f) this.f12629b;
        if (i3 != 0) {
            handler.post(new androidx.emoji2.text.i(i3, 5, fVar));
        } else {
            handler.post(new x.h(25, fVar, dVar.f14338a));
        }
    }

    public void H(String str, androidx.camera.core.impl.utils.executor.b bVar, CameraDevice.StateCallback stateCallback) {
        bVar.getClass();
        stateCallback.getClass();
        try {
            ((CameraManager) this.f12629b).openCamera(str, new p(bVar, stateCallback), (Handler) ((y) this.f12630c).f8774c);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }

    public void I(androidx.camera.core.impl.utils.executor.b bVar, androidx.camera.camera2.internal.e eVar) {
        t tVar;
        y yVar = (y) this.f12630c;
        synchronized (((HashMap) yVar.f8773b)) {
            try {
                tVar = (t) ((HashMap) yVar.f8773b).get(eVar);
                if (tVar == null) {
                    tVar = new t(bVar, eVar);
                    ((HashMap) yVar.f8773b).put(eVar, tVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        ((CameraManager) this.f12629b).registerAvailabilityCallback(tVar, (Handler) yVar.f8774c);
    }

    public void J(String str) {
        b4.b bVar;
        synchronized (this) {
            try {
                Object obj = ((HashMap) this.f12629b).get(str);
                t4.f.c(obj, "Argument must not be null");
                bVar = (b4.b) obj;
                int i3 = bVar.f3147b;
                if (i3 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + bVar.f3147b);
                }
                int i10 = i3 - 1;
                bVar.f3147b = i10;
                if (i10 == 0) {
                    b4.b bVar2 = (b4.b) ((HashMap) this.f12629b).remove(str);
                    if (!bVar2.equals(bVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar + ", but actually removed: " + bVar2 + ", safeKey: " + str);
                    }
                    androidx.appcompat.app.t tVar = (androidx.appcompat.app.t) this.f12630c;
                    synchronized (((ArrayDeque) tVar.f568b)) {
                        if (((ArrayDeque) tVar.f568b).size() < 10) {
                            ((ArrayDeque) tVar.f568b).offer(bVar2);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        bVar.f3146a.unlock();
    }

    public void K(Messenger messenger, int i3, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.arg1 = 1;
        obtain.setData(bundle);
        obtain.replyTo = messenger;
        ((Messenger) this.f12629b).send(obtain);
    }

    public int L(CaptureRequest captureRequest, androidx.camera.core.impl.utils.executor.b bVar, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.f12629b).setRepeatingRequest(captureRequest, new androidx.camera.camera2.internal.compat.f(bVar, captureCallback), ((k) this.f12630c).f1176a);
    }

    public void M(long j4) {
        if (((Vibrator) this.f12629b) == null) {
            XXApplication xXApplication = XXApplication.f7400h;
            this.f12629b = (Vibrator) j1.a().getSystemService("vibrator");
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "VibratorUtils", "手机是否有震动器 " + ((Vibrator) this.f12629b).hasVibrator());
            if (!((Vibrator) this.f12629b).hasVibrator()) {
                return;
            }
        }
        ((Vibrator) this.f12629b).vibrate(VibrationEffect.createOneShot(j4, 255));
    }

    public void N() {
        MediaPlayer mediaPlayer = (MediaPlayer) this.f12630c;
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    ((MediaPlayer) this.f12630c).stop();
                    ((MediaPlayer) this.f12630c).release();
                }
                this.f12630c = null;
            } catch (Throwable th2) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "VibratorUtils", android.support.v4.media.session.e.p(th2, new StringBuilder("关闭铃声异常：")));
            }
        }
    }

    public i O(i iVar) {
        if (!((gd.a) this.f12629b).equals((gd.a) iVar.f12629b)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (iVar.A()) {
            return this;
        }
        int[] iArr = (int[]) iVar.f12630c;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i3 = 0;
        while (true) {
            gd.a aVar = (gd.a) iVar.f12629b;
            if (i3 >= length) {
                return h(new i(aVar, iArr2));
            }
            int i10 = iArr[i3];
            aVar.getClass();
            iArr2[i3] = (929 - i10) % 929;
            i3++;
        }
    }

    public void P(CameraManager.AvailabilityCallback availabilityCallback) {
        t tVar;
        if (availabilityCallback != null) {
            y yVar = (y) this.f12630c;
            synchronized (((HashMap) yVar.f8773b)) {
                tVar = (t) ((HashMap) yVar.f8773b).remove(availabilityCallback);
            }
        } else {
            tVar = null;
        }
        if (tVar != null) {
            synchronized (tVar.f1221c) {
                tVar.f1222d = true;
            }
        }
        ((CameraManager) this.f12629b).unregisterAvailabilityCallback(tVar);
    }

    @Override // rd.b
    public void a(x xVar) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) this.f12629b;
        Log.e("qob", "queryMandatoryUpdate onError " + (bluetoothDevice != null ? bluetoothDevice.getAddress() : null) + " baseError " + xVar);
        if (xVar.f2798b != 0) {
            k6.b bVar = ((HeadsetFragment) this.f12630c).f8070c;
            if (bVar != null) {
                bVar.P();
            }
            ((HeadsetFragment) this.f12630c).f8070c = null;
            com.example.test.service.e.h().getClass();
            com.example.test.service.e.h().f7682a = true;
            com.example.test.service.e.h().n();
            return;
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        kotlin.jvm.internal.e.c(kVar);
        kVar.V(false);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        kotlin.jvm.internal.e.c(kVar2);
        BluetoothDevice bluetoothDevice2 = (BluetoothDevice) this.f12629b;
        String address = bluetoothDevice2 != null ? bluetoothDevice2.getAddress() : null;
        if (address == null) {
            address = "";
        }
        kVar2.M(address, "setting_jl_ota_truemac");
        ((HeadsetFragment) this.f12630c).getClass();
        xd.a a3 = tb.a(new byte[]{90, -91, 72, 4});
        k6.b bVar2 = ((HeadsetFragment) this.f12630c).f8070c;
        if (bVar2 != null) {
            bVar2.i(a3, new eb.e(5));
        }
    }

    @Override // com.example.test.ui.view.r
    public void b() {
        if (((SportTargetBean) this.f12629b).isVibrator() == 1) {
            y().M(200L);
        }
    }

    @Override // com.example.test.utils.b
    public void c(String str, boolean z5) {
        if (z5) {
            int i3 = CustomJLDialActivity.U;
            CustomJLDialActivity customJLDialActivity = (CustomJLDialActivity) this.f12629b;
            ((s) customJLDialActivity.I0()).n((String) this.f12630c);
            String concat = String.format("%s: %d", Arrays.copyOf(new Object[]{customJLDialActivity.getString(R$string.str_installing), 0}, 2)).concat("%");
            eh.b bVar = customJLDialActivity.f7247z;
            ((u) bVar.getValue()).f13360f.setProgress(0.0f);
            ((u) bVar.getValue()).f13360f.setText(concat);
        }
    }

    @Override // androidx.camera.core.impl.b1
    public void d(a1 a1Var) {
        synchronized (((HashMap) this.f12630c)) {
            try {
                u0 u0Var = (u0) ((HashMap) this.f12630c).remove(a1Var);
                if (u0Var != null) {
                    u0Var.f1494a.set(false);
                    a6.d().execute(new i0(2, this, u0Var));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.b1
    public void e(Executor executor, a1 a1Var) {
        synchronized (((HashMap) this.f12630c)) {
            u0 u0Var = (u0) ((HashMap) this.f12630c).get(a1Var);
            if (u0Var != null) {
                u0Var.f1494a.set(false);
            }
            u0 u0Var2 = new u0(executor, (androidx.camera.view.a) a1Var);
            ((HashMap) this.f12630c).put(a1Var, u0Var2);
            a6.d().execute(new androidx.camera.camera2.internal.compat.h(this, 1, u0Var, u0Var2));
        }
    }

    @Override // com.example.test.ui.view.r
    public void f() {
        int i3 = 1;
        if (((SportTargetBean) this.f12629b).isVibrator() == 1) {
            y().M(300L);
        }
        int i10 = SportCountDownNewActivity.I;
        SportCountDownNewActivity sportCountDownNewActivity = (SportCountDownNewActivity) this.f12630c;
        ((com.example.baselibrary.utils.e) sportCountDownNewActivity.F.getValue()).postDelayed(new com.example.test.ui.sport.activity.b(sportCountDownNewActivity, i3), 1000L);
    }

    @Override // rd.a
    public void g(vd.b bVar) {
        if (bVar.e != 0) {
            m(com.google.android.gms.internal.mlkit_vision_common.i0.b(12296, bVar.e, "status = " + bVar.e));
            return;
        }
        Object h4 = ((td.a) this.f12630c).h(bVar);
        rd.b bVar2 = (rd.b) this.f12629b;
        if (bVar2 != null) {
            bVar2.onSuccess(h4);
        }
    }

    public i h(i iVar) {
        gd.a aVar = (gd.a) iVar.f12629b;
        gd.a aVar2 = (gd.a) this.f12629b;
        if (!aVar2.equals(aVar)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (A()) {
            return iVar;
        }
        if (iVar.A()) {
            return this;
        }
        int[] iArr = (int[]) this.f12630c;
        int length = iArr.length;
        int[] iArr2 = (int[]) iVar.f12630c;
        if (length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length2 = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length2);
        for (int i3 = length2; i3 < iArr.length; i3++) {
            iArr3[i3] = aVar2.a(iArr2[i3 - length2], iArr[i3]);
        }
        return new i(aVar2, iArr3);
    }

    public void i(i6.g gVar) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            ((Handler) this.f12630c).post(new x.h(this, 27, gVar, false));
            return;
        }
        ArrayList arrayList = (ArrayList) this.f12629b;
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            r5.a.i(obj);
        }
    }

    @Override // vh.c
    public Iterator iterator() {
        return new kotlin.text.b(this);
    }

    public int j(ArrayList arrayList, androidx.camera.core.impl.utils.executor.b bVar, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.f12629b).captureBurst(arrayList, new androidx.camera.camera2.internal.compat.f(bVar, captureCallback), ((k) this.f12630c).f1176a);
    }

    @Override // g4.n
    public void k(a4.b bVar, Bitmap bitmap) {
        IOException iOException = ((t4.e) this.f12630c).f18511b;
        if (iOException != null) {
            if (bitmap == null) {
                throw iOException;
            }
            bVar.j(bitmap);
            throw iOException;
        }
    }

    public void l(CameraException cameraException) {
        ((b) this.f12629b).b(1, "dispatchError", cameraException);
        ((CameraView) this.f12630c).f11550j.post(new h(this, cameraException));
    }

    @Override // rd.a
    public void m(x xVar) {
        rd.b bVar = (rd.b) this.f12629b;
        if (bVar != null) {
            bVar.a(xVar);
        }
    }

    @Override // g4.n
    public void n() {
        com.bumptech.glide.load.resource.bitmap.a aVar = (com.bumptech.glide.load.resource.bitmap.a) this.f12629b;
        synchronized (aVar) {
            aVar.f7023c = aVar.f7021a.length;
        }
    }

    public void o(pf.b bVar) {
        Long valueOf = Long.valueOf(bVar.a());
        CameraView cameraView = (CameraView) this.f12630c;
        ((b) this.f12629b).b(0, "dispatchFrame:", valueOf, "processors:", Integer.valueOf(cameraView.f11558s.size()));
        if (cameraView.f11558s.isEmpty()) {
            bVar.b();
        } else {
            cameraView.f11551k.execute(new x.h(this, 10, bVar, false));
        }
    }

    @Override // x.c
    public void onSuccess(Object obj) {
        Devices c9;
        int i3 = 5;
        switch (this.f12628a) {
            case 5:
                ((androidx.concurrent.futures.b) this.f12629b).a((androidx.camera.core.b) this.f12630c);
                return;
            case 8:
                o oVar = (o) obj;
                oVar.getClass();
                try {
                    c0.f fVar = (c0.f) ((de.o) this.f12630c).f12377b;
                    if (fVar.e.get()) {
                        oVar.close();
                    } else {
                        i0 i0Var = new i0(i3, fVar, oVar);
                        Objects.requireNonNull(oVar);
                        fVar.b(i0Var, new androidx.activity.b(oVar, 9));
                    }
                    return;
                } catch (ProcessingException e) {
                    a0.c("SurfaceProcessorNode", "Failed to send SurfaceOutput to SurfaceProcessor.", e);
                    return;
                }
            case 10:
                j jVar = (j) obj;
                Integer valueOf = jVar != null ? Integer.valueOf(jVar.e) : null;
                String str = jVar != null ? jVar.f3236d : null;
                BluetoothDevice bluetoothDevice = (BluetoothDevice) this.f12629b;
                kotlin.jvm.internal.e.c(bluetoothDevice);
                String address = bluetoothDevice.getAddress();
                kotlin.jvm.internal.e.e(address, "getAddress(...)");
                String b3 = ca.b(address);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                kotlin.jvm.internal.e.c(kVar);
                kVar.V(true);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                kotlin.jvm.internal.e.c(kVar2);
                kVar2.M(b3, "setting_jl_ota_truemac");
                Log.e("qob", "queryMandatoryUpdate onSuccess " + valueOf + " " + str);
                HeadsetFragment headsetFragment = (HeadsetFragment) this.f12630c;
                headsetFragment.getClass();
                Log.e("qob", "onCheckOTAAuthSucess");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                if (!(kVar3 != null ? kotlin.jvm.internal.e.a(kVar3.q(), Boolean.TRUE) : false)) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                    if (kVar4 != null) {
                        kVar4.V(true);
                    }
                    String address2 = r5.b.k().f18057g.getAddress();
                    kotlin.jvm.internal.e.c(address2);
                    String b10 = ca.b(address2);
                    Object obj2 = p0.f7741g;
                    p0 a3 = m1.a();
                    a3.getClass();
                    Log.e("qob", "getJLHeadsetOTAFailedFirmwareInfoWithMac");
                    a3.i();
                    XXApplication xXApplication = XXApplication.f7400h;
                    com.example.test.utils.a a10 = u1.a(j1.a().getApplicationContext());
                    c6.b bVar = c6.b.f3390c;
                    String str2 = a10.f8718a;
                    kotlin.jvm.internal.e.e(str2, "getVersionName(...)");
                    bVar.e("", b10, str2).subscribe(new l0(j1.a().getApplicationContext(), a3, w0.d()));
                    return;
                }
                Object obj3 = p0.f7741g;
                FirmwareInfoBean d5 = m1.a().d();
                headsetFragment.f8072f = d5;
                if (d5 == null) {
                    kotlin.jvm.internal.e.m("bean");
                    throw null;
                }
                String downloadUrl = d5.getDownloadUrl();
                if (downloadUrl != null && downloadUrl.length() != 0) {
                    if (!headsetFragment.q0().isShowing()) {
                        headsetFragment.q0().show();
                    }
                    ((com.example.test.presenter.main.p0) headsetFragment.X()).f7544d = headsetFragment.f8070c;
                    com.example.test.ui.dialog.g q02 = headsetFragment.q0();
                    ((ImageView) q02.findViewById(R$id.iv_find_close)).setVisibility(8);
                    t6.e eVar = q02.f7960a;
                    if (eVar != null) {
                        eVar.a(100, 0);
                        return;
                    }
                    return;
                }
                p0 a11 = m1.a();
                a11.getClass();
                Log.e("qob", "getJLHeadsetOTAFailedFirmwareInfo");
                a11.i();
                XXApplication xXApplication2 = XXApplication.f7400h;
                Context applicationContext = j1.a().getApplicationContext();
                if (applicationContext != null) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar5 = com.example.test.utils.k.f8731b;
                    if (kVar5 == null || (c9 = kVar5.c()) == null) {
                        return;
                    }
                    com.example.test.utils.a a12 = u1.a(j1.a().getApplicationContext());
                    c6.b bVar2 = c6.b.f3390c;
                    String macAddress = c9.getMacAddress();
                    kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
                    String str3 = a12.f8718a;
                    kotlin.jvm.internal.e.e(str3, "getVersionName(...)");
                    bVar2.e("0.0.1", macAddress, str3).subscribe(new k0(applicationContext, a11, w0.d()));
                    return;
                }
                return;
            case 26:
                ((androidx.camera.camera2.internal.i) this.f12630c).f1250n.remove((m) this.f12629b);
                int ordinal = ((androidx.camera.camera2.internal.i) this.f12630c).e.ordinal();
                if (ordinal != 1 && ordinal != 4) {
                    if (ordinal != 5 && (ordinal != 6 || ((androidx.camera.camera2.internal.i) this.f12630c).f1248l == 0)) {
                        return;
                    } else {
                        ((androidx.camera.camera2.internal.i) this.f12630c).s("Camera reopen required. Checking if the current camera can be closed safely.", null);
                    }
                }
                if (((androidx.camera.camera2.internal.i) this.f12630c).f1250n.isEmpty()) {
                    androidx.camera.camera2.internal.i iVar = (androidx.camera.camera2.internal.i) this.f12630c;
                    if (iVar.f1247k != null) {
                        iVar.s("closing camera", null);
                        ((androidx.camera.camera2.internal.i) this.f12630c).f1247k.close();
                        ((androidx.camera.camera2.internal.i) this.f12630c).f1247k = null;
                        return;
                    }
                    return;
                }
                return;
            default:
                ((Surface) this.f12629b).release();
                ((SurfaceTexture) this.f12630c).release();
                return;
        }
    }

    public void p(Gesture gesture, boolean z5, PointF pointF) {
        ((b) this.f12629b).b(1, "dispatchOnFocusEnd", gesture, Boolean.valueOf(z5), pointF);
        ((CameraView) this.f12630c).f11550j.post(new cf.b(this, z5, gesture, pointF));
    }

    public int q(int i3) {
        if (i3 == 0) {
            return v(0);
        }
        gd.a aVar = (gd.a) this.f12629b;
        int[] iArr = (int[]) this.f12630c;
        if (i3 == 1) {
            int i10 = 0;
            for (int i11 : iArr) {
                i10 = aVar.a(i10, i11);
            }
            return i10;
        }
        int i12 = iArr[0];
        int length = iArr.length;
        for (int i13 = 1; i13 < length; i13++) {
            i12 = aVar.a(aVar.c(i3, i12), iArr[i13]);
        }
        return i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory r(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ef.i.r(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public com.google.gson.internal.i s(bc.a aVar) {
        e0 e0Var;
        Map map = (Map) this.f12629b;
        Type type = aVar.f3204b;
        if (map.get(type) != null) {
            throw new ClassCastException();
        }
        Class cls = aVar.f3203a;
        if (map.get(cls) != null) {
            throw new ClassCastException();
        }
        com.google.gson.internal.i iVar = null;
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                ((ac.b) this.f12630c).a(declaredConstructor);
            }
            e0Var = new e0(declaredConstructor, 12);
        } catch (NoSuchMethodException unused) {
            e0Var = null;
        }
        if (e0Var != null) {
            return e0Var;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            iVar = SortedSet.class.isAssignableFrom(cls) ? new ec.a(7) : EnumSet.class.isAssignableFrom(cls) ? new f0(type, 10) : Set.class.isAssignableFrom(cls) ? new gc.b(7) : Queue.class.isAssignableFrom(cls) ? new hc.a(7) : new n9.e(7);
        } else if (Map.class.isAssignableFrom(cls)) {
            iVar = ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new com.google.android.gms.internal.mlkit_common.o(8) : ConcurrentMap.class.isAssignableFrom(cls) ? new hc.a(6) : SortedMap.class.isAssignableFrom(cls) ? new n9.e(6) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(new bc.a(((ParameterizedType) type).getActualTypeArguments()[0]).f3203a)) ? new eb.e(7) : new com.google.android.gms.internal.mlkit_common.o(7);
        }
        return iVar != null ? iVar : new de.o(cls, type);
    }

    public CameraCharacteristics t(String str) {
        try {
            return ((CameraManager) this.f12629b).getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }

    public String toString() {
        switch (this.f12628a) {
            case 15:
                return ((Map) this.f12629b).toString();
            case 17:
                Formatter formatter = new Formatter();
                try {
                    int i3 = 0;
                    for (j2 j2Var : (j2[]) this.f12630c) {
                        if (j2Var == null) {
                            formatter.format("%3d:    |   %n", Integer.valueOf(i3));
                            i3++;
                        } else {
                            formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i3), Integer.valueOf(j2Var.f2641f), Integer.valueOf(j2Var.e));
                            i3++;
                        }
                    }
                    String formatter2 = formatter.toString();
                    formatter.close();
                    return formatter2;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            case 19:
                StringBuilder sb2 = new StringBuilder(x() * 8);
                for (int x10 = x(); x10 >= 0; x10--) {
                    int v6 = v(x10);
                    if (v6 != 0) {
                        if (v6 < 0) {
                            sb2.append(" - ");
                            v6 = -v6;
                        } else if (sb2.length() > 0) {
                            sb2.append(" + ");
                        }
                        if (x10 == 0 || v6 != 1) {
                            sb2.append(v6);
                        }
                        if (x10 != 0) {
                            if (x10 == 1) {
                                sb2.append('x');
                            } else {
                                sb2.append("x^");
                                sb2.append(x10);
                            }
                        }
                    }
                }
                return sb2.toString();
            case Const.ANDROID_VERSION_29 /* 29 */:
                String str = "[ ";
                if (((o0.e) this.f12629b) != null) {
                    for (int i10 = 0; i10 < 9; i10++) {
                        StringBuilder t8 = com.google.android.gms.internal.mlkit_vision_barcode.l0.t(str);
                        t8.append(((o0.e) this.f12629b).f16676h[i10]);
                        t8.append(" ");
                        str = t8.toString();
                    }
                }
                StringBuilder u10 = com.google.android.gms.internal.mlkit_vision_barcode.l0.u(str, "] ");
                u10.append((o0.e) this.f12629b);
                return u10.toString();
            default:
                return super.toString();
        }
    }

    public j2 u(int i3) {
        j2 j2Var;
        j2 j2Var2;
        j2[] j2VarArr = (j2[]) this.f12630c;
        j2 j2Var3 = j2VarArr[z(i3)];
        if (j2Var3 != null) {
            return j2Var3;
        }
        for (int i10 = 1; i10 < 5; i10++) {
            int z5 = z(i3) - i10;
            if (z5 >= 0 && (j2Var2 = j2VarArr[z5]) != null) {
                return j2Var2;
            }
            int z6 = z(i3) + i10;
            if (z6 < j2VarArr.length && (j2Var = j2VarArr[z6]) != null) {
                return j2Var;
            }
        }
        return null;
    }

    public int v(int i3) {
        return ((int[]) this.f12630c)[(r0.length - 1) - i3];
    }

    public Set w() {
        return Collections.EMPTY_SET;
    }

    public int x() {
        return ((int[]) this.f12630c).length - 1;
    }

    public int z(int i3) {
        return i3 - ((fd.b) this.f12629b).f13566h;
    }

    public /* synthetic */ i(int i3, boolean z5) {
        this.f12628a = i3;
    }

    public /* synthetic */ i(Object obj, int i3, Object obj2, boolean z5) {
        this.f12628a = i3;
        this.f12630c = obj;
        this.f12629b = obj2;
    }

    public i(de.o oVar) {
        this.f12628a = 14;
        this.f12630c = new a2.i();
        this.f12629b = oVar;
        na.b();
    }

    public i(gd.a aVar, int[] iArr) {
        this.f12628a = 19;
        if (iArr.length != 0) {
            this.f12629b = aVar;
            int length = iArr.length;
            int i3 = 1;
            if (length > 1 && iArr[0] == 0) {
                while (i3 < length && iArr[i3] == 0) {
                    i3++;
                }
                if (i3 == length) {
                    this.f12630c = new int[]{0};
                    return;
                }
                int i10 = length - i3;
                int[] iArr2 = new int[i10];
                this.f12630c = iArr2;
                System.arraycopy(iArr, i3, iArr2, 0, i10);
                return;
            }
            this.f12630c = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    public i(fd.b bVar) {
        this.f12628a = 17;
        this.f12629b = new fd.b(bVar);
        this.f12630c = new j2[(bVar.f13567i - bVar.f13566h) + 1];
    }

    public i(CameraCaptureSession cameraCaptureSession, k kVar) {
        this.f12628a = 2;
        cameraCaptureSession.getClass();
        this.f12629b = cameraCaptureSession;
        this.f12630c = kVar;
    }

    public i(o0.d dVar) {
        this.f12628a = 29;
        this.f12630c = dVar;
    }

    public i(Context context, y yVar) {
        this.f12628a = 3;
        this.f12629b = (CameraManager) context.getSystemService("camera");
        this.f12630c = yVar;
    }

    public i(int i3) {
        this.f12628a = i3;
        switch (i3) {
            case 6:
                this.f12629b = new HashMap();
                this.f12630c = new androidx.appcompat.app.t();
                break;
            case 15:
                Map map = Collections.EMPTY_MAP;
                this.f12630c = ac.b.f219a;
                this.f12629b = map;
                break;
            case 21:
                this.f12629b = new ArrayList();
                this.f12630c = new Handler(Looper.getMainLooper());
                break;
            default:
                this.f12629b = new b0();
                this.f12630c = new HashMap();
                break;
        }
    }

    public i(Runnable runnable) {
        this.f12628a = 25;
        this.f12630c = new CopyOnWriteArrayList();
        new HashMap();
        this.f12629b = runnable;
    }

    public i(Context context, Object obj, LinkedHashSet linkedHashSet) {
        androidx.camera.camera2.internal.compat.u a3;
        this.f12628a = 27;
        eb.e eVar = new eb.e(16);
        this.f12629b = new HashMap();
        this.f12630c = eVar;
        if (obj instanceof androidx.camera.camera2.internal.compat.u) {
            a3 = (androidx.camera.camera2.internal.compat.u) obj;
        } else {
            a3 = androidx.camera.camera2.internal.compat.u.a(context, v.c.a());
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ((HashMap) this.f12629b).put(str, new n.i0(context, str, a3, (eb.e) this.f12630c));
        }
    }

    public i(Context context) {
        this.f12628a = 7;
        this.f12630c = null;
        this.f12629b = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(CharSequence input, oh.p pVar) {
        this.f12628a = 24;
        kotlin.jvm.internal.e.f(input, "input");
        this.f12629b = input;
        this.f12630c = (Lambda) pVar;
    }

    public i(CameraView cameraView) {
        this.f12628a = 0;
        this.f12630c = cameraView;
        this.f12629b = b.a(i.class.getSimpleName());
    }
}
