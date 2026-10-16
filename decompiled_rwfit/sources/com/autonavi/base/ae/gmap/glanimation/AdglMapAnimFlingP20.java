package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: classes.dex */
public class AdglMapAnimFlingP20 extends AbstractAdglAnimation {
    private boolean hasCheckParams;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private float velocityScreenX;
    private float velocityScreenY;

    public AdglMapAnimFlingP20(int i3) {
        reset();
        this.duration = i3;
    }

    public void commitAnimation(Object obj) {
        boolean z5;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f2 = this.velocityScreenX;
        float f10 = this.duration;
        float f11 = (f2 * f10) / 2000.0f;
        float f12 = (this.velocityScreenY * f10) / 2000.0f;
        if (Math.abs(f11) == 0.0f || Math.abs(f12) == 0.0f) {
            z5 = true;
        } else {
            this.isOver = false;
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            this.moveParam.setFromValue(((Point) obtain).x, ((Point) obtain).y);
            double mapAngle = (gLMapState.getMapAngle() * 3.141592653589793d) / 180.0d;
            double mapLenWithWin = gLMapState.getMapLenWithWin(1);
            double d5 = f11;
            double d8 = f12;
            this.moveParam.setToValue(((Point) obtain).x - (((Math.cos(mapAngle) * d5) - (Math.sin(mapAngle) * d8)) * mapLenWithWin), ((Point) obtain).y - (((Math.cos(mapAngle) * d8) + (Math.sin(mapAngle) * d5)) * mapLenWithWin));
            this.needMove = this.moveParam.needToCaculate();
            obtain.recycle();
            z5 = true;
        }
        this.hasCheckParams = z5;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
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
        float f2 = uptimeMillis / this.duration;
        if (f2 > 1.0f) {
            this.isOver = true;
            f2 = 1.0f;
        }
        if (f2 < 0.0f || f2 > 1.0f || !this.needMove) {
            return;
        }
        this.moveParam.setNormalizedTime(f2);
        gLMapState.setMapGeoCenter(this.moveParam.getCurXValue(), this.moveParam.getCurYValue());
    }

    public void reset() {
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityScreenX = 0.0f;
        this.velocityScreenY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void setPositionAndVelocity(float f2, float f10) {
        this.moveParam = null;
        this.velocityScreenX = f2;
        this.velocityScreenY = f10;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
