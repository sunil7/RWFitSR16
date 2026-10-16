package com.example.test.service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.IntentFilter;
import android.os.Message;
import android.util.Log;
import com.example.blesdk.bean.function.BindInfoBean;
import com.example.blesdk.bean.function.BlueToothBean;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class e implements u5.d, o5.a {

    /* renamed from: q, reason: collision with root package name */
    public static e f7681q;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7682a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7683b;

    /* renamed from: c, reason: collision with root package name */
    public int f7684c;

    /* renamed from: d, reason: collision with root package name */
    public int f7685d;
    public s5.a e;

    /* renamed from: f, reason: collision with root package name */
    public final com.example.baselibrary.utils.e f7686f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7687g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7688h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7689i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7690j = false;

    /* renamed from: k, reason: collision with root package name */
    public com.example.test.ui.dialog.r f7691k;

    /* renamed from: l, reason: collision with root package name */
    public int f7692l;

    /* renamed from: m, reason: collision with root package name */
    public final c f7693m;

    /* renamed from: n, reason: collision with root package name */
    public final b f7694n;

    /* renamed from: o, reason: collision with root package name */
    public final c f7695o;

    /* renamed from: p, reason: collision with root package name */
    public final d f7696p;

    public e() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "初始化连接工具");
        m();
        this.f7686f = new com.example.baselibrary.utils.e(this);
        this.f7694n = new b();
        this.f7695o = new c(0);
        this.f7693m = new c(1);
        this.f7696p = new d();
    }

    public static void d() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            if (kVar == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            BlueToothBean e = com.example.test.utils.k.f8731b.e();
            if (e != null) {
                String mac = e.getMac();
                if (y5.d.e(mac)) {
                    return;
                }
                if (!y5.d.f20006c) {
                    y5.d.c(1, mac);
                    return;
                }
                if (y5.d.f20007d) {
                    return;
                }
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(mac);
                kotlin.jvm.internal.e.e(remoteDevice, "getRemoteDevice(...)");
                if (defaultAdapter.isEnabled()) {
                    try {
                        remoteDevice.createBond();
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                    } catch (NoSuchMethodException e11) {
                        e11.printStackTrace();
                    } catch (InvocationTargetException e12) {
                        e12.printStackTrace();
                    }
                }
            }
        }
    }

    public static e h() {
        if (f7681q == null) {
            synchronized (e.class) {
                f7681q = new e();
            }
        }
        return f7681q;
    }

    @Override // u5.d
    public final void I(s5.a aVar, int i3) {
        StringBuilder q5 = android.support.v4.media.session.e.q(i3, "设备连接错误 ", " isAutoConnect ");
        q5.append(this.f7682a);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", q5.toString());
        this.f7683b = false;
        if (i3 != 0 && i3 != 5 && i3 != 4) {
            if (aVar != null) {
                this.e = aVar;
            }
            s5.a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.f18213d = 0;
            } else {
                yh.d.b().e(new EventBusBeans.DeviceStatusEvent(0));
                p(R$string.str_connect_fail);
            }
        }
        if (!this.f7682a) {
            yh.d.b().e(new EventBusBeans.DeviceStatusEvent(0));
            p(R$string.str_connect_fail);
            return;
        }
        int i10 = this.f7685d;
        if (i10 > 3) {
            yh.d.b().e(new EventBusBeans.DeviceStatusEvent(0));
        } else {
            this.f7685d = i10 + 1;
            this.f7686f.sendEmptyMessageDelayed(101, this.f7684c * 10 * 1000);
            b();
        }
    }

    public final void a() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "开始绑定设备...");
        if (y5.d.f20005b) {
            c bleDataCallback = this.f7695o;
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
        } else {
            b customStatusCallback = this.f7694n;
            kotlin.jvm.internal.e.f(customStatusCallback, "customStatusCallback");
            x5.b.I0().K0(new u5.f(32, customStatusCallback));
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            if (kVar == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            User d5 = com.example.test.utils.k.f8731b.d();
            if (d5 != null) {
                BindInfoBean bindInfoBean = new BindInfoBean();
                bindInfoBean.setBindType(1);
                bindInfoBean.setUserId(d5.getUserId());
                if (y5.d.f20005b) {
                    com.google.android.gms.internal.mlkit_vision_common.p.t(bindInfoBean);
                } else {
                    com.google.android.gms.internal.mlkit_vision_common.p.s(bindInfoBean);
                }
                this.f7688h = true;
            }
        }
    }

    public final void b() {
        int i3;
        s5.a aVar = this.e;
        if (aVar != null && (i3 = aVar.f18213d) != 1) {
            if (i3 != 2) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "设备未连接，开始连接 mac " + this.e.f18212c);
                if (y1.a().q().booleanValue()) {
                    String str = (String) y1.a().i("setting_jl_ota_truemac", String.class);
                    if (str != null && str.length() > 0 && str.equalsIgnoreCase(this.e.f18212c)) {
                        this.e.f18212c = ca.c(str);
                    }
                } else {
                    String str2 = (String) y1.a().i("setting_jl_ota_truemac", String.class);
                    StringBuilder r = android.support.v4.media.session.e.r("tTrueMac ", str2, " bind statue ");
                    r.append(this.e.e);
                    Log.e("qob", r.toString());
                    if (str2 != null && str2.length() > 0) {
                        String mac2 = this.e.f18212c;
                        kotlin.jvm.internal.e.f(mac2, "mac2");
                        List u10 = kotlin.text.m.u(str2, new String[]{":"});
                        List u11 = kotlin.text.m.u(mac2, new String[]{":"});
                        int i10 = 0;
                        while (true) {
                            if (i10 >= 5) {
                                this.e.f18212c = str2;
                                break;
                            } else if (!kotlin.jvm.internal.e.a(u10.get(i10), u11.get(i10))) {
                                break;
                            } else {
                                i10++;
                            }
                        }
                    }
                }
                this.e.f18213d = 2;
                yh.d.b().e(new EventBusBeans.DeviceStatusEvent(r5.b.k().l() ? 2 : 0));
                r5.b.k().c(this.e);
                return;
            }
        }
        if (aVar == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "设备未连接else，开始连接 mac currentDevice == null");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "设备未连接else，开始连接 mac " + this.e.f18212c + " " + this.e.f18213d);
    }

    public final void c(s5.a aVar) {
        this.f7688h = false;
        this.e = aVar;
        this.f7682a = false;
        this.f7687g = true;
        b();
    }

    public final void e() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "disconnect 发送蓝牙状态 0");
        this.f7682a = false;
        this.f7689i = false;
        r5.b.k().e(false);
    }

    @Override // u5.d
    public final void e0(s5.a aVar) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "设备连接超时 connectCount " + this.f7684c + " isAutoConnect " + this.f7682a);
        if (aVar != null) {
            this.e = aVar;
        }
        this.e.f18213d = 0;
        this.f7683b = false;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "开始重连设备 是否自动连接 = " + this.f7682a + " 蓝牙是否开打 = " + r5.b.k().l() + " 连接次数 = " + this.f7684c);
        if (this.f7684c < 9999 && this.f7682a && r5.b.k().l()) {
            this.f7686f.sendEmptyMessageDelayed(101, this.f7684c * 10 * 1000);
            b();
        } else {
            p(R$string.str_connect_timeout);
            yh.d.b().e(new EventBusBeans.DeviceStatusEvent(0));
        }
    }

    public final void f() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "开始获取设备绑定信息");
        yh.d.b().e(new EventBusBeans.DeviceStatusEvent(3));
        c bleDataCallback = this.f7693m;
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        if (r5.b.k().f18054c) {
            x5.d.c().j((byte) 2, new byte[0]);
        } else {
            x5.b.I0().F0((byte) 2);
        }
    }

    public final s5.a g() {
        s5.a aVar = this.e;
        return aVar == null ? new s5.a() : aVar;
    }

    @Override // u5.d
    public final void h0(s5.a aVar) {
        User d5;
        s5.a aVar2;
        if (y5.d.f20005b) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "设备连接成功...");
        } else {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "设备连接成功，开始绑定设备... " + y5.d.f20005b);
        }
        XXApplication xXApplication = XXApplication.f7400h;
        com.google.android.gms.internal.mlkit_vision_barcode.j1.a().e = false;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k.f8731b.V(false);
        Log.e("qob", "onConnected setJLOTATrueMac " + aVar.f18212c + " BindStatus " + aVar.e + " Status " + aVar.f18213d);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        String jlOtaMac = aVar.f18212c;
        kVar.getClass();
        kotlin.jvm.internal.e.f(jlOtaMac, "jlOtaMac");
        kVar.M(jlOtaMac, "setting_jl_ota_truemac");
        String str = aVar.f18212c;
        if (str != null && (aVar2 = this.e) != null && str.equals(aVar2.f18212c)) {
            if (y5.d.f20005b) {
                s5.a aVar3 = this.e;
                aVar3.f18213d = aVar.f18213d;
                aVar3.f18212c = aVar.f18212c;
                aVar3.f18210a = aVar.f18210a;
                aVar3.f18211b = aVar.f18211b;
            } else {
                this.e = aVar;
            }
        }
        this.f7689i = false;
        this.f7683b = false;
        if (!y5.d.f20005b) {
            f();
            return;
        }
        s5.a aVar4 = this.e;
        if (aVar4 == null || aVar4.e != 1) {
            yh.d.b().e(new EventBusBeans.DeviceStatusEvent(3));
            a();
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "开始登录设备");
        d bleDataCallback = this.f7696p;
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
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        if (kVar2 == null || (d5 = kVar2.d()) == null) {
            return;
        }
        BindInfoBean bindInfoBean = new BindInfoBean();
        bindInfoBean.setBindType(1);
        bindInfoBean.setUserId(d5.getUserId());
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -5);
        } else if (y5.b.m(bindInfoBean.getUserId()).length > 32) {
            x5.b.I0().G0((byte) -5);
        } else {
            x5.c b3 = x5.c.b();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getLoginCmd " + bindInfoBean);
            y5.b.m(bindInfoBean.getUserId());
            b3.g((byte) -5, new byte[]{3, 2, 32}, new boolean[0]);
        }
        this.f7688h = true;
    }

    public final boolean i() {
        s5.a aVar = this.e;
        return aVar != null && aVar.f18213d == 1;
    }

    public final void j(int i3) {
        u5.c cVar;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "绑定设备失败"));
        e();
        this.f7686f.sendEmptyMessage(5);
        u5.c cVar2 = null;
        b bVar = this.f7694n;
        if (bVar != null) {
            x5.b I0 = x5.b.I0();
            if (I0.J0(bVar)) {
                LinkedList linkedList = I0.f19795a;
                Iterator it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        cVar = null;
                        break;
                    }
                    cVar = (u5.c) it.next();
                    if (cVar != null && cVar.g() == bVar) {
                        break;
                    }
                }
                if (cVar != null) {
                    linkedList.remove(cVar);
                }
            }
        }
        c cVar3 = this.f7695o;
        if (cVar3 != null) {
            x5.b I02 = x5.b.I0();
            if (I02.J0(cVar3)) {
                LinkedList linkedList2 = I02.f19795a;
                Iterator it2 = linkedList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    u5.c cVar4 = (u5.c) it2.next();
                    if (cVar4 != null && cVar4.g() == cVar3) {
                        cVar2 = cVar4;
                        break;
                    }
                }
                if (cVar2 == null) {
                    return;
                }
                linkedList2.remove(cVar2);
            }
        }
    }

    public final void k() {
        u5.c cVar;
        if (this.e == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "当前设备为空");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "绑定RK设备成功");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        if (com.example.test.utils.k.f8731b != null) {
            Devices devices = new Devices();
            devices.setName(this.e.f18210a);
            devices.setMacAddress(this.e.f18212c);
            devices.setDeviceFlag(this.e.f18214f);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k.f8731b.a(devices);
        }
        this.f7686f.sendEmptyMessage(1);
        b bVar = this.f7694n;
        if (bVar != null) {
            x5.b I0 = x5.b.I0();
            if (I0.J0(bVar)) {
                LinkedList linkedList = I0.f19795a;
                Iterator it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        cVar = null;
                        break;
                    }
                    cVar = (u5.c) it.next();
                    if (cVar != null && cVar.g() == bVar) {
                        break;
                    }
                }
                if (cVar == null) {
                    return;
                }
                linkedList.remove(cVar);
            }
        }
    }

    public final void l() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "释放连接工具");
        f7681q = null;
    }

    public final void m() {
        synchronized (e.class) {
            try {
                r5.b k10 = r5.b.k();
                XXApplication xXApplication = XXApplication.f7400h;
                XXApplication a3 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
                k10.f18060j = a3;
                BluetoothManager bluetoothManager = (BluetoothManager) a3.getSystemService("bluetooth");
                if (bluetoothManager != null) {
                    k10.f18056f = bluetoothManager.getAdapter();
                }
                r5.b.k().q(this);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    Devices c9 = kVar.c();
                    if (c9 != null) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "当前设备为: " + com.example.baselibrary.utils.b.z(c9));
                        s5.a aVar = new s5.a();
                        this.e = aVar;
                        aVar.f18210a = c9.getName();
                        this.e.f18213d = 0;
                        String macAddress = c9.getMacAddress();
                        String str = (String) kVar.i("setting_jl_ota_truemac", String.class);
                        Log.e("qob", " getJLOTAFileFailed " + kVar.q() + " tTrueMacAdr " + str);
                        if (kVar.q().booleanValue()) {
                            if (str != null && str.length() > 0) {
                                macAddress = str;
                            }
                            macAddress = ca.c(macAddress);
                        } else if (str != null && str.length() > 0) {
                            macAddress = str;
                        }
                        s5.a aVar2 = this.e;
                        aVar2.f18212c = macAddress;
                        aVar2.e = c9.getStatus();
                        this.e.f18214f = c9.getDeviceFlag();
                        this.f7682a = true;
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "当前设备为: " + com.example.baselibrary.utils.b.z(this.e));
                        n();
                    } else {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "当前设备为空");
                    }
                }
                int i3 = ScreenStatusReceive.f7643a;
                XXApplication a10 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                a10.registerReceiver(new ScreenStatusReceive(), intentFilter);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // u5.d
    public final void m0(s5.a aVar) {
        s5.a aVar2;
        if (y5.d.f20005b) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "onJLOTAFailedConnected " + aVar.f18213d);
            if (r5.b.k().f18069t) {
                Log.e("qob", "杰里 OTA失败, 需强制进行升级");
                if (!aVar.a()) {
                    yh.d.b().e(new EventBusBeans.DeviceStatusEvent(7));
                    return;
                }
                String str = aVar.f18212c;
                if (str != null && (aVar2 = this.e) != null && str.equals(aVar2.f18212c)) {
                    if (y5.d.f20005b) {
                        s5.a aVar3 = this.e;
                        aVar3.f18213d = 1;
                        aVar3.f18212c = aVar.f18212c;
                        aVar3.f18210a = aVar.f18210a;
                        aVar3.f18211b = aVar.f18211b;
                    } else {
                        this.e = aVar;
                    }
                }
                this.f7683b = false;
                if (this.e == null) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "当前设备为空");
                    return;
                }
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "绑定JL HeadSet设备成功");
                if (y1.a() != null) {
                    Devices devices = new Devices();
                    devices.setName(this.e.f18210a);
                    String str2 = (String) y1.a().i("setting_jl_ota_truemac", String.class);
                    if (str2 == null || str2.length() <= 0) {
                        devices.setMacAddress(this.e.f18212c);
                    } else {
                        devices.setMacAddress(str2);
                    }
                    devices.setDeviceModel("");
                    devices.setStatus(1);
                    devices.setDeviceFlag(this.e.f18214f);
                    y1.a().a(devices);
                }
                this.f7686f.sendEmptyMessage(1);
            }
        }
    }

    public final void n() {
        this.f7682a = !this.f7687g;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "重置设备连接任务：是否连接 = " + i() + " 是否自动重连 = " + this.f7682a + " 是否正在连接 = " + this.f7683b);
        this.f7684c = 0;
        this.f7685d = 0;
        if (i() || !this.f7682a || this.f7683b) {
            return;
        }
        b();
    }

    @Override // u5.d
    public final void o() {
        this.f7683b = true;
        try {
            this.e.f18213d = 2;
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "onConnecting setStatus exception" + e);
        }
    }

    public final void p(int i3) {
        com.example.test.ui.dialog.r rVar = this.f7691k;
        if (rVar != null && rVar.isShowing()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "提示正在运行");
            return;
        }
        this.f7691k = null;
        XXApplication xXApplication = XXApplication.f7400h;
        if (com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c() != null && !com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c().isFinishing() && !com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c().isDestroyed()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c().getComponentName());
            com.example.test.ui.dialog.r rVar2 = new com.example.test.ui.dialog.r(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c());
            this.f7691k = rVar2;
            rVar2.a();
            this.f7691k.b(i3);
        }
        com.example.test.ui.dialog.r rVar3 = this.f7691k;
        if (rVar3 != null) {
            try {
                rVar3.show();
            } catch (Throwable th2) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", android.support.v4.media.session.e.p(th2, new StringBuilder("弹窗失败：")));
            }
        }
    }

    public final void q() {
        String str;
        BlueToothBean e;
        this.f7682a = false;
        this.f7687g = true;
        this.f7689i = false;
        Log.e("qob", "unbindBt blueToothInfo");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null && (e = kVar.e()) != null && e.getMac() != null) {
            Log.e("qob", "unbindBt blueToothInfo getmac " + e.getMac());
            y5.d.c(2, e.getMac());
        }
        s5.a aVar = this.e;
        if (aVar != null && (str = aVar.f18212c) != null) {
            y5.d.c(2, str);
        }
        r5.b.k().e(true);
        if (y1.a() != null) {
            y1.a().f0();
            com.example.test.utils.k a3 = y1.a();
            a3.getClass();
            a3.M("", "setting_jl_ota_truemac");
            y1.a().V(false);
        }
        this.e = null;
        r5.b.k().f18063m = 239;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "unbind 发送蓝牙状态 0");
        yh.d.b().e(new EventBusBeans.DeviceStatusEvent(0));
    }

    /* JADX WARN: Type inference failed for: r7v12, types: [eh.b, java.lang.Object] */
    @Override // o5.a
    public final void r0(Message message) {
        int i3 = message.what;
        if (i3 == 101) {
            this.f7684c++;
            if (this.f7683b || !this.f7682a) {
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "连接重试 " + this.f7684c);
            b();
            return;
        }
        if (i3 == 4) {
            yh.d.b().e(new EventBusBeans.DeviceStatusEvent(4));
            p(R$string.str_bind_tips);
            e();
            return;
        }
        if (i3 == 5) {
            yh.d.b().e(new EventBusBeans.DeviceStatusEvent(5));
            p(R$string.str_bind_retry);
            e();
            return;
        }
        if (i3 == 8) {
            yh.d.b().e(new EventBusBeans.DeviceStatusEvent(5));
            e();
            return;
        }
        if (i3 == 6) {
            if (y1.a() != null) {
                y1.a().Q("");
                Devices c9 = y1.a().c();
                if (c9 != null) {
                    y1.a().e0(c9.getMacAddress(), false);
                    y1.a().a0(c9.getMacAddress(), false);
                    if (y5.d.f20005b) {
                        y1.a().O(c9.getMacAddress(), false);
                    }
                }
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== DeviceConnectService DEVICE_RECOVERY_ERROR_INFO");
            q();
            p(R$string.str_device_restore_tips);
            yh.d.b().e(new EventBusBeans.DeviceStatusEvent(6));
            return;
        }
        if (i3 == 1) {
            this.f7686f.removeMessages(101);
            this.f7687g = false;
            try {
                com.example.test.ui.dialog.r rVar = this.f7691k;
                if (rVar != null) {
                    rVar.dismiss();
                }
            } catch (Throwable th2) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", android.support.v4.media.session.e.p(th2, new StringBuilder("弹窗消失异常 ")));
            }
            XXApplication xXApplication = XXApplication.f7400h;
            com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
            Object obj = com.example.blesdk.service.y.f7339y;
            com.google.android.gms.internal.mlkit_vision_barcode.i1.a().f7343d = false;
            com.google.android.gms.internal.mlkit_vision_barcode.i1.a().e = false;
            com.google.android.gms.internal.mlkit_vision_barcode.i1.a().f7344f = false;
            yh.d.b().e(new EventBusBeans.DeviceStatusEvent(1));
            d0 d0Var = (d0) d0.f7657y.getValue();
            com.google.android.gms.internal.mlkit_vision_common.p.U((v) d0Var.f7658a.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((x) d0Var.f7659b.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((k) d0Var.f7660c.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((w) d0Var.f7661d.getValue());
            if (!y5.d.f20005b) {
                com.google.android.gms.internal.mlkit_vision_common.p.U((f) d0Var.e.getValue());
            }
            com.google.android.gms.internal.mlkit_vision_common.p.U((g) d0Var.f7662f.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((h) d0Var.f7663g.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((c0) d0Var.f7664h.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((q) d0Var.f7665i.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((j) d0Var.f7666j.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((a0) d0Var.f7667k.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((l) d0Var.f7668l.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((t) d0Var.f7669m.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((m) d0Var.r.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((b0) d0Var.f7674s.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((y) d0Var.f7675t.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((n) d0Var.f7677v.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((r) d0Var.f7672p.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((s) d0Var.f7678w.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((z) d0Var.f7676u.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.U((i) d0Var.f7671o.getValue());
            if (y5.d.f20005b) {
                com.google.android.gms.internal.mlkit_vision_common.p.U((p) d0Var.f7673q.getValue());
                com.google.android.gms.internal.mlkit_vision_common.p.U((u) d0Var.f7670n.getValue());
            }
            com.google.android.gms.internal.mlkit_vision_common.p.U((o) d0Var.f7679x.getValue());
            if (!y5.d.f20005b) {
                Object obj2 = u1.f7811u;
                u1 a3 = com.google.android.gms.internal.mlkit_vision_barcode.q1.a();
                a3.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== pairDevice");
                a3.b().sendEmptyMessageDelayed(1, 1000L);
            } else if (!this.e.a()) {
                Object obj3 = u1.f7811u;
                com.google.android.gms.internal.mlkit_vision_barcode.q1.a().c();
            }
            this.f7682a = true;
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [eh.b, java.lang.Object] */
    @Override // u5.d
    public final void v(s5.a aVar) {
        int i3;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "onDisConnect 设备连接断开 ");
        if (this.f7682a) {
            this.e = aVar;
        }
        this.f7683b = false;
        this.f7689i = false;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "发送蓝牙状态  isAutoConnect " + this.f7682a + " status = 0");
        yh.d.b().e(new EventBusBeans.DeviceStatusEvent(0));
        d0 d0Var = (d0) d0.f7657y.getValue();
        com.google.android.gms.internal.mlkit_vision_common.p.d((v) d0Var.f7658a.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((x) d0Var.f7659b.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((k) d0Var.f7660c.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((w) d0Var.f7661d.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((f) d0Var.e.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((g) d0Var.f7662f.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((h) d0Var.f7663g.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((c0) d0Var.f7664h.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((q) d0Var.f7665i.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((j) d0Var.f7666j.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((a0) d0Var.f7667k.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((l) d0Var.f7668l.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((t) d0Var.f7669m.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((m) d0Var.r.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((b0) d0Var.f7674s.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((y) d0Var.f7675t.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((n) d0Var.f7677v.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((r) d0Var.f7672p.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((s) d0Var.f7678w.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((z) d0Var.f7676u.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((i) d0Var.f7671o.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((p) d0Var.f7673q.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((u) d0Var.f7670n.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((o) d0Var.f7679x.getValue());
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "开始重连设备 是否自动连接 = " + this.f7682a + " 蓝牙是否开打 = " + r5.b.k().l() + " 连接次数 = " + this.f7684c);
        if (this.f7682a && r5.b.k().l() && (i3 = this.f7684c) < 9999) {
            this.f7686f.sendEmptyMessageDelayed(101, i3 * 10 * 1000);
            b();
        }
    }
}
