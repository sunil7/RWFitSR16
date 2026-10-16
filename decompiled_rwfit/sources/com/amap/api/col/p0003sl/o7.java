package com.amap.api.col.p0003sl;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class o7 {
    private static volatile o7 r;

    /* renamed from: a, reason: collision with root package name */
    boolean f4745a = true;

    /* renamed from: b, reason: collision with root package name */
    boolean f4746b = true;

    /* renamed from: c, reason: collision with root package name */
    boolean f4747c = true;

    /* renamed from: d, reason: collision with root package name */
    boolean f4748d = true;
    boolean e = true;

    /* renamed from: f, reason: collision with root package name */
    boolean f4749f = true;

    /* renamed from: g, reason: collision with root package name */
    boolean f4750g = true;

    /* renamed from: h, reason: collision with root package name */
    int f4751h = 25;

    /* renamed from: i, reason: collision with root package name */
    int f4752i = 100;

    /* renamed from: j, reason: collision with root package name */
    int f4753j = 100;

    /* renamed from: k, reason: collision with root package name */
    int f4754k = 100;

    /* renamed from: l, reason: collision with root package name */
    int f4755l = 6;

    /* renamed from: m, reason: collision with root package name */
    int f4756m = 100;

    /* renamed from: n, reason: collision with root package name */
    int f4757n = 5000;

    /* renamed from: o, reason: collision with root package name */
    int f4758o = AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;

    /* renamed from: p, reason: collision with root package name */
    int f4759p = 100000000;

    /* renamed from: q, reason: collision with root package name */
    int f4760q = 16;

    public static o7 a() {
        if (r == null) {
            synchronized (o7.class) {
                try {
                    if (r == null) {
                        r = new o7();
                    }
                } finally {
                }
            }
        }
        return r;
    }

    public int b(int i3) {
        int i10;
        return (this.f4748d && (i10 = this.f4751h) < i3) ? i10 : i3;
    }

    public void b(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f4749f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f4754k < d6.a(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public void a(RouteSearch.FromAndTo fromAndTo, List<LatLonPoint> list) throws AMapException {
        double a3;
        if (!this.f4747c || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (list != null && list.size() != 0) {
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            Iterator<LatLonPoint> it = list.iterator();
            double d5 = 0.0d;
            while (it.hasNext()) {
                d5 += d6.a(from, r3);
                from = it.next();
            }
            a3 = d5 + d6.a(from, to);
        } else {
            a3 = d6.a(fromAndTo.getFrom(), fromAndTo.getTo());
        }
        if (this.f4757n < a3 / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public void b(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f4749f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f4754k < d6.a(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public void b(List<LatLonPoint> list) throws AMapException {
        if (this.f4750g && list != null) {
            if (this.f4755l < list.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
            }
        }
    }

    public int a(int i3) {
        int i10;
        return (this.f4748d && (i10 = this.f4756m) < i3) ? i10 : i3;
    }

    public void a(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f4758o < d6.a(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public void a(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f4758o < d6.a(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public void a(List<List<LatLonPoint>> list) throws AMapException {
        if (this.f4745a && list != null) {
            if (this.f4753j >= list.size()) {
                for (List<LatLonPoint> list2 : list) {
                    double d5 = 0.0d;
                    if (list2 != null && list2.size() >= 3) {
                        int size = list2.size();
                        int i3 = 0;
                        while (i3 < size) {
                            LatLonPoint latLonPoint = list2.get(i3);
                            i3++;
                            LatLonPoint latLonPoint2 = list2.get(i3 % size);
                            d5 += ((latLonPoint2.getLatitude() * 111319.49079327357d) * (Math.cos(latLonPoint.getLatitude() * 0.017453292519943295d) * (latLonPoint.getLongitude() * 111319.49079327357d))) - ((Math.cos(latLonPoint2.getLatitude() * 0.017453292519943295d) * (latLonPoint2.getLongitude() * 111319.49079327357d)) * (latLonPoint.getLatitude() * 111319.49079327357d));
                        }
                        d5 = Math.abs(d5 / 2.0d);
                    }
                    if (this.f4760q < list2.size()) {
                        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION);
                    }
                    if (this.f4759p < d5) {
                        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION);
                    }
                }
                return;
            }
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION);
        }
    }

    public void a(String str) throws AMapException {
        if (str != null && this.f4746b && str.length() > this.f4752i) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION);
        }
    }
}
