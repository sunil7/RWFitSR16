package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class x extends a2.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f573c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c0 f574d;
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(c0 c0Var, de.o oVar) {
        super(c0Var);
        this.f574d = c0Var;
        this.e = oVar;
    }

    @Override // a2.h
    public final void A() {
        switch (this.f573c) {
            case 0:
                this.f574d.n(true, true);
                break;
            default:
                this.f574d.n(true, true);
                break;
        }
    }

    @Override // a2.h
    public final IntentFilter w() {
        switch (this.f573c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // a2.h
    public final int x() {
        Location location;
        boolean z5;
        long j4;
        Location location2;
        switch (this.f573c) {
            case 0:
                return ((PowerManager) this.e).isPowerSaveMode() ? 2 : 1;
            default:
                de.o oVar = (de.o) this.e;
                m0 m0Var = (m0) oVar.f12379d;
                if (m0Var.f523b > System.currentTimeMillis()) {
                    z5 = m0Var.f522a;
                } else {
                    Context context = (Context) oVar.f12377b;
                    int b3 = a1.g.b(context, "android.permission.ACCESS_COARSE_LOCATION");
                    Location location3 = null;
                    LocationManager locationManager = (LocationManager) oVar.f12378c;
                    if (b3 == 0) {
                        try {
                        } catch (Exception e) {
                            Log.d("TwilightManager", "Failed to get last known location", e);
                        }
                        if (locationManager.isProviderEnabled(Const.PROVIDER_NETWORK)) {
                            location2 = locationManager.getLastKnownLocation(Const.PROVIDER_NETWORK);
                            location = location2;
                        }
                        location2 = null;
                        location = location2;
                    } else {
                        location = null;
                    }
                    if (a1.g.b(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                location3 = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e10) {
                            Log.d("TwilightManager", "Failed to get last known location", e10);
                        }
                    }
                    if (location3 == null || location == null ? location3 != null : location3.getTime() > location.getTime()) {
                        location = location3;
                    }
                    if (location != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (l0.f518d == null) {
                            l0.f518d = new l0();
                        }
                        l0 l0Var = l0.f518d;
                        l0Var.a(currentTimeMillis - Const.DAY_IN_MILLIS, location.getLatitude(), location.getLongitude());
                        l0Var.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
                        z5 = l0Var.f521c == 1;
                        long j10 = l0Var.f520b;
                        long j11 = l0Var.f519a;
                        l0Var.a(Const.DAY_IN_MILLIS + currentTimeMillis, location.getLatitude(), location.getLongitude());
                        long j12 = l0Var.f520b;
                        if (j10 == -1 || j11 == -1) {
                            j4 = currentTimeMillis + 43200000;
                        } else {
                            if (currentTimeMillis <= j11) {
                                j12 = currentTimeMillis > j10 ? j11 : j10;
                            }
                            j4 = j12 + 60000;
                        }
                        m0Var.f522a = z5;
                        m0Var.f523b = j4;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i3 = Calendar.getInstance().get(11);
                        if (i3 < 6 || i3 >= 22) {
                            z5 = true;
                        }
                    }
                }
                return z5 ? 2 : 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(c0 c0Var, Context context) {
        super(c0Var);
        this.f574d = c0Var;
        this.e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
