package com.example.test.ui.testui;

import android.util.Log;
import com.example.database.table.User;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.test.R$id;
import com.example.test.R$string;
import f6.n2;

/* loaded from: classes.dex */
public final class o0 implements t6.a, a7.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8298a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TRingSetpTargetActivity f8299b;

    public /* synthetic */ o0(TRingSetpTargetActivity tRingSetpTargetActivity, int i3) {
        this.f8298a = i3;
        this.f8299b = tRingSetpTargetActivity;
    }

    @Override // a7.f
    public void j(int i3) {
        if (i3 == R$id.barStatusIv) {
            Log.d("tong", "click menu");
            this.f8299b.finish();
        }
    }

    @Override // t6.a
    public void v(String data) {
        User d5;
        User d8;
        User d10;
        switch (this.f8298a) {
            case 0:
                kotlin.jvm.internal.e.f(data, "data");
                int parseInt = Integer.parseInt(kotlin.text.m.r(data, "KCAL", ""));
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null && (d5 = kVar.d()) != null) {
                    kVar.M(Integer.valueOf(parseInt), android.support.v4.media.session.e.l(d5.getUserId(), "calu_num_target"));
                }
                TRingSetpTargetActivity tRingSetpTargetActivity = this.f8299b;
                int i3 = TRingSetpTargetActivity.L;
                ((n2) tRingSetpTargetActivity.f7247z.getValue()).f13142b.setHintStr(data);
                return;
            case 1:
                kotlin.jvm.internal.e.f(data, "data");
                String string = this.f8299b.getString(R$string.str_km);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                User d11 = kVar2 != null ? kVar2.d() : null;
                if (d11 != null) {
                    TRingSetpTargetActivity tRingSetpTargetActivity2 = this.f8299b;
                    if (d11.getMeterUnit() == 0) {
                        string = tRingSetpTargetActivity2.getString(R$string.str_km);
                        kotlin.jvm.internal.e.e(string, "getString(...)");
                    } else {
                        string = tRingSetpTargetActivity2.getString(R$string.str_mile);
                        kotlin.jvm.internal.e.e(string, "getString(...)");
                    }
                }
                float parseFloat = Float.parseFloat(kotlin.text.m.r(data, string, ""));
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                if (kVar3 != null && (d8 = kVar3.d()) != null) {
                    kVar3.M(Float.valueOf(parseFloat), android.support.v4.media.session.e.l(d8.getUserId(), "dist_num_target"));
                }
                ((n2) this.f8299b.f7247z.getValue()).f13143c.setHintStr(data);
                return;
            default:
                kotlin.jvm.internal.e.f(data, "data");
                String string2 = this.f8299b.getString(R$string.str_unit_step);
                kotlin.jvm.internal.e.e(string2, "getString(...)");
                long parseLong = Long.parseLong(kotlin.text.m.r(data, string2, ""));
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                if (kVar4 != null && (d10 = kVar4.d()) != null) {
                    kVar4.M(Long.valueOf(parseLong), android.support.v4.media.session.e.l(d10.getUserId(), "step_num_target"));
                }
                ((n2) this.f8299b.f7247z.getValue()).f13144d.setHintStr(data);
                ((com.example.test.presenter.main.k) this.f8299b.I0()).getClass();
                try {
                    c6.d dVar = c6.d.f3392c;
                    String sportTarget = String.valueOf(parseLong);
                    dVar.getClass();
                    kotlin.jvm.internal.e.f(sportTarget, "sportTarget");
                    rg.l<HttpModel<String>> updateUserInfo = ((UserApi) dVar.f113a).updateUserInfo(null, null, null, null, null, null, sportTarget);
                    kotlin.jvm.internal.e.e(updateUserInfo, "updateUserInfo(...)");
                    com.example.baselibrary.utils.b.u(updateUserInfo).blockingSubscribe();
                    return;
                } catch (Exception e) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "保存目标步数", e.getMessage());
                    return;
                }
        }
    }
}
