package ud;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f19048a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f19049b;

    /* renamed from: c, reason: collision with root package name */
    public vd.a f19050c;

    /* renamed from: d, reason: collision with root package name */
    public int f19051d;
    public rd.a e;

    /* renamed from: f, reason: collision with root package name */
    public BluetoothDevice f19052f;

    /* renamed from: g, reason: collision with root package name */
    public int f19053g;

    /* renamed from: h, reason: collision with root package name */
    public long f19054h;

    public final String toString() {
        return "DataInfo{type=" + this.f19048a + ", recvData=" + ee.b.c(this.f19049b) + ", basePacket=" + this.f19050c + ", timeoutMs=" + this.f19051d + ", callback=" + this.e + ", device=" + this.f19052f + ", reSendCount=" + this.f19053g + ", isSend=false, sendTime=" + this.f19054h + '}';
    }
}
