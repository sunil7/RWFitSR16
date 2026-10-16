package qd;

import android.bluetooth.BluetoothDevice;
import androidx.recyclerview.widget.x;

/* loaded from: classes.dex */
public final class g implements rd.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17921a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f17922b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k6.b f17923c;

    public /* synthetic */ g(k6.b bVar, BluetoothDevice bluetoothDevice, int i3) {
        this.f17921a = i3;
        this.f17923c = bVar;
        this.f17922b = bluetoothDevice;
    }

    @Override // rd.b
    public final void a(x xVar) {
        switch (this.f17921a) {
            case 0:
                this.f17923c.p("ReadFileThread", xVar);
                break;
            case 1:
                this.f17923c.p("upgradePrepare", xVar);
                break;
            case 2:
                this.f17923c.p("upgradeStep02", xVar);
                break;
            default:
                this.f17923c.p("readyToReconnectDevice", xVar);
                break;
        }
    }

    @Override // rd.b
    public final void onSuccess(Object obj) {
        switch (this.f17921a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                String str = this.f17923c.f17897a;
                StringBuilder sb2 = new StringBuilder("onSuccess, length = ");
                sb2.append(bArr == null ? 0 : bArr.length);
                ee.c.e(str, "ReadFileThread", sb2.toString());
                this.f17923c.F = bArr;
                this.f17923c.I(this.f17922b);
                break;
            case 1:
                k6.b bVar = this.f17923c;
                fc.c cVar = bVar.f17899c;
                BluetoothDevice bluetoothDevice = this.f17922b;
                cVar.f(bluetoothDevice, (be.j) obj);
                bVar.J(bluetoothDevice);
                break;
            case 2:
                this.f17923c.o(this.f17922b, (byte[]) obj);
                break;
            default:
                Integer num = (Integer) obj;
                this.f17923c.M.removeMessages(4665);
                if (this.f17923c.A.j()) {
                    de.k kVar = this.f17923c.A;
                    boolean z5 = num.intValue() == 1;
                    if (((ud.d) kVar.f12370g) != null) {
                        ((ud.d) kVar.f12370g).f19063c = z5;
                    }
                }
                i9.f fVar = this.f17923c.L;
                if (fVar != null) {
                    fVar.f14376c = num.intValue();
                    k6.b bVar2 = this.f17923c;
                    k6.b.r(bVar2, this.f17922b, bVar2.L);
                    break;
                }
                break;
        }
    }
}
