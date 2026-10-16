package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.AVectorCrossAttr;

/* loaded from: classes.dex */
public class CrossOverlay {
    public static final int UPDATE_TYPE_DATA = 0;

    /* renamed from: a, reason: collision with root package name */
    ICrossVectorOverlay f5729a;

    public interface GenerateCrossImageListener {
        void onGenerateComplete(Bitmap bitmap, int i3);
    }

    public interface OnCrossVectorUpdateListener {
        void onUpdate(int i3, UpdateItem updateItem);
    }

    public static class UpdateItem {
        public int dataUpdateFlag = -1;
    }

    public CrossOverlay(CrossOverlayOptions crossOverlayOptions, ICrossVectorOverlay iCrossVectorOverlay) {
        this.f5729a = iCrossVectorOverlay;
    }

    public void remove() {
        ICrossVectorOverlay iCrossVectorOverlay = this.f5729a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.remove();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        try {
            this.f5729a.setAttribute(aVectorCrossAttr);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public int setData(byte[] bArr) {
        ICrossVectorOverlay iCrossVectorOverlay;
        if (bArr == null || (iCrossVectorOverlay = this.f5729a) == null) {
            return 0;
        }
        try {
            iCrossVectorOverlay.setData(bArr);
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public void setGenerateCrossImageListener(GenerateCrossImageListener generateCrossImageListener) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f5729a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setGenerateCrossImageListener(generateCrossImageListener);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void setImageMode(boolean z5) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f5729a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setImageMode(z5);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void setOnCrossVectorUpdateListener(OnCrossVectorUpdateListener onCrossVectorUpdateListener) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f5729a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setOnCrossVectorUpdateListener(onCrossVectorUpdateListener);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void setVisible(boolean z5) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f5729a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setVisible(z5);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }
}
