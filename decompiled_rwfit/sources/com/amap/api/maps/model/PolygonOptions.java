package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.AMapPara;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public final class PolygonOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    @JBindingExclude
    String f5743a;
    private float strokeWidth = 10.0f;
    private int strokeColor = -16777216;
    private int fillColor = -16777216;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean isUsePolylineStroke = true;

    @JBindingExclude
    private AMapPara.LineJoinType lineJoinType = AMapPara.LineJoinType.LineJoinBevel;
    private int nLineCapType = 3;
    private int nLineJoinType = 0;
    private PolygonUpdateFlags updateFlags = new PolygonUpdateFlags();
    private final List<LatLng> points = new ArrayList();
    private List<BaseHoleOptions> holeOptions = new ArrayList();

    @JBindingInclude
    public static class PolygonUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean isPointsUpdated = false;
        protected boolean isHoleOptionsUpdated = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isPointsUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    public PolygonOptions() {
        this.type = "PolygonOptions";
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        if (r7 == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a() {
        /*
            r12 = this;
            java.lang.String r0 = "PolygonDelegateImp"
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r1 = r12.holeOptions
            if (r1 == 0) goto La3
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r2 = r12.holeOptions
            r3 = 0
            r4 = r3
        Lf:
            int r5 = r2.size()
            r6 = 1
            if (r4 >= r5) goto L95
            java.lang.Object r5 = r2.get(r4)
            com.amap.api.maps.model.BaseHoleOptions r5 = (com.amap.api.maps.model.BaseHoleOptions) r5
            boolean r7 = r5 instanceof com.amap.api.maps.model.PolygonHoleOptions
            if (r7 == 0) goto L36
            com.amap.api.maps.model.PolygonHoleOptions r5 = (com.amap.api.maps.model.PolygonHoleOptions) r5
            java.util.List r6 = r12.getPoints()
            boolean r6 = com.amap.api.col.p0003sl.v4.a(r6, r5)
            if (r6 == 0) goto L91
            boolean r6 = com.amap.api.col.p0003sl.v4.b(r1, r5)
            if (r6 != 0) goto L91
            r1.add(r5)
            goto L91
        L36:
            boolean r7 = r5 instanceof com.amap.api.maps.model.CircleHoleOptions
            if (r7 == 0) goto L91
            com.amap.api.maps.model.CircleHoleOptions r5 = (com.amap.api.maps.model.CircleHoleOptions) r5
            java.util.List r7 = r12.getPoints()
            boolean r8 = com.amap.api.col.p0003sl.v4.b(r7, r5)     // Catch: java.lang.Throwable -> L7c
            if (r8 != 0) goto L85
            com.amap.api.maps.model.LatLng r8 = r5.getCenter()     // Catch: java.lang.Throwable -> L7c
            if (r8 != 0) goto L4d
            goto L78
        L4d:
            int r9 = r1.size()     // Catch: java.lang.Throwable -> L69
            if (r9 <= 0) goto L6b
            int r9 = r1.size()     // Catch: java.lang.Throwable -> L69
            r10 = r3
        L58:
            if (r10 >= r9) goto L6b
            java.lang.Object r11 = r1.get(r10)     // Catch: java.lang.Throwable -> L69
            int r10 = r10 + 1
            com.amap.api.maps.model.BaseHoleOptions r11 = (com.amap.api.maps.model.BaseHoleOptions) r11     // Catch: java.lang.Throwable -> L69
            boolean r11 = com.amap.api.col.p0003sl.v4.a(r11, r8)     // Catch: java.lang.Throwable -> L69
            if (r11 == 0) goto L58
            goto L78
        L69:
            r7 = move-exception
            goto L70
        L6b:
            boolean r7 = com.amap.api.col.p0003sl.v4.a(r8, r7)     // Catch: java.lang.Throwable -> L69
            goto L79
        L70:
            java.lang.String r8 = "contains"
            com.amap.api.col.p0003sl.ka.a(r7, r0, r8)     // Catch: java.lang.Throwable -> L7c
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L7c
        L78:
            r7 = r3
        L79:
            if (r7 == 0) goto L85
            goto L86
        L7c:
            r6 = move-exception
            java.lang.String r7 = "isCircleInPolygon"
            com.amap.api.col.p0003sl.ka.a(r6, r0, r7)
            r6.printStackTrace()
        L85:
            r6 = r3
        L86:
            if (r6 == 0) goto L91
            boolean r6 = com.amap.api.col.p0003sl.v4.a(r1, r5)
            if (r6 != 0) goto L91
            r1.add(r5)
        L91:
            int r4 = r4 + 1
            goto Lf
        L95:
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r0 = r12.holeOptions
            r0.clear()
            java.util.List<com.amap.api.maps.model.BaseHoleOptions> r0 = r12.holeOptions
            r0.addAll(r1)
            com.amap.api.maps.model.PolygonOptions$PolygonUpdateFlags r0 = r12.updateFlags
            r0.isHoleOptionsUpdated = r6
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.PolygonOptions.a():void");
    }

    public PolygonOptions add(LatLng latLng) {
        try {
            this.points.add(latLng);
            this.updateFlags.isPointsUpdated = true;
            a();
            return this;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return this;
        }
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                Iterator<LatLng> it = iterable.iterator();
                while (it.hasNext()) {
                    this.points.add(it.next());
                }
                a();
                this.updateFlags.isPointsUpdated = true;
                return this;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return this;
    }

    public PolygonOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i3) {
        this.fillColor = i3;
        return this;
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public AMapPara.LineJoinType getLineJoinType() {
        return this.lineJoinType;
    }

    public List<LatLng> getPoints() {
        return this.points;
    }

    public int getStrokeColor() {
        return this.strokeColor;
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

    public PolygonOptions lineJoinType(AMapPara.LineJoinType lineJoinType) {
        if (lineJoinType != null) {
            this.lineJoinType = lineJoinType;
            this.nLineJoinType = lineJoinType.getTypeValue();
        }
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.holeOptions.clear();
            if (list != null) {
                this.holeOptions.addAll(list);
            }
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.points.clear();
            if (list == null) {
                return;
            }
            this.points.addAll(list);
            a();
            this.updateFlags.isPointsUpdated = true;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public PolygonOptions strokeColor(int i3) {
        this.strokeColor = i3;
        return this;
    }

    public PolygonOptions strokeWidth(float f2) {
        this.strokeWidth = f2;
        return this;
    }

    public PolygonOptions usePolylineStroke(boolean z5) {
        this.isUsePolylineStroke = z5;
        return this;
    }

    public PolygonOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f5743a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.lineJoinType.getTypeValue());
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : (byte) 0);
    }

    public PolygonOptions zIndex(float f2) {
        float f10 = this.zIndex;
        if (f10 != f10) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f2;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PolygonOptions m14clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.points.addAll(this.points);
        polygonOptions.strokeWidth = this.strokeWidth;
        polygonOptions.strokeColor = this.strokeColor;
        polygonOptions.fillColor = this.fillColor;
        polygonOptions.zIndex = this.zIndex;
        polygonOptions.isVisible = this.isVisible;
        polygonOptions.holeOptions = this.holeOptions;
        polygonOptions.f5743a = this.f5743a;
        polygonOptions.isUsePolylineStroke = this.isUsePolylineStroke;
        polygonOptions.lineJoinType = this.lineJoinType;
        polygonOptions.nLineCapType = this.nLineCapType;
        polygonOptions.nLineJoinType = this.nLineJoinType;
        polygonOptions.updateFlags = this.updateFlags;
        return polygonOptions;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public PolygonUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public PolygonOptions addHoles(Iterable<BaseHoleOptions> iterable) {
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

    public PolygonOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            try {
                this.points.addAll(Arrays.asList(latLngArr));
                this.updateFlags.isPointsUpdated = true;
                a();
                return this;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return this;
    }
}
