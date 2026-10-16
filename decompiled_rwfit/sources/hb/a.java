package hb;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class a extends com.google.android.material.tabs.a {
    @Override // com.google.android.material.tabs.a
    public final void b(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        float cos;
        float f10;
        RectF a3 = com.google.android.material.tabs.a.a(tabLayout, view);
        RectF a10 = com.google.android.material.tabs.a.a(tabLayout, view2);
        if (a3.left < a10.left) {
            double d5 = (f2 * 3.141592653589793d) / 2.0d;
            f10 = (float) (1.0d - Math.cos(d5));
            cos = (float) Math.sin(d5);
        } else {
            double d8 = (f2 * 3.141592653589793d) / 2.0d;
            float sin = (float) Math.sin(d8);
            cos = (float) (1.0d - Math.cos(d8));
            f10 = sin;
        }
        int i3 = (int) a3.left;
        int i10 = (int) a10.left;
        LinearInterpolator linearInterpolator = ja.a.f15383a;
        drawable.setBounds(Math.round(f10 * (i10 - i3)) + i3, drawable.getBounds().top, Math.round(cos * (((int) a10.right) - r8)) + ((int) a3.right), drawable.getBounds().bottom);
    }
}
