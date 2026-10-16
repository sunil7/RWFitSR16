package la;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bb.e;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.badge.BadgeDrawable$SavedState;
import com.google.android.material.internal.r;
import com.google.android.material.internal.s;
import com.google.android.material.internal.w;
import eb.h;
import eb.l;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public final class a extends Drawable implements r {

    /* renamed from: q, reason: collision with root package name */
    public static final int f15837q = R$style.Widget_MaterialComponents_Badge;
    public static final int r = R$attr.badgeStyle;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f15838a;

    /* renamed from: b, reason: collision with root package name */
    public final h f15839b;

    /* renamed from: c, reason: collision with root package name */
    public final s f15840c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f15841d;
    public final float e;

    /* renamed from: f, reason: collision with root package name */
    public final float f15842f;

    /* renamed from: g, reason: collision with root package name */
    public final float f15843g;

    /* renamed from: h, reason: collision with root package name */
    public final BadgeDrawable$SavedState f15844h;

    /* renamed from: i, reason: collision with root package name */
    public float f15845i;

    /* renamed from: j, reason: collision with root package name */
    public float f15846j;

    /* renamed from: k, reason: collision with root package name */
    public int f15847k;

    /* renamed from: l, reason: collision with root package name */
    public float f15848l;

    /* renamed from: m, reason: collision with root package name */
    public float f15849m;

    /* renamed from: n, reason: collision with root package name */
    public float f15850n;

    /* renamed from: o, reason: collision with root package name */
    public WeakReference f15851o;

    /* renamed from: p, reason: collision with root package name */
    public WeakReference f15852p;

    public a(Context context) {
        e eVar;
        Context context2;
        WeakReference weakReference = new WeakReference(context);
        this.f15838a = weakReference;
        w.c(context, w.f10640b, "Theme.MaterialComponents");
        Resources resources = context.getResources();
        this.f15841d = new Rect();
        this.f15839b = new h();
        this.e = resources.getDimensionPixelSize(R$dimen.mtrl_badge_radius);
        this.f15843g = resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding);
        this.f15842f = resources.getDimensionPixelSize(R$dimen.mtrl_badge_with_text_radius);
        s sVar = new s(this);
        this.f15840c = sVar;
        sVar.f10632a.setTextAlign(Paint.Align.CENTER);
        this.f15844h = new BadgeDrawable$SavedState(context);
        int i3 = R$style.TextAppearance_MaterialComponents_Badge;
        Context context3 = (Context) weakReference.get();
        if (context3 == null || sVar.f10636f == (eVar = new e(context3, i3)) || (context2 = (Context) weakReference.get()) == null) {
            return;
        }
        sVar.b(eVar, context2);
        i();
    }

    @Override // com.google.android.material.internal.r
    public final void a() {
        invalidateSelf();
    }

    public final String b() {
        if (d() <= this.f15847k) {
            return NumberFormat.getInstance().format(d());
        }
        Context context = (Context) this.f15838a.get();
        return context == null ? "" : context.getString(R$string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.f15847k), "+");
    }

    public final CharSequence c() {
        CharSequence charSequence;
        int i3;
        Context context;
        int i10;
        int i11;
        if (!isVisible()) {
            return null;
        }
        boolean e = e();
        BadgeDrawable$SavedState badgeDrawable$SavedState = this.f15844h;
        if (!e) {
            charSequence = badgeDrawable$SavedState.contentDescriptionNumberless;
            return charSequence;
        }
        i3 = badgeDrawable$SavedState.contentDescriptionQuantityStrings;
        if (i3 <= 0 || (context = (Context) this.f15838a.get()) == null) {
            return null;
        }
        if (d() > this.f15847k) {
            i10 = badgeDrawable$SavedState.contentDescriptionExceedsMaxBadgeNumberRes;
            return context.getString(i10, Integer.valueOf(this.f15847k));
        }
        Resources resources = context.getResources();
        i11 = badgeDrawable$SavedState.contentDescriptionQuantityStrings;
        return resources.getQuantityString(i11, d(), Integer.valueOf(d()));
    }

    public final int d() {
        int i3;
        if (!e()) {
            return 0;
        }
        i3 = this.f15844h.number;
        return i3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i3;
        if (getBounds().isEmpty()) {
            return;
        }
        i3 = this.f15844h.alpha;
        if (i3 == 0 || !isVisible()) {
            return;
        }
        this.f15839b.draw(canvas);
        if (e()) {
            Rect rect = new Rect();
            String b3 = b();
            s sVar = this.f15840c;
            sVar.f10632a.getTextBounds(b3, 0, b3.length(), rect);
            canvas.drawText(b3, this.f15845i, this.f15846j + (rect.height() / 2), sVar.f10632a);
        }
    }

    public final boolean e() {
        int i3;
        i3 = this.f15844h.number;
        return i3 != -1;
    }

    public final void f(int i3) {
        int i10;
        BadgeDrawable$SavedState badgeDrawable$SavedState = this.f15844h;
        i10 = badgeDrawable$SavedState.badgeGravity;
        if (i10 != i3) {
            badgeDrawable$SavedState.badgeGravity = i3;
            WeakReference weakReference = this.f15851o;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = (View) this.f15851o.get();
            WeakReference weakReference2 = this.f15852p;
            h(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
        }
    }

    public final void g(int i3) {
        int i10;
        int i11;
        BadgeDrawable$SavedState badgeDrawable$SavedState = this.f15844h;
        i10 = badgeDrawable$SavedState.maxCharacterCount;
        if (i10 != i3) {
            badgeDrawable$SavedState.maxCharacterCount = i3;
            i11 = badgeDrawable$SavedState.maxCharacterCount;
            this.f15847k = ((int) Math.pow(10.0d, i11 - 1.0d)) - 1;
            this.f15840c.f10635d = true;
            i();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        int i3;
        i3 = this.f15844h.alpha;
        return i3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f15841d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f15841d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h(View view, FrameLayout frameLayout) {
        this.f15851o = new WeakReference(view);
        this.f15852p = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        i();
        invalidateSelf();
    }

    public final void i() {
        int i3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Context context = (Context) this.f15838a.get();
        WeakReference weakReference = this.f15851o;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        Rect rect2 = this.f15841d;
        rect.set(rect2);
        Rect rect3 = new Rect();
        view.getDrawingRect(rect3);
        WeakReference weakReference2 = this.f15852p;
        FrameLayout frameLayout = weakReference2 != null ? (FrameLayout) weakReference2.get() : null;
        if (frameLayout != null) {
            frameLayout.offsetDescendantRectToMyCoords(view, rect3);
        }
        BadgeDrawable$SavedState badgeDrawable$SavedState = this.f15844h;
        i3 = badgeDrawable$SavedState.verticalOffset;
        i10 = badgeDrawable$SavedState.additionalVerticalOffset;
        int i15 = i10 + i3;
        i11 = badgeDrawable$SavedState.badgeGravity;
        if (i11 == 8388691 || i11 == 8388693) {
            this.f15846j = rect3.bottom - i15;
        } else {
            this.f15846j = rect3.top + i15;
        }
        int d5 = d();
        float f2 = this.f15842f;
        if (d5 <= 9) {
            if (!e()) {
                f2 = this.e;
            }
            this.f15848l = f2;
            this.f15850n = f2;
            this.f15849m = f2;
        } else {
            this.f15848l = f2;
            this.f15850n = f2;
            this.f15849m = (this.f15840c.a(b()) / 2.0f) + this.f15843g;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e() ? R$dimen.mtrl_badge_text_horizontal_edge_offset : R$dimen.mtrl_badge_horizontal_edge_offset);
        i12 = badgeDrawable$SavedState.horizontalOffset;
        i13 = badgeDrawable$SavedState.additionalHorizontalOffset;
        int i16 = i13 + i12;
        i14 = badgeDrawable$SavedState.badgeGravity;
        if (i14 == 8388659 || i14 == 8388691) {
            WeakHashMap weakHashMap = z0.f15748a;
            this.f15845i = i0.d(view) == 0 ? (rect3.left - this.f15849m) + dimensionPixelSize + i16 : ((rect3.right + this.f15849m) - dimensionPixelSize) - i16;
        } else {
            WeakHashMap weakHashMap2 = z0.f15748a;
            this.f15845i = i0.d(view) == 0 ? ((rect3.right + this.f15849m) - dimensionPixelSize) - i16 : (rect3.left - this.f15849m) + dimensionPixelSize + i16;
        }
        float f10 = this.f15845i;
        float f11 = this.f15846j;
        float f12 = this.f15849m;
        float f13 = this.f15850n;
        rect2.set((int) (f10 - f12), (int) (f11 - f13), (int) (f10 + f12), (int) (f11 + f13));
        float f14 = this.f15848l;
        h hVar = this.f15839b;
        l f15 = hVar.f12505a.f12488a.f();
        f15.c(f14);
        hVar.setShapeAppearanceModel(f15.a());
        if (rect.equals(rect2)) {
            return;
        }
        hVar.setBounds(rect2);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.r
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        this.f15844h.alpha = i3;
        this.f15840c.f10632a.setAlpha(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
