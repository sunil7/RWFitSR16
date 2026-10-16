package bb;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import b1.o;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.gms.internal.mlkit_vision_barcode.x0;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f3190a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f3191b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3192c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3193d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final float f3194f;

    /* renamed from: g, reason: collision with root package name */
    public final float f3195g;

    /* renamed from: h, reason: collision with root package name */
    public final float f3196h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3197i;

    /* renamed from: j, reason: collision with root package name */
    public final float f3198j;

    /* renamed from: k, reason: collision with root package name */
    public float f3199k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3200l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3201m = false;

    /* renamed from: n, reason: collision with root package name */
    public Typeface f3202n;

    public e(Context context, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, R$styleable.TextAppearance);
        this.f3199k = obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        this.f3190a = t0.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        t0.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        t0.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.f3193d = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.e = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int i10 = R$styleable.TextAppearance_fontFamily;
        i10 = obtainStyledAttributes.hasValue(i10) ? i10 : R$styleable.TextAppearance_android_fontFamily;
        this.f3200l = obtainStyledAttributes.getResourceId(i10, 0);
        this.f3192c = obtainStyledAttributes.getString(i10);
        obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.f3191b = t0.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f3194f = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f3195g = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f3196h = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i3, R$styleable.MaterialTextAppearance);
        this.f3197i = obtainStyledAttributes2.hasValue(R$styleable.MaterialTextAppearance_android_letterSpacing);
        this.f3198j = obtainStyledAttributes2.getFloat(R$styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f3202n;
        int i3 = this.f3193d;
        if (typeface == null && (str = this.f3192c) != null) {
            this.f3202n = Typeface.create(str, i3);
        }
        if (this.f3202n == null) {
            int i10 = this.e;
            if (i10 == 1) {
                this.f3202n = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f3202n = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f3202n = Typeface.DEFAULT;
            } else {
                this.f3202n = Typeface.MONOSPACE;
            }
            this.f3202n = Typeface.create(this.f3202n, i3);
        }
    }

    public final Typeface b(Context context) {
        if (this.f3201m) {
            return this.f3202n;
        }
        if (!context.isRestricted()) {
            try {
                int i3 = this.f3200l;
                ThreadLocal threadLocal = o.f3076a;
                Typeface a3 = context.isRestricted() ? null : o.a(context, i3, new TypedValue(), 0, null, false, false);
                this.f3202n = a3;
                if (a3 != null) {
                    this.f3202n = Typeface.create(a3, this.f3193d);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.f3192c, e);
            }
        }
        a();
        this.f3201m = true;
        return this.f3202n;
    }

    public final void c(Context context, x0 x0Var) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i3 = this.f3200l;
        if (i3 == 0) {
            this.f3201m = true;
        }
        if (this.f3201m) {
            x0Var.b(this.f3202n, true);
            return;
        }
        try {
            c cVar = new c(this, x0Var);
            ThreadLocal threadLocal = o.f3076a;
            if (context.isRestricted()) {
                cVar.a(-4);
            } else {
                o.a(context, i3, new TypedValue(), 0, cVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f3201m = true;
            x0Var.a(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.f3192c, e);
            this.f3201m = true;
            x0Var.a(-3);
        }
    }

    public final boolean d(Context context) {
        Typeface typeface = null;
        int i3 = this.f3200l;
        if (i3 != 0) {
            ThreadLocal threadLocal = o.f3076a;
            if (!context.isRestricted()) {
                typeface = o.a(context, i3, new TypedValue(), 0, null, false, true);
            }
        }
        return typeface != null;
    }

    public final void e(Context context, TextPaint textPaint, x0 x0Var) {
        f(context, textPaint, x0Var);
        ColorStateList colorStateList = this.f3190a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f3191b;
        textPaint.setShadowLayer(this.f3196h, this.f3194f, this.f3195g, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void f(Context context, TextPaint textPaint, x0 x0Var) {
        if (d(context)) {
            g(textPaint, b(context));
            return;
        }
        a();
        g(textPaint, this.f3202n);
        c(context, new d(this, textPaint, x0Var));
    }

    public final void g(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i3 = (~typeface.getStyle()) & this.f3193d;
        textPaint.setFakeBoldText((i3 & 1) != 0);
        textPaint.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f3199k);
        if (this.f3197i) {
            textPaint.setLetterSpacing(this.f3198j);
        }
    }
}
