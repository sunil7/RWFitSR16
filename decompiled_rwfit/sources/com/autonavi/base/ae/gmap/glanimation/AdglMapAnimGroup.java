package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: classes.dex */
public class AdglMapAnimGroup extends AbstractAdglAnimation {
    public static final int CAMERA_MAX_DEGREE = 80;
    public static final int CAMERA_MIN_DEGREE = 0;
    public static final int MAXMAPLEVEL = 20;
    public static final int MINMAPLEVEL = 3;
    int endZoomDuration;
    boolean hasCheckParams;
    boolean hasMidZoom;
    int midZoomDuration;
    public boolean needMove;
    boolean needRotateCamera;
    boolean needRotateMap;
    boolean needZoom;
    int startZoomDuration;
    AbstractAdglAnimationParam1V zoomStartParam = null;
    AbstractAdglAnimationParam1V zoomEndParam = null;
    AbstractAdglAnimationParam2V moveParam = null;
    AbstractAdglAnimationParam1V rotateMapParam = null;
    AbstractAdglAnimationParam1V rotateCameraParam = null;

    public AdglMapAnimGroup(int i3) {
        reset();
        this.duration = i3;
    }

    public static boolean checkLevel(float f2) {
        return f2 >= 3.0f && f2 <= 20.0f;
    }

