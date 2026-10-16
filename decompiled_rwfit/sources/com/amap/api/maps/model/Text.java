package com.amap.api.maps.model;

import android.graphics.Typeface;
import com.amap.api.col.p0003sl.p3;

/* loaded from: classes.dex */
public final class Text {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    private Marker marker;
    private TextOptions textOptions;

    public Text(Marker marker, TextOptions textOptions) {
        this.marker = marker;
        this.textOptions = textOptions;
    }

    private void a() {
        this.marker.setIcon(p3.a(this.textOptions));
    }

    public void destroy() {
        try {
            this.marker.destroy();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof Text) {
                return this.marker.equals(((Text) obj).marker);
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public int getAlignX() {
        try {
            return this.textOptions.getAlignX();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public int getAlignY() {
        try {
            return this.textOptions.getAlignY();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public int getBackgroundColor() {
        try {
            return this.textOptions.getBackgroundColor();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public int getFontColor() {
        try {
            return this.textOptions.getFontColor();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public int getFontSize() {
        try {
            return this.textOptions.getFontSize();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public String getId() {
        try {
            return this.marker.getId();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public Object getObject() {
        return this.marker.getObject();
    }

    public LatLng getPosition() {
        try {
            return this.marker.getPosition();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public float getRotate() {
        return this.marker.getRotateAngle();
    }

    public String getText() {
        try {
            return this.textOptions.getText();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public Typeface getTypeface() {
        try {
            return this.textOptions.getTypeface();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public float getZIndex() {
        return this.marker.getZIndex();
    }

    public int hashCode() {
        return this.marker.hashCode();
    }

    public boolean isVisible() {
        try {
            return this.marker.isVisible();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            this.marker.remove();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setAlign(int i3, int i10) {
        try {
            this.textOptions.align(i3, i10);
            this.marker.setAnchor(p3.a(this.textOptions.getAlignX(), true), p3.a(this.textOptions.getAlignY(), false));
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setBackgroundColor(int i3) {
        try {
            this.textOptions.backgroundColor(i3);
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setFontColor(int i3) {
        try {
            this.textOptions.fontColor(i3);
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setFontSize(int i3) {
        try {
            this.textOptions.fontSize(i3);
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setObject(Object obj) {
        this.marker.setObject(obj);
    }

    public void setPosition(LatLng latLng) {
        try {
            this.marker.setPosition(latLng);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setRotate(float f2) {
        try {
            this.marker.setRotateAngle(f2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setText(String str) {
        try {
            this.textOptions.text(str);
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setTypeface(Typeface typeface) {
        try {
            this.textOptions.typeface(typeface);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setVisible(boolean z5) {
        try {
            this.marker.setVisible(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setZIndex(float f2) {
        this.marker.setZIndex(f2);
    }
}
