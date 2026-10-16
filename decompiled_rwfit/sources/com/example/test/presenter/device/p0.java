package com.example.test.presenter.device;

import com.example.blesdk.bean.function.SedentaryReminderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class p0 extends d implements v5.o {

    /* renamed from: b, reason: collision with root package name */
    public SedentaryReminderBean f7470b;

    @Override // u5.g
    public final void a(int i3) {
        ((XXBaseActivity) ((f7.p) this.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LongSitPresenter", "errorCode = " + i3);
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        ((XXBaseActivity) ((f7.p) this.f7255a)).b0();
        SedentaryReminderBean sedentaryReminderBean = this.f7470b;
        if (sedentaryReminderBean != null) {
            com.example.baselibrary.preseneter.b.j(sedentaryReminderBean, new oh.l() { // from class: com.example.test.presenter.device.LongSitPresenter$saveDB$1$1
                @Override // oh.l
                public final Long invoke(SedentaryReminderBean sedentaryReminderBean2) {
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_long_sit");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(sedentaryReminderBean2));
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
            }, new oh.l() { // from class: com.example.test.presenter.device.LongSitPresenter$saveDB$1$2
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
                        ((f7.p) p0.this.f7255a).g();
                    } else {
                        ((f7.p) p0.this.f7255a).h();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        SedentaryReminderBean sedentaryReminderBean = (SedentaryReminderBean) obj;
        if (sedentaryReminderBean != null) {
            ((f7.p) this.f7255a).n(sedentaryReminderBean);
        }
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.LongSitPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_long_sit");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.LongSitPresenter$initData$2

            public static final class a extends bc.a<SedentaryReminderBean> {
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
                    p0 p0Var = p0.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    ((f7.p) p0Var.f7255a).n((SedentaryReminderBean) g10);
                }
            }
        });
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = this;
        I0.K0(eVar);
        if (!y5.d.f20005b) {
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) 6, new byte[0]);
                return;
            } else {
                x5.b.I0().F0((byte) 6);
                return;
            }
        }
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -24);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getSedentaryRCmdJL");
        b3.g((byte) -24, new byte[]{2, 9, 16}, new boolean[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(SedentaryReminderBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        this.f7470b = data;
        ((XXBaseActivity) ((f7.p) this.f7255a)).V();
        if (!y5.d.f20005b) {
            if (!r5.b.k().f18054c) {
                x5.b.I0().F0((byte) 37);
                return;
            }
            x5.d c9 = x5.d.c();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getSedentaryCmd " + data);
            byte isOpen = data.isOpen();
            byte[] a3 = y5.b.a(data.getRemindDuration(), 2);
            c9.j((byte) 37, new byte[]{isOpen, a3[0], a3[1], y5.b.q(data.getRepeatModel()), (byte) (data.getStartHour() & 255), (byte) (data.getStartMin() & 255), (byte) (data.getEndHour() & 255), (byte) (data.getEndMin() & 255)});
            return;
        }
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -23);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getSedentaryWCmdJL " + data);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(data.isOpen() ? 1 : 0);
        sb2.append(Byte.valueOf((byte) data.getRepeatModel()[0]));
        sb2.append(Byte.valueOf((byte) data.getRepeatModel()[6]));
        sb2.append(Byte.valueOf((byte) data.getRepeatModel()[5]));
        sb2.append(Byte.valueOf((byte) data.getRepeatModel()[4]));
        sb2.append(Byte.valueOf((byte) data.getRepeatModel()[3]));
        sb2.append(Byte.valueOf((byte) data.getRepeatModel()[2]));
        sb2.append(Byte.valueOf((byte) data.getRepeatModel()[1]));
        b3.g((byte) -23, new byte[]{2, 9, 0, y5.b.b(sb2.toString()), (byte) (data.getStartHour() & 255), (byte) (data.getStartMin() & 255), (byte) (data.getEndHour() & 255), (byte) (data.getEndMin() & 255), (byte) (data.getRemindDuration() & 255)}, new boolean[0]);
    }
}
