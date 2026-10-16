package l6;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements BluetoothAdapter.LeScanCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15794a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15795b;

    public /* synthetic */ k(Object obj, int i3) {
        this.f15794a = i3;
        this.f15795b = obj;
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public final void onLeScan(BluetoothDevice bluetoothDevice, int i3, byte[] bArr) {
        switch (this.f15794a) {
            case 0:
                ((o) this.f15795b).c(bluetoothDevice, i3, bArr, true);
                break;
            default:
                ((k6.b) this.f15795b).n(bluetoothDevice, i3, bArr, true);
                break;
        }
    }
}
