package com.example.blesdk.ble.scan;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.ParcelUuid;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import k9.g;
import t5.b;
import t5.e;
import t5.f;
import t5.k;

/* loaded from: classes.dex */
public class PendingIntentReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        PendingIntent pendingIntent;
        e e;
        if (context == null || intent == null || (pendingIntent = (PendingIntent) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT")) == null) {
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS");
        android.bluetooth.le.ScanSettings scanSettings = (android.bluetooth.le.ScanSettings) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS");
        if (parcelableArrayListExtra == null || scanSettings == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_USE_HARDWARE_BATCHING", true);
        boolean booleanExtra2 = intent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_USE_HARDWARE_FILTERING", true);
        boolean booleanExtra3 = intent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_USE_HARDWARE_CALLBACK_TYPES", true);
        long longExtra = intent.getLongExtra("no.nordicsemi.android.support.v18.EXTRA_MATCH_LOST_TIMEOUT", 10000L);
        long longExtra2 = intent.getLongExtra("no.nordicsemi.android.support.v18.EXTRA_MATCH_LOST_INTERVAL", 10000L);
        int intExtra = intent.getIntExtra("no.nordicsemi.android.support.v18.EXTRA_MATCH_MODE", 1);
        int intExtra2 = intent.getIntExtra("no.nordicsemi.android.support.v18.EXTRA_NUM_OF_MATCHES", 3);
        b a3 = b.a();
        f fVar = (f) a3;
        ArrayList arrayList = new ArrayList();
        int size = parcelableArrayListExtra.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = parcelableArrayListExtra.get(i3);
            int i10 = i3 + 1;
            android.bluetooth.le.ScanFilter scanFilter = (android.bluetooth.le.ScanFilter) obj;
            ArrayList arrayList2 = parcelableArrayListExtra;
            g gVar = new g(1);
            String deviceAddress = scanFilter.getDeviceAddress();
            if (deviceAddress != null && !BluetoothAdapter.checkBluetoothAddress(deviceAddress)) {
                throw new IllegalArgumentException("invalid device address ".concat(deviceAddress));
            }
            gVar.f15550c = deviceAddress;
            gVar.f15549b = scanFilter.getDeviceName();
            ParcelUuid serviceUuid = scanFilter.getServiceUuid();
            int i11 = size;
            ParcelUuid serviceUuidMask = scanFilter.getServiceUuidMask();
            if (serviceUuidMask != null && serviceUuid == null) {
                throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
            }
            gVar.f15551d = serviceUuid;
            gVar.e = serviceUuidMask;
            gVar.b(scanFilter.getManufacturerId(), scanFilter.getManufacturerData(), scanFilter.getManufacturerDataMask());
            if (scanFilter.getServiceDataUuid() != null) {
                gVar.c(scanFilter.getServiceDataUuid(), scanFilter.getServiceData(), scanFilter.getServiceDataMask());
            }
            arrayList.add(new ScanFilter((String) gVar.f15549b, (String) gVar.f15550c, (ParcelUuid) gVar.f15551d, (ParcelUuid) gVar.e, (ParcelUuid) gVar.f15552f, (byte[]) gVar.f15553g, (byte[]) gVar.f15554h, gVar.f15548a, (byte[]) gVar.f15555i, (byte[]) gVar.f15556j));
            i3 = i10;
            parcelableArrayListExtra = arrayList2;
            size = i11;
        }
        k kVar = new k();
        kVar.f18560f = scanSettings.getLegacy();
        kVar.f18561g = scanSettings.getPhy();
        int callbackType = scanSettings.getCallbackType();
        if (callbackType != 1 && callbackType != 2 && callbackType != 4 && callbackType != 6) {
            throw new IllegalArgumentException(l0.j(callbackType, "invalid callback type - "));
        }
        kVar.f18557b = callbackType;
        kVar.c(scanSettings.getScanMode());
        long reportDelayMillis = scanSettings.getReportDelayMillis();
        if (reportDelayMillis < 0) {
            throw new IllegalArgumentException("reportDelay must be > 0");
        }
        kVar.f18558c = reportDelayMillis;
        kVar.f18563i = booleanExtra;
        kVar.f18562h = booleanExtra2;
        kVar.f18564j = booleanExtra3;
        if (longExtra <= 0 || longExtra2 <= 0) {
            throw new IllegalArgumentException("maxDeviceAgeMillis and taskIntervalMillis must be > 0");
        }
        kVar.f18565k = longExtra;
        kVar.f18566l = longExtra2;
        kVar.b(intExtra);
        if (intExtra2 < 1 || intExtra2 > 3) {
            throw new IllegalArgumentException(l0.j(intExtra2, "invalid numOfMatches "));
        }
        kVar.e = intExtra2;
        ScanSettings a10 = kVar.a();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isOffloadedScanBatchingSupported = defaultAdapter.isOffloadedScanBatchingSupported();
        boolean isOffloadedFilteringSupported = defaultAdapter.isOffloadedFilteringSupported();
        synchronized (a3) {
            try {
                try {
                    e = fVar.e(pendingIntent);
                    if (e == null) {
                        e eVar = new e(isOffloadedScanBatchingSupported, isOffloadedFilteringSupported, arrayList, a10, pendingIntent);
                        synchronized (fVar.f18544c) {
                            fVar.f18544c.put(pendingIntent, eVar);
                        }
                        e = eVar;
                    }
                } catch (IllegalStateException unused) {
                    return;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        e.f18542n.f18547b = context;
        ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT");
        if (parcelableArrayListExtra2 != null) {
            ArrayList arrayList3 = new ArrayList();
            int size2 = parcelableArrayListExtra2.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj2 = parcelableArrayListExtra2.get(i12);
                i12++;
                arrayList3.add(fVar.d((android.bluetooth.le.ScanResult) obj2));
            }
            if (a10.m() > 0) {
                e.b(arrayList3);
            } else if (!arrayList3.isEmpty()) {
                e.a(intent.getIntExtra("android.bluetooth.le.extra.CALLBACK_TYPE", 1), (ScanResult) arrayList3.get(0));
            }
        } else {
            int intExtra3 = intent.getIntExtra("android.bluetooth.le.extra.ERROR_CODE", 0);
            if (intExtra3 != 0) {
                e.f18532h.b(intExtra3);
            }
        }
        e.f18542n.f18547b = null;
    }
}
