package i6;

import android.bluetooth.BluetoothDevice;
import com.example.test.tool.ota.ble.model.BleScanInfo;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class i {
    public void a(boolean z5) {
    }

    public abstract void b(BluetoothDevice bluetoothDevice, int i3, int i10);

    public abstract void c(BluetoothDevice bluetoothDevice, int i3, int i10);

    public void d(BluetoothDevice bluetoothDevice, BleScanInfo bleScanInfo) {
    }

    public void e(int i3) {
    }

    public abstract void f(BluetoothDevice bluetoothDevice, int i3, UUID uuid, byte[] bArr);
}
