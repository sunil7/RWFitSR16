package o6;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.app.y;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.qd;
import com.google.android.gms.internal.mlkit_vision_barcode.ub;
import com.jieli.jl_bt_ota.impl.RcspAuth;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import n.m0;

/* loaded from: classes.dex */
public final class p implements f {

    /* renamed from: q, reason: collision with root package name */
    public static volatile p f16784q;
    public static final UUID r = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    /* renamed from: s, reason: collision with root package name */
    public static final UUID f16785s = UUID.fromString("fe010000-1234-5678-abcd-00805f9b34fb");

    /* renamed from: a, reason: collision with root package name */
    public final XXApplication f16786a;

    /* renamed from: b, reason: collision with root package name */
    public final BluetoothAdapter f16787b;

    /* renamed from: c, reason: collision with root package name */
    public final o4.c f16788c;

    /* renamed from: f, reason: collision with root package name */
    public final RcspAuth f16790f;

    /* renamed from: g, reason: collision with root package name */
    public volatile BluetoothDevice f16791g;

    /* renamed from: h, reason: collision with root package name */
    public volatile BluetoothDevice f16792h;

    /* renamed from: i, reason: collision with root package name */
    public volatile BluetoothDevice f16793i;

    /* renamed from: j, reason: collision with root package name */
    public UUID f16794j;

    /* renamed from: k, reason: collision with root package name */
    public final y f16795k;

    /* renamed from: l, reason: collision with root package name */
    public b f16796l;

    /* renamed from: m, reason: collision with root package name */
    public h f16797m;

    /* renamed from: o, reason: collision with root package name */
    public final UUID f16799o;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f16789d = new ArrayList();
    public final HashMap e = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    public final boolean f16798n = j6.a.f15325b.g().f15327a.getBoolean("spp_multiple_channel", false);

    /* renamed from: p, reason: collision with root package name */
    public final Handler f16800p = new Handler(new m(this, 0));

    public p(XXApplication xXApplication) {
        o oVar = new o(this, 0);
        this.f16786a = xXApplication;
        WeakReference weakReference = ub.f9549a;
        if ((weakReference == null ? null : (Context) weakReference.get()) == null) {
            ub.f9549a = new WeakReference(xXApplication);
        }
        this.f16799o = UUID.fromString(xXApplication.getSharedPreferences("ji_bluetooth_ota_preferences", 0).getString("spp_uuid", f16785s.toString()));
        this.f16787b = BluetoothAdapter.getDefaultAdapter();
        this.f16788c = new o4.c(1);
        this.f16790f = new RcspAuth(xXApplication, new n(this), oVar);
        if (this.f16795k == null) {
            this.f16795k = new y(this, 3);
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.UUID");
            xXApplication.registerReceiver(this.f16795k, intentFilter);
        }
    }

    public static String d(BluetoothDevice bluetoothDevice, UUID uuid) {
        if (bluetoothDevice == null || uuid == null) {
            return null;
        }
        return bluetoothDevice.getAddress() + "_" + uuid;
    }

    public final boolean a(BluetoothDevice bluetoothDevice, UUID uuid) {
        ParcelUuid[] uuids;
        if (!qd.a(this.f16786a)) {
            ee.c.b(4, "SppManager", "-connectSpp- miss bluetooth permission.");
            return false;
        }
        if (bluetoothDevice == null || bluetoothDevice.getType() == 2) {
            ee.c.b(4, "SppManager", "-connectSpp-  device is bad object. ");
            return false;
        }
        ee.c.b(3, "SppManager", "-connectSpp- >> device : " + ee.a.e(this.f16786a, bluetoothDevice) + ", sppUUID = " + uuid);
        if (this.f16792h != null) {
            ee.c.b(3, "SppManager", "-connectSpp- >>  device is connecting. device :" + ee.a.e(this.f16786a, this.f16791g));
            return false;
        }
        if (this.f16791g != null) {
            if (ee.a.b(this.f16791g, bluetoothDevice)) {
                if (g(bluetoothDevice, uuid)) {
                    e(bluetoothDevice, uuid, 2);
                    return true;
                }
            } else if (b(this.f16791g, null)) {
                SystemClock.sleep(500L);
            }
        }
        this.f16792h = bluetoothDevice;
        this.f16794j = uuid;
        boolean z5 = qd.a(this.f16786a) && 12 == bluetoothDevice.getBondState();
        ee.c.b(3, "SppManager", "-connectSpp- >> isPaired = " + z5);
        if (z5) {
            if (bluetoothDevice.getUuids() != null) {
                WeakReference weakReference = ub.f9549a;
                Context context = weakReference != null ? (Context) weakReference.get() : null;
                if (ee.a.d() && uuid != null && !TextUtils.isEmpty(uuid.toString()) && ub.a(context) && (uuids = bluetoothDevice.getUuids()) != null) {
                    for (ParcelUuid parcelUuid : uuids) {
                        if (parcelUuid != null && uuid.toString().equalsIgnoreCase(parcelUuid.toString())) {
                            h(bluetoothDevice, uuid);
                            break;
                        }
                    }
                }
            }
            boolean fetchUuidsWithSdp = bluetoothDevice.fetchUuidsWithSdp();
            ee.c.b(3, "SppManager", "-connectSpp- >> fetchUuidsWithSdp = " + fetchUuidsWithSdp);
            if (!fetchUuidsWithSdp) {
                e(bluetoothDevice, uuid, 0);
                return false;
            }
        } else {
            WeakReference weakReference2 = ub.f9549a;
            boolean createBond = !ub.a(weakReference2 != null ? (Context) weakReference2.get() : null) ? false : bluetoothDevice.createBond();
            ee.c.b(3, "SppManager", "-connectSpp- >> createBond = " + createBond);
            if (!createBond) {
                e(bluetoothDevice, uuid, 0);
                return false;
            }
            ee.c.b(2, "SppManager", "-startPairTimeoutTask- device = " + ee.a.e(this.f16786a, bluetoothDevice) + ", sppUUID = " + uuid);
            this.f16800p.removeMessages(1023);
            this.f16793i = bluetoothDevice;
            Bundle bundle = new Bundle();
            bundle.putSerializable("spp_uuid", uuid);
            Message obtainMessage = this.f16800p.obtainMessage(1023, bluetoothDevice);
            obtainMessage.setData(bundle);
            this.f16800p.sendMessageDelayed(obtainMessage, 30000L);
        }
        e(bluetoothDevice, uuid, 1);
        ee.c.b(3, "SppManager", "-startConnectTimeoutTask- device = " + ee.a.e(this.f16786a, bluetoothDevice) + ", sppUUID = " + uuid);
        Handler handler = this.f16800p;
        handler.removeMessages(1024);
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("spp_uuid", uuid);
        Message obtainMessage2 = handler.obtainMessage(1024, bluetoothDevice);
        obtainMessage2.setData(bundle2);
        handler.sendMessageDelayed(obtainMessage2, 40000L);
        return true;
    }

