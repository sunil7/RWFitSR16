package l6;

import android.bluetooth.BluetoothGatt;
import com.autonavi.aps.amapapi.config.Const;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class q extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue f15826a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f15827b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f15828c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f15829d;
    public volatile int e;

    /* renamed from: f, reason: collision with root package name */
    public final mc.g f15830f;

    /* renamed from: g, reason: collision with root package name */
    public final n6.a f15831g;

    /* renamed from: h, reason: collision with root package name */
    public p f15832h;

    public q(mc.g gVar, n6.a aVar) {
        super("SendBleDataThread");
        this.f15826a = new LinkedBlockingQueue();
        this.f15827b = false;
        this.f15828c = false;
        this.f15829d = false;
        this.e = 0;
        this.f15830f = gVar;
        this.f15831g = aVar;
    }

    public static void b(p pVar, boolean z5) {
        i6.c cVar;
        if (pVar == null || (cVar = pVar.f15825f) == null) {
            ee.c.b(3, "SendBleDataThread", "getCallback is null.");
        } else {
            cVar.a(pVar.f15821a.getDevice(), z5);
        }
    }

    public final boolean a(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2, byte[] bArr, i6.c cVar) {
        boolean z5;
        if (!this.f15827b) {
            return false;
        }
        try {
            this.f15826a.put(new p(bluetoothGatt, uuid, uuid2, bArr, cVar));
            z5 = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            z5 = false;
        }
        if (z5 && this.f15828c && !this.f15829d) {
            this.f15828c = false;
            synchronized (this.f15826a) {
                this.f15826a.notify();
            }
        }
        return z5;
    }

    public final void c(p pVar) {
        p pVar2;
        if (pVar == null || ((pVar2 = this.f15832h) != null && pVar2.equals(pVar))) {
            if (pVar != null) {
                pVar.f15825f = this.f15832h.f15825f;
                this.f15832h = pVar;
            }
            synchronized (this.f15826a) {
                try {
                    if (this.f15828c) {
                        if (this.f15829d) {
                            this.f15826a.notifyAll();
                        } else {
                            this.f15826a.notify();
                        }
                    } else if (this.f15829d) {
                        this.f15826a.notify();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ee.c.b(2, "SendBleDataThread", "send ble data thread is started.");
        if (this.f15831g != null) {
            getId();
            getName();
        }
        if (this.f15830f != null) {
            synchronized (this.f15826a) {
                while (this.f15827b) {
                    this.f15832h = null;
                    this.f15828c = false;
                    this.f15829d = false;
                    if (this.f15826a.isEmpty()) {
                        this.f15828c = true;
                        ee.c.b(2, "SendBleDataThread", "queue is empty, so waiting for data");
                        try {
                            this.f15826a.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        p pVar = (p) this.f15826a.peek();
                        this.f15832h = pVar;
                        if (pVar != null) {
                            this.f15829d = this.f15830f.k(pVar.f15821a, pVar.f15822b, pVar.f15823c, pVar.f15824d);
                            if (this.f15829d) {
                                try {
                                    this.f15826a.wait(Const.L_MIN_GET_REQ);
                                } catch (InterruptedException e10) {
                                    e10.printStackTrace();
                                }
                            } else {
                                this.f15832h.e = -1;
                            }
                            p pVar2 = this.f15832h;
                            if (pVar2.e != 0) {
                                this.e++;
                                if (this.e >= 3) {
                                    b(this.f15832h, false);
                                    this.f15826a.clear();
                                } else {
                                    p pVar3 = this.f15832h;
                                    if (pVar3.e != -1) {
                                        pVar3.e = -1;
                                        try {
                                            Thread.sleep(10L);
                                        } catch (InterruptedException e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                }
                            } else {
                                b(pVar2, true);
                            }
                        }
                        this.e = 0;
                        if (!this.f15826a.isEmpty()) {
                            this.f15826a.poll();
                        }
                    }
                }
            }
            this.f15829d = false;
            this.f15828c = false;
            this.f15826a.clear();
            n6.a aVar = this.f15831g;
            if (aVar != null) {
                long id2 = getId();
                getName();
                n6.b bVar = (n6.b) aVar.f16381b;
                q qVar = bVar.e;
                if (qVar != null && qVar.getId() == id2) {
                    bVar.e = null;
                }
            }
            ee.c.b(2, "SendBleDataThread", "send ble data thread exit.");
        }
    }

    @Override // java.lang.Thread
    public final synchronized void start() {
        this.f15827b = true;
        super.start();
    }
}
