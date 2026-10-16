package com.example.test.presenter.device;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.example.database.table.User;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.SwitchBean;
import com.example.network.bean.UserInfoBean;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes.dex */
public final class t extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7480d;
    public final /* synthetic */ int e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ User f7481f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.example.baselibrary.preseneter.b f7482g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(int i3, User user, com.example.baselibrary.preseneter.b bVar, Context context, com.example.test.utils.w0 w0Var, int i10) {
        super(context, w0Var);
        this.f7480d = i10;
        this.e = i3;
        this.f7481f = user;
        this.f7482g = bVar;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7480d) {
            case 0:
                ((f7.f) ((u) this.f7482g).f7255a).getClass();
                break;
            default:
                ((e7.b) ((com.example.test.presenter.main.z0) this.f7482g).f7255a).z();
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        switch (this.f7480d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                if (!(httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false) || httpModel.getResults() == null) {
                    ((f7.f) ((u) this.f7482g).f7255a).getClass();
                    return;
                }
                UserInfoBean userInfoBean = (UserInfoBean) httpModel.getResults();
                User user = new User();
                String portraitUrl = userInfoBean.getPortraitUrl();
                if (portraitUrl == null) {
                    portraitUrl = "";
                }
                user.setAvatar(portraitUrl);
                Calendar calendar = Calendar.getInstance();
                calendar.set(1, 1990);
                calendar.set(2, 0);
                calendar.set(5, 1);
                String birthday = userInfoBean.getBirthday();
                if (birthday == null) {
                    birthday = String.valueOf(calendar.getTimeInMillis() / 1000);
                }
                user.setBirthday(birthday);
                user.setAccount(userInfoBean.getAccount());
                user.setHeight(userInfoBean.getHeight() <= 0.0d ? 170.0d : userInfoBean.getHeight());
                user.setWeight(userInfoBean.getWeight() > 60.0d ? userInfoBean.getWeight() : 60.0d);
                String name = userInfoBean.getName();
                if (name == null) {
                    name = "";
                }
                user.setName(name);
                user.setSex(userInfoBean.getSex());
                user.setUserId(String.valueOf(userInfoBean.getId()));
                user.setPlatform(this.e);
                user.setStepsTarget(userInfoBean.getSportTarget() == 0 ? Const.I_GEO_MAX_TIME : userInfoBean.getSportTarget());
                User user2 = this.f7481f;
                if (user2 != null) {
                    user.setMeterUnit(user2.getMeterUnit());
                    user.setTempUnit(user2.getTempUnit());
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    kVar.G(user);
                }
                ((f7.f) ((u) this.f7482g).f7255a).i(user);
                return;
            default:
                HttpModel httpModel2 = (HttpModel) obj;
                if (!(httpModel2 != null ? kotlin.jvm.internal.e.a(httpModel2.isSuccess(), Boolean.TRUE) : false) || httpModel2.getResults() == null) {
                    ((e7.b) ((com.example.test.presenter.main.z0) this.f7482g).f7255a).z();
                    return;
                }
                UserInfoBean userInfoBean2 = (UserInfoBean) httpModel2.getResults();
                User user3 = new User();
                String portraitUrl2 = userInfoBean2.getPortraitUrl();
                if (portraitUrl2 == null) {
                    portraitUrl2 = "";
                }
                user3.setAvatar(portraitUrl2);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(1, 1990);
                calendar2.set(2, 0);
                calendar2.set(5, 1);
                String birthday2 = userInfoBean2.getBirthday();
                if (birthday2 == null) {
                    birthday2 = String.valueOf(calendar2.getTimeInMillis() / 1000);
                }
                user3.setBirthday(birthday2);
                user3.setAccount(userInfoBean2.getAccount());
                user3.setHeight(userInfoBean2.getHeight() <= 0.0d ? 170.0d : userInfoBean2.getHeight());
                user3.setWeight(userInfoBean2.getWeight() > 60.0d ? userInfoBean2.getWeight() : 60.0d);
                String name2 = userInfoBean2.getName();
                if (name2 == null) {
                    name2 = "";
                }
                user3.setName(name2);
                user3.setSex(userInfoBean2.getSex());
                user3.setUserId(String.valueOf(userInfoBean2.getId()));
                user3.setPlatform(this.e);
                user3.setStepsTarget(userInfoBean2.getSportTarget() == 0 ? Const.I_GEO_MAX_TIME : userInfoBean2.getSportTarget());
                User user4 = this.f7481f;
                if (user4 != null) {
                    user3.setMeterUnit(user4.getMeterUnit());
                    user3.setTempUnit(user4.getTempUnit());
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                if (kVar2 != null) {
                    kVar2.G(user3);
                }
                ((e7.b) ((com.example.test.presenter.main.z0) this.f7482g).f7255a).i(user3);
                com.example.test.presenter.main.z0 z0Var = (com.example.test.presenter.main.z0) this.f7482g;
                z0Var.getClass();
                rg.l<HttpModel<List<SwitchBean>>> switchParam = ((UserApi) c6.d.f3392c.f113a).getSwitchParam();
                kotlin.jvm.internal.e.e(switchParam, "getSwitchParam(...)");
                com.example.baselibrary.utils.b.w(switchParam).subscribe(new y(z0Var, ((e7.b) z0Var.f7255a).f0(), com.example.test.utils.w0.d(), 4));
                return;
        }
    }
}
