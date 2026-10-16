package com.autonavi.base.ae.gmap.glyph;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GlyphLoader {
    private static Map<String, Typeface> FontFaceMap = new HashMap();

    public static long createGlyphLoader() {
        return nativeCreateGlyphLoader();
    }

    private static String decodeUnicode(short s7) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char) s7);
        return stringBuffer.toString();
    }

    public static void destroyGlyphLoader(long j4) {
        nativeDestroyGlyphLoader(j4);
    }

    private static FontMetricsRequestParam genFontMetricsParam(byte[] bArr) {
        FontMetricsRequestParam fontMetricsRequestParam = new FontMetricsRequestParam();
        fontMetricsRequestParam.fFontSize = GLConvertUtil.getInt(bArr, 0) * 0.001f;
        fontMetricsRequestParam.nFontStyleCode = GLConvertUtil.getInt(bArr, 4);
        int i3 = 12;
        if (1 == GLConvertUtil.getInt(bArr, 8)) {
            int i10 = GLConvertUtil.getInt(bArr, 12);
            fontMetricsRequestParam.strName = new String(bArr, 16, i10);
            i3 = 16 + i10;
        }
        fontMetricsRequestParam.languageArr = new String(bArr, i3 + 4, GLConvertUtil.getInt(bArr, i3));
        return fontMetricsRequestParam;
    }

    private static GlyphRequestParam genGlyphRequestParam(byte[] bArr) {
        GlyphRequestParam glyphRequestParam = new GlyphRequestParam();
        int i3 = GLConvertUtil.getInt(bArr, 0);
        glyphRequestParam.strBuffer = new String(bArr, 4, i3);
        Font font = new Font();
        font.nFontStyleCode = GLConvertUtil.getInt(bArr, i3 + 4);
        font.nFontSize = GLConvertUtil.getInt(bArr, i3 + 8);
        int i10 = GLConvertUtil.getInt(bArr, i3 + 12);
        int i11 = i3 + 16;
        font.strName = new String(bArr, i11, i10);
        int i12 = i11 + i10;
        FontMetrics fontMetrics = new FontMetrics();
        fontMetrics.fAscent = GLConvertUtil.getInt(bArr, i12) * 0.001f;
        fontMetrics.fDescent = GLConvertUtil.getInt(bArr, i12 + 4) * 0.001f;
        fontMetrics.fLeading = GLConvertUtil.getInt(bArr, i12 + 8) * 0.001f;
        fontMetrics.fHeight = GLConvertUtil.getInt(bArr, i12 + 12) * 0.001f;
        font.fontMetrics = fontMetrics;
        glyphRequestParam.font = font;
        glyphRequestParam.drawingMode = GLConvertUtil.getInt(bArr, i12 + 16);
        glyphRequestParam.strokeWidth = GLConvertUtil.getInt(bArr, i12 + 20) * 0.001f;
        int i13 = i12 + 28;
        glyphRequestParam.languageArr = new String(bArr, i13, GLConvertUtil.getInt(bArr, i12 + 24));
        glyphRequestParam.isEmoji = GLConvertUtil.getInt(bArr, i13);
        glyphRequestParam.isSDF = GLConvertUtil.getInt(bArr, i12 + 32);
        int i14 = i12 + 40;
        if (1 == GLConvertUtil.getInt(bArr, i12 + 36)) {
            GlyphMetrics glyphMetrics = new GlyphMetrics();
            glyphMetrics.nWidth = GLConvertUtil.getInt(bArr, i14);
            glyphMetrics.nHeight = GLConvertUtil.getInt(bArr, i12 + 44);
            glyphMetrics.fLeft = GLConvertUtil.getInt(bArr, i12 + 48) * 0.001f;
            glyphMetrics.fTop = GLConvertUtil.getInt(bArr, i12 + 52) * 0.001f;
            glyphMetrics.fAdvance = GLConvertUtil.getInt(bArr, i12 + 56) * 0.001f;
            glyphRequestParam.fGlyphMetrics = glyphMetrics;
        }
        return glyphRequestParam;
    }

    private static FontMetrics getFontMetrics(byte[] bArr) {
        FontMetricsRequestParam genFontMetricsParam = genFontMetricsParam(bArr);
        TextPaint newTextPaint = newTextPaint(new FontStyle(genFontMetricsParam.nFontStyleCode), genFontMetricsParam.fFontSize, genFontMetricsParam.strName, false, 0.0f);
        Paint.FontMetrics fontMetrics = newTextPaint.getFontMetrics();
        FontMetrics fontMetrics2 = new FontMetrics();
        fontMetrics2.bSuccess = true;
        fontMetrics2.fAscent = Math.abs(fontMetrics.ascent);
        fontMetrics2.fDescent = Math.abs(fontMetrics.descent);
        fontMetrics2.fLeading = Math.abs(fontMetrics.leading);
        fontMetrics2.fHeight = Math.abs(fontMetrics.descent) + Math.abs(fontMetrics.ascent);
        newTextPaint.setTypeface(null);
        return fontMetrics2;
    }

    private static GlyphMetrics getGlyphMetrics(byte[] bArr) {
        boolean z5;
        float f2;
        boolean z6;
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        boolean z8 = genGlyphRequestParam.drawingMode != 0;
        String str = genGlyphRequestParam.strBuffer;
        Font font = genGlyphRequestParam.font;
        float f10 = font.nFontSize;
        String str2 = font.strName;
        boolean z10 = false;
        float f11 = genGlyphRequestParam.strokeWidth;
        if (genGlyphRequestParam.isEmoji > 0) {
            z5 = true;
            f2 = f10;
            z6 = true;
        } else {
            z5 = true;
            f2 = f10;
            z6 = false;
        }
        if (genGlyphRequestParam.isSDF > 0) {
            z10 = z5;
        }
        return loadGlyphMetrics(str, fontStyle, f2, str2, z8, f11, z6, z10);
    }

    private static GlyphRaster getGlyphRaster(byte[] bArr) {
        boolean z5;
        float f2;
        boolean z6;
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        int i3 = genGlyphRequestParam.drawingMode;
        boolean z8 = i3 != 0;
        if (i3 == 3) {
            return loadPathRaster(genGlyphRequestParam.strBuffer, fontStyle, r2.nFontSize, genGlyphRequestParam.font.strName, z8, 2.0f * genGlyphRequestParam.strokeWidth);
        }
        String str = genGlyphRequestParam.strBuffer;
        Font font = genGlyphRequestParam.font;
        float f10 = font.nFontSize;
        String str2 = font.strName;
        boolean z10 = false;
        float f11 = genGlyphRequestParam.strokeWidth;
        if (genGlyphRequestParam.isEmoji > 0) {
            z5 = true;
            f2 = f10;
            z6 = true;
        } else {
            z5 = true;
            f2 = f10;
            z6 = false;
        }
        if (genGlyphRequestParam.isSDF > 0) {
            z10 = z5;
        }
        return loadGlyphRaster(str, fontStyle, f2, str2, z8, f11, z6, z10);
    }

    private static GlyphMetrics loadGlyphMetrics(String str, FontStyle fontStyle, float f2, String str2, boolean z5, float f10, boolean z6, boolean z8) {
        GlyphMetrics glyphMetrics = new GlyphMetrics();
        if (fontStyle != null && !TextUtils.isEmpty(str)) {
            try {
                if (z6) {
                    glyphMetrics.bSuccess = true;
                    glyphMetrics.fLeft = 0.0f;
                    glyphMetrics.fTop = 0.0f;
                    int i3 = (int) f2;
                    glyphMetrics.nWidth = i3;
                    glyphMetrics.nHeight = i3;
                    glyphMetrics.fAdvance = f2;
                    return glyphMetrics;
                }
                TextPaint newTextPaint = newTextPaint(fontStyle, f2, str2, z5, f10);
                Rect rect = new Rect();
                newTextPaint.getTextBounds(str, 0, str.length(), rect);
                if (rect.width() == 0 && rect.height() == 0) {
                    float measureText = newTextPaint.measureText(" ", 0, 1);
                    float abs = Math.abs(newTextPaint.getFontMetrics().ascent) + Math.abs(newTextPaint.getFontMetrics().descent);
                    rect.top = 0;
                    rect.left = 0;
                    rect.right = (int) measureText;
                    rect.bottom = (int) abs;
                }
                if (z5 && f10 > 0.0f) {
                    float f11 = f10 / 2.0f;
                    rect.top = (int) (rect.top - f11);
                    rect.left = (int) (rect.left - f11);
                    rect.right = (int) (rect.right + f11);
                    rect.bottom = (int) (rect.bottom + f11);
                }
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = rect.left;
                glyphMetrics.fTop = Math.abs(newTextPaint.getFontMetrics().ascent) - Math.abs(rect.top);
                glyphMetrics.nWidth = rect.width();
                glyphMetrics.nHeight = rect.height();
                glyphMetrics.fAdvance = newTextPaint.measureText(str);
                newTextPaint.setTypeface(null);
                return glyphMetrics;
            } catch (Exception unused) {
                glyphMetrics.bSuccess = false;
            }
        }
        return glyphMetrics;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb A[Catch: Exception -> 0x014d, TryCatch #0 {Exception -> 0x014d, blocks: (B:16:0x005d, B:18:0x0074, B:20:0x007a, B:24:0x00a6, B:25:0x00c5, B:27:0x00cb, B:34:0x00dc, B:36:0x0119, B:39:0x011f, B:41:0x0123, B:43:0x0130, B:46:0x0134, B:48:0x013a, B:49:0x013f, B:50:0x013d, B:52:0x00d4, B:53:0x0149), top: B:15:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0119 A[Catch: Exception -> 0x014d, TryCatch #0 {Exception -> 0x014d, blocks: (B:16:0x005d, B:18:0x0074, B:20:0x007a, B:24:0x00a6, B:25:0x00c5, B:27:0x00cb, B:34:0x00dc, B:36:0x0119, B:39:0x011f, B:41:0x0123, B:43:0x0130, B:46:0x0134, B:48:0x013a, B:49:0x013f, B:50:0x013d, B:52:0x00d4, B:53:0x0149), top: B:15:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013a A[Catch: Exception -> 0x014d, TryCatch #0 {Exception -> 0x014d, blocks: (B:16:0x005d, B:18:0x0074, B:20:0x007a, B:24:0x00a6, B:25:0x00c5, B:27:0x00cb, B:34:0x00dc, B:36:0x0119, B:39:0x011f, B:41:0x0123, B:43:0x0130, B:46:0x0134, B:48:0x013a, B:49:0x013f, B:50:0x013d, B:52:0x00d4, B:53:0x0149), top: B:15:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013d A[Catch: Exception -> 0x014d, TryCatch #0 {Exception -> 0x014d, blocks: (B:16:0x005d, B:18:0x0074, B:20:0x007a, B:24:0x00a6, B:25:0x00c5, B:27:0x00cb, B:34:0x00dc, B:36:0x0119, B:39:0x011f, B:41:0x0123, B:43:0x0130, B:46:0x0134, B:48:0x013a, B:49:0x013f, B:50:0x013d, B:52:0x00d4, B:53:0x0149), top: B:15:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.autonavi.base.ae.gmap.glyph.GlyphRaster loadGlyphRaster(java.lang.String r8, com.autonavi.base.ae.gmap.glyph.FontStyle r9, float r10, java.lang.String r11, boolean r12, float r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.glyph.GlyphLoader.loadGlyphRaster(java.lang.String, com.autonavi.base.ae.gmap.glyph.FontStyle, float, java.lang.String, boolean, float, boolean, boolean):com.autonavi.base.ae.gmap.glyph.GlyphRaster");
    }

    public static GlyphRaster loadPathRaster(String str, FontStyle fontStyle, float f2, String str2, boolean z5, float f10) {
        GlyphRaster glyphRaster = new GlyphRaster();
        if (fontStyle != null && !TextUtils.isEmpty(str)) {
            try {
                TextPaint newTextPaint = newTextPaint(fontStyle, f2, str2, false, 0.0f);
                Rect rect = new Rect();
                newTextPaint.getTextBounds(str, 0, str.length(), rect);
                int width = rect.width();
                int height = rect.height();
                Bitmap.Config config = Bitmap.Config.ALPHA_8;
                new Canvas(Bitmap.createBitmap(width, height, config)).drawText(str, 0 - rect.left, 0 - rect.top, newTextPaint);
                TextPaint newTextPaint2 = newTextPaint(fontStyle, f2, str2, z5, f10);
                Rect rect2 = new Rect();
                newTextPaint2.getTextBounds(str, 0, str.length(), rect2);
                if (z5 && f10 > 0.0f) {
                    float f11 = f10 * 0.5f;
                    rect2.top = (int) (rect2.top - f11);
                    rect2.left = (int) (rect2.left - f11);
                    rect2.right = (int) (rect2.right + f11);
                    rect2.bottom = (int) (rect2.bottom + f11);
                }
                if (!rect2.isEmpty()) {
                    Bitmap createBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), config);
                    Canvas canvas = new Canvas(createBitmap);
                    float f12 = 0 - rect2.left;
                    float f13 = 0 - rect2.top;
                    Path path = new Path();
                    newTextPaint.getTextPath(str, 0, str.length(), f12, f13, path);
                    canvas.drawPath(path, newTextPaint2);
                    int width2 = rect2.width() * rect2.height();
                    byte[] bArr = new byte[width2];
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    glyphRaster.bitmapWidth = rect2.width();
                    glyphRaster.bitmapHeight = rect2.height();
                    glyphRaster.bitmapPixelMode = 0;
                    glyphRaster.bitmapSize = width2;
                    createBitmap.copyPixelsToBuffer(wrap);
                    createBitmap.recycle();
                    glyphRaster.bitmapBuffer = bArr;
                    glyphRaster.bSuccess = true;
                }
                newTextPaint.setTypeface(null);
                newTextPaint2.setTypeface(null);
                return glyphRaster;
            } catch (Exception unused) {
                glyphRaster.bSuccess = false;
            }
        }
        return glyphRaster;
    }

    private static native long nativeCreateGlyphLoader();

    private static native void nativeDestroyGlyphLoader(long j4);

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0068, code lost:
    
        if (r4 != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.text.TextPaint newTextPaint(com.autonavi.base.ae.gmap.glyph.FontStyle r3, float r4, java.lang.String r5, boolean r6, float r7) {
        /*
            android.text.TextPaint r0 = new android.text.TextPaint
            r0.<init>()
            if (r3 != 0) goto L8
            return r0
        L8:
            r1 = -1
            r0.setColor(r1)
            r1 = 1
            r0.setAntiAlias(r1)
            r0.setFilterBitmap(r1)
            r0.setTextSize(r4)
            android.graphics.Paint$Align r4 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r4)
            if (r6 == 0) goto L26
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r4)
            r0.setStrokeWidth(r7)
            goto L2b
        L26:
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            r0.setStyle(r4)
        L2b:
            int r4 = r3.getSlant()
            r6 = 2
            r7 = 0
            if (r4 == 0) goto L3a
            if (r4 == r1) goto L38
            if (r4 == r6) goto L38
            goto L3a
        L38:
            r4 = r1
            goto L3b
        L3a:
            r4 = r7
        L3b:
            int r3 = r3.getWeight()
            r2 = 500(0x1f4, float:7.0E-43)
            if (r3 == r2) goto L59
            r2 = 600(0x258, float:8.41E-43)
            if (r3 == r2) goto L59
            r2 = 700(0x2bc, float:9.81E-43)
            if (r3 == r2) goto L59
            r2 = 800(0x320, float:1.121E-42)
            if (r3 == r2) goto L59
            r2 = 900(0x384, float:1.261E-42)
            if (r3 == r2) goto L59
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r3 == r2) goto L59
            r3 = r7
            goto L5a
        L59:
            r3 = r1
        L5a:
            if (r3 == 0) goto L62
            if (r4 == 0) goto L62
            r0.setFakeBoldText(r1)
            goto L6b
        L62:
            if (r3 == 0) goto L68
            r0.setFakeBoldText(r1)
            goto L6b
        L68:
            if (r4 == 0) goto L6b
            goto L6c
        L6b:
            r6 = r7
        L6c:
            boolean r3 = r5.isEmpty()
            if (r3 != 0) goto L96
            java.util.Map<java.lang.String, android.graphics.Typeface> r3 = com.autonavi.base.ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Exception -> L8f
            monitor-enter(r3)     // Catch: java.lang.Exception -> L8f
            java.util.Map<java.lang.String, android.graphics.Typeface> r4 = com.autonavi.base.ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Throwable -> L89
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L89
            android.graphics.Typeface r4 = (android.graphics.Typeface) r4     // Catch: java.lang.Throwable -> L89
            if (r4 != 0) goto L8b
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromFile(r5)     // Catch: java.lang.Throwable -> L89
            java.util.Map<java.lang.String, android.graphics.Typeface> r7 = com.autonavi.base.ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Throwable -> L89
            r7.put(r5, r4)     // Catch: java.lang.Throwable -> L89
            goto L8b
        L89:
            r4 = move-exception
            goto L8d
        L8b:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L89
            goto L9c
        L8d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L89
            throw r4     // Catch: java.lang.Exception -> L8f
        L8f:
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r3, r6)
            goto L9c
        L96:
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r3, r6)
        L9c:
            r0.setTypeface(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.glyph.GlyphLoader.newTextPaint(com.autonavi.base.ae.gmap.glyph.FontStyle, float, java.lang.String, boolean, float):android.text.TextPaint");
    }

    private static String decodeUnicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
