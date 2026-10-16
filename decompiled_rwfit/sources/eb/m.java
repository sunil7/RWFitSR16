package eb;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.gms.internal.mlkit_vision_barcode.qb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: m, reason: collision with root package name */
    public static final j f12539m = new j(0.5f);

    /* renamed from: a, reason: collision with root package name */
    public qb f12540a = new k();

    /* renamed from: b, reason: collision with root package name */
    public qb f12541b = new k();

    /* renamed from: c, reason: collision with root package name */
    public qb f12542c = new k();

    /* renamed from: d, reason: collision with root package name */
    public qb f12543d = new k();
    public c e = new a(0.0f);

    /* renamed from: f, reason: collision with root package name */
    public c f12544f = new a(0.0f);

    /* renamed from: g, reason: collision with root package name */
    public c f12545g = new a(0.0f);

    /* renamed from: h, reason: collision with root package name */
    public c f12546h = new a(0.0f);

    /* renamed from: i, reason: collision with root package name */
    public e f12547i = new e(0);

    /* renamed from: j, reason: collision with root package name */
    public e f12548j = new e(0);

    /* renamed from: k, reason: collision with root package name */
    public e f12549k = new e(0);

    /* renamed from: l, reason: collision with root package name */
    public e f12550l = new e(0);

    public static l a(Context context, int i3, int i10, c cVar) {
        if (i10 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i3);
            i3 = i10;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, R$styleable.ShapeAppearance);
        try {
            int i11 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i12 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i11);
            int i13 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i11);
            int i14 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i11);
            int i15 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i11);
            c d5 = d(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, cVar);
            c d8 = d(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, d5);
            c d10 = d(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, d5);
            c d11 = d(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, d5);
            c d12 = d(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, d5);
            l lVar = new l();
            qb a3 = rb.a(i12);
            lVar.f12528a = a3;
            l.b(a3);
            lVar.e = d8;
            qb a10 = rb.a(i13);
            lVar.f12529b = a10;
            l.b(a10);
            lVar.f12532f = d10;
            qb a11 = rb.a(i14);
            lVar.f12530c = a11;
            l.b(a11);
            lVar.f12533g = d11;
            qb a12 = rb.a(i15);
            lVar.f12531d = a12;
            l.b(a12);
            lVar.f12534h = d12;
            return lVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static l b(Context context, AttributeSet attributeSet, int i3, int i10) {
        return c(context, attributeSet, i3, i10, new a(0));
    }

    public static l c(Context context, AttributeSet attributeSet, int i3, int i10, c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i3, i10);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, cVar);
    }

    public static c d(TypedArray typedArray, int i3, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i3);
        if (peekValue != null) {
            int i10 = peekValue.type;
            if (i10 == 5) {
                return new a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i10 == 6) {
                return new j(peekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cVar;
    }

    public final boolean e(RectF rectF) {
        boolean z5 = this.f12550l.getClass().equals(e.class) && this.f12548j.getClass().equals(e.class) && this.f12547i.getClass().equals(e.class) && this.f12549k.getClass().equals(e.class);
        float a3 = this.e.a(rectF);
        return z5 && ((this.f12544f.a(rectF) > a3 ? 1 : (this.f12544f.a(rectF) == a3 ? 0 : -1)) == 0 && (this.f12546h.a(rectF) > a3 ? 1 : (this.f12546h.a(rectF) == a3 ? 0 : -1)) == 0 && (this.f12545g.a(rectF) > a3 ? 1 : (this.f12545g.a(rectF) == a3 ? 0 : -1)) == 0) && ((this.f12541b instanceof k) && (this.f12540a instanceof k) && (this.f12542c instanceof k) && (this.f12543d instanceof k));
    }

    public final l f() {
        l lVar = new l();
        lVar.f12528a = this.f12540a;
        lVar.f12529b = this.f12541b;
        lVar.f12530c = this.f12542c;
        lVar.f12531d = this.f12543d;
        lVar.e = this.e;
        lVar.f12532f = this.f12544f;
        lVar.f12533g = this.f12545g;
        lVar.f12534h = this.f12546h;
        lVar.f12535i = this.f12547i;
        lVar.f12536j = this.f12548j;
        lVar.f12537k = this.f12549k;
        lVar.f12538l = this.f12550l;
        return lVar;
    }
}
