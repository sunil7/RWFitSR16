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
public final class a0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12674a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionItemView f12675b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionItemView f12676c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f12677d;
    public final ActionItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final TitleView f12678f;

    /* renamed from: g, reason: collision with root package name */
    public final ActionItemView f12679g;

    public a0(LinearLayout linearLayout, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, ActionItemView actionItemView4, ActionItemView actionItemView5, TitleView titleView) {
        this.f12674a = linearLayout;
        this.f12675b = actionItemView;
        this.f12676c = actionItemView2;
        this.f12677d = actionItemView3;
        this.e = actionItemView4;
        this.f12678f = titleView;
        this.f12679g = actionItemView5;
    }

    public static a0 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_drink, (ViewGroup) null, false);
        int i3 = R$id.avRepeat;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.drinkAv;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.endTimeAv;
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
                                return new a0((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, actionItemView4, actionItemView5, titleView);
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
        return this.f12674a;
    }
}
