package qd;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import androidx.recyclerview.widget.x;
import com.google.android.gms.internal.mlkit_vision_barcode.ub;
import com.google.android.gms.internal.mlkit_vision_common.i0;
import de.n;
import java.util.Locale;

/* loaded from: classes.dex */
public final class h implements rd.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17924a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f17925b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k6.b f17926c;

    public /* synthetic */ h(k6.b bVar, BluetoothDevice bluetoothDevice, int i3) {
        this.f17924a = i3;
        this.f17926c = bVar;
        this.f17925b = bluetoothDevice;
    }

    @Override // rd.b
    public final void a(x xVar) {
        switch (this.f17924a) {
            case 0:
                k6.b bVar = this.f17926c;
                bVar.x(this.f17925b, 2);
                bVar.p("callbackConnectFailed", xVar);
                break;
            case 1:
                this.f17926c.p("upgradeStep01", xVar);
                break;
            default:
                this.f17926c.p("upgradeStep02", xVar);
                break;
        }
    }

    @Override // rd.b
    public final void onSuccess(Object obj) {
        be.j a3;
        x a10;
        be.j a11;
        switch (this.f17924a) {
            case 0:
                be.j jVar = (be.j) obj;
                this.f17926c.f17899c.f(this.f17925b, jVar);
                if (jVar.I) {
                    n nVar = this.f17926c.f15524z;
                    n6.a aVar = new n6.a(this, 10);
                    nVar.getClass();
                    nVar.f12375a.i(new xd.i(), new ef.i(16, aVar, new n9.e(9)));
                }
                if (jVar.f3253w == 1) {
                    ee.c.f(this.f17926c.f17897a, "getDeviceInfoWithConnection", "sdkType : " + jVar.r);
                    k6.b bVar = this.f17926c;
                    BluetoothDevice bluetoothDevice = this.f17925b;
                    fc.c cVar = bVar.f17899c;
                    if (cVar.c(bluetoothDevice) < 530 && (a3 = cVar.a(bluetoothDevice)) != null) {
                        a3.K = 530;
                        cVar.f(bluetoothDevice, a3);
                    }
                    if (jVar.r >= 2) {
                        BluetoothGatt d5 = this.f17926c.O.d();
                        if (ub.a(this.f17926c.f17901f) && d5 != null) {
                            boolean requestConnectionPriority = d5.requestConnectionPriority(1);
                            ee.c.f(this.f17926c.f17897a, "getDeviceInfoWithConnection", "requestConnectionPriority :: ret : " + requestConnectionPriority);
                        }
                    }
                } else {
                    de.k kVar = this.f17926c.A;
                    if (kVar.j()) {
                        kVar.k(null);
                        kVar.n();
                    }
                    if (this.f17926c.E) {
                        ee.c.c(this.f17926c.f17897a, "getDeviceInfoWithConnection", "The device is functioning properly. However, the cache status is currently being upgraded, so the upgrade call is complete.");
                        k6.b.q(this.f17926c);
                    }
                }
                k6.b bVar2 = this.f17926c;
                BluetoothDevice bluetoothDevice2 = this.f17925b;
                bVar2.x(bluetoothDevice2, 1);
                be.j a12 = bVar2.f17899c.a(bluetoothDevice2);
                if (a12 != null && !bVar2.E) {
                    if (a12.f3253w == 1 || a12.f3254x == 1) {
                        bVar2.e.r(bluetoothDevice2);
                        break;
                    }
                }
                break;
            case 1:
                ud.c cVar2 = (ud.c) obj;
                k6.b bVar3 = this.f17926c;
                String str = bVar3.f17897a;
                Locale locale = Locale.ENGLISH;
                ee.c.b(3, str, "Step01.获取升级文件信息的偏移地址, " + cVar2);
                BluetoothDevice bluetoothDevice3 = this.f17925b;
                bVar3.l(bluetoothDevice3, 0.0f);
                int i3 = cVar2.f19059a;
                if (!bVar3.w("upgradeStep02")) {
                    int i10 = cVar2.f19060b;
                    if (i10 >= 0 && i3 >= 0) {
                        if (i3 != 0 || i10 != 0) {
                            bVar3.u(i3, i10, new g(bVar3, bluetoothDevice3, 2));
                            break;
                        } else {
                            int i11 = bVar3.f17902g.f2676b;
                            char[] cArr = ee.b.f12595a;
                            bVar3.o(bluetoothDevice3, new byte[]{(byte) i11});
                            break;
                        }
                    } else {
                        bVar3.p("upgradeStep02", i0.c(4097, "upgradeStep02: offset = " + i3 + ", len = " + i10));
                        break;
                    }
                }
                break;
            default:
                Integer num = (Integer) obj;
                k6.b bVar4 = this.f17926c;
                String str2 = bVar4.f17897a;
                Locale locale2 = Locale.ENGLISH;
                ee.c.b(3, str2, "Step2.发送升级文件校验信息，确认是否可以升级, 结果: " + num);
                if (num.intValue() != 0) {
                    switch (num.intValue()) {
                        case 1:
                            a10 = i0.a(16386);
                            break;
                        case 2:
                            a10 = i0.c(16387, "Command E2, result = " + num);
                            break;
                        case 3:
                            a10 = i0.a(16396);
                            break;
                        case 4:
                            a10 = i0.a(16397);
                            break;
                        case 5:
                            a10 = i0.a(16398);
                            break;
                        case 6:
                            a10 = i0.a(16403);
                            break;
                        case 7:
                            a10 = i0.a(16404);
                            break;
                        default:
                            a10 = i0.b(16385, num.intValue(), "upgradeStep2 :: Unknown error : " + num);
                            break;
                    }
                    a(a10);
                    break;
                } else if (!bVar4.w("checkUpgradeEnvironment")) {
                    BluetoothDevice bluetoothDevice4 = this.f17925b;
                    fc.c cVar3 = bVar4.f17899c;
                    be.j a13 = cVar3.a(bluetoothDevice4);
                    ee.c.c(bVar4.f17897a, "checkUpgradeEnvironment", "device : " + ee.a.e(bVar4.f17901f, bluetoothDevice4) + ", deviceInfo ：" + a13);
                    if (a13 != null) {
                        if (!a13.A) {
                            if (!a13.B) {
                                if (a13.f3253w != 1) {
                                    bVar4.G(bluetoothDevice4);
                                    break;
                                } else {
                                    bVar4.W();
                                    break;
                                }
                            } else {
                                if (cVar3.c(bluetoothDevice4) < 530 && (a11 = cVar3.a(bluetoothDevice4)) != null) {
                                    a11.K = 530;
                                    cVar3.f(bluetoothDevice4, a11);
                                }
                                bVar4.V();
                                break;
                            }
                        } else {
                            de.k kVar2 = bVar4.A;
                            if (kVar2.j()) {
                                kVar2.k(null);
                                kVar2.n();
                            }
                            bVar4.W();
                            break;
                        }
                    } else {
                        bVar4.p("checkUpgradeEnvironment", i0.a(4114));
                        break;
                    }
                }
                break;
        }
    }
}
