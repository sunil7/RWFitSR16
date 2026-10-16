package o6;

import android.bluetooth.BluetoothDevice;
import java.util.UUID;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements qd.k, p6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f16781a;

    public /* synthetic */ n(p pVar) {
        this.f16781a = pVar;
    }

    @Override // qd.k
    public boolean a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        p pVar = this.f16781a;
        pVar.getClass();
        pVar.i(bluetoothDevice, p.r, bArr, new n(pVar));
        return true;
    }

    @Override // p6.a
    public void b(BluetoothDevice bluetoothDevice, UUID uuid, boolean z5) {
        ee.c.b(3, "SppManager", "-sendAuthDataToDevice- device = " + ee.a.e(this.f16781a.f16786a, bluetoothDevice) + ", result = " + z5);
    }
}
