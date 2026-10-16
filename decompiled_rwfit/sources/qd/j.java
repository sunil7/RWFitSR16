package qd;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public BluetoothDevice f17931a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17932b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17933c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f17934d;
    public int e;

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AuthTask{device=");
        sb2.append(this.f17931a);
        sb2.append(", isAuthProgressResult=");
        sb2.append(this.f17932b);
        sb2.append(", isAuthDevice=");
        sb2.append(this.f17933c);
        sb2.append(", randomData=");
        sb2.append(ee.b.c(this.f17934d));
        sb2.append(", retryNum=");
        return android.support.v4.media.session.e.m(sb2, this.e, '}');
    }
}
