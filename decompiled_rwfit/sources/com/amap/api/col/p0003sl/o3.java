package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* loaded from: classes.dex */
public class o3 implements IInfoWindowAction, IInfoWindowManager {

    /* renamed from: a, reason: collision with root package name */
    private final IGlOverlayLayer f4736a;

    public o3(IGlOverlayLayer iGlOverlayLayer, Context context) {
        this.f4736a = iGlOverlayLayer;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public synchronized void hideInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.f4736a;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "hideInfoWindow", null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean onInfoWindowTap(MotionEvent motionEvent) {
        IGlOverlayLayer iGlOverlayLayer = this.f4736a;
        if (iGlOverlayLayer == null || motionEvent == null) {
            return false;
        }
        Object nativeProperties = iGlOverlayLayer.getNativeProperties("PopupOverlay", "onInfoWindowTap", new Object[]{Double.valueOf(motionEvent.getX()), Double.valueOf(motionEvent.getY())});
        if (nativeProperties instanceof Boolean) {
            return ((Boolean) nativeProperties).booleanValue();
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void redrawInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.f4736a;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "redrawInfoWindow", null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void setInfoWindowAdapterManager(w1 w1Var) {
        synchronized (this) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowAppearAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackColor(int i3) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackEnable(boolean z5) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackScale(float f2, float f10) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowDisappearAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowMovingAnimation(Animation animation) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public synchronized void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void startAnimation() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public synchronized void showInfoWindow(BasePointOverlay basePointOverlay) throws RemoteException {
        IGlOverlayLayer iGlOverlayLayer = this.f4736a;
        if (iGlOverlayLayer != null && basePointOverlay != null) {
            iGlOverlayLayer.getNativeProperties(basePointOverlay.getId(), "showInfoWindow", new Object[]{basePointOverlay.getId()});
        }
    }
}
