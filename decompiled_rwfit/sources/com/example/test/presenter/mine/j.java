package com.example.test.presenter.mine;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.example.database.table.User;
import com.example.network.base.HttpModel;
import com.example.network.bean.LoginResultBean;
import com.example.test.presenter.main.d0;
import com.example.test.ui.mine.activity.LoginActivity;
import com.example.test.ui.mine.model.WxLoginInfoBean;
import com.example.test.utils.w0;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class j extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7595d;
    public final /* synthetic */ k e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(k kVar, Context context, w0 w0Var, int i3) {
        super(context, w0Var);
        this.f7595d = i3;
        this.e = kVar;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7595d) {
            case 0:
                ((LoginActivity) ((h7.f) this.e.f7255a)).T0(i3);
                break;
            default:
                ((LoginActivity) ((h7.f) this.e.f7255a)).T0(i3);
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        switch (this.f7595d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                if (httpModel != null) {
                    k kVar = this.e;
                    Boolean isSuccess = httpModel.isSuccess();
                    kotlin.jvm.internal.e.e(isSuccess, "isSuccess(...)");
                    if (!isSuccess.booleanValue()) {
                        ((LoginActivity) ((h7.f) kVar.f7255a)).T0(httpModel.getCode());
                        return;
                    }
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    if (kVar2 != null) {
                        String accessToken = ((LoginResultBean) httpModel.getResults()).getAccessToken();
                        kotlin.jvm.internal.e.e(accessToken, "getAccessToken(...)");
                        kVar2.M(accessToken, "user_login_token");
                    }
                    if (d6.a.f12304c == null) {
                        synchronized (d6.a.class) {
                            d6.a.f12304c = new d6.a();
                        }
                    }
                    d6.a aVar = d6.a.f12304c;
                    if (aVar != null) {
                        aVar.f12306b = ((LoginResultBean) httpModel.getResults()).getAccessToken();
                    }
                    if (d6.a.f12304c == null) {
                        synchronized (d6.a.class) {
                            d6.a.f12304c = new d6.a();
                        }
                    }
                    d6.a aVar2 = d6.a.f12304c;
                    if (aVar2 != null) {
                        aVar2.f12305a = 0;
                    }
                    w0.d().f8766a = false;
                    User user = new User();
                    user.setUserId(((LoginResultBean) httpModel.getResults()).getMemberId());
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(1, 1990);
                    calendar.set(2, 0);
                    calendar.set(5, 1);
                    user.setBirthday(String.valueOf(calendar.getTimeInMillis() / 1000));
                    user.setWeight(60.0d);
                    user.setStepsTarget(Const.I_GEO_MAX_TIME);
                    user.setHeight(170.0d);
                    user.setSex(1);
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                    if (kVar3 != null) {
                        kVar3.G(user);
                    }
                    LoginActivity loginActivity = (LoginActivity) ((h7.f) kVar.f7255a);
                    loginActivity.getClass();
                    com.example.test.service.e.h().m();
                    loginActivity.b0();
                    loginActivity.S0(0);
                    loginActivity.finish();
                    return;
                }
                return;
            default:
                HttpModel httpModel2 = (HttpModel) obj;
                if (httpModel2 != null) {
                    k kVar4 = this.e;
                    Boolean isSuccess2 = httpModel2.isSuccess();
                    kotlin.jvm.internal.e.e(isSuccess2, "isSuccess(...)");
                    if (!isSuccess2.booleanValue()) {
                        ((LoginActivity) ((h7.f) kVar4.f7255a)).T0(httpModel2.getCode());
                        return;
                    }
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar5 = com.example.test.utils.k.f8731b;
                    if (kVar5 != null) {
                        String accessToken2 = ((LoginResultBean) httpModel2.getResults()).getAccessToken();
                        kotlin.jvm.internal.e.e(accessToken2, "getAccessToken(...)");
                        kVar5.M(accessToken2, "user_login_token");
                    }
                    if (d6.a.f12304c == null) {
                        synchronized (d6.a.class) {
                            d6.a.f12304c = new d6.a();
                        }
                    }
                    d6.a aVar3 = d6.a.f12304c;
                    if (aVar3 != null) {
                        aVar3.f12306b = ((LoginResultBean) httpModel2.getResults()).getAccessToken();
                    }
                    if (d6.a.f12304c == null) {
                        synchronized (d6.a.class) {
                            d6.a.f12304c = new d6.a();
                        }
                    }
                    d6.a aVar4 = d6.a.f12304c;
                    if (aVar4 != null) {
                        aVar4.f12305a = 1;
                    }
                    User user2 = new User();
                    user2.setUserId(((LoginResultBean) httpModel2.getResults()).getMemberId());
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar6 = com.example.test.utils.k.f8731b;
                    if (kVar6 != null) {
                        kVar6.G(user2);
                    }
                    w0.d().f8766a = false;
                    LoginActivity loginActivity2 = (LoginActivity) ((h7.f) kVar4.f7255a);
                    WxLoginInfoBean wxLoginInfoBean = loginActivity2.H;
                    if (wxLoginInfoBean == null) {
                        loginActivity2.b0();
                        loginActivity2.S0(1);
                        loginActivity2.finish();
                        return;
                    }
                    k kVar7 = (k) loginActivity2.I0();
                    kVar7.getClass();
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar8 = com.example.test.utils.k.f8731b;
                    User d5 = kVar8 != null ? kVar8.d() : null;
                    if (d5 != null) {
                        d5.setSex(wxLoginInfoBean.getGenderType() == 2 ? 1 : 2);
                        d5.setName(wxLoginInfoBean.getUserNickName());
                        d5.setAvatar(wxLoginInfoBean.getUserAvatar());
                        Calendar calendar2 = Calendar.getInstance();
                        String year = wxLoginInfoBean.getYear();
                        kotlin.jvm.internal.e.e(year, "getYear(...)");
                        calendar2.set(1, Integer.parseInt(year));
                        calendar2.set(2, 0);
                        calendar2.set(5, 1);
                        String birthday = d5.getBirthday();
                        if (birthday == null) {
                            birthday = String.valueOf(calendar2.getTimeInMillis() / 1000);
                        }
                        d5.setBirthday(birthday);
                        d5.setHeight(d5.getHeight() <= 0.0d ? 170.0d : d5.getHeight());
                        d5.setWeight(d5.getWeight() > 60.0d ? d5.getWeight() : 60.0d);
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar9 = com.example.test.utils.k.f8731b;
                        if (kVar9 != null) {
                            kVar9.G(d5);
                        }
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar10 = com.example.test.utils.k.f8731b;
                        User d8 = kVar10 != null ? kVar10.d() : null;
                        if (d8 != null) {
                            d8.getPlatform();
                        }
                        if (d8 != null) {
                            c6.d dVar = c6.d.f3392c;
                            String name = d8.getName();
                            kotlin.jvm.internal.e.e(name, "getName(...)");
                            String birthday2 = d8.getBirthday();
                            kotlin.jvm.internal.e.e(birthday2, "getBirthday(...)");
                            String valueOf = String.valueOf(d8.getSex());
                            String valueOf2 = String.valueOf(d8.getHeight());
                            String valueOf3 = String.valueOf(d8.getWeight());
                            String avatar = d8.getAvatar();
                            kotlin.jvm.internal.e.e(avatar, "getAvatar(...)");
                            rg.l e = dVar.e(name, birthday2, valueOf, valueOf2, valueOf3, avatar, String.valueOf(d8.getStepsTarget()));
                            LoginActivity loginActivity3 = (LoginActivity) ((h7.f) kVar7.f7255a);
                            loginActivity3.getClass();
                            e.subscribe(new d0(d8, kVar7, loginActivity3, w0.d(), 3));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
