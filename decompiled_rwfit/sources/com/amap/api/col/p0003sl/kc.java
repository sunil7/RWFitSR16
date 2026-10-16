package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class kc extends nc {

    /* renamed from: c, reason: collision with root package name */
    private Context f4437c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4438d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f4439f;

    /* renamed from: b, reason: collision with root package name */
    private String f4436b = "iKey";

    /* renamed from: g, reason: collision with root package name */
    private int f4440g = 0;

    public kc(Context context, boolean z5, int i3, int i10, String str) {
        a(context, z5, i3, i10, str, 0);
    }

    private void a(Context context, boolean z5, int i3, int i10, String str, int i11) {
        this.f4437c = context;
        this.f4438d = z5;
        this.e = i3;
        this.f4439f = i10;
        this.f4436b = str;
        this.f4440g = i11;
    }

    @Override // com.amap.api.col.p0003sl.nc
    public boolean c() {
        if (f9.g(this.f4437c) == 1) {
            return true;
        }
        if (!this.f4438d) {
            return false;
        }
        String b3 = ha.b(this.f4437c, this.f4436b);
        if (TextUtils.isEmpty(b3)) {
            return true;
        }
        String[] split = b3.split("\\|");
        if (split != null && split.length >= 2) {
            return !n9.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f4439f;
        }
        Context context = this.f4437c;
        String str = this.f4436b;
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
        return true;
    }

    public kc(Context context, boolean z5, int i3, int i10, String str, int i11) {
        a(context, z5, i3, i10, str, i11);
    }

    @Override // com.amap.api.col.p0003sl.nc
    public int a() {
        int i3;
        if ((f9.g(this.f4437c) == 1 || (i3 = this.e) <= 0) && ((i3 = this.f4440g) <= 0 || i3 >= Integer.MAX_VALUE)) {
            i3 = Integer.MAX_VALUE;
        }
        nc ncVar = this.f4715a;
        return ncVar != null ? Math.max(i3, ncVar.a()) : i3;
    }

    @Override // com.amap.api.col.p0003sl.nc
    public void a(int i3) {
        if (f9.g(this.f4437c) == 1) {
            return;
        }
        String a3 = n9.a(System.currentTimeMillis(), "yyyyMMdd");
        String b3 = ha.b(this.f4437c, this.f4436b);
        if (!TextUtils.isEmpty(b3)) {
            String[] split = b3.split("\\|");
            if (split != null && split.length >= 2) {
                if (a3.equals(split[0])) {
                    i3 += Integer.parseInt(split[1]);
                }
            } else {
                Context context = this.f4437c;
                String str = this.f4436b;
                SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
                edit.remove(str);
                edit.apply();
            }
        }
        Context context2 = this.f4437c;
        String str2 = this.f4436b;
        String str3 = a3 + "|" + i3;
        SharedPreferences.Editor edit2 = context2.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit2.putString(str2, str3);
        edit2.apply();
    }
}
