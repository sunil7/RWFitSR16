package com.example.test.ui.testui;

import android.util.Log;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final class j0 implements a7.f, t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingMuslinTargetActivity f8285a;

    public /* synthetic */ j0(TRingMuslinTargetActivity tRingMuslinTargetActivity) {
        this.f8285a = tRingMuslinTargetActivity;
    }

    @Override // a7.f
    public void j(int i3) {
        if (i3 == R$id.barStatusIv) {
            this.f8285a.finish();
        }
    }

    @Override // t6.a
    public void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        TRingMuslinTargetActivity tRingMuslinTargetActivity = this.f8285a;
        Log.d(tRingMuslinTargetActivity.E, "select muslin count = ".concat(data));
        tRingMuslinTargetActivity.F = Integer.valueOf(Integer.parseInt(data));
        ((f6.w0) tRingMuslinTargetActivity.f7247z.getValue()).f13416b.setHintStr(data + " " + tRingMuslinTargetActivity.getString(R$string.str_count));
        com.example.test.presenter.device.u0 u0Var = (com.example.test.presenter.device.u0) tRingMuslinTargetActivity.I0();
        int parseInt = Integer.parseInt(data);
        u0Var.f7485b = Integer.valueOf(parseInt);
        ((XXBaseActivity) ((g7.t) u0Var.f7255a)).V();
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 42);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(parseInt, "getMuslimCountCmdJL "));
        byte[] a3 = y5.b.a(parseInt, 4);
        b3.g((byte) 42, new byte[]{2, 96, 0, a3[0], a3[1], a3[2], a3[3]}, new boolean[0]);
    }
}
