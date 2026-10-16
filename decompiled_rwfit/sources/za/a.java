package za;

import android.view.View;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.navigation.NavigationBarItemView;

/* loaded from: classes.dex */
public final class a extends NavigationBarItemView {
    @Override // com.google.android.material.navigation.NavigationBarItemView
    public final int getItemDefaultMarginResId() {
        return R$dimen.mtrl_navigation_rail_icon_margin;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    public final int getItemLayoutResId() {
        return R$layout.mtrl_navigation_rail_item;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        if (View.MeasureSpec.getMode(i10) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i10)), i10, 0));
        }
    }
}
