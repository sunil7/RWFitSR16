package l6;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.app.y;
import androidx.camera.core.impl.c1;
import com.example.test.XXApplication;
import com.example.test.tool.ota.ble.model.BleScanInfo;
import com.google.android.gms.internal.mlkit_vision_barcode.qd;
import com.google.android.gms.internal.mlkit_vision_barcode.ub;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: o, reason: collision with root package name */
    public static volatile o f15804o;

    /* renamed from: p, reason: collision with root package name */
    public static final UUID f15805p = pd.a.f17537a;

    /* renamed from: q, reason: collision with root package name */
    public static final UUID f15806q = pd.a.f17538b;
    public static final UUID r = pd.a.f17539c;

    /* renamed from: s, reason: collision with root package name */
    public static final UUID f15807s = UUID.fromString("00002902-0000-1000-8000-00805F9B34FB");

    /* renamed from: a, reason: collision with root package name */
    public final XXApplication f15808a;

    /* renamed from: c, reason: collision with root package name */
    public final y f15810c;

    /* renamed from: d, reason: collision with root package name */
    public final BluetoothAdapter f15811d;
    public volatile BluetoothDevice e;

    /* renamed from: f, reason: collision with root package name */
    public volatile BluetoothDevice f15812f;

    /* renamed from: j, reason: collision with root package name */
    public n f15816j;

    /* renamed from: n, reason: collision with root package name */
    public final m f15820n;

    /* renamed from: b, reason: collision with root package name */
    public final j6.a f15809b = j6.a.f15325b.g();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f15813g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f15814h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final j f15815i = new j();

    /* renamed from: k, reason: collision with root package name */
    public int f15817k = 0;

    /* renamed from: l, reason: collision with root package name */
    public long f15818l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f15819m = new Handler(Looper.getMainLooper(), new de.j(this, 3));

    public o(XXApplication xXApplication) {
        new k(this, 0);
        new l(this, 0);
        this.f15820n = new m(this);
        this.f15808a = xXApplication;
        WeakReference weakReference = ub.f9549a;
        if ((weakReference == null ? null : (Context) weakReference.get()) == null) {
            ub.f9549a = new WeakReference(xXApplication);
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.f15811d = defaultAdapter;
        if (defaultAdapter != null) {
            defaultAdapter.getBluetoothLeScanner();
        }
        if (this.f15810c == null) {
            this.f15810c = new y(this, 1);
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            xXApplication.registerReceiver(this.f15810c, intentFilter);
        }
    }

    public final boolean a(BluetoothDevice bluetoothDevice) {
        BluetoothGatt bluetoothGatt;
        if (bluetoothDevice != null && qd.a(this.f15808a)) {
            if (this.e != null) {
                ee.c.b(5, "o", "BleDevice is connecting, please wait.");
                return ee.a.b(this.e, bluetoothDevice);
            }
            try {
                bluetoothGatt = bluetoothDevice.connectGatt(this.f15808a, false, this.f15820n, 2);
            } catch (Exception e) {
                e.printStackTrace();
                bluetoothGatt = null;
            }
            r0 = bluetoothGatt != null;
            if (r0) {
                this.e = bluetoothDevice;
                f(bluetoothDevice, 1);
                Handler handler = this.f15819m;
                if (!handler.hasMessages(4113)) {
                    handler.sendMessageDelayed(handler.obtainMessage(4113, bluetoothDevice), 40000L);
                }
                ee.c.b(2, "o", "connect start...." + ee.a.e(this.f15808a, bluetoothDevice));
            }
        }
        return r0;
    }

    public final void b(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            XXApplication xXApplication = this.f15808a;
            if (qd.a(xXApplication)) {
                n6.b g10 = g(bluetoothDevice);
                ee.c.b(3, "o", "disconnectBleDevice : " + ee.a.e(xXApplication, bluetoothDevice) + ", " + g10);
                if (g10 == null) {
                    ee.c.b(3, "o", "disconnectBleDevice : It is not a connected device.");
                } else if (ee.a.d()) {
                    g10.f16383b.disconnect();
                }
            }
        }
    }

    public final void c(BluetoothDevice bluetoothDevice, int i3, byte[] bArr, boolean z5) {
        BluetoothAdapter bluetoothAdapter;
        XXApplication xXApplication = this.f15808a;
        if (!qd.a(xXApplication) || (bluetoothAdapter = this.f15811d) == null || !bluetoothAdapter.isEnabled() || TextUtils.isEmpty(bluetoothDevice.getName())) {
            return;
        }
        ArrayList arrayList = this.f15814h;
        if (arrayList.contains(bluetoothDevice)) {
            return;
        }
        ee.c.b(2, "o", "notify device : " + ee.a.e(xXApplication, bluetoothDevice));
        arrayList.add(bluetoothDevice);
        BleScanInfo bleScanInfo = new BleScanInfo();
        bleScanInfo.b(bArr);
        bleScanInfo.d(i3);
        bleScanInfo.a(z5);
        this.f15815i.h(bluetoothDevice, bleScanInfo);
    }

    public final n6.b d(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        return (n6.b) this.f15813g.get(bluetoothDevice.getAddress());
    }

    public final void e(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            ee.c.b(5, "o", "-handleBleConnectedEvent- device is null.");
            return;
        }
        this.f15819m.removeMessages(4116);
        n6.b d5 = d(bluetoothDevice);
        q qVar = d5.e;
        if (qVar == null || !qVar.f15827b) {
            q qVar2 = new q(new mc.g(d5, 4), new n6.a(d5, 0));
            d5.e = qVar2;
            qVar2.start();
        }
        f(bluetoothDevice, 2);
    }

    public final void f(BluetoothDevice bluetoothDevice, int i3) {
        if (i3 == 0 || i3 == 2) {
            this.f15819m.removeMessages(4115);
            this.f15818l = 0L;
        } else if (i3 == 1) {
            this.f15818l = System.currentTimeMillis();
        }
        ee.c.b(3, "o", "handleBleConnection >> device : " + ee.a.e(this.f15808a, bluetoothDevice) + ", status : " + i3);
        this.f15815i.b(bluetoothDevice, i3);
    }

    public final n6.b g(BluetoothDevice bluetoothDevice) {
        ArrayList arrayList;
        if (bluetoothDevice != null) {
            String address = bluetoothDevice.getAddress();
            if (BluetoothAdapter.checkBluetoothAddress(address)) {
                n6.b bVar = (n6.b) this.f15813g.remove(address);
                if (bVar != null) {
                    q qVar = bVar.e;
                    if (qVar != null) {
                        synchronized (qVar) {
                            qVar.f15827b = false;
                            qVar.c(null);
                        }
                    }
                    if (this.f15813g.isEmpty()) {
                        this.f15812f = null;
                        return bVar;
                    }
                    if (bVar.f16383b.getDevice() != null && ee.a.b(bVar.f16383b.getDevice(), this.f15812f)) {
                        HashMap hashMap = this.f15813g;
                        if (hashMap.isEmpty()) {
                            arrayList = new ArrayList();
                        } else {
                            ArrayList arrayList2 = new ArrayList(hashMap.values());
                            Collections.sort(arrayList2, new c1(4));
                            arrayList = arrayList2;
                        }
                        this.f15812f = ((n6.b) arrayList.get(0)).f16383b.getDevice();
                    }
                }
                return bVar;
            }
        }
        return null;
    }

    public final boolean h(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3, boolean z5) {
        if (qd.a(this.f15808a)) {
            if (!z5) {
                z5 = bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                ee.c.b(3, "o", "..descriptor : .setValue  ret : " + z5);
                if (z5) {
                    i3 = 0;
                } else {
                    i3++;
                    if (i3 < 3) {
                        ee.c.b(3, "o", "-tryToWriteDescriptor- : retryCount : " + i3 + ", isSkipSetValue :  false");
                        SystemClock.sleep(50L);
                        h(bluetoothGatt, bluetoothGattDescriptor, i3, false);
                    }
                }
            }
            if (z5) {
                z5 = bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                ee.c.b(3, "o", "..bluetoothGatt : .writeDescriptor  ret : " + z5);
                if (!z5) {
                    int i10 = i3 + 1;
                    if (i10 < 3) {
                        ee.c.b(3, "o", "-tryToWriteDescriptor- 2222 : retryCount : " + i10 + ", isSkipSetValue :  true");
                        SystemClock.sleep(50L);
                        h(bluetoothGatt, bluetoothGattDescriptor, i10, true);
                    }
                }
            }
            return z5;
        }
        return false;
    }
}
