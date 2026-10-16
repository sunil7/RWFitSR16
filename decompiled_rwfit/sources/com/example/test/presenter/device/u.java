package com.example.test.presenter.device;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.example.test.ui.device.model.BleDeviceModel;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class u extends com.example.baselibrary.preseneter.b implements u5.j {
    public static void l() {
        r5.d.d().f(null, false);
    }

    public static void m() {
        r5.d.d().g();
    }

    @Override // u5.j
    public final void f() {
        ((f7.f) this.f7255a).s0();
    }

    @Override // u5.j
    public final void g(s5.a aVar) {
        BleDeviceModel bleDeviceModel = new BleDeviceModel();
        bleDeviceModel.setMac(aVar.f18212c);
        bleDeviceModel.setName(aVar.f18210a);
        bleDeviceModel.setRssi(aVar.f18211b);
        bleDeviceModel.setRawDataFlag(aVar.f18214f);
        bleDeviceModel.setPidType(aVar.f18215g);
        ((f7.f) this.f7255a).y0(bleDeviceModel);
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        r5.d.d().h(this);
    }

    public final void k() {
        BluetoothManager bluetoothManager;
        r5.d d5 = r5.d.d();
        Context f02 = ((f7.f) this.f7255a).f0();
        d5.f18090f = f02;
        if (f02 != null && (bluetoothManager = (BluetoothManager) f02.getSystemService("bluetooth")) != null) {
            d5.f18091g = bluetoothManager.getAdapter();
        }
        r5.d d8 = r5.d.d();
        if (d8.e(this)) {
            return;
        }
        d8.f18088c.add(new WeakReference(this));
    }
}
