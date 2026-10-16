package com.dh.imagepick.crop;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import c5.c;
import com.dh.imagepick.R;

/* loaded from: classes.dex */
public class CropImageView extends AppCompatImageView {
    public static final c5.b H = new c5.b(Looper.getMainLooper(), 0, false);
    public static c I;
    public float A;
    public int B;
    public float C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;

    /* renamed from: d, reason: collision with root package name */
    public int f7083d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f7084f;

    /* renamed from: g, reason: collision with root package name */
    public int f7085g;

    /* renamed from: h, reason: collision with root package name */
    public int f7086h;

    /* renamed from: i, reason: collision with root package name */
    public Style f7087i;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f7088j;

    /* renamed from: k, reason: collision with root package name */
    public final Path f7089k;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f7090l;

    /* renamed from: m, reason: collision with root package name */
    public int f7091m;

    /* renamed from: n, reason: collision with root package name */
    public int f7092n;

    /* renamed from: o, reason: collision with root package name */
    public int f7093o;

    /* renamed from: p, reason: collision with root package name */
    public int f7094p;

    /* renamed from: q, reason: collision with root package name */
    public Matrix f7095q;
    public final Matrix r;

    /* renamed from: s, reason: collision with root package name */
    public final PointF f7096s;

    /* renamed from: t, reason: collision with root package name */
    public final PointF f7097t;

    /* renamed from: u, reason: collision with root package name */
    public final PointF f7098u;

    /* renamed from: v, reason: collision with root package name */
    public final PointF f7099v;

    /* renamed from: w, reason: collision with root package name */
    public PointF f7100w;

    /* renamed from: x, reason: collision with root package name */
    public int f7101x;

    /* renamed from: y, reason: collision with root package name */
    public long f7102y;

