package com.example.test.ui.device.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.VideoHidBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.presenter.device.k1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.v2;

/* loaded from: classes.dex */
public final class VideoHidActivity extends XXBaseActivity<k1, v2> implements f7.b0, View.OnClickListener {
    public static final /* synthetic */ int F = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.VideoHidActivity$videoHidBean$2
        @Override // oh.a
        public final VideoHidBean invoke() {
            return new VideoHidBean();
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new k1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((v2) this.f7247z.getValue()).f13404a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_video_hid, (ViewGroup) null, false);
        int i3 = R$id.titleView;
        TitleView titleView = (TitleView) he.a(i3, inflate);
        if (titleView != null) {
            i3 = R$id.videoHidOpenAv;
            ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
            if (actionItemView != null) {
                i3 = R$id.videoHidOpenDefaultAv;
                ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView2 != null) {
                    return new v2((LinearLayout) inflate, actionItemView, actionItemView2, titleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((k1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((v2) bVar.getValue()).f13405b.setOnTitleListener(new f0(this, 1));
        final int i3 = 0;
        ((v2) bVar.getValue()).f13406c.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.device.activity.j0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ VideoHidActivity f7870b;

            {
                this.f7870b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                VideoHidActivity this$0 = this.f7870b;
                switch (i3) {
                    case 0:
                        int i10 = VideoHidActivity.F;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setOpen(z5);
                        break;
                    default:
                        int i11 = VideoHidActivity.F;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setDefaultOpen(z5);
                        break;
                }
            }
        });
        final int i10 = 1;
        ((v2) bVar.getValue()).f13407d.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.device.activity.j0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ VideoHidActivity f7870b;

            {
                this.f7870b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                VideoHidActivity this$0 = this.f7870b;
                switch (i10) {
                    case 0:
                        int i102 = VideoHidActivity.F;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setOpen(z5);
                        break;
                    default:
                        int i11 = VideoHidActivity.F;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setDefaultOpen(z5);
                        break;
                }
            }
        });
        R0();
    }

    public final void R0() {
        eh.b bVar = this.f7247z;
        ((v2) bVar.getValue()).f13406c.setItemOpen(S0().isOpen());
        ((v2) bVar.getValue()).f13407d.setItemOpen(S0().isDefaultOpen());
    }

    public final VideoHidBean S0() {
        return (VideoHidBean) this.E.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            view.getId();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        R0();
    }
}
