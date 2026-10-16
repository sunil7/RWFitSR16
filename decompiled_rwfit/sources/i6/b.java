package i6;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import com.example.test.tool.ota.ble.model.BleScanInfo;
import com.example.test.utils.w0;
import com.example.test.utils.y;
import java.util.ArrayList;
import java.util.UUID;
import o2.m;

/* loaded from: classes.dex */
public final class b extends i {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f14361a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f14362b = new Handler(Looper.getMainLooper());

    @Override // i6.i
    public final void a(boolean z5) {
        w0 w0Var = new w0();
        w0Var.f8766a = z5;
        g(w0Var);
    }

    @Override // i6.i
    public final void b(BluetoothDevice bluetoothDevice, int i3, int i10) {
        g(new a(bluetoothDevice, i3, i10, 0));
    }

    @Override // i6.i
    public final void c(BluetoothDevice bluetoothDevice, int i3, int i10) {
        g(new a(bluetoothDevice, i3, i10, 1));
    }

    @Override // i6.i
    public final void d(BluetoothDevice bluetoothDevice, BleScanInfo bleScanInfo) {
        g(new y(bluetoothDevice, 21, bleScanInfo, false));
    }

    @Override // i6.i
    public final void e(int i3) {
        g(new m((byte) 0, i3, 5));
    }

    @Override // i6.i
    public final void f(BluetoothDevice bluetoothDevice, int i3, UUID uuid, byte[] bArr) {
        g(new fd.c(bluetoothDevice, i3, uuid, bArr));
    }

    public final void g(h hVar) {
        x.h hVar2 = new x.h(this.f14361a, hVar);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            hVar2.run();
        } else {
            this.f14362b.post(hVar2);
        }
    }
}
