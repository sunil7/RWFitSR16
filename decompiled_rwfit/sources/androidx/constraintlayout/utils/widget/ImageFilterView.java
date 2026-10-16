package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import v0.b;
import v0.c;

/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: d, reason: collision with root package name */
    public final c f1787d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f1788f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f1789g;

    /* renamed from: h, reason: collision with root package name */
    public float f1790h;

    /* renamed from: i, reason: collision with root package name */
    public float f1791i;

    /* renamed from: j, reason: collision with root package name */
    public float f1792j;

    /* renamed from: k, reason: collision with root package name */
    public Path f1793k;

    /* renamed from: l, reason: collision with root package name */
    public ViewOutlineProvider f1794l;

    /* renamed from: m, reason: collision with root package name */
    public RectF f1795m;

    /* renamed from: n, reason: collision with root package name */
    public final Drawable[] f1796n;

    /* renamed from: o, reason: collision with root package name */
    public LayerDrawable f1797o;

    /* renamed from: p, reason: collision with root package name */
    public float f1798p;

    /* renamed from: q, reason: collision with root package name */
    public float f1799q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f1800s;

    public ImageFilterView(Context context) {
        super(context);
        this.f1787d = new c();
        this.e = true;
        this.f1788f = null;
        this.f1789g = null;
        this.f1790h = 0.0f;
        this.f1791i = 0.0f;
        this.f1792j = Float.NaN;
        this.f1796n = new Drawable[2];
        this.f1798p = Float.NaN;
        this.f1799q = Float.NaN;
        this.r = Float.NaN;
        this.f1800s = Float.NaN;
    }

    private void setOverlay(boolean z5) {
        this.e = z5;
    }

    public final void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f1788f = obtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.f1790h = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.e));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f1798p));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f1799q));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f1800s));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.r));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f1789g = drawable;
            Drawable drawable2 = this.f1788f;
            Drawable[] drawableArr = this.f1796n;
            if (drawable2 == null || drawable == null) {
                Drawable drawable3 = getDrawable();
                this.f1789g = drawable3;
                if (drawable3 != null) {
                    Drawable mutate = drawable3.mutate();
                    this.f1789g = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable mutate2 = getDrawable().mutate();
            this.f1789g = mutate2;
            drawableArr[0] = mutate2;
            drawableArr[1] = this.f1788f.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f1797o = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f1790h * 255.0f));
            if (!this.e) {
                this.f1797o.getDrawable(0).setAlpha((int) ((1.0f - this.f1790h) * 255.0f));
            }
            super.setImageDrawable(this.f1797o);
        }
    }

    public final void d() {
        if (Float.isNaN(this.f1798p) && Float.isNaN(this.f1799q) && Float.isNaN(this.r) && Float.isNaN(this.f1800s)) {
            return;
        }
        float f2 = Float.isNaN(this.f1798p) ? 0.0f : this.f1798p;
        float f10 = Float.isNaN(this.f1799q) ? 0.0f : this.f1799q;
        float f11 = Float.isNaN(this.r) ? 1.0f : this.r;
        float f12 = Float.isNaN(this.f1800s) ? 0.0f : this.f1800s;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f13 = f11 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f13, f13);
        float f14 = intrinsicWidth * f13;
        float f15 = f13 * intrinsicHeight;
        matrix.postTranslate(((((width - f14) * f2) + width) - f14) * 0.5f, ((((height - f15) * f10) + height) - f15) * 0.5f);
        matrix.postRotate(f12, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void e() {
        if (Float.isNaN(this.f1798p) && Float.isNaN(this.f1799q) && Float.isNaN(this.r) && Float.isNaN(this.f1800s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            d();
        }
    }

    public float getBrightness() {
        return this.f1787d.f19119d;
    }

    public float getContrast() {
        return this.f1787d.f19120f;
    }

    public float getCrossfade() {
        return this.f1790h;
    }

    public float getImagePanX() {
        return this.f1798p;
    }

    public float getImagePanY() {
        return this.f1799q;
    }

    public float getImageRotate() {
        return this.f1800s;
    }

    public float getImageZoom() {
        return this.r;
    }

    public float getRound() {
        return this.f1792j;
    }

    public float getRoundPercent() {
        return this.f1791i;
    }

    public float getSaturation() {
        return this.f1787d.e;
    }

    public float getWarmth() {
        return this.f1787d.f19121g;
    }

    @Override // android.view.View
    public final void layout(int i3, int i10, int i11, int i12) {
        super.layout(i3, i10, i11, i12);
        d();
    }

    public void setAltImageResource(int i3) {
        Drawable mutate = pb.b(getContext(), i3).mutate();
        this.f1788f = mutate;
        Drawable drawable = this.f1789g;
        Drawable[] drawableArr = this.f1796n;
        drawableArr[0] = drawable;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f1797o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f1790h);
    }

    public void setBrightness(float f2) {
        c cVar = this.f1787d;
        cVar.f19119d = f2;
        cVar.a(this);
    }

    public void setContrast(float f2) {
        c cVar = this.f1787d;
        cVar.f19120f = f2;
        cVar.a(this);
    }

    public void setCrossfade(float f2) {
        this.f1790h = f2;
        if (this.f1796n != null) {
            if (!this.e) {
                this.f1797o.getDrawable(0).setAlpha((int) ((1.0f - this.f1790h) * 255.0f));
            }
            this.f1797o.getDrawable(1).setAlpha((int) (this.f1790h * 255.0f));
            super.setImageDrawable(this.f1797o);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f1788f == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f1789g = mutate;
        Drawable[] drawableArr = this.f1796n;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f1788f;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f1797o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f1790h);
    }

    public void setImagePanX(float f2) {
        this.f1798p = f2;
        e();
    }

    public void setImagePanY(float f2) {
        this.f1799q = f2;
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        if (this.f1788f == null) {
            super.setImageResource(i3);
            return;
        }
        Drawable mutate = pb.b(getContext(), i3).mutate();
        this.f1789g = mutate;
        Drawable[] drawableArr = this.f1796n;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f1788f;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f1797o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f1790h);
    }

    public void setImageRotate(float f2) {
        this.f1800s = f2;
        e();
    }

    public void setImageZoom(float f2) {
        this.r = f2;
        e();
    }

    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f1792j = f2;
            float f10 = this.f1791i;
            this.f1791i = -1.0f;
            setRoundPercent(f10);
            return;
        }
        boolean z5 = this.f1792j != f2;
        this.f1792j = f2;
        if (f2 != 0.0f) {
            if (this.f1793k == null) {
                this.f1793k = new Path();
            }
            if (this.f1795m == null) {
                this.f1795m = new RectF();
            }
            if (this.f1794l == null) {
                b bVar = new b(this, 1);
                this.f1794l = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f1795m.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f1793k.reset();
            Path path = this.f1793k;
            RectF rectF = this.f1795m;
            float f11 = this.f1792j;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f2) {
        boolean z5 = this.f1791i != f2;
        this.f1791i = f2;
        if (f2 != 0.0f) {
            if (this.f1793k == null) {
                this.f1793k = new Path();
            }
            if (this.f1795m == null) {
                this.f1795m = new RectF();
            }
            if (this.f1794l == null) {
                b bVar = new b(this, 0);
                this.f1794l = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f1791i) / 2.0f;
            this.f1795m.set(0.0f, 0.0f, width, height);
            this.f1793k.reset();
            this.f1793k.addRoundRect(this.f1795m, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        c cVar = this.f1787d;
        cVar.e = f2;
        cVar.a(this);
    }

    public void setWarmth(float f2) {
        c cVar = this.f1787d;
        cVar.f19121g = f2;
        cVar.a(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1787d = new c();
        this.e = true;
        this.f1788f = null;
        this.f1789g = null;
        this.f1790h = 0.0f;
        this.f1791i = 0.0f;
        this.f1792j = Float.NaN;
        this.f1796n = new Drawable[2];
        this.f1798p = Float.NaN;
        this.f1799q = Float.NaN;
        this.r = Float.NaN;
        this.f1800s = Float.NaN;
        c(attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1787d = new c();
        this.e = true;
        this.f1788f = null;
        this.f1789g = null;
        this.f1790h = 0.0f;
        this.f1791i = 0.0f;
        this.f1792j = Float.NaN;
        this.f1796n = new Drawable[2];
        this.f1798p = Float.NaN;
        this.f1799q = Float.NaN;
        this.r = Float.NaN;
        this.f1800s = Float.NaN;
        c(attributeSet);
    }
}
