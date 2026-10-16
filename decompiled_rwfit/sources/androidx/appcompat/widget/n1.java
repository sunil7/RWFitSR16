package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class n1 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1001a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1002b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f1003c = new Rect();

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 29 || i3 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1001a);
        } else {
            drawable.setState(f1002b);
        }
        drawable.setState(state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Rect b(Drawable drawable) {
        int i3;
        int i10;
        int i11;
        int i12;
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 29) {
            Insets a3 = m1.a(drawable);
            i3 = a3.left;
            i10 = a3.top;
            i11 = a3.right;
            i12 = a3.bottom;
            return new Rect(i3, i10, i11, i12);
        }
        boolean z5 = drawable instanceof d1.h;
        Object obj = drawable;
        if (z5) {
            ((d1.i) ((d1.h) drawable)).getClass();
            obj = null;
        }
        if (i13 >= 29) {
            boolean z6 = l1.f978a;
        } else if (l1.f978a) {
            try {
                Object invoke = l1.f979b.invoke(obj, null);
                if (invoke != null) {
                    return new Rect(l1.f980c.getInt(invoke), l1.f981d.getInt(invoke), l1.e.getInt(invoke), l1.f982f.getInt(invoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return f1003c;
    }

    public static PorterDuff.Mode c(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
