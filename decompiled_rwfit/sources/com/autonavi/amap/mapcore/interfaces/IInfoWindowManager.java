package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;

/* loaded from: classes.dex */
public interface IInfoWindowManager {
    void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener);

    void setInfoWindowAppearAnimation(Animation animation);

    void setInfoWindowBackColor(int i3);

    void setInfoWindowBackEnable(boolean z5);

    void setInfoWindowBackScale(float f2, float f10);

    void setInfoWindowDisappearAnimation(Animation animation);

    void setInfoWindowMovingAnimation(Animation animation);

    void startAnimation();
}
