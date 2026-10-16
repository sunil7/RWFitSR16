package l1;

import android.view.View;
import android.view.Window;
import com.autonavi.amap.mapcore.AMapEngineUtils;

/* loaded from: classes.dex */
public final class z1 extends y1 {
    @Override // l1.c2
    public final void a(boolean z5) {
        Window window = this.f15743a;
        if (!z5) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-17));
        } else {
            window.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 16);
        }
    }

    @Override // l1.c2
    public final void b(boolean z5) {
        Window window = this.f15743a;
        if (!z5) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } else {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
        }
    }
}
