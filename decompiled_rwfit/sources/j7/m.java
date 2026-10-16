package j7;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.example.test.ui.device.activity.i0;
import com.github.chrisbanes.photoview.PhotoView;

/* loaded from: classes.dex */
public final class m implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* renamed from: h, reason: collision with root package name */
    public final PhotoView f15354h;

    /* renamed from: i, reason: collision with root package name */
    public final GestureDetector f15355i;

    /* renamed from: j, reason: collision with root package name */
    public final b f15356j;

    /* renamed from: p, reason: collision with root package name */
    public View.OnClickListener f15362p;

    /* renamed from: q, reason: collision with root package name */
    public View.OnLongClickListener f15363q;
    public l r;

    /* renamed from: v, reason: collision with root package name */
    public final i0 f15367v;

    /* renamed from: a, reason: collision with root package name */
    public final AccelerateDecelerateInterpolator f15348a = new AccelerateDecelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public int f15349b = 200;

    /* renamed from: c, reason: collision with root package name */
    public float f15350c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f15351d = 1.75f;
    public float e = 3.0f;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15352f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15353g = false;

    /* renamed from: k, reason: collision with root package name */
    public final Matrix f15357k = new Matrix();

    /* renamed from: l, reason: collision with root package name */
    public final Matrix f15358l = new Matrix();

    /* renamed from: m, reason: collision with root package name */
    public final Matrix f15359m = new Matrix();

    /* renamed from: n, reason: collision with root package name */
    public final RectF f15360n = new RectF();

    /* renamed from: o, reason: collision with root package name */
    public final float[] f15361o = new float[9];

    /* renamed from: s, reason: collision with root package name */
    public int f15364s = 2;

    /* renamed from: t, reason: collision with root package name */
    public boolean f15365t = true;

    /* renamed from: u, reason: collision with root package name */
    public ImageView.ScaleType f15366u = ImageView.ScaleType.FIT_CENTER;

    public m(PhotoView photoView) {
        i0 i0Var = new i0(this, 24);
        this.f15367v = i0Var;
        this.f15354h = photoView;
        photoView.setOnTouchListener(this);
        photoView.addOnLayoutChangeListener(this);
        if (photoView.isInEditMode()) {
            return;
        }
        this.f15356j = new b(photoView.getContext(), i0Var);
        GestureDetector gestureDetector = new GestureDetector(photoView.getContext(), new com.dh.imagepick.preview.widgets.video.c(this, 4));
        this.f15355i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new com.dh.imagepick.preview.widgets.video.d(this, 1));
    }

    public final void a() {
        if (b()) {
            this.f15354h.setImageMatrix(c());
        }
    }

    public final boolean b() {
        RectF rectF;
        float f2;
        float f10;
        float f11;
        float f12;
        float f13;
        Matrix c9 = c();
        float f14 = 0.0f;
        if (this.f15354h.getDrawable() != null) {
            rectF = this.f15360n;
            rectF.set(0.0f, 0.0f, r1.getIntrinsicWidth(), r1.getIntrinsicHeight());
            c9.mapRect(rectF);
        } else {
            rectF = null;
        }
        if (rectF == null) {
            return false;
        }
        float height = rectF.height();
        float width = rectF.width();
        PhotoView photoView = this.f15354h;
        float height2 = (photoView.getHeight() - photoView.getPaddingTop()) - photoView.getPaddingBottom();
        if (height <= height2) {
            int i3 = j.f15338a[this.f15366u.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    height2 = (height2 - height) / 2.0f;
                    f10 = rectF.top;
                } else {
                    height2 -= height;
                    f10 = rectF.top;
                }
                f11 = height2 - f10;
            } else {
                f2 = rectF.top;
                f11 = -f2;
            }
        } else {
            f2 = rectF.top;
            if (f2 <= 0.0f) {
                f10 = rectF.bottom;
                if (f10 >= height2) {
                    f11 = 0.0f;
                }
                f11 = height2 - f10;
            }
            f11 = -f2;
        }
        float width2 = (photoView.getWidth() - photoView.getPaddingLeft()) - photoView.getPaddingRight();
        if (width <= width2) {
            int i10 = j.f15338a[this.f15366u.ordinal()];
            if (i10 != 2) {
                if (i10 != 3) {
                    f12 = (width2 - width) / 2.0f;
                    f13 = rectF.left;
                } else {
                    f12 = width2 - width;
                    f13 = rectF.left;
                }
                f14 = f12 - f13;
            } else {
                f14 = -rectF.left;
            }
            this.f15364s = 2;
        } else {
            float f15 = rectF.left;
            if (f15 > 0.0f) {
                this.f15364s = 0;
                f14 = -f15;
            } else {
                float f16 = rectF.right;
                if (f16 < width2) {
                    f14 = width2 - f16;
                    this.f15364s = 1;
                } else {
                    this.f15364s = -1;
                }
            }
        }
        this.f15359m.postTranslate(f14, f11);
        return true;
    }

    public final Matrix c() {
        Matrix matrix = this.f15358l;
        matrix.set(this.f15357k);
        matrix.postConcat(this.f15359m);
        return matrix;
    }

    public final float d() {
        Matrix matrix = this.f15359m;
        float[] fArr = this.f15361o;
        matrix.getValues(fArr);
        float pow = (float) Math.pow(fArr[0], 2.0d);
        matrix.getValues(fArr);
        return (float) Math.sqrt(pow + ((float) Math.pow(fArr[3], 2.0d)));
    }

    public final void e(float f2, float f10, float f11, boolean z5) {
        if (f2 < this.f15350c || f2 > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z5) {
            this.f15354h.post(new k(this, d(), f2, f10, f11));
        } else {
            this.f15359m.setScale(f2, f2, f10, f11);
            a();
        }
    }

    public final void f() {
        if (this.f15365t) {
            g(this.f15354h.getDrawable());
            return;
        }
        Matrix matrix = this.f15359m;
        matrix.reset();
        matrix.postRotate(0.0f);
        a();
        this.f15354h.setImageMatrix(c());
        b();
    }

    public final void g(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        PhotoView photoView = this.f15354h;
        float width = (photoView.getWidth() - photoView.getPaddingLeft()) - photoView.getPaddingRight();
        float height = (photoView.getHeight() - photoView.getPaddingTop()) - photoView.getPaddingBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Matrix matrix = this.f15357k;
        matrix.reset();
        float f2 = intrinsicWidth;
        float f10 = width / f2;
        float f11 = intrinsicHeight;
        float f12 = height / f11;
        ImageView.ScaleType scaleType = this.f15366u;
        if (scaleType == ImageView.ScaleType.CENTER) {
            matrix.postTranslate((width - f2) / 2.0f, (height - f11) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f10, f12);
            matrix.postScale(max, max);
            matrix.postTranslate((width - (f2 * max)) / 2.0f, (height - (f11 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f10, f12));
            matrix.postScale(min, min);
            matrix.postTranslate((width - (f2 * min)) / 2.0f, (height - (f11 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f11);
            RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
            if (((int) 0.0f) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f11, f2);
            }
            int i3 = j.f15338a[this.f15366u.ordinal()];
            if (i3 == 1) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i3 == 2) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i3 == 3) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i3 == 4) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        Matrix matrix2 = this.f15359m;
        matrix2.reset();
        matrix2.postRotate(0.0f);
        a();
        this.f15354h.setImageMatrix(c());
        b();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (i3 == i13 && i10 == i14 && i11 == i15 && i12 == i16) {
            return;
        }
        g(this.f15354h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00c8  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j7.m.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f15362p = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f15355i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f15363q = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
    }

    public void setOnOutsidePhotoTapListener(d dVar) {
    }

    public void setOnPhotoTapListener(e eVar) {
    }

    public void setOnScaleChangeListener(f fVar) {
    }

    public void setOnSingleFlingListener(g gVar) {
    }

    public void setOnViewDragListener(h hVar) {
    }

    public void setOnViewTapListener(i iVar) {
    }
}
