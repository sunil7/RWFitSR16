package com.amap.api.maps;

import com.autonavi.amap.mapcore.interfaces.IUiSettings;

/* loaded from: classes.dex */
public final class UiSettings {
    private final IUiSettings uiSettingsDelegate;

    public UiSettings(IUiSettings iUiSettings) {
        this.uiSettingsDelegate = iUiSettings;
    }

    public float getLogoMarginRate(int i3) {
        try {
            return this.uiSettingsDelegate.getLogoMarginRate(i3);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public int getLogoPosition() {
        try {
            return this.uiSettingsDelegate.getLogoPosition();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public int getZoomPosition() {
        try {
            return this.uiSettingsDelegate.getZoomPosition();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 2;
        }
    }

    public boolean isCompassEnabled() {
        try {
            return this.uiSettingsDelegate.isCompassEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public boolean isGestureScaleByMapCenter() {
        try {
            return this.uiSettingsDelegate.isGestureScaleByMapCenter();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public boolean isIndoorSwitchEnabled() {
        try {
            return this.uiSettingsDelegate.isIndoorSwitchEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public boolean isLogoEnable() {
        try {
            return this.uiSettingsDelegate.isLogoEnable();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.uiSettingsDelegate.isMyLocationButtonEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isRotateGesturesEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public boolean isScaleControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isScaleControlsEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isScrollGesturesEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isTiltGesturesEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomControlsEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomGesturesEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public void setAllGesturesEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setAllGesturesEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setCompassEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setCompassEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setGestureScaleByMapCenter(boolean z5) {
        try {
            this.uiSettingsDelegate.setGestureScaleByMapCenter(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setIndoorSwitchEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setIndoorSwitchEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setLogoBottomMargin(int i3) {
        try {
            this.uiSettingsDelegate.setLogoBottomMargin(i3);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setLogoCenter(int i3, int i10) {
    }

    public void setLogoEnable(boolean z5) {
        try {
            this.uiSettingsDelegate.setLogoEnable(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setLogoLeftMargin(int i3) {
        try {
            this.uiSettingsDelegate.setLogoLeftMargin(i3);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setLogoMarginRate(int i3, float f2) {
        try {
            this.uiSettingsDelegate.setLogoMarginRate(i3, f2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setLogoPosition(int i3) {
        try {
            this.uiSettingsDelegate.setLogoPosition(i3);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setMyLocationButtonEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setMyLocationButtonEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setRotateGesturesEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setRotateGesturesEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setScaleControlsEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setScaleControlsEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setScrollGesturesEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setScrollGesturesEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setTiltGesturesEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setTiltGesturesEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setZoomControlsEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setZoomControlsEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setZoomGesturesEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setZoomGesturesEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setZoomInByScreenCenter(boolean z5) {
        try {
            this.uiSettingsDelegate.setZoomInByScreenCenter(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setZoomPosition(int i3) {
        try {
            this.uiSettingsDelegate.setZoomPosition(i3);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
