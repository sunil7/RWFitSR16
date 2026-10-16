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
public final class y2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13463a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13464b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13465c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f13466d;
    public final ActionItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final ActionItemView f13467f;

    /* renamed from: g, reason: collision with root package name */
    public final ActionItemView f13468g;

    /* renamed from: h, reason: collision with root package name */
    public final ActionItemView f13469h;

    /* renamed from: i, reason: collision with root package name */
    public final ActionItemView f13470i;

    /* renamed from: j, reason: collision with root package name */
    public final ActionItemView f13471j;

    /* renamed from: k, reason: collision with root package name */
    public final TitleView f13472k;

    public y2(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, LinearLayout linearLayout2, ActionItemView actionItemView3, ActionItemView actionItemView4, ActionItemView actionItemView5, ActionItemView actionItemView6, ActionItemView actionItemView7, ActionItemView actionItemView8, TitleView titleView) {
        this.f13463a = linearLayout;
        this.f13464b = actionItemView;
        this.f13465c = actionItemView2;
        this.f13466d = linearLayout2;
        this.e = actionItemView3;
        this.f13467f = actionItemView4;
        this.f13468g = actionItemView5;
        this.f13469h = actionItemView6;
        this.f13470i = actionItemView7;
        this.f13471j = actionItemView8;
        this.f13472k = titleView;
    }

    public static y2 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_women_health, (ViewGroup) null, false);
        int i3 = R$id.av_wh;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.last_mens_day;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.ll_action;
                LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                if (linearLayout != null) {
                    i3 = R$id.mens_remind;
                    ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView3 != null) {
                        i3 = R$id.menstrual_period;
                        ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                        if (actionItemView4 != null) {
                            i3 = R$id.ovulation_remind;
                            ActionItemView actionItemView5 = (ActionItemView) he.a(i3, inflate);
                            if (actionItemView5 != null) {
                                i3 = R$id.range_days;
                                ActionItemView actionItemView6 = (ActionItemView) he.a(i3, inflate);
                                if (actionItemView6 != null) {
                                    i3 = R$id.remind_model;
                                    ActionItemView actionItemView7 = (ActionItemView) he.a(i3, inflate);
                                    if (actionItemView7 != null) {
                                        i3 = R$id.remind_time;
                                        ActionItemView actionItemView8 = (ActionItemView) he.a(i3, inflate);
                                        if (actionItemView8 != null) {
                                            i3 = R$id.titleView;
                                            TitleView titleView = (TitleView) he.a(i3, inflate);
                                            if (titleView != null) {
                                                return new y2((LinearLayout) inflate, actionItemView, actionItemView2, linearLayout, actionItemView3, actionItemView4, actionItemView5, actionItemView6, actionItemView7, actionItemView8, titleView);
                                            }
                                        }
                                    }
                                }
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
        return this.f13463a;
    }
}
