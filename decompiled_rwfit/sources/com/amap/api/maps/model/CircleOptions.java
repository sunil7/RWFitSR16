package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public final class CircleOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    @JBindingExclude
    String f5728a;
    private LatLng point = null;
    private double radius = 0.0d;
    private float strokeWidth = 10.0f;
    private int strokeColor = -16777216;
    private int fillColor = 0;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private int dottedLineType = -1;
    private boolean isUsePolylineStroke = true;
    private CircleUpdateFlags updateFlags = new CircleUpdateFlags();
    private List<BaseHoleOptions> holeOptions = new ArrayList();

    @JBindingInclude
    public static class CircleUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean isCenterUpdated = false;
        protected boolean isRadiusUpdated = false;
        protected boolean isHoleOptionsUpdated = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isCenterUpdated = false;
            this.isRadiusUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    public CircleOptions() {
        this.type = "CircleOptions";
    }

    private void a() {
        if (this.holeOptions != null) {
            ArrayList arrayList = new ArrayList();
            List<BaseHoleOptions> list = this.holeOptions;
            for (int i3 = 0; i3 < list.size(); i3++) {
                BaseHoleOptions baseHoleOptions = list.get(i3);
                if (baseHoleOptions instanceof PolygonHoleOptions) {
                    PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                    if (v4.a(getRadius(), getCenter(), arrayList, polygonHoleOptions) && !v4.b(arrayList, polygonHoleOptions)) {
                        arrayList.add(polygonHoleOptions);
                    }
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                    if (v4.a(getRadius(), getCenter(), circleHoleOptions) && !v4.a(arrayList, circleHoleOptions)) {
                        arrayList.add(circleHoleOptions);
                    }
                }
            }
            this.holeOptions.clear();
            this.holeOptions.addAll(arrayList);
            this.updateFlags.isHoleOptionsUpdated = true;
        }
    }

    public CircleOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr != null) {
            try {
                this.holeOptions.addAll(Arrays.asList(baseHoleOptionsArr));
                a();
                return this;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return this;
    }

    public CircleOptions center(LatLng latLng) {
        this.point = latLng;
        this.updateFlags.isCenterUpdated = true;
        a();
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i3) {
        this.fillColor = i3;
        return this;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public double getRadius() {
        return this.radius;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeDottedLineType() {
        return this.dottedLineType;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isUsePolylineStroke() {
        return this.isUsePolylineStroke;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public CircleOptions radius(double d5) {
        this.radius = d5;
        this.updateFlags.isRadiusUpdated = true;
        a();
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public CircleOptions setStrokeDottedLineType(int i3) {
        this.dottedLineType = i3;
        return this;
    }

    public CircleOptions strokeColor(int i3) {
        this.strokeColor = i3;
        return this;
    }

    public CircleOptions strokeWidth(float f2) {
        this.strokeWidth = f2;
        return this;
    }

    public CircleOptions usePolylineStroke(boolean z5) {
        this.isUsePolylineStroke = z5;
        return this;
    }

    public CircleOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble(Const.JSON_KEY_LAT, latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f5728a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.dottedLineType);
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : (byte) 0);
    }

    public CircleOptions zIndex(float f2) {
        if (this.zIndex != f2) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f2;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CircleOptions m7clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.f5728a = this.f5728a;
        circleOptions.point = this.point;
        circleOptions.radius = this.radius;
        circleOptions.strokeWidth = this.strokeWidth;
        circleOptions.strokeColor = this.strokeColor;
        circleOptions.fillColor = this.fillColor;
        circleOptions.zIndex = this.zIndex;
        circleOptions.isVisible = this.isVisible;
        circleOptions.holeOptions = this.holeOptions;
        circleOptions.dottedLineType = this.dottedLineType;
        circleOptions.isUsePolylineStroke = this.isUsePolylineStroke;
        circleOptions.updateFlags = this.updateFlags;
        return circleOptions;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public CircleUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public CircleOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        if (iterable != null) {
            try {
                Iterator<BaseHoleOptions> it = iterable.iterator();
                while (it.hasNext()) {
                    this.holeOptions.add(it.next());
                }
                a();
                return this;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return this;
    }
}
