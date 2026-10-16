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
public final class w2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13422a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f13423b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f13424c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f13425d;
    public final TitleView e;

    /* renamed from: f, reason: collision with root package name */
    public final ActionItemView f13426f;

    /* renamed from: g, reason: collision with root package name */
    public final ActionItemView f13427g;

    public w2(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, ActionItemView actionItemView4, ActionItemView actionItemView5, TitleView titleView) {
        this.f13422a = linearLayout;
        this.f13423b = actionItemView;
        this.f13424c = actionItemView2;
        this.f13425d = actionItemView3;
        this.e = titleView;
        this.f13426f = actionItemView4;
        this.f13427g = actionItemView5;
    }

    public static w2 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_wash_hand, (ViewGroup) null, false);
        int i3 = R$id.avRepeat;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.endTimeAv;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.startTimeAv;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.titleView;
                    TitleView titleView = (TitleView) he.a(i3, inflate);
                    if (titleView != null) {
                        i3 = R$id.warnRateAv;
                        ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                        if (actionItemView4 != null) {
                            i3 = R$id.washHandAv;
                            ActionItemView actionItemView5 = (ActionItemView) he.a(i3, inflate);
                            if (actionItemView5 != null) {
                                return new w2((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, actionItemView4, actionItemView5, titleView);
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
        return this.f13422a;
    }
}
