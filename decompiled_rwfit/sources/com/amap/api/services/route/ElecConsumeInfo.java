package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ElecConsumeInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f6280a;

    /* renamed from: b, reason: collision with root package name */
    private int f6281b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f6282c;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f6283d = new ArrayList();

    public int getConsumeEnergy() {
        return this.f6280a;
    }

    public List<Integer> getLeftEnergy() {
        return this.f6283d;
    }

    public LatLonPoint getRunOutPoint() {
        return this.f6282c;
    }

    public int getRunOutStepIndex() {
        return this.f6281b;
    }

    public void setConsumeEnergy(int i3) {
        this.f6280a = i3;
    }

    public void setLeftEnergy(List<Integer> list) {
        this.f6283d = list;
    }

    public void setRunOutPoint(LatLonPoint latLonPoint) {
        this.f6282c = latLonPoint;
    }

    public void setRunOutStepIndex(int i3) {
        this.f6281b = i3;
    }
}
