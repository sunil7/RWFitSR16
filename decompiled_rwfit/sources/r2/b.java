package r2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.NetworkType;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.HashMap;
import o2.m;
import p2.l;
import x2.h;
import y2.j;

/* loaded from: classes.dex */
public final class b implements p2.a {

    /* renamed from: d, reason: collision with root package name */
    public static final String f18020d = m.i("CommandHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f18021a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f18022b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Object f18023c = new Object();

    public b(Context context) {
        this.f18021a = context;
    }

    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent c(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @Override // p2.a
    public final void a(String str, boolean z5) {
        synchronized (this.f18023c) {
            try {
                p2.a aVar = (p2.a) this.f18022b.remove(str);
                if (aVar != null) {
                    aVar.a(str, z5);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d(Intent intent, int i3, g gVar) {
        int i10 = 5;
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            m.g().d(f18020d, String.format("Handling constraints changed %s", intent), new Throwable[0]);
            d dVar = new d(this.f18021a, i3, gVar);
            ArrayList e = gVar.e.f17427c.n().e();
            String str = c.f18024a;
            int size = e.size();
            boolean z5 = false;
            boolean z6 = false;
            boolean z8 = false;
            boolean z10 = false;
            int i11 = 0;
            while (i11 < size) {
                Object obj = e.get(i11);
                i11++;
                o2.c cVar = ((h) obj).f19757j;
                z5 |= cVar.f16702d;
                z6 |= cVar.f16700b;
                z8 |= cVar.e;
                z10 |= cVar.f16699a != NetworkType.NOT_REQUIRED;
                if (z5 && z6 && z8 && z10) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.f3014a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            Context context = dVar.f18026a;
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z5).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z6).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z8).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z10);
            context.sendBroadcast(intent2);
            t2.c cVar2 = dVar.f18028c;
            cVar2.b(e);
            ArrayList arrayList = new ArrayList(e.size());
            long currentTimeMillis = System.currentTimeMillis();
            int size2 = e.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj2 = e.get(i12);
                i12++;
                h hVar = (h) obj2;
                String str3 = hVar.f19749a;
                if (currentTimeMillis >= hVar.a() && (!hVar.b() || cVar2.a(str3))) {
                    arrayList.add(hVar);
                }
            }
            int size3 = arrayList.size();
            int i13 = 0;
            while (i13 < size3) {
                Object obj3 = arrayList.get(i13);
                i13++;
                String str4 = ((h) obj3).f19749a;
                Intent b3 = b(context, str4);
                m.g().d(d.f18025d, l0.o("Creating a delay_met command for workSpec with id (", str4, ")"), new Throwable[0]);
                gVar.e(new androidx.activity.f(gVar, b3, dVar.f18027b, i10));
            }
            cVar2.c();
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            m.g().d(f18020d, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i3)), new Throwable[0]);
            gVar.e.c();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            m.g().f(f18020d, l0.o("Invalid request for ", action, ", requires KEY_WORKSPEC_ID."), new Throwable[0]);
            return;
        }
        if (!"ACTION_SCHEDULE_WORK".equals(action)) {
            if ("ACTION_DELAY_MET".equals(action)) {
                Bundle extras2 = intent.getExtras();
                synchronized (this.f18023c) {
                    try {
                        String string = extras2.getString("KEY_WORKSPEC_ID");
                        m g10 = m.g();
                        String str5 = f18020d;
                        g10.d(str5, "Handing delay met for " + string, new Throwable[0]);
                        if (this.f18022b.containsKey(string)) {
                            m.g().d(str5, "WorkSpec " + string + " is already being handled for ACTION_DELAY_MET", new Throwable[0]);
                        } else {
                            e eVar = new e(this.f18021a, i3, string, gVar);
                            this.f18022b.put(string, eVar);
                            eVar.d();
                        }
                    } finally {
                    }
                }
                return;
            }
            if (!"ACTION_STOP_WORK".equals(action)) {
                if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                    m.g().k(f18020d, String.format("Ignoring intent %s", intent), new Throwable[0]);
                    return;
                }
                Bundle extras3 = intent.getExtras();
                String string2 = extras3.getString("KEY_WORKSPEC_ID");
                boolean z11 = extras3.getBoolean("KEY_NEEDS_RESCHEDULE");
                m.g().d(f18020d, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i3)), new Throwable[0]);
                a(string2, z11);
                return;
            }
            String string3 = intent.getExtras().getString("KEY_WORKSPEC_ID");
            m.g().d(f18020d, l0.n("Handing stopWork work for ", string3), new Throwable[0]);
            l lVar = gVar.e;
            lVar.f17428d.p(new j(lVar, string3, false));
            String str6 = a.f18019a;
            n.l k10 = gVar.e.f17427c.k();
            x2.d j4 = k10.j(string3);
            if (j4 != null) {
                a.a(this.f18021a, j4.f19742b, string3);
                m.g().d(a.f18019a, l0.o("Removing SystemIdInfo for workSpecId (", string3, ")"), new Throwable[0]);
                k10.r(string3);
            }
            gVar.a(string3, false);
            return;
        }
        String string4 = intent.getExtras().getString("KEY_WORKSPEC_ID");
        String str7 = f18020d;
        m.g().d(str7, l0.n("Handling schedule work for ", string4), new Throwable[0]);
        WorkDatabase workDatabase = gVar.e.f17427c;
        workDatabase.c();
        try {
            h h4 = workDatabase.n().h(string4);
            if (h4 == null) {
                m.g().k(str7, "Skipping scheduling " + string4 + " because it's no longer in the DB", new Throwable[0]);
                return;
            }
            if (h4.f19750b.isFinished()) {
                m.g().k(str7, "Skipping scheduling " + string4 + "because it is finished.", new Throwable[0]);
                return;
            }
            long a3 = h4.a();
            boolean b10 = h4.b();
            Context context2 = this.f18021a;
            l lVar2 = gVar.e;
            if (b10) {
                m.g().d(str7, "Opportunistically setting an alarm for " + string4 + " at " + a3, new Throwable[0]);
                a.b(context2, lVar2, string4, a3);
                Intent intent3 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                intent3.setAction("ACTION_CONSTRAINTS_CHANGED");
                gVar.e(new androidx.activity.f(gVar, intent3, i3, i10));
            } else {
                m.g().d(str7, "Setting up Alarms for " + string4 + " at " + a3, new Throwable[0]);
                a.b(context2, lVar2, string4, a3);
            }
            workDatabase.h();
        } finally {
            workDatabase.f();
        }
    }
}
