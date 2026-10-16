package l6;

import android.bluetooth.BluetoothDevice;
import com.google.android.gms.internal.mlkit_vision_barcode.fe;
import java.util.UUID;

/* loaded from: classes.dex */
public final class f extends fe {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f15777a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UUID f15778b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UUID f15779c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f15780d;

    public f(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, int i3) {
        this.f15777a = bluetoothDevice;
        this.f15778b = uuid;
        this.f15779c = uuid2;
        this.f15780d = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.fe
    public final void a(m6.a aVar) {
        aVar.e(this.f15777a, this.f15778b, this.f15779c, this.f15780d);
    }
}
