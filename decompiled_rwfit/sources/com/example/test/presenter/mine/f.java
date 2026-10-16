package com.example.test.presenter.mine;

import com.example.database.table.User;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.test.presenter.main.d0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.mine.activity.AccountValidateActivity;
import com.example.test.utils.w0;

/* loaded from: classes.dex */
public final class f extends com.example.baselibrary.preseneter.b {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7591b;

    public f(AccountValidateActivity accountValidateActivity) {
        super(accountValidateActivity);
        this.f7591b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.mine.AccountValidatePresenter$bindInfoCallback$2
            @Override // oh.a
            public final c invoke() {
                return new c();
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k() {
        ((XXBaseActivity) ((h7.c) this.f7255a)).b0();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.f0();
        }
        com.example.test.service.e.h().q();
    }

    public final void l(int i3, String account) {
        kotlin.jvm.internal.e.f(account, "account");
        Object obj = (h7.c) this.f7255a;
        ((XXBaseActivity) obj).V();
        c6.d dVar = c6.d.f3392c;
        dVar.getClass();
        rg.l<HttpModel<Object>> sendVerifyCode = ((UserApi) dVar.f113a).sendVerifyCode(account, i3);
        kotlin.jvm.internal.e.e(sendVerifyCode, "sendVerifyCode(...)");
        rg.l w8 = com.example.baselibrary.utils.b.w(sendVerifyCode);
        AccountValidateActivity accountValidateActivity = (AccountValidateActivity) obj;
        accountValidateActivity.getClass();
        w8.subscribe(new d(this, accountValidateActivity, w0.d(), 5));
    }

    public final void m(User user, Integer num) {
        c6.d dVar = c6.d.f3392c;
        String name = user.getName();
        if (name == null) {
            name = "";
        }
        String birthday = user.getBirthday();
        if (birthday == null) {
            birthday = "";
        }
        String valueOf = String.valueOf(user.getSex());
        if (valueOf == null) {
            valueOf = "";
        }
        String valueOf2 = String.valueOf(user.getHeight());
        if (valueOf2 == null) {
            valueOf2 = "";
        }
        String valueOf3 = String.valueOf(user.getWeight());
        if (valueOf3 == null) {
            valueOf3 = "";
        }
        String avatar = user.getAvatar();
        rg.l e = dVar.e(name, birthday, valueOf, valueOf2, valueOf3, avatar != null ? avatar : "", String.valueOf(user.getStepsTarget()));
        AccountValidateActivity accountValidateActivity = (AccountValidateActivity) ((h7.c) this.f7255a);
        accountValidateActivity.getClass();
        e.subscribe(new d0(this, num, accountValidateActivity, w0.d(), 2));
    }
}
