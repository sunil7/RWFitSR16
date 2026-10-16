package qd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import androidx.appcompat.app.y;
import androidx.recyclerview.widget.n0;
import androidx.recyclerview.widget.x;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.ub;
import com.google.android.gms.internal.mlkit_vision_common.i0;
import d4.t;
import de.m;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f17897a = getClass().getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public final BluetoothAdapter f17898b;

    /* renamed from: c, reason: collision with root package name */
    public final fc.c f17899c;

    /* renamed from: d, reason: collision with root package name */
    public final t f17900d;
    public final de.e e;

    /* renamed from: f, reason: collision with root package name */
    public final XXApplication f17901f;

    /* renamed from: g, reason: collision with root package name */
    public n0 f17902g;

    /* renamed from: h, reason: collision with root package name */
    public volatile BluetoothDevice f17903h;

    /* renamed from: i, reason: collision with root package name */
    public volatile de.i f17904i;

    /* renamed from: j, reason: collision with root package name */
    public d6.a f17905j;

    /* renamed from: k, reason: collision with root package name */
    public y f17906k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f17907l;

    public a(XXApplication xXApplication) {
        n0 n0Var = new n0(1);
        n0Var.f2676b = 0;
        n0Var.e = 3000;
        n0Var.f2678d = false;
        n0Var.f2677c = false;
        this.f17902g = n0Var;
        this.f17901f = xXApplication;
        ub.f9549a = new WeakReference(xXApplication);
        this.f17898b = BluetoothAdapter.getDefaultAdapter();
        this.f17899c = new fc.c(1);
        this.f17900d = new t(1);
        char[] cArr = ee.a.f12594a;
        this.f17907l = xXApplication.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        this.e = new de.e();
        if (this.f17906k == null) {
            this.f17906k = new y(this, 4);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            xXApplication.registerReceiver(this.f17906k, intentFilter);
        }
    }

    public boolean a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        return k(bluetoothDevice, bArr);
    }

    public final void b(BluetoothDevice bluetoothDevice, vd.b bVar, int i3, int i10, rd.a aVar) {
        int i11;
        int intValue;
        if (bluetoothDevice == null) {
            bluetoothDevice = g();
        }
        if (bluetoothDevice == null) {
            c(i0.a(4114), aVar);
            return;
        }
        if (!d(bluetoothDevice)) {
            c(i0.a(20481), aVar);
            return;
        }
        if (this.f17904i == null) {
            ee.c.c(this.f17897a, "sendCommandAsync", "No data processor.");
            c(i0.c(4114, "No data processor."), aVar);
            return;
        }
        if (i3 == 1) {
            if (this.f17905j == null) {
                this.f17905j = new d6.a(2);
            }
            d6.a aVar2 = this.f17905j;
            synchronized (aVar2) {
                Integer num = (Integer) ((HashMap) aVar2.f12306b).get(bluetoothDevice.getAddress());
                intValue = num == null ? aVar2.f12305a : num.intValue();
                int i12 = intValue + 1;
                if (i12 >= 256) {
                    i12 = 0;
                }
                ((HashMap) aVar2.f12306b).put(bluetoothDevice.getAddress(), Integer.valueOf(i12));
            }
            bVar.f19225a = intValue;
            t tVar = this.f17900d;
            tVar.getClass();
            int i13 = bVar.f19228d;
            if (i13 == 2 || i13 == 3) {
                tVar.f12284a.put(t.a(bluetoothDevice, bVar.f19226b, bVar.f19225a), bVar);
            }
        }
        byte[] bArr = m.f12371a;
        boolean z5 = i3 == 1;
        int i14 = (z5 && ((i11 = bVar.f19228d) == 2 || i11 == 3)) ? 1 : 0;
        vd.a aVar3 = new vd.a();
        aVar3.f19218a = i3;
        aVar3.f19219b = i14;
        int i15 = bVar.f19226b;
        aVar3.f19220c = i15;
        aVar3.f19222f = bVar.f19225a;
        aVar3.e = bVar.e;
        int i16 = z5 ? 1 : 2;
        jd.a aVar4 = bVar.f19229f;
        if (aVar4 != null) {
            if (i15 == 1) {
                aVar3.f19223g = aVar4.f15404b;
                i16++;
            }
            byte[] a3 = aVar4.a();
            if (a3 != null && a3.length > 0) {
                aVar3.f19224h = a3;
                i16 += a3.length;
            }
        }
        aVar3.f19221d = i16;
        ud.a aVar5 = new ud.a();
        aVar5.f19048a = 0;
        aVar5.f19052f = bluetoothDevice;
        aVar5.f19050c = aVar3;
        aVar5.f19051d = i10;
        aVar5.e = aVar;
        ee.c.c(this.f17897a, "sendRcspCommand", "addSendData :: cmdType : " + i3 + ", " + aVar5);
        this.f17904i.c(aVar5);
    }

    public final void c(x xVar, rd.a aVar) {
        ee.c.f(this.f17897a, "cbCommandError", "callback : " + aVar + ", " + xVar);
        if (aVar != null) {
            aVar.m(xVar);
        } else {
            e(xVar);
        }
    }

    public final boolean d(BluetoothDevice bluetoothDevice) {
        if (!this.f17902g.f2678d) {
            return true;
        }
        ud.b b3 = this.f17899c.b(bluetoothDevice);
        return b3 != null ? b3.f19055a : false;
    }

    public abstract void e(x xVar);

    public final vd.b f(BluetoothDevice bluetoothDevice, vd.a aVar) {
        if (aVar == null) {
            return null;
        }
        return (vd.b) this.f17900d.f12284a.get(t.a(bluetoothDevice, aVar.f19220c, aVar.f19222f));
    }

    public final BluetoothDevice g() {
        BluetoothDevice c9 = ((k6.b) this).O.c();
        if (this.f17903h == null) {
            this.f17903h = c9;
        } else if (c9 != null && !ee.a.b(c9, this.f17903h)) {
            this.f17903h = c9;
        }
        return this.f17903h;
    }

    public final void h(BluetoothDevice bluetoothDevice, vd.a aVar) {
        t tVar = this.f17900d;
        tVar.getClass();
        if (aVar != null) {
            tVar.f12284a.remove(t.a(bluetoothDevice, aVar.f19220c, aVar.f19222f));
        }
    }

    public final void i(vd.b bVar, rd.a aVar) {
        b(g(), bVar, 1, this.f17902g.e, aVar);
    }

    public final void j(vd.b bVar) {
        b(g(), bVar, 0, this.f17902g.e, null);
    }

    public abstract boolean k(BluetoothDevice bluetoothDevice, byte[] bArr);
}
