package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.R$attr;
import androidx.constraintlayout.widget.R$styleable;
import com.google.android.gms.internal.mlkit_vision_common.g0;
import okhttp3.internal.http2.Settings;
import r5.a;
import u0.b;
import v0.e;

/* loaded from: classes.dex */
public class MotionLabel extends View implements b {
    public float A;
    public float B;
    public Drawable C;
    public Matrix D;
    public Bitmap E;
    public BitmapShader F;
    public Matrix G;
    public float H;
    public float I;
    public float J;
    public float K;
    public final Paint L;
    public int M;
    public Rect N;
    public Paint O;
    public float P;
    public float Q;
    public float R;
    public float S;
    public float T;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f1815a;

    /* renamed from: b, reason: collision with root package name */
    public Path f1816b;

    /* renamed from: c, reason: collision with root package name */
    public int f1817c;

    /* renamed from: d, reason: collision with root package name */
    public int f1818d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public float f1819f;

    /* renamed from: g, reason: collision with root package name */
    public float f1820g;

    /* renamed from: h, reason: collision with root package name */
    public ViewOutlineProvider f1821h;

    /* renamed from: i, reason: collision with root package name */
    public RectF f1822i;

    /* renamed from: j, reason: collision with root package name */
    public float f1823j;

    /* renamed from: k, reason: collision with root package name */
    public float f1824k;

    /* renamed from: l, reason: collision with root package name */
    public int f1825l;

    /* renamed from: m, reason: collision with root package name */
    public int f1826m;

    /* renamed from: n, reason: collision with root package name */
    public float f1827n;

    /* renamed from: o, reason: collision with root package name */
    public String f1828o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1829p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f1830q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f1831s;

    /* renamed from: t, reason: collision with root package name */
    public int f1832t;

    /* renamed from: u, reason: collision with root package name */
    public int f1833u;

    /* renamed from: v, reason: collision with root package name */
    public String f1834v;

    /* renamed from: w, reason: collision with root package name */
    public int f1835w;

    /* renamed from: x, reason: collision with root package name */
    public int f1836x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1837y;

    /* renamed from: z, reason: collision with root package name */
    public float f1838z;

    public MotionLabel(Context context) {
        super(context);
        this.f1815a = new TextPaint();
        this.f1816b = new Path();
        this.f1817c = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f1818d = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.e = false;
        this.f1819f = 0.0f;
        this.f1820g = Float.NaN;
        this.f1823j = 48.0f;
        this.f1824k = Float.NaN;
        this.f1827n = 0.0f;
        this.f1828o = "Hello World";
        this.f1829p = true;
        this.f1830q = new Rect();
        this.r = 1;
        this.f1831s = 1;
        this.f1832t = 1;
        this.f1833u = 1;
        this.f1835w = 8388659;
        this.f1836x = 0;
        this.f1837y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        b(context, null);
    }

    private float getHorizontalOffset() {
        float f2 = Float.isNaN(this.f1824k) ? 1.0f : this.f1823j / this.f1824k;
        String str = this.f1828o;
        return ((this.J + 1.0f) * ((((Float.isNaN(this.A) ? getMeasuredWidth() : this.A) - getPaddingLeft()) - getPaddingRight()) - (this.f1815a.measureText(str, 0, str.length()) * f2))) / 2.0f;
    }

