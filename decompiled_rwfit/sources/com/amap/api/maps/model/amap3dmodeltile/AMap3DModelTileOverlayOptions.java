package com.amap.api.maps.model.amap3dmodeltile;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public class AMap3DModelTileOverlayOptions extends BaseOptions implements Parcelable {
    public static final Parcelable.Creator<AMap3DModelTileOverlayOptions> CREATOR = new a();
    private TileProvider tileProvider;

    @JBindingInclude
    private TileProviderInner tileProviderInner;

    @JBindingInclude
    private float zIndex = 0.0f;

    @JBindingInclude
    private boolean visible = true;

    @JBindingInclude
    private List<AMap3DTileBuildingColor> customBuildingColors = new ArrayList();

    @JBindingInclude
    private List<AMap3DTileBuildingMaterialOptions> customBuildingMaterialOptions = new ArrayList();

    public static class a implements Parcelable.Creator<AMap3DModelTileOverlayOptions> {
        @Override // android.os.Parcelable.Creator
        public AMap3DModelTileOverlayOptions createFromParcel(Parcel parcel) {
            TileProvider tileProvider = (TileProvider) parcel.readValue(TileProvider.class.getClassLoader());
            ArrayList readArrayList = parcel.readArrayList(AMap3DTileBuildingColor.class.getClassLoader());
            ArrayList readArrayList2 = parcel.readArrayList(AMap3DTileBuildingMaterialOptions.class.getClassLoader());
            AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions = new AMap3DModelTileOverlayOptions();
            if (tileProvider != null) {
                aMap3DModelTileOverlayOptions.setTileProvider(tileProvider);
            }
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            aMap3DModelTileOverlayOptions.setVisible(zArr[0]);
            aMap3DModelTileOverlayOptions.setZIndex(parcel.readFloat());
            aMap3DModelTileOverlayOptions.setCustomBuildingColors(readArrayList);
            aMap3DModelTileOverlayOptions.setCustomBuildingMaterialOptions(readArrayList2);
            return aMap3DModelTileOverlayOptions;
        }

        @Override // android.os.Parcelable.Creator
        public AMap3DModelTileOverlayOptions[] newArray(int i3) {
            return new AMap3DModelTileOverlayOptions[i3];
        }
    }

    public AMap3DModelTileOverlayOptions() {
        this.type = "AMap3DModelTileOverlayOptions";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<AMap3DTileBuildingColor> getCustomBuildingColors() {
        return this.customBuildingColors;
    }

    public List<AMap3DTileBuildingMaterialOptions> getCustomBuildingMaterialOptions() {
        return this.customBuildingMaterialOptions;
    }

    public TileProviderInner getTileProviderInner() {
        return this.tileProviderInner;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public void setCustomBuildingColors(List<AMap3DTileBuildingColor> list) {
        this.customBuildingColors = list;
    }

    public void setCustomBuildingMaterialOptions(List<AMap3DTileBuildingMaterialOptions> list) {
        this.customBuildingMaterialOptions = list;
    }

    public void setTileProvider(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
        this.tileProviderInner = new TileProviderInner(tileProvider);
    }

    public void setVisible(boolean z5) {
        this.visible = z5;
    }

    public void setZIndex(float f2) {
        this.zIndex = f2;
    }

    public boolean visible() {
        return this.visible;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeValue(this.tileProviderInner);
        parcel.writeBooleanArray(new boolean[]{this.visible});
        parcel.writeFloat(this.zIndex);
        parcel.writeList(this.customBuildingColors);
        parcel.writeList(this.customBuildingMaterialOptions);
    }
}
