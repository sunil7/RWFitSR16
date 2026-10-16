package y2;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import androidx.appcompat.widget.i1;
import androidx.appcompat.widget.y0;
import androidx.work.impl.WorkDatabase;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.BreatheBean;
import com.example.blesdk.bean.function.BrightScreenBean;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.test.presenter.device.g1;
import com.example.test.presenter.device.s0;
import com.example.test.presenter.device.t0;
import com.example.test.service.u1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.BoWatcherActivity;
import com.example.test.ui.device.activity.BreatheSettingActivity;
import com.example.test.ui.device.activity.BtWatcherActivity;
import com.example.test.ui.device.activity.DeviceScanActivity;
import com.example.test.ui.device.activity.DialListActivity;
import com.example.test.ui.device.activity.DrinkActivity;
import com.example.test.ui.device.activity.DrinkJLActivity;
import com.example.test.ui.device.activity.HrWatcherActivity;
import com.example.test.ui.device.activity.HrWatcherJlActivity;
import com.example.test.ui.device.activity.LongSitActivity;
import com.example.test.ui.device.activity.LongSitJLActivity;
import com.example.test.ui.device.activity.MessagePushActivity;
import com.example.test.ui.device.activity.MoreActivity;
import com.example.test.ui.device.activity.NoDisturbActivity;
import com.example.test.ui.device.activity.QrCodeManagerActivity;
import com.example.test.ui.device.activity.RingMessagePushActivity;
import com.example.test.ui.device.activity.ScanQrCodeActivity;
import com.example.test.ui.device.activity.ScheduleActivity;
import com.example.test.ui.device.activity.ScreenLightActivity;
import com.example.test.utils.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import f6.s1;
import f6.w2;
import f7.y;
import java.util.List;

