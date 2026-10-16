package androidx.camera.core;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Log;
import android.view.Surface;
import androidx.camera.core.impl.r0;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.tencent.connect.common.Constants;
import java.nio.ByteBuffer;
import java.util.Locale;
import t.h0;
import t.o0;
import t.p0;

/* loaded from: classes.dex */
public abstract class ImageProcessingUtil {

    /* renamed from: a, reason: collision with root package name */
    public static int f1285a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Result {
        public static final Result ERROR_CONVERSION;
        public static final Result SUCCESS;
        public static final Result UNKNOWN;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Result[] f1286a;

        static {
            Result result = new Result(Constants.APP_VERSION_UNKNOWN, 0);
            UNKNOWN = result;
            Result result2 = new Result(AMapLocationStaticsEntity.SUCCESS_STATUS, 1);
            SUCCESS = result2;
            Result result3 = new Result("ERROR_CONVERSION", 2);
            ERROR_CONVERSION = result3;
            f1286a = new Result[]{result, result2, result3};
        }

        public static Result valueOf(String str) {
            return (Result) Enum.valueOf(Result.class, str);
        }

        public static Result[] values() {
            return (Result[]) f1286a.clone();
        }
    }

    static {
        System.loadLibrary("image_processing_util_jni");
    }

    public static void a(p0 p0Var) {
        if (!d(p0Var)) {
            a0.b("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return;
        }
        int width = p0Var.getWidth();
        int height = p0Var.getHeight();
        int U = p0Var.o()[0].U();
        int U2 = p0Var.o()[1].U();
        int U3 = p0Var.o()[2].U();
        int T = p0Var.o()[0].T();
        int T2 = p0Var.o()[1].T();
        if ((nativeShiftPixel(p0Var.o()[0].S(), U, p0Var.o()[1].S(), U2, p0Var.o()[2].S(), U3, T, T2, width, height, T, T2, T2) != 0 ? Result.ERROR_CONVERSION : Result.SUCCESS) == Result.ERROR_CONVERSION) {
            a0.b("ImageProcessingUtil", "One pixel shift for YUV failure");
        }
    }

    public static h0 b(p0 p0Var, r0 r0Var, ByteBuffer byteBuffer, int i3, boolean z5) {
        if (!d(p0Var)) {
            a0.b("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 != 0 && i3 != 90 && i3 != 180 && i3 != 270) {
            a0.b("ImageProcessingUtil", "Unsupported rotation degrees for rotate RGB");
            return null;
        }
        Surface e = r0Var.e();
        int width = p0Var.getWidth();
        int height = p0Var.getHeight();
        int U = p0Var.o()[0].U();
        int U2 = p0Var.o()[1].U();
        int U3 = p0Var.o()[2].U();
        int T = p0Var.o()[0].T();
        int T2 = p0Var.o()[1].T();
        if ((nativeConvertAndroid420ToABGR(p0Var.o()[0].S(), U, p0Var.o()[1].S(), U2, p0Var.o()[2].S(), U3, T, T2, e, byteBuffer, width, height, z5 ? T : 0, z5 ? T2 : 0, z5 ? T2 : 0, i3) != 0 ? Result.ERROR_CONVERSION : Result.SUCCESS) == Result.ERROR_CONVERSION) {
            a0.b("ImageProcessingUtil", "YUV to RGB conversion failure");
            return null;
        }
        if (Log.isLoggable("MH", 3)) {
            Locale locale = Locale.US;
            a0.a("ImageProcessingUtil", "Image processing performance profiling, duration: [" + (System.currentTimeMillis() - currentTimeMillis) + "], image count: " + f1285a);
            f1285a = f1285a + 1;
        }
        p0 k10 = r0Var.k();
        if (k10 == null) {
            a0.b("ImageProcessingUtil", "YUV to RGB acquireLatestImage failure");
            return null;
        }
        h0 h0Var = new h0(k10);
        h0Var.addOnImageCloseListener(new o0(k10, p0Var, 0));
        return h0Var;
    }

    public static void c(Bitmap bitmap, ByteBuffer byteBuffer, int i3) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, i3, bitmap.getRowBytes(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    public static boolean d(p0 p0Var) {
        return p0Var.n() == 35 && p0Var.o().length == 3;
    }

    public static h0 e(p0 p0Var, r0 r0Var, ImageWriter imageWriter, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i3) {
        String str;
        Result result;
        Result result2;
        if (!d(p0Var)) {
            a0.b("ImageProcessingUtil", "Unsupported format for rotate YUV");
            return null;
        }
        if (i3 != 0 && i3 != 90 && i3 != 180 && i3 != 270) {
            a0.b("ImageProcessingUtil", "Unsupported rotation degrees for rotate YUV");
            return null;
        }
        Result result3 = Result.ERROR_CONVERSION;
        if (i3 > 0) {
            int width = p0Var.getWidth();
            int height = p0Var.getHeight();
            int U = p0Var.o()[0].U();
            int U2 = p0Var.o()[1].U();
            int U3 = p0Var.o()[2].U();
            int T = p0Var.o()[1].T();
            Image dequeueInputImage = imageWriter.dequeueInputImage();
            if (dequeueInputImage == null) {
                result2 = result3;
                str = "ImageProcessingUtil";
            } else {
                result2 = result3;
                str = "ImageProcessingUtil";
                if (nativeRotateYUV(p0Var.o()[0].S(), U, p0Var.o()[1].S(), U2, p0Var.o()[2].S(), U3, T, dequeueInputImage.getPlanes()[0].getBuffer(), dequeueInputImage.getPlanes()[0].getRowStride(), dequeueInputImage.getPlanes()[0].getPixelStride(), dequeueInputImage.getPlanes()[1].getBuffer(), dequeueInputImage.getPlanes()[1].getRowStride(), dequeueInputImage.getPlanes()[1].getPixelStride(), dequeueInputImage.getPlanes()[2].getBuffer(), dequeueInputImage.getPlanes()[2].getRowStride(), dequeueInputImage.getPlanes()[2].getPixelStride(), byteBuffer, byteBuffer2, byteBuffer3, width, height, i3) != 0) {
                    result3 = result2;
                } else {
                    imageWriter.queueInputImage(dequeueInputImage);
                    result3 = Result.SUCCESS;
                }
            }
            result = result2;
        } else {
            str = "ImageProcessingUtil";
            result = result3;
            result3 = result;
        }
        if (result3 == result) {
            a0.b(str, "rotate YUV failure");
            return null;
        }
        String str2 = str;
        p0 k10 = r0Var.k();
        if (k10 == null) {
            a0.b(str2, "YUV rotation acquireLatestImage failure");
            return null;
        }
        h0 h0Var = new h0(k10);
        h0Var.addOnImageCloseListener(new o0(k10, p0Var, 1));
        return h0Var;
    }

    public static void f(byte[] bArr, Surface surface) {
        surface.getClass();
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            a0.b("ImageProcessingUtil", "Failed to enqueue JPEG image.");
        }
    }

    private static native int nativeConvertAndroid420ToABGR(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i10, ByteBuffer byteBuffer3, int i11, int i12, int i13, Surface surface, ByteBuffer byteBuffer4, int i14, int i15, int i16, int i17, int i18, int i19);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i3, int i10, int i11, int i12, boolean z5);

    private static native int nativeRotateYUV(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i10, ByteBuffer byteBuffer3, int i11, int i12, ByteBuffer byteBuffer4, int i13, int i14, ByteBuffer byteBuffer5, int i15, int i16, ByteBuffer byteBuffer6, int i17, int i18, ByteBuffer byteBuffer7, ByteBuffer byteBuffer8, ByteBuffer byteBuffer9, int i19, int i20, int i21);

    private static native int nativeShiftPixel(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i10, ByteBuffer byteBuffer3, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18);

    private static native int nativeWriteJpegToSurface(byte[] bArr, Surface surface);
}
