package com.example.test.service;

import com.example.blesdk.bean.function.SwitchStatusBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.device.model.MsgDataModel;
import com.example.test.ui.model.EventBusBeans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class r1 implements v5.u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f7779a;

    public r1(u1 u1Var) {
        this.f7779a = u1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        this.f7779a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "获取设备开关信息失败，原因:" + i3);
        if (y5.d.f20005b) {
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
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        SwitchStatusBean switchStatusBean = (SwitchStatusBean) obj;
        this.f7779a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "获取设备开关信息成功");
        if (switchStatusBean != null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", String.valueOf(switchStatusBean));
            if (y5.d.f20005b) {
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
                    if (cVar != null) {
                        linkedList.remove(cVar);
                    }
                }
            }
            com.example.baselibrary.utils.b.x(switchStatusBean, new oh.l() { // from class: com.example.test.service.SyncService$switchCallback$2$1$onResult$1$1
                @Override // oh.l
                public final Long invoke(SwitchStatusBean it2) {
                    kotlin.jvm.internal.e.f(it2, "it");
                    ArrayList arrayList = new ArrayList();
                    String str = e.h().g().f18212c;
                    if (y5.d.f20005b) {
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null) {
                            kotlin.jvm.internal.e.c(str);
                            kVar.U(str, it2.isPhoneCall());
                        }
                        yh.d.b().e(new EventBusBeans.IncomingCallEvent(it2.isPhoneCall()));
                    }
                    arrayList.add(new MsgDataModel(0, it2.isPhoneCall()));
                    arrayList.add(new MsgDataModel(1, it2.isSms()));
                    arrayList.add(new MsgDataModel(2, it2.isQQ()));
                    arrayList.add(new MsgDataModel(3, it2.isWeChat()));
                    arrayList.add(new MsgDataModel(4, it2.isWhatsApp()));
                    arrayList.add(new MsgDataModel(5, it2.isMessenger()));
                    arrayList.add(new MsgDataModel(6, it2.isTwitter()));
                    arrayList.add(new MsgDataModel(7, it2.isLinkedin()));
                    arrayList.add(new MsgDataModel(8, it2.isInstagram()));
                    arrayList.add(new MsgDataModel(9, it2.isFacebook()));
                    arrayList.add(new MsgDataModel(10, it2.isLine()));
                    arrayList.add(new MsgDataModel(11, it2.isWeWork()));
                    arrayList.add(new MsgDataModel(12, it2.isDingDing()));
                    arrayList.add(new MsgDataModel(13, it2.isEmail()));
                    arrayList.add(new MsgDataModel(14, it2.isCalendar()));
                    arrayList.add(new MsgDataModel(15, it2.isViber()));
                    arrayList.add(new MsgDataModel(16, it2.isSkype()));
                    arrayList.add(new MsgDataModel(17, it2.isKakaoTalk()));
                    arrayList.add(new MsgDataModel(18, it2.isTumblr()));
                    arrayList.add(new MsgDataModel(19, it2.isSnapchat()));
                    arrayList.add(new MsgDataModel(20, it2.isYoutube()));
                    arrayList.add(new MsgDataModel(21, it2.isPinterset()));
                    arrayList.add(new MsgDataModel(22, it2.isTiktok()));
                    arrayList.add(new MsgDataModel(23, it2.isGmail()));
                    arrayList.add(new MsgDataModel(24, it2.isOther()));
                    arrayList.add(new MsgDataModel(27, it2.isWeibo()));
                    arrayList.add(new MsgDataModel(28, it2.isBand()));
                    arrayList.add(new MsgDataModel(29, it2.isTelegram()));
                    arrayList.add(new MsgDataModel(30, it2.isBetween()));
                    arrayList.add(new MsgDataModel(31, it2.isNaverCafe()));
                    arrayList.add(new MsgDataModel(32, it2.isNetFlix()));
                    arrayList.add(new MsgDataModel(34, it2.isMax()));
                    arrayList.add(new MsgDataModel(35, it2.isVk()));
                    arrayList.add(new MsgDataModel(36, it2.isRuMail()));
                    arrayList.add(new MsgDataModel(37, it2.isYandexMail()));
                    arrayList.add(new MsgDataModel(38, it2.isYandexTaxi()));
                    arrayList.add(new MsgDataModel(39, it2.isVkontakte()));
                    arrayList.add(new MsgDataModel(40, it2.isWildberries()));
                    arrayList.add(new MsgDataModel(41, it2.isOzon()));
                    arrayList.add(new MsgDataModel(42, it2.isMakc()));
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(str);
                    dataSetting.setDataKey("setting_message");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(arrayList));
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    User d5 = kVar2 != null ? kVar2.d() : null;
                    if (d5 != null) {
                        dataSetting.setUserId(d5.getUserId());
                    }
                    return Long.valueOf(SettingImpl.INSTANCE.saveData(dataSetting));
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$switchCallback$2$1$onResult$1$2
                public final void invoke(long j4) {
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Number) obj2).longValue());
                    return eh.g.f12633a;
                }
            });
        }
    }
}
