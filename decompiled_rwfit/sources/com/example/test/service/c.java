package com.example.test.service;

import com.example.blesdk.bean.function.BindInfoBean;
import com.example.blesdk.bean.function.BlueToothBean;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class c implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7654a;

    public /* synthetic */ c(int i3) {
        this.f7654a = i3;
    }

    private final void b() {
    }

    private final void f() {
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        switch (this.f7654a) {
            case 0:
                e.h().j(i3);
                break;
            default:
                e h4 = e.h();
                h4.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "获取绑定信息失败 " + i3 + " 获取绑定信息失败次数 = " + h4.f7692l + " 是否自动连接 = " + h4.f7682a);
                c cVar2 = h4.f7693m;
                if (cVar2 != null) {
                    x5.b I0 = x5.b.I0();
                    if (I0.J0(cVar2)) {
                        LinkedList linkedList = I0.f19795a;
                        Iterator it = linkedList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                cVar = (u5.c) it.next();
                                if (cVar == null || cVar.g() != cVar2) {
                                }
                            } else {
                                cVar = null;
                            }
                        }
                        if (cVar != null) {
                            linkedList.remove(cVar);
                        }
                    }
                }
                boolean z5 = h4.f7682a;
                com.example.baselibrary.utils.e eVar = h4.f7686f;
                if (!z5) {
                    r5.b.k().e(false);
                    eVar.sendEmptyMessage(5);
                    break;
                } else if (!h4.i()) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "设备未连接，等待连接...");
                    break;
                } else {
                    int i10 = h4.f7692l;
                    if (i10 >= 8) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "连续获取绑定信息失败,不再校验绑定信息");
                        r5.b.k().e(false);
                        eVar.sendEmptyMessage(5);
                        break;
                    } else {
                        h4.f7692l = i10 + 1;
                        h4.f();
                        break;
                    }
                }
                break;
        }
    }

    @Override // u5.g
    public final void c() {
        int i3 = this.f7654a;
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        u5.c cVar2;
        String userId;
        switch (this.f7654a) {
            case 0:
                BindInfoBean bindInfoBean = (BindInfoBean) obj;
                if (bindInfoBean.getBindStatus() != 0) {
                    e.h().j(bindInfoBean.getBindStatus());
                    return;
                }
                e.h().f7689i = true;
                e h4 = e.h();
                s5.a aVar = h4.e;
                if (aVar == null) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "当前设备为空");
                    return;
                }
                aVar.e = 1;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "绑定JL设备成功");
                if (y1.a() != null) {
                    Devices devices = new Devices();
                    devices.setName(h4.e.f18210a);
                    devices.setMacAddress(h4.e.f18212c);
                    devices.setDeviceModel(bindInfoBean.getDeviceClazz());
                    devices.setStatus(1);
                    devices.setDeviceFlag(h4.e.f18214f);
                    y1.a().a(devices);
                    com.example.test.utils.k a3 = y1.a();
                    a3.getClass();
                    Devices c9 = a3.c();
                    if (c9 != null) {
                        a3.M(bindInfoBean, c9.getMacAddress() + "device_support_info");
                    }
                    BlueToothBean blueToothBean = new BlueToothBean();
                    blueToothBean.setMac(bindInfoBean.getBtAddress());
                    y1.a().P(blueToothBean);
                }
                h4.f7686f.sendEmptyMessage(1);
                c cVar3 = h4.f7695o;
                if (cVar3 != null) {
                    x5.b I0 = x5.b.I0();
                    if (I0.J0(cVar3)) {
                        LinkedList linkedList = I0.f19795a;
                        Iterator it = linkedList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                cVar = (u5.c) it.next();
                                if (cVar == null || cVar.g() != cVar3) {
                                }
                            } else {
                                cVar = null;
                            }
                        }
                        if (cVar == null) {
                            return;
                        }
                        linkedList.remove(cVar);
                        return;
                    }
                    return;
                }
                return;
            default:
                BindInfoBean bindInfoBean2 = (BindInfoBean) obj;
                e h10 = e.h();
                h10.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "绑定信息返回：" + bindInfoBean2.toString() + " isAutoConnect " + h10.f7682a);
                h10.f7692l = 0;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    User d5 = kVar.d();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "绑定信息返回：" + bindInfoBean2.toString() + " user " + d5);
                    if (d5 == null) {
                        h10.f7686f.sendEmptyMessage(4);
                    } else if (bindInfoBean2.getBindStatus() == 0 || (userId = bindInfoBean2.getUserId()) == null || userId.length() == 0 || "null".equalsIgnoreCase(userId)) {
                        if (h10.f7682a) {
                            h10.f7686f.sendEmptyMessage(6);
                        } else {
                            h10.a();
                        }
                    } else if (bindInfoBean2.getBindStatus() != 1 || bindInfoBean2.getBindType() == 1) {
                        h10.k();
                    } else {
                        h10.a();
                    }
                } else {
                    h10.f7686f.sendEmptyMessage(4);
                }
                c cVar4 = h10.f7693m;
                if (cVar4 != null) {
                    x5.b I02 = x5.b.I0();
                    if (I02.J0(cVar4)) {
                        LinkedList linkedList2 = I02.f19795a;
                        Iterator it2 = linkedList2.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                cVar2 = (u5.c) it2.next();
                                if (cVar2 == null || cVar2.g() != cVar4) {
                                }
                            } else {
                                cVar2 = null;
                            }
                        }
                        if (cVar2 == null) {
                            return;
                        }
                        linkedList2.remove(cVar2);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
