package androidx.appcompat.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.Window;
import androidx.camera.core.impl.a1;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.AddressBookBean;
import com.example.blesdk.bean.function.AlarmRemainderBean;
import com.example.blesdk.bean.function.BrightScreenLedBean;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.blesdk.bean.function.GameChildAppBean;
import com.example.blesdk.bean.function.SwitchStatusBean;
import com.example.test.XXApplication;
import com.example.test.presenter.device.c1;
import com.example.test.presenter.device.d1;
import com.example.test.presenter.device.f1;
import com.example.test.presenter.device.q0;
import com.example.test.presenter.device.r0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.AlarmActivity;
import com.example.test.ui.device.activity.BoWatcherActivity;
import com.example.test.ui.device.activity.BtWatcherActivity;
import com.example.test.ui.device.activity.ContactActivity;
import com.example.test.ui.device.activity.CustomDialActivity;
import com.example.test.ui.device.activity.CustomJLDialActivity;
import com.example.test.ui.device.activity.DeviceScanActivity;
import com.example.test.ui.device.activity.DialMarketActivity;
import com.example.test.ui.device.activity.DrinkActivity;
import com.example.test.ui.device.activity.GameWatchAppActivity;
import com.example.test.ui.device.activity.HrWatcherActivity;
import com.example.test.ui.device.activity.HrWatcherJlActivity;
import com.example.test.ui.device.activity.LongSitActivity;
import com.example.test.ui.device.activity.MessagePushActivity;
import com.example.test.ui.device.activity.OtaActivity;
import com.example.test.ui.device.activity.RingMessagePushActivity;
import com.example.test.ui.device.activity.ScanQrCodeActivity;
import com.example.test.ui.device.activity.ScanQrMlActivity;
import com.example.test.ui.device.activity.ScreenLedLevelActivity;
import com.example.test.ui.device.activity.ScreenLightActivity;
import com.example.test.ui.device.model.AlarmModel;
import com.example.test.ui.device.model.ContactModel;
import com.example.test.ui.device.model.MessageModel;
import com.example.test.ui.device.model.MsgDataModel;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import f6.m1;
import f6.t0;
import f6.w2;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class t implements h.w, androidx.appcompat.widget.p, a1, m1.o, t6.b, a7.e, t6.a, t6.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f567a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f568b;

    public /* synthetic */ t(Object obj, int i3) {
        this.f567a = i3;
        this.f568b = obj;
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void i() {
    }

    private final void j() {
    }

    private final void k() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a7.e
    public void B() {
        char c9 = 3;
        switch (this.f567a) {
            case 10:
                int i3 = AlarmActivity.I;
                AlarmActivity alarmActivity = (AlarmActivity) this.f568b;
                com.example.test.presenter.device.c cVar = (com.example.test.presenter.device.c) alarmActivity.I0();
                List<AlarmModel> data = alarmActivity.S0();
                cVar.getClass();
                kotlin.jvm.internal.e.f(data, "data");
                ArrayList reminderBeans = cVar.f7414b;
                reminderBeans.clear();
                ((XXBaseActivity) ((f7.a) cVar.f7255a)).V();
                for (AlarmModel alarmModel : data) {
                    if (!alarmModel.isAdd()) {
                        AlarmRemainderBean alarmRemainderBean = new AlarmRemainderBean();
                        alarmRemainderBean.setAlarmTag(alarmModel.getAlarmTag());
                        alarmRemainderBean.setRepeatModel(alarmModel.getRepeatModel());
                        alarmRemainderBean.setStartHour(alarmModel.getStartHour());
                        alarmRemainderBean.setStartMin(alarmModel.getStartMin());
                        alarmRemainderBean.setOpen(alarmModel.isOpen());
                        reminderBeans.add(alarmRemainderBean);
                    }
                }
                kotlin.jvm.internal.e.f(reminderBeans, "reminderBeans");
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) 40);
                    return;
                }
                x5.d c10 = x5.d.c();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getAlarmCmd " + com.example.baselibrary.utils.b.z(reminderBeans));
                ArrayList arrayList = new ArrayList();
                int size = reminderBeans.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = reminderBeans.get(i10);
                    i10++;
                    AlarmRemainderBean alarmRemainderBean2 = (AlarmRemainderBean) obj;
                    byte[] n4 = y5.b.n(alarmRemainderBean2.getAlarmTag());
                    byte[] bArr = new byte[n4.length + 6];
                    char c11 = c9;
                    bArr[0] = (byte) ((alarmRemainderBean2.isOpen() ? 1 : 0) & 255);
                    bArr[1] = (byte) (alarmRemainderBean2.getStartHour() & 255);
                    bArr[2] = (byte) (alarmRemainderBean2.getStartMin() & 255);
                    bArr[c11] = y5.b.q(alarmRemainderBean2.getRepeatModel());
                    bArr[4] = (byte) ((alarmRemainderBean2.isDelayRemain() ? 1 : 0) & 255);
                    bArr[5] = (byte) (n4.length & 255);
                    System.arraycopy(n4, 0, bArr, 6, n4.length);
                    arrayList.add(bArr);
                    c9 = c11;
                }
                int size2 = arrayList.size();
                int i11 = 0;
                int i12 = 0;
                while (i12 < size2) {
                    Object obj2 = arrayList.get(i12);
                    i12++;
                    i11 += ((byte[]) obj2).length;
                }
                byte[] bArr2 = new byte[i11 + 1];
                int size3 = reminderBeans.size();
                char[] cArr = y5.b.f20001a;
                bArr2[0] = (byte) (size3 & 255);
                int size4 = arrayList.size();
                int i13 = 0;
                int i14 = 1;
                while (i13 < size4) {
                    Object obj3 = arrayList.get(i13);
                    i13++;
                    byte[] bArr3 = (byte[]) obj3;
                    System.arraycopy(bArr3, 0, bArr2, i14, bArr3.length);
                    i14 += bArr3.length;
                }
                c10.j((byte) 40, bArr2);
                return;
            case 11:
            case 18:
            case 20:
            case 21:
            case 22:
            default:
                int i15 = ScreenLedLevelActivity.H;
                ScreenLedLevelActivity screenLedLevelActivity = (ScreenLedLevelActivity) this.f568b;
                f1 f1Var = (f1) screenLedLevelActivity.I0();
                BrightScreenLedBean data2 = screenLedLevelActivity.S0();
                f1Var.getClass();
                kotlin.jvm.internal.e.f(data2, "data");
                f1Var.f7428b = data2;
                ((XXBaseActivity) ((f7.x) f1Var.f7255a)).V();
                com.google.android.gms.internal.mlkit_vision_common.p.C(data2);
                return;
            case 12:
                int i16 = BtWatcherActivity.I;
                BtWatcherActivity btWatcherActivity = (BtWatcherActivity) this.f568b;
                btWatcherActivity.S0().setOpen(((w2) btWatcherActivity.f7247z.getValue()).f13427g.getItemOpen());
                com.example.test.presenter.device.m mVar = (com.example.test.presenter.device.m) btWatcherActivity.I0();
                DrinkReminderBean data3 = btWatcherActivity.S0();
                mVar.getClass();
                kotlin.jvm.internal.e.f(data3, "data");
                mVar.f7459b = data3;
                ((XXBaseActivity) ((f7.k) mVar.f7255a)).V();
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) -47);
                    return;
                }
                x5.c b3 = x5.c.b();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedBodyTemperatureWCmdJL " + data3);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(data3.isOpen() ? 1 : 0);
                sb2.append(Byte.valueOf((byte) data3.getRepeatModel()[0]));
                sb2.append(Byte.valueOf((byte) data3.getRepeatModel()[6]));
                sb2.append(Byte.valueOf((byte) data3.getRepeatModel()[5]));
                sb2.append(Byte.valueOf((byte) data3.getRepeatModel()[4]));
                sb2.append(Byte.valueOf((byte) data3.getRepeatModel()[3]));
                sb2.append(Byte.valueOf((byte) data3.getRepeatModel()[2]));
                sb2.append(Byte.valueOf((byte) data3.getRepeatModel()[1]));
                b3.g((byte) -47, new byte[]{2, 27, 0, y5.b.b(sb2.toString()), (byte) (data3.getStartHour() & 255), (byte) (data3.getStartMin() & 255), (byte) (data3.getEndHour() & 255), (byte) (data3.getEndMin() & 255), (byte) (data3.getRemindDuration() & 255)}, new boolean[0]);
                return;
            case 13:
                int i17 = ContactActivity.I;
                ContactActivity contactActivity = (ContactActivity) this.f568b;
                com.example.test.presenter.device.q qVar = (com.example.test.presenter.device.q) contactActivity.I0();
                List data4 = contactActivity.S0();
                qVar.getClass();
                kotlin.jvm.internal.e.f(data4, "data");
                ((XXBaseActivity) ((f7.d) qVar.f7255a)).V();
                ArrayList addressBookBean = qVar.f7471b;
                addressBookBean.clear();
                Iterator it = data4.iterator();
                while (true) {
                    String str = "";
                    if (!it.hasNext()) {
                        kotlin.jvm.internal.e.f(addressBookBean, "addressBookBean");
                        if (!r5.b.k().f18054c) {
                            x5.b.I0().F0((byte) 45);
                            return;
                        }
                        int size5 = addressBookBean.size();
                        int i18 = 0;
                        while (i18 < size5) {
                            Object obj4 = addressBookBean.get(i18);
                            i18++;
                            AddressBookBean addressBookBean2 = (AddressBookBean) obj4;
                            String contactNum = addressBookBean2.getContactNum();
                            kotlin.jvm.internal.e.e(contactNum, "getContactNum(...)");
                            addressBookBean2.setContactNum(kotlin.text.m.r(contactNum, " ", ""));
                        }
                        x5.d c12 = x5.d.c();
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getAddressCmd " + com.example.baselibrary.utils.b.z(addressBookBean));
                        ArrayList arrayList2 = new ArrayList();
                        int size6 = addressBookBean.size();
                        int i19 = 0;
                        while (i19 < size6) {
                            Object obj5 = addressBookBean.get(i19);
                            i19++;
                            AddressBookBean addressBookBean3 = (AddressBookBean) obj5;
                            byte[] n8 = y5.b.n(addressBookBean3.getContactName());
                            byte[] n10 = y5.b.n(addressBookBean3.getContactNum());
                            byte[] bArr4 = new byte[n8.length + 2 + n10.length];
                            bArr4[0] = (byte) (n8.length & 255);
                            System.arraycopy(n8, 0, bArr4, 1, n8.length);
                            bArr4[n8.length + 1] = (byte) (n10.length & 255);
                            System.arraycopy(n10, 0, bArr4, n8.length + 2, n10.length);
                            arrayList2.add(bArr4);
                        }
                        int size7 = arrayList2.size();
                        int i20 = 0;
                        int i21 = 0;
                        while (i21 < size7) {
                            Object obj6 = arrayList2.get(i21);
                            i21++;
                            i20 += ((byte[]) obj6).length;
                        }
                        byte[] bArr5 = new byte[i20 + 1];
                        int size8 = addressBookBean.size();
                        char[] cArr2 = y5.b.f20001a;
                        bArr5[0] = (byte) (size8 & 255);
                        int size9 = arrayList2.size();
                        int i22 = 0;
                        int i23 = 1;
                        while (i22 < size9) {
                            Object obj7 = arrayList2.get(i22);
                            i22++;
                            byte[] bArr6 = (byte[]) obj7;
                            System.arraycopy(bArr6, 0, bArr5, i23, bArr6.length);
                            i23 += bArr6.length;
                        }
                        c12.j((byte) 45, bArr5);
                        return;
                    }
                    ContactModel contactModel = (ContactModel) it.next();
                    AddressBookBean addressBookBean4 = new AddressBookBean();
                    addressBookBean4.setContactName(contactModel.getContactName());
                    String contactType = contactModel.getContactType();
                    if (contactType != null && contactType.length() != 0) {
                        String contactType2 = contactModel.getContactType();
                        kotlin.jvm.internal.e.e(contactType2, "getContactType(...)");
                        str = kotlin.text.m.r(contactType2, " ", "");
                    }
                    addressBookBean4.setContactNum(str);
                    addressBookBean.add(addressBookBean4);
                }
                break;
            case 14:
            case 15:
                return;
            case 16:
                int i24 = DeviceScanActivity.I;
                DeviceScanActivity deviceScanActivity = (DeviceScanActivity) this.f568b;
                if (deviceScanActivity.R0()) {
                    ((f6.w) deviceScanActivity.f7247z.getValue()).f13414c.a();
                    ((com.example.test.presenter.device.u) deviceScanActivity.I0()).getClass();
                    com.example.test.presenter.device.u.l();
                    return;
                }
                return;
            case 17:
                return;
            case 19:
                int i25 = GameWatchAppActivity.M;
                GameWatchAppActivity gameWatchAppActivity = (GameWatchAppActivity) this.f568b;
                GameChildAppBean R0 = gameWatchAppActivity.R0();
                eh.b bVar = gameWatchAppActivity.f7247z;
                R0.setIsAll(((f6.g0) bVar.getValue()).f12898b.getItemOpen() ? 1 : 0);
                if (gameWatchAppActivity.R0().getIsChildGame() != 255) {
                    gameWatchAppActivity.R0().setIsChildGame(((f6.g0) bVar.getValue()).e.getItemOpen() ? 1 : 0);
                }
                if (gameWatchAppActivity.R0().getIsBedtimeStories() != 255) {
                    gameWatchAppActivity.R0().setIsBedtimeStories(((f6.g0) bVar.getValue()).f12900d.getItemOpen() ? 1 : 0);
                }
                if (gameWatchAppActivity.R0().getIsMusic() != 255) {
                    gameWatchAppActivity.R0().setIsMusic(((f6.g0) bVar.getValue()).f12902g.getItemOpen() ? 1 : 0);
                }
                if (gameWatchAppActivity.R0().getIsLearningCards() != 255) {
                    gameWatchAppActivity.R0().setIsLearningCards(((f6.g0) bVar.getValue()).f12901f.getItemOpen() ? 1 : 0);
                }
                if (gameWatchAppActivity.R0().getIsAudioStory() != 255) {
                    gameWatchAppActivity.R0().setIsAudioStory(((f6.g0) bVar.getValue()).f12899c.getItemOpen() ? 1 : 0);
                }
                com.example.test.presenter.device.e0 e0Var = (com.example.test.presenter.device.e0) gameWatchAppActivity.I0();
                GameChildAppBean data5 = gameWatchAppActivity.R0();
                e0Var.getClass();
                kotlin.jvm.internal.e.f(data5, "data");
                e0Var.f7421b = data5;
                ((XXBaseActivity) ((f7.l) e0Var.f7255a)).V();
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) 40);
                    return;
                }
                x5.c b10 = x5.c.b();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getChildAppCmdJL " + data5);
                int isAll = data5.getIsAll();
                char[] cArr3 = y5.b.f20001a;
                b10.g((byte) 40, new byte[]{2, 109, 0, (byte) (isAll & 255), (byte) (data5.getIsBedtimeStories() & 255), (byte) (data5.getIsChildGame() & 255), (byte) (data5.getIsMusic() & 255), (byte) (data5.getIsLearningCards() & 255), (byte) (data5.getIsAudioStory() & 255)}, new boolean[0]);
                return;
            case 23:
                MessagePushActivity messagePushActivity = (MessagePushActivity) this.f568b;
                int i26 = MessagePushActivity.H;
                r0 r0Var = (r0) messagePushActivity.I0();
                List<MessageModel> data6 = ((MessagePushActivity) this.f568b).R0();
                boolean itemOpen = ((t0) ((MessagePushActivity) this.f568b).f7247z.getValue()).f13335c.getItemOpen();
                r0Var.getClass();
                kotlin.jvm.internal.e.f(data6, "data");
                ((XXBaseActivity) ((f7.q) r0Var.f7255a)).V();
                ArrayList arrayList3 = new ArrayList();
                SwitchStatusBean switchStatusBean = new SwitchStatusBean();
                for (MessageModel messageModel : data6) {
                    MsgDataModel msgDataModel = new MsgDataModel();
                    msgDataModel.setOpen(messageModel.isSelected());
                    msgDataModel.setAppId(messageModel.getId());
                    arrayList3.add(msgDataModel);
                    switch (messageModel.getId()) {
                        case 0:
                            switchStatusBean.setPhoneCall(messageModel.isSelected());
                            break;
                        case 1:
                            switchStatusBean.setSms(messageModel.isSelected());
                            break;
                        case 2:
                            switchStatusBean.setQQ(messageModel.isSelected());
                            break;
                        case 3:
                            switchStatusBean.setWeChat(messageModel.isSelected());
                            break;
                        case 4:
                            switchStatusBean.setWhatsApp(messageModel.isSelected());
                            break;
                        case 5:
                            switchStatusBean.setMessenger(messageModel.isSelected());
                            break;
                        case 6:
                            switchStatusBean.setTwitter(messageModel.isSelected());
                            break;
                        case 7:
                            switchStatusBean.setLinkedin(messageModel.isSelected());
                            break;
                        case 8:
                            switchStatusBean.setInstagram(messageModel.isSelected());
                            break;
                        case 9:
                            switchStatusBean.setFacebook(messageModel.isSelected());
                            break;
                        case 10:
                            switchStatusBean.setLine(messageModel.isSelected());
                            break;
                        case 11:
                            switchStatusBean.setWeWork(messageModel.isSelected());
                            break;
                        case 12:
                            switchStatusBean.setDingDing(messageModel.isSelected());
                            break;
                        case 13:
                            switchStatusBean.setEmail(messageModel.isSelected());
                            break;
                        case 14:
                            switchStatusBean.setCalendar(messageModel.isSelected());
                            break;
                        case 15:
                            switchStatusBean.setViber(messageModel.isSelected());
                            break;
                        case 16:
                            switchStatusBean.setSkype(messageModel.isSelected());
                            break;
                        case 17:
                            switchStatusBean.setKakaoTalk(messageModel.isSelected());
                            break;
                        case 18:
                            switchStatusBean.setTumblr(messageModel.isSelected());
                            break;
                        case 19:
                            switchStatusBean.setSnapchat(messageModel.isSelected());
                            break;
                        case 20:
                            switchStatusBean.setYoutube(messageModel.isSelected());
                            break;
                        case 21:
                            switchStatusBean.setPinterset(messageModel.isSelected());
                            break;
                        case 22:
                            switchStatusBean.setTiktok(messageModel.isSelected());
                            break;
                        case 23:
                            switchStatusBean.setGmail(messageModel.isSelected());
                            break;
                        case 24:
                            switchStatusBean.setOther(messageModel.isSelected());
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                            switchStatusBean.setWeibo(messageModel.isSelected());
                            break;
                        case Const.ANDROID_VERSION_28 /* 28 */:
                            switchStatusBean.setBand(messageModel.isSelected());
                            break;
                        case Const.ANDROID_VERSION_29 /* 29 */:
                            switchStatusBean.setTelegram(messageModel.isSelected());
                            break;
                        case 30:
                            switchStatusBean.setBetween(messageModel.isSelected());
                            break;
                        case 31:
                            switchStatusBean.setNaverCafe(messageModel.isSelected());
                            break;
                        case 32:
                            switchStatusBean.setNetFlix(messageModel.isSelected());
                            break;
                        case 34:
                            switchStatusBean.setMax(messageModel.isSelected());
                            break;
                        case 35:
                            switchStatusBean.setVk(messageModel.isSelected());
                            break;
                        case 36:
                            switchStatusBean.setRuMail(messageModel.isSelected());
                            break;
                        case 37:
                            switchStatusBean.setYandexMail(messageModel.isSelected());
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_VIDEO_FILE /* 38 */:
                            switchStatusBean.setYandexTaxi(messageModel.isSelected());
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_GAME_VIDEO_FILE /* 39 */:
                            switchStatusBean.setVkontakte(messageModel.isSelected());
                            break;
                        case 40:
                            switchStatusBean.setWildberries(messageModel.isSelected());
                            break;
                        case 41:
                            switchStatusBean.setOzon(messageModel.isSelected());
                            break;
                        case 42:
                            switchStatusBean.setMakc(messageModel.isSelected());
                            break;
                    }
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                switchStatusBean.setPhoneCall(kVar != null ? kVar.I(com.example.test.service.e.h().g().f18212c) : false);
                switchStatusBean.setAll(itemOpen);
                r0Var.f7475c = arrayList3;
                if (y5.d.f20005b) {
                    com.google.android.gms.internal.mlkit_vision_common.p.T(-41, (q0) r0Var.f7474b.getValue());
                    com.google.android.gms.internal.mlkit_vision_common.p.H(switchStatusBean);
                    return;
                } else {
                    com.google.android.gms.internal.mlkit_vision_common.p.T(35, (q0) r0Var.f7474b.getValue());
                    com.google.android.gms.internal.mlkit_vision_common.p.G(switchStatusBean);
                    return;
                }
            case 24:
                return;
            case 25:
                RingMessagePushActivity ringMessagePushActivity = (RingMessagePushActivity) this.f568b;
                int i27 = RingMessagePushActivity.H;
                d1 d1Var = (d1) ringMessagePushActivity.I0();
                List<MessageModel> data7 = ((RingMessagePushActivity) this.f568b).R0();
                boolean itemOpen2 = ((m1) ((RingMessagePushActivity) this.f568b).f7247z.getValue()).f13120c.getItemOpen();
                d1Var.getClass();
                kotlin.jvm.internal.e.f(data7, "data");
                ((XXBaseActivity) ((f7.q) d1Var.f7255a)).V();
                ArrayList arrayList4 = new ArrayList();
                SwitchStatusBean switchStatusBean2 = new SwitchStatusBean();
                for (MessageModel messageModel2 : data7) {
                    MsgDataModel msgDataModel2 = new MsgDataModel();
                    msgDataModel2.setOpen(messageModel2.isSelected());
                    msgDataModel2.setAppId(messageModel2.getId());
                    arrayList4.add(msgDataModel2);
                    switch (messageModel2.getId()) {
                        case 0:
                            switchStatusBean2.setPhoneCall(messageModel2.isSelected());
                            if (com.example.test.utils.k.f8731b == null) {
                                synchronized (com.example.test.utils.k.class) {
                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                }
                            }
                            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                            if (kVar2 != null) {
                                String str2 = com.example.test.service.e.h().g().f18212c;
                                kotlin.jvm.internal.e.e(str2, "getBleMac(...)");
                                kVar2.U(str2, messageModel2.isSelected());
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            switchStatusBean2.setSms(messageModel2.isSelected());
                            break;
                        case 2:
                            switchStatusBean2.setQQ(messageModel2.isSelected());
                            break;
                        case 3:
                            switchStatusBean2.setWeChat(messageModel2.isSelected());
                            break;
                        case 4:
                            switchStatusBean2.setWhatsApp(messageModel2.isSelected());
                            break;
                        case 5:
                            switchStatusBean2.setMessenger(messageModel2.isSelected());
                            break;
                        case 6:
                            switchStatusBean2.setTwitter(messageModel2.isSelected());
                            break;
                        case 7:
                            switchStatusBean2.setLinkedin(messageModel2.isSelected());
                            break;
                        case 8:
                            switchStatusBean2.setInstagram(messageModel2.isSelected());
                            break;
                        case 9:
                            switchStatusBean2.setFacebook(messageModel2.isSelected());
                            break;
                        case 10:
                            switchStatusBean2.setLine(messageModel2.isSelected());
                            break;
                        case 11:
                            switchStatusBean2.setWeWork(messageModel2.isSelected());
                            break;
                        case 12:
                            switchStatusBean2.setDingDing(messageModel2.isSelected());
                            break;
                        case 13:
                            switchStatusBean2.setEmail(messageModel2.isSelected());
                            break;
                        case 14:
                            switchStatusBean2.setCalendar(messageModel2.isSelected());
                            break;
                        case 15:
                            switchStatusBean2.setViber(messageModel2.isSelected());
                            break;
                        case 16:
                            switchStatusBean2.setSkype(messageModel2.isSelected());
                            break;
                        case 17:
                            switchStatusBean2.setKakaoTalk(messageModel2.isSelected());
                            break;
                        case 18:
                            switchStatusBean2.setTumblr(messageModel2.isSelected());
                            break;
                        case 19:
                            switchStatusBean2.setSnapchat(messageModel2.isSelected());
                            break;
                        case 20:
                            switchStatusBean2.setYoutube(messageModel2.isSelected());
                            break;
                        case 21:
                            switchStatusBean2.setPinterset(messageModel2.isSelected());
                            break;
                        case 22:
                            switchStatusBean2.setTiktok(messageModel2.isSelected());
                            break;
                        case 23:
                            switchStatusBean2.setGmail(messageModel2.isSelected());
                            break;
                        case 24:
                            switchStatusBean2.setOther(messageModel2.isSelected());
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                            switchStatusBean2.setWeibo(messageModel2.isSelected());
                            break;
                        case Const.ANDROID_VERSION_28 /* 28 */:
                            switchStatusBean2.setBand(messageModel2.isSelected());
                            break;
                        case Const.ANDROID_VERSION_29 /* 29 */:
                            switchStatusBean2.setTelegram(messageModel2.isSelected());
                            break;
                        case 30:
                            switchStatusBean2.setBetween(messageModel2.isSelected());
                            break;
                        case 31:
                            switchStatusBean2.setNaverCafe(messageModel2.isSelected());
                            break;
                        case 32:
                            switchStatusBean2.setNetFlix(messageModel2.isSelected());
                            break;
                        case 34:
                            switchStatusBean2.setMax(messageModel2.isSelected());
                            break;
                        case 35:
                            switchStatusBean2.setVk(messageModel2.isSelected());
                            break;
                        case 36:
                            switchStatusBean2.setRuMail(messageModel2.isSelected());
                            break;
                        case 37:
                            switchStatusBean2.setYandexMail(messageModel2.isSelected());
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_VIDEO_FILE /* 38 */:
                            switchStatusBean2.setYandexTaxi(messageModel2.isSelected());
                            break;
                        case WXMediaMessage.IMediaObject.TYPE_GAME_VIDEO_FILE /* 39 */:
                            switchStatusBean2.setVkontakte(messageModel2.isSelected());
                            break;
                        case 40:
                            switchStatusBean2.setWildberries(messageModel2.isSelected());
                            break;
                        case 41:
                            switchStatusBean2.setOzon(messageModel2.isSelected());
                            break;
                        case 42:
                            switchStatusBean2.setMakc(messageModel2.isSelected());
                            break;
                    }
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                boolean I = kVar3 != null ? kVar3.I(com.example.test.service.e.h().g().f18212c) : false;
                Log.e("qob", "incomingCall " + I);
                switchStatusBean2.setPhoneCall(I);
                switchStatusBean2.setAll(itemOpen2);
                d1Var.f7419c = arrayList4;
                if (y5.d.f20005b) {
                    com.google.android.gms.internal.mlkit_vision_common.p.T(-41, (c1) d1Var.f7418b.getValue());
                    com.google.android.gms.internal.mlkit_vision_common.p.H(switchStatusBean2);
                    return;
                } else {
                    com.google.android.gms.internal.mlkit_vision_common.p.T(35, (c1) d1Var.f7418b.getValue());
                    com.google.android.gms.internal.mlkit_vision_common.p.G(switchStatusBean2);
                    return;
                }
        }
    }

    @Override // androidx.camera.core.impl.a1
    public void a(Object obj) {
        ((k1.a) this.f568b).f(obj);
    }

    @Override // h.w
    public void b(h.k kVar, boolean z5) {
        switch (this.f567a) {
            case 0:
                ((c0) this.f568b).r(kVar);
                break;
            default:
                if (kVar instanceof h.d0) {
                    ((h.d0) kVar).f14106z.k().c(false);
                }
                h.w wVar = ((androidx.appcompat.widget.l) this.f568b).e;
                if (wVar != null) {
                    wVar.b(kVar, z5);
                    break;
                }
                break;
        }
    }

    @Override // h.w
    public boolean c(h.k kVar) {
        switch (this.f567a) {
            case 0:
                Window.Callback callback = ((c0) this.f568b).f433l.getCallback();
                if (callback == null) {
                    return true;
                }
                callback.onMenuOpened(108, kVar);
                return true;
            default:
                androidx.appcompat.widget.l lVar = (androidx.appcompat.widget.l) this.f568b;
                if (kVar == lVar.f955c) {
                    return false;
                }
                lVar.f975y = ((h.d0) kVar).A.f14169a;
                h.w wVar = lVar.e;
                if (wVar != null) {
                    return wVar.c(kVar);
                }
                return false;
        }
    }

    @Override // m1.o
    public boolean g(View view) {
        int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
        ViewPager2 viewPager2 = (ViewPager2) ((v2.h) this.f568b).f19149d;
        if (viewPager2.r) {
            viewPager2.c(currentItem, true);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x01f7, code lost:
    
        if (r5 == 12) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0228, code lost:
    
        if (r5 == 12) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r5 == 12) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        if (r5 == 12) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
    
        if (r5 == 12) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d5, code lost:
    
        if (r5 == 12) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0115, code lost:
    
        if (r5 == 12) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0146, code lost:
    
        if (r5 == 12) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0186, code lost:
    
        if (r5 == 12) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01b7, code lost:
    
        if (r5 == 12) goto L105;
     */
    @Override // t6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(int r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.t.h(int, int, int):void");
    }

    @Override // t6.b
    public void onCancel() {
        switch (this.f567a) {
            case 9:
                ((com.example.test.service.p0) this.f568b).getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "======== cancel");
                break;
        }
    }

    @Override // androidx.camera.core.impl.a1
    public void onError(Throwable th2) {
        com.google.android.gms.internal.mlkit_vision_common.a0.c("ObserverToConsumerAdapter", "Unexpected error in Observable", th2);
    }

    @Override // t6.b
    public void s() {
        Object obj = this.f568b;
        switch (this.f567a) {
            case 9:
                ((com.example.test.service.p0) obj).getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "======== pair");
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.ruiwo168.com/app/download.html"));
                XXApplication xXApplication = XXApplication.f7400h;
                Activity c9 = j1.a().c();
                if (c9 != null) {
                    c9.startActivity(intent);
                    break;
                }
                break;
            case 26:
                ScanQrCodeActivity scanQrCodeActivity = (ScanQrCodeActivity) obj;
                scanQrCodeActivity.getClass();
                v2.h hVar = new v2.h(scanQrCodeActivity);
                hVar.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                hVar.p(new b9.a(5));
                break;
            default:
                v2.h hVar2 = new v2.h(((ScanQrMlActivity) obj).getApplicationContext());
                hVar2.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                hVar2.p(new b9.a(8));
                break;
        }
    }

    @Override // a7.e
    public void u0() {
        switch (this.f567a) {
            case 10:
                ((AlarmActivity) this.f568b).onBackPressed();
                break;
            case 11:
            case 18:
            case 20:
            case 21:
            case 22:
            default:
                ((ScreenLedLevelActivity) this.f568b).onBackPressed();
                break;
            case 12:
                ((BtWatcherActivity) this.f568b).onBackPressed();
                break;
            case 13:
                ((ContactActivity) this.f568b).onBackPressed();
                break;
            case 14:
                ((CustomDialActivity) this.f568b).onBackPressed();
                break;
            case 15:
                ((CustomJLDialActivity) this.f568b).onBackPressed();
                break;
            case 16:
                ((DeviceScanActivity) this.f568b).onBackPressed();
                break;
            case 17:
                ((DialMarketActivity) this.f568b).onBackPressed();
                break;
            case 19:
                ((GameWatchAppActivity) this.f568b).onBackPressed();
                break;
            case 23:
                ((MessagePushActivity) this.f568b).onBackPressed();
                break;
            case 24:
                ((OtaActivity) this.f568b).onBackPressed();
                break;
            case 25:
                ((RingMessagePushActivity) this.f568b).onBackPressed();
                break;
        }
    }

    @Override // t6.a
    public void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        int i3 = BoWatcherActivity.I;
        BoWatcherActivity boWatcherActivity = (BoWatcherActivity) this.f568b;
        boWatcherActivity.S0().setRemindDuration(Integer.parseInt(data));
        boWatcherActivity.R0();
    }

    @Override // t6.d
    public void y() {
        switch (this.f567a) {
            case 18:
                ((DrinkActivity) this.f568b).F = false;
                break;
            case 19:
            default:
                ((ScreenLightActivity) this.f568b).E = false;
                break;
            case 20:
                ((HrWatcherActivity) this.f568b).E = false;
                break;
            case 21:
                ((HrWatcherJlActivity) this.f568b).F = false;
                break;
            case 22:
                ((LongSitActivity) this.f568b).E = false;
                break;
        }
    }

    public t(b2.h hVar) {
        this.f567a = 8;
        this.f568b = Collections.unmodifiableMap(new HashMap(hVar.f3120a));
    }

    public t() {
        this.f567a = 6;
        this.f568b = new ArrayDeque();
    }
}
