package o6;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import com.example.test.XXApplication;
import java.util.UUID;

/* loaded from: classes.dex */
public final class c extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final XXApplication f16750a;

    /* renamed from: b, reason: collision with root package name */
    public final BluetoothDevice f16751b;

    /* renamed from: c, reason: collision with root package name */
    public final BluetoothSocket f16752c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16753d;
    public final mc.g e;

    /* renamed from: f, reason: collision with root package name */
    public final UUID f16754f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f16755g;

    public c(XXApplication xXApplication, BluetoothDevice bluetoothDevice, UUID uuid, BluetoothSocket bluetoothSocket, mc.g gVar) {
        super("ReceiveSppDataThread : " + bluetoothDevice);
        this.f16750a = xXApplication;
        this.f16751b = bluetoothDevice;
        this.f16754f = uuid;
        this.f16752c = bluetoothSocket;
        this.f16753d = 4096;
        this.e = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066 A[SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r10 = this;
            super.run()
            java.lang.String r0 = "ReceiveDataThread start."
            r1 = 3
            java.lang.String r2 = "c"
            ee.c.b(r1, r2, r0)
            r0 = 1
            r10.f16755g = r0
            mc.g r3 = r10.e
            if (r3 == 0) goto L15
            r10.getId()
        L15:
            android.bluetooth.BluetoothDevice r3 = r10.f16751b
            r4 = 2
            r5 = 0
            if (r3 == 0) goto La4
            com.example.test.XXApplication r3 = r10.f16750a
            boolean r3 = com.google.android.gms.internal.mlkit_vision_barcode.qd.a(r3)
            if (r3 == 0) goto La4
            int r0 = r10.f16753d
            byte[] r0 = new byte[r0]
            android.bluetooth.BluetoothSocket r3 = r10.f16752c
            if (r3 == 0) goto L34
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.io.IOException -> L30
            goto L35
        L30:
            r3 = move-exception
            r3.printStackTrace()
        L34:
            r3 = 0
        L35:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "ReceiveDataThread isRunning : "
            r6.<init>(r7)
            boolean r7 = r10.f16755g
            r6.append(r7)
            java.lang.String r7 = ", mBluetoothSocket : "
            r6.append(r7)
            android.bluetooth.BluetoothSocket r7 = r10.f16752c
            r6.append(r7)
            java.lang.String r7 = ", inputStream : "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            ee.c.b(r1, r2, r6)
        L5a:
            boolean r6 = r10.f16755g
            if (r6 == 0) goto La3
            if (r3 == 0) goto La3
            int r6 = r3.read(r0)     // Catch: java.lang.Exception -> L6c
            if (r6 > 0) goto L6e
            r6 = 30
            java.lang.Thread.sleep(r6)     // Catch: java.lang.Exception -> L6c
            goto L5a
        L6c:
            r0 = move-exception
            goto L82
        L6e:
            byte[] r7 = new byte[r6]     // Catch: java.lang.Exception -> L6c
            java.lang.System.arraycopy(r0, r5, r7, r5, r6)     // Catch: java.lang.Exception -> L6c
            mc.g r6 = r10.e     // Catch: java.lang.Exception -> L6c
            if (r6 == 0) goto L5a
            r10.getId()     // Catch: java.lang.Exception -> L6c
            android.bluetooth.BluetoothDevice r8 = r10.f16751b     // Catch: java.lang.Exception -> L6c
            java.util.UUID r9 = r10.f16754f     // Catch: java.lang.Exception -> L6c
            r6.g(r8, r9, r7)     // Catch: java.lang.Exception -> L6c
            goto L5a
        L82:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "-ReceiveDataThread- have an exception : "
            r3.<init>(r6)
            r3.append(r0)
            java.lang.String r6 = ", sppUUID = "
            r3.append(r6)
            java.util.UUID r6 = r10.f16754f
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r6 = 5
            ee.c.b(r6, r2, r3)
            r0.printStackTrace()
            r0 = r4
            goto La4
        La3:
            r0 = r5
        La4:
            r10.f16755g = r5
            mc.g r3 = r10.e
            if (r3 == 0) goto Lba
            r10.getId()
            android.bluetooth.BluetoothDevice r5 = r10.f16751b
            java.util.UUID r6 = r10.f16754f
            if (r0 != r4) goto Lba
            java.lang.Object r0 = r3.f16022b
            o6.p r0 = (o6.p) r0
            r0.b(r5, r6)
        Lba:
            java.lang.String r0 = "ReceiveDataThread exit"
            ee.c.b(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.c.run():void");
    }
}
