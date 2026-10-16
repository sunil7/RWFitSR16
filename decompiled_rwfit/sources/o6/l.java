package o6;

import android.bluetooth.BluetoothDevice;
import com.google.android.gms.internal.mlkit_vision_barcode.jf;
import java.util.UUID;

/* loaded from: classes.dex */
public final class l extends jf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f16776a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UUID f16777b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f16778c;

    public l(BluetoothDevice bluetoothDevice, UUID uuid, byte[] bArr) {
        this.f16776a = bluetoothDevice;
        this.f16777b = uuid;
        this.f16778c = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.jf
    public final void a(i6.e eVar) {
        eVar.f14365a.f14371d.f(this.f16776a, 1, this.f16777b, this.f16778c);
    }
}
