package com.google.android.gms.internal.mlkit_vision_barcode;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class me {
    public static void a(CaptureRequest.Builder builder, androidx.camera.core.impl.d1 d1Var) {
        n6.a c9 = g0.d.d(d1Var).c();
        for (androidx.camera.core.impl.c cVar : c9.g()) {
            CaptureRequest.Key key = cVar.f1353c;
            try {
                builder.set(key, c9.e(cVar));
            } catch (IllegalArgumentException unused) {
                com.google.android.gms.internal.mlkit_vision_common.a0.b("Camera2CaptureRequestBuilder", "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    public static void b(CaptureRequest.Builder builder, int i3, q.a aVar) {
        Map map;
        if (i3 == 3 && aVar.f17604a) {
            HashMap hashMap = new HashMap();
            hashMap.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 1);
            map = Collections.unmodifiableMap(hashMap);
        } else {
            if (i3 != 4) {
                aVar.getClass();
            } else if (aVar.f17605b) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 2);
                map = Collections.unmodifiableMap(hashMap2);
            }
            map = Collections.EMPTY_MAP;
        }
        for (Map.Entry entry : map.entrySet()) {
            builder.set((CaptureRequest.Key) entry.getKey(), entry.getValue());
        }
    }

    public static CaptureRequest c(androidx.camera.core.impl.d0 d0Var, CameraDevice cameraDevice, HashMap hashMap, boolean z5, q.a aVar) {
        CaptureRequest.Builder createCaptureRequest;
        androidx.camera.core.impl.n nVar;
        if (cameraDevice == null) {
            return null;
        }
        List unmodifiableList = Collections.unmodifiableList(d0Var.f1366a);
        ArrayList arrayList = new ArrayList();
        Iterator it = unmodifiableList.iterator();
        while (it.hasNext()) {
            Surface surface = (Surface) hashMap.get((androidx.camera.core.impl.g0) it.next());
            if (surface == null) {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
            arrayList.add(surface);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        int i3 = d0Var.f1368c;
        if (i3 == 5 && (nVar = d0Var.f1371g) != null && (nVar.i() instanceof TotalCaptureResult)) {
            com.google.android.gms.internal.mlkit_vision_common.a0.a("Camera2CaptureRequestBuilder", "createReprocessCaptureRequest");
            createCaptureRequest = cameraDevice.createReprocessCaptureRequest((TotalCaptureResult) nVar.i());
        } else {
            com.google.android.gms.internal.mlkit_vision_common.a0.a("Camera2CaptureRequestBuilder", "createCaptureRequest");
            if (i3 == 5) {
                createCaptureRequest = cameraDevice.createCaptureRequest(z5 ? 1 : 2);
            } else {
                createCaptureRequest = cameraDevice.createCaptureRequest(i3);
            }
        }
        b(createCaptureRequest, i3, aVar);
        androidx.camera.core.impl.c cVar = androidx.camera.core.impl.d0.f1365j;
        Object obj = androidx.camera.core.impl.h.f1404f;
        androidx.camera.core.impl.d1 d1Var = d0Var.f1367b;
        try {
            obj = d1Var.e(cVar);
        } catch (IllegalArgumentException unused) {
        }
        Range range = (Range) obj;
        Objects.requireNonNull(range);
        Object obj2 = androidx.camera.core.impl.h.f1404f;
        if (!range.equals(obj2)) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
            try {
                obj2 = d1Var.e(androidx.camera.core.impl.d0.f1365j);
            } catch (IllegalArgumentException unused2) {
            }
            Range range2 = (Range) obj2;
            Objects.requireNonNull(range2);
            createCaptureRequest.set(key, range2);
        }
        int i10 = 0;
        if (d0Var.a() == 1 || d0Var.b() == 1) {
            createCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        } else if (d0Var.a() == 2) {
            createCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 2);
        } else if (d0Var.b() == 2) {
            createCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
        }
        androidx.camera.core.impl.c cVar2 = androidx.camera.core.impl.d0.f1363h;
        TreeMap treeMap = d1Var.f1374a;
        if (treeMap.containsKey(cVar2)) {
            createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, (Integer) d1Var.e(cVar2));
        }
        androidx.camera.core.impl.c cVar3 = androidx.camera.core.impl.d0.f1364i;
        if (treeMap.containsKey(cVar3)) {
            createCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) d1Var.e(cVar3)).byteValue()));
        }
        a(createCaptureRequest, d1Var);
        int size = arrayList.size();
        while (i10 < size) {
            Object obj3 = arrayList.get(i10);
            i10++;
            createCaptureRequest.addTarget((Surface) obj3);
        }
        createCaptureRequest.setTag(d0Var.f1370f);
        return createCaptureRequest.build();
    }

    public static CaptureRequest d(androidx.camera.core.impl.d0 d0Var, CameraDevice cameraDevice, q.a aVar) {
        if (cameraDevice == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder("template type = ");
        int i3 = d0Var.f1368c;
        sb2.append(i3);
        com.google.android.gms.internal.mlkit_vision_common.a0.a("Camera2CaptureRequestBuilder", sb2.toString());
        CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(i3);
        b(createCaptureRequest, i3, aVar);
        a(createCaptureRequest, d0Var.f1367b);
        return createCaptureRequest.build();
    }
}
