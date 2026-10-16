package l0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f15665a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f15666b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f15667c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f15668d;
    public float e;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f15671h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f15672i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f15673j;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15669f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15670g = true;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f15674k = PorterDuff.Mode.SRC_IN;

    public a(ColorStateList colorStateList, float f2) {
        this.f15665a = f2;
        Paint paint = new Paint(5);
        this.f15666b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.f15671h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.f15671h.getDefaultColor()));
        this.f15667c = new RectF();
        this.f15668d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.f15667c;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        Rect rect2 = this.f15668d;
        rect2.set(rect);
        if (this.f15669f) {
            rect2.inset((int) Math.ceil(b.a(this.e, this.f15665a, this.f15670g)), (int) Math.ceil(b.b(this.e, this.f15665a, this.f15670g)));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z5;
        Paint paint = this.f15666b;
        if (this.f15672i == null || paint.getColorFilter() != null) {
            z5 = false;
        } else {
            paint.setColorFilter(this.f15672i);
            z5 = true;
        }
        RectF rectF = this.f15667c;
        float f2 = this.f15665a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z5) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f15668d, this.f15665a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f15673j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f15671h;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f15671h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f15666b;
        boolean z5 = colorForState != paint.getColor();
        if (z5) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f15673j;
        if (colorStateList2 == null || (mode = this.f15674k) == null) {
            return z5;
        }
        this.f15672i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        this.f15666b.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f15666b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f15673j = colorStateList;
        this.f15672i = a(colorStateList, this.f15674k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f15674k = mode;
        this.f15672i = a(this.f15673j, mode);
        invalidateSelf();
    }
}
