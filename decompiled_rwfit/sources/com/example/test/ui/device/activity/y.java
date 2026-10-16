package com.example.test.ui.device.activity;

import android.text.format.DateFormat;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dh.imagepick.ImagePickClient;
import com.example.blesdk.bean.function.ReminderModeBean;
import com.example.test.R$string;
import com.example.test.presenter.device.b1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.OptionAdapter;
import com.example.test.ui.device.model.AlarmModel;
import com.example.test.ui.device.model.BleDeviceModel;
import com.example.test.ui.device.model.OptionModel;
import com.example.test.ui.device.model.RemindModel;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class y implements nd.b, r3.a, a7.d, OnItemClickListener, t6.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7898a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XXBaseActivity f7899b;

    public /* synthetic */ y(XXBaseActivity xXBaseActivity, int i3) {
        this.f7898a = i3;
        this.f7899b = xXBaseActivity;
    }

    @Override // t6.e
    public void a(int i3, int i10) {
        ScheduleAddActivity this$0 = (ScheduleAddActivity) this.f7899b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        int i11 = ScheduleAddActivity.L;
        this$0.S0().setAdvanceIndex(i10);
        this$0.S0().setAdvance(((RemindModel) ((List) this$0.F.getValue()).get(i10)).getTimeInMinutes());
        this$0.R0();
    }

    @Override // r3.a
    public void e(int i3, int i10, int i11) {
        AlarmAddActivity this$0 = (AlarmAddActivity) this.f7899b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (DateFormat.is24HourFormat(this$0)) {
            int i12 = AlarmAddActivity.N;
            this$0.R0().setStartHour(i3);
            this$0.R0().setStartMin(i10);
            return;
        }
        int i13 = AlarmAddActivity.N;
        AlarmModel R0 = this$0.R0();
        int i14 = i10 + 1;
        if (i3 == 1) {
            if (i14 < 12) {
                i14 = i10 + 13;
            }
        } else if (i14 == 12) {
            i14 = 0;
        }
        R0.setStartHour(i14);
        this$0.R0().setStartMin(i11);
    }

    @Override // nd.b
    public void h(boolean z5) {
        int i3 = QrCodeDetailActivity.G;
        final QrCodeDetailActivity qrCodeDetailActivity = (QrCodeDetailActivity) this.f7899b;
        if (z5) {
            oh.l lVar = new oh.l() { // from class: com.example.test.ui.device.activity.QrCodeDetailActivity$onClick$3$1
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String path) {
                    kotlin.jvm.internal.e.f(path, "path");
                    QrCodeDetailActivity qrCodeDetailActivity2 = QrCodeDetailActivity.this;
                    int i10 = QrCodeDetailActivity.G;
                    ((b1) qrCodeDetailActivity2.I0()).o(path);
                }
            };
            QrCodeDetailActivity$onClick$3$2 errorBack = new oh.l() { // from class: com.example.test.ui.device.activity.QrCodeDetailActivity$onClick$3$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String error) {
                    kotlin.jvm.internal.e.f(error, "error");
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error pick ".concat(error));
                }
            };
            kotlin.jvm.internal.e.f(errorBack, "errorBack");
            com.dh.imagepick.work.c with = ImagePickClient.with(qrCodeDetailActivity);
            with.getClass();
            new f5.b(with).h(new com.example.test.utils.o(errorBack, lVar, 0));
        }
    }

    @Override // a7.d
    public void j(boolean z5) {
        XXBaseActivity xXBaseActivity = this.f7899b;
        switch (this.f7898a) {
            case 2:
                int i3 = BoWatcherActivity.I;
                BoWatcherActivity this$0 = (BoWatcherActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                this$0.S0().setOpen(z5);
                break;
            case 3:
                int i10 = BreatheSettingActivity.L;
                BreatheSettingActivity this$02 = (BreatheSettingActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                this$02.S0().setOpen(z5);
                break;
            case 4:
                int i11 = BtWatcherActivity.I;
                BtWatcherActivity this$03 = (BtWatcherActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$03, "this$0");
                this$03.S0().setOpen(z5);
                break;
            case 5:
            case 10:
            case 11:
            default:
                int i12 = WomenHealthJLActivity.K;
                WomenHealthJLActivity this$04 = (WomenHealthJLActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$04, "this$0");
                this$04.R0().setOpen(z5);
                this$04.S0();
                break;
            case 6:
                int i13 = DrinkActivity.I;
                DrinkActivity this$05 = (DrinkActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$05, "this$0");
                this$05.S0().setOpen(z5);
                break;
            case 7:
                int i14 = HrWatcherActivity.I;
                HrWatcherActivity this$06 = (HrWatcherActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$06, "this$0");
                this$06.S0().setOpen(z5);
                break;
            case 8:
                int i15 = HrWatcherJlActivity.I;
                HrWatcherJlActivity this$07 = (HrWatcherJlActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$07, "this$0");
                this$07.S0().setOpen(z5);
                break;
            case 9:
                int i16 = LongSitActivity.I;
                LongSitActivity this$08 = (LongSitActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$08, "this$0");
                this$08.S0().setOpen(z5);
                break;
            case 12:
                int i17 = ScreenLightActivity.H;
                ScreenLightActivity this$09 = (ScreenLightActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$09, "this$0");
                this$09.S0().setOpen(z5);
                break;
            case 13:
                int i18 = WomenHealthActivity.I;
                WomenHealthActivity this$010 = (WomenHealthActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$010, "this$0");
                this$010.R0().setOpen(z5);
                this$010.S0();
                break;
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        XXBaseActivity xXBaseActivity = this.f7899b;
        switch (this.f7898a) {
            case 5:
                int i10 = DeviceScanActivity.I;
                DeviceScanActivity this$0 = (DeviceScanActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
                kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
                ((com.example.test.presenter.device.u) this$0.I0()).getClass();
                com.example.test.presenter.device.u.m();
                this$0.Q0(R$string.str_device_connecting);
                s5.a aVar = new s5.a();
                aVar.f18210a = ((BleDeviceModel) this$0.S0().get(i3)).getName();
                aVar.f18212c = ((BleDeviceModel) this$0.S0().get(i3)).getMac();
                aVar.f18214f = ((BleDeviceModel) this$0.S0().get(i3)).getRawDataFlag();
                com.example.test.service.e.h().c(aVar);
                break;
            default:
                int i11 = OptionActivity.K;
                OptionActivity this$02 = (OptionActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
                kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
                boolean booleanValue = ((Boolean) this$02.F.getValue()).booleanValue();
                eh.b bVar = this$02.I;
                if (!booleanValue) {
                    ((OptionModel) this$02.T0().get(i3)).setCheck(!((OptionModel) this$02.T0().get(i3)).isCheck());
                    ((OptionAdapter) bVar.getValue()).notifyItemChanged(i3);
                    break;
                } else {
                    Iterator it = this$02.T0().iterator();
                    while (it.hasNext()) {
                        ((OptionModel) it.next()).setCheck(false);
                    }
                    ((OptionModel) this$02.T0().get(i3)).setCheck(!((OptionModel) this$02.T0().get(i3)).isCheck());
                    ((OptionAdapter) bVar.getValue()).notifyItemRangeChanged(0, this$02.T0().size());
                    if (((OptionModel) this$02.T0().get(i3)).isCheck()) {
                        ((ReminderModeBean) this$02.J.getValue()).setReminderMode(i3);
                        break;
                    }
                }
                break;
        }
    }
}
