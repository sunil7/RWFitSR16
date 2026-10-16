package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.R$attr;
import eb.m;
import eb.x;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f10325a;

    /* renamed from: b, reason: collision with root package name */
    public m f10326b;

    /* renamed from: c, reason: collision with root package name */
    public int f10327c;

    /* renamed from: d, reason: collision with root package name */
    public int f10328d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f10329f;

    /* renamed from: g, reason: collision with root package name */
    public int f10330g;

    /* renamed from: h, reason: collision with root package name */
    public int f10331h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f10332i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f10333j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f10334k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f10335l;

    /* renamed from: m, reason: collision with root package name */
    public eb.h f10336m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10337n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f10338o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10339p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10340q;
    public RippleDrawable r;

    /* renamed from: s, reason: collision with root package name */
    public int f10341s;

    public d(MaterialButton materialButton, m mVar) {
        this.f10325a = materialButton;
        this.f10326b = mVar;
    }

    public final x a() {
        RippleDrawable rippleDrawable = this.r;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.r.getNumberOfLayers() > 2 ? (x) this.r.getDrawable(2) : (x) this.r.getDrawable(1);
    }

    public final eb.h b(boolean z5) {
        RippleDrawable rippleDrawable = this.r;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (eb.h) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z5 ? 1 : 0);
    }

    public final void c(m mVar) {
        this.f10326b = mVar;
        if (b(false) != null) {
            b(false).setShapeAppearanceModel(mVar);
        }
        if (b(true) != null) {
            b(true).setShapeAppearanceModel(mVar);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(mVar);
        }
    }

    public final void d(int i3, int i10) {
        WeakHashMap weakHashMap = z0.f15748a;
        MaterialButton materialButton = this.f10325a;
        int f2 = i0.f(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int e = i0.e(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        int i11 = this.e;
        int i12 = this.f10329f;
        this.f10329f = i10;
        this.e = i3;
        if (!this.f10338o) {
            e();
        }
        i0.k(materialButton, f2, (paddingTop + i3) - i11, e, (paddingBottom + i10) - i12);
    }

    public final void e() {
        eb.h hVar = new eb.h(this.f10326b);
        MaterialButton materialButton = this.f10325a;
        hVar.j(materialButton.getContext());
        d1.b.h(hVar, this.f10333j);
        PorterDuff.Mode mode = this.f10332i;
        if (mode != null) {
            d1.b.i(hVar, mode);
        }
        float f2 = this.f10331h;
        ColorStateList colorStateList = this.f10334k;
        hVar.f12505a.f12496j = f2;
        hVar.invalidateSelf();
        hVar.q(colorStateList);
        eb.h hVar2 = new eb.h(this.f10326b);
        hVar2.setTint(0);
        float f10 = this.f10331h;
        int b3 = this.f10337n ? com.google.android.gms.internal.mlkit_vision_common.x.b(R$attr.colorSurface, materialButton) : 0;
        hVar2.f12505a.f12496j = f10;
        hVar2.invalidateSelf();
        hVar2.q(ColorStateList.valueOf(b3));
        eb.h hVar3 = new eb.h(this.f10326b);
        this.f10336m = hVar3;
        d1.b.g(hVar3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(cb.a.b(this.f10335l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{hVar2, hVar}), this.f10327c, this.e, this.f10328d, this.f10329f), this.f10336m);
        this.r = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        eb.h b10 = b(false);
        if (b10 != null) {
            b10.k(this.f10341s);
        }
    }

    public final void f() {
        int i3 = 0;
        eb.h b3 = b(false);
        eb.h b10 = b(true);
        if (b3 != null) {
            float f2 = this.f10331h;
            ColorStateList colorStateList = this.f10334k;
            b3.f12505a.f12496j = f2;
            b3.invalidateSelf();
            b3.q(colorStateList);
            if (b10 != null) {
                float f10 = this.f10331h;
                if (this.f10337n) {
                    i3 = com.google.android.gms.internal.mlkit_vision_common.x.b(R$attr.colorSurface, this.f10325a);
                }
                b10.f12505a.f12496j = f10;
                b10.invalidateSelf();
                b10.q(ColorStateList.valueOf(i3));
            }
        }
    }
}
