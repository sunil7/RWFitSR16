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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R$styleable;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import v0.a;
import v0.c;

/* loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: d, reason: collision with root package name */
    public final c f1773d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f1774f;

    /* renamed from: g, reason: collision with root package name */
    public float f1775g;

    /* renamed from: h, reason: collision with root package name */
    public Path f1776h;

    /* renamed from: i, reason: collision with root package name */
    public ViewOutlineProvider f1777i;

    /* renamed from: j, reason: collision with root package name */
    public RectF f1778j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable[] f1779k;

    /* renamed from: l, reason: collision with root package name */
    public LayerDrawable f1780l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1781m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f1782n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f1783o;

    /* renamed from: p, reason: collision with root package name */
    public float f1784p;

    /* renamed from: q, reason: collision with root package name */
    public float f1785q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f1786s;

    public ImageFilterButton(Context context) {
        super(context);
        this.f1773d = new c();
        this.e = 0.0f;
        this.f1774f = 0.0f;
        this.f1775g = Float.NaN;
        this.f1779k = new Drawable[2];
        this.f1781m = true;
        this.f1782n = null;
        this.f1783o = null;
        this.f1784p = Float.NaN;
        this.f1785q = Float.NaN;
        this.r = Float.NaN;
        this.f1786s = Float.NaN;
        setPadding(0, 0, 0, 0);
    }

    private void setOverlay(boolean z5) {
        this.f1781m = z5;
    }

    public final void a(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f1782n = obtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.e = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f1781m));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f1784p));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f1785q));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f1786s));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.r));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f1783o = drawable;
            Drawable drawable2 = this.f1782n;
            Drawable[] drawableArr = this.f1779k;
            if (drawable2 == null || drawable == null) {
                Drawable drawable3 = getDrawable();
                this.f1783o = drawable3;
                if (drawable3 != null) {
                    Drawable mutate = drawable3.mutate();
                    this.f1783o = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable mutate2 = getDrawable().mutate();
            this.f1783o = mutate2;
            drawableArr[0] = mutate2;
            drawableArr[1] = this.f1782n.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
            this.f1780l = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.e * 255.0f));
            if (!this.f1781m) {
                this.f1780l.getDrawable(0).setAlpha((int) ((1.0f - this.e) * 255.0f));
            }
            super.setImageDrawable(this.f1780l);
        }
    }

    public final void b() {
        if (Float.isNaN(this.f1784p) && Float.isNaN(this.f1785q) && Float.isNaN(this.r) && Float.isNaN(this.f1786s)) {
            return;
        }
        float f2 = Float.isNaN(this.f1784p) ? 0.0f : this.f1784p;
        float f10 = Float.isNaN(this.f1785q) ? 0.0f : this.f1785q;
        float f11 = Float.isNaN(this.r) ? 1.0f : this.r;
        float f12 = Float.isNaN(this.f1786s) ? 0.0f : this.f1786s;
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

    public final void c() {
        if (Float.isNaN(this.f1784p) && Float.isNaN(this.f1785q) && Float.isNaN(this.r) && Float.isNaN(this.f1786s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            b();
        }
    }

    public float getContrast() {
        return this.f1773d.f19120f;
    }

    public float getCrossfade() {
        return this.e;
    }

    public float getImagePanX() {
        return this.f1784p;
    }

    public float getImagePanY() {
        return this.f1785q;
    }

    public float getImageRotate() {
        return this.f1786s;
    }

    public float getImageZoom() {
        return this.r;
    }

    public float getRound() {
        return this.f1775g;
    }

    public float getRoundPercent() {
        return this.f1774f;
    }

    public float getSaturation() {
        return this.f1773d.e;
    }

    public float getWarmth() {
        return this.f1773d.f19121g;
    }

    @Override // android.view.View
    public final void layout(int i3, int i10, int i11, int i12) {
        super.layout(i3, i10, i11, i12);
        b();
    }

    public void setAltImageResource(int i3) {
        Drawable mutate = pb.b(getContext(), i3).mutate();
        this.f1782n = mutate;
        Drawable drawable = this.f1783o;
        Drawable[] drawableArr = this.f1779k;
        drawableArr[0] = drawable;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f1780l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.e);
    }

    public void setBrightness(float f2) {
        c cVar = this.f1773d;
        cVar.f19119d = f2;
        cVar.a(this);
    }

    public void setContrast(float f2) {
        c cVar = this.f1773d;
        cVar.f19120f = f2;
        cVar.a(this);
    }

    public void setCrossfade(float f2) {
        this.e = f2;
        if (this.f1779k != null) {
            if (!this.f1781m) {
                this.f1780l.getDrawable(0).setAlpha((int) ((1.0f - this.e) * 255.0f));
            }
            this.f1780l.getDrawable(1).setAlpha((int) (this.e * 255.0f));
            super.setImageDrawable(this.f1780l);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f1782n == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f1783o = mutate;
        Drawable[] drawableArr = this.f1779k;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f1782n;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f1780l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.e);
    }

    public void setImagePanX(float f2) {
        this.f1784p = f2;
        c();
    }

    public void setImagePanY(float f2) {
        this.f1785q = f2;
        c();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i3) {
        if (this.f1782n == null) {
            super.setImageResource(i3);
            return;
        }
        Drawable mutate = pb.b(getContext(), i3).mutate();
        this.f1783o = mutate;
        Drawable[] drawableArr = this.f1779k;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f1782n;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.f1780l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.e);
    }

    public void setImageRotate(float f2) {
        this.f1786s = f2;
        c();
    }

    public void setImageZoom(float f2) {
        this.r = f2;
        c();
    }

    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f1775g = f2;
            float f10 = this.f1774f;
            this.f1774f = -1.0f;
            setRoundPercent(f10);
            return;
        }
        boolean z5 = this.f1775g != f2;
        this.f1775g = f2;
        if (f2 != 0.0f) {
            if (this.f1776h == null) {
                this.f1776h = new Path();
            }
            if (this.f1778j == null) {
                this.f1778j = new RectF();
            }
            if (this.f1777i == null) {
                a aVar = new a(1, this);
                this.f1777i = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            this.f1778j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f1776h.reset();
            Path path = this.f1776h;
            RectF rectF = this.f1778j;
            float f11 = this.f1775g;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f2) {
        boolean z5 = this.f1774f != f2;
        this.f1774f = f2;
        if (f2 != 0.0f) {
            if (this.f1776h == null) {
                this.f1776h = new Path();
            }
            if (this.f1778j == null) {
                this.f1778j = new RectF();
            }
            if (this.f1777i == null) {
                a aVar = new a(0, this);
                this.f1777i = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f1774f) / 2.0f;
            this.f1778j.set(0.0f, 0.0f, width, height);
            this.f1776h.reset();
            this.f1776h.addRoundRect(this.f1778j, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        c cVar = this.f1773d;
        cVar.e = f2;
        cVar.a(this);
    }

    public void setWarmth(float f2) {
        c cVar = this.f1773d;
        cVar.f19121g = f2;
        cVar.a(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1773d = new c();
        this.e = 0.0f;
        this.f1774f = 0.0f;
        this.f1775g = Float.NaN;
        this.f1779k = new Drawable[2];
        this.f1781m = true;
        this.f1782n = null;
        this.f1783o = null;
        this.f1784p = Float.NaN;
        this.f1785q = Float.NaN;
        this.r = Float.NaN;
        this.f1786s = Float.NaN;
        a(attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1773d = new c();
        this.e = 0.0f;
        this.f1774f = 0.0f;
        this.f1775g = Float.NaN;
        this.f1779k = new Drawable[2];
        this.f1781m = true;
        this.f1782n = null;
        this.f1783o = null;
        this.f1784p = Float.NaN;
        this.f1785q = Float.NaN;
        this.r = Float.NaN;
        this.f1786s = Float.NaN;
        a(attributeSet);
    }
}
