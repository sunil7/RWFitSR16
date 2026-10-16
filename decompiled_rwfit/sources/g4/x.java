package g4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final Paint f13861a = new Paint(6);

    /* renamed from: b, reason: collision with root package name */
    public static final Paint f13862b = new Paint(7);

    /* renamed from: c, reason: collision with root package name */
    public static final Paint f13863c;

    /* renamed from: d, reason: collision with root package name */
    public static final Lock f13864d;

    static {
        f13864d = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079")).contains(Build.MODEL) ? new ReentrantLock() : new w();
        Paint paint = new Paint(7);
        f13863c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = f13864d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f13861a);
            canvas.setBitmap(null);
        } finally {
            lock.unlock();
        }
    }

    public static Bitmap b(a4.b bVar, Bitmap bitmap, int i3, int i10) {
        if (bitmap.getWidth() != i3 || bitmap.getHeight() != i10) {
            float min = Math.min(i3 / bitmap.getWidth(), i10 / bitmap.getHeight());
            int round = Math.round(bitmap.getWidth() * min);
            int round2 = Math.round(bitmap.getHeight() * min);
            if (bitmap.getWidth() != round || bitmap.getHeight() != round2) {
                Bitmap f2 = bVar.f((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
                f2.setHasAlpha(bitmap.hasAlpha());
                if (Log.isLoggable("TransformationUtils", 2)) {
                    Log.v("TransformationUtils", "request: " + i3 + "x" + i10);
                    Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
                    Log.v("TransformationUtils", "toReuse: " + f2.getWidth() + "x" + f2.getHeight());
                    StringBuilder sb2 = new StringBuilder("minPct:   ");
                    sb2.append(min);
                    Log.v("TransformationUtils", sb2.toString());
                }
                Matrix matrix = new Matrix();
                matrix.setScale(min, min);
                a(bitmap, f2, matrix);
                return f2;
            }
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
        } else if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size matches input, returning input");
            return bitmap;
        }
        return bitmap;
    }

    public static Bitmap c(a4.b bVar, Bitmap bitmap) {
        Bitmap.Config config = Bitmap.Config.RGBA_F16;
        if (!config.equals(bitmap.getConfig())) {
            config = Bitmap.Config.ARGB_8888;
        }
        if (config.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap f2 = bVar.f(bitmap.getWidth(), bitmap.getHeight(), config);
        new Canvas(f2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return f2;
    }
}
