package com.amap.api.col.p0003sl;

import android.location.GpsStatus;
import android.location.LocationManager;
import android.support.v4.media.session.e;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;

/* loaded from: classes.dex */
class j implements GpsStatus.Listener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f4309a;

    public j(k kVar) {
        this.f4309a = kVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i3) {
        GpsStatus gpsStatus;
        try {
            k kVar = this.f4309a;
            LocationManager locationManager = kVar.f4341d;
            if (locationManager == null) {
                return;
            }
            gpsStatus = kVar.f4354s;
            kVar.f4354s = locationManager.getGpsStatus(gpsStatus);
            if (i3 == 1) {
                this.f4309a.getClass();
                DebugUtils.writeCat("GpsLocation | status stopped ");
            } else {
                if (i3 == 2) {
                    k.a(this.f4309a);
                    return;
                }
                if (i3 == 3) {
                    this.f4309a.getClass();
                    DebugUtils.writeCat("GpsLocation | first fix ");
                } else {
                    if (i3 != 4) {
                        return;
                    }
                    k.c(this.f4309a);
                }
            }
        } catch (Throwable th2) {
            DebugUtils.writeCat(e.p(th2, new StringBuilder("GpsLocation | onGpsStatusChanged error: ")));
            CoreUtil.reportError(th2, "GpsLocation", "onGpsStatusChanged");
        }
    }
}
