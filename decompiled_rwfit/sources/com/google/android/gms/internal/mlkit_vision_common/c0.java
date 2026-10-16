package com.google.android.gms.internal.mlkit_vision_common;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.tencent.open.apireq.BaseResp;

/* loaded from: classes.dex */
public abstract class c0 {
    public static Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(90, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        float height = bitmap.getHeight();
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        matrix.postTranslate(height - fArr[2], 0.0f - fArr[5]);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint());
        return createBitmap;
    }

    public static float b(MotionEvent motionEvent) {
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y4 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((y4 * y4) + (x10 * x10));
    }

    public static Rect c(float f2, float f10, float f11, int i3, int i10, int i11, int i12) {
        int i13 = (int) ((i3 * f2) / 2.0f);
        int i14 = (int) ((i10 * f2) / 2.0f);
        int i15 = (int) (((f10 / i11) * 2000.0f) - 1000.0f);
        int i16 = (int) (((f11 / i12) * 2000.0f) - 1000.0f);
        RectF rectF = new RectF(Math.min(Math.max(i15 - i13, BaseResp.CODE_QQ_NOT_INSTALLED), 1000), Math.min(Math.max(i16 - i14, BaseResp.CODE_QQ_NOT_INSTALLED), 1000), Math.min(Math.max(i15 + i13, BaseResp.CODE_QQ_NOT_INSTALLED), 1000), Math.min(Math.max(i16 + i14, BaseResp.CODE_QQ_NOT_INSTALLED), 1000));
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public static int d(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static Bitmap e(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i3 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i10 = options.outHeight / 400;
            if (i10 > 0) {
                i3 = i10;
            }
            options.inSampleSize = i3;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Point f(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static int g(Context context) {
        int identifier;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.windowFullscreen});
        boolean z5 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (!z5 && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean h(Context context) {
        Point f2 = f(context);
        return f2.y > f2.x;
    }

    public static Bitmap i(int i3, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static void j(Rect rect) {
        rect.centerX();
        rect.centerY();
        rect.width();
        rect.height();
        rect.width();
        rect.height();
    }
}
