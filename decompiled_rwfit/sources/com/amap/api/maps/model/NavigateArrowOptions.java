package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public final class NavigateArrowOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final NavigateArrowOptionsCreator CREATOR = new NavigateArrowOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    @JBindingExclude
    String f5742a;
    private float width = 10.0f;
    private int topColor = Color.argb(221, 87, 235, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS);
    private int sideColor = Color.argb(170, 0, 172, 146);
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean is3DModel = false;
    private int arrowLineInnerResId = AMapEngineUtils.ARROW_LINE_INNER_TEXTURE_ID;
    private int arrowLineOuterResId = AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID;
    private int arrowLineShadowResId = AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID;
    private final List<LatLng> points = new ArrayList();

    public NavigateArrowOptions() {
        this.type = "NavigateArrowOptions";
    }

    public NavigateArrowOptions add(LatLng latLng) {
        this.points.add(latLng);
        return this;
    }

    public NavigateArrowOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.points.add(it.next());
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<LatLng> getPoints() {
        return this.points;
    }

    public int getSideColor() {
        return this.sideColor;
    }

    public int getTopColor() {
        return this.topColor;
    }

    public float getWidth() {
        return this.width;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean is3DModel() {
        return this.is3DModel;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public NavigateArrowOptions set3DModel(boolean z5) {
        this.is3DModel = z5;
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
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public NavigateArrowOptions sideColor(int i3) {
        this.sideColor = i3;
        return this;
    }

    public NavigateArrowOptions topColor(int i3) {
        this.topColor = i3;
        return this;
    }

    public NavigateArrowOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    public NavigateArrowOptions width(float f2) {
        this.width = f2;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.width);
        parcel.writeInt(this.topColor);
        parcel.writeInt(this.sideColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f5742a);
        parcel.writeByte(this.is3DModel ? (byte) 1 : (byte) 0);
    }

    public NavigateArrowOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }

    public NavigateArrowOptions add(LatLng... latLngArr) {
        this.points.addAll(Arrays.asList(latLngArr));
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public NavigateArrowOptions m13clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        NavigateArrowOptions navigateArrowOptions = new NavigateArrowOptions();
        navigateArrowOptions.points.addAll(this.points);
        navigateArrowOptions.width = this.width;
        navigateArrowOptions.topColor = this.topColor;
        navigateArrowOptions.sideColor = this.sideColor;
        navigateArrowOptions.zIndex = this.zIndex;
        navigateArrowOptions.isVisible = this.isVisible;
        navigateArrowOptions.is3DModel = this.is3DModel;
        navigateArrowOptions.f5742a = this.f5742a;
        navigateArrowOptions.arrowLineInnerResId = this.arrowLineInnerResId;
        navigateArrowOptions.arrowLineOuterResId = this.arrowLineOuterResId;
        navigateArrowOptions.arrowLineShadowResId = this.arrowLineShadowResId;
        return navigateArrowOptions;
    }
}
