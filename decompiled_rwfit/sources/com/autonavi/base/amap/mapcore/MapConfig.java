package com.autonavi.base.amap.mapcore;

import android.opengl.Matrix;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.concurrent.atomic.AtomicInteger;

@JBindingInclude
/* loaded from: classes.dex */
public class MapConfig implements Cloneable, IMapConfig {
    public static final int DEFAULT_RATIO = 1;
    private static final int GEO_POINT_ZOOM = 20;
    public static final float MAX_ZOOM = 20.0f;
    public static final float MAX_ZOOM_INDOOR = 20.0f;
    public static final float MIN_ZOOM = 3.0f;
    public static final int MSG_ACTION_MAINTHREAD_TRIGGER = 30;
    public static final int MSG_ACTION_NATIVE_OVERLAYS_POSITION_UPDATE = 41;
    public static final int MSG_ACTION_NATIVE_OVERLAYS_REFRESH = 40;
    public static final int MSG_ACTION_ONBASEPOICLICK = 20;
    public static final int MSG_ACTION_ONMAPCLICK = 19;
    public static final int MSG_AUTH_FAILURE = 2;
    public static final int MSG_CALLBACK_MAPLOADED = 16;
    public static final int MSG_CALLBACK_ONTOUCHEVENT = 14;
    public static final int MSG_CALLBACK_SCREENSHOT = 15;
    public static final int MSG_CAMERAUPDATE_CHANGE = 10;
    public static final int MSG_CAMERAUPDATE_FINISH = 11;
    public static final int MSG_COMPASSVIEW_CHANGESTATE = 13;
    public static final int MSG_INFOWINDOW_UPDATE = 18;
    public static final int MSG_TILEOVERLAY_REFRESH = 17;
    public static final int MSG_ZOOMVIEW_CHANGESTATE = 12;
    private static final int TILE_SIZE_POW = 8;
    private String customTextureResourcePath;
    private boolean isSetLimitZoomLevel;
    MapConfig lastMapconfig;
    private IPoint[] limitIPoints;
    private LatLngBounds limitLatLngBounds;
    private String mCustomStyleID;
    private String mCustomStylePath;

    @JBindingInclude
    private int mapHeight;

    @JBindingInclude
    private float mapPerPixelUnitLength;

    @JBindingInclude
    private int mapWidth;
    private float skyHeight;
    public float maxZoomLevel = 20.0f;
    public float minZoomLevel = 3.0f;
    private FPoint[] mapRect = null;

    @JBindingInclude
    private Rectangle geoRectangle = new Rectangle();
    private boolean isIndoorEnable = false;
    private boolean isBuildingEnable = true;
    private boolean isMapTextEnable = true;
    private boolean isTrafficEnabled = false;
    private boolean isCustomStyleEnabled = false;

    @JBindingInclude
    private double sX = 2.21010267E8d;

    @JBindingInclude
    private double sY = 1.01697799E8d;
    private DPoint mapGeoCenter = new DPoint(this.sX, this.sY);

    @JBindingInclude
    private float sZ = 10.0f;

    @JBindingInclude
    private float sC = 0.0f;

    @JBindingInclude
    private float sR = 0.0f;
    private boolean isCenterChanged = false;
    private boolean isZoomChanged = false;
    private boolean isTiltChanged = false;
    private boolean isBearingChanged = false;
    private boolean isNeedUpdateZoomControllerState = false;
    private boolean isNeedUpdateMapRectNextFrame = false;
    private int mMapStyleMode = 0;
    private int mMapStyleTime = 0;
    private int anchorX = 0;
    private String mMapLanguage = "zh_cn";
    private boolean isHideLogoEnable = false;
    private boolean isWorldMapEnable = false;
    private boolean isTouchPoiEnable = true;
    private int abroadState = 1;
    private boolean isAbroadEnable = false;
    private boolean isTerrainEnable = false;

    @JBindingInclude
    float[] viewMatrix = new float[16];

    @JBindingInclude
    float[] projectionMatrix = new float[16];

