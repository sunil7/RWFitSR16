package com.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.google.android.gms.internal.mlkit_vision_common.c0;

/* loaded from: classes.dex */
public class ScanBoxView extends View {
    public int A;
    public boolean B;
    public String C;
    public String D;
    public String E;
    public int F;
    public int G;
    public boolean H;
    public int I;
    public boolean J;
    public int K;
    public boolean L;
    public boolean M;
    public boolean N;
    public Drawable O;
    public Bitmap P;
    public float Q;
    public float R;
    public Bitmap S;
    public Bitmap T;
    public Bitmap U;
    public Bitmap V;
    public float W;

    /* renamed from: a, reason: collision with root package name */
    public int f6873a;

    /* renamed from: a0, reason: collision with root package name */
    public StaticLayout f6874a0;

    /* renamed from: b, reason: collision with root package name */
    public int f6875b;

    /* renamed from: b0, reason: collision with root package name */
    public int f6876b0;

    /* renamed from: c, reason: collision with root package name */
    public Rect f6877c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f6878c0;

    /* renamed from: d, reason: collision with root package name */
    public float f6879d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f6880d0;
    public float e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f6881e0;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f6882f;

    /* renamed from: f0, reason: collision with root package name */
    public QRCodeView f6883f0;

    /* renamed from: g, reason: collision with root package name */
    public final TextPaint f6884g;

    /* renamed from: h, reason: collision with root package name */
    public int f6885h;

    /* renamed from: i, reason: collision with root package name */
    public int f6886i;

    /* renamed from: j, reason: collision with root package name */
    public int f6887j;

    /* renamed from: k, reason: collision with root package name */
    public int f6888k;

    /* renamed from: l, reason: collision with root package name */
    public int f6889l;

    /* renamed from: m, reason: collision with root package name */
    public int f6890m;

    /* renamed from: n, reason: collision with root package name */
    public int f6891n;

    /* renamed from: o, reason: collision with root package name */
    public int f6892o;

    /* renamed from: p, reason: collision with root package name */
    public int f6893p;

    /* renamed from: q, reason: collision with root package name */
    public int f6894q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6895s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f6896t;

    /* renamed from: u, reason: collision with root package name */
    public Bitmap f6897u;

    /* renamed from: v, reason: collision with root package name */
    public int f6898v;

    /* renamed from: w, reason: collision with root package name */
    public int f6899w;

    /* renamed from: x, reason: collision with root package name */
    public int f6900x;

    /* renamed from: y, reason: collision with root package name */
    public float f6901y;

    /* renamed from: z, reason: collision with root package name */
    public int f6902z;

