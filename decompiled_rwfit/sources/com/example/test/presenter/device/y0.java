package com.example.test.presenter.device;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.example.database.table.Devices;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.main.fragment.HeadsetFragment;
import com.google.android.gms.internal.mlkit_vision_barcode.tb;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import f6.k3;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public final class y0 implements rd.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7497a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7498b;

    public /* synthetic */ y0(Object obj, int i3) {
        this.f7497a = i3;
        this.f7498b = obj;
    }

    @Override // rd.c
    public void a(androidx.recyclerview.widget.x xVar) {
        switch (this.f7497a) {
            case 1:
                Log.e("qob", "onError " + xVar);
                break;
        }
    }

    public final void b(boolean z5, boolean z6) {
    }

    public final void c(BluetoothDevice bluetoothDevice, int i3, int i10) {
    }

    public final void d(BluetoothDevice bluetoothDevice, int i3) {
    }

    @Override // rd.c
    public final void e(BluetoothDevice bluetoothDevice, int i3) {
    }

    public final void f(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
    }

    @Override // rd.c
    public void g(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
        byte[] bArr;
        switch (this.f7497a) {
            case 2:
                if (bluetoothDevice != null) {
                    de.k kVar = (de.k) this.f7498b;
                    if (kVar.h()) {
                        if (bleScanMessage != null) {
                            ((HashMap) kVar.e).put(bluetoothDevice.getAddress(), bleScanMessage);
                            bArr = bleScanMessage.getRawData();
                        } else {
                            bArr = null;
                        }
                        boolean c9 = de.k.c(kVar, bluetoothDevice, bArr);
                        String e = ee.a.e((XXApplication) kVar.f12367c, bluetoothDevice);
                        Locale locale = Locale.ENGLISH;
                        ee.c.c("DeviceReConnectManager", "onDiscovery", "isReConnectDevice : " + c9 + ", device : " + e);
                        if (c9) {
                            kVar.a(bluetoothDevice);
                            kVar.g();
                            break;
                        }
                    }
                }
                break;
        }
    }

    public final void h(boolean z5, boolean z6) {
    }

    @Override // rd.c
    public final void i(BluetoothDevice bluetoothDevice, int i3) {
    }

    @Override // rd.c
    public void j(BluetoothDevice bluetoothDevice, int i3, int i10) {
        switch (this.f7497a) {
            case 1:
                Log.e("qob", "onBleDataBlockChanged " + i3 + " p2 " + i10);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    @Override // rd.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.bluetooth.BluetoothDevice r11, int r12) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.presenter.device.y0.k(android.bluetooth.BluetoothDevice, int):void");
    }

    public final void l(androidx.recyclerview.widget.x xVar) {
    }

    @Override // rd.c
    public void m(BluetoothDevice bluetoothDevice, vd.b bVar) {
        Devices c9;
        k3 k3Var;
        int i3 = 3;
        switch (this.f7497a) {
            case 1:
                if (bVar instanceof xd.a) {
                    byte[] bArr = ((zd.a) ((xd.a) bVar).f19229f).f20393d;
                    int i10 = bArr[2] & 255;
                    Log.e("qob", "onReceiveCommand tCmd " + i10 + " tLen " + (bArr[3] & 255));
                    if (i10 == 72) {
                        String str = new String(kotlin.collections.g.d(5, 10, bArr), kotlin.text.a.f15656a);
                        Log.e("qob", "tVersionInfo ".concat(str));
                        k3 k3Var2 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                        TextView textView = k3Var2 != null ? k3Var2.f13072n : null;
                        if (textView != null) {
                            textView.setText("V".concat(str));
                        }
                        com.example.test.presenter.main.p0 p0Var = (com.example.test.presenter.main.p0) ((HeadsetFragment) this.f7498b).X();
                        p0Var.getClass();
                        p0Var.e = str;
                        HeadsetFragment headsetFragment = (HeadsetFragment) this.f7498b;
                        k3 k3Var3 = (k3) headsetFragment.f7251b;
                        TextView textView2 = k3Var3 != null ? k3Var3.f13070l : null;
                        if (textView2 != null) {
                            textView2.setText(headsetFragment.getString(R$string.str_connected));
                        }
                        xd.a a3 = tb.a(new byte[]{90, -91, 73, 4});
                        k6.b bVar2 = ((HeadsetFragment) this.f7498b).f8070c;
                        if (bVar2 != null) {
                            bVar2.i(a3, null);
                            return;
                        }
                        return;
                    }
                    if (i10 == 73) {
                        String str2 = new String(kotlin.collections.g.d(4, 12, bArr), kotlin.text.a.f15656a);
                        com.example.test.presenter.main.p0 p0Var2 = (com.example.test.presenter.main.p0) ((HeadsetFragment) this.f7498b).X();
                        p0Var2.getClass();
                        p0Var2.f7545f = str2;
                        Log.e("qob", "tDeviceIdInfo ".concat(str2));
                        HeadsetFragment headsetFragment2 = (HeadsetFragment) this.f7498b;
                        if (!headsetFragment2.f8071d) {
                            headsetFragment2.f8071d = true;
                            com.example.test.presenter.main.p0 p0Var3 = (com.example.test.presenter.main.p0) headsetFragment2.X();
                            p0Var3.getClass();
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                            if (kVar != null && (c9 = kVar.c()) != null) {
                                c6.b bVar3 = c6.b.f3390c;
                                String macAddress = c9.getMacAddress();
                                kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
                                bVar3.d(macAddress, str2).subscribe(new y(p0Var3, (FragmentActivity) ((HeadsetFragment) ((e7.a) p0Var3.f7255a)).f0(), com.example.test.utils.w0.d(), i3));
                            }
                        }
                        xd.a a10 = tb.a(new byte[]{90, -91, -1, 4});
                        k6.b bVar4 = ((HeadsetFragment) this.f7498b).f8070c;
                        if (bVar4 != null) {
                            bVar4.i(a10, null);
                            return;
                        }
                        return;
                    }
                    if (i10 != 255) {
                        return;
                    }
                    byte b3 = bArr[4];
                    int i11 = bArr[5] & 255;
                    byte b10 = bArr[6];
                    byte b11 = bArr[7];
                    byte b12 = bArr[8];
                    int i12 = bArr[9] & 255;
                    int i13 = bArr[10] & 255;
                    int i14 = bArr[11] & 255;
                    int i15 = bArr[12] & 255;
                    HeadsetFragment headsetFragment3 = (HeadsetFragment) this.f7498b;
                    headsetFragment3.f8073g = i14;
                    k3 k3Var4 = (k3) headsetFragment3.f7251b;
                    TextView textView3 = k3Var4 != null ? k3Var4.f13068j : null;
                    if (textView3 != null) {
                        textView3.setText("L" + i12 + "%");
                    }
                    k3 k3Var5 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                    TextView textView4 = k3Var5 != null ? k3Var5.f13069k : null;
                    if (textView4 != null) {
                        textView4.setText("R" + i13 + "%");
                    }
                    k3 k3Var6 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                    TextView textView5 = k3Var6 != null ? k3Var6.f13067i : null;
                    if (textView5 != null) {
                        textView5.setText(" " + i14 + "%");
                    }
                    k3 k3Var7 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                    ProgressBar progressBar = k3Var7 != null ? k3Var7.f13063d : null;
                    if (progressBar != null) {
                        progressBar.setProgress(i12);
                    }
                    k3 k3Var8 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                    ProgressBar progressBar2 = k3Var8 != null ? k3Var8.e : null;
                    if (progressBar2 != null) {
                        progressBar2.setProgress(i13);
                    }
                    k3 k3Var9 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                    ProgressBar progressBar3 = k3Var9 != null ? k3Var9.f13062c : null;
                    if (progressBar3 != null) {
                        progressBar3.setProgress(i14);
                    }
                    k3 k3Var10 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                    SeekBar seekBar = k3Var10 != null ? k3Var10.f13064f : null;
                    if (seekBar != null) {
                        seekBar.setProgress(i15);
                    }
                    if (i11 == 0) {
                        k3 k3Var11 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                        if (k3Var11 != null) {
                            k3Var11.f13061b.setImageResource(R$mipmap.hs_equalizer_bg1);
                            return;
                        }
                        return;
                    }
                    if (i11 == 1) {
                        k3 k3Var12 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                        if (k3Var12 != null) {
                            k3Var12.f13061b.setImageResource(R$mipmap.hs_equalizer_bg2);
                            return;
                        }
                        return;
                    }
                    if (i11 == 2) {
                        k3 k3Var13 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                        if (k3Var13 != null) {
                            k3Var13.f13061b.setImageResource(R$mipmap.hs_equalizer_bg3);
                            return;
                        }
                        return;
                    }
                    if (i11 != 3) {
                        if (i11 == 4 && (k3Var = (k3) ((HeadsetFragment) this.f7498b).f7251b) != null) {
                            k3Var.f13061b.setImageResource(R$mipmap.hs_equalizer_bg5);
                            return;
                        }
                        return;
                    }
                    k3 k3Var14 = (k3) ((HeadsetFragment) this.f7498b).f7251b;
                    if (k3Var14 != null) {
                        k3Var14.f13061b.setImageResource(R$mipmap.hs_equalizer_bg4);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void n(BluetoothDevice bluetoothDevice) {
    }

    @Override // rd.c
    public void o(boolean z5, boolean z6) {
        switch (this.f7497a) {
            case 2:
                ee.c.c("DeviceReConnectManager", "onDiscoveryStatus", "bStart : " + z6);
                if (((de.k) this.f7498b).h()) {
                    de.k kVar = (de.k) this.f7498b;
                    if (kVar.e() == null || kVar.e().f19064d != 2) {
                        if (!z6) {
                            ee.c.c("DeviceReConnectManager", "onDiscoveryStatus", "ready start scan");
                            ((de.k) this.f7498b).f12365a.removeMessages(37973);
                            ((de.k) this.f7498b).f12365a.sendEmptyMessageDelayed(37973, 1000L);
                            break;
                        } else if (((ud.d) ((de.k) this.f7498b).f12370g) != null && ((ud.d) ((de.k) this.f7498b).f12370g).f19064d == 0) {
                            ((ud.d) ((de.k) this.f7498b).f12370g).f19064d = 1;
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override // rd.c
    public void p(BluetoothDevice bluetoothDevice, int i3) {
        switch (this.f7497a) {
            case 1:
                Log.e("qob", "onBtDeviceConnection");
                break;
        }
    }

    @Override // rd.c
    public void q(boolean z5, boolean z6) {
        switch (this.f7497a) {
            case 2:
                if (!z5 && ((de.k) this.f7498b).h()) {
                    ee.c.c("DeviceReConnectManager", "onAdapterStatus", "bluetooth is off.");
                    break;
                }
                break;
        }
    }

    @Override // rd.c
    public void r(BluetoothDevice bluetoothDevice) {
        switch (this.f7497a) {
            case 1:
                Log.e("qob", "onMandatoryUpgrade " + (bluetoothDevice != null ? bluetoothDevice.getAddress() : null));
                break;
        }
    }

    public final void s(BluetoothDevice bluetoothDevice, vd.b bVar) {
    }
}