    @JBindingInclude
    float[] mvpMatrix = new float[16];

    @JBindingInclude
    private int[] tilsIDs = new int[100];
    private boolean mapEnable = true;
    private int anchorY = 0;
    private boolean isProFunctionAuthEnable = true;
    private boolean isUseProFunction = false;
    private int customBackgroundColor = -1;
    private float mapZoomScale = 1.0f;
    private AtomicInteger changedCounter = new AtomicInteger(0);
    private volatile double changeRatio = 1.0d;
    private volatile double changeGridRatio = 1.0d;
    private int gridX = 0;
    private int gridY = 0;

    public MapConfig(boolean z5) {
        this.lastMapconfig = null;
        if (z5) {
            MapConfig mapConfig = new MapConfig(false);
            this.lastMapconfig = mapConfig;
            mapConfig.setGridXY(0, 0);
            this.lastMapconfig.setSX(0.0d);
            this.lastMapconfig.setSY(0.0d);
            this.lastMapconfig.setSZ(0.0f);
            this.lastMapconfig.setSC(0.0f);
            this.lastMapconfig.setSR(0.0f);
        }
    }

    private void changeRatio() {
        double sx = this.lastMapconfig.getSX();
        double sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc2 = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        this.changeRatio = Math.abs(this.sY - sy) + Math.abs(this.sX - sx);
        this.changeRatio = this.changeRatio == 0.0d ? 1.0d : this.changeRatio * 2.0d;
        this.changeRatio = this.changeRatio * (sz == this.sZ ? 1.0d : Math.abs(sz - r11));
        float f2 = this.sC;
        float abs = sc2 == f2 ? 1.0f : Math.abs(sc2 - f2);
        float f10 = this.sR;
        float abs2 = sr != f10 ? Math.abs(sr - f10) : 1.0f;
        double d5 = abs;
        this.changeRatio *= d5;
        double d8 = abs2;
        this.changeRatio *= d8;
        this.changeGridRatio = (this.lastMapconfig.getGridY() - this.gridY) + Math.abs(this.lastMapconfig.getGridX() - this.gridX);
        this.changeGridRatio = this.changeGridRatio != 0.0d ? this.changeGridRatio * 2.0d : 1.0d;
        this.changeGridRatio *= d5;
        this.changeGridRatio *= d8;
    }

