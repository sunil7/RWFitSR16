package eg;

import android.view.View;
import com.example.test.ui.device.activity.i0;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: classes2.dex */
public interface a {
    void a(i0 i0Var, int i3, int i10);

    void b(SmartRefreshLayout smartRefreshLayout, RefreshState refreshState, RefreshState refreshState2);

    void c(SmartRefreshLayout smartRefreshLayout, int i3, int i10);

    void d(int i3, float f2, int i10);

    void f(boolean z5, float f2, int i3, int i10, int i11);

    boolean g();

    fg.b getSpinnerStyle();

    View getView();

    void h(d dVar, int i3, int i10);

    int i(d dVar, boolean z5);

    void setPrimaryColors(int... iArr);
}
