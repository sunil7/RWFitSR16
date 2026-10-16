package com.example.test.presenter.device;

import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.device.activity.MessagePushActivity;
import com.example.test.ui.device.model.MessageModel;
import com.example.test.ui.device.model.MsgDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class r0 extends d {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7474b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f7475c;

    public r0(MessagePushActivity messagePushActivity) {
        super(messagePushActivity);
        this.f7474b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.MessagePushPresenter$switchStatusCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final q0 invoke() {
                return new q0(r0.this);
            }
        });
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        q0 q0Var = (q0) this.f7474b.getValue();
        if (q0Var == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(q0Var)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == q0Var) {
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
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.MessagePushPresenter$initData$1
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
        }, new oh.l() { // from class: com.example.test.presenter.device.MessagePushPresenter$initData$2

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
                    r0 r0Var = r0.this;
                    a aVar = new a();
                    dataSetting.getDataValue();
                    List<MsgDataModel> h4 = com.example.baselibrary.utils.b.h(dataSetting.getDataValue(), aVar.f3204b);
                    kotlin.jvm.internal.e.e(h4, "fromJsonArray(...)");
                    ArrayList arrayList = new ArrayList();
                    for (MsgDataModel msgDataModel : h4) {
                        if (msgDataModel.getAppId() != 0) {
                            MessageModel messageModel = new MessageModel();
                            messageModel.setId(msgDataModel.getAppId());
                            messageModel.setSelected(msgDataModel.isOpen());
                            arrayList.add(messageModel);
                        }
                    }
                    ((f7.q) r0Var.f7255a).d(arrayList);
                }
            }
        });
    }
}