    public ScanBoxView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f6882f = paint;
        paint.setAntiAlias(true);
        this.f6885h = Color.parseColor("#33FFFFFF");
        this.f6886i = -1;
        this.f6887j = c0.d(context, 20.0f);
        this.f6888k = c0.d(context, 3.0f);
        this.f6893p = c0.d(context, 1.0f);
        this.f6894q = -1;
        this.f6892o = c0.d(context, 90.0f);
        this.f6889l = c0.d(context, 200.0f);
        this.f6891n = c0.d(context, 140.0f);
        this.r = 0;
        this.f6895s = false;
        this.f6896t = null;
        this.f6897u = null;
        this.f6898v = c0.d(context, 1.0f);
        this.f6899w = -1;
        this.f6900x = 1000;
        this.f6901y = -1.0f;
        this.f6902z = 1;
        this.A = 0;
        this.B = false;
        this.f6873a = c0.d(context, 2.0f);
        this.E = null;
        this.F = (int) TypedValue.applyDimension(2, 14.0f, context.getResources().getDisplayMetrics());
        this.G = -1;
        this.H = false;
        this.I = c0.d(context, 20.0f);
        this.J = false;
        this.K = Color.parseColor("#22000000");
        this.L = false;
        this.M = false;
        this.N = false;
        TextPaint textPaint = new TextPaint();
        this.f6884g = textPaint;
        textPaint.setAntiAlias(true);
        this.f6876b0 = c0.d(context, 4.0f);
        this.f6878c0 = false;
        this.f6880d0 = false;
        this.f6881e0 = false;
    }

    public final void a() {
        int width = (getWidth() - this.f6889l) / 2;
        int i3 = this.f6892o;
        this.f6877c = new Rect(width, i3, this.f6889l + width, this.f6890m + i3);
        if (this.B) {
            float f2 = r1.left + this.W + 0.5f;
            this.e = f2;
            this.R = f2;
        } else {
            float f10 = r1.top + this.W + 0.5f;
            this.f6879d = f10;
            this.Q = f10;
        }
        QRCodeView qRCodeView = this.f6883f0;
        if (qRCodeView == null || !this.f6878c0) {
            return;
        }
        Rect rect = new Rect(this.f6877c);
        CameraPreview cameraPreview = qRCodeView.f6861b;
        if (cameraPreview.f6853a == null || rect.left <= 0 || rect.top <= 0) {
            return;
        }
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int width2 = rect.width() / 2;
        int height = rect.height() / 2;
        c0.j(rect);
        if (c0.h(cameraPreview.getContext())) {
            centerY = centerX;
            centerX = centerY;
            height = width2;
            width2 = height;
        }
        Rect rect2 = new Rect(centerX - width2, centerY - height, centerX + width2, centerY + height);
        c0.j(rect2);
        cameraPreview.a(rect2.centerX(), rect2.centerY(), rect2.width(), rect2.height());
    }

    public final Rect b(int i3) {
        if (!this.f6878c0 || getVisibility() != 0) {
            return null;
        }
        Rect rect = new Rect(this.f6877c);
        float measuredHeight = (i3 * 1.0f) / getMeasuredHeight();
        float exactCenterX = rect.exactCenterX() * measuredHeight;
        float exactCenterY = rect.exactCenterY() * measuredHeight;
        float width = (rect.width() / 2.0f) * measuredHeight;
        float height = (rect.height() / 2.0f) * measuredHeight;
        rect.left = (int) (exactCenterX - width);
        rect.right = (int) (exactCenterX + width);
        rect.top = (int) (exactCenterY - height);
        rect.bottom = (int) (exactCenterY + height);
        return rect;
    }

    public final void c() {
        if (this.O != null || this.N) {
            if (this.B) {
                this.P = this.V;
            } else {
                this.P = this.U;
            }
        } else if (this.f6896t != null || this.f6895s) {
            if (this.B) {
                this.f6897u = this.T;
            } else {
                this.f6897u = this.S;
            }
        }
        if (this.B) {
            this.E = this.D;
            this.f6890m = this.f6891n;
            this.f6875b = (int) (((this.f6900x * 1.0f) * this.f6873a) / this.f6889l);
        } else {
            this.E = this.C;
            int i3 = this.f6889l;
            this.f6890m = i3;
            this.f6875b = (int) (((this.f6900x * 1.0f) * this.f6873a) / i3);
        }
        if (!TextUtils.isEmpty(this.E)) {
            boolean z5 = this.J;
            TextPaint textPaint = this.f6884g;
            if (z5) {
                this.f6874a0 = new StaticLayout(this.E, textPaint, c0.f(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.f6874a0 = new StaticLayout(this.E, textPaint, this.f6889l - (this.f6876b0 * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.f6901y != -1.0f) {
            int g10 = c0.f(getContext()).y - c0.g(getContext());
            int i10 = this.A;
            if (i10 == 0) {
                this.f6892o = (int) ((g10 * this.f6901y) - (this.f6890m / 2));
            } else {
                this.f6892o = i10 + ((int) (((g10 - i10) * this.f6901y) - (this.f6890m / 2)));
            }
        }
        a();
        postInvalidate();
    }

    public int getAnimTime() {
        return this.f6900x;
    }

    public String getBarCodeTipText() {
        return this.D;
    }

    public int getBarcodeRectHeight() {
        return this.f6891n;
    }

    public int getBorderColor() {
        return this.f6899w;
    }

    public int getBorderSize() {
        return this.f6898v;
    }

    public int getCornerColor() {
        return this.f6886i;
    }

    public int getCornerLength() {
        return this.f6887j;
    }

    public int getCornerSize() {
        return this.f6888k;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.f6896t;
    }

    public float getHalfCornerSize() {
        return this.W;
    }

    public boolean getIsBarcode() {
        return this.B;
    }

    public int getMaskColor() {
        return this.f6885h;
    }

    public String getQRCodeTipText() {
        return this.C;
    }

    public int getRectHeight() {
        return this.f6890m;
    }

    public int getRectWidth() {
        return this.f6889l;
    }

    public Bitmap getScanLineBitmap() {
        return this.f6897u;
    }

    public int getScanLineColor() {
        return this.f6894q;
    }

    public int getScanLineMargin() {
        return this.r;
    }

    public int getScanLineSize() {
        return this.f6893p;
    }

    public int getTipBackgroundColor() {
        return this.K;
    }

    public int getTipBackgroundRadius() {
        return this.f6876b0;
    }

    public String getTipText() {
        return this.E;
    }

    public int getTipTextColor() {
        return this.G;
    }

    public int getTipTextMargin() {
        return this.I;
    }

    public int getTipTextSize() {
        return this.F;
    }

    public StaticLayout getTipTextSl() {
        return this.f6874a0;
    }

    public int getToolbarHeight() {
        return this.A;
    }

    public int getTopOffset() {
        return this.f6892o;
    }

    public float getVerticalBias() {
        return this.f6901y;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (this.f6877c == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int i3 = this.f6885h;
        Paint paint = this.f6882f;
        if (i3 != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.f6885h);
            float f2 = width;
            canvas2 = canvas;
            canvas2.drawRect(0.0f, 0.0f, f2, this.f6877c.top, paint);
            Rect rect = this.f6877c;
            canvas2.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, paint);
            Rect rect2 = this.f6877c;
            canvas2.drawRect(rect2.right + 1, rect2.top, f2, rect2.bottom + 1, paint);
            canvas2.drawRect(0.0f, this.f6877c.bottom + 1, f2, height, paint);
        } else {
            canvas2 = canvas;
        }
        if (this.f6898v > 0) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(this.f6899w);
            paint.setStrokeWidth(this.f6898v);
            canvas2.drawRect(this.f6877c, paint);
        }
        if (this.W > 0.0f) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(this.f6886i);
            paint.setStrokeWidth(this.f6888k);
            int i10 = this.f6902z;
            if (i10 == 1) {
                Rect rect3 = this.f6877c;
                float f10 = rect3.left - this.W;
                float f11 = rect3.top;
                canvas2.drawLine(f10, f11, f10 + this.f6887j, f11, paint);
                float f12 = this.f6877c.left;
                float f13 = r13.top - this.W;
                canvas2.drawLine(f12, f13, f12, f13 + this.f6887j, paint);
                Rect rect4 = this.f6877c;
                float f14 = rect4.right + this.W;
                float f15 = rect4.top;
                canvas2.drawLine(f14, f15, f14 - this.f6887j, f15, paint);
                float f16 = this.f6877c.right;
                float f17 = r13.top - this.W;
                canvas2.drawLine(f16, f17, f16, f17 + this.f6887j, paint);
                Rect rect5 = this.f6877c;
                float f18 = rect5.left - this.W;
                float f19 = rect5.bottom;
                canvas2.drawLine(f18, f19, f18 + this.f6887j, f19, paint);
                float f20 = this.f6877c.left;
                float f21 = r13.bottom + this.W;
                canvas2.drawLine(f20, f21, f20, f21 - this.f6887j, paint);
                Rect rect6 = this.f6877c;
                float f22 = rect6.right + this.W;
                float f23 = rect6.bottom;
                canvas2.drawLine(f22, f23, f22 - this.f6887j, f23, paint);
                float f24 = this.f6877c.right;
                float f25 = r13.bottom + this.W;
                canvas2.drawLine(f24, f25, f24, f25 - this.f6887j, paint);
            } else if (i10 == 2) {
                int i11 = this.f6877c.left;
                float f26 = r13.top + this.W;
                canvas2.drawLine(i11, f26, i11 + this.f6887j, f26, paint);
                Rect rect7 = this.f6877c;
                float f27 = rect7.left + this.W;
                canvas2.drawLine(f27, rect7.top, f27, r13 + this.f6887j, paint);
                int i12 = this.f6877c.right;
                float f28 = r13.top + this.W;
                canvas2.drawLine(i12, f28, i12 - this.f6887j, f28, paint);
                Rect rect8 = this.f6877c;
                float f29 = rect8.right - this.W;
                canvas2.drawLine(f29, rect8.top, f29, r13 + this.f6887j, paint);
                int i13 = this.f6877c.left;
                float f30 = r13.bottom - this.W;
                canvas2.drawLine(i13, f30, i13 + this.f6887j, f30, paint);
                Rect rect9 = this.f6877c;
                float f31 = rect9.left + this.W;
                canvas2.drawLine(f31, rect9.bottom, f31, r13 - this.f6887j, paint);
                int i14 = this.f6877c.right;
                float f32 = r13.bottom - this.W;
                canvas2.drawLine(i14, f32, i14 - this.f6887j, f32, paint);
                Rect rect10 = this.f6877c;
                float f33 = rect10.right - this.W;
                canvas2.drawLine(f33, rect10.bottom, f33, r13 - this.f6887j, paint);
            }
        }
        if (this.B) {
            if (this.P != null) {
                float f34 = this.f6877c.left;
                float f35 = this.W;
                float f36 = this.r;
                RectF rectF = new RectF(f34 + f35 + 0.5f, r5.top + f35 + f36, this.R, (r5.bottom - f35) - f36);
                Rect rect11 = new Rect((int) (this.P.getWidth() - rectF.width()), 0, this.P.getWidth(), this.P.getHeight());
                if (rect11.left < 0) {
                    rect11.left = 0;
                    rectF.left = rectF.right - rect11.width();
                }
                canvas2.drawBitmap(this.P, rect11, rectF, paint);
            } else if (this.f6897u != null) {
                float f37 = this.e;
                canvas2.drawBitmap(this.f6897u, (Rect) null, new RectF(f37, this.f6877c.top + this.W + this.r, this.f6897u.getWidth() + f37, (this.f6877c.bottom - this.W) - this.r), paint);
            } else {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(this.f6894q);
                float f38 = this.e;
                float f39 = this.f6877c.top;
                float f40 = this.W;
                float f41 = this.r;
                canvas2.drawRect(f38, f39 + f40 + f41, this.f6893p + f38, (r13.bottom - f40) - f41, paint);
            }
        } else if (this.P != null) {
            float f42 = this.f6877c.left;
            float f43 = this.W;
            float f44 = this.r;
            RectF rectF2 = new RectF(f42 + f43 + f44, r5.top + f43 + 0.5f, (r5.right - f43) - f44, this.Q);
            Rect rect12 = new Rect(0, (int) (this.P.getHeight() - rectF2.height()), this.P.getWidth(), this.P.getHeight());
            if (rect12.top < 0) {
                rect12.top = 0;
                rectF2.top = rectF2.bottom - rect12.height();
            }
            canvas2.drawBitmap(this.P, rect12, rectF2, paint);
        } else if (this.f6897u != null) {
            float f45 = this.f6877c.left;
            float f46 = this.W;
            float f47 = this.r;
            float f48 = this.f6879d;
            canvas2.drawBitmap(this.f6897u, (Rect) null, new RectF(f45 + f46 + f47, f48, (r6.right - f46) - f47, this.f6897u.getHeight() + f48), paint);
        } else {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.f6894q);
            float f49 = this.f6877c.left;
            float f50 = this.W;
            float f51 = this.r;
            float f52 = f49 + f50 + f51;
            float f53 = this.f6879d;
            canvas2.drawRect(f52, f53, (r13.right - f50) - f51, f53 + this.f6893p, paint);
        }
        if (!TextUtils.isEmpty(this.E) && this.f6874a0 != null) {
            boolean z5 = this.H;
            TextPaint textPaint = this.f6884g;
            if (z5) {
                if (this.L) {
                    paint.setColor(this.K);
                    paint.setStyle(Paint.Style.FILL);
                    if (this.J) {
                        Rect rect13 = new Rect();
                        String str = this.E;
                        textPaint.getTextBounds(str, 0, str.length(), rect13);
                        float width2 = ((canvas2.getWidth() - rect13.width()) / 2) - this.f6876b0;
                        RectF rectF3 = new RectF(width2, (this.f6877c.bottom + this.I) - this.f6876b0, rect13.width() + width2 + (this.f6876b0 * 2), this.f6874a0.getHeight() + this.f6877c.bottom + this.I + this.f6876b0);
                        float f54 = this.f6876b0;
                        canvas2.drawRoundRect(rectF3, f54, f54, paint);
                    } else {
                        Rect rect14 = this.f6877c;
                        float f55 = rect14.left;
                        int i15 = rect14.bottom + this.I;
                        RectF rectF4 = new RectF(f55, i15 - this.f6876b0, rect14.right, this.f6874a0.getHeight() + i15 + this.f6876b0);
                        float f56 = this.f6876b0;
                        canvas2.drawRoundRect(rectF4, f56, f56, paint);
                    }
                }
                canvas2.save();
                if (this.J) {
                    canvas2.translate(0.0f, this.f6877c.bottom + this.I);
                } else {
                    Rect rect15 = this.f6877c;
                    canvas2.translate(rect15.left + this.f6876b0, rect15.bottom + this.I);
                }
                this.f6874a0.draw(canvas2);
                canvas2.restore();
            } else {
                if (this.L) {
                    paint.setColor(this.K);
                    paint.setStyle(Paint.Style.FILL);
                    if (this.J) {
                        Rect rect16 = new Rect();
                        String str2 = this.E;
                        textPaint.getTextBounds(str2, 0, str2.length(), rect16);
                        float width3 = ((canvas2.getWidth() - rect16.width()) / 2) - this.f6876b0;
                        int i16 = this.f6876b0;
                        RectF rectF5 = new RectF(width3, ((this.f6877c.top - this.I) - this.f6874a0.getHeight()) - this.f6876b0, rect16.width() + width3 + (i16 * 2), (this.f6877c.top - this.I) + i16);
                        float f57 = this.f6876b0;
                        canvas2.drawRoundRect(rectF5, f57, f57, paint);
                    } else {
                        Rect rect17 = this.f6877c;
                        float f58 = rect17.left;
                        int height2 = (rect17.top - this.I) - this.f6874a0.getHeight();
                        int i17 = this.f6876b0;
                        Rect rect18 = this.f6877c;
                        RectF rectF6 = new RectF(f58, height2 - i17, rect18.right, (rect18.top - this.I) + i17);
                        float f59 = this.f6876b0;
                        canvas2.drawRoundRect(rectF6, f59, f59, paint);
                    }
                }
                canvas2.save();
                if (this.J) {
                    canvas2.translate(0.0f, (this.f6877c.top - this.I) - this.f6874a0.getHeight());
                } else {
                    Rect rect19 = this.f6877c;
                    canvas2.translate(rect19.left + this.f6876b0, (rect19.top - this.I) - this.f6874a0.getHeight());
                }
                this.f6874a0.draw(canvas2);
                canvas2.restore();
            }
        }
        if (this.B) {
            if (this.P == null) {
                this.e += this.f6873a;
                int i18 = this.f6893p;
                Bitmap bitmap = this.f6897u;
                if (bitmap != null) {
                    i18 = bitmap.getWidth();
                }
                if (this.M) {
                    float f60 = this.e;
                    float f61 = i18 + f60;
                    float f62 = this.f6877c.right;
                    float f63 = this.W;
                    if (f61 > f62 - f63 || f60 < r1.left + f63) {
                        this.f6873a = -this.f6873a;
                    }
                } else {
                    float f64 = this.e + i18;
                    float f65 = this.f6877c.right;
                    float f66 = this.W;
                    if (f64 > f65 - f66) {
                        this.e = r13.left + f66 + 0.5f;
                    }
                }
            } else {
                float f67 = this.R + this.f6873a;
                this.R = f67;
                float f68 = this.f6877c.right;
                float f69 = this.W;
                if (f67 > f68 - f69) {
                    this.R = r0.left + f69 + 0.5f;
                }
            }
        } else if (this.P == null) {
            this.f6879d += this.f6873a;
            int i19 = this.f6893p;
            Bitmap bitmap2 = this.f6897u;
            if (bitmap2 != null) {
                i19 = bitmap2.getHeight();
            }
            if (this.M) {
                float f70 = this.f6879d;
                float f71 = i19 + f70;
                float f72 = this.f6877c.bottom;
                float f73 = this.W;
                if (f71 > f72 - f73 || f70 < r1.top + f73) {
                    this.f6873a = -this.f6873a;
                }
            } else {
                float f74 = this.f6879d + i19;
                float f75 = this.f6877c.bottom;
                float f76 = this.W;
                if (f74 > f75 - f76) {
                    this.f6879d = r13.top + f76 + 0.5f;
                }
            }
        } else {
            float f77 = this.Q + this.f6873a;
            this.Q = f77;
            float f78 = this.f6877c.bottom;
            float f79 = this.W;
            if (f77 > f78 - f79) {
                this.Q = r0.top + f79 + 0.5f;
            }
        }
        long j4 = this.f6875b;
        Rect rect20 = this.f6877c;
        postInvalidateDelayed(j4, rect20.left, rect20.top, rect20.right, rect20.bottom);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        super.onSizeChanged(i3, i10, i11, i12);
        a();
    }

    public void setAnimTime(int i3) {
        this.f6900x = i3;
        c();
    }

    public void setAutoZoom(boolean z5) {
        this.f6881e0 = z5;
    }

    public void setBarCodeTipText(String str) {
        this.D = str;
        c();
    }

    public void setBarcodeRectHeight(int i3) {
        this.f6891n = i3;
        c();
    }

    public void setBorderColor(int i3) {
        this.f6899w = i3;
        c();
    }

    public void setBorderSize(int i3) {
        this.f6898v = i3;
        c();
    }

    public void setCornerColor(int i3) {
        this.f6886i = i3;
        c();
    }

    public void setCornerLength(int i3) {
        this.f6887j = i3;
        c();
    }

    public void setCornerSize(int i3) {
        this.f6888k = i3;
        c();
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.f6896t = drawable;
        c();
    }

    public void setHalfCornerSize(float f2) {
        this.W = f2;
        c();
    }

    public void setIsBarcode(boolean z5) {
        this.B = z5;
        c();
    }

    public void setMaskColor(int i3) {
        this.f6885h = i3;
        c();
    }

    public void setOnlyDecodeScanBoxArea(boolean z5) {
        this.f6878c0 = z5;
        a();
    }

    public void setQRCodeTipText(String str) {
        this.C = str;
        c();
    }

    public void setRectHeight(int i3) {
        this.f6890m = i3;
        c();
    }

    public void setRectWidth(int i3) {
        this.f6889l = i3;
        c();
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.f6897u = bitmap;
        c();
    }

    public void setScanLineColor(int i3) {
        this.f6894q = i3;
        c();
    }

    public void setScanLineMargin(int i3) {
        this.r = i3;
        c();
    }

    public void setScanLineReverse(boolean z5) {
        this.M = z5;
        c();
    }

    public void setScanLineSize(int i3) {
        this.f6893p = i3;
        c();
    }

    public void setShowDefaultGridScanLineDrawable(boolean z5) {
        this.N = z5;
        c();
    }

    public void setShowDefaultScanLineDrawable(boolean z5) {
        this.f6895s = z5;
        c();
    }

    public void setShowLocationPoint(boolean z5) {
        this.f6880d0 = z5;
    }

    public void setShowTipBackground(boolean z5) {
        this.L = z5;
        c();
    }

    public void setShowTipTextAsSingleLine(boolean z5) {
        this.J = z5;
        c();
    }

    public void setTipBackgroundColor(int i3) {
        this.K = i3;
        c();
    }

    public void setTipBackgroundRadius(int i3) {
        this.f6876b0 = i3;
        c();
    }

    public void setTipText(String str) {
        if (this.B) {
            this.D = str;
        } else {
            this.C = str;
        }
        c();
    }

    public void setTipTextBelowRect(boolean z5) {
        this.H = z5;
        c();
    }

    public void setTipTextColor(int i3) {
        this.G = i3;
        this.f6884g.setColor(i3);
        c();
    }

    public void setTipTextMargin(int i3) {
        this.I = i3;
        c();
    }

    public void setTipTextSize(int i3) {
        this.F = i3;
        this.f6884g.setTextSize(i3);
        c();
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.f6874a0 = staticLayout;
        c();
    }

    public void setToolbarHeight(int i3) {
        this.A = i3;
        c();
    }

    public void setTopOffset(int i3) {
        this.f6892o = i3;
        c();
    }

    public void setVerticalBias(float f2) {
        this.f6901y = f2;
        c();
    }
}
