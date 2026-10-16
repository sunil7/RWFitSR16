package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.t3;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.FileUtil;

/* loaded from: classes.dex */
public class u3 extends rc {

    /* renamed from: a, reason: collision with root package name */
    private Context f5128a;

    /* renamed from: b, reason: collision with root package name */
    private t3 f5129b;

    /* renamed from: c, reason: collision with root package name */
    private a4 f5130c;

    /* renamed from: d, reason: collision with root package name */
    private a f5131d;

    public interface a {
    }

    public u3(Context context) {
        this.f5128a = context;
        if (this.f5129b == null) {
            this.f5129b = new t3(context, "");
        }
    }

    public void a() {
        this.f5128a = null;
        if (this.f5129b != null) {
            this.f5129b = null;
        }
    }

    @Override // com.amap.api.col.p0003sl.rc
    public void runTask() {
        String str;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                t3 t3Var = this.f5129b;
                if (t3Var != null) {
                    t3.a c9 = t3Var.c();
                    if (c9 == null || c9.f5076a == null) {
                        str = null;
                    } else {
                        str = FileUtil.getMapBaseStorage(this.f5128a) + "/custom_texture_data";
                        FileUtil.writeDatasToFile(str, c9.f5076a);
                    }
                    a aVar = this.f5131d;
                    if (aVar != null) {
                        ((b0) aVar).a(str, this.f5130c);
                    }
                }
                ka.a(this.f5128a, v4.b());
            }
        } catch (Throwable th2) {
            ka.a(th2, "CustomStyleTask", "download customStyle");
            th2.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.f5131d = aVar;
    }
}
