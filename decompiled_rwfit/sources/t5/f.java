package t5;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.os.Handler;
import com.example.blesdk.ble.scan.ScanFilter;
import com.example.blesdk.ble.scan.ScanResult;
import com.example.blesdk.ble.scan.ScanSettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends b {

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f18543b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f18544c = new HashMap();

    @Override // t5.b
    public final void b(List list, ScanSettings scanSettings, i iVar, Handler handler) {
        d dVar;
        ArrayList arrayList;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner == null) {
            throw new IllegalStateException("BT le scanner not available");
        }
        boolean isOffloadedScanBatchingSupported = defaultAdapter.isOffloadedScanBatchingSupported();
        boolean isOffloadedFilteringSupported = defaultAdapter.isOffloadedFilteringSupported();
        synchronized (this.f18543b) {
            if (this.f18543b.containsKey(iVar)) {
                throw new IllegalArgumentException("scanner already started with given callback");
            }
            dVar = new d(isOffloadedScanBatchingSupported, isOffloadedFilteringSupported, list, scanSettings, iVar, handler);
            this.f18543b.put(iVar, dVar);
        }
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (defaultAdapter.isOffloadedScanBatchingSupported() && scanSettings.o()) {
            builder.setReportDelay(scanSettings.m());
        }
        if (scanSettings.p()) {
            builder.setCallbackType(scanSettings.b()).setMatchMode(scanSettings.j()).setNumOfMatches(scanSettings.k());
        }
        builder.setScanMode(scanSettings.n()).setLegacy(scanSettings.d()).setPhy(scanSettings.l());
        android.bluetooth.le.ScanSettings build = builder.build();
        if (!list.isEmpty() && isOffloadedFilteringSupported && scanSettings.q()) {
            arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ScanFilter scanFilter = (ScanFilter) it.next();
                ScanFilter.Builder builder2 = new ScanFilter.Builder();
                builder2.setServiceUuid(scanFilter.m(), scanFilter.n()).setManufacturerData(scanFilter.i(), scanFilter.d(), scanFilter.h());
                if (scanFilter.a() != null) {
                    builder2.setDeviceAddress(scanFilter.a());
                }
                if (scanFilter.b() != null) {
                    builder2.setDeviceName(scanFilter.b());
                }
                if (scanFilter.l() != null) {
                    builder2.setServiceData(scanFilter.l(), scanFilter.j(), scanFilter.k());
                }
                arrayList.add(builder2.build());
            }
        } else {
            arrayList = null;
        }
        bluetoothLeScanner.startScan(arrayList, build, dVar.f18541n);
    }

    public final ScanResult d(android.bluetooth.le.ScanResult scanResult) {
        return new ScanResult(scanResult.getDevice(), (scanResult.getDataStatus() << 5) | (scanResult.isLegacy() ? 16 : 0) | scanResult.isConnectable(), scanResult.getPrimaryPhy(), scanResult.getSecondaryPhy(), scanResult.getAdvertisingSid(), scanResult.getTxPower(), scanResult.getRssi(), scanResult.getPeriodicAdvertisingInterval(), j.a(scanResult.getScanRecord() != null ? scanResult.getScanRecord().getBytes() : null), scanResult.getTimestampNanos());
    }

    public final e e(PendingIntent pendingIntent) {
        synchronized (this.f18544c) {
            try {
                if (!this.f18544c.containsKey(pendingIntent)) {
                    return null;
                }
                e eVar = (e) this.f18544c.get(pendingIntent);
                if (eVar != null) {
                    return eVar;
                }
                throw new IllegalStateException("Scanning has been stopped");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
