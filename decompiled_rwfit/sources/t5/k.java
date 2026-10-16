package t5;

import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.ble.scan.ScanSettings;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public int f18556a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f18557b = 1;

    /* renamed from: c, reason: collision with root package name */
    public long f18558c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f18559d = 1;
    public int e = 3;

    /* renamed from: f, reason: collision with root package name */
    public boolean f18560f = true;

    /* renamed from: g, reason: collision with root package name */
    public int f18561g = 255;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18562h = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18563i = true;

    /* renamed from: j, reason: collision with root package name */
    public boolean f18564j = true;

    /* renamed from: k, reason: collision with root package name */
    public long f18565k = 10000;

    /* renamed from: l, reason: collision with root package name */
    public long f18566l = 10000;

    /* renamed from: m, reason: collision with root package name */
    public long f18567m = 0;

    /* renamed from: n, reason: collision with root package name */
    public long f18568n = 0;

    public final ScanSettings a() {
        if (this.f18567m == 0 && this.f18568n == 0) {
            int i3 = this.f18556a;
            if (i3 == 1) {
                this.f18568n = 2000L;
                this.f18567m = Const.L_MAX_WAIT_WIFI;
            } else if (i3 != 2) {
                this.f18568n = 500L;
                this.f18567m = 4500L;
            } else {
                this.f18568n = 0L;
                this.f18567m = 0L;
            }
        }
        return new ScanSettings(this.f18556a, this.f18557b, this.f18558c, this.f18559d, this.e, this.f18560f, this.f18561g, this.f18562h, this.f18563i, this.f18564j, this.f18565k, this.f18566l, this.f18568n, this.f18567m);
    }

    public final void b(int i3) {
        if (i3 < 1 || i3 > 2) {
            throw new IllegalArgumentException(l0.j(i3, "invalid matchMode "));
        }
        this.f18559d = i3;
    }

    public final void c(int i3) {
        if (i3 < -1 || i3 > 2) {
            throw new IllegalArgumentException(l0.j(i3, "invalid scan mode "));
        }
        this.f18556a = i3;
    }
}
