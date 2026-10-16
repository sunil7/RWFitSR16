package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.example.test.ui.model.dial.PlacementSelectModel;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class e2 {
    public static Bitmap a(Context context, PlacementSelectModel data) {
        Bitmap decodeResource;
        kotlin.jvm.internal.e.f(context, "context");
        kotlin.jvm.internal.e.f(data, "data");
        String backgroundUrl = data.getBackgroundUrl();
        if ((backgroundUrl == null || backgroundUrl.length() == 0) && data.getBackgroundResId() == 0) {
            return null;
        }
        String backgroundUrl2 = data.getBackgroundUrl();
        if (backgroundUrl2 == null || backgroundUrl2.length() == 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            decodeResource = BitmapFactory.decodeResource(context.getResources(), data.getBackgroundResId(), options);
        } else {
            FileInputStream fileInputStream = new FileInputStream(data.getBackgroundUrl());
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inScaled = false;
            decodeResource = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, options2);
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth(), decodeResource.getHeight(), Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.e.e(createBitmap, "createBitmap(...)");
        String color = data.getColor();
        if (color == null || color.length() == 0) {
            data.setColor("#ffffff");
        }
        Paint paint = new Paint();
        paint.setDither(true);
        Canvas canvas = new Canvas(createBitmap);
        if (data.getDialType() == 1) {
            canvas.drawColor(0);
            float width = decodeResource.getWidth() / 2.0f;
            canvas.drawCircle(width, width, width, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), paint);
        } else {
            canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), paint);
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(data.getHourData(), 0, data.getHourData().length);
        float hourX = data.getHourX();
        float hourY = data.getHourY();
        float minuteX = data.getMinuteX();
        float minuteY = data.getMinuteY();
        if (decodeByteArray != null) {
            Bitmap b3 = b(Color.parseColor(data.getColor()), decodeByteArray);
            canvas.drawBitmap(b3, hourX, hourY, (Paint) null);
            hourX += decodeByteArray.getWidth();
            canvas.drawBitmap(b3, minuteX, minuteY, (Paint) null);
            minuteX += decodeByteArray.getWidth();
            decodeByteArray.recycle();
            b3.recycle();
        }
        Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(data.getMinuteData(), 0, data.getMinuteData().length);
        if (decodeByteArray2 != null) {
            Bitmap b10 = b(Color.parseColor(data.getColor()), decodeByteArray2);
            canvas.drawBitmap(b10, hourX, hourY, (Paint) null);
            canvas.drawBitmap(b10, minuteX, minuteY, (Paint) null);
            decodeByteArray2.recycle();
            b10.recycle();
        }
        Bitmap decodeByteArray3 = BitmapFactory.decodeByteArray(data.getTimeSeparatorData(), 0, data.getTimeSeparatorData().length);
        if (decodeByteArray3 != null) {
            Bitmap b11 = b(Color.parseColor(data.getColor()), decodeByteArray3);
            canvas.drawBitmap(b11, data.getTimeSeparatorX(), data.getTimeSeparatorY(), (Paint) null);
            decodeByteArray3.recycle();
            b11.recycle();
        }
        Bitmap decodeByteArray4 = BitmapFactory.decodeByteArray(data.getMonthData(), 0, data.getMonthData().length);
        float monthX = data.getMonthX();
        float monthY = data.getMonthY();
        float dayX = data.getDayX();
        float dayY = data.getDayY();
        if (decodeByteArray4 != null) {
            Bitmap b12 = b(Color.parseColor(data.getColor()), decodeByteArray4);
            canvas.drawBitmap(b12, monthX, monthY, (Paint) null);
            monthX += decodeByteArray4.getWidth();
            canvas.drawBitmap(b12, dayX, dayY, (Paint) null);
            dayX += decodeByteArray4.getWidth();
            decodeByteArray4.recycle();
            b12.recycle();
        }
        Bitmap decodeByteArray5 = BitmapFactory.decodeByteArray(data.getDayData(), 0, data.getDayData().length);
        if (decodeByteArray5 != null) {
            Bitmap b13 = b(Color.parseColor(data.getColor()), decodeByteArray5);
            canvas.drawBitmap(b13, monthX, monthY, (Paint) null);
            canvas.drawBitmap(b13, dayX, dayY, (Paint) null);
            decodeByteArray5.recycle();
            b13.recycle();
        }
        Bitmap decodeByteArray6 = BitmapFactory.decodeByteArray(data.getDateSeparatorData(), 0, data.getDateSeparatorData().length);
        if (decodeByteArray6 != null) {
            Bitmap b14 = b(Color.parseColor(data.getColor()), decodeByteArray6);
            canvas.drawBitmap(b14, data.getDateSeparatorX(), data.getDateSeparatorY(), (Paint) null);
            decodeByteArray6.recycle();
            b14.recycle();
        }
        Bitmap decodeByteArray7 = BitmapFactory.decodeByteArray(data.getWeekData(), 0, data.getWeekData().length);
        if (decodeByteArray7 != null) {
            Bitmap b15 = b(Color.parseColor(data.getColor()), decodeByteArray7);
            canvas.drawBitmap(b15, data.getWeekX(), data.getWeekY(), (Paint) null);
            decodeByteArray7.recycle();
            b15.recycle();
        }
        decodeResource.recycle();
        return createBitmap;
    }

    public static Bitmap b(int i3, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int red = Color.red(i3);
        int green = Color.green(i3);
        int blue = Color.blue(i3);
        for (int i10 = 0; i10 < width; i10++) {
            for (int i11 = 0; i11 < height; i11++) {
                int alpha = Color.alpha(bitmap.getPixel(i10, i11));
                if (alpha > 0) {
                    iArr[(i11 * width) + i10] = Color.argb(alpha, red, green, blue);
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, width, height, bitmap.getConfig());
        kotlin.jvm.internal.e.e(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    public static Bitmap c(Bitmap bitmap, int i3, int i10) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i10 / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        kotlin.jvm.internal.e.e(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    public static void d(Bitmap bitmap, String filePath) {
        kotlin.jvm.internal.e.f(filePath, "filePath");
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
