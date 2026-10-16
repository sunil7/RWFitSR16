package com.example.test.ui.sport.activity;

import android.location.Location;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.LatLng;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements AMap.OnMyLocationChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8168a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XXBaseActivity f8169b;

    public /* synthetic */ f(XXBaseActivity xXBaseActivity, int i3) {
        this.f8168a = i3;
        this.f8169b = xXBaseActivity;
    }

    @Override // com.amap.api.maps.AMap.OnMyLocationChangeListener
    public final void onMyLocationChange(Location location) {
        XXBaseActivity xXBaseActivity = this.f8169b;
        switch (this.f8168a) {
            case 0:
                int i3 = SportMapActivity.H;
                SportMapActivity this$0 = (SportMapActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (this$0.F) {
                    this$0.R0().animateCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
                    break;
                }
                break;
            default:
                int i10 = SportNewMapActivity.H;
                SportNewMapActivity this$02 = (SportNewMapActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                if (this$02.F) {
                    this$02.R0().animateCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
                    break;
                }
                break;
        }
    }
}
