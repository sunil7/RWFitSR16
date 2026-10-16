package com.example.test.ui.sport.activity;

import com.autonavi.aps.amapapi.config.Const;
import com.example.database.db.SportImpl;
import com.example.database.table.DataSport;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.network.api.DataApi;
import com.example.network.base.HttpModel;
import com.example.test.XXApplication;
import com.example.test.presenter.sport.w;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.sport.model.SportRecordModel;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class p implements t6.b, a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SportRecordActivity f8183a;

    public /* synthetic */ p(SportRecordActivity sportRecordActivity) {
        this.f8183a = sportRecordActivity;
    }

    @Override // a7.e
    public void B() {
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        User d5;
        SportRecordActivity sportRecordActivity = this.f8183a;
        int i3 = SportRecordActivity.J;
        int size = sportRecordActivity.R0().size();
        SportRecordActivity sportRecordActivity2 = this.f8183a;
        int i10 = sportRecordActivity2.H;
        if (i10 < 0 || i10 >= size) {
            return;
        }
        w wVar = (w) sportRecordActivity2.I0();
        SportRecordActivity sportRecordActivity3 = this.f8183a;
        int i11 = sportRecordActivity3.H;
        long id2 = ((SportRecordModel) sportRecordActivity3.R0().get(this.f8183a.H)).getId();
        wVar.getClass();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
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
            DataSport data = sportImpl.getData(userId, id2, macAddress);
            if (data == null || !data.getIsUpdate()) {
                String userId2 = d5.getUserId();
                kotlin.jvm.internal.e.e(userId2, "getUserId(...)");
                String macAddress2 = c9.getMacAddress();
                kotlin.jvm.internal.e.e(macAddress2, "getMacAddress(...)");
                sportImpl.delSportById(userId2, id2, macAddress2);
            } else {
                String timestamp = data.getTimestamp();
                kotlin.jvm.internal.e.e(timestamp, "getTimestamp(...)");
                long parseLong = Long.parseLong(timestamp);
                long rawOffset = TimeZone.getDefault().getRawOffset();
                long j4 = TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L;
                ((XXBaseActivity) ((i7.h) wVar.f7255a)).V();
                rg.l<HttpModel<String>> delSportData = ((DataApi) c6.a.f3389c.f113a).delSportData((int) (((rawOffset + j4) / 1000) + parseLong));
                kotlin.jvm.internal.e.e(delSportData, "delSportData(...)");
                rg.l u10 = com.example.baselibrary.utils.b.u(delSportData);
                XXApplication xXApplication = XXApplication.f7400h;
                u10.blockingSubscribe(new com.example.test.presenter.sport.p(wVar, i11, id2, j1.a().c(), w0.d(), 1));
            }
            ((SportRecordActivity) ((i7.h) wVar.f7255a)).T0(i11);
        }
    }

    @Override // a7.e
    public void u0() {
        this.f8183a.onBackPressed();
    }
}
