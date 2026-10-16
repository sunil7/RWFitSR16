package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.m9;
import com.amap.api.col.p0003sl.oa;

/* loaded from: classes.dex */
public class na {

    /* renamed from: a, reason: collision with root package name */
    private Context f4708a;

    /* renamed from: b, reason: collision with root package name */
    private m9 f4709b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4710c = true;

    /* renamed from: d, reason: collision with root package name */
    private qa f4711d = new qa("40C27E38DCAD404B5465362914090908");

    public void a(Context context, boolean z5, String str, String str2, String str3, String[] strArr) {
        try {
            m9 a3 = new m9.a(str, str2, str).a(strArr).a(str3).a();
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                this.f4708a = applicationContext;
                this.f4709b = a3;
                this.f4710c = z5;
                this.f4711d.a(applicationContext, a3);
            }
        } catch (a9 unused) {
        }
    }

    public void a(String str, String str2) {
        oa.a.f4778a.a(this.f4708a, str, str2, this.f4711d.a(this.f4708a), this.f4710c, this.f4709b);
    }
}
