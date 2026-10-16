package com.google.android.gms.internal.mlkit_vision_barcode;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes.dex */
public abstract class f1 {
    public static final FloatBuffer a(int i3) {
        ByteBuffer order = ByteBuffer.allocateDirect(i3 * 4).order(ByteOrder.nativeOrder());
        order.limit(order.capacity());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        kotlin.jvm.internal.e.e(asFloatBuffer, "byteBuffer(size * Egloo.SIZE_OF_FLOAT).asFloatBuffer()");
        return asFloatBuffer;
    }
}
