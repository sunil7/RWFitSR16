package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R$styleable;
import v0.d;

/* loaded from: classes.dex */
public class MotionButton extends AppCompatButton {

    /* renamed from: d, reason: collision with root package name */
    public float f1811d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public Path f1812f;

    /* renamed from: g, reason: collision with root package name */
    public ViewOutlineProvider f1813g;

    /* renamed from: h, reason: collision with root package name */
    public RectF f1814h;

    public MotionButton(Context context) {
        super(context);
        this.f1811d = 0.0f;
        this.e = Float.NaN;
        setPadding(0, 0, 0, 0);
    }

    public final void a(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public float getRound() {
        return this.e;
    }

    public float getRoundPercent() {
        return this.f1811d;
    }

    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.e = f2;
            float f10 = this.f1811d;
            this.f1811d = -1.0f;
            setRoundPercent(f10);
            return;
        }
        boolean z5 = this.e != f2;
        this.e = f2;
        if (f2 != 0.0f) {
            if (this.f1812f == null) {
                this.f1812f = new Path();
            }
            if (this.f1814h == null) {
                this.f1814h = new RectF();
            }
            if (this.f1813g == null) {
                d dVar = new d(this, 1);
                this.f1813g = dVar;
                setOutlineProvider(dVar);
            }
            setClipToOutline(true);
            this.f1814h.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f1812f.reset();
            Path path = this.f1812f;
            RectF rectF = this.f1814h;
            float f11 = this.e;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f2) {
        boolean z5 = this.f1811d != f2;
        this.f1811d = f2;
        if (f2 != 0.0f) {
            if (this.f1812f == null) {
                this.f1812f = new Path();
            }
            if (this.f1814h == null) {
                this.f1814h = new RectF();
            }
            if (this.f1813g == null) {
                d dVar = new d(this, 0);
                this.f1813g = dVar;
                setOutlineProvider(dVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f1811d) / 2.0f;
            this.f1814h.set(0.0f, 0.0f, width, height);
            this.f1812f.reset();
            this.f1812f.addRoundRect(this.f1814h, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1811d = 0.0f;
        this.e = Float.NaN;
        a(attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1811d = 0.0f;
        this.e = Float.NaN;
        a(attributeSet);
    }
}
