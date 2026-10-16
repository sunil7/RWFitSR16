package n6;

import android.bluetooth.BluetoothGatt;
import com.example.test.XXApplication;
import l6.q;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final XXApplication f16382a;

    /* renamed from: b, reason: collision with root package name */
    public final BluetoothGatt f16383b;

    /* renamed from: c, reason: collision with root package name */
    public int f16384c = 20;

    /* renamed from: d, reason: collision with root package name */
    public long f16385d;
    public q e;

    public b(XXApplication xXApplication, BluetoothGatt bluetoothGatt) {
        this.f16382a = xXApplication;
        this.f16383b = bluetoothGatt;
    }

    public final String toString() {
        return "BleDevice{context=" + this.f16382a + ", gatt=" + this.f16383b + ", mtu=" + this.f16384c + ", connectedTime=" + this.f16385d + ", sendDataThread=" + this.e + '}';
    }
}
