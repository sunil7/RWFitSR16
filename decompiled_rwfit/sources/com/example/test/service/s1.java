package com.example.test.service;

import android.util.Log;
import com.example.blesdk.bean.sync.BreatheItemBean;
import com.example.blesdk.bean.sync.BreatheSyncBean;
import com.example.blesdk.bean.sync.JLSleepSyncBean;
import com.example.blesdk.bean.sync.JLStepSyncBean;
import com.example.blesdk.bean.sync.MuslimCountItemBean;
import com.example.blesdk.bean.sync.MuslimCountSyncBean;
import com.example.blesdk.bean.sync.SleepItemBean;
import com.example.blesdk.bean.sync.SleepSyncBean;
import com.example.blesdk.bean.sync.SportItemBean;
import com.example.blesdk.bean.sync.SportResultBean;
import com.example.blesdk.bean.sync.SportSyncBean;
import com.example.blesdk.bean.sync.StepFrequencyItemBean;
import com.example.blesdk.bean.sync.StepItemBean;
import com.example.blesdk.bean.sync.StepSyncBean;
import com.example.database.db.BreatheImpl;
import com.example.database.db.MuslimCountImpl;
import com.example.database.db.RawStepsImpl;
import com.example.database.db.SleepImpl;
import com.example.database.db.SportImpl;
import com.example.database.db.StepsImpl;
import com.example.database.table.DataBreathe;
import com.example.database.table.DataMuslimCount;
import com.example.database.table.DataSleep;
import com.example.database.table.DataSport;
import com.example.database.table.DataStep;
import com.example.database.table.Devices;
import com.example.database.table.RawDataSleep;
import com.example.database.table.RawDataStep;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.BoData;
import com.example.test.ui.model.chart.chart.BpData;
import com.example.test.ui.model.chart.chart.HrData;
import com.example.test.ui.model.chart.chart.MuslimItemData;
import com.example.test.ui.model.chart.chart.PressureData;
import com.example.test.ui.model.chart.chart.SleepItemData;
import com.example.test.ui.model.chart.chart.StepItemData;
import com.example.test.ui.model.chart.chart.SugarData;
import com.example.test.ui.model.chart.chart.TempData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class s1 implements u5.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f7805a;

    public s1(u1 u1Var) {
        this.f7805a = u1Var;
    }

    public final void a(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncBloodSugar$1$1

                public static final class a extends bc.a<ArrayList<SugarData>> {
                }

                /* JADX WARN: Removed duplicated region for block: B:63:0x012b  */
                /* JADX WARN: Removed duplicated region for block: B:81:0x017f  */
                /* JADX WARN: Removed duplicated region for block: B:84:0x0189  */
                /* JADX WARN: Removed duplicated region for block: B:87:0x018a A[SYNTHETIC] */
                @Override // oh.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(java.util.List<com.example.blesdk.bean.sync.BloodSugarSyncBean> r15) {
                    /*
                        Method dump skipped, instructions count: 423
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.SyncService$syncCallback$2$1$onSyncBloodSugar$1$1.invoke(java.util.List):java.lang.Boolean");
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncBloodSugar$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(9));
                }
            });
        }
    }

    public final void b(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncBo$1$1

                public static final class a extends bc.a<ArrayList<BoData>> {
                }

                /* JADX WARN: Removed duplicated region for block: B:64:0x012c  */
                /* JADX WARN: Removed duplicated region for block: B:83:0x0189  */
                /* JADX WARN: Removed duplicated region for block: B:86:0x0193  */
                /* JADX WARN: Removed duplicated region for block: B:89:0x0194 A[SYNTHETIC] */
                @Override // oh.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(java.util.List<? extends com.example.blesdk.bean.sync.BloodOxySyncBean> r17) {
                    /*
                        Method dump skipped, instructions count: 449
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.SyncService$syncCallback$2$1$onSyncBo$1$1.invoke(java.util.List):java.lang.Boolean");
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncBo$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.d("BO_DATA ", z5));
                    yh.d.b().e(new EventBusBeans.SyncEvent(3));
                }
            });
        }
    }

    public final void c(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncBp$1$1

                public static final class a extends bc.a<ArrayList<BpData>> {
                }

                /* JADX WARN: Removed duplicated region for block: B:100:0x01df  */
                /* JADX WARN: Removed duplicated region for block: B:103:0x01ee  */
                /* JADX WARN: Removed duplicated region for block: B:106:0x01f4  */
                /* JADX WARN: Removed duplicated region for block: B:109:0x01f6  */
                /* JADX WARN: Removed duplicated region for block: B:71:0x015a  */
                /* JADX WARN: Removed duplicated region for block: B:98:0x01d9  */
                @Override // oh.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(java.util.List<? extends com.example.blesdk.bean.sync.BloodPressSyncBean> r19) {
                    /*
                        Method dump skipped, instructions count: 530
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.SyncService$syncCallback$2$1$onSyncBp$1$1.invoke(java.util.List):java.lang.Boolean");
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncBp$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(2));
                }
            });
        }
    }

    public final void d(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncBreath$1$1
                @Override // oh.l
                public final Boolean invoke(List<? extends BreatheSyncBean> list2) {
                    String str;
                    Devices c9;
                    User d5;
                    ArrayList t8 = android.support.v4.media.session.e.t("breatheSyncBeans", list2);
                    for (BreatheSyncBean breatheSyncBean : list2) {
                        DataBreathe dataBreathe = new DataBreathe();
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null && (d5 = kVar.d()) != null) {
                            dataBreathe.setUserId(d5.getUserId());
                        }
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        if (kVar2 != null && (c9 = kVar2.c()) != null) {
                            dataBreathe.setMac(c9.getMacAddress());
                        }
                        dataBreathe.setTimestamp(String.valueOf(breatheSyncBean.getTime()));
                        long time = breatheSyncBean.getTime() * 1000;
                        try {
                            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                            str = null;
                        }
                        dataBreathe.setDate(str);
                        int i3 = 0;
                        dataBreathe.setIsUpdate(false);
                        List<BreatheItemBean> items = breatheSyncBean.getItems();
                        if (items != null) {
                            Iterator<T> it = items.iterator();
                            while (it.hasNext()) {
                                i3 += ((BreatheItemBean) it.next()).getTimeLen();
                            }
                        }
                        dataBreathe.setTotalTime(Integer.valueOf(i3));
                        dataBreathe.setItems(com.example.baselibrary.utils.b.z(breatheSyncBean.getItems()));
                        t8.add(dataBreathe);
                    }
                    return Boolean.valueOf(BreatheImpl.INSTANCE.saveDatas(t8));
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncBreath$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(7));
                }
            });
        }
    }

    public final void e(int i3) {
        u1 u1Var = this.f7805a;
        u1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "同步失败" + i3);
        com.example.baselibrary.utils.d.a(R$string.str_syncing_fail);
        u1Var.f7814c = true;
        u1Var.f7826p = false;
        u1Var.f7827q = false;
        u1Var.b().removeCallbacksAndMessages(null);
        try {
            com.example.test.ui.dialog.h hVar = u1Var.f7812a;
            if (hVar != null) {
                hVar.dismiss();
            }
        } catch (Throwable th2) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("弹出消失异常：", th2.getMessage()));
        }
    }

    public final void f() {
        u1 u1Var = this.f7805a;
        u1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(u1Var.f7813b, "onSyncFinish "));
        u1Var.f7813b = 100;
        u1Var.f();
        yh.d.b().e(new EventBusBeans.SyncStatusEvent(1));
        u1Var.f7826p = false;
        u1Var.f7827q = false;
    }

    public final void g(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncHr$1$1

                public static final class a extends bc.a<ArrayList<HrData>> {
                }

                /* JADX WARN: Removed duplicated region for block: B:63:0x0129  */
                /* JADX WARN: Removed duplicated region for block: B:83:0x018c A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:91:0x017f A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:94:0x017c  */
                @Override // oh.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(java.util.List<com.example.blesdk.bean.sync.HeartRateSyncBean> r17) {
                    /*
                        Method dump skipped, instructions count: 435
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.SyncService$syncCallback$2$1$onSyncHr$1$1.invoke(java.util.List):java.lang.Boolean");
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncHr$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(1));
                }
            });
        }
    }

    public final void h(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncHrv$1$1

                public static final class a extends bc.a<ArrayList<HrData>> {
                }

                /* JADX WARN: Removed duplicated region for block: B:63:0x0126  */
                /* JADX WARN: Removed duplicated region for block: B:80:0x0176  */
                /* JADX WARN: Removed duplicated region for block: B:82:0x017d  */
                /* JADX WARN: Removed duplicated region for block: B:85:0x017e A[SYNTHETIC] */
                @Override // oh.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(java.util.List<com.example.blesdk.bean.sync.HrvSyncBean> r15) {
                    /*
                        Method dump skipped, instructions count: 411
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.SyncService$syncCallback$2$1$onSyncHrv$1$1.invoke(java.util.List):java.lang.Boolean");
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncHrv$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(13));
                }
            });
        }
    }

    public final void i(List list) {
        if (list != null) {
            final u1 u1Var = this.f7805a;
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncJLSleep$1$1
                {
                    super(1);
                }

                @Override // oh.l
                public final Boolean invoke(List<? extends JLSleepSyncBean> list2) {
                    int i3;
                    int i10;
                    boolean z5;
                    int i11;
                    HashMap hashMap;
                    int i12;
                    Object obj;
                    Object obj2;
                    char c9;
                    Devices c10;
                    User d5;
                    String str;
                    Devices c11;
                    User d8;
                    int i13 = 60;
                    int i14 = 1;
                    ArrayList t8 = android.support.v4.media.session.e.t("list", list2);
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = list2.iterator();
                    RawDataSleep rawDataSleep = null;
                    while (true) {
                        i3 = 34;
                        i10 = 17;
                        z5 = false;
                        int i15 = 0;
                        if (!it.hasNext()) {
                            break;
                        }
                        JLSleepSyncBean jLSleepSyncBean = (JLSleepSyncBean) it.next();
                        RawDataSleep rawDataSleep2 = new RawDataSleep();
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null && (d8 = kVar.d()) != null) {
                            rawDataSleep2.setUserId(d8.getUserId());
                        }
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        if (kVar2 != null && (c11 = kVar2.c()) != null) {
                            rawDataSleep2.setMac(c11.getMacAddress());
                        }
                        rawDataSleep2.setIsUpdate(false);
                        rawDataSleep2.setTimestamp(jLSleepSyncBean.getTime());
                        RawDataSleep rawDataSleep3 = rawDataSleep;
                        long time = jLSleepSyncBean.getTime() * 1000;
                        try {
                            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                            str = null;
                        }
                        rawDataSleep2.setDate(str);
                        rawDataSleep2.setSleepModel(jLSleepSyncBean.getSleepModel());
                        if (rawDataSleep2.getSleepModel() == 17) {
                            arrayList.clear();
                            rawDataSleep = rawDataSleep2;
                        } else {
                            if (rawDataSleep2.getSleepModel() == 34 && rawDataSleep3 != null) {
                                int size = arrayList.size();
                                while (i15 < size) {
                                    Object obj3 = arrayList.get(i15);
                                    i15++;
                                    RawDataSleep rawDataSleep4 = (RawDataSleep) obj3;
                                    if (rawDataSleep4.getTimestamp() >= rawDataSleep3.getTimestamp() && rawDataSleep4.getTimestamp() < rawDataSleep2.getTimestamp()) {
                                        rawDataSleep4.setDate(rawDataSleep2.getDate());
                                    }
                                }
                            }
                            rawDataSleep = rawDataSleep3;
                        }
                        t8.add(rawDataSleep2);
                        arrayList.add(rawDataSleep2);
                    }
                    SleepImpl sleepImpl = SleepImpl.INSTANCE;
                    u1 u1Var2 = u1.this;
                    Object obj4 = u1.f7811u;
                    u1Var2.getClass();
                    ArrayList arrayList2 = new ArrayList();
                    if (!t8.isEmpty()) {
                        HashMap a3 = y5.e.a("date", t8);
                        for (String str2 : a3.keySet()) {
                            DataSleep dataSleep = new DataSleep();
                            List<RawDataSleep> list3 = (List) a3.get(str2);
                            ArrayList arrayList3 = new ArrayList();
                            if (list3 != null) {
                                int i16 = z5 ? 1 : 0;
                                for (RawDataSleep rawDataSleep5 : list3) {
                                    int i17 = i14;
                                    if (rawDataSleep5.getSleepModel() == i10) {
                                        arrayList3.clear();
                                        arrayList3.add(rawDataSleep5);
                                        i14 = i17;
                                        i16 = i14;
                                    } else {
                                        if (i16 != 0) {
                                            arrayList3.add(rawDataSleep5);
                                            if (rawDataSleep5.getSleepModel() == i3) {
                                                i16 = z5 ? 1 : 0;
                                            }
                                        }
                                        i14 = i17;
                                    }
                                }
                            }
                            int i18 = i14;
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncService", "最后一段起始与结束的睡眠数据: " + arrayList3);
                            if (arrayList3.size() < 3) {
                                i14 = i18;
                            } else {
                                if (arrayList3.isEmpty()) {
                                    i11 = i13;
                                    hashMap = a3;
                                    i12 = i10;
                                } else {
                                    if (com.example.test.utils.k.f8731b == null) {
                                        synchronized (com.example.test.utils.k.class) {
                                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                        }
                                    }
                                    com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                                    if (kVar3 != null && (d5 = kVar3.d()) != null) {
                                        dataSleep.setUserId(d5.getUserId());
                                    }
                                    if (com.example.test.utils.k.f8731b == null) {
                                        synchronized (com.example.test.utils.k.class) {
                                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                        }
                                    }
                                    com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                                    if (kVar4 != null && (c10 = kVar4.c()) != null) {
                                        dataSleep.setMac(c10.getMacAddress());
                                    }
                                    dataSleep.setIsUpdate(z5);
                                    int size2 = arrayList3.size();
                                    int i19 = z5 ? 1 : 0;
                                    while (true) {
                                        if (i19 >= size2) {
                                            obj = null;
                                            break;
                                        }
                                        obj = arrayList3.get(i19);
                                        i19++;
                                        if (((RawDataSleep) obj).getSleepModel() == i10) {
                                            break;
                                        }
                                    }
                                    RawDataSleep rawDataSleep6 = (RawDataSleep) obj;
                                    int size3 = arrayList3.size();
                                    int i20 = 0;
                                    while (true) {
                                        if (i20 >= size3) {
                                            obj2 = null;
                                            break;
                                        }
                                        obj2 = arrayList3.get(i20);
                                        i20++;
                                        if (((RawDataSleep) obj2).getSleepModel() == i3) {
                                            break;
                                        }
                                    }
                                    RawDataSleep rawDataSleep7 = (RawDataSleep) obj2;
                                    if (rawDataSleep6 != null && rawDataSleep7 != null) {
                                        dataSleep.setAsleepTime(rawDataSleep6.getTimestamp());
                                        dataSleep.setWakeupTime(rawDataSleep7.getTimestamp());
                                        dataSleep.setTimestamp(String.valueOf(rawDataSleep7.getTimestamp()));
                                        dataSleep.setTotalSleepTime((rawDataSleep7.getTimestamp() - rawDataSleep6.getTimestamp()) / i13);
                                    }
                                    ArrayList arrayList4 = new ArrayList();
                                    int size4 = arrayList3.size() - 1;
                                    i11 = i13;
                                    int i21 = 0;
                                    int i22 = 0;
                                    int i23 = 0;
                                    int i24 = 0;
                                    int i25 = 0;
                                    while (i23 < size4) {
                                        int i26 = i23 + 1;
                                        RawDataSleep rawDataSleep8 = (RawDataSleep) arrayList3.get(i26);
                                        RawDataSleep rawDataSleep9 = (RawDataSleep) arrayList3.get(i23);
                                        HashMap hashMap2 = a3;
                                        SleepItemData sleepItemData = new SleepItemData();
                                        int i27 = size4;
                                        int timestamp = (int) (rawDataSleep8.getTimestamp() - rawDataSleep9.getTimestamp());
                                        sleepItemData.setDuration(timestamp / 60);
                                        sleepItemData.setDurationPercent(sleepItemData.getDuration() / dataSleep.getTotalSleepTime());
                                        int sleepModel = rawDataSleep9.getSleepModel();
                                        int i28 = i18;
                                        if (sleepModel == i28) {
                                            sleepItemData.setSleepType(2);
                                            i25 += timestamp;
                                        } else if (sleepModel == 2) {
                                            sleepItemData.setSleepType(i28);
                                            i21 += timestamp;
                                        } else {
                                            if (sleepModel == 3) {
                                                sleepItemData.setSleepType(0);
                                            } else if (sleepModel == 0) {
                                                sleepItemData.setSleepType(0);
                                            } else {
                                                if (sleepModel == 17) {
                                                    sleepItemData.setSleepType(1);
                                                    i21 += timestamp;
                                                } else if (sleepModel == 4) {
                                                    c9 = 3;
                                                    sleepItemData.setSleepType(3);
                                                    i22 += timestamp;
                                                    arrayList4.add(sleepItemData);
                                                    i23 = i26;
                                                    size4 = i27;
                                                    a3 = hashMap2;
                                                    i18 = 1;
                                                }
                                                c9 = 3;
                                                arrayList4.add(sleepItemData);
                                                i23 = i26;
                                                size4 = i27;
                                                a3 = hashMap2;
                                                i18 = 1;
                                            }
                                            i24 += timestamp;
                                        }
                                        c9 = 3;
                                        arrayList4.add(sleepItemData);
                                        i23 = i26;
                                        size4 = i27;
                                        a3 = hashMap2;
                                        i18 = 1;
                                    }
                                    hashMap = a3;
                                    i12 = 17;
                                    dataSleep.setWakeupCount(i24 / 60);
                                    dataSleep.setSleepDeepTime(i25 / 60);
                                    dataSleep.setSleepLightTime(i21 / 60);
                                    dataSleep.setSleepRapidTime(i22 / 60);
                                    dataSleep.setDate(str2);
                                    dataSleep.setItems(com.example.baselibrary.utils.b.z(arrayList4));
                                }
                                arrayList2.add(dataSleep);
                                i10 = i12;
                                i13 = i11;
                                a3 = hashMap;
                                i14 = 1;
                                i3 = 34;
                                z5 = false;
                            }
                        }
                    }
                    return Boolean.valueOf(sleepImpl.saveDatas(arrayList2));
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncJLSleep$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(4));
                }
            });
        }
    }

    public final void j(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncJLStep$1$1
                @Override // oh.l
                public final Boolean invoke(List<? extends JLStepSyncBean> list2) {
                    String str;
                    User d5;
                    Devices c9;
                    ArrayList t8 = android.support.v4.media.session.e.t("stepSyncList", list2);
                    for (JLStepSyncBean jLStepSyncBean : list2) {
                        RawDataStep rawDataStep = new RawDataStep();
                        rawDataStep.setCalorie(jLStepSyncBean.getCalorie());
                        rawDataStep.setDistance(jLStepSyncBean.getDistance());
                        rawDataStep.setStep(jLStepSyncBean.getSteps());
                        rawDataStep.setTimestamp(jLStepSyncBean.getTime());
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(jLStepSyncBean.getTime() * 1000);
                        calendar.set(11, 0);
                        calendar.set(12, 0);
                        calendar.set(13, 0);
                        calendar.set(14, 0);
                        long timeInMillis = calendar.getTimeInMillis();
                        try {
                            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                            str = null;
                        }
                        rawDataStep.setDate(str);
                        rawDataStep.setHour(jLStepSyncBean.getHour());
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null && (c9 = kVar.c()) != null) {
                            rawDataStep.setMac(c9.getMacAddress());
                        }
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        if (kVar2 != null && (d5 = kVar2.d()) != null) {
                            rawDataStep.setUserId(d5.getUserId());
                        }
                        rawDataStep.setIsUpdate(false);
                        t8.add(rawDataStep);
                    }
                    return Boolean.valueOf(RawStepsImpl.INSTANCE.saveSteps(t8));
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncJLStep$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(0));
                }
            });
        }
    }

    public final void k(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncMuslimCount$1$1

                public static final class a extends bc.a<ArrayList<MuslimItemData>> {
                }

                @Override // oh.l
                public final Boolean invoke(List<MuslimCountSyncBean> list2) {
                    String str;
                    Devices c9;
                    User d5;
                    ArrayList t8 = android.support.v4.media.session.e.t("countSyncBeans", list2);
                    for (MuslimCountSyncBean muslimCountSyncBean : list2) {
                        DataMuslimCount dataMuslimCount = new DataMuslimCount();
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null && (d5 = kVar.d()) != null) {
                            dataMuslimCount.setUserId(d5.getUserId());
                        }
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        if (kVar2 != null && (c9 = kVar2.c()) != null) {
                            dataMuslimCount.setMac(c9.getMacAddress());
                        }
                        dataMuslimCount.setIsUpdate(false);
                        dataMuslimCount.setTimestamp(String.valueOf(muslimCountSyncBean.getTime()));
                        long time = muslimCountSyncBean.getTime() * 1000;
                        try {
                            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                            str = null;
                        }
                        dataMuslimCount.setDate(str);
                        ArrayList arrayList = new ArrayList();
                        MuslimCountImpl muslimCountImpl = MuslimCountImpl.INSTANCE;
                        String mac = dataMuslimCount.getMac();
                        String userId = dataMuslimCount.getUserId();
                        kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                        String date = dataMuslimCount.getDate();
                        kotlin.jvm.internal.e.e(date, "getDate(...)");
                        DataMuslimCount dataByDate = muslimCountImpl.getDataByDate(mac, userId, date);
                        if (dataByDate != null) {
                            List h4 = com.example.baselibrary.utils.b.h(dataByDate.getItems(), new a().f3204b);
                            kotlin.jvm.internal.e.c(h4);
                            arrayList.addAll(h4);
                        }
                        if (arrayList.size() < 24) {
                            arrayList.clear();
                            for (int i3 = 0; i3 < 24; i3++) {
                                arrayList.add(new MuslimItemData(i3, 0));
                            }
                        }
                        if (dataByDate != null && dataByDate.getTotalCount() > muslimCountSyncBean.getTotalCount()) {
                            arrayList.clear();
                            for (int i10 = 0; i10 < 24; i10++) {
                                arrayList.add(new MuslimItemData(i10, 0));
                            }
                        }
                        List<MuslimCountItemBean> items = muslimCountSyncBean.getItems();
                        kotlin.jvm.internal.e.e(items, "getItems(...)");
                        MuslimCountItemBean muslimCountItemBean = (MuslimCountItemBean) kotlin.collections.h.n(items);
                        String hour = muslimCountItemBean.getHour();
                        kotlin.jvm.internal.e.e(hour, "getHour(...)");
                        int parseInt = Integer.parseInt(hour);
                        int count = muslimCountItemBean.getCount();
                        int i11 = 0;
                        for (int i12 = 0; i12 < parseInt; i12++) {
                            i11 += ((MuslimItemData) arrayList.get(i12)).getCount();
                        }
                        if (i11 > count) {
                            arrayList.clear();
                            for (int i13 = 0; i13 < 24; i13++) {
                                arrayList.add(new MuslimItemData(i13, 0));
                            }
                            i11 = 0;
                        }
                        List<MuslimCountItemBean> items2 = muslimCountSyncBean.getItems();
                        if (items2 != null) {
                            for (MuslimCountItemBean muslimCountItemBean2 : items2) {
                                String hour2 = muslimCountItemBean2.getHour();
                                kotlin.jvm.internal.e.e(hour2, "getHour(...)");
                                int parseInt2 = Integer.parseInt(hour2);
                                int count2 = muslimCountItemBean2.getCount();
                                int i14 = count2 - i11;
                                if (i14 >= 0) {
                                    arrayList.set(parseInt2, new MuslimItemData(parseInt2, i14));
                                } else {
                                    arrayList.set(parseInt2, new MuslimItemData(parseInt2, count2));
                                }
                                i11 = count2;
                            }
                        }
                        dataMuslimCount.setMinCount(9999999);
                        dataMuslimCount.setMaxCount(0);
                        int size = arrayList.size();
                        int i15 = 0;
                        while (i15 < size) {
                            Object obj = arrayList.get(i15);
                            i15++;
                            MuslimItemData muslimItemData = (MuslimItemData) obj;
                            if (muslimItemData.getCount() > 0) {
                                if (muslimItemData.getCount() > dataMuslimCount.getMaxCount()) {
                                    dataMuslimCount.setMaxCount(muslimItemData.getCount());
                                }
                                if (muslimItemData.getCount() < dataMuslimCount.getMinCount()) {
                                    dataMuslimCount.setMinCount(muslimItemData.getCount());
                                }
                            }
                        }
                        if (dataMuslimCount.getMinCount() == 9999999) {
                            dataMuslimCount.setMinCount(0);
                        }
                        dataMuslimCount.setAvgCount((dataMuslimCount.getMaxCount() + dataMuslimCount.getMinCount()) / 2);
                        dataMuslimCount.setTotalCount(muslimCountSyncBean.getTotalCount());
                        dataMuslimCount.setItems(com.example.baselibrary.utils.b.z(arrayList));
                        t8.add(dataMuslimCount);
                    }
                    return Boolean.valueOf(MuslimCountImpl.INSTANCE.saveDatas(t8));
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncMuslimCount$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(10));
                }
            });
        }
    }

    public final void l(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncPressure$1$1

                public static final class a extends bc.a<ArrayList<PressureData>> {
                }

                /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
                /* JADX WARN: Removed duplicated region for block: B:81:0x0185  */
                /* JADX WARN: Removed duplicated region for block: B:84:0x018f  */
                /* JADX WARN: Removed duplicated region for block: B:87:0x0190 A[SYNTHETIC] */
                @Override // oh.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(java.util.List<com.example.blesdk.bean.sync.PressureSyncBean> r17) {
                    /*
                        Method dump skipped, instructions count: 445
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.SyncService$syncCallback$2$1$onSyncPressure$1$1.invoke(java.util.List):java.lang.Boolean");
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncPressure$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.d("PRESSURE_DATA ", z5));
                    yh.d.b().e(new EventBusBeans.SyncEvent(6));
                }
            });
        }
    }

    public final void m(int i3) {
        u1 u1Var = this.f7805a;
        if (i3 < u1Var.f7813b) {
            u1Var.b().removeCallbacksAndMessages(null);
        }
        u1Var.f7813b = i3;
        if (i3 != 100) {
            u1Var.f();
        }
    }

    public final void n(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncSleep$1$1
                @Override // oh.l
                public final Boolean invoke(List<? extends SleepSyncBean> list2) {
                    String str;
                    Iterator it;
                    long j4;
                    long j10;
                    Devices c9;
                    User d5;
                    ArrayList t8 = android.support.v4.media.session.e.t("list", list2);
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        SleepSyncBean sleepSyncBean = (SleepSyncBean) it2.next();
                        DataSleep dataSleep = new DataSleep();
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null && (d5 = kVar.d()) != null) {
                            dataSleep.setUserId(d5.getUserId());
                        }
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        if (kVar2 != null && (c9 = kVar2.c()) != null) {
                            dataSleep.setMac(c9.getMacAddress());
                        }
                        int i3 = 0;
                        dataSleep.setIsUpdate(false);
                        dataSleep.setTotalSleepTime(sleepSyncBean.getTotalSleepTime());
                        dataSleep.setTimestamp(String.valueOf(sleepSyncBean.getTime()));
                        long time = sleepSyncBean.getTime() * 1000;
                        try {
                            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time, " date translate error ", e.getMessage()));
                            str = null;
                        }
                        dataSleep.setDate(str);
                        dataSleep.setAsleepTime(sleepSyncBean.getAsleepTime());
                        dataSleep.setWakeupTime(sleepSyncBean.getAwakeTime());
                        ArrayList arrayList = new ArrayList();
                        List<SleepItemBean> items = sleepSyncBean.getItems();
                        long j11 = 0;
                        if (items != null) {
                            long j12 = 0;
                            j10 = 0;
                            for (SleepItemBean sleepItemBean : items) {
                                SleepItemData sleepItemData = new SleepItemData();
                                sleepItemData.setSleepType(sleepItemBean.getSleepType());
                                sleepItemData.setDuration(sleepItemBean.getLen());
                                Iterator it3 = it2;
                                SleepSyncBean sleepSyncBean2 = sleepSyncBean;
                                sleepItemData.setDurationPercent((sleepItemBean.getLen() * 60.0d) / sleepSyncBean2.getTotalSleepTime());
                                arrayList.add(sleepItemData);
                                int sleepType = sleepItemBean.getSleepType();
                                if (sleepType == 0) {
                                    i3++;
                                    sleepItemBean.getLen();
                                } else if (sleepType == 1) {
                                    j12 += sleepItemBean.getLen();
                                } else if (sleepType == 2) {
                                    j11 += sleepItemBean.getLen();
                                } else if (sleepType == 3) {
                                    j10 += sleepItemBean.getLen();
                                }
                                it2 = it3;
                                sleepSyncBean = sleepSyncBean2;
                            }
                            it = it2;
                            j4 = j11;
                            j11 = j12;
                        } else {
                            it = it2;
                            j4 = 0;
                            j10 = 0;
                        }
                        dataSleep.setSleepLightTime(j11);
                        dataSleep.setSleepDeepTime(j4);
                        dataSleep.setWakeupCount(i3);
                        dataSleep.setSleepRapidTime(j10);
                        dataSleep.setItems(com.example.baselibrary.utils.b.z(arrayList));
                        t8.add(dataSleep);
                        it2 = it;
                    }
                    return Boolean.valueOf(SleepImpl.INSTANCE.saveDatas(t8));
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncSleep$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(4));
                }
            });
        }
    }

    public final void o(SportSyncBean sportSyncBean) {
        if (sportSyncBean != null) {
            if (y5.d.f20005b) {
                com.example.baselibrary.utils.b.x(sportSyncBean.getResultItems(), new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncSport$1$1
                    @Override // oh.l
                    public final Boolean invoke(List<SportResultBean> list) {
                        String str;
                        Devices c9;
                        User d5;
                        ArrayList arrayList = new ArrayList();
                        kotlin.jvm.internal.e.c(list);
                        for (SportResultBean sportResultBean : list) {
                            DataSport dataSport = new DataSport();
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                            if (kVar != null && (d5 = kVar.d()) != null) {
                                dataSport.setUserId(d5.getUserId());
                            }
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            if (kVar2 != null && (c9 = kVar2.c()) != null) {
                                dataSport.setMac(c9.getMacAddress());
                            }
                            dataSport.setIsUpdate(false);
                            dataSport.setTimestamp(String.valueOf(sportResultBean.getStartTime()));
                            long startTime = sportResultBean.getStartTime() * 1000;
                            try {
                                str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(startTime));
                            } catch (Exception e) {
                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(startTime, " date translate error ", e.getMessage()));
                                str = null;
                            }
                            dataSport.setDate(str);
                            dataSport.setTotalDistances(String.valueOf(sportResultBean.getDistance()));
                            dataSport.setTotalSteps(String.valueOf(sportResultBean.getStep()));
                            dataSport.setTotalCalories(String.valueOf(sportResultBean.getCalorie()));
                            dataSport.setTotalTimes(String.valueOf(sportResultBean.getExerciseTime()));
                            dataSport.setSportType(sportResultBean.getWorkModel());
                            dataSport.setAvgSteps(sportResultBean.getCadence());
                            dataSport.setMaxSteps(sportResultBean.getMaxCadence());
                            dataSport.setMinSteps(sportResultBean.getMinCadence());
                            dataSport.setSpeed(sportResultBean.getSpeed());
                            dataSport.setAvgPace(sportResultBean.getPace());
                            dataSport.setMaxPace(sportResultBean.getMaxPace());
                            dataSport.setMinPace(sportResultBean.getMinPace());
                            dataSport.setAvgHr(sportResultBean.getAverageHr());
                            dataSport.setMaxHr(sportResultBean.getMaxHr());
                            dataSport.setMinHr(sportResultBean.getMinHr());
                            dataSport.setFrom(1);
                            dataSport.setViewType(sportResultBean.getViewType());
                            arrayList.add(dataSport);
                        }
                        return Boolean.valueOf(SportImpl.INSTANCE.saveDatas(arrayList));
                    }
                }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncSport$1$2
                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Boolean) obj).booleanValue());
                        return eh.g.f12633a;
                    }

                    public final void invoke(boolean z5) {
                        yh.d.b().e(new EventBusBeans.SyncEvent(8));
                    }
                });
            } else {
                com.example.baselibrary.utils.b.x(sportSyncBean.getItems(), new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncSport$1$3
                    @Override // oh.l
                    public final Boolean invoke(List<SportItemBean> list) {
                        String str;
                        Devices c9;
                        User d5;
                        ArrayList arrayList = new ArrayList();
                        kotlin.jvm.internal.e.c(list);
                        for (SportItemBean sportItemBean : list) {
                            DataSport dataSport = new DataSport();
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                            if (kVar != null && (d5 = kVar.d()) != null) {
                                dataSport.setUserId(d5.getUserId());
                            }
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            if (kVar2 != null && (c9 = kVar2.c()) != null) {
                                dataSport.setMac(c9.getMacAddress());
                            }
                            dataSport.setIsUpdate(false);
                            dataSport.setTimestamp(String.valueOf(sportItemBean.getSportTime()));
                            long sportTime = sportItemBean.getSportTime() * 1000;
                            try {
                                str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(sportTime));
                            } catch (Exception e) {
                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(sportTime, " date translate error ", e.getMessage()));
                                str = null;
                            }
                            dataSport.setDate(str);
                            dataSport.setTotalDistances(String.valueOf(sportItemBean.getTotalDistance()));
                            dataSport.setTotalSteps(String.valueOf(sportItemBean.getTotalStep()));
                            dataSport.setTotalCalories(String.valueOf(sportItemBean.getTotalCalorie()));
                            dataSport.setTotalTimes(String.valueOf(sportItemBean.getTotalSportTime()));
                            dataSport.setSportType(sportItemBean.getSportType());
                            dataSport.setHrData(com.example.baselibrary.utils.b.z(sportItemBean.getSportHrItems()));
                            ArrayList arrayList2 = new ArrayList();
                            List<StepFrequencyItemBean> stepFrequencyItems = sportItemBean.getStepFrequencyItems();
                            if (stepFrequencyItems != null) {
                                Iterator<T> it = stepFrequencyItems.iterator();
                                while (it.hasNext()) {
                                    arrayList2.add(Long.valueOf(((StepFrequencyItemBean) it.next()).getStepFrequency()));
                                }
                            }
                            dataSport.setStepDetails(com.example.baselibrary.utils.b.z(arrayList2));
                            dataSport.setPaceMetrics(com.example.baselibrary.utils.b.z(sportItemBean.getMetricPaceItems()));
                            dataSport.setPaceImperials(com.example.baselibrary.utils.b.z(sportItemBean.getImperialPaceItems()));
                            dataSport.setFrom(0);
                            arrayList.add(dataSport);
                        }
                        return Boolean.valueOf(SportImpl.INSTANCE.saveDatas(arrayList));
                    }
                }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncSport$1$4
                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Boolean) obj).booleanValue());
                        return eh.g.f12633a;
                    }

                    public final void invoke(boolean z5) {
                        yh.d.b().e(new EventBusBeans.SyncEvent(8));
                    }
                });
            }
        }
    }

    public final void p(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncStep$1$1
                @Override // oh.l
                public final Boolean invoke(List<? extends StepSyncBean> list2) {
                    String str;
                    User d5;
                    Devices c9;
                    ArrayList t8 = android.support.v4.media.session.e.t("stepSyncList", list2);
                    for (StepSyncBean stepSyncBean : list2) {
                        DataStep dataStep = new DataStep();
                        dataStep.setCalorie(stepSyncBean.getTotalCalorie());
                        dataStep.setDistance(stepSyncBean.getTotalDistance());
                        dataStep.setTotalStep(stepSyncBean.getTotalSteps());
                        dataStep.setTimestamp(String.valueOf(stepSyncBean.getTime()));
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(stepSyncBean.getTime() * 1000);
                        int i3 = 0;
                        calendar.set(11, 0);
                        calendar.set(12, 0);
                        calendar.set(13, 0);
                        calendar.set(14, 0);
                        long timeInMillis = calendar.getTimeInMillis();
                        try {
                            str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                        } catch (Exception e) {
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                            str = null;
                        }
                        dataStep.setDate(str);
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null && (c9 = kVar.c()) != null) {
                            dataStep.setMac(c9.getMacAddress());
                        }
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        if (kVar2 != null && (d5 = kVar2.d()) != null) {
                            dataStep.setUserId(d5.getUserId());
                        }
                        dataStep.setIsUpdate(false);
                        ArrayList arrayList = new ArrayList();
                        List<StepItemBean> items = stepSyncBean.getItems();
                        if (items != null) {
                            for (Object obj : items) {
                                int i10 = i3 + 1;
                                if (i3 < 0) {
                                    kotlin.collections.i.f();
                                    throw null;
                                }
                                StepItemBean stepItemBean = (StepItemBean) obj;
                                StepItemData stepItemData = new StepItemData();
                                stepItemData.setTime(String.valueOf(stepItemBean.getIndex()));
                                stepItemData.setCalorie(stepItemBean.getCalorie());
                                stepItemData.setDistance(stepItemBean.getDistance());
                                stepItemData.setSteps(stepItemBean.getSteps());
                                arrayList.add(stepItemData);
                                i3 = i10;
                            }
                        }
                        dataStep.setItems(com.example.baselibrary.utils.b.z(arrayList));
                        t8.add(dataStep);
                        Log.e("qob", "onSyncStep " + dataStep.getDate() + " items " + dataStep.getItems());
                    }
                    r5.a.h(t8.size(), "saveSteps dataSteps.size ", "qob");
                    return Boolean.valueOf(StepsImpl.INSTANCE.saveSteps(t8));
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncStep$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(0));
                }
            });
        }
    }

    public final void q(List list) {
        if (list != null) {
            com.example.baselibrary.utils.b.x(list, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncTemp$1$1

                public static final class a extends bc.a<ArrayList<TempData>> {
                }

                /* JADX WARN: Removed duplicated region for block: B:63:0x012b  */
                /* JADX WARN: Removed duplicated region for block: B:81:0x017f  */
                /* JADX WARN: Removed duplicated region for block: B:84:0x0189  */
                /* JADX WARN: Removed duplicated region for block: B:87:0x018a A[SYNTHETIC] */
                @Override // oh.l
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(java.util.List<? extends com.example.blesdk.bean.sync.BodyTempSyncBean> r15) {
                    /*
                        Method dump skipped, instructions count: 423
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.SyncService$syncCallback$2$1$onSyncTemp$1$1.invoke(java.util.List):java.lang.Boolean");
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$syncCallback$2$1$onSyncTemp$1$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }

                public final void invoke(boolean z5) {
                    yh.d.b().e(new EventBusBeans.SyncEvent(5));
                }
            });
        }
    }
}
