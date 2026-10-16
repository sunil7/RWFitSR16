package com.google.android.gms.internal.mlkit_vision_barcode;

import android.hardware.camera2.CameraDevice;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class ne {
    public static CameraDevice.StateCallback a(ArrayList arrayList) {
        return arrayList.isEmpty() ? new n.v() : arrayList.size() == 1 ? (CameraDevice.StateCallback) arrayList.get(0) : new com.example.test.ui.view.a(arrayList);
    }
}
