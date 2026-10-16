package com.example.test.ui.testui;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import com.example.blesdk.bean.function.BrightScreenLedBean;
import com.example.blesdk.bean.function.VideoHidBean;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.presenter.main.i1;
import com.example.test.presenter.main.j1;
import com.example.test.presenter.main.r1;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.device.activity.RingMessagePushActivity;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.y9;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class q implements t6.a, t6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8303a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TRingDeviceFragment f8304b;

    public /* synthetic */ q(TRingDeviceFragment tRingDeviceFragment, int i3) {
        this.f8303a = i3;
        this.f8304b = tRingDeviceFragment;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }

    private final void i() {
    }

    @Override // t6.b
    public void onCancel() {
        int i3 = this.f8303a;
    }

    @Override // t6.b
    public void s() {
        Devices c9;
        int i3 = 3;
        int i10 = 2;
        int i11 = 1;
        switch (this.f8303a) {
            case 1:
                v2.h hVar = new v2.h(this.f8304b.f0());
                hVar.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                hVar.p(new b9.a(19));
                return;
            case 2:
                com.example.test.utils.t.b(this.f8304b.f0());
                return;
            case 3:
                TRingDeviceFragment tRingDeviceFragment = this.f8304b;
                tRingDeviceFragment.V();
                if (com.example.test.service.e.h().i()) {
                    tRingDeviceFragment.f8229w = tRingDeviceFragment.f8230x;
                    ((r1) tRingDeviceFragment.X()).o();
                    return;
                }
                r1 r1Var = (r1) tRingDeviceFragment.X();
                r1Var.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== unbindLocal");
                com.example.test.service.e.h().q();
                ((TRingDeviceFragment) ((g7.z) r1Var.f7255a)).J0();
                return;
            case 4:
                r1 r1Var2 = (r1) this.f8304b.X();
                r1Var2.f7558g = 2;
                ((XXBaseFragment) ((g7.z) r1Var2.f7255a)).V();
                if (r5.b.k().f18054c) {
                    x5.c b3 = x5.c.b();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "获取关机");
                    char[] cArr = y5.b.f20001a;
                    b3.g((byte) -57, new byte[]{2, 34, 0, (byte) 2}, new boolean[0]);
                } else {
                    x5.b.I0().F0((byte) -57);
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    kVar.W(33);
                }
                yh.d.b().e(new EventBusBeans.SyncEvent(10));
                return;
            case 5:
                r1 r1Var3 = (r1) this.f8304b.X();
                r1Var3.f7558g = 1;
                ((XXBaseFragment) ((g7.z) r1Var3.f7255a)).V();
                com.google.android.gms.internal.mlkit_vision_common.p.U((j1) r1Var3.e.getValue());
                com.google.android.gms.internal.mlkit_vision_common.p.y(1);
                return;
            case 6:
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                if (kVar2 != null && (c9 = kVar2.c()) != null) {
                    kVar2.N(c9.getMacAddress() + "home_card_data");
                }
                ((r1) this.f8304b.X()).o();
                Log.d("tong", "unbind dialog ok");
                return;
            case 7:
                TRingDeviceFragment tRingDeviceFragment2 = this.f8304b;
                Context f02 = tRingDeviceFragment2.f0();
                ArrayList arrayList = new ArrayList();
                arrayList.add("android.permission.READ_PHONE_STATE");
                arrayList.add("android.permission.READ_CALL_LOG");
                arrayList.add("android.permission.READ_CONTACTS");
                arrayList.add("android.permission.ANSWER_PHONE_CALLS");
                if (nd.c.j(f02, arrayList)) {
                    tRingDeviceFragment2.startActivity(new Intent(tRingDeviceFragment2.f0(), (Class<?>) RingMessagePushActivity.class));
                    return;
                }
                v2.h hVar2 = new v2.h(tRingDeviceFragment2.f0());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("android.permission.READ_PHONE_STATE");
                arrayList2.add("android.permission.READ_CALL_LOG");
                arrayList2.add("android.permission.READ_CONTACTS");
                arrayList2.add("android.permission.ANSWER_PHONE_CALLS");
                hVar2.n(arrayList2);
                hVar2.p(new n(tRingDeviceFragment2, 9));
                return;
            case 8:
                TRingDeviceFragment tRingDeviceFragment3 = this.f8304b;
                int i12 = tRingDeviceFragment3.A;
                if (i12 == 1) {
                    v2.h hVar3 = new v2.h(tRingDeviceFragment3.f0());
                    hVar3.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar3.p(new n(tRingDeviceFragment3, i11));
                    return;
                } else {
                    if (i12 == 2) {
                        v2.h hVar4 = new v2.h(tRingDeviceFragment3.f0());
                        hVar4.o("android.permission.CAMERA");
                        hVar4.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                        hVar4.p(new n(tRingDeviceFragment3, i10));
                        return;
                    }
                    if (i12 != 3) {
                        return;
                    }
                    v2.h hVar5 = new v2.h(tRingDeviceFragment3.f0());
                    hVar5.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar5.p(new n(tRingDeviceFragment3, i3));
                    return;
                }
            default:
                y9.a(this.f8304b.f0());
                return;
        }
    }

    @Override // t6.a
    public void v(String data) {
        boolean z5 = false;
        switch (this.f8303a) {
            case 0:
                kotlin.jvm.internal.e.f(data, "data");
                int a3 = this.f8304b.A0().a(R$id.av_app_unit);
                DeviceOptionModel deviceOptionModel = this.f8304b.A0().getData().get(a3);
                kotlin.jvm.internal.e.d(deviceOptionModel, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
                DeviceOptionModel deviceOptionModel2 = deviceOptionModel;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (Integer.parseInt(data) == 0) {
                    if (d5 != null) {
                        d5.setMeterUnit(0);
                    }
                    deviceOptionModel2.setOptionHint(this.f8304b.f0().getString(R$string.str_unit_metric));
                } else {
                    if (d5 != null) {
                        d5.setMeterUnit(1);
                    }
                    deviceOptionModel2.setOptionHint(this.f8304b.f0().getString(R$string.str_unit_imperial));
                }
                ((r1) this.f8304b.X()).m(d5, 5);
                this.f8304b.A0().notifyItemChanged(a3);
                return;
            case 9:
                kotlin.jvm.internal.e.f(data, "data");
                boolean equals = data.equals("0");
                TRingDeviceFragment tRingDeviceFragment = this.f8304b;
                if (equals) {
                    tRingDeviceFragment.u0().setOpen(false);
                } else {
                    tRingDeviceFragment.u0().setOpen(true);
                    tRingDeviceFragment.u0().setLcdLevel(Integer.parseInt(data));
                }
                r1 r1Var = (r1) tRingDeviceFragment.X();
                BrightScreenLedBean data2 = tRingDeviceFragment.u0();
                r1Var.getClass();
                kotlin.jvm.internal.e.f(data2, "data");
                com.google.android.gms.internal.mlkit_vision_common.p.U(r1Var);
                r1Var.f7559h = data2;
                ((XXBaseFragment) ((g7.z) r1Var.f7255a)).V();
                com.google.android.gms.internal.mlkit_vision_common.p.C(data2);
                int a10 = tRingDeviceFragment.A0().a(R$id.av_led_light);
                DeviceOptionModel deviceOptionModel3 = tRingDeviceFragment.A0().getData().get(a10);
                kotlin.jvm.internal.e.d(deviceOptionModel3, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
                DeviceOptionModel deviceOptionModel4 = deviceOptionModel3;
                if (tRingDeviceFragment.u0().isOpen()) {
                    int lcdLevel = tRingDeviceFragment.u0().getLcdLevel();
                    if (lcdLevel == 1) {
                        deviceOptionModel4.setOptionHint(tRingDeviceFragment.f0().getString(R$string.str_ring_screen_light_1));
                    } else if (lcdLevel == 2) {
                        deviceOptionModel4.setOptionHint(tRingDeviceFragment.f0().getString(R$string.str_ring_screen_light_2));
                    } else if (lcdLevel == 3) {
                        deviceOptionModel4.setOptionHint(tRingDeviceFragment.f0().getString(R$string.str_ring_screen_light_3));
                    }
                } else {
                    deviceOptionModel4.setOptionHint(tRingDeviceFragment.f0().getString(R$string.str_ring_screen_light_0));
                }
                tRingDeviceFragment.A0().notifyItemChanged(a10);
                return;
            case 10:
                kotlin.jvm.internal.e.f(data, "data");
                TRingDeviceFragment tRingDeviceFragment2 = this.f8304b;
                int a11 = tRingDeviceFragment2.A0().a(R$id.av_video_hid);
                DeviceOptionModel deviceOptionModel5 = tRingDeviceFragment2.A0().getData().get(a11);
                kotlin.jvm.internal.e.d(deviceOptionModel5, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
                DeviceOptionModel deviceOptionModel6 = deviceOptionModel5;
                tRingDeviceFragment2.C0().setHidOpen(Integer.parseInt(data));
                if (Integer.parseInt(data) == 1) {
                    deviceOptionModel6.setOptionHint(tRingDeviceFragment2.f0().getString(R$string.ring_item_hid_setting_vedio));
                } else if (Integer.parseInt(data) == 2) {
                    deviceOptionModel6.setOptionHint(tRingDeviceFragment2.f0().getString(R$string.ring_item_hid_setting_book));
                } else if (Integer.parseInt(data) == 3) {
                    deviceOptionModel6.setOptionHint(tRingDeviceFragment2.f0().getString(R$string.ring_item_hid_setting_music));
                    XXApplication xXApplication = XXApplication.f7400h;
                    com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
                    String packageName = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext().getPackageName();
                    String string = Settings.Secure.getString(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext().getContentResolver(), "enabled_notification_listeners");
                    if (string != null) {
                        kotlin.jvm.internal.e.c(packageName);
                        z5 = kotlin.text.m.c(string, packageName, false);
                    }
                    if (!z5) {
                        eh.b bVar = tRingDeviceFragment2.E;
                        ((com.example.test.ui.dialog.r) bVar.getValue()).b(R$string.str_msg_tips);
                        ((com.example.test.ui.dialog.r) bVar.getValue()).show();
                    }
                } else {
                    deviceOptionModel6.setOptionHint(tRingDeviceFragment2.f0().getString(R$string.str_ring_screen_light_0));
                }
                r1 r1Var2 = (r1) tRingDeviceFragment2.X();
                VideoHidBean data3 = tRingDeviceFragment2.C0();
                r1Var2.getClass();
                kotlin.jvm.internal.e.f(data3, "data");
                com.google.android.gms.internal.mlkit_vision_common.p.U((i1) r1Var2.f7562k.getValue());
                r1Var2.f7560i = data3;
                com.google.android.gms.internal.mlkit_vision_common.p.R(data3);
                tRingDeviceFragment2.A0().notifyItemChanged(a11);
                return;
            default:
                kotlin.jvm.internal.e.f(data, "data");
                TRingDeviceFragment tRingDeviceFragment3 = this.f8304b;
                int a12 = tRingDeviceFragment3.A0().a(R$id.av_wear_direction);
                DeviceOptionModel deviceOptionModel7 = tRingDeviceFragment3.A0().getData().get(a12);
                kotlin.jvm.internal.e.d(deviceOptionModel7, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
                DeviceOptionModel deviceOptionModel8 = deviceOptionModel7;
                Log.d("tong", "get weardirection position = " + a12);
                if (Integer.parseInt(data) == 0) {
                    deviceOptionModel8.setOptionHint(tRingDeviceFragment3.f0().getString(R$string.str_ring_direction_left));
                    ((r1) tRingDeviceFragment3.X()).n(false);
                } else {
                    deviceOptionModel8.setOptionHint(tRingDeviceFragment3.f0().getString(R$string.str_ring_direction_right));
                    ((r1) tRingDeviceFragment3.X()).n(true);
                }
                tRingDeviceFragment3.A0().notifyItemChanged(a12);
                return;
        }
    }
}
