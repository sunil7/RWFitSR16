package ib;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import g.d;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f14403a = {R.attr.theme, R$attr.theme};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f14404b = {R$attr.materialThemeOverlay};

    public static Context a(Context context, AttributeSet attributeSet, int i3, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f14404b, i3, i10);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        boolean z5 = (context instanceof d) && ((d) context).f13692a == resourceId;
        if (resourceId == 0 || z5) {
            return context;
        }
        d dVar = new d(context, resourceId);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f14403a);
        int resourceId2 = obtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = obtainStyledAttributes2.getResourceId(1, 0);
        obtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            dVar.getTheme().applyStyle(resourceId2, true);
        }
        return dVar;
    }
}
