package l6;

import android.bluetooth.BluetoothGatt;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final BluetoothGatt f15821a;

    /* renamed from: b, reason: collision with root package name */
    public final UUID f15822b;

    /* renamed from: c, reason: collision with root package name */
    public final UUID f15823c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f15824d;
    public int e = -1;

    /* renamed from: f, reason: collision with root package name */
    public i6.c f15825f;

    public p(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2, byte[] bArr, i6.c cVar) {
        this.f15821a = bluetoothGatt;
        this.f15822b = uuid;
        this.f15823c = uuid2;
        this.f15824d = bArr;
        this.f15825f = cVar;
    }

    public final boolean equals(Object obj) {
        UUID uuid;
        UUID uuid2;
        if (obj instanceof p) {
            p pVar = (p) obj;
            BluetoothGatt bluetoothGatt = this.f15821a;
            if (bluetoothGatt != null && (uuid = this.f15822b) != null && (uuid2 = this.f15823c) != null && bluetoothGatt.equals(pVar.f15821a) && uuid.equals(pVar.f15822b) && uuid2.equals(pVar.f15823c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        UUID uuid;
        UUID uuid2;
        BluetoothGatt bluetoothGatt = this.f15821a;
        return (bluetoothGatt == null || (uuid = this.f15822b) == null || (uuid2 = this.f15823c) == null) ? super.hashCode() : uuid2.hashCode() + uuid.hashCode() + bluetoothGatt.hashCode();
    }

    public final String toString() {
        return "BleSendTask{mGatt=" + this.f15821a + ", serviceUUID=" + this.f15822b + ", characteristicUUID=" + this.f15823c + ", data=" + Arrays.toString(this.f15824d) + ", status=" + this.e + ", mCallback=" + this.f15825f + '}';
    }
}
