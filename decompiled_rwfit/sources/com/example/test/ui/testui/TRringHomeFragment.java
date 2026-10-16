package com.example.test.ui.testui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f1;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.presenter.main.t1;
import com.example.test.service.TimeChangedReceiver;
import com.example.test.service.u1;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.main.model.BaseDataModel;
import com.example.test.ui.main.model.HomeBSModel;
import com.example.test.ui.main.model.HomeBoModel;
import com.example.test.ui.main.model.HomeBpModel;
import com.example.test.ui.main.model.HomeBreatheModel;
import com.example.test.ui.main.model.HomeBtModel;
import com.example.test.ui.main.model.HomeEditCardModel;
import com.example.test.ui.main.model.HomeFamilyModel;
import com.example.test.ui.main.model.HomeHrModel;
import com.example.test.ui.main.model.HomeHrvModel;
import com.example.test.ui.main.model.HomeMuslinModel;
import com.example.test.ui.main.model.HomeSleepModel;
import com.example.test.ui.main.model.HomeSportModel;
import com.example.test.ui.main.model.HomeStepModel;
import com.example.test.ui.main.model.HomeSugarModel;
import com.example.test.ui.main.model.HomeVaperBatteryModel;
import com.example.test.ui.main.model.HomeViperPowerModel;
import com.example.test.ui.main.model.PageViewModel;
import com.example.test.ui.main.model.PhysiologicalCycleModel;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.f2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.q1;
import f6.v3;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRringHomeFragment extends XXBaseFragment<t1, v3> implements g7.p, androidx.swiperefreshlayout.widget.j {

    /* renamed from: d, reason: collision with root package name */
    public HomeStepModel f8242d = new HomeStepModel();
    public HomeSleepModel e = new HomeSleepModel();

    /* renamed from: f, reason: collision with root package name */
    public HomeHrModel f8243f = new HomeHrModel();

    /* renamed from: g, reason: collision with root package name */
    public HomeBoModel f8244g = new HomeBoModel();

    /* renamed from: h, reason: collision with root package name */
    public HomeHrvModel f8245h = new HomeHrvModel();

    /* renamed from: i, reason: collision with root package name */
    public HomeSportModel f8246i = new HomeSportModel();

    /* renamed from: j, reason: collision with root package name */
    public HomeSugarModel f8247j = new HomeSugarModel();

    /* renamed from: k, reason: collision with root package name */
    public final PhysiologicalCycleModel f8248k = new PhysiologicalCycleModel();

    /* renamed from: l, reason: collision with root package name */
    public HomeBSModel f8249l = new HomeBSModel();

    /* renamed from: m, reason: collision with root package name */
    public HomeMuslinModel f8250m = new HomeMuslinModel();

    /* renamed from: n, reason: collision with root package name */
    public HomeBpModel f8251n = new HomeBpModel();

    /* renamed from: o, reason: collision with root package name */
    public final HomeFamilyModel f8252o = new HomeFamilyModel();

    /* renamed from: p, reason: collision with root package name */
    public final HomeEditCardModel f8253p = new HomeEditCardModel();

    /* renamed from: q, reason: collision with root package name */
    public final eh.b f8254q = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRringHomeFragment$datas$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<BaseDataModel> invoke() {
            TRringHomeFragment tRringHomeFragment = TRringHomeFragment.this;
            return kotlin.collections.i.e(tRringHomeFragment.f8242d, tRringHomeFragment.f8243f, tRringHomeFragment.e, new BaseDataModel(10087));
        }
    });
    public final eh.b r = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRringHomeFragment$homeAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final TRingHomeDataAdapter invoke() {
            TRingHomeDataAdapter tRingHomeDataAdapter = new TRingHomeDataAdapter(TRringHomeFragment.this.q0());
            tRingHomeDataAdapter.addItemProvider(new b0(7));
            tRingHomeDataAdapter.addItemProvider(new b0(4));
            tRingHomeDataAdapter.addItemProvider(new b0(6));
            tRingHomeDataAdapter.addItemProvider(new e0(1));
            tRingHomeDataAdapter.addItemProvider(new b0(5));
            tRingHomeDataAdapter.addItemProvider(new b0(0));
            tRingHomeDataAdapter.addItemProvider(new b0(8));
            tRingHomeDataAdapter.addItemProvider(new b0(9));
            tRingHomeDataAdapter.addItemProvider(new b0(1));
            tRingHomeDataAdapter.addItemProvider(new d0(1));
            tRingHomeDataAdapter.addItemProvider(new c0(1));
            tRingHomeDataAdapter.addItemProvider(new b0(2));
            tRingHomeDataAdapter.addItemProvider(new b0(3));
            tRingHomeDataAdapter.addItemProvider(new r6.a(4));
            return tRingHomeDataAdapter;
        }
    });

    public TRringHomeFragment() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRringHomeFragment$syncDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.h invoke() {
                return new com.example.test.ui.dialog.h(TRringHomeFragment.this.f0());
            }
        });
    }

    @Override // g7.p
    public final void G(HomeBoModel homeBoModel) {
        int a3 = u0().a(3);
        this.f8244g = homeBoModel;
        if (a3 > -1) {
            q0().set(a3, homeBoModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // g7.p
    public final void H(HomeHrModel homeHrModel) {
        int a3 = u0().a(1);
        this.f8243f = homeHrModel;
        if (a3 > -1) {
            q0().set(a3, homeHrModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new t1(this);
    }

    @Override // g7.p
    public final void O(HomeBreatheModel homeBreatheModel) {
    }

    @Override // g7.p
    public final void P(HomeSportModel homeSportModel) {
        int a3 = u0().a(8);
        this.f8246i = homeSportModel;
        if (a3 > -1) {
            q0().set(a3, homeSportModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // g7.p
    public final void U(HomeViperPowerModel homeViperPowerModel) {
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        v3 v3Var = (v3) this.f7251b;
        if (v3Var != null) {
            return v3Var.f13408a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_tring_main, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        int i3 = R$id.homeDataList;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.homeDataSwipe;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) he.a(i3, inflate);
            if (swipeRefreshLayout != null) {
                i3 = R$id.img;
                if (((ImageView) he.a(i3, inflate)) != null) {
                    i3 = R$id.toolbar;
                    TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                    if (tRingToolBarView != null) {
                        return new v3(linearLayout, linearLayout, recyclerView, swipeRefreshLayout, tRingToolBarView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
        PageViewModel pageViewModel = (PageViewModel) new de.o(this).q(PageViewModel.class);
        Bundle arguments = getArguments();
        pageViewModel.setIndex(arguments != null ? arguments.getInt("section_number") : 1);
    }

    @Override // p5.a
    public final Context f0() {
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.e.d(activity, "null cannot be cast to non-null type android.content.Context");
        return activity;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        String str;
        User d5;
        Object obj = u1.f7811u;
        u1 a3 = q1.a();
        a3.getClass();
        r5.b.k().q(a3);
        t1 t1Var = (t1) X();
        t1Var.getClass();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String str2 = null;
        try {
            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
            str = null;
        }
        if (str != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null && (d5 = kVar.d()) != null) {
                str2 = d5.getUserId();
            }
            if (str2 != null) {
                if (y5.d.f20005b) {
                    Object obj2 = com.example.test.utils.m.f8734b;
                    if (!d2.a().a()) {
                        t1Var.u(str, str2);
                        t1Var.s(str, str2);
                        t1Var.o(str, str2);
                        t1Var.l(str, str2);
                        t1Var.p(str, str2);
                        t1Var.r(str, str2);
                        t1Var.x(str, str2);
                        t1Var.v(str, str2);
                        t1Var.q(str, str2);
                    }
                }
                t1Var.t(str, str2);
                t1Var.s(str, str2);
                t1Var.o(str, str2);
                t1Var.l(str, str2);
                t1Var.p(str, str2);
                t1Var.r(str, str2);
                t1Var.x(str, str2);
                t1Var.v(str, str2);
                t1Var.q(str, str2);
            }
        }
        ((t1) X()).w();
    }

    @Override // g7.p
    public final void i0(HomeBtModel homeBtModel) {
    }

    @Override // androidx.swiperefreshlayout.widget.j
    public final void j() {
        SwipeRefreshLayout swipeRefreshLayout;
        if (!com.example.test.service.e.h().i()) {
            com.example.baselibrary.utils.d.a(R$string.str_device_disconnected);
            v3 v3Var = (v3) this.f7251b;
            swipeRefreshLayout = v3Var != null ? v3Var.f13411d : null;
            if (swipeRefreshLayout == null) {
                return;
            }
            swipeRefreshLayout.setRefreshing(false);
            return;
        }
        Object obj = u1.f7811u;
        if (q1.a().f7826p) {
            v3 v3Var2 = (v3) this.f7251b;
            swipeRefreshLayout = v3Var2 != null ? v3Var2.f13411d : null;
            if (swipeRefreshLayout == null) {
                return;
            }
            swipeRefreshLayout.setRefreshing(false);
            return;
        }
        q1.a().g();
        v3 v3Var3 = (v3) this.f7251b;
        swipeRefreshLayout = v3Var3 != null ? v3Var3.f13411d : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override // g7.p
    public final void l0(HomeStepModel homeStepModel) {
        int a3 = u0().a(0);
        this.f8242d = homeStepModel;
        if (a3 > -1) {
            q0().set(a3, homeStepModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // g7.p
    public final void m(HomeSleepModel homeSleepModel) {
        int a3 = u0().a(4);
        this.e = homeSleepModel;
        if (a3 > -1) {
            q0().set(a3, homeSleepModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        b2.a(this);
        v3 v3Var = (v3) this.f7251b;
        if (v3Var != null) {
            RecyclerView recyclerView = v3Var.f13410c;
            recyclerView.setItemViewCacheSize(q0().size());
            f0();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(2);
            gridLayoutManager.K = new androidx.recyclerview.widget.a0(1);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(u0());
            recyclerView.g(new y6.c(com.example.baselibrary.utils.b.f(f0(), 10.0f), 0));
            f1 itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator != null) {
                itemAnimator.f2565f = 0L;
            }
        }
        v3 v3Var2 = (v3) this.f7251b;
        if (v3Var2 != null) {
            v3Var2.e.setOnViewChildListener(new a1(this, 0));
        }
        com.example.test.service.e.h().getClass();
        f2.a();
        v3 v3Var3 = (v3) this.f7251b;
        if (v3Var3 != null) {
            v3Var3.f13411d.setOnRefreshListener(this);
        }
    }

    @Override // g7.p
    public final void o0(HomeBSModel homeBSModel) {
        int a3 = u0().a(6);
        this.f8249l = homeBSModel;
        if (a3 > -1) {
            q0().set(a3, homeBSModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        deviceStatusEvent.getStatus();
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            if (((v3) this.f7251b) != null) {
                TimeChangedReceiver.a((FragmentActivity) f0());
            }
        } else if (status == 2) {
        } else if (status != 3) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x032b  */
    @yh.k(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDeviceSupportEvent(com.example.test.ui.model.EventBusBeans.DeviceSupportEvent r34) {
        /*
            Method dump skipped, instructions count: 876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.testui.TRringHomeFragment.onDeviceSupportEvent(com.example.test.ui.model.EventBusBeans$DeviceSupportEvent):void");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        SwipeRefreshLayout swipeRefreshLayout;
        super.onResume();
        XXApplication xXApplication = XXApplication.f7400h;
        Log.e("qob", "onResume backToFrontFlag " + j1.a().e);
        if (j1.a().e) {
            j1.a().e = false;
            if (!com.example.test.service.e.h().i()) {
                v3 v3Var = (v3) this.f7251b;
                swipeRefreshLayout = v3Var != null ? v3Var.f13411d : null;
                if (swipeRefreshLayout == null) {
                    return;
                }
                swipeRefreshLayout.setRefreshing(false);
                return;
            }
            Object obj = u1.f7811u;
            if (!q1.a().f7826p) {
                u0().notifyDataSetChanged();
                return;
            }
            v3 v3Var2 = (v3) this.f7251b;
            swipeRefreshLayout = v3Var2 != null ? v3Var2.f13411d : null;
            if (swipeRefreshLayout == null) {
                return;
            }
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(EventBusBeans.SyncEvent syncEvent) {
        String str;
        User d5;
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String str2 = null;
        try {
            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
            str = null;
        }
        if (str != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null && (d5 = kVar.d()) != null) {
                str2 = d5.getUserId();
            }
            if (str2 != null) {
                switch (syncEvent.getSyncType()) {
                    case 0:
                        if (y5.d.f20005b) {
                            Object obj = com.example.test.utils.m.f8734b;
                            if (!d2.a().a()) {
                                ((t1) X()).u(str, str2);
                                return;
                            }
                        }
                        ((t1) X()).t(str, str2);
                        return;
                    case 1:
                        ((t1) X()).o(str, str2);
                        return;
                    case 2:
                        ((t1) X()).m(str, str2);
                        return;
                    case 3:
                        ((t1) X()).l(str, str2);
                        return;
                    case 4:
                        ((t1) X()).s(str, str2);
                        return;
                    case 5:
                    case 11:
                    case 12:
                    default:
                        return;
                    case 6:
                        ((t1) X()).x(str, str2);
                        return;
                    case 7:
                        ((t1) X()).n(str, str2);
                        return;
                    case 8:
                        ((t1) X()).r(str, str2);
                        return;
                    case 9:
                        ((t1) X()).v(str, str2);
                        return;
                    case 10:
                        ((t1) X()).q(str, str2);
                        return;
                    case 13:
                        ((t1) X()).p(str, str2);
                        return;
                }
            }
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onUnitEvent(EventBusBeans.UnitEvent unitEvent) {
        String str;
        User d5;
        kotlin.jvm.internal.e.f(unitEvent, "unitEvent");
        if (unitEvent.getUnitType() == 99) {
            ((t1) X()).w();
            return;
        }
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String str2 = null;
        try {
            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
            str = null;
        }
        if (str != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null && (d5 = kVar.d()) != null) {
                str2 = d5.getUserId();
            }
            if (str2 != null) {
                if (unitEvent.getUnitType() == 0) {
                    if (y5.d.f20005b) {
                        Object obj = com.example.test.utils.m.f8734b;
                        if (!d2.a().a()) {
                            ((t1) X()).u(str, str2);
                        }
                    }
                    ((t1) X()).t(str, str2);
                }
                ((t1) X()).r(str, str2);
            }
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onWomenHealthEventSetting(EventBusBeans.WomenHealthRemindSettingEvent womenHealthRemindSettingEvent) {
        kotlin.jvm.internal.e.f(womenHealthRemindSettingEvent, "womenHealthRemindSettingEvent");
        Log.e("qob", "onWomenHealthEventSetting");
        int a3 = u0().a(15);
        if (a3 > -1) {
            q0().set(a3, this.f8248k);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // g7.p
    public final void q(HomeSugarModel homeSugarModel) {
        int a3 = u0().a(9);
        this.f8247j = homeSugarModel;
        if (a3 > -1) {
            q0().set(a3, homeSugarModel);
            u0().notifyItemChanged(a3);
        }
    }

    public final List q0() {
        return (List) this.f8254q.getValue();
    }

    @Override // g7.p
    public final void r(HomeMuslinModel homeMuslinModel) {
        int a3 = u0().a(10);
        this.f8250m = homeMuslinModel;
        if (a3 > -1) {
            q0().set(a3, homeMuslinModel);
            u0().notifyItemChanged(a3);
        }
    }

    public final TRingHomeDataAdapter u0() {
        return (TRingHomeDataAdapter) this.r.getValue();
    }

    @Override // g7.p
    public final void v0(HomeHrvModel homeHrvModel) {
        int a3 = u0().a(13);
        this.f8245h = homeHrvModel;
        if (a3 > -1) {
            q0().set(a3, homeHrvModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // g7.p
    public final void w(HomeBpModel homeBpModel) {
        int a3 = u0().a(2);
        this.f8251n = homeBpModel;
        if (a3 > -1) {
            q0().set(a3, homeBpModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // g7.p
    public final void x0(HomeVaperBatteryModel homeVaperBatteryModel) {
    }
}
