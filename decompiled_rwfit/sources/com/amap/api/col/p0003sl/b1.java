package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.maps.interfaces.INativeOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class b1 extends FrameLayout implements INativeOverlayLayer {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f3771a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, c1> f3772b;

    public class a implements Comparator<BaseOverlay> {
        public a(b1 b1Var) {
        }

        @Override // java.util.Comparator
        public int compare(BaseOverlay baseOverlay, BaseOverlay baseOverlay2) {
            BaseOverlay baseOverlay3 = baseOverlay;
            BaseOverlay baseOverlay4 = baseOverlay2;
            if ((baseOverlay3 instanceof Marker) && (baseOverlay4 instanceof Marker)) {
                return Float.compare(((Marker) baseOverlay3).getZIndex(), ((Marker) baseOverlay4).getZIndex());
            }
            return 0;
        }
    }

    public b1(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f3772b = new ConcurrentHashMap<>();
        this.f3771a = iAMapDelegate;
    }

    private boolean a(c1 c1Var) {
        View d5 = c1Var.d();
        if (d5.getVisibility() == 8) {
            return false;
        }
        Rect rect = new Rect();
        d5.getHitRect(rect);
        return rect.top <= this.f3771a.getMapHeight() && rect.bottom >= 0 && rect.left <= this.f3771a.getMapWidth() && rect.right >= 0;
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void addNativeOverlay(Marker marker, MarkerOptions markerOptions) {
        this.f3772b.put(marker.getId(), new c1(marker));
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public boolean checkInBounds(String str) {
        c1 c1Var = this.f3772b.get(str);
        if (c1Var == null) {
            return false;
        }
        return a(c1Var);
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void clear() {
        View d5;
        Iterator<Map.Entry<String, c1>> it = this.f3772b.entrySet().iterator();
        while (it.hasNext()) {
            c1 value = it.next().getValue();
            if (value != null && (d5 = value.d()) != null) {
                removeView(d5);
            }
        }
        this.f3772b.clear();
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public BaseOverlay getHitOverlay(DPoint dPoint, int i3) {
        BaseOverlay c9;
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, c1>> it = this.f3772b.entrySet().iterator();
        while (it.hasNext()) {
            c1 value = it.next().getValue();
            if (value != null && value.a(dPoint) && (c9 = value.c()) != null && (c9 instanceof Marker) && ((Marker) c9).getId().contains("MARKER")) {
                arrayList.add(c9);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Collections.sort(arrayList, new a(this));
        return (BaseOverlay) arrayList.get(arrayList.size() - 1);
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public List<Marker> getMapScreenMarkers() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, c1> entry : this.f3772b.entrySet()) {
            c1 value = entry.getValue();
            String key = entry.getKey();
            if (value != null && key.contains("MARKER") && a(value)) {
                BaseOverlay c9 = value.c();
                if (c9 instanceof Marker) {
                    arrayList.add((Marker) c9);
                }
            }
        }
        return arrayList;
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void getMarkerInfoWindowOffset(String str, FPoint fPoint) {
        Marker marker;
        MarkerOptions options;
        c1 c1Var = this.f3772b.get(str);
        if (c1Var == null || (marker = (Marker) c1Var.c()) == null || (options = marker.getOptions()) == null) {
            return;
        }
        ((PointF) fPoint).x = (marker.getOptions().getAnchorU() * c1Var.e()) + options.getInfoWindowOffsetX();
        ((PointF) fPoint).y = options.getInfoWindowOffsetY();
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public Rect getOverlayBoundRect(String str) {
        View d5;
        Rect rect = new Rect();
        c1 c1Var = this.f3772b.get(str);
        if (c1Var != null && (d5 = c1Var.d()) != null) {
            d5.getHitRect(rect);
        }
        return rect;
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void getOverlayScreenPos(String str, FPoint fPoint) {
        if (this.f3772b.get(str) == null) {
            return;
        }
        ((PointF) fPoint).x = r2.a();
        ((PointF) fPoint).y = r2.b();
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void hideInfoWindow(String str) {
        c1 c1Var = this.f3772b.get(str);
        if (c1Var == null) {
            return;
        }
        c1Var.b(false);
        try {
            this.f3771a.hideInfoWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public boolean isInfoWindowShown(String str) {
        c1 c1Var = this.f3772b.get(str);
        if (c1Var == null || ((Marker) c1Var.c()) == null) {
            return false;
        }
        return c1Var.g();
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void redrawOverlays() {
        LatLng position;
        Iterator<Map.Entry<String, c1>> it = this.f3772b.entrySet().iterator();
        while (it.hasNext()) {
            c1 value = it.next().getValue();
            if (value != null) {
                IPoint obtain = IPoint.obtain();
                Marker marker = (Marker) value.c();
                MarkerOptions.MarkerUpdateFlags updateFlags = marker.getOptions().getUpdateFlags();
                if ((updateFlags.latlngUpdate || updateFlags.anchorUpdate) && (position = marker.getPosition()) != null) {
                    this.f3771a.getLatLng2Pixel(position.latitude, position.longitude, obtain);
                }
                if (value.f()) {
                    value.i();
                    value.a(((Point) obtain).x, ((Point) obtain).y);
                } else {
                    int i3 = ((Point) obtain).x;
                    int i10 = ((Point) obtain).y;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    int a3 = value.a();
                    int b3 = value.b();
                    if (a3 > 0 && b3 > 0) {
                        layoutParams.leftMargin = a3;
                        layoutParams.topMargin = b3;
                        View d5 = value.d();
                        if (d5 != null) {
                            d5.setZ(((Marker) value.c()).getZIndex());
                            addView(d5, layoutParams);
                        }
                        value.a(true);
                        value.a(false, i3, i10);
                    }
                }
                obtain.recycle();
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void removeNativeOverlay(String str) {
        c1 c1Var = this.f3772b.get(str);
        if (c1Var != null) {
            View d5 = c1Var.d();
            if (d5 != null) {
                removeView(d5);
            }
            this.f3772b.remove(str);
        }
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void screenShotOverlays(Canvas canvas) {
        View d5;
        Iterator<Map.Entry<String, c1>> it = this.f3772b.entrySet().iterator();
        while (it.hasNext()) {
            c1 value = it.next().getValue();
            if (value != null && (d5 = value.d()) != null) {
                d5.setDrawingCacheEnabled(true);
                d5.invalidate();
                d5.buildDrawingCache();
                Bitmap drawingCache = d5.getDrawingCache();
                if (drawingCache != null) {
                    d5.getHitRect(new Rect());
                    canvas.drawBitmap(drawingCache, r3.left, r3.top, new Paint());
                }
                d5.setDrawingCacheEnabled(false);
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void set2Top(String str) {
        c1 c1Var = this.f3772b.get(str);
        if (c1Var == null) {
            return;
        }
        c1Var.d().setFocusable(true);
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void showInfoWindow(String str) {
        Marker marker;
        c1 c1Var = this.f3772b.get(str);
        if (c1Var == null || (marker = (Marker) c1Var.c()) == null) {
            return;
        }
        try {
            this.f3771a.showInfoWindow(marker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1Var.b(true);
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void updateOverlayOption(String str, MarkerOptions markerOptions) {
        Marker marker;
        c1 c1Var = this.f3772b.get(str);
        if (c1Var == null || (marker = (Marker) c1Var.c()) == null || markerOptions == null) {
            return;
        }
        marker.setMarkerOptions(markerOptions);
    }

    @Override // com.amap.api.maps.interfaces.INativeOverlayLayer
    public void updateOverlaysPosition() {
        BaseOverlay c9;
        Iterator<Map.Entry<String, c1>> it = this.f3772b.entrySet().iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            c1 value = it.next().getValue();
            if (value != null && (c9 = value.c()) != null) {
                Marker marker = c9 instanceof Marker ? (Marker) c9 : null;
                if (marker != null) {
                    LatLng position = marker.getPosition();
                    IPoint obtain = IPoint.obtain();
                    if (position != null) {
                        this.f3771a.getLatLng2Pixel(position.latitude, position.longitude, obtain);
                    }
                    value.b(((Point) obtain).x, ((Point) obtain).y);
                    obtain.recycle();
                    if (value.g() && value.h()) {
                        z5 = true;
                    }
                }
            }
        }
        redrawOverlays();
        if (z5) {
            this.f3771a.redrawInfoWindow();
        }
    }
}
