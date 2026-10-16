package com.amap.api.maps.model;

import android.graphics.Point;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public class BuildingOverlayOptions extends BaseOptions {
    private int[] buildingLatlngsPoints;
    private float zindex;
    private int buildingHeight = -1;
    private int buildingHeightScale = 1;
    private int buildingTopColor = -7829368;
    private int buildingSideColor = -7829368;
    private boolean isVisible = true;
    private List<LatLng> buildingLatlngs = new ArrayList();

    public int getBuildingHeight() {
        return this.buildingHeight;
    }

    public int getBuildingHeightScale() {
        return this.buildingHeightScale;
    }

    public List<LatLng> getBuildingLatlngs() {
        return this.buildingLatlngs;
    }

    public int getBuildingSideColor() {
        return this.buildingSideColor;
    }

    public int getBuildingTopColor() {
        return this.buildingTopColor;
    }

    public synchronized int[] getPoints() {
        List<LatLng> list = this.buildingLatlngs;
        if (list == null || list.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[this.buildingLatlngs.size() * 2];
        int i3 = 0;
        for (int i10 = 0; i10 < this.buildingLatlngs.size(); i10++) {
            LatLng latLng = this.buildingLatlngs.get(i10);
            if (latLng != null) {
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int i11 = i3 + 1;
                iArr[i3] = latLongToPixels.x;
                i3 += 2;
                iArr[i11] = latLongToPixels.y;
            }
        }
        return iArr;
    }

    public float getZIndex() {
        return this.zindex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public BuildingOverlayOptions setBuildingHeight(int i3) {
        this.buildingHeight = i3;
        return this;
    }

    public BuildingOverlayOptions setBuildingHeightScale(int i3) {
        this.buildingHeightScale = i3;
        return this;
    }

    public synchronized BuildingOverlayOptions setBuildingLatlngs(List<LatLng> list) {
        this.buildingLatlngs = list;
        if (list != null && list.size() > 0) {
            this.buildingLatlngsPoints = new int[list.size() * 2];
            int i3 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                LatLng latLng = list.get(i10);
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int[] iArr = this.buildingLatlngsPoints;
                int i11 = i3 + 1;
                iArr[i3] = latLongToPixels.x;
                i3 += 2;
                iArr[i11] = latLongToPixels.y;
            }
        }
        return this;
    }

    public BuildingOverlayOptions setBuildingSideColor(int i3) {
        this.buildingSideColor = i3;
        return this;
    }

    public BuildingOverlayOptions setBuildingTopColor(int i3) {
        this.buildingTopColor = i3;
        return this;
    }

    public void setVisible(boolean z5) {
        this.isVisible = z5;
    }

    public void setZIndex(float f2) {
        this.zindex = f2;
    }
}
