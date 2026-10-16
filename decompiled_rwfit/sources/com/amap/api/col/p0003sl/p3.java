package com.amap.api.col.p0003sl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.TextOptions;

/* loaded from: classes.dex */
public class p3 {

    /* renamed from: a, reason: collision with root package name */
    private static Paint f4807a = new Paint();

    /* renamed from: b, reason: collision with root package name */
    private static Rect f4808b = new Rect();

    public static float a(int i3, boolean z5) {
        if (z5) {
            if (i3 != 1) {
                return i3 != 2 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }
        if (i3 != 8) {
            return i3 != 16 ? 0.5f : 1.0f;
        }
        return 0.0f;
    }

    public static MarkerOptions b(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(textOptions.getPosition());
        markerOptions.visible(textOptions.isVisible());
        markerOptions.zIndex(textOptions.getZIndex());
        markerOptions.rotateAngle(textOptions.getRotate());
        markerOptions.icon(a(textOptions));
        markerOptions.anchor(a(textOptions.getAlignX(), true), a(textOptions.getAlignY(), false));
        return markerOptions;
    }

    public static BitmapDescriptor a(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        f4807a.setTypeface(textOptions.getTypeface());
        f4807a.setSubpixelText(true);
        f4807a.setAntiAlias(true);
        f4807a.setStrokeWidth(5.0f);
        f4807a.setStrokeCap(Paint.Cap.ROUND);
        f4807a.setTextSize(textOptions.getFontSize());
        f4807a.setTextAlign(Paint.Align.CENTER);
        f4807a.setColor(textOptions.getFontColor());
        Paint.FontMetrics fontMetrics = f4807a.getFontMetrics();
        int i3 = (int) (fontMetrics.descent - fontMetrics.ascent);
        int i10 = (int) (((i3 - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        if (textOptions.getText() != null) {
            f4807a.getTextBounds(textOptions.getText(), 0, textOptions.getText().length(), f4808b);
        }
        Bitmap createBitmap = Bitmap.createBitmap(f4808b.width() + 6, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(textOptions.getBackgroundColor());
        if (textOptions.getText() != null) {
            canvas.drawText(textOptions.getText(), f4808b.centerX() + 3, i10, f4807a);
        }
        return BitmapDescriptorFactory.fromBitmap(createBitmap);
    }
}
