package com.amap.api.maps.model;

/* loaded from: classes.dex */
public class AMapCameraInfo {
    private float aspectRatio;
    private float fov;
    private float positionX;
    private float positionY;
    private float positionZ;
    private float rotate;

    public AMapCameraInfo(float f2, float f10, float f11, float f12, float f13, float f14) {
        this.fov = f2;
        this.aspectRatio = f10;
        this.rotate = f11;
        this.positionX = f12;
        this.positionY = f13;
        this.positionZ = f14;
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public float getFov() {
        return this.fov;
    }

    public float getRotate() {
        return this.rotate;
    }

    public float getX() {
        return this.positionX;
    }

    public float getY() {
        return this.positionY;
    }

    public float getZ() {
        return this.positionZ;
    }

    public String toString() {
        return "[fov:" + this.fov + " aspectRatio:" + this.aspectRatio + " rotate:" + this.rotate + " pos_x:" + this.positionX + " pos_y:" + this.positionY + " pos_z:" + this.positionZ + "]";
    }
}
