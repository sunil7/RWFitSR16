package com.example.test.ui.sport.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.blesdk.bean.sync.SportDataPushBean;
import com.example.database.table.User;
import com.example.test.R$array;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.presenter.main.z0;
import com.example.test.service.s0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.LongClickView;
import com.example.test.ui.view.ToolBarView;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ba;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.k1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.o1;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import f6.d2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class SportNewDetailJLActivity extends XXBaseActivity<com.example.test.presenter.sport.l, d2> implements i7.d, View.OnClickListener, e6.b, o5.a {
    public static int Q;
    public boolean G;
    public boolean H;
    public long O;
    public final int E = 200;
    public double F = Double.NaN;
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewDetailJLActivity$sportTargetBean$2
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
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewDetailJLActivity$finishSportDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(SportNewDetailJLActivity.this);
            rVar.b(R$string.str_finish_sport_legel);
            rVar.setOnDialogListener(new h(SportNewDetailJLActivity.this, 0));
            return rVar;
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewDetailJLActivity$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(SportNewDetailJLActivity.this);
        }
    });
    public final eh.b L = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewDetailJLActivity$sportType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = SportNewDetailJLActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("sport_type", 5) : 5);
        }
    });
    public final eh.b M = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewDetailJLActivity$sportStatus$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = SportNewDetailJLActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("sport_status", 1) : 1);
        }
    });
    public final i N = new i(this);
    public final SportDataPushBean P = new SportDataPushBean();

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.sport.l(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((d2) this.f7247z.getValue()).f12788a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_sport_new_detail, (ViewGroup) null, false);
        int i3 = R$id.caloriesTv;
        TextView textView = (TextView) he.a(i3, inflate);
        if (textView != null) {
            i3 = R$id.cancelTips;
            if (((TextView) he.a(i3, inflate)) != null) {
                i3 = R$id.continueTips;
                if (((TextView) he.a(i3, inflate)) != null) {
                    i3 = R$id.currentPaceTv;
                    TextView textView2 = (TextView) he.a(i3, inflate);
                    if (textView2 != null) {
                        i3 = R$id.data;
                        if (((ConstraintLayout) he.a(i3, inflate)) != null) {
                            i3 = R$id.distanceTv;
                            TextView textView3 = (TextView) he.a(i3, inflate);
                            if (textView3 != null) {
                                i3 = R$id.distanceUnitTv;
                                TextView textView4 = (TextView) he.a(i3, inflate);
                                if (textView4 != null) {
                                    i3 = R$id.ivLock;
                                    ImageView imageView = (ImageView) he.a(i3, inflate);
                                    if (imageView != null) {
                                        i3 = R$id.ll_data;
                                        if (((LinearLayout) he.a(i3, inflate)) != null) {
                                            i3 = R$id.ll_kcal;
                                            if (((LinearLayout) he.a(i3, inflate)) != null) {
                                                i3 = R$id.ll_pics;
                                                if (((LinearLayout) he.a(i3, inflate)) != null) {
                                                    i3 = R$id.ll_time;
                                                    if (((LinearLayout) he.a(i3, inflate)) != null) {
                                                        i3 = R$id.llTips;
                                                        LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                                                        if (linearLayout != null) {
                                                            i3 = R$id.longTips;
                                                            TextView textView5 = (TextView) he.a(i3, inflate);
                                                            if (textView5 != null) {
                                                                i3 = R$id.pauseBtn;
                                                                ImageView imageView2 = (ImageView) he.a(i3, inflate);
                                                                if (imageView2 != null) {
                                                                    i3 = R$id.playBtn;
                                                                    ImageView imageView3 = (ImageView) he.a(i3, inflate);
                                                                    if (imageView3 != null) {
                                                                        i3 = R$id.progressView;
                                                                        LongClickView longClickView = (LongClickView) he.a(i3, inflate);
                                                                        if (longClickView != null) {
                                                                            i3 = R$id.progressViewCancel;
                                                                            LongClickView longClickView2 = (LongClickView) he.a(i3, inflate);
                                                                            if (longClickView2 != null) {
                                                                                i3 = R$id.sportPauseLl;
                                                                                LinearLayout linearLayout2 = (LinearLayout) he.a(i3, inflate);
                                                                                if (linearLayout2 != null) {
                                                                                    i3 = R$id.stopBtn;
                                                                                    ImageView imageView4 = (ImageView) he.a(i3, inflate);
                                                                                    if (imageView4 != null) {
                                                                                        i3 = R$id.toolbar;
                                                                                        ToolBarView toolBarView = (ToolBarView) he.a(i3, inflate);
                                                                                        if (toolBarView != null) {
                                                                                            i3 = R$id.totalTimeTv;
                                                                                            TextView textView6 = (TextView) he.a(i3, inflate);
                                                                                            if (textView6 != null) {
                                                                                                i3 = R$id.tvMap;
                                                                                                ImageView imageView5 = (ImageView) he.a(i3, inflate);
                                                                                                if (imageView5 != null) {
                                                                                                    return new d2((ConstraintLayout) inflate, textView, textView2, textView3, textView4, imageView, linearLayout, textView5, imageView2, imageView3, longClickView, longClickView2, linearLayout2, imageView4, toolBarView, textView6, imageView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    @Override // com.example.baselibrary.base.activity.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K0() {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.sport.activity.SportNewDetailJLActivity.K0():void");
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        SportTargetBean sportTargetBean;
        b2.a(this);
        com.example.test.presenter.sport.l lVar = (com.example.test.presenter.sport.l) I0();
        boolean z5 = true;
        if (((Number) this.M.getValue()).intValue() == 3) {
            lVar.f7613f = true;
        }
        com.google.android.gms.internal.mlkit_vision_common.p.U((com.example.test.presenter.sport.i) lVar.f7616i.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.U((com.example.test.presenter.sport.k) lVar.f7617j.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.U((com.example.test.presenter.sport.j) lVar.f7618k.getValue());
        if (lVar.e == null) {
            lVar.e = new Timer();
        }
        Timer timer = lVar.e;
        if (timer != null) {
            timer.scheduleAtFixedRate(new com.example.test.presenter.sport.g(lVar), 1000L, 1000L);
        }
        y u10 = y.u();
        eh.b bVar = this.I;
        if (((SportTargetBean) bVar.getValue()) != null && ((sportTargetBean = (SportTargetBean) bVar.getValue()) == null || sportTargetBean.isScreenLight() != 1)) {
            z5 = false;
        }
        u10.y(z5);
        eh.b bVar2 = this.f7247z;
        ((d2) bVar2.getValue()).f12795i.setOnClickListener(this);
        ((d2) bVar2.getValue()).f12800n.setOnClickListener(this);
        ((d2) bVar2.getValue()).f12796j.setOnClickListener(this);
        ((d2) bVar2.getValue()).f12803q.setOnClickListener(this);
        ((d2) bVar2.getValue()).f12792f.setOnClickListener(this);
        ((d2) bVar2.getValue()).f12801o.setOnViewChildListener(new com.google.android.gms.internal.mlkit_common.o(6));
        if (!ba.a().contains(Integer.valueOf(S0()))) {
            ((d2) bVar2.getValue()).f12803q.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(50);
        arrayList.add(10);
        arrayList.add(89);
        arrayList.add(96);
        arrayList.add(97);
        arrayList.add(98);
        arrayList.add(63);
        arrayList.add(86);
        arrayList.add(100);
        arrayList.add(101);
        arrayList.add(12);
        arrayList.add(20);
        arrayList.add(17);
        arrayList.add(51);
        arrayList.add(53);
        arrayList.add(61);
        arrayList.add(102);
        arrayList.add(13);
        arrayList.add(19);
        if (!arrayList.contains(Integer.valueOf(S0()))) {
            ((d2) bVar2.getValue()).f12791d.setVisibility(8);
            ((d2) bVar2.getValue()).e.setVisibility(8);
        }
        String[] stringArray = getResources().getStringArray(R$array.jlrunning_string_array);
        kotlin.jvm.internal.e.e(stringArray, "getStringArray(...)");
        String j4 = l0.j(S0(), "jlrunning_");
        Resources resources = getResources();
        kotlin.jvm.internal.e.e(resources, "getResources(...)");
        int identifier = resources.getIdentifier(j4, "mipmap", getPackageName());
        ToolBarView toolBarView = ((d2) bVar2.getValue()).f12801o;
        String str = stringArray[S0()];
        kotlin.jvm.internal.e.e(str, "get(...)");
        toolBarView.setBarTitle(str);
        ((d2) bVar2.getValue()).f12801o.setBarStatusDrawable(identifier);
        ((d2) bVar2.getValue()).f12797k.setMyClickListener(new h(this, 1));
        ((d2) bVar2.getValue()).f12798l.setMyClickListener(new h(this, 2));
    }

    public final void R0() {
        if (!this.H) {
            com.example.baselibrary.utils.d.a(R$string.str_title_battery_nosupport_workout);
            Object obj = s0.N;
            o1.a().f();
            com.example.test.presenter.sport.l lVar = (com.example.test.presenter.sport.l) I0();
            int S0 = S0();
            lVar.f7613f = true;
            k1.a((byte) 4, S0);
            if (this.O >= 120) {
                ((com.example.test.presenter.sport.l) I0()).l();
                Thread.sleep(Const.L_MAX_WAIT_WIFI);
            }
            finish();
        }
        yh.d.b().e(new EventBusBeans.SyncSportEvent(0L));
    }

    public final int S0() {
        return ((Number) this.L.getValue()).intValue();
    }

    public final void T0() {
        eh.b bVar = this.f7247z;
        ((d2) bVar.getValue()).f12799m.setVisibility(0);
        ((d2) bVar.getValue()).f12793g.setVisibility(0);
        ((d2) bVar.getValue()).f12795i.setVisibility(8);
        com.example.test.presenter.sport.l lVar = (com.example.test.presenter.sport.l) I0();
        int S0 = S0();
        lVar.f7613f = true;
        k1.a((byte) 3, S0);
    }

    @Override // e6.b
    public final void W() {
    }

    @Override // e6.b
    public final void X(long j4, double d5, double d8, long j10, long j11) {
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // e6.b
    public final void j(boolean z5) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3 = 0;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i10 = R$id.playBtn;
        eh.b bVar = this.f7247z;
        if (valueOf != null && valueOf.intValue() == i10) {
            if (this.G) {
                return;
            }
            ((d2) bVar.getValue()).f12799m.setVisibility(8);
            ((d2) bVar.getValue()).f12793g.setVisibility(4);
            ((d2) bVar.getValue()).f12795i.setVisibility(0);
            com.example.test.presenter.sport.l lVar = (com.example.test.presenter.sport.l) I0();
            int S0 = S0();
            lVar.f7613f = false;
            k1.a((byte) 2, S0);
            Object obj = s0.N;
            s0 a3 = o1.a();
            a3.f7801w = false;
            a3.K = 0;
            a3.M = false;
            return;
        }
        int i11 = R$id.stopBtn;
        if (valueOf != null && valueOf.intValue() == i11) {
            return;
        }
        int i12 = R$id.pauseBtn;
        if (valueOf != null && valueOf.intValue() == i12) {
            if (this.G) {
                return;
            }
            T0();
            Object obj2 = s0.N;
            o1.a().f7801w = true;
            return;
        }
        int i13 = R$id.tvMap;
        if (valueOf != null && valueOf.intValue() == i13) {
            if (this.G) {
                return;
            }
            startActivity(new Intent(this, (Class<?>) SportNewMapActivity.class));
            new Thread(new g(this, i3)).start();
            return;
        }
        int i14 = R$id.ivLock;
        if (valueOf == null || valueOf.intValue() != i14 || this.G) {
            return;
        }
        this.G = true;
        ((d2) bVar.getValue()).f12799m.setVisibility(8);
        ((d2) bVar.getValue()).f12795i.setVisibility(0);
        ((d2) bVar.getValue()).f12795i.setImageResource(R$mipmap.ic_unlock);
        ((d2) bVar.getValue()).f12794h.setVisibility(0);
        ((d2) bVar.getValue()).f12797k.setVisibility(0);
        ((d2) bVar.getValue()).f12793g.setVisibility(4);
        ((d2) bVar.getValue()).f12792f.setAlpha(0.5f);
        ((d2) bVar.getValue()).f12803q.setAlpha(0.5f);
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (!r5.b.k().f18054c) {
            z0.e = true;
        }
        z0.f7585d = false;
        b2.b(this);
        Object obj = s0.N;
        s0 a3 = o1.a();
        if (kotlin.collections.h.m(a3.g(), this)) {
            LinkedList g10 = a3.g();
            kotlin.jvm.internal.i.a(g10);
            g10.remove(this);
        }
        o1.a().j();
        y.u().F();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        Log.e("SportNewDetailJLActivity", "蓝牙断开链接onDeviceStatusEvent " + deviceStatusEvent.getStatus());
        if (deviceStatusEvent.getStatus() == 0) {
            finish();
        }
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
    public final void onSportDataPushEvent(EventBusBeans.SportDataPushEvent sportDataPushEvent) {
        kotlin.jvm.internal.e.f(sportDataPushEvent, "sportDataPushEvent");
        SportDataPushBean sportDataPushBean = sportDataPushEvent.getSportDataPushBean();
        SportDataPushBean sportDataPushBean2 = this.P;
        if (sportDataPushBean2 != null) {
            sportDataPushBean2.settActivityTime(sportDataPushBean.gettActivityTime());
        }
        SportDataPushBean sportDataPushBean3 = this.P;
        if (sportDataPushBean3 != null) {
            sportDataPushBean3.settActivityCalorie(sportDataPushBean.gettActivityCalorie());
        }
        SportDataPushBean sportDataPushBean4 = this.P;
        if (sportDataPushBean4 != null) {
            sportDataPushBean4.settActivityDistance(sportDataPushBean.gettActivityDistance());
        }
        SportDataPushBean sportDataPushBean5 = this.P;
        if (sportDataPushBean5 != null) {
            sportDataPushBean5.settActivityHr(sportDataPushBean.gettActivityHr());
        }
        SportDataPushBean sportDataPushBean6 = this.P;
        if (sportDataPushBean6 != null) {
            sportDataPushBean6.settActivitySteps(sportDataPushBean.gettActivitySteps());
        }
        this.F = sportDataPushBean.gettActivityDistance().intValue();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 != null) {
            if (d5.getMeterUnit() == 0) {
                android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (((float) (this.F / 1000)) * 100)) / 100.0f)}, 1, "%.2f", ((d2) this.f7247z.getValue()).f12791d);
                ((d2) this.f7247z.getValue()).e.setText(getString(R$string.str_km));
            } else {
                android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (v1.b((float) this.F) * 100)) / 100.0f)}, 1, "%.2f", ((d2) this.f7247z.getValue()).f12791d);
                ((d2) this.f7247z.getValue()).e.setText(getString(R$string.str_mile));
            }
            ((d2) this.f7247z.getValue()).f12790c.setText(String.valueOf(sportDataPushBean.gettActivityHr()));
        }
        ((d2) this.f7247z.getValue()).f12789b.setText(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((int) ((sportDataPushBean.gettActivityCalorie().intValue() / 10000.0f) * 10)) / 10.0f)}, 1)));
        this.O = sportDataPushBean.gettActivityTime().intValue();
        ((com.example.test.presenter.sport.l) I0()).f7614g = sportDataPushBean.gettActivityTime().intValue();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSportFinish(EventBusBeans.SportFinish sportFinish) {
        kotlin.jvm.internal.e.f(sportFinish, "sportFinish");
        ((com.example.baselibrary.utils.e) this.K.getValue()).postDelayed(new g(this, 1), 500L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        new Thread(new g(this, 2)).start();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        ((com.example.test.presenter.sport.l) I0()).k(0);
        super.onStop();
    }

    @Override // e6.b
    public final void q0(h6.b bVar) {
        if (bVar.f14268c > this.E) {
            bVar.f14267b = S0();
            ArrayList arrayList = new ArrayList();
            bVar.f14275k = arrayList;
            Object obj = s0.N;
            arrayList.addAll(o1.a().h());
        }
        Object obj2 = s0.N;
        o1.a().j();
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1 && !this.G) {
                long j4 = this.O;
                eh.b bVar = this.J;
                if (j4 < 120) {
                    ((com.example.test.ui.dialog.r) bVar.getValue()).b(R$string.str_sport_end_nodata_message_time);
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
            ((d2) bVar2.getValue()).f12795i.setImageResource(R$mipmap.ic_sport_pause);
            Object obj = s0.N;
            if (o1.a().f7801w) {
                ((d2) bVar2.getValue()).f12795i.setVisibility(8);
                ((d2) bVar2.getValue()).f12799m.setVisibility(0);
                ((d2) bVar2.getValue()).f12793g.setVisibility(0);
            } else {
                ((d2) bVar2.getValue()).f12795i.setVisibility(0);
                ((d2) bVar2.getValue()).f12799m.setVisibility(8);
            }
            ((d2) bVar2.getValue()).f12797k.setVisibility(8);
            ((d2) bVar2.getValue()).f12794h.setVisibility(4);
            ((d2) bVar2.getValue()).f12792f.setAlpha(1.0f);
            ((d2) bVar2.getValue()).f12803q.setAlpha(1.0f);
        }
    }

    @Override // e6.b
    public final void u(int i3) {
    }

    @Override // e6.b
    public final void y(List list) {
    }
}
