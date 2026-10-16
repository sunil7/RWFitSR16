package com.example.test.presenter.main;

import android.content.Context;
import android.util.Log;
import com.example.database.table.User;
import com.example.network.base.HttpModel;
import com.example.network.bean.DeviceModelInfoBean;
import com.example.test.R$string;
import com.example.test.ui.main.fragment.DeviceFragment;
import com.example.test.ui.mine.activity.AccountValidateActivity;
import com.example.test.ui.mine.activity.LoginActivity;
import com.example.test.ui.mine.activity.PrivacySafeActivity;
import com.example.test.ui.testui.TRingDeviceFragment;
import f6.g3;
import f6.u3;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d0 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7503d;
    public final /* synthetic */ Object e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f7504f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(Object obj, Object obj2, Context context, com.example.test.utils.w0 w0Var, int i3) {
        super(context, w0Var);
        this.f7503d = i3;
        this.e = obj;
        this.f7504f = obj2;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7503d) {
            case 0:
                th2.getMessage();
                DeviceFragment deviceFragment = (DeviceFragment) ((g7.k) ((h0) this.f7504f).f7255a);
                deviceFragment.getClass();
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    kVar.R(new DeviceModelInfoBean());
                }
                g3 g3Var = (g3) deviceFragment.f7251b;
                if (g3Var != null) {
                    g3Var.f12925b.setBindModel(deviceFragment.u0());
                    return;
                }
                return;
            case 1:
                th2.getMessage();
                TRingDeviceFragment tRingDeviceFragment = (TRingDeviceFragment) ((g7.z) ((r1) this.f7504f).f7255a);
                tRingDeviceFragment.getClass();
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                if (kVar2 != null) {
                    kVar2.R(new DeviceModelInfoBean());
                }
                u3 u3Var = (u3) tRingDeviceFragment.f7251b;
                if (u3Var != null) {
                    u3Var.f13380b.setBindModel(tRingDeviceFragment.z0());
                    return;
                }
                return;
            case 2:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "uploadUser", "errorCode " + i3 + " 错误 " + th2.toString());
                ((AccountValidateActivity) ((h7.c) ((com.example.test.presenter.mine.f) this.e).f7255a)).U0(0, (Integer) this.f7504f);
                return;
            case 3:
                LoginActivity loginActivity = (LoginActivity) ((h7.f) ((com.example.test.presenter.mine.k) this.f7504f).f7255a);
                loginActivity.b0();
                loginActivity.w0(R$string.str_login_fail);
                return;
            case 4:
                ((h7.h) ((com.example.test.presenter.mine.m) this.f7504f).f7255a).p();
                return;
            case 5:
                ((h7.h) ((com.example.test.presenter.mine.n) this.f7504f).f7255a).p();
                return;
            default:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                PrivacySafeActivity privacySafeActivity = (PrivacySafeActivity) ((h7.i) ((com.example.test.presenter.mine.p) this.f7504f).f7255a);
                privacySafeActivity.getClass();
                String string = privacySafeActivity.getString(R$string.str_network_error);
                if (string == null) {
                    string = "";
                }
                privacySafeActivity.S0(i3, string);
                return;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        switch (this.f7503d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                com.example.baselibrary.utils.b.z(httpModel);
                if (httpModel != null) {
                    String str = (String) this.e;
                    h0 h0Var = (h0) this.f7504f;
                    ((DeviceModelInfoBean) httpModel.getResults()).setDeviceClazz(str);
                    g7.k kVar = (g7.k) h0Var.f7255a;
                    Object results = httpModel.getResults();
                    kotlin.jvm.internal.e.e(results, "getResults(...)");
                    DeviceModelInfoBean deviceModelInfoBean = (DeviceModelInfoBean) results;
                    DeviceFragment deviceFragment = (DeviceFragment) kVar;
                    deviceFragment.getClass();
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    if (kVar2 != null) {
                        kVar2.R(deviceModelInfoBean);
                    }
                    deviceFragment.u0().setShowUrl(deviceModelInfoBean.getShowUrl());
                    g3 g3Var = (g3) deviceFragment.f7251b;
                    if (g3Var != null) {
                        g3Var.f12925b.setBindModel(deviceFragment.u0());
                        return;
                    }
                    return;
                }
                return;
            case 1:
                HttpModel httpModel2 = (HttpModel) obj;
                com.example.baselibrary.utils.b.z(httpModel2);
                if (httpModel2 != null) {
                    String str2 = (String) this.e;
                    r1 r1Var = (r1) this.f7504f;
                    ((DeviceModelInfoBean) httpModel2.getResults()).setDeviceClazz(str2);
                    g7.z zVar = (g7.z) r1Var.f7255a;
                    Object results2 = httpModel2.getResults();
                    kotlin.jvm.internal.e.e(results2, "getResults(...)");
                    DeviceModelInfoBean deviceModelInfoBean2 = (DeviceModelInfoBean) results2;
                    TRingDeviceFragment tRingDeviceFragment = (TRingDeviceFragment) zVar;
                    tRingDeviceFragment.getClass();
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                    if (kVar3 != null) {
                        kVar3.R(deviceModelInfoBean2);
                    }
                    tRingDeviceFragment.z0().setShowUrl(deviceModelInfoBean2.getShowUrl());
                    u3 u3Var = (u3) tRingDeviceFragment.f7251b;
                    if (u3Var != null) {
                        u3Var.f13380b.setBindModel(tRingDeviceFragment.z0());
                        return;
                    }
                    return;
                }
                return;
            case 2:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "uploadUser", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("result ", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                ((AccountValidateActivity) ((h7.c) ((com.example.test.presenter.mine.f) this.e).f7255a)).U0(0, (Integer) this.f7504f);
                return;
            case 3:
                HttpModel httpModel3 = (HttpModel) obj;
                if (!(httpModel3 != null ? kotlin.jvm.internal.e.a(httpModel3.isSuccess(), Boolean.TRUE) : false)) {
                    LoginActivity loginActivity = (LoginActivity) ((h7.f) ((com.example.test.presenter.mine.k) this.f7504f).f7255a);
                    loginActivity.b0();
                    loginActivity.w0(R$string.str_login_fail);
                    return;
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                if (kVar4 != null) {
                    kVar4.G((User) this.e);
                }
                LoginActivity loginActivity2 = (LoginActivity) ((h7.f) ((com.example.test.presenter.mine.k) this.f7504f).f7255a);
                loginActivity2.b0();
                Object obj2 = com.example.test.service.g1.e;
                com.example.test.service.g1 a3 = com.google.android.gms.internal.mlkit_vision_barcode.p1.a();
                a3.f7707b = false;
                a3.f7706a = false;
                loginActivity2.S0(1);
                loginActivity2.finish();
                return;
            case 4:
                HttpModel httpModel4 = (HttpModel) obj;
                if (!(httpModel4 != null ? kotlin.jvm.internal.e.a(httpModel4.isSuccess(), Boolean.TRUE) : false)) {
                    ((h7.h) ((com.example.test.presenter.mine.m) this.f7504f).f7255a).p();
                    return;
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar5 = com.example.test.utils.k.f8731b;
                if (kVar5 != null) {
                    kVar5.G((User) this.e);
                }
                Log.d("tong", "onUserInfoSuccess---3");
                ((h7.h) ((com.example.test.presenter.mine.m) this.f7504f).f7255a).k();
                return;
            case 5:
                HttpModel httpModel5 = (HttpModel) obj;
                if (!(httpModel5 != null ? kotlin.jvm.internal.e.a(httpModel5.isSuccess(), Boolean.TRUE) : false)) {
                    ((h7.h) ((com.example.test.presenter.mine.n) this.f7504f).f7255a).p();
                    return;
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar6 = com.example.test.utils.k.f8731b;
                if (kVar6 != null) {
                    kVar6.G((User) this.e);
                }
                ((h7.h) ((com.example.test.presenter.mine.n) this.f7504f).f7255a).k();
                return;
            default:
                HttpModel httpModel6 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onSuccess ->", com.example.baselibrary.utils.b.z(httpModel6)));
                if (!(httpModel6 != null ? kotlin.jvm.internal.e.a(httpModel6.isSuccess(), Boolean.TRUE) : false)) {
                    h7.i iVar = (h7.i) ((com.example.test.presenter.mine.p) this.f7504f).f7255a;
                    int code = httpModel6 != null ? httpModel6.getCode() : -1;
                    String msg = httpModel6 != null ? httpModel6.getMsg() : null;
                    if (msg == null) {
                        msg = "";
                    }
                    ((PrivacySafeActivity) iVar).S0(code, msg);
                    return;
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar7 = com.example.test.utils.k.f8731b;
                if (kVar7 != null) {
                    kVar7.X((ArrayList) this.e);
                }
                ((PrivacySafeActivity) ((h7.i) ((com.example.test.presenter.mine.p) this.f7504f).f7255a)).finish();
                return;
        }
    }
}
