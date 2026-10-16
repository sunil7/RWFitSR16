package com.example.test.ui.testui;

import android.text.TextUtils;
import android.util.Log;
import com.example.database.table.User;
import com.example.test.R$id;
import f6.y1;

/* loaded from: classes.dex */
public final class t0 implements a7.f, t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingSleepTargetActivity f8314a;

    public /* synthetic */ t0(TRingSleepTargetActivity tRingSleepTargetActivity) {
        this.f8314a = tRingSleepTargetActivity;
    }

    @Override // a7.f
    public void j(int i3) {
        if (i3 == R$id.barStatusIv) {
            Log.d("tong", "click menu");
            this.f8314a.finish();
        }
    }

    @Override // t6.a
    public void v(String data) {
        User d5;
        kotlin.jvm.internal.e.f(data, "data");
        Log.d(this.f8314a.E, "select sleep time = ".concat(data));
        TRingSleepTargetActivity tRingSleepTargetActivity = this.f8314a;
        tRingSleepTargetActivity.getClass();
        int i3 = 0;
        int i10 = 0;
        for (String str : kotlin.text.m.u(data, new String[]{"H"})) {
            Log.d(tRingSleepTargetActivity.E, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("part = ", str));
            if (TextUtils.isDigitsOnly(str)) {
                if (str.length() > 0 && kotlin.text.m.B(str).toString().length() > 0) {
                    i3 = Integer.parseInt(str);
                }
            } else if (!str.equals("")) {
                i10 = Integer.parseInt(kotlin.text.m.r(str, "M", ""));
            }
        }
        int i11 = (i3 * 60) + i10;
        Log.d(this.f8314a.E, "SAVE sleep time = " + i11);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null && (d5 = kVar.d()) != null) {
            kVar.M(Integer.valueOf(i11), android.support.v4.media.session.e.l(d5.getUserId(), "sleep_time_target"));
        }
        ((y1) this.f8314a.f7247z.getValue()).f13461b.setHintStr(data);
    }
}
