package com.example.test.ui.main.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.blesdk.bean.function.SwitchStatusBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.presenter.main.b0;
import com.example.test.presenter.main.h0;
import com.example.test.ui.device.activity.AlarmActivity;
import com.example.test.ui.device.activity.AlarmJLActivity;
import com.example.test.ui.device.activity.BoWatcherActivity;
import com.example.test.ui.device.activity.BreatheSettingActivity;
import com.example.test.ui.device.activity.BtWatcherActivity;
import com.example.test.ui.device.activity.ContactActivity;
import com.example.test.ui.device.activity.ContactJLActivity;
import com.example.test.ui.device.activity.DeviceScanActivity;
import com.example.test.ui.device.activity.DrinkActivity;
import com.example.test.ui.device.activity.DrinkJLActivity;
import com.example.test.ui.device.activity.GameWatchAppActivity;
import com.example.test.ui.device.activity.HrWatcherActivity;
import com.example.test.ui.device.activity.HrWatcherJlActivity;
import com.example.test.ui.device.activity.LongSitActivity;
import com.example.test.ui.device.activity.LongSitJLActivity;
import com.example.test.ui.device.activity.MessagePushActivity;
import com.example.test.ui.device.activity.MoreActivity;
import com.example.test.ui.device.activity.NoDisturbActivity;
import com.example.test.ui.device.activity.OptionActivity;
import com.example.test.ui.device.activity.QrCodeManagerActivity;
import com.example.test.ui.device.activity.ScheduleActivity;
import com.example.test.ui.device.activity.ScreenLightActivity;
import com.example.test.ui.device.activity.ScreenLongActivity;
import com.example.test.ui.device.activity.TakePhotoActivity;
import com.example.test.ui.device.activity.WashHandActivity;
import com.example.test.ui.device.activity.WomenHealthActivity;
import com.example.test.ui.device.activity.WomenHealthJLActivity;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.device.model.MsgDataModel;
import com.example.test.utils.z0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.x1;
import com.google.android.gms.internal.mlkit_vision_common.p;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements s6.b, nd.b, androidx.activity.result.a, OnItemClickListener, OnItemChildClickListener, t6.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8103a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeviceFragment f8104b;

    public /* synthetic */ e(DeviceFragment deviceFragment, int i3) {
        this.f8103a = i3;
        this.f8104b = deviceFragment;
    }

    @Override // t6.e
    public void a(int i3, int i10) {
        DeviceFragment this$0 = this.f8104b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        this$0.r = i10;
        int a3 = this$0.z0().a(R$id.av_date_format);
        DeviceOptionModel deviceOptionModel = this$0.z0().getData().get(a3);
        kotlin.jvm.internal.e.d(deviceOptionModel, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
        DeviceOptionModel deviceOptionModel2 = deviceOptionModel;
        int i11 = this$0.r;
        if (i11 == 0) {
            deviceOptionModel2.setOptionHint(this$0.getString(R$string.str_ymd));
        } else if (i11 == 1) {
            deviceOptionModel2.setOptionHint(this$0.getString(R$string.str_dmy));
        } else if (i11 == 2) {
            deviceOptionModel2.setOptionHint(this$0.getString(R$string.str_mdy));
        }
        this$0.z0().notifyItemChanged(a3);
        h commonStatusCallback = (h) this$0.f8061y.getValue();
        kotlin.jvm.internal.e.f(commonStatusCallback, "commonStatusCallback");
        x5.b.I0().K0(new u5.f(commonStatusCallback));
        int i12 = this$0.r;
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -51);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", l0.j(i12, "getDateFormatWCmdJL "));
        char[] cArr = y5.b.f20001a;
        b3.g((byte) -51, new byte[]{2, 30, 0, (byte) (i12 & 255)}, new boolean[0]);
    }

    @Override // androidx.activity.result.a
    public void b(Object obj) {
        DeviceFragment this$0 = this.f8104b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        ((ActivityResult) obj).b();
    }

    @Override // s6.b
    public void c(int i3, final boolean z5) {
        s5.a g10;
        String str;
        String str2;
        String str3;
        String str4;
        final DeviceFragment this$0 = this.f8104b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (i3 == this$0.z0().a(R$id.av_weather)) {
            s5.a g11 = com.example.test.service.e.h().g();
            if (g11 != null && (str4 = g11.f18212c) != null) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (!Boolean.valueOf(z5).equals(kVar != null ? Boolean.valueOf(kVar.K(str4)) : null)) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    if (kVar2 != null) {
                        kVar2.e0(str4, z5);
                    }
                    if (z5) {
                        v2.h hVar = new v2.h(this$0.getActivity());
                        hVar.o("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
                        hVar.p(new b9.a(13));
                    }
                }
            }
        } else if (i3 == this$0.z0().a(R$id.av_take_photo)) {
            s5.a g12 = com.example.test.service.e.h().g();
            if (g12 != null && (str3 = g12.f18212c) != null) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                if (kVar3 != null) {
                    kVar3.a0(str3, z5);
                }
            }
        } else if (i3 == this$0.z0().a(R$id.av_search_device)) {
            s5.a g13 = com.example.test.service.e.h().g();
            if (g13 != null && (str2 = g13.f18212c) != null) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                if (!Boolean.valueOf(z5).equals(kVar4 != null ? Boolean.valueOf(kVar4.H(str2)) : null)) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar5 = com.example.test.utils.k.f8731b;
                    if (kVar5 != null) {
                        kVar5.O(str2, z5);
                    }
                    h commonStatusCallback = (h) this$0.f8061y.getValue();
                    kotlin.jvm.internal.e.f(commonStatusCallback, "commonStatusCallback");
                    x5.b.I0().K0(new u5.f(commonStatusCallback));
                    if (r5.b.k().f18054c) {
                        x5.c b3 = x5.c.b();
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", r5.a.d("getAntiLostCmdJL ", z5));
                        b3.g((byte) -42, new byte[]{2, 21, 0, z5 ? (byte) 1 : (byte) 0}, new boolean[0]);
                    } else {
                        x5.b.I0().F0((byte) -42);
                    }
                }
            }
        } else if (i3 == this$0.z0().a(R$id.av_incoming_call) && (g10 = com.example.test.service.e.h().g()) != null && (str = g10.f18212c) != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar6 = com.example.test.utils.k.f8731b;
            if (!Boolean.valueOf(z5).equals(kVar6 != null ? Boolean.valueOf(kVar6.I(str)) : null)) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar7 = com.example.test.utils.k.f8731b;
                if (kVar7 != null) {
                    kVar7.U(str, z5);
                }
                com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.main.fragment.DeviceFragment$setIncomingCall$1
                    @Override // oh.l
                    public final DataSetting invoke(String it) {
                        kotlin.jvm.internal.e.f(it, "it");
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar8 = com.example.test.utils.k.f8731b;
                        User d5 = kVar8 != null ? kVar8.d() : null;
                        if (d5 == null) {
                            return null;
                        }
                        SettingImpl settingImpl = SettingImpl.INSTANCE;
                        String userId = d5.getUserId();
                        String str5 = android.support.v4.media.session.e.y(userId, "getUserId(...)").f18212c;
                        kotlin.jvm.internal.e.e(str5, "getBleMac(...)");
                        return settingImpl.getData(userId, str5, "setting_message");
                    }
                }, new oh.l() { // from class: com.example.test.ui.main.fragment.DeviceFragment$setIncomingCall$2

                    public static final class a extends bc.a<List<? extends MsgDataModel>> {
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((DataSetting) obj);
                        return eh.g.f12633a;
                    }

                    public final void invoke(DataSetting dataSetting) {
                        if (dataSetting != null) {
                            boolean z6 = z5;
                            DeviceFragment deviceFragment = this$0;
                            a aVar = new a();
                            dataSetting.getDataValue();
                            List<MsgDataModel> h4 = com.example.baselibrary.utils.b.h(dataSetting.getDataValue(), aVar.f3204b);
                            kotlin.jvm.internal.e.e(h4, "fromJsonArray(...)");
                            SwitchStatusBean switchStatusBean = new SwitchStatusBean();
                            for (MsgDataModel msgDataModel : h4) {
                                switch (msgDataModel.getAppId()) {
                                    case 1:
                                        switchStatusBean.setSms(msgDataModel.isOpen());
                                        break;
                                    case 2:
                                        switchStatusBean.setQQ(msgDataModel.isOpen());
                                        break;
                                    case 3:
                                        switchStatusBean.setWeChat(msgDataModel.isOpen());
                                        break;
                                    case 4:
                                        switchStatusBean.setWhatsApp(msgDataModel.isOpen());
                                        break;
                                    case 5:
                                        switchStatusBean.setMessenger(msgDataModel.isOpen());
                                        break;
                                    case 6:
                                        switchStatusBean.setTwitter(msgDataModel.isOpen());
                                        break;
                                    case 7:
                                        switchStatusBean.setLinkedin(msgDataModel.isOpen());
                                        break;
                                    case 8:
                                        switchStatusBean.setInstagram(msgDataModel.isOpen());
                                        break;
                                    case 9:
                                        switchStatusBean.setFacebook(msgDataModel.isOpen());
                                        break;
                                    case 10:
                                        switchStatusBean.setLine(msgDataModel.isOpen());
                                        break;
                                    case 11:
                                        switchStatusBean.setWeWork(msgDataModel.isOpen());
                                        break;
                                    case 12:
                                        switchStatusBean.setDingDing(msgDataModel.isOpen());
                                        break;
                                    case 13:
                                        switchStatusBean.setEmail(msgDataModel.isOpen());
                                        break;
                                    case 14:
                                        switchStatusBean.setCalendar(msgDataModel.isOpen());
                                        break;
                                    case 15:
                                        switchStatusBean.setViber(msgDataModel.isOpen());
                                        break;
                                    case 16:
                                        switchStatusBean.setSkype(msgDataModel.isOpen());
                                        break;
                                    case 17:
                                        switchStatusBean.setKakaoTalk(msgDataModel.isOpen());
                                        break;
                                    case 18:
                                        switchStatusBean.setTumblr(msgDataModel.isOpen());
                                        break;
                                    case 19:
                                        switchStatusBean.setSnapchat(msgDataModel.isOpen());
                                        break;
                                    case 20:
                                        switchStatusBean.setYoutube(msgDataModel.isOpen());
                                        break;
                                    case 21:
                                        switchStatusBean.setPinterset(msgDataModel.isOpen());
                                        break;
                                    case 22:
                                        switchStatusBean.setTiktok(msgDataModel.isOpen());
                                        break;
                                    case 23:
                                        switchStatusBean.setGmail(msgDataModel.isOpen());
                                        break;
                                    case 24:
                                        switchStatusBean.setOther(msgDataModel.isOpen());
                                        break;
                                }
                            }
                            switchStatusBean.setPhoneCall(z6);
                            p.V((h) deviceFragment.f8061y.getValue());
                            p.H(switchStatusBean);
                        }
                    }
                });
            }
        }
        List list = this$0.e;
        DeviceOptionModel deviceOptionModel = list != null ? (DeviceOptionModel) list.get(i3) : null;
        if (deviceOptionModel == null) {
            return;
        }
        deviceOptionModel.setChecked(z5);
    }

    @Override // nd.b
    public void h(boolean z5) {
        switch (this.f8103a) {
            case 1:
                DeviceFragment this$0 = this.f8104b;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_blue_permission_tips);
                    break;
                } else {
                    this$0.f0().startActivity(new Intent(this$0.f0(), (Class<?>) DeviceScanActivity.class));
                    break;
                }
            case 2:
                DeviceFragment this$02 = this.f8104b;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                if (z5) {
                    a2.d b3 = a2.d.b();
                    this$02.f0();
                    b3.t();
                    break;
                }
                break;
            case 3:
                DeviceFragment this$03 = this.f8104b;
                kotlin.jvm.internal.e.f(this$03, "this$0");
                if (z5) {
                    a2.d b10 = a2.d.b();
                    this$03.f0();
                    b10.t();
                    break;
                }
                break;
            case 4:
                DeviceFragment this$04 = this.f8104b;
                kotlin.jvm.internal.e.f(this$04, "this$0");
                if (z5) {
                    this$04.H0(this$04.f8053p);
                    break;
                }
                break;
            case 5:
                DeviceFragment this$05 = this.f8104b;
                kotlin.jvm.internal.e.f(this$05, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_blue_permission_tips);
                    break;
                } else {
                    this$05.H0(this$05.f8054q);
                    break;
                }
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                DeviceFragment this$06 = this.f8104b;
                kotlin.jvm.internal.e.f(this$06, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_blue_permission_tips);
                    break;
                } else {
                    this$06.H0(this$06.f8054q);
                    break;
                }
            case 10:
                DeviceFragment this$07 = this.f8104b;
                kotlin.jvm.internal.e.f(this$07, "this$0");
                if (z5) {
                    this$07.H0(this$07.f8053p);
                    break;
                }
                break;
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, final int i3) {
        DeviceOptionModel deviceOptionModel;
        final DeviceFragment this$0 = this.f8104b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        if (System.currentTimeMillis() - x1.f9659a >= 1200 || System.currentTimeMillis() < x1.f9659a) {
            x1.f9659a = System.currentTimeMillis();
            if (!com.example.test.service.e.h().i() || !this$0.f8042d) {
                Toast.makeText(this$0.f0(), R$string.str_device_disconnected, 0).show();
                return;
            }
            if (i3 == this$0.z0().a(R$id.av_weather)) {
                v2.h hVar = new v2.h(this$0.getActivity());
                hVar.o("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
                final int i10 = 1;
                hVar.p(new nd.b() { // from class: com.example.test.ui.main.fragment.b
                    @Override // nd.b
                    public final void h(boolean z5) {
                        switch (i10) {
                            case 0:
                                DeviceFragment this$02 = this$0;
                                int i11 = i3;
                                kotlin.jvm.internal.e.f(this$02, "this$0");
                                if (z5) {
                                    List list = this$02.e;
                                    DeviceOptionModel deviceOptionModel2 = list != null ? (DeviceOptionModel) list.get(i11) : null;
                                    if (deviceOptionModel2 != null) {
                                        deviceOptionModel2.setEnableSwitch(true);
                                    }
                                    List list2 = this$02.e;
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
                                        kVar.a0(str, true);
                                    }
                                    this$02.z0().notifyItemChanged(i11);
                                    return;
                                }
                                return;
                            case 1:
                                DeviceFragment this$03 = this$0;
                                int i12 = i3;
                                kotlin.jvm.internal.e.f(this$03, "this$0");
                                if (z5) {
                                    List list3 = this$03.e;
                                    DeviceOptionModel deviceOptionModel4 = list3 != null ? (DeviceOptionModel) list3.get(i12) : null;
                                    if (deviceOptionModel4 != null) {
                                        deviceOptionModel4.setEnableSwitch(true);
                                    }
                                    List list4 = this$03.e;
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
                                        kVar2.e0(str2, true);
                                    }
                                    this$03.z0().notifyItemChanged(i12);
                                    z0.d().f(true);
                                    return;
                                }
                                return;
                            default:
                                DeviceFragment this$04 = this$0;
                                int i13 = i3;
                                kotlin.jvm.internal.e.f(this$04, "this$0");
                                if (z5) {
                                    List list5 = this$04.e;
                                    DeviceOptionModel deviceOptionModel6 = list5 != null ? (DeviceOptionModel) list5.get(i13) : null;
                                    if (deviceOptionModel6 != null) {
                                        deviceOptionModel6.setEnableSwitch(true);
                                    }
                                    List list6 = this$04.e;
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
                                    this$04.z0().notifyItemChanged(i13);
                                    return;
                                }
                                return;
                        }
                    }
                });
                return;
            }
            if (i3 == this$0.z0().a(R$id.av_take_photo)) {
                if (Build.VERSION.SDK_INT >= 30) {
                    v2.h hVar2 = new v2.h(this$0.getActivity());
                    hVar2.o("android.permission.CAMERA");
                    final int i11 = 2;
                    hVar2.p(new nd.b() { // from class: com.example.test.ui.main.fragment.b
                        @Override // nd.b
                        public final void h(boolean z5) {
                            switch (i11) {
                                case 0:
                                    DeviceFragment this$02 = this$0;
                                    int i112 = i3;
                                    kotlin.jvm.internal.e.f(this$02, "this$0");
                                    if (z5) {
                                        List list = this$02.e;
                                        DeviceOptionModel deviceOptionModel2 = list != null ? (DeviceOptionModel) list.get(i112) : null;
                                        if (deviceOptionModel2 != null) {
                                            deviceOptionModel2.setEnableSwitch(true);
                                        }
                                        List list2 = this$02.e;
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
                                            kVar.a0(str, true);
                                        }
                                        this$02.z0().notifyItemChanged(i112);
                                        return;
                                    }
                                    return;
                                case 1:
                                    DeviceFragment this$03 = this$0;
                                    int i12 = i3;
                                    kotlin.jvm.internal.e.f(this$03, "this$0");
                                    if (z5) {
                                        List list3 = this$03.e;
                                        DeviceOptionModel deviceOptionModel4 = list3 != null ? (DeviceOptionModel) list3.get(i12) : null;
                                        if (deviceOptionModel4 != null) {
                                            deviceOptionModel4.setEnableSwitch(true);
                                        }
                                        List list4 = this$03.e;
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
                                            kVar2.e0(str2, true);
                                        }
                                        this$03.z0().notifyItemChanged(i12);
                                        z0.d().f(true);
                                        return;
                                    }
                                    return;
                                default:
                                    DeviceFragment this$04 = this$0;
                                    int i13 = i3;
                                    kotlin.jvm.internal.e.f(this$04, "this$0");
                                    if (z5) {
                                        List list5 = this$04.e;
                                        DeviceOptionModel deviceOptionModel6 = list5 != null ? (DeviceOptionModel) list5.get(i13) : null;
                                        if (deviceOptionModel6 != null) {
                                            deviceOptionModel6.setEnableSwitch(true);
                                        }
                                        List list6 = this$04.e;
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
                                        this$04.z0().notifyItemChanged(i13);
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
                final int i12 = 0;
                hVar3.p(new nd.b() { // from class: com.example.test.ui.main.fragment.b
                    @Override // nd.b
                    public final void h(boolean z5) {
                        switch (i12) {
                            case 0:
                                DeviceFragment this$02 = this$0;
                                int i112 = i3;
                                kotlin.jvm.internal.e.f(this$02, "this$0");
                                if (z5) {
                                    List list = this$02.e;
                                    DeviceOptionModel deviceOptionModel2 = list != null ? (DeviceOptionModel) list.get(i112) : null;
                                    if (deviceOptionModel2 != null) {
                                        deviceOptionModel2.setEnableSwitch(true);
                                    }
                                    List list2 = this$02.e;
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
                                        kVar.a0(str, true);
                                    }
                                    this$02.z0().notifyItemChanged(i112);
                                    return;
                                }
                                return;
                            case 1:
                                DeviceFragment this$03 = this$0;
                                int i122 = i3;
                                kotlin.jvm.internal.e.f(this$03, "this$0");
                                if (z5) {
                                    List list3 = this$03.e;
                                    DeviceOptionModel deviceOptionModel4 = list3 != null ? (DeviceOptionModel) list3.get(i122) : null;
                                    if (deviceOptionModel4 != null) {
                                        deviceOptionModel4.setEnableSwitch(true);
                                    }
                                    List list4 = this$03.e;
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
                                        kVar2.e0(str2, true);
                                    }
                                    this$03.z0().notifyItemChanged(i122);
                                    z0.d().f(true);
                                    return;
                                }
                                return;
                            default:
                                DeviceFragment this$04 = this$0;
                                int i13 = i3;
                                kotlin.jvm.internal.e.f(this$04, "this$0");
                                if (z5) {
                                    List list5 = this$04.e;
                                    DeviceOptionModel deviceOptionModel6 = list5 != null ? (DeviceOptionModel) list5.get(i13) : null;
                                    if (deviceOptionModel6 != null) {
                                        deviceOptionModel6.setEnableSwitch(true);
                                    }
                                    List list6 = this$04.e;
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
                                    this$04.z0().notifyItemChanged(i13);
                                    return;
                                }
                                return;
                        }
                    }
                });
                return;
            }
            if (i3 == this$0.z0().a(R$id.av_search_device)) {
                List list = this$0.e;
                DeviceOptionModel deviceOptionModel2 = list != null ? (DeviceOptionModel) list.get(i3) : null;
                if (deviceOptionModel2 != null) {
                    deviceOptionModel2.setEnableSwitch(true);
                }
                List list2 = this$0.e;
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
                this$0.z0().notifyItemChanged(i3);
                return;
            }
            if (i3 == this$0.z0().a(R$id.av_incoming_call)) {
                List list3 = this$0.e;
                DeviceOptionModel deviceOptionModel3 = list3 != null ? (DeviceOptionModel) list3.get(i3) : null;
                if (deviceOptionModel3 != null) {
                    deviceOptionModel3.setEnableSwitch(true);
                }
                List list4 = this$0.e;
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
                this$0.z0().notifyItemChanged(i3);
            }
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, final int i3) {
        DeviceOptionModel deviceOptionModel;
        final int i10 = 1;
        final int i11 = 0;
        int i12 = 2;
        int i13 = 3;
        final DeviceFragment this$0 = this.f8104b;
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
        List list = this$0.e;
        if (list != null && (deviceOptionModel = (DeviceOptionModel) list.get(i3)) != null && deviceOptionModel.getId() == R$id.btn_unbind) {
            if (com.example.test.service.e.h().i()) {
                this$0.A0().b(R$string.str_device_unbind_tips);
            } else {
                this$0.A0().b(R$string.str_disconnect_unbinding_tips);
            }
            this$0.A0().setOnDialogListener(new f(this$0, i12));
            this$0.A0().show();
            return;
        }
        if (!com.example.test.service.e.h().i() || !this$0.f8042d) {
            Toast.makeText(this$0.f0(), R$string.str_device_disconnected, 0).show();
            return;
        }
        final List list2 = this$0.e;
        if (list2 != null) {
            int id2 = ((DeviceOptionModel) list2.get(i3)).getId();
            if (id2 == R$id.av_msg) {
                Context f02 = this$0.f0();
                ArrayList arrayList = new ArrayList();
                arrayList.add("android.permission.READ_PHONE_STATE");
                arrayList.add("android.permission.READ_CALL_LOG");
                arrayList.add("android.permission.READ_CONTACTS");
                arrayList.add("android.permission.ANSWER_PHONE_CALLS");
                if (nd.c.j(f02, arrayList)) {
                    this$0.startActivity(new Intent(this$0.f0(), (Class<?>) MessagePushActivity.class));
                    return;
                }
                v2.h hVar = new v2.h(this$0.getActivity());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("android.permission.READ_PHONE_STATE");
                arrayList2.add("android.permission.READ_CALL_LOG");
                arrayList2.add("android.permission.READ_CONTACTS");
                arrayList2.add("android.permission.ANSWER_PHONE_CALLS");
                hVar.n(arrayList2);
                hVar.p(new e(this$0, i12));
                return;
            }
            if (id2 == R$id.av_alarm) {
                this$0.startActivity(y5.d.f20005b ? new Intent(this$0.f0(), (Class<?>) AlarmJLActivity.class) : new Intent(this$0.f0(), (Class<?>) AlarmActivity.class));
                return;
            }
            if (id2 == R$id.av_schedule) {
                this$0.startActivity(new Intent(this$0.f0(), (Class<?>) ScheduleActivity.class));
                return;
            }
            if (id2 == R$id.av_hr_watcher) {
                this$0.startActivity(y5.d.f20005b ? new Intent(this$0.f0(), (Class<?>) HrWatcherJlActivity.class) : new Intent(this$0.f0(), (Class<?>) HrWatcherActivity.class));
                return;
            }
            if (id2 == R$id.av_long_sit) {
                this$0.startActivity(y5.d.f20005b ? new Intent(this$0.f0(), (Class<?>) LongSitJLActivity.class) : new Intent(this$0.f0(), (Class<?>) LongSitActivity.class));
                return;
            }
            if (id2 == R$id.av_screen_light) {
                this$0.startActivity(new Intent(this$0.f0(), (Class<?>) ScreenLightActivity.class));
                return;
            }
            if (id2 == R$id.av_drink) {
                this$0.startActivity(y5.d.f20005b ? new Intent(this$0.f0(), (Class<?>) DrinkJLActivity.class) : new Intent(this$0.f0(), (Class<?>) DrinkActivity.class));
                return;
            }
            if (id2 == R$id.av_wash_hand) {
                this$0.startActivity(new Intent(this$0.f0(), (Class<?>) WashHandActivity.class));
                return;
            }
            if (id2 == R$id.av_bo_watcher) {
                this$0.startActivity(new Intent(this$0.f0(), (Class<?>) BoWatcherActivity.class));
                return;
            }
            if (id2 == R$id.av_bt_watcher) {
                this$0.startActivity(new Intent(this$0.f0(), (Class<?>) BtWatcherActivity.class));
                return;
            }
            if (id2 == R$id.av_date_format) {
                ((com.example.test.ui.dialog.d) this$0.f8049l.getValue()).show();
                return;
            }
            if (id2 == R$id.av_no_disturb) {
                this$0.startActivity(new Intent(this$0.f0(), (Class<?>) NoDisturbActivity.class));
                return;
            }
            if (id2 == R$id.av_women) {
                this$0.startActivity(y5.d.f20005b ? new Intent(this$0.f0(), (Class<?>) WomenHealthJLActivity.class) : new Intent(this$0.f0(), (Class<?>) WomenHealthActivity.class));
                return;
            }
            if (id2 == R$id.av_warn_model) {
                int i14 = OptionActivity.K;
                FragmentActivity fragmentActivity = (FragmentActivity) this$0.f0();
                Intent intent = new Intent(fragmentActivity, (Class<?>) OptionActivity.class);
                intent.putExtra("option_type", 0);
                intent.putExtra("is_single", true);
                intent.putExtra("select_array", new int[]{1, 0, 0});
                fragmentActivity.startActivity(intent);
                return;
            }
            if (id2 == R$id.av_screen_long) {
                this$0.f0().startActivity(new Intent(this$0.f0(), (Class<?>) ScreenLongActivity.class));
                return;
            }
            if (id2 == R$id.av_address_book) {
                Context f03 = this$0.f0();
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add("android.permission.READ_PHONE_STATE");
                arrayList3.add("android.permission.READ_CALL_LOG");
                arrayList3.add("android.permission.READ_CONTACTS");
                arrayList3.add("android.permission.ANSWER_PHONE_CALLS");
                if (nd.c.j(f03, arrayList3)) {
                    this$0.startActivity(y5.d.f20005b ? new Intent(this$0.f0(), (Class<?>) ContactJLActivity.class) : new Intent(this$0.f0(), (Class<?>) ContactActivity.class));
                    return;
                }
                v2.h hVar2 = new v2.h(this$0.getActivity());
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add("android.permission.READ_PHONE_STATE");
                arrayList4.add("android.permission.READ_CALL_LOG");
                arrayList4.add("android.permission.READ_CONTACTS");
                arrayList4.add("android.permission.ANSWER_PHONE_CALLS");
                hVar2.n(arrayList4);
                hVar2.p(new e(this$0, i13));
                return;
            }
            if (id2 == R$id.av_take_photo) {
                if (Build.VERSION.SDK_INT >= 30) {
                    v2.h hVar3 = new v2.h(this$0.f0());
                    hVar3.o("android.permission.CAMERA");
                    hVar3.p(new nd.b() { // from class: com.example.test.ui.main.fragment.c
                        @Override // nd.b
                        public final void h(boolean z5) {
                            switch (i11) {
                                case 0:
                                    List list3 = list2;
                                    kotlin.jvm.internal.e.f(list3, "$list");
                                    DeviceFragment this$02 = this$0;
                                    kotlin.jvm.internal.e.f(this$02, "this$0");
                                    if (!((DeviceOptionModel) list3.get(i3)).isChecked()) {
                                        com.example.baselibrary.utils.d.a(R$string.str_please_open_carmer);
                                        break;
                                    } else {
                                        Intent intent2 = new Intent(this$02.f0(), (Class<?>) TakePhotoActivity.class);
                                        intent2.putExtra("isFromClickIn", true);
                                        this$02.startActivity(intent2);
                                        break;
                                    }
                                default:
                                    List list4 = list2;
                                    kotlin.jvm.internal.e.f(list4, "$list");
                                    DeviceFragment this$03 = this$0;
                                    kotlin.jvm.internal.e.f(this$03, "this$0");
                                    if (!((DeviceOptionModel) list4.get(i3)).isChecked()) {
                                        com.example.baselibrary.utils.d.a(R$string.str_please_open_carmer);
                                        break;
                                    } else {
                                        Intent intent3 = new Intent(this$03.f0(), (Class<?>) TakePhotoActivity.class);
                                        intent3.putExtra("isFromClickIn", true);
                                        this$03.startActivity(intent3);
                                        break;
                                    }
                            }
                        }
                    });
                    return;
                } else {
                    v2.h hVar4 = new v2.h(this$0.f0());
                    hVar4.o("android.permission.CAMERA");
                    hVar4.o("android.permission.WRITE_EXTERNAL_STORAGE");
                    hVar4.o("android.permission.READ_EXTERNAL_STORAGE");
                    hVar4.p(new nd.b() { // from class: com.example.test.ui.main.fragment.c
                        @Override // nd.b
                        public final void h(boolean z5) {
                            switch (i10) {
                                case 0:
                                    List list3 = list2;
                                    kotlin.jvm.internal.e.f(list3, "$list");
                                    DeviceFragment this$02 = this$0;
                                    kotlin.jvm.internal.e.f(this$02, "this$0");
                                    if (!((DeviceOptionModel) list3.get(i3)).isChecked()) {
                                        com.example.baselibrary.utils.d.a(R$string.str_please_open_carmer);
                                        break;
                                    } else {
                                        Intent intent2 = new Intent(this$02.f0(), (Class<?>) TakePhotoActivity.class);
                                        intent2.putExtra("isFromClickIn", true);
                                        this$02.startActivity(intent2);
                                        break;
                                    }
                                default:
                                    List list4 = list2;
                                    kotlin.jvm.internal.e.f(list4, "$list");
                                    DeviceFragment this$03 = this$0;
                                    kotlin.jvm.internal.e.f(this$03, "this$0");
                                    if (!((DeviceOptionModel) list4.get(i3)).isChecked()) {
                                        com.example.baselibrary.utils.d.a(R$string.str_please_open_carmer);
                                        break;
                                    } else {
                                        Intent intent3 = new Intent(this$03.f0(), (Class<?>) TakePhotoActivity.class);
                                        intent3.putExtra("isFromClickIn", true);
                                        this$03.startActivity(intent3);
                                        break;
                                    }
                            }
                        }
                    });
                    return;
                }
            }
            if (id2 == R$id.av_recover) {
                this$0.A0().b(R$string.str_device_recovery_tips);
                this$0.A0().setOnDialogListener(new f(this$0, i13));
                this$0.A0().show();
                return;
            }
            if (id2 == R$id.av_search_device) {
                p.U((b0) ((h0) this$0.X()).f7515g.getValue());
                if (y5.d.f20005b) {
                    p.c();
                    return;
                } else if (r5.b.k().f18054c) {
                    x5.d.c().j((byte) 65, new byte[0]);
                    return;
                } else {
                    x5.b.I0().F0((byte) 65);
                    return;
                }
            }
            if (id2 == R$id.btn_unbind) {
                this$0.A0().b(R$string.str_device_unbind_tips);
                this$0.A0().setOnDialogListener(new f(this$0, 4));
                this$0.A0().show();
                return;
            }
            if (id2 != R$id.av_weather) {
                if (id2 == R$id.av_breathe) {
                    this$0.startActivity(new Intent(this$0.f0(), (Class<?>) BreatheSettingActivity.class));
                    return;
                }
                if (id2 == R$id.av_qr_code) {
                    this$0.startActivity(new Intent(this$0.f0(), (Class<?>) QrCodeManagerActivity.class));
                    return;
                }
                if (id2 == R$id.av_restart) {
                    this$0.A0().b(R$string.str_device_restart_tips);
                    this$0.A0().setOnDialogListener(new f(this$0, 5));
                    this$0.A0().show();
                } else if (id2 == R$id.av_power_off) {
                    this$0.A0().b(R$string.str_device_shutdown_tips);
                    this$0.A0().setOnDialogListener(new f(this$0, 6));
                    this$0.A0().show();
                } else if (id2 == R$id.av_more) {
                    this$0.startActivity(new Intent(this$0.f0(), (Class<?>) MoreActivity.class));
                } else if (id2 == R$id.av_game_watchapp) {
                    this$0.startActivity(new Intent(this$0.f0(), (Class<?>) GameWatchAppActivity.class));
                }
            }
        }
    }
}
