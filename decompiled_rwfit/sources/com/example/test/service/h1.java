package com.example.test.service;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.Log;
import com.example.blesdk.bean.function.BindInfoBean;
import com.example.blesdk.bean.function.MusicPushBean;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.blesdk.bean.function.UnitBean;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.f2;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final /* synthetic */ class h1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7717a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u1 f7718b;

    public /* synthetic */ h1(u1 u1Var, int i3) {
        this.f7717a = i3;
        this.f7718b = u1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        User d5;
        User d8;
        User d10;
        User d11;
        int i3 = 0;
        int i10 = 2;
        switch (this.f7717a) {
            case 0:
                u1 this$0 = this.f7718b;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!e.h().i() || this$0.f7826p || this$0.f7827q) {
                    return;
                }
                com.google.android.gms.internal.mlkit_vision_common.p.V((k1) this$0.f7817g.getValue());
                this$0.f7813b = 0;
                this$0.f7814c = false;
                this$0.f7827q = true;
                this$0.b().sendEmptyMessage(0);
                if (!y5.d.f20005b) {
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备日期时间 " + this$0);
                        Date time = Calendar.getInstance().getTime();
                        kotlin.jvm.internal.e.e(time, "getTime(...)");
                        com.google.android.gms.internal.mlkit_vision_common.p.u(time);
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备日期时间失败 设备未连接");
                    }
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备功能表");
                        p1 bleDataCallback = (p1) this$0.f7819i.getValue();
                        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
                        x5.b I0 = x5.b.I0();
                        u5.e eVar = new u5.e();
                        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
                        eVar.f18884b = bleDataCallback;
                        I0.K0(eVar);
                        if (r5.b.k().f18054c) {
                            x5.d.c().j((byte) 3, new byte[0]);
                        } else {
                            x5.b.I0().F0((byte) 3);
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备功能表失败 设备未连接");
                    }
                    this$0.g();
                    u1.d();
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备语言");
                        UnitBean unitBean = new UnitBean();
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null && (d5 = kVar.d()) != null) {
                            unitBean.setTempUnit(d5.getTempUnit());
                            unitBean.setMeasureUnit(d5.getMeterUnit());
                        }
                        XXApplication xXApplication = XXApplication.f7400h;
                        Context applicationContext = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext();
                        if (applicationContext != null) {
                            unitBean.setTimeFont(!DateFormat.is24HourFormat(applicationContext) ? 1 : 0);
                        }
                        unitBean.setLang(f2.b());
                        com.google.android.gms.internal.mlkit_vision_common.p.P(unitBean);
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备语言失败 设备未连接");
                    }
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "启动天气同步");
                    com.example.test.utils.z0.d().c();
                    com.example.test.utils.z0.d().f(true);
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化运动目标");
                        com.google.android.gms.internal.mlkit_vision_common.p.U((r1) this$0.f7820j.getValue());
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        SportTargetBean B = kVar2 != null ? kVar2.B() : null;
                        if (B != null) {
                            com.google.android.gms.internal.mlkit_vision_common.p.E(B);
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化运动目标失败 设备未连接");
                    }
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化开关状态");
                        r1 bleDataCallback2 = (r1) this$0.f7820j.getValue();
                        kotlin.jvm.internal.e.f(bleDataCallback2, "bleDataCallback");
                        x5.b I02 = x5.b.I0();
                        u5.e eVar2 = new u5.e();
                        eVar2.f18883a = new com.example.baselibrary.utils.e(eVar2);
                        eVar2.f18884b = bleDataCallback2;
                        I02.K0(eVar2);
                        if (r5.b.k().f18054c) {
                            x5.d.c().j((byte) 5, new byte[0]);
                        } else {
                            x5.b.I0().F0((byte) 5);
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化开关状态失败 设备未连接");
                    }
                    if (r5.b.k().f18054c) {
                        i1 bleDataCallback3 = (i1) this$0.f7821k.getValue();
                        kotlin.jvm.internal.e.f(bleDataCallback3, "bleDataCallback");
                        x5.b I03 = x5.b.I0();
                        u5.e eVar3 = new u5.e();
                        eVar3.f18883a = new com.example.baselibrary.utils.e(eVar3);
                        eVar3.f18884b = bleDataCallback3;
                        I03.K0(eVar3);
                        if (r5.b.k().f18054c) {
                            x5.d.c().j((byte) 15, new byte[0]);
                            return;
                        } else {
                            x5.b.I0().F0((byte) 15);
                            return;
                        }
                    }
                    return;
                }
                if (e.h().i()) {
                    double offset = (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 3600000.0d) * 4;
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "本地时区设置 " + offset);
                    byte b3 = (byte) ((int) offset);
                    if (r5.b.k().f18054c) {
                        x5.c b10 = x5.c.b();
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(b3, "getZoneCmd "));
                        byte[] bArr = new byte[5];
                        bArr[0] = 2;
                        bArr[1] = 2;
                        bArr[2] = 0;
                        bArr[3] = b3;
                        char[] cArr = y5.b.f20001a;
                        String str = Build.BRAND;
                        kotlin.jvm.internal.e.e(str, "getDeviceBrand(...)");
                        if (kotlin.text.m.c(str, "samsung", false)) {
                            bArr[4] = 3;
                        } else {
                            bArr[4] = 2;
                        }
                        b10.g((byte) -12, bArr, new boolean[0]);
                    } else {
                        x5.b.I0().F0((byte) -12);
                    }
                } else {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "本地时区设置失败 设备未连接");
                }
                if (e.h().i()) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备日期时间 " + this$0);
                    Date time2 = Calendar.getInstance().getTime();
                    kotlin.jvm.internal.e.e(time2, "getTime(...)");
                    com.google.android.gms.internal.mlkit_vision_common.p.v(time2);
                } else {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备日期时间失败 设备未连接");
                }
                if (e.h().i()) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备功能表");
                    com.example.test.utils.k a3 = y1.a();
                    kotlin.jvm.internal.e.c(a3);
                    BindInfoBean m10 = a3.m();
                    SupportMenuBean supportMenuBean = new SupportMenuBean();
                    supportMenuBean.setStep(true);
                    supportMenuBean.setSleep(true);
                    supportMenuBean.setHr(true);
                    supportMenuBean.setBloodPress(false);
                    supportMenuBean.setBloodOxy(true);
                    supportMenuBean.setBodyTemp(false);
                    supportMenuBean.setEcg(false);
                    supportMenuBean.setBreathe(false);
                    supportMenuBean.setPressure(true);
                    supportMenuBean.setDial(true);
                    supportMenuBean.setWallpaperDial(false);
                    supportMenuBean.setMsgNotification(true);
                    supportMenuBean.setSedentary(true);
                    supportMenuBean.setDrink(true);
                    supportMenuBean.setRemindModel(false);
                    supportMenuBean.setAlarm(true);
                    supportMenuBean.setBrightScreen(true);
                    supportMenuBean.setBrightScreenTime(true);
                    supportMenuBean.setHrMonitor(true);
                    supportMenuBean.setDND(true);
                    supportMenuBean.setWeather(true);
                    supportMenuBean.setAddressBook(true);
                    supportMenuBean.setRecovery(true);
                    supportMenuBean.setFirmwareUpdate(true);
                    supportMenuBean.setNFC(false);
                    supportMenuBean.setQrCode(false);
                    supportMenuBean.setRestart(true);
                    supportMenuBean.setPowerOff(true);
                    supportMenuBean.setBlueTooth(true);
                    supportMenuBean.setFindDevice(true);
                    supportMenuBean.setVideoHid(false);
                    supportMenuBean.setSetBTName(false);
                    supportMenuBean.setLEDLight(false);
                    supportMenuBean.setTakePhoto(true);
                    supportMenuBean.setBLESupport_Function_V2_Get_OK(false);
                    if (m10 != null) {
                        supportMenuBean.setStep(m10.getIsStep() == 1);
                        supportMenuBean.setHr(m10.getIsHeartRate() == 1);
                        supportMenuBean.setBloodOxy(m10.getIsBo() == 1);
                        supportMenuBean.setBloodPress(m10.getIsBp() == 1);
                        supportMenuBean.setPressure(m10.getIsPressure() == 1);
                        supportMenuBean.setBloodSugar(m10.getIsBloodSugar() == 1);
                        supportMenuBean.setWomenHealth(m10.getIsMenstrualCycle() == 1);
                        supportMenuBean.setVaperPowerData(m10.getIsVaperPowerData() == 1);
                        supportMenuBean.setVaperBatteryData(m10.getIsVaperBatteryData() == 1);
                        supportMenuBean.setActivityDataStaticTran2(m10.getIsActivityDataStaticTran2() == 1);
                        supportMenuBean.setBLESupport_Function_V2(m10.getIsBLESupport_Function_V2() == 1);
                        supportMenuBean.setHealthRing(m10.getIsHealthRing() == 1);
                        supportMenuBean.setHrv(m10.getIsHrv() == 1);
                        supportMenuBean.setSleep(m10.getIsSleep() == 1);
                        supportMenuBean.setHrMonitor(m10.getIsHeartRate() == 1);
                        Log.e("qob", "isHealthRing " + supportMenuBean.isHealthRing() + " isBLESupport_Function_V2 " + ((int) m10.getIsBLESupport_Function_V2()));
                        if (supportMenuBean.isVaperPowerData()) {
                            supportMenuBean.setSleep(false);
                            supportMenuBean.setHr(false);
                            supportMenuBean.setBloodPress(false);
                            supportMenuBean.setBloodOxy(false);
                            supportMenuBean.setBodyTemp(false);
                            supportMenuBean.setEcg(false);
                            supportMenuBean.setBreathe(false);
                            supportMenuBean.setPressure(false);
                            supportMenuBean.setMuslimRing(false);
                            supportMenuBean.setSedentary(false);
                            supportMenuBean.setDrink(false);
                            supportMenuBean.setBrightScreen(false);
                            supportMenuBean.setHrMonitor(false);
                            Log.e("qob", "initVaperPower");
                            if (e.h().i()) {
                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化电子烟功率 " + this$0);
                                if (r5.b.k().f18054c) {
                                    x5.c b11 = x5.c.b();
                                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getVaperPowerRCmdJL");
                                    b11.g((byte) -107, new byte[]{2, 97, 16}, new boolean[0]);
                                } else {
                                    x5.b.I0().F0((byte) -107);
                                }
                            } else {
                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化电子烟功率失败 设备未连接");
                            }
                        } else if (supportMenuBean.isHealthRing()) {
                            supportMenuBean.setDial(false);
                            supportMenuBean.setWallpaperDial(false);
                            supportMenuBean.setMsgNotification(false);
                            supportMenuBean.setSedentary(false);
                            supportMenuBean.setDrink(false);
                            supportMenuBean.setRemindModel(false);
                            supportMenuBean.setAlarm(false);
                            supportMenuBean.setBrightScreen(false);
                            supportMenuBean.setBrightScreenTime(false);
                            supportMenuBean.setHrMonitor(true);
                            supportMenuBean.setDND(false);
                            supportMenuBean.setWeather(false);
                            supportMenuBean.setAddressBook(false);
                            supportMenuBean.setRecovery(true);
                            supportMenuBean.setFirmwareUpdate(true);
                            supportMenuBean.setNFC(false);
                            supportMenuBean.setQrCode(false);
                            supportMenuBean.setRestart(false);
                            supportMenuBean.setPowerOff(true);
                            supportMenuBean.setBlueTooth(false);
                            supportMenuBean.setFindDevice(true);
                            supportMenuBean.setVideoHid(true);
                            supportMenuBean.setSetBTName(true);
                            supportMenuBean.setLEDLight(true);
                            supportMenuBean.setWearDir(true);
                            supportMenuBean.setHealthMontior(true);
                            supportMenuBean.setSetBTName(true);
                            supportMenuBean.setTakePhoto(true);
                            if (supportMenuBean.isBLESupport_Function_V2()) {
                                com.example.test.utils.k a10 = y1.a();
                                SupportMenuBean l3 = a10 != null ? a10.l() : null;
                                if (l3 != null) {
                                    supportMenuBean.setPressure(l3.isPressure());
                                    supportMenuBean.setBloodSugar(l3.isBloodSugar());
                                    supportMenuBean.setMuslimCountData(l3.isMuslimCountData());
                                }
                            }
                        }
                    }
                    com.example.test.utils.k a11 = y1.a();
                    if (a11 != null) {
                        a11.F(supportMenuBean);
                    }
                    Object obj = com.example.test.utils.m.f8734b;
                    com.example.test.utils.m a12 = d2.a();
                    a12.getClass();
                    a12.f8735a = supportMenuBean;
                    yh.d.b().e(new EventBusBeans.DeviceSupportEvent(supportMenuBean));
                } else {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备功能表失败 设备未连接");
                }
                if (e.h().i()) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "12/24小时制设置");
                    XXApplication xXApplication2 = XXApplication.f7400h;
                    Context applicationContext2 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext();
                    if (applicationContext2 != null) {
                        int i11 = !DateFormat.is24HourFormat(applicationContext2) ? 1 : 0;
                        if (r5.b.k().f18054c) {
                            x5.c b12 = x5.c.b();
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i11, "getTimeFontCmd "));
                            char[] cArr2 = y5.b.f20001a;
                            b12.g((byte) -16, new byte[]{2, 14, 0, (byte) (i11 & 255)}, new boolean[0]);
                        } else {
                            x5.b.I0().F0((byte) -16);
                        }
                    }
                } else {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "12/24小时制设置失败 设备未连接");
                }
                Object obj2 = com.example.test.utils.m.f8734b;
                SupportMenuBean supportMenuBean2 = d2.a().f8735a;
                if (supportMenuBean2 != null ? supportMenuBean2.isBLESupport_Function_V2() : true) {
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化杰里设备V2功能表");
                        q1 bleDataCallback4 = (q1) this$0.f7818h.getValue();
                        kotlin.jvm.internal.e.f(bleDataCallback4, "bleDataCallback");
                        x5.b I04 = x5.b.I0();
                        u5.e eVar4 = new u5.e();
                        eVar4.f18883a = new com.example.baselibrary.utils.e(eVar4);
                        eVar4.f18884b = bleDataCallback4;
                        I04.K0(eVar4);
                        if (r5.b.k().f18054c) {
                            x5.c b13 = x5.c.b();
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getFunctionV2RCmdJL");
                            b13.g((byte) 18, new byte[]{2, 99, 16}, new boolean[0]);
                        } else {
                            x5.b.I0().F0((byte) 18);
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化杰里设备V2功能表 设备未连接");
                    }
                }
                if (d2.a().c()) {
                    Log.e("qob", "initRingLedLight");
                    if (e.h().i()) {
                        com.google.android.gms.internal.mlkit_vision_common.p.U((m1) this$0.f7822l.getValue());
                        com.google.android.gms.internal.mlkit_vision_common.p.j();
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "initRingLedLight 设备未连接");
                    }
                    Log.e("qob", "initRingVideoHid");
                    if (e.h().i()) {
                        com.google.android.gms.internal.mlkit_vision_common.p.U((n1) this$0.f7824n.getValue());
                        com.google.android.gms.internal.mlkit_vision_common.p.q();
                    } else {
                        Log.e("SyncService", "initRingVideoHid 设备未连接");
                    }
                    Log.e("qob", "initRingWearDir");
                    if (e.h().i()) {
                        o1 bleDataCallback5 = (o1) this$0.f7825o.getValue();
                        kotlin.jvm.internal.e.f(bleDataCallback5, "bleDataCallback");
                        x5.b I05 = x5.b.I0();
                        u5.e eVar5 = new u5.e();
                        eVar5.f18883a = new com.example.baselibrary.utils.e(eVar5);
                        eVar5.f18884b = bleDataCallback5;
                        I05.K0(eVar5);
                        if (r5.b.k().f18054c) {
                            x5.c b14 = x5.c.b();
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getRingWearHandRCmdJL");
                            b14.g((byte) 30, new byte[]{2, 104, 16}, new boolean[0]);
                        } else {
                            x5.b.I0().F0((byte) 30);
                        }
                    } else {
                        Log.e("SyncService", "initRingWearDir 设备未连接");
                    }
                } else {
                    u1.d();
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备语言");
                        int a13 = f2.a();
                        if (r5.b.k().f18054c) {
                            x5.c b15 = x5.c.b();
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(a13, "getLanguageCmd "));
                            char[] cArr3 = y5.b.f20001a;
                            b15.g((byte) -15, new byte[]{2, 15, 0, (byte) (a13 & 255)}, new boolean[0]);
                        } else {
                            x5.b.I0().F0((byte) -15);
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化设备语言失败 设备未连接");
                    }
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "公英制设置");
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                        if (kVar3 != null && (d11 = kVar3.d()) != null) {
                            int meterUnit = d11.getMeterUnit();
                            if (r5.b.k().f18054c) {
                                x5.c b16 = x5.c.b();
                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(meterUnit, "getMeasureUnitCmd "));
                                char[] cArr4 = y5.b.f20001a;
                                b16.g((byte) -17, new byte[]{2, 17, 0, (byte) (meterUnit & 255)}, new boolean[0]);
                            } else {
                                x5.b.I0().F0((byte) -17);
                            }
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "公英制设置失败 设备未连接");
                    }
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "温度单位设置");
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                        if (kVar4 != null && (d10 = kVar4.d()) != null) {
                            int tempUnit = d10.getTempUnit();
                            if (r5.b.k().f18054c) {
                                x5.c b17 = x5.c.b();
                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(tempUnit, "getTempUnitCmd "));
                                char[] cArr5 = y5.b.f20001a;
                                b17.g((byte) -18, new byte[]{2, 29, 0, (byte) (tempUnit & 255)}, new boolean[0]);
                            } else {
                                x5.b.I0().F0((byte) -18);
                            }
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "温度单位设置失败 设备未连接");
                    }
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "计步目标设置");
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar5 = com.example.test.utils.k.f8731b;
                        if (kVar5 != null && (d8 = kVar5.d()) != null) {
                            com.google.android.gms.internal.mlkit_vision_common.p.F(d8.getStepsTarget());
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "计步目标设置失败 设备未连接");
                    }
                    if (e.h().i()) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化开关状态");
                        r1 bleDataCallback6 = (r1) this$0.f7820j.getValue();
                        kotlin.jvm.internal.e.f(bleDataCallback6, "bleDataCallback");
                        x5.b I06 = x5.b.I0();
                        u5.e eVar6 = new u5.e();
                        eVar6.f18883a = new com.example.baselibrary.utils.e(eVar6);
                        eVar6.f18884b = bleDataCallback6;
                        I06.K0(eVar6);
                        if (r5.b.k().f18054c) {
                            x5.c b18 = x5.c.b();
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getDeviceSwitchRCmdJL");
                            b18.g((byte) -90, new byte[]{2, 20, 16}, new boolean[0]);
                        } else {
                            x5.b.I0().F0((byte) -90);
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化开关状态失败 设备未连接");
                    }
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "启动天气同步");
                    com.example.test.utils.z0.d().c();
                    com.example.test.utils.z0.d().f(true);
                }
                this$0.g();
                ArrayList a14 = g0.f7705a.a();
                if (a14.size() > 0) {
                    int size = a14.size();
                    while (i3 < size) {
                        Object obj3 = a14.get(i3);
                        i3++;
                        MusicPushBean musicPushBean = (MusicPushBean) obj3;
                        kotlin.jvm.internal.e.c(musicPushBean);
                        com.google.android.gms.internal.mlkit_vision_common.p.B(musicPushBean);
                    }
                    return;
                }
                return;
            case 1:
                u1 this$02 = this.f7718b;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                com.example.test.ui.dialog.h hVar = this$02.f7812a;
                if (hVar != null) {
                    try {
                        String string = hVar.getContext().getString(R$string.str_device_sync);
                        kotlin.jvm.internal.e.e(string, "getString(...)");
                        hVar.b(string);
                        if (!hVar.isShowing() && this$02.f7813b < 100) {
                            Log.e("qob", "SyncService isShowing " + hVar.isShowing() + " currentProgress " + this$02.f7813b);
                            hVar.show();
                        }
                        if (this$02.f7813b == 100) {
                            this$02.b().postDelayed(new h1(this$02, i10), 150L);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("show sync dialog error ", th2.getMessage()));
                        this$02.f7812a = null;
                        this$02.f7815d = null;
                        this$02.f();
                        return;
                    }
                }
                return;
            default:
                u1 this$03 = this.f7718b;
                kotlin.jvm.internal.e.f(this$03, "this$0");
                if (this$03.r) {
                    com.example.baselibrary.utils.d.a(R$string.str_sync_success);
                }
                Activity activity = this$03.f7815d;
                Log.e("qob", "SyncService finish " + (activity != null ? activity.getClass() : null));
                com.example.test.ui.dialog.h hVar2 = this$03.f7812a;
                if (hVar2 != null) {
                    Activity activity2 = this$03.f7815d;
                    if (activity2 != null) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "finish " + activity2.isFinishing() + " isDestroyed " + activity2.isDestroyed() + " class " + activity2);
                        if (!activity2.isFinishing() && !activity2.isDestroyed()) {
                            try {
                                hVar2.dismiss();
                            } catch (Throwable th3) {
                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("移除弹窗出错 ", th3.getMessage()));
                            }
                        }
                    }
                    this$03.f7812a = null;
                    this$03.f7815d = null;
                    this$03.f7813b = 0;
                    this$03.f7826p = false;
                }
                Object obj4 = g1.e;
                com.google.android.gms.internal.mlkit_vision_barcode.p1.a().p();
                Object obj5 = p0.f7741g;
                com.google.android.gms.internal.mlkit_vision_barcode.m1.a().h(true);
                if (y5.d.f20005b) {
                    if (r5.b.k().f18054c) {
                        x5.c b19 = x5.c.b();
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getBatteryCmd");
                        b19.g((byte) -13, new byte[]{2, 3, 16}, new boolean[0]);
                    } else {
                        x5.b.I0().F0((byte) -13);
                    }
                }
                Object obj6 = com.example.test.utils.m.f8734b;
                SupportMenuBean supportMenuBean3 = d2.a().f8735a;
                if (!(supportMenuBean3 != null ? supportMenuBean3.isSleep() : true) && d2.a().c()) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SY03不支持配对!");
                    return;
                } else {
                    e.h().getClass();
                    e.d();
                    return;
                }
        }
    }
}
