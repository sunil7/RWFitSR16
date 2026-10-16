package r5;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.os.Message;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.example.baselibrary.utils.e;
import com.example.blesdk.bean.BleSendBean;
import com.example.blesdk.service.b0;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import u5.j;

/* loaded from: classes.dex */
public final class b extends BluetoothGattCallback implements o5.a, j {

    /* renamed from: y, reason: collision with root package name */
    public static b f18051y;

    /* renamed from: b, reason: collision with root package name */
    public boolean f18053b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18054c;
    public s5.a e;

    /* renamed from: f, reason: collision with root package name */
    public BluetoothAdapter f18056f;

    /* renamed from: g, reason: collision with root package name */
    public BluetoothDevice f18057g;

    /* renamed from: i, reason: collision with root package name */
    public BluetoothGatt f18059i;

    /* renamed from: j, reason: collision with root package name */
    public XXApplication f18060j;

    /* renamed from: k, reason: collision with root package name */
    public long f18061k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f18062l;

    /* renamed from: o, reason: collision with root package name */
    public BluetoothGattCharacteristic f18065o;

    /* renamed from: p, reason: collision with root package name */
    public BluetoothGattCharacteristic f18066p;

    /* renamed from: q, reason: collision with root package name */
    public BluetoothGattCharacteristic f18067q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f18068s;

    /* renamed from: h, reason: collision with root package name */
    public final Object f18058h = new Object();

    /* renamed from: m, reason: collision with root package name */
    public int f18063m = 239;

    /* renamed from: n, reason: collision with root package name */
    public volatile int f18064n = 230;

    /* renamed from: t, reason: collision with root package name */
    public boolean f18069t = false;

    /* renamed from: u, reason: collision with root package name */
    public int f18070u = 0;

    /* renamed from: v, reason: collision with root package name */
    public int f18071v = 1;

    /* renamed from: w, reason: collision with root package name */
    public boolean f18072w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f18073x = false;

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f18052a = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final e f18055d = new e(this);

    public static b k() {
        if (f18051y == null) {
            synchronized (b.class) {
                f18051y = new b();
            }
        }
        return f18051y;
    }

