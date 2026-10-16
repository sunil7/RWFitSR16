package l6;

import android.bluetooth.BluetoothDevice;
import com.google.android.gms.internal.mlkit_vision_barcode.fe;

/* loaded from: classes.dex */
public final class g extends fe {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f15781a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f15782b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15783c;

    public g(BluetoothDevice bluetoothDevice, int i3, int i10) {
        this.f15781a = bluetoothDevice;
        this.f15782b = i3;
        this.f15783c = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.fe
    public final void a(m6.a aVar) {
        aVar.c(this.f15781a, this.f15782b, this.f15783c);
    }
}
