package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.maps.offlinemap.OfflineMapStatus;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;
import java.util.List;

/* loaded from: classes.dex */
public class p8 implements IRouteSearchV2 {

    /* renamed from: a, reason: collision with root package name */
    private RouteSearchV2.OnRouteSearchListener f4813a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4814b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f4815c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.DriveRouteQuery f4816a;

        public a(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
            this.f4816a = driveRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = 101;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            DriveRouteResultV2 driveRouteResultV2 = null;
            try {
                try {
                    driveRouteResultV2 = p8.this.calculateDriveRoute(this.f4816a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = p8.this.f4813a;
                bundle.putParcelable("result", driveRouteResultV2);
                obtainMessage.setData(bundle);
                p8.this.f4815c.sendMessage(obtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.WalkRouteQuery f4818a;

        public b(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
            this.f4818a = walkRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            WalkRouteResultV2 walkRouteResultV2 = null;
            try {
                try {
                    walkRouteResultV2 = p8.this.calculateWalkRoute(this.f4818a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = p8.this.f4813a;
                bundle.putParcelable("result", walkRouteResultV2);
                obtainMessage.setData(bundle);
                p8.this.f4815c.sendMessage(obtainMessage);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.RideRouteQuery f4820a;

        public c(RouteSearchV2.RideRouteQuery rideRouteQuery) {
            this.f4820a = rideRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = OfflineMapStatus.EXCEPTION_SDCARD;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            RideRouteResultV2 rideRouteResultV2 = null;
            try {
                try {
                    rideRouteResultV2 = p8.this.calculateRideRoute(this.f4820a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = p8.this.f4813a;
                bundle.putParcelable("result", rideRouteResultV2);
                obtainMessage.setData(bundle);
                p8.this.f4815c.sendMessage(obtainMessage);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.BusRouteQuery f4822a;

        public d(RouteSearchV2.BusRouteQuery busRouteQuery) {
            this.f4822a = busRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            BusRouteResultV2 busRouteResultV2 = null;
            try {
                try {
                    busRouteResultV2 = p8.this.calculateBusRoute(this.f4822a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = p8.this.f4813a;
                bundle.putParcelable("result", busRouteResultV2);
                obtainMessage.setData(bundle);
                p8.this.f4815c.sendMessage(obtainMessage);
            }
        }
    }

    public p8(Context context) throws AMapException {
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4814b = context.getApplicationContext();
        this.f4815c = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public BusRouteResultV2 calculateBusRoute(RouteSearchV2.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            v6.a(this.f4814b);
            if (busRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a(busRouteQuery.getFromAndTo())) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            RouteSearchV2.BusRouteQuery m35clone = busRouteQuery.m35clone();
            BusRouteResultV2 c9 = new h6(this.f4814b, m35clone).c();
            if (c9 == null) {
                return c9;
            }
            c9.setBusQuery(m35clone);
            return c9;
        } catch (AMapException e) {
            d6.a(e, "RouteSearch", "calculateBusRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public void calculateBusRouteAsyn(RouteSearchV2.BusRouteQuery busRouteQuery) {
        try {
            u7.b().a(new d(busRouteQuery));
        } catch (Throwable th2) {
            d6.a(th2, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            v6.a(this.f4814b);
            if (driveRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a(driveRouteQuery.getFromAndTo())) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            o7 a3 = o7.a();
            List<LatLonPoint> passedByPoints = driveRouteQuery.getPassedByPoints();
            a3.getClass();
            if (passedByPoints != null && 16 < passedByPoints.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
            }
            o7.a().a(driveRouteQuery.getAvoidpolygons());
            RouteSearchV2.DriveRouteQuery m36clone = driveRouteQuery.m36clone();
            DriveRouteResultV2 c9 = new r6(this.f4814b, m36clone).c();
            if (c9 == null) {
                return c9;
            }
            c9.setDriveQuery(m36clone);
            return c9;
        } catch (AMapException e) {
            d6.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public void calculateDriveRouteAsyn(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        try {
            u7.b().a(new a(driveRouteQuery));
        } catch (Throwable th2) {
            d6.a(th2, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public RideRouteResultV2 calculateRideRoute(RouteSearchV2.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            v6.a(this.f4814b);
            if (rideRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a(rideRouteQuery.getFromAndTo())) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            o7.a().a(rideRouteQuery.getFromAndTo());
            RouteSearchV2.RideRouteQuery m38clone = rideRouteQuery.m38clone();
            RideRouteResultV2 c9 = new r7(this.f4814b, m38clone).c();
            if (c9 == null) {
                return c9;
            }
            c9.setRideQuery(m38clone);
            return c9;
        } catch (AMapException e) {
            d6.a(e, "RouteSearch", "calculaterideRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public void calculateRideRouteAsyn(RouteSearchV2.RideRouteQuery rideRouteQuery) {
        try {
            u7.b().a(new c(rideRouteQuery));
        } catch (Throwable th2) {
            d6.a(th2, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public WalkRouteResultV2 calculateWalkRoute(RouteSearchV2.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            v6.a(this.f4814b);
            if (walkRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a(walkRouteQuery.getFromAndTo())) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            o7.a().b(walkRouteQuery.getFromAndTo());
            RouteSearchV2.WalkRouteQuery m39clone = walkRouteQuery.m39clone();
            WalkRouteResultV2 c9 = new x7(this.f4814b, m39clone).c();
            if (c9 == null) {
                return c9;
            }
            c9.setWalkQuery(m39clone);
            return c9;
        } catch (AMapException e) {
            d6.a(e, "RouteSearch", "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public void calculateWalkRouteAsyn(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        try {
            u7.b().a(new b(walkRouteQuery));
        } catch (Throwable th2) {
            d6.a(th2, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener) {
        this.f4813a = onRouteSearchListener;
    }

    private boolean a(RouteSearchV2.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }
}
