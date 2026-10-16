package t5;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.example.blesdk.ble.scan.ScanResult;
import com.example.blesdk.ble.scan.ScanSettings;
import com.example.blesdk.ble.scan.ScannerService;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: a, reason: collision with root package name */
    public final PendingIntent f18546a;

    /* renamed from: b, reason: collision with root package name */
    public Context f18547b;

    /* renamed from: c, reason: collision with root package name */
    public final Service f18548c;

    /* renamed from: d, reason: collision with root package name */
    public long f18549d;
    public final long e;

    public h(PendingIntent pendingIntent, ScanSettings scanSettings) {
        this.f18546a = pendingIntent;
        this.e = scanSettings.m();
    }

    @Override // t5.i
    public final void a(ArrayList arrayList) {
        Context context = this.f18547b;
        if (context == null) {
            context = this.f18548c;
        }
        if (context == null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f18549d > (elapsedRealtime - this.e) + 5) {
            return;
        }
        this.f18549d = elapsedRealtime;
        try {
            Intent intent = new Intent();
            intent.putExtra("android.bluetooth.le.extra.CALLBACK_TYPE", 1);
            intent.putParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT", new ArrayList<>(arrayList));
            intent.setExtrasClassLoader(ScanResult.class.getClassLoader());
            this.f18546a.send(context, 0, intent);
        } catch (PendingIntent.CanceledException unused) {
        }
    }

    @Override // t5.i
    public final void b(int i3) {
        Context context = this.f18547b;
        if (context == null) {
            context = this.f18548c;
        }
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("android.bluetooth.le.extra.ERROR_CODE", i3);
            this.f18546a.send(context, 0, intent);
        } catch (PendingIntent.CanceledException unused) {
        }
    }

    @Override // t5.i
    public final void c(int i3, ScanResult scanResult) {
        Context context = this.f18547b;
        if (context == null) {
            context = this.f18548c;
        }
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("android.bluetooth.le.extra.CALLBACK_TYPE", i3);
            intent.putParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT", new ArrayList<>(Collections.singletonList(scanResult)));
            this.f18546a.send(context, 0, intent);
        } catch (PendingIntent.CanceledException unused) {
        }
    }

    public h(PendingIntent pendingIntent, ScanSettings scanSettings, ScannerService scannerService) {
        this.f18546a = pendingIntent;
        this.e = scanSettings.m();
        this.f18548c = scannerService;
    }
}
