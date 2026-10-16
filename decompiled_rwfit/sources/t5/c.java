package t5;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import b1.m;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends ScanCallback {

    /* renamed from: a, reason: collision with root package name */
    public long f18539a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f18540b;

    public c(d dVar) {
        this.f18540b = dVar;
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onBatchScanResults(List list) {
        this.f18540b.f18533i.post(new n5.a(9, this, list));
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int i3) {
        this.f18540b.f18533i.post(new m(i3, 4, this));
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int i3, ScanResult scanResult) {
        this.f18540b.f18533i.post(new androidx.camera.camera2.internal.compat.e(this, scanResult, i3, 5));
    }
}
