package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public abstract class l3 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f983a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f984b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f985c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f986d = {R.attr.state_pressed};
    public static final int[] e = {R.attr.state_checked};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f987f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f988g = new int[1];

    public static void a(Context context, View view) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i3) {
        ColorStateList d5 = d(context, i3);
        if (d5 != null && d5.isStateful()) {
            return d5.getColorForState(f984b, d5.getDefaultColor());
        }
        ThreadLocal threadLocal = f983a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f2 = typedValue.getFloat();
        return c1.a.e(c(context, i3), Math.round(Color.alpha(r4) * f2));
    }

    public static int c(Context context, int i3) {
        int[] iArr = f988g;
        iArr[0] = i3;
        de.o H = de.o.H(context, null, iArr);
        try {
            return ((TypedArray) H.f12378c).getColor(0, 0);
        } finally {
            H.K();
        }
    }

    public static ColorStateList d(Context context, int i3) {
        int[] iArr = f988g;
        iArr[0] = i3;
        de.o H = de.o.H(context, null, iArr);
        try {
            return H.v(0);
        } finally {
            H.K();
        }
    }
}
