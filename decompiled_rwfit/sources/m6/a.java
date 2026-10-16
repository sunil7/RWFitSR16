package m6;

import android.bluetooth.BluetoothDevice;
import com.example.test.tool.ota.ble.model.BleScanInfo;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class a {
    public abstract void a(boolean z5);

    public abstract void b(BluetoothDevice bluetoothDevice, int i3);

    public abstract void c(BluetoothDevice bluetoothDevice, int i3, int i10);

    public abstract void d(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr);

    public void e(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, int i3) {
    }

    public void f(BluetoothDevice bluetoothDevice, int i3, List list) {
    }

    public void g(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr, int i3) {
    }

    public abstract void h(BluetoothDevice bluetoothDevice, BleScanInfo bleScanInfo);

    public abstract void i();
}
