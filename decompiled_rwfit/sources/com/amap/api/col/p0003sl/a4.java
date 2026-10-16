package com.amap.api.col.p0003sl;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class a4 {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, StyleItem> f3597a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private StyleItem[] f3598b;

    public StyleItem[] a() {
        Map<Integer, StyleItem> map = this.f3597a;
        if (map != null && map.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (StyleItem styleItem : this.f3597a.values()) {
                if (styleItem.isValid()) {
                    arrayList.add(styleItem);
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                StyleItem[] styleItemArr = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
                this.f3598b = styleItemArr;
                return styleItemArr;
            }
        }
        return null;
    }

    public StyleItem[] b() {
        return this.f3598b;
    }

    public Map<Integer, StyleItem> c() {
        return this.f3597a;
    }
}
