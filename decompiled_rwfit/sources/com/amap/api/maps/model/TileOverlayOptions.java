package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public final class TileOverlayOptions extends BaseOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private TileProvider _tileProvider;

    @JBindingInclude
    private String diskCacheDir;

    @JBindingInclude
    private boolean diskCacheEnabled;

    @JBindingInclude
    private long diskCacheSize;

    @JBindingInclude
    private TileProviderInner mTileProvider;
    private final int mVersionCode;

    @JBindingInclude
    private boolean mVisible;

    @JBindingInclude
    private float mZIndex;

    @JBindingInclude
    private int memCacheSize;

    @JBindingInclude
    private boolean memoryCacheEnabled;

    public TileOverlayOptions() {
        this.mVisible = true;
        this.memCacheSize = Const.MAX_SIZE_WRAPDATA;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = 1;
        this.type = "TileOverlayOptions";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions diskCacheDir(String str) {
        this.diskCacheDir = str;
        return this;
    }

    public TileOverlayOptions diskCacheEnabled(boolean z5) {
        this.diskCacheEnabled = z5;
        return this;
    }

    public TileOverlayOptions diskCacheSize(int i3) {
        this.diskCacheSize = i3 * 1024;
        return this;
    }

    public String getDiskCacheDir() {
        return this.diskCacheDir;
    }

    public boolean getDiskCacheEnabled() {
        return this.diskCacheEnabled;
    }

    public long getDiskCacheSize() {
        return this.diskCacheSize;
    }

    public int getMemCacheSize() {
        return this.memCacheSize;
    }

    public boolean getMemoryCacheEnabled() {
        return this.memoryCacheEnabled;
    }

    public TileProvider getTileProvider() {
        return this._tileProvider;
    }

    public TileProviderInner getTileProviderInner() {
        return this.mTileProvider;
    }

    public float getZIndex() {
        return this.mZIndex;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public TileOverlayOptions memCacheSize(int i3) {
        this.memCacheSize = i3;
        return this;
    }

    public TileOverlayOptions memoryCacheEnabled(boolean z5) {
        this.memoryCacheEnabled = z5;
        return this;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this._tileProvider = tileProvider;
        this.mTileProvider = new TileProviderInner(tileProvider);
        return this;
    }

    public TileOverlayOptions visible(boolean z5) {
        this.mVisible = z5;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeValue(this.mTileProvider);
        parcel.writeByte(this.mVisible ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.mZIndex);
        parcel.writeInt(this.memCacheSize);
        parcel.writeLong(this.diskCacheSize);
        parcel.writeString(this.diskCacheDir);
        parcel.writeByte(this.memoryCacheEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.diskCacheEnabled ? (byte) 1 : (byte) 0);
    }

    public TileOverlayOptions zIndex(float f2) {
        this.mZIndex = f2;
        return this;
    }

    public TileOverlayOptions(int i3, boolean z5, float f2) {
        this.memCacheSize = Const.MAX_SIZE_WRAPDATA;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = i3;
        this.mVisible = z5;
        this.mZIndex = f2;
        this.type = "TileOverlayOptions";
    }
}
