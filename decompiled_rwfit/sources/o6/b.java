package o6;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Looper;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.qd;
import java.util.UUID;
import n.m0;

/* loaded from: classes.dex */
public final class b extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final XXApplication f16746a;

    /* renamed from: b, reason: collision with root package name */
    public final BluetoothDevice f16747b;

    /* renamed from: c, reason: collision with root package name */
    public final UUID f16748c;

    /* renamed from: d, reason: collision with root package name */
    public final m0 f16749d;
    public final Handler e;

    public b(XXApplication xXApplication, BluetoothDevice bluetoothDevice, UUID uuid, m0 m0Var) {
        super("ConnectionSppThread");
        this.e = new Handler(Looper.getMainLooper());
        this.f16746a = xXApplication;
        this.f16747b = bluetoothDevice;
        this.f16748c = uuid;
        this.f16749d = m0Var;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final synchronized void run() {
        boolean z5;
        long id2 = getId();
        if (this.f16749d != null) {
            this.e.post(new m5.a(this, id2, 8));
        }
        if (this.f16747b != null && qd.a(this.f16746a)) {
            ee.c.b(5, "ConnectionSppThread", "-ConnectionSppThread- connect device : " + ee.a.e(this.f16746a, this.f16747b) + ", uuid = " + this.f16748c);
            BluetoothSocket bluetoothSocket = null;
            try {
                bluetoothSocket = this.f16747b.createRfcommSocketToServiceRecord(this.f16748c);
                bluetoothSocket.connect();
                z5 = true;
            } catch (Exception e) {
                e.printStackTrace();
                ee.c.b(5, "ConnectionSppThread", "-ConnectionSppThread- exception : " + e.getMessage() + ", uuid = " + this.f16748c);
                z5 = false;
            }
            final BluetoothSocket bluetoothSocket2 = bluetoothSocket;
            final boolean z6 = z5;
            if (z6) {
                ee.c.b(3, "ConnectionSppThread", "-ConnectionSppThread- connect spp ok, recv max = " + bluetoothSocket2.getMaxReceivePacketSize() + ", send max = " + bluetoothSocket2.getMaxTransmitPacketSize());
            }
            final long id3 = getId();
            final BluetoothDevice bluetoothDevice = this.f16747b;
            final UUID uuid = this.f16748c;
            if (this.f16749d != null) {
                this.e.post(new Runnable() { // from class: o6.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        p pVar = (p) b.this.f16749d.f16254b;
                        b bVar = pVar.f16796l;
                        if (bVar != null && bVar.getId() == id3) {
                            pVar.f16796l = null;
                        }
                        boolean z8 = z6;
                        BluetoothDevice bluetoothDevice2 = bluetoothDevice;
                        UUID uuid2 = uuid;
                        if (!z8) {
                            pVar.e(bluetoothDevice2, uuid2, 0);
                            return;
                        }
                        pVar.f16791g = bluetoothDevice2;
                        if (bluetoothDevice2 != null) {
                            pVar.f16792h = null;
                        }
                        if (pVar.c(bluetoothDevice2, uuid2) == null) {
                            c cVar = new c(pVar.f16786a, bluetoothDevice2, uuid2, bluetoothSocket2, new mc.g(pVar, 6));
                            String d5 = p.d(bluetoothDevice2, uuid2);
                            if (d5 != null) {
                                pVar.e.put(d5, cVar);
                            }
                            cVar.start();
                        }
                        if (pVar.f16797m == null) {
                            h hVar = new h(pVar.f16786a, pVar, new n6.a(pVar, 3));
                            pVar.f16797m = hVar;
                            hVar.start();
                        }
                        pVar.e(bluetoothDevice2, uuid2, 2);
                    }
                });
            }
            return;
        }
        final long id4 = getId();
        if (this.f16749d != null) {
            final UUID uuid2 = null;
            final BluetoothSocket bluetoothSocket3 = null;
            final boolean z8 = false;
            final BluetoothDevice bluetoothDevice2 = null;
            this.e.post(new Runnable() { // from class: o6.a
                @Override // java.lang.Runnable
                public final void run() {
                    p pVar = (p) b.this.f16749d.f16254b;
                    b bVar = pVar.f16796l;
                    if (bVar != null && bVar.getId() == id4) {
                        pVar.f16796l = null;
                    }
                    boolean z82 = z8;
                    BluetoothDevice bluetoothDevice22 = bluetoothDevice2;
                    UUID uuid22 = uuid2;
                    if (!z82) {
                        pVar.e(bluetoothDevice22, uuid22, 0);
                        return;
                    }
                    pVar.f16791g = bluetoothDevice22;
                    if (bluetoothDevice22 != null) {
                        pVar.f16792h = null;
                    }
                    if (pVar.c(bluetoothDevice22, uuid22) == null) {
                        c cVar = new c(pVar.f16786a, bluetoothDevice22, uuid22, bluetoothSocket3, new mc.g(pVar, 6));
                        String d5 = p.d(bluetoothDevice22, uuid22);
                        if (d5 != null) {
                            pVar.e.put(d5, cVar);
                        }
                        cVar.start();
                    }
                    if (pVar.f16797m == null) {
                        h hVar = new h(pVar.f16786a, pVar, new n6.a(pVar, 3));
                        pVar.f16797m = hVar;
                        hVar.start();
                    }
                    pVar.e(bluetoothDevice22, uuid22, 2);
                }
            });
        }
    }
}
