package f6;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.view.TRingDeviceInfoView;

/* loaded from: classes.dex */
public final class u3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f13379a;

    /* renamed from: b, reason: collision with root package name */
    public final TRingDeviceInfoView f13380b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f13381c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f13382d;

    public u3(RelativeLayout relativeLayout, TRingDeviceInfoView tRingDeviceInfoView, RecyclerView recyclerView, RelativeLayout relativeLayout2) {
        this.f13379a = relativeLayout;
        this.f13380b = tRingDeviceInfoView;
        this.f13381c = recyclerView;
        this.f13382d = relativeLayout2;
    }

    @Override // m2.a
    public final View b() {
        return this.f13379a;
    }
}
