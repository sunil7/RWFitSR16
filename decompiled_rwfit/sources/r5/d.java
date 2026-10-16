package r5;

import a1.g;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.example.baselibrary.utils.e;
import com.example.blesdk.ble.scan.ScanResult;
import com.example.blesdk.ble.scan.ScanSettings;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import t5.i;
import t5.k;
import u5.j;

/* loaded from: classes.dex */
public final class d extends i implements o5.a {

    /* renamed from: h, reason: collision with root package name */
    public static d f18085h;

    /* renamed from: a, reason: collision with root package name */
    public boolean f18086a;

    /* renamed from: b, reason: collision with root package name */
    public e f18087b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList f18088c;

    /* renamed from: d, reason: collision with root package name */
    public long f18089d;
    public t5.b e;

    /* renamed from: f, reason: collision with root package name */
    public Context f18090f;

    /* renamed from: g, reason: collision with root package name */
    public BluetoothAdapter f18091g;

    public static d d() {
        if (f18085h == null) {
            synchronized (d.class) {
                d dVar = new d();
                dVar.f18088c = new LinkedList();
                dVar.f18087b = new e(dVar);
                dVar.e = t5.b.a();
                f18085h = dVar;
            }
        }
        return f18085h;
    }

    @Override // t5.i
    public final void b(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", l0.j(i3, "扫描失败："));
        g();
    }

