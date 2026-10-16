package n5;

import android.app.Notification;
import android.bluetooth.BluetoothDevice;
import android.os.SystemClock;
import android.view.View;
import androidx.camera.core.impl.q0;
import com.example.blesdk.ble.scan.ScanResult;
import com.google.android.gms.internal.mlkit_vision_barcode.ub;
import com.google.android.gms.internal.mlkit_vision_common.i0;
import com.jieli.jl_bt_ota.impl.RcspAuth;
import ee.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k6.b;
import kotlin.jvm.internal.e;
import pe.o;
import t.f1;
import t.s0;
import t.w0;
import t.z0;
import t5.d;
import t5.f;
import u0.z;
import y0.r;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16377a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16378b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16379c;

    public /* synthetic */ a(int i3, Object obj, Object obj2) {
        this.f16377a = i3;
        this.f16378b = obj;
        this.f16379c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        Object obj = this.f16379c;
        Object obj2 = this.f16378b;
        switch (this.f16377a) {
            case 0:
                r managerCompat = (r) obj2;
                e.f(managerCompat, "$managerCompat");
                Notification notification = (Notification) obj;
                e.f(notification, "$notification");
                managerCompat.f19913a.deleteNotificationChannel(notification.getChannelId());
                break;
            case 1:
                b bVar = (b) obj2;
                bVar.getClass();
                char[] cArr = ee.a.f12594a;
                BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
                if (bluetoothDevice != null && ub.a(bVar.f17901f)) {
                    try {
                        Object invoke = bluetoothDevice.getClass().getMethod("removeBond", null).invoke(bluetoothDevice, null);
                        if (invoke instanceof Boolean) {
                            z5 = ((Boolean) invoke).booleanValue();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        c.b(5, "BluetoothUtil", "Invoke removeBond : " + e.getMessage());
                    }
                }
                c.e(bVar.f17897a, "startUpgradeReConnect", r5.a.d("removeBond >>> ", z5));
                break;
            case 2:
                ((rd.b) obj2).a(i0.c(20486, "readBlockData :: failed. " + ((IOException) obj).getMessage()));
                break;
            case 3:
                ((RcspAuth) obj2).lambda$onAuthSuccess$2((BluetoothDevice) obj);
                break;
            case 4:
                ((t.c) obj2).lambda$setOnImageAvailableListener$0((q0) obj);
                break;
            case 5:
                ((z0) obj2).a();
                z0 z0Var = (z0) obj;
                if (z0Var != null) {
                    z0Var.a();
                    break;
                }
                break;
            case 6:
                ((s0) obj2).lambda$enqueueImageProxy$1((q0) obj);
                break;
            case 7:
                ((w0) obj2).b((f1) obj);
                break;
            case 8:
                ((t5.a) ((o) obj2).f17580b).f18532h.c(4, (ScanResult) obj);
                break;
            case 9:
                t5.c cVar = (t5.c) obj2;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j4 = cVar.f18539a;
                d dVar = cVar.f18540b;
                if (j4 <= (elapsedRealtime - dVar.f18531g.m()) + 5) {
                    cVar.f18539a = elapsedRealtime;
                    f fVar = (f) t5.b.a();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((List) obj).iterator();
                    while (it.hasNext()) {
                        arrayList.add(fVar.d((android.bluetooth.le.ScanResult) it.next()));
                    }
                    dVar.b(arrayList);
                    break;
                }
                break;
            default:
                z zVar = (z) obj2;
                View[] viewArr = (View[]) obj;
                if (zVar.f18825p != -1) {
                    for (View view : viewArr) {
                        view.setTag(zVar.f18825p, Long.valueOf(System.nanoTime()));
                    }
                }
                if (zVar.f18826q != -1) {
                    for (View view2 : viewArr) {
                        view2.setTag(zVar.f18826q, null);
                    }
                    break;
                }
                break;
        }
    }
}
