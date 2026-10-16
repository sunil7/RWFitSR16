package com.example.test.ui.sport.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.test.ui.XXBaseActivity;
import f6.h2;

/* loaded from: classes.dex */
public final class SportCountDownActivity extends XXBaseActivity<com.example.test.presenter.sport.a, h2> implements i7.a, o5.a {
    public static final /* synthetic */ int I = 0;
    public int E = 3;
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportCountDownActivity$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(SportCountDownActivity.this);
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportCountDownActivity$sportTargetBean$2
        @Override // oh.a
        public final SportTargetBean invoke() {
            return new SportTargetBean();
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportCountDownActivity$sportType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = SportCountDownActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("sport_type", 5) : 5);
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.sport.a(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((h2) this.f7247z.getValue()).f12952a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return h2.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.sport.a) I0()).k();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
    }

    public final SportTargetBean R0() {
        return (SportTargetBean) this.G.getValue();
    }

    public final int S0() {
        return ((Number) this.H.getValue()).intValue();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        int i3 = this.E - 1;
        this.E = i3;
        eh.b bVar = this.f7247z;
        eh.b bVar2 = this.F;
        if (i3 <= 0) {
            if (R0().isVibrator() == 1) {
                ef.i.y().M(300L);
            }
            ((h2) bVar.getValue()).f12953b.setText("GO");
            ((com.example.baselibrary.utils.e) bVar2.getValue()).postDelayed(new a(this, 0), 500L);
            return;
        }
        ((h2) bVar.getValue()).f12953b.setText(String.valueOf(this.E));
        if (R0().isVibrator() == 1) {
            ef.i.y().M(200L);
        }
        ((com.example.baselibrary.utils.e) bVar2.getValue()).sendEmptyMessageDelayed(1, 1000L);
    }
}
