package i6;

import android.bluetooth.BluetoothDevice;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import java.util.UUID;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements p6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f14363a;

    public void a(BluetoothDevice bluetoothDevice, boolean z5) {
        f this$0 = this.f14363a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (z5) {
            return;
        }
        XXApplication xXApplication = XXApplication.f7400h;
        ee.c.b(3, "BluetoothHelper", "-writeDataByBleAsync- device:" + ee.a.e(j1.a(), bluetoothDevice) + ", result = " + z5);
    }

    @Override // p6.a
    public void b(BluetoothDevice bluetoothDevice, UUID uuid, boolean z5) {
        f this$0 = this.f14363a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (z5) {
            return;
        }
        XXApplication xXApplication = XXApplication.f7400h;
        ee.c.b(3, "BluetoothHelper", "-writeDataToSppAsync- device = " + ee.a.e(j1.a(), bluetoothDevice) + ", uuid = " + uuid + ", result = " + z5);
    }
}