    private void initZoomEndParam(float f2, float f10, int i3) {
        if (this.zoomEndParam == null) {
            this.zoomEndParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomEndParam.reset();
        this.zoomEndParam.setInterpolatorType(i3, 1.0f);
        this.zoomEndParam.setToValue(f10);
        this.zoomEndParam.setFromValue(f2);
    }

    private void initZoomStartParam(float f2, int i3) {
        if (this.zoomStartParam == null) {
            this.zoomStartParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomStartParam.reset();
        this.zoomStartParam.setInterpolatorType(i3, 1.0f);
        this.zoomStartParam.setToValue(f2);
    }

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (this.needZoom) {
            if (this.zoomStartParam == null) {
                this.hasCheckParams = true;
                return;
            }
            float mapZoomer = gLMapState.getMapZoomer();
            this.zoomStartParam.setFromValue(mapZoomer);
            if (this.hasMidZoom) {
                float toValue = this.zoomStartParam.getToValue() - mapZoomer;
                float fromValue = this.zoomEndParam.getFromValue() - this.zoomEndParam.getToValue();
                if (Math.abs(toValue) < 1.0E-6d || Math.abs(fromValue) < 1.0E-6d) {
                    this.hasMidZoom = false;
                    this.zoomStartParam.setToValue(this.zoomEndParam.getToValue());
                    this.zoomStartParam.needToCaculate();
                    this.zoomEndParam = null;
                } else {
                    this.zoomStartParam.needToCaculate();
                    this.zoomEndParam.needToCaculate();
                }
            }
            if (!this.hasMidZoom && Math.abs(this.zoomStartParam.getFromValue() - this.zoomStartParam.getToValue()) < 1.0E-6d) {
                this.needZoom = false;
            }
            if (this.needZoom) {
                if (this.hasMidZoom) {
                    int i3 = (this.duration - this.midZoomDuration) >> 1;
                    this.startZoomDuration = i3;
                    this.endZoomDuration = i3;
                } else {
                    this.startZoomDuration = this.duration;
                }
            }
        }
        if (this.needMove && this.moveParam != null) {
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            int i10 = ((Point) obtain).x;
            int i11 = ((Point) obtain).y;
            obtain.recycle();
            this.moveParam.setFromValue(i10, i11);
            this.needMove = this.moveParam.needToCaculate();
        }
        if (this.needRotateMap && this.rotateMapParam != null) {
            float mapAngle = gLMapState.getMapAngle();
            float toValue2 = this.rotateMapParam.getToValue();
            if (mapAngle > 180.0f && toValue2 == 0.0f) {
                toValue2 = 360.0f;
            }
            float f2 = ((int) toValue2) - ((int) mapAngle);
            if (f2 > 180.0f) {
                toValue2 -= 360.0f;
            } else if (f2 < -180.0f) {
                toValue2 += 360.0f;
            }
            this.rotateMapParam.setFromValue(mapAngle);
            this.rotateMapParam.setToValue(toValue2);
            this.needRotateMap = this.rotateMapParam.needToCaculate();
        }
        if (this.needRotateCamera && this.rotateCameraParam != null) {
            this.rotateCameraParam.setFromValue(gLMapState.getCameraDegree());
            this.needRotateCamera = this.rotateCameraParam.needToCaculate();
        }
        if (this.needMove || this.needZoom || this.needRotateMap || this.needRotateCamera) {
            this.isOver = false;
        } else {
            this.isOver = true;
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        float curValue;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (!this.hasCheckParams) {
            commitAnimation(obj);
        }
        if (this.isOver) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f2 = this.duration;
        if (f2 == 0.0f) {
            this.isOver = true;
            return;
        }
        float f10 = uptimeMillis / f2;
        if (f10 > 1.0f) {
            this.isOver = true;
            f10 = 1.0f;
        } else if (f10 < 0.0f) {
            this.isOver = true;
            return;
        }
        if (this.needZoom) {
            gLMapState.getMapZoomer();
            if (this.hasMidZoom) {
                long j4 = this.offsetTime;
                int i3 = this.startZoomDuration;
                if (j4 <= i3) {
                    this.zoomStartParam.setNormalizedTime(j4 / i3);
                    curValue = this.zoomStartParam.getCurValue();
                } else {
                    int i10 = this.midZoomDuration;
                    if (j4 <= i3 + i10) {
                        curValue = this.zoomStartParam.getToValue();
                    } else {
                        this.zoomEndParam.setNormalizedTime(((j4 - r4) - i10) / this.endZoomDuration);
                        curValue = this.zoomEndParam.getCurValue();
                    }
                }
                if (this.isOver) {
                    curValue = this.zoomEndParam.getToValue();
                }
            } else {
                this.zoomStartParam.setNormalizedTime(f10);
                curValue = this.zoomStartParam.getCurValue();
            }
            gLMapState.setMapZoomer(curValue);
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null && this.needMove) {
            abstractAdglAnimationParam2V.setNormalizedTime(f10);
            int fromXValue = (int) this.moveParam.getFromXValue();
            int fromYValue = (int) this.moveParam.getFromYValue();
            int toXValue = (int) this.moveParam.getToXValue();
            int toYValue = (int) this.moveParam.getToYValue();
            float curMult = this.moveParam.getCurMult();
            gLMapState.setMapGeoCenter(fromXValue + ((int) ((toXValue - fromXValue) * curMult)), fromYValue + ((int) ((toYValue - fromYValue) * curMult)));
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.rotateMapParam;
        if (abstractAdglAnimationParam1V != null && this.needRotateMap) {
            abstractAdglAnimationParam1V.setNormalizedTime(f10);
            gLMapState.setMapAngle((int) this.rotateMapParam.getCurValue());
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V2 == null || !this.needRotateCamera) {
            return;
        }
        abstractAdglAnimationParam1V2.setNormalizedTime(f10);
        gLMapState.setCameraDegree((int) this.rotateCameraParam.getCurValue());
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public boolean isValid() {
        return this.needRotateCamera || this.needRotateMap || this.needMove || this.needZoom;
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.needZoom = false;
        this.needMove = false;
        this.moveParam = null;
        this.needRotateMap = false;
        this.rotateMapParam = null;
        this.hasMidZoom = false;
        this.duration = 0;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomStartParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.zoomEndParam;
        if (abstractAdglAnimationParam1V2 != null) {
            abstractAdglAnimationParam1V2.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V3 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V3 != null) {
            abstractAdglAnimationParam1V3.reset();
        }
    }

    public void setDuration(int i3) {
        this.duration = i3;
    }

    public void setToCameraDegree(float f2, int i3) {
        this.needRotateCamera = false;
        if (f2 > 80.0f || f2 < 0.0f) {
            return;
        }
        this.needRotateCamera = true;
        if (this.rotateCameraParam == null) {
            this.rotateCameraParam = new AbstractAdglAnimationParam1V();
        }
        this.rotateCameraParam.reset();
        this.rotateCameraParam.setInterpolatorType(i3, 1.0f);
        this.rotateCameraParam.setToValue(f2);
    }

    public void setToMapAngle(float f2, int i3) {
        float f10 = f2 % 360.0f;
        this.needRotateMap = true;
        if (this.rotateMapParam == null) {
            this.rotateMapParam = new AbstractAdglAnimationParam1V();
        }
        this.rotateMapParam.reset();
        this.rotateMapParam.setInterpolatorType(i3, 1.0f);
        this.rotateMapParam.setToValue(f10);
    }

    public void setToMapCenterGeo(int i3, int i10, int i11) {
        if (i3 <= 0 || i10 <= 0) {
            return;
        }
        this.needMove = true;
        if (this.moveParam == null) {
            this.moveParam = new AbstractAdglAnimationParam2V();
        }
        this.moveParam.reset();
        this.moveParam.setInterpolatorType(i11, 1.0f);
        this.moveParam.setToValue(i3, i10);
    }

    public void setToMapLevel(float f2, int i3) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (checkLevel(f2)) {
            initZoomStartParam(f2, i3);
        } else {
            this.needZoom = false;
        }
    }

    public boolean typeEqueal(AdglMapAnimGroup adglMapAnimGroup) {
        return this.needRotateCamera == adglMapAnimGroup.needRotateCamera && this.needRotateMap == adglMapAnimGroup.needRotateMap && this.needZoom == adglMapAnimGroup.needZoom && this.needMove == adglMapAnimGroup.needMove;
    }

    public void setToMapLevel(float f2, float f10, int i3) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (i3 > 0 && i3 < this.duration) {
            this.midZoomDuration = i3;
        }
        if (checkLevel(f2) && checkLevel(f10)) {
            this.hasMidZoom = true;
            initZoomStartParam(f10, 0);
            initZoomEndParam(f10, f2, 0);
        } else if (checkLevel(f2)) {
            this.hasMidZoom = false;
            initZoomStartParam(f2, 0);
        } else if (checkLevel(f10)) {
            this.hasMidZoom = false;
            initZoomStartParam(f10, 0);
        } else {
            this.needZoom = false;
        }
    }
}
