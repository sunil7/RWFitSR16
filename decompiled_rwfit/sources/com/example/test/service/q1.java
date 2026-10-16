package com.example.test.service;

import android.util.Log;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.table.Devices;
import com.example.network.api.DeviceApi;
import com.example.network.base.HttpModel;
import com.example.test.XXApplication;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class q1 implements v5.t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f7753a;

    public q1(u1 u1Var) {
        this.f7753a = u1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        this.f7753a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "获取功能表V2失败，原因:" + i3);
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        Devices c9;
        String macAddress;
        String deviceModel;
        SupportMenuBean supportMenuBean = (SupportMenuBean) obj;
        this.f7753a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "获取功能表V2成功");
        if (supportMenuBean != null) {
            u1 u1Var = this.f7753a;
            u1Var.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", String.valueOf(supportMenuBean));
            com.example.test.utils.k a3 = y1.a();
            SupportMenuBean l3 = a3 != null ? a3.l() : null;
            if (l3 != null) {
                l3.setMsgNotification(supportMenuBean.isMsgNotification());
                l3.setTakePhoto(supportMenuBean.isTakePhoto());
                l3.setAddressBook(supportMenuBean.isAddressBook());
                l3.setDND(supportMenuBean.isDND());
                l3.setTakePhoto(supportMenuBean.isTakePhoto());
                l3.setFindDevice(supportMenuBean.isFindDevice());
                l3.setLEDLight(supportMenuBean.isLEDLight());
                l3.setWearDir(supportMenuBean.isWearDir());
                l3.setHealthMontior(supportMenuBean.isHealthMontior());
                l3.setSetBTName(supportMenuBean.isSetBTName());
                l3.setRecovery(supportMenuBean.isRecovery());
                l3.setPowerOff(supportMenuBean.isPowerOff());
                l3.setBLESupport_Function_V2_Get_OK(true);
                l3.setVideoHid(supportMenuBean.isVideoHid());
                l3.setVideoHidBook(supportMenuBean.isVideoHidBook());
                l3.setVideoHidMusic(supportMenuBean.isVideoHidMusic());
                l3.setFunc2HealthAllSwitch(supportMenuBean.isFunc2HealthAllSwitch());
                l3.setVideoHidAndroidBook(supportMenuBean.isVideoHidAndroidBook());
                l3.setChildAppSwitch(supportMenuBean.isChildAppSwitch());
                l3.setPushMsgEnableSwitch(supportMenuBean.isPushMsgEnableSwitch());
                l3.setPushMsgSwitchValue(supportMenuBean.getPushMsgSwitchValue());
                l3.setFunc2GirlCareGernal(supportMenuBean.isFunc2GirlCareGernal());
                l3.setDefaultENSYSTEM(supportMenuBean.isDefaultENSYSTEM());
                l3.setDefaultNoViewWorkout(supportMenuBean.isDefaultNoViewWorkout());
                l3.setBrightScreenTime(supportMenuBean.isBrightScreenTime());
                l3.setNewSport(supportMenuBean.isNewSport());
                l3.setAppFrontAndBack(supportMenuBean.isAppFrontAndBack());
                l3.setRememberSwitch(supportMenuBean.isRememberSwitch());
                l3.setSupportHrReminder(supportMenuBean.isSupportHrReminder());
                l3.setSupportBoReminder(supportMenuBean.isSupportBoReminder());
                l3.setSupportMotoVibrationLevel(supportMenuBean.isSupportMotoVibrationLevel());
                com.example.test.utils.k a10 = y1.a();
                Integer valueOf = a10 != null ? Integer.valueOf(a10.x()) : null;
                if (valueOf != null && valueOf.intValue() == 1) {
                    l3.setAlarm(supportMenuBean.isAlarm());
                }
                l3.setBrightScreen(supportMenuBean.isBrightScreen());
                if (supportMenuBean.isFunc2HealthAllSwitch()) {
                    l3.setStep(supportMenuBean.isStep());
                    l3.setHr(supportMenuBean.isHr());
                    l3.setBloodPress(supportMenuBean.isBloodPress());
                    l3.setSleep(supportMenuBean.isSleep());
                    l3.setBloodOxy(supportMenuBean.isBloodOxy());
                    l3.setHrv(supportMenuBean.isHrv());
                    l3.setPressure(supportMenuBean.isPressure());
                    l3.setBloodSugar(supportMenuBean.isBloodSugar());
                    l3.setMuslimCountData(supportMenuBean.isMuslimCountData());
                    l3.setSleep(supportMenuBean.isSleep());
                    l3.setHrMonitor(supportMenuBean.isHr());
                }
                Log.e("qob", "supportV2Callback getLocalSupport isVideoHidBook " + l3.isVideoHidBook());
                com.example.test.utils.k a11 = y1.a();
                if (a11 != null) {
                    a11.F(l3);
                }
                Object obj2 = com.example.test.utils.m.f8734b;
                com.example.test.utils.m a12 = d2.a();
                a12.getClass();
                a12.f8735a = l3;
                yh.d.b().e(new EventBusBeans.DeviceSupportEvent(l3));
                if (l3.isRememberSwitch()) {
                    Log.e("qob", "initMuslimCountSwitch");
                    if (e.h().i()) {
                        l1 bleDataCallback = (l1) u1Var.f7823m.getValue();
                        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
                        x5.b I0 = x5.b.I0();
                        u5.e eVar = new u5.e();
                        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
                        eVar.f18884b = bleDataCallback;
                        I0.K0(eVar);
                        if (r5.b.k().f18054c) {
                            x5.c b3 = x5.c.b();
                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "设备赞念开关切换命令");
                            b3.g((byte) 72, new byte[]{2, 120, 16}, new boolean[0]);
                        } else {
                            x5.b.I0().F0((byte) 72);
                        }
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "initMuslimCountSwitch 设备未连接");
                    }
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
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                if (kVar2 == null || kVar2.d() == null || (macAddress = c9.getMacAddress()) == null || (deviceModel = c9.getDeviceModel()) == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("model", deviceModel);
                hashMap.put(CoreUtil.STR_DEX_MAC_NAME, macAddress);
                hashMap.put("isDataTypeActivity", Integer.valueOf(l3.isStep() ? 1 : 0));
                hashMap.put("isDataTypeHeart", Integer.valueOf(l3.isHr() ? 1 : 0));
                hashMap.put("isDataTypeBloodPressure", Integer.valueOf(l3.isBloodPress() ? 1 : 0));
                hashMap.put("isDataTypeSleep", Integer.valueOf(l3.isSleep() ? 1 : 0));
                hashMap.put("isDataTypeSPO2", Integer.valueOf(l3.isBloodOxy() ? 1 : 0));
                hashMap.put("isDataTypeHRV", Integer.valueOf(l3.isHrv() ? 1 : 0));
                hashMap.put("isDataTypeStress", Integer.valueOf(l3.isPressure() ? 1 : 0));
                hashMap.put("isDataTypeBloodSugar", Integer.valueOf(l3.isBloodSugar() ? 1 : 0));
                hashMap.put("isDataTypeMuslimCount", Integer.valueOf(l3.isMuslimCountData() ? 1 : 0));
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "上传设备功能支持信息: " + hashMap);
                c6.b bVar = c6.b.f3390c;
                bVar.getClass();
                rg.l<HttpModel<String>> saveDeviceSupport = ((DeviceApi) bVar.f113a).saveDeviceSupport(hashMap);
                kotlin.jvm.internal.e.e(saveDeviceSupport, "saveDeviceSupport(...)");
                rg.l w8 = com.example.baselibrary.utils.b.w(saveDeviceSupport);
                XXApplication xXApplication = XXApplication.f7400h;
                w8.subscribe(new com.example.test.presenter.device.y(u1Var, com.google.android.gms.internal.mlkit_vision_barcode.j1.a(), com.example.test.utils.w0.d(), 8));
            }
        }
    }
}
