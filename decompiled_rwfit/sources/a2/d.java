package a2;

import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.t;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.p;
import androidx.lifecycle.a0;
import androidx.lifecycle.c0;
import androidx.recyclerview.widget.x;
import androidx.viewpager2.widget.ViewPager2;
import com.example.test.XXApplication;
import com.example.test.presenter.device.s;
import com.example.test.presenter.device.t0;
import com.example.test.presenter.device.z0;
import com.example.test.ui.device.activity.AlarmJLActivity;
import com.example.test.ui.device.activity.BoWatcherActivity;
import com.example.test.ui.device.activity.BtWatcherActivity;
import com.example.test.ui.device.activity.ContactJLActivity;
import com.example.test.ui.device.activity.CustomDialActivity;
import com.example.test.ui.device.activity.DeviceScanActivity;
import com.example.test.ui.device.activity.DialDetailActivity;
import com.example.test.ui.device.activity.DrinkActivity;
import com.example.test.ui.device.activity.DrinkJLActivity;
import com.example.test.ui.device.activity.HrWatcherActivity;
import com.example.test.ui.device.activity.HrWatcherJlActivity;
import com.example.test.ui.device.activity.LongSitActivity;
import com.example.test.ui.device.activity.LongSitJLActivity;
import com.example.test.ui.device.activity.MessagePushActivity;
import com.example.test.ui.device.activity.MoreActivity;
import com.example.test.ui.device.activity.NoDisturbActivity;
import com.example.test.ui.device.activity.OtaActivity;
import com.example.test.ui.device.activity.QrCodeDetailActivity;
import com.example.test.ui.device.activity.RingMessagePushActivity;
import com.example.test.ui.device.activity.ScanQrCodeActivity;
import com.example.test.ui.device.activity.ScanQrMlActivity;
import com.example.test.ui.main.model.PageViewModel;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.y9;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import f6.a1;
import f7.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import n.x0;

/* loaded from: classes.dex */
public class d implements h.i, c0, m1.o, rd.b, a7.e, t6.d, t6.a, t6.b {

    /* renamed from: c, reason: collision with root package name */
    public static d f21c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22a;

    /* renamed from: b, reason: collision with root package name */
    public Object f23b;

    public /* synthetic */ d() {
        this.f22a = 8;
    }

    public static d b() {
        if (f21c == null) {
            f21c = new d();
        }
        return f21c;
    }

    private final void c() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void j() {
    }

    private final void l() {
    }

    private final void m() {
    }

    private final void n() {
    }

    private final void p() {
    }

    private final void q() {
    }

