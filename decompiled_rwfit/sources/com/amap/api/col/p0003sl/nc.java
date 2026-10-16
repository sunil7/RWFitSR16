package com.amap.api.col.p0003sl;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public abstract class nc {

    /* renamed from: a, reason: collision with root package name */
    nc f4715a;

    public nc() {
    }

    public void a(boolean z5) {
        nc ncVar = this.f4715a;
        if (ncVar != null) {
            ncVar.a(z5);
        }
    }

    public boolean b() {
        nc ncVar = this.f4715a;
        if (ncVar != null ? ncVar.b() : true) {
            return c();
        }
        return false;
    }

    public abstract boolean c();

    public nc(nc ncVar) {
        this.f4715a = ncVar;
    }

    public int a() {
        nc ncVar = this.f4715a;
        return Math.min(SubsamplingScaleImageView.TILE_SIZE_AUTO, ncVar != null ? ncVar.a() : Integer.MAX_VALUE);
    }

    public void a(int i3) {
        nc ncVar = this.f4715a;
        if (ncVar != null) {
            ncVar.a(i3);
        }
    }
}
