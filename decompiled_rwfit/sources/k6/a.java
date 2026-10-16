package k6;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import de.g;
import i6.i;
import java.util.UUID;
import kotlin.jvm.internal.e;
import o6.p;

/* loaded from: classes.dex */
public final class a extends i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f15511a;

    public a(b bVar) {
        this.f15511a = bVar;
    }

    @Override // i6.i
    public final void b(BluetoothDevice bluetoothDevice, int i3, int i10) {
        b bVar = this.f15511a;
        bVar.L(bVar.O.d(), i3, i10);
    }

    @Override // i6.i
    public final void c(BluetoothDevice bluetoothDevice, int i3, int i10) {
        int i11 = 1;
        if (i10 == 1) {
            i11 = 3;
        } else if (i10 != 2) {
            i11 = 0;
        }
        b bVar = this.f15511a;
        ee.c.b(3, bVar.f17897a, "onConnection >>> device : " + ee.a.e(bVar.f17901f, bluetoothDevice) + ", way = " + i3 + " status ：" + i10 + ", change status : " + i11);
        bVar.K(bluetoothDevice, i11);
    }

    @Override // i6.i
    public final void f(BluetoothDevice bluetoothDevice, int i3, UUID uuid, byte[] bArr) {
        if (i3 == 1 && !e.a(p.r, uuid)) {
            ee.c.b(2, this.f15511a.f17897a, "onReceiveData >>> skip spec");
            return;
        }
        b bVar = this.f15511a;
        bVar.getClass();
        if (bluetoothDevice == null || bArr == null) {
            return;
        }
        ee.c.c(bVar.f17897a, "onReceiveDeviceData", "device : " + ee.a.e(bVar.f17901f, bluetoothDevice) + ", recv data : " + ee.b.c(bArr));
        if (!bVar.d(bluetoothDevice)) {
            ee.c.e(bVar.f17897a, "onReceiveDeviceData", "handleAuthData ");
            bVar.B.handleAuthData(bluetoothDevice, bArr);
            return;
        }
        if (bVar.f17904i == null) {
            ee.c.e(bVar.f17897a, "onReceiveDeviceData", "No data processor.");
            return;
        }
        ud.a aVar = new ud.a();
        aVar.f19048a = 1;
        aVar.f19052f = bluetoothDevice;
        aVar.f19049b = bArr;
        de.i iVar = bVar.f17904i;
        ((Handler) iVar.f12361g).post(new g(iVar, aVar, 1));
        ee.c.c(bVar.f17897a, "onReceiveDeviceData", "addRecvData : " + aVar);
    }
}
