package f6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

/* loaded from: classes.dex */
public final class e implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12808a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f12809b;

    /* renamed from: c, reason: collision with root package name */
    public final SwipeRecyclerView f12810c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f12811d;

    public e(LinearLayout linearLayout, LinearLayout linearLayout2, SwipeRecyclerView swipeRecyclerView, TitleView titleView) {
        this.f12808a = linearLayout;
        this.f12809b = linearLayout2;
        this.f12810c = swipeRecyclerView;
        this.f12811d = titleView;
    }

    public static e a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_alarm, (ViewGroup) null, false);
        int i3 = R$id.addAlarmLl;
        LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
        if (linearLayout != null) {
            i3 = R$id.alarmList;
            SwipeRecyclerView swipeRecyclerView = (SwipeRecyclerView) he.a(i3, inflate);
            if (swipeRecyclerView != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new e((LinearLayout) inflate, linearLayout, swipeRecyclerView, titleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // m2.a
    public final View b() {
        return this.f12808a;
    }
}
