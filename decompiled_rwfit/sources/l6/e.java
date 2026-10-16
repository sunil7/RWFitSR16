package l6;

import android.bluetooth.BluetoothDevice;
import com.google.android.gms.internal.mlkit_vision_barcode.fe;
import java.util.List;

/* loaded from: classes.dex */
public final class e extends fe {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f15774a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f15775b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f15776c;

    public e(BluetoothDevice bluetoothDevice, int i3, List list) {
        this.f15774a = bluetoothDevice;
        this.f15775b = i3;
        this.f15776c = list;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.fe
    public final void a(m6.a aVar) {
        aVar.f(this.f15774a, this.f15775b, this.f15776c);
    }
}
