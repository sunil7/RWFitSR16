package com.google.android.material.bottomappbar;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.material.R$dimen;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class f implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar.Behavior f10261a;

    public f(BottomAppBar.Behavior behavior) {
        this.f10261a = behavior;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int bottomInset;
        int leftInset;
        int rightInset;
        BottomAppBar.Behavior behavior = this.f10261a;
        BottomAppBar bottomAppBar = (BottomAppBar) behavior.f10243f.get();
        if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
            view.removeOnLayoutChangeListener(this);
            return;
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
        int measuredWidth = floatingActionButton.getMeasuredWidth();
        int measuredHeight = floatingActionButton.getMeasuredHeight();
        Rect rect = behavior.e;
        rect.set(0, 0, measuredWidth, measuredHeight);
        floatingActionButton.j(rect);
        int height = rect.height();
        bottomAppBar.F(height);
        bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().e.a(new RectF(rect)));
        x0.f fVar = (x0.f) view.getLayoutParams();
        if (behavior.f10244g == 0) {
            int dimensionPixelOffset = bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2);
            bottomInset = bottomAppBar.getBottomInset();
            ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomInset + dimensionPixelOffset;
            leftInset = bottomAppBar.getLeftInset();
            ((ViewGroup.MarginLayoutParams) fVar).leftMargin = leftInset;
            rightInset = bottomAppBar.getRightInset();
            ((ViewGroup.MarginLayoutParams) fVar).rightMargin = rightInset;
            boolean d5 = gb.d(floatingActionButton);
            int i17 = bottomAppBar.R;
            if (d5) {
                ((ViewGroup.MarginLayoutParams) fVar).leftMargin += i17;
            } else {
                ((ViewGroup.MarginLayoutParams) fVar).rightMargin += i17;
            }
        }
    }
}
