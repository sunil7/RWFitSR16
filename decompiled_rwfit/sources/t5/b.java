package t5;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.os.Handler;
import com.example.blesdk.ble.scan.ScanSettings;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static f f18538a;

    public static synchronized b a() {
        synchronized (b.class) {
            f fVar = f18538a;
            if (fVar != null) {
                return fVar;
            }
            f fVar2 = new f();
            f18538a = fVar2;
            return fVar2;
        }
    }

    public abstract void b(List list, ScanSettings scanSettings, i iVar, Handler handler);

    public final void c(i iVar) {
        d dVar;
        BluetoothLeScanner bluetoothLeScanner;
        if (iVar == null) {
            throw new IllegalArgumentException("callback is null");
        }
        f fVar = (f) this;
        synchronized (fVar.f18543b) {
            dVar = (d) fVar.f18543b.remove(iVar);
        }
        if (dVar == null) {
            return;
        }
        dVar.e = true;
        dVar.f18533i.removeCallbacksAndMessages(null);
        synchronized (dVar.f18526a) {
            dVar.f18536l.clear();
            dVar.f18535k.clear();
            dVar.f18534j.clear();
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || (bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner()) == null) {
            return;
        }
        bluetoothLeScanner.stopScan(dVar.f18541n);
    }
}
