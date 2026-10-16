package com.amap.api.col.p0003sl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class x6 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private static x6 f5344a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public AutoTChargeStationResult f5345a;

        /* renamed from: b, reason: collision with root package name */
        public AutoTSearch.OnChargeStationListener f5346b;
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public BusLineResult f5347a;

        /* renamed from: b, reason: collision with root package name */
        public BusLineSearch.OnBusLineSearchListener f5348b;
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public BusStationResult f5349a;

        /* renamed from: b, reason: collision with root package name */
        public BusStationSearch.OnBusStationSearchListener f5350b;
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public CloudItemDetail f5351a;

        /* renamed from: b, reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f5352b;
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public CloudResult f5353a;

        /* renamed from: b, reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f5354b;
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public GeocodeResult f5355a;

        /* renamed from: b, reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f5356b;
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public List<NearbySearch.NearbyListener> f5357a;

        /* renamed from: b, reason: collision with root package name */
        public NearbySearchResult f5358b;
    }

    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public PoiItem f5359a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f5360b;
    }

    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public PoiItemV2 f5361a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f5362b;
    }

    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public PoiResult f5363a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f5364b;
    }

    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public PoiResultV2 f5365a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f5366b;
    }

    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public RegeocodeResult f5367a;

        /* renamed from: b, reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f5368b;
    }

    public static class m {

        /* renamed from: a, reason: collision with root package name */
        public RoutePOISearchResult f5369a;

        /* renamed from: b, reason: collision with root package name */
        public RoutePOISearch.OnRoutePOISearchListener f5370b;
    }

    public static class n {

        /* renamed from: a, reason: collision with root package name */
        public LocalWeatherForecastResult f5371a;

        /* renamed from: b, reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f5372b;
    }

    public static class o {

        /* renamed from: a, reason: collision with root package name */
        public LocalWeatherLiveResult f5373a;

        /* renamed from: b, reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f5374b;
    }

    public x6() {
    }

    public static synchronized x6 a() {
        x6 x6Var;
        synchronized (x6.class) {
            try {
                if (f5344a == null) {
                    if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                        f5344a = new x6();
                    }
                    f5344a = new x6(Looper.getMainLooper());
                }
                x6Var = f5344a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return x6Var;
    }

    private void b(Message message) {
        i iVar;
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i3 = message.what;
        if (i3 == 603) {
            k kVar = (k) message.obj;
            if (kVar == null || (onPoiSearchListener = kVar.f5366b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(kVar.f5365a, data.getInt("errorCode"));
            return;
        }
        if (i3 != 604 || (iVar = (i) message.obj) == null) {
            return;
        }
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener2 = iVar.f5362b;
        Bundle data2 = message.getData();
        if (data2 != null) {
            onPoiSearchListener2.onPoiItemSearched(iVar.f5361a, data2.getInt("errorCode"));
        }
    }

    private void c(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i3 = message.what;
        if (i3 == 100) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i3 == 101) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i3 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i3 == 103) {
            Bundle data5 = message.getData();
            if (data5 != null) {
                onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data5.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i3 != 104 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private void d(Message message) {
        Bundle data;
        RouteSearchV2.OnRouteSearchListener onRouteSearchListener = (RouteSearchV2.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i3 = message.what;
        if (i3 == 101) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResultV2) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i3 == 100) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResultV2) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i3 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResultV2) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i3 != 103 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onRideRouteSearched((RideRouteResultV2) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private void e(Message message) {
        n nVar;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data2;
        int i3 = message.what;
        if (i3 == 1301) {
            o oVar = (o) message.obj;
            if (oVar == null || (onWeatherSearchListener2 = oVar.f5374b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onWeatherSearchListener2.onWeatherLiveSearched(oVar.f5373a, data2.getInt("errorCode"));
            return;
        }
        if (i3 != 1302 || (nVar = (n) message.obj) == null || (onWeatherSearchListener = nVar.f5372b) == null || (data = message.getData()) == null) {
            return;
        }
        onWeatherSearchListener.onWeatherForecastSearched(nVar.f5371a, data.getInt("errorCode"));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        f fVar;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        List<NearbySearch.NearbyListener> list;
        d dVar;
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data;
        Bundle data2;
        Bundle data3;
        Bundle data4;
        a aVar;
        try {
            int i3 = message.arg1;
            if (i3 == 101) {
                d(message);
                return;
            }
            switch (i3) {
                case 1:
                    c(message);
                    break;
                case 2:
                    int i10 = message.what;
                    if (i10 != 201) {
                        if (i10 == 200 && (fVar = (f) message.obj) != null && (onGeocodeSearchListener = fVar.f5356b) != null) {
                            onGeocodeSearchListener.onGeocodeSearched(fVar.f5355a, message.arg2);
                            break;
                        }
                    } else {
                        l lVar = (l) message.obj;
                        if (lVar != null && (onGeocodeSearchListener2 = lVar.f5368b) != null) {
                            onGeocodeSearchListener2.onRegeocodeSearched(lVar.f5367a, message.arg2);
                            break;
                        }
                    }
                    break;
                case 3:
                    b bVar = (b) message.obj;
                    if (bVar != null && (onBusLineSearchListener = bVar.f5348b) != null) {
                        int i11 = message.what;
                        onBusLineSearchListener.onBusLineSearched(i11 == 1000 ? bVar.f5347a : null, i11);
                        break;
                    }
                    break;
                case 4:
                    DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
                    if (onDistrictSearchListener != null) {
                        onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable("result"));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
                    if (inputtipsListener != null) {
                        inputtipsListener.onGetInputtips(message.what == 1000 ? message.getData().getParcelableArrayList("result") : null, message.what);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    a(message);
                    break;
                case 7:
                    c cVar = (c) message.obj;
                    if (cVar != null && (onBusStationSearchListener = cVar.f5350b) != null) {
                        int i12 = message.what;
                        onBusStationSearchListener.onBusStationSearched(i12 == 1000 ? cVar.f5349a : null, i12);
                        break;
                    }
                    break;
                case 8:
                    List list2 = (List) message.obj;
                    if (list2 != null && list2.size() != 0) {
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            ((NearbySearch.NearbyListener) it.next()).onUserInfoCleared(message.what);
                        }
                        break;
                    }
                    break;
                case 9:
                    g gVar = (g) message.obj;
                    if (gVar != null && (list = gVar.f5357a) != null && list.size() != 0) {
                        NearbySearchResult nearbySearchResult = message.what == 1000 ? gVar.f5358b : null;
                        Iterator<NearbySearch.NearbyListener> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onNearbyInfoSearched(nearbySearchResult, message.what);
                        }
                        break;
                    }
                    break;
                case 10:
                    List list3 = (List) message.obj;
                    if (list3 != null && list3.size() != 0) {
                        Iterator it3 = list3.iterator();
                        while (it3.hasNext()) {
                            ((NearbySearch.NearbyListener) it3.next()).onNearbyInfoUploaded(message.what);
                        }
                        break;
                    }
                    break;
                case 11:
                    int i13 = message.arg2;
                    ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
                    String string = message.getData().getString("shareurlkey");
                    if (onShareSearchListener != null) {
                        switch (message.what) {
                            case 1100:
                                onShareSearchListener.onPoiShareUrlSearched(string, i13);
                                break;
                            case AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR /* 1101 */:
                                onShareSearchListener.onLocationShareUrlSearched(string, i13);
                                break;
                            case AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT /* 1102 */:
                                onShareSearchListener.onNaviShareUrlSearched(string, i13);
                                break;
                            case AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT /* 1103 */:
                                onShareSearchListener.onBusRouteShareUrlSearched(string, i13);
                                break;
                            case 1104:
                                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i13);
                                break;
                            case 1105:
                                onShareSearchListener.onWalkRouteShareUrlSearched(string, i13);
                                break;
                        }
                    } else {
                        break;
                    }
                case 12:
                    int i14 = message.what;
                    if (i14 != 700) {
                        if (i14 == 701 && (dVar = (d) message.obj) != null) {
                            dVar.f5352b.onCloudItemDetailSearched(dVar.f5351a, message.arg2);
                            break;
                        }
                    } else {
                        e eVar = (e) message.obj;
                        if (eVar != null) {
                            eVar.f5354b.onCloudSearched(eVar.f5353a, message.arg2);
                            break;
                        } else {
                            break;
                        }
                    }
                    break;
                case 13:
                    e(message);
                    break;
                case 14:
                    m mVar = (m) message.obj;
                    if (mVar != null && (onRoutePOISearchListener = mVar.f5370b) != null && (data = message.getData()) != null) {
                        onRoutePOISearchListener.onRoutePoiSearched(mVar.f5369a, data.getInt("errorCode"));
                        break;
                    }
                    break;
                default:
                    switch (i3) {
                        case 16:
                            DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (DistanceSearch.OnDistanceSearchListener) message.obj;
                            if (onDistanceSearchListener != null && message.what == 400 && (data2 = message.getData()) != null) {
                                onDistanceSearchListener.onDistanceSearched((DistanceResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                                break;
                            }
                            break;
                        case 17:
                            RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (RouteSearch.OnTruckRouteSearchListener) message.obj;
                            if (onTruckRouteSearchListener != null && message.what == 104 && (data3 = message.getData()) != null) {
                                onTruckRouteSearchListener.onTruckRouteSearched((TruckRouteRestult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                                break;
                            }
                            break;
                        case 18:
                            RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = (RouteSearch.OnRoutePlanSearchListener) message.obj;
                            if (onRoutePlanSearchListener != null && message.what == 105 && (data4 = message.getData()) != null) {
                                onRoutePlanSearchListener.onDriveRoutePlanSearched((DriveRoutePlanResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                                break;
                            }
                            break;
                        case 19:
                            b(message);
                            break;
                        case 20:
                            if (message.what == 600 && (aVar = (a) message.obj) != null) {
                                AutoTSearch.OnChargeStationListener onChargeStationListener = aVar.f5346b;
                                Bundle data5 = message.getData();
                                if (data5 != null) {
                                    int i15 = data5.getInt("errorCode");
                                    if (onChargeStationListener != null) {
                                        onChargeStationListener.onChargeStationSearched(aVar.f5345a, i15);
                                        break;
                                    }
                                }
                            }
                            break;
                    }
            }
        } catch (Throwable th2) {
            d6.a(th2, "MessageHandler", "handleMessage");
        }
    }

    public x6(Looper looper) {
        super(looper);
    }

    private void a(Message message) {
        h hVar;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i3 = message.what;
        if (i3 == 600) {
            j jVar = (j) message.obj;
            if (jVar == null || (onPoiSearchListener = jVar.f5364b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(jVar.f5363a, data.getInt("errorCode"));
            return;
        }
        if (i3 != 602 || (hVar = (h) message.obj) == null) {
            return;
        }
        PoiSearch.OnPoiSearchListener onPoiSearchListener2 = hVar.f5360b;
        Bundle data2 = message.getData();
        if (data2 != null) {
            onPoiSearchListener2.onPoiItemSearched(hVar.f5359a, data2.getInt("errorCode"));
        }
    }
}
