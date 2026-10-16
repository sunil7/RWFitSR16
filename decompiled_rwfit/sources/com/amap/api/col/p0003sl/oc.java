package com.amap.api.col.p0003sl;

import android.content.Context;

/* loaded from: classes.dex */
public class oc extends nc {

    /* renamed from: b, reason: collision with root package name */
    private Context f4780b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4781c;

    public oc(Context context, boolean z5) {
        this.f4780b = context;
        this.f4781c = z5;
    }

    @Override // com.amap.api.col.p0003sl.nc
    public boolean c() {
        return f9.g(this.f4780b) == 1 || this.f4781c;
    }
}
