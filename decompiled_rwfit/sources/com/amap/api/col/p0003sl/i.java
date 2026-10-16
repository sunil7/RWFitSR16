package com.amap.api.col.p0003sl;

import android.location.GnssStatus;
import com.autonavi.aps.amapapi.utils.DebugUtils;

/* loaded from: classes.dex */
class i extends GnssStatus.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f4278a;

    public i(k kVar) {
        this.f4278a = kVar;
    }

    @Override // android.location.GnssStatus.Callback
    public void onFirstFix(int i3) {
        this.f4278a.getClass();
        DebugUtils.writeCat("GpsLocation | first fix ");
    }

    @Override // android.location.GnssStatus.Callback
    public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        k.a(this.f4278a, gnssStatus);
    }

    @Override // android.location.GnssStatus.Callback
    public void onStarted() {
        this.f4278a.getClass();
        DebugUtils.writeCat("GpsLocation | status stopped ");
    }

    @Override // android.location.GnssStatus.Callback
    public void onStopped() {
        k.a(this.f4278a);
    }
}
