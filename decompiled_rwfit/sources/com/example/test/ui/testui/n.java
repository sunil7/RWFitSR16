package com.example.test.ui.testui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.table.User;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.presenter.main.l1;
import com.example.test.presenter.main.n1;
import com.example.test.presenter.main.r1;
import com.example.test.ui.device.activity.DeviceScanActivity;
import com.example.test.ui.device.activity.MoreActivity;
import com.example.test.ui.device.activity.OtaActivity;
import com.example.test.ui.device.activity.QrCodeManagerActivity;
import com.example.test.ui.device.activity.ScreenLightActivity;
import com.example.test.ui.device.activity.TakePhotoActivity;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.mine.activity.InputActivity;
import com.example.test.ui.mine.activity.RingContactActivity;
import com.example.test.ui.mine.activity.RingFeedBackActivity;
import com.example.test.ui.mine.activity.WebContentActivity;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.f2;
import com.google.android.gms.internal.mlkit_vision_barcode.m1;
import com.google.android.gms.internal.mlkit_vision_barcode.x1;
import f6.u3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements androidx.activity.result.a, nd.b, OnItemClickListener, OnItemChildClickListener, s6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8292a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TRingDeviceFragment f8293b;

    public /* synthetic */ n(TRingDeviceFragment tRingDeviceFragment, int i3) {
        this.f8292a = i3;
        this.f8293b = tRingDeviceFragment;
    }

    @Override // androidx.activity.result.a
    public void b(Object obj) {
        TRingDeviceFragment this$0 = this.f8293b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        ((ActivityResult) obj).b();
    }

    @Override // s6.b
    public void c(int i3, boolean z5) {
        s5.a g10;
        String str;
        User d5;
        String str2;
        String str3;
        TRingDeviceFragment this$0 = this.f8293b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (i3 == this$0.A0().a(R$id.av_weather)) {
            s5.a g11 = com.example.test.service.e.h().g();
            if (g11 != null && (str3 = g11.f18212c) != null) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (!Boolean.valueOf(z5).equals(kVar != null ? Boolean.valueOf(kVar.K(str3)) : null)) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    if (kVar2 != null) {
                        kVar2.e0(str3, z5);
                    }
                    if (z5) {
                        v2.h hVar = new v2.h(this$0.getActivity());
                        hVar.o("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
                        hVar.p(new b9.a(18));
                    }
                }
            }
        } else if (i3 == this$0.A0().a(R$id.av_take_photo)) {
            s5.a g12 = com.example.test.service.e.h().g();
            if (g12 != null && (str2 = g12.f18212c) != null) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                if (kVar3 != null) {
                    kVar3.a0(str2, z5);
                }
            }
        } else if (i3 == this$0.A0().a(R$id.av_low_battery)) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
            if (kVar4 != null && (d5 = kVar4.d()) != null) {
                kVar4.M(Integer.valueOf(z5 ? 1 : 0), android.support.v4.media.session.e.l(d5.getUserId(), "ring_lowbattery_select"));
            }
        } else if (i3 == this$0.A0().a(R$id.av_remember)) {
            n1 bleDataCallback = (n1) ((r1) this$0.X()).f7564m.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar5 = com.example.test.utils.k.f8731b;
            if (kVar5 != null) {
                kVar5.Z(z5 ? 1 : 0);
            }
            if (r5.b.k().f18054c) {
                x5.c b3 = x5.c.b();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "设备赞念开关切换命令");
                char[] cArr = y5.b.f20001a;
                b3.g((byte) 65, new byte[]{2, 120, 0, (byte) ((z5 ? 1 : 0) & 255)}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) 65);
            }
            Object obj = com.example.test.utils.m.f8734b;
            yh.d.b().e(new EventBusBeans.DeviceSupportEvent(d2.a().f8735a));
        } else if (i3 == this$0.A0().a(R$id.av_search_device) && (g10 = com.example.test.service.e.h().g()) != null && (str = g10.f18212c) != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar6 = com.example.test.utils.k.f8731b;
            Boolean.valueOf(z5).equals(kVar6 != null ? Boolean.valueOf(kVar6.H(str)) : null);
        }
        List list = this$0.f8220m;
        DeviceOptionModel deviceOptionModel = list != null ? (DeviceOptionModel) list.get(i3) : null;
        if (deviceOptionModel == null) {
            return;
        }
        deviceOptionModel.setChecked(z5);
    }

    @Override // nd.b
    public void h(boolean z5) {
        switch (this.f8292a) {
            case 1:
                TRingDeviceFragment this$0 = this.f8293b;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (z5) {
                    this$0.f0().startActivity(new Intent(this$0.f0(), (Class<?>) DeviceScanActivity.class));
                    return;
                } else {
                    com.example.baselibrary.utils.d.a(R$string.str_blue_permission_tips);
                    return;
                }
            case 2:
                TRingDeviceFragment this$02 = this.f8293b;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                if (z5) {
                    this$02.N0(this$02.f8231y);
                    return;
                }
                return;
            case 3:
                TRingDeviceFragment this$03 = this.f8293b;
                kotlin.jvm.internal.e.f(this$03, "this$0");
                if (z5) {
                    this$03.N0(this$03.f8232z);
                    return;
                } else {
                    com.example.baselibrary.utils.d.a(R$string.str_blue_permission_tips);
                    return;
                }
            case 4:
            case 5:
            case 6:
            default:
                TRingDeviceFragment this$04 = this.f8293b;
                kotlin.jvm.internal.e.f(this$04, "this$0");
                if (z5) {
                    a2.d b3 = a2.d.b();
                    this$04.f0();
                    b3.t();
                    return;
                }
                return;
            case 7:
                TRingDeviceFragment this$05 = this.f8293b;
                kotlin.jvm.internal.e.f(this$05, "this$0");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    String str = com.example.test.service.e.h().g().f18212c;
                    kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                    kVar.a0(str, true);
                }
                Intent intent = new Intent(this$05.f0(), (Class<?>) TakePhotoActivity.class);
                intent.putExtra("isFromClickIn", true);
                this$05.startActivity(intent);
                return;
            case 8:
                TRingDeviceFragment this$06 = this.f8293b;
                kotlin.jvm.internal.e.f(this$06, "this$0");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                if (kVar2 != null) {
                    String str2 = com.example.test.service.e.h().g().f18212c;
                    kotlin.jvm.internal.e.e(str2, "getBleMac(...)");
                    kVar2.a0(str2, true);
                }
                Intent intent2 = new Intent(this$06.f0(), (Class<?>) TakePhotoActivity.class);
                intent2.putExtra("isFromClickIn", true);
                this$06.startActivity(intent2);
                return;
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, final int i3) {
        DeviceOptionModel deviceOptionModel;
        final TRingDeviceFragment this$0 = this.f8293b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        if (System.currentTimeMillis() - x1.f9659a >= 1200 || System.currentTimeMillis() < x1.f9659a) {
            x1.f9659a = System.currentTimeMillis();
            if (!com.example.test.service.e.h().i() || !this$0.f8219l) {
                Toast.makeText(this$0.f0(), R$string.str_device_disconnected, 0).show();
                u3 u3Var = (u3) this$0.f7251b;
                if (u3Var != null) {
                    u3Var.f13380b.setLinkedStatus(0);
                    return;
                }
                return;
            }
            if (i3 == this$0.A0().a(R$id.av_weather)) {
                v2.h hVar = new v2.h(this$0.getActivity());
                hVar.o("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
                final int i10 = 0;
                hVar.p(new nd.b() { // from class: com.example.test.ui.testui.o
                    @Override // nd.b
                    public final void h(boolean z5) {
                        switch (i10) {
                            case 0:
                                TRingDeviceFragment this$02 = this$0;
                                int i11 = i3;
                                kotlin.jvm.internal.e.f(this$02, "this$0");
                                if (z5) {
                                    List list = this$02.f8220m;
                                    DeviceOptionModel deviceOptionModel2 = list != null ? (DeviceOptionModel) list.get(i11) : null;
                                    if (deviceOptionModel2 != null) {
                                        deviceOptionModel2.setEnableSwitch(true);
                                    }
                                    List list2 = this$02.f8220m;
                                    DeviceOptionModel deviceOptionModel3 = list2 != null ? (DeviceOptionModel) list2.get(i11) : null;
                                    if (deviceOptionModel3 != null) {
                                        deviceOptionModel3.setChecked(true);
                                    }
                                    if (com.example.test.utils.k.f8731b == null) {
                                        synchronized (com.example.test.utils.k.class) {
                                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                        }
                                    }
                                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                                    if (kVar != null) {
                                        String str = com.example.test.service.e.h().g().f18212c;
                                        kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                                        kVar.e0(str, true);
                                    }
                                    this$02.A0().notifyItemChanged(i11);
                                    com.example.test.utils.z0.d().f(true);
                                    return;
                                }
                                return;
                            case 1:
                                TRingDeviceFragment this$03 = this$0;
                                int i12 = i3;
                                kotlin.jvm.internal.e.f(this$03, "this$0");
                                if (z5) {
                                    List list3 = this$03.f8220m;
                                    DeviceOptionModel deviceOptionModel4 = list3 != null ? (DeviceOptionModel) list3.get(i12) : null;
                                    if (deviceOptionModel4 != null) {
                                        deviceOptionModel4.setEnableSwitch(true);
                                    }
                                    List list4 = this$03.f8220m;
                                    DeviceOptionModel deviceOptionModel5 = list4 != null ? (DeviceOptionModel) list4.get(i12) : null;
                                    if (deviceOptionModel5 != null) {
                                        deviceOptionModel5.setChecked(true);
                                    }
                                    if (com.example.test.utils.k.f8731b == null) {
                                        synchronized (com.example.test.utils.k.class) {
                                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                        }
                                    }
                                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                    if (kVar2 != null) {
                                        String str2 = com.example.test.service.e.h().g().f18212c;
                                        kotlin.jvm.internal.e.e(str2, "getBleMac(...)");
                                        kVar2.a0(str2, true);
                                    }
                                    this$03.A0().notifyItemChanged(i12);
                                    return;
                                }
                                return;
                            default:
                                TRingDeviceFragment this$04 = this$0;
                                int i13 = i3;
                                kotlin.jvm.internal.e.f(this$04, "this$0");
                                if (z5) {
                                    List list5 = this$04.f8220m;
                                    DeviceOptionModel deviceOptionModel6 = list5 != null ? (DeviceOptionModel) list5.get(i13) : null;
                                    if (deviceOptionModel6 != null) {
                                        deviceOptionModel6.setEnableSwitch(true);
                                    }
                                    List list6 = this$04.f8220m;
                                    DeviceOptionModel deviceOptionModel7 = list6 != null ? (DeviceOptionModel) list6.get(i13) : null;
                                    if (deviceOptionModel7 != null) {
                                        deviceOptionModel7.setChecked(true);
                                    }
                                    if (com.example.test.utils.k.f8731b == null) {
                                        synchronized (com.example.test.utils.k.class) {
                                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                        }
                                    }
                                    com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                                    if (kVar3 != null) {
                                        String str3 = com.example.test.service.e.h().g().f18212c;
                                        kotlin.jvm.internal.e.e(str3, "getBleMac(...)");
                                        kVar3.a0(str3, true);
                                    }
                                    this$04.A0().notifyItemChanged(i13);
                                    return;
                                }
                                return;
                        }
                    }
                });
                return;
            }
            if (i3 == this$0.A0().a(R$id.av_take_photo)) {
                if (Build.VERSION.SDK_INT >= 30) {
                    v2.h hVar2 = new v2.h(this$0.getActivity());
                    hVar2.o("android.permission.CAMERA");
                    final int i11 = 1;
                    hVar2.p(new nd.b() { // from class: com.example.test.ui.testui.o
                        @Override // nd.b
                        public final void h(boolean z5) {
                            switch (i11) {
                                case 0:
                                    TRingDeviceFragment this$02 = this$0;
                                    int i112 = i3;
                                    kotlin.jvm.internal.e.f(this$02, "this$0");
                                    if (z5) {
                                        List list = this$02.f8220m;
                                        DeviceOptionModel deviceOptionModel2 = list != null ? (DeviceOptionModel) list.get(i112) : null;
                                        if (deviceOptionModel2 != null) {
                                            deviceOptionModel2.setEnableSwitch(true);
                                        }
                                        List list2 = this$02.f8220m;
                                        DeviceOptionModel deviceOptionModel3 = list2 != null ? (DeviceOptionModel) list2.get(i112) : null;
                                        if (deviceOptionModel3 != null) {
                                            deviceOptionModel3.setChecked(true);
                                        }
                                        if (com.example.test.utils.k.f8731b == null) {
                                            synchronized (com.example.test.utils.k.class) {
                                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                            }
                                        }
                                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                                        if (kVar != null) {
                                            String str = com.example.test.service.e.h().g().f18212c;
                                            kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                                            kVar.e0(str, true);
                                        }
                                        this$02.A0().notifyItemChanged(i112);
                                        com.example.test.utils.z0.d().f(true);
                                        return;
                                    }
                                    return;
                                case 1:
                                    TRingDeviceFragment this$03 = this$0;
                                    int i12 = i3;
                                    kotlin.jvm.internal.e.f(this$03, "this$0");
                                    if (z5) {
                                        List list3 = this$03.f8220m;
                                        DeviceOptionModel deviceOptionModel4 = list3 != null ? (DeviceOptionModel) list3.get(i12) : null;
                                        if (deviceOptionModel4 != null) {
                                            deviceOptionModel4.setEnableSwitch(true);
                                        }
                                        List list4 = this$03.f8220m;
                                        DeviceOptionModel deviceOptionModel5 = list4 != null ? (DeviceOptionModel) list4.get(i12) : null;
                                        if (deviceOptionModel5 != null) {
                                            deviceOptionModel5.setChecked(true);
                                        }
                                        if (com.example.test.utils.k.f8731b == null) {
                                            synchronized (com.example.test.utils.k.class) {
                                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                            }
                                        }
                                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                        if (kVar2 != null) {
                                            String str2 = com.example.test.service.e.h().g().f18212c;
                                            kotlin.jvm.internal.e.e(str2, "getBleMac(...)");
                                            kVar2.a0(str2, true);
                                        }
                                        this$03.A0().notifyItemChanged(i12);
                                        return;
                                    }
                                    return;
                                default:
                                    TRingDeviceFragment this$04 = this$0;
                                    int i13 = i3;
                                    kotlin.jvm.internal.e.f(this$04, "this$0");
                                    if (z5) {
                                        List list5 = this$04.f8220m;
                                        DeviceOptionModel deviceOptionModel6 = list5 != null ? (DeviceOptionModel) list5.get(i13) : null;
                                        if (deviceOptionModel6 != null) {
                                            deviceOptionModel6.setEnableSwitch(true);
                                        }
                                        List list6 = this$04.f8220m;
                                        DeviceOptionModel deviceOptionModel7 = list6 != null ? (DeviceOptionModel) list6.get(i13) : null;
                                        if (deviceOptionModel7 != null) {
                                            deviceOptionModel7.setChecked(true);
                                        }
                                        if (com.example.test.utils.k.f8731b == null) {
                                            synchronized (com.example.test.utils.k.class) {
                                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                            }
                                        }
                                        com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                                        if (kVar3 != null) {
                                            String str3 = com.example.test.service.e.h().g().f18212c;
                                            kotlin.jvm.internal.e.e(str3, "getBleMac(...)");
                                            kVar3.a0(str3, true);
                                        }
                                        this$04.A0().notifyItemChanged(i13);
                                        return;
                                    }
                                    return;
                            }
                        }
                    });
                    return;
                }
                v2.h hVar3 = new v2.h(this$0.getActivity());
                ArrayList arrayList = new ArrayList();
                arrayList.add("android.permission.CAMERA");
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                hVar3.n(arrayList);
                final int i12 = 2;
                hVar3.p(new nd.b() { // from class: com.example.test.ui.testui.o
                    @Override // nd.b
                    public final void h(boolean z5) {
                        switch (i12) {
                            case 0:
                                TRingDeviceFragment this$02 = this$0;
                                int i112 = i3;
                                kotlin.jvm.internal.e.f(this$02, "this$0");
                                if (z5) {
                                    List list = this$02.f8220m;
                                    DeviceOptionModel deviceOptionModel2 = list != null ? (DeviceOptionModel) list.get(i112) : null;
                                    if (deviceOptionModel2 != null) {
                                        deviceOptionModel2.setEnableSwitch(true);
                                    }
                                    List list2 = this$02.f8220m;
                                    DeviceOptionModel deviceOptionModel3 = list2 != null ? (DeviceOptionModel) list2.get(i112) : null;
                                    if (deviceOptionModel3 != null) {
                                        deviceOptionModel3.setChecked(true);
                                    }
                                    if (com.example.test.utils.k.f8731b == null) {
                                        synchronized (com.example.test.utils.k.class) {
                                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                        }
                                    }
                                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                                    if (kVar != null) {
                                        String str = com.example.test.service.e.h().g().f18212c;
                                        kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                                        kVar.e0(str, true);
                                    }
                                    this$02.A0().notifyItemChanged(i112);
                                    com.example.test.utils.z0.d().f(true);
                                    return;
                                }
                                return;
                            case 1:
                                TRingDeviceFragment this$03 = this$0;
                                int i122 = i3;
                                kotlin.jvm.internal.e.f(this$03, "this$0");
                                if (z5) {
                                    List list3 = this$03.f8220m;
                                    DeviceOptionModel deviceOptionModel4 = list3 != null ? (DeviceOptionModel) list3.get(i122) : null;
                                    if (deviceOptionModel4 != null) {
                                        deviceOptionModel4.setEnableSwitch(true);
                                    }
                                    List list4 = this$03.f8220m;
                                    DeviceOptionModel deviceOptionModel5 = list4 != null ? (DeviceOptionModel) list4.get(i122) : null;
                                    if (deviceOptionModel5 != null) {
                                        deviceOptionModel5.setChecked(true);
                                    }
                                    if (com.example.test.utils.k.f8731b == null) {
                                        synchronized (com.example.test.utils.k.class) {
                                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                        }
                                    }
                                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                                    if (kVar2 != null) {
                                        String str2 = com.example.test.service.e.h().g().f18212c;
                                        kotlin.jvm.internal.e.e(str2, "getBleMac(...)");
                                        kVar2.a0(str2, true);
                                    }
                                    this$03.A0().notifyItemChanged(i122);
                                    return;
                                }
                                return;
                            default:
                                TRingDeviceFragment this$04 = this$0;
                                int i13 = i3;
                                kotlin.jvm.internal.e.f(this$04, "this$0");
                                if (z5) {
                                    List list5 = this$04.f8220m;
                                    DeviceOptionModel deviceOptionModel6 = list5 != null ? (DeviceOptionModel) list5.get(i13) : null;
                                    if (deviceOptionModel6 != null) {
                                        deviceOptionModel6.setEnableSwitch(true);
                                    }
                                    List list6 = this$04.f8220m;
                                    DeviceOptionModel deviceOptionModel7 = list6 != null ? (DeviceOptionModel) list6.get(i13) : null;
                                    if (deviceOptionModel7 != null) {
                                        deviceOptionModel7.setChecked(true);
                                    }
                                    if (com.example.test.utils.k.f8731b == null) {
                                        synchronized (com.example.test.utils.k.class) {
                                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                        }
                                    }
                                    com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                                    if (kVar3 != null) {
                                        String str3 = com.example.test.service.e.h().g().f18212c;
                                        kotlin.jvm.internal.e.e(str3, "getBleMac(...)");
                                        kVar3.a0(str3, true);
                                    }
                                    this$04.A0().notifyItemChanged(i13);
                                    return;
                                }
                                return;
                        }
                    }
                });
                return;
            }
            if (i3 == this$0.A0().a(R$id.av_search_device)) {
                List list = this$0.f8220m;
                DeviceOptionModel deviceOptionModel2 = list != null ? (DeviceOptionModel) list.get(i3) : null;
                if (deviceOptionModel2 != null) {
                    deviceOptionModel2.setEnableSwitch(true);
                }
                List list2 = this$0.f8220m;
                deviceOptionModel = list2 != null ? (DeviceOptionModel) list2.get(i3) : null;
                if (deviceOptionModel != null) {
                    deviceOptionModel.setChecked(true);
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    String str = com.example.test.service.e.h().g().f18212c;
                    kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                    kVar.O(str, true);
                }
                this$0.A0().notifyItemChanged(i3);
                return;
            }
            if (i3 == this$0.A0().a(R$id.av_incoming_call)) {
                List list3 = this$0.f8220m;
                DeviceOptionModel deviceOptionModel3 = list3 != null ? (DeviceOptionModel) list3.get(i3) : null;
                if (deviceOptionModel3 != null) {
                    deviceOptionModel3.setEnableSwitch(true);
                }
                List list4 = this$0.f8220m;
                deviceOptionModel = list4 != null ? (DeviceOptionModel) list4.get(i3) : null;
                if (deviceOptionModel != null) {
                    deviceOptionModel.setChecked(true);
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                if (kVar2 != null) {
                    String str2 = com.example.test.service.e.h().g().f18212c;
                    kotlin.jvm.internal.e.e(str2, "getBleMac(...)");
                    kVar2.U(str2, true);
                }
                this$0.A0().notifyItemChanged(i3);
            }
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        DeviceOptionModel deviceOptionModel;
        DeviceOptionModel deviceOptionModel2;
        DeviceOptionModel deviceOptionModel3;
        DeviceOptionModel deviceOptionModel4;
        DeviceOptionModel deviceOptionModel5;
        DeviceOptionModel deviceOptionModel6;
        Integer valueOf;
        DeviceOptionModel deviceOptionModel7;
        DeviceOptionModel deviceOptionModel8;
        int i10 = 3;
        TRingDeviceFragment this$0 = this.f8293b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        if (System.currentTimeMillis() - x1.f9659a < 1200 && System.currentTimeMillis() >= x1.f9659a) {
            if (System.currentTimeMillis() - x1.f9659a >= 1200 || System.currentTimeMillis() < x1.f9659a) {
                x1.f9659a = System.currentTimeMillis();
                return;
            }
            return;
        }
        x1.f9659a = System.currentTimeMillis();
        List list = this$0.f8220m;
        if (list != null && (deviceOptionModel8 = (DeviceOptionModel) list.get(i3)) != null && deviceOptionModel8.getId() == R$id.btn_unbind) {
            if (com.example.test.service.e.h().i()) {
                this$0.B0().b(R$string.str_device_unbind_tips);
            } else {
                this$0.B0().b(R$string.str_disconnect_unbinding_tips);
            }
            this$0.B0().setOnDialogListener(new q(this$0, i10));
            this$0.B0().show();
            return;
        }
        List list2 = this$0.f8220m;
        if (list2 == null || (deviceOptionModel7 = (DeviceOptionModel) list2.get(i3)) == null || deviceOptionModel7.getId() != R$id.av_app_unit) {
            List list3 = this$0.f8220m;
            if (list3 == null || (deviceOptionModel6 = (DeviceOptionModel) list3.get(i3)) == null || deviceOptionModel6.getId() != R$id.av_screen_light) {
                List list4 = this$0.f8220m;
                if (list4 == null || (deviceOptionModel5 = (DeviceOptionModel) list4.get(i3)) == null || deviceOptionModel5.getId() != R$id.av_app_feedback) {
                    List list5 = this$0.f8220m;
                    if (list5 == null || (deviceOptionModel4 = (DeviceOptionModel) list5.get(i3)) == null || deviceOptionModel4.getId() != R$id.av_app_theme) {
                        List list6 = this$0.f8220m;
                        if (list6 == null || (deviceOptionModel3 = (DeviceOptionModel) list6.get(i3)) == null || deviceOptionModel3.getId() != R$id.av_sleep_mode) {
                            List list7 = this$0.f8220m;
                            if (list7 == null || (deviceOptionModel2 = (DeviceOptionModel) list7.get(i3)) == null || deviceOptionModel2.getId() != R$id.av_app_family) {
                                List list8 = this$0.f8220m;
                                if (list8 != null && (deviceOptionModel = (DeviceOptionModel) list8.get(i3)) != null && deviceOptionModel.getId() == R$id.av_app_problem) {
                                    String format = String.format("https://www.ruiwo168.com/help_ring/help_%s.html", Arrays.copyOf(new Object[]{f2.d(this$0.getContext()).equals("zh-cn") ? "zh" : "en"}, 1));
                                    if (com.example.test.utils.k.f8731b == null) {
                                        synchronized (com.example.test.utils.k.class) {
                                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                        }
                                    }
                                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                                    Integer valueOf2 = kVar != null ? Integer.valueOf(kVar.D()) : null;
                                    String format2 = String.format("%s?isNew=1&type=%d", Arrays.copyOf(new Object[]{format, Integer.valueOf((valueOf2 != null && valueOf2.intValue() == 1) ? 3 : (valueOf2 != null && valueOf2.intValue() == 2) ? 2 : 1)}, 2));
                                    int i11 = WebContentActivity.H;
                                    Context f02 = this$0.f0();
                                    String string = this$0.getString(R$string.ring_item_issue_title);
                                    kotlin.jvm.internal.e.e(string, "getString(...)");
                                    com.google.android.gms.internal.mlkit_vision_barcode.r1.a(f02, string, format2);
                                }
                            } else {
                                com.example.test.utils.w0.d().getClass();
                                if (com.example.test.utils.w0.g()) {
                                    com.example.baselibrary.utils.d.a(R$string.str_family_no_login);
                                } else {
                                    this$0.startActivity(new Intent(this$0.f0(), (Class<?>) TRingFamilyActivity.class));
                                }
                            }
                        } else if (r5.b.k().f18054c) {
                            this$0.startActivity(new Intent(this$0.f0(), (Class<?>) TRingSleepModeActivity.class));
                        } else {
                            com.example.baselibrary.utils.d.a(R$string.str_device_disconnected);
                        }
                    } else {
                        this$0.startActivity(new Intent(this$0.f0(), (Class<?>) TRingThemeTypeActivity.class));
                    }
                } else {
                    Object obj = com.example.test.utils.m.f8734b;
                    SupportMenuBean supportMenuBean = d2.a().f8735a;
                    if (supportMenuBean != null ? supportMenuBean.isDefaultNoViewWorkout() : false) {
                        SupportMenuBean supportMenuBean2 = d2.a().f8735a;
                        if (supportMenuBean2 != null ? supportMenuBean2.isDefaultENSYSTEM() : false) {
                            this$0.startActivity(new Intent(this$0.f0(), (Class<?>) RingContactActivity.class));
                        }
                    }
                    this$0.startActivity(new Intent(this$0.f0(), (Class<?>) RingFeedBackActivity.class));
                }
            } else {
                this$0.startActivity(new Intent(this$0.f0(), (Class<?>) ScreenLightActivity.class));
            }
        } else {
            ((com.example.test.ui.dialog.m) this$0.f8216i.getValue()).show();
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            User d5 = kVar2 != null ? kVar2.d() : null;
            if (d5 == null || d5.getMeterUnit() != 0) {
                ((com.example.test.ui.dialog.m) this$0.f8216i.getValue()).a(1);
            } else {
                ((com.example.test.ui.dialog.m) this$0.f8216i.getValue()).a(0);
            }
        }
        if (!com.example.test.service.e.h().i() || !this$0.f8219l) {
            Toast.makeText(this$0.f0(), R$string.str_device_disconnected, 0).show();
            u3 u3Var = (u3) this$0.f7251b;
            if (u3Var != null) {
                u3Var.f13380b.setLinkedStatus(0);
                return;
            }
            return;
        }
        List list9 = this$0.f8220m;
        if (list9 != null) {
            int id2 = ((DeviceOptionModel) list9.get(i3)).getId();
            if (id2 == R$id.av_take_photo) {
                if (Build.VERSION.SDK_INT >= 30) {
                    v2.h hVar = new v2.h(this$0.f0());
                    hVar.o("android.permission.CAMERA");
                    hVar.p(new n(this$0, 7));
                    return;
                } else {
                    v2.h hVar2 = new v2.h(this$0.f0());
                    hVar2.o("android.permission.CAMERA");
                    hVar2.o("android.permission.WRITE_EXTERNAL_STORAGE");
                    hVar2.o("android.permission.READ_EXTERNAL_STORAGE");
                    hVar2.p(new n(this$0, 8));
                    return;
                }
            }
            if (id2 == R$id.av_msg) {
                ((com.example.test.ui.dialog.r) this$0.f8224q.getValue()).show();
                return;
            }
            if (id2 == R$id.av_recover) {
                ((com.example.test.ui.dialog.t) this$0.r.getValue()).setOnDialogListener(new q(this$0, 4));
                ((com.example.test.ui.dialog.t) this$0.r.getValue()).show();
                return;
            }
            if (id2 == R$id.av_search_device) {
                com.google.android.gms.internal.mlkit_vision_common.p.U((l1) ((r1) this$0.X()).f7556d.getValue());
                com.google.android.gms.internal.mlkit_vision_common.p.c();
                return;
            }
            if (id2 != R$id.btn_unbind) {
                if (id2 == R$id.av_qr_code) {
                    this$0.startActivity(new Intent(this$0.f0(), (Class<?>) QrCodeManagerActivity.class));
                    return;
                }
                if (id2 == R$id.av_alarm_reminder) {
                    this$0.startActivity(new Intent(this$0.f0(), (Class<?>) TringAlarmActivity.class));
                    return;
                }
                if (id2 == R$id.av_restart) {
                    if (!com.example.test.service.e.h().i() || !this$0.f8219l) {
                        Toast.makeText(this$0.f0(), R$string.str_device_disconnected, 0).show();
                        u3 u3Var2 = (u3) this$0.f7251b;
                        if (u3Var2 != null) {
                            u3Var2.f13380b.setLinkedStatus(0);
                            return;
                        }
                        return;
                    }
                    if (this$0.z0().getPower() < 30) {
                        Toast.makeText(this$0.f0(), R$string.str_ota_battery_limit30, 0).show();
                        return;
                    }
                    Object obj2 = com.example.test.service.p0.f7741g;
                    String downloadUrl = m1.a().d().getDownloadUrl();
                    if (downloadUrl != null && downloadUrl.length() != 0) {
                        this$0.startActivity(new Intent(this$0.f0(), (Class<?>) OtaActivity.class));
                        return;
                    }
                    Log.d("tong", "FirmUpgrade downloadUrl is null");
                    this$0.V();
                    m1.a().h(false);
                    return;
                }
                if (id2 == R$id.av_power_off) {
                    ((com.example.test.ui.dialog.t) this$0.f8223p.getValue()).setOnDialogListener(new q(this$0, 5));
                    ((com.example.test.ui.dialog.t) this$0.f8223p.getValue()).show();
                    return;
                }
                if (id2 == R$id.av_more) {
                    this$0.startActivity(new Intent(this$0.f0(), (Class<?>) MoreActivity.class));
                    return;
                }
                if (id2 != R$id.av_video_hid) {
                    if (id2 == R$id.av_set_name) {
                        int i12 = InputActivity.H;
                        Context f03 = this$0.f0();
                        Intent intent = new Intent(f03, (Class<?>) InputActivity.class);
                        intent.putExtra(AeUtil.ROOT_DATA_PATH_OLD_NAME, "smart_ring");
                        intent.putExtra("data_type", 3);
                        f03.startActivity(intent);
                        return;
                    }
                    if (id2 == R$id.av_led_light) {
                        ((com.example.test.ui.dialog.k) this$0.f8215h.getValue()).show();
                        if (this$0.u0().isOpen()) {
                            ((com.example.test.ui.dialog.k) this$0.f8215h.getValue()).a(this$0.u0().getLcdLevel());
                            return;
                        } else {
                            ((com.example.test.ui.dialog.k) this$0.f8215h.getValue()).a(0);
                            return;
                        }
                    }
                    if (id2 == R$id.av_vibration) {
                        if (r5.b.k().f18054c) {
                            this$0.startActivity(new Intent(this$0.f0(), (Class<?>) TRingVibrationActivity.class));
                            return;
                        } else {
                            com.example.baselibrary.utils.d.a(R$string.str_device_disconnected);
                            return;
                        }
                    }
                    if (id2 != R$id.av_wear_direction) {
                        if (id2 == R$id.av_health_monitor) {
                            this$0.startActivity(new Intent(this$0.f0(), (Class<?>) HealthWatcherActivity.class));
                            return;
                        }
                        return;
                    }
                    ((com.example.test.ui.dialog.o) this$0.f8217j.getValue()).show();
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                    Integer valueOf3 = kVar3 != null ? Integer.valueOf(kVar3.E()) : null;
                    if (valueOf3 != null) {
                        com.example.test.ui.dialog.o oVar = (com.example.test.ui.dialog.o) this$0.f8217j.getValue();
                        int intValue = valueOf3.intValue();
                        oVar.getClass();
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                        Integer valueOf4 = kVar4 != null ? Integer.valueOf(kVar4.D()) : null;
                        if (valueOf4 != null && valueOf4.intValue() == 0) {
                            ConstraintLayout constraintLayout = oVar.f8006g;
                            if (constraintLayout != null) {
                                constraintLayout.setBackgroundResource(R$drawable.shape_background_theme_black);
                            }
                            TextView textView = oVar.f8004d;
                            if (textView != null) {
                                textView.setTextColor(a1.d.a(oVar.getContext(), R$color.color_white));
                            }
                            TextView textView2 = oVar.e;
                            if (textView2 != null) {
                                textView2.setTextColor(a1.d.a(oVar.getContext(), R$color.color_white));
                            }
                            TextView textView3 = oVar.f8005f;
                            if (textView3 != null) {
                                textView3.setTextColor(a1.d.a(oVar.getContext(), R$color.color_white));
                            }
                        } else if (valueOf4 != null && valueOf4.intValue() == 1) {
                            ConstraintLayout constraintLayout2 = oVar.f8006g;
                            if (constraintLayout2 != null) {
                                constraintLayout2.setBackgroundResource(R$drawable.shape_background_theme_white);
                            }
                            TextView textView4 = oVar.f8004d;
                            if (textView4 != null) {
                                textView4.setTextColor(a1.d.a(oVar.getContext(), R$color.color_black));
                            }
                            TextView textView5 = oVar.e;
                            if (textView5 != null) {
                                textView5.setTextColor(a1.d.a(oVar.getContext(), R$color.color_black));
                            }
                            TextView textView6 = oVar.f8005f;
                            if (textView6 != null) {
                                textView6.setTextColor(a1.d.a(oVar.getContext(), R$color.color_black));
                            }
                        } else if (valueOf4 != null && valueOf4.intValue() == 2) {
                            ConstraintLayout constraintLayout3 = oVar.f8006g;
                            if (constraintLayout3 != null) {
                                constraintLayout3.setBackgroundResource(R$drawable.shape_background_theme_pink);
                            }
                            TextView textView7 = oVar.f8004d;
                            if (textView7 != null) {
                                textView7.setTextColor(a1.d.a(oVar.getContext(), R$color.color_black));
                            }
                            TextView textView8 = oVar.e;
                            if (textView8 != null) {
                                textView8.setTextColor(a1.d.a(oVar.getContext(), R$color.color_black));
                            }
                            TextView textView9 = oVar.f8005f;
                            if (textView9 != null) {
                                textView9.setTextColor(a1.d.a(oVar.getContext(), R$color.color_black));
                            }
                        }
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar5 = com.example.test.utils.k.f8731b;
                        valueOf = kVar5 != null ? Integer.valueOf(kVar5.D()) : null;
                        if (intValue != 0) {
                            if (intValue != 1) {
                                return;
                            }
                            if (valueOf != null && valueOf.intValue() == 0) {
                                ImageView imageView = oVar.f8002b;
                                if (imageView != null) {
                                    imageView.setImageResource(R$drawable.svg_select_no_black);
                                }
                            } else {
                                ImageView imageView2 = oVar.f8002b;
                                if (imageView2 != null) {
                                    imageView2.setImageResource(R$drawable.svg_select_no_white);
                                }
                            }
                            ImageView imageView3 = oVar.f8003c;
                            if (imageView3 != null) {
                                imageView3.setImageResource(R$mipmap.select_yes);
                                return;
                            }
                            return;
                        }
                        ImageView imageView4 = oVar.f8002b;
                        if (imageView4 != null) {
                            imageView4.setImageResource(R$mipmap.select_yes);
                        }
                        if (valueOf != null && valueOf.intValue() == 0) {
                            ImageView imageView5 = oVar.f8003c;
                            if (imageView5 != null) {
                                imageView5.setImageResource(R$drawable.svg_select_no_black);
                                return;
                            }
                            return;
                        }
                        ImageView imageView6 = oVar.f8003c;
                        if (imageView6 != null) {
                            imageView6.setImageResource(R$drawable.svg_select_no_white);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ((com.example.test.ui.dialog.n) this$0.f8218k.getValue()).show();
                com.example.test.ui.dialog.n nVar = (com.example.test.ui.dialog.n) this$0.f8218k.getValue();
                int hidOpen = this$0.C0().getHidOpen();
                nVar.getClass();
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar6 = com.example.test.utils.k.f8731b;
                Integer valueOf5 = kVar6 != null ? Integer.valueOf(kVar6.D()) : null;
                if (valueOf5 != null && valueOf5.intValue() == 0) {
                    ConstraintLayout constraintLayout4 = nVar.f8000l;
                    if (constraintLayout4 != null) {
                        constraintLayout4.setBackgroundResource(R$drawable.shape_background_theme_black);
                    }
                    TextView textView10 = nVar.f7994f;
                    if (textView10 != null) {
                        textView10.setTextColor(a1.d.a(nVar.getContext(), R$color.color_white));
                    }
                    TextView textView11 = nVar.f7995g;
                    if (textView11 != null) {
                        textView11.setTextColor(a1.d.a(nVar.getContext(), R$color.color_white));
                    }
                    TextView textView12 = nVar.f7996h;
                    if (textView12 != null) {
                        textView12.setTextColor(a1.d.a(nVar.getContext(), R$color.color_white));
                    }
                    TextView textView13 = nVar.f7997i;
                    if (textView13 != null) {
                        textView13.setTextColor(a1.d.a(nVar.getContext(), R$color.color_white));
                    }
                    TextView textView14 = nVar.f7998j;
                    if (textView14 != null) {
                        textView14.setTextColor(a1.d.a(nVar.getContext(), R$color.color_white));
                    }
                    TextView textView15 = nVar.f7999k;
                    if (textView15 != null) {
                        textView15.setTextColor(a1.d.a(nVar.getContext(), R$color.color_white));
                    }
                } else if (valueOf5 != null && valueOf5.intValue() == 1) {
                    ConstraintLayout constraintLayout5 = nVar.f8000l;
                    if (constraintLayout5 != null) {
                        constraintLayout5.setBackgroundResource(R$drawable.shape_background_theme_white);
                    }
                    TextView textView16 = nVar.f7994f;
                    if (textView16 != null) {
                        textView16.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                    TextView textView17 = nVar.f7995g;
                    if (textView17 != null) {
                        textView17.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                    TextView textView18 = nVar.f7996h;
                    if (textView18 != null) {
                        textView18.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                    TextView textView19 = nVar.f7997i;
                    if (textView19 != null) {
                        textView19.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                    TextView textView20 = nVar.f7998j;
                    if (textView20 != null) {
                        textView20.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                    TextView textView21 = nVar.f7999k;
                    if (textView21 != null) {
                        textView21.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                } else if (valueOf5 != null && valueOf5.intValue() == 2) {
                    ConstraintLayout constraintLayout6 = nVar.f8000l;
                    if (constraintLayout6 != null) {
                        constraintLayout6.setBackgroundResource(R$drawable.shape_background_theme_pink);
                    }
                    TextView textView22 = nVar.f7994f;
                    if (textView22 != null) {
                        textView22.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                    TextView textView23 = nVar.f7995g;
                    if (textView23 != null) {
                        textView23.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                    TextView textView24 = nVar.f7996h;
                    if (textView24 != null) {
                        textView24.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                    TextView textView25 = nVar.f7997i;
                    if (textView25 != null) {
                        textView25.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                    TextView textView26 = nVar.f7998j;
                    if (textView26 != null) {
                        textView26.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                    TextView textView27 = nVar.f7999k;
                    if (textView27 != null) {
                        textView27.setTextColor(a1.d.a(nVar.getContext(), R$color.color_black));
                    }
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar7 = com.example.test.utils.k.f8731b;
                valueOf = kVar7 != null ? Integer.valueOf(kVar7.D()) : null;
                if (hidOpen == 0) {
                    ImageView imageView7 = nVar.e;
                    if (imageView7 != null) {
                        imageView7.setImageResource(R$mipmap.select_yes);
                    }
                    if (valueOf != null && valueOf.intValue() == 0) {
                        ImageView imageView8 = nVar.f7991b;
                        if (imageView8 != null) {
                            imageView8.setImageResource(R$drawable.svg_select_no_black);
                        }
                        ImageView imageView9 = nVar.f7992c;
                        if (imageView9 != null) {
                            imageView9.setImageResource(R$drawable.svg_select_no_black);
                        }
                        ImageView imageView10 = nVar.f7993d;
                        if (imageView10 != null) {
                            imageView10.setImageResource(R$drawable.svg_select_no_black);
                            return;
                        }
                        return;
                    }
                    ImageView imageView11 = nVar.f7991b;
                    if (imageView11 != null) {
                        imageView11.setImageResource(R$drawable.svg_select_no_white);
                    }
                    ImageView imageView12 = nVar.f7992c;
                    if (imageView12 != null) {
                        imageView12.setImageResource(R$drawable.svg_select_no_white);
                    }
                    ImageView imageView13 = nVar.f7993d;
                    if (imageView13 != null) {
                        imageView13.setImageResource(R$drawable.svg_select_no_white);
                        return;
                    }
                    return;
                }
                if (hidOpen == 1) {
                    ImageView imageView14 = nVar.f7991b;
                    if (imageView14 != null) {
                        imageView14.setImageResource(R$mipmap.select_yes);
                    }
                    if (valueOf != null && valueOf.intValue() == 0) {
                        ImageView imageView15 = nVar.f7992c;
                        if (imageView15 != null) {
                            imageView15.setImageResource(R$drawable.svg_select_no_black);
                        }
                        ImageView imageView16 = nVar.f7993d;
                        if (imageView16 != null) {
                            imageView16.setImageResource(R$drawable.svg_select_no_black);
                        }
                        ImageView imageView17 = nVar.e;
                        if (imageView17 != null) {
                            imageView17.setImageResource(R$drawable.svg_select_no_black);
                            return;
                        }
                        return;
                    }
                    ImageView imageView18 = nVar.f7992c;
                    if (imageView18 != null) {
                        imageView18.setImageResource(R$drawable.svg_select_no_white);
                    }
                    ImageView imageView19 = nVar.f7993d;
                    if (imageView19 != null) {
                        imageView19.setImageResource(R$drawable.svg_select_no_white);
                    }
                    ImageView imageView20 = nVar.e;
                    if (imageView20 != null) {
                        imageView20.setImageResource(R$drawable.svg_select_no_white);
                        return;
                    }
                    return;
                }
                if (hidOpen == 2) {
                    ImageView imageView21 = nVar.f7992c;
                    if (imageView21 != null) {
                        imageView21.setImageResource(R$mipmap.select_yes);
                    }
                    if (valueOf != null && valueOf.intValue() == 0) {
                        ImageView imageView22 = nVar.f7991b;
                        if (imageView22 != null) {
                            imageView22.setImageResource(R$drawable.svg_select_no_black);
                        }
                        ImageView imageView23 = nVar.f7993d;
                        if (imageView23 != null) {
                            imageView23.setImageResource(R$drawable.svg_select_no_black);
                        }
                        ImageView imageView24 = nVar.e;
                        if (imageView24 != null) {
                            imageView24.setImageResource(R$drawable.svg_select_no_black);
                            return;
                        }
                        return;
                    }
                    ImageView imageView25 = nVar.f7991b;
                    if (imageView25 != null) {
                        imageView25.setImageResource(R$drawable.svg_select_no_white);
                    }
                    ImageView imageView26 = nVar.f7993d;
                    if (imageView26 != null) {
                        imageView26.setImageResource(R$drawable.svg_select_no_white);
                    }
                    ImageView imageView27 = nVar.e;
                    if (imageView27 != null) {
                        imageView27.setImageResource(R$drawable.svg_select_no_white);
                        return;
                    }
                    return;
                }
                if (hidOpen != 3) {
                    return;
                }
                ImageView imageView28 = nVar.f7993d;
                if (imageView28 != null) {
                    imageView28.setImageResource(R$mipmap.select_yes);
                }
                if (valueOf != null && valueOf.intValue() == 0) {
                    ImageView imageView29 = nVar.f7991b;
                    if (imageView29 != null) {
                        imageView29.setImageResource(R$drawable.svg_select_no_black);
                    }
                    ImageView imageView30 = nVar.f7992c;
                    if (imageView30 != null) {
                        imageView30.setImageResource(R$drawable.svg_select_no_black);
                    }
                    ImageView imageView31 = nVar.e;
                    if (imageView31 != null) {
                        imageView31.setImageResource(R$drawable.svg_select_no_black);
                        return;
                    }
                    return;
                }
                ImageView imageView32 = nVar.f7991b;
                if (imageView32 != null) {
                    imageView32.setImageResource(R$drawable.svg_select_no_white);
                }
                ImageView imageView33 = nVar.f7992c;
                if (imageView33 != null) {
                    imageView33.setImageResource(R$drawable.svg_select_no_white);
                }
                ImageView imageView34 = nVar.e;
                if (imageView34 != null) {
                    imageView34.setImageResource(R$drawable.svg_select_no_white);
                }
            }
        }
    }
}
