package o6;

import android.bluetooth.BluetoothDevice;
import androidx.recyclerview.widget.x;
import com.google.android.gms.internal.mlkit_vision_common.i0;
import java.util.Locale;

/* loaded from: classes.dex */
public final class o implements qd.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16782a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16783b;

    public /* synthetic */ o(Object obj, int i3) {
        this.f16782a = i3;
        this.f16783b = obj;
    }

    @Override // qd.l
    public final void a(BluetoothDevice bluetoothDevice, int i3, String str) {
        switch (this.f16782a) {
            case 0:
                ee.c.b(4, "SppManager", String.format(Locale.getDefault(), "-onAuthFailed- device : %s, code : %d, message : %s", ee.a.e(((p) this.f16783b).f16786a, bluetoothDevice), Integer.valueOf(i3), str));
                ((p) this.f16783b).getClass();
                p pVar = (p) this.f16783b;
                pVar.b(bluetoothDevice, pVar.f16794j);
                break;
            default:
                k6.b bVar = (k6.b) this.f16783b;
                String str2 = bVar.f17897a;
                String e = ee.a.e(bVar.f17901f, bluetoothDevice);
                Locale locale = Locale.ENGLISH;
                ee.c.f(str2, "onAuthFailed", "device : " + e + ", code : " + i3 + ", message : " + str);
                bVar.f17899c.d(bluetoothDevice, false);
                if (!bVar.A.h()) {
                    x b3 = i0.b(20481, i3, str);
                    bVar.x(bluetoothDevice, 2);
                    bVar.p("callbackConnectFailed", b3);
                    break;
                } else {
                    bVar.x(bluetoothDevice, 2);
                    break;
                }
        }
    }

    @Override // qd.l
    public final void b(BluetoothDevice bluetoothDevice) {
        switch (this.f16782a) {
            case 0:
                ee.c.b(4, "SppManager", "-onAuthSuccess- >>> auth ok, handleSppConnection : " + ee.a.e(((p) this.f16783b).f16786a, bluetoothDevice));
                ((p) this.f16783b).getClass();
                p pVar = (p) this.f16783b;
                pVar.e(bluetoothDevice, pVar.f16794j, 2);
                break;
            default:
                k6.b bVar = (k6.b) this.f16783b;
                bVar.f17899c.d(bluetoothDevice, true);
                boolean D = bVar.D(bluetoothDevice);
                String str = bVar.f17897a;
                String e = ee.a.e(bVar.f17901f, bluetoothDevice);
                Locale locale = Locale.ENGLISH;
                ee.c.f(str, "onAuthSuccess", "device[" + e + "] auth ok, isBleConnected = " + D);
                if (!D) {
                    bVar.v(bluetoothDevice, 1);
                    break;
                } else {
                    bVar.H(bluetoothDevice);
                    break;
                }
        }
    }

    @Override // qd.l
    public final void c(boolean z5) {
        switch (this.f16782a) {
            case 0:
                ee.c.b(5, "SppManager", "-onInitResult- " + z5);
                break;
            default:
                ee.c.c(((k6.b) this.f16783b).f17897a, "onInitResult", "result : " + z5);
                break;
        }
    }
}