    @Override // t5.i
    public final void c(int i3, ScanResult scanResult) {
        String str;
        if (scanResult.d() == null || scanResult.a().getName() == null || scanResult.d().f18555g == null || scanResult.d().f18555g.length < 9) {
            return;
        }
        Arrays.copyOf(scanResult.d().f18555g, 9);
        String h4 = y5.b.h(scanResult.d().f18555g);
        if (h4.contains("02 01 06 03 03 0a a0") || h4.contains("d6 05 02 00") || h4.contains("15 ff d6 05 41 54") || h4.contains("d6 06 02 00")) {
            s5.a aVar = new s5.a();
            aVar.f18210a = scanResult.a().getName() == null ? "Unnamed" : scanResult.a().getName();
            aVar.f18212c = scanResult.a().getAddress();
            aVar.f18211b = scanResult.b();
            aVar.f18214f = h4.replaceAll(" ", "").toUpperCase();
            if (h4.contains("02 01 06 03 03 0a a0")) {
                aVar.f18215g = 1;
                if (aVar.a()) {
                    aVar.f18215g = 3;
                }
            } else if (h4.contains("d6 06 02 00")) {
                String str2 = aVar.f18214f;
                String str3 = aVar.f18212c;
                if (str2 != null && str3 != null) {
                    String upperCase = str3.replace(":", "").toUpperCase();
                    String upperCase2 = str2.toUpperCase();
                    if (upperCase2.contains(upperCase)) {
                        String[] split = upperCase2.split(upperCase);
                        if (split.length > 1) {
                            String str4 = split[1];
                            if (str4.length() > 20) {
                                String substring = str4.substring(6, 22);
                                if (!substring.matches("0+")) {
                                    int i10 = 0;
                                    while (i10 < substring.length()) {
                                        int i11 = i10 + 2;
                                        try {
                                            Integer.parseInt(substring.substring(i10, i11), 16);
                                            i10 = i11;
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                aVar.f18215g = 4;
            } else if (h4.contains("15 ff d6 05 41 54")) {
                aVar.f18215g = 239;
            } else {
                aVar.f18215g = 2;
                if (aVar.a()) {
                    aVar.f18215g = 3;
                }
            }
            String str5 = aVar.f18210a;
            if (str5 == null || str5.isEmpty() || (str = aVar.f18210a) == null || str.length() == 0) {
                return;
            }
            Iterator it = this.f18088c.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() != null) {
                    ((j) weakReference.get()).g(aVar);
                }
            }
        }
    }

    public final boolean e(j jVar) {
        Iterator it = this.f18088c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null && weakReference.get() == jVar) {
                return true;
            }
        }
        return false;
    }

    public final void f(String str, boolean z5) {
        BluetoothAdapter bluetoothAdapter = this.f18091g;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", "蓝牙未打开，不可用 ");
            return;
        }
        BluetoothAdapter bluetoothAdapter2 = this.f18091g;
        if (bluetoothAdapter2 == null || !bluetoothAdapter2.isEnabled()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", "蓝牙异常，不可用 ");
            return;
        }
        if (z5) {
            Set<BluetoothDevice> bondedDevices = this.f18091g.getBondedDevices();
            boolean z6 = g.a(this.f18090f, "android.permission.BLUETOOTH_CONNECT") != 0;
            if (!bondedDevices.isEmpty() && z6) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", "已绑定设备");
                for (BluetoothDevice bluetoothDevice : bondedDevices.stream()) {
                    String name = bluetoothDevice.getName();
                    if (name != null && name.length() != 0 && bluetoothDevice.getType() == 2) {
                        int connectionState = ((BluetoothManager) this.f18090f.getSystemService("bluetooth")).getConnectionState(bluetoothDevice, 7);
                        StringBuilder sb2 = new StringBuilder("设备：");
                        sb2.append(bluetoothDevice.getAddress());
                        sb2.append(" 名字：");
                        sb2.append(bluetoothDevice.getName());
                        sb2.append("是否绑定：");
                        sb2.append(bluetoothDevice.getBondState() == 12);
                        sb2.append(" 类型 = ");
                        sb2.append(bluetoothDevice.getType());
                        sb2.append(" 连接状态 = ");
                        sb2.append(connectionState);
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", sb2.toString());
                        if (connectionState == 2 && (str == null || "".equals(str.trim()) || str.equals(bluetoothDevice.getAddress()))) {
                            s5.a aVar = new s5.a();
                            aVar.f18212c = bluetoothDevice.getAddress();
                            aVar.f18210a = bluetoothDevice.getName();
                            b.k().c(aVar);
                            return;
                        }
                    }
                }
            }
        }
        long j4 = (str == null || str.isEmpty()) ? 10000L : 5000L;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", "是否正在扫描：" + this.f18086a + " 上次扫面时间差：" + (System.currentTimeMillis() - this.f18089d));
        boolean z8 = this.f18086a;
        e eVar = this.f18087b;
        if (z8 || System.currentTimeMillis() - this.f18089d < j4) {
            if (this.f18086a) {
                return;
            }
            eVar.removeMessages(1);
            eVar.sendEmptyMessageDelayed(1, j4 - (System.currentTimeMillis() - this.f18089d));
            return;
        }
        this.f18086a = true;
        this.f18089d = System.currentTimeMillis();
        k kVar = new k();
        kVar.c(1);
        kVar.b(1);
        ScanSettings a3 = kVar.a();
        try {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", "开始扫描设备");
            t5.b bVar = this.e;
            bVar.getClass();
            bVar.b(Collections.EMPTY_LIST, a3, this, new Handler(Looper.getMainLooper()));
            eVar.removeMessages(0);
            eVar.sendEmptyMessageDelayed(0, j4);
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", "开始扫描异常 " + e.getMessage());
            this.f18086a = false;
            this.f18089d = 0L;
        }
    }

    public final void g() {
        this.f18087b.removeMessages(0);
        if (this.f18086a) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", "停止蓝牙扫描");
            this.f18086a = false;
            try {
                this.e.c(this);
            } catch (Exception e) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", "扫描停止错误 " + e.getMessage());
            }
            StringBuilder sb2 = new StringBuilder("onScanFinish size ");
            LinkedList linkedList = this.f18088c;
            sb2.append(linkedList.size());
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", sb2.toString());
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() != null) {
                    ((j) weakReference.get()).f();
                }
            }
        }
    }

    public final void h(j jVar) {
        WeakReference weakReference;
        if (e(jVar)) {
            LinkedList linkedList = this.f18088c;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    weakReference = null;
                    break;
                }
                weakReference = (WeakReference) it.next();
                if (weakReference.get() != null && weakReference.get() == jVar) {
                    break;
                }
            }
            if (weakReference == null) {
                return;
            }
            if (weakReference.get() == null) {
                linkedList.remove(weakReference);
            } else {
                weakReference.clear();
                linkedList.remove(weakReference);
            }
        }
    }

    @Override // o5.a
    public final void r0(Message message) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ScanBleService", "-------------收到handle-------------");
        int i3 = message.what;
        if (i3 == 0) {
            g();
        } else if (i3 == 1) {
            f(null, false);
        }
    }
}
