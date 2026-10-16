package com.example.test.presenter.device;

import com.example.blesdk.bean.function.AddressBookBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.ContactActivity;
import com.example.test.ui.device.model.ContactModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class q extends d implements w5.a {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7471b;

    public q(ContactActivity contactActivity) {
        super(contactActivity);
        this.f7471b = new ArrayList();
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ContactPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "errorCode "));
        ((XXBaseActivity) ((f7.d) this.f7255a)).b0();
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        com.example.baselibrary.preseneter.b.j(this.f7471b, new oh.l() { // from class: com.example.test.presenter.device.ContactPresenter$saveDB$1
            @Override // oh.l
            public final Long invoke(List<AddressBookBean> it) {
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                for (AddressBookBean addressBookBean : it) {
                    String contactNum = addressBookBean.getContactNum();
                    if (contactNum == null || contactNum.length() == 0) {
                        str = "";
                    } else {
                        String contactNum2 = addressBookBean.getContactNum();
                        kotlin.jvm.internal.e.e(contactNum2, "getContactNum(...)");
                        str = kotlin.text.m.r(contactNum2, " ", "");
                    }
                    addressBookBean.setContactNum(str);
                }
                DataSetting dataSetting = new DataSetting();
                dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                dataSetting.setDataKey("setting_address_book");
                dataSetting.setDataValue(com.example.baselibrary.utils.b.z(it));
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    dataSetting.setUserId(d5.getUserId());
                }
                return Long.valueOf(SettingImpl.INSTANCE.saveData(dataSetting));
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.ContactPresenter$saveDB$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return eh.g.f12633a;
            }

            public final void invoke(long j4) {
                if (j4 > 0) {
                    ((f7.d) q.this.f7255a).a();
                } else {
                    ((f7.d) q.this.f7255a).b();
                }
            }
        });
        ((XXBaseActivity) ((f7.d) this.f7255a)).b0();
    }

    @Override // u5.g
    public final /* bridge */ /* synthetic */ void e(Object obj) {
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == this) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.ContactPresenter$initData$1
            @Override // oh.l
            public final DataSetting invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 == null) {
                    return null;
                }
                SettingImpl settingImpl = SettingImpl.INSTANCE;
                String userId = d5.getUserId();
                String str = android.support.v4.media.session.e.y(userId, "getUserId(...)").f18212c;
                kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                return settingImpl.getData(userId, str, "setting_address_book");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.ContactPresenter$initData$2

            public static final class a extends bc.a<List<? extends AddressBookBean>> {
            }

            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DataSetting) obj);
                return eh.g.f12633a;
            }

            public final void invoke(DataSetting dataSetting) {
                if (dataSetting != null) {
                    q qVar = q.this;
                    List<AddressBookBean> h4 = com.example.baselibrary.utils.b.h(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(h4, "fromJsonArray(...)");
                    ArrayList arrayList = new ArrayList();
                    for (AddressBookBean addressBookBean : h4) {
                        ContactModel contactModel = new ContactModel();
                        contactModel.setContactName(addressBookBean.getContactName());
                        contactModel.setContactType(addressBookBean.getContactNum());
                        arrayList.add(contactModel);
                    }
                    ((f7.d) qVar.f7255a).d(arrayList);
                }
            }
        });
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = this;
        I0.K0(eVar);
    }
}
