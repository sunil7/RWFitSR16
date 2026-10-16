package i6;

import android.bluetooth.BluetoothDevice;
import com.example.test.tool.ota.ble.model.BleScanInfo;
import java.util.UUID;

/* loaded from: classes.dex */
public final class d extends m6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f14364a;

    public d(f fVar) {
        this.f14364a = fVar;
    }

    @Override // m6.a
    public final void a(boolean z5) {
        this.f14364a.f14371d.a(z5);
    }

    @Override // m6.a
    public final void b(BluetoothDevice bluetoothDevice, int i3) {
        f fVar = this.f14364a;
        fVar.f14371d.c(bluetoothDevice, 0, i3);
        ef.i iVar = fVar.e;
        iVar.getClass();
        iVar.i(new g());
    }

    @Override // m6.a
    public final void c(BluetoothDevice bluetoothDevice, int i3, int i10) {
        this.f14364a.f14371d.b(bluetoothDevice, i3, i10);
    }

    @Override // m6.a
    public final void d(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr) {
        f fVar = this.f14364a;
        fVar.f14371d.f(bluetoothDevice, 0, uuid2, bArr);
        ef.i iVar = fVar.e;
        iVar.getClass();
        iVar.i(new g());
    }

    @Override // m6.a
    public final void h(BluetoothDevice bluetoothDevice, BleScanInfo bleScanInfo) {
        this.f14364a.f14371d.d(bluetoothDevice, bleScanInfo);
    }

    @Override // m6.a
    public final void i() {
        this.f14364a.f14371d.e(0);
    }
}