    /* renamed from: z, reason: collision with root package name */
    public double f7103z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Style {
        public static final Style CIRCLE;
        public static final Style RECTANGLE;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f7104a;

        static {
            Style style = new Style("RECTANGLE", 0);
            RECTANGLE = style;
            Style style2 = new Style("CIRCLE", 1);
            CIRCLE = style2;
            f7104a = new Style[]{style, style2};
        }

        public static Style valueOf(String str) {
            return (Style) Enum.valueOf(Style.class, str);
        }

        public static Style[] values() {
            return (Style[]) f7104a.clone();
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public static float e(int i3, int i10, int i11, int i12, boolean z5) {
        float f2 = i11 / i3;
        float f10 = i12 / i10;
        return z5 ? Math.max(f2, f10) : Math.min(f2, f10);
    }

    public static Bitmap g(int i3, Bitmap bitmap) {
        Bitmap bitmap2;
        if (i3 == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i3, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            bitmap2 = bitmap;
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                return bitmap2 != createBitmap ? createBitmap : bitmap2;
            } catch (OutOfMemoryError e) {
                e = e;
                e.printStackTrace();
                return bitmap2;
            }
        } catch (OutOfMemoryError e10) {
            e = e10;
            bitmap2 = bitmap;
        }
    }

    private RectF getImageMatrixRect() {
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        this.f7095q.mapRect(rectF);
        return rectF;
    }

    public static float i(float f2, float f10, float f11, float f12) {
        float f13 = f2 - f11;
        float f14 = f10 - f12;
        return (float) Math.sqrt((f14 * f14) + (f13 * f13));
    }

    public final void c() {
        float[] fArr = new float[9];
        this.f7095q.getValues(fArr);
        float abs = Math.abs(fArr[1]) + Math.abs(fArr[0]);
        float e = e(this.f7093o, this.f7094p, this.F, this.G, true);
        float f2 = 4.0f * e;
        this.C = f2;
        if (abs < e) {
            float f10 = e / abs;
            this.f7095q.postScale(f10, f10);
        } else if (abs > f2) {
            float f11 = f2 / abs;
            this.f7095q.postScale(f11, f11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r7 = this;
            android.graphics.RectF r0 = new android.graphics.RectF
            int r1 = r7.f7091m
            float r1 = (float) r1
            int r2 = r7.f7092n
            float r2 = (float) r2
            r3 = 0
            r0.<init>(r3, r3, r1, r2)
            android.graphics.Matrix r1 = r7.f7095q
            r1.mapRect(r0)
            float r1 = r0.left
            android.graphics.RectF r2 = r7.f7090l
            float r4 = r2.left
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L1e
        L1b:
            float r1 = -r1
            float r1 = r1 + r4
            goto L28
        L1e:
            float r1 = r0.right
            float r4 = r2.right
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 >= 0) goto L27
            goto L1b
        L27:
            r1 = r3
        L28:
            float r4 = r0.top
            float r5 = r2.top
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 <= 0) goto L34
            float r0 = -r4
            float r3 = r0 + r5
            goto L3f
        L34:
            float r0 = r0.bottom
            float r2 = r2.bottom
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L3f
            float r0 = -r0
            float r3 = r0 + r2
        L3f:
            android.graphics.Matrix r0 = r7.f7095q
            r0.postTranslate(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dh.imagepick.crop.CropImageView.d():void");
    }

    public final void f() {
        postDelayed(new a(this), 50L);
    }

    public float getBorderWidth() {
        return this.f7084f;
    }

    public int getFocusColor() {
        return this.e;
    }

    public int getFocusHeight() {
        return this.f7086h;
    }

    public Style getFocusStyle() {
        return this.f7087i;
    }

    public int getFocusWidth() {
        return this.f7085g;
    }

    public int getMaskColor() {
        return this.f7083d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        if (r12 > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
    
        r1 = r2.getWidth();
        r3 = r2.getWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008e, code lost:
    
        if ((r1 / 2) <= r11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0092, code lost:
    
        if ((r3 / 2) <= r12) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0094, code lost:
    
        r1 = android.graphics.Bitmap.createScaledBitmap(android.graphics.Bitmap.createScaledBitmap(r2, r11 * 2, r12 * 2, true), r11, r12, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
    
        r1 = android.graphics.Bitmap.createScaledBitmap(r2, r11, r12, true);
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0104 A[Catch: IOException -> 0x0108, TRY_LEAVE, TryCatch #0 {IOException -> 0x0108, blocks: (B:53:0x00f7, B:55:0x0104), top: B:52:0x00f7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(java.io.File r10, int r11, int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dh.imagepick.crop.CropImageView.h(java.io.File, int, int, boolean):void");
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Style style = Style.RECTANGLE;
        Style style2 = this.f7087i;
        RectF rectF = this.f7090l;
        Path path = this.f7089k;
        if (style == style2) {
            path.addRect(rectF, Path.Direction.CCW);
            canvas.save();
            canvas.clipRect(0, 0, getWidth(), getHeight());
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawColor(this.f7083d);
            canvas.restore();
        } else if (Style.CIRCLE == style2) {
            float min = Math.min((rectF.right - rectF.left) / 2.0f, (rectF.bottom - rectF.top) / 2.0f);
            PointF pointF = this.f7100w;
            path.addCircle(pointF.x, pointF.y, min, Path.Direction.CCW);
            canvas.save();
            canvas.clipRect(0, 0, getWidth(), getHeight());
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawColor(this.f7083d);
            canvas.restore();
        }
        Paint paint = this.f7088j;
        paint.setColor(this.e);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f7084f);
        paint.setAntiAlias(true);
        canvas.drawPath(path, paint);
        path.reset();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        super.onSizeChanged(i3, i10, i11, i12);
        this.D = true;
        f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r2 != 6) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r31) {
        /*
            Method dump skipped, instructions count: 821
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dh.imagepick.crop.CropImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBorderColor(int i3) {
        this.e = i3;
        invalidate();
    }

    public void setBorderWidth(int i3) {
        this.f7084f = i3;
        invalidate();
    }

    public void setFocusHeight(int i3) {
        this.f7086h = i3;
        f();
    }

    public void setFocusStyle(Style style) {
        this.f7087i = style;
        invalidate();
    }

    public void setFocusWidth(int i3) {
        this.f7085g = i3;
        f();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        f();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        f();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        f();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        f();
    }

    public void setMaskColor(int i3) {
        this.f7083d = i3;
        invalidate();
    }

    public void setMinHeight(int i3) {
        this.G = Math.max(this.f7086h, i3);
    }

    public void setMinWidth(int i3) {
        this.F = Math.max(this.f7085g, i3);
    }

    public void setOnBitmapSaveCompleteListener(c cVar) {
        I = cVar;
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Style[] styleArr = {Style.RECTANGLE, Style.CIRCLE};
        this.f7083d = -1358954496;
        this.e = -1434419072;
        this.f7084f = 1;
        this.f7085g = 250;
        this.f7086h = 250;
        this.f7087i = styleArr[0];
        this.f7088j = new Paint();
        this.f7089k = new Path();
        this.f7090l = new RectF();
        this.f7095q = new Matrix();
        this.r = new Matrix();
        this.f7096s = new PointF();
        this.f7097t = new PointF();
        this.f7098u = new PointF();
        this.f7099v = new PointF();
        this.f7100w = new PointF();
        this.f7101x = 0;
        this.f7102y = 0L;
        this.f7103z = 0.0d;
        this.A = 1.0f;
        this.B = 0;
        this.C = 4.0f;
        this.D = false;
        this.E = false;
        this.f7085g = (int) TypedValue.applyDimension(1, this.f7085g, getResources().getDisplayMetrics());
        this.f7086h = (int) TypedValue.applyDimension(1, this.f7086h, getResources().getDisplayMetrics());
        this.f7084f = (int) TypedValue.applyDimension(1, this.f7084f, getResources().getDisplayMetrics());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CropImageView);
        this.f7083d = obtainStyledAttributes.getColor(R.styleable.CropImageView_cropMaskColor, this.f7083d);
        this.e = obtainStyledAttributes.getColor(R.styleable.CropImageView_cropBorderColor, this.e);
        this.f7084f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CropImageView_cropBorderWidth, this.f7084f);
        this.f7085g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CropImageView_cropFocusWidth, this.f7085g);
        this.f7086h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CropImageView_cropFocusHeight, this.f7086h);
        this.f7087i = styleArr[obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropStyle, 0)];
        obtainStyledAttributes.recycle();
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
