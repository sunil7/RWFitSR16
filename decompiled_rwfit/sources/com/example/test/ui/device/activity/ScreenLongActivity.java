package com.example.test.ui.device.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.BrightScreenTimeBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.device.h1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.tencent.connect.common.Constants;
import f6.t1;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class ScreenLongActivity extends XXBaseActivity<h1, t1> implements f7.z, View.OnClickListener {
    public static final /* synthetic */ int H = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScreenLongActivity$brightTimeBean$2
        @Override // oh.a
        public final BrightScreenTimeBean invoke() {
            return new BrightScreenTimeBean();
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScreenLongActivity$options$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            if (!y5.d.f20005b) {
                arrayList.add(ScreenLongActivity.this.getString(R$string.str_always_bright));
                arrayList.add("5");
                arrayList.add(Constants.VIA_REPORT_TYPE_WPA_STATE);
                arrayList.add("30");
                arrayList.add("45");
                return arrayList;
            }
            arrayList.add("5");
            arrayList.add(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
            arrayList.add(Constants.VIA_REPORT_TYPE_WPA_STATE);
            arrayList.add("20");
            arrayList.add(Constants.VIA_REPORT_TYPE_CHAT_AUDIO);
            arrayList.add("30");
            return arrayList;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScreenLongActivity$selectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ScreenLongActivity screenLongActivity = ScreenLongActivity.this;
            int i3 = ScreenLongActivity.H;
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(screenLongActivity, (List) screenLongActivity.F.getValue());
            lVar.setOnDialogDataListener(new f0(ScreenLongActivity.this, 0));
            return lVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new h1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((t1) this.f7247z.getValue()).f13339a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_screen_long, (ViewGroup) null, false);
        int i3 = R$id.avScreenInfo;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.titleView;
            TitleView titleView = (TitleView) he.a(i3, inflate);
            if (titleView != null) {
                return new t1((LinearLayout) inflate, actionItemView, titleView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((h1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((t1) bVar.getValue()).f13340b.setOnClickListener(this);
        ((t1) bVar.getValue()).f13341c.setOnTitleListener(new e0(this, 0));
        R0();
    }

    public final void R0() {
        int timeSecond = S0().getTimeSecond();
        eh.b bVar = this.f7247z;
        if (timeSecond == 0) {
            ActionItemView actionItemView = ((t1) bVar.getValue()).f13340b;
            String string = getString(R$string.str_always_bright);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            actionItemView.setHintStr(string);
            return;
        }
        ((t1) bVar.getValue()).f13340b.setHintStr(S0().getTimeSecond() + " " + getString(R$string.str_second));
    }

    public final BrightScreenTimeBean S0() {
        return (BrightScreenTimeBean) this.E.getValue();
    }

    public final void T0(BrightScreenTimeBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        S0().setTimeSecond(data.getTimeSecond());
        if (data.getDurationNums().length() > 0) {
            eh.b bVar = this.F;
            ((List) bVar.getValue()).clear();
            String durationNums = data.getDurationNums();
            kotlin.jvm.internal.e.e(durationNums, "getDurationNums(...)");
            if (kotlin.text.m.c(durationNums, "_0", false)) {
                ((List) bVar.getValue()).add(getString(R$string.str_always_bright));
            }
            String durationNums2 = data.getDurationNums();
            kotlin.jvm.internal.e.e(durationNums2, "getDurationNums(...)");
            for (String str : kotlin.text.m.u(durationNums2, new String[]{"_"})) {
                if (!str.equals("0")) {
                    ((List) bVar.getValue()).add(str);
                }
            }
        }
        R0();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onBrightTimeEvent(EventBusBeans.BrightTimeEvent brightTimeEvent) {
        kotlin.jvm.internal.e.f(brightTimeEvent, "brightTimeEvent");
        if (brightTimeEvent.getBrightScreenTimeBean() != null) {
            S0().setTimeSecond(brightTimeEvent.getBrightScreenTimeBean().getTimeSecond());
            R0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.avScreenInfo;
        if (valueOf != null && valueOf.intValue() == i3) {
            int timeSecond = S0().getTimeSecond();
            eh.b bVar = this.G;
            if (timeSecond == 0) {
                ((com.example.test.ui.dialog.l) bVar.getValue()).a(0);
            } else {
                int indexOf = ((List) this.F.getValue()).indexOf(String.valueOf(S0().getTimeSecond()));
                ((com.example.test.ui.dialog.l) bVar.getValue()).a(indexOf != -1 ? indexOf : 0);
            }
            ((com.example.test.ui.dialog.l) bVar.getValue()).show();
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }
}
