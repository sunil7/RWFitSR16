package l6;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_common.i0;
import java.util.List;

/* loaded from: classes.dex */
public final class l extends ScanCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15796a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15797b;

    public /* synthetic */ l(Object obj, int i3) {
        this.f15796a = i3;
        this.f15797b = obj;
    }

    private final void a(List list) {
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onBatchScanResults(List list) {
        switch (this.f15796a) {
            case 0:
                break;
            default:
                super.onBatchScanResults(list);
                break;
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int i3) {
        XXApplication xXApplication;
        switch (this.f15796a) {
            case 0:
                o oVar = o.f15804o;
                ee.c.b(2, "o", "onScanFailed : " + i3);
                o oVar2 = (o) this.f15797b;
                BluetoothAdapter bluetoothAdapter = oVar2.f15811d;
                if (bluetoothAdapter != null && bluetoothAdapter != null && bluetoothAdapter.isEnabled() && Build.VERSION.SDK_INT >= 31 && (xXApplication = oVar2.f15808a) != null) {
                    a1.g.a(xXApplication, "android.permission.BLUETOOTH_SCAN");
                    break;
                }
                break;
            default:
                super.onScanFailed(i3);
                ((k6.b) this.f15797b).e.a(i0.b(8194, i3, "Scan ble error."));
                break;
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int i3, ScanResult scanResult) {
        switch (this.f15796a) {
            case 0:
                if (scanResult != null && scanResult.getScanRecord() != null) {
                    BluetoothDevice device = scanResult.getDevice();
                    boolean isConnectable = scanResult.isConnectable();
                    ((o) this.f15797b).c(device, scanResult.getRssi(), scanResult.getScanRecord().getBytes(), isConnectable);
                    break;
                }
                break;
            default:
                super.onScanResult(i3, scanResult);
                if (scanResult != null && scanResult.getScanRecord() != null) {
                    BluetoothDevice device2 = scanResult.getDevice();
                    boolean isConnectable2 = scanResult.isConnectable();
                    ((k6.b) this.f15797b).n(device2, scanResult.getRssi(), scanResult.getScanRecord().getBytes(), isConnectable2);
                    break;
                }
                break;
        }
    }
}
