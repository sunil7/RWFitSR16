package eb;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.ui.device.activity.e0;
import java.util.BitSet;

/* loaded from: classes.dex */
public class h extends Drawable implements x {

    /* renamed from: w, reason: collision with root package name */
    public static final Paint f12504w = new Paint(1);

    /* renamed from: a, reason: collision with root package name */
    public g f12505a;

    /* renamed from: b, reason: collision with root package name */
    public final v[] f12506b;

    /* renamed from: c, reason: collision with root package name */
    public final v[] f12507c;

    /* renamed from: d, reason: collision with root package name */
    public final BitSet f12508d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final Matrix f12509f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f12510g;

    /* renamed from: h, reason: collision with root package name */
    public final Path f12511h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f12512i;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f12513j;

    /* renamed from: k, reason: collision with root package name */
    public final Region f12514k;

    /* renamed from: l, reason: collision with root package name */
    public final Region f12515l;

    /* renamed from: m, reason: collision with root package name */
    public m f12516m;

    /* renamed from: n, reason: collision with root package name */
    public final Paint f12517n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f12518o;

    /* renamed from: p, reason: collision with root package name */
    public final db.a f12519p;

    /* renamed from: q, reason: collision with root package name */
    public final e0 f12520q;
    public final o r;

    /* renamed from: s, reason: collision with root package name */
    public PorterDuffColorFilter f12521s;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuffColorFilter f12522t;

    /* renamed from: u, reason: collision with root package name */
    public final RectF f12523u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12524v;

    public h() {
        this(new m());
    }

    public void a() {
        invalidateSelf();
    }

    public final void b(RectF rectF, Path path) {
        g gVar = this.f12505a;
        this.r.a(gVar.f12488a, gVar.f12495i, rectF, this.f12520q, path);
        if (this.f12505a.f12494h != 1.0f) {
            Matrix matrix = this.f12509f;
            matrix.reset();
            float f2 = this.f12505a.f12494h;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f12523u, true);
    }

    public final int c(int i3) {
        g gVar = this.f12505a;
        float f2 = gVar.f12499m + 0.0f + gVar.f12498l;
        ua.a aVar = gVar.f12489b;
        return aVar != null ? aVar.a(f2, i3) : i3;
    }

