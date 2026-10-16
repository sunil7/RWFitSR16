package l6;

import android.bluetooth.BluetoothDevice;
import com.google.android.gms.internal.mlkit_vision_barcode.fe;
import java.util.UUID;

/* loaded from: classes.dex */
public final class i extends fe {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f15788a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UUID f15789b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UUID f15790c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ byte[] f15791d;
    public final /* synthetic */ int e;

    public i(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr, int i3) {
        this.f15788a = bluetoothDevice;
        this.f15789b = uuid;
        this.f15790c = uuid2;
        this.f15791d = bArr;
        this.e = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.fe
    public final void a(m6.a aVar) {
        aVar.g(this.f15788a, this.f15789b, this.f15790c, this.f15791d, this.e);
    }
}