    private final void r() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:80:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x042a  */
    /* JADX WARN: Type inference failed for: r14v2, types: [f7.d] */
    /* JADX WARN: Type inference failed for: r2v32, types: [f7.k] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r6v14, types: [f7.s] */
    /* JADX WARN: Type inference failed for: r6v8, types: [f7.o] */
    @Override // a7.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B() {
        /*
            Method dump skipped, instructions count: 1200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.d.B():void");
    }

    @Override // rd.b
    public void a(x xVar) {
        Log.e("qob", "queryMandatoryUpdate onError");
    }

    @Override // h.i
    public boolean d(h.k kVar, MenuItem menuItem) {
        switch (this.f22a) {
            case 1:
                p pVar = ((ActionMenuView) this.f23b).f666z;
                if (pVar == null) {
                    return false;
                }
                Iterator it = ((CopyOnWriteArrayList) ((Toolbar) ((t) pVar).f568b).G.f12630c).iterator();
                if (it.hasNext()) {
                    throw android.support.v4.media.session.e.d(it);
                }
                return false;
            default:
                ((Toolbar) this.f23b).getClass();
                return false;
        }
    }

    @Override // m1.o
    public boolean g(View view) {
        int currentItem = ((ViewPager2) view).getCurrentItem() - 1;
        ViewPager2 viewPager2 = (ViewPager2) ((v2.h) this.f23b).f19149d;
        if (viewPager2.r) {
            viewPager2.c(currentItem, true);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (r5 == 12) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        if (r5 == 12) goto L25;
     */
    @Override // t6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(int r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f23b
            com.example.test.ui.device.activity.BoWatcherActivity r0 = (com.example.test.ui.device.activity.BoWatcherActivity) r0
            boolean r1 = r0.F
            r2 = 1
            r3 = 0
            r4 = 12
            if (r1 == 0) goto L3d
            boolean r1 = android.text.format.DateFormat.is24HourFormat(r0)
            if (r1 == 0) goto L21
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setStartHour(r8)
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setStartMin(r9)
            goto L6d
        L21:
            com.example.blesdk.bean.function.DrinkReminderBean r1 = r0.S0()
            int r5 = r8 + 1
            if (r7 != r2) goto L2e
            if (r5 >= r4) goto L31
            int r3 = r8 + 13
            goto L32
        L2e:
            if (r5 != r4) goto L31
            goto L32
        L31:
            r3 = r5
        L32:
            r1.setStartHour(r3)
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setStartMin(r9)
            goto L6d
        L3d:
            boolean r1 = android.text.format.DateFormat.is24HourFormat(r0)
            if (r1 == 0) goto L52
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setEndHour(r8)
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setEndMin(r9)
            goto L6d
        L52:
            com.example.blesdk.bean.function.DrinkReminderBean r1 = r0.S0()
            int r5 = r8 + 1
            if (r7 != r2) goto L5f
            if (r5 >= r4) goto L62
            int r3 = r8 + 13
            goto L63
        L5f:
            if (r5 != r4) goto L62
            goto L63
        L62:
            r3 = r5
        L63:
            r1.setEndHour(r3)
            com.example.blesdk.bean.function.DrinkReminderBean r7 = r0.S0()
            r7.setEndMin(r9)
        L6d:
            r0.R0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.d.h(int, int, int):void");
    }

    @Override // androidx.lifecycle.c0
    public void i(Object obj) {
        String text$lambda$0;
        text$lambda$0 = PageViewModel.text$lambda$0((Integer) obj);
        ((a0) this.f23b).k(text$lambda$0);
    }

    @Override // h.i
    public void k(h.k kVar) {
        switch (this.f22a) {
            case 1:
                d dVar = ((ActionMenuView) this.f23b).f661u;
                if (dVar != null) {
                    dVar.k(kVar);
                    return;
                }
                return;
            default:
                Toolbar toolbar = (Toolbar) this.f23b;
                androidx.appcompat.widget.l lVar = toolbar.f836a.f660t;
                if (lVar == null || !lVar.f()) {
                    Iterator it = ((CopyOnWriteArrayList) toolbar.G.f12630c).iterator();
                    if (it.hasNext()) {
                        throw android.support.v4.media.session.e.d(it);
                    }
                    return;
                }
                return;
        }
    }

    public void o(j jVar) {
        jVar.getClass();
        boolean z5 = jVar == j.f48c;
        f fVar = (f) this.f23b;
        if (z5) {
            fVar.f59i.set(true);
            return;
        }
        if (fVar.f59i.get()) {
            return;
        }
        m mVar = fVar.f55d;
        mVar.f63a = 0;
        ArrayList arrayList = mVar.f64b;
        arrayList.clear();
        List list = jVar.f49a;
        arrayList.add(list);
        mVar.f65c = jVar.f50b;
        mVar.f66d = 0;
        int size = list.size();
        mVar.e = size;
        mVar.f67f = size;
        mVar.f68g = list.size();
        mVar.f69h = 0;
        mVar.f70i = 0;
        int size2 = mVar.size();
        if (size2 != 0) {
            ArrayList arrayList2 = fVar.f60j;
            for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
                a aVar = (a) ((WeakReference) arrayList2.get(size3)).get();
                if (aVar != null) {
                    aVar.f8a.f14a.onInserted(0, size2);
                }
            }
        } else {
            fVar.getClass();
        }
        if (mVar.f63a <= 0) {
            int i3 = mVar.f65c;
        }
        if (fVar.e == -1) {
            fVar.e = list.size() / 2;
        }
    }

    @Override // t6.b
    public void onCancel() {
        int i3 = this.f22a;
    }

    @Override // rd.b
    public void onSuccess(Object obj) {
        be.j jVar = (be.j) obj;
        Integer valueOf = jVar != null ? Integer.valueOf(jVar.e) : null;
        String str = jVar != null ? jVar.f3236d : null;
        OtaActivity otaActivity = (OtaActivity) ((u) ((z0) this.f23b).f7255a);
        otaActivity.getClass();
        Log.e("qob", "onCheckOTAAuthSucess");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null ? kotlin.jvm.internal.e.a(kVar.q(), Boolean.TRUE) : false) {
            otaActivity.onClick(((a1) otaActivity.f7247z.getValue()).f12681b);
        }
        Log.e("qob", "queryMandatoryUpdate onSuccess " + valueOf + " " + str);
    }

    @Override // t6.b
    public void s() {
        switch (this.f22a) {
            case 13:
                int i3 = CustomDialActivity.U;
                CustomDialActivity customDialActivity = (CustomDialActivity) this.f23b;
                customDialActivity.T0().setColor("#000000");
                customDialActivity.T0().setTimeUpType(1);
                customDialActivity.T0().setTimeDownType(8);
                customDialActivity.T0().setTimePosition(0);
                customDialActivity.Y0();
                customDialActivity.O = "";
                eh.b bVar = customDialActivity.f7247z;
                ((f6.t) bVar.getValue()).f13326m.setCanPress(false);
                customDialActivity.P = 0.0f;
                customDialActivity.c1();
                ((f6.t) bVar.getValue()).f13318d.setProgress(100);
                ((s) customDialActivity.I0()).A(customDialActivity.O, true, customDialActivity.P, customDialActivity.T0());
                break;
            case 14:
                DeviceScanActivity deviceScanActivity = (DeviceScanActivity) this.f23b;
                deviceScanActivity.getClass();
                v2.h hVar = new v2.h(deviceScanActivity);
                hVar.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                hVar.p(new b9.a(4));
                break;
            case 22:
                y9.a((MessagePushActivity) this.f23b);
                break;
            case 23:
                MoreActivity moreActivity = (MoreActivity) this.f23b;
                moreActivity.E = moreActivity.F;
                ((t0) moreActivity.I0()).l();
                break;
            case 26:
                y9.a((RingMessagePushActivity) this.f23b);
                break;
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                ScanQrCodeActivity scanQrCodeActivity = (ScanQrCodeActivity) this.f23b;
                scanQrCodeActivity.getClass();
                com.example.test.utils.t.b(scanQrCodeActivity);
                break;
            default:
                com.example.test.utils.t.b(((ScanQrMlActivity) this.f23b).getApplicationContext());
                break;
        }
    }

    public void t() {
        this.f23b = new com.example.test.service.a();
        XXApplication xXApplication = XXApplication.f7400h;
        ((TelephonyManager) j1.a().getSystemService("phone")).listen((com.example.test.service.a) this.f23b, 32);
    }

    @Override // a7.e
    public void u0() {
        switch (this.f22a) {
            case 9:
                ((AlarmJLActivity) this.f23b).onBackPressed();
                break;
            case 10:
            case 11:
            case 13:
            case 14:
            case 22:
            case 23:
            default:
                ((QrCodeDetailActivity) this.f23b).onBackPressed();
                break;
            case 12:
                ((ContactJLActivity) this.f23b).onBackPressed();
                break;
            case 15:
                ((DialDetailActivity) this.f23b).onBackPressed();
                break;
            case 16:
                ((DrinkActivity) this.f23b).onBackPressed();
                break;
            case 17:
                ((DrinkJLActivity) this.f23b).onBackPressed();
                break;
            case 18:
                ((HrWatcherActivity) this.f23b).onBackPressed();
                break;
            case 19:
                ((HrWatcherJlActivity) this.f23b).onBackPressed();
                break;
            case 20:
                ((LongSitActivity) this.f23b).onBackPressed();
                break;
            case 21:
                ((LongSitJLActivity) this.f23b).onBackPressed();
                break;
            case 24:
                ((NoDisturbActivity) this.f23b).onBackPressed();
                break;
        }
    }

    @Override // t6.a
    public void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        int i3 = BtWatcherActivity.I;
        BtWatcherActivity btWatcherActivity = (BtWatcherActivity) this.f23b;
        btWatcherActivity.S0().setRemindDuration(Integer.parseInt(data));
        btWatcherActivity.R0();
    }

    @Override // t6.d
    public void y() {
        ((BoWatcherActivity) this.f23b).F = false;
    }

    public /* synthetic */ d(Object obj, int i3) {
        this.f22a = i3;
        this.f23b = obj;
    }

    public d(a0 a0Var, x0 x0Var) {
        this.f22a = 5;
        this.f23b = a0Var;
    }
}
