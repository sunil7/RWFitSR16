package com.autonavi.base.ae.gmap.bean;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.amap.api.col.p0003sl.a1;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.nio.ByteBuffer;

@JBindingInclude
/* loaded from: classes.dex */
public class NativeTextGenerate {

    @JBindingExclude
    private static volatile NativeTextGenerate instance;

    @JBindingExclude
    private TextPaint text_paint_bitmap;

    @JBindingExclude
    private TextPaint text_paint_size;

    @JBindingExclude
    private float density = 1.0f;

    @JBindingExclude
    private final int kTextLayoutLeftToRight = 0;

    @JBindingExclude
    private final int kTextLayoutUpToDown = 1;

    @JBindingExclude
    private final int kTextAlignmentCenter = 0;

    @JBindingExclude
    private final int kTextAlignmentLeft = 1;

    @JBindingExclude
    private final int kTextAlignmentRight = 2;

    @JBindingInclude
    public static class TextGeneratePOIStyleDesc {
        int fontSize = 0;
        int fontColor = 0;
        int fontBorderColor = 0;
        int fontBgColor = 0;
        int boldFont = 0;
    }

    @JBindingInclude
    public static class TextGenerateTextBitmap {
        byte[] data;
        public int dataId;
        int dataLength;
        double height;
        BitmapDescriptor imageData;
        String text;
        double width;
    }

    @JBindingInclude
    public static class TextGenerateTextStyle {
        int singleLineCharaterLimit = 7;
        int textAlignment = 0;
        int layoutDirection = 0;
    }

    @JBindingExclude
    private NativeTextGenerate() {
        this.text_paint_size = null;
        this.text_paint_bitmap = null;
        this.text_paint_size = new TextPaint();
        this.text_paint_bitmap = new TextPaint();
    }

    @JBindingInclude
    public static NativeTextGenerate getInstance() {
        if (instance == null) {
            synchronized (NativeTextGenerate.class) {
                try {
                    if (instance == null) {
                        instance = new NativeTextGenerate();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    @JBindingExclude
    private StaticLayout setPaintStyle(TextPaint textPaint, TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return null;
        }
        float f2 = textGeneratePOIStyleDesc.fontSize * 1.3f;
        textPaint.setColor(textGeneratePOIStyleDesc.fontColor);
        textPaint.setTextSize(f2);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(textGeneratePOIStyleDesc.boldFont == 1 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        int i3 = textGenerateTextStyle.textAlignment;
        if (i3 == 0) {
            textPaint.setTextAlign(Paint.Align.CENTER);
        } else if (i3 != 2) {
            textPaint.setTextAlign(Paint.Align.LEFT);
        } else {
            textPaint.setTextAlign(Paint.Align.RIGHT);
        }
        int length = textGenerateTextBitmap.text.length();
        int i10 = textGenerateTextStyle.singleLineCharaterLimit;
        if (length > i10 || length % i10 != 0) {
            int i11 = (length / i10) + 1;
            i10 = (length / i11) + (length % i11 <= 0 ? 0 : 1);
        }
        return new StaticLayout(textGenerateTextBitmap.text, textPaint, (int) (f2 * i10), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    @JBindingInclude
    public void calculateTextBoundSize(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        StaticLayout paintStyle = setPaintStyle(this.text_paint_size, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        float measureText = this.text_paint_size.measureText(textGenerateTextBitmap.text);
        Paint.FontMetrics fontMetrics = this.text_paint_size.getFontMetrics();
        textGenerateTextBitmap.width = measureText;
        textGenerateTextBitmap.height = fontMetrics.descent - fontMetrics.ascent;
        textGenerateTextBitmap.width = paintStyle.getWidth();
        textGenerateTextBitmap.height = paintStyle.getHeight();
    }

    @JBindingInclude
    public void generateTextBitmap(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        StaticLayout paintStyle = setPaintStyle(this.text_paint_bitmap, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        Bitmap createBitmap = Bitmap.createBitmap((int) textGenerateTextBitmap.width, (int) textGenerateTextBitmap.height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i3 = textGenerateTextStyle.textAlignment;
        if (i3 == 0) {
            canvas.translate(((float) textGenerateTextBitmap.width) / 2.0f, 0.0f);
        } else if (i3 == 2) {
            canvas.translate((float) textGenerateTextBitmap.width, 0.0f);
        }
        paintStyle.draw(canvas);
        this.text_paint_bitmap.setStyle(Paint.Style.STROKE);
        this.text_paint_bitmap.setStrokeWidth(1.0f);
        this.text_paint_bitmap.setColor(textGeneratePOIStyleDesc.fontBorderColor);
        paintStyle.draw(canvas);
        int i10 = (int) (textGenerateTextBitmap.width * textGenerateTextBitmap.height * 4.0d);
        textGenerateTextBitmap.dataLength = i10;
        textGenerateTextBitmap.data = new byte[i10];
        textGenerateTextBitmap.dataId = v4.a();
        createBitmap.copyPixelsToBuffer(ByteBuffer.wrap(textGenerateTextBitmap.data));
    }

    @JBindingInclude
    public BitmapDescriptor getIconBitmap(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] readFileContentsFromAssetsByPreName = FileUtil.readFileContentsFromAssetsByPreName(a1.f3562f, AMapEngineUtils.MAP_ICONS_ASSETS_NAME, str.concat("_"));
            if (readFileContentsFromAssetsByPreName != null) {
                return BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeByteArray(readFileContentsFromAssetsByPreName, 0, readFileContentsFromAssetsByPreName.length));
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
        return null;
    }

    @JBindingInclude
    public byte[] getMapStyleFileData(String str) {
        try {
            return FileUtil.uncompress(FileUtil.readFileContentsFromAssetsByPreName(a1.f3562f, AMapEngineUtils.MAP_MAP_ASSETS_NAME, str));
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @JBindingExclude
    public void setDensity(float f2) {
        this.density = f2;
    }
}
