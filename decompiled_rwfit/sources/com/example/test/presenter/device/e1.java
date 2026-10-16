package com.example.test.presenter.device;

import com.example.blesdk.bean.function.ScheduleBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.ScheduleActivity;
import com.example.test.ui.device.model.ScheduleModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e1 extends d implements u5.g {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7423b;

    /* renamed from: c, reason: collision with root package name */
    public int f7424c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7425d;

    public e1(ScheduleActivity scheduleActivity) {
        super(scheduleActivity);
        this.f7423b = new ArrayList();
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SchedulePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "日程错误，errorCode = "));
        ((XXBaseActivity) ((f7.w) this.f7255a)).b0();
        k(i3);
        if (this.f7425d) {
            this.f7425d = false;
            com.example.baselibrary.preseneter.b.j("", SchedulePresenter$initData$1.INSTANCE, new SchedulePresenter$initData$2(this));
        }
    }

    @Override // u5.g
    public final void c() {
        if (this.f7425d) {
            this.f7425d = false;
            com.example.baselibrary.preseneter.b.j("", SchedulePresenter$initData$1.INSTANCE, new SchedulePresenter$initData$2(this));
            return;
        }
        int i3 = this.f7424c - 1;
        this.f7424c = i3;
        if (i3 > 0) {
            return;
        }
        ((XXBaseActivity) ((f7.w) this.f7255a)).b0();
        ArrayList arrayList = this.f7423b;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SchedulePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("saveDB data = ", com.example.baselibrary.utils.b.z(arrayList)));
        com.example.baselibrary.preseneter.b.j(arrayList, new oh.l() { // from class: com.example.test.presenter.device.SchedulePresenter$saveDB$1
            @Override // oh.l
            public final Long invoke(List<ScheduleBean> it) {
                kotlin.jvm.internal.e.f(it, "it");
                DataSetting dataSetting = new DataSetting();
                dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                dataSetting.setDataKey("setting_schedule");
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
        }, new oh.l() { // from class: com.example.test.presenter.device.SchedulePresenter$saveDB$2
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
                    ((f7.w) e1.this.f7255a).getClass();
                } else {
                    ((ScheduleActivity) ((f7.w) e1.this.f7255a)).getClass();
                    com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                }
            }
        });
    }

    @Override // u5.g
    public final /* bridge */ /* synthetic */ void e(Object obj) {
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

    public final void l(ScheduleModel scheduleModel, List list, boolean z5) {
        kotlin.jvm.internal.e.f(list, "list");
        ArrayList arrayList = this.f7423b;
        arrayList.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ScheduleModel scheduleModel2 = (ScheduleModel) it.next();
            ScheduleBean scheduleBean = new ScheduleBean();
            scheduleBean.setTime(scheduleModel2.getTime());
            scheduleBean.setAdvance(scheduleModel2.getAdvance());
            scheduleBean.setAdvanceIndex(scheduleModel2.getAdvanceIndex());
            scheduleBean.setScheduleId(scheduleModel2.getScheduleId());
            scheduleBean.setTitle(scheduleModel2.getScheduleTitle());
            scheduleBean.setMessage(scheduleModel2.getScheduleMsg());
            arrayList.add(scheduleBean);
        }
        ScheduleBean scheduleBean2 = new ScheduleBean();
        scheduleBean2.setTime(scheduleModel.getTime());
        scheduleBean2.setAdvance(scheduleModel.getAdvance());
        scheduleBean2.setAdvanceIndex(scheduleModel.getAdvanceIndex());
        scheduleBean2.setScheduleId(scheduleModel.getScheduleId());
        scheduleBean2.setTitle(scheduleModel.getScheduleTitle());
        scheduleBean2.setMessage(scheduleModel.getScheduleMsg());
        if (z5) {
            com.google.android.gms.internal.mlkit_vision_common.p.a(scheduleBean2);
            return;
        }
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -79);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getScheduleWCmdJL " + com.example.baselibrary.utils.b.z(scheduleBean2));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(scheduleBean2.getTime());
        String format = new SimpleDateFormat("yy", Locale.getDefault()).format(Long.valueOf(calendar.getTimeInMillis()));
        kotlin.jvm.internal.e.e(format, "format(...)");
        int parseInt = Integer.parseInt(format);
        int i3 = calendar.get(2) + 1;
        int i10 = calendar.get(5);
        int i11 = calendar.get(11);
        int i12 = calendar.get(12);
        byte[] n4 = y5.b.n(scheduleBean2.getMessage());
        byte[] bArr = new byte[n4.length + 43];
        bArr[0] = 4;
        bArr[1] = 3;
        bArr[2] = 0;
        bArr[3] = (byte) (scheduleBean2.getScheduleId() & 255);
        bArr[4] = (byte) parseInt;
        bArr[5] = (byte) i3;
        bArr[6] = (byte) i10;
        bArr[7] = (byte) i11;
        bArr[8] = (byte) i12;
        byte[] a3 = y5.b.a(scheduleBean2.getAdvance(), 2);
        bArr[9] = a3[0];
        bArr[10] = a3[1];
        byte[] n8 = y5.b.n(scheduleBean2.getTitle());
        System.arraycopy(n8, 0, bArr, 11, n8.length <= 32 ? n8.length : 32);
        if (n4.length != 0) {
            System.arraycopy(n4, 0, bArr, 43, n4.length);
        }
        b3.g((byte) -79, bArr, new boolean[0]);
    }
}
