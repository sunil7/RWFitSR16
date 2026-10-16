package com.amap.api.trace;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TraceOverlay {
    public static final int TRACE_STATUS_FAILURE = 3;
    public static final int TRACE_STATUS_FINISH = 2;
    public static final int TRACE_STATUS_PREPARE = 4;
    public static final int TRACE_STATUS_PROCESSING = 1;

    /* renamed from: a, reason: collision with root package name */
    private Polyline f6563a;

    /* renamed from: b, reason: collision with root package name */
    private PolylineOptions f6564b;

    /* renamed from: c, reason: collision with root package name */
    private AMap f6565c;

    /* renamed from: d, reason: collision with root package name */
    private List<LatLng> f6566d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f6567f;

    /* renamed from: g, reason: collision with root package name */
    private int f6568g;

    public TraceOverlay(AMap aMap, List<LatLng> list) {
        this.f6566d = new ArrayList();
        this.e = 4;
        this.f6565c = aMap;
        a();
        this.f6566d = list;
        this.f6564b.addAll(list);
        this.f6563a = aMap.addPolyline(this.f6564b);
    }

    private PolylineOptions a() {
        if (this.f6564b == null) {
            PolylineOptions polylineOptions = new PolylineOptions();
            this.f6564b = polylineOptions;
            polylineOptions.setCustomTexture(BitmapDescriptorFactory.fromAsset("tracelinetexture.png"));
            this.f6564b.width(40.0f);
        }
        return this.f6564b;
    }

    public void add(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f6566d.addAll(list);
        a();
        if (this.f6563a == null) {
            this.f6563a = this.f6565c.addPolyline(this.f6564b);
        }
        Polyline polyline = this.f6563a;
        if (polyline != null) {
            polyline.setPoints(this.f6566d);
        }
    }

    public int getDistance() {
        return this.f6567f;
    }

    public int getTraceStatus() {
        return this.e;
    }

    public int getWaitTime() {
        return this.f6568g;
    }

    public void remove() {
        Polyline polyline = this.f6563a;
        if (polyline != null) {
            polyline.remove();
        }
    }

    public void setDistance(int i3) {
        this.f6567f = i3;
    }

    public void setProperCamera(List<LatLng> list) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<LatLng> it = list.iterator();
        while (it.hasNext()) {
            builder.include(it.next());
        }
        try {
            this.f6565c.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 20));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setTraceStatus(int i3) {
        this.e = i3;
    }

    public void setWaitTime(int i3) {
        this.f6568g = i3;
    }

    public void zoopToSpan() {
        setProperCamera(this.f6564b.getPoints());
    }

    public TraceOverlay(AMap aMap) {
        this.f6566d = new ArrayList();
        this.e = 4;
        this.f6565c = aMap;
        a();
    }
}
