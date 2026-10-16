package com.google.android.gms.internal.mlkit_vision_common;

import android.util.Log;
import com.example.blesdk.bean.function.AlarmRemainderBean;
import com.example.blesdk.bean.function.BindInfoBean;
import com.example.blesdk.bean.function.BrightScreenLedBean;
import com.example.blesdk.bean.function.DateBean;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.blesdk.bean.function.ExchangeSportDataBean;
import com.example.blesdk.bean.function.MsgPushBean;
import com.example.blesdk.bean.function.MusicPushBean;
import com.example.blesdk.bean.function.PersonBean;
import com.example.blesdk.bean.function.ScheduleBean;
import com.example.blesdk.bean.function.SportDataBean;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.blesdk.bean.function.SwitchStatusBean;
import com.example.blesdk.bean.function.UnitBean;
import com.example.blesdk.bean.function.VideoHidBean;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class p {
    public static void A(MsgPushBean msgPushBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -6);
            return;
        }
        msgPushBean.setTitle(y5.b.p(32, msgPushBean.getTitle()));
        msgPushBean.setContent(y5.b.p(250, msgPushBean.getContent()));
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getMsgPushCmdJL " + msgPushBean);
        byte[] n4 = y5.b.n(msgPushBean.getAppId());
        byte[] n8 = y5.b.n(msgPushBean.getContent());
        byte[] n10 = y5.b.n(msgPushBean.getTitle());
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getMsgPushCmd title len " + n10.length + " content len " + n8.length);
        byte[] bArr = new byte[n8.length + 74];
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(msgPushBean.getTimeMill());
        String format = new SimpleDateFormat("yy", Locale.getDefault()).format(Long.valueOf(calendar.getTimeInMillis()));
        kotlin.jvm.internal.e.e(format, "format(...)");
        int parseInt = Integer.parseInt(format);
        int i3 = calendar.get(2) + 1;
        int i10 = calendar.get(5);
        int i11 = calendar.get(11);
        int i12 = calendar.get(12);
        int i13 = calendar.get(13);
        bArr[0] = 4;
        bArr[1] = 1;
        bArr[2] = 0;
        bArr[3] = Byte.MAX_VALUE;
        bArr[4] = (byte) parseInt;
        bArr[5] = (byte) i3;
        bArr[6] = (byte) i10;
        bArr[7] = (byte) i11;
        bArr[8] = (byte) i12;
        bArr[9] = (byte) i13;
        System.arraycopy(n4, 0, bArr, 10, n4.length <= 32 ? n4.length : 32);
        System.arraycopy(n10, 0, bArr, 42, n10.length);
        System.arraycopy(n8, 0, bArr, 74, n8.length);
        b3.g((byte) -6, bArr, new boolean[0]);
    }

    public static void B(MusicPushBean musicPushBean) {
        Log.e("qob", "setPushMusicJL " + musicPushBean.getContent());
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -96);
            return;
        }
        if (y5.d.f20006c || musicPushBean.getContent() == null) {
            return;
        }
        if (musicPushBean.getContent().length() > 200) {
            String content = musicPushBean.getContent();
            kotlin.jvm.internal.e.e(content, "getContent(...)");
            String substring = content.substring(0, 200);
            kotlin.jvm.internal.e.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            musicPushBean.setContent(substring);
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getMusicPushCmdJL " + musicPushBean);
        byte[] n4 = y5.b.n(musicPushBean.getContent());
        byte[] bArr = new byte[n4.length + 5];
        bArr[0] = 4;
        bArr[1] = 2;
        bArr[2] = 0;
        bArr[3] = (byte) musicPushBean.getEntity();
        bArr[4] = (byte) musicPushBean.getAttr();
        System.arraycopy(n4, 0, bArr, 5, n4.length);
        b3.g((byte) -96, bArr, new boolean[0]);
    }

    public static void C(BrightScreenLedBean brightScreenLedBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 24);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getLedLevelWCmdJL " + brightScreenLedBean.isOpen());
        b3.g((byte) 24, new byte[]{2, 102, 0, brightScreenLedBean.isOpen(), (byte) brightScreenLedBean.getLcdLevel()}, new boolean[0]);
    }

    public static void D(SportDataBean sportDataBean) {
        byte b3;
        byte b10;
        double distance;
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -58);
            return;
        }
        x5.c b11 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "获取手机运动模式中需要传输给设备数据 " + sportDataBean);
        byte[] a3 = y5.b.a(sportDataBean.getStep(), 4);
        byte b12 = a3[3];
        byte b13 = a3[2];
        byte b14 = a3[1];
        byte b15 = a3[0];
        byte[] a10 = y5.b.a(sportDataBean.getDistance(), 4);
        byte b16 = a10[3];
        byte b17 = a10[2];
        byte b18 = a10[1];
        byte b19 = a10[0];
        byte[] a11 = y5.b.a(sportDataBean.getCalorie(), 4);
        byte b20 = a11[3];
        byte b21 = a11[2];
        byte b22 = a11[1];
        byte b23 = a11[0];
        byte[] a12 = y5.b.a((int) sportDataBean.getTotalTime(), 2);
        byte b24 = a12[1];
        byte b25 = a12[0];
        long totalTime = sportDataBean.getTotalTime() / 60;
        byte[] a13 = y5.b.a((int) (totalTime != 0 ? sportDataBean.getStep() / totalTime : 0L), 2);
        byte b26 = a13[1];
        byte b27 = a13[0];
        byte[] a14 = y5.b.a(sportDataBean.getAltitude(), 2);
        byte b28 = a14[1];
        byte b29 = a14[0];
        byte[] a15 = y5.b.a(sportDataBean.getPressure(), 2);
        byte b30 = a15[1];
        byte b31 = a15[0];
        byte[] a16 = y5.b.a(sportDataBean.getCurrentPace(), 4);
        byte b32 = a16[3];
        byte b33 = a16[2];
        byte b34 = a16[1];
        byte b35 = a16[0];
        double totalTime2 = sportDataBean.getTotalTime() / 3600.0d;
        if (totalTime2 == 0.0d) {
            b3 = b31;
            b10 = b23;
            distance = 0.0d;
        } else {
            b3 = b31;
            b10 = b23;
            distance = (sportDataBean.getDistance() / 1000.0d) / totalTime2;
        }
        byte[] a17 = y5.b.a(Float.floatToIntBits((float) distance), 4);
        b11.g((byte) -58, new byte[]{2, 35, 0, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b10, b24, b25, b26, b27, b28, b29, b30, b3, b32, b33, b34, b35, a17[3], a17[2], a17[1], a17[0], (byte) (sportDataBean.getWorkMode() & 255), 0, 0, 0}, new boolean[0]);
    }

    public static void E(SportTargetBean sportTargetBean) {
        kotlin.jvm.internal.e.f(sportTargetBean, "sportTargetBean");
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 48);
            return;
        }
        x5.d c9 = x5.d.c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getSportTargetCmd " + sportTargetBean);
        byte[] a3 = y5.b.a(sportTargetBean.getTime(), 2);
        byte b3 = a3[0];
        byte b10 = a3[1];
        byte[] a10 = y5.b.a(sportTargetBean.getCalorie(), 2);
        byte b11 = a10[0];
        byte b12 = a10[1];
        byte[] a11 = y5.b.a(sportTargetBean.getDistance(), 2);
        c9.j((byte) 48, new byte[]{b3, b10, b11, b12, a11[0], a11[1]});
    }

    public static void F(int i3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -19);
            Log.d("tong", "setStepTarget no connect bleservice");
        } else {
            x5.c b3 = x5.c.b();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "getStepTargetCmd "));
            byte[] a3 = y5.b.a(i3, 4);
            b3.g((byte) -19, new byte[]{2, 7, 0, a3[0], a3[1], a3[2], a3[3]}, new boolean[0]);
        }
    }

    public static void G(SwitchStatusBean switchStatusBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 35);
            return;
        }
        x5.d c9 = x5.d.c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getDeviceSwitchCmd " + switchStatusBean);
        c9.j((byte) 35, new byte[]{y5.b.q(new int[]{switchStatusBean.isPhoneCall(), switchStatusBean.isSms(), switchStatusBean.isQQ(), switchStatusBean.isWeChat(), switchStatusBean.isWhatsApp(), switchStatusBean.isMessenger(), switchStatusBean.isTwitter(), switchStatusBean.isLinkedin()}), y5.b.q(new int[]{switchStatusBean.isInstagram(), switchStatusBean.isFacebook(), switchStatusBean.isLine(), switchStatusBean.isWeWork(), switchStatusBean.isDingDing(), switchStatusBean.isEmail(), switchStatusBean.isCalendar(), switchStatusBean.isViber()}), y5.b.q(new int[]{switchStatusBean.isSkype(), switchStatusBean.isKakaoTalk(), switchStatusBean.isTumblr(), switchStatusBean.isSnapchat(), switchStatusBean.isYoutube(), switchStatusBean.isPinterset(), switchStatusBean.isTiktok(), switchStatusBean.isGmail()}), y5.b.q(new int[]{0, 0, 0, 0, 0, 0, 0, switchStatusBean.isOther()})});
    }

    public static void H(SwitchStatusBean switchStatusBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -41);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getDeviceSwitchCmdJL " + switchStatusBean);
        b3.g((byte) -41, new byte[]{2, 20, 0, y5.b.q(new int[]{switchStatusBean.isOther(), switchStatusBean.isPhoneCall(), switchStatusBean.isSms(), switchStatusBean.isEmail(), switchStatusBean.isSkype(), switchStatusBean.isFacebook(), switchStatusBean.isWhatsApp(), switchStatusBean.isLine()}), y5.b.q(new int[]{switchStatusBean.isInstagram(), switchStatusBean.isKakaoTalk(), switchStatusBean.isGmail(), switchStatusBean.isTwitter(), switchStatusBean.isLinkedin(), switchStatusBean.isWeibo(), switchStatusBean.isQQ(), switchStatusBean.isWeChat()}), y5.b.q(new int[]{switchStatusBean.isBand(), switchStatusBean.isTelegram(), switchStatusBean.isBetween(), switchStatusBean.isNaverCafe(), switchStatusBean.isYoutube(), switchStatusBean.isNetFlix(), switchStatusBean.isMax(), switchStatusBean.isVk()}), y5.b.q(new int[]{switchStatusBean.isRuMail(), switchStatusBean.isYandexMail(), switchStatusBean.isYandexTaxi(), switchStatusBean.isVkontakte(), 1, 1, 1, switchStatusBean.isAll()})}, new boolean[0]);
    }

    public static void I(int i3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -18);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "getTempUnitCmd "));
        char[] cArr = y5.b.f20001a;
        b3.g((byte) -18, new byte[]{2, 29, 0, (byte) (i3 & 255)}, new boolean[0]);
    }

    public static void J(DrinkReminderBean drinkReminderBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -53);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedBloodOxygenWCmdJL " + drinkReminderBean);
        byte isOpen = drinkReminderBean.isOpen();
        int startHour = drinkReminderBean.getStartHour();
        char[] cArr = y5.b.f20001a;
        b3.g((byte) -53, new byte[]{2, 37, 0, isOpen, (byte) (startHour & 255), (byte) (drinkReminderBean.getStartMin() & 255), (byte) (drinkReminderBean.getEndHour() & 255), (byte) (drinkReminderBean.getEndMin() & 255), (byte) (drinkReminderBean.getRemindDuration() & 255)}, new boolean[0]);
    }

    public static void K(DrinkReminderBean drinkReminderBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 75);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedBloodPressureWCmdJL " + drinkReminderBean);
        byte isOpen = drinkReminderBean.isOpen();
        int startHour = drinkReminderBean.getStartHour();
        char[] cArr = y5.b.f20001a;
        b3.g((byte) 75, new byte[]{2, 124, 0, isOpen, (byte) (startHour & 255), (byte) (drinkReminderBean.getStartMin() & 255), (byte) (drinkReminderBean.getEndHour() & 255), (byte) (drinkReminderBean.getEndMin() & 255), (byte) (drinkReminderBean.getRemindDuration() & 255)}, new boolean[0]);
    }

    public static void L(DrinkReminderBean drinkReminderBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 38);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedBloodSugarCmdJL " + drinkReminderBean);
        byte isOpen = drinkReminderBean.isOpen();
        int startHour = drinkReminderBean.getStartHour();
        char[] cArr = y5.b.f20001a;
        b3.g((byte) 38, new byte[]{2, 110, 0, isOpen, (byte) (startHour & 255), (byte) (drinkReminderBean.getStartMin() & 255), (byte) (drinkReminderBean.getEndHour() & 255), (byte) (drinkReminderBean.getEndMin() & 255), (byte) (drinkReminderBean.getRemindDuration() & 255)}, new boolean[0]);
    }

    public static void M(DrinkReminderBean drinkReminderBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 32);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedHRVCmdJL " + drinkReminderBean);
        byte isOpen = drinkReminderBean.isOpen();
        int startHour = drinkReminderBean.getStartHour();
        char[] cArr = y5.b.f20001a;
        b3.g((byte) 32, new byte[]{2, 106, 0, isOpen, (byte) (startHour & 255), (byte) (drinkReminderBean.getStartMin() & 255), (byte) (drinkReminderBean.getEndHour() & 255), (byte) (drinkReminderBean.getEndMin() & 255), (byte) (drinkReminderBean.getRemindDuration() & 255)}, new boolean[0]);
    }

    public static void N(DrinkReminderBean reminderBean) {
        kotlin.jvm.internal.e.f(reminderBean, "reminderBean");
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -43);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedHeartRateWCmdJL " + reminderBean);
        boolean isOpen = reminderBean.isOpen();
        char[] cArr = y5.b.f20001a;
        b3.g((byte) -43, new byte[]{2, 22, 0, (byte) ((isOpen ? 1 : 0) & 255), (byte) (reminderBean.getStartHour() & 255), (byte) (reminderBean.getStartMin() & 255), (byte) (reminderBean.getEndHour() & 255), (byte) (reminderBean.getEndMin() & 255), (byte) (reminderBean.getRemindDuration() & 255)}, new boolean[0]);
    }

    public static void O(DrinkReminderBean drinkReminderBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 35);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedStressCmdJL " + drinkReminderBean);
        byte isOpen = drinkReminderBean.isOpen();
        int startHour = drinkReminderBean.getStartHour();
        char[] cArr = y5.b.f20001a;
        b3.g((byte) 35, new byte[]{2, 107, 0, isOpen, (byte) (startHour & 255), (byte) (drinkReminderBean.getStartMin() & 255), (byte) (drinkReminderBean.getEndHour() & 255), (byte) (drinkReminderBean.getEndMin() & 255), (byte) (drinkReminderBean.getRemindDuration() & 255)}, new boolean[0]);
    }

    public static void P(UnitBean unitBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 36);
            return;
        }
        x5.d c9 = x5.d.c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getUnitCmd " + unitBean);
        int lang = unitBean.getLang();
        char[] cArr = y5.b.f20001a;
        c9.j((byte) 36, new byte[]{(byte) (lang & 255), (byte) (unitBean.getMeasureUnit() & 255), (byte) (unitBean.getTempUnit() & 255), (byte) (unitBean.getTimeFont() & 255)});
    }

    public static void Q(PersonBean personBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -20);
            Log.d("tong", "setUserInfo  no connect bleservice");
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getUserInfoCmd " + personBean);
        int measureUnit = personBean.getMeasureUnit();
        char[] cArr = y5.b.f20001a;
        byte b10 = (byte) (measureUnit & 255);
        int i3 = personBean.getGender() == 1 ? 1 : 0;
        byte birthdayYear = (byte) ((Calendar.getInstance().get(1) - personBean.getBirthdayYear()) & 255);
        float height = personBean.getHeight();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putFloat(height);
        byte[] array = allocate.array();
        byte b11 = array[3];
        byte b12 = array[2];
        byte b13 = array[1];
        byte b14 = array[0];
        float weight = personBean.getWeight();
        ByteBuffer allocate2 = ByteBuffer.allocate(4);
        allocate2.putFloat(weight);
        byte[] array2 = allocate2.array();
        b3.g((byte) -20, new byte[]{2, 6, 0, b10, (byte) (i3 & 255), birthdayYear, b11, b12, b13, b14, array2[3], array2[2], array2[1], array2[0]}, new boolean[0]);
    }

    public static void R(VideoHidBean videoHidBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 19);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getVideoHidWCmdJL " + videoHidBean.isOpen());
        b3.g((byte) 19, new byte[]{2, 100, 0, (byte) videoHidBean.getHidOpen(), videoHidBean.isDefaultOpen()}, new boolean[0]);
    }

    public static void S(String str) {
        if (!r5.b.k().f18054c) {
            r5.c.h().n(true, new byte[]{14, 2, -123});
        } else {
            if (str.length() == 0) {
                return;
            }
            r5.c.h().u(2, str, "");
        }
    }

    public static void T(int i3, w5.c customStatusCallback) {
        kotlin.jvm.internal.e.f(customStatusCallback, "customStatusCallback");
        x5.b.I0().K0(new u5.f(i3, customStatusCallback));
    }

    public static void U(u5.g bleDataCallback) {
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
    }

    public static void V(w5.b commonStatusCallback) {
        kotlin.jvm.internal.e.f(commonStatusCallback, "commonStatusCallback");
        x5.b.I0().K0(new u5.f(commonStatusCallback));
    }

    public static void W() {
        Log.e("qob", "syncBOJL");
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -70, new byte[]{5, 9, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -70);
        }
    }

    public static void X() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -3);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getUnBindCmd");
        b3.g((byte) -3, new byte[]{3, 1, 48, 0}, new boolean[0]);
    }

    public static void a(ScheduleBean scheduleBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -81);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getScheduleACmdJL " + com.example.baselibrary.utils.b.z(scheduleBean));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(scheduleBean.getTime());
        String format = new SimpleDateFormat("yy", Locale.getDefault()).format(Long.valueOf(calendar.getTimeInMillis()));
        kotlin.jvm.internal.e.e(format, "format(...)");
        int parseInt = Integer.parseInt(format);
        int i3 = calendar.get(2) + 1;
        int i10 = calendar.get(5);
        int i11 = calendar.get(11);
        int i12 = calendar.get(12);
        byte[] n4 = y5.b.n(scheduleBean.getMessage());
        byte[] bArr = new byte[n4.length + 43];
        bArr[0] = 4;
        bArr[1] = 3;
        bArr[2] = 32;
        bArr[3] = (byte) (scheduleBean.getScheduleId() & 255);
        bArr[4] = (byte) parseInt;
        bArr[5] = (byte) i3;
        bArr[6] = (byte) i10;
        bArr[7] = (byte) i11;
        bArr[8] = (byte) i12;
        byte[] a3 = y5.b.a(scheduleBean.getAdvance(), 2);
        bArr[9] = a3[0];
        bArr[10] = a3[1];
        byte[] n8 = y5.b.n(scheduleBean.getTitle());
        System.arraycopy(n8, 0, bArr, 11, n8.length <= 32 ? n8.length : 32);
        if (n4.length != 0) {
            System.arraycopy(n4, 0, bArr, 43, n4.length);
        }
        b3.g((byte) -81, bArr, new boolean[0]);
    }

    public static void b(int i3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 67);
            return;
        }
        x5.d c9 = x5.d.c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "getControlDeviceCmd controlType "));
        char[] cArr = y5.b.f20001a;
        c9.j((byte) 67, new byte[]{(byte) (i3 & 255)});
    }

    public static void c() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -42);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "获取查找设备");
        b3.g((byte) -42, new byte[]{2, 52, 0, 1}, new boolean[0]);
    }

    public static void d(u5.b bVar) {
        u5.c cVar;
        if (bVar == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(bVar)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == bVar) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    public static void e(u5.i fileTransferCallback) {
        kotlin.jvm.internal.e.f(fileTransferCallback, "fileTransferCallback");
        r5.c h4 = r5.c.h();
        if (h4.k(fileTransferCallback)) {
            CopyOnWriteArrayList copyOnWriteArrayList = h4.f18079f;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null && weakReference.get() == fileTransferCallback) {
                    weakReference.clear();
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
        }
    }

    public static void f(ExchangeSportDataBean exchangeSportDataBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 70);
            return;
        }
        x5.d c9 = x5.d.c();
        byte[] bArr = new byte[exchangeSportDataBean.isFinish() ? 21 : 14];
        bArr[0] = exchangeSportDataBean.isFinish();
        byte[] a3 = y5.b.a(exchangeSportDataBean.getTimeLen(), 2);
        bArr[1] = a3[0];
        bArr[2] = a3[1];
        byte[] a10 = y5.b.a(exchangeSportDataBean.getStep(), 2);
        bArr[3] = a10[0];
        bArr[4] = a10[1];
        byte[] a11 = y5.b.a(exchangeSportDataBean.getDistance(), 2);
        bArr[5] = a11[0];
        bArr[6] = a11[1];
        byte[] a12 = y5.b.a((int) exchangeSportDataBean.getCal(), 3);
        bArr[7] = a12[0];
        bArr[8] = a12[1];
        bArr[9] = a12[2];
        byte[] a13 = y5.b.a((int) exchangeSportDataBean.getPaceKm(), 2);
        bArr[10] = a13[0];
        bArr[11] = a13[1];
        byte[] a14 = y5.b.a((int) exchangeSportDataBean.getPaceImp(), 2);
        bArr[12] = a14[0];
        bArr[13] = a14[1];
        if (exchangeSportDataBean.isFinish()) {
            byte[] a15 = y5.b.a(exchangeSportDataBean.getStepSeq(), 2);
            bArr[14] = a15[0];
            bArr[15] = a15[1];
            byte[] r = y5.b.r(exchangeSportDataBean.getStartTime());
            bArr[16] = r[3];
            bArr[17] = r[2];
            bArr[18] = r[1];
            bArr[19] = r[0];
            bArr[20] = exchangeSportDataBean.isHasMap();
        }
        c9.j((byte) 70, bArr);
    }

    public static void g() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -22);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getBrightTimeRCmdJL");
        b3.g((byte) -22, new byte[]{2, 8, 16}, new boolean[0]);
    }

    public static void h() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -14);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getVersionCmd");
        b3.g((byte) -14, new byte[]{2, 4, 16}, new boolean[0]);
    }

    public static void i() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -13);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getBatteryCmd");
        b3.g((byte) -13, new byte[]{2, 3, 16}, new boolean[0]);
    }

    public static void j() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 25);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getLedLevelRCmdJL");
        b3.g((byte) 25, new byte[]{2, 102, 16}, new boolean[0]);
    }

    public static void k() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -54);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedBloodOxygenRCmdJL");
        b3.g((byte) -54, new byte[]{2, 37, 16}, new boolean[0]);
    }

    public static void l() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 74);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedBloodPressureRCmdJL");
        b3.g((byte) 74, new byte[]{2, 124, 16}, new boolean[0]);
    }

    public static void m() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 39);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedBloodSugarRCmdJL");
        b3.g((byte) 39, new byte[]{2, 110, 16}, new boolean[0]);
    }

    public static void n() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 33);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedHRVRCmdJL");
        b3.g((byte) 33, new byte[]{2, 106, 16}, new boolean[0]);
    }

    public static void o() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -44);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedHeartRateRCmdJL");
        b3.g((byte) -44, new byte[]{2, 22, 16}, new boolean[0]);
    }

    public static void p() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 36);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getTimedStressRCmdJL");
        b3.g((byte) 36, new byte[]{2, 107, 16}, new boolean[0]);
    }

    public static void q() {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 20);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getVideoHidRCmdJL");
        b3.g((byte) 20, new byte[]{2, 100, 16}, new boolean[0]);
    }

    public static void r(ArrayList reminderBeans) {
        int i3;
        int i10 = 1;
        kotlin.jvm.internal.e.f(reminderBeans, "reminderBeans");
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -32);
            return;
        }
        byte b3 = 2;
        if (reminderBeans.size() <= 0) {
            x5.c b10 = x5.c.b();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getAlarmDelAllCmdJL");
            b10.g((byte) -32, new byte[]{2, 16, 48, -1}, new boolean[0]);
            return;
        }
        x5.c b11 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getAlarmWCmdJL " + com.example.baselibrary.utils.b.z(reminderBeans));
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        String format = new SimpleDateFormat("yy", Locale.getDefault()).format(Long.valueOf(calendar.getTimeInMillis()));
        kotlin.jvm.internal.e.e(format, "format(...)");
        int parseInt = Integer.parseInt(format);
        int i11 = calendar.get(2) + 1;
        char c9 = 5;
        int i12 = calendar.get(5);
        int size = reminderBeans.size();
        int i13 = 0;
        while (true) {
            i3 = 3;
            if (i13 >= size) {
                break;
            }
            Object obj = reminderBeans.get(i13);
            i13 += i10;
            AlarmRemainderBean alarmRemainderBean = (AlarmRemainderBean) obj;
            int i14 = i10;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(alarmRemainderBean.isOpen() ? 1 : 0);
            sb2.append(Byte.valueOf((byte) alarmRemainderBean.getRepeatModel()[0]));
            sb2.append(Byte.valueOf((byte) alarmRemainderBean.getRepeatModel()[6]));
            sb2.append(Byte.valueOf((byte) alarmRemainderBean.getRepeatModel()[c9]));
            sb2.append(Byte.valueOf((byte) alarmRemainderBean.getRepeatModel()[4]));
            sb2.append(Byte.valueOf((byte) alarmRemainderBean.getRepeatModel()[3]));
            sb2.append(Byte.valueOf((byte) alarmRemainderBean.getRepeatModel()[b3]));
            sb2.append(Byte.valueOf((byte) alarmRemainderBean.getRepeatModel()[i14]));
            byte[] n4 = y5.b.n(alarmRemainderBean.getAlarmTag());
            byte b12 = b3;
            byte[] bArr = new byte[28];
            char c10 = c9;
            bArr[0] = (byte) (alarmRemainderBean.getAlarmId() & 255);
            bArr[i14] = y5.b.b(sb2.toString());
            bArr[b12] = (byte) parseInt;
            bArr[3] = (byte) i11;
            bArr[4] = (byte) i12;
            bArr[c10] = (byte) (alarmRemainderBean.getStartHour() & 255);
            bArr[6] = (byte) (alarmRemainderBean.getStartMin() & 255);
            int i15 = 21;
            if (n4.length <= 21) {
                i15 = n4.length;
            }
            System.arraycopy(n4, 0, bArr, 7, i15);
            arrayList.add(bArr);
            i10 = i14;
            b3 = b12;
            c9 = c10;
        }
        int i16 = i10;
        byte b13 = b3;
        int size2 = arrayList.size();
        int i17 = 0;
        int i18 = 0;
        while (i18 < size2) {
            Object obj2 = arrayList.get(i18);
            i18++;
            i17 += ((byte[]) obj2).length;
        }
        byte[] bArr2 = new byte[i17 + 3];
        bArr2[0] = b13;
        bArr2[i16] = 16;
        bArr2[b13] = 0;
        int size3 = arrayList.size();
        int i19 = 0;
        while (i19 < size3) {
            Object obj3 = arrayList.get(i19);
            i19++;
            byte[] bArr3 = (byte[]) obj3;
            System.arraycopy(bArr3, 0, bArr2, i3, bArr3.length);
            i3 += bArr3.length;
        }
        b11.g((byte) -32, bArr2, new boolean[0]);
    }

    public static void s(BindInfoBean bindInfoBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 32);
            return;
        }
        if (y5.b.m(bindInfoBean.getUserId()).length > 32) {
            x5.b.I0().G0((byte) 32);
            return;
        }
        x5.d c9 = x5.d.c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getBindInfoCmd " + bindInfoBean);
        byte[] m10 = y5.b.m(bindInfoBean.getUserId());
        byte[] bArr = new byte[m10.length + 1];
        bArr[0] = (byte) (bindInfoBean.getBindType() & 255);
        System.arraycopy(m10, 0, bArr, 1, m10.length);
        c9.j((byte) 32, bArr);
    }

    public static void t(BindInfoBean bindInfoBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -4);
            return;
        }
        if (y5.b.m(bindInfoBean.getUserId()).length > 32) {
            x5.b.I0().G0((byte) -4);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getBindInfoCmdJL " + bindInfoBean);
        byte[] m10 = y5.b.m(bindInfoBean.getUserId());
        byte[] bArr = {3, 1, 32, 0, 0, 0, 0};
        if (m10.length >= 4) {
            System.arraycopy(m10, 0, bArr, 3, 4);
        } else {
            byte[] bArr2 = new byte[4];
            int length = 4 - m10.length;
            int length2 = m10.length;
            for (int i3 = 0; i3 < length2; i3++) {
                bArr2[length + i3] = m10[i3];
            }
            System.arraycopy(bArr2, 0, bArr, 3, 4);
        }
        b3.g((byte) -4, bArr, new boolean[0]);
    }

    public static void u(Date date) {
        kotlin.jvm.internal.e.f(date, "date");
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 33);
            return;
        }
        DateBean dateBean = new DateBean();
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(1) < 2000) {
            x5.b.I0().G0((byte) 33);
            return;
        }
        calendar.setTimeInMillis(date.getTime());
        dateBean.setYear(calendar.get(1));
        dateBean.setMonth(calendar.get(2) + 1);
        dateBean.setDay(calendar.get(5));
        dateBean.setHour(calendar.get(11));
        dateBean.setMin(calendar.get(12));
        dateBean.setSecond(calendar.get(13));
        x5.d c9 = x5.d.c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getDateCmd " + dateBean);
        byte[] a3 = y5.b.a(dateBean.getYear(), 2);
        c9.j((byte) 33, new byte[]{a3[0], a3[1], (byte) (dateBean.getMonth() & 255), (byte) (dateBean.getDay() & 255), (byte) (dateBean.getHour() & 255), (byte) (dateBean.getMin() & 255), (byte) (dateBean.getSecond() & 255)});
    }

    public static void v(Date date) {
        kotlin.jvm.internal.e.f(date, "date");
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -11);
            return;
        }
        DateBean dateBean = new DateBean();
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(1) < 2000) {
            x5.b.I0().G0((byte) -11);
            return;
        }
        calendar.setTimeInMillis(date.getTime());
        dateBean.setYear(calendar.get(1) - 2000);
        dateBean.setMonth(calendar.get(2) + 1);
        dateBean.setDay(calendar.get(5));
        dateBean.setHour(calendar.get(11));
        dateBean.setMin(calendar.get(12));
        dateBean.setSecond(calendar.get(13));
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getDateCmdJL " + dateBean);
        int year = dateBean.getYear();
        char[] cArr = y5.b.f20001a;
        b3.g((byte) -11, new byte[]{2, 1, 0, (byte) (year & 255), (byte) (dateBean.getMonth() & 255), (byte) (dateBean.getDay() & 255), (byte) (dateBean.getHour() & 255), (byte) (dateBean.getMin() & 255), (byte) (dateBean.getSecond() & 255)}, new boolean[0]);
    }

    public static void w(int i3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -17);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "getMeasureUnitCmd "));
        char[] cArr = y5.b.f20001a;
        b3.g((byte) -17, new byte[]{2, 17, 0, (byte) (i3 & 255)}, new boolean[0]);
    }

    public static void x(PersonBean personBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 46);
            return;
        }
        x5.d c9 = x5.d.c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getPersonalInfoCmd " + personBean);
        byte[] m10 = y5.b.m(personBean.getNickName());
        byte[] bArr = new byte[m10.length + 8];
        bArr[0] = (byte) ((personBean.getGender() == 1 ? 1 : 0) & 255);
        bArr[1] = (byte) ((Calendar.getInstance().get(1) - personBean.getBirthdayYear()) & 255);
        byte[] a3 = y5.b.a((int) personBean.getHeight(), 2);
        bArr[2] = a3[0];
        bArr[3] = a3[1];
        byte[] a10 = y5.b.a((int) (personBean.getWeight() * 10), 2);
        bArr[4] = a10[0];
        bArr[5] = a10[1];
        byte[] a11 = y5.b.a(personBean.getStepTarget(), 2);
        bArr[6] = a11[0];
        bArr[7] = a11[1];
        System.arraycopy(m10, 0, bArr, 8, m10.length);
        c9.j((byte) 46, bArr);
    }

    public static void y(int i3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -57);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "获取关机");
        char[] cArr = y5.b.f20001a;
        b3.g((byte) -57, new byte[]{2, 34, 0, (byte) (i3 & 255)}, new boolean[0]);
    }

    public static void z(MsgPushBean msgPushBean) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 50);
            return;
        }
        msgPushBean.setTitle(y5.b.p(32, msgPushBean.getTitle()));
        msgPushBean.setContent(y5.b.p(208, msgPushBean.getContent()));
        x5.d c9 = x5.d.c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getMsgPushCmd " + msgPushBean);
        byte[] n4 = y5.b.n(msgPushBean.getContent());
        byte[] n8 = y5.b.n(msgPushBean.getTitle());
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getMsgPushCmd title len " + n8.length + " content len " + n4.length);
        byte[] bArr = new byte[n4.length + 10 + n8.length];
        byte[] r = y5.b.r(msgPushBean.getTimeMill() / ((long) 1000));
        bArr[0] = r[0];
        bArr[1] = r[1];
        bArr[2] = r[2];
        bArr[3] = r[3];
        bArr[4] = (byte) (msgPushBean.getMsgType() & 255);
        bArr[5] = (byte) 2;
        bArr[6] = 0;
        bArr[7] = (byte) (n8.length & 255);
        System.arraycopy(n8, 0, bArr, 8, n8.length);
        bArr[n8.length + 8] = 2;
        bArr[n8.length + 9] = (byte) (n4.length & 255);
        System.arraycopy(n4, 0, bArr, n8.length + 10, n4.length);
        c9.j((byte) 50, bArr);
    }
}
