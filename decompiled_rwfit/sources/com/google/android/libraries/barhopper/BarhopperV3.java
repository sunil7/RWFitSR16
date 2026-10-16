package com.google.android.libraries.barhopper;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.c0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.g1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.z;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import pc.a;

/* loaded from: classes.dex */
public class BarhopperV3 implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public long f10164a;

    private native void closeNative(long j4);

    private native long createNativeWithClientOptions(byte[] bArr);

    public static a g(byte[] bArr) {
        bArr.getClass();
        try {
            c0 c0Var = c0.f9757b;
            g1 g1Var = g1.f9786c;
            return a.n(bArr, c0.f9757b);
        } catch (zzer e) {
            throw new IllegalStateException("Received unexpected BarhopperResponse buffer: {0}", e);
        }
    }

    private native byte[] recognizeBitmapNative(long j4, Bitmap bitmap, RecognitionOptions recognitionOptions);

    private native byte[] recognizeBufferNative(long j4, int i3, int i10, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions);

    private native byte[] recognizeNative(long j4, int i3, int i10, byte[] bArr, RecognitionOptions recognitionOptions);

    public final void b(lb.a aVar) {
        if (this.f10164a != 0) {
            Log.w("BarhopperV3", "Native pointer already exists.");
            return;
        }
        try {
            int c9 = aVar.c();
            byte[] bArr = new byte[c9];
            z zVar = new z(bArr, c9);
            aVar.l(zVar);
            if (c9 - zVar.f9854d != 0) {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
            long createNativeWithClientOptions = createNativeWithClientOptions(bArr);
            this.f10164a = createNativeWithClientOptions;
            if (createNativeWithClientOptions == 0) {
                throw new IllegalArgumentException("Failed to create native pointer with client options.");
            }
        } catch (IOException e) {
            throw new RuntimeException(l0.o("Serializing ", lb.a.class.getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }

    public final a c(int i3, int i10, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions) {
        long j4 = this.f10164a;
        if (j4 != 0) {
            return g(recognizeBufferNative(j4, i3, i10, byteBuffer, recognitionOptions));
        }
        throw new IllegalStateException("Native pointer does not exist.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j4 = this.f10164a;
        if (j4 != 0) {
            closeNative(j4);
            this.f10164a = 0L;
        }
    }

    public final a e(int i3, int i10, byte[] bArr, RecognitionOptions recognitionOptions) {
        long j4 = this.f10164a;
        if (j4 != 0) {
            return g(recognizeNative(j4, i3, i10, bArr, recognitionOptions));
        }
        throw new IllegalStateException("Native pointer does not exist.");
    }

    public final a f(Bitmap bitmap, RecognitionOptions recognitionOptions) {
        if (this.f10164a == 0) {
            throw new IllegalStateException("Native pointer does not exist.");
        }
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config != config2) {
            Log.d("BarhopperV3", "Input bitmap config is not ARGB_8888. Converting it to ARGB_8888 from ".concat(String.valueOf(bitmap.getConfig())));
            bitmap = bitmap.copy(config2, bitmap.isMutable());
        }
        return g(recognizeBitmapNative(this.f10164a, bitmap, recognitionOptions));
    }
}
