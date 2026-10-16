package com.example.test.ui.sport.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.service.r0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ToolBarView;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.n1;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import f6.b2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class SportDetailJLActivity extends XXBaseActivity<com.example.test.presenter.sport.c, b2> implements i7.b, View.OnClickListener, e6.b, o5.a {
    public static final /* synthetic */ int M = 0;
    public boolean G;
    public boolean L;
    public final int E = 200;
    public double F = Double.NaN;
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportDetailJLActivity$sportTargetBean$2
        @Override // oh.a
        public final SportTargetBean invoke() {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                return kVar.B();
            }
            return null;
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportDetailJLActivity$finishSportDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(SportDetailJLActivity.this);
            rVar.b(R$string.str_finish_sport_legel);
            rVar.setOnDialogListener(new hc.a(5));
            return rVar;
        }
    });
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportDetailJLActivity$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(SportDetailJLActivity.this);
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportDetailJLActivity$sportType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = SportDetailJLActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("sport_type", 5) : 5);
        }
    });

    @Override // i7.b
    public final void D(long j4) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportRecord", l0.l(j4, "SPORT ID "));
        if (!r5.b.k().f18054c) {
            finish();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) SportRecordDetailActivity.class);
        intent.putExtra("sport_id", j4);
        intent.putExtra("sport_status", true);
        startActivity(intent);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        com.example.test.presenter.sport.c cVar = new com.example.test.presenter.sport.c(this);
        com.example.test.presenter.sport.b bVar = new com.example.test.presenter.sport.b();
        bVar.f7602a = this;
        cVar.f7603b = bVar;
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bVar;
        I0.K0(eVar);
        return cVar;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((b2) this.f7247z.getValue()).f12716a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return b2.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        XXApplication xXApplication = XXApplication.f7400h;
        j1.a();
        Object obj = r0.M;
        if (!n1.a().j(this)) {
            w0(R$string.str_sport_supoort_tips);
            finish();
            return;
        }
        n1.a().k(this);
        n1.a().n(R0());
        com.example.test.presenter.sport.c cVar = (com.example.test.presenter.sport.c) I0();
        int R0 = R0();
        cVar.getClass();
        com.example.test.presenter.sport.c.k((byte) 1, R0);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 != null) {
            if (d5.getMeterUnit() == 0) {
                ((b2) this.f7247z.getValue()).e.setText(getString(R$string.str_km));
            } else {
                ((b2) this.f7247z.getValue()).e.setText(getString(R$string.str_mile));
            }
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        SportTargetBean sportTargetBean;
        com.google.android.gms.internal.mlkit_vision_barcode.b2.a(this);
        y u10 = y.u();
        eh.b bVar = this.H;
        boolean z5 = true;
        if (((SportTargetBean) bVar.getValue()) != null && ((sportTargetBean = (SportTargetBean) bVar.getValue()) == null || sportTargetBean.isScreenLight() != 1)) {
            z5 = false;
        }
        u10.y(z5);
        eh.b bVar2 = this.f7247z;
        ((b2) bVar2.getValue()).f12723i.setOnClickListener(this);
        ((b2) bVar2.getValue()).f12728n.setOnClickListener(this);
        ((b2) bVar2.getValue()).f12724j.setOnClickListener(this);
        ((b2) bVar2.getValue()).f12731q.setOnClickListener(this);
        ((b2) bVar2.getValue()).f12720f.setOnClickListener(this);
        ((b2) bVar2.getValue()).f12729o.setOnViewChildListener(new n9.e(5));
        int R0 = R0();
        if (R0 == 2) {
            ToolBarView toolBarView = ((b2) bVar2.getValue()).f12729o;
            String string = getString(R$string.str_tab_sport_biking);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            toolBarView.setBarTitle(string);
            ((b2) bVar2.getValue()).f12729o.setBarStatusDrawable(R$mipmap.ic_sport_bike);
        } else if (R0 == 7) {
            ToolBarView toolBarView2 = ((b2) bVar2.getValue()).f12729o;
            String string2 = getString(R$string.str_tab_sport_walking);
            kotlin.jvm.internal.e.e(string2, "getString(...)");
            toolBarView2.setBarTitle(string2);
            ((b2) bVar2.getValue()).f12729o.setBarStatusDrawable(R$mipmap.ic_sport_walk);
        } else if (R0 == 14) {
            ToolBarView toolBarView3 = ((b2) bVar2.getValue()).f12729o;
            String string3 = getString(R$string.str_tab_sport_climing);
            kotlin.jvm.internal.e.e(string3, "getString(...)");
            toolBarView3.setBarTitle(string3);
            ((b2) bVar2.getValue()).f12729o.setBarStatusDrawable(R$mipmap.ic_sport_climb);
        } else if (R0 == 4) {
            ToolBarView toolBarView4 = ((b2) bVar2.getValue()).f12729o;
            String string4 = getString(R$string.str_tab_sport_running_indoor);
            kotlin.jvm.internal.e.e(string4, "getString(...)");
            toolBarView4.setBarTitle(string4);
            ((b2) bVar2.getValue()).f12729o.setBarStatusDrawable(R$mipmap.ic_sport_run);
            ((b2) bVar2.getValue()).f12731q.setVisibility(8);
        } else if (R0 == 5) {
            ToolBarView toolBarView5 = ((b2) bVar2.getValue()).f12729o;
            String string5 = getString(R$string.str_tab_sport_running_outdoor);
            kotlin.jvm.internal.e.e(string5, "getString(...)");
            toolBarView5.setBarTitle(string5);
            ((b2) bVar2.getValue()).f12729o.setBarStatusDrawable(R$mipmap.ic_sport_run);
        }
        ((b2) bVar2.getValue()).f12725k.setMyClickListener(new d(this, 0));
        ((b2) bVar2.getValue()).f12726l.setMyClickListener(new d(this, 1));
    }

    public final int R0() {
        return ((Number) this.K.getValue()).intValue();
    }

    public final void S0() {
        eh.b bVar = this.f7247z;
        ((b2) bVar.getValue()).f12727m.setVisibility(0);
        ((b2) bVar.getValue()).f12721g.setVisibility(0);
        ((b2) bVar.getValue()).f12723i.setVisibility(8);
        com.example.test.presenter.sport.c cVar = (com.example.test.presenter.sport.c) I0();
        int R0 = R0();
        cVar.getClass();
        com.example.test.presenter.sport.c.k((byte) 3, R0);
    }

    public final void T0() {
        eh.b bVar = this.f7247z;
        ((b2) bVar.getValue()).f12727m.setVisibility(8);
        ((b2) bVar.getValue()).f12721g.setVisibility(4);
        ((b2) bVar.getValue()).f12723i.setVisibility(0);
        com.example.test.presenter.sport.c cVar = (com.example.test.presenter.sport.c) I0();
        int R0 = R0();
        cVar.getClass();
        com.example.test.presenter.sport.c.k((byte) 2, R0);
    }

    @Override // e6.b
    public final void W() {
        com.example.test.presenter.sport.c cVar = (com.example.test.presenter.sport.c) I0();
        int R0 = R0();
        cVar.getClass();
        com.example.test.presenter.sport.c.k((byte) 4, R0);
    }

    @Override // e6.b
    public final void X(long j4, double d5, double d8, long j10, long j11) {
        this.F = d8;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d10 = kVar != null ? kVar.d() : null;
        if (d10 != null) {
            if (d10.getMeterUnit() == 0) {
                android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (((float) (d8 / 1000)) * 100)) / 100.0f)}, 1, "%.2f", ((b2) this.f7247z.getValue()).f12719d);
                ((b2) this.f7247z.getValue()).e.setText(getString(R$string.str_km));
                long j12 = 60;
                android.support.v4.media.session.e.A(new Object[]{Long.valueOf(j10 / j12), Long.valueOf(j10 % j12)}, 2, "%d'%02d''", ((b2) this.f7247z.getValue()).f12718c);
            } else {
                android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (v1.b((float) d8) * 100)) / 100.0f)}, 1, "%.2f", ((b2) this.f7247z.getValue()).f12719d);
                ((b2) this.f7247z.getValue()).e.setText(getString(R$string.str_mile));
                long j13 = 60;
                android.support.v4.media.session.e.A(new Object[]{Long.valueOf(j11 / j13), Long.valueOf(j11 % j13)}, 2, "%d'%02d''", ((b2) this.f7247z.getValue()).f12718c);
            }
        }
        android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (((float) d5) * 10)) / 10.0f)}, 1, "%.1f", ((b2) this.f7247z.getValue()).f12717b);
        long j14 = 3600;
        long j15 = j4 / j14;
        long j16 = j4 % j14;
        long j17 = 60;
        android.support.v4.media.session.e.A(new Object[]{Long.valueOf(j15), Long.valueOf(j16 / j17), Long.valueOf(j16 % j17)}, 3, "%02d:%02d:%02d", ((b2) this.f7247z.getValue()).f12730p);
    }

    @Override // e6.b
    public final void j(boolean z5) {
        this.L = z5;
        if (this.G) {
            return;
        }
        if (z5) {
            S0();
        } else {
            T0();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.playBtn;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (this.G) {
                return;
            }
            T0();
            Object obj = r0.M;
            r0 a3 = n1.a();
            a3.f7774v = false;
            a3.J = 0;
            a3.L = false;
            return;
        }
        int i10 = R$id.stopBtn;
        if (valueOf != null && valueOf.intValue() == i10) {
            return;
        }
        int i11 = R$id.pauseBtn;
        if (valueOf != null && valueOf.intValue() == i11) {
            if (this.G) {
                return;
            }
            S0();
            Object obj2 = r0.M;
            n1.a().f7774v = true;
            return;
        }
        int i12 = R$id.tvMap;
        if (valueOf != null && valueOf.intValue() == i12) {
            if (this.G) {
                return;
            }
            startActivity(new Intent(this, (Class<?>) SportMapActivity.class));
            return;
        }
        int i13 = R$id.ivLock;
        if (valueOf == null || valueOf.intValue() != i13 || this.G) {
            return;
        }
        this.G = true;
        eh.b bVar = this.f7247z;
        ((b2) bVar.getValue()).f12727m.setVisibility(8);
        ((b2) bVar.getValue()).f12723i.setVisibility(0);
        ((b2) bVar.getValue()).f12723i.setImageResource(R$mipmap.ic_unlock);
        ((b2) bVar.getValue()).f12722h.setVisibility(0);
        ((b2) bVar.getValue()).f12725k.setVisibility(0);
        ((b2) bVar.getValue()).f12721g.setVisibility(4);
        ((b2) bVar.getValue()).f12720f.setAlpha(0.5f);
        ((b2) bVar.getValue()).f12731q.setAlpha(0.5f);
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        com.google.android.gms.internal.mlkit_vision_barcode.b2.b(this);
        Object obj = r0.M;
        r0 a3 = n1.a();
        if (kotlin.collections.h.m(a3.g(), this)) {
            LinkedList g10 = a3.g();
            kotlin.jvm.internal.i.a(g10);
            g10.remove(this);
        }
        n1.a().l();
        y.u().F();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        y.u().G();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        y.u().A();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSportFinish(EventBusBeans.SportFinish sportFinish) {
        kotlin.jvm.internal.e.f(sportFinish, "sportFinish");
        ((com.example.baselibrary.utils.e) this.J.getValue()).postDelayed(new androidx.activity.b(this, 19), 500L);
    }

    @Override // e6.b
    public final void q0(h6.b bVar) {
        com.example.test.presenter.sport.c cVar = (com.example.test.presenter.sport.c) I0();
        int R0 = R0();
        cVar.getClass();
        com.example.test.presenter.sport.c.k((byte) 4, R0);
        if (bVar.f14268c > this.E) {
            bVar.f14267b = R0();
            ArrayList arrayList = new ArrayList();
            bVar.f14275k = arrayList;
            Object obj = r0.M;
            arrayList.addAll(n1.a().h());
            ((com.example.test.presenter.sport.c) I0()).l(bVar);
        } else {
            finish();
        }
        Object obj2 = r0.M;
        n1.a().l();
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1 && !this.G) {
                double d5 = this.F;
                double d8 = this.E;
                eh.b bVar = this.I;
                if (d5 < d8) {
                    ((com.example.test.ui.dialog.r) bVar.getValue()).b(R$string.str_finish_sport_no_legel);
                } else {
                    ((com.example.test.ui.dialog.r) bVar.getValue()).b(R$string.str_finish_sport_legel);
                }
                ((com.example.test.ui.dialog.r) bVar.getValue()).show();
                return;
            }
            return;
        }
        if (this.G) {
            this.G = false;
            eh.b bVar2 = this.f7247z;
            ((b2) bVar2.getValue()).f12723i.setImageResource(R$mipmap.ic_sport_pause);
            Object obj = r0.M;
            if (n1.a().f7774v || this.L) {
                ((b2) bVar2.getValue()).f12723i.setVisibility(8);
                ((b2) bVar2.getValue()).f12727m.setVisibility(0);
                ((b2) bVar2.getValue()).f12721g.setVisibility(0);
            } else {
                ((b2) bVar2.getValue()).f12723i.setVisibility(0);
                ((b2) bVar2.getValue()).f12727m.setVisibility(8);
            }
            ((b2) bVar2.getValue()).f12725k.setVisibility(8);
            ((b2) bVar2.getValue()).f12722h.setVisibility(4);
            ((b2) bVar2.getValue()).f12720f.setAlpha(1.0f);
            ((b2) bVar2.getValue()).f12731q.setAlpha(1.0f);
        }
    }

    @Override // e6.b
    public final void u(int i3) {
    }

    @Override // e6.b
    public final void y(List list) {
    }
}