    public final void a() {
        e eVar = this.f18055d;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "蓝牙断开连接......");
        try {
            eVar.removeCallbacksAndMessages(null);
            BluetoothGatt bluetoothGatt = this.f18059i;
            if (bluetoothGatt != null) {
                try {
                    bluetoothGatt.getClass().getMethod("refresh", null).invoke(bluetoothGatt, null);
                } catch (Exception unused) {
                }
                this.f18059i.close();
                this.f18059i = null;
            }
            if (this.r) {
                return;
            }
            eVar.sendEmptyMessage(3);
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "蓝牙断开连接回掉报错：" + e.getMessage(), "");
        }
    }

    public final void b(s5.a aVar) {
        try {
            this.e = aVar;
            BluetoothDevice remoteDevice = this.f18056f.getRemoteDevice(aVar.f18212c);
            this.f18057g = remoteDevice;
            if (remoteDevice == null) {
                d(4);
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "获取设备为空，不连接");
                return;
            }
            synchronized (this.f18058h) {
                p();
                BluetoothGatt bluetoothGatt = this.f18059i;
                try {
                    bluetoothGatt.getClass().getMethod("refresh", null).invoke(bluetoothGatt, null);
                } catch (Exception unused) {
                }
                BluetoothGatt bluetoothGatt2 = this.f18059i;
                if (bluetoothGatt2 != null) {
                    bluetoothGatt2.close();
                    this.f18059i = null;
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.e = aVar;
            this.f18061k = System.currentTimeMillis();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "开启连接---");
            this.f18059i = this.f18057g.connectGatt(this.f18060j, false, this, 2);
        } catch (Throwable th2) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", android.support.v4.media.session.e.p(th2, new StringBuilder("连接异常 ")));
            d(-1);
        }
    }

    public final void c(s5.a aVar) {
        String str;
        if (this.f18053b) {
            d(5);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "正在连接，不连接");
            return;
        }
        if (aVar != null && aVar.f18213d == 1) {
            d(0);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "已存在连接，不连接");
            return;
        }
        if (aVar != null && ((str = aVar.f18212c) == null || str.isEmpty())) {
            d(4);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "mac地址为空，不连接");
            return;
        }
        if (!l()) {
            d(2);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "蓝牙未开启，不连接");
            return;
        }
        if (this.f18072w) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "正在搜索设备连接中, 不连接");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "清除所有Message,防止断开再回调");
        e eVar = this.f18055d;
        eVar.removeCallbacksAndMessages(null);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "开启直连---" + com.example.baselibrary.utils.b.z(aVar));
        try {
            this.e = aVar;
            this.f18053b = true;
            Iterator it = this.f18052a.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null) {
                    ((u5.d) weakReference.get()).o();
                }
            }
            b(aVar);
            eVar.sendEmptyMessageDelayed(0, 10000L);
        } catch (Throwable th2) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", android.support.v4.media.session.e.p(th2, new StringBuilder("连接异常 ")));
            d(-1);
        }
    }

    public final void d(int i3) {
        new StringBuilder("connectFail ").append(i3);
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = Integer.valueOf(i3);
        this.f18055d.sendMessage(obtain);
    }

    public final void e(boolean z5) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", a.d("disconnect isUnbind ", z5));
        if (z5) {
            this.f18055d.removeMessages(1);
            d.d().h(this);
            if (this.f18072w) {
                d.d().g();
            }
            this.f18072w = false;
        }
        h();
    }

    @Override // u5.j
    public final void f() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "扫描结束是否扫描到设备 ：" + this.f18068s + " 已搜索到服务 " + this.f18062l);
        this.f18072w = false;
        this.f18055d.removeMessages(1);
        if (this.f18068s || this.f18062l) {
            return;
        }
        h();
        d(4);
    }

    @Override // u5.j
    public final void g(s5.a aVar) {
        if (this.e.f18212c.equals(aVar.f18212c)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "扫描到该设备，开始连接");
            this.f18068s = true;
            this.f18072w = false;
            this.f18055d.removeMessages(1);
            b(aVar);
            d.d().g();
        }
    }

    public final void h() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "disconnectBlueToothConnection");
        try {
            BluetoothGatt bluetoothGatt = this.f18059i;
            if (bluetoothGatt != null) {
                bluetoothGatt.disconnect();
            }
            a();
        } catch (Throwable th2) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", android.support.v4.media.session.e.p(th2, new StringBuilder("disconnectBlueToothConnection 异常：")));
        }
    }

    public final boolean i(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.f18059i;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 16) == 0) {
            return false;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)", "");
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
        UUID uuid = y5.a.f19996d;
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(uuid);
        if (descriptor != null) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "Enabling notifications for " + bluetoothGattCharacteristic.getUuid(), "");
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "gatt.writeDescriptor(" + uuid + ")", "");
            return bluetoothGatt.writeDescriptor(descriptor);
        }
        return false;
    }

    public final int j() {
        return y5.d.f20005b ? this.f18063m - 3 : this.f18063m - 16;
    }

    public final boolean l() {
        BluetoothAdapter bluetoothAdapter = this.f18056f;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public final boolean m(u5.d dVar) {
        Iterator it = this.f18052a.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null && weakReference.get() == dVar) {
                return true;
            }
        }
        return false;
    }

    public final void n() {
        r();
        Iterator it = this.f18052a.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null) {
                ((u5.d) weakReference.get()).e0(this.e);
            }
        }
    }

    public final void o() {
        r();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "服务发现失败");
        Iterator it = this.f18052a.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null) {
                ((u5.d) weakReference.get()).I(this.e, 1);
            }
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        char c9;
        super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        if (!bluetoothGattCharacteristic.getUuid().equals(y5.a.f19995c)) {
            if (bluetoothGattCharacteristic.getUuid().equals(y5.a.f19998g)) {
                int i3 = com.example.blesdk.service.b.f7281a;
                com.example.blesdk.service.b.b(bluetoothGattCharacteristic.getValue());
                return;
            }
            if (bluetoothGattCharacteristic.getUuid().equals(y5.a.f20000i)) {
                boolean z5 = b0.f7293a;
                byte[] data = bluetoothGattCharacteristic.getValue();
                kotlin.jvm.internal.e.f(data, "data");
                if (data.length < 2) {
                    return;
                }
                int i10 = (data[0] & 255) | ((data[1] & 255) << 8);
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "收到通知 opcode: 0x".concat(String.format("%04X", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1))));
                if (i10 == 65286 && b0.f7293a && data.length >= 3) {
                    int i11 = data[2] & 255;
                    if (i11 != 0) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", l0.j(i11, "Telink OTA失败, result: "));
                        b0.b();
                        com.example.test.presenter.device.e eVar = b0.f7299h;
                        if (eVar != null) {
                            eVar.a(4);
                            return;
                        }
                        return;
                    }
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "Telink OTA成功");
                    b0.b();
                    com.example.test.presenter.device.e eVar2 = b0.f7299h;
                    if (eVar2 != null) {
                        eVar2.b(1.0f);
                        com.example.test.presenter.device.e eVar3 = b0.f7299h;
                        if (eVar3 != null) {
                            eVar3.onFinish();
                            return;
                        } else {
                            kotlin.jvm.internal.e.m("fileCallback");
                            throw null;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        byte[] value = bluetoothGattCharacteristic.getValue();
        Log.e("qob", "receiveBleData " + value.length + " isJLPlatform " + y5.d.f20005b);
        if (!y5.d.f20005b) {
            x5.d.c().h(value);
            return;
        }
        x5.c b3 = x5.c.b();
        synchronized (b3) {
            try {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "接收到指令 --> ", y5.b.h(value));
                if (value[0] != -85 && b3.f19804d.f19785a <= 1) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "接收到其他指令，不处理 --> ", y5.b.h(value));
                    byte[] bArr = ((BleSendBean) b3.f19803c.get(0)).willSendData;
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "原始发送指令 --> ", y5.b.h(bArr));
                    if (bArr.length >= 9) {
                        String i12 = y5.b.i(new byte[]{bArr[6], bArr[7], bArr[8]});
                        HashMap hashMap = y5.c.f20003a;
                        x5.b.I0().G0(hashMap.containsKey(i12) ? ((Byte) hashMap.get(i12)).byteValue() : (byte) 0);
                    }
                    b3.e();
                }
                x5.a aVar = b3.f19804d;
                if (aVar.f19785a == 1) {
                    aVar.f19787c = value[1];
                    aVar.f19790g = y5.b.j(new byte[]{value[2], value[3]});
                    c9 = 2;
                    b3.f19804d.f19791h = y5.b.h(new byte[]{value[4], value[5]}).replaceAll(" ", "");
                    x5.a aVar2 = b3.f19804d;
                    aVar2.f19788d = value[6];
                    aVar2.e = value[7];
                    aVar2.f19789f = value[8];
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "接收到指令解析 --> ", "protocolFlag = " + ((int) b3.f19804d.f19787c) + " ，CRC = " + b3.f19804d.f19791h + " ，CMD = " + ((int) b3.f19804d.f19788d) + " ，Key = " + ((int) b3.f19804d.e) + " ，KeyFlag = " + ((int) b3.f19804d.f19789f) + " ，dataLen = " + b3.f19804d.f19790g);
                    x5.a aVar3 = b3.f19804d;
                    int i13 = aVar3.f19790g;
                    aVar3.f19792i = new byte[i13];
                    if (i13 > k().j()) {
                        int j4 = (b3.f19804d.f19790g - k().j()) / k().j();
                        if ((b3.f19804d.f19790g - k().j()) % k().j() > 0) {
                            j4++;
                        }
                        b3.f19804d.f19785a = j4 + 1;
                    }
                } else {
                    c9 = 2;
                }
                x5.a aVar4 = b3.f19804d;
                int i14 = aVar4.f19785a;
                if (i14 <= 1 || aVar4.f19786b >= i14) {
                    if (i14 > 1) {
                        System.arraycopy(value, 0, aVar4.f19792i, aVar4.f19793j, value.length);
                    } else {
                        System.arraycopy(value, 6, aVar4.f19792i, aVar4.f19793j, aVar4.f19790g);
                    }
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "接收到指令分包解析 --> ", "content byte = " + y5.b.h(b3.f19804d.f19792i));
                    x5.a aVar5 = b3.f19804d;
                    if (!aVar5.f19791h.equals(y5.d.a(aVar5.f19792i))) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "包内容解析 --> 包校验失败，给设备回馈失败");
                        return;
                    }
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "包内容解析 --> 包校验通过");
                    x5.a aVar6 = b3.f19804d;
                    if (aVar6.f19787c != 17) {
                        byte b10 = aVar6.f19788d;
                        byte b11 = aVar6.e;
                        byte b12 = aVar6.f19789f;
                        byte[] bArr2 = new byte[3];
                        bArr2[0] = b10;
                        bArr2[1] = b11;
                        bArr2[c9] = b12;
                        if (b10 == 6 && b11 == 9) {
                            bArr2 = new byte[4];
                            bArr2[0] = b10;
                            bArr2[1] = b11;
                            bArr2[c9] = b12;
                            bArr2[3] = 0;
                        }
                        b3.g((byte) 17, bArr2, true);
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "接收到设备端发送过来的数据 --> ", y5.b.h(b3.f19804d.f19792i));
                    }
                    Log.e("qob", "analysisJLData getProtocolFlag " + ((int) b3.f19804d.f19787c));
                    x5.a aVar7 = b3.f19804d;
                    b3.f(aVar7.f19787c, aVar7.f19788d, aVar7.e, aVar7.f19789f, aVar7.f19792i);
                    x5.b I0 = x5.b.I0();
                    x5.a aVar8 = b3.f19804d;
                    I0.z(aVar8.f19787c, aVar8.f19792i);
                    x5.a aVar9 = b3.f19804d;
                    aVar9.f19785a = 1;
                    aVar9.f19786b = 1;
                    aVar9.f19787c = (byte) 0;
                    aVar9.f19788d = (byte) 0;
                    aVar9.e = (byte) 0;
                    aVar9.f19789f = (byte) 0;
                    aVar9.f19790g = 0;
                    aVar9.f19791h = "";
                    aVar9.f19792i = null;
                    aVar9.f19793j = 0;
                } else {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "进行多包处理, 包数：" + b3.f19804d.f19785a);
                    x5.a aVar10 = b3.f19804d;
                    if (aVar10.f19786b == 1) {
                        System.arraycopy(value, 6, aVar10.f19792i, aVar10.f19793j, value.length - 6);
                        b3.f19804d.f19793j += value.length - 6;
                    } else {
                        System.arraycopy(value, 0, aVar10.f19792i, aVar10.f19793j, value.length);
                        b3.f19804d.f19793j += value.length;
                    }
                    b3.f19804d.f19786b++;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        String str;
        if (i3 == 0) {
            StringBuilder sb2 = new StringBuilder("Read Response received from ");
            sb2.append(bluetoothGattCharacteristic.getUuid());
            sb2.append(", value: ");
            char[] cArr = y5.e.f20008a;
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (value == null || value.length == 0) {
                str = "";
            } else {
                char[] cArr2 = new char[(value.length * 3) - 1];
                for (int i10 = 0; i10 < value.length; i10++) {
                    byte b3 = value[i10];
                    int i11 = i10 * 3;
                    char[] cArr3 = y5.e.f20008a;
                    cArr2[i11] = cArr3[(b3 & 255) >>> 4];
                    cArr2[i11 + 1] = cArr3[b3 & 15];
                    if (i10 != value.length - 1) {
                        cArr2[i11 + 2] = '-';
                    }
                }
                str = "(0x) ".concat(new String(cArr2));
            }
            sb2.append(str);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", sb2.toString(), "");
            if (bluetoothGattCharacteristic.getUuid().equals(y5.a.f19998g)) {
                int i12 = com.example.blesdk.service.b.f7281a;
                com.example.blesdk.service.b.b(bluetoothGattCharacteristic.getValue());
            }
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        if (i3 != 0) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", l0.j(i3, "onCharacteristicWrite 系统写入失败"));
            return;
        }
        if (bluetoothGattCharacteristic.getUuid().equals(y5.a.f19998g)) {
            int i10 = com.example.blesdk.service.b.f7281a;
            System.out.println((Object) "pxi写数据完成");
            int i11 = com.example.blesdk.service.b.f7290k + 1;
            com.example.blesdk.service.b.f7290k = i11;
            if (i11 < com.example.blesdk.service.b.f7291l.size()) {
                com.example.blesdk.service.b.e((byte[]) com.example.blesdk.service.b.f7291l.get(com.example.blesdk.service.b.f7290k));
            }
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (bluetoothGattCharacteristic.getValue().length == 5 && (value[0] & 255) == 39 && !this.r) {
                this.f18055d.sendEmptyMessageDelayed(20, 1000L);
                return;
            }
            return;
        }
        if (bluetoothGattCharacteristic.getUuid().equals(y5.a.f20000i)) {
            b0.a();
            return;
        }
        if (!y5.d.f20005b) {
            x5.d c9 = x5.d.c();
            byte[] value2 = bluetoothGattCharacteristic.getValue();
            BleSendBean bleSendBean = (BleSendBean) c9.f19809d.get(0);
            if (bleSendBean.sendMsgId == -1) {
                c9.g();
                return;
            }
            if (value2.length < 3 || !x5.d.d(value2[2])) {
                bleSendBean.gattWriteFinish = 2;
                if (bleSendBean.receivedFECmd == 1) {
                    c9.g();
                    return;
                }
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerUtils", "onNextFile 大文件传输指令不用等待回调应答");
            c9.f19809d.remove(0);
            c9.f19806a = 0;
            c.h().n(false, value2);
            return;
        }
        x5.c b3 = x5.c.b();
        bluetoothGattCharacteristic.getValue();
        synchronized (b3) {
            try {
                BleSendBean bleSendBean2 = (BleSendBean) b3.f19803c.get(0);
                byte b10 = bleSendBean2.sendMsgId;
                if (b10 != 17 && b10 != -58) {
                    bleSendBean2.gattWriteFinish = 2;
                    if (bleSendBean2.receivedFECmd == 1) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "onNextFileForJL 已收到答复指令出队列 " + b3.f19803c.size());
                        b3.e();
                    }
                }
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHandlerJLUtils", "onNextFileForJL 答复指令直接出队列 " + b3.f19803c.size());
                b3.e();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i3, int i10) {
        e eVar = this.f18055d;
        if (i3 != 0) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", l0.j(i3, "收到蓝牙断开回调，蓝牙已异常断开 STATUS = "));
            eVar.sendEmptyMessage(3);
            d(i3);
            return;
        }
        if (i10 == 0) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "收到蓝牙断开回调，蓝牙已断开");
            a();
        } else {
            if (i10 != 2) {
                return;
            }
            eVar.removeCallbacksAndMessages(null);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "蓝牙连接成功，开始搜索服务, 移除连接超时10000S");
            this.f18059i.requestConnectionPriority(1);
            boolean discoverServices = this.f18059i.discoverServices();
            this.f18062l = discoverServices;
            if (discoverServices) {
                eVar.sendEmptyMessageDelayed(5, 30000L);
            } else {
                o();
            }
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
        if (i3 == 0) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "Data written to descriptor. " + bluetoothGattDescriptor.getUuid() + ", enableNotificationsIndex: " + this.f18070u);
            int i10 = this.f18070u + 1;
            this.f18070u = i10;
            int i11 = this.f18071v;
            if (i10 < i11 && this.f18067q != null) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "onDescriptorWrite 使能Telink OTA特征");
                i(this.f18067q);
                return;
            }
            if (i10 < i11 && this.f18066p != null) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "onDescriptorWrite 使能原相特征");
                i(this.f18066p);
                return;
            }
            if (!y5.d.f20005b) {
                bluetoothGatt.requestMtu(239);
            } else if (y5.d.f20006c) {
                bluetoothGatt.requestMtu(185);
            } else {
                bluetoothGatt.requestMtu(509);
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "onDescriptorWrite requestMtu 清除DEVICE_SERVICE_NOTIFY_CONNECT超时");
            if (this.r) {
                return;
            }
            e eVar = this.f18055d;
            eVar.removeCallbacksAndMessages(null);
            eVar.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i3, int i10) {
        super.onMtuChanged(bluetoothGatt, i3, i10);
        StringBuilder s7 = l0.s(i3, "onMtuChanged ", i10, " status ", " isRelease ");
        s7.append(this.r);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", s7.toString());
        if (y5.d.f20005b) {
            this.f18063m = i3 - 3;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i3, int i10) {
        super.onReadRemoteRssi(bluetoothGatt, i3, i10);
        a.h(i3, "onReadRemoteRssi rssi ", "qob");
        Iterator it = this.f18052a.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null) {
                ((u5.d) weakReference.get()).getClass();
            }
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i3) {
        if (!this.f18062l) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "蓝牙发现服务，状态异常");
            return;
        }
        this.f18069t = false;
        this.f18070u = 0;
        this.f18071v = 1;
        this.f18066p = null;
        this.f18067q = null;
        y5.d.f20007d = false;
        if (i3 != 0) {
            p();
            o();
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "蓝牙服务发现");
        y5.d.f20005b = false;
        y5.d.f20006c = false;
        if (bluetoothGatt.getService(y5.a.e) != null) {
            y5.d.f20005b = true;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "获取杰里蓝牙服务 " + y5.d.f20005b);
        } else {
            y5.d.f20005b = false;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "获取瑞昱蓝牙服务");
        }
        BluetoothGattService service = bluetoothGatt.getService(y5.a.f19999h);
        if (service != null) {
            y5.d.f20005b = true;
            y5.d.f20006c = true;
            y5.d.f20007d = true;
            this.f18067q = service.getCharacteristic(y5.a.f20000i);
            this.f18071v = 2;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "获取Telink OTA蓝牙服务");
        } else {
            BluetoothGattService service2 = bluetoothGatt.getService(y5.a.f19997f);
            if (service2 != null) {
                y5.d.f20005b = true;
                y5.d.f20006c = true;
                this.f18066p = service2.getCharacteristic(y5.a.f19998g);
                this.f18071v = 2;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "获取智能戒指pxi OTA蓝牙服务");
            }
        }
        BluetoothGattService service3 = bluetoothGatt.getService(y5.a.f19993a);
        if (service3 != null) {
            this.f18065o = service3.getCharacteristic(y5.a.f19994b);
        } else {
            this.f18069t = true;
            if (!this.r) {
                this.f18055d.sendEmptyMessageDelayed(10, 2000L);
            }
        }
        if (service3 != null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "通知使能监听：" + i(service3.getCharacteristic(y5.a.f19995c)) + " enableNotificationsCount " + this.f18071v);
        }
    }

    public final void p() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "refreshDeviceCache");
        if (this.f18059i != null) {
            try {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "bluetoothGatt--refreshDeviceCache");
                BluetoothGatt bluetoothGatt = this.f18059i;
                ((Boolean) bluetoothGatt.getClass().getMethod("refresh", null).invoke(bluetoothGatt, null)).getClass();
            } catch (Exception e) {
                e.printStackTrace();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "An exception occured while refreshing device");
            }
        }
    }

    public final void q(u5.d dVar) {
        if (m(dVar)) {
            return;
        }
        Log.e("qob", "registerScanBleCallback " + dVar.getClass());
        this.f18052a.add(new WeakReference(dVar));
    }

    public final void r() {
        s5.a aVar = this.e;
        if (aVar != null) {
            aVar.f18213d = 0;
        }
        this.r = false;
        this.f18053b = false;
        this.f18062l = false;
        this.f18065o = null;
        this.f18068s = false;
        this.f18054c = false;
        if (y5.d.f20005b) {
            this.f18064n = 230;
        } else {
            this.f18064n = 100;
        }
    }

    @Override // o5.a
    public final void r0(Message message) {
        BluetoothManager bluetoothManager;
        int i3 = message.what;
        if (i3 == 0) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "10000s超时,直连失败开启扫描连接");
            this.f18073x = true;
            h();
            return;
        }
        if (i3 == 1) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "onMessage DEVICE_SCAN_CONNECT 10s超时");
            this.r = true;
            this.f18072w = false;
            this.f18073x = false;
            e(false);
            n();
            return;
        }
        if (i3 == 5) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "onMessage DEVICE_SERVICE_NOTIFY_CONNECT 30s超时");
            this.r = true;
            this.f18072w = false;
            this.f18073x = false;
            e(false);
            n();
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f18052a;
        e eVar = this.f18055d;
        if (i3 == 2) {
            this.f18072w = false;
            this.f18073x = false;
            eVar.removeCallbacksAndMessages(null);
            if (System.currentTimeMillis() - this.f18061k > Const.FENCE_STATED_MIN_TIME) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", android.support.v4.media.session.e.n(new StringBuilder("连接成功, 超10分钟，耗时 "), System.currentTimeMillis() - this.f18061k, " 毫秒"));
                a();
                return;
            }
            this.f18054c = true;
            this.e.f18213d = 1;
            this.f18053b = false;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", android.support.v4.media.session.e.n(new StringBuilder("连接成功，耗时 "), System.currentTimeMillis() - this.f18061k, " 毫秒"));
            d.d().h(this);
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null) {
                    ((u5.d) weakReference.get()).h0(this.e);
                }
            }
            return;
        }
        if (i3 == 3) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "蓝牙断开回调 isDisconnectNeedFindDevice " + this.f18073x);
            this.f18072w = false;
            eVar.removeCallbacksAndMessages(null);
            if (this.f18073x) {
                this.f18073x = false;
                d d5 = d.d();
                XXApplication xXApplication = this.f18060j;
                d5.f18090f = xXApplication;
                if (xXApplication != null && (bluetoothManager = (BluetoothManager) xXApplication.getSystemService("bluetooth")) != null) {
                    d5.f18091g = bluetoothManager.getAdapter();
                }
                d d8 = d.d();
                if (!d8.e(this)) {
                    d8.f18088c.add(new WeakReference(this));
                }
                s5.a aVar = this.e;
                String str = aVar != null ? aVar.f18212c : null;
                this.f18072w = true;
                d.d().f(str, true);
                eVar.sendEmptyMessageDelayed(1, 10000L);
            }
            r();
            Iterator it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                WeakReference weakReference2 = (WeakReference) it2.next();
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((u5.d) weakReference2.get()).v(this.e);
                }
            }
            return;
        }
        if (i3 == 4) {
            this.f18073x = false;
            this.f18072w = false;
            eVar.removeCallbacksAndMessages(null);
            int intValue = ((Integer) message.obj).intValue();
            r();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", android.support.v4.media.session.e.n(new StringBuilder("连接失败，耗时 "), System.currentTimeMillis() - this.f18061k, " 毫秒"));
            Iterator it3 = copyOnWriteArrayList.iterator();
            while (it3.hasNext()) {
                WeakReference weakReference3 = (WeakReference) it3.next();
                if (weakReference3 != null && weakReference3.get() != null) {
                    ((u5.d) weakReference3.get()).I(this.e, intValue);
                }
            }
            return;
        }
        if (i3 != 10) {
            if (i3 == 20) {
                this.f18073x = false;
                this.f18072w = false;
                eVar.removeCallbacksAndMessages(null);
                Log.e("ConnectBleService", "onMessage DEVICE_PXI_CMD_FW_OTA_INIT_NEW");
                this.f18059i.readCharacteristic(this.f18066p);
                return;
            }
            return;
        }
        this.f18073x = false;
        this.f18072w = false;
        eVar.removeCallbacksAndMessages(null);
        this.f18053b = false;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", android.support.v4.media.session.e.n(new StringBuilder("OTA失败 连接成功，耗时 "), System.currentTimeMillis() - this.f18061k, " 毫秒"));
        d.d().h(this);
        Iterator it4 = copyOnWriteArrayList.iterator();
        while (it4.hasNext()) {
            WeakReference weakReference4 = (WeakReference) it4.next();
            if (weakReference4 != null && weakReference4.get() != null) {
                ((u5.d) weakReference4.get()).m0(this.e);
            }
        }
    }

    public final boolean s(byte[] bArr) {
        byte b3;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f18065o;
        if (bluetoothGattCharacteristic == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "写入特征值为空");
            return false;
        }
        bluetoothGattCharacteristic.setValue(bArr);
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.f18065o;
        BluetoothGatt bluetoothGatt = this.f18059i;
        if (bluetoothGatt == null || bluetoothGattCharacteristic2 == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "写characteristic is  null ", "");
            return false;
        }
        if ((bluetoothGattCharacteristic2.getProperties() & 12) == 0) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "Writing characteristic 不支持写功能", "");
            return false;
        }
        boolean writeCharacteristic = bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic2);
        byte[] value = bluetoothGattCharacteristic2.getValue();
        if (value != null && value.length >= 2 && ((b3 = value[2]) == -124 || b3 == Byte.MIN_VALUE || b3 == -123 || b3 == -126 || b3 == -122)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "write " + writeCharacteristic + ",file transfer");
            return writeCharacteristic;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "write " + writeCharacteristic + Const.STR_MART_COMMA + bluetoothGattCharacteristic2.getValue().length);
        return writeCharacteristic;
    }
}
