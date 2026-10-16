package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import na.a;
import na.b;

/* loaded from: classes.dex */
public class BottomNavigationView extends NavigationBarView {
    public BottomNavigationView(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public final NavigationBarMenuView a(Context context) {
        return new BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public void setItemHorizontalTranslationEnabled(boolean z5) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.A != z5) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z5);
            getPresenter().g(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(a aVar) {
        setOnItemReselectedListener(aVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(b bVar) {
        setOnItemSelectedListener(bVar);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomNavigationStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BottomNavigationView(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.R$style.Widget_Design_BottomNavigationView
            r6.<init>(r7, r8, r9, r4)
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R$styleable.BottomNavigationView
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            de.o r7 = com.google.android.material.internal.w.e(r0, r1, r2, r3, r4, r5)
            int r8 = com.google.android.material.R$styleable.BottomNavigationView_itemHorizontalTranslationEnabled
            java.lang.Object r9 = r7.f12378c
            android.content.res.TypedArray r9 = (android.content.res.TypedArray) r9
            r0 = 1
            boolean r8 = r9.getBoolean(r8, r0)
            r6.setItemHorizontalTranslationEnabled(r8)
            r7.K()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomnavigation.BottomNavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
