package com.google.android.gms.internal.mlkit_vision_barcode;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public abstract class ae {
    public static boolean a(MotionEvent motionEvent, int i3) {
        return (motionEvent.getSource() & i3) == i3;
    }
}
