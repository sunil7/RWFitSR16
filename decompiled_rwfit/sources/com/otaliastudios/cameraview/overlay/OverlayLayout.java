package com.otaliastudios.cameraview.overlay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.otaliastudios.cameraview.R$styleable;
import ef.b;
import tf.a;
import tf.c;
import tf.d;

@SuppressLint({"CustomViewStyleable"})
/* loaded from: classes2.dex */
public class OverlayLayout extends FrameLayout implements a {

    /* renamed from: c, reason: collision with root package name */
    public static final b f11618c = b.a("OverlayLayout");

    /* renamed from: a, reason: collision with root package name */
    public Overlay$Target f11619a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11620b;

    public OverlayLayout(Context context) {
        super(context);
        this.f11619a = Overlay$Target.PREVIEW;
        setWillNotDraw(false);
    }

    public final void a(Overlay$Target overlay$Target, Canvas canvas) {
        synchronized (this) {
            try {
                this.f11619a = overlay$Target;
                int i3 = c.f18624a[overlay$Target.ordinal()];
                if (i3 == 1) {
                    super.draw(canvas);
                } else if (i3 == 2 || i3 == 3) {
                    canvas.save();
                    float width = canvas.getWidth() / getWidth();
                    float height = canvas.getHeight() / getHeight();
                    f11618c.b(0, "draw", "target:", overlay$Target, "canvas:", canvas.getWidth() + "x" + canvas.getHeight(), "view:", getWidth() + "x" + getHeight(), "widthScale:", Float.valueOf(width), "heightScale:", Float.valueOf(height), "hardwareCanvasMode:", Boolean.valueOf(this.f11620b));
                    canvas.scale(width, height);
                    dispatchDraw(canvas);
                    canvas.restore();
                }
            } finally {
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final d generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        d dVar = new d(context, attributeSet);
        dVar.f18625a = false;
        dVar.f18626b = false;
        dVar.f18627c = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CameraView_Layout);
        try {
            dVar.f18625a = obtainStyledAttributes.getBoolean(R$styleable.CameraView_Layout_layout_drawOnPreview, false);
            dVar.f18626b = obtainStyledAttributes.getBoolean(R$styleable.CameraView_Layout_layout_drawOnPictureSnapshot, false);
            dVar.f18627c = obtainStyledAttributes.getBoolean(R$styleable.CameraView_Layout_layout_drawOnVideoSnapshot, false);
            return dVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        f11618c.b(1, "normal draw called.");
        Overlay$Target overlay$Target = Overlay$Target.PREVIEW;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (((d) getChildAt(i3).getLayoutParams()).a(overlay$Target)) {
                a(overlay$Target, canvas);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        d dVar = (d) view.getLayoutParams();
        boolean a3 = dVar.a(this.f11619a);
        b bVar = f11618c;
        if (a3) {
            bVar.b(0, "Performing drawing for view:", view.getClass().getSimpleName(), "target:", this.f11619a, "params:", dVar);
            return super.drawChild(canvas, view, j4);
        }
        bVar.b(0, "Skipping drawing for view:", view.getClass().getSimpleName(), "target:", this.f11619a, "params:", dVar);
        return false;
    }

    @Override // tf.a
    public boolean getHardwareCanvasEnabled() {
        return this.f11620b;
    }

    public void setHardwareCanvasEnabled(boolean z5) {
        this.f11620b = z5;
    }
}
