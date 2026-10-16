package com.example.test.ui.device.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.s0;

/* loaded from: classes.dex */
public final class MensRemindModelActivity extends XXBaseActivity<com.example.test.presenter.device.a, s0> implements p5.a {
    public static final /* synthetic */ int I = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.MensRemindModelActivity$isMensRemind$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = MensRemindModelActivity.this.getIntent();
            boolean z5 = false;
            if (intent != null) {
                int i3 = MensRemindModelActivity.I;
                z5 = intent.getBooleanExtra("isMensRemind", false);
            }
            return Boolean.valueOf(z5);
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.MensRemindModelActivity$isOvulRemind$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = MensRemindModelActivity.this.getIntent();
            boolean z5 = false;
            if (intent != null) {
                int i3 = MensRemindModelActivity.I;
                z5 = intent.getBooleanExtra("isOvulRemind", false);
            }
            return Boolean.valueOf(z5);
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.MensRemindModelActivity$isOvulHighRemind$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = MensRemindModelActivity.this.getIntent();
            boolean z5 = false;
            if (intent != null) {
                int i3 = MensRemindModelActivity.I;
                z5 = intent.getBooleanExtra("isOvulHighRemind", false);
            }
            return Boolean.valueOf(z5);
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.MensRemindModelActivity$isOvulOverRemind$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = MensRemindModelActivity.this.getIntent();
            boolean z5 = false;
            if (intent != null) {
                int i3 = MensRemindModelActivity.I;
                z5 = intent.getBooleanExtra("isOvulOverRemind", false);
            }
            return Boolean.valueOf(z5);
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.a(this, 1);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((s0) this.f7247z.getValue()).f13290a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_mens_remind_model, (ViewGroup) null, false);
        int i3 = R$id.mens_remind;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.ovulation_finish_remind;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.ovulation__high_remind;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.ovulation_remind;
                    ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView4 != null) {
                        i3 = R$id.titleView;
                        TitleView titleView = (TitleView) he.a(i3, inflate);
                        if (titleView != null) {
                            return new s0((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, actionItemView4, titleView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        eh.b bVar = this.f7247z;
        ((s0) bVar.getValue()).f13291b.setItemOpen(((Boolean) this.E.getValue()).booleanValue());
        ((s0) bVar.getValue()).e.setItemOpen(((Boolean) this.F.getValue()).booleanValue());
        ((s0) bVar.getValue()).f13293d.setItemOpen(((Boolean) this.G.getValue()).booleanValue());
        ((s0) bVar.getValue()).f13292c.setItemOpen(((Boolean) this.H.getValue()).booleanValue());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        ((s0) this.f7247z.getValue()).f13294f.setOnTitleListener(new q(this));
    }
}
