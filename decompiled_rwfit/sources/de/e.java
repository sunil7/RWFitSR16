package de;

import android.bluetooth.BluetoothDevice;
import androidx.recyclerview.widget.x;
import com.jieli.jl_bt_ota.model.BleScanMessage;

/* loaded from: classes.dex */
public final class e extends a2.h implements rd.c {
    @Override // rd.c
    public final void a(x xVar) {
        u(new d(0, xVar));
    }

    @Override // rd.c
    public final void e(BluetoothDevice bluetoothDevice, int i3) {
        u(new a(bluetoothDevice, i3, 0));
    }

    @Override // rd.c
    public final void g(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
        u(new c0.b(9, bluetoothDevice, bleScanMessage));
    }

    @Override // rd.c
    public final void i(BluetoothDevice bluetoothDevice, int i3) {
        u(new a(bluetoothDevice, i3, 3));
    }

    @Override // rd.c
    public final void j(final BluetoothDevice bluetoothDevice, final int i3, final int i10) {
        u(new l() { // from class: de.b
            @Override // de.l
            public final void k(Object obj) {
                ((rd.c) obj).j(bluetoothDevice, i3, i10);
            }
        });
    }

    @Override // rd.c
    public final void k(BluetoothDevice bluetoothDevice, int i3) {
        u(new a(bluetoothDevice, i3, 1));
    }

    @Override // rd.c
    public final void m(BluetoothDevice bluetoothDevice, vd.b bVar) {
        u(new c0.b(10, bluetoothDevice, bVar));
    }

    @Override // rd.c
    public final void o(boolean z5, boolean z6) {
        u(new c(1, z5, z6));
    }

    @Override // rd.c
    public final void p(BluetoothDevice bluetoothDevice, int i3) {
        u(new a(bluetoothDevice, i3, 2));
    }

    @Override // rd.c
    public final void q(boolean z5, boolean z6) {
        u(new c(0, z5, z6));
    }

    @Override // rd.c
    public final void r(BluetoothDevice bluetoothDevice) {
        u(new af.a(bluetoothDevice, 16));
    }
}
