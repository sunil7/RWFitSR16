package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.maps.offlinemap.OfflineMapStatus;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import java.util.List;

/* loaded from: classes.dex */
public class o8 implements IRouteSearch {

    /* renamed from: a, reason: collision with root package name */
    private RouteSearch.OnRouteSearchListener f4761a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearch.OnTruckRouteSearchListener f4762b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearch.OnRoutePlanSearchListener f4763c;

    /* renamed from: d, reason: collision with root package name */
    private Context f4764d;
    private Handler e;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.WalkRouteQuery f4765a;

        public a(RouteSearch.WalkRouteQuery walkRouteQuery) {
            this.f4765a = walkRouteQuery;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v5, types: [android.os.Handler] */
        @Override // java.lang.Runnable
        public void run() {
            String str = "result";
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            WalkRouteResult walkRouteResult = null;
            try {
                try {
                    walkRouteResult = o8.this.calculateWalkRoute(this.f4765a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = o8.this.f4761a;
                bundle.putParcelable(str, walkRouteResult);
                obtainMessage.setData(bundle);
                o8.this.e.sendMessage(obtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.BusRouteQuery f4767a;

        public b(RouteSearch.BusRouteQuery busRouteQuery) {
            this.f4767a = busRouteQuery;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v5, types: [android.os.Handler] */
        @Override // java.lang.Runnable
        public void run() {
            String str = "result";
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            BusRouteResult busRouteResult = null;
            try {
                try {
                    busRouteResult = o8.this.calculateBusRoute(this.f4767a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = o8.this.f4761a;
                bundle.putParcelable(str, busRouteResult);
                obtainMessage.setData(bundle);
                o8.this.e.sendMessage(obtainMessage);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.DriveRouteQuery f4769a;

        public c(RouteSearch.DriveRouteQuery driveRouteQuery) {
            this.f4769a = driveRouteQuery;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v5, types: [android.os.Handler] */
        @Override // java.lang.Runnable
        public void run() {
            String str = "result";
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = 101;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            DriveRouteResult driveRouteResult = null;
            try {
                try {
                    driveRouteResult = o8.this.calculateDriveRoute(this.f4769a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = o8.this.f4761a;
                bundle.putParcelable(str, driveRouteResult);
                obtainMessage.setData(bundle);
                o8.this.e.sendMessage(obtainMessage);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.RideRouteQuery f4771a;

        public d(RouteSearch.RideRouteQuery rideRouteQuery) {
            this.f4771a = rideRouteQuery;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v5, types: [android.os.Handler] */
        @Override // java.lang.Runnable
        public void run() {
            String str = "result";
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = OfflineMapStatus.EXCEPTION_SDCARD;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            RideRouteResult rideRouteResult = null;
            try {
                try {
                    rideRouteResult = o8.this.calculateRideRoute(this.f4771a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = o8.this.f4761a;
                bundle.putParcelable(str, rideRouteResult);
                obtainMessage.setData(bundle);
                o8.this.e.sendMessage(obtainMessage);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.TruckRouteQuery f4773a;

        public e(RouteSearch.TruckRouteQuery truckRouteQuery) {
            this.f4773a = truckRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = 104;
            obtainMessage.arg1 = 17;
            Bundle bundle = new Bundle();
            TruckRouteRestult truckRouteRestult = null;
            try {
                try {
                    truckRouteRestult = o8.this.calculateTruckRoute(this.f4773a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = o8.this.f4762b;
                bundle.putParcelable("result", truckRouteRestult);
                obtainMessage.setData(bundle);
                o8.this.e.sendMessage(obtainMessage);
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.DrivePlanQuery f4775a;

        public f(RouteSearch.DrivePlanQuery drivePlanQuery) {
            this.f4775a = drivePlanQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = 105;
            obtainMessage.arg1 = 18;
            Bundle bundle = new Bundle();
            DriveRoutePlanResult driveRoutePlanResult = null;
            try {
                try {
                    driveRoutePlanResult = o8.this.calculateDrivePlan(this.f4775a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = o8.this.f4763c;
                bundle.putParcelable("result", driveRoutePlanResult);
                obtainMessage.setData(bundle);
                o8.this.e.sendMessage(obtainMessage);
            }
        }
    }

    public o8(Context context) throws AMapException {
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4764d = context.getApplicationContext();
        this.e = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            v6.a(this.f4764d);
            if (busRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a(busRouteQuery.getFromAndTo())) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            RouteSearch.BusRouteQuery m28clone = busRouteQuery.m28clone();
            BusRouteResult c9 = new g6(this.f4764d, m28clone).c();
            if (c9 == null) {
                return c9;
            }
            c9.setBusQuery(m28clone);
            return c9;
        } catch (AMapException e10) {
            d6.a(e10, "RouteSearch", "calculateBusRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateBusRouteAsyn(RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            u7.b().a(new b(busRouteQuery));
        } catch (Throwable th2) {
            d6.a(th2, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            v6.a(this.f4764d);
            if (drivePlanQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a(drivePlanQuery.getFromAndTo())) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            DriveRoutePlanResult c9 = new p6(this.f4764d, drivePlanQuery.m29clone()).c();
            if (c9 == null) {
                return c9;
            }
            c9.setDrivePlanQuery(drivePlanQuery);
            return c9;
        } catch (AMapException e10) {
            d6.a(e10, "RouteSearch", "calculateDrivePlan");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateDrivePlanAsyn(RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            u7.b().a(new f(drivePlanQuery));
        } catch (Throwable th2) {
            d6.a(th2, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            v6.a(this.f4764d);
            if (driveRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a(driveRouteQuery.getFromAndTo())) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            o7.a().b(driveRouteQuery.getPassedByPoints());
            o7.a().a(driveRouteQuery.getAvoidpolygons());
            RouteSearch.DriveRouteQuery m30clone = driveRouteQuery.m30clone();
            DriveRouteResult c9 = new q6(this.f4764d, m30clone).c();
            if (c9 == null) {
                return c9;
            }
            c9.setDriveQuery(m30clone);
            return c9;
        } catch (AMapException e10) {
            d6.a(e10, "RouteSearch", "calculateDriveRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateDriveRouteAsyn(RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            u7.b().a(new c(driveRouteQuery));
        } catch (Throwable th2) {
            d6.a(th2, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            v6.a(this.f4764d);
            if (rideRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a(rideRouteQuery.getFromAndTo())) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            o7.a().a(rideRouteQuery.getFromAndTo());
            RouteSearch.RideRouteQuery m32clone = rideRouteQuery.m32clone();
            RideRouteResult c9 = new q7(this.f4764d, m32clone).c();
            if (c9 == null) {
                return c9;
            }
            c9.setRideQuery(m32clone);
            return c9;
        } catch (AMapException e10) {
            d6.a(e10, "RouteSearch", "calculaterideRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateRideRouteAsyn(RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            u7.b().a(new d(rideRouteQuery));
        } catch (Throwable th2) {
            d6.a(th2, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            v6.a(this.f4764d);
            if (truckRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a(truckRouteQuery.getFromAndTo())) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            o7.a().a(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
            o7 a3 = o7.a();
            List<LatLonPoint> passedByPoints = truckRouteQuery.getPassedByPoints();
            a3.getClass();
            if (passedByPoints != null && 16 < passedByPoints.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
            }
            RouteSearch.TruckRouteQuery m33clone = truckRouteQuery.m33clone();
            TruckRouteRestult c9 = new v7(this.f4764d, m33clone).c();
            if (c9 == null) {
                return c9;
            }
            c9.setTruckQuery(m33clone);
            return c9;
        } catch (AMapException e10) {
            d6.a(e10, "RouteSearch", "calculateDriveRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateTruckRouteAsyn(RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            u7.b().a(new e(truckRouteQuery));
        } catch (Throwable th2) {
            d6.a(th2, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            v6.a(this.f4764d);
            if (walkRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a(walkRouteQuery.getFromAndTo())) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            o7.a().b(walkRouteQuery.getFromAndTo());
            RouteSearch.WalkRouteQuery m34clone = walkRouteQuery.m34clone();
            WalkRouteResult c9 = new w7(this.f4764d, m34clone).c();
            if (c9 == null) {
                return c9;
            }
            c9.setWalkQuery(m34clone);
            return c9;
        } catch (AMapException e10) {
            d6.a(e10, "RouteSearch", "calculateWalkRoute");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateWalkRouteAsyn(RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            u7.b().a(new a(walkRouteQuery));
        } catch (Throwable th2) {
            d6.a(th2, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.f4763c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.f4762b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.f4761a = onRouteSearchListener;
    }

    private boolean a(RouteSearch.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }
}
