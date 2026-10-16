package com.example.test.presenter.mine;

import com.example.database.table.User;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.test.ui.XXBaseActivity;
import com.example.test.utils.w0;

/* loaded from: classes.dex */
public final class h extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String desc, String str, String str2, String str3) {
        User d5;
        kotlin.jvm.internal.e.f(desc, "desc");
        ((XXBaseActivity) ((h7.d) this.f7255a)).V();
        c6.d dVar = c6.d.f3392c;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        String userId = (kVar == null || (d5 = kVar.d()) == null) ? null : d5.getUserId();
        if (userId == null) {
            userId = "";
        }
        dVar.getClass();
        rg.l<HttpModel<String>> feedback = ((UserApi) dVar.f113a).feedback(desc, "", "", str, str2, str3, userId);
        kotlin.jvm.internal.e.e(feedback, "feedback(...)");
        com.example.baselibrary.utils.b.w(feedback).subscribe(new g(this, ((h7.d) this.f7255a).f0(), w0.d(), 0));
    }
}
