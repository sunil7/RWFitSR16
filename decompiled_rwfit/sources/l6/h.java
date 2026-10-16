package l6;

import android.bluetooth.BluetoothDevice;
import com.google.android.gms.internal.mlkit_vision_barcode.fe;
import java.util.UUID;

/* loaded from: classes.dex */
public final class h extends fe {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f15784a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UUID f15785b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UUID f15786c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ byte[] f15787d;

    public h(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr) {
        this.f15784a = bluetoothDevice;
        this.f15785b = uuid;
        this.f15786c = uuid2;
        this.f15787d = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.fe
    public final void a(m6.a aVar) {
        aVar.d(this.f15784a, this.f15785b, this.f15786c, this.f15787d);
    }
}
