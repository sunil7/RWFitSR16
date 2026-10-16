package x5;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.AerobicExerciseBean;
import com.example.blesdk.bean.function.AlarmRemainderBean;
import com.example.blesdk.bean.function.BaseAnswerBean;
import com.example.blesdk.bean.function.BindInfoBean;
import com.example.blesdk.bean.function.BlueToothBean;
import com.example.blesdk.bean.function.BoReminderBean;
import com.example.blesdk.bean.function.BreatheBean;
import com.example.blesdk.bean.function.BrightScreenBean;
import com.example.blesdk.bean.function.BrightScreenLedBean;
import com.example.blesdk.bean.function.BrightScreenTimeBean;
import com.example.blesdk.bean.function.BrightVibrationBean;
import com.example.blesdk.bean.function.BtNameBean;
import com.example.blesdk.bean.function.CustomDialInfoBean;
import com.example.blesdk.bean.function.DNDModelBean;
import com.example.blesdk.bean.function.DialBean;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.blesdk.bean.function.FactoryInBean;
import com.example.blesdk.bean.function.FactoryStateBean;
import com.example.blesdk.bean.function.FirmVersionBean;
import com.example.blesdk.bean.function.GameChildAppBean;
import com.example.blesdk.bean.function.HrBoActualReminderBean;
import com.example.blesdk.bean.function.HrMonitorBean;
import com.example.blesdk.bean.function.HrReminderBean;
import com.example.blesdk.bean.function.JLWomenHealthBean;
import com.example.blesdk.bean.function.MuslimFlashCountBean;
import com.example.blesdk.bean.function.OTAStatusBean;
import com.example.blesdk.bean.function.PowerBean;
import com.example.blesdk.bean.function.PrayerClockBean;
import com.example.blesdk.bean.function.ReminderModeBean;
import com.example.blesdk.bean.function.SedentaryReminderBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.blesdk.bean.function.SwitchStatusBean;
import com.example.blesdk.bean.function.VaperPowerBean;
import com.example.blesdk.bean.function.VaperPowerOHMBean;
import com.example.blesdk.bean.function.VideoHidBean;
import com.example.blesdk.bean.function.WomenHealthBean;
import com.example.blesdk.bean.sync.BloodOxyItemBean;
import com.example.blesdk.bean.sync.BloodOxySyncBean;
import com.example.blesdk.bean.sync.BloodPressItemBean;
import com.example.blesdk.bean.sync.BloodPressSyncBean;
import com.example.blesdk.bean.sync.BloodSugarItemBean;
import com.example.blesdk.bean.sync.BloodSugarSyncBean;
import com.example.blesdk.bean.sync.BoPartData;
import com.example.blesdk.bean.sync.BodyTempItemBean;
import com.example.blesdk.bean.sync.BodyTempSyncBean;
import com.example.blesdk.bean.sync.BpPartData;
import com.example.blesdk.bean.sync.BreathPartData;
import com.example.blesdk.bean.sync.HealthDataSyncBean;
import com.example.blesdk.bean.sync.HealthSyncBean;
import com.example.blesdk.bean.sync.HeartRateItemBean;
import com.example.blesdk.bean.sync.HeartRateSyncBean;
import com.example.blesdk.bean.sync.HrPartData;
import com.example.blesdk.bean.sync.HrvItemBean;
import com.example.blesdk.bean.sync.HrvSyncBean;
import com.example.blesdk.bean.sync.ImperialPaceItemBean;
import com.example.blesdk.bean.sync.JLSleepSyncBean;
import com.example.blesdk.bean.sync.JLStepSyncBean;
import com.example.blesdk.bean.sync.LogInfoBean;
import com.example.blesdk.bean.sync.MetricPaceItemBean;
import com.example.blesdk.bean.sync.MuslimCountItemBean;
import com.example.blesdk.bean.sync.MuslimCountSyncBean;
import com.example.blesdk.bean.sync.NewSportBean;
import com.example.blesdk.bean.sync.PressureItemBean;
import com.example.blesdk.bean.sync.PressurePartData;
import com.example.blesdk.bean.sync.PressureSyncBean;
import com.example.blesdk.bean.sync.SportDataPushBean;
import com.example.blesdk.bean.sync.SportHrItemBean;
import com.example.blesdk.bean.sync.SportItemBean;
import com.example.blesdk.bean.sync.SportResultBean;
import com.example.blesdk.bean.sync.SportSyncBean;
import com.example.blesdk.bean.sync.StepFrequencyItemBean;
import com.example.blesdk.bean.sync.StepItemBean;
import com.example.blesdk.bean.sync.StepPartData;
import com.example.blesdk.bean.sync.StepSyncBean;
import com.example.blesdk.bean.sync.TempPartData;
import com.example.blesdk.bean.sync.VaperDetailItemBean;
import com.example.blesdk.bean.sync.VaperDetailSyncBean;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.mlkit.common.MlKitException;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: h, reason: collision with root package name */
    public static b f19794h;

    /* renamed from: c, reason: collision with root package name */
    public int f19797c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f19798d = -1;
    public int e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f19799f = new ArrayList(1);

    /* renamed from: g, reason: collision with root package name */
    public final ByteArrayOutputStream f19800g = new ByteArrayOutputStream();

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f19795a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f19796b = new HashMap(1);

    public static void A(byte[] bArr, ArrayList arrayList) {
        SwitchStatusBean switchStatusBean = new SwitchStatusBean();
        int i3 = 0;
        if (bArr.length >= 7) {
            byte b3 = bArr[6];
            switchStatusBean.setOther(y5.b.l(b3, 0));
            switchStatusBean.setPhoneCall(y5.b.l(b3, 1));
            switchStatusBean.setSms(y5.b.l(b3, 2));
            switchStatusBean.setEmail(y5.b.l(b3, 3));
            switchStatusBean.setSkype(y5.b.l(b3, 4));
            switchStatusBean.setFacebook(y5.b.l(b3, 5));
            switchStatusBean.setWhatsApp(y5.b.l(b3, 6));
            switchStatusBean.setLine(y5.b.l(b3, 7));
            byte b10 = bArr[5];
            switchStatusBean.setInstagram(y5.b.l(b10, 0));
            switchStatusBean.setKakaoTalk(y5.b.l(b10, 1));
            switchStatusBean.setGmail(y5.b.l(b10, 2));
            switchStatusBean.setTwitter(y5.b.l(b10, 3));
            switchStatusBean.setLinkedin(y5.b.l(b10, 4));
            switchStatusBean.setWeibo(y5.b.l(b10, 5));
            switchStatusBean.setQQ(y5.b.l(b10, 6));
            switchStatusBean.setWeChat(y5.b.l(b10, 7));
            byte b11 = bArr[4];
            switchStatusBean.setBand(y5.b.l(b11, 0));
            switchStatusBean.setTelegram(y5.b.l(b11, 1));
            switchStatusBean.setBetween(y5.b.l(b11, 2));
            switchStatusBean.setNaverCafe(y5.b.l(b11, 3));
            switchStatusBean.setYoutube(y5.b.l(b11, 4));
            switchStatusBean.setNetFlix(y5.b.l(b11, 5));
            switchStatusBean.setMax(y5.b.l(b11, 6));
            switchStatusBean.setVk(y5.b.l(b11, 7));
            byte b12 = bArr[3];
            switchStatusBean.setRuMail(y5.b.l(b12, 0));
            switchStatusBean.setYandexMail(y5.b.l(b12, 1));
            switchStatusBean.setYandexTaxi(y5.b.l(b12, 2));
            switchStatusBean.setVkontakte(y5.b.l(b12, 3));
            switchStatusBean.setAll(y5.b.l(b12, 7));
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(switchStatusBean);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bd A[LOOP:1: B:20:0x00b7->B:22:0x00bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A0(byte[] r19, java.util.ArrayList r20) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.b.A0(byte[], java.util.ArrayList):void");
    }

    public static void B(byte[] bArr, ArrayList arrayList) {
        DNDModelBean dNDModelBean = new DNDModelBean();
        byte b3 = bArr[5];
        char[] cArr = y5.b.f20001a;
        int i3 = b3 & 255;
        int i10 = bArr[6] & 255;
        int i11 = bArr[7] & 255;
        int i12 = bArr[8] & 255;
        int i13 = 0;
        dNDModelBean.setOpen(bArr[3] == 1);
        dNDModelBean.setAllDay(false);
        dNDModelBean.setStartHour(i3);
        dNDModelBean.setStartMin(i10);
        dNDModelBean.setEndHour(i11);
        dNDModelBean.setEndMin(i12);
        int size = arrayList.size();
        while (i13 < size) {
            Object obj = arrayList.get(i13);
            i13++;
            ((u5.c) obj).f(dNDModelBean);
        }
    }

    public static void B0(byte[] bArr, ArrayList arrayList) {
        SportSyncBean sportSyncBean = new SportSyncBean();
        ArrayList arrayList2 = new ArrayList(1);
        int i3 = 0;
        int i10 = 0;
        while (i10 < bArr.length) {
            SportItemBean sportItemBean = new SportItemBean();
            sportItemBean.setSportTime(y5.b.d(i10, i10 + 3, bArr) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000));
            sportItemBean.setSportType(bArr[i10 + 4] & 255);
            sportItemBean.setTotalSportTime(y5.b.d(i10 + 5, i10 + 8, bArr));
            sportItemBean.setTotalDistance(y5.b.d(i10 + 9, i10 + 10, bArr));
            sportItemBean.setTotalStep(y5.b.d(i10 + 11, i10 + 13, bArr));
            sportItemBean.setTotalCalorie(y5.b.d(i10 + 14, i10 + 16, bArr));
            int d5 = y5.b.d(i10 + 17, i10 + 18, bArr);
            int i11 = i10 + 19;
            if (d5 > 0) {
                int i12 = (d5 * 4) + i11;
                ArrayList arrayList3 = new ArrayList(1);
                while (i11 < i12) {
                    MetricPaceItemBean metricPaceItemBean = new MetricPaceItemBean();
                    metricPaceItemBean.setPaceIndex(bArr[i11] & 255);
                    metricPaceItemBean.setPace(y5.b.d(i11 + 1, i11 + 2, bArr));
                    metricPaceItemBean.setKm((bArr[i11 + 3] & 255) == 1);
                    i11 += 4;
                    arrayList3.add(metricPaceItemBean);
                }
                sportItemBean.setMetricPaceItems(arrayList3);
            }
            int d8 = y5.b.d(i11, i11 + 1, bArr);
            int i13 = i11 + 2;
            if (d8 > 0) {
                int i14 = (d8 * 4) + i13;
                ArrayList arrayList4 = new ArrayList(1);
                while (i13 < i14) {
                    ImperialPaceItemBean imperialPaceItemBean = new ImperialPaceItemBean();
                    imperialPaceItemBean.setPaceIndex(bArr[i13] & 255);
                    imperialPaceItemBean.setPace(y5.b.d(i13 + 1, i13 + 2, bArr));
                    imperialPaceItemBean.setMi((bArr[i13 + 3] & 255) == 1);
                    i13 += 4;
                    arrayList4.add(imperialPaceItemBean);
                }
                sportItemBean.setImperialPaceItems(arrayList4);
            }
            int d10 = y5.b.d(i13, i13 + 1, bArr);
            int i15 = i13 + 2;
            if (d10 > 0) {
                int i16 = (d10 * 3) + i15;
                ArrayList arrayList5 = new ArrayList(1);
                while (i15 < i16) {
                    StepFrequencyItemBean stepFrequencyItemBean = new StepFrequencyItemBean();
                    stepFrequencyItemBean.setTimeMin(y5.b.d(i15, i15 + 1, bArr));
                    stepFrequencyItemBean.setStepFrequency(bArr[i15 + 2] & 255);
                    i15 += 3;
                    arrayList5.add(stepFrequencyItemBean);
                }
                sportItemBean.setStepFrequencyItems(arrayList5);
            }
            int d11 = y5.b.d(i15, i15 + 1, bArr);
            i10 = i15 + 2;
            if (d11 > 0) {
                int i17 = (d11 * 3) + i10;
                ArrayList arrayList6 = new ArrayList(1);
                while (i10 < i17) {
                    SportHrItemBean sportHrItemBean = new SportHrItemBean();
                    sportHrItemBean.setTimeMills(y5.b.d(i10, i10 + 1, bArr));
                    sportHrItemBean.setHr(bArr[i10 + 2] & 255);
                    i10 += 3;
                    arrayList6.add(sportHrItemBean);
                }
                sportItemBean.setSportHrItems(arrayList6);
            }
            arrayList2.add(sportItemBean);
        }
        sportSyncBean.setItems(arrayList2);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(sportSyncBean);
        }
    }

    public static void C(byte[] bArr, ArrayList arrayList) {
        int i3;
        int i10;
        int i11;
        int i12 = 0;
        if (bArr.length < 4) {
            int size = arrayList.size();
            while (i12 < size) {
                Object obj = arrayList.get(i12);
                i12++;
                ((u5.c) obj).d(-14, 2001);
            }
            return;
        }
        FirmVersionBean firmVersionBean = new FirmVersionBean();
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i13 = 3; i13 < 6; i13++) {
                byte b3 = bArr[i13];
                char[] cArr = y5.b.f20001a;
                sb2.append(b3 & 255);
                sb2.append(".");
            }
            firmVersionBean.setDeviceNo(sb2.substring(0, sb2.length() - 1));
            if (bArr.length > 16) {
                byte b10 = bArr[6];
                char[] cArr2 = y5.b.f20001a;
                i11 = b10 & 255;
                i3 = (bArr[7] & 255) + ((bArr[8] & 255) << 8);
                i10 = (bArr[9] & 255) + ((bArr[10] & 255) << 8);
                byte[] bArr2 = new byte[8];
                System.arraycopy(bArr, 11, bArr2, 0, 8);
                String str = new String(bArr2);
                if (bArr.length > 19) {
                    StringBuilder sb3 = new StringBuilder();
                    for (int i14 = 20; i14 < 23; i14++) {
                        sb3.append(bArr[i14] & 255);
                        sb3.append(".");
                    }
                    firmVersionBean.setUiVersion(sb3.substring(0, sb3.length() - 1));
                } else {
                    firmVersionBean.setUiVersion("1.0.0");
                }
                Log.e("qob", "tScreenType " + i11 + " tScreenWidth " + i3 + " tScreenHeight " + i10 + " tDeviceModel " + str + " UIVersion " + firmVersionBean.getUiVersion());
                firmVersionBean.setDeviceClazz(str);
            } else {
                i3 = 240;
                i10 = 284;
                i11 = 0;
            }
            firmVersionBean.setScreenType(i11);
            firmVersionBean.setScreenWidth(i3);
            firmVersionBean.setScreenHeight(i10);
        } catch (Exception e) {
            e.printStackTrace();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "analysisFirmware " + e.getMessage());
        }
        int size2 = arrayList.size();
        while (i12 < size2) {
            Object obj2 = arrayList.get(i12);
            i12++;
            ((u5.c) obj2).f(firmVersionBean);
        }
    }

    public static void C0(byte[] bArr, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(1);
        int i3 = 0;
        int i10 = 0;
        while (i10 < bArr.length) {
            StepSyncBean stepSyncBean = new StepSyncBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                stepSyncBean.setTime(y5.b.f(bArr2) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            stepSyncBean.setTotalSteps(y5.b.d(i10 + 4, i10 + 6, bArr));
            stepSyncBean.setTotalCalorie(y5.b.d(i10 + 7, i10 + 9, bArr));
            stepSyncBean.setTotalDistance(y5.b.d(i10 + 10, i10 + 12, bArr));
            stepSyncBean.setItemCount(y5.b.d(i10 + 13, i10 + 14, bArr));
            i10 += 15;
            ArrayList arrayList3 = new ArrayList(1);
            for (int i11 = 0; i11 < stepSyncBean.getItemCount(); i11++) {
                StepItemBean stepItemBean = new StepItemBean();
                stepItemBean.setIndex(bArr[i10] & 255);
                stepItemBean.setSteps(y5.b.d(i10 + 1, i10 + 2, bArr));
                stepItemBean.setCalorie(y5.b.d(i10 + 3, i10 + 5, bArr));
                stepItemBean.setDistance(y5.b.d(i10 + 6, i10 + 7, bArr));
                i10 += 8;
                arrayList3.add(stepItemBean);
            }
            stepSyncBean.setItems(arrayList3);
            arrayList2.add(stepSyncBean);
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void D(byte[] bArr, ArrayList arrayList) {
        int i3 = 0;
        if (bArr.length < 5) {
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((u5.c) obj).d(71, 2001);
            }
            return;
        }
        NewSportBean newSportBean = new NewSportBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        int i10 = bArr[4] & 255;
        newSportBean.setSportType(Integer.valueOf(b3 & 255));
        newSportBean.setStatus(Integer.valueOf(i10));
        int size2 = arrayList.size();
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            u5.c cVar = (u5.c) obj2;
            if (cVar instanceof u5.e) {
                ((u5.e) cVar).f(newSportBean);
            }
        }
    }

    public static void D0(byte[] bArr, ArrayList arrayList) {
        WomenHealthBean womenHealthBean = new WomenHealthBean();
        int i3 = 0;
        byte b3 = bArr[0];
        char[] cArr = y5.b.f20001a;
        womenHealthBean.setType(b3 & 255);
        womenHealthBean.setOpen(bArr[1] == 1);
        womenHealthBean.setMensOpen(bArr[2] == 1);
        womenHealthBean.setOvulOpen(bArr[3] == 1);
        womenHealthBean.setOvulHighOpen(bArr[4] == 1);
        womenHealthBean.setOvulOverOpen(bArr[5] == 1);
        womenHealthBean.setRangeDays(bArr[6] & 255);
        womenHealthBean.setMensDays(bArr[7] & 255);
        womenHealthBean.setLastDays(y5.b.d(8, 11, bArr) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000));
        womenHealthBean.setRemindHour(bArr[12] & 255);
        womenHealthBean.setRemindMin(bArr[13] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(womenHealthBean);
        }
    }

    public static void E(byte b3, byte[] bArr, ArrayList arrayList) {
        long j4;
        long j10;
        Log.e("qob", "analysisJLHealthData " + (b3 & 255));
        HealthDataSyncBean healthDataSyncBean = new HealthDataSyncBean();
        long j11 = 946684800;
        int i3 = 0;
        int i10 = 3;
        long j12 = 1000;
        if (b3 == -59) {
            healthDataSyncBean.setDataType(1);
            ArrayList arrayList2 = new ArrayList(1);
            ArrayList arrayList3 = new ArrayList(1);
            while (i10 < bArr.length) {
                HeartRateItemBean heartRateItemBean = new HeartRateItemBean();
                HrPartData hrPartData = new HrPartData();
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i10, bArr2, 0, 4);
                try {
                    j10 = j11;
                } catch (Exception e) {
                    e = e;
                    j10 = j11;
                }
                try {
                    long f2 = (y5.b.f(bArr2) + j11) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000);
                    heartRateItemBean.setTimeMills(f2);
                    hrPartData.setTime(f2);
                } catch (Exception e10) {
                    e = e10;
                    e.printStackTrace();
                    byte b10 = bArr[i10 + 4];
                    char[] cArr = y5.b.f20001a;
                    heartRateItemBean.setHr(b10 & 255);
                    i10 += 6;
                    hrPartData.setHr(heartRateItemBean.getHr());
                    arrayList3.add(heartRateItemBean);
                    arrayList2.add(hrPartData);
                    j11 = j10;
                }
                byte b102 = bArr[i10 + 4];
                char[] cArr2 = y5.b.f20001a;
                heartRateItemBean.setHr(b102 & 255);
                i10 += 6;
                hrPartData.setHr(heartRateItemBean.getHr());
                arrayList3.add(heartRateItemBean);
                arrayList2.add(hrPartData);
                j11 = j10;
            }
            healthDataSyncBean.setHrPartData(arrayList2);
        } else if (b3 == 34) {
            healthDataSyncBean.setDataType(13);
            Log.e("qob", "analysisBreatheData JL_BLE_KEY_APP_REAL_TIME_HRV_DATA_ID");
            ArrayList arrayList4 = new ArrayList(1);
            ArrayList arrayList5 = new ArrayList(1);
            while (i10 < bArr.length) {
                HrvItemBean hrvItemBean = new HrvItemBean();
                HrPartData hrPartData2 = new HrPartData();
                byte[] bArr3 = new byte[4];
                System.arraycopy(bArr, i10, bArr3, 0, 4);
                try {
                    j4 = j12;
                    try {
                        long f10 = (y5.b.f(bArr3) + 946684800) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / j4);
                        hrvItemBean.setTimeMills(f10);
                        hrPartData2.setTime(f10);
                    } catch (Exception e11) {
                        e = e11;
                        e.printStackTrace();
                        byte b11 = bArr[i10 + 4];
                        char[] cArr3 = y5.b.f20001a;
                        hrvItemBean.setHrv(b11 & 255);
                        i10 += 6;
                        hrPartData2.setHr(hrvItemBean.getHrv());
                        arrayList5.add(hrvItemBean);
                        arrayList4.add(hrPartData2);
                        j12 = j4;
                    }
                } catch (Exception e12) {
                    e = e12;
                    j4 = j12;
                }
                byte b112 = bArr[i10 + 4];
                char[] cArr32 = y5.b.f20001a;
                hrvItemBean.setHrv(b112 & 255);
                i10 += 6;
                hrPartData2.setHr(hrvItemBean.getHrv());
                arrayList5.add(hrvItemBean);
                arrayList4.add(hrPartData2);
                j12 = j4;
            }
            healthDataSyncBean.setHrPartData(arrayList4);
        } else if (b3 == 37) {
            healthDataSyncBean.setDataType(9);
            Log.e("qob", "analysisBreatheData JL_BLE_KEY_APP_REAL_TIME_BLOODSUGAR_DATA_ID");
            ArrayList arrayList6 = new ArrayList(1);
            while (i10 < bArr.length) {
                BloodSugarItemBean bloodSugarItemBean = new BloodSugarItemBean();
                TempPartData tempPartData = new TempPartData();
                byte[] bArr4 = new byte[4];
                System.arraycopy(bArr, i10, bArr4, 0, 4);
                try {
                    long f11 = (y5.b.f(bArr4) + 946684800) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000);
                    bloodSugarItemBean.setTimeMills(f11);
                    tempPartData.setTime(f11);
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
                bloodSugarItemBean.setSugar(y5.b.d(i10 + 4, i10 + 5, bArr));
                i10 += 6;
                tempPartData.setTemp(bloodSugarItemBean.getSugar());
                arrayList6.add(tempPartData);
            }
            healthDataSyncBean.setTempPartData(arrayList6);
        } else if (b3 == 46) {
            healthDataSyncBean.setDataType(10);
            MuslimCountItemBean muslimCountItemBean = new MuslimCountItemBean();
            while (i10 < bArr.length) {
                byte[] bArr5 = new byte[4];
                System.arraycopy(bArr, i10, bArr5, 0, 4);
                try {
                    long f12 = (y5.b.f(bArr5) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                    muslimCountItemBean.setTimeMills(f12);
                    long j13 = f12 * 1000;
                    muslimCountItemBean.setDate(com.example.baselibrary.utils.b.q(j13));
                    muslimCountItemBean.setHour(com.example.baselibrary.utils.b.p(j13));
                } catch (Exception e14) {
                    e14.printStackTrace();
                }
                muslimCountItemBean.setCount(y5.b.d(i10 + 4, i10 + 7, bArr));
                i10 += 8;
            }
            healthDataSyncBean.setMuslimCountPartData(muslimCountItemBean);
        } else if (b3 == -100) {
            healthDataSyncBean.setDataType(3);
            ArrayList arrayList7 = new ArrayList(1);
            while (i10 < bArr.length) {
                BloodOxyItemBean bloodOxyItemBean = new BloodOxyItemBean();
                BoPartData boPartData = new BoPartData();
                byte[] bArr6 = new byte[4];
                System.arraycopy(bArr, i10, bArr6, 0, 4);
                try {
                    bloodOxyItemBean.setTimeMills((y5.b.f(bArr6) + 946684800) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
                } catch (Exception e15) {
                    e15.printStackTrace();
                }
                bloodOxyItemBean.setBloodOxy(bArr[i10 + 4] & 255);
                i10 += 6;
                boPartData.setTime(bloodOxyItemBean.getTimeMills());
                boPartData.setBo(bloodOxyItemBean.getBloodOxy());
                arrayList7.add(boPartData);
            }
            healthDataSyncBean.setBoPartData(arrayList7);
        } else if (b3 == -101) {
            healthDataSyncBean.setDataType(8);
            ArrayList arrayList8 = new ArrayList(1);
            while (i10 < bArr.length) {
                PressureItemBean pressureItemBean = new PressureItemBean();
                PressurePartData pressurePartData = new PressurePartData();
                byte[] bArr7 = new byte[4];
                System.arraycopy(bArr, i10, bArr7, 0, 4);
                try {
                    pressureItemBean.setTimeMills((y5.b.f(bArr7) + 946684800) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                byte b12 = bArr[i10 + 4];
                char[] cArr4 = y5.b.f20001a;
                pressureItemBean.setPressure(b12 & 255);
                i10 += 6;
                pressurePartData.setTime(pressureItemBean.getTimeMills());
                pressurePartData.setPressure(pressureItemBean.getPressure());
                arrayList8.add(pressurePartData);
            }
            healthDataSyncBean.setPressurePartData(arrayList8);
        } else if (b3 == -99) {
            ArrayList arrayList9 = new ArrayList();
            healthDataSyncBean.setDataType(0);
            while (i10 < bArr.length) {
                JLStepSyncBean jLStepSyncBean = new JLStepSyncBean();
                byte[] bArr8 = new byte[4];
                System.arraycopy(bArr, i10, bArr8, 0, 4);
                try {
                    long f13 = (y5.b.f(bArr8) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                    jLStepSyncBean.setTime(f13);
                    long j14 = f13 * 1000;
                    jLStepSyncBean.setDate(com.example.baselibrary.utils.b.q(j14));
                    jLStepSyncBean.setHour(com.example.baselibrary.utils.b.p(j14));
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                jLStepSyncBean.setSteps(y5.b.d(i10 + 5, i10 + 7, bArr));
                jLStepSyncBean.setCalorie(y5.b.d(i10 + 8, i10 + 11, bArr) / 10);
                jLStepSyncBean.setDistance(y5.b.d(i10 + 12, i10 + 15, bArr) / 10000);
                i10 += 16;
                arrayList9.add(jLStepSyncBean);
            }
            healthDataSyncBean.setStepJLPartData(arrayList9);
        } else if (b3 == 117) {
            healthDataSyncBean.setDataType(14);
            ArrayList arrayList10 = new ArrayList(1);
            while (i10 < bArr.length) {
                new BloodOxyItemBean();
                BpPartData bpPartData = new BpPartData();
                byte[] bArr9 = new byte[4];
                System.arraycopy(bArr, i10, bArr9, 0, 4);
                try {
                    bpPartData.setTime((y5.b.f(bArr9) + 946684800) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                bpPartData.setSp(bArr[i10 + 4] & 255);
                byte b13 = bArr[i10 + 5];
                char[] cArr5 = y5.b.f20001a;
                bpPartData.setDp(b13 & 255);
                i10 += 6;
                arrayList10.add(bpPartData);
            }
            healthDataSyncBean.setBpPartData(arrayList10);
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(healthDataSyncBean);
        }
    }

    public static void F(byte[] bArr, ArrayList arrayList) {
        Log.e("qob", "analysisJLMuslimCountControl");
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        int i3 = b3 & 255;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((u5.c) obj).f(Integer.valueOf(i3));
        }
    }

    public static void G(byte[] bArr, ArrayList arrayList) {
        int i3 = 0;
        PowerBean powerBean = new PowerBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        powerBean.setPower(b3 & 255);
        if (bArr.length > 4) {
            powerBean.setVoltage(y5.b.j(new byte[]{bArr[4], bArr[5]}));
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(powerBean);
        }
    }

    public static void H(byte b3, byte[] bArr, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        if (bArr[2] == 48) {
            AlarmRemainderBean alarmRemainderBean = new AlarmRemainderBean();
            byte b10 = bArr[3];
            char[] cArr = y5.b.f20001a;
            alarmRemainderBean.setAlarmId(b10 & 255);
            alarmRemainderBean.setDelete(true);
            arrayList2.add(alarmRemainderBean);
        } else {
            int i10 = 3;
            while (i10 < bArr.length) {
                AlarmRemainderBean alarmRemainderBean2 = new AlarmRemainderBean();
                byte b11 = bArr[i10];
                char[] cArr2 = y5.b.f20001a;
                alarmRemainderBean2.setAlarmId(b11 & 255);
                alarmRemainderBean2.setDelete(false);
                byte[] c9 = y5.b.c(bArr[i10 + 1]);
                int[] iArr = {c9[6], c9[0], c9[1], c9[2], c9[3], c9[4], c9[5]};
                alarmRemainderBean2.setOpen(y5.b.l(c9[7], 0));
                alarmRemainderBean2.setRepeatModel(iArr);
                alarmRemainderBean2.setStartHour(bArr[i10 + 5] & 255);
                alarmRemainderBean2.setStartMin(bArr[i10 + 6] & 255);
                byte[] bArr2 = new byte[21];
                System.arraycopy(bArr, i10 + 7, bArr2, 0, 21);
                alarmRemainderBean2.setAlarmTag(y5.b.e(bArr2));
                if (b3 == 1 && bArr[2] == 0) {
                    alarmRemainderBean2.setEdit(true);
                }
                i10 += 28;
                arrayList2.add(alarmRemainderBean2);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            try {
                ((u5.c) obj).f(arrayList2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void I(byte[] bArr, ArrayList arrayList) {
        DrinkReminderBean drinkReminderBean = new DrinkReminderBean();
        byte[] c9 = y5.b.c(bArr[3]);
        int i3 = 0;
        int[] iArr = {c9[6], c9[0], c9[1], c9[2], c9[3], c9[4], c9[5]};
        drinkReminderBean.setOpen(y5.b.l(c9[7], 0));
        drinkReminderBean.setRepeatModel(iArr);
        drinkReminderBean.setStartHour(bArr[4] & 255);
        drinkReminderBean.setStartMin(bArr[5] & 255);
        drinkReminderBean.setEndHour(bArr[6] & 255);
        drinkReminderBean.setEndMin(bArr[7] & 255);
        drinkReminderBean.setRemindDuration(bArr[8] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(drinkReminderBean);
        }
    }

    public static b I0() {
        if (f19794h == null) {
            synchronized (b.class) {
                f19794h = new b();
            }
        }
        return f19794h;
    }

    public static void J(byte[] bArr, ArrayList arrayList) {
        SedentaryReminderBean sedentaryReminderBean = new SedentaryReminderBean();
        byte[] c9 = y5.b.c(bArr[3]);
        int i3 = 0;
        int[] iArr = {c9[6], c9[0], c9[1], c9[2], c9[3], c9[4], c9[5]};
        sedentaryReminderBean.setOpen(y5.b.l(c9[7], 0));
        sedentaryReminderBean.setRepeatModel(iArr);
        sedentaryReminderBean.setStartHour(bArr[4] & 255);
        sedentaryReminderBean.setStartMin(bArr[5] & 255);
        sedentaryReminderBean.setEndHour(bArr[6] & 255);
        sedentaryReminderBean.setEndMin(bArr[7] & 255);
        sedentaryReminderBean.setRemindDuration(bArr[8] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(sedentaryReminderBean);
        }
    }

    public static void K(byte[] bArr, ArrayList arrayList) {
        int[] iArr = new int[7];
        Log.e("qob", "analysisJLSettingBloodSugar");
        DrinkReminderBean drinkReminderBean = new DrinkReminderBean();
        int i3 = 0;
        drinkReminderBean.setOpen(bArr[3] > 0);
        drinkReminderBean.setRepeatModel(iArr);
        byte b3 = bArr[4];
        char[] cArr = y5.b.f20001a;
        drinkReminderBean.setStartHour(b3 & 255);
        drinkReminderBean.setStartMin(bArr[5] & 255);
        drinkReminderBean.setEndHour(bArr[6] & 255);
        drinkReminderBean.setEndMin(bArr[7] & 255);
        drinkReminderBean.setRemindDuration(bArr[8] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(drinkReminderBean);
        }
    }

    public static void L(byte[] bArr, ArrayList arrayList) {
        Log.e("qob", "analysisJLSettingChildGameApp");
        GameChildAppBean gameChildAppBean = new GameChildAppBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        gameChildAppBean.setIsAll(b3 & 255);
        gameChildAppBean.setIsBedtimeStories(bArr[4] & 255);
        gameChildAppBean.setIsChildGame(bArr[5] & 255);
        gameChildAppBean.setIsMusic(bArr[6] & 255);
        gameChildAppBean.setIsLearningCards(bArr[7] & 255);
        gameChildAppBean.setIsAudioStory(bArr[8] & 255);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(gameChildAppBean);
        }
    }

    public static void M(byte[] bArr, ArrayList arrayList) {
        int[] iArr = new int[7];
        Log.e("qob", "analysisJLSettingHrv");
        DrinkReminderBean drinkReminderBean = new DrinkReminderBean();
        int i3 = 0;
        drinkReminderBean.setOpen(bArr[3] > 0);
        drinkReminderBean.setRepeatModel(iArr);
        byte b3 = bArr[4];
        char[] cArr = y5.b.f20001a;
        drinkReminderBean.setStartHour(b3 & 255);
        drinkReminderBean.setStartMin(bArr[5] & 255);
        drinkReminderBean.setEndHour(bArr[6] & 255);
        drinkReminderBean.setEndMin(bArr[7] & 255);
        drinkReminderBean.setRemindDuration(bArr[8] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(drinkReminderBean);
        }
    }

    public static void N(byte[] bArr, ArrayList arrayList) {
        int[] iArr = new int[7];
        Log.e("qob", "analysisJLSettingStress");
        DrinkReminderBean drinkReminderBean = new DrinkReminderBean();
        int i3 = 0;
        drinkReminderBean.setOpen(bArr[3] > 0);
        drinkReminderBean.setRepeatModel(iArr);
        byte b3 = bArr[4];
        char[] cArr = y5.b.f20001a;
        drinkReminderBean.setStartHour(b3 & 255);
        drinkReminderBean.setStartMin(bArr[5] & 255);
        drinkReminderBean.setEndHour(bArr[6] & 255);
        drinkReminderBean.setEndMin(bArr[7] & 255);
        drinkReminderBean.setRemindDuration(bArr[8] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(drinkReminderBean);
        }
    }

    public static void O(byte[] bArr, ArrayList arrayList) {
        SportResultBean sportResultBean;
        int i3;
        int i10 = 0;
        if (bArr.length > 3) {
            char[] cArr = y5.b.f20001a;
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 3, bArr2, 0, 4);
            try {
                StringBuilder sb2 = new StringBuilder();
                for (int i11 = 0; i11 < 4; i11++) {
                    String hexString = Integer.toHexString(bArr2[i11] & 255);
                    if (hexString.length() < 2) {
                        sb2.append(0);
                    }
                    sb2.append(hexString);
                }
                i3 = Integer.parseUnsignedInt(sb2.toString(), 16);
            } catch (Throwable th2) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ByteConvertUtil", android.support.v4.media.session.e.p(th2, new StringBuilder("数据转换异常 ")));
                i3 = 0;
            }
            if (i3 == -1) {
                StringBuilder sb3 = new StringBuilder("");
                for (int i12 = 7; i12 < bArr.length; i12++) {
                    sb3.append(String.valueOf(bArr[i12] & 255) + Const.STR_MART_COMMA);
                }
                String sb4 = sb3.toString();
                if (!(sb4 == null || "".equals(sb4.trim()))) {
                    sb4 = sb4.substring(0, sb4.length() - 1);
                }
                sportResultBean = new SportResultBean();
                sportResultBean.setNewSportHrs(sb4);
                sportResultBean.setNewSportHrsData(true);
            } else {
                SportResultBean sportResultBean2 = new SportResultBean();
                try {
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(bArr, 3, bArr3, 0, 4);
                    sportResultBean2.setStartTime((y5.b.f(bArr3) + 946684800) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
                    System.arraycopy(bArr, 7, bArr3, 0, 4);
                    sportResultBean2.setEndTime((y5.b.f(bArr3) + 946684800) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
                    byte[] bArr4 = new byte[2];
                    System.arraycopy(bArr, 11, bArr4, 0, 2);
                    sportResultBean2.setExerciseTime(y5.b.j(bArr4));
                    System.arraycopy(bArr, 13, bArr4, 0, 2);
                    sportResultBean2.setHeight(y5.b.j(bArr4));
                    System.arraycopy(bArr, 15, bArr4, 0, 2);
                    sportResultBean2.setBarometricPressure(y5.b.j(bArr4));
                    sportResultBean2.setCadence(bArr[17] & 255);
                    sportResultBean2.setWorkModel(bArr[18] & 255);
                    System.arraycopy(bArr, 19, bArr3, 0, 4);
                    sportResultBean2.setStep(y5.b.f(bArr3));
                    System.arraycopy(bArr, 23, bArr3, 0, 4);
                    sportResultBean2.setDistance(y5.b.f(bArr3));
                    System.arraycopy(bArr, 27, bArr3, 0, 4);
                    sportResultBean2.setCalorie(y5.b.f(bArr3));
                    System.arraycopy(bArr, 31, bArr3, 0, 4);
                    sportResultBean2.setSpeed(y5.b.j(bArr3));
                    System.arraycopy(bArr, 35, bArr3, 0, 4);
                    sportResultBean2.setPace(y5.b.j(bArr3));
                    sportResultBean2.setAverageHr(bArr[39] & 255);
                    sportResultBean2.setMaxHr(bArr[40] & 255);
                    sportResultBean2.setMinHr(bArr[41] & 255);
                    sportResultBean2.setViewType(bArr[42] & 255);
                    Log.e("qob", "ViewType " + sportResultBean2.getViewType());
                    System.arraycopy(bArr, 43, bArr4, 0, 2);
                    sportResultBean2.setMaxCadence(y5.b.j(bArr4));
                    System.arraycopy(bArr, 45, bArr4, 0, 2);
                    sportResultBean2.setMinCadence(y5.b.j(bArr4));
                    System.arraycopy(bArr, 47, bArr3, 0, 4);
                    sportResultBean2.setMaxPace(y5.b.j(bArr3));
                    System.arraycopy(bArr, 51, bArr3, 0, 4);
                    sportResultBean2.setMinPace(y5.b.j(bArr3));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sportResultBean = sportResultBean2;
            }
        } else {
            sportResultBean = null;
        }
        if (sportResultBean != null) {
            int size = arrayList.size();
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((u5.c) obj).f(sportResultBean);
            }
            return;
        }
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            ((u5.c) obj2).d(113, MlKitException.CODE_SCANNER_CANCELLED);
        }
    }

    public static void Q(byte[] bArr, ArrayList arrayList) {
        SportSyncBean sportSyncBean = new SportSyncBean();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        if (bArr.length > 3) {
            int length = (bArr.length - 3) / 128;
            for (int i10 = 0; i10 < length; i10++) {
                SportResultBean sportResultBean = new SportResultBean();
                try {
                    byte[] bArr2 = new byte[4];
                    int i11 = i10 * 128;
                    System.arraycopy(bArr, i11 + 3, bArr2, 0, 4);
                    sportResultBean.setStartTime((y5.b.f(bArr2) + 946684800) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
                    System.arraycopy(bArr, i11 + 7, bArr2, 0, 4);
                    sportResultBean.setEndTime((y5.b.f(bArr2) + 946684800) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
                    byte[] bArr3 = new byte[2];
                    System.arraycopy(bArr, i11 + 11, bArr3, 0, 2);
                    sportResultBean.setExerciseTime(y5.b.j(bArr3));
                    System.arraycopy(bArr, i11 + 13, bArr3, 0, 2);
                    sportResultBean.setHeight(y5.b.j(bArr3));
                    System.arraycopy(bArr, i11 + 15, bArr3, 0, 2);
                    sportResultBean.setBarometricPressure(y5.b.j(bArr3));
                    sportResultBean.setCadence(bArr[i11 + 17] & 255);
                    sportResultBean.setWorkModel(bArr[i11 + 18] & 255);
                    System.arraycopy(bArr, i11 + 19, bArr2, 0, 4);
                    sportResultBean.setStep(y5.b.f(bArr2));
                    System.arraycopy(bArr, i11 + 23, bArr2, 0, 4);
                    sportResultBean.setDistance(y5.b.f(bArr2));
                    System.arraycopy(bArr, i11 + 27, bArr2, 0, 4);
                    sportResultBean.setCalorie(y5.b.f(bArr2));
                    System.arraycopy(bArr, i11 + 31, bArr2, 0, 4);
                    sportResultBean.setSpeed(y5.b.j(bArr2));
                    System.arraycopy(bArr, i11 + 35, bArr2, 0, 4);
                    sportResultBean.setPace(y5.b.j(bArr2));
                    sportResultBean.setAverageHr(bArr[i11 + 39] & 255);
                    sportResultBean.setMaxHr(bArr[i11 + 40] & 255);
                    sportResultBean.setMinHr(bArr[i11 + 41] & 255);
                    sportResultBean.setViewType(bArr[i11 + 42] & 255);
                    Log.e("qob", "ViewType " + sportResultBean.getViewType());
                    System.arraycopy(bArr, i11 + 43, bArr3, 0, 2);
                    sportResultBean.setMaxCadence(y5.b.j(bArr3));
                    System.arraycopy(bArr, i11 + 45, bArr3, 0, 2);
                    sportResultBean.setMinCadence(y5.b.j(bArr3));
                    System.arraycopy(bArr, i11 + 47, bArr2, 0, 4);
                    sportResultBean.setMaxPace(y5.b.j(bArr2));
                    System.arraycopy(bArr, i11 + 51, bArr2, 0, 4);
                    sportResultBean.setMinPace(y5.b.j(bArr2));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                arrayList2.add(sportResultBean);
            }
        }
        sportSyncBean.setResultItems(arrayList2);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(sportSyncBean);
        }
    }

    public static void R(byte[] bArr, ArrayList arrayList) {
        int i3;
        long j4;
        Date parse;
        Log.e("qob", "analysisJLSyncBloodSugar " + bArr.length);
        ArrayList arrayList2 = new ArrayList(1);
        ArrayList arrayList3 = new ArrayList(1);
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            BloodSugarItemBean bloodSugarItemBean = new BloodSugarItemBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                long f2 = (y5.b.f(bArr2) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                bloodSugarItemBean.setTimeMills(f2);
                long j10 = f2 * 1000;
                bloodSugarItemBean.setDate(com.example.baselibrary.utils.b.q(j10));
                bloodSugarItemBean.setHour(com.example.baselibrary.utils.b.p(j10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            bloodSugarItemBean.setSugar(y5.b.d(i10 + 4, i10 + 5, bArr) / 10.0f);
            i10 += 6;
            arrayList3.add(bloodSugarItemBean);
        }
        if (arrayList3.size() > 0) {
            HashMap a3 = y5.e.a("date", arrayList3);
            for (String strTime : a3.keySet()) {
                List<BloodSugarItemBean> list = (List) a3.get(strTime);
                BloodSugarSyncBean bloodSugarSyncBean = new BloodSugarSyncBean();
                kotlin.jvm.internal.e.f(strTime, "strTime");
                try {
                    parse = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(strTime);
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.c(strTime, " date translate error ", e10.getMessage()));
                }
                if (parse != null) {
                    j4 = parse.getTime() / 1000;
                    bloodSugarSyncBean.setTime(j4);
                    bloodSugarSyncBean.setItemCount(list.size());
                    bloodSugarSyncBean.setItems(list);
                    arrayList2.add(bloodSugarSyncBean);
                }
                j4 = 0;
                bloodSugarSyncBean.setTime(j4);
                bloodSugarSyncBean.setItemCount(list.size());
                bloodSugarSyncBean.setItems(list);
                arrayList2.add(bloodSugarSyncBean);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void S(byte[] bArr, ArrayList arrayList) {
        int i3;
        long j4;
        Date parse;
        ArrayList arrayList2 = new ArrayList(1);
        ArrayList arrayList3 = new ArrayList(1);
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            BloodOxyItemBean bloodOxyItemBean = new BloodOxyItemBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                long f2 = (y5.b.f(bArr2) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                bloodOxyItemBean.setTimeMills(f2);
                long j10 = f2 * 1000;
                bloodOxyItemBean.setDate(com.example.baselibrary.utils.b.q(j10));
                bloodOxyItemBean.setHour(com.example.baselibrary.utils.b.p(j10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte b3 = bArr[i10 + 4];
            char[] cArr = y5.b.f20001a;
            bloodOxyItemBean.setBloodOxy(b3 & 255);
            i10 += 6;
            arrayList3.add(bloodOxyItemBean);
        }
        if (arrayList3.size() > 0) {
            HashMap a3 = y5.e.a("date", arrayList3);
            for (String strTime : a3.keySet()) {
                List<BloodOxyItemBean> list = (List) a3.get(strTime);
                BloodOxySyncBean bloodOxySyncBean = new BloodOxySyncBean();
                kotlin.jvm.internal.e.f(strTime, "strTime");
                try {
                    parse = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(strTime);
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.c(strTime, " date translate error ", e10.getMessage()));
                }
                if (parse != null) {
                    j4 = parse.getTime() / 1000;
                    bloodOxySyncBean.setTime(j4);
                    bloodOxySyncBean.setItemCount(list.size());
                    bloodOxySyncBean.setItems(list);
                    arrayList2.add(bloodOxySyncBean);
                }
                j4 = 0;
                bloodOxySyncBean.setTime(j4);
                bloodOxySyncBean.setItemCount(list.size());
                bloodOxySyncBean.setItems(list);
                arrayList2.add(bloodOxySyncBean);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void T(byte[] bArr, ArrayList arrayList) {
        int i3;
        long j4;
        Date parse;
        ArrayList arrayList2 = new ArrayList(1);
        ArrayList arrayList3 = new ArrayList(1);
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            BloodPressItemBean bloodPressItemBean = new BloodPressItemBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                long f2 = (y5.b.f(bArr2) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                bloodPressItemBean.setTimeMills(f2);
                long j10 = f2 * 1000;
                bloodPressItemBean.setDate(com.example.baselibrary.utils.b.q(j10));
                bloodPressItemBean.setHour(com.example.baselibrary.utils.b.p(j10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte b3 = bArr[i10 + 4];
            char[] cArr = y5.b.f20001a;
            bloodPressItemBean.setSp(b3 & 255);
            bloodPressItemBean.setDp(bArr[i10 + 5] & 255);
            i10 += 6;
            arrayList3.add(bloodPressItemBean);
        }
        if (arrayList3.size() > 0) {
            HashMap a3 = y5.e.a("date", arrayList3);
            for (String strTime : a3.keySet()) {
                List<BloodPressItemBean> list = (List) a3.get(strTime);
                BloodPressSyncBean bloodPressSyncBean = new BloodPressSyncBean();
                kotlin.jvm.internal.e.f(strTime, "strTime");
                try {
                    parse = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(strTime);
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.c(strTime, " date translate error ", e10.getMessage()));
                }
                if (parse != null) {
                    j4 = parse.getTime() / 1000;
                    bloodPressSyncBean.setTime(j4);
                    bloodPressSyncBean.setItemCount(list.size());
                    bloodPressSyncBean.setItems(list);
                    arrayList2.add(bloodPressSyncBean);
                }
                j4 = 0;
                bloodPressSyncBean.setTime(j4);
                bloodPressSyncBean.setItemCount(list.size());
                bloodPressSyncBean.setItems(list);
                arrayList2.add(bloodPressSyncBean);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void U(byte[] bArr, ArrayList arrayList) {
        int i3;
        long j4;
        Date parse;
        ArrayList arrayList2 = new ArrayList(1);
        ArrayList arrayList3 = new ArrayList(1);
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            BodyTempItemBean bodyTempItemBean = new BodyTempItemBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                long f2 = (y5.b.f(bArr2) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                bodyTempItemBean.setTimeMills(f2);
                long j10 = f2 * 1000;
                bodyTempItemBean.setDate(com.example.baselibrary.utils.b.q(j10));
                bodyTempItemBean.setHour(com.example.baselibrary.utils.b.p(j10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            bodyTempItemBean.setTemp(y5.b.d(i10 + 4, i10 + 5, bArr) / 10.0f);
            i10 += 6;
            arrayList3.add(bodyTempItemBean);
        }
        if (arrayList3.size() > 0) {
            HashMap a3 = y5.e.a("date", arrayList3);
            for (String strTime : a3.keySet()) {
                List<BodyTempItemBean> list = (List) a3.get(strTime);
                BodyTempSyncBean bodyTempSyncBean = new BodyTempSyncBean();
                kotlin.jvm.internal.e.f(strTime, "strTime");
                try {
                    parse = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(strTime);
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.c(strTime, " date translate error ", e10.getMessage()));
                }
                if (parse != null) {
                    j4 = parse.getTime() / 1000;
                    bodyTempSyncBean.setTime(j4);
                    bodyTempSyncBean.setItemCount(list.size());
                    bodyTempSyncBean.setItems(list);
                    arrayList2.add(bodyTempSyncBean);
                }
                j4 = 0;
                bodyTempSyncBean.setTime(j4);
                bodyTempSyncBean.setItemCount(list.size());
                bodyTempSyncBean.setItems(list);
                arrayList2.add(bodyTempSyncBean);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void V(byte[] bArr, ArrayList arrayList) {
        int i3;
        long j4;
        Date parse;
        ArrayList arrayList2 = new ArrayList(1);
        ArrayList arrayList3 = new ArrayList(1);
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            HeartRateItemBean heartRateItemBean = new HeartRateItemBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                long f2 = (y5.b.f(bArr2) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                heartRateItemBean.setTimeMills(f2);
                long j10 = f2 * 1000;
                heartRateItemBean.setDate(com.example.baselibrary.utils.b.q(j10));
                heartRateItemBean.setHour(com.example.baselibrary.utils.b.p(j10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte b3 = bArr[i10 + 4];
            char[] cArr = y5.b.f20001a;
            heartRateItemBean.setHr(b3 & 255);
            i10 += 6;
            if (heartRateItemBean.getHr() > 0) {
                arrayList3.add(heartRateItemBean);
            }
        }
        if (arrayList3.size() > 0) {
            HashMap a3 = y5.e.a("date", arrayList3);
            for (String strTime : a3.keySet()) {
                List<HeartRateItemBean> list = (List) a3.get(strTime);
                HeartRateSyncBean heartRateSyncBean = new HeartRateSyncBean();
                kotlin.jvm.internal.e.f(strTime, "strTime");
                try {
                    parse = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(strTime);
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.c(strTime, " date translate error ", e10.getMessage()));
                }
                if (parse != null) {
                    j4 = parse.getTime() / 1000;
                    heartRateSyncBean.setTime(j4);
                    heartRateSyncBean.setItemCount(list.size());
                    heartRateSyncBean.setItems(list);
                    arrayList2.add(heartRateSyncBean);
                }
                j4 = 0;
                heartRateSyncBean.setTime(j4);
                heartRateSyncBean.setItemCount(list.size());
                heartRateSyncBean.setItems(list);
                arrayList2.add(heartRateSyncBean);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void W(byte[] bArr, ArrayList arrayList) {
        int i3;
        long j4;
        Date parse;
        ArrayList arrayList2 = new ArrayList(1);
        ArrayList arrayList3 = new ArrayList(1);
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            HrvItemBean hrvItemBean = new HrvItemBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                long f2 = (y5.b.f(bArr2) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                hrvItemBean.setTimeMills(f2);
                long j10 = f2 * 1000;
                hrvItemBean.setDate(com.example.baselibrary.utils.b.q(j10));
                hrvItemBean.setHour(com.example.baselibrary.utils.b.p(j10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte b3 = bArr[i10 + 4];
            char[] cArr = y5.b.f20001a;
            hrvItemBean.setHrv(b3 & 255);
            i10 += 6;
            arrayList3.add(hrvItemBean);
        }
        if (arrayList3.size() > 0) {
            HashMap a3 = y5.e.a("date", arrayList3);
            for (String strTime : a3.keySet()) {
                List<HrvItemBean> list = (List) a3.get(strTime);
                HrvSyncBean hrvSyncBean = new HrvSyncBean();
                kotlin.jvm.internal.e.f(strTime, "strTime");
                try {
                    parse = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(strTime);
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.c(strTime, " date translate error ", e10.getMessage()));
                }
                if (parse != null) {
                    j4 = parse.getTime() / 1000;
                    hrvSyncBean.setTime(j4);
                    hrvSyncBean.setItemCount(list.size());
                    hrvSyncBean.setItems(list);
                    arrayList2.add(hrvSyncBean);
                }
                j4 = 0;
                hrvSyncBean.setTime(j4);
                hrvSyncBean.setItemCount(list.size());
                hrvSyncBean.setItems(list);
                arrayList2.add(hrvSyncBean);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            u5.c cVar = (u5.c) obj;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "analysisJLSyncHrv " + cVar.toString() + " size " + arrayList.size());
            cVar.f(arrayList2);
        }
    }

    public static void X(byte[] bArr, ArrayList arrayList) {
        int i3;
        long j4;
        Date parse;
        Log.e("qob", "analysisJLSyncMuslimCount " + bArr.length);
        ArrayList arrayList2 = new ArrayList(1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            MuslimCountItemBean muslimCountItemBean = new MuslimCountItemBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                long f2 = (y5.b.f(bArr2) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                muslimCountItemBean.setTimeMills(f2);
                long j10 = f2 * 1000;
                muslimCountItemBean.setDate(com.example.baselibrary.utils.b.q(j10));
                muslimCountItemBean.setHour(com.example.baselibrary.utils.b.p(j10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            muslimCountItemBean.setCount(y5.b.d(i10 + 4, i10 + 7, bArr));
            i10 += 8;
            linkedHashMap.put(muslimCountItemBean.getDate() + muslimCountItemBean.getHour(), muslimCountItemBean);
        }
        ArrayList arrayList3 = new ArrayList(linkedHashMap.values());
        if (!arrayList3.isEmpty()) {
            HashMap a3 = y5.e.a("date", arrayList3);
            for (String strTime : a3.keySet()) {
                List<MuslimCountItemBean> list = (List) a3.get(strTime);
                MuslimCountItemBean muslimCountItemBean2 = list.get(list.size() - 1);
                MuslimCountSyncBean muslimCountSyncBean = new MuslimCountSyncBean();
                kotlin.jvm.internal.e.f(strTime, "strTime");
                try {
                    parse = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(strTime);
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.c(strTime, " date translate error ", e10.getMessage()));
                }
                if (parse != null) {
                    j4 = parse.getTime() / 1000;
                    muslimCountSyncBean.setTime(j4);
                    muslimCountSyncBean.setItemCount(list.size());
                    muslimCountSyncBean.setItems(list);
                    muslimCountSyncBean.setTotalCount(muslimCountItemBean2.getCount());
                    arrayList2.add(muslimCountSyncBean);
                }
                j4 = 0;
                muslimCountSyncBean.setTime(j4);
                muslimCountSyncBean.setItemCount(list.size());
                muslimCountSyncBean.setItems(list);
                muslimCountSyncBean.setTotalCount(muslimCountItemBean2.getCount());
                arrayList2.add(muslimCountSyncBean);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void Y(byte[] bArr, ArrayList arrayList) {
        int i3;
        long j4;
        Date parse;
        ArrayList arrayList2 = new ArrayList(1);
        ArrayList arrayList3 = new ArrayList(1);
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            PressureItemBean pressureItemBean = new PressureItemBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                long f2 = (y5.b.f(bArr2) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                Log.e("qob", "analysisJLSyncPressure " + y5.b.f(bArr2) + " getTimestamp " + f2 + " getJLUTCTimeOffset " + com.example.baselibrary.utils.b.i());
                pressureItemBean.setTimeMills(f2);
                long j10 = f2 * 1000;
                pressureItemBean.setDate(com.example.baselibrary.utils.b.q(j10));
                pressureItemBean.setHour(com.example.baselibrary.utils.b.p(j10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte b3 = bArr[i10 + 4];
            char[] cArr = y5.b.f20001a;
            pressureItemBean.setPressure(b3 & 255);
            i10 += 6;
            if (pressureItemBean.getPressure() > 0) {
                arrayList3.add(pressureItemBean);
            }
        }
        if (arrayList3.size() > 0) {
            HashMap a3 = y5.e.a("date", arrayList3);
            for (String strTime : a3.keySet()) {
                List<PressureItemBean> list = (List) a3.get(strTime);
                PressureSyncBean pressureSyncBean = new PressureSyncBean();
                kotlin.jvm.internal.e.f(strTime, "strTime");
                try {
                    parse = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(strTime);
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.c(strTime, " date translate error ", e10.getMessage()));
                }
                if (parse != null) {
                    j4 = parse.getTime() / 1000;
                    pressureSyncBean.setTime(j4);
                    pressureSyncBean.setItemCount(list.size());
                    pressureSyncBean.setItems(list);
                    arrayList2.add(pressureSyncBean);
                }
                j4 = 0;
                pressureSyncBean.setTime(j4);
                pressureSyncBean.setItemCount(list.size());
                pressureSyncBean.setItems(list);
                arrayList2.add(pressureSyncBean);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void Z(byte[] bArr, ArrayList arrayList) {
        int i3;
        ArrayList arrayList2 = new ArrayList(1);
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            JLSleepSyncBean jLSleepSyncBean = new JLSleepSyncBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                jLSleepSyncBean.setTime((y5.b.f(bArr2) + 946684800) - (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            jLSleepSyncBean.setSleepModel(bArr[i10 + 4]);
            i10 += 7;
            arrayList2.add(jLSleepSyncBean);
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void a0(byte[] bArr, ArrayList arrayList) {
        int i3;
        ArrayList arrayList2 = new ArrayList();
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            JLStepSyncBean jLStepSyncBean = new JLStepSyncBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                long f2 = (y5.b.f(bArr2) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                jLStepSyncBean.setTime(f2);
                long j4 = f2 * 1000;
                jLStepSyncBean.setDate(com.example.baselibrary.utils.b.q(j4));
                jLStepSyncBean.setHour(com.example.baselibrary.utils.b.p(j4));
            } catch (Exception e) {
                e.printStackTrace();
            }
            jLStepSyncBean.setSteps(y5.b.d(i10 + 5, i10 + 7, bArr));
            jLStepSyncBean.setCalorie(y5.b.d(i10 + 8, i10 + 11, bArr) / 10);
            jLStepSyncBean.setDistance(y5.b.d(i10 + 12, i10 + 15, bArr) / 10000);
            i10 += 16;
            arrayList2.add(jLStepSyncBean);
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void b0(byte[] bArr, ArrayList arrayList) {
        int i3;
        long j4;
        Date parse;
        ArrayList arrayList2 = new ArrayList(1);
        ArrayList arrayList3 = new ArrayList(1);
        int i10 = 3;
        while (true) {
            i3 = 0;
            if (i10 >= bArr.length) {
                break;
            }
            VaperDetailItemBean vaperDetailItemBean = new VaperDetailItemBean();
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i10, bArr2, 0, 4);
            try {
                long f2 = (y5.b.f(bArr2) + 946684800) - (com.example.baselibrary.utils.b.i() / 1000);
                vaperDetailItemBean.setTimeMills(f2);
                long j10 = f2 * 1000;
                vaperDetailItemBean.setDate(com.example.baselibrary.utils.b.q(j10));
                vaperDetailItemBean.setHour(com.example.baselibrary.utils.b.p(j10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte b3 = bArr[i10 + 4];
            char[] cArr = y5.b.f20001a;
            vaperDetailItemBean.setDuration(b3 & 255);
            i10 += 5;
            arrayList3.add(vaperDetailItemBean);
        }
        if (arrayList3.size() > 0) {
            HashMap a3 = y5.e.a("date", arrayList3);
            for (String strTime : a3.keySet()) {
                List<VaperDetailItemBean> list = (List) a3.get(strTime);
                VaperDetailSyncBean vaperDetailSyncBean = new VaperDetailSyncBean();
                kotlin.jvm.internal.e.f(strTime, "strTime");
                try {
                    parse = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(strTime);
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, r5.a.c(strTime, " date translate error ", e10.getMessage()));
                }
                if (parse != null) {
                    j4 = parse.getTime() / 1000;
                    vaperDetailSyncBean.setTime(j4);
                    vaperDetailSyncBean.setItemCount(list.size());
                    vaperDetailSyncBean.setItems(list);
                    arrayList2.add(vaperDetailSyncBean);
                }
                j4 = 0;
                vaperDetailSyncBean.setTime(j4);
                vaperDetailSyncBean.setItemCount(list.size());
                vaperDetailSyncBean.setItems(list);
                arrayList2.add(vaperDetailSyncBean);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void c(byte[] bArr, ArrayList arrayList) {
        BindInfoBean bindInfoBean = new BindInfoBean();
        int i3 = 0;
        byte b3 = bArr[0];
        char[] cArr = y5.b.f20001a;
        bindInfoBean.setBindStatus(b3 & 255);
        bindInfoBean.setBindType(bArr[1] & 255);
        int length = bArr.length - 2;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 2, bArr2, 0, length);
        bindInfoBean.setUserId(new String(bArr2, StandardCharsets.UTF_16LE));
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(bindInfoBean);
        }
    }

    public static void c0(byte[] bArr, ArrayList arrayList) {
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            u5.c cVar = (u5.c) obj;
            Log.e("qob", "analysisJLTakePhoto " + y5.b.h(bArr));
            if (bArr.length == 4) {
                cVar.f(Integer.valueOf(bArr[bArr.length - 1] & 255));
            } else {
                Log.e("qob", "analysisJLTakePhoto 过滤5个字节回复的");
            }
        }
    }

    public static void d(boolean z5, byte[] bArr, ArrayList arrayList) {
        int i3;
        BlueToothBean blueToothBean = new BlueToothBean();
        blueToothBean.setBle(z5);
        int i10 = 0;
        if (z5) {
            i3 = 0;
        } else {
            blueToothBean.setNeedBound(bArr[0] == 1);
            i3 = 1;
        }
        byte[] bArr2 = new byte[6];
        System.arraycopy(bArr, i3, bArr2, 0, 6);
        String h4 = y5.b.h(bArr2);
        blueToothBean.setMac(h4.replace(" ", ":").substring(0, h4.length() - 1).toUpperCase());
        int length = (bArr.length - 6) - (i3 + 1);
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, i3 + 7, bArr3, 0, length);
        blueToothBean.setName(new String(bArr3, StandardCharsets.UTF_16LE));
        Log.e("qob", "analysisBlueTooth " + blueToothBean.getMac() + " name " + blueToothBean.getName() + " pair " + blueToothBean.isNeedBound());
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((u5.c) obj).f(blueToothBean);
        }
    }

    public static void d0(byte[] bArr, ArrayList arrayList) {
        DrinkReminderBean drinkReminderBean = new DrinkReminderBean();
        byte[] c9 = y5.b.c(bArr[3]);
        int i3 = 0;
        int[] iArr = {c9[6], c9[0], c9[1], c9[2], c9[3], c9[4], c9[5]};
        drinkReminderBean.setOpen(y5.b.l(c9[7], 0));
        drinkReminderBean.setRepeatModel(iArr);
        drinkReminderBean.setStartHour(bArr[4] & 255);
        drinkReminderBean.setStartMin(bArr[5] & 255);
        drinkReminderBean.setEndHour(bArr[6] & 255);
        drinkReminderBean.setEndMin(bArr[7] & 255);
        drinkReminderBean.setRemindDuration(bArr[8] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(drinkReminderBean);
        }
    }

    public static void e(byte[] bArr, ArrayList arrayList) {
        Log.e("qob", "analysisBreatheData ");
        BreatheBean breatheBean = new BreatheBean();
        int i3 = 0;
        breatheBean.setOpen(bArr[0] == 1);
        byte b3 = bArr[1];
        char[] cArr = y5.b.f20001a;
        breatheBean.setTimes(b3 & 255);
        ArrayList arrayList2 = new ArrayList(1);
        int i10 = 2;
        while (i10 < bArr.length) {
            BreatheBean.TimeItem timeItem = new BreatheBean.TimeItem();
            timeItem.setHour(bArr[i10] & 255);
            timeItem.setMin(bArr[i10 + 1] & 255);
            i10 += 2;
            arrayList2.add(timeItem);
        }
        breatheBean.setBreatheTime(arrayList2);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(breatheBean);
        }
    }

    public static void e0(byte[] bArr, ArrayList arrayList) {
        DrinkReminderBean drinkReminderBean = new DrinkReminderBean();
        int i3 = 0;
        drinkReminderBean.setOpen(bArr[3] == 1);
        byte b3 = bArr[4];
        char[] cArr = y5.b.f20001a;
        drinkReminderBean.setStartHour(b3 & 255);
        drinkReminderBean.setStartMin(bArr[5] & 255);
        drinkReminderBean.setEndHour(bArr[6] & 255);
        drinkReminderBean.setEndMin(bArr[7] & 255);
        drinkReminderBean.setRemindDuration(bArr[8] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(drinkReminderBean);
        }
    }

    public static void f(byte[] bArr, ArrayList arrayList) {
        BrightScreenBean brightScreenBean = new BrightScreenBean();
        int i3 = 0;
        brightScreenBean.setOpen(y5.b.l(bArr[0], 0));
        brightScreenBean.setStartHour(bArr[1] & 255);
        brightScreenBean.setStartMin(bArr[2] & 255);
        brightScreenBean.setEndHour(bArr[3] & 255);
        brightScreenBean.setEndMin(bArr[4] & 255);
        brightScreenBean.setHasData(true);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(brightScreenBean);
        }
    }

    public static void f0(byte[] bArr, ArrayList arrayList) {
        VaperPowerBean vaperPowerBean = new VaperPowerBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        vaperPowerBean.setVaperPowerType(b3 & 255);
        vaperPowerBean.setPowerLevel(bArr[4] & 255);
        vaperPowerBean.setVaperPowerLevelNum(bArr[5] & 255);
        int[] iArr = new int[vaperPowerBean.getVaperPowerLevelNum()];
        int i3 = 0;
        for (int i10 = 0; i10 < vaperPowerBean.getVaperPowerLevelNum(); i10++) {
            iArr[i10] = bArr[i10 + 6] & 255;
        }
        vaperPowerBean.setVaperPowerLevel(iArr);
        Log.e("qob", "analysisJLVaperPower " + vaperPowerBean);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(vaperPowerBean);
        }
    }

    public static void g(byte[] bArr, ArrayList arrayList) {
        CustomDialInfoBean customDialInfoBean = new CustomDialInfoBean();
        int i3 = 0;
        byte b3 = bArr[0];
        char[] cArr = y5.b.f20001a;
        customDialInfoBean.setTimePosition(b3 & 255);
        customDialInfoBean.setTimeUpType(bArr[1] & 255);
        customDialInfoBean.setTimeDownType(bArr[2] & 255);
        customDialInfoBean.setColor(Const.STR_MART_WELL + y5.b.i(new byte[]{bArr[5], bArr[4], bArr[3]}));
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(customDialInfoBean);
        }
    }

    public static void g0(byte[] bArr, ArrayList arrayList) {
        VaperPowerOHMBean vaperPowerOHMBean = new VaperPowerOHMBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        vaperPowerOHMBean.setPowerOHM(b3 & 255);
        Log.e("qob", "VaperPowerOHMBean " + vaperPowerOHMBean);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(vaperPowerOHMBean);
        }
    }

    public static void h(byte[] bArr, ArrayList arrayList) {
        DialInfoBean dialInfoBean = new DialInfoBean();
        int i3 = 0;
        byte b3 = bArr[0];
        char[] cArr = y5.b.f20001a;
        dialInfoBean.setDialType(b3 & 255);
        dialInfoBean.setWidth(y5.b.j(new byte[]{bArr[1], bArr[2]}));
        dialInfoBean.setHeight(y5.b.j(new byte[]{bArr[3], bArr[4]}));
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(dialInfoBean);
        }
    }

    public static void h0(byte[] bArr, ArrayList arrayList) {
        VideoHidBean videoHidBean = new VideoHidBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        int i3 = 0;
        videoHidBean.setOpen((b3 & 255) == 1);
        videoHidBean.setDefaultOpen((bArr[4] & 255) == 1);
        videoHidBean.setHidOpen(bArr[3] & 255);
        Log.e("qob", "VideoHidBean " + videoHidBean);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(videoHidBean);
        }
    }

    public static void i(byte[] bArr, ArrayList arrayList) {
        SupportMenuBean supportMenuBean = new SupportMenuBean();
        int i3 = 0;
        supportMenuBean.setStep(y5.b.l(bArr[0], 0));
        supportMenuBean.setSleep(y5.b.l(bArr[0], 1));
        supportMenuBean.setHr(y5.b.l(bArr[0], 2));
        supportMenuBean.setBloodPress(y5.b.l(bArr[0], 3));
        supportMenuBean.setBloodOxy(y5.b.l(bArr[0], 4));
        supportMenuBean.setBodyTemp(y5.b.l(bArr[0], 5));
        supportMenuBean.setEcg(y5.b.l(bArr[0], 6));
        supportMenuBean.setBreathe(y5.b.l(bArr[0], 7));
        supportMenuBean.setDial(y5.b.l(bArr[1], 0));
        supportMenuBean.setWallpaperDial(y5.b.l(bArr[1], 1));
        supportMenuBean.setMsgNotification(y5.b.l(bArr[1], 2));
        supportMenuBean.setSedentary(y5.b.l(bArr[1], 3));
        supportMenuBean.setDrink(y5.b.l(bArr[1], 4));
        supportMenuBean.setRemindModel(y5.b.l(bArr[1], 5));
        supportMenuBean.setAlarm(y5.b.l(bArr[1], 6));
        supportMenuBean.setBrightScreen(y5.b.l(bArr[1], 7));
        supportMenuBean.setBrightScreenTime(y5.b.l(bArr[2], 0));
        supportMenuBean.setHrMonitor(y5.b.l(bArr[2], 1));
        supportMenuBean.setDND(y5.b.l(bArr[2], 2));
        supportMenuBean.setWeather(y5.b.l(bArr[2], 3));
        supportMenuBean.setAddressBook(y5.b.l(bArr[2], 4));
        supportMenuBean.setRecovery(y5.b.l(bArr[2], 5));
        supportMenuBean.setFirmwareUpdate(y5.b.l(bArr[2], 6));
        supportMenuBean.setNFC(y5.b.l(bArr[2], 7));
        supportMenuBean.setQrCode(y5.b.l(bArr[3], 0));
        supportMenuBean.setRestart(y5.b.l(bArr[3], 1));
        supportMenuBean.setPowerOff(y5.b.l(bArr[3], 2));
        supportMenuBean.setBlueTooth(y5.b.l(bArr[3], 3));
        supportMenuBean.setWomenHealth(y5.b.l(bArr[3], 4));
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(supportMenuBean);
        }
    }

    public static void i0(byte[] bArr, ArrayList arrayList) {
        DrinkReminderBean drinkReminderBean = new DrinkReminderBean();
        byte[] c9 = y5.b.c(bArr[3]);
        int i3 = 0;
        int[] iArr = {c9[6], c9[0], c9[1], c9[2], c9[3], c9[4], c9[5]};
        drinkReminderBean.setOpen(y5.b.l(c9[7], 0));
        drinkReminderBean.setRepeatModel(iArr);
        drinkReminderBean.setStartHour(bArr[4] & 255);
        drinkReminderBean.setStartMin(bArr[5] & 255);
        drinkReminderBean.setEndHour(bArr[6] & 255);
        drinkReminderBean.setEndMin(bArr[7] & 255);
        drinkReminderBean.setRemindDuration(bArr[8] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(drinkReminderBean);
        }
    }

    public static void j(byte[] bArr, ArrayList arrayList) {
        Log.e("qob", "analysisDeviceSupportV2 " + bArr.length);
        SupportMenuBean supportMenuBean = new SupportMenuBean();
        boolean l3 = y5.b.l(bArr[3], 0);
        boolean l5 = y5.b.l(bArr[4], 0);
        boolean l8 = y5.b.l(bArr[5], 0);
        boolean l9 = y5.b.l(bArr[6], 0);
        boolean l10 = y5.b.l(bArr[7], 0);
        boolean l11 = y5.b.l(bArr[8], 0);
        boolean l12 = y5.b.l(bArr[9], 0);
        boolean l13 = y5.b.l(bArr[10], 0);
        boolean l14 = y5.b.l(bArr[11], 0);
        boolean l15 = y5.b.l(bArr[12], 0);
        boolean l16 = y5.b.l(bArr[13], 0);
        boolean l17 = y5.b.l(bArr[14], 0);
        boolean l18 = y5.b.l(bArr[15], 0);
        boolean l19 = y5.b.l(bArr[16], 0);
        boolean l20 = y5.b.l(bArr[17], 0);
        boolean l21 = y5.b.l(bArr[18], 0);
        boolean l22 = y5.b.l(bArr[19], 0);
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 20, bArr2, 0, 4);
        try {
            long g10 = y5.b.g(bArr2);
            boolean l23 = y5.b.l(bArr[24], 0);
            boolean l24 = y5.b.l(bArr[25], 0);
            boolean l25 = y5.b.l(bArr[26], 0);
            boolean l26 = y5.b.l(bArr[27], 0);
            boolean l27 = y5.b.l(bArr[28], 0);
            boolean l28 = y5.b.l(bArr[29], 0);
            boolean l29 = y5.b.l(bArr[30], 0);
            boolean l30 = y5.b.l(bArr[31], 0);
            boolean l31 = y5.b.l(bArr[32], 0);
            boolean l32 = y5.b.l(bArr[32], 1);
            boolean l33 = y5.b.l(bArr[33], 0);
            boolean l34 = y5.b.l(bArr[34], 0);
            Log.e("qob", "tMID_BLE_MSG_SWITCH " + l22 + " tMID_BLE_FUNC2_GIRL_CARE_GERNAL " + l23);
            supportMenuBean.setAlarm(l24);
            supportMenuBean.setMsgNotification(l5);
            supportMenuBean.setAddressBook(l3);
            supportMenuBean.setTakePhoto(l8);
            supportMenuBean.setDND(l9);
            supportMenuBean.setLEDLight(l10);
            supportMenuBean.setWearDir(l11);
            supportMenuBean.setVideoHid(l12);
            supportMenuBean.setHealthMontior(l13);
            supportMenuBean.setSetBTName(l14);
            supportMenuBean.setFindDevice(l15);
            supportMenuBean.setRecovery(l16);
            supportMenuBean.setPowerOff(l17);
            supportMenuBean.setVideoHidBook(l18);
            supportMenuBean.setVideoHidMusic(l19);
            supportMenuBean.setVideoHidAndroidBook(l20);
            supportMenuBean.setChildAppSwitch(l21);
            supportMenuBean.setPushMsgEnableSwitch(l22);
            supportMenuBean.setPushMsgSwitchValue(g10);
            supportMenuBean.setFunc2GirlCareGernal(l23);
            supportMenuBean.setDefaultENSYSTEM(l26);
            supportMenuBean.setDefaultNoViewWorkout(l27);
            supportMenuBean.setNewSport(l28);
            supportMenuBean.setBrightScreenTime(l25);
            supportMenuBean.setAppFrontAndBack(l29);
            supportMenuBean.setRememberSwitch(l30);
            supportMenuBean.setSupportHrReminder(l31);
            supportMenuBean.setSupportBoReminder(l32);
            supportMenuBean.setSupportMotoVibrationLevel(l34);
            supportMenuBean.setBrightScreen(l33);
            boolean l35 = y5.b.l(bArr[83], 0);
            boolean l36 = y5.b.l(bArr[84], 0);
            boolean l37 = y5.b.l(bArr[85], 0);
            boolean l38 = y5.b.l(bArr[86], 0);
            boolean l39 = y5.b.l(bArr[87], 0);
            byte b3 = bArr[88];
            boolean l40 = y5.b.l(bArr[89], 0);
            boolean l41 = y5.b.l(bArr[90], 0);
            boolean l42 = y5.b.l(bArr[91], 0);
            boolean l43 = y5.b.l(bArr[92], 0);
            boolean l44 = y5.b.l(bArr[93], 0);
            supportMenuBean.setFunc2HealthAllSwitch(l35);
            Log.e("qob", "tMID_BLE_FUNC2_HEALTH_ALL_SWITCH " + l35 + " tMID_MID_BLE_FUNC2_STRESSS " + l42);
            if (l35) {
                supportMenuBean.setStep(l36);
                supportMenuBean.setHr(l37);
                supportMenuBean.setBloodPress(l38);
                supportMenuBean.setSleep(l39);
                supportMenuBean.setBloodOxy(l40);
                supportMenuBean.setHrv(l41);
                supportMenuBean.setPressure(l42);
                supportMenuBean.setBloodSugar(l43);
                supportMenuBean.setMuslimCountData(l44);
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((u5.c) obj).f(supportMenuBean);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void j0(byte[] bArr, ArrayList arrayList) {
        Log.e("qob", "analysisJLWomenHealth");
        JLWomenHealthBean jLWomenHealthBean = new JLWomenHealthBean();
        int i3 = 0;
        jLWomenHealthBean.setOpen(bArr[3] == 1);
        byte b3 = bArr[4];
        char[] cArr = y5.b.f20001a;
        jLWomenHealthBean.setRemindHour(b3 & 255);
        jLWomenHealthBean.setRemindMin(bArr[5] & 255);
        jLWomenHealthBean.setPeriodDays(bArr[6] & 255);
        jLWomenHealthBean.setOvulateDays(bArr[7] & 255);
        jLWomenHealthBean.setLastPeriodY(bArr[8] & 255);
        jLWomenHealthBean.setLastPeriodM(bArr[9] & 255);
        jLWomenHealthBean.setLastPeriodD(bArr[10] & 255);
        jLWomenHealthBean.setPeriodDuration(bArr[11] & 255);
        jLWomenHealthBean.setRangeDuration(bArr[12] & 255);
        if (jLWomenHealthBean.getLastPeriodY() == 255 && jLWomenHealthBean.getLastPeriodM() == 255 && jLWomenHealthBean.getLastPeriodD() == 255) {
            jLWomenHealthBean.setLastDays(System.currentTimeMillis() / 1000);
        } else {
            int lastPeriodY = jLWomenHealthBean.getLastPeriodY() + 2000;
            int lastPeriodM = jLWomenHealthBean.getLastPeriodM();
            int lastPeriodD = jLWomenHealthBean.getLastPeriodD();
            Calendar calendar = Calendar.getInstance();
            calendar.set(lastPeriodY, lastPeriodM - 1, lastPeriodD, 0, 0, 0);
            calendar.set(14, 0);
            jLWomenHealthBean.setLastDays(calendar.getTimeInMillis() / 1000);
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(jLWomenHealthBean);
        }
    }

    public static void k(byte[] bArr, ArrayList arrayList) {
        SwitchStatusBean switchStatusBean = new SwitchStatusBean();
        int i3 = 0;
        switchStatusBean.setPhoneCall(y5.b.l(bArr[0], 0));
        switchStatusBean.setSms(y5.b.l(bArr[0], 1));
        switchStatusBean.setQQ(y5.b.l(bArr[0], 2));
        switchStatusBean.setWeChat(y5.b.l(bArr[0], 3));
        switchStatusBean.setWhatsApp(y5.b.l(bArr[0], 4));
        switchStatusBean.setMessenger(y5.b.l(bArr[0], 5));
        switchStatusBean.setTwitter(y5.b.l(bArr[0], 6));
        switchStatusBean.setLinkedin(y5.b.l(bArr[0], 7));
        switchStatusBean.setInstagram(y5.b.l(bArr[1], 0));
        switchStatusBean.setFacebook(y5.b.l(bArr[1], 1));
        switchStatusBean.setLine(y5.b.l(bArr[1], 2));
        switchStatusBean.setWeWork(y5.b.l(bArr[1], 3));
        switchStatusBean.setDingDing(y5.b.l(bArr[1], 4));
        switchStatusBean.setEmail(y5.b.l(bArr[1], 5));
        switchStatusBean.setCalendar(y5.b.l(bArr[1], 6));
        switchStatusBean.setViber(y5.b.l(bArr[1], 7));
        switchStatusBean.setSkype(y5.b.l(bArr[2], 0));
        switchStatusBean.setKakaoTalk(y5.b.l(bArr[2], 1));
        switchStatusBean.setTumblr(y5.b.l(bArr[2], 2));
        switchStatusBean.setSnapchat(y5.b.l(bArr[2], 3));
        switchStatusBean.setYoutube(y5.b.l(bArr[2], 4));
        switchStatusBean.setPinterset(y5.b.l(bArr[2], 5));
        switchStatusBean.setTiktok(y5.b.l(bArr[2], 6));
        switchStatusBean.setGmail(y5.b.l(bArr[2], 7));
        switchStatusBean.setOther(y5.b.l(bArr[bArr.length - 1], 7));
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(switchStatusBean);
        }
    }

    public static void k0(byte[] bArr, ArrayList arrayList) {
        PrayerClockBean prayerClockBean = new PrayerClockBean();
        int i3 = 0;
        byte b3 = bArr[0];
        char[] cArr = y5.b.f20001a;
        int i10 = b3 & 255;
        prayerClockBean.setCount(i10);
        ArrayList arrayList2 = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            PrayerClockBean.PrayerClockData prayerClockData = new PrayerClockBean.PrayerClockData();
            int i12 = i11 * 4;
            prayerClockData.setClockType(bArr[i12 + 1] & 255);
            prayerClockData.setSwitch(y5.b.l(bArr[i12 + 2], 0));
            prayerClockData.setHour(bArr[i12 + 3] & 255);
            prayerClockData.setMinute(bArr[i12 + 4] & 255);
            arrayList2.add(prayerClockData);
        }
        prayerClockBean.setList(arrayList2);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(prayerClockBean);
        }
    }

    public static void l(byte[] bArr, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(1);
        int i3 = 0;
        int i10 = 0;
        while (i10 < bArr.length) {
            DialBean dialBean = new DialBean();
            byte b3 = bArr[i10];
            char[] cArr = y5.b.f20001a;
            dialBean.setType(b3 & 255);
            dialBean.setDialId(y5.b.d(i10 + 1, i10 + 2, bArr) + "");
            i10 += 3;
            arrayList2.add(dialBean);
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void l0(byte[] bArr, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(1);
        StringBuilder sb2 = new StringBuilder("闹钟个数：");
        int i3 = 0;
        byte b3 = bArr[0];
        char[] cArr = y5.b.f20001a;
        sb2.append(b3 & 255);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", sb2.toString());
        int i10 = 1;
        while (i10 < bArr.length) {
            AlarmRemainderBean alarmRemainderBean = new AlarmRemainderBean();
            alarmRemainderBean.setOpen((bArr[i10] & 255) == 1);
            alarmRemainderBean.setStartHour(bArr[i10 + 1] & 255);
            alarmRemainderBean.setStartMin(bArr[i10 + 2] & 255);
            byte b10 = bArr[i10 + 3];
            int[] iArr = new int[7];
            for (int i11 = 0; i11 < 7; i11++) {
                iArr[i11] = (b10 >> i11) & 1;
            }
            alarmRemainderBean.setRepeatModel(iArr);
            alarmRemainderBean.setDelayRemain((bArr[i10 + 4] & 255) == 1);
            int i12 = bArr[i10 + 5] & 255;
            int i13 = i10 + 6;
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i13, bArr2, 0, i12);
            alarmRemainderBean.setAlarmTag(y5.b.e(bArr2));
            i10 = i13 + i12;
            arrayList2.add(alarmRemainderBean);
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public static void m(byte[] bArr, ArrayList arrayList) {
        DNDModelBean dNDModelBean = new DNDModelBean();
        int i3 = 0;
        dNDModelBean.setOpen(bArr[0] == 1);
        dNDModelBean.setAllDay(bArr[1] == 1);
        byte b3 = bArr[2];
        char[] cArr = y5.b.f20001a;
        dNDModelBean.setStartHour(b3 & 255);
        dNDModelBean.setStartMin(bArr[3] & 255);
        dNDModelBean.setEndHour(bArr[4] & 255);
        dNDModelBean.setEndMin(bArr[5] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(dNDModelBean);
        }
    }

    public static void m0(byte[] bArr, ArrayList arrayList) {
        DrinkReminderBean drinkReminderBean = new DrinkReminderBean();
        int i3 = 0;
        drinkReminderBean.setOpen(y5.b.l(bArr[0], 0));
        drinkReminderBean.setRemindDuration(y5.b.d(1, 2, bArr));
        drinkReminderBean.setStartHour(bArr[3] & 255);
        drinkReminderBean.setStartMin(bArr[4] & 255);
        drinkReminderBean.setEndHour(bArr[5] & 255);
        drinkReminderBean.setEndMin(bArr[6] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(drinkReminderBean);
        }
    }

    public static void n(byte b3, ArrayList arrayList) {
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            char[] cArr = y5.b.f20001a;
            ((u5.c) obj).d(b3 & 255, 4);
        }
    }

    public static void n0(byte[] bArr, ArrayList arrayList) {
        SedentaryReminderBean sedentaryReminderBean = new SedentaryReminderBean();
        int i3 = 0;
        sedentaryReminderBean.setOpen(y5.b.l(bArr[0], 0));
        sedentaryReminderBean.setRemindDuration(y5.b.d(1, 2, bArr));
        byte b3 = bArr[3];
        int[] iArr = new int[7];
        for (int i10 = 0; i10 < 7; i10++) {
            iArr[i10] = (b3 >> i10) & 1;
        }
        sedentaryReminderBean.setRepeatModel(iArr);
        sedentaryReminderBean.setStartHour(bArr[4] & 255);
        sedentaryReminderBean.setStartMin(bArr[5] & 255);
        sedentaryReminderBean.setEndHour(bArr[6] & 255);
        sedentaryReminderBean.setEndMin(bArr[7] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(sedentaryReminderBean);
        }
    }

    public static void o(byte[] bArr, ArrayList arrayList) {
        FirmVersionBean firmVersionBean = new FirmVersionBean();
        int i3 = 0;
        try {
            int i10 = bArr[0];
            char[] cArr = y5.b.f20001a;
            int i11 = i10 & 255;
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, 1, bArr2, 0, i11);
            firmVersionBean.setDeviceClazz(y5.b.e(bArr2));
            int i12 = bArr[i11 + 1] & 255;
            byte[] bArr3 = new byte[i12];
            System.arraycopy(bArr, i11 + 2, bArr3, 0, i12);
            firmVersionBean.setDeviceNo(y5.b.e(bArr3));
        } catch (Exception e) {
            e.printStackTrace();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "analysisFirmware " + e.getMessage());
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(firmVersionBean);
        }
    }

    public static void o0(byte[] bArr, ArrayList arrayList) {
        BtNameBean btNameBean = new BtNameBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        btNameBean.setNameLen(b3 & 255);
        String e = y5.b.e(Arrays.copyOfRange(bArr, 4, bArr.length));
        btNameBean.setBtName(e);
        Log.e("qob", "analysisRingBtName ".concat(e));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(btNameBean);
        }
    }

    public static void p(byte[] bArr, ArrayList arrayList) {
        HealthDataSyncBean healthDataSyncBean = new HealthDataSyncBean();
        byte b3 = bArr[0];
        char[] cArr = y5.b.f20001a;
        healthDataSyncBean.setDataType(b3 & 255);
        if (healthDataSyncBean.getDataType() == 0) {
            ArrayList arrayList2 = new ArrayList(1);
            int i3 = 1;
            while (true) {
                if (i3 >= bArr.length) {
                    break;
                }
                StepPartData stepPartData = new StepPartData();
                int i10 = bArr[i3] & 255;
                int i11 = Calendar.getInstance().get(11);
                if (i11 == 0 && i10 != i11) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "跨天收到上一天广播步数，不回调");
                    break;
                }
                stepPartData.setIndex(i10);
                stepPartData.setSteps(y5.b.d(i3 + 1, i3 + 2, bArr));
                stepPartData.setCal(y5.b.d(i3 + 3, i3 + 5, bArr));
                stepPartData.setDistance(y5.b.d(i3 + 6, i3 + 7, bArr));
                i3 += 8;
                arrayList2.add(stepPartData);
            }
            healthDataSyncBean.setStepPartData(arrayList2);
        } else if (healthDataSyncBean.getDataType() == 1) {
            ArrayList arrayList3 = new ArrayList(1);
            int i12 = 1;
            while (i12 < bArr.length) {
                HrPartData hrPartData = new HrPartData();
                hrPartData.setTime(y5.b.d(i12, i12 + 3, bArr) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? 3600000L : 0L)) / 1000));
                hrPartData.setHr(bArr[i12 + 4] & 255);
                i12 += 5;
                arrayList3.add(hrPartData);
            }
            healthDataSyncBean.setHrPartData(arrayList3);
        } else if (healthDataSyncBean.getDataType() == 2) {
            ArrayList arrayList4 = new ArrayList(1);
            int i13 = 1;
            while (i13 < bArr.length) {
                BpPartData bpPartData = new BpPartData();
                bpPartData.setTime(y5.b.d(i13, i13 + 3, bArr) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? 3600000L : 0L)) / 1000));
                bpPartData.setSp(bArr[i13 + 4] & 255);
                bpPartData.setDp(bArr[i13 + 5] & 255);
                i13 += 6;
                arrayList4.add(bpPartData);
            }
            healthDataSyncBean.setBpPartData(arrayList4);
        } else if (healthDataSyncBean.getDataType() == 3) {
            ArrayList arrayList5 = new ArrayList(1);
            int i14 = 1;
            while (i14 < bArr.length) {
                BoPartData boPartData = new BoPartData();
                boPartData.setTime(y5.b.d(i14, i14 + 3, bArr) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? 3600000L : 0L)) / 1000));
                boPartData.setBo(bArr[i14 + 4] & 255);
                i14 += 5;
                arrayList5.add(boPartData);
            }
            healthDataSyncBean.setBoPartData(arrayList5);
        } else if (healthDataSyncBean.getDataType() == 4) {
            ArrayList arrayList6 = new ArrayList(1);
            int i15 = 1;
            while (i15 < bArr.length) {
                TempPartData tempPartData = new TempPartData();
                tempPartData.setTime(y5.b.d(i15, i15 + 3, bArr) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? 3600000L : 0L)) / 1000));
                tempPartData.setTemp(((bArr[i15 + 4] & 255) + 200) / 10.0f);
                i15 += 5;
                arrayList6.add(tempPartData);
            }
            healthDataSyncBean.setTempPartData(arrayList6);
        } else if (healthDataSyncBean.getDataType() == 5) {
            ArrayList arrayList7 = new ArrayList(1);
            int i16 = 1;
            while (i16 < bArr.length) {
                BreathPartData breathPartData = new BreathPartData();
                breathPartData.setTime(y5.b.d(i16, i16 + 3, bArr) - ((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? 3600000L : 0L)) / 1000));
                breathPartData.setBreathTime(bArr[i16 + 4] & 255);
                i16 += 5;
                arrayList7.add(breathPartData);
            }
            healthDataSyncBean.setBreathPartData(arrayList7);
        }
        int size = arrayList.size();
        int i17 = 0;
        while (i17 < size) {
            Object obj = arrayList.get(i17);
            i17++;
            ((u5.c) obj).f(healthDataSyncBean);
        }
    }

    public static void p0(byte[] bArr, ArrayList arrayList) {
        Log.e("qob", "analysisRingFactoryState");
        FactoryStateBean factoryStateBean = new FactoryStateBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        factoryStateBean.setGsensorState(b3 & 255);
        factoryStateBean.setHeartState(bArr[4] & 255);
        factoryStateBean.setWearState(bArr[5] & 255);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(factoryStateBean);
        }
    }

    public static void q(byte[] bArr, ArrayList arrayList) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "++++++", "准备回调 " + y5.b.h(bArr));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "++++++", Integer.valueOf(bArr[0] & 255));
            ((u5.c) obj).f(Integer.valueOf(bArr[0] & 255));
        }
    }

    public static void q0(byte[] bArr, ArrayList arrayList) {
        Log.e("qob", "analysisRingLedLevel " + bArr.length);
        BrightScreenLedBean brightScreenLedBean = new BrightScreenLedBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        int i3 = 0;
        brightScreenLedBean.setOpen((b3 & 255) == 1);
        brightScreenLedBean.setLcdLevel(bArr[4] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(brightScreenLedBean);
        }
    }

    public static void r(byte[] bArr, ArrayList arrayList) {
        HrMonitorBean hrMonitorBean = new HrMonitorBean();
        int i3 = 0;
        hrMonitorBean.setOpen(bArr[0] == 1);
        hrMonitorBean.setTestDuration(y5.b.d(1, 2, bArr));
        hrMonitorBean.setStartHour(bArr[3] & 255);
        hrMonitorBean.setStartMin(bArr[4] & 255);
        hrMonitorBean.setEndHour(bArr[5] & 255);
        hrMonitorBean.setEndMin(bArr[6] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(hrMonitorBean);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void r0(byte[] r22, java.util.ArrayList r23) {
        /*
            r1 = r22
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 1
            r2.<init>(r3)
            r4 = 0
            r5 = r4
        La:
            int r0 = r1.length
            if (r5 >= r0) goto Lb4
            com.example.blesdk.bean.sync.BloodOxySyncBean r6 = new com.example.blesdk.bean.sync.BloodOxySyncBean
            r6.<init>()
            r0 = 4
            byte[] r7 = new byte[r0]
            java.lang.System.arraycopy(r1, r5, r7, r4, r0)
            r8 = 1000(0x3e8, double:4.94E-321)
            r10 = 0
            r12 = 3600000(0x36ee80, double:1.7786363E-317)
            long r14 = y5.b.f(r7)     // Catch: java.lang.Exception -> L47
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L47
            int r0 = r0.getRawOffset()     // Catch: java.lang.Exception -> L47
            r16 = r5
            long r4 = (long) r0
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L45
            boolean r0 = r0.useDaylightTime()     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L3b
            r17 = r12
            goto L3d
        L3b:
            r17 = r10
        L3d:
            long r4 = r4 + r17
            long r4 = r4 / r8
            long r14 = r14 - r4
            r6.setTime(r14)     // Catch: java.lang.Exception -> L45
            goto L4d
        L45:
            r0 = move-exception
            goto L4a
        L47:
            r0 = move-exception
            r16 = r5
        L4a:
            r0.printStackTrace()
        L4d:
            int r5 = r16 + 4
            int r0 = r16 + 5
            int r0 = y5.b.d(r5, r0, r1)
            r6.setItemCount(r0)
            int r5 = r16 + 6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r3)
            r4 = 0
        L60:
            int r14 = r6.getItemCount()
            if (r4 >= r14) goto Laa
            com.example.blesdk.bean.sync.BloodOxyItemBean r14 = new com.example.blesdk.bean.sync.BloodOxyItemBean
            r14.<init>()
            int r15 = r5 + 3
            int r15 = y5.b.d(r5, r15, r1)
            r17 = r4
            long r3 = (long) r15
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            int r15 = r15.getRawOffset()
            r18 = r8
            long r7 = (long) r15
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            boolean r15 = r15.useDaylightTime()
            if (r15 == 0) goto L8c
            r20 = r12
            goto L8e
        L8c:
            r20 = r10
        L8e:
            long r7 = r7 + r20
            long r7 = r7 / r18
            long r3 = r3 - r7
            r14.setTimeMills(r3)
            int r3 = r5 + 4
            r3 = r1[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r14.setBloodOxy(r3)
            int r5 = r5 + 5
            r0.add(r14)
            int r4 = r17 + 1
            r8 = r18
            r3 = 1
            goto L60
        Laa:
            r6.setItems(r0)
            r2.add(r6)
            r3 = 1
            r4 = 0
            goto La
        Lb4:
            int r0 = r23.size()
            r4 = 0
        Lb9:
            if (r4 >= r0) goto Lc9
            r1 = r23
            java.lang.Object r3 = r1.get(r4)
            int r4 = r4 + 1
            u5.c r3 = (u5.c) r3
            r3.f(r2)
            goto Lb9
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.b.r0(byte[], java.util.ArrayList):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void s0(byte[] r22, java.util.ArrayList r23) {
        /*
            r1 = r22
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 1
            r2.<init>(r3)
            r4 = 0
            r5 = r4
        La:
            int r0 = r1.length
            if (r5 >= r0) goto Lbd
            com.example.blesdk.bean.sync.BloodPressSyncBean r6 = new com.example.blesdk.bean.sync.BloodPressSyncBean
            r6.<init>()
            r0 = 4
            byte[] r7 = new byte[r0]
            java.lang.System.arraycopy(r1, r5, r7, r4, r0)
            r8 = 1000(0x3e8, double:4.94E-321)
            r10 = 0
            r12 = 3600000(0x36ee80, double:1.7786363E-317)
            long r14 = y5.b.f(r7)     // Catch: java.lang.Exception -> L47
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L47
            int r0 = r0.getRawOffset()     // Catch: java.lang.Exception -> L47
            r16 = r5
            long r4 = (long) r0
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L45
            boolean r0 = r0.useDaylightTime()     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L3b
            r17 = r12
            goto L3d
        L3b:
            r17 = r10
        L3d:
            long r4 = r4 + r17
            long r4 = r4 / r8
            long r14 = r14 - r4
            r6.setTime(r14)     // Catch: java.lang.Exception -> L45
            goto L4d
        L45:
            r0 = move-exception
            goto L4a
        L47:
            r0 = move-exception
            r16 = r5
        L4a:
            r0.printStackTrace()
        L4d:
            int r5 = r16 + 4
            int r0 = r16 + 5
            int r0 = y5.b.d(r5, r0, r1)
            r6.setItemCount(r0)
            int r5 = r16 + 6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r3)
            r4 = 0
        L60:
            int r14 = r6.getItemCount()
            if (r4 >= r14) goto Lb3
            com.example.blesdk.bean.sync.BloodPressItemBean r14 = new com.example.blesdk.bean.sync.BloodPressItemBean
            r14.<init>()
            int r15 = r5 + 3
            int r15 = y5.b.d(r5, r15, r1)
            r17 = r4
            long r3 = (long) r15
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            int r15 = r15.getRawOffset()
            r18 = r8
            long r7 = (long) r15
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            boolean r15 = r15.useDaylightTime()
            if (r15 == 0) goto L8c
            r20 = r12
            goto L8e
        L8c:
            r20 = r10
        L8e:
            long r7 = r7 + r20
            long r7 = r7 / r18
            long r3 = r3 - r7
            r14.setTimeMills(r3)
            int r3 = r5 + 4
            r3 = r1[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r14.setSp(r3)
            int r3 = r5 + 5
            r3 = r1[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r14.setDp(r3)
            int r5 = r5 + 6
            r0.add(r14)
            int r4 = r17 + 1
            r8 = r18
            r3 = 1
            goto L60
        Lb3:
            r6.setItems(r0)
            r2.add(r6)
            r3 = 1
            r4 = 0
            goto La
        Lbd:
            int r0 = r23.size()
            r4 = 0
        Lc2:
            if (r4 >= r0) goto Ld2
            r1 = r23
            java.lang.Object r3 = r1.get(r4)
            int r4 = r4 + 1
            u5.c r3 = (u5.c) r3
            r3.f(r2)
            goto Lc2
        Ld2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.b.s0(byte[], java.util.ArrayList):void");
    }

    public static void t(byte[] bArr, ArrayList arrayList) {
        AerobicExerciseBean aerobicExerciseBean = new AerobicExerciseBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        aerobicExerciseBean.setExerciseHour(b3 & 255);
        aerobicExerciseBean.setExerciseMinute(bArr[4] & 255);
        aerobicExerciseBean.setLowerHeartRate(bArr[5] & 255);
        aerobicExerciseBean.setUpperHeartRate(bArr[6] & 255);
        aerobicExerciseBean.setLowerHeartRateDuration(bArr[7] & 255);
        aerobicExerciseBean.setLowerHeartRateVibrationCount(bArr[8] & 255);
        aerobicExerciseBean.setUpperHeartRateDuration(bArr[9] & 255);
        aerobicExerciseBean.setUpperHeartRateVibrationCount(bArr[10] & 255);
        aerobicExerciseBean.setDuration(bArr[11] & 255);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(aerobicExerciseBean);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void t0(byte[] r22, java.util.ArrayList r23) {
        /*
            r1 = r22
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 1
            r2.<init>(r3)
            r4 = 0
            r5 = r4
        La:
            int r0 = r1.length
            if (r5 >= r0) goto Lb4
            com.example.blesdk.bean.sync.BreatheSyncBean r6 = new com.example.blesdk.bean.sync.BreatheSyncBean
            r6.<init>()
            r0 = 4
            byte[] r7 = new byte[r0]
            java.lang.System.arraycopy(r1, r5, r7, r4, r0)
            r8 = 1000(0x3e8, double:4.94E-321)
            r10 = 0
            r12 = 3600000(0x36ee80, double:1.7786363E-317)
            long r14 = y5.b.f(r7)     // Catch: java.lang.Exception -> L47
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L47
            int r0 = r0.getRawOffset()     // Catch: java.lang.Exception -> L47
            r16 = r5
            long r4 = (long) r0
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L45
            boolean r0 = r0.useDaylightTime()     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L3b
            r17 = r12
            goto L3d
        L3b:
            r17 = r10
        L3d:
            long r4 = r4 + r17
            long r4 = r4 / r8
            long r14 = r14 - r4
            r6.setTime(r14)     // Catch: java.lang.Exception -> L45
            goto L4d
        L45:
            r0 = move-exception
            goto L4a
        L47:
            r0 = move-exception
            r16 = r5
        L4a:
            r0.printStackTrace()
        L4d:
            int r5 = r16 + 4
            int r0 = r16 + 5
            int r0 = y5.b.d(r5, r0, r1)
            r6.setItemCount(r0)
            int r5 = r16 + 6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r3)
            r4 = 0
        L60:
            int r14 = r6.getItemCount()
            if (r4 >= r14) goto Laa
            com.example.blesdk.bean.sync.BreatheItemBean r14 = new com.example.blesdk.bean.sync.BreatheItemBean
            r14.<init>()
            int r15 = r5 + 3
            int r15 = y5.b.d(r5, r15, r1)
            r17 = r4
            long r3 = (long) r15
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            int r15 = r15.getRawOffset()
            r18 = r8
            long r7 = (long) r15
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            boolean r15 = r15.useDaylightTime()
            if (r15 == 0) goto L8c
            r20 = r12
            goto L8e
        L8c:
            r20 = r10
        L8e:
            long r7 = r7 + r20
            long r7 = r7 / r18
            long r3 = r3 - r7
            r14.setTimeMills(r3)
            int r3 = r5 + 4
            r3 = r1[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r14.setTimeLen(r3)
            int r5 = r5 + 5
            r0.add(r14)
            int r4 = r17 + 1
            r8 = r18
            r3 = 1
            goto L60
        Laa:
            r6.setItems(r0)
            r2.add(r6)
            r3 = 1
            r4 = 0
            goto La
        Lb4:
            int r0 = r23.size()
            r4 = 0
        Lb9:
            if (r4 >= r0) goto Lc9
            r1 = r23
            java.lang.Object r3 = r1.get(r4)
            int r4 = r4 + 1
            u5.c r3 = (u5.c) r3
            r3.f(r2)
            goto Lb9
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.b.t0(byte[], java.util.ArrayList):void");
    }

    public static void u(byte[] bArr, ArrayList arrayList) {
        int i3;
        int i10;
        Log.e("qob", "analysisJLBindInfo");
        BindInfoBean bindInfoBean = new BindInfoBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        bindInfoBean.setBindStatus(b3 & 255);
        Byte b10 = (byte) 0;
        Byte b11 = (byte) 0;
        Byte b12 = (byte) 0;
        Byte b13 = (byte) 0;
        Byte b14 = (byte) 0;
        Byte b15 = (byte) 0;
        Byte b16 = (byte) 0;
        Byte b17 = (byte) 0;
        Byte b18 = (byte) 0;
        Byte b19 = (byte) 0;
        Byte b20 = (byte) 0;
        if (bArr.length > 8) {
            int length = bArr.length - 8;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 8, bArr2, 0, length);
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i11 >= length) {
                    i10 = 0;
                    break;
                }
                if (i12 == 0) {
                    int i14 = bArr2[i11] & 255;
                    int i15 = bArr2[i11 + 1] & 255;
                    if (i14 == 5) {
                        if (i15 == 2) {
                            b10 = (byte) 1;
                        } else if (i15 == 5) {
                            b11 = (byte) 1;
                        } else if (i15 == 3) {
                            b12 = (byte) 1;
                        } else if (i15 == 4) {
                            b14 = (byte) 1;
                        } else if (i15 != 8) {
                            if (i15 == 9) {
                                b13 = (byte) 1;
                            } else if (i15 == 13) {
                                b16 = (byte) 1;
                            } else if (i15 == 16) {
                                b15 = (byte) 1;
                            } else if (i15 == 23) {
                                b17 = (byte) 1;
                            } else if (i15 == 24) {
                                b18 = (byte) 1;
                            } else if (i15 == 25) {
                                b19 = (byte) 1;
                            } else if (i15 == 10) {
                                b20 = (byte) 1;
                            }
                        }
                    }
                }
                if (bArr2[i11] == 0) {
                    i12++;
                }
                int i16 = i12;
                if (i16 == 4 && i13 == 0) {
                    i13 = i11 + 1;
                }
                if (i16 == 5) {
                    i10 = i11 + 1;
                    i12 = i16;
                    break;
                } else {
                    i11++;
                    i12 = i16;
                }
            }
            int i17 = i13;
            int i18 = i11 + 1;
            while (i18 < length) {
                if (bArr2[i18] == 0) {
                    i12++;
                }
                int i19 = i12;
                if (i19 == 6) {
                    break;
                }
                i18++;
                i12 = i19;
            }
            Log.e("qob", "startIndex " + i10 + " startIndex2 " + i17);
            int i20 = (i10 + (-1)) - i17;
            byte[] bArr3 = new byte[i20];
            System.arraycopy(bArr2, i17, bArr3, 0, i20);
            String str = new String(bArr3);
            int i21 = i18 - i10;
            byte[] bArr4 = new byte[i21];
            System.arraycopy(bArr2, i10, bArr4, 0, i21);
            String str2 = new String(bArr4);
            if (str2.equalsIgnoreCase("pxi")) {
                bindInfoBean.setDeviceClazz(str);
            } else {
                bindInfoBean.setDeviceClazz(str2);
            }
            Log.e("qob", "deviceClazz " + str2 + " tDeviceModel " + str);
            byte[] bArr5 = new byte[17];
            int i22 = i18 + 5;
            int i23 = i18;
            i3 = 0;
            System.arraycopy(bArr2, i22, bArr5, 0, 17);
            bindInfoBean.setBtAddress(new String(bArr5));
            bindInfoBean.setBatteryNumDisable(bArr2[i23 + 23]);
            bindInfoBean.setAntiLostEnable(bArr2[i23 + 24]);
            bindInfoBean.setNewSleepAlgoEnable(bArr2[i23 + 25]);
            bindInfoBean.setDateFormatEnable(bArr2[i23 + 26]);
            bindInfoBean.setTemperatureUnitEnable(bArr2[i23 + 28]);
            bindInfoBean.setDrinkWaterEnable(bArr2[i23 + 29]);
            bindInfoBean.setSpo2DetectSetEnable(bArr2[i23 + 32]);
            bindInfoBean.setWashHandsEnable(bArr2[i23 + 33]);
            bindInfoBean.setWeather2Enable(bArr2[i23 + 52]);
            bindInfoBean.setIsMenstrualCycle(bArr2[i23 + 59]);
            int i24 = i23 + 61;
            if (length > i24) {
                bindInfoBean.setIsActivityDataStaticTran2(bArr2[i24]);
                i24 = i23 + 62;
            }
            if (length > i24) {
                bindInfoBean.setIsBLESupport_Function_V2(bArr2[i24]);
            }
            bindInfoBean.setIsStep(b10.byteValue());
            bindInfoBean.setIsHeartRate(b12.byteValue());
            bindInfoBean.setIsBo(b13.byteValue());
            bindInfoBean.setIsBp(b14.byteValue());
            bindInfoBean.setIsBloodSugar(b15.byteValue());
            bindInfoBean.setIsPressure(b16.byteValue());
            bindInfoBean.setIsMuslimRing(b17.byteValue());
            bindInfoBean.setIsVaperPowerData(b18.byteValue());
            bindInfoBean.setIsVaperBatteryData(b19.byteValue());
            bindInfoBean.setIsHrv(b20.byteValue());
            bindInfoBean.setIsSleep(b11.byteValue());
            if (str2.equalsIgnoreCase("pxi")) {
                bindInfoBean.setIsHealthRing((byte) 1);
            }
            Log.e("qob", "tJLBloodsugar " + b15 + " IsMenstrualCycle " + ((int) bindInfoBean.getIsMenstrualCycle()) + " weather2Enable " + ((int) bindInfoBean.getWeather2Enable()) + " tJLVaperPower " + ((int) bindInfoBean.getIsVaperPowerData()) + " tJLStress " + ((int) bindInfoBean.getIsPressure()) + " tJLStep " + ((int) bindInfoBean.getIsStep()) + " tActivity_Data_Static_Tran_2 " + ((int) bindInfoBean.getIsActivityDataStaticTran2()) + " tMID_BLE_SUPPORT_FUNCTION_V2 " + ((int) bindInfoBean.getIsBLESupport_Function_V2()) + " isHealthRing " + ((int) bindInfoBean.getIsHealthRing()) + "isSupportSleep " + b11);
        } else {
            i3 = 0;
        }
        int size = arrayList.size();
        int i25 = i3;
        while (i25 < size) {
            Object obj = arrayList.get(i25);
            i25++;
            ((u5.c) obj).f(bindInfoBean);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void u0(byte[] r22, java.util.ArrayList r23) {
        /*
            r1 = r22
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 1
            r2.<init>(r3)
            r4 = 0
            r5 = r4
        La:
            int r0 = r1.length
            if (r5 >= r0) goto Lba
            com.example.blesdk.bean.sync.BodyTempSyncBean r6 = new com.example.blesdk.bean.sync.BodyTempSyncBean
            r6.<init>()
            r0 = 4
            byte[] r7 = new byte[r0]
            java.lang.System.arraycopy(r1, r5, r7, r4, r0)
            r8 = 1000(0x3e8, double:4.94E-321)
            r10 = 0
            r12 = 3600000(0x36ee80, double:1.7786363E-317)
            long r14 = y5.b.f(r7)     // Catch: java.lang.Exception -> L47
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L47
            int r0 = r0.getRawOffset()     // Catch: java.lang.Exception -> L47
            r16 = r5
            long r4 = (long) r0
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L45
            boolean r0 = r0.useDaylightTime()     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L3b
            r17 = r12
            goto L3d
        L3b:
            r17 = r10
        L3d:
            long r4 = r4 + r17
            long r4 = r4 / r8
            long r14 = r14 - r4
            r6.setTime(r14)     // Catch: java.lang.Exception -> L45
            goto L4d
        L45:
            r0 = move-exception
            goto L4a
        L47:
            r0 = move-exception
            r16 = r5
        L4a:
            r0.printStackTrace()
        L4d:
            int r5 = r16 + 4
            int r0 = r16 + 5
            int r0 = y5.b.d(r5, r0, r1)
            r6.setItemCount(r0)
            int r5 = r16 + 6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r3)
            r4 = 0
        L60:
            int r14 = r6.getItemCount()
            if (r4 >= r14) goto Lb0
            com.example.blesdk.bean.sync.BodyTempItemBean r14 = new com.example.blesdk.bean.sync.BodyTempItemBean
            r14.<init>()
            int r15 = r5 + 3
            int r15 = y5.b.d(r5, r15, r1)
            r17 = r4
            long r3 = (long) r15
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            int r15 = r15.getRawOffset()
            r18 = r8
            long r7 = (long) r15
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            boolean r15 = r15.useDaylightTime()
            if (r15 == 0) goto L8c
            r20 = r12
            goto L8e
        L8c:
            r20 = r10
        L8e:
            long r7 = r7 + r20
            long r7 = r7 / r18
            long r3 = r3 - r7
            r14.setTimeMills(r3)
            int r3 = r5 + 4
            r3 = r1[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + 200
            float r3 = (float) r3
            r4 = 1092616192(0x41200000, float:10.0)
            float r3 = r3 / r4
            r14.setTemp(r3)
            int r5 = r5 + 5
            r0.add(r14)
            int r4 = r17 + 1
            r8 = r18
            r3 = 1
            goto L60
        Lb0:
            r6.setItems(r0)
            r2.add(r6)
            r3 = 1
            r4 = 0
            goto La
        Lba:
            int r0 = r23.size()
            r4 = 0
        Lbf:
            if (r4 >= r0) goto Lcf
            r1 = r23
            java.lang.Object r3 = r1.get(r4)
            int r4 = r4 + 1
            u5.c r3 = (u5.c) r3
            r3.f(r2)
            goto Lbf
        Lcf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.b.u0(byte[], java.util.ArrayList):void");
    }

    public static void v(byte[] bArr, ArrayList arrayList) {
        DrinkReminderBean drinkReminderBean = new DrinkReminderBean();
        if (bArr.length < 4) {
            return;
        }
        int[] iArr = new int[7];
        int i3 = 0;
        drinkReminderBean.setOpen(bArr[3] > 0);
        drinkReminderBean.setRepeatModel(iArr);
        byte b3 = bArr[4];
        char[] cArr = y5.b.f20001a;
        drinkReminderBean.setStartHour(b3 & 255);
        drinkReminderBean.setStartMin(bArr[5] & 255);
        drinkReminderBean.setEndHour(bArr[6] & 255);
        drinkReminderBean.setEndMin(bArr[7] & 255);
        drinkReminderBean.setRemindDuration(bArr[8] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(drinkReminderBean);
        }
    }

    public static void v0(byte[] bArr, ArrayList arrayList) {
        HealthSyncBean healthSyncBean = new HealthSyncBean();
        int i3 = 0;
        healthSyncBean.setTotalDataCount(y5.b.d(0, 1, bArr));
        healthSyncBean.setHasStepData(y5.b.l(bArr[2], 0));
        healthSyncBean.setHasSleepData(y5.b.l(bArr[2], 1));
        healthSyncBean.setHasHrData(y5.b.l(bArr[2], 2));
        healthSyncBean.setHasBloodPressData(y5.b.l(bArr[2], 3));
        healthSyncBean.setHasBloodOxyData(y5.b.l(bArr[2], 4));
        healthSyncBean.setHasBodyTempData(y5.b.l(bArr[2], 5));
        healthSyncBean.setHasBreatheData(y5.b.l(bArr[2], 6));
        healthSyncBean.setHasEcgData(y5.b.l(bArr[2], 7));
        healthSyncBean.setHasSportData(y5.b.l(bArr[3], 0));
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(healthSyncBean);
        }
    }

    public static void w(byte[] bArr, ArrayList arrayList) {
        DrinkReminderBean drinkReminderBean = new DrinkReminderBean();
        if (bArr.length < 4) {
            return;
        }
        int[] iArr = new int[7];
        int i3 = 0;
        drinkReminderBean.setOpen(bArr[3] > 0);
        drinkReminderBean.setRepeatModel(iArr);
        byte b3 = bArr[4];
        char[] cArr = y5.b.f20001a;
        drinkReminderBean.setStartHour(b3 & 255);
        drinkReminderBean.setStartMin(bArr[5] & 255);
        drinkReminderBean.setEndHour(bArr[6] & 255);
        drinkReminderBean.setEndMin(bArr[7] & 255);
        drinkReminderBean.setRemindDuration(bArr[8] & 255);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(drinkReminderBean);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void w0(byte[] r22, java.util.ArrayList r23) {
        /*
            r1 = r22
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 1
            r2.<init>(r3)
            r4 = 0
            r5 = r4
        La:
            int r0 = r1.length
            if (r5 >= r0) goto Lb4
            com.example.blesdk.bean.sync.HeartRateSyncBean r6 = new com.example.blesdk.bean.sync.HeartRateSyncBean
            r6.<init>()
            r0 = 4
            byte[] r7 = new byte[r0]
            java.lang.System.arraycopy(r1, r5, r7, r4, r0)
            r8 = 1000(0x3e8, double:4.94E-321)
            r10 = 0
            r12 = 3600000(0x36ee80, double:1.7786363E-317)
            long r14 = y5.b.f(r7)     // Catch: java.lang.Exception -> L47
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L47
            int r0 = r0.getRawOffset()     // Catch: java.lang.Exception -> L47
            r16 = r5
            long r4 = (long) r0
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Exception -> L45
            boolean r0 = r0.useDaylightTime()     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L3b
            r17 = r12
            goto L3d
        L3b:
            r17 = r10
        L3d:
            long r4 = r4 + r17
            long r4 = r4 / r8
            long r14 = r14 - r4
            r6.setTime(r14)     // Catch: java.lang.Exception -> L45
            goto L4d
        L45:
            r0 = move-exception
            goto L4a
        L47:
            r0 = move-exception
            r16 = r5
        L4a:
            r0.printStackTrace()
        L4d:
            int r5 = r16 + 4
            int r0 = r16 + 5
            int r0 = y5.b.d(r5, r0, r1)
            r6.setItemCount(r0)
            int r5 = r16 + 6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r3)
            r4 = 0
        L60:
            int r14 = r6.getItemCount()
            if (r4 >= r14) goto Laa
            com.example.blesdk.bean.sync.HeartRateItemBean r14 = new com.example.blesdk.bean.sync.HeartRateItemBean
            r14.<init>()
            int r15 = r5 + 3
            int r15 = y5.b.d(r5, r15, r1)
            r17 = r4
            long r3 = (long) r15
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            int r15 = r15.getRawOffset()
            r18 = r8
            long r7 = (long) r15
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            boolean r15 = r15.useDaylightTime()
            if (r15 == 0) goto L8c
            r20 = r12
            goto L8e
        L8c:
            r20 = r10
        L8e:
            long r7 = r7 + r20
            long r7 = r7 / r18
            long r3 = r3 - r7
            r14.setTimeMills(r3)
            int r3 = r5 + 4
            r3 = r1[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r14.setHr(r3)
            int r5 = r5 + 5
            r0.add(r14)
            int r4 = r17 + 1
            r8 = r18
            r3 = 1
            goto L60
        Laa:
            r6.setItems(r0)
            r2.add(r6)
            r3 = 1
            r4 = 0
            goto La
        Lb4:
            int r0 = r23.size()
            r4 = 0
        Lb9:
            if (r4 >= r0) goto Lc9
            r1 = r23
            java.lang.Object r3 = r1.get(r4)
            int r4 = r4 + 1
            u5.c r3 = (u5.c) r3
            r3.f(r2)
            goto Lb9
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.b.w0(byte[], java.util.ArrayList):void");
    }

    public static void x(byte[] bArr, ArrayList arrayList) {
        BrightScreenBean brightScreenBean = new BrightScreenBean();
        int i3 = 0;
        brightScreenBean.setOpen(y5.b.l(bArr[3], 0));
        if (bArr.length > 4) {
            brightScreenBean.setStartHour(bArr[4] & 255);
            brightScreenBean.setStartMin(bArr[5] & 255);
            brightScreenBean.setEndHour(bArr[6] & 255);
            brightScreenBean.setEndMin(bArr[7] & 255);
            brightScreenBean.setHasData(true);
        } else {
            brightScreenBean.setHasData(false);
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(brightScreenBean);
        }
    }

    public static void y(byte[] bArr, ArrayList arrayList) {
        BrightScreenTimeBean brightScreenTimeBean = new BrightScreenTimeBean();
        byte b3 = bArr[3];
        char[] cArr = y5.b.f20001a;
        brightScreenTimeBean.setTimeSecond(b3 & 255);
        int i3 = 0;
        if (bArr.length > 4) {
            if ((bArr[5] & 255) == 255) {
                int i10 = bArr[6] & 255;
                int i11 = bArr[7] & 255;
                int i12 = bArr[8] & 255;
                int i13 = bArr[9] & 255;
                int i14 = bArr[10] & 255;
                brightScreenTimeBean.setOpen(i10 == 1);
                brightScreenTimeBean.setStartHour(i11);
                brightScreenTimeBean.setStartMin(i12);
                brightScreenTimeBean.setEndHour(i13);
                brightScreenTimeBean.setEndMin(i14);
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (int i15 = 4; i15 < bArr.length; i15++) {
                    arrayList2.add((bArr[i15] & 255) + "");
                }
                StringJoiner stringJoiner = new StringJoiner("_");
                int size = arrayList2.size();
                int i16 = 0;
                while (i16 < size) {
                    Object obj = arrayList2.get(i16);
                    i16++;
                    stringJoiner.add((String) obj);
                }
                brightScreenTimeBean.setDurationNums(stringJoiner.toString());
            }
        }
        int size2 = arrayList.size();
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            ((u5.c) obj2).f(brightScreenTimeBean);
        }
    }

    public static void y0(byte[] bArr, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(1);
        int i3 = 0;
        int i10 = 0;
        while (i10 < bArr.length) {
            LogInfoBean logInfoBean = new LogInfoBean();
            logInfoBean.setTime(com.example.baselibrary.utils.b.r((y5.b.d(i10, i10 + 3, bArr) * 1000) - com.example.baselibrary.utils.b.l()));
            byte[] bArr2 = new byte[32];
            System.arraycopy(bArr, i10 + 4, bArr2, 0, 32);
            if ((bArr2[0] & 255) == 255 && (bArr2[1] & 255) == 255 && (bArr2[2] & 255) == 255 && (bArr2[3] & 255) == 255) {
                break;
            }
            logInfoBean.setContent(y5.b.e(bArr2));
            Log.e("qob", "time " + logInfoBean.getTime() + " content " + logInfoBean.getContent());
            i10 += 36;
            arrayList2.add(logInfoBean);
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(arrayList2);
        }
    }

    public final void E0(int i3) {
        int i10 = 0;
        char[] cArr = y5.b.f20001a;
        byte b3 = (byte) (i3 & 255);
        ArrayList H0 = H0(b3);
        if (H0.size() > 0) {
            int size = H0.size();
            while (i10 < size) {
                Object obj = H0.get(i10);
                i10++;
                ((u5.c) obj).d(i3, 5);
            }
            return;
        }
        if (b3 == -124 || b3 == Byte.MIN_VALUE || b3 == -126 || b3 == -123 || b3 == -122) {
            r5.c.h().n(true, new byte[]{5, 2, b3});
        }
    }

    public final void F0(byte b3) {
        ArrayList H0 = H0(b3);
        if (H0.size() == 0) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "not found callback 22 " + Integer.toHexString(b3 & 255));
            return;
        }
        int size = H0.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = H0.get(i3);
            i3++;
            char[] cArr = y5.b.f20001a;
            ((u5.c) obj).d(b3 & 255, 7);
        }
    }

    public final void G0(byte b3) {
        ArrayList H0 = H0(b3);
        if (H0.size() == 0) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "not found callback 33 " + Integer.toHexString(b3 & 255));
            return;
        }
        int size = H0.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = H0.get(i3);
            i3++;
            char[] cArr = y5.b.f20001a;
            ((u5.c) obj).d(b3 & 255, 8);
        }
    }

    public final ArrayList H0(byte b3) {
        ArrayList arrayList = new ArrayList(1);
        Iterator it = this.f19795a.iterator();
        while (it.hasNext()) {
            u5.c cVar = (u5.c) it.next();
            if (cVar != null) {
                for (byte b10 : cVar.e()) {
                    if (b10 == b3) {
                        arrayList.add(cVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final boolean J0(u5.b bVar) {
        Iterator it = this.f19795a.iterator();
        while (it.hasNext()) {
            u5.c cVar = (u5.c) it.next();
            if (cVar != null && cVar.g() == bVar) {
                return true;
            }
        }
        return false;
    }

    public final void K0(u5.c cVar) {
        if (J0(cVar.g())) {
            Log.d("tong", "isHasRegister");
        } else {
            this.f19795a.add(cVar);
        }
    }

    public final void P(byte b3, byte[] bArr, ArrayList arrayList) {
        int i3 = 0;
        if (bArr.length <= 3) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "analysisJLSportPushData设置指令收到应答 --> CMD = ", Byte.valueOf(bArr[0]), ", Key = ", Byte.valueOf(bArr[1]), ", Key flag = ", Byte.valueOf(bArr[2]));
            b(b3, bArr);
            return;
        }
        Log.e("qob", "analysisJLSportPushData");
        SportDataPushBean sportDataPushBean = new SportDataPushBean();
        sportDataPushBean.settActivityTime(Integer.valueOf(y5.b.d(3, 6, bArr)));
        sportDataPushBean.settActivitySteps(Integer.valueOf(y5.b.d(7, 10, bArr)));
        sportDataPushBean.settActivityDistance(Integer.valueOf(y5.b.d(11, 14, bArr)));
        sportDataPushBean.settActivityCalorie(Integer.valueOf(y5.b.d(15, 18, bArr)));
        sportDataPushBean.settActivityHr(Integer.valueOf(bArr[19] & 255));
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u5.c) obj).f(sportDataPushBean);
        }
    }

    public final void a(byte b3, byte[] bArr, int i3) {
        byte b10;
        HashMap hashMap = this.f19796b;
        boolean z5 = true;
        int i10 = 0;
        if (b3 == -2) {
            int d5 = y5.b.d(0, 1, bArr);
            if (d5 == this.f19797c) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "回复流水号重复，不回调");
                return;
            }
            this.f19797c = d5;
            b(bArr[2], bArr);
            byte b11 = bArr[2];
            if (b11 < 0 || b11 >= 32) {
                return;
            }
            hashMap.put(Integer.valueOf(b11 & 255), Integer.valueOf(d5));
            return;
        }
        if (b3 >= 0 && b3 < 32) {
            char[] cArr = y5.b.f20001a;
            if (((Integer) hashMap.get(Integer.valueOf(b3 & 255))) == null) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "应答缓存列表不存该指令缓存，不回调");
                return;
            }
        }
        char[] cArr2 = y5.b.f20001a;
        int i11 = b3 & 255;
        hashMap.remove(Integer.valueOf(i11));
        if (i3 == this.f19798d) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "数据回复流水号重复，不回调");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", l0.j(i3, "数据回复流水号 = "));
        this.f19798d = i3;
        ArrayList H0 = H0(b3);
        if (b3 != 122 && b3 != 123 && b3 != 124 && b3 != 125 && b3 != 126 && H0.size() == 0) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "no found callback 11 " + Integer.toHexString(i11));
            return;
        }
        try {
            if (b3 == 0) {
                o(bArr, H0);
                return;
            }
            if (b3 == 1 || b3 == 96) {
                PowerBean powerBean = new PowerBean();
                powerBean.setLowPower((bArr[0] & 255) == 1);
                powerBean.setPowerStatus(bArr[1] & 255);
                powerBean.setPower((byte) (bArr[2] & 255));
                int size = H0.size();
                while (i10 < size) {
                    Object obj = H0.get(i10);
                    i10++;
                    ((u5.c) obj).f(powerBean);
                }
                return;
            }
            if (b3 == 2) {
                c(bArr, H0);
                return;
            }
            if (b3 == 3) {
                i(bArr, H0);
                return;
            }
            if (b3 == 4) {
                h(bArr, H0);
                return;
            }
            if (b3 == 5) {
                k(bArr, H0);
                return;
            }
            if (b3 != 6 && b3 != 98) {
                if (b3 != 7 && b3 != 99) {
                    if (b3 != 21 && b3 != -112) {
                        if (b3 != 8 && b3 != 100) {
                            if (b3 != 9 && b3 != 101) {
                                if (b3 != 10 && b3 != 102) {
                                    if (b3 != 11 && b3 != 103) {
                                        if (b3 != 12 && b3 != 104) {
                                            if (b3 != 13 && b3 != 105) {
                                                if (b3 == 14) {
                                                    b10 = 14;
                                                } else {
                                                    if (b3 != 15) {
                                                        if (b3 == 16) {
                                                            l(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == 17) {
                                                            OTAStatusBean oTAStatusBean = new OTAStatusBean();
                                                            oTAStatusBean.setOtaStatus(bArr[0] & 255);
                                                            oTAStatusBean.setOtaComplete(bArr[1] == 1);
                                                            int size2 = H0.size();
                                                            while (i10 < size2) {
                                                                Object obj2 = H0.get(i10);
                                                                i10++;
                                                                ((u5.c) obj2).f(oTAStatusBean);
                                                            }
                                                            return;
                                                        }
                                                        if (b3 == 106) {
                                                            int size3 = H0.size();
                                                            int i12 = 0;
                                                            while (i12 < size3) {
                                                                Object obj3 = H0.get(i12);
                                                                i12++;
                                                                byte b12 = bArr[0];
                                                                char[] cArr3 = y5.b.f20001a;
                                                                ((u5.c) obj3).f(Integer.valueOf(b12 & 255));
                                                            }
                                                            return;
                                                        }
                                                        if (b3 == 107) {
                                                            int size4 = H0.size();
                                                            int i13 = 0;
                                                            while (i13 < size4) {
                                                                Object obj4 = H0.get(i13);
                                                                i13++;
                                                                byte b13 = bArr[0];
                                                                char[] cArr4 = y5.b.f20001a;
                                                                ((u5.c) obj4).f(Integer.valueOf(b13 & 255));
                                                            }
                                                            return;
                                                        }
                                                        if (b3 == 108) {
                                                            int size5 = H0.size();
                                                            int i14 = 0;
                                                            while (i14 < size5) {
                                                                Object obj5 = H0.get(i14);
                                                                i14++;
                                                                ((u5.c) obj5).f(Integer.valueOf(y5.b.d(0, 1, bArr)));
                                                            }
                                                            return;
                                                        }
                                                        if (b3 == 109) {
                                                            int size6 = H0.size();
                                                            int i15 = 0;
                                                            while (i15 < size6) {
                                                                Object obj6 = H0.get(i15);
                                                                i15++;
                                                                byte b14 = bArr[0];
                                                                char[] cArr5 = y5.b.f20001a;
                                                                ((u5.c) obj6).f(Integer.valueOf(b14 & 255));
                                                            }
                                                            return;
                                                        }
                                                        if (b3 == -96) {
                                                            v0(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == -95) {
                                                            C0(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == -94) {
                                                            A0(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == -93) {
                                                            w0(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == -92) {
                                                            s0(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == -91) {
                                                            r0(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == -90) {
                                                            u0(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == -89) {
                                                            t0(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == -88) {
                                                            B0(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == 97) {
                                                            p(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 == 18) {
                                                            e(bArr, H0);
                                                            return;
                                                        }
                                                        if (b3 != 122 && b3 != 123 && b3 != 124 && b3 != 125 && b3 != 126) {
                                                            if (b3 == 111) {
                                                                int size7 = H0.size();
                                                                while (i10 < size7) {
                                                                    Object obj7 = H0.get(i10);
                                                                    i10++;
                                                                    ((u5.c) obj7).f(1);
                                                                }
                                                                return;
                                                            }
                                                            if (b3 == 19) {
                                                                g(bArr, H0);
                                                                return;
                                                            }
                                                            if (b3 == -81) {
                                                                y0(bArr, H0);
                                                                return;
                                                            }
                                                            if (b3 == 112) {
                                                                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "++++++", "收到 " + y5.b.h(bArr));
                                                                q(bArr, H0);
                                                                return;
                                                            }
                                                            if (b3 == 20) {
                                                                D0(bArr, H0);
                                                                return;
                                                            }
                                                            if (b3 == 114) {
                                                                int d8 = y5.b.d(0, 1, bArr);
                                                                int size8 = H0.size();
                                                                while (i10 < size8) {
                                                                    Object obj8 = H0.get(i10);
                                                                    i10++;
                                                                    ((u5.c) obj8).f(Integer.valueOf(d8));
                                                                }
                                                                return;
                                                            }
                                                            if (b3 != Byte.MAX_VALUE) {
                                                                if (b3 == Byte.MIN_VALUE) {
                                                                    z0(bArr, H0);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                int size9 = H0.size();
                                                                while (i10 < size9) {
                                                                    Object obj9 = H0.get(i10);
                                                                    i10++;
                                                                    ((u5.c) obj9).f(1);
                                                                }
                                                                return;
                                                            }
                                                        }
                                                        byte[] bArr2 = new byte[3];
                                                        bArr2[0] = bArr[0];
                                                        bArr2[1] = bArr[1];
                                                        if (b3 == 122) {
                                                            bArr2[2] = -124;
                                                        } else if (b3 == 123) {
                                                            bArr2[2] = Byte.MIN_VALUE;
                                                        } else if (b3 == 124) {
                                                            bArr2[2] = -123;
                                                        } else if (b3 == 126) {
                                                            bArr2[2] = -122;
                                                        } else {
                                                            bArr2[2] = -126;
                                                        }
                                                        r5.c.h().n(true, bArr2);
                                                        return;
                                                    }
                                                    b10 = 14;
                                                }
                                                if (b3 != b10) {
                                                    z5 = false;
                                                }
                                                d(z5, bArr, H0);
                                                return;
                                            }
                                            m(bArr, H0);
                                            return;
                                        }
                                        r(bArr, H0);
                                        return;
                                    }
                                    BrightScreenTimeBean brightScreenTimeBean = new BrightScreenTimeBean();
                                    brightScreenTimeBean.setTimeSecond(bArr[0] & 255);
                                    int size10 = H0.size();
                                    while (i10 < size10) {
                                        Object obj10 = H0.get(i10);
                                        i10++;
                                        ((u5.c) obj10).f(brightScreenTimeBean);
                                    }
                                    return;
                                }
                                f(bArr, H0);
                                return;
                            }
                            l0(bArr, H0);
                            return;
                        }
                        ReminderModeBean reminderModeBean = new ReminderModeBean();
                        reminderModeBean.setReminderMode(bArr[0] & 255);
                        int size11 = H0.size();
                        while (i10 < size11) {
                            Object obj11 = H0.get(i10);
                            i10++;
                            ((u5.c) obj11).f(reminderModeBean);
                        }
                        return;
                    }
                    k0(bArr, H0);
                    return;
                }
                m0(bArr, H0);
                return;
            }
            n0(bArr, H0);
        } catch (Exception e) {
            e.printStackTrace();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "消息体解析错误：" + e.getMessage());
            n(b3, H0);
        }
    }

    public final void b(byte b3, byte[] bArr) {
        try {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", y5.b.h(bArr));
            ArrayList H0 = H0(b3);
            if (H0.size() > 0) {
                int size = H0.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = H0.get(i3);
                    i3++;
                    u5.c cVar = (u5.c) obj;
                    if (y5.d.f20005b) {
                        cVar.h(b3, (byte) 0);
                    } else {
                        cVar.h(b3, bArr[3]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "设备应答解析错误：" + e.getMessage());
            ArrayList H02 = H0(b3);
            if (H02.size() > 0) {
                n(b3, H02);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0144 A[LOOP:1: B:39:0x0142->B:40:0x0144, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(byte[] r21, java.util.ArrayList r22) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.b.s(byte[], java.util.ArrayList):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x00f6 A[LOOP:1: B:80:0x00f4->B:81:0x00f6, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0090 -> B:34:0x00e0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x0(byte[] r8, java.util.ArrayList r9) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.b.x0(byte[], java.util.ArrayList):void");
    }

    public final void z(byte b3, byte[] bArr) {
        byte b10 = bArr[0];
        byte b11 = bArr[1];
        byte b12 = bArr[2];
        String i3 = y5.b.i(new byte[]{b10, b11, b12});
        HashMap hashMap = y5.c.f20003a;
        byte byteValue = hashMap.containsKey(i3) ? ((Byte) hashMap.get(i3)).byteValue() : (byte) 0;
        StringBuilder s7 = l0.s(b10, "analysisJLData ", b11, " ", " ");
        s7.append((int) b12);
        s7.append(" ");
        s7.append(byteValue & 255);
        Log.e("qob", s7.toString());
        if (b3 == 17 && (byteValue == -4 || byteValue == -11 || byteValue == -12 || byteValue == -15 || byteValue == -16 || byteValue == -17 || byteValue == -18 || byteValue == -19 || byteValue == -20 || byteValue == -21 || byteValue == -23 || byteValue == -25 || byteValue == -27 || byteValue == -29 || byteValue == -31 || byteValue == -108 || byteValue == 19 || byteValue == 22 || byteValue == 24 || byteValue == 26 || byteValue == 29 || byteValue == -32 || byteValue == -35 || byteValue == -34 || byteValue == -3 || byteValue == -36 || byteValue == -8 || byteValue == -40 || byteValue == -41 || byteValue == -42 || byteValue == -43 || byteValue == -45 || byteValue == -46 || byteValue == -47 || byteValue == -49 || byteValue == -51 || byteValue == -53 || byteValue == 75 || byteValue == 32 || byteValue == 35 || byteValue == 38 || byteValue == 40 || byteValue == 42 || byteValue == 44 || byteValue == 50 || byteValue == 52 || byteValue == -55 || byteValue == -76 || byteValue == -77 || byteValue == 31 || byteValue == 54 || byteValue == -81 || byteValue == 59 || byteValue == -79 || byteValue == -82 || byteValue == -6 || byteValue == -96 || byteValue == -88 || byteValue == -89 || byteValue == 64 || byteValue == 65 || byteValue == 66 || byteValue == 68)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "设置指令收到应答 --> CMD = ", Byte.valueOf(bArr[0]), ", Key = ", Byte.valueOf(bArr[1]), ", Key flag = ", Byte.valueOf(bArr[2]));
            b(byteValue, bArr);
            return;
        }
        if (byteValue == -9 || byteValue == -10 || byteValue == -85 || byteValue == -86 || byteValue == -87 || byteValue == 21) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "杰理文件传输指令返回");
            r5.c.h().o(false, bArr, byteValue);
            return;
        }
        ArrayList H0 = H0(byteValue);
        try {
            if (byteValue == -3) {
                u(bArr, H0);
                return;
            }
            if (byteValue != -27 && byteValue != -28) {
                if (byteValue == -78) {
                    if (bArr.length < 5) {
                        int size = H0.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj = H0.get(i10);
                            i10++;
                            ((u5.c) obj).d(-78, 2001);
                        }
                        return;
                    }
                    int i11 = bArr[4] & 255;
                    int size2 = H0.size();
                    int i12 = 0;
                    while (i12 < size2) {
                        Object obj2 = H0.get(i12);
                        i12++;
                        ((u5.c) obj2).f(Integer.valueOf(i11));
                    }
                    return;
                }
                if (byteValue == 71) {
                    D(bArr, H0);
                    return;
                }
                if (byteValue == 31) {
                    Log.e("qob", "analysisJLHealthDataControl");
                    int i13 = bArr.length > 5 ? (bArr[5] & 255) + 10 : 0;
                    int size3 = H0.size();
                    int i14 = 0;
                    while (i14 < size3) {
                        Object obj3 = H0.get(i14);
                        i14++;
                        ((u5.c) obj3).f(Integer.valueOf(i13));
                    }
                    return;
                }
                if (byteValue == 54) {
                    F(bArr, H0);
                    return;
                }
                if (byteValue == 59) {
                    F(bArr, H0);
                    return;
                }
                if (byteValue == -5) {
                    if (bArr.length < 4) {
                        int size4 = H0.size();
                        int i15 = 0;
                        while (i15 < size4) {
                            Object obj4 = H0.get(i15);
                            i15++;
                            ((u5.c) obj4).d(-5, 2001);
                        }
                        return;
                    }
                    BaseAnswerBean baseAnswerBean = new BaseAnswerBean();
                    baseAnswerBean.setStatusCode(bArr[3]);
                    int size5 = H0.size();
                    int i16 = 0;
                    while (i16 < size5) {
                        Object obj5 = H0.get(i16);
                        i16++;
                        ((u5.c) obj5).f(baseAnswerBean);
                    }
                    return;
                }
                if (byteValue != -59 && byteValue != -99 && byteValue != -100 && byteValue != -101 && byteValue != 34 && byteValue != 37 && byteValue != 46 && byteValue != 117) {
                    if (byteValue == -14) {
                        C(bArr, H0);
                        return;
                    }
                    if (byteValue == -13) {
                        G(bArr, H0);
                        return;
                    }
                    if (byteValue == -90) {
                        A(bArr, H0);
                        return;
                    }
                    if (byteValue != -23 && byteValue != -24) {
                        if (byteValue != -36 && byteValue != -37) {
                            if (byteValue != -43 && byteValue != -44) {
                                if (byteValue != -47 && byteValue != -48) {
                                    if (byteValue != -53 && byteValue != -54) {
                                        if (byteValue != 75 && byteValue != 74) {
                                            if (byteValue != 32 && byteValue != 33) {
                                                if (byteValue != 35 && byteValue != 36) {
                                                    if (byteValue != 38 && byteValue != 39) {
                                                        if (byteValue != 40 && byteValue != 41) {
                                                            if (byteValue != 42 && byteValue != 47) {
                                                                if (byteValue != 44 && byteValue != 45) {
                                                                    if (byteValue != 65 && byteValue != 72) {
                                                                        if (byteValue != -55 && byteValue != -56) {
                                                                            if (byteValue != -49 && byteValue != -50) {
                                                                                if (byteValue != -51 && byteValue != -52) {
                                                                                    if (byteValue != -32 && byteValue != -34 && byteValue != -33 && byteValue != -35) {
                                                                                        if (byteValue != -79 && byteValue != -81 && byteValue != -80 && byteValue != -82) {
                                                                                            if (byteValue != -29 && byteValue != -30) {
                                                                                                if (byteValue != -21 && byteValue != -22 && byteValue != 50 && byteValue != 51) {
                                                                                                    if (byteValue != 52 && byteValue != 53) {
                                                                                                        if (byteValue != -108 && byteValue != -107) {
                                                                                                            if (byteValue == -104) {
                                                                                                                g0(bArr, H0);
                                                                                                                return;
                                                                                                            }
                                                                                                            if (byteValue != 19 && byteValue != 20) {
                                                                                                                if (byteValue != 22 && byteValue != 23) {
                                                                                                                    if (byteValue != 24 && byteValue != 25) {
                                                                                                                        if (byteValue != 26 && byteValue != 27) {
                                                                                                                            if (byteValue == 49) {
                                                                                                                                p0(bArr, H0);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            if (byteValue != 29 && byteValue != 30) {
                                                                                                                                if (byteValue != -46 && byteValue != -97) {
                                                                                                                                    if (byteValue != -25 && byteValue != -26) {
                                                                                                                                        if (byteValue == -7) {
                                                                                                                                            c0(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -40) {
                                                                                                                                            int size6 = H0.size();
                                                                                                                                            int i17 = 0;
                                                                                                                                            while (i17 < size6) {
                                                                                                                                                Object obj6 = H0.get(i17);
                                                                                                                                                i17++;
                                                                                                                                                byte b13 = bArr[3];
                                                                                                                                                char[] cArr = y5.b.f20001a;
                                                                                                                                                ((u5.c) obj6).f(Integer.valueOf(b13 & 255));
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -89) {
                                                                                                                                            int size7 = H0.size();
                                                                                                                                            int i18 = 0;
                                                                                                                                            while (i18 < size7) {
                                                                                                                                                Object obj7 = H0.get(i18);
                                                                                                                                                i18++;
                                                                                                                                                byte b14 = bArr[bArr.length - 1];
                                                                                                                                                char[] cArr2 = y5.b.f20001a;
                                                                                                                                                ((u5.c) obj7).f(Integer.valueOf((b14 & 255) + 1));
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -60) {
                                                                                                                                            a0(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -66) {
                                                                                                                                            Z(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -62) {
                                                                                                                                            V(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -64) {
                                                                                                                                            T(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -70) {
                                                                                                                                            S(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -68) {
                                                                                                                                            U(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -72) {
                                                                                                                                            W(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -74) {
                                                                                                                                            Y(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -112) {
                                                                                                                                            R(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -110) {
                                                                                                                                            X(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -103) {
                                                                                                                                            b0(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -83) {
                                                                                                                                            Q(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == 113) {
                                                                                                                                            O(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -96) {
                                                                                                                                            Log.e("qob", "JL_SET_MUSIC_ID 音乐控制相关");
                                                                                                                                            int size8 = H0.size();
                                                                                                                                            int i19 = 0;
                                                                                                                                            while (i19 < size8) {
                                                                                                                                                Object obj8 = H0.get(i19);
                                                                                                                                                i19++;
                                                                                                                                                byte b15 = bArr[bArr.length - 1];
                                                                                                                                                char[] cArr3 = y5.b.f20001a;
                                                                                                                                                ((u5.c) obj8).f(Integer.valueOf(b15 & 255));
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -106) {
                                                                                                                                            x0(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -105) {
                                                                                                                                            s(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == -98) {
                                                                                                                                            Log.e("BleResultHelper", "JL_CONTACT_FILE_DELETE_TRANSFER_ID 删除通讯录");
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue == 18) {
                                                                                                                                            j(bArr, H0);
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        if (byteValue != 66 && byteValue != 67) {
                                                                                                                                            if (byteValue != 68 && byteValue != 69) {
                                                                                                                                                if (byteValue != 70) {
                                                                                                                                                    if (byteValue == -58 || byteValue == 57) {
                                                                                                                                                        P(byteValue, bArr, H0);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                Log.e("qob", "analysisJLHrBoActualReminder");
                                                                                                                                                HrBoActualReminderBean hrBoActualReminderBean = new HrBoActualReminderBean();
                                                                                                                                                byte b16 = bArr[3];
                                                                                                                                                char[] cArr4 = y5.b.f20001a;
                                                                                                                                                hrBoActualReminderBean.setType(b16 & 255);
                                                                                                                                                hrBoActualReminderBean.setRemindValue(bArr[4] & 255);
                                                                                                                                                int size9 = H0.size();
                                                                                                                                                int i20 = 0;
                                                                                                                                                while (i20 < size9) {
                                                                                                                                                    Object obj9 = H0.get(i20);
                                                                                                                                                    i20++;
                                                                                                                                                    ((u5.c) obj9).f(hrBoActualReminderBean);
                                                                                                                                                }
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            Log.e("qob", "analysisJLBoReminder");
                                                                                                                                            BoReminderBean boReminderBean = new BoReminderBean();
                                                                                                                                            boReminderBean.setOpen(bArr[3] > 0);
                                                                                                                                            byte b17 = bArr[4];
                                                                                                                                            char[] cArr5 = y5.b.f20001a;
                                                                                                                                            boReminderBean.setRemindValue(b17 & 255);
                                                                                                                                            int size10 = H0.size();
                                                                                                                                            int i21 = 0;
                                                                                                                                            while (i21 < size10) {
                                                                                                                                                Object obj10 = H0.get(i21);
                                                                                                                                                i21++;
                                                                                                                                                ((u5.c) obj10).f(boReminderBean);
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        Log.e("qob", "analysisJLHrReminder");
                                                                                                                                        HrReminderBean hrReminderBean = new HrReminderBean();
                                                                                                                                        hrReminderBean.setOpen(bArr[3] > 0);
                                                                                                                                        byte b18 = bArr[4];
                                                                                                                                        char[] cArr6 = y5.b.f20001a;
                                                                                                                                        hrReminderBean.setRemindValue(b18 & 255);
                                                                                                                                        int size11 = H0.size();
                                                                                                                                        int i22 = 0;
                                                                                                                                        while (i22 < size11) {
                                                                                                                                            Object obj11 = H0.get(i22);
                                                                                                                                            i22++;
                                                                                                                                            ((u5.c) obj11).f(hrReminderBean);
                                                                                                                                        }
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                    B(bArr, H0);
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                                j0(bArr, H0);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            Log.e("qob", "analysisRingWearHand");
                                                                                                                            FactoryInBean factoryInBean = new FactoryInBean();
                                                                                                                            factoryInBean.setOpen(bArr[3] & 255);
                                                                                                                            int size12 = H0.size();
                                                                                                                            int i23 = 0;
                                                                                                                            while (i23 < size12) {
                                                                                                                                Object obj12 = H0.get(i23);
                                                                                                                                i23++;
                                                                                                                                ((u5.c) obj12).f(factoryInBean);
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        }
                                                                                                                        Log.e("qob", "analysisRingFactoryIn");
                                                                                                                        FactoryInBean factoryInBean2 = new FactoryInBean();
                                                                                                                        factoryInBean2.setOpen(bArr[3] & 255);
                                                                                                                        int size13 = H0.size();
                                                                                                                        int i24 = 0;
                                                                                                                        while (i24 < size13) {
                                                                                                                            Object obj13 = H0.get(i24);
                                                                                                                            i24++;
                                                                                                                            ((u5.c) obj13).f(factoryInBean2);
                                                                                                                        }
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    q0(bArr, H0);
                                                                                                                    return;
                                                                                                                }
                                                                                                                o0(bArr, H0);
                                                                                                                return;
                                                                                                            }
                                                                                                            h0(bArr, H0);
                                                                                                            return;
                                                                                                        }
                                                                                                        f0(bArr, H0);
                                                                                                        return;
                                                                                                    }
                                                                                                    MuslimFlashCountBean muslimFlashCountBean = new MuslimFlashCountBean();
                                                                                                    muslimFlashCountBean.setGoalFlashCount(bArr[3] & 255);
                                                                                                    muslimFlashCountBean.setAlarmFlashCount(bArr[(bArr[4] & 255) + 4] & 255);
                                                                                                    int size14 = H0.size();
                                                                                                    int i25 = 0;
                                                                                                    while (i25 < size14) {
                                                                                                        Object obj14 = H0.get(i25);
                                                                                                        i25++;
                                                                                                        ((u5.c) obj14).f(muslimFlashCountBean);
                                                                                                    }
                                                                                                    return;
                                                                                                }
                                                                                                y(bArr, H0);
                                                                                                return;
                                                                                            }
                                                                                            x(bArr, H0);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    H(b3, bArr, H0);
                                                                                    return;
                                                                                }
                                                                                int i26 = bArr[3] & 255;
                                                                                int size15 = H0.size();
                                                                                int i27 = 0;
                                                                                while (i27 < size15) {
                                                                                    Object obj15 = H0.get(i27);
                                                                                    i27++;
                                                                                    ((u5.c) obj15).f(Integer.valueOf(i26));
                                                                                }
                                                                                return;
                                                                            }
                                                                            t(bArr, H0);
                                                                            return;
                                                                        }
                                                                        i0(bArr, H0);
                                                                        return;
                                                                    }
                                                                    byte b19 = bArr[3];
                                                                    char[] cArr7 = y5.b.f20001a;
                                                                    int i28 = b19 & 255;
                                                                    Log.e("qob", "analysisJLSettingMuslimCountSwitch " + i28);
                                                                    int size16 = H0.size();
                                                                    int i29 = 0;
                                                                    while (i29 < size16) {
                                                                        Object obj16 = H0.get(i29);
                                                                        i29++;
                                                                        ((u5.c) obj16).f(Integer.valueOf(i28));
                                                                    }
                                                                    return;
                                                                }
                                                                Log.e("qob", "analysisJLSettingMuslimCountClean");
                                                                int size17 = H0.size();
                                                                int i30 = 0;
                                                                while (i30 < size17) {
                                                                    Object obj17 = H0.get(i30);
                                                                    i30++;
                                                                    ((u5.c) obj17).f(0);
                                                                }
                                                                return;
                                                            }
                                                            Integer valueOf = Integer.valueOf(y5.b.d(3, 6, bArr));
                                                            Log.e("qob", "analysisJLSettingMuslimCountGoal " + valueOf);
                                                            int size18 = H0.size();
                                                            int i31 = 0;
                                                            while (i31 < size18) {
                                                                Object obj18 = H0.get(i31);
                                                                i31++;
                                                                ((u5.c) obj18).f(valueOf);
                                                            }
                                                            return;
                                                        }
                                                        L(bArr, H0);
                                                        return;
                                                    }
                                                    K(bArr, H0);
                                                    return;
                                                }
                                                N(bArr, H0);
                                                return;
                                            }
                                            M(bArr, H0);
                                            return;
                                        }
                                        w(bArr, H0);
                                        return;
                                    }
                                    v(bArr, H0);
                                    return;
                                }
                                d0(bArr, H0);
                                return;
                            }
                            e0(bArr, H0);
                            return;
                        }
                        I(bArr, H0);
                        return;
                    }
                    J(bArr, H0);
                    return;
                }
                E(byteValue, bArr, H0);
                return;
            }
            Log.e("qob", "analysisRingVibrationLevel");
            BrightVibrationBean brightVibrationBean = new BrightVibrationBean();
            byte b20 = bArr[3];
            char[] cArr8 = y5.b.f20001a;
            brightVibrationBean.setLevel(b20 & 255);
            brightVibrationBean.setCount(bArr[4] & 255);
            int size19 = H0.size();
            int i32 = 0;
            while (i32 < size19) {
                Object obj19 = H0.get(i32);
                i32++;
                ((u5.c) obj19).f(brightVibrationBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BleResultHelper", "消息体解析错误：" + e.getMessage());
            n(byteValue, H0);
        }
    }

    public final void z0(byte[] bArr, ArrayList arrayList) {
        ArrayList arrayList2 = this.f19799f;
        if (arrayList2.size() == 10) {
            arrayList2.clear();
        }
        LogInfoBean logInfoBean = new LogInfoBean();
        int i3 = 0;
        logInfoBean.setTime(com.example.baselibrary.utils.b.r((y5.b.d(0, 3, bArr) * 1000) - com.example.baselibrary.utils.b.l()));
        byte[] bArr2 = new byte[bArr.length - 4];
        System.arraycopy(bArr, 4, bArr2, 0, bArr.length - 4);
        logInfoBean.setContent(y5.b.e(bArr2));
        arrayList2.add(logInfoBean);
        Log.e("qob", "time " + logInfoBean.getTime() + " getContent " + logInfoBean.getContent() + " logInfos " + arrayList2.size());
        if (arrayList2.size() > 0) {
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((u5.c) obj).f(arrayList2);
            }
        }
    }
}
