package com.example.test.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import com.example.database.table.User;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.sport.activity.SportDetailActivity;
import com.example.test.ui.sport.activity.SportDetailJLActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.NotImplementedError;

/* loaded from: classes.dex */
public final class SportService extends Service implements o5.a, e6.b {

    /* renamed from: a, reason: collision with root package name */
    public final eh.b f7644a = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportService$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(SportService.this);
        }
    });

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7645b = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportService$mBuilder$2
        {
            super(0);
        }

        @Override // oh.a
        public final y0.l invoke() {
            return new y0.l(SportService.this.getApplicationContext(), null);
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7646c = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportService$manager$2
        {
            super(0);
        }

        @Override // oh.a
        public final NotificationManager invoke() {
            Object systemService = SportService.this.getSystemService("notification");
            kotlin.jvm.internal.e.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public int f7647d;

    @Override // e6.b
    public final void W() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // e6.b
    public final void X(long j4, double d5, double d8, long j10, long j11) {
        b(d8, d5, false);
    }

    public final y0.l a() {
        return (y0.l) this.f7645b.getValue();
    }

    public final void b(double d5, double d8, boolean z5) {
        String string = getString(R$string.str_tab_sport_running_indoor);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        int i3 = this.f7647d;
        if (i3 == 2) {
            string = getString(R$string.str_tab_sport_biking);
            kotlin.jvm.internal.e.e(string, "getString(...)");
        } else if (i3 == 5) {
            string = getString(R$string.str_tab_sport_running_outdoor);
            kotlin.jvm.internal.e.e(string, "getString(...)");
        } else if (i3 == 7) {
            string = getString(R$string.str_tab_sport_walking);
            kotlin.jvm.internal.e.e(string, "getString(...)");
        } else if (i3 == 14) {
            string = getString(R$string.str_tab_sport_climing);
            kotlin.jvm.internal.e.e(string, "getString(...)");
        }
        StringBuilder sb2 = new StringBuilder();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d10 = kVar != null ? kVar.d() : null;
        if (d10 != null) {
            if (d10.getMeterUnit() == 0) {
                sb2.append(String.format(Locale.ENGLISH, "%.2f%s", Arrays.copyOf(new Object[]{Double.valueOf(d5 / 1000), getString(R$string.str_km)}, 2)));
            } else {
                sb2.append(String.format(Locale.ENGLISH, "%.2f%s", Arrays.copyOf(new Object[]{Float.valueOf(v1.b((float) d5)), getString(R$string.str_mile)}, 2)));
            }
        }
        sb2.append("  ");
        sb2.append(String.format(Locale.ENGLISH, "%.2f%s", Arrays.copyOf(new Object[]{Double.valueOf(d8), "KCAL"}, 2)));
        y0.l a3 = a();
        a3.getClass();
        a3.e = y0.l.b(string);
        y0.l a10 = a();
        a10.getClass();
        a10.f19882f = y0.l.b(sb2);
        if (z5) {
            return;
        }
        ((NotificationManager) this.f7646c.getValue()).notify(223, a().a());
    }

    @Override // e6.b
    public final void j(boolean z5) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        if (intent != null) {
            this.f7647d = intent.getIntExtra("SPORT_TYPE", 5);
        }
        b(0.0d, 0.0d, true);
        a().r.icon = R$mipmap.ic_launcher;
        a().r.when = System.currentTimeMillis();
        a().f19885i = 0;
        a().c(2, false);
        String l3 = com.google.android.gms.internal.mlkit_vision_barcode.l0.l(System.currentTimeMillis(), "channelId");
        ((NotificationManager) this.f7646c.getValue()).createNotificationChannel(new NotificationChannel(l3, getResources().getString(R$string.app_name), 4));
        a().f19892p = l3;
        Intent intent2 = y5.d.f20005b ? new Intent(this, (Class<?>) SportDetailJLActivity.class) : new Intent(this, (Class<?>) SportDetailActivity.class);
        a().f19883g = PendingIntent.getActivity(this, 0, intent2, 67108864);
        startForeground(223, a().a());
        ((com.example.baselibrary.utils.e) this.f7644a.getValue()).sendEmptyMessageDelayed(0, 1000L);
        return super.onStartCommand(intent2, i3, i10);
    }

    @Override // e6.b
    public final void q0(h6.b bVar) {
        stopSelf();
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        ((com.example.baselibrary.utils.e) this.f7644a.getValue()).sendEmptyMessageDelayed(0, 1000L);
    }

    @Override // e6.b
    public final void u(int i3) {
    }

    @Override // e6.b
    public final void y(List list) {
    }
}
