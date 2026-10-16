package com.amap.api.maps.model;

import android.util.Pair;
import com.amap.api.col.p0003sl.q5;
import com.amap.api.col.p0003sl.r5;
import com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner;
import java.util.Map;

/* loaded from: classes.dex */
public class RouteOverlay {
    private IRouteOverlayInner mBaseRouteOverlay;

    public enum MapRouteScene {
        NORMAL,
        CHARGE,
        LIMIT,
        CIMMUTE,
        WRONG,
        SHARE,
        HD
    }

    public static class RouteOverlayHighLightParam {
        public int arrowColorNormal;
        public int borderColorHightLight;
        public int borderColorNormal;
        public int fillColorHightLight;
        public int fillColorNormal;
    }

    public RouteOverlay(IRouteOverlayInner iRouteOverlayInner) {
        this.mBaseRouteOverlay = iRouteOverlayInner;
    }

    public void addRouteItem(int i3, r5[] r5VarArr, boolean z5, q5 q5Var, int[] iArr) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.addRouteItem(i3, r5VarArr, z5 ? 1 : 0, q5Var, iArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRouteName() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.addRouteName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pair<Float, Float> getDisplayRange() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return null;
            }
            return iRouteOverlayInner.getDisplayRange();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getOverlayPriority() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                return iRouteOverlayInner.getOverlayProperty();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isVisible() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                return iRouteOverlayInner.isVisible();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeRouteName() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.removeRouteName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setArrow3DTexture(BitmapDescriptor bitmapDescriptor) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setArrow3DTexture(bitmapDescriptor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setArrowFlow(boolean z5) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setArrowFlow(z5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCar2DPosition(int i3, float f2) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setCar2DPosition(i3, f2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDisplayRange(float f2, float f10) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return;
            }
            iRouteOverlayInner.setDisplayRange(f2, f10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHighlightParam(RouteOverlayHighLightParam routeOverlayHighLightParam) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setHighlightParam(routeOverlayHighLightParam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHighlightType(int i3) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setHighlightType(i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLine2DWidth(int i3, int i10) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setLine2DWidth(i3, i10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLineWidthScale(float f2) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setLineWidthScale(f2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOverlayPriority(int i3) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return;
            }
            iRouteOverlayInner.setOverlayProperty(i3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRouteItemParam(r5 r5Var) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setRouteItemParam(r5Var);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSelectStatus(boolean z5) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setSelectStatus(z5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setShowArrow(boolean z5) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setShowArrow(z5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setShowNaviRouteNameCountMap(Map<Integer, Integer> map) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setShowNaviRouteNameCountMap(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVisible(boolean z5) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setVisible(z5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
