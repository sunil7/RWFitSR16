package l6;

import android.bluetooth.BluetoothDevice;
import com.example.test.tool.ota.ble.model.BleScanInfo;
import com.google.android.gms.internal.mlkit_vision_barcode.fe;

/* loaded from: classes.dex */
public final class c extends fe {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f15770a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BleScanInfo f15771b;

    public c(BluetoothDevice bluetoothDevice, BleScanInfo bleScanInfo) {
        this.f15770a = bluetoothDevice;
        this.f15771b = bleScanInfo;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.fe
    public final void a(m6.a aVar) {
        aVar.h(this.f15770a, this.f15771b);
    }
}
