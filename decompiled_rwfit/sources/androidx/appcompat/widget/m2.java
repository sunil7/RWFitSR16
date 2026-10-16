package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class m2 {

    /* renamed from: g, reason: collision with root package name */
    public static m2 f992g;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f994a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f995b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f996c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f997d;
    public n.g0 e;

    /* renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f991f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h, reason: collision with root package name */
    public static final l2 f993h = new l2(6);

    public static synchronized m2 b() {
        m2 m2Var;
        synchronized (m2.class) {
            try {
                if (f992g == null) {
                    f992g = new m2();
                }
                m2Var = f992g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return m2Var;
    }

    public static synchronized PorterDuffColorFilter e(int i3, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (m2.class) {
            l2 l2Var = f993h;
            l2Var.getClass();
            int i10 = (31 + i3) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) l2Var.a(Integer.valueOf(mode.hashCode() + i10));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i3, mode);
            }
        }
        return porterDuffColorFilter;
    }

    public final Drawable a(Context context, int i3) {
        Drawable drawable;
        if (this.f996c == null) {
            this.f996c = new TypedValue();
        }
        TypedValue typedValue = this.f996c;
        context.getResources().getValue(i3, typedValue, true);
        long j4 = (typedValue.assetCookie << 32) | typedValue.data;
        synchronized (this) {
            m0.e eVar = (m0.e) this.f995b.get(context);
            drawable = null;
            if (eVar != null) {
                WeakReference weakReference = (WeakReference) eVar.c(j4, null);
                if (weakReference != null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                    if (constantState != null) {
                        drawable = constantState.newDrawable(context.getResources());
                    } else {
                        int b3 = m0.d.b(eVar.f15896b, eVar.f15898d, j4);
                        if (b3 >= 0) {
                            Object[] objArr = eVar.f15897c;
                            Object obj = objArr[b3];
                            Object obj2 = m0.e.e;
                            if (obj != obj2) {
                                objArr[b3] = obj2;
                                eVar.f15895a = true;
                            }
                        }
                    }
                }
            }
        }
        if (drawable != null) {
            return drawable;
        }
        LayerDrawable layerDrawable = null;
        if (this.e != null) {
            if (i3 == R$drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{c(context, R$drawable.abc_cab_background_internal_bg), c(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i3 == R$drawable.abc_ratingbar_material) {
                layerDrawable = n.g0.k(this, context, R$dimen.abc_star_big);
            } else if (i3 == R$drawable.abc_ratingbar_indicator_material) {
                layerDrawable = n.g0.k(this, context, R$dimen.abc_star_medium);
            } else if (i3 == R$drawable.abc_ratingbar_small_material) {
                layerDrawable = n.g0.k(this, context, R$dimen.abc_star_small);
            }
        }
        if (layerDrawable == null) {
            return layerDrawable;
        }
        layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
        synchronized (this) {
            try {
                Drawable.ConstantState constantState2 = layerDrawable.getConstantState();
                if (constantState2 != null) {
                    m0.e eVar2 = (m0.e) this.f995b.get(context);
                    if (eVar2 == null) {
                        eVar2 = new m0.e();
                        this.f995b.put(context, eVar2);
                    }
                    eVar2.d(j4, new WeakReference(constantState2));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return layerDrawable;
    }

    public final synchronized Drawable c(Context context, int i3) {
        return d(context, i3, false);
    }

    public final synchronized Drawable d(Context context, int i3, boolean z5) {
        Drawable a3;
        try {
            if (!this.f997d) {
                this.f997d = true;
                Drawable c9 = c(context, androidx.appcompat.resources.R$drawable.abc_vector_test);
                if (c9 == null || (!(c9 instanceof k2.a) && !"android.graphics.drawable.VectorDrawable".equals(c9.getClass().getName()))) {
                    this.f997d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            a3 = a(context, i3);
            if (a3 == null) {
                a3 = a1.c.b(context, i3);
            }
            if (a3 != null) {
                a3 = g(context, i3, z5, a3);
            }
            if (a3 != null) {
                n1.a(a3);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return a3;
    }

    public final synchronized ColorStateList f(Context context, int i3) {
        ColorStateList colorStateList;
        m0.l lVar;
        WeakHashMap weakHashMap = this.f994a;
        ColorStateList colorStateList2 = null;
        colorStateList = (weakHashMap == null || (lVar = (m0.l) weakHashMap.get(context)) == null) ? null : (ColorStateList) lVar.b(i3, null);
        if (colorStateList == null) {
            n.g0 g0Var = this.e;
            if (g0Var != null) {
                colorStateList2 = g0Var.m(context, i3);
            }
            if (colorStateList2 != null) {
                if (this.f994a == null) {
                    this.f994a = new WeakHashMap();
                }
                m0.l lVar2 = (m0.l) this.f994a.get(context);
                if (lVar2 == null) {
                    lVar2 = new m0.l();
                    this.f994a.put(context, lVar2);
                }
                lVar2.a(i3, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable g(android.content.Context r8, int r9, boolean r10, android.graphics.drawable.Drawable r11) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.m2.g(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
