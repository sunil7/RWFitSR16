package com.dh.imagepick.crop;

import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.dh.imagepick.crop.CropImageView;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CropImageView f7107a;

    public a(CropImageView cropImageView) {
        this.f7107a = cropImageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CropImageView cropImageView = this.f7107a;
        Drawable drawable = cropImageView.getDrawable();
        if (!cropImageView.D || drawable == null) {
            return;
        }
        cropImageView.f7101x = 0;
        cropImageView.f7095q = cropImageView.getImageMatrix();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        cropImageView.f7093o = intrinsicWidth;
        cropImageView.f7091m = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        cropImageView.f7094p = intrinsicHeight;
        cropImageView.f7092n = intrinsicHeight;
        int width = cropImageView.getWidth();
        int height = cropImageView.getHeight();
        cropImageView.f7100w = new PointF(width / 2, height / 2);
        if (cropImageView.f7087i == CropImageView.Style.CIRCLE) {
            int min = Math.min(cropImageView.f7085g, cropImageView.f7086h);
            cropImageView.f7085g = min;
            cropImageView.f7086h = min;
        }
        RectF rectF = cropImageView.f7090l;
        PointF pointF = cropImageView.f7100w;
        float f2 = pointF.x;
        int i3 = cropImageView.f7085g;
        float f10 = i3 / 2;
        rectF.left = f2 - f10;
        rectF.right = f2 + f10;
        float f11 = pointF.y;
        int i10 = cropImageView.f7086h;
        float f12 = i10 / 2;
        rectF.top = f11 - f12;
        rectF.bottom = f11 + f12;
        float e = CropImageView.e(cropImageView.f7091m, cropImageView.f7092n, i3, i10, true);
        cropImageView.C = 4.0f * e;
        float e10 = CropImageView.e(cropImageView.f7091m, cropImageView.f7092n, width, height, false);
        if (e10 > e) {
            e = e10;
        }
        cropImageView.f7095q.setScale(e, e, cropImageView.f7091m / 2, cropImageView.f7092n / 2);
        float[] fArr = new float[9];
        cropImageView.f7095q.getValues(fArr);
        PointF pointF2 = cropImageView.f7100w;
        cropImageView.f7095q.postTranslate(pointF2.x - (((cropImageView.f7091m * fArr[0]) / 2.0f) + fArr[2]), pointF2.y - (((cropImageView.f7092n * fArr[4]) / 2.0f) + fArr[5]));
        cropImageView.setImageMatrix(cropImageView.f7095q);
        cropImageView.invalidate();
    }
}
