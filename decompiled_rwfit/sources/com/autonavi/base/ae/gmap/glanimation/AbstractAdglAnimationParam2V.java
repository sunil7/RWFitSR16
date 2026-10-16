package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: classes.dex */
public class AbstractAdglAnimationParam2V extends AbstractAdglAnimationParam {
    public double fromXValue;
    public double fromYValue;
    public double toXValue;
    public double toYValue;

    public AbstractAdglAnimationParam2V() {
        reset();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue && this.hasToValue) {
            double d5 = this.toXValue - this.fromXValue;
            double d8 = this.toYValue - this.fromYValue;
            if (Math.abs(d5) > 1.0E-4d || Math.abs(d8) > 1.0E-4d) {
                this.needToCaculate = true;
            }
        }
        this.hasCheckedParam = true;
    }

    public double getCurXValue() {
        double d5 = this.fromXValue;
        return ((this.toXValue - d5) * this.mult) + d5;
    }

    public double getCurYValue() {
        double d5 = this.fromYValue;
        return ((this.toYValue - d5) * this.mult) + d5;
    }

    public double getFromXValue() {
        return this.fromXValue;
    }

    public double getFromYValue() {
        return this.fromYValue;
    }

    public double getToXValue() {
        return this.toXValue;
    }

    public double getToYValue() {
        return this.toYValue;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromXValue = 0.0d;
        this.toXValue = 0.0d;
        this.fromYValue = 0.0d;
        this.toYValue = 0.0d;
    }

    public void setFromValue(double d5, double d8) {
        this.fromXValue = d5;
        this.fromYValue = d8;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(double d5, double d8) {
        this.toXValue = d5;
        this.toYValue = d8;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }
}
