package l6;

import android.bluetooth.BluetoothDevice;
import com.google.android.gms.internal.mlkit_vision_barcode.fe;

/* loaded from: classes.dex */
public final class d extends fe {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f15772a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f15773b;

    public d(BluetoothDevice bluetoothDevice, int i3) {
        this.f15772a = bluetoothDevice;
        this.f15773b = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.fe
    public final void a(m6.a aVar) {
        aVar.b(this.f15772a, this.f15773b);
    }
}
