package com.example.test.ui.main.fragment;

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
import com.example.blesdk.bean.function.PowerBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.presenter.main.w0;
import com.example.test.service.TimeChangedReceiver;
import com.example.test.service.u1;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.main.adapter.HomeDataAdapter;
import com.example.test.ui.main.model.BaseDataModel;
import com.example.test.ui.main.model.HomeBSModel;
import com.example.test.ui.main.model.HomeBoModel;
import com.example.test.ui.main.model.HomeBpModel;
import com.example.test.ui.main.model.HomeBreatheModel;
import com.example.test.ui.main.model.HomeBtModel;
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
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.testui.b0;
import com.example.test.ui.view.ToolBarView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.f2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.q1;
import f6.m3;
import g7.p;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.NotImplementedError;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class HomeFragment extends XXBaseFragment<w0, m3> implements p, androidx.swiperefreshlayout.widget.j {

    /* renamed from: d, reason: collision with root package name */
    public HomeStepModel f8078d = new HomeStepModel();
    public HomeSleepModel e = new HomeSleepModel();

    /* renamed from: f, reason: collision with root package name */
    public HomeHrModel f8079f = new HomeHrModel();

    /* renamed from: g, reason: collision with root package name */
    public HomeBpModel f8080g = new HomeBpModel();

    /* renamed from: h, reason: collision with root package name */
    public HomeBoModel f8081h = new HomeBoModel();

    /* renamed from: i, reason: collision with root package name */
    public HomeBreatheModel f8082i = new HomeBreatheModel();

    /* renamed from: j, reason: collision with root package name */
    public HomeBtModel f8083j = new HomeBtModel();

    /* renamed from: k, reason: collision with root package name */
    public HomeBSModel f8084k = new HomeBSModel();

    /* renamed from: l, reason: collision with root package name */
    public HomeSugarModel f8085l = new HomeSugarModel();

    /* renamed from: m, reason: collision with root package name */
    public HomeViperPowerModel f8086m = new HomeViperPowerModel();

    /* renamed from: n, reason: collision with root package name */
    public HomeVaperBatteryModel f8087n = new HomeVaperBatteryModel();

    /* renamed from: o, reason: collision with root package name */
    public final eh.b f8088o = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.HomeFragment$datas$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<BaseDataModel> invoke() {
            if (y5.d.f20005b) {
                HomeFragment homeFragment = HomeFragment.this;
                return kotlin.collections.i.e(homeFragment.f8078d, homeFragment.e, homeFragment.f8079f, new BaseDataModel(10087));
            }
            HomeFragment homeFragment2 = HomeFragment.this;
            return kotlin.collections.i.e(homeFragment2.f8078d, homeFragment2.e, homeFragment2.f8079f, new BaseDataModel(10087));
        }
    });

    /* renamed from: p, reason: collision with root package name */
    public final eh.b f8089p = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.HomeFragment$homeAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final HomeDataAdapter invoke() {
            HomeDataAdapter homeDataAdapter = new HomeDataAdapter(HomeFragment.this.q0());
            homeDataAdapter.addItemProvider(new b0(17));
            homeDataAdapter.addItemProvider(new b0(16));
            homeDataAdapter.addItemProvider(new b0(15));
            homeDataAdapter.addItemProvider(new b0(10));
            homeDataAdapter.addItemProvider(new b0(11));
            homeDataAdapter.addItemProvider(new b0(13));
            homeDataAdapter.addItemProvider(new b0(14));
            homeDataAdapter.addItemProvider(new b0(12));
            homeDataAdapter.addItemProvider(new b0(18));
            homeDataAdapter.addItemProvider(new b0(20));
            homeDataAdapter.addItemProvider(new b0(19));
            homeDataAdapter.addItemProvider(new r6.a(4));
            return homeDataAdapter;
        }
    });

    public HomeFragment() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.HomeFragment$syncDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.h invoke() {
                return new com.example.test.ui.dialog.h(HomeFragment.this.f0());
            }
        });
    }

    @Override // g7.p
    public final void G(HomeBoModel homeBoModel) {
        int a3 = u0().a(3);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BO_DATA rev " + com.example.baselibrary.utils.b.z(homeBoModel) + " " + a3);
        this.f8081h = homeBoModel;
        if (a3 > -1) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("BO_DATA notifyItemChanged ", com.example.baselibrary.utils.b.z(homeBoModel)));
            q0().set(a3, homeBoModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // g7.p
    public final void H(HomeHrModel homeHrModel) {
        int a3 = u0().a(1);
        this.f8079f = homeHrModel;
        if (a3 > -1) {
            q0().set(a3, homeHrModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new w0(this);
    }

    @Override // g7.p
    public final void O(HomeBreatheModel homeBreatheModel) {
        int a3 = u0().a(7);
        this.f8082i = homeBreatheModel;
        if (a3 > -1) {
            q0().set(a3, homeBreatheModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // g7.p
    public final void P(HomeSportModel homeSportModel) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // g7.p
    public final void U(HomeViperPowerModel homeViperPowerModel) {
        int a3 = u0().a(11);
        this.f8086m = homeViperPowerModel;
        if (a3 > -1) {
            q0().set(a3, this.f8086m);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        m3 m3Var = (m3) this.f7251b;
        if (m3Var != null) {
            return m3Var.f13125a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_main, viewGroup, false);
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
                    ToolBarView toolBarView = (ToolBarView) he.a(i3, inflate);
                    if (toolBarView != null) {
                        return new m3(linearLayout, recyclerView, swipeRefreshLayout, toolBarView);
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
        ((w0) X()).q();
        ((w0) X()).x();
        Object obj = u1.f7811u;
        u1 a3 = q1.a();
        a3.getClass();
        r5.b.k().q(a3);
    }

    @Override // g7.p
    public final void i0(HomeBtModel homeBtModel) {
        int a3 = u0().a(5);
        this.f8083j = homeBtModel;
        if (a3 > -1) {
            q0().set(a3, homeBtModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // androidx.swiperefreshlayout.widget.j
    public final void j() {
        SwipeRefreshLayout swipeRefreshLayout;
        if (!com.example.test.service.e.h().i()) {
            com.example.baselibrary.utils.d.a(R$string.str_device_disconnected);
            m3 m3Var = (m3) this.f7251b;
            swipeRefreshLayout = m3Var != null ? m3Var.f13127c : null;
            if (swipeRefreshLayout == null) {
                return;
            }
            swipeRefreshLayout.setRefreshing(false);
            return;
        }
        Object obj = u1.f7811u;
        if (q1.a().f7826p) {
            m3 m3Var2 = (m3) this.f7251b;
            swipeRefreshLayout = m3Var2 != null ? m3Var2.f13127c : null;
            if (swipeRefreshLayout == null) {
                return;
            }
            swipeRefreshLayout.setRefreshing(false);
            return;
        }
        q1.a().g();
        m3 m3Var3 = (m3) this.f7251b;
        swipeRefreshLayout = m3Var3 != null ? m3Var3.f13127c : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override // g7.p
    public final void l0(HomeStepModel homeStepModel) {
        int a3 = u0().a(0);
        this.f8078d = homeStepModel;
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
        m3 m3Var = (m3) this.f7251b;
        if (m3Var != null) {
            RecyclerView recyclerView = m3Var.f13126b;
            recyclerView.setItemViewCacheSize(q0().size());
            f0();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(2);
            gridLayoutManager.K = new m(this);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(u0());
            recyclerView.g(new y6.c(com.example.baselibrary.utils.b.f(f0(), 10.0f), 0));
            f1 itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator != null) {
                itemAnimator.f2565f = 0L;
            }
        }
        m3 m3Var2 = (m3) this.f7251b;
        if (m3Var2 != null) {
            m3Var2.f13128d.setOnViewChildListener(new n(this, 0));
        }
        s5.a aVar = com.example.test.service.e.h().e;
        int i3 = aVar != null ? aVar.f18213d : 0;
        if (i3 == 1) {
            m3 m3Var3 = (m3) this.f7251b;
            if (m3Var3 != null) {
                ToolBarView toolBarView = m3Var3.f13128d;
                String string = getString(R$string.str_connected);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                toolBarView.setBarTitle(string);
                toolBarView.setBarStatusDrawable(R$mipmap.ic_device_connected);
                TimeChangedReceiver.a((FragmentActivity) f0());
            }
        } else if (i3 != 2) {
            m3 m3Var4 = (m3) this.f7251b;
            if (m3Var4 != null) {
                ToolBarView toolBarView2 = m3Var4.f13128d;
                String string2 = getString(R$string.str_disconnected);
                kotlin.jvm.internal.e.e(string2, "getString(...)");
                toolBarView2.setBarTitle(string2);
                toolBarView2.setBarStatusDrawable(R$mipmap.ic_device_disconnected);
            }
        } else {
            m3 m3Var5 = (m3) this.f7251b;
            if (m3Var5 != null) {
                ToolBarView toolBarView3 = m3Var5.f13128d;
                String string3 = getString(R$string.str_connecting);
                kotlin.jvm.internal.e.e(string3, "getString(...)");
                toolBarView3.setBarTitle(string3);
            }
        }
        f2.a();
        m3 m3Var6 = (m3) this.f7251b;
        if (m3Var6 != null) {
            m3Var6.f13127c.setOnRefreshListener(this);
        }
    }

    @Override // g7.p
    public final void o0(HomeBSModel homeBSModel) {
        int a3 = u0().a(6);
        this.f8084k = homeBSModel;
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
            m3 m3Var = (m3) this.f7251b;
            if (m3Var != null) {
                ToolBarView toolBarView = m3Var.f13128d;
                String string = getString(R$string.str_connected);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                toolBarView.setBarTitle(string);
                toolBarView.setBarStatusDrawable(R$mipmap.ic_device_connected);
                TimeChangedReceiver.a((FragmentActivity) f0());
                return;
            }
            return;
        }
        if (status == 2) {
            m3 m3Var2 = (m3) this.f7251b;
            if (m3Var2 != null) {
                ToolBarView toolBarView2 = m3Var2.f13128d;
                String string2 = getString(R$string.str_connecting);
                kotlin.jvm.internal.e.e(string2, "getString(...)");
                toolBarView2.setBarTitle(string2);
                return;
            }
            return;
        }
        if (status == 3) {
            m3 m3Var3 = (m3) this.f7251b;
            if (m3Var3 != null) {
                ToolBarView toolBarView3 = m3Var3.f13128d;
                String string3 = getString(R$string.str_connecting);
                kotlin.jvm.internal.e.e(string3, "getString(...)");
                toolBarView3.setBarTitle(string3);
                return;
            }
            return;
        }
        m3 m3Var4 = (m3) this.f7251b;
        if (m3Var4 != null) {
            ToolBarView toolBarView4 = m3Var4.f13128d;
            String string4 = getString(R$string.str_disconnected);
            kotlin.jvm.internal.e.e(string4, "getString(...)");
            toolBarView4.setBarTitle(string4);
            toolBarView4.setBarStatusDrawable(R$mipmap.ic_device_disconnected);
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceSupportEvent(EventBusBeans.DeviceSupportEvent deviceSupportEvent) {
        int a3;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        kotlin.jvm.internal.e.f(deviceSupportEvent, "deviceSupportEvent");
        q0().clear();
        q0().addAll(kotlin.collections.i.e(this.f8078d, this.e, this.f8079f, this.f8080g, this.f8081h, this.f8082i, this.f8083j, this.f8084k, this.f8085l, this.f8086m, this.f8087n, new BaseDataModel(10087)));
        u0().setList(q0());
        Object obj = com.example.test.utils.m.f8734b;
        com.example.test.utils.m a21 = d2.a();
        SupportMenuBean supportMenuBean = deviceSupportEvent.getSupportMenuBean();
        kotlin.jvm.internal.e.e(supportMenuBean, "getSupportMenuBean(...)");
        a21.getClass();
        a21.f8735a = supportMenuBean;
        SupportMenuBean supportMenuBean2 = d2.a().f8735a;
        if (!(supportMenuBean2 != null ? supportMenuBean2.isStep() : true) && (a20 = u0().a(0)) > -1) {
            q0().remove(a20);
            u0().notifyItemRemoved(a20);
        }
        SupportMenuBean supportMenuBean3 = d2.a().f8735a;
        if (!(supportMenuBean3 != null ? supportMenuBean3.isSleep() : true) && (a19 = u0().a(4)) > -1) {
            q0().remove(a19);
            u0().notifyItemRemoved(a19);
        }
        SupportMenuBean supportMenuBean4 = d2.a().f8735a;
        if (!(supportMenuBean4 != null ? supportMenuBean4.isHr() : true) && (a18 = u0().a(1)) > -1) {
            q0().remove(a18);
            u0().notifyItemRemoved(a18);
        }
        SupportMenuBean supportMenuBean5 = d2.a().f8735a;
        if (!(supportMenuBean5 != null ? supportMenuBean5.isBloodPress() : true) && (a17 = u0().a(2)) > -1) {
            q0().remove(a17);
            u0().notifyItemRemoved(a17);
        }
        SupportMenuBean supportMenuBean6 = d2.a().f8735a;
        if (!(supportMenuBean6 != null ? supportMenuBean6.isBloodOxy() : true) && (a16 = u0().a(3)) > -1) {
            q0().remove(a16);
            u0().notifyItemRemoved(a16);
        }
        SupportMenuBean supportMenuBean7 = d2.a().f8735a;
        if (!(supportMenuBean7 != null ? supportMenuBean7.isBreathe() : false) && (a15 = u0().a(7)) > -1) {
            q0().remove(a15);
            u0().notifyItemRemoved(a15);
        }
        SupportMenuBean supportMenuBean8 = d2.a().f8735a;
        if (!(supportMenuBean8 != null ? supportMenuBean8.isBodyTemp() : true) && (a14 = u0().a(5)) > -1) {
            q0().remove(a14);
            u0().notifyItemRemoved(a14);
        }
        if (!d2.a().d() && (a13 = u0().a(6)) > -1) {
            q0().remove(a13);
            u0().notifyItemRemoved(a13);
        }
        if (!d2.a().b() && (a12 = u0().a(9)) > -1) {
            q0().remove(a12);
            u0().notifyItemRemoved(a12);
        }
        SupportMenuBean supportMenuBean9 = d2.a().f8735a;
        if (!(supportMenuBean9 != null ? supportMenuBean9.isMuslimCountData() : false) && (a11 = u0().a(10)) > -1) {
            q0().remove(a11);
            u0().notifyItemRemoved(a11);
        }
        SupportMenuBean supportMenuBean10 = d2.a().f8735a;
        if (!(supportMenuBean10 != null ? supportMenuBean10.isVaperPowerData() : false) && (a10 = u0().a(11)) > -1) {
            q0().remove(a10);
            u0().notifyItemRemoved(a10);
        }
        SupportMenuBean supportMenuBean11 = d2.a().f8735a;
        if ((supportMenuBean11 != null ? supportMenuBean11.isVaperBatteryData() : false) || (a3 = u0().a(12)) <= -1) {
            return;
        }
        q0().remove(a3);
        u0().notifyItemRemoved(a3);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onPowerEvent(EventBusBeans.DevicePowerEvent powerEvent) {
        kotlin.jvm.internal.e.f(powerEvent, "powerEvent");
        Log.e("qob", "HomeFragment onPowerEvent " + powerEvent.getPowerBean().getPower());
        PowerBean powerBean = powerEvent.getPowerBean();
        if (powerBean != null) {
            HomeVaperBatteryModel homeVaperBatteryModel = new HomeVaperBatteryModel();
            homeVaperBatteryModel.setCurrentBattery(powerBean.getPower());
            x0(homeVaperBatteryModel);
        }
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
                m3 m3Var = (m3) this.f7251b;
                swipeRefreshLayout = m3Var != null ? m3Var.f13127c : null;
                if (swipeRefreshLayout == null) {
                    return;
                }
                swipeRefreshLayout.setRefreshing(false);
                return;
            }
            Object obj = u1.f7811u;
            if (q1.a().f7826p) {
                m3 m3Var2 = (m3) this.f7251b;
                swipeRefreshLayout = m3Var2 != null ? m3Var2.f13127c : null;
                if (swipeRefreshLayout == null) {
                    return;
                }
                swipeRefreshLayout.setRefreshing(false);
            }
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
                        Log.e("qob", "Constant.DATA_TYPE_STEP");
                        if (y5.d.f20005b) {
                            Object obj = com.example.test.utils.m.f8734b;
                            if (!d2.a().a()) {
                                ((w0) X()).u(str, str2);
                                return;
                            }
                        }
                        ((w0) X()).t(str, str2);
                        return;
                    case 1:
                        ((w0) X()).r(str, str2);
                        return;
                    case 2:
                        ((w0) X()).m(str, str2);
                        return;
                    case 3:
                        ((w0) X()).l(str, str2);
                        return;
                    case 4:
                        ((w0) X()).s(str, str2);
                        return;
                    case 5:
                        ((w0) X()).p(str, str2);
                        return;
                    case 6:
                        ((w0) X()).o(str, str2);
                        return;
                    case 7:
                        ((w0) X()).n(str, str2);
                        return;
                    case 8:
                    default:
                        return;
                    case 9:
                        ((w0) X()).v(str, str2);
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
                if (unitEvent.getUnitType() != 0) {
                    ((w0) X()).p(str, str2);
                    return;
                }
                if (y5.d.f20005b) {
                    Object obj = com.example.test.utils.m.f8734b;
                    if (!d2.a().a()) {
                        ((w0) X()).u(str, str2);
                        return;
                    }
                }
                ((w0) X()).t(str, str2);
            }
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onVaperPowerLevelEvent(EventBusBeans.VaperPowerLevelEvent powerLevelEvent) {
        kotlin.jvm.internal.e.f(powerLevelEvent, "powerLevelEvent");
        ((w0) X()).w();
    }

    @Override // g7.p
    public final void q(HomeSugarModel homeSugarModel) {
        int a3 = u0().a(9);
        this.f8085l = homeSugarModel;
        if (a3 > -1) {
            q0().set(a3, this.f8085l);
            u0().notifyItemChanged(a3);
        }
    }

    public final List q0() {
        return (List) this.f8088o.getValue();
    }

    @Override // g7.p
    public final void r(HomeMuslinModel homeMuslinModel) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final HomeDataAdapter u0() {
        return (HomeDataAdapter) this.f8089p.getValue();
    }

    @Override // g7.p
    public final void v0(HomeHrvModel homeHrvModel) {
    }

    @Override // g7.p
    public final void w(HomeBpModel homeBpModel) {
        int a3 = u0().a(2);
        this.f8080g = homeBpModel;
        if (a3 > -1) {
            q0().set(a3, homeBpModel);
            u0().notifyItemChanged(a3);
        }
    }

    @Override // g7.p
    public final void x0(HomeVaperBatteryModel homeVaperBatteryModel) {
        int a3 = u0().a(12);
        this.f8087n = homeVaperBatteryModel;
        if (a3 > -1) {
            q0().set(a3, this.f8087n);
            u0().notifyItemChanged(a3);
        }
    }
}