    private float getVerticalOffset() {
        float f2 = Float.isNaN(this.f1824k) ? 1.0f : this.f1823j / this.f1824k;
        Paint.FontMetrics fontMetrics = this.f1815a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.B) ? getMeasuredHeight() : this.B) - getPaddingTop()) - getPaddingBottom();
        float f10 = fontMetrics.descent;
        float f11 = fontMetrics.ascent;
        return (((1.0f - this.K) * (measuredHeight - ((f10 - f11) * f2))) / 2.0f) - (f2 * f11);
    }

    public final void a(float f2) {
        if (this.e || f2 != 1.0f) {
            this.f1816b.reset();
            String str = this.f1828o;
            int length = str.length();
            TextPaint textPaint = this.f1815a;
            Rect rect = this.f1830q;
            textPaint.getTextBounds(str, 0, length, rect);
            this.f1815a.getTextPath(str, 0, length, 0.0f, 0.0f, this.f1816b);
            if (f2 != 1.0f) {
                String a3 = g0.a();
                StringBuilder sb2 = new StringBuilder(a.a(22, a3));
                sb2.append(a3);
                sb2.append(" scale ");
                sb2.append(f2);
                Log.v("MotionLabel", sb2.toString());
                Matrix matrix = new Matrix();
                matrix.postScale(f2, f2);
                this.f1816b.transform(matrix);
            }
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.f1829p = false;
        }
    }

    public final void b(Context context, AttributeSet attributeSet) {
        Typeface typeface;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true);
        int i3 = typedValue.data;
        this.f1817c = i3;
        TextPaint textPaint = this.f1815a;
        textPaint.setColor(i3);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R$styleable.MotionLabel_android_fontFamily) {
                    this.f1834v = obtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MotionLabel_scaleFromTextSize) {
                    this.f1824k = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f1824k);
                } else if (index == R$styleable.MotionLabel_android_textSize) {
                    this.f1823j = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f1823j);
                } else if (index == R$styleable.MotionLabel_android_textStyle) {
                    this.f1825l = obtainStyledAttributes.getInt(index, this.f1825l);
                } else if (index == R$styleable.MotionLabel_android_typeface) {
                    this.f1826m = obtainStyledAttributes.getInt(index, this.f1826m);
                } else if (index == R$styleable.MotionLabel_android_textColor) {
                    this.f1817c = obtainStyledAttributes.getColor(index, this.f1817c);
                } else if (index == R$styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.f1820g);
                    this.f1820g = dimension;
                    setRound(dimension);
                } else if (index == R$styleable.MotionLabel_borderRoundPercent) {
                    float f2 = obtainStyledAttributes.getFloat(index, this.f1819f);
                    this.f1819f = f2;
                    setRoundPercent(f2);
                } else if (index == R$styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R$styleable.MotionLabel_android_autoSizeTextType) {
                    this.f1836x = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.MotionLabel_textOutlineColor) {
                    this.f1818d = obtainStyledAttributes.getInt(index, this.f1818d);
                    this.e = true;
                } else if (index == R$styleable.MotionLabel_textOutlineThickness) {
                    this.f1827n = obtainStyledAttributes.getDimension(index, this.f1827n);
                    this.e = true;
                } else if (index == R$styleable.MotionLabel_textBackground) {
                    this.C = obtainStyledAttributes.getDrawable(index);
                    this.e = true;
                } else if (index == R$styleable.MotionLabel_textBackgroundPanX) {
                    this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                } else if (index == R$styleable.MotionLabel_textBackgroundPanY) {
                    this.R = obtainStyledAttributes.getFloat(index, this.R);
                } else if (index == R$styleable.MotionLabel_textPanX) {
                    this.J = obtainStyledAttributes.getFloat(index, this.J);
                } else if (index == R$styleable.MotionLabel_textPanY) {
                    this.K = obtainStyledAttributes.getFloat(index, this.K);
                } else if (index == R$styleable.MotionLabel_textBackgroundRotate) {
                    this.T = obtainStyledAttributes.getFloat(index, this.T);
                } else if (index == R$styleable.MotionLabel_textBackgroundZoom) {
                    this.S = obtainStyledAttributes.getFloat(index, this.S);
                } else if (index == R$styleable.MotionLabel_textureHeight) {
                    this.H = obtainStyledAttributes.getDimension(index, this.H);
                } else if (index == R$styleable.MotionLabel_textureWidth) {
                    this.I = obtainStyledAttributes.getDimension(index, this.I);
                } else if (index == R$styleable.MotionLabel_textureEffect) {
                    this.M = obtainStyledAttributes.getInt(index, this.M);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.C != null) {
            this.G = new Matrix();
            int intrinsicWidth = this.C.getIntrinsicWidth();
            int intrinsicHeight = this.C.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.I) ? 128 : (int) this.I;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.H) ? 128 : (int) this.H;
            }
            if (this.M != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.E = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.E);
            this.C.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.C.setFilterBitmap(true);
            this.C.draw(canvas);
            if (this.M != 0) {
                Bitmap bitmap = this.E;
                System.nanoTime();
                int width = bitmap.getWidth() / 2;
                int height = bitmap.getHeight() / 2;
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
                for (int i11 = 0; i11 < 4 && width >= 32 && height >= 32; i11++) {
                    width /= 2;
                    height /= 2;
                    createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
                }
                this.E = createScaledBitmap;
            }
            Bitmap bitmap2 = this.E;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.F = new BitmapShader(bitmap2, tileMode, tileMode);
        }
        this.r = getPaddingLeft();
        this.f1831s = getPaddingRight();
        this.f1832t = getPaddingTop();
        this.f1833u = getPaddingBottom();
        String str = this.f1834v;
        int i12 = this.f1826m;
        int i13 = this.f1825l;
        if (str != null) {
            typeface = Typeface.create(str, i13);
            if (typeface != null) {
                setTypeface(typeface);
                textPaint.setColor(this.f1817c);
                textPaint.setStrokeWidth(this.f1827n);
                textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                textPaint.setFlags(128);
                setTextSize(this.f1823j);
                textPaint.setAntiAlias(true);
            }
        } else {
            typeface = null;
        }
        if (i12 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i12 == 2) {
            typeface = Typeface.SERIF;
        } else if (i12 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        if (i13 > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i13) : Typeface.create(typeface, i13);
            setTypeface(defaultFromStyle);
            int i14 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i13;
            textPaint.setFakeBoldText((i14 & 1) != 0);
            textPaint.setTextSkewX((i14 & 2) != 0 ? -0.25f : 0.0f);
        } else {
            textPaint.setFakeBoldText(false);
            textPaint.setTextSkewX(0.0f);
            setTypeface(typeface);
        }
        textPaint.setColor(this.f1817c);
        textPaint.setStrokeWidth(this.f1827n);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setFlags(128);
        setTextSize(this.f1823j);
        textPaint.setAntiAlias(true);
    }

    public final void c(float f2, float f10, float f11, float f12) {
        int i3 = (int) (f2 + 0.5f);
        this.f1838z = f2 - i3;
        int i10 = (int) (f11 + 0.5f);
        int i11 = i10 - i3;
        int i12 = (int) (f12 + 0.5f);
        int i13 = (int) (0.5f + f10);
        int i14 = i12 - i13;
        float f13 = f11 - f2;
        this.A = f13;
        float f14 = f12 - f10;
        this.B = f14;
        if (this.G != null) {
            this.A = f13;
            this.B = f14;
            d();
        }
        if (getMeasuredHeight() == i14 && getMeasuredWidth() == i11) {
            super.layout(i3, i13, i10, i12);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i14, 1073741824));
            super.layout(i3, i13, i10, i12);
        }
        if (this.f1837y) {
            Rect rect = this.N;
            TextPaint textPaint = this.f1815a;
            if (rect == null) {
                this.O = new Paint();
                this.N = new Rect();
                this.O.set(textPaint);
                this.P = this.O.getTextSize();
            }
            this.A = f13;
            this.B = f14;
            Paint paint = this.O;
            String str = this.f1828o;
            paint.getTextBounds(str, 0, str.length(), this.N);
            float height = this.N.height() * 1.3f;
            float f15 = (f13 - this.f1831s) - this.r;
            float f16 = (f14 - this.f1833u) - this.f1832t;
            float width = this.N.width();
            if (width * f16 > height * f15) {
                textPaint.setTextSize((this.P * f15) / width);
            } else {
                textPaint.setTextSize((this.P * f16) / height);
            }
            if (this.e || !Float.isNaN(this.f1824k)) {
                a(Float.isNaN(this.f1824k) ? 1.0f : this.f1823j / this.f1824k);
            }
        }
    }

    public final void d() {
        float f2 = Float.isNaN(this.Q) ? 0.0f : this.Q;
        float f10 = Float.isNaN(this.R) ? 0.0f : this.R;
        float f11 = Float.isNaN(this.S) ? 1.0f : this.S;
        float f12 = Float.isNaN(this.T) ? 0.0f : this.T;
        this.G.reset();
        float width = this.E.getWidth();
        float height = this.E.getHeight();
        float f13 = Float.isNaN(this.I) ? this.A : this.I;
        float f14 = Float.isNaN(this.H) ? this.B : this.H;
        float f15 = f11 * (width * f14 < height * f13 ? f13 / width : f14 / height);
        this.G.postScale(f15, f15);
        float f16 = width * f15;
        float f17 = f13 - f16;
        float f18 = f15 * height;
        float f19 = f14 - f18;
        if (!Float.isNaN(this.H)) {
            f19 = this.H / 2.0f;
        }
        if (!Float.isNaN(this.I)) {
            f17 = this.I / 2.0f;
        }
        this.G.postTranslate((((f2 * f17) + f13) - f16) * 0.5f, (((f10 * f19) + f14) - f18) * 0.5f);
        this.G.postRotate(f12, f13 / 2.0f, f14 / 2.0f);
        this.F.setLocalMatrix(this.G);
    }

    public float getRound() {
        return this.f1820g;
    }

    public float getRoundPercent() {
        return this.f1819f;
    }

    public float getScaleFromTextSize() {
        return this.f1824k;
    }

    public float getTextBackgroundPanX() {
        return this.Q;
    }

    public float getTextBackgroundPanY() {
        return this.R;
    }

    public float getTextBackgroundRotate() {
        return this.T;
    }

    public float getTextBackgroundZoom() {
        return this.S;
    }

    public int getTextOutlineColor() {
        return this.f1818d;
    }

    public float getTextPanX() {
        return this.J;
    }

    public float getTextPanY() {
        return this.K;
    }

    public float getTextureHeight() {
        return this.H;
    }

    public float getTextureWidth() {
        return this.I;
    }

    public Typeface getTypeface() {
        return this.f1815a.getTypeface();
    }

    @Override // android.view.View
    public final void layout(int i3, int i10, int i11, int i12) {
        super.layout(i3, i10, i11, i12);
        boolean isNaN = Float.isNaN(this.f1824k);
        float f2 = isNaN ? 1.0f : this.f1823j / this.f1824k;
        this.A = i11 - i3;
        this.B = i12 - i10;
        if (this.f1837y) {
            Rect rect = this.N;
            TextPaint textPaint = this.f1815a;
            if (rect == null) {
                this.O = new Paint();
                this.N = new Rect();
                this.O.set(textPaint);
                this.P = this.O.getTextSize();
            }
            Paint paint = this.O;
            String str = this.f1828o;
            paint.getTextBounds(str, 0, str.length(), this.N);
            int width = this.N.width();
            int height = (int) (this.N.height() * 1.3f);
            float f10 = (this.A - this.f1831s) - this.r;
            float f11 = (this.B - this.f1833u) - this.f1832t;
            if (isNaN) {
                float f12 = width;
                float f13 = height;
                if (f12 * f11 > f13 * f10) {
                    textPaint.setTextSize((this.P * f10) / f12);
                } else {
                    textPaint.setTextSize((this.P * f11) / f13);
                }
            } else {
                float f14 = width;
                float f15 = height;
                f2 = f14 * f11 > f15 * f10 ? f10 / f14 : f11 / f15;
            }
        }
        if (this.e || !isNaN) {
            float f16 = i3;
            float f17 = i10;
            float f18 = i11;
            float f19 = i12;
            if (this.G != null) {
                this.A = f18 - f16;
                this.B = f19 - f17;
                d();
            }
            a(f2);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f2 = Float.isNaN(this.f1824k) ? 1.0f : this.f1823j / this.f1824k;
        super.onDraw(canvas);
        boolean z5 = this.e;
        TextPaint textPaint = this.f1815a;
        if (!z5 && f2 == 1.0f) {
            canvas.drawText(this.f1828o, this.f1838z + this.r + getHorizontalOffset(), this.f1832t + getVerticalOffset(), textPaint);
            return;
        }
        if (this.f1829p) {
            a(f2);
        }
        if (this.D == null) {
            this.D = new Matrix();
        }
        if (!this.e) {
            float horizontalOffset = this.r + getHorizontalOffset();
            float verticalOffset = this.f1832t + getVerticalOffset();
            this.D.reset();
            this.D.preTranslate(horizontalOffset, verticalOffset);
            this.f1816b.transform(this.D);
            textPaint.setColor(this.f1817c);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            textPaint.setStrokeWidth(this.f1827n);
            canvas.drawPath(this.f1816b, textPaint);
            this.D.reset();
            this.D.preTranslate(-horizontalOffset, -verticalOffset);
            this.f1816b.transform(this.D);
            return;
        }
        Paint paint = this.L;
        paint.set(textPaint);
        this.D.reset();
        float horizontalOffset2 = this.r + getHorizontalOffset();
        float verticalOffset2 = this.f1832t + getVerticalOffset();
        this.D.postTranslate(horizontalOffset2, verticalOffset2);
        this.D.preScale(f2, f2);
        this.f1816b.transform(this.D);
        if (this.F != null) {
            textPaint.setFilterBitmap(true);
            textPaint.setShader(this.F);
        } else {
            textPaint.setColor(this.f1817c);
        }
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setStrokeWidth(this.f1827n);
        canvas.drawPath(this.f1816b, textPaint);
        if (this.F != null) {
            textPaint.setShader(null);
        }
        textPaint.setColor(this.f1818d);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f1827n);
        canvas.drawPath(this.f1816b, textPaint);
        this.D.reset();
        this.D.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.f1816b.transform(this.D);
        textPaint.set(paint);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i10);
        this.f1837y = false;
        this.r = getPaddingLeft();
        this.f1831s = getPaddingRight();
        this.f1832t = getPaddingTop();
        this.f1833u = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            String str = this.f1828o;
            int length = str.length();
            this.f1815a.getTextBounds(str, 0, length, this.f1830q);
            if (mode != 1073741824) {
                size = (int) (r7.width() + 0.99999f);
            }
            size += this.r + this.f1831s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (r6.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f1832t + this.f1833u + fontMetricsInt;
            }
        } else if (this.f1836x != 0) {
            this.f1837y = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i3) {
        if ((i3 & 8388615) == 0) {
            i3 |= 8388611;
        }
        if ((i3 & 112) == 0) {
            i3 |= 48;
        }
        if (i3 != this.f1835w) {
            invalidate();
        }
        this.f1835w = i3;
        int i10 = i3 & 112;
        if (i10 == 48) {
            this.K = -1.0f;
        } else if (i10 != 80) {
            this.K = 0.0f;
        } else {
            this.K = 1.0f;
        }
        int i11 = i3 & 8388615;
        if (i11 != 3) {
            if (i11 != 5) {
                if (i11 != 8388611) {
                    if (i11 != 8388613) {
                        this.J = 0.0f;
                        return;
                    }
                }
            }
            this.J = 1.0f;
            return;
        }
        this.J = -1.0f;
    }

    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f1820g = f2;
            float f10 = this.f1819f;
            this.f1819f = -1.0f;
            setRoundPercent(f10);
            return;
        }
        boolean z5 = this.f1820g != f2;
        this.f1820g = f2;
        if (f2 != 0.0f) {
            if (this.f1816b == null) {
                this.f1816b = new Path();
            }
            if (this.f1822i == null) {
                this.f1822i = new RectF();
            }
            if (this.f1821h == null) {
                e eVar = new e(this, 1);
                this.f1821h = eVar;
                setOutlineProvider(eVar);
            }
            setClipToOutline(true);
            this.f1822i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f1816b.reset();
            Path path = this.f1816b;
            RectF rectF = this.f1822i;
            float f11 = this.f1820g;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f2) {
        boolean z5 = this.f1819f != f2;
        this.f1819f = f2;
        if (f2 != 0.0f) {
            if (this.f1816b == null) {
                this.f1816b = new Path();
            }
            if (this.f1822i == null) {
                this.f1822i = new RectF();
            }
            if (this.f1821h == null) {
                e eVar = new e(this, 0);
                this.f1821h = eVar;
                setOutlineProvider(eVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f1819f) / 2.0f;
            this.f1822i.set(0.0f, 0.0f, width, height);
            this.f1816b.reset();
            this.f1816b.addRoundRect(this.f1822i, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f2) {
        this.f1824k = f2;
    }

    public void setText(CharSequence charSequence) {
        this.f1828o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f2) {
        this.Q = f2;
        d();
        invalidate();
    }

    public void setTextBackgroundPanY(float f2) {
        this.R = f2;
        d();
        invalidate();
    }

    public void setTextBackgroundRotate(float f2) {
        this.T = f2;
        d();
        invalidate();
    }

    public void setTextBackgroundZoom(float f2) {
        this.S = f2;
        d();
        invalidate();
    }

    public void setTextFillColor(int i3) {
        this.f1817c = i3;
        invalidate();
    }

    public void setTextOutlineColor(int i3) {
        this.f1818d = i3;
        this.e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f2) {
        this.f1827n = f2;
        this.e = true;
        if (Float.isNaN(f2)) {
            this.f1827n = 1.0f;
            this.e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f2) {
        this.J = f2;
        invalidate();
    }

    public void setTextPanY(float f2) {
        this.K = f2;
        invalidate();
    }

    public void setTextSize(float f2) {
        this.f1823j = f2;
        String a3 = g0.a();
        float f10 = this.f1824k;
        StringBuilder sb2 = new StringBuilder(a.a(35, a3));
        sb2.append(a3);
        sb2.append("  ");
        sb2.append(f2);
        sb2.append(" / ");
        sb2.append(f10);
        Log.v("MotionLabel", sb2.toString());
        if (!Float.isNaN(this.f1824k)) {
            f2 = this.f1824k;
        }
        this.f1815a.setTextSize(f2);
        a(Float.isNaN(this.f1824k) ? 1.0f : this.f1823j / this.f1824k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f2) {
        this.H = f2;
        d();
        invalidate();
    }

    public void setTextureWidth(float f2) {
        this.I = f2;
        d();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        TextPaint textPaint = this.f1815a;
        if (textPaint.getTypeface() != typeface) {
            textPaint.setTypeface(typeface);
        }
    }

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1815a = new TextPaint();
        this.f1816b = new Path();
        this.f1817c = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f1818d = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.e = false;
        this.f1819f = 0.0f;
        this.f1820g = Float.NaN;
        this.f1823j = 48.0f;
        this.f1824k = Float.NaN;
        this.f1827n = 0.0f;
        this.f1828o = "Hello World";
        this.f1829p = true;
        this.f1830q = new Rect();
        this.r = 1;
        this.f1831s = 1;
        this.f1832t = 1;
        this.f1833u = 1;
        this.f1835w = 8388659;
        this.f1836x = 0;
        this.f1837y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        b(context, attributeSet);
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1815a = new TextPaint();
        this.f1816b = new Path();
        this.f1817c = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f1818d = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.e = false;
        this.f1819f = 0.0f;
        this.f1820g = Float.NaN;
        this.f1823j = 48.0f;
        this.f1824k = Float.NaN;
        this.f1827n = 0.0f;
        this.f1828o = "Hello World";
        this.f1829p = true;
        this.f1830q = new Rect();
        this.r = 1;
        this.f1831s = 1;
        this.f1832t = 1;
        this.f1833u = 1;
        this.f1835w = 8388659;
        this.f1836x = 0;
        this.f1837y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        b(context, attributeSet);
    }
}
