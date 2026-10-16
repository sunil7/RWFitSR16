package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class mc extends nc {

    /* renamed from: b, reason: collision with root package name */
    protected int f4659b;

    /* renamed from: c, reason: collision with root package name */
    protected long f4660c;

    /* renamed from: d, reason: collision with root package name */
    private String f4661d;
    private Context e;

    public mc(Context context, int i3, String str, nc ncVar) {
        super(ncVar);
        this.f4659b = i3;
        this.f4661d = str;
        this.e = context;
    }

    @Override // com.amap.api.col.p0003sl.nc
    public void a(boolean z5) {
        nc ncVar = this.f4715a;
        if (ncVar != null) {
            ncVar.a(z5);
        }
        if (z5) {
            String str = this.f4661d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f4660c = currentTimeMillis;
            Context context = this.e;
            String valueOf = String.valueOf(currentTimeMillis);
            int i3 = ha.f4272c;
            SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
            edit.putString(str, valueOf);
            edit.apply();
        }
    }

    @Override // com.amap.api.col.p0003sl.nc
    public boolean c() {
        if (this.f4660c == 0) {
            String b3 = ha.b(this.e, this.f4661d);
            this.f4660c = TextUtils.isEmpty(b3) ? 0L : Long.parseLong(b3);
        }
        return System.currentTimeMillis() - this.f4660c >= ((long) this.f4659b);
    }
}
