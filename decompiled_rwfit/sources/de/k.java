package de;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.recyclerview.widget.x;
import com.example.test.XXApplication;
import com.example.test.presenter.device.y0;
import com.google.android.gms.internal.mlkit_vision_common.i0;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class k implements re.a {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f12365a;

    /* renamed from: b, reason: collision with root package name */
    public long f12366b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12367c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f12368d;
    public final Object e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f12369f;

    /* renamed from: g, reason: collision with root package name */
    public volatile Object f12370g;

    public k(XXApplication xXApplication, k6.b bVar) {
        this.f12366b = 0L;
        this.e = new HashMap();
        this.f12365a = new Handler(Looper.getMainLooper(), new j(this, 0));
        y0 y0Var = new y0(this, 2);
        this.f12369f = y0Var;
        this.f12367c = xXApplication;
        this.f12368d = bVar;
        ArrayList arrayList = (ArrayList) bVar.e.f36a;
        if (arrayList.contains(y0Var)) {
            return;
        }
        arrayList.add(y0Var);
    }

    public static void b(k kVar, String str) {
        long d5 = kVar.d();
        ee.c.c("DeviceReConnectManager", "dealWithConnectFailed", "address : " + str + ", Left Time = " + d5);
        if (d5 > 2000) {
            ee.c.e("DeviceReConnectManager", "dealWithConnectFailed", "resume reconnect task.");
            Handler handler = kVar.f12365a;
            handler.removeMessages(37973);
            handler.sendEmptyMessage(37973);
            return;
        }
        ee.c.e("DeviceReConnectManager", "dealWithConnectFailed", "time not enough.");
        x c9 = i0.c(16402, str);
        if (((k6.b) kVar.f12368d).E) {
            ((k6.b) kVar.f12368d).e(c9);
        }
        kVar.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017f A[EDGE_INSN: B:39:0x017f->B:40:0x017f BREAK  A[LOOP:0: B:21:0x006e->B:38:0x006e], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(de.k r19, android.bluetooth.BluetoothDevice r20, byte[] r21) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: de.k.c(de.k, android.bluetooth.BluetoothDevice, byte[]):boolean");
    }

    @Override // re.a
    public void B(FileDownloadModel fileDownloadModel) {
        ((o4.e) this.f12367c).B(fileDownloadModel);
        if (i(fileDownloadModel.h())) {
            return;
        }
        ((n6.a) this.f12368d).B(fileDownloadModel);
    }

    @Override // re.a
    public void F(int i3) {
        ((o4.e) this.f12367c).remove(i3);
        if (i(i3)) {
            this.f12365a.removeMessages(i3);
            if (((AtomicInteger) this.f12369f).get() == i3) {
                this.f12370g = Thread.currentThread();
                this.f12365a.sendEmptyMessage(0);
                LockSupport.park();
                ((n6.a) this.f12368d).remove(i3);
            }
        } else {
            ((n6.a) this.f12368d).remove(i3);
        }
        ((ArrayList) this.e).remove(Integer.valueOf(i3));
    }

    @Override // re.a
    public void G(int i3, int i10, long j4) {
        ((o4.e) this.f12367c).G(i3, i10, j4);
        if (i(i3)) {
            return;
        }
        ((n6.a) this.f12368d).G(i3, i10, j4);
    }

    @Override // re.a
    public void H(int i3, long j4) {
        ((o4.e) this.f12367c).getClass();
        if (i(i3)) {
            return;
        }
        ((n6.a) this.f12368d).H(i3, j4);
    }

    @Override // re.a
    public void I(int i3, int i10, long j4, long j10, String str) {
        ((o4.e) this.f12367c).getClass();
        if (i(i3)) {
            return;
        }
        ((n6.a) this.f12368d).I(i3, i10, j4, j10, str);
    }

    @Override // re.a
    public ArrayList J(int i3) {
        return ((o4.e) this.f12367c).J(i3);
    }

    @Override // re.a
    public FileDownloadModel L(int i3) {
        return ((o4.e) this.f12367c).L(i3);
    }

    @Override // re.a
    public void N(int i3, int i10) {
        ((o4.e) this.f12367c).getClass();
        if (i(i3)) {
            return;
        }
        ((n6.a) this.f12368d).N(i3, i10);
    }

    @Override // re.a
    public void O(int i3, long j4) {
        ((o4.e) this.f12367c).getClass();
        if (i(i3)) {
            f(i3);
        }
        ((n6.a) this.f12368d).O(i3, j4);
        ((ArrayList) this.e).remove(Integer.valueOf(i3));
    }

    public void a(BluetoothDevice bluetoothDevice) {
        ee.c.c("DeviceReConnectManager", "connectBtDevice", ((ud.d) this.f12370g) + ", device : " + bluetoothDevice);
        if (((ud.d) this.f12370g) == null || ((ud.d) this.f12370g).f19064d == 2) {
            return;
        }
        ((ud.d) this.f12370g).f19064d = 2;
        long d5 = d();
        ee.c.e("DeviceReConnectManager", "connectBtDevice", "left time = " + d5);
        if (d5 <= 2000) {
            this.f12365a.removeMessages(37974);
            this.f12365a.sendEmptyMessageDelayed(37974, 31000L);
            ee.c.e("DeviceReConnectManager", "connectBtDevice", "reset time >>> ");
        }
        this.f12365a.removeMessages(37975);
        this.f12365a.sendEmptyMessageDelayed(37975, 30000L);
        k6.b bVar = (k6.b) this.f12368d;
        if (bVar.O.f14369b.a(bluetoothDevice)) {
            return;
        }
        bVar.K(bluetoothDevice, 2);
    }

    @Override // re.a
    public void clear() {
        ((o4.e) this.f12367c).clear();
        ((n6.a) this.f12368d).clear();
    }

    public long d() {
        long timeInMillis = 65000 - (Calendar.getInstance().getTimeInMillis() - this.f12366b);
        if (timeInMillis < 0) {
            return 0L;
        }
        return timeInMillis;
    }

    public ud.d e() {
        if (((ud.d) this.f12370g) == null) {
            return null;
        }
        ud.d dVar = (ud.d) this.f12370g;
        ud.d dVar2 = new ud.d(dVar.f19062b, dVar.f19061a, dVar.f19063c);
        dVar2.f19064d = dVar.f19064d;
        return dVar2;
    }

    public void f(int i3) {
        this.f12365a.removeMessages(i3);
        if (((AtomicInteger) this.f12369f).get() != i3) {
            p(i3);
            return;
        }
        this.f12370g = Thread.currentThread();
        this.f12365a.sendEmptyMessage(0);
        LockSupport.park();
    }

    public void g() {
        ee.c.c("DeviceReConnectManager", "stopScan", "---->");
        k6.b bVar = (k6.b) this.f12368d;
        bVar.T();
        bVar.U();
    }

    public boolean h() {
        return this.f12365a.hasMessages(37974);
    }

    public boolean i(int i3) {
        return !((ArrayList) this.e).contains(Integer.valueOf(i3));
    }

    public boolean j() {
        return e() != null;
    }

    public void k(ud.d dVar) {
        if (((ud.d) this.f12370g) != dVar) {
            this.f12370g = dVar;
            ((HashMap) this.e).clear();
            ee.c.c("DeviceReConnectManager", "setReConnectDevMsg", "" + dVar);
        }
    }

    @Override // re.a
    public void l(int i3) {
        ((o4.e) this.f12367c).getClass();
        if (i(i3)) {
            return;
        }
        ((n6.a) this.f12368d).getClass();
    }

    @Override // re.a
    public void m(int i3, Exception exc, long j4) {
        ((o4.e) this.f12367c).getClass();
        if (i(i3)) {
            f(i3);
        }
        ((n6.a) this.f12368d).m(i3, exc, j4);
        ((ArrayList) this.e).remove(Integer.valueOf(i3));
    }

    public void n() {
        ee.c.e("DeviceReConnectManager", "stopReconnectTask", "isReconnecting : " + h() + ", isWaitingForUpdate : " + j());
        this.f12366b = 0L;
        k(null);
        g();
        this.f12365a.removeCallbacksAndMessages(null);
    }

    @Override // re.a
    public void o(int i3) {
        ((o4.e) this.f12367c).o(i3);
        if (i(i3)) {
            return;
        }
        ((n6.a) this.f12368d).o(i3);
    }

    public void p(int i3) {
        o4.e eVar = (o4.e) this.f12367c;
        FileDownloadModel L = eVar.L(i3);
        n6.a aVar = (n6.a) this.f12368d;
        aVar.B(L);
        ArrayList J = eVar.J(i3);
        aVar.o(i3);
        int size = J.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = J.get(i10);
            i10++;
            aVar.v((ve.a) obj);
        }
    }

    @Override // re.a
    public void r(int i3, Exception exc) {
        ((o4.e) this.f12367c).getClass();
        if (i(i3)) {
            return;
        }
        ((n6.a) this.f12368d).r(i3, exc);
    }

    @Override // re.a
    public boolean remove(int i3) {
        ((n6.a) this.f12368d).remove(i3);
        ((o4.e) this.f12367c).remove(i3);
        return true;
    }

    @Override // re.a
    public void s(int i3) {
        this.f12365a.sendEmptyMessageDelayed(i3, this.f12366b);
    }

    @Override // re.a
    public void v(ve.a aVar) {
        ((o4.e) this.f12367c).v(aVar);
        if (i(aVar.f19231a)) {
            return;
        }
        ((n6.a) this.f12368d).v(aVar);
    }

    @Override // re.a
    public void w(long j4, String str, String str2, int i3) {
        ((o4.e) this.f12367c).getClass();
        if (i(i3)) {
            return;
        }
        ((n6.a) this.f12368d).w(j4, str, str2, i3);
    }

    public k() {
        this.e = new ArrayList();
        this.f12369f = new AtomicInteger();
        this.f12367c = new o4.e(5);
        this.f12368d = new n6.a((byte) 0, 11);
        this.f12366b = ye.c.f20115a.f20117b;
        int i3 = ye.e.f20123a;
        HandlerThread handlerThread = new HandlerThread("FileDownloader-RemitHandoverToDB");
        handlerThread.start();
        this.f12365a = new Handler(handlerThread.getLooper(), new j(this, 6));
    }
}
