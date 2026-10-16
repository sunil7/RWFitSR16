package i6;

import android.bluetooth.BluetoothDevice;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class a implements h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14357a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14358b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14359c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14360d;

    public /* synthetic */ a(BluetoothDevice bluetoothDevice, int i3, int i10, int i11) {
        this.f14357a = i11;
        this.f14358b = bluetoothDevice;
        this.f14359c = i3;
        this.f14360d = i10;
    }

    public byte a(int i3, int i10) {
        return ((byte[][]) this.f14358b)[i10][i3];
    }

    public void b(int i3, int i10, int i11) {
        ((byte[][]) this.f14358b)[i10][i3] = (byte) i11;
    }

    @Override // i6.h
    public void j(Object obj) {
        switch (this.f14357a) {
            case 0:
                i callback = (i) obj;
                kotlin.jvm.internal.e.f(callback, "callback");
                callback.b((BluetoothDevice) this.f14358b, this.f14359c, this.f14360d);
                break;
            default:
                i callback2 = (i) obj;
                kotlin.jvm.internal.e.f(callback2, "callback");
                callback2.c((BluetoothDevice) this.f14358b, this.f14359c, this.f14360d);
                break;
        }
    }

    public String toString() {
        switch (this.f14357a) {
            case 2:
                int i3 = this.f14359c;
                int i10 = this.f14360d;
                StringBuilder sb2 = new StringBuilder((i3 * 2 * i10) + 2);
                for (int i11 = 0; i11 < i10; i11++) {
                    byte[] bArr = ((byte[][]) this.f14358b)[i11];
                    for (int i12 = 0; i12 < i3; i12++) {
                        byte b3 = bArr[i12];
                        if (b3 == 0) {
                            sb2.append(" 0");
                        } else if (b3 != 1) {
                            sb2.append("  ");
                        } else {
                            sb2.append(" 1");
                        }
                    }
                    sb2.append('\n');
                }
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public a(int i3, int i10) {
        this.f14357a = 2;
        this.f14358b = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i10, i3);
        this.f14359c = i3;
        this.f14360d = i10;
    }
}
