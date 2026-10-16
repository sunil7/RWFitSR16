package com.example.test.presenter.device;

import com.example.blesdk.bean.function.AlarmRemainderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.AlarmActivity;
import com.example.test.ui.device.model.AlarmModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends d implements v5.a {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7414b;

    public c(AlarmActivity alarmActivity) {
        super(alarmActivity);
        this.f7414b = new ArrayList();
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "AlarmPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "闹钟错误，errorCode = "));
        ((XXBaseActivity) ((f7.a) this.f7255a)).b0();
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        com.example.baselibrary.preseneter.b.j(this.f7414b, new oh.l() { // from class: com.example.test.presenter.device.AlarmPresenter$saveDB$1
            @Override // oh.l
            public final Long invoke(List<AlarmRemainderBean> it) {
                kotlin.jvm.internal.e.f(it, "it");
                DataSetting dataSetting = new DataSetting();
                dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                dataSetting.setDataKey("setting_alarm");
                dataSetting.setDataValue(com.example.baselibrary.utils.b.z(it));
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    dataSetting.setUserId(d5.getUserId());
                }
                return Long.valueOf(SettingImpl.INSTANCE.saveData(dataSetting));
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.AlarmPresenter$saveDB$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return eh.g.f12633a;
            }

            public final void invoke(long j4) {
                if (j4 > 0) {
                    ((f7.a) c.this.f7255a).a();
                } else {
                    ((f7.a) c.this.f7255a).b();
                }
            }
        });
        ((XXBaseActivity) ((f7.a) this.f7255a)).b0();
    }

    @Override // u5.g
    public final void e(Object obj) {
        List<AlarmRemainderBean> list = (List) obj;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (AlarmRemainderBean alarmRemainderBean : list) {
                AlarmModel alarmModel = new AlarmModel();
                alarmModel.setAlarmTag(alarmRemainderBean.getAlarmTag());
                alarmModel.setRepeatModel(alarmRemainderBean.getRepeatModel());
                alarmModel.setStartHour(alarmRemainderBean.getStartHour());
                alarmModel.setStartMin(alarmRemainderBean.getStartMin());
                alarmModel.setOpen(alarmRemainderBean.isOpen());
                arrayList.add(alarmModel);
            }
        }
        ((f7.a) this.f7255a).d(arrayList);
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == this) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.AlarmPresenter$initData$1
            @Override // oh.l
            public final DataSetting invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 == null) {
                    return null;
                }
                SettingImpl settingImpl = SettingImpl.INSTANCE;
                String userId = d5.getUserId();
                String str = android.support.v4.media.session.e.y(userId, "getUserId(...)").f18212c;
                kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                return settingImpl.getData(userId, str, "setting_alarm");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.AlarmPresenter$initData$2

            public static final class a extends bc.a<List<? extends AlarmRemainderBean>> {
            }

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
                    c cVar = c.this;
                    List<AlarmRemainderBean> h4 = com.example.baselibrary.utils.b.h(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(h4, "fromJsonArray(...)");
                    ArrayList arrayList = new ArrayList();
                    for (AlarmRemainderBean alarmRemainderBean : h4) {
                        AlarmModel alarmModel = new AlarmModel();
                        alarmModel.setAlarmTag(alarmRemainderBean.getAlarmTag());
                        alarmModel.setRepeatModel(alarmRemainderBean.getRepeatModel());
                        alarmModel.setStartHour(alarmRemainderBean.getStartHour());
                        alarmModel.setStartMin(alarmRemainderBean.getStartMin());
                        alarmModel.setOpen(alarmRemainderBean.isOpen());
                        arrayList.add(alarmModel);
                    }
                    ((f7.a) cVar.f7255a).d(arrayList);
                }
            }
        });
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = this;
        I0.K0(eVar);
        if (r5.b.k().f18054c) {
            x5.d.c().j((byte) 9, new byte[0]);
        } else {
            x5.b.I0().F0((byte) 9);
        }
    }
}
