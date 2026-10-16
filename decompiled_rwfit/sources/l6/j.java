package l6;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import com.example.test.tool.ota.ble.model.BleScanInfo;
import com.google.android.gms.internal.mlkit_vision_barcode.fe;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public final class j extends m6.a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f15792a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f15793b = new Handler(Looper.getMainLooper());

    @Override // m6.a
    public final void a(boolean z5) {
        j(new a(z5));
    }

    @Override // m6.a
    public final void b(BluetoothDevice bluetoothDevice, int i3) {
        j(new d(bluetoothDevice, i3));
    }

    @Override // m6.a
    public final void c(BluetoothDevice bluetoothDevice, int i3, int i10) {
        j(new g(bluetoothDevice, i3, i10));
    }

    @Override // m6.a
    public final void d(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr) {
        j(new h(bluetoothDevice, uuid, uuid2, bArr));
    }

    @Override // m6.a
    public final void e(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, int i3) {
        j(new f(bluetoothDevice, uuid, uuid2, i3));
    }

    @Override // m6.a
    public final void f(BluetoothDevice bluetoothDevice, int i3, List list) {
        j(new e(bluetoothDevice, i3, list));
    }

    @Override // m6.a
    public final void g(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr, int i3) {
        j(new i(bluetoothDevice, uuid, uuid2, bArr, i3));
    }

    @Override // m6.a
    public final void h(BluetoothDevice bluetoothDevice, BleScanInfo bleScanInfo) {
        j(new c(bluetoothDevice, bleScanInfo));
    }

    @Override // m6.a
    public final void i() {
        j(new b());
    }

    public final void j(fe feVar) {
        ia.j jVar = new ia.j(6, this, feVar);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            jVar.run();
        } else {
            this.f15793b.post(jVar);
        }
    }
}
