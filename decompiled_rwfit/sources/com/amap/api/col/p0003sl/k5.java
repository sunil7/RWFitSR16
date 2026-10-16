package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.AMapEngineUtils;

/* loaded from: classes.dex */
class k5 extends rc {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l5 f4368a;

    public k5(l5 l5Var) {
        this.f4368a = l5Var;
    }

    @Override // com.amap.api.col.p0003sl.rc
    public void runTask() {
        Context context;
        Bitmap bitmap;
        Context context2;
        Context context3;
        Bitmap bitmap2;
        Context context4;
        Context context5;
        this.f4368a.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
        this.f4368a.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
        context = this.f4368a.f4462s;
        if ("".equals(o4.a(context, "amap_web_logo", "md5_day", ""))) {
            bitmap = this.f4368a.f4448c;
            if (bitmap != null) {
                bitmap2 = this.f4368a.f4449d;
                if (bitmap2 != null) {
                    String b3 = e9.b(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME);
                    context4 = this.f4368a.f4462s;
                    o4.b(context4, "amap_web_logo", "md5_day", b3);
                    String b10 = e9.b(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
                    if (!"".equals(b10)) {
                        context5 = this.f4368a.f4462s;
                        o4.b(context5, "amap_web_logo", "md5_night", b10);
                    }
                    this.f4368a.c(true);
                    return;
                }
            }
            context2 = this.f4368a.f4462s;
            o4.b(context2, "amap_web_logo", "md5_day", "0b718b5f291b09d2b62be725dfb977b3");
            context3 = this.f4368a.f4462s;
            o4.b(context3, "amap_web_logo", "md5_night", "4b1405462a5c910de0e0723ffd96c018");
        }
    }
}
