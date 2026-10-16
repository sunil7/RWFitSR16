package com.example.test.ui.main.fragment;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.o0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.blesdk.bean.function.FirmVersionBean;
import com.example.blesdk.bean.function.PowerBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.table.Devices;
import com.example.network.bean.DialBean;
import com.example.test.MainActivity;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.presenter.main.c0;
import com.example.test.presenter.main.e0;
import com.example.test.presenter.main.h0;
import com.example.test.presenter.main.z;
import com.example.test.service.p0;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.device.activity.DeviceScanActivity;
import com.example.test.ui.device.activity.OtaActivity;
import com.example.test.ui.device.activity.ScanQrCodeActivity;
import com.example.test.ui.device.adapter.DeviceOptionAdapter;
import com.example.test.ui.device.model.DeviceInfoModel;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.device.model.DialInfoModel;
import com.example.test.ui.device.model.DialModel;
import com.example.test.ui.dialog.r;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.testui.TRingDeviceScanActivity;
import com.example.test.ui.view.DeviceInfoView;
import com.example.test.ui.view.ToolBarView;
import com.example.test.utils.t;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.m1;
import com.google.android.gms.internal.mlkit_vision_barcode.x1;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import com.google.android.gms.internal.mlkit_vision_common.p;
import f6.g3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.g0;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class DeviceFragment extends XXBaseFragment<h0, g3> implements g7.k, View.OnClickListener, o5.a {

    /* renamed from: d, reason: collision with root package name */
    public boolean f8042d;
    public List e;

    /* renamed from: f, reason: collision with root package name */
    public int f8043f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8044g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8045h;

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f8046i = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceFragment$optionAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final DeviceOptionAdapter invoke() {
            DeviceFragment deviceFragment = DeviceFragment.this;
            deviceFragment.e = deviceFragment.C0();
            return new DeviceOptionAdapter(DeviceFragment.this.e);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f8047j = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceFragment$tipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final r invoke() {
            r rVar = new r(DeviceFragment.this.f0());
            rVar.b(R$string.str_disconnect_tips);
            return rVar;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f8048k = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceFragment$connectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.h invoke() {
            return new com.example.test.ui.dialog.h(DeviceFragment.this.f0());
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final eh.b f8049l = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceFragment$dateFormatDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.d invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(DeviceFragment.this.getString(R$string.str_ymd));
            arrayList.add(DeviceFragment.this.getString(R$string.str_dmy));
            arrayList.add(DeviceFragment.this.getString(R$string.str_mdy));
            com.example.test.ui.dialog.d dVar = new com.example.test.ui.dialog.d(DeviceFragment.this.f0(), arrayList, DeviceFragment.this.r);
            dVar.setOnOptionSelectListener(new e(DeviceFragment.this, 9));
            return dVar;
        }
    });

    /* renamed from: m, reason: collision with root package name */
    public int f8050m;

    /* renamed from: n, reason: collision with root package name */
    public final int f8051n;

    /* renamed from: o, reason: collision with root package name */
    public final int f8052o;

    /* renamed from: p, reason: collision with root package name */
    public final int f8053p;

    /* renamed from: q, reason: collision with root package name */
    public final int f8054q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f8055s;

    /* renamed from: t, reason: collision with root package name */
    public final eh.b f8056t;

    /* renamed from: u, reason: collision with root package name */
    public final eh.b f8057u;

    /* renamed from: v, reason: collision with root package name */
    public final eh.b f8058v;

    /* renamed from: w, reason: collision with root package name */
    public final eh.b f8059w;

    /* renamed from: x, reason: collision with root package name */
    public DialInfoModel f8060x;

    /* renamed from: y, reason: collision with root package name */
    public final eh.b f8061y;

    public DeviceFragment() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceFragment$weakHandler$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.baselibrary.utils.e invoke() {
                return new com.example.baselibrary.utils.e(DeviceFragment.this);
            }
        });
        this.f8051n = 1;
        this.f8052o = 2;
        this.f8053p = 3;
        this.f8054q = 4;
        this.f8056t = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceFragment$permissionTipDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.i invoke() {
                com.example.test.ui.dialog.i iVar = new com.example.test.ui.dialog.i(DeviceFragment.this.f0(), 2);
                iVar.setOnDialogListener(new f(DeviceFragment.this, 11));
                iVar.setCancelable(false);
                return iVar;
            }
        });
        this.f8057u = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceFragment$gpsTipsDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final r invoke() {
                r rVar = new r(DeviceFragment.this.f0());
                rVar.b(R$string.str_gps_open);
                rVar.setOnDialogListener(new f(DeviceFragment.this, 1));
                return rVar;
            }
        });
        this.f8058v = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceFragment$bleTipsDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final r invoke() {
                r rVar = new r(DeviceFragment.this.f0());
                rVar.b(R$string.str_ble_open);
                rVar.setOnDialogListener(new f(DeviceFragment.this, 0));
                return rVar;
            }
        });
        this.f8059w = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceFragment$deviceInfo$2
            @Override // oh.a
            public final DeviceInfoModel invoke() {
                Devices c9;
                DeviceInfoModel deviceInfoModel = new DeviceInfoModel(R$id.device_info, 0);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null && (c9 = kVar.c()) != null) {
                    deviceInfoModel.setVersion(c9.getDeviceVer());
                    deviceInfoModel.setDeviceName(c9.getName());
                }
                return deviceInfoModel;
            }
        });
        this.f8061y = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.DeviceFragment$setDateFormatCallback$2
            @Override // oh.a
            public final h invoke() {
                return new h();
            }
        });
    }

    public final r A0() {
        return (r) this.f8047j.getValue();
    }

    public final void B0() {
        u0().setBindStatus(1);
        u0().setDeviceName(com.example.test.service.e.h().g().f18210a);
        u0().setMac(com.example.test.service.e.h().g().f18212c);
        g3 g3Var = (g3) this.f7251b;
        if (g3Var != null) {
            g3Var.f12925b.setBindModel(u0());
        }
        g3 g3Var2 = (g3) this.f7251b;
        if (g3Var2 != null) {
            ToolBarView toolBarView = g3Var2.f12927d;
            com.example.test.service.e.h().getClass();
            String string = com.example.test.service.e.h().i() ? getString(R$string.str_connected) : com.example.test.service.e.h().g().f18213d == 2 ? getString(R$string.str_device_connecting) : getString(R$string.str_disconnected);
            kotlin.jvm.internal.e.c(string);
            toolBarView.setBarTitle(string);
            toolBarView.setBarStatusDrawable(R$mipmap.ic_device_disconnected);
            if (com.example.test.service.e.h().i()) {
                toolBarView.setBarStatusDrawable(R$mipmap.ic_device_connected);
            }
        }
        List list = this.e;
        if (list != null) {
            list.clear();
        }
        List list2 = this.e;
        if (list2 != null) {
            list2.addAll(C0());
        }
        z0().notifyDataSetChanged();
    }

    public final ArrayList C0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DialInfoModel(R$id.dv_market, 1));
        DeviceOptionModel deviceOptionModel = new DeviceOptionModel(R$id.av_msg, 10086);
        deviceOptionModel.setActionType(0);
        deviceOptionModel.setOptionRes(R$mipmap.ic_msg_push);
        deviceOptionModel.setOptionStr(R$string.str_msg_push);
        arrayList.add(deviceOptionModel);
        if (y5.d.f20005b) {
            DeviceOptionModel deviceOptionModel2 = new DeviceOptionModel(R$id.av_incoming_call, 10086);
            deviceOptionModel2.setActionType(1);
            deviceOptionModel2.setOptionRes(R$mipmap.ic_incoming_call);
            deviceOptionModel2.setOptionStr(R$string.str_phone_remind);
            deviceOptionModel2.setEnableSwitch(true);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            deviceOptionModel2.setChecked(kVar != null ? kVar.I(com.example.test.service.e.h().g().f18212c) : false);
            arrayList.add(deviceOptionModel2);
        }
        DeviceOptionModel deviceOptionModel3 = new DeviceOptionModel(R$id.av_take_photo, 10086);
        deviceOptionModel3.setActionType(1);
        deviceOptionModel3.setOptionRes(R$mipmap.ic_take_photo);
        deviceOptionModel3.setOptionStr(R$string.str_take_photo);
        Context f02 = f0();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("android.permission.CAMERA");
        arrayList2.add("android.permission.WRITE_EXTERNAL_STORAGE");
        arrayList2.add("android.permission.READ_EXTERNAL_STORAGE");
        deviceOptionModel3.setEnableSwitch(nd.c.j(f02, arrayList2));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        deviceOptionModel3.setChecked(kVar2 != null ? kVar2.J(com.example.test.service.e.h().g().f18212c) : false);
        arrayList.add(deviceOptionModel3);
        DeviceOptionModel deviceOptionModel4 = new DeviceOptionModel(R$id.av_search_device, 10086);
        deviceOptionModel4.setActionType(0);
        deviceOptionModel4.setOptionRes(R$mipmap.ic_search_device);
        deviceOptionModel4.setOptionStr(R$string.str_search_device);
        arrayList.add(deviceOptionModel4);
        DeviceOptionModel deviceOptionModel5 = new DeviceOptionModel(R$id.av_long_sit, 10086);
        deviceOptionModel5.setActionType(0);
        deviceOptionModel5.setOptionRes(R$mipmap.ic_long_sit);
        deviceOptionModel5.setOptionStr(R$string.str_long_sit);
        arrayList.add(deviceOptionModel5);
        DeviceOptionModel deviceOptionModel6 = new DeviceOptionModel(R$id.av_drink, 10086);
        deviceOptionModel6.setActionType(0);
        deviceOptionModel6.setOptionRes(R$mipmap.ic_drink);
        deviceOptionModel6.setOptionStr(R$string.str_drink);
        arrayList.add(deviceOptionModel6);
        if (!y5.d.f20005b) {
            DeviceOptionModel deviceOptionModel7 = new DeviceOptionModel(R$id.av_warn_model, 10086);
            deviceOptionModel7.setActionType(0);
            deviceOptionModel7.setOptionRes(R$mipmap.ic_warn_model);
            deviceOptionModel7.setOptionStr(R$string.str_warn_model);
            arrayList.add(deviceOptionModel7);
        }
        DeviceOptionModel deviceOptionModel8 = new DeviceOptionModel(R$id.av_alarm, 10086);
        deviceOptionModel8.setActionType(0);
        deviceOptionModel8.setOptionRes(R$mipmap.ic_alarm);
        deviceOptionModel8.setOptionStr(R$string.str_alarm);
        arrayList.add(deviceOptionModel8);
        DeviceOptionModel deviceOptionModel9 = new DeviceOptionModel(R$id.av_screen_light, 10086);
        deviceOptionModel9.setActionType(0);
        deviceOptionModel9.setOptionRes(R$mipmap.ic_screen_light);
        deviceOptionModel9.setOptionStr(R$string.str_screen_light);
        arrayList.add(deviceOptionModel9);
        DeviceOptionModel deviceOptionModel10 = new DeviceOptionModel(R$id.av_screen_long, 10086);
        deviceOptionModel10.setActionType(0);
        deviceOptionModel10.setOptionRes(R$mipmap.ic_screen_time);
        deviceOptionModel10.setOptionStr(R$string.str_screen_long);
        arrayList.add(deviceOptionModel10);
        DeviceOptionModel deviceOptionModel11 = new DeviceOptionModel(R$id.av_hr_watcher, 10086);
        deviceOptionModel11.setActionType(0);
        deviceOptionModel11.setOptionRes(R$mipmap.ic_hr_check);
        deviceOptionModel11.setOptionStr(R$string.str_hr_watcher);
        arrayList.add(deviceOptionModel11);
        DeviceOptionModel deviceOptionModel12 = new DeviceOptionModel(R$id.av_no_disturb, 10086);
        deviceOptionModel12.setActionType(0);
        deviceOptionModel12.setOptionRes(R$mipmap.ic_no_disturb);
        deviceOptionModel12.setOptionStr(R$string.str_no_disturb);
        arrayList.add(deviceOptionModel12);
        DeviceOptionModel deviceOptionModel13 = new DeviceOptionModel(R$id.av_weather, 10086);
        deviceOptionModel13.setActionType(1);
        deviceOptionModel13.setOptionRes(R$mipmap.ic_weather);
        deviceOptionModel13.setOptionStr(R$string.str_weather);
        deviceOptionModel13.setEnableSwitch(nd.c.j(f0(), kotlin.collections.i.b("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION")));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
        deviceOptionModel13.setChecked(kVar3 != null ? kVar3.K(com.example.test.service.e.h().g().f18212c) : false);
        arrayList.add(deviceOptionModel13);
        DeviceOptionModel deviceOptionModel14 = new DeviceOptionModel(R$id.av_address_book, 10086);
        deviceOptionModel14.setActionType(0);
        deviceOptionModel14.setOptionRes(R$mipmap.ic_address_book);
        deviceOptionModel14.setOptionStr(R$string.str_address_book);
        arrayList.add(deviceOptionModel14);
        if (!y5.d.f20005b) {
            DeviceOptionModel deviceOptionModel15 = new DeviceOptionModel(R$id.av_qr_code, 10086);
            deviceOptionModel15.setActionType(0);
            deviceOptionModel15.setOptionRes(R$mipmap.ic_qr_code_man);
            deviceOptionModel15.setOptionStr(R$string.str_qrcode_manager);
            arrayList.add(deviceOptionModel15);
            DeviceOptionModel deviceOptionModel16 = new DeviceOptionModel(R$id.av_breathe, 10086);
            deviceOptionModel16.setActionType(0);
            deviceOptionModel16.setOptionRes(R$mipmap.ic_breathe_setting);
            deviceOptionModel16.setOptionStr(R$string.str_breathe_title);
            arrayList.add(deviceOptionModel16);
        }
        DeviceOptionModel deviceOptionModel17 = new DeviceOptionModel(R$id.av_women, 10086);
        deviceOptionModel17.setActionType(0);
        deviceOptionModel17.setOptionRes(R$mipmap.ic_women_health);
        deviceOptionModel17.setOptionStr(R$string.str_menstrual_cycle_reminder);
        arrayList.add(deviceOptionModel17);
        DeviceOptionModel deviceOptionModel18 = new DeviceOptionModel(R$id.av_game_watchapp, 10086);
        deviceOptionModel18.setActionType(0);
        deviceOptionModel18.setOptionRes(R$mipmap.ic_item_gameapp);
        deviceOptionModel18.setOptionStr(R$string.str_dial_setting_item_appcontrol);
        arrayList.add(deviceOptionModel18);
        DeviceOptionModel deviceOptionModel19 = new DeviceOptionModel(R$id.av_more, 10086);
        deviceOptionModel19.setActionType(0);
        deviceOptionModel19.setOptionRes(R$mipmap.ic_more);
        deviceOptionModel19.setOptionStr(R$string.str_more);
        arrayList.add(deviceOptionModel19);
        arrayList.add(new DeviceOptionModel(R$id.btn_unbind, 17));
        arrayList.add(new DeviceOptionModel(10087));
        return arrayList;
    }

    public final void D0() {
        this.f8042d = false;
        u0().setBindStatus(0);
        g3 g3Var = (g3) this.f7251b;
        if (g3Var != null) {
            g3Var.f12925b.setBindModel(u0());
        }
        z0().b(R$id.av_long_sit);
        z0().b(R$id.av_drink);
        z0().b(R$id.av_wash_hand);
        z0().b(R$id.av_date_format);
        z0().b(R$id.av_bt_watcher);
        z0().b(R$id.av_bo_watcher);
        z0().b(R$id.av_warn_model);
        z0().b(R$id.av_screen_light);
        z0().b(R$id.av_screen_long);
        z0().b(R$id.av_no_disturb);
        z0().b(R$id.av_recover);
        z0().b(R$id.btn_unbind);
        z0().b(R$id.av_breathe);
        z0().b(R$id.av_women);
        z0().b(R$id.av_qr_code);
        z0().b(R$id.av_restart);
        z0().b(R$id.av_power_off);
        z0().b(R$id.av_incoming_call);
        z0().b(R$id.av_search_device);
        Object obj = com.example.test.utils.m.f8734b;
        if (!d2.a().c()) {
            int a3 = z0().a(R$id.av_weather);
            z0().getData().get(a3).setEnableSwitch(false);
            z0().getData().get(a3).setChecked(false);
        }
        int a10 = z0().a(R$id.av_take_photo);
        if (a10 != -1) {
            z0().getData().get(a10).setEnableSwitch(false);
            z0().getData().get(a10).setChecked(false);
        }
        this.e = z0().getData();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.Q("");
        }
    }

    public final void E0(PowerBean powerBean) {
        DeviceInfoView deviceInfoView;
        kotlin.jvm.internal.e.f(powerBean, "powerBean");
        u0().setPower(powerBean.getPower());
        u0().setPowering(powerBean.getPowerStatus() != 0);
        u0().setLowPower(powerBean.isLowPower());
        g3 g3Var = (g3) this.f7251b;
        if (g3Var == null || (deviceInfoView = g3Var.f12925b) == null) {
            return;
        }
        deviceInfoView.setBindModel(u0());
    }

    public final void F0() {
        b0();
        this.f8042d = false;
        D0();
        g3 g3Var = (g3) this.f7251b;
        if (g3Var != null) {
            ToolBarView toolBarView = g3Var.f12927d;
            String string = getString(R$string.str_disconnected);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            toolBarView.setBarTitle(string);
        }
        ((MainActivity) f0()).finish();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.b0();
        }
        f0().startActivity(new Intent(f0(), (Class<?>) TRingDeviceScanActivity.class));
        int i3 = this.f8050m;
        if (i3 == this.f8053p) {
            this.f8050m = 0;
        } else if (i3 == this.f8054q) {
            this.f8050m = 0;
        }
    }

    public final void G0() {
        g3 g3Var = (g3) this.f7251b;
        if (g3Var != null) {
            ToolBarView toolBarView = g3Var.f12927d;
            String string = getString(R$string.str_connected);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            toolBarView.setBarTitle(string);
            toolBarView.setBarStatusDrawable(R$mipmap.ic_device_connected);
        }
        this.f8042d = true;
        Object obj = com.example.test.utils.m.f8734b;
        Log.e("qob", "refreshDeviceInfo 蓝牙已连接刷新功能表 isSupportHealthRing " + d2.a().c());
        B0();
        h0 h0Var = (h0) X();
        h0Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", "======== initDeviceInfo");
        boolean z5 = y5.d.f20005b;
        eh.b bVar = h0Var.f7512c;
        if (z5) {
            p.U((c0) bVar.getValue());
            p.h();
        } else {
            p.U((c0) bVar.getValue());
            p.U((e0) h0Var.f7513d.getValue());
            p.U((z) h0Var.e.getValue());
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) 0, new byte[0]);
            } else {
                x5.b.I0().F0((byte) 0);
            }
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) 1, new byte[0]);
            } else {
                x5.b.I0().F0((byte) 1);
            }
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) 4, new byte[0]);
            } else {
                x5.b.I0().F0((byte) 4);
            }
        }
        ((h0) X()).k();
        g3 g3Var2 = (g3) this.f7251b;
        if (g3Var2 != null) {
            DeviceInfoView deviceInfoView = g3Var2.f12925b;
            String string2 = getString(R$string.str_ota);
            kotlin.jvm.internal.e.e(string2, "getString(...)");
            deviceInfoView.setOtaText(string2);
        }
    }

    public final void H0(int i3) {
        if (com.example.test.service.e.h().i()) {
            this.f8050m = i3;
            ((h0) X()).n();
            return;
        }
        ((h0) X()).o();
        if (i3 == this.f8053p) {
            startActivity(new Intent(f0(), (Class<?>) ScanQrCodeActivity.class));
            this.f8050m = 0;
        } else if (i3 == this.f8054q) {
            startActivity(new Intent(f0(), (Class<?>) DeviceScanActivity.class));
            this.f8050m = 0;
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new h0(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        g3 g3Var = (g3) this.f7251b;
        if (g3Var != null) {
            return g3Var.f12924a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_device, viewGroup, false);
        int i3 = R$id.device_info_view;
        DeviceInfoView deviceInfoView = (DeviceInfoView) he.a(i3, inflate);
        if (deviceInfoView != null) {
            i3 = R$id.device_option_list;
            RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
            if (recyclerView != null) {
                i3 = R$id.toolbar;
                ToolBarView toolBarView = (ToolBarView) he.a(i3, inflate);
                if (toolBarView != null) {
                    return new g3((RelativeLayout) inflate, deviceInfoView, recyclerView, toolBarView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
        registerForActivityResult(new o0(2), new e(this, 6));
    }

    @Override // p5.a
    public final Context f0() {
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.e.d(activity, "null cannot be cast to non-null type android.content.Context");
        return activity;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        b2.a(this);
        int i3 = 0;
        this.f8043f = 0;
        com.example.test.utils.k a3 = y1.a();
        Log.e("qob", "DeviceFragment initView isOTAFailed " + (a3 != null ? a3.q() : null));
        g3 g3Var = (g3) this.f7251b;
        if (g3Var != null) {
            RecyclerView recyclerView = g3Var.f12926c;
            f0();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            g0 g0Var = new g0(f0());
            g0Var.e(recyclerView.getResources().getColor(R.color.transparent));
            g0Var.o(R$dimen.qb_px_10);
            recyclerView.g(g0Var.d());
            recyclerView.setAdapter(z0());
            recyclerView.setItemAnimator(null);
        }
        z0().setOnItemClickListener(new e(this, 7));
        z0().addChildClickViewIds(R$id.switch_enable_view);
        z0().setOnItemChildClickListener(new e(this, 8));
        z0().setOnSwitchItemStatusListener(new e(this, i3));
        g3 g3Var2 = (g3) this.f7251b;
        if (g3Var2 != null) {
            g3Var2.f12925b.setBindClickListener(this);
        }
        g3 g3Var3 = (g3) this.f7251b;
        if (g3Var3 != null) {
            g3Var3.f12927d.setOnViewChildListener(new f(this, 10));
        }
        com.example.test.utils.k a10 = y1.a();
        if (a10 != null && a10.c() != null) {
            this.f8042d = true;
        }
        if (this.f8042d) {
            B0();
        } else {
            D0();
        }
        ((h0) X()).k();
        ((h0) X()).l();
        g3 g3Var4 = (g3) this.f7251b;
        if (g3Var4 != null) {
            g3Var4.f12925b.setOnViewClickListener(new View.OnClickListener() { // from class: com.example.test.ui.main.fragment.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeviceFragment this$0 = DeviceFragment.this;
                    kotlin.jvm.internal.e.f(this$0, "this$0");
                    if (System.currentTimeMillis() - x1.f9659a >= 1200 || System.currentTimeMillis() < x1.f9659a) {
                        x1.f9659a = System.currentTimeMillis();
                        if (!com.example.test.service.e.h().i() || !this$0.f8042d) {
                            Toast.makeText(this$0.f0(), R$string.str_device_disconnected, 0).show();
                            return;
                        }
                        if (this$0.u0().getPower() < 30) {
                            Toast.makeText(this$0.f0(), R$string.str_ota_battery_limit30, 0).show();
                            return;
                        }
                        Object obj = p0.f7741g;
                        String downloadUrl = m1.a().d().getDownloadUrl();
                        if (downloadUrl != null && downloadUrl.length() != 0) {
                            this$0.startActivity(new Intent(this$0.f0(), (Class<?>) OtaActivity.class));
                        } else {
                            this$0.V();
                            m1.a().h(false);
                        }
                    }
                }
            });
        }
        if (this.f8042d) {
            com.example.test.utils.k a11 = y1.a();
            if ((a11 != null ? kotlin.jvm.internal.e.a(a11.q(), Boolean.TRUE) : false) && this.f8043f == 0) {
                this.f8043f = 1;
                V();
                Object obj = p0.f7741g;
                m1.a().f();
            }
        }
        Log.e("qob", "isScanFragmentToBindFragment " + this.f8044g);
        if (this.f8044g) {
            this.f8044g = false;
            G0();
        }
    }

    public final void n0(DialInfoBean dialInfoBean) {
        List list;
        int a3;
        kotlin.jvm.internal.e.f(dialInfoBean, "dialInfoBean");
        Object obj = com.example.test.utils.m.f8734b;
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (!(supportMenuBean != null ? supportMenuBean.isDial() : true) || (list = this.e) == null || (a3 = z0().a(R$id.dv_market)) < 0) {
            return;
        }
        Object obj2 = list.get(a3);
        kotlin.jvm.internal.e.d(obj2, "null cannot be cast to non-null type com.example.test.ui.device.model.DialInfoModel");
        ((DialInfoModel) obj2).setDialInfoBean(dialInfoBean);
        z0().notifyItemChanged(a3);
    }

    @Override // g7.k
    @yh.k(threadMode = ThreadMode.MAIN)
    public void onAttachFirmware(FirmVersionBean firmVersionBean) {
        Devices c9;
        kotlin.jvm.internal.e.f(firmVersionBean, "firmVersionBean");
        Log.e("qob", "DeviceFragment onAttachFirmware");
        u0().setVersion(firmVersionBean.getDeviceNo());
        if (!y5.d.f20005b) {
            h0 h0Var = (h0) X();
            String deviceClazz = firmVersionBean.getDeviceClazz();
            kotlin.jvm.internal.e.e(deviceClazz, "getDeviceClazz(...)");
            h0Var.m(deviceClazz);
            return;
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (c9 = kVar.c()) == null) {
            return;
        }
        Log.e("qob", "onAttachFirmware " + c9.getDeviceModel());
        h0 h0Var2 = (h0) X();
        String deviceModel = c9.getDeviceModel();
        kotlin.jvm.internal.e.e(deviceModel, "getDeviceModel(...)");
        h0Var2.m(deviceModel);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.btnBind;
        if (valueOf != null && valueOf.intValue() == i3 && q0()) {
            if (nd.c.j(f0(), android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"))) {
                f0().startActivity(new Intent(f0(), (Class<?>) DeviceScanActivity.class));
            } else {
                this.f8055s = 1;
                ((com.example.test.ui.dialog.i) this.f8056t.getValue()).show();
            }
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceFunEvent(EventBusBeans.DeviceFunEvent deviceEvent) {
        kotlin.jvm.internal.e.f(deviceEvent, "deviceEvent");
        if (deviceEvent.getDeviceFunType() == 2) {
            F0();
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        Object obj = p0.f7741g;
        m1.a().f7742a = false;
        u0().setHasNew(false);
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            G0();
            return;
        }
        if (status == 2) {
            g3 g3Var = (g3) this.f7251b;
            if (g3Var != null) {
                ToolBarView toolBarView = g3Var.f12927d;
                String string = getString(R$string.str_connecting);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                toolBarView.setBarTitle(string);
                return;
            }
            return;
        }
        if (status == 3) {
            g3 g3Var2 = (g3) this.f7251b;
            if (g3Var2 != null) {
                ToolBarView toolBarView2 = g3Var2.f12927d;
                String string2 = getString(R$string.str_connecting);
                kotlin.jvm.internal.e.e(string2, "getString(...)");
                toolBarView2.setBarTitle(string2);
                return;
            }
            return;
        }
        if (status == 6) {
            F0();
            return;
        }
        if (status != 7) {
            b0();
            g3 g3Var3 = (g3) this.f7251b;
            if (g3Var3 != null) {
                ToolBarView toolBarView3 = g3Var3.f12927d;
                String string3 = com.example.test.service.e.h().g().f18213d == 2 ? getString(R$string.str_device_connecting) : getString(R$string.str_disconnected);
                kotlin.jvm.internal.e.c(string3);
                toolBarView3.setBarTitle(string3);
                toolBarView3.setBarStatusDrawable(R$mipmap.ic_device_disconnected);
            }
            int a3 = z0().a(R$id.av_take_photo);
            if (a3 > -1) {
                List list = this.e;
                if (list != null) {
                    ((DeviceOptionModel) list.get(a3)).setEnableSwitch(false);
                }
                z0().notifyItemChanged(a3);
            }
            int a10 = z0().a(R$id.av_weather);
            if (a10 > -1) {
                List list2 = this.e;
                if (list2 != null) {
                    ((DeviceOptionModel) list2.get(a10)).setEnableSwitch(false);
                }
                z0().notifyItemChanged(a10);
                return;
            }
            return;
        }
        Log.e("qob", "DEVICE_JL_OTA_ERROR_INFO");
        if (this.f8042d) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if ((kVar != null ? kotlin.jvm.internal.e.a(kVar.q(), Boolean.TRUE) : false) && this.f8043f == 1) {
                V();
                m1.a().f();
                return;
            }
            return;
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        if (kVar2 != null) {
            kVar2.V(true);
        }
        String address = r5.b.k().f18057g.getAddress();
        kotlin.jvm.internal.e.c(address);
        m1.a().g(ca.b(address));
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceSupportEvent(EventBusBeans.DeviceSupportEvent deviceSupportEvent) {
        g3 g3Var;
        kotlin.jvm.internal.e.f(deviceSupportEvent, "deviceSupportEvent");
        Object obj = com.example.test.utils.m.f8734b;
        com.example.test.utils.m a3 = d2.a();
        SupportMenuBean supportMenuBean = deviceSupportEvent.getSupportMenuBean();
        kotlin.jvm.internal.e.e(supportMenuBean, "getSupportMenuBean(...)");
        a3.getClass();
        a3.f8735a = supportMenuBean;
        SupportMenuBean supportMenuBean2 = d2.a().f8735a;
        if (!(supportMenuBean2 != null ? supportMenuBean2.isDial() : true)) {
            z0().b(R$id.dv_market);
        }
        SupportMenuBean supportMenuBean3 = d2.a().f8735a;
        if (!(supportMenuBean3 != null ? supportMenuBean3.isSedentary() : true)) {
            z0().b(R$id.av_long_sit);
        }
        SupportMenuBean supportMenuBean4 = d2.a().f8735a;
        if (!(supportMenuBean4 != null ? supportMenuBean4.isMsgNotification() : true)) {
            z0().b(R$id.av_msg);
            z0().b(R$id.av_incoming_call);
        }
        SupportMenuBean supportMenuBean5 = d2.a().f8735a;
        if (!(supportMenuBean5 != null ? supportMenuBean5.isTakePhoto() : true)) {
            z0().b(R$id.av_take_photo);
        }
        SupportMenuBean supportMenuBean6 = d2.a().f8735a;
        if (!(supportMenuBean6 != null ? supportMenuBean6.isDrink() : true)) {
            z0().b(R$id.av_drink);
        }
        SupportMenuBean supportMenuBean7 = d2.a().f8735a;
        if (!(supportMenuBean7 != null ? supportMenuBean7.isRemindModel() : true)) {
            z0().b(R$id.av_warn_model);
        }
        SupportMenuBean supportMenuBean8 = d2.a().f8735a;
        if (!(supportMenuBean8 != null ? supportMenuBean8.isAlarm() : true)) {
            z0().b(R$id.av_alarm);
        }
        SupportMenuBean supportMenuBean9 = d2.a().f8735a;
        if (!(supportMenuBean9 != null ? supportMenuBean9.isBrightScreen() : true)) {
            z0().b(R$id.av_screen_light);
        }
        SupportMenuBean supportMenuBean10 = d2.a().f8735a;
        if (!(supportMenuBean10 != null ? supportMenuBean10.isHrMonitor() : true)) {
            z0().b(R$id.av_hr_watcher);
        }
        SupportMenuBean supportMenuBean11 = d2.a().f8735a;
        if (!(supportMenuBean11 != null ? supportMenuBean11.isDND() : true)) {
            z0().b(R$id.av_no_disturb);
        }
        SupportMenuBean supportMenuBean12 = d2.a().f8735a;
        if (!(supportMenuBean12 != null ? supportMenuBean12.isWeather() : true)) {
            z0().b(R$id.av_weather);
        }
        SupportMenuBean supportMenuBean13 = d2.a().f8735a;
        if (!(supportMenuBean13 != null ? supportMenuBean13.isAddressBook() : true)) {
            z0().b(R$id.av_address_book);
        }
        SupportMenuBean supportMenuBean14 = d2.a().f8735a;
        if (!(supportMenuBean14 != null ? supportMenuBean14.isFirmwareUpdate() : true) && (g3Var = (g3) this.f7251b) != null) {
            g3Var.f12925b.setOtaStatus(false);
        }
        SupportMenuBean supportMenuBean15 = d2.a().f8735a;
        if (!(supportMenuBean15 != null ? supportMenuBean15.isBreathe() : false)) {
            z0().b(R$id.av_breathe);
        }
        SupportMenuBean supportMenuBean16 = d2.a().f8735a;
        if (!(supportMenuBean16 != null ? supportMenuBean16.isWomenHealth() : true)) {
            z0().b(R$id.av_women);
        }
        SupportMenuBean supportMenuBean17 = d2.a().f8735a;
        if (!(supportMenuBean17 != null ? supportMenuBean17.isQrCode() : true)) {
            z0().b(R$id.av_qr_code);
        }
        if (d2.a().c()) {
            z0().b(R$id.av_incoming_call);
        }
        SupportMenuBean supportMenuBean18 = d2.a().f8735a;
        if (supportMenuBean18 != null ? supportMenuBean18.isBLESupport_Function_V2() : true) {
            SupportMenuBean supportMenuBean19 = d2.a().f8735a;
            if (supportMenuBean19 != null ? supportMenuBean19.isBLESupport_Function_V2_Get_OK() : true) {
                SupportMenuBean supportMenuBean20 = d2.a().f8735a;
                if (!(supportMenuBean20 != null ? supportMenuBean20.isChildAppSwitch() : true)) {
                    z0().b(R$id.av_game_watchapp);
                }
            }
        } else {
            SupportMenuBean supportMenuBean21 = d2.a().f8735a;
            if (!(supportMenuBean21 != null ? supportMenuBean21.isChildAppSwitch() : true)) {
                z0().b(R$id.av_game_watchapp);
            }
        }
        SupportMenuBean supportMenuBean22 = d2.a().f8735a;
        if (supportMenuBean22 != null ? supportMenuBean22.isRestart() : true) {
            return;
        }
        SupportMenuBean supportMenuBean23 = d2.a().f8735a;
        if (supportMenuBean23 != null ? supportMenuBean23.isPowerOff() : true) {
            return;
        }
        SupportMenuBean supportMenuBean24 = d2.a().f8735a;
        if (supportMenuBean24 != null ? supportMenuBean24.isRecovery() : true) {
            return;
        }
        z0().b(R$id.av_more);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onFirmUpgradeEvent(EventBusBeans.FirmwareEvent firmwareEvent) {
        DeviceInfoView deviceInfoView;
        String downloadUrl;
        kotlin.jvm.internal.e.f(firmwareEvent, "firmwareEvent");
        if (firmwareEvent.getStatus() == 11) {
            b0();
            return;
        }
        b0();
        u0().setHasNew((firmwareEvent.getFirmwareInfoBean() == null || (downloadUrl = firmwareEvent.getFirmwareInfoBean().getDownloadUrl()) == null || downloadUrl.length() == 0) ? false : true);
        g3 g3Var = (g3) this.f7251b;
        if (g3Var == null || (deviceInfoView = g3Var.f12925b) == null) {
            return;
        }
        deviceInfoView.setBindModel(u0());
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onHomeDialRefreshEvent(EventBusBeans.HomeDialEvent homeDialEvent) {
        List list;
        List<DialModel> dialModels;
        kotlin.jvm.internal.e.f(homeDialEvent, "homeDialEvent");
        int a3 = z0().a(R$id.dv_market);
        if (a3 <= -1 || (list = this.e) == null) {
            return;
        }
        Object obj = list.get(a3);
        String z5 = com.example.baselibrary.utils.b.z(this.f8060x);
        StringBuilder sb2 = new StringBuilder("刷新 id ");
        sb2.append(obj);
        sb2.append(" ");
        sb2.append(z5);
        DialInfoModel dialInfoModel = this.f8060x;
        Object obj2 = null;
        if (dialInfoModel != null && (dialModels = dialInfoModel.getDialModels()) != null) {
            Iterator<T> it = dialModels.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                DialBean dialBean = ((DialModel) next).getDialBean();
                if (dialBean != null && dialBean.getId() == homeDialEvent.getDialId()) {
                    obj2 = next;
                    break;
                }
            }
            obj2 = (DialModel) obj2;
        }
        if (obj2 != null) {
            ((h0) X()).k();
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onIncomingCallEvent(EventBusBeans.IncomingCallEvent incomingCallEvent) {
        int a3;
        kotlin.jvm.internal.e.f(incomingCallEvent, "incomingCallEvent");
        if (this.e == null || (a3 = z0().a(R$id.av_incoming_call)) < 0) {
            return;
        }
        z0().getData().get(a3).setChecked(incomingCallEvent.isOpen());
        z0().notifyItemChanged(a3);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onPowerEvent(EventBusBeans.DevicePowerEvent powerEvent) {
        kotlin.jvm.internal.e.f(powerEvent, "powerEvent");
        Log.e("qob", "DeviceFragment onPowerEvent " + powerEvent.getPowerBean().getPower() + " isFragmentVisible " + this.f8045h);
        PowerBean powerBean = powerEvent.getPowerBean();
        if (powerBean != null) {
            E0(powerBean);
        }
        Object obj = p0.f7741g;
        if (!m1.a().f7742a && this.f8045h && u0().isHasNew()) {
            m1.a().f7742a = true;
            if (A0().isShowing()) {
                return;
            }
            A0().b(R$string.str_new_version_found);
            A0().setOnDialogListener(new g(this));
            A0().show();
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncStatusEvent(EventBusBeans.SyncStatusEvent syncStatusEvent) {
        kotlin.jvm.internal.e.f(syncStatusEvent, "syncStatusEvent");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceFragment", l0.j(this.f8050m, "========= onSyncStatusEvent "));
    }

    public final boolean q0() {
        XXApplication xXApplication = XXApplication.f7400h;
        boolean d5 = t.d(j1.a());
        boolean n4 = com.example.baselibrary.utils.b.n(j1.a());
        if (!n4) {
            ((r) this.f8058v.getValue()).show();
            return n4;
        }
        if (!d5) {
            ((r) this.f8057u.getValue()).show();
        }
        return d5;
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.main.fragment.DeviceFragment$onMessage$1
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    com.example.baselibrary.utils.d.b("拍照");
                    new Thread(new com.example.blesdk.service.z(1)).start();
                }
            }, new oh.l() { // from class: com.example.test.ui.main.fragment.DeviceFragment$onMessage$2
                public final void invoke(eh.g it) {
                    kotlin.jvm.internal.e.f(it, "it");
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((eh.g) obj);
                    return eh.g.f12633a;
                }
            });
        } else {
            ((com.example.test.ui.dialog.h) this.f8048k.getValue()).dismiss();
            this.f8042d = true;
            B0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean z5) {
        super.setUserVisibleHint(z5);
        Log.e("qob", "DeviceFragment setUserVisibleHint " + z5);
        this.f8045h = z5;
        if (z5 && y5.d.f20005b) {
            p.U((e0) ((h0) X()).f7513d.getValue());
            p.i();
        }
    }

    public final DeviceInfoModel u0() {
        return (DeviceInfoModel) this.f8059w.getValue();
    }

    public final DeviceOptionAdapter z0() {
        return (DeviceOptionAdapter) this.f8046i.getValue();
    }
}
