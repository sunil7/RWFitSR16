package f6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public final class q0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13249a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13250b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13251c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13252d;
    public final ActionItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final TitleView f13253f;

    /* renamed from: g, reason: collision with root package name */
    public final ActionItemView f13254g;

    public q0(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, ActionItemView actionItemView4, ActionItemView actionItemView5, TitleView titleView) {
        this.f13249a = linearLayout;
        this.f13250b = actionItemView;
        this.f13251c = actionItemView2;
        this.f13252d = actionItemView3;
        this.e = actionItemView4;
        this.f13253f = titleView;
        this.f13254g = actionItemView5;
    }

    public static q0 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_long_sit, (ViewGroup) null, false);
        int i3 = R$id.avRepeat;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.endTimeAv;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.longSitAv;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.startTimeAv;
                    ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView4 != null) {
                        i3 = R$id.titleView;
                        TitleView titleView = (TitleView) he.a(i3, inflate);
                        if (titleView != null) {
                            i3 = R$id.warnRateAv;
                            ActionItemView actionItemView5 = (ActionItemView) he.a(i3, inflate);
                            if (actionItemView5 != null) {
                                return new q0((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, actionItemView4, actionItemView5, titleView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // m2.a
    public final View b() {
        return this.f13249a;
    }
}