    public void addChangedCounter() {
        this.changedCounter.incrementAndGet();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAbroadState() {
        return this.abroadState;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorX() {
        return this.anchorX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorY() {
        return this.anchorY;
    }

    public double getChangeGridRatio() {
        return this.changeGridRatio;
    }

    public double getChangeRatio() {
        return this.changeRatio;
    }

    public int getChangedCounter() {
        return this.changedCounter.get();
    }

    public int getCustomBackgroundColor() {
        return this.customBackgroundColor;
    }

    public String getCustomStyleID() {
        return this.mCustomStyleID;
    }

    public String getCustomStylePath() {
        return this.mCustomStylePath;
    }

    public String getCustomTextureResourcePath() {
        return this.customTextureResourcePath;
    }

    public Rectangle getGeoRectangle() {
        return this.geoRectangle;
    }

    public int getGridX() {
        return this.gridX;
    }

    public int getGridY() {
        return this.gridY;
    }

    public IPoint[] getLimitIPoints() {
        return this.limitIPoints;
    }

    public LatLngBounds getLimitLatLngBounds() {
        return this.limitLatLngBounds;
    }

    public DPoint getMapGeoCenter() {
        return this.mapGeoCenter;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapHeight() {
        return this.mapHeight;
    }

    public String getMapLanguage() {
        return this.mMapLanguage;
    }

    public int getMapStyleMode() {
        return this.mMapStyleMode;
    }

    public int getMapStyleTime() {
        return this.mMapStyleTime;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapWidth() {
        return this.mapWidth;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMapZoomScale() {
        return this.mapZoomScale;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMaxZoomLevel() {
        return this.maxZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMinZoomLevel() {
        return this.minZoomLevel;
    }

    public float[] getMvpMatrix() {
        return this.mvpMatrix;
    }

    public float[] getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public float getSC() {
        return this.sC;
    }

    public float getSR() {
        return this.sR;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSX() {
        return this.sX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSY() {
        return this.sY;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getSZ() {
        return this.sZ;
    }

    public float getSkyHeight() {
        return this.skyHeight;
    }

    public float[] getViewMatrix() {
        return this.viewMatrix;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isAbroadEnable() {
        return this.isAbroadEnable;
    }

    public boolean isBearingChanged() {
        return this.isBearingChanged;
    }

    public boolean isBuildingEnable() {
        return this.isBuildingEnable;
    }

    public boolean isCustomStyleEnable() {
        return this.isCustomStyleEnabled;
    }

    public boolean isHideLogoEnable() {
        return this.isHideLogoEnable;
    }

    public boolean isIndoorEnable() {
        return this.isIndoorEnable;
    }

    public boolean isMapEnable() {
        return this.mapEnable;
    }

    public boolean isMapStateChange() {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig == null) {
            return false;
        }
        double sx = mapConfig.getSX();
        double sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc2 = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        double d5 = this.sX;
        boolean z5 = true;
        boolean z6 = sx != d5;
        this.isCenterChanged = z6;
        double d8 = this.sY;
        if (sy != d8) {
            z6 = true;
        }
        this.isCenterChanged = z6;
        float f2 = this.sZ;
        boolean z8 = sz != f2;
        this.isZoomChanged = z8;
        if (z8) {
            float f10 = this.minZoomLevel;
            if (sz > f10 && f2 > f10) {
                float f11 = this.maxZoomLevel;
                if (sz < f11 && f2 < f11) {
                    this.isNeedUpdateZoomControllerState = false;
                }
            }
            this.isNeedUpdateZoomControllerState = true;
        }
        boolean z10 = sc2 != this.sC;
        this.isTiltChanged = z10;
        boolean z11 = sr != this.sR;
        this.isBearingChanged = z11;
        if (!z6 && !z8 && !z10 && !z11 && !this.isNeedUpdateMapRectNextFrame) {
            z5 = false;
        }
        if (z5) {
            this.isNeedUpdateMapRectNextFrame = false;
            int i3 = 28 - ((int) f2);
            setGridXY(((int) d5) >> i3, ((int) d8) >> i3);
            changeRatio();
        }
        return z5;
    }

    public boolean isMapTextEnable() {
        return this.isMapTextEnable;
    }

    public boolean isNeedUpdateZoomControllerState() {
        return this.isNeedUpdateZoomControllerState;
    }

    public boolean isProFunctionAuthEnable() {
        return this.isProFunctionAuthEnable;
    }

    public boolean isSetLimitZoomLevel() {
        return this.isSetLimitZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isTerrainEnable() {
        return this.isTerrainEnable;
    }

    public boolean isTiltChanged() {
        return this.isTiltChanged;
    }

    public boolean isTouchPoiEnable() {
        return this.isTouchPoiEnable;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public boolean isUseProFunction() {
        return this.isUseProFunction;
    }

    public boolean isWorldMapEnable() {
        return this.isWorldMapEnable;
    }

    public boolean isZoomChanged() {
        return this.isZoomChanged;
    }

    public void resetChangedCounter() {
        this.changedCounter.set(0);
    }

    public void resetMinMaxZoomPreference() {
        this.minZoomLevel = 3.0f;
        this.maxZoomLevel = 20.0f;
        this.isSetLimitZoomLevel = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadEnable(boolean z5) {
        this.isAbroadEnable = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadState(int i3) {
        this.abroadState = i3;
    }

    public void setAnchorX(int i3) {
        this.anchorX = i3;
    }

    public void setAnchorY(int i3) {
        this.anchorY = i3;
    }

    public void setBuildingEnable(boolean z5) {
        this.isBuildingEnable = z5;
    }

    public void setCustomBackgroundColor(int i3) {
        this.customBackgroundColor = i3;
    }

    public void setCustomStyleEnable(boolean z5) {
        this.isCustomStyleEnabled = z5;
    }

    public void setCustomStyleID(String str) {
        this.mCustomStyleID = str;
    }

    public void setCustomStylePath(String str) {
        this.mCustomStylePath = str;
    }

    public void setCustomTextureResourcePath(String str) {
        this.customTextureResourcePath = str;
    }

    public void setGridXY(int i3, int i10) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setGridXY(this.gridX, this.gridY);
        }
        this.gridX = i3;
        this.gridY = i10;
    }

    public void setHideLogoEnble(boolean z5) {
        this.isHideLogoEnable = z5;
    }

    public void setIndoorEnable(boolean z5) {
        this.isIndoorEnable = z5;
    }

    public void setLimitIPoints(IPoint[] iPointArr) {
        this.limitIPoints = iPointArr;
    }

    public void setLimitLatLngBounds(LatLngBounds latLngBounds) {
        this.limitLatLngBounds = latLngBounds;
        if (latLngBounds == null) {
            resetMinMaxZoomPreference();
        }
    }

    public void setMapEnable(boolean z5) {
        this.mapEnable = z5;
    }

    public void setMapHeight(int i3) {
        this.mapHeight = i3;
    }

    public void setMapLanguage(String str) {
        this.mMapLanguage = str;
    }

    public void setMapStyleMode(int i3) {
        this.mMapStyleMode = i3;
    }

    public void setMapStyleTime(int i3) {
        this.mMapStyleTime = i3;
    }

    public void setMapTextEnable(boolean z5) {
        this.isMapTextEnable = z5;
    }

    public void setMapWidth(int i3) {
        this.mapWidth = i3;
    }

    public void setMapZoomScale(float f2) {
        this.mapZoomScale = f2;
    }

    public void setMaxZoomLevel(float f2) {
        if (f2 > 20.0f) {
            f2 = 20.0f;
        }
        if (f2 < 3.0f) {
            f2 = 3.0f;
        }
        if (f2 < getMinZoomLevel()) {
            f2 = getMinZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = f2;
    }

    public void setMinZoomLevel(float f2) {
        if (f2 < 3.0f) {
            f2 = 3.0f;
        }
        if (f2 > 20.0f) {
            f2 = 20.0f;
        }
        if (f2 > getMaxZoomLevel()) {
            f2 = getMaxZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = f2;
    }

    public void setProFunctionAuthEnable(boolean z5) {
        this.isProFunctionAuthEnable = z5;
    }

    public void setSC(float f2) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSC(this.sC);
        }
        this.sC = f2;
    }

    public void setSR(float f2) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSR(this.sR);
        }
        this.sR = f2;
    }

    public void setSX(double d5) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSX(this.sX);
        }
        this.sX = d5;
        this.mapGeoCenter.f6570x = d5;
    }

    public void setSY(double d5) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSY(this.sY);
        }
        this.sY = d5;
        this.mapGeoCenter.f6570x = d5;
    }

    public void setSZ(float f2) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSZ(this.sZ);
        }
        this.sZ = f2;
    }

    public void setSkyHeight(float f2) {
        this.skyHeight = f2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setTerrainEnable(boolean z5) {
        this.isTerrainEnable = z5;
    }

    public void setTouchPoiEnable(boolean z5) {
        this.isTouchPoiEnable = z5;
    }

    public void setTrafficEnabled(boolean z5) {
        this.isTrafficEnabled = z5;
    }

    public void setUseProFunction(boolean z5) {
        this.isUseProFunction = z5;
    }

    public void setWorldMapEnable(boolean z5) {
        this.isWorldMapEnable = z5;
    }

    public String toString() {
        return " sX: " + this.sX + " sY: " + this.sY + " sZ: " + this.sZ + " sC: " + this.sC + " sR: " + this.sR + " skyHeight: " + this.skyHeight;
    }

    public void updateFinalMatrix() {
        Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
    }

    public void updateMapRectNextFrame(boolean z5) {
        this.isNeedUpdateMapRectNextFrame = z5;
    }
}
