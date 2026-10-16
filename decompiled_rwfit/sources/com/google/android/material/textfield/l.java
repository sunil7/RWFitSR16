package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.widget.u2;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* loaded from: classes.dex */
public final class l extends m {

    /* renamed from: d, reason: collision with root package name */
    public final h f10909d;
    public final u2 e;

    /* renamed from: f, reason: collision with root package name */
    public final i f10910f;

    /* renamed from: g, reason: collision with root package name */
    public final a f10911g;

    /* renamed from: h, reason: collision with root package name */
    public final b f10912h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10913i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10914j;

    /* renamed from: k, reason: collision with root package name */
    public long f10915k;

    /* renamed from: l, reason: collision with root package name */
    public StateListDrawable f10916l;

    /* renamed from: m, reason: collision with root package name */
    public eb.h f10917m;

    /* renamed from: n, reason: collision with root package name */
    public AccessibilityManager f10918n;

    /* renamed from: o, reason: collision with root package name */
    public ValueAnimator f10919o;

    /* renamed from: p, reason: collision with root package name */
    public ValueAnimator f10920p;

    public l(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f10909d = new h(this, 0);
        this.e = new u2(this, 2);
        this.f10910f = new i(this, textInputLayout);
        int i3 = 1;
        this.f10911g = new a(this, i3);
        this.f10912h = new b(this, i3);
        this.f10913i = false;
        this.f10914j = false;
        this.f10915k = Format.OFFSET_SAMPLE_RELATIVE;
    }

    public static void d(l lVar, AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            lVar.getClass();
            return;
        }
        lVar.getClass();
        long currentTimeMillis = System.currentTimeMillis() - lVar.f10915k;
        if (currentTimeMillis < 0 || currentTimeMillis > 300) {
            lVar.f10913i = false;
        }
        if (lVar.f10913i) {
            lVar.f10913i = false;
            return;
        }
        lVar.g(!lVar.f10914j);
        if (!lVar.f10914j) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    public static boolean f(EditText editText) {
        return editText.getKeyListener() != null;
    }

    @Override // com.google.android.material.textfield.m
    public final void a() {
        Context context = this.f10922b;
        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        eb.h e = e(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        eb.h e10 = e(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f10917m = e;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f10916l = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, e);
        this.f10916l.addState(new int[0], e10);
        Drawable b3 = pb.b(context, R$drawable.mtrl_dropdown_arrow);
        TextInputLayout textInputLayout = this.f10921a;
        textInputLayout.setEndIconDrawable(b3);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.exposed_dropdown_menu_content_description));
        textInputLayout.setEndIconOnClickListener(new androidx.appcompat.app.c(this, 7));
        textInputLayout.addOnEditTextAttachedListener(this.f10911g);
        textInputLayout.addOnEndIconChangedListener(this.f10912h);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = ja.a.f15383a;
        ofFloat.setInterpolator(linearInterpolator);
        ofFloat.setDuration(67);
        ofFloat.addUpdateListener(new com.google.android.material.internal.t(this, 1));
        this.f10920p = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(linearInterpolator);
        ofFloat2.setDuration(50);
        ofFloat2.addUpdateListener(new com.google.android.material.internal.t(this, 1));
        this.f10919o = ofFloat2;
        ofFloat2.addListener(new ab.q(this, 4));
        this.f10918n = (AccessibilityManager) context.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.m
    public final boolean b(int i3) {
        return i3 != 0;
    }

    public final eb.h e(float f2, float f10, float f11, int i3) {
        int i10 = 0;
        eb.k kVar = new eb.k();
        eb.k kVar2 = new eb.k();
        eb.k kVar3 = new eb.k();
        eb.k kVar4 = new eb.k();
        eb.e eVar = new eb.e(i10);
        eb.e eVar2 = new eb.e(i10);
        eb.e eVar3 = new eb.e(i10);
        eb.e eVar4 = new eb.e(i10);
        eb.a aVar = new eb.a(f2);
        eb.a aVar2 = new eb.a(f2);
        eb.a aVar3 = new eb.a(f10);
        eb.a aVar4 = new eb.a(f10);
        eb.m mVar = new eb.m();
        mVar.f12540a = kVar;
        mVar.f12541b = kVar2;
        mVar.f12542c = kVar3;
        mVar.f12543d = kVar4;
        mVar.e = aVar;
        mVar.f12544f = aVar2;
        mVar.f12545g = aVar4;
        mVar.f12546h = aVar3;
        mVar.f12547i = eVar;
        mVar.f12548j = eVar2;
        mVar.f12549k = eVar3;
        mVar.f12550l = eVar4;
        Paint paint = eb.h.f12504w;
        int i11 = R$attr.colorSurface;
        String simpleName = eb.h.class.getSimpleName();
        Context context = this.f10922b;
        int b3 = s0.b(context, i11, simpleName);
        eb.h hVar = new eb.h();
        hVar.j(context);
        hVar.l(ColorStateList.valueOf(b3));
        hVar.k(f11);
        hVar.setShapeAppearanceModel(mVar);
        eb.g gVar = hVar.f12505a;
        if (gVar.f12493g == null) {
            gVar.f12493g = new Rect();
        }
        hVar.f12505a.f12493g.set(0, i3, 0, i3);
        hVar.invalidateSelf();
        return hVar;
    }

    public final void g(boolean z5) {
        if (this.f10914j != z5) {
            this.f10914j = z5;
            this.f10920p.cancel();
            this.f10919o.start();
        }
    }
}
