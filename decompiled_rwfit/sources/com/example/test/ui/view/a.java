package com.example.test.ui.view;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import n.g0;
import n.n0;
import n.v;

/* loaded from: classes.dex */
public final class a extends CameraDevice.StateCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8671a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8672b;

    public /* synthetic */ a(Object obj, int i3) {
        this.f8671a = i3;
        this.f8672b = obj;
    }

    private final void c(CameraDevice cameraDevice) {
    }

    public void a() {
        ArrayList l3;
        synchronized (((g0) this.f8672b).f16175b) {
            l3 = ((g0) this.f8672b).l();
            ((LinkedHashSet) ((g0) this.f8672b).e).clear();
            ((LinkedHashSet) ((g0) this.f8672b).f16176c).clear();
            ((LinkedHashSet) ((g0) this.f8672b).f16177d).clear();
        }
        int size = l3.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = l3.get(i3);
            i3++;
            n0 n0Var = (n0) obj;
            synchronized (n0Var.f16257a) {
                try {
                    List list = n0Var.f16266k;
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((androidx.camera.core.impl.g0) it.next()).b();
                        }
                        n0Var.f16266k = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            n0Var.f16275u.h();
        }
    }

    public void b() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (((g0) this.f8672b).f16175b) {
            linkedHashSet.addAll((LinkedHashSet) ((g0) this.f8672b).e);
            linkedHashSet.addAll((LinkedHashSet) ((g0) this.f8672b).f16176c);
        }
        ((androidx.camera.core.impl.utils.executor.b) ((g0) this.f8672b).f16174a).execute(new m5.a(linkedHashSet, 5));
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onClosed(CameraDevice cameraDevice) {
        switch (this.f8671a) {
            case 1:
                ArrayList arrayList = (ArrayList) this.f8672b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraDevice.StateCallback) obj).onClosed(cameraDevice);
                }
                break;
            case 2:
                b();
                a();
                break;
            default:
                super.onClosed(cameraDevice);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        switch (this.f8671a) {
            case 0:
                ((CameraPreview) this.f8672b).f8349b.release();
                cameraDevice.close();
                break;
            case 1:
                ArrayList arrayList = (ArrayList) this.f8672b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraDevice.StateCallback) obj).onDisconnected(cameraDevice);
                }
                break;
            default:
                b();
                a();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i3) {
        switch (this.f8671a) {
            case 0:
                ((CameraPreview) this.f8672b).f8349b.release();
                cameraDevice.close();
                return;
            case 1:
                ArrayList arrayList = (ArrayList) this.f8672b;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((CameraDevice.StateCallback) obj).onError(cameraDevice, i3);
                }
                return;
            default:
                b();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                synchronized (((g0) this.f8672b).f16175b) {
                    linkedHashSet.addAll((LinkedHashSet) ((g0) this.f8672b).e);
                    linkedHashSet.addAll((LinkedHashSet) ((g0) this.f8672b).f16176c);
                }
                ((androidx.camera.core.impl.utils.executor.b) ((g0) this.f8672b).f16174a).execute(new b1.m(i3, 3, linkedHashSet));
                a();
                return;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        switch (this.f8671a) {
            case 0:
                CameraPreview cameraPreview = (CameraPreview) this.f8672b;
                cameraPreview.f8349b.release();
                try {
                    cameraPreview.getSurfaceTexture();
                    throw null;
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                    return;
                }
            case 1:
                ArrayList arrayList = (ArrayList) this.f8672b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraDevice.StateCallback) obj).onOpened(cameraDevice);
                }
                return;
            default:
                return;
        }
    }

    public a(ArrayList arrayList) {
        this.f8671a = 1;
        this.f8672b = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            CameraDevice.StateCallback stateCallback = (CameraDevice.StateCallback) obj;
            if (!(stateCallback instanceof v)) {
                ((ArrayList) this.f8672b).add(stateCallback);
            }
        }
    }
}