    public final void d(Canvas canvas) {
        if (this.f12508d.cardinality() > 0) {
            Log.w(Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i3 = this.f12505a.f12502p;
        Path path = this.f12510g;
        db.a aVar = this.f12519p;
        if (i3 != 0) {
            canvas.drawPath(path, aVar.f12319a);
        }
        for (int i10 = 0; i10 < 4; i10++) {
            v vVar = this.f12506b[i10];
            int i11 = this.f12505a.f12501o;
            Matrix matrix = v.f12578a;
            vVar.a(matrix, aVar, i11, canvas);
            this.f12507c[i10].a(matrix, aVar, this.f12505a.f12501o, canvas);
        }
        if (this.f12524v) {
            g gVar = this.f12505a;
            int sin = (int) (Math.sin(Math.toRadians(gVar.f12503q)) * gVar.f12502p);
            int g10 = g();
            canvas.translate(-sin, -g10);
            canvas.drawPath(path, f12504w);
            canvas.translate(sin, g10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f5, code lost:
    
        if (r5 < 29) goto L42;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: eb.h.draw(android.graphics.Canvas):void");
    }

    public final void e(Canvas canvas, Paint paint, Path path, m mVar, RectF rectF) {
        if (!mVar.e(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float a3 = mVar.f12544f.a(rectF) * this.f12505a.f12495i;
            canvas.drawRoundRect(rectF, a3, a3, paint);
        }
    }

    public final RectF f() {
        RectF rectF = this.f12512i;
        rectF.set(getBounds());
        return rectF;
    }

    public final int g() {
        g gVar = this.f12505a;
        return (int) (Math.cos(Math.toRadians(gVar.f12503q)) * gVar.f12502p);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f12505a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        g gVar = this.f12505a;
        if (gVar.f12500n == 2) {
            return;
        }
        if (gVar.f12488a.e(f())) {
            outline.setRoundRect(getBounds(), h() * this.f12505a.f12495i);
            return;
        }
        RectF f2 = f();
        Path path = this.f12510g;
        b(f2, path);
        if (path.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f12505a.f12493g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f12514k;
        region.set(bounds);
        RectF f2 = f();
        Path path = this.f12510g;
        b(f2, path);
        Region region2 = this.f12515l;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final float h() {
        return this.f12505a.f12488a.e.a(f());
    }

    public final boolean i() {
        Paint.Style style = this.f12505a.r;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f12518o.getStrokeWidth() > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f12505a.e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f12505a.getClass();
        ColorStateList colorStateList2 = this.f12505a.f12491d;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f12505a.f12490c;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    public final void j(Context context) {
        this.f12505a.f12489b = new ua.a(context);
        t();
    }

    public final void k(float f2) {
        g gVar = this.f12505a;
        if (gVar.f12499m != f2) {
            gVar.f12499m = f2;
            t();
        }
    }

    public final void l(ColorStateList colorStateList) {
        g gVar = this.f12505a;
        if (gVar.f12490c != colorStateList) {
            gVar.f12490c = colorStateList;
            onStateChange(getState());
        }
    }

    public final void m(float f2) {
        g gVar = this.f12505a;
        if (gVar.f12495i != f2) {
            gVar.f12495i = f2;
            this.e = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        g gVar = this.f12505a;
        g gVar2 = new g();
        gVar2.f12490c = null;
        gVar2.f12491d = null;
        gVar2.e = null;
        gVar2.f12492f = PorterDuff.Mode.SRC_IN;
        gVar2.f12493g = null;
        gVar2.f12494h = 1.0f;
        gVar2.f12495i = 1.0f;
        gVar2.f12497k = 255;
        gVar2.f12498l = 0.0f;
        gVar2.f12499m = 0.0f;
        gVar2.f12500n = 0;
        gVar2.f12501o = 0;
        gVar2.f12502p = 0;
        gVar2.f12503q = 0;
        gVar2.r = Paint.Style.FILL_AND_STROKE;
        gVar2.f12488a = gVar.f12488a;
        gVar2.f12489b = gVar.f12489b;
        gVar2.f12496j = gVar.f12496j;
        gVar2.f12490c = gVar.f12490c;
        gVar2.f12491d = gVar.f12491d;
        gVar2.f12492f = gVar.f12492f;
        gVar2.e = gVar.e;
        gVar2.f12497k = gVar.f12497k;
        gVar2.f12494h = gVar.f12494h;
        gVar2.f12502p = gVar.f12502p;
        gVar2.f12500n = gVar.f12500n;
        gVar2.f12495i = gVar.f12495i;
        gVar2.f12498l = gVar.f12498l;
        gVar2.f12499m = gVar.f12499m;
        gVar2.f12501o = gVar.f12501o;
        gVar2.f12503q = gVar.f12503q;
        gVar2.r = gVar.r;
        if (gVar.f12493g != null) {
            gVar2.f12493g = new Rect(gVar.f12493g);
        }
        this.f12505a = gVar2;
        return this;
    }

    public final void n() {
        this.f12505a.r = Paint.Style.FILL;
        super.invalidateSelf();
    }

    public final void o() {
        this.f12519p.a(-12303292);
        this.f12505a.getClass();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z5 = r(iArr) || s();
        if (z5) {
            invalidateSelf();
        }
        return z5;
    }

    public final void p() {
        g gVar = this.f12505a;
        if (gVar.f12500n != 2) {
            gVar.f12500n = 2;
            super.invalidateSelf();
        }
    }

    public final void q(ColorStateList colorStateList) {
        g gVar = this.f12505a;
        if (gVar.f12491d != colorStateList) {
            gVar.f12491d = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean r(int[] iArr) {
        boolean z5;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f12505a.f12490c == null || color2 == (colorForState2 = this.f12505a.f12490c.getColorForState(iArr, (color2 = (paint2 = this.f12517n).getColor())))) {
            z5 = false;
        } else {
            paint2.setColor(colorForState2);
            z5 = true;
        }
        if (this.f12505a.f12491d == null || color == (colorForState = this.f12505a.f12491d.getColorForState(iArr, (color = (paint = this.f12518o).getColor())))) {
            return z5;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean s() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f12521s;
        PorterDuffColorFilter porterDuffColorFilter3 = this.f12522t;
        g gVar = this.f12505a;
        ColorStateList colorStateList = gVar.e;
        PorterDuff.Mode mode = gVar.f12492f;
        Paint paint = this.f12517n;
        if (colorStateList == null || mode == null) {
            int color = paint.getColor();
            int c9 = c(color);
            porterDuffColorFilter = c9 != color ? new PorterDuffColorFilter(c9, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(c(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.f12521s = porterDuffColorFilter;
        this.f12505a.getClass();
        this.f12522t = null;
        this.f12505a.getClass();
        return (k1.b.a(porterDuffColorFilter2, this.f12521s) && k1.b.a(porterDuffColorFilter3, this.f12522t)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        g gVar = this.f12505a;
        if (gVar.f12497k != i3) {
            gVar.f12497k = i3;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f12505a.getClass();
        super.invalidateSelf();
    }

    @Override // eb.x
    public final void setShapeAppearanceModel(m mVar) {
        this.f12505a.f12488a = mVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f12505a.e = colorStateList;
        s();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        g gVar = this.f12505a;
        if (gVar.f12492f != mode) {
            gVar.f12492f = mode;
            s();
            super.invalidateSelf();
        }
    }

    public final void t() {
        g gVar = this.f12505a;
        float f2 = gVar.f12499m + 0.0f;
        gVar.f12501o = (int) Math.ceil(0.75f * f2);
        this.f12505a.f12502p = (int) Math.ceil(f2 * 0.25f);
        s();
        super.invalidateSelf();
    }

    public h(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(m.b(context, attributeSet, i3, i10).a());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(eb.m r4) {
        /*
            r3 = this;
            eb.g r0 = new eb.g
            r0.<init>()
            r1 = 0
            r0.f12490c = r1
            r0.f12491d = r1
            r0.e = r1
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            r0.f12492f = r2
            r0.f12493g = r1
            r2 = 1065353216(0x3f800000, float:1.0)
            r0.f12494h = r2
            r0.f12495i = r2
            r2 = 255(0xff, float:3.57E-43)
            r0.f12497k = r2
            r2 = 0
            r0.f12498l = r2
            r0.f12499m = r2
            r2 = 0
            r0.f12500n = r2
            r0.f12501o = r2
            r0.f12502p = r2
            r0.f12503q = r2
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.FILL_AND_STROKE
            r0.r = r2
            r0.f12488a = r4
            r0.f12489b = r1
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eb.h.<init>(eb.m):void");
    }

    public h(g gVar) {
        o oVar;
        this.f12506b = new v[4];
        this.f12507c = new v[4];
        this.f12508d = new BitSet(8);
        this.f12509f = new Matrix();
        this.f12510g = new Path();
        this.f12511h = new Path();
        this.f12512i = new RectF();
        this.f12513j = new RectF();
        this.f12514k = new Region();
        this.f12515l = new Region();
        Paint paint = new Paint(1);
        this.f12517n = paint;
        Paint paint2 = new Paint(1);
        this.f12518o = paint2;
        this.f12519p = new db.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            oVar = n.f12551a;
        } else {
            oVar = new o();
        }
        this.r = oVar;
        this.f12523u = new RectF();
        this.f12524v = true;
        this.f12505a = gVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = f12504w;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        s();
        r(getState());
        this.f12520q = new e0(this, 16);
    }
}
