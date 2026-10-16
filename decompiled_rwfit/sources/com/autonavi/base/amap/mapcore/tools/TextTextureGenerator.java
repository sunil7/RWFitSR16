package com.autonavi.base.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.amap.api.col.p0003sl.v4;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    private int TEXT_FONTSIZE = -1;
    private int TEXT_FONTSIZE_TRUE = -1;
    private float base_line = 0.0f;
    private float start_x = 0.0f;
    private Paint text_paint = null;

    public TextTextureGenerator() {
        createTextParam();
    }

    public static int GetNearstSize2N(int i3) {
        int i10 = 1;
        while (i3 > i10) {
            i10 *= 2;
        }
        return i10;
    }

    private void createTextParam() {
        float f2;
        float f10;
        int i3 = this.TEXT_FONTSIZE - 2;
        this.TEXT_FONTSIZE_TRUE = i3;
        Paint newPaint = newPaint(null, i3, ALIGNLEFT);
        this.text_paint = newPaint;
        float f11 = (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE) / 2.0f;
        this.start_x = f11;
        try {
            Paint.FontMetrics fontMetrics = newPaint.getFontMetrics();
            f2 = fontMetrics.descent;
            try {
                f10 = fontMetrics.ascent;
            } catch (Exception unused) {
                f10 = -27.832031f;
                this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f2 + f10)) / 2.0f) + f11 + 0.5f;
            }
        } catch (Exception unused2) {
            f2 = 7.3242188f;
        }
        this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f2 + f10)) / 2.0f) + f11 + 0.5f;
    }

    public static float getFontHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }

    private static Paint newPaint(String str, int i3, int i10) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize(i3);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        switch (i10) {
            case ALIGNLEFT /* 49 */:
                textPaint.setTextAlign(Paint.Align.LEFT);
                break;
            case 50:
                textPaint.setTextAlign(Paint.Align.RIGHT);
                break;
            case ALIGNCENTER /* 51 */:
                textPaint.setTextAlign(Paint.Align.CENTER);
                break;
            default:
                textPaint.setTextAlign(Paint.Align.LEFT);
                break;
        }
        return textPaint;
    }

    public byte[] getCharsWidths(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            Paint paint = this.text_paint;
            bArr[i3] = (byte) (new float[]{paint.measureText(((char) iArr[i3]) + "")}[0] + (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE));
        }
        return bArr;
    }

    public byte[] getTextPixelBuffer(int i3, int i10) {
        if (this.TEXT_FONTSIZE != i10) {
            this.TEXT_FONTSIZE = i10;
            createTextParam();
        }
        char c9 = (char) i3;
        try {
            char[] cArr = {c9};
            float f2 = this.base_line;
            int i11 = this.TEXT_FONTSIZE;
            Bitmap createBitmap = Bitmap.createBitmap(i11, i11, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            int i12 = this.TEXT_FONTSIZE;
            byte[] bArr = new byte[i12 * i12];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            float measureText = this.text_paint.measureText(String.valueOf(c9));
            char c10 = cArr[0];
            if (c10 > 0 && c10 < 256) {
                f2 -= 1.5f;
            }
            float f10 = f2;
            Paint.Align textAlign = this.text_paint.getTextAlign();
            float textSize = this.text_paint.getTextSize();
            float f11 = measureText - this.TEXT_FONTSIZE_TRUE;
            Paint.Align align = Paint.Align.CENTER;
            if (textAlign == align || f11 < 4.0f) {
                canvas.drawText(cArr, 0, 1, this.start_x, f10, this.text_paint);
            } else {
                this.text_paint.setTextAlign(align);
                this.text_paint.setTextSize(this.TEXT_FONTSIZE_TRUE - f11);
                canvas.drawText(cArr, 0, 1, (this.TEXT_FONTSIZE_TRUE - f11) / 2.0f, f10, this.text_paint);
                this.text_paint.setTextAlign(textAlign);
                this.text_paint.setTextSize(textSize);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            v4.a(createBitmap);
            return bArr;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }
}
