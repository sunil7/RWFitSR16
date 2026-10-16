package i6;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import java.util.ArrayList;
import l6.o;
import o6.p;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: f, reason: collision with root package name */
    public static final eb.e f14366f = new eb.e(13);

    /* renamed from: g, reason: collision with root package name */
    public static volatile f f14367g;

    /* renamed from: a, reason: collision with root package name */
    public final j6.a f14368a;

    /* renamed from: b, reason: collision with root package name */
    public final o f14369b;

    /* renamed from: c, reason: collision with root package name */
    public final p f14370c;

    /* renamed from: d, reason: collision with root package name */
    public final b f14371d;
    public final ef.i e;

    public f() {
        j6.a g10 = j6.a.f15325b.g();
        this.f14368a = g10;
        if (o.f15804o == null) {
            synchronized (o.class) {
                try {
                    if (o.f15804o == null) {
                        XXApplication xXApplication = XXApplication.f7400h;
                        o.f15804o = new o(j1.a());
                        ee.c.b(4, "o", "init BleManager.. " + o.f15804o);
                    }
                } finally {
                }
            }
        }
        o oVar = o.f15804o;
        this.f14369b = oVar;
        if (p.f16784q == null) {
            synchronized (p.class) {
                try {
                    if (p.f16784q == null) {
                        XXApplication xXApplication2 = XXApplication.f7400h;
                        p.f16784q = new p(j1.a());
                    }
                } finally {
                }
            }
        }
        p pVar = p.f16784q;
        this.f14370c = pVar;
        this.f14371d = new b();
        this.e = new ef.i(21);
        d dVar = new d(this);
        e eVar = new e(this);
        if (g10.a()) {
            ArrayList arrayList = oVar.f15815i.f15792a;
            if (arrayList.contains(dVar)) {
                return;
            }
            arrayList.add(dVar);
            return;
        }
        ArrayList arrayList2 = (ArrayList) pVar.f16788c.f16732a;
        if (arrayList2.contains(eVar)) {
            return;
        }
        arrayList2.add(eVar);
    }

    public final void a(BluetoothDevice bluetoothDevice) {
        if (this.f14368a.a()) {
            this.f14369b.a(bluetoothDevice);
        } else {
            this.f14370c.a(bluetoothDevice, p.r);
        }
    }

    public final void b(BluetoothDevice bluetoothDevice) {
        if (this.f14368a.a()) {
            this.f14369b.b(bluetoothDevice);
        } else {
            this.f14370c.b(bluetoothDevice, null);
        }
    }

    public final BluetoothDevice c() {
        return this.f14368a.a() ? this.f14369b.f15812f : this.f14370c.f16791g;
    }

    public final BluetoothGatt d() {
        if (!this.f14368a.a()) {
            return null;
        }
        n6.b d5 = this.f14369b.d(c());
        if (d5 == null) {
            return null;
        }
        return d5.f16383b;
    }
}
