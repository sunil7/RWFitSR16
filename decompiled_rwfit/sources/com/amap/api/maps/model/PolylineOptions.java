package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public final class PolylineOptions extends BaseOptions implements Parcelable {

    @JBindingExclude
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();

    @JBindingExclude
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;

    @JBindingExclude
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    /* renamed from: a, reason: collision with root package name */
    @JBindingExclude
    String f5744a;

    @JBindingExclude
    private List<Integer> colorValues;

    @JBindingExclude
    private List<Integer> customIndexs;
    private BitmapDescriptor customTexture;
    private List<BitmapDescriptor> customTextureList;
    private BitmapDescriptor eraseTexture;
    private BitmapDescriptor footPrintTexture;
    private int[] jniColorValues;
    private int[] jniCustomIndexes;
    private float width = 10.0f;
    private int color = -16777216;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean useEngine = false;
    private boolean reducePoint = true;
    private boolean isUseTexture = true;
    private boolean isGeodesic = false;
    private boolean isDottedLine = false;
    private boolean isGradient = false;
    private float transparency = 1.0f;
    private boolean isAboveMaskLayer = false;
    private int dottedLineType = 0;

    @JBindingExclude
    private LineCapType lineCapType = LineCapType.LineCapRound;

    @JBindingExclude
    private LineJoinType lineJoinType = LineJoinType.LineJoinBevel;
    private int nLineCapType = 3;
    private int nLineJoinType = 0;
    private float shownRatio = -1.0f;
    private float shownRangeBegin = -1.0f;
    private float shownRangeEnd = -1.0f;
    private float footPrintGap = 100.0f;
    private boolean eraseVisible = false;
    private int eraseColor = -7829368;
    private float shownPolylineRangeBegin = 0.0f;
    private float shownPolylineRangeEnd = 0.0f;
    private boolean showPolylineRangeEnable = false;
    private PolylineUpdateFlags updateFlags = new PolylineUpdateFlags();
    private final List<LatLng> points = new ArrayList();

    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);

        private int type;

        LineCapType(int i3) {
            this.type = i3;
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineCapType valueOf(int i3) {
            return values()[Math.max(0, Math.min(i3, 4))];
        }
    }

    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);

        private int type;

        LineJoinType(int i3) {
            this.type = i3;
        }

        public int getTypeValue() {
            return this.type;
        }

        public static LineJoinType valueOf(int i3) {
            return values()[Math.max(0, Math.min(i3, 3))];
        }
    }

    @JBindingInclude
    public static class PolylineUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean isPointsUpdated = false;
        protected boolean isCustomIndexesUpdated = false;
        protected boolean isCustomTextureListUpdated = false;
        protected boolean isColorValuesUpdated = false;
        protected boolean footPrintBDUpdate = false;
        protected boolean eraseUpdate = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isPointsUpdated = false;
            this.isCustomIndexesUpdated = false;
            this.isCustomTextureListUpdated = false;
            this.isColorValuesUpdated = false;
            this.footPrintBDUpdate = false;
            this.eraseUpdate = false;
        }
    }

    public PolylineOptions() {
        this.type = "PolylineOptions";
    }

    public PolylineOptions aboveMaskLayer(boolean z5) {
        this.isAboveMaskLayer = z5;
        return this;
    }

    public PolylineOptions add(LatLng latLng) {
        if (latLng != null) {
            try {
                this.points.add(latLng);
                this.updateFlags.isPointsUpdated = true;
                return this;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                Iterator<LatLng> it = iterable.iterator();
                while (it.hasNext()) {
                    this.points.add(it.next());
                }
                this.updateFlags.isPointsUpdated = true;
                return this;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return this;
    }

    public PolylineOptions color(int i3) {
        this.color = i3;
        return this;
    }

    public PolylineOptions colorValues(List<Integer> list) {
        try {
            this.colorValues = list;
            this.jniColorValues = new int[list.size()];
            int i3 = 0;
            while (true) {
                int[] iArr = this.jniColorValues;
                if (i3 >= iArr.length) {
                    break;
                }
                iArr[i3] = list.get(i3).intValue();
                i3++;
            }
            this.updateFlags.isColorValuesUpdated = true;
        } catch (Throwable unused) {
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean z5) {
        this.isGeodesic = z5;
        return this;
    }

    public int getColor() {
        return this.color;
    }

    public List<Integer> getColorValues() {
        return this.colorValues;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.customTexture;
    }

    public List<Integer> getCustomTextureIndex() {
        return this.customIndexs;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.customTextureList;
    }

    public int getDottedLineType() {
        return this.dottedLineType;
    }

    public int getEraseColor() {
        return this.eraseColor;
    }

    public BitmapDescriptor getEraseTexture() {
        return this.eraseTexture;
    }

    public boolean getEraseVisible() {
        return this.eraseVisible;
    }

    public float getFootPrintGap() {
        return this.footPrintGap;
    }

    public BitmapDescriptor getFootPrintTexture() {
        return this.footPrintTexture;
    }

    public LineCapType getLineCapType() {
        return this.lineCapType;
    }

    public LineJoinType getLineJoinType() {
        return this.lineJoinType;
    }

    public List<LatLng> getPoints() {
        return this.points;
    }

    public float getPolylineShownRangeBegin() {
        return this.shownPolylineRangeBegin;
    }

    public float getPolylineShownRangeEnd() {
        return this.shownPolylineRangeEnd;
    }

    public boolean getReducePoint() {
        return this.reducePoint;
    }

    public float getShownRangeBegin() {
        return this.shownRangeBegin;
    }

    public float getShownRangeEnd() {
        return this.shownRangeEnd;
    }

    public float getShownRatio() {
        return this.shownRatio;
    }

    public float getTransparency() {
        return this.transparency;
    }

    public boolean getUseEngine() {
        return this.useEngine;
    }

    public float getWidth() {
        return this.width;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isAboveMaskLayer() {
        return this.isAboveMaskLayer;
    }

    public boolean isDottedLine() {
        return this.isDottedLine;
    }

    public boolean isGeodesic() {
        return this.isGeodesic;
    }

    public boolean isShowPolylineRangeEnable() {
        return this.showPolylineRangeEnable;
    }

    public boolean isUseGradient() {
        return this.isGradient;
    }

    public boolean isUseTexture() {
        return this.isUseTexture;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public PolylineOptions lineCapType(LineCapType lineCapType) {
        if (lineCapType != null) {
            this.lineCapType = lineCapType;
            this.nLineCapType = lineCapType.getTypeValue();
        }
        return this;
    }

    public PolylineOptions lineJoinType(LineJoinType lineJoinType) {
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

    public PolylineOptions setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        this.customTexture = bitmapDescriptor;
        return this;
    }

    public PolylineOptions setCustomTextureIndex(List<Integer> list) {
        try {
            this.customIndexs = list;
            this.jniCustomIndexes = new int[list.size()];
            int i3 = 0;
            while (true) {
                int[] iArr = this.jniCustomIndexes;
                if (i3 >= iArr.length) {
                    break;
                }
                iArr[i3] = list.get(i3).intValue();
                i3++;
            }
            PolylineUpdateFlags polylineUpdateFlags = this.updateFlags;
            polylineUpdateFlags.isCustomIndexesUpdated = true;
            polylineUpdateFlags.isCustomTextureListUpdated = true;
        } catch (Throwable unused) {
        }
        return this;
    }

    public PolylineOptions setCustomTextureList(List<BitmapDescriptor> list) {
        this.customTextureList = list;
        PolylineUpdateFlags polylineUpdateFlags = this.updateFlags;
        polylineUpdateFlags.isCustomTextureListUpdated = true;
        polylineUpdateFlags.isCustomIndexesUpdated = true;
        return this;
    }

    public PolylineOptions setDottedLine(boolean z5) {
        this.isDottedLine = z5;
        return this;
    }

    public PolylineOptions setDottedLineType(int i3) {
        this.dottedLineType = i3 == 0 ? 0 : 1;
        return this;
    }

    public PolylineOptions setEraseColor(boolean z5, int i3) {
        this.eraseVisible = z5;
        this.eraseColor = i3;
        this.updateFlags.eraseUpdate = true;
        return this;
    }

    public PolylineOptions setEraseTexture(boolean z5, BitmapDescriptor bitmapDescriptor) {
        this.eraseVisible = z5;
        this.eraseTexture = bitmapDescriptor;
        this.updateFlags.eraseUpdate = true;
        return this;
    }

    public PolylineOptions setFootPrintGap(float f2) {
        this.footPrintGap = f2;
        return this;
    }

    public PolylineOptions setFootPrintTexture(BitmapDescriptor bitmapDescriptor) {
        this.footPrintTexture = bitmapDescriptor;
        this.updateFlags.footPrintBDUpdate = true;
        return this;
    }

    public void setPoints(List<LatLng> list) {
        List<LatLng> list2;
        if (list == null || (list2 = this.points) == list) {
            return;
        }
        try {
            list2.clear();
            this.points.addAll(list);
            this.updateFlags.isPointsUpdated = true;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public PolylineOptions setPolylineShowRange(float f2, float f10) {
        this.shownPolylineRangeBegin = f2;
        this.shownPolylineRangeEnd = f10;
        return this;
    }

    public void setReducePoint(boolean z5) {
        this.reducePoint = z5;
    }

    public PolylineOptions setShownRange(float f2, float f10) {
        this.shownRangeBegin = f2;
        this.shownRangeEnd = f10;
        showPolylineRangeEnabled(true);
        setPolylineShowRange(f2, f10);
        return this;
    }

    public PolylineOptions setShownRatio(float f2) {
        this.shownRatio = f2;
        setPolylineShowRange(0.0f, f2);
        showPolylineRangeEnabled(true);
        return this;
    }

    public void setUseEngine(boolean z5) {
        this.useEngine = z5;
    }

    public PolylineOptions setUseTexture(boolean z5) {
        this.isUseTexture = z5;
        return this;
    }

    public PolylineOptions showPolylineRangeEnabled(boolean z5) {
        this.showPolylineRangeEnable = z5;
        return this;
    }

    public PolylineOptions transparency(float f2) {
        this.transparency = f2;
        return this;
    }

    public PolylineOptions useGradient(boolean z5) {
        this.isGradient = z5;
        return this;
    }

    public PolylineOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    public PolylineOptions width(float f2) {
        this.width = f2;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.width);
        parcel.writeInt(this.color);
        parcel.writeInt(this.dottedLineType);
        parcel.writeFloat(this.zIndex);
        parcel.writeFloat(this.transparency);
        parcel.writeString(this.f5744a);
        parcel.writeInt(this.lineCapType.getTypeValue());
        parcel.writeInt(this.lineJoinType.getTypeValue());
        parcel.writeBooleanArray(new boolean[]{this.isVisible, this.isDottedLine, this.isGeodesic, this.isGradient, this.isAboveMaskLayer});
        BitmapDescriptor bitmapDescriptor = this.customTexture;
        if (bitmapDescriptor != null) {
            parcel.writeParcelable(bitmapDescriptor, i3);
        }
        List<BitmapDescriptor> list = this.customTextureList;
        if (list != null) {
            parcel.writeList(list);
        }
        List<Integer> list2 = this.customIndexs;
        if (list2 != null) {
            parcel.writeList(list2);
        }
        List<Integer> list3 = this.colorValues;
        if (list3 != null) {
            parcel.writeList(list3);
        }
        parcel.writeFloat(this.shownRatio);
    }

    public PolylineOptions zIndex(float f2) {
        if (this.zIndex != f2) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f2;
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public PolylineUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            try {
                this.points.addAll(Arrays.asList(latLngArr));
                this.updateFlags.isPointsUpdated = true;
                return this;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return this;
    }
}
