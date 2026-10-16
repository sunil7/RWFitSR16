package com.example.test.presenter.mine;

import android.content.Context;
import com.example.blesdk.bean.function.BindInfoBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.db.BloodOxygenImpl;
import com.example.database.db.BloodPressImpl;
import com.example.database.db.BodyTempImpl;
import com.example.database.db.BreatheImpl;
import com.example.database.db.HrImpl;
import com.example.database.db.QrCodeImpl;
import com.example.database.db.SettingImpl;
import com.example.database.db.SleepImpl;
import com.example.database.db.SportImpl;
import com.example.database.db.StepsImpl;
import com.example.database.db.UserImpl;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.network.base.HttpModel;
import com.example.network.bean.LoginResultBean;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.device.model.WeatherCacheModel;
import com.example.test.ui.mine.activity.AccountValidateActivity;
import com.example.test.ui.view.InputView;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7588d;
    public final /* synthetic */ f e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(f fVar, Context context, w0 w0Var, int i3) {
        super(context, w0Var);
        this.f7588d = i3;
        this.e = fVar;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7588d) {
            case 0:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("register error ->", com.example.baselibrary.utils.b.z(th2)));
                ((AccountValidateActivity) ((h7.c) this.e.f7255a)).T0(i3, 0);
                break;
            case 1:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("register error ->", com.example.baselibrary.utils.b.z(th2)));
                ((AccountValidateActivity) ((h7.c) this.e.f7255a)).T0(i3, 1);
                break;
            case 2:
                AccountValidateActivity accountValidateActivity = (AccountValidateActivity) ((h7.c) this.e.f7255a);
                accountValidateActivity.b0();
                w0.d().getClass();
                int c9 = w0.c(i3);
                if (c9 == 0) {
                    accountValidateActivity.w0(R$string.str_del_acc_fail);
                    break;
                } else {
                    accountValidateActivity.w0(c9);
                    break;
                }
            case 3:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("register error ->", com.example.baselibrary.utils.b.z(th2)));
                ((AccountValidateActivity) ((h7.c) this.e.f7255a)).T0(i3, 0);
                break;
            case 4:
                AccountValidateActivity accountValidateActivity2 = (AccountValidateActivity) ((h7.c) this.e.f7255a);
                accountValidateActivity2.b0();
                w0.d().getClass();
                int c10 = w0.c(i3);
                if (c10 == 0) {
                    accountValidateActivity2.w0(R$string.str_reset_pw_fail);
                    break;
                } else {
                    accountValidateActivity2.w0(c10);
                    break;
                }
            case 5:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("sendVerifyCode error ->", com.example.baselibrary.utils.b.z(th2)));
                AccountValidateActivity accountValidateActivity3 = (AccountValidateActivity) ((h7.c) this.e.f7255a);
                accountValidateActivity3.b0();
                w0.d().getClass();
                int c11 = w0.c(i3);
                if (c11 == 0) {
                    accountValidateActivity3.w0(R$string.str_verify_code_fail);
                    break;
                } else {
                    accountValidateActivity3.w0(c11);
                    break;
                }
            default:
                AccountValidateActivity accountValidateActivity4 = (AccountValidateActivity) ((h7.c) this.e.f7255a);
                accountValidateActivity4.b0();
                w0.d().getClass();
                int c12 = w0.c(i3);
                if (c12 == 0) {
                    accountValidateActivity4.w0(R$string.str_reset_pw_fail);
                    break;
                } else {
                    accountValidateActivity4.w0(c12);
                    break;
                }
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        com.example.test.utils.k a3;
        switch (this.f7588d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("register ->", com.example.baselibrary.utils.b.z(httpModel)));
                com.example.test.utils.k a10 = y1.a();
                final Integer valueOf = a10 != null ? Integer.valueOf(a10.x()) : null;
                if (httpModel != null) {
                    final f fVar = this.e;
                    LoginResultBean loginResultBean = (LoginResultBean) httpModel.getResults();
                    if (loginResultBean == null) {
                        ((AccountValidateActivity) ((h7.c) fVar.f7255a)).U0(httpModel.getCode(), valueOf);
                        return;
                    }
                    com.example.test.utils.k a11 = y1.a();
                    if (a11 != null) {
                        String accessToken = loginResultBean.getAccessToken();
                        kotlin.jvm.internal.e.e(accessToken, "getAccessToken(...)");
                        a11.M(accessToken, "user_login_token");
                    }
                    if (d6.a.f12304c == null) {
                        synchronized (d6.a.class) {
                            d6.a.f12304c = new d6.a();
                        }
                    }
                    d6.a aVar = d6.a.f12304c;
                    if (aVar != null) {
                        aVar.f12306b = loginResultBean.getAccessToken();
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
                    if (valueOf != null && (a3 = y1.a()) != null) {
                        a3.Y(valueOf.intValue());
                    }
                    if (httpModel.getCode() == 1020) {
                        ((AccountValidateActivity) ((h7.c) fVar.f7255a)).U0(httpModel.getCode(), valueOf);
                        return;
                    }
                    String memberId = loginResultBean.getMemberId();
                    if (memberId == null) {
                        ((AccountValidateActivity) ((h7.c) fVar.f7255a)).U0(httpModel.getCode(), valueOf);
                        return;
                    }
                    com.google.android.gms.internal.mlkit_vision_common.p.T(32, (c) fVar.f7591b.getValue());
                    BindInfoBean bindInfoBean = new BindInfoBean();
                    bindInfoBean.setBindType(1);
                    bindInfoBean.setUserId(memberId);
                    if (y5.d.f20005b) {
                        com.google.android.gms.internal.mlkit_vision_common.p.t(bindInfoBean);
                    } else {
                        com.google.android.gms.internal.mlkit_vision_common.p.s(bindInfoBean);
                    }
                    com.example.baselibrary.preseneter.b.j(memberId, new oh.l() { // from class: com.example.test.presenter.mine.AccountValidatePresenter$mergeUserData$1
                        @Override // oh.l
                        public final Integer invoke(String memId) {
                            User d5;
                            Devices c9;
                            User d8;
                            MMKV mmkv;
                            kotlin.jvm.internal.e.f(memId, "memId");
                            com.example.test.utils.k a12 = y1.a();
                            if (a12 != null && (d5 = a12.d()) != null) {
                                com.example.test.utils.k a13 = y1.a();
                                if (a13 != null && (d8 = a13.d()) != null) {
                                    Devices c10 = a13.c();
                                    if (c10 != null) {
                                        c10.setUserId(memId);
                                        String c11 = r5.a.c(memId, c10.getMacAddress(), "user_location_weather_time");
                                        String macAddress = c10.getMacAddress();
                                        kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
                                        a13.M(Long.valueOf(a13.r(macAddress)), c11);
                                        a13.N(d8.getUserId() + c10.getMacAddress() + "user_location_weather_time");
                                        a13.M(Boolean.valueOf(a13.K(c10.getMacAddress())), r5.a.c(memId, c10.getMacAddress(), "setting_weather"));
                                        a13.N(d8.getUserId() + c10.getMacAddress() + "setting_weather");
                                        a13.M(Boolean.valueOf(a13.J(c10.getMacAddress())), r5.a.c(memId, c10.getMacAddress(), "setting_take_photo"));
                                        a13.N(d8.getUserId() + c10.getMacAddress() + "setting_take_photo");
                                        a13.M(Boolean.valueOf(a13.H(c10.getMacAddress())), r5.a.c(memId, c10.getMacAddress(), "setting_anti_lost"));
                                        a13.N(d8.getUserId() + c10.getMacAddress() + "setting_anti_lost");
                                        a13.M(Boolean.valueOf(a13.I(c10.getMacAddress())), r5.a.c(memId, c10.getMacAddress(), "setting_incoming_call"));
                                        a13.N(d8.getUserId() + c10.getMacAddress() + "setting_incoming_call");
                                        String macAddress2 = c10.getMacAddress();
                                        kotlin.jvm.internal.e.e(macAddress2, "getMacAddress(...)");
                                        User d10 = a13.d();
                                        WeatherCacheModel weatherCacheModel = null;
                                        if (d10 != null && (mmkv = a13.f8732a) != null) {
                                            weatherCacheModel = (WeatherCacheModel) mmkv.f(d10.getUserId() + macAddress2 + "setting_weather_cache", WeatherCacheModel.class);
                                        }
                                        if (weatherCacheModel != null) {
                                            a13.M(weatherCacheModel, memId + c10.getMacAddress() + "setting_weather_cache");
                                            a13.N(d8.getUserId() + c10.getMacAddress() + "setting_weather_cache");
                                        }
                                        SupportMenuBean l3 = a13.l();
                                        if (l3 != null) {
                                            a13.M(l3, memId + c10.getMacAddress() + "device_support");
                                            a13.N(d8.getUserId() + c10.getMacAddress() + "device_support");
                                        }
                                        a13.M(c10, memId.concat("device_info_bound"));
                                        a13.N(d8.getUserId() + "device_info_bound");
                                    }
                                    a13.M(a13.B(), memId.concat("setting_sport_target"));
                                    a13.N(d8.getUserId() + "setting_sport_target");
                                    d8.setUserId(memId);
                                    a13.M(d8, "user_info_logged");
                                    UserImpl userImpl = UserImpl.INSTANCE;
                                    userImpl.saveUser(d8);
                                    userImpl.removeVisitor();
                                }
                                BloodOxygenImpl bloodOxygenImpl = BloodOxygenImpl.INSTANCE;
                                String userId = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                                bloodOxygenImpl.mergeData(userId, memId);
                                BloodPressImpl bloodPressImpl = BloodPressImpl.INSTANCE;
                                String userId2 = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId2, "getUserId(...)");
                                bloodPressImpl.mergeData(userId2, memId);
                                BodyTempImpl bodyTempImpl = BodyTempImpl.INSTANCE;
                                String userId3 = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId3, "getUserId(...)");
                                bodyTempImpl.mergeData(userId3, memId);
                                BreatheImpl breatheImpl = BreatheImpl.INSTANCE;
                                String userId4 = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId4, "getUserId(...)");
                                breatheImpl.mergeData(userId4, memId);
                                HrImpl hrImpl = HrImpl.INSTANCE;
                                String userId5 = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId5, "getUserId(...)");
                                hrImpl.mergeData(userId5, memId);
                                SleepImpl sleepImpl = SleepImpl.INSTANCE;
                                String userId6 = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId6, "getUserId(...)");
                                sleepImpl.mergeData(userId6, memId);
                                SportImpl sportImpl = SportImpl.INSTANCE;
                                String userId7 = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId7, "getUserId(...)");
                                sportImpl.mergeData(userId7, memId);
                                StepsImpl stepsImpl = StepsImpl.INSTANCE;
                                String userId8 = d5.getUserId();
                                kotlin.jvm.internal.e.e(userId8, "getUserId(...)");
                                stepsImpl.mergeData(userId8, memId);
                                com.example.test.utils.k a14 = y1.a();
                                if (a14 != null && (c9 = a14.c()) != null) {
                                    QrCodeImpl qrCodeImpl = QrCodeImpl.INSTANCE;
                                    String userId9 = d5.getUserId();
                                    kotlin.jvm.internal.e.e(userId9, "getUserId(...)");
                                    String macAddress3 = c9.getMacAddress();
                                    kotlin.jvm.internal.e.e(macAddress3, "getMacAddress(...)");
                                    qrCodeImpl.mergeData(userId9, macAddress3, memId);
                                    SettingImpl settingImpl = SettingImpl.INSTANCE;
                                    String userId10 = d5.getUserId();
                                    kotlin.jvm.internal.e.e(userId10, "getUserId(...)");
                                    String macAddress4 = c9.getMacAddress();
                                    kotlin.jvm.internal.e.e(macAddress4, "getMacAddress(...)");
                                    settingImpl.mergeData(userId10, macAddress4, memId);
                                }
                            }
                            return 1;
                        }
                    }, new oh.l() { // from class: com.example.test.presenter.mine.AccountValidatePresenter$mergeUserData$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void invoke(int i3) {
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                            User d5 = kVar != null ? kVar.d() : null;
                            if (d5 == null) {
                                ((AccountValidateActivity) ((h7.c) f.this.f7255a)).U0(0, valueOf);
                                return;
                            }
                            f fVar2 = f.this;
                            Integer num = valueOf;
                            fVar2.getClass();
                            String avatar = d5.getAvatar();
                            if (avatar == null || avatar.length() == 0) {
                                fVar2.m(d5, num);
                                return;
                            }
                            String avatar2 = d5.getAvatar();
                            if (avatar2 != null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(avatar2);
                                rg.l d8 = c6.c.f3391c.d(arrayList);
                                AccountValidateActivity accountValidateActivity = (AccountValidateActivity) ((h7.c) fVar2.f7255a);
                                accountValidateActivity.getClass();
                                d8.subscribe(new e(d5, fVar2, num, accountValidateActivity, w0.d()));
                            }
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke(((Number) obj2).intValue());
                            return eh.g.f12633a;
                        }
                    });
                    return;
                }
                return;
            case 1:
                HttpModel httpModel2 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("register ->", com.example.baselibrary.utils.b.z(httpModel2)));
                if (httpModel2 != null) {
                    f fVar2 = this.e;
                    if (d6.a.f12304c == null) {
                        synchronized (d6.a.class) {
                            d6.a.f12304c = new d6.a();
                        }
                    }
                    d6.a aVar3 = d6.a.f12304c;
                    if (aVar3 != null) {
                        aVar3.f12305a = 0;
                    }
                    ((AccountValidateActivity) ((h7.c) fVar2.f7255a)).U0(httpModel2.getCode(), null);
                    return;
                }
                return;
            case 2:
                HttpModel httpModel3 = (HttpModel) obj;
                if (httpModel3 != null) {
                    h7.c cVar = (h7.c) this.e.f7255a;
                    int code = httpModel3.getCode();
                    AccountValidateActivity accountValidateActivity = (AccountValidateActivity) cVar;
                    accountValidateActivity.b0();
                    w0.d().getClass();
                    int c9 = w0.c(code);
                    if (c9 != 0) {
                        accountValidateActivity.w0(c9);
                        return;
                    }
                    ((f) accountValidateActivity.I0()).k();
                    com.example.test.service.e.h().e();
                    com.example.test.service.e.h().l();
                    XXApplication xXApplication = XXApplication.f7400h;
                    j1.a().a();
                    com.example.test.utils.k a12 = y1.a();
                    if (a12 != null) {
                        a12.L();
                    }
                    com.example.test.utils.k a13 = y1.a();
                    if (a13 != null) {
                        a13.Y(0);
                    }
                    com.example.test.utils.k a14 = y1.a();
                    if (a14 != null) {
                        a14.b0();
                    }
                    w0.d().getClass();
                    w0.i();
                    return;
                }
                return;
            case 3:
                HttpModel httpModel4 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("register ->", com.example.baselibrary.utils.b.z(httpModel4)));
                if (httpModel4 != null) {
                    f fVar3 = this.e;
                    LoginResultBean loginResultBean2 = (LoginResultBean) httpModel4.getResults();
                    if (loginResultBean2 != null) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null) {
                            String accessToken2 = loginResultBean2.getAccessToken();
                            kotlin.jvm.internal.e.e(accessToken2, "getAccessToken(...)");
                            kVar.M(accessToken2, "user_login_token");
                        }
                        if (d6.a.f12304c == null) {
                            synchronized (d6.a.class) {
                                d6.a.f12304c = new d6.a();
                            }
                        }
                        d6.a aVar4 = d6.a.f12304c;
                        if (aVar4 != null) {
                            aVar4.f12306b = loginResultBean2.getAccessToken();
                        }
                    }
                    if (d6.a.f12304c == null) {
                        synchronized (d6.a.class) {
                            d6.a.f12304c = new d6.a();
                        }
                    }
                    d6.a aVar5 = d6.a.f12304c;
                    if (aVar5 != null) {
                        aVar5.f12305a = 0;
                    }
                    ((AccountValidateActivity) ((h7.c) fVar3.f7255a)).U0(httpModel4.getCode(), null);
                    return;
                }
                return;
            case 4:
                HttpModel httpModel5 = (HttpModel) obj;
                if (httpModel5 != null) {
                    ((AccountValidateActivity) ((h7.c) this.e.f7255a)).V0(httpModel5.getCode());
                    return;
                }
                return;
            case 5:
                HttpModel httpModel6 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("sendVerifyCode ->", com.example.baselibrary.utils.b.z(httpModel6)));
                if (httpModel6 != null) {
                    h7.c cVar2 = (h7.c) this.e.f7255a;
                    int code2 = httpModel6.getCode();
                    AccountValidateActivity accountValidateActivity2 = (AccountValidateActivity) cVar2;
                    accountValidateActivity2.b0();
                    Integer R0 = accountValidateActivity2.R0();
                    eh.b bVar = accountValidateActivity2.f7247z;
                    if (R0 != null && R0.intValue() == 0) {
                        if (code2 == 1020) {
                            w0.d().getClass();
                            accountValidateActivity2.w0(w0.c(code2));
                            return;
                        } else {
                            InputView inputView = ((f6.c) bVar.getValue()).f12753j;
                            inputView.f8449i = 120;
                            inputView.a();
                            return;
                        }
                    }
                    if (R0 != null && R0.intValue() == 4) {
                        if (code2 == 1010) {
                            accountValidateActivity2.w0(R$string.str_account_not_exit);
                            return;
                        }
                        InputView inputView2 = ((f6.c) bVar.getValue()).f12753j;
                        inputView2.f8449i = 120;
                        inputView2.a();
                        return;
                    }
                    if (R0 != null && R0.intValue() == 1) {
                        if (code2 == 1020) {
                            w0.d().getClass();
                            accountValidateActivity2.w0(w0.c(code2));
                            return;
                        } else {
                            InputView inputView3 = ((f6.c) bVar.getValue()).f12753j;
                            inputView3.f8449i = 120;
                            inputView3.a();
                            return;
                        }
                    }
                    if (R0 != null && R0.intValue() == 2) {
                        if (code2 == 1010) {
                            w0.d().getClass();
                            accountValidateActivity2.w0(w0.c(code2));
                            return;
                        } else {
                            InputView inputView4 = ((f6.c) bVar.getValue()).f12753j;
                            inputView4.f8449i = 120;
                            inputView4.a();
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                HttpModel httpModel7 = (HttpModel) obj;
                if (httpModel7 != null) {
                    ((AccountValidateActivity) ((h7.c) this.e.f7255a)).V0(httpModel7.getCode());
                    return;
                }
                return;
        }
    }
}
