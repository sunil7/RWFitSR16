package qd;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;

/* loaded from: classes.dex */
public final class b implements BluetoothProfile.ServiceListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k6.b f17908a;

    public b(k6.b bVar) {
        this.f17908a = bVar;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceConnected(int i3, BluetoothProfile bluetoothProfile) {
        k6.b bVar = this.f17908a;
        ee.c.e(bVar.f17897a, "onServiceConnected", "profile : " + i3);
        if (2 == i3) {
            bVar.f15522x = (BluetoothA2dp) bluetoothProfile;
        } else if (1 == i3) {
            bVar.f15521w = (BluetoothHeadset) bluetoothProfile;
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceDisconnected(int i3) {
        k6.b bVar = this.f17908a;
        ee.c.e(bVar.f17897a, "onServiceDisconnected", "profile : " + i3);
        if (2 == i3) {
            bVar.f15522x = null;
        } else if (1 == i3) {
            bVar.f15521w = null;
        }
    }
}
