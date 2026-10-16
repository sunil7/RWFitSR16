package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.md;
import j7.c;
import j7.d;
import j7.e;
import j7.f;
import j7.g;
import j7.h;
import j7.i;
import j7.m;
import j7.n;

/* loaded from: classes.dex */
public class PhotoView extends AppCompatImageView {

    /* renamed from: d, reason: collision with root package name */
    public final m f8780d;
    public ImageView.ScaleType e;

    public PhotoView(Context context) {
        this(context, null);
    }

    public m getAttacher() {
        return this.f8780d;
    }

    public RectF getDisplayRect() {
        m mVar = this.f8780d;
        mVar.b();
        Matrix c9 = mVar.c();
        if (mVar.f15354h.getDrawable() == null) {
            return null;
        }
        RectF rectF = mVar.f15360n;
        rectF.set(0.0f, 0.0f, r2.getIntrinsicWidth(), r2.getIntrinsicHeight());
        c9.mapRect(rectF);
        return rectF;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f8780d.f15358l;
    }

    public float getMaximumScale() {
        return this.f8780d.e;
    }

    public float getMediumScale() {
        return this.f8780d.f15351d;
    }

    public float getMinimumScale() {
        return this.f8780d.f15350c;
    }

    public float getScale() {
        return this.f8780d.d();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f8780d.f15366u;
    }

    public void setAllowParentInterceptOnEdge(boolean z5) {
        this.f8780d.f15352f = z5;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i3, int i10, int i11, int i12) {
        boolean frame = super.setFrame(i3, i10, i11, i12);
        if (frame) {
            this.f8780d.f();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m mVar = this.f8780d;
        if (mVar != null) {
            mVar.f();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        m mVar = this.f8780d;
        if (mVar != null) {
            mVar.f();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m mVar = this.f8780d;
        if (mVar != null) {
            mVar.f();
        }
    }

    public void setMaximumScale(float f2) {
        m mVar = this.f8780d;
        md.a(mVar.f15350c, mVar.f15351d, f2);
        mVar.e = f2;
    }

    public void setMediumScale(float f2) {
        m mVar = this.f8780d;
        md.a(mVar.f15350c, f2, mVar.e);
        mVar.f15351d = f2;
    }

    public void setMinimumScale(float f2) {
        m mVar = this.f8780d;
        md.a(f2, mVar.f15351d, mVar.e);
        mVar.f15350c = f2;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8780d.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f8780d.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8780d.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.f8780d.setOnMatrixChangeListener(cVar);
    }

    public void setOnOutsidePhotoTapListener(d dVar) {
        this.f8780d.setOnOutsidePhotoTapListener(dVar);
    }

    public void setOnPhotoTapListener(e eVar) {
        this.f8780d.setOnPhotoTapListener(eVar);
    }

    public void setOnScaleChangeListener(f fVar) {
        this.f8780d.setOnScaleChangeListener(fVar);
    }

    public void setOnSingleFlingListener(g gVar) {
        this.f8780d.setOnSingleFlingListener(gVar);
    }

    public void setOnViewDragListener(h hVar) {
        this.f8780d.setOnViewDragListener(hVar);
    }

    public void setOnViewTapListener(i iVar) {
        this.f8780d.setOnViewTapListener(iVar);
    }

    public void setRotationBy(float f2) {
        m mVar = this.f8780d;
        mVar.f15359m.postRotate(f2 % 360.0f);
        mVar.a();
    }

    public void setRotationTo(float f2) {
        m mVar = this.f8780d;
        mVar.f15359m.setRotate(f2 % 360.0f);
        mVar.a();
    }

    public void setScale(float f2) {
        m mVar = this.f8780d;
        PhotoView photoView = mVar.f15354h;
        mVar.e(f2, photoView.getRight() / 2, photoView.getBottom() / 2, false);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        m mVar = this.f8780d;
        if (mVar == null) {
            this.e = scaleType;
            return;
        }
        mVar.getClass();
        if (scaleType == null) {
            return;
        }
        if (n.f15368a[scaleType.ordinal()] == 1) {
            throw new IllegalStateException("Matrix scale type is not supported");
        }
        if (scaleType != mVar.f15366u) {
            mVar.f15366u = scaleType;
            mVar.f();
        }
    }

    public void setZoomTransitionDuration(int i3) {
        this.f8780d.f15349b = i3;
    }

    public void setZoomable(boolean z5) {
        m mVar = this.f8780d;
        mVar.f15365t = z5;
        mVar.f();
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8780d = new m(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.e;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.e = null;
        }
    }
}
