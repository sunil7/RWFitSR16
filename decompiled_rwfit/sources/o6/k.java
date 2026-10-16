package o6;

import android.bluetooth.BluetoothDevice;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.jf;
import java.util.UUID;

/* loaded from: classes.dex */
public final class k extends jf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f16773a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UUID f16774b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f16775c;

    public k(BluetoothDevice bluetoothDevice, UUID uuid, int i3) {
        this.f16773a = bluetoothDevice;
        this.f16774b = uuid;
        this.f16775c = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.jf
    public final void a(i6.e eVar) {
        i6.f fVar = eVar.f14365a;
        UUID uuid = this.f16774b;
        int i3 = this.f16775c;
        if (i3 == 2 && fVar.f14368a.f15327a.getBoolean("spp_multiple_channel", false)) {
            j6.a aVar = fVar.f14368a;
            aVar.getClass();
            if (!kotlin.jvm.internal.e.a(UUID.fromString(aVar.f15327a.getString("spp_custom_uuid", k6.c.f15525a.toString())), uuid)) {
                ee.c.b(3, "BluetoothHelper", "onSppConnection :: skip custom uuid = " + uuid);
                return;
            }
        }
        XXApplication xXApplication = XXApplication.f7400h;
        XXApplication a3 = j1.a();
        BluetoothDevice bluetoothDevice = this.f16773a;
        ee.c.b(2, "BluetoothHelper", "onSppConnection :: device = " + ee.a.e(a3, bluetoothDevice) + ", uuid = " + uuid + ", status = " + i3);
        fVar.f14371d.c(bluetoothDevice, 1, i3);
    }
}
