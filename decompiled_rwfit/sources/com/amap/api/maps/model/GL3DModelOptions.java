package com.amap.api.maps.model;

import android.util.Pair;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public class GL3DModelOptions extends BaseOptions {

    @JBindingInclude
    private BitmapDescriptor bitmapDescriptor;

    @JBindingInclude
    private LatLng latLng;

    @JBindingInclude
    private String modelData;

    @JBindingInclude
    private float rotate;

    @JBindingInclude
    private String snippet;

    @JBindingInclude
    private String title;
    private List<Float> vertextList = new ArrayList();
    private List<Float> textrueList = new ArrayList();

    @JBindingInclude
    private boolean isModeltUpdate = false;

    @JBindingInclude
    private int fixedLength = 50;

    @JBindingInclude
    private double altitude = 0.0d;

    @JBindingInclude
    private boolean fixedDisplaySizeEnabled = true;

    @JBindingInclude
    private double fixedDisplaySizeX = -1.0d;

    @JBindingInclude
    private double fixedDisplaySizeY = -1.0d;

    @JBindingInclude
    private boolean visibile = true;

    @JBindingInclude
    private int zIndex = 0;

    public GL3DModelOptions() {
        this.type = "GL3DModelOptions";
    }

    public GL3DModelOptions angle(float f2) {
        this.rotate = f2;
        return this;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public float getAngle() {
        return this.rotate;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.bitmapDescriptor;
    }

    public Pair<Double, Double> getFixDisplaySize() {
        return Pair.create(Double.valueOf(this.fixedDisplaySizeX), Double.valueOf(this.fixedDisplaySizeY));
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public int getModelFixedLength() {
        return this.fixedLength;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public List<Float> getTextrue() {
        return this.textrueList;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Float> getVertext() {
        return this.vertextList;
    }

    public int getZIndex() {
        return this.zIndex;
    }

    public boolean isFixedDisplaySizeEnabled() {
        return this.fixedDisplaySizeEnabled;
    }

    public boolean isVisible() {
        return this.visibile;
    }

    public GL3DModelOptions position(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public GL3DModelOptions setAltitude(double d5) {
        this.altitude = d5;
        return this;
    }

    public GL3DModelOptions setFixDisplaySize(double d5, double d8) {
        this.fixedDisplaySizeX = d5;
        this.fixedDisplaySizeY = d8;
        return this;
    }

    public GL3DModelOptions setFixedDisplaySizeEnabled(boolean z5) {
        this.fixedDisplaySizeEnabled = z5;
        return this;
    }

    public GL3DModelOptions setModelFixedLength(int i3) {
        this.fixedLength = i3;
        return this;
    }

    public GL3DModelOptions setVisible(boolean z5) {
        this.visibile = z5;
        return this;
    }

    public GL3DModelOptions setzIndex(int i3) {
        this.zIndex = i3;
        return this;
    }

    public GL3DModelOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public GL3DModelOptions textureDrawable(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public GL3DModelOptions title(String str) {
        this.title = str;
        return this;
    }

    public GL3DModelOptions vertexData(String str) {
        if (str != null && str.length() > 0) {
            this.modelData = str;
            this.isModeltUpdate = true;
        }
        return this;
    }

    public GL3DModelOptions vertexData(List<Float> list, List<Float> list2) {
        this.vertextList = list;
        this.textrueList = list2;
        StringBuilder sb2 = new StringBuilder();
        if (this.vertextList != null) {
            for (int i3 = 0; i3 < this.vertextList.size() - 3; i3 += 3) {
                sb2.append("v ");
                sb2.append(this.vertextList.get(i3));
                sb2.append(" ");
                sb2.append(this.vertextList.get(i3 + 1));
                sb2.append(" ");
                sb2.append(this.vertextList.get(i3 + 2));
                sb2.append("\n");
            }
        }
        if (this.textrueList != null) {
            for (int i10 = 0; i10 < this.textrueList.size() - 2; i10 += 2) {
                sb2.append("vt ");
                sb2.append(this.textrueList.get(i10));
                sb2.append(" ");
                sb2.append(1.0f - this.textrueList.get(i10 + 1).floatValue());
                sb2.append("\n");
            }
        }
        vertexData(sb2.toString());
        return this;
    }
}
