package pa;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import com.google.android.gms.internal.mlkit_vision_barcode.qb;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardView;
import eb.d;
import eb.h;
import eb.k;
import eb.l;
import eb.m;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f17480s = {R.attr.state_checked};

    /* renamed from: t, reason: collision with root package name */
    public static final double f17481t = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCardView f17482a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f17483b;

    /* renamed from: c, reason: collision with root package name */
    public final h f17484c;

    /* renamed from: d, reason: collision with root package name */
    public final h f17485d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f17486f;

    /* renamed from: g, reason: collision with root package name */
    public int f17487g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f17488h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f17489i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f17490j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f17491k;

    /* renamed from: l, reason: collision with root package name */
    public m f17492l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f17493m;

    /* renamed from: n, reason: collision with root package name */
    public RippleDrawable f17494n;

    /* renamed from: o, reason: collision with root package name */
    public LayerDrawable f17495o;

    /* renamed from: p, reason: collision with root package name */
    public h f17496p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f17497q;
    public boolean r;

    public c(MaterialCardView materialCardView, AttributeSet attributeSet, int i3) {
        int i10 = MaterialCardView.f10353o;
        this.f17483b = new Rect();
        this.f17497q = false;
        this.f17482a = materialCardView;
        h hVar = new h(materialCardView.getContext(), attributeSet, i3, i10);
        this.f17484c = hVar;
        hVar.j(materialCardView.getContext());
        hVar.o();
        l f2 = hVar.f12505a.f12488a.f();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i3, R$style.CardView);
        if (obtainStyledAttributes.hasValue(R$styleable.CardView_cardCornerRadius)) {
            f2.c(obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.f17485d = new h();
        f(f2.a());
        obtainStyledAttributes.recycle();
    }

    public static float b(qb qbVar, float f2) {
        if (qbVar instanceof k) {
            return (float) ((1.0d - f17481t) * f2);
        }
        if (qbVar instanceof d) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    public final float a() {
        qb qbVar = this.f17492l.f12540a;
        h hVar = this.f17484c;
        return Math.max(Math.max(b(qbVar, hVar.h()), b(this.f17492l.f12541b, hVar.f12505a.f12488a.f12544f.a(hVar.f()))), Math.max(b(this.f17492l.f12542c, hVar.f12505a.f12488a.f12545g.a(hVar.f())), b(this.f17492l.f12543d, hVar.f12505a.f12488a.f12546h.a(hVar.f()))));
    }

    public final LayerDrawable c() {
        if (this.f17494n == null) {
            int[] iArr = cb.a.f3422a;
            this.f17496p = new h(this.f17492l);
            this.f17494n = new RippleDrawable(this.f17490j, null, this.f17496p);
        }
        if (this.f17495o == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.f17489i;
            if (drawable != null) {
                stateListDrawable.addState(f17480s, drawable);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f17494n, this.f17485d, stateListDrawable});
            this.f17495o = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.f17495o;
    }

    public final b d(Drawable drawable) {
        int i3;
        int i10;
        if (this.f17482a.getUseCompatPadding()) {
            int ceil = (int) Math.ceil((r0.getMaxCardElevation() * 1.5f) + (g() ? a() : 0.0f));
            i3 = (int) Math.ceil(r0.getMaxCardElevation() + (g() ? a() : 0.0f));
            i10 = ceil;
        } else {
            i3 = 0;
            i10 = 0;
        }
        return new b(drawable, i3, i10, i3, i10);
    }

    public final void e(Drawable drawable) {
        this.f17489i = drawable;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f17489i = mutate;
            d1.b.h(mutate, this.f17491k);
        }
        if (this.f17495o != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = this.f17489i;
            if (drawable2 != null) {
                stateListDrawable.addState(f17480s, drawable2);
            }
            this.f17495o.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, stateListDrawable);
        }
    }

    public final void f(m mVar) {
        this.f17492l = mVar;
        h hVar = this.f17484c;
        hVar.setShapeAppearanceModel(mVar);
        hVar.f12524v = !hVar.f12505a.f12488a.e(hVar.f());
        h hVar2 = this.f17485d;
        if (hVar2 != null) {
            hVar2.setShapeAppearanceModel(mVar);
        }
        h hVar3 = this.f17496p;
        if (hVar3 != null) {
            hVar3.setShapeAppearanceModel(mVar);
        }
    }

    public final boolean g() {
        MaterialCardView materialCardView = this.f17482a;
        if (!materialCardView.getPreventCornerOverlap()) {
            return false;
        }
        h hVar = this.f17484c;
        return hVar.f12505a.f12488a.e(hVar.f()) && materialCardView.getUseCompatPadding();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r7 = this;
            com.google.android.material.card.MaterialCardView r0 = r7.f17482a
            boolean r1 = r0.getPreventCornerOverlap()
            r2 = 0
            if (r1 == 0) goto L1b
            eb.h r1 = r7.f17484c
            eb.g r3 = r1.f12505a
            eb.m r3 = r3.f12488a
            android.graphics.RectF r1 = r1.f()
            boolean r1 = r3.e(r1)
            if (r1 != 0) goto L1b
            r1 = 1
            goto L1c
        L1b:
            r1 = r2
        L1c:
            r3 = 0
            if (r1 != 0) goto L28
            boolean r1 = r7.g()
            if (r1 == 0) goto L26
            goto L28
        L26:
            r1 = r3
            goto L2c
        L28:
            float r1 = r7.a()
        L2c:
            boolean r4 = r0.getPreventCornerOverlap()
            if (r4 == 0) goto L44
            boolean r4 = r0.getUseCompatPadding()
            if (r4 == 0) goto L44
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r5 = pa.c.f17481t
            double r3 = r3 - r5
            float r5 = r0.getCardViewRadius()
            double r5 = (double) r5
            double r3 = r3 * r5
            float r3 = (float) r3
        L44:
            float r1 = r1 - r3
            int r1 = (int) r1
            android.graphics.Rect r3 = r7.f17483b
            int r4 = r3.left
            int r4 = r4 + r1
            int r5 = r3.top
            int r5 = r5 + r1
            int r6 = r3.right
            int r6 = r6 + r1
            int r3 = r3.bottom
            int r3 = r3 + r1
            android.graphics.Rect r1 = r0.f1602c
            r1.set(r4, r5, r6, r3)
            com.example.test.utils.y r0 = r0.e
            java.lang.Object r1 = r0.f8774c
            androidx.cardview.widget.CardView r1 = (androidx.cardview.widget.CardView) r1
            boolean r1 = r1.getUseCompatPadding()
            if (r1 != 0) goto L69
            r0.I(r2, r2, r2, r2)
            return
        L69:
            java.lang.Object r1 = r0.f8773b
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            l0.a r1 = (l0.a) r1
            float r2 = r1.e
            float r1 = r1.f15665a
            java.lang.Object r3 = r0.f8774c
            androidx.cardview.widget.CardView r3 = (androidx.cardview.widget.CardView) r3
            boolean r4 = r3.getPreventCornerOverlap()
            float r4 = l0.b.a(r2, r1, r4)
            double r4 = (double) r4
            double r4 = java.lang.Math.ceil(r4)
            int r4 = (int) r4
            boolean r3 = r3.getPreventCornerOverlap()
            float r1 = l0.b.b(r2, r1, r3)
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            int r1 = (int) r1
            r0.I(r4, r1, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.c.h():void");
    }

    public final void i() {
        boolean z5 = this.f17497q;
        MaterialCardView materialCardView = this.f17482a;
        if (!z5) {
            materialCardView.setBackgroundInternal(d(this.f17484c));
        }
        materialCardView.setForeground(d(this.f17488h));
    }
}
