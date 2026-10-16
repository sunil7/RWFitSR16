package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
public class a5 implements z4 {
    @Override // com.amap.api.col.p0003sl.z4
    public void a(int i3, String str, String str2) {
        if (i3 == 0) {
            q9.a(v4.b()).a(p9.b(str, str2));
        } else {
            q9.a(v4.b()).a(p9.a(str, str2));
        }
    }

    @Override // com.amap.api.col.p0003sl.z4
    public void flush() {
        try {
            q9.a(v4.b()).e();
        } catch (Throwable unused) {
        }
    }
}
