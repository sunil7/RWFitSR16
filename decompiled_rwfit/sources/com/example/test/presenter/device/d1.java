package com.example.test.presenter.device;

import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.device.activity.RingMessagePushActivity;
import com.example.test.ui.device.model.MessageModel;
import com.example.test.ui.device.model.MsgDataModel;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class d1 extends d {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7418b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f7419c;

    public d1(RingMessagePushActivity ringMessagePushActivity) {
        super(ringMessagePushActivity);
        this.f7418b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.RingMessagePushPresenter$switchStatusCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final c1 invoke() {
                return new c1(d1.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        c1 c1Var = (c1) this.f7418b.getValue();
        if (c1Var == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(c1Var)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == c1Var) {
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.RingMessagePushPresenter$initData$1
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
                return settingImpl.getData(userId, str, "setting_message");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.RingMessagePushPresenter$initData$2

            public static final class a extends bc.a<List<? extends MsgDataModel>> {
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
                    d1 d1Var = d1.this;
                    Type type = new a().f3204b;
                    dataSetting.getDataValue();
                    List<MsgDataModel> h4 = com.example.baselibrary.utils.b.h(dataSetting.getDataValue(), type);
                    kotlin.jvm.internal.e.e(h4, "fromJsonArray(...)");
                    ArrayList arrayList = new ArrayList();
                    for (MsgDataModel msgDataModel : h4) {
                        if (msgDataModel.getAppId() != 0) {
                            MessageModel messageModel = new MessageModel();
                            messageModel.setId(msgDataModel.getAppId());
                            messageModel.setSelected(msgDataModel.isOpen());
                            arrayList.add(messageModel);
                        } else {
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                            Boolean valueOf = kVar != null ? Boolean.valueOf(kVar.I(com.example.test.service.e.h().g().f18212c)) : null;
                            MessageModel messageModel2 = new MessageModel();
                            messageModel2.setId(msgDataModel.getAppId());
                            kotlin.jvm.internal.e.c(valueOf);
                            messageModel2.setSelected(valueOf.booleanValue());
                            arrayList.add(messageModel2);
                        }
                    }
                    ((f7.q) d1Var.f7255a).d(arrayList);
                }
            }
        });
    }
}
