package com.example.test.presenter.sport;

import android.app.Activity;
import com.example.baselibrary.base.activity.BaseActivity;
import com.example.database.db.SportImpl;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.network.base.HttpModel;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.sport.activity.SportNewRecordActivity;
import com.example.test.ui.sport.activity.SportRecordActivity;
import com.example.test.utils.w0;

/* loaded from: classes.dex */
public final class p extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7623d;
    public final /* synthetic */ int e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f7624f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.example.baselibrary.preseneter.b f7625g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(com.example.baselibrary.preseneter.b bVar, int i3, long j4, Activity activity, w0 w0Var, int i10) {
        super(activity, w0Var);
        this.f7623d = i10;
        this.f7625g = bVar;
        this.e = i3;
        this.f7624f = j4;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7623d) {
            case 0:
                r rVar = (r) this.f7625g;
                ((XXBaseActivity) ((i7.f) rVar.f7255a)).b0();
                Object obj = (i7.f) rVar.f7255a;
                SportNewRecordActivity sportNewRecordActivity = (SportNewRecordActivity) obj;
                sportNewRecordActivity.getClass();
                String string = sportNewRecordActivity.getString(R$string.str_network_error);
                if (string == null) {
                    string = "";
                }
                ((BaseActivity) obj).getClass();
                com.example.baselibrary.utils.d.b(string);
                break;
            default:
                w wVar = (w) this.f7625g;
                ((XXBaseActivity) ((i7.h) wVar.f7255a)).b0();
                Object obj2 = (i7.h) wVar.f7255a;
                SportRecordActivity sportRecordActivity = (SportRecordActivity) obj2;
                sportRecordActivity.getClass();
                String string2 = sportRecordActivity.getString(R$string.str_network_error);
                if (string2 == null) {
                    string2 = "";
                }
                ((BaseActivity) obj2).getClass();
                com.example.baselibrary.utils.d.b(string2);
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        User d5;
        User d8;
        switch (this.f7623d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                if (httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    if (kVar != null && (d5 = kVar.d()) != null) {
                        long j4 = this.f7624f;
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        Devices c9 = kVar2 != null ? kVar2.c() : null;
                        if (c9 != null) {
                            SportImpl sportImpl = SportImpl.INSTANCE;
                            String userId = d5.getUserId();
                            kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                            String macAddress = c9.getMacAddress();
                            kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
                            sportImpl.delSportById(userId, j4, macAddress);
                        }
                    }
                    ((SportNewRecordActivity) ((i7.f) ((r) this.f7625g).f7255a)).T0(this.e);
                    ((XXBaseActivity) ((i7.f) ((r) this.f7625g).f7255a)).b0();
                    return;
                }
                return;
            default:
                HttpModel httpModel2 = (HttpModel) obj;
                if (httpModel2 != null ? kotlin.jvm.internal.e.a(httpModel2.isSuccess(), Boolean.TRUE) : false) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                    if (kVar3 != null && (d8 = kVar3.d()) != null) {
                        long j10 = this.f7624f;
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                        Devices c10 = kVar4 != null ? kVar4.c() : null;
                        if (c10 != null) {
                            SportImpl sportImpl2 = SportImpl.INSTANCE;
                            String userId2 = d8.getUserId();
                            kotlin.jvm.internal.e.e(userId2, "getUserId(...)");
                            String macAddress2 = c10.getMacAddress();
                            kotlin.jvm.internal.e.e(macAddress2, "getMacAddress(...)");
                            sportImpl2.delSportById(userId2, j10, macAddress2);
                        }
                    }
                    ((SportRecordActivity) ((i7.h) ((w) this.f7625g).f7255a)).T0(this.e);
                    ((XXBaseActivity) ((i7.h) ((w) this.f7625g).f7255a)).b0();
                    return;
                }
                return;
        }
    }
}
