package fc;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import be.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f13558a;

    public c(int i3) {
        switch (i3) {
            case 2:
                this.f13558a = new HashMap();
                new HashMap();
                break;
            default:
                this.f13558a = new HashMap();
                break;
        }
    }

    public j a(BluetoothDevice bluetoothDevice) {
        ud.b b3 = b(bluetoothDevice);
        if (b3 != null) {
            return b3.f19057c;
        }
        return null;
    }

    public ud.b b(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        String address = bluetoothDevice.getAddress();
        if (TextUtils.isEmpty(address)) {
            return null;
        }
        return (ud.b) this.f13558a.get(address);
    }

    public int c(BluetoothDevice bluetoothDevice) {
        int i3;
        j a3 = a(bluetoothDevice);
        if (a3 == null || (i3 = a3.K) <= 0) {
            return 530;
        }
        return i3;
    }

    public void d(BluetoothDevice bluetoothDevice, boolean z5) {
        ud.b b3 = b(bluetoothDevice);
        if (b3 == null) {
            b3 = new ud.b();
        }
        b3.f19055a = z5;
        e(bluetoothDevice, b3);
    }

    public void e(BluetoothDevice bluetoothDevice, ud.b bVar) {
        if (bluetoothDevice != null) {
            String address = bluetoothDevice.getAddress();
            if (BluetoothAdapter.checkBluetoothAddress(address)) {
                this.f13558a.put(address, bVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
    
        if (r5.f3253w == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(android.bluetooth.BluetoothDevice r4, be.j r5) {
        /*
            r3 = this;
            ud.b r0 = r3.b(r4)
            if (r5 == 0) goto Lc
            int r1 = r5.f3253w
            r2 = 1
            if (r1 != r2) goto Lc
            goto Ld
        Lc:
            r2 = 0
        Ld:
            if (r0 != 0) goto L14
            ud.b r0 = new ud.b
            r0.<init>()
        L14:
            r0.f19057c = r5
            r0.f19056b = r2
            r3.e(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fc.c.f(android.bluetooth.BluetoothDevice, be.j):void");
    }

    public c(Set set) {
        this.f13558a = new HashMap();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            HashMap hashMap = this.f13558a;
            bVar.getClass();
            hashMap.put(a.class, bVar.f13557a);
        }
    }
}
