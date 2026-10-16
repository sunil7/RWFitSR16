package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: classes.dex */
public abstract class AbstractAdglAnimationParam {
    protected float mult;
    protected float normalizedTime;
    protected int interpolationType = 0;
    protected float factor = 1.0f;
    protected boolean hasCheckedParam = false;
    protected boolean needToCaculate = false;
    protected boolean hasFromValue = false;
    protected boolean hasToValue = false;

    public static float bounce(float f2) {
        return f2 * f2 * 8.0f;
    }

    public abstract void checkParam();

    public float getCurMult() {
        return this.mult;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public boolean needToCaculate() {
        if (!this.hasCheckedParam) {
            checkParam();
        }
        return this.hasCheckedParam && this.needToCaculate;
    }

    public void reset() {
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public void setInterpolatorType(int i3, float f2) {
        this.interpolationType = i3;
        this.factor = f2;
    }

    public void setNormalizedTime(float f2) {
        double pow;
        float bounce;
        float f10;
        this.normalizedTime = f2;
        switch (this.interpolationType) {
            case 0:
                break;
            case 1:
                pow = Math.pow(f2, this.factor * 2.0f);
                f2 = (float) pow;
                break;
            case 2:
                if (this.factor != 1.0f) {
                    f2 = (float) (1.0d - Math.pow(1.0f - f2, r0 * 2.0f));
                    break;
                } else {
                    float f11 = 1.0f - f2;
                    f2 = 1.0f - (f11 * f11);
                    break;
                }
            case 3:
                pow = (Math.cos((f2 + 1.0f) * 3.141592653589793d) / 2.0d) + 0.5d;
                f2 = (float) pow;
                break;
            case 4:
                float f12 = f2 * 1.1226f;
                if (f12 >= 0.3535f) {
                    if (f12 < 0.7408f) {
                        bounce = bounce(f12 - 0.54719f);
                        f10 = 0.7f;
                    } else if (f12 < 0.9644f) {
                        bounce = bounce(f12 - 0.8526f);
                        f10 = 0.9f;
                    } else {
                        bounce = bounce(f12 - 1.0435f);
                        f10 = 0.95f;
                    }
                    f2 = bounce + f10;
                    break;
                } else {
                    f2 = bounce(f12);
                    break;
                }
            case 5:
                float f13 = f2 - 1.0f;
                f2 = (((f13 * 3.0f) + 2.0f) * f13 * f13) + 1.0f;
                break;
            case 6:
                if (f2 >= 0.0f) {
                    if (f2 >= 0.25f) {
                        if (f2 >= 0.5f) {
                            if (f2 >= 0.75f) {
                                if (f2 <= 1.0f) {
                                    f2 = 4.0f - (f2 * 4.0f);
                                    break;
                                }
                            } else {
                                f2 = (f2 * 4.0f) - 2.0f;
                                break;
                            }
                        } else {
                            f2 = 2.0f - (f2 * 4.0f);
                            break;
                        }
                    } else {
                        f2 *= 4.0f;
                        break;
                    }
                }
            default:
                f2 = 0.0f;
                break;
        }
        this.mult = f2;
    }
}
