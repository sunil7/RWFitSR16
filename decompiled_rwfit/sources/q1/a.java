package q1;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public final class a implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        DrawerLayout drawerLayout = (DrawerLayout) view;
        boolean z5 = false;
        boolean z6 = windowInsets.getSystemWindowInsetTop() > 0;
        drawerLayout.f2013w = windowInsets;
        drawerLayout.f2014x = z6;
        if (!z6 && drawerLayout.getBackground() == null) {
            z5 = true;
        }
        drawerLayout.setWillNotDraw(z5);
        drawerLayout.requestLayout();
        return windowInsets.consumeSystemWindowInsets();
    }
}
