package com.example.test.ui.main.fragment;

import android.content.Context;
import android.content.Intent;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.MainActivity;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.presenter.main.d1;
import com.example.test.presenter.main.g1;
import com.example.test.presenter.main.h1;
import com.example.test.presenter.main.p0;
import com.example.test.presenter.main.t;
import com.example.test.presenter.main.x0;
import com.example.test.service.u1;
import com.example.test.ui.sport.activity.SportNewRecordActivity;
import com.example.test.ui.sport.activity.SportRecordActivity;
import com.example.test.ui.sport.activity.SportSettingActivity;
import com.example.test.ui.testui.TRingDeviceScanActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.q1;
import f6.m3;

/* loaded from: classes.dex */
public final class n implements a7.f, a7.b, t6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8115a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseFragment f8116b;

    public /* synthetic */ n(BaseFragment baseFragment, int i3) {
        this.f8115a = i3;
        this.f8116b = baseFragment;
    }

    @Override // a7.b
    public void a(String year) {
        switch (this.f8115a) {
            case 1:
                kotlin.jvm.internal.e.f(year, "year");
                ((com.example.test.presenter.main.b) ((BOStatisticsFragment) this.f8116b).X()).n(year);
                break;
            case 2:
                kotlin.jvm.internal.e.f(year, "year");
                ((com.example.test.presenter.main.c) ((BPStatisticsFragment) this.f8116b).X()).n(year);
                break;
            case 3:
                kotlin.jvm.internal.e.f(year, "year");
                ((com.example.test.presenter.main.g) ((BSStatisticsFragment) this.f8116b).X()).o(year);
                break;
            case 4:
                kotlin.jvm.internal.e.f(year, "year");
                ((com.example.test.presenter.main.h) ((BTStatisticsFragment) this.f8116b).X()).n(year);
                break;
            case 5:
                kotlin.jvm.internal.e.f(year, "year");
                ((t) ((BreatheStatisticsFragment) this.f8116b).X()).m(year);
                break;
            case 6:
                kotlin.jvm.internal.e.f(year, "year");
                ((x0) ((HRStatisticsFragment) this.f8116b).X()).n(year);
                break;
            case 7:
            case 9:
            default:
                kotlin.jvm.internal.e.f(year, "year");
                ((h1) ((SugarStatisticsFragment) this.f8116b).X()).n(year);
                break;
            case 8:
                kotlin.jvm.internal.e.f(year, "year");
                ((d1) ((SleepStatisticsFragment) this.f8116b).X()).n(year);
                break;
            case 10:
                kotlin.jvm.internal.e.f(year, "year");
                ((g1) ((StepStatisticsFragment) this.f8116b).X()).n(year);
                break;
        }
    }

    @Override // a7.b
    public void b(String date) {
        switch (this.f8115a) {
            case 1:
                kotlin.jvm.internal.e.f(date, "date");
                ((com.example.test.presenter.main.b) ((BOStatisticsFragment) this.f8116b).X()).k(date);
                break;
            case 2:
                kotlin.jvm.internal.e.f(date, "date");
                ((com.example.test.presenter.main.c) ((BPStatisticsFragment) this.f8116b).X()).k(date);
                break;
            case 3:
                kotlin.jvm.internal.e.f(date, "date");
                ((com.example.test.presenter.main.g) ((BSStatisticsFragment) this.f8116b).X()).l(date);
                break;
            case 4:
                kotlin.jvm.internal.e.f(date, "date");
                ((com.example.test.presenter.main.h) ((BTStatisticsFragment) this.f8116b).X()).k(date);
                break;
            case 5:
                kotlin.jvm.internal.e.f(date, "date");
                break;
            case 6:
                kotlin.jvm.internal.e.f(date, "date");
                ((x0) ((HRStatisticsFragment) this.f8116b).X()).k(date);
                break;
            case 7:
            case 9:
            default:
                kotlin.jvm.internal.e.f(date, "date");
                ((h1) ((SugarStatisticsFragment) this.f8116b).X()).k(date);
                break;
            case 8:
                kotlin.jvm.internal.e.f(date, "date");
                ((d1) ((SleepStatisticsFragment) this.f8116b).X()).k(date);
                break;
            case 10:
                kotlin.jvm.internal.e.f(date, "date");
                ((g1) ((StepStatisticsFragment) this.f8116b).X()).k(date);
                break;
        }
    }

    @Override // a7.b
    public void c(String month) {
        switch (this.f8115a) {
            case 1:
                kotlin.jvm.internal.e.f(month, "month");
                ((com.example.test.presenter.main.b) ((BOStatisticsFragment) this.f8116b).X()).l(month);
                break;
            case 2:
                kotlin.jvm.internal.e.f(month, "month");
                ((com.example.test.presenter.main.c) ((BPStatisticsFragment) this.f8116b).X()).l(month);
                break;
            case 3:
                kotlin.jvm.internal.e.f(month, "month");
                ((com.example.test.presenter.main.g) ((BSStatisticsFragment) this.f8116b).X()).m(month);
                break;
            case 4:
                kotlin.jvm.internal.e.f(month, "month");
                ((com.example.test.presenter.main.h) ((BTStatisticsFragment) this.f8116b).X()).l(month);
                break;
            case 5:
                kotlin.jvm.internal.e.f(month, "month");
                ((t) ((BreatheStatisticsFragment) this.f8116b).X()).k(month);
                break;
            case 6:
                kotlin.jvm.internal.e.f(month, "month");
                ((x0) ((HRStatisticsFragment) this.f8116b).X()).l(month);
                break;
            case 7:
            case 9:
            default:
                kotlin.jvm.internal.e.f(month, "month");
                ((h1) ((SugarStatisticsFragment) this.f8116b).X()).l(month);
                break;
            case 8:
                kotlin.jvm.internal.e.f(month, "month");
                ((d1) ((SleepStatisticsFragment) this.f8116b).X()).l(month);
                break;
            case 10:
                kotlin.jvm.internal.e.f(month, "month");
                ((g1) ((StepStatisticsFragment) this.f8116b).X()).m(month);
                break;
        }
    }

    @Override // a7.b
    public void d(String str, String str2) {
        switch (this.f8115a) {
            case 1:
                ((com.example.test.presenter.main.b) ((BOStatisticsFragment) this.f8116b).X()).m(str, str2);
                break;
            case 2:
                ((com.example.test.presenter.main.c) ((BPStatisticsFragment) this.f8116b).X()).m(str, str2);
                break;
            case 3:
                ((com.example.test.presenter.main.g) ((BSStatisticsFragment) this.f8116b).X()).n(str, str2);
                break;
            case 4:
                ((com.example.test.presenter.main.h) ((BTStatisticsFragment) this.f8116b).X()).m(str, str2);
                break;
            case 5:
                ((t) ((BreatheStatisticsFragment) this.f8116b).X()).l(str, str2);
                break;
            case 6:
                ((x0) ((HRStatisticsFragment) this.f8116b).X()).m(str, str2);
                break;
            case 7:
            case 9:
            default:
                ((h1) ((SugarStatisticsFragment) this.f8116b).X()).m(str, str2);
                break;
            case 8:
                ((d1) ((SleepStatisticsFragment) this.f8116b).X()).m(str, str2);
                break;
            case 10:
                ((g1) ((StepStatisticsFragment) this.f8116b).X()).l(str, str2);
                break;
        }
    }

    @Override // a7.f
    public void j(int i3) {
        BaseFragment baseFragment = this.f8116b;
        switch (this.f8115a) {
            case 0:
                final HomeFragment homeFragment = (HomeFragment) baseFragment;
                if (i3 != R$id.option1) {
                    if (i3 == R$id.option2) {
                        homeFragment.V();
                        m3 m3Var = (m3) homeFragment.f7251b;
                        if (m3Var != null) {
                            com.example.baselibrary.utils.b.x(m3Var.f13126b, new oh.l() { // from class: com.example.test.ui.main.fragment.HomeFragment$initView$2$onAction$1$1
                                {
                                    super(1);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:38:0x0149  */
                                /* JADX WARN: Removed duplicated region for block: B:41:0x016f A[RETURN] */
                                @Override // oh.l
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct add '--show-bad-code' argument
                                */
                                public final java.lang.String invoke(androidx.recyclerview.widget.RecyclerView r18) {
                                    /*
                                        Method dump skipped, instructions count: 368
                                        To view this dump add '--comments-level debug' option
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.main.fragment.HomeFragment$initView$2$onAction$1$1.invoke(androidx.recyclerview.widget.RecyclerView):java.lang.String");
                                }
                            }, new oh.l() { // from class: com.example.test.ui.main.fragment.HomeFragment$initView$2$onAction$1$2
                                {
                                    super(1);
                                }

                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((String) obj);
                                    return eh.g.f12633a;
                                }

                                public final void invoke(String str) {
                                    HomeFragment.this.b0();
                                    if (str != null) {
                                        aa.a(HomeFragment.this.f0(), str);
                                    }
                                }
                            });
                            break;
                        }
                    }
                } else if (!com.example.test.service.e.h().i()) {
                    int i10 = R$string.str_device_disconnected;
                    homeFragment.getClass();
                    com.example.baselibrary.utils.d.a(i10);
                    break;
                } else {
                    XXApplication xXApplication = XXApplication.f7400h;
                    j1.a().e = false;
                    Object obj = u1.f7811u;
                    q1.a().g();
                    break;
                }
                break;
            default:
                if (i3 != R$id.option1) {
                    o oVar = (o) baseFragment;
                    if (i3 != R$id.option2) {
                        if (i3 == R$id.barStatusIv) {
                            Object obj2 = com.example.test.utils.m.f8734b;
                            SupportMenuBean supportMenuBean = d2.a().f8735a;
                            if (!(supportMenuBean != null ? supportMenuBean.isNewSport() : false)) {
                                Context context = oVar.getContext();
                                if (context != null) {
                                    context.startActivity(new Intent(oVar.getContext(), (Class<?>) SportRecordActivity.class));
                                    break;
                                }
                            } else {
                                Context context2 = oVar.getContext();
                                if (context2 != null) {
                                    context2.startActivity(new Intent(oVar.getContext(), (Class<?>) SportNewRecordActivity.class));
                                    break;
                                }
                            }
                        }
                    } else {
                        Context context3 = oVar.getContext();
                        if (context3 != null) {
                            context3.startActivity(new Intent(oVar.getContext(), (Class<?>) SportSettingActivity.class));
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        com.example.test.service.e.h().getClass();
        com.example.test.service.e.h().f7682a = true;
        k6.b bVar = ((HeadsetFragment) this.f8116b).f8070c;
        if (bVar != null) {
            bVar.P();
        }
        p0 p0Var = (p0) ((HeadsetFragment) this.f8116b).X();
        ((HeadsetFragment) ((e7.a) p0Var.f7255a)).b0();
        XXApplication xXApplication = XXApplication.f7400h;
        j1.a().e = false;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.f0();
        }
        HeadsetFragment headsetFragment = (HeadsetFragment) ((e7.a) p0Var.f7255a);
        headsetFragment.b0();
        MainActivity mainActivity = (MainActivity) headsetFragment.f0();
        mainActivity.R0().h();
        mainActivity.finish();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        if (kVar2 != null) {
            kVar2.b0();
        }
        headsetFragment.f0().startActivity(new Intent(headsetFragment.f0(), (Class<?>) TRingDeviceScanActivity.class));
        com.example.test.service.e.h().q();
    }
}
