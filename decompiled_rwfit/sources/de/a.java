package de;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12342a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f12343b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12344c;

    public /* synthetic */ a(BluetoothDevice bluetoothDevice, int i3, int i10) {
        this.f12342a = i10;
        this.f12343b = bluetoothDevice;
        this.f12344c = i3;
    }

    @Override // de.l
    public final void k(Object obj) {
        rd.c cVar = (rd.c) obj;
        switch (this.f12342a) {
            case 0:
                cVar.e(this.f12343b, this.f12344c);
                break;
            case 1:
                cVar.k(this.f12343b, this.f12344c);
                break;
            case 2:
                cVar.p(this.f12343b, this.f12344c);
                break;
            default:
                cVar.i(this.f12343b, this.f12344c);
                break;
        }
    }
}
