package cb;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f3422a = {R.attr.state_pressed};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f3423b = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f3424c = {R.attr.state_selected};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f3425d = {R.attr.state_enabled, R.attr.state_pressed};
    public static final String e = a.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        int[] iArr = f3424c;
        int colorForState = colorStateList != null ? colorStateList.getColorForState(f3423b, colorStateList.getDefaultColor()) : 0;
        int e10 = c1.a.e(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
        int[][] iArr2 = {iArr, StateSet.NOTHING};
        int colorForState2 = colorStateList != null ? colorStateList.getColorForState(f3422a, colorStateList.getDefaultColor()) : 0;
        return new ColorStateList(iArr2, new int[]{e10, c1.a.e(colorForState2, Math.min(Color.alpha(colorForState2) * 2, 255))});
    }

    public static ColorStateList b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f3425d, 0)) != 0) {
            Log.w(e, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean c(int[] iArr) {
        boolean z5 = false;
        boolean z6 = false;
        for (int i3 : iArr) {
            if (i3 == 16842910) {
                z5 = true;
            } else if (i3 == 16842908 || i3 == 16842919 || i3 == 16843623) {
                z6 = true;
            }
        }
        return z5 && z6;
    }
}
