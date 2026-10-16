package com.autonavi.base.ae.gmap.style;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class StyleItem {
    public int mainKey;
    private Map<Integer, StyleElement> styleElements = new HashMap();
    private int styleTypeId;
    public int[] subKey;

    public StyleItem(int i3) {
        this.styleTypeId = i3;
    }

    public StyleElement get(int i3) {
        return this.styleElements.get(Integer.valueOf(i3));
    }

    public StyleElement[] getStyleElements() {
        Map<Integer, StyleElement> map = this.styleElements;
        if (map == null || map.size() <= 0) {
            return null;
        }
        return (StyleElement[]) this.styleElements.values().toArray(new StyleElement[this.styleElements.size()]);
    }

    public boolean isValid() {
        return this.styleElements.size() > 0 && this.styleTypeId >= 0;
    }

    public void put(int i3, StyleElement styleElement) {
        this.styleElements.put(Integer.valueOf(i3), styleElement);
    }

    public String toString() {
        return "styleTypeId:" + this.styleTypeId + "\nstyleElements.size :" + this.styleElements.size();
    }
}
