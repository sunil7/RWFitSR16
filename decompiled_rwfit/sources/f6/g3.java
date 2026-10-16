package f6;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.DeviceInfoView;
import com.example.test.ui.view.ToolBarView;

/* loaded from: classes.dex */
public final class g3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f12924a;

    /* renamed from: b, reason: collision with root package name */
    public final DeviceInfoView f12925b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f12926c;

    /* renamed from: d, reason: collision with root package name */
    public final ToolBarView f12927d;

    public g3(RelativeLayout relativeLayout, DeviceInfoView deviceInfoView, RecyclerView recyclerView, ToolBarView toolBarView) {
        this.f12924a = relativeLayout;
        this.f12925b = deviceInfoView;
        this.f12926c = recyclerView;
        this.f12927d = toolBarView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12924a;
    }
}
