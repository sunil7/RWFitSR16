package wa;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class b extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    public final Paint f19530b;

    /* renamed from: h, reason: collision with root package name */
    public float f19535h;

    /* renamed from: i, reason: collision with root package name */
    public int f19536i;

    /* renamed from: j, reason: collision with root package name */
    public int f19537j;

    /* renamed from: k, reason: collision with root package name */
    public int f19538k;

    /* renamed from: l, reason: collision with root package name */
    public int f19539l;

    /* renamed from: m, reason: collision with root package name */
    public int f19540m;

    /* renamed from: o, reason: collision with root package name */
    public eb.m f19542o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f19543p;

    /* renamed from: a, reason: collision with root package name */
    public final eb.o f19529a = eb.n.f12551a;

    /* renamed from: c, reason: collision with root package name */
    public final Path f19531c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final Rect f19532d = new Rect();
    public final RectF e = new RectF();

    /* renamed from: f, reason: collision with root package name */
    public final RectF f19533f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    public final k4.b f19534g = new k4.b(this);

    /* renamed from: n, reason: collision with root package name */
    public boolean f19541n = true;

    public b(eb.m mVar) {
        this.f19542o = mVar;
        Paint paint = new Paint(1);
        this.f19530b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z5 = this.f19541n;
        Paint paint = this.f19530b;
        Rect rect = this.f19532d;
        if (z5) {
            copyBounds(rect);
            float height = this.f19535h / rect.height();
            paint.setShader(new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{c1.a.c(this.f19536i, this.f19540m), c1.a.c(this.f19537j, this.f19540m), c1.a.c(c1.a.e(this.f19537j, 0), this.f19540m), c1.a.c(c1.a.e(this.f19539l, 0), this.f19540m), c1.a.c(this.f19539l, this.f19540m), c1.a.c(this.f19538k, this.f19540m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP));
            this.f19541n = false;
        }
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        copyBounds(rect);
        RectF rectF = this.e;
        rectF.set(rect);
        eb.c cVar = this.f19542o.e;
        RectF rectF2 = this.f19533f;
        rectF2.set(getBounds());
        float min = Math.min(cVar.a(rectF2), rectF.width() / 2.0f);
        eb.m mVar = this.f19542o;
        rectF2.set(getBounds());
        if (mVar.e(rectF2)) {
            rectF.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(rectF, min, min, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f19534g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f19535h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        eb.m mVar = this.f19542o;
        RectF rectF = this.f19533f;
        rectF.set(getBounds());
        if (mVar.e(rectF)) {
            eb.c cVar = this.f19542o.e;
            rectF.set(getBounds());
            outline.setRoundRect(getBounds(), cVar.a(rectF));
            return;
        }
        Rect rect = this.f19532d;
        copyBounds(rect);
        RectF rectF2 = this.e;
        rectF2.set(rect);
        eb.m mVar2 = this.f19542o;
        Path path = this.f19531c;
        this.f19529a.a(mVar2, 1.0f, rectF2, null, path);
        if (path.isConvex()) {
            outline.setConvexPath(path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        eb.m mVar = this.f19542o;
        RectF rectF = this.f19533f;
        rectF.set(getBounds());
        if (!mVar.e(rectF)) {
            return true;
        }
        int round = Math.round(this.f19535h);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f19543p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f19541n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f19543p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f19540m)) != this.f19540m) {
            this.f19541n = true;
            this.f19540m = colorForState;
        }
        if (this.f19541n) {
            invalidateSelf();
        }
        return this.f19541n;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        this.f19530b.setAlpha(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f19530b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
