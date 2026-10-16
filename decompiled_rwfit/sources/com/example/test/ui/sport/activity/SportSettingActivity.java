package com.example.test.ui.sport.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.sport.y;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.od;
import f6.g2;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class SportSettingActivity extends XXBaseActivity<y, g2> implements i7.i, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportSettingActivity$sportTargetBean$2
        @Override // oh.a
        public final SportTargetBean invoke() {
            return new SportTargetBean();
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportSettingActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 10;
            int a3 = od.a(10, 180, 10);
            if (10 <= a3) {
                while (true) {
                    arrayList.add(String.valueOf(i3));
                    if (i3 == a3) {
                        break;
                    }
                    i3 += 10;
                }
            }
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(SportSettingActivity.this, arrayList);
            lVar.setOnDialogDataListener(new r(SportSettingActivity.this, 3));
            return lVar;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportSettingActivity$calorieDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 100;
            int a3 = od.a(100, 1000, 100);
            if (100 <= a3) {
                while (true) {
                    arrayList.add(String.valueOf(i3));
                    if (i3 == a3) {
                        break;
                    }
                    i3 += 100;
                }
            }
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(SportSettingActivity.this, arrayList);
            lVar.setOnDialogDataListener(new r(SportSettingActivity.this, 0));
            return lVar;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportSettingActivity$distanceDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 1;
            while (true) {
                int i10 = i3 + 1;
                arrayList.add(String.valueOf(i3));
                if (i10 > 10) {
                    com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(SportSettingActivity.this, arrayList);
                    lVar.setOnDialogDataListener(new r(SportSettingActivity.this, 1));
                    return lVar;
                }
                i3 = i10;
            }
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new y(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((g2) this.f7247z.getValue()).f12917a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_sport_setting, (ViewGroup) null, false);
        int i3 = R$id.avAutoPause;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.avCalTarget;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.avDistanceTarget;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.avScreenLight;
                    ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView4 != null) {
                        i3 = R$id.avTimeTarget;
                        ActionItemView actionItemView5 = (ActionItemView) he.a(i3, inflate);
                        if (actionItemView5 != null) {
                            i3 = R$id.avVibratorSetting;
                            ActionItemView actionItemView6 = (ActionItemView) he.a(i3, inflate);
                            if (actionItemView6 != null) {
                                i3 = R$id.titleView;
                                TitleView titleView = (TitleView) he.a(i3, inflate);
                                if (titleView != null) {
                                    return new g2((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, actionItemView4, actionItemView5, actionItemView6, titleView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((y) I0()).k();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((g2) bVar.getValue()).f12921f.setOnClickListener(this);
        ((g2) bVar.getValue()).f12920d.setOnClickListener(this);
        ((g2) bVar.getValue()).f12919c.setOnClickListener(this);
        ((g2) bVar.getValue()).f12923h.setOnTitleListener(new r(this, 2));
        final int i3 = 0;
        ((g2) bVar.getValue()).f12922g.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.sport.activity.q

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SportSettingActivity f8185b;

            {
                this.f8185b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                SportSettingActivity this$0 = this.f8185b;
                switch (i3) {
                    case 0:
                        int i10 = SportSettingActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setVibrator(z5 ? 1 : 0);
                        break;
                    case 1:
                        int i11 = SportSettingActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setScreenLight(z5 ? 1 : 0);
                        break;
                    default:
                        int i12 = SportSettingActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setAutoPause(z5 ? 1 : 0);
                        break;
                }
            }
        });
        final int i10 = 1;
        ((g2) bVar.getValue()).e.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.sport.activity.q

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SportSettingActivity f8185b;

            {
                this.f8185b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                SportSettingActivity this$0 = this.f8185b;
                switch (i10) {
                    case 0:
                        int i102 = SportSettingActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setVibrator(z5 ? 1 : 0);
                        break;
                    case 1:
                        int i11 = SportSettingActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setScreenLight(z5 ? 1 : 0);
                        break;
                    default:
                        int i12 = SportSettingActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setAutoPause(z5 ? 1 : 0);
                        break;
                }
            }
        });
        final int i11 = 2;
        ((g2) bVar.getValue()).f12918b.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.sport.activity.q

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SportSettingActivity f8185b;

            {
                this.f8185b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                SportSettingActivity this$0 = this.f8185b;
                switch (i11) {
                    case 0:
                        int i102 = SportSettingActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setVibrator(z5 ? 1 : 0);
                        break;
                    case 1:
                        int i112 = SportSettingActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setScreenLight(z5 ? 1 : 0);
                        break;
                    default:
                        int i12 = SportSettingActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.S0().setAutoPause(z5 ? 1 : 0);
                        break;
                }
            }
        });
        R0();
    }

    public final void R0() {
        User d5;
        ((g2) this.f7247z.getValue()).f12921f.setHintStr(String.format("%d min", Arrays.copyOf(new Object[]{Integer.valueOf(S0().getTime())}, 1)));
        ((g2) this.f7247z.getValue()).f12919c.setHintStr(String.format("%d kcal", Arrays.copyOf(new Object[]{Integer.valueOf(S0().getCalorie())}, 1)));
        String string = getString(R$string.str_km);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null && (d5 = kVar.d()) != null && d5.getMeterUnit() == 1) {
            string = getString(R$string.str_mile);
            kotlin.jvm.internal.e.e(string, "getString(...)");
        }
        ((g2) this.f7247z.getValue()).f12920d.setHintStr(String.format("%d %s", Arrays.copyOf(new Object[]{Integer.valueOf(S0().getDistance()), string}, 2)));
    }

    public final SportTargetBean S0() {
        return (SportTargetBean) this.E.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.avTimeTarget;
        if (valueOf != null && valueOf.intValue() == i3) {
            eh.b bVar = this.F;
            ((com.example.test.ui.dialog.l) bVar.getValue()).a((S0().getTime() / 10) - 1);
            ((com.example.test.ui.dialog.l) bVar.getValue()).show();
            return;
        }
        int i10 = R$id.avCalTarget;
        if (valueOf != null && valueOf.intValue() == i10) {
            eh.b bVar2 = this.G;
            ((com.example.test.ui.dialog.l) bVar2.getValue()).a((S0().getCalorie() / 100) - 1);
            ((com.example.test.ui.dialog.l) bVar2.getValue()).show();
            return;
        }
        int i11 = R$id.avDistanceTarget;
        if (valueOf != null && valueOf.intValue() == i11) {
            eh.b bVar3 = this.H;
            ((com.example.test.ui.dialog.l) bVar3.getValue()).a(S0().getDistance() - 1);
            ((com.example.test.ui.dialog.l) bVar3.getValue()).show();
        }
    }
}
