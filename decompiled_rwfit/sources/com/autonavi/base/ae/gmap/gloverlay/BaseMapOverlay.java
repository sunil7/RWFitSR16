package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/* loaded from: classes.dex */
public abstract class BaseMapOverlay<T extends GLOverlay, E> implements Serializable {
    private static final long serialVersionUID = 1;
    protected Context mContext;
    protected int mEngineID;
    protected T mGLOverlay;
    protected Vector<E> mItemList;
    protected int mLastFocusedIndex;
    protected IAMapDelegate mMapView;

    public BaseMapOverlay(int i3, Context context, IAMap iAMap) {
        this.mItemList = null;
        this.mEngineID = i3;
        this.mContext = context;
        try {
            this.mMapView = (IAMapDelegate) iAMap;
        } catch (Throwable unused) {
        }
        this.mItemList = new Vector<>();
        iniGLOverlay();
    }

    public abstract void addItem(E e);

    public boolean clear() {
        try {
            this.mItemList.clear();
            clearFocus();
            T t8 = this.mGLOverlay;
            if (t8 == null) {
                return true;
            }
            t8.removeAll();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void clearFocus() {
        this.mLastFocusedIndex = -1;
        this.mGLOverlay.clearFocus();
    }

    public T getGLOverlay() {
        return this.mGLOverlay;
    }

    public final E getItem(int i3) {
        try {
            synchronized (this.mItemList) {
                if (i3 >= 0) {
                    try {
                        if (i3 <= this.mItemList.size() - 1) {
                            return this.mItemList.get(i3);
                        }
                    } finally {
                    }
                }
                return null;
            }
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public List<E> getItems() {
        return this.mItemList;
    }

    public int getSize() {
        return this.mItemList.size();
    }

    public abstract void iniGLOverlay();

    public boolean isClickable() {
        T t8 = this.mGLOverlay;
        if (t8 != null) {
            return t8.isClickable();
        }
        return false;
    }

    public boolean isVisible() {
        T t8 = this.mGLOverlay;
        if (t8 != null) {
            return t8.isVisible();
        }
        return false;
    }

    public void releaseInstance() {
        if (getGLOverlay() != null) {
            IAMapDelegate iAMapDelegate = this.mMapView;
            if (iAMapDelegate != null && iAMapDelegate.isMaploaded()) {
                this.mMapView.removeEngineGLOverlay(this);
            }
            getGLOverlay().releaseInstance();
            this.mGLOverlay = null;
        }
    }

    public boolean removeAll() {
        return clear();
    }

    public void removeItem(int i3) {
        if (i3 >= 0) {
            try {
                if (i3 > this.mItemList.size() - 1) {
                    return;
                }
                if (i3 == this.mLastFocusedIndex) {
                    this.mLastFocusedIndex = -1;
                    clearFocus();
                }
                this.mItemList.remove(i3);
                T t8 = this.mGLOverlay;
                if (t8 != null) {
                    t8.removeItem(i3);
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public abstract void resumeMarker(Bitmap bitmap);

    public void setClickable(boolean z5) {
        T t8 = this.mGLOverlay;
        if (t8 != null) {
            t8.setClickable(z5);
        }
    }

    public abstract void setVisible(boolean z5);

    public void removeItem(E e) {
        if (e == null) {
            return;
        }
        try {
            synchronized (this.mItemList) {
                removeItem(this.mItemList.indexOf(e));
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }
}