    public final boolean b(BluetoothDevice bluetoothDevice, UUID uuid) {
        int i3 = 0;
        if (!qd.a(this.f16786a)) {
            ee.c.b(4, "SppManager", "-disconnectSpp- miss bluetooth permission.");
            return false;
        }
        if (!ee.a.b(bluetoothDevice, this.f16791g)) {
            ee.c.b(5, "SppManager", "-disconnectSpp- >> device is not connected. device = " + ee.a.e(this.f16786a, bluetoothDevice) + ",\n ConnectedSppDevice = " + ee.a.e(this.f16786a, this.f16791g));
            return false;
        }
        ee.c.b(3, "SppManager", "-disconnectSpp- device = " + ee.a.e(this.f16786a, bluetoothDevice) + ", sppUUID = " + uuid);
        if (uuid != null) {
            c cVar = d(bluetoothDevice, uuid) == null ? null : (c) this.e.remove(d(bluetoothDevice, uuid));
            if (cVar != null) {
                BluetoothSocket bluetoothSocket = cVar.f16752c;
                if (bluetoothSocket != null) {
                    try {
                        bluetoothSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                ee.c.b(5, "c", "ReceiveDataThread stopThread.");
                cVar.f16755g = false;
            }
            e(bluetoothDevice, uuid, 0);
        } else if (!f(bluetoothDevice)) {
            Set keySet = this.e.keySet();
            ArrayList arrayList = new ArrayList();
            String address = bluetoothDevice.getAddress();
            Iterator it = keySet.iterator();
            while (it.hasNext()) {
                String[] split = ((String) it.next()).split("_");
                if (split.length == 2 && address.equals(split[0])) {
                    arrayList.add(UUID.fromString(split[1]));
                }
            }
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                b(bluetoothDevice, (UUID) obj);
            }
        }
        return true;
    }

    public final c c(BluetoothDevice bluetoothDevice, UUID uuid) {
        if (d(bluetoothDevice, uuid) == null) {
            return null;
        }
        return (c) this.e.get(d(bluetoothDevice, uuid));
    }

    public final void e(BluetoothDevice bluetoothDevice, UUID uuid, int i3) {
        boolean z5 = ee.a.b(this.f16792h, bluetoothDevice) || ee.a.b(bluetoothDevice, this.f16793i) || ee.a.b(bluetoothDevice, this.f16791g);
        ee.c.b(3, "SppManager", "-handleSppConnection- device = " + ee.a.e(this.f16786a, bluetoothDevice) + ", isValidDevice = " + z5 + ", sppUUID = " + uuid + ", status = " + i3);
        if (z5) {
            if (i3 == 0 || i3 == 2) {
                if (ee.a.b(bluetoothDevice, this.f16792h)) {
                    this.f16792h = null;
                }
                ee.c.b(4, "SppManager", "-stopConnectTimeoutTask-");
                this.f16800p.removeMessages(1024);
                if (i3 == 0) {
                    if (ee.a.b(bluetoothDevice, this.f16791g)) {
                        c cVar = d(bluetoothDevice, uuid) == null ? null : (c) this.e.remove(d(bluetoothDevice, uuid));
                        if (cVar != null) {
                            ee.c.b(5, "c", "ReceiveDataThread stopThread.");
                            cVar.f16755g = false;
                        }
                        if (f(bluetoothDevice)) {
                            h hVar = this.f16797m;
                            if (hVar != null) {
                                synchronized (hVar) {
                                    hVar.f16767b = false;
                                    synchronized (hVar.f16766a) {
                                        try {
                                            if (hVar.f16768c) {
                                                hVar.f16766a.notifyAll();
                                            }
                                        } catch (Throwable th2) {
                                            throw th2;
                                        }
                                    }
                                }
                            }
                            this.f16791g = null;
                        }
                    }
                } else if (this.f16791g == null) {
                    this.f16791g = bluetoothDevice;
                    if (bluetoothDevice != null) {
                        this.f16792h = null;
                    }
                }
            }
            o4.c cVar2 = this.f16788c;
            cVar2.getClass();
            cVar2.b(new k(bluetoothDevice, uuid, i3));
            if (this.f16798n) {
                if (i3 == 2) {
                    if (this.f16799o.equals(uuid)) {
                        return;
                    }
                    a(bluetoothDevice, this.f16799o);
                } else if (i3 == 0 && ee.a.b(this.f16791g, bluetoothDevice)) {
                    b(this.f16791g, null);
                }
            }
        }
    }

    public final boolean f(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return true;
        }
        HashMap hashMap = this.e;
        if (hashMap.isEmpty()) {
            return true;
        }
        String address = bluetoothDevice.getAddress();
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("_");
            if (split.length == 2 && address.equals(split[0])) {
                return false;
            }
        }
        return true;
    }

    public final boolean g(BluetoothDevice bluetoothDevice, UUID uuid) {
        BluetoothSocket bluetoothSocket;
        if (qd.a(this.f16786a)) {
            c c9 = c(bluetoothDevice, uuid);
            return (c9 == null || (bluetoothSocket = c9.f16752c) == null || !bluetoothSocket.isConnected()) ? false : true;
        }
        ee.c.b(4, "SppManager", "-isSppSocketConnected- miss bluetooth permission.");
        return false;
    }

    public final void h(BluetoothDevice bluetoothDevice, UUID uuid) {
        StringBuilder sb2 = new StringBuilder("-startConnectSppThread- device = ");
        XXApplication xXApplication = this.f16786a;
        sb2.append(ee.a.e(xXApplication, bluetoothDevice));
        sb2.append(", sppUUID = ");
        sb2.append(uuid);
        ee.c.b(2, "SppManager", sb2.toString());
        if (this.f16796l == null) {
            b bVar = new b(xXApplication, bluetoothDevice, uuid, new m0(this, 5));
            this.f16796l = bVar;
            bVar.start();
        }
    }

    public final void i(BluetoothDevice bluetoothDevice, UUID uuid, byte[] bArr, p6.a aVar) {
        h hVar = this.f16797m;
        if (hVar != null) {
            g gVar = new g();
            gVar.f16762a = bluetoothDevice;
            gVar.f16763b = uuid;
            gVar.f16764c = bArr;
            gVar.f16765d = aVar;
            if (hVar.f16767b) {
                try {
                    hVar.f16766a.put(gVar);
                    if (hVar.f16768c) {
                        hVar.f16768c = false;
                        synchronized (hVar.f16766a) {
                            hVar.f16766a.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final synchronized boolean j(BluetoothDevice bluetoothDevice, UUID uuid, byte[] bArr) {
        if (!qd.a(this.f16786a)) {
            ee.c.b(4, "SppManager", "-writeDataToSppDevice- miss bluetooth permission.");
            return false;
        }
        if (bluetoothDevice == null) {
            ee.c.b(5, "SppManager", "-writeDataToSppDevice- param is error.");
            return false;
        }
        if (!ee.a.b(bluetoothDevice, this.f16791g)) {
            ee.c.b(5, "SppManager", "-writeDataToSppDevice- device is error. device = " + ee.a.e(this.f16786a, bluetoothDevice));
            return false;
        }
        c c9 = c(bluetoothDevice, uuid);
        if (c9 == null) {
            ee.c.b(5, "SppManager", "-writeDataToSppDevice- receiveSppDataThread is null. device = " + ee.a.e(this.f16786a, bluetoothDevice) + ", sppUUID = " + uuid);
            return false;
        }
        BluetoothSocket bluetoothSocket = c9.f16752c;
        if (bluetoothSocket != null && bluetoothSocket.isConnected() && bluetoothSocket.getOutputStream() != null) {
            bluetoothSocket.getOutputStream().write(bArr);
            ee.c.b(2, "SppManager", "-writeDataToSppDevice- device = " + ee.a.e(this.f16786a, bluetoothDevice) + ", sppUUID = " + uuid + "\n send ret = true, raw data = " + ee.b.c(bArr));
            return true;
        }
        ee.c.b(5, "SppManager", "-writeDataToSppDevice- spp socket is close.");
        return false;
    }
}
