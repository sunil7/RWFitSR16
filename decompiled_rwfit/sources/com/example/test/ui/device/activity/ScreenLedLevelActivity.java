package com.example.test.ui.device.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.BrightScreenLedBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.device.f1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.r1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ScreenLedLevelActivity extends XXBaseActivity<f1, r1> implements f7.x, View.OnClickListener {
    public static final /* synthetic */ int H = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScreenLedLevelActivity$brightLedLevelBean$2
        @Override // oh.a
        public final BrightScreenLedBean invoke() {
            return new BrightScreenLedBean();
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScreenLedLevelActivity$options$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ScreenLedLevelActivity.this.getString(R$string.str_ring_screen_light_0));
            arrayList.add(ScreenLedLevelActivity.this.getString(R$string.str_ring_screen_light_1));
            arrayList.add(ScreenLedLevelActivity.this.getString(R$string.str_ring_screen_light_2));
            arrayList.add(ScreenLedLevelActivity.this.getString(R$string.str_ring_screen_light_3));
            return arrayList;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScreenLedLevelActivity$selectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ScreenLedLevelActivity screenLedLevelActivity = ScreenLedLevelActivity.this;
            int i3 = ScreenLedLevelActivity.H;
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(screenLedLevelActivity, (List) screenLedLevelActivity.F.getValue());
            lVar.setOnDialogDataListener(new yh.h(ScreenLedLevelActivity.this));
            return lVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new f1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((r1) this.f7247z.getValue()).f13273a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_screen_led_level, (ViewGroup) null, false);
        int i3 = R$id.avScreenInfo;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.titleView;
            TitleView titleView = (TitleView) he.a(i3, inflate);
            if (titleView != null) {
                return new r1((LinearLayout) inflate, actionItemView, titleView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((f1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((r1) bVar.getValue()).f13274b.setOnClickListener(this);
        ((r1) bVar.getValue()).f13275c.setOnTitleListener(new androidx.appcompat.app.t(this, 28));
        R0();
    }

    public final void R0() {
        boolean isOpen = S0().isOpen();
        eh.b bVar = this.f7247z;
        if (isOpen) {
            ((r1) bVar.getValue()).f13274b.setHintStr((String) ((List) this.F.getValue()).get(S0().getLcdLevel()));
            return;
        }
        ActionItemView actionItemView = ((r1) bVar.getValue()).f13274b;
        String string = getString(R$string.str_ring_screen_light_0);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        actionItemView.setHintStr(string);
    }

    public final BrightScreenLedBean S0() {
        return (BrightScreenLedBean) this.E.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.avScreenInfo;
        if (valueOf != null && valueOf.intValue() == i3) {
            boolean isOpen = S0().isOpen();
            eh.b bVar = this.G;
            if (isOpen) {
                ((com.example.test.ui.dialog.l) bVar.getValue()).a(S0().getLcdLevel());
            } else {
                ((com.example.test.ui.dialog.l) bVar.getValue()).a(0);
            }
            ((com.example.test.ui.dialog.l) bVar.getValue()).show();
        }
    }
}
