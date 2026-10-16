package f6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public final class d1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f12779a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f12780b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f12781c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionItemView f12782d;
    public final ActionItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final ActionItemView f12783f;

    /* renamed from: g, reason: collision with root package name */
    public final ActionItemView f12784g;

    /* renamed from: h, reason: collision with root package name */
    public final ActionItemView f12785h;

    /* renamed from: i, reason: collision with root package name */
    public final TitleView f12786i;

    /* renamed from: j, reason: collision with root package name */
    public final ActionItemView f12787j;

    public d1(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, ActionItemView actionItemView, ActionItemView actionItemView2, ActionItemView actionItemView3, ActionItemView actionItemView4, ActionItemView actionItemView5, TitleView titleView, ActionItemView actionItemView6) {
        this.f12779a = linearLayout;
        this.f12780b = imageView;
        this.f12781c = linearLayout2;
        this.f12782d = actionItemView;
        this.e = actionItemView2;
        this.f12783f = actionItemView3;
        this.f12784g = actionItemView4;
        this.f12785h = actionItemView5;
        this.f12786i = titleView;
        this.f12787j = actionItemView6;
    }

    public static d1 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R$layout.activity_personal, (ViewGroup) null, false);
        int i3 = R$id.avatarIv;
        ImageView imageView = (ImageView) he.a(i3, inflate);
        if (imageView != null) {
            i3 = R$id.avatarLl;
            LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
            if (linearLayout != null) {
                i3 = R$id.birthdayAv;
                ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
                if (actionItemView != null) {
                    i3 = R$id.heightAv;
                    ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView2 != null) {
                        i3 = R$id.itemName;
                        if (((TextView) he.a(i3, inflate)) != null) {
                            i3 = R$id.ivNext;
                            if (((ImageView) he.a(i3, inflate)) != null) {
                                i3 = R$id.nickNameAv;
                                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                                if (actionItemView3 != null) {
                                    i3 = R$id.sexAv;
                                    ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                                    if (actionItemView4 != null) {
                                        i3 = R$id.targetAv;
                                        ActionItemView actionItemView5 = (ActionItemView) he.a(i3, inflate);
                                        if (actionItemView5 != null) {
                                            i3 = R$id.titleView;
                                            TitleView titleView = (TitleView) he.a(i3, inflate);
                                            if (titleView != null) {
                                                i3 = R$id.weightAv;
                                                ActionItemView actionItemView6 = (ActionItemView) he.a(i3, inflate);
                                                if (actionItemView6 != null) {
                                                    return new d1((LinearLayout) inflate, imageView, linearLayout, actionItemView, actionItemView2, actionItemView3, actionItemView4, actionItemView5, titleView, actionItemView6);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // m2.a
    public final View b() {
        return this.f12779a;
    }
}
