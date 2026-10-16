package com.amap.api.col.p0003sl;

import android.location.Location;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: classes.dex */
class m0 implements LocationSource.OnLocationChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f4526a;

    /* renamed from: b, reason: collision with root package name */
    Location f4527b;

    public m0(IAMapDelegate iAMapDelegate) {
        this.f4526a = iAMapDelegate;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public void onLocationChanged(Location location) {
        this.f4527b = location;
        try {
            if (this.f4526a.isMyLocationEnabled()) {
                this.f4526a.showMyLocationOverlay(location);
            }
        } catch (Throwable th2) {
            ka.a(th2, "AMapOnLocationChangedListener", "onLocationChanged");
            th2.printStackTrace();
        }
    }
}
