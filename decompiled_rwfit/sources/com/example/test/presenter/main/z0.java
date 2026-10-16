package com.example.test.presenter.main;

import com.example.database.table.User;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.SwitchBean;
import com.example.network.bean.UserInfoBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class z0 extends com.example.baselibrary.preseneter.b {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f7585d;
    public static boolean e;

    /* renamed from: b, reason: collision with root package name */
    public long f7586b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7587c;

    public z0(final e7.b bVar) {
        super(bVar);
        this.f7587c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.MainPresenter$sportCallback$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // oh.a
            public final y0 invoke() {
                return new y0(e7.b.this, this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(int i3, boolean z5) {
        String birthday;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        SwitchBean switchBean = null;
        User d5 = kVar != null ? kVar.d() : null;
        if (!z5 && d5 != null && (birthday = d5.getBirthday()) != null && birthday.length() != 0) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            if (kVar2 != null) {
                ArrayList w8 = kVar2.w();
                int size = w8.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    Object obj = w8.get(i10);
                    i10++;
                    if (kotlin.jvm.internal.e.a(((SwitchBean) obj).getParaName(), "isPerson")) {
                        switchBean = obj;
                        break;
                    }
                }
                switchBean = switchBean;
            }
            if (switchBean != null && kotlin.jvm.internal.e.a(switchBean.getParaValue(), "0")) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "MainPresenter", "隐私开关个人信息已关闭");
                return;
            }
        }
        if (d5 != null) {
            ((e7.b) this.f7255a).i(d5);
        }
        rg.l<HttpModel<UserInfoBean>> userInfo = ((UserApi) c6.d.f3392c.f113a).getUserInfo();
        kotlin.jvm.internal.e.e(userInfo, "getUserInfo(...)");
        com.example.baselibrary.utils.b.w(userInfo).subscribe(new com.example.test.presenter.device.t(i3, d5, this, ((e7.b) this.f7255a).f0(), com.example.test.utils.w0.d(), 1));
    }

    public final void l() {
        com.example.baselibrary.utils.b.y(new oh.l() { // from class: com.example.test.presenter.main.MainPresenter$initPrivacy$1
            @Override // oh.l
            public final List<SwitchBean> invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    return kVar.w();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.MainPresenter$initPrivacy$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends SwitchBean>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<? extends SwitchBean> list) {
                if (list != null) {
                    z0.this.getClass();
                }
            }
        });
    }
}
