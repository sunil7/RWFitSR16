package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f1123b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static y f1124c;

    /* renamed from: a, reason: collision with root package name */
    public m2 f1125a;

    public static synchronized y a() {
        y yVar;
        synchronized (y.class) {
            try {
                if (f1124c == null) {
                    d();
                }
                yVar = f1124c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return yVar;
    }

    public static synchronized PorterDuffColorFilter c(int i3, PorterDuff.Mode mode) {
        PorterDuffColorFilter e;
        synchronized (y.class) {
            e = m2.e(i3, mode);
        }
        return e;
    }

    public static synchronized void d() {
        synchronized (y.class) {
            if (f1124c == null) {
                y yVar = new y();
                f1124c = yVar;
                yVar.f1125a = m2.b();
                m2 m2Var = f1124c.f1125a;
                n.g0 g0Var = new n.g0();
                synchronized (m2Var) {
                    m2Var.e = g0Var;
                }
            }
        }
    }

    public static void e(Drawable drawable, n3 n3Var, int[] iArr) {
        PorterDuff.Mode mode = m2.f991f;
        int[] state = drawable.getState();
        int[] iArr2 = n1.f1001a;
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z5 = n3Var.f1007d;
        if (!z5 && !n3Var.f1006c) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilter = null;
        ColorStateList colorStateList = z5 ? n3Var.f1004a : null;
        PorterDuff.Mode mode2 = n3Var.f1006c ? n3Var.f1005b : m2.f991f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilter = m2.e(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilter);
    }

    public final synchronized Drawable b(Context context, int i3) {
        return this.f1125a.c(context, i3);
    }
}