/* loaded from: classes.dex */
public class f implements i1, y0, t6.b, a7.e, t6.d, t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19952a;

    /* renamed from: b, reason: collision with root package name */
    public Object f19953b;

    public /* synthetic */ f() {
        this.f19952a = 8;
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void i() {
    }

    private final void j() {
    }

    private final void k() {
    }

    private final void l() {
    }

    @Override // a7.e
    public void B() {
        byte[] bArr;
        switch (this.f19952a) {
            case 11:
                int i3 = BoWatcherActivity.I;
                BoWatcherActivity boWatcherActivity = (BoWatcherActivity) this.f19953b;
                boWatcherActivity.S0().setOpen(((w2) boWatcherActivity.f7247z.getValue()).f13427g.getItemOpen());
                com.example.test.presenter.device.j jVar = (com.example.test.presenter.device.j) boWatcherActivity.I0();
                DrinkReminderBean data = boWatcherActivity.S0();
                jVar.getClass();
                kotlin.jvm.internal.e.f(data, "data");
                jVar.f7439b = data;
                ((XXBaseActivity) ((f7.k) jVar.f7255a)).V();
                com.google.android.gms.internal.mlkit_vision_common.p.J(data);
                break;
            case 12:
                int i10 = BreatheSettingActivity.L;
                BreatheSettingActivity breatheSettingActivity = (BreatheSettingActivity) this.f19953b;
                com.example.test.presenter.device.l lVar = (com.example.test.presenter.device.l) breatheSettingActivity.I0();
                BreatheBean breatheBean = breatheSettingActivity.S0();
                lVar.getClass();
                kotlin.jvm.internal.e.f(breatheBean, "breatheBean");
                ((XXBaseActivity) ((f7.c) lVar.f7255a)).V();
                lVar.f7455c = breatheBean;
                com.example.test.presenter.device.k customStatusCallback = (com.example.test.presenter.device.k) lVar.f7456d.getValue();
                kotlin.jvm.internal.e.f(customStatusCallback, "customStatusCallback");
                x5.b.I0().K0(new u5.f(51, customStatusCallback));
                if (r5.b.k().f18054c) {
                    x5.d c9 = x5.d.c();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getBreatheCmd " + breatheBean);
                    List<BreatheBean.TimeItem> breatheTime = breatheBean.getBreatheTime();
                    if (breatheTime == null || breatheTime.isEmpty() || breatheBean.getBreatheTime().size() < 5) {
                        bArr = new byte[0];
                    } else {
                        bArr = new byte[(breatheBean.getBreatheTime().size() * 2) + 2];
                        bArr[0] = breatheBean.isOpen();
                        int times = breatheBean.getTimes();
                        char[] cArr = y5.b.f20001a;
                        bArr[1] = (byte) (times & 255);
                        List<BreatheBean.TimeItem> breatheTime2 = breatheBean.getBreatheTime();
                        kotlin.jvm.internal.e.e(breatheTime2, "getBreatheTime(...)");
                        int i11 = 2;
                        for (BreatheBean.TimeItem timeItem : breatheTime2) {
                            bArr[i11] = (byte) (timeItem.getHour() & 255);
                            bArr[i11 + 1] = (byte) (timeItem.getMin() & 255);
                            i11 += 2;
                        }
                    }
                    c9.j((byte) 51, bArr);
                    break;
                } else {
                    x5.b.I0().F0((byte) 51);
                    break;
                }
                break;
            case 15:
            case 25:
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
            case Const.ANDROID_VERSION_28 /* 28 */:
                break;
            default:
                int i12 = ScreenLightActivity.H;
                ScreenLightActivity screenLightActivity = (ScreenLightActivity) this.f19953b;
                screenLightActivity.S0().setOpen(((s1) screenLightActivity.f7247z.getValue()).f13296b.getItemOpen());
                g1 g1Var = (g1) screenLightActivity.I0();
                BrightScreenBean data2 = screenLightActivity.S0();
                g1Var.getClass();
                kotlin.jvm.internal.e.f(data2, "data");
                g1Var.f7432b = data2;
                ((XXBaseActivity) ((y) g1Var.f7255a)).V();
                if (y5.d.f20005b) {
                    if (r5.b.k().f18054c) {
                        x5.c b3 = x5.c.b();
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getBrightWCmdJL " + data2);
                        byte isOpen = data2.isOpen();
                        int startHour = data2.getStartHour();
                        char[] cArr2 = y5.b.f20001a;
                        b3.g((byte) -29, new byte[]{2, 12, 0, isOpen, (byte) (startHour & 255), (byte) (data2.getStartMin() & 255), (byte) (data2.getEndHour() & 255), (byte) (data2.getEndMin() & 255)}, new boolean[0]);
                        break;
                    } else {
                        x5.b.I0().F0((byte) -29);
                        break;
                    }
                } else if (r5.b.k().f18054c) {
                    x5.d c10 = x5.d.c();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getBrightCmd " + data2);
                    byte isOpen2 = data2.isOpen();
                    int startHour2 = data2.getStartHour();
                    char[] cArr3 = y5.b.f20001a;
                    c10.j((byte) 41, new byte[]{isOpen2, (byte) (startHour2 & 255), (byte) (data2.getStartMin() & 255), (byte) (data2.getEndHour() & 255), (byte) (data2.getEndMin() & 255)});
                    break;
                } else {
                    x5.b.I0().F0((byte) 41);
                    break;
                }
        }
    }

    public void a(int i3) {
    }

    public void b(int i3) {
    }

    public int c(int i3) {
        WorkDatabase workDatabase;
        int i10;
        synchronized (f.class) {
            try {
                workDatabase = (WorkDatabase) this.f19953b;
                workDatabase.c();
                Long e = workDatabase.j().e("next_job_scheduler_id");
                int intValue = e != null ? e.intValue() : 0;
                workDatabase.j().h(new x2.c("next_job_scheduler_id", intValue == Integer.MAX_VALUE ? 0 : intValue + 1));
                workDatabase.h();
                workDatabase.f();
                i10 = (intValue >= 0 && intValue <= i3) ? intValue : 0;
                ((WorkDatabase) this.f19953b).j().h(new x2.c("next_job_scheduler_id", 1));
            } catch (Throwable th2) {
                workDatabase.f();
                throw th2;
            } finally {
            }
        }
        return i10;
    }

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
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.f.h(int, int, int):void");
    }

    @Override // t6.b
    public void onCancel() {
        switch (this.f19952a) {
            case 10:
                u1 u1Var = (u1) this.f19953b;
                u1Var.getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== cancel");
                u1Var.h();
                break;
        }
    }

    @Override // t6.b
    public void s() {
        BluetoothDevice bluetoothDevice;
        switch (this.f19952a) {
            case 10:
                ((u1) this.f19953b).getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== pair");
                r5.b k10 = r5.b.k();
                if (k10.e != null && (bluetoothDevice = k10.f18057g) != null) {
                    bluetoothDevice.createBond();
                    break;
                }
                break;
            case 14:
                DeviceScanActivity deviceScanActivity = (DeviceScanActivity) this.f19953b;
                deviceScanActivity.getClass();
                t.b(deviceScanActivity);
                break;
            case 22:
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                MessagePushActivity messagePushActivity = (MessagePushActivity) this.f19953b;
                intent.setData(Uri.fromParts("package", messagePushActivity.getPackageName(), null));
                messagePushActivity.startActivity(intent);
                break;
            case 23:
                int i3 = MoreActivity.H;
                t0 t0Var = (t0) ((MoreActivity) this.f19953b).I0();
                t0Var.f7484c = 0;
                ((XXBaseActivity) ((f7.r) t0Var.f7255a)).V();
                com.google.android.gms.internal.mlkit_vision_common.p.U((s0) t0Var.f7483b.getValue());
                if (!y5.d.f20005b) {
                    com.google.android.gms.internal.mlkit_vision_common.p.b(0);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_common.p.y(0);
                    break;
                }
            default:
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                RingMessagePushActivity ringMessagePushActivity = (RingMessagePushActivity) this.f19953b;
                intent2.setData(Uri.fromParts("package", ringMessagePushActivity.getPackageName(), null));
                ringMessagePushActivity.startActivity(intent2);
                break;
        }
    }

    @Override // a7.e
    public void u0() {
        switch (this.f19952a) {
            case 11:
                ((BoWatcherActivity) this.f19953b).onBackPressed();
                break;
            case 12:
                ((BreatheSettingActivity) this.f19953b).onBackPressed();
                break;
            case 15:
                ((DialListActivity) this.f19953b).onBackPressed();
                break;
            case 25:
                ((QrCodeManagerActivity) this.f19953b).onBackPressed();
                break;
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                ((ScanQrCodeActivity) this.f19953b).onBackPressed();
                break;
            case Const.ANDROID_VERSION_28 /* 28 */:
                ((ScheduleActivity) this.f19953b).onBackPressed();
                break;
            default:
                ((ScreenLightActivity) this.f19953b).onBackPressed();
                break;
        }
    }

    @Override // t6.a
    public void v(String data) {
        int i3 = this.f19952a;
        kotlin.jvm.internal.e.f(data, "data");
        switch (i3) {
            case 16:
                int i10 = DrinkActivity.I;
                DrinkActivity drinkActivity = (DrinkActivity) this.f19953b;
                drinkActivity.S0().setRemindDuration(Integer.parseInt(data));
                drinkActivity.R0();
                break;
            case 17:
            default:
                int i11 = LongSitActivity.I;
                LongSitActivity longSitActivity = (LongSitActivity) this.f19953b;
                longSitActivity.S0().setRemindDuration(Integer.parseInt(data));
                longSitActivity.R0();
                break;
            case 18:
                int i12 = HrWatcherActivity.I;
                HrWatcherActivity hrWatcherActivity = (HrWatcherActivity) this.f19953b;
                hrWatcherActivity.S0().setTestDuration(Integer.parseInt(data));
                hrWatcherActivity.R0();
                break;
            case 19:
                int i13 = HrWatcherJlActivity.I;
                HrWatcherJlActivity hrWatcherJlActivity = (HrWatcherJlActivity) this.f19953b;
                hrWatcherJlActivity.S0().setRemindDuration(Integer.parseInt(data));
                hrWatcherJlActivity.R0();
                break;
        }
    }

    @Override // t6.d
    public void y() {
        switch (this.f19952a) {
            case 13:
                ((BtWatcherActivity) this.f19953b).F = false;
                break;
            case 17:
                ((DrinkJLActivity) this.f19953b).G = false;
                break;
            case 21:
                ((LongSitJLActivity) this.f19953b).E = false;
                break;
            default:
                ((NoDisturbActivity) this.f19953b).E = false;
                break;
        }
    }

    public /* synthetic */ f(Object obj, int i3) {
        this.f19952a = i3;
        this.f19953b = obj;
    }

    public f(Context context) {
        this.f19952a = 7;
        this.f19953b = new b4.d(context);
    }

    public f(CameraCaptureSession cameraCaptureSession, Handler handler) {
        this.f19952a = 4;
        if (Build.VERSION.SDK_INT >= 28) {
            this.f19953b = new androidx.camera.camera2.internal.compat.j(cameraCaptureSession, null);
        } else {
            this.f19953b = new ef.i(cameraCaptureSession, new androidx.camera.camera2.internal.compat.k(handler));
        }
    }

    public f(CameraDevice cameraDevice, Handler handler) {
        this.f19952a = 5;
        if (Build.VERSION.SDK_INT >= 28) {
            cameraDevice.getClass();
            this.f19953b = new androidx.camera.camera2.internal.compat.r(cameraDevice, null);
        } else {
            this.f19953b = new androidx.camera.camera2.internal.compat.q(cameraDevice, new androidx.camera.camera2.internal.compat.k(handler));
        }
    }
}
