package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final t.q f1350a;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new t0(2));
        f1350a = new t.q(linkedHashSet);
    }

    public static void a(Context context, com.example.test.utils.y yVar, t.q qVar) {
        Integer b3;
        int i3 = 0;
        IllegalArgumentException illegalArgumentException = null;
        if (Build.VERSION.SDK_INT >= 34 && a0.b(context) != 0) {
            LinkedHashSet t8 = yVar.t();
            if (t8.isEmpty()) {
                throw new CameraValidator$CameraIdListIncorrectException("No cameras available", 0, null);
            }
            com.google.android.gms.internal.mlkit_vision_common.a0.a("CameraValidator", "Virtual device with ID: " + a0.b(context) + " has " + t8.size() + " cameras. Skipping validation.");
            return;
        }
        if (qVar != null) {
            try {
                b3 = qVar.b();
                if (b3 == null) {
                    com.google.android.gms.internal.mlkit_vision_common.a0.e("CameraValidator", "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e) {
                com.google.android.gms.internal.mlkit_vision_common.a0.c("CameraValidator", "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e);
                return;
            }
        } else {
            b3 = null;
        }
        com.google.android.gms.internal.mlkit_vision_common.a0.a("CameraValidator", "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + b3);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera")) {
                if (qVar != null) {
                    if (b3.intValue() == 1) {
                    }
                }
                t.q.f18375c.c(yVar.t());
                i3 = 1;
            }
        } catch (IllegalArgumentException e10) {
            illegalArgumentException = e10;
            com.google.android.gms.internal.mlkit_vision_common.a0.f("CameraValidator", "Camera LENS_FACING_BACK verification failed", illegalArgumentException);
        }
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera.front")) {
                if (qVar != null) {
                    if (b3.intValue() == 0) {
                    }
                }
                t.q.f18374b.c(yVar.t());
                i3++;
            }
        } catch (IllegalArgumentException e11) {
            illegalArgumentException = e11;
            com.google.android.gms.internal.mlkit_vision_common.a0.f("CameraValidator", "Camera LENS_FACING_FRONT verification failed", illegalArgumentException);
        }
        try {
            f1350a.c(yVar.t());
            com.google.android.gms.internal.mlkit_vision_common.a0.a("CameraValidator", "Found a LENS_FACING_EXTERNAL camera");
            i3++;
        } catch (IllegalArgumentException unused) {
        }
        if (illegalArgumentException == null) {
            return;
        }
        com.google.android.gms.internal.mlkit_vision_common.a0.b("CameraValidator", "Camera LensFacing verification failed, existing cameras: " + yVar.t());
        throw new CameraValidator$CameraIdListIncorrectException("Expected camera missing from device.", i3, illegalArgumentException);
    }
}
