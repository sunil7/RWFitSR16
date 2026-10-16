package com.autonavi.base.amap.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class Rectangle {

    @JBindingInclude
    private int beyond180Mode;
    public float bottom;
    public FPoint[] clipMapRect;
    public IPoint[] clipRect;

    @JBindingInclude
    private int[] jniClipRect;
    public float left;
    public Rect rect;
    public float right;
    public float top;

    public Rectangle() {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
    }

    private void updateClipMapRect(int i3, int i10) {
        int i11 = 0;
        if (this.clipMapRect == null) {
            FPoint[] fPointArr = new FPoint[4];
            this.clipMapRect = fPointArr;
            fPointArr[0] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[1] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[2] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[3] = FPoint.obtain(0.0f, 0.0f);
        }
        Rect rect = this.rect;
        if (rect != null) {
            FPoint[] fPointArr2 = this.clipMapRect;
            FPoint fPoint = fPointArr2[0];
            float f2 = rect.left - i3;
            ((PointF) fPoint).x = f2;
            float f10 = rect.top - i10;
            ((PointF) fPoint).y = f10;
            FPoint fPoint2 = fPointArr2[1];
            float f11 = rect.right - i3;
            ((PointF) fPoint2).x = f11;
            ((PointF) fPoint2).y = f10;
            FPoint fPoint3 = fPointArr2[2];
            ((PointF) fPoint3).x = f11;
            float f12 = rect.bottom - i10;
            ((PointF) fPoint3).y = f12;
            FPoint fPoint4 = fPointArr2[3];
            ((PointF) fPoint4).x = f2;
            ((PointF) fPoint4).y = f12;
        }
        if (this.jniClipRect == null) {
            this.jniClipRect = new int[this.clipMapRect.length * 2];
        }
        while (true) {
            FPoint[] fPointArr3 = this.clipMapRect;
            if (i11 >= fPointArr3.length) {
                return;
            }
            int[] iArr = this.jniClipRect;
            int i12 = i11 * 2;
            FPoint fPoint5 = fPointArr3[i11];
            iArr[i12] = (int) ((PointF) fPoint5).x;
            iArr[i12 + 1] = (int) ((PointF) fPoint5).y;
            i11++;
        }
    }

    private void updateClipRect() {
        if (this.clipRect == null) {
            IPoint[] iPointArr = new IPoint[4];
            this.clipRect = iPointArr;
            iPointArr[0] = IPoint.obtain(0, 0);
            this.clipRect[1] = IPoint.obtain(0, 0);
            this.clipRect[2] = IPoint.obtain(0, 0);
            this.clipRect[3] = IPoint.obtain(0, 0);
        }
        Rect rect = this.rect;
        if (rect != null) {
            IPoint[] iPointArr2 = this.clipRect;
            IPoint iPoint = iPointArr2[0];
            int i3 = rect.left;
            ((Point) iPoint).x = i3;
            int i10 = rect.top;
            ((Point) iPoint).y = i10;
            IPoint iPoint2 = iPointArr2[1];
            int i11 = rect.right;
            ((Point) iPoint2).x = i11;
            ((Point) iPoint2).y = i10;
            IPoint iPoint3 = iPointArr2[2];
            ((Point) iPoint3).x = i11;
            int i12 = rect.bottom;
            ((Point) iPoint3).y = i12;
            IPoint iPoint4 = iPointArr2[3];
            ((Point) iPoint4).x = i3;
            ((Point) iPoint4).y = i12;
        }
    }

    public boolean contains(int i3, int i10) {
        Rect rect = this.rect;
        if (rect == null) {
            return false;
        }
        if (rect.contains(i3, i10)) {
            return true;
        }
        if (this.beyond180Mode != 0) {
            return this.rect.contains(i3 - AMapEngineUtils.MAX_P20_WIDTH, i10) || this.rect.contains(i3 + AMapEngineUtils.MAX_P20_WIDTH, i10);
        }
        return false;
    }

    public int getBeyond180Mode() {
        return this.beyond180Mode;
    }

    public FPoint[] getClipMapRect() {
        return this.clipMapRect;
    }

    public IPoint[] getClipRect() {
        return this.clipRect;
    }

    public Rect getRect() {
        return this.rect;
    }

    public boolean isOverlap(Rect rect) {
        Rect rect2 = this.rect;
        if (rect2 != null && rect != null) {
            int width = rect2.width() + rect2.left;
            int i3 = rect.left;
            if (width > i3) {
                int width2 = rect.width() + i3;
                Rect rect3 = this.rect;
                if (width2 > rect3.left) {
                    int height = rect3.height() + rect3.top;
                    int i10 = rect.top;
                    if (height > i10 && rect.height() + i10 > this.rect.top) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void updateRect(Rect rect, int i3, int i10) {
        if (rect != null) {
            this.rect = rect;
            rect.inset((-rect.width()) / 8, (-rect.height()) / 8);
            float f2 = r4.left / 100000.0f;
            int i11 = this.rect.right;
            if ((i11 / 100000.0f) * f2 < 0.0f) {
                this.beyond180Mode = -1;
            } else if (i11 > 268435456) {
                this.beyond180Mode = 1;
            } else {
                this.beyond180Mode = 0;
            }
            updateClipRect();
            updateClipMapRect(i3, i10);
        }
    }

    public boolean contains(IPoint iPoint) {
        if (iPoint == null) {
            return false;
        }
        return contains(((Point) iPoint).x, ((Point) iPoint).y);
    }

    public boolean isOverlap(int i3, int i10, int i11, int i12) {
        Rect rect = this.rect;
        if (rect == null) {
            return false;
        }
        if (rect.width() + rect.left > i3) {
            int i13 = i3 + i11;
            Rect rect2 = this.rect;
            if (i13 > rect2.left) {
                if (rect2.height() + rect2.top > i10 && i10 + i12 > this.rect.top) {
                    return true;
                }
            }
        }
        return false;
    }

    public Rectangle(Rect rect, int i3, int i10) {
        new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        this.rect = rect;
        if (rect != null) {
            updateRect(rect, i3, i10);
            updateClipRect();
            updateClipMapRect(rect.centerX(), rect.centerY());
        }
    }

    public boolean contains(Rect rect) {
        if (rect == null) {
            return false;
        }
        return this.rect.contains(rect);
    }

    public Rectangle(float f2, float f10, float f11, float f12) {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        if (f2 >= f10 || f12 <= f11) {
            return;
        }
        this.left = f2;
        this.right = f10;
        this.top = f12;
        this.bottom = f11;
    }
}
