package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class MVTTileOverlayOptions extends BaseOptions implements Parcelable {
    public static final Parcelable.Creator<MVTTileOverlayOptions> CREATOR = new a();

    @JBindingInclude
    private String layerId;
    private TileProvider tileProvider;

    @JBindingInclude
    private TileProviderInner tileProviderInner;

    @JBindingInclude
    private boolean visible;

    @JBindingInclude
    private float zIndex;

    public static class Builder {

        /* renamed from: id, reason: collision with root package name */
        private String f5734id;
        private String key;
        private String url;
        private float zIndex = 0.0f;
        private boolean visible = true;

        public MVTTileOverlayOptions build() {
            MVTTileOverlayOptions mVTTileOverlayOptions = new MVTTileOverlayOptions(this.url, this.key, this.f5734id);
            mVTTileOverlayOptions.setZIndex(this.zIndex);
            mVTTileOverlayOptions.setVisible(this.visible);
            return mVTTileOverlayOptions;
        }

        public Builder id(String str) {
            this.f5734id = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder visible(boolean z5) {
            this.visible = z5;
            return this;
        }

        public Builder zIndex(float f2) {
            this.zIndex = f2;
            return this;
        }
    }

    public static class a implements Parcelable.Creator<MVTTileOverlayOptions> {
        @Override // android.os.Parcelable.Creator
        public MVTTileOverlayOptions createFromParcel(Parcel parcel) {
            TileProvider tileProvider = (TileProvider) parcel.readValue(TileProvider.class.getClassLoader());
            MVTTileOverlayOptions mVTTileOverlayOptions = new MVTTileOverlayOptions(parcel.readString(), parcel.readString(), parcel.readString());
            if (tileProvider != null) {
                mVTTileOverlayOptions.setTileProvider(tileProvider);
            }
            return mVTTileOverlayOptions;
        }

        @Override // android.os.Parcelable.Creator
        public MVTTileOverlayOptions[] newArray(int i3) {
            return new MVTTileOverlayOptions[i3];
        }
    }

    public MVTTileOverlayOptions(String str, String str2, String str3) {
        this.type = "MVTTileOverlayOptions";
        MVTTileProvider mVTTileProvider = new MVTTileProvider(str, str2, str3);
        this.tileProvider = mVTTileProvider;
        this.tileProviderInner = new TileProviderInner(mVTTileProvider);
        this.layerId = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileProviderInner getTileProviderInner() {
        return this.tileProviderInner;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public void setTileProvider(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
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
    }
}
