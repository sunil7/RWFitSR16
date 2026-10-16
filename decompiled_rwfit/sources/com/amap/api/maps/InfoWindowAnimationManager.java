package com.amap.api.maps;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;

/* loaded from: classes.dex */
public class InfoWindowAnimationManager {

    /* renamed from: a, reason: collision with root package name */
    IInfoWindowManager f5704a;

    public InfoWindowAnimationManager(IInfoWindowManager iInfoWindowManager) {
        this.f5704a = iInfoWindowManager;
    }

    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
        this.f5704a.setInfoWindowAnimation(animation, animationListener);
    }

    public void setInfoWindowAppearAnimation(Animation animation) {
        this.f5704a.setInfoWindowAppearAnimation(animation);
    }

    public void setInfoWindowBackColor(int i3) {
        this.f5704a.setInfoWindowBackColor(i3);
    }

    public void setInfoWindowBackEnable(boolean z5) {
        this.f5704a.setInfoWindowBackEnable(z5);
    }

    public void setInfoWindowBackScale(float f2, float f10) {
        this.f5704a.setInfoWindowBackScale(f2, f10);
    }

    public void setInfoWindowDisappearAnimation(Animation animation) {
        this.f5704a.setInfoWindowDisappearAnimation(animation);
    }

    public void setInfoWindowMovingAnimation(Animation animation) {
        this.f5704a.setInfoWindowMovingAnimation(animation);
    }

    public void startAnimation() {
        this.f5704a.startAnimation();
    }
}
