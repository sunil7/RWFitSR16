package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.j1;
import androidx.recyclerview.widget.k1;

/* loaded from: classes.dex */
public final class h implements k1 {
    @Override // androidx.recyclerview.widget.k1
    public final void a(View view) {
        j1 j1Var = (j1) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) j1Var).width != -1 || ((ViewGroup.MarginLayoutParams) j1Var).height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }

    @Override // androidx.recyclerview.widget.k1
    public final void c(View view) {
    }
}
