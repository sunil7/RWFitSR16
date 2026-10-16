package l6;

import android.bluetooth.BluetoothGatt;
import java.util.UUID;

/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final BluetoothGatt f15799a;

    /* renamed from: b, reason: collision with root package name */
    public final UUID f15800b;

    /* renamed from: c, reason: collision with root package name */
    public final UUID f15801c;

    /* renamed from: d, reason: collision with root package name */
    public final UUID f15802d = o.f15807s;
    public int e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ o f15803f;

    public n(o oVar, BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2) {
        this.f15803f = oVar;
        this.f15799a = bluetoothGatt;
        this.f15800b = uuid;
        this.f15801c = uuid2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e4  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r12 = this;
            java.lang.String r0 = "o"
            r1 = 4
            l6.o r2 = r12.f15803f
            android.bluetooth.BluetoothGatt r3 = r12.f15799a
            java.util.UUID r4 = r12.f15800b
            java.util.UUID r5 = r12.f15801c
            r6 = 0
            if (r3 == 0) goto La8
            com.example.test.XXApplication r7 = r2.f15808a
            boolean r7 = com.google.android.gms.internal.mlkit_vision_barcode.qd.a(r7)
            if (r7 != 0) goto L18
            goto Lad
        L18:
            android.bluetooth.BluetoothGattService r7 = r3.getService(r4)
            if (r7 != 0) goto L31
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "BluetoothGattService is null. uuid = "
            r7.<init>(r8)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            ee.c.b(r1, r0, r7)
            goto Lb2
        L31:
            android.bluetooth.BluetoothGattCharacteristic r7 = r7.getCharacteristic(r5)
            if (r7 != 0) goto L49
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "BluetoothGattCharacteristic is null. uuid = "
            r7.<init>(r8)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            ee.c.b(r1, r0, r7)
            goto Lb2
        L49:
            r8 = 1
            boolean r8 = r3.setCharacteristicNotification(r7, r8)
            if (r8 == 0) goto L80
            java.util.List r7 = r7.getDescriptors()
            java.util.Iterator r7 = r7.iterator()
            r8 = r6
        L59:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L7e
            java.lang.Object r9 = r7.next()
            android.bluetooth.BluetoothGattDescriptor r9 = (android.bluetooth.BluetoothGattDescriptor) r9
            java.util.UUID r10 = r9.getUuid()
            java.util.UUID r11 = l6.o.f15807s
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L72
            goto L59
        L72:
            boolean r8 = r2.h(r3, r9, r6, r6)
            if (r8 != 0) goto L7e
            java.lang.String r9 = "tryToWriteDescriptor failed...."
            ee.c.b(r1, r0, r9)
            goto L59
        L7e:
            r6 = r8
            goto L86
        L80:
            java.lang.String r6 = "setCharacteristicNotification is failed...."
            ee.c.b(r1, r0, r6)
            goto L7e
        L86:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "enableBLEDeviceNotification ret : "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r8 = ", serviceUUID : "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = ", characteristicUUID : "
            r7.append(r8)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            ee.c.b(r1, r0, r7)
            goto Lb2
        La8:
            l6.o r7 = l6.o.f15804o
            r2.getClass()
        Lad:
            java.lang.String r7 = "Bluetooth gatt is null."
            ee.c.b(r1, r0, r7)
        Lb2:
            l6.o r7 = l6.o.f15804o
            java.util.Locale.getDefault()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "enableBLEDeviceNotification ===> "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r8 = ", service uuid = "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r4 = ", characteristic uuid = "
            r7.append(r4)
            r7.append(r5)
            java.lang.String r4 = r7.toString()
            ee.c.b(r1, r0, r4)
            if (r6 != 0) goto Le4
            if (r3 == 0) goto Le3
            android.bluetooth.BluetoothDevice r0 = r3.getDevice()
            r2.b(r0)
        Le3:
            return
        Le4:
            android.os.Handler r0 = r2.f15819m
            r1 = 4115(0x1013, float:5.766E-42)
            r0.removeMessages(r1)
            android.os.Handler r0 = r2.f15819m
            android.bluetooth.BluetoothDevice r2 = r3.getDevice()
            android.os.Message r1 = r0.obtainMessage(r1, r2)
            r2 = 6000(0x1770, double:2.9644E-320)
            r0.sendMessageDelayed(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.n.run():void");
    }
}
