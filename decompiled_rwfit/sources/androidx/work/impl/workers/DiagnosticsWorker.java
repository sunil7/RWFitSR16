package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.mb;
import com.google.android.gms.internal.mlkit_vision_common.g6;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import n.l;
import o2.k;
import o2.m;
import o4.c;
import o4.e;
import p0.f;
import x2.d;
import x2.h;

/* loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {

    /* renamed from: g, reason: collision with root package name */
    public static final String f3037g = m.i("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public static String h(e eVar, c cVar, l lVar, ArrayList arrayList) {
        StringBuilder sb2 = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            h hVar = (h) obj;
            d j4 = lVar.j(hVar.f19749a);
            Integer valueOf = j4 != null ? Integer.valueOf(j4.f19742b) : null;
            String str = hVar.f19749a;
            eVar.getClass();
            b2.l b3 = b2.l.b(1, "SELECT name FROM workname WHERE work_spec_id=?");
            if (str == null) {
                b3.bindNull(1);
            } else {
                b3.bindString(1, str);
            }
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) eVar.f16737a;
            workDatabase_Impl.b();
            Cursor g10 = workDatabase_Impl.g(b3);
            try {
                ArrayList arrayList2 = new ArrayList(g10.getCount());
                while (g10.moveToNext()) {
                    arrayList2.add(g10.getString(0));
                }
                g10.close();
                b3.c();
                ArrayList g11 = cVar.g(hVar.f19749a);
                String join = TextUtils.join(Const.STR_MART_COMMA, arrayList2);
                String join2 = TextUtils.join(Const.STR_MART_COMMA, g11);
                String str2 = hVar.f19749a;
                String str3 = hVar.f19751c;
                String name = hVar.f19750b.name();
                StringBuilder v6 = l0.v("\n", str2, "\t ", str3, "\t ");
                v6.append(valueOf);
                v6.append("\t ");
                v6.append(name);
                v6.append("\t ");
                v6.append(join);
                v6.append("\t ");
                v6.append(join2);
                v6.append("\t");
                sb2.append(v6.toString());
            } catch (Throwable th2) {
                g10.close();
                b3.c();
                throw th2;
            }
        }
        return sb2.toString();
    }

    @Override // androidx.work.Worker
    public final k g() {
        b2.l lVar;
        l lVar2;
        e eVar;
        c cVar;
        int i3;
        WorkDatabase workDatabase = p2.l.a(this.f2992a).f17427c;
        f n4 = workDatabase.n();
        e l3 = workDatabase.l();
        c o3 = workDatabase.o();
        l k10 = workDatabase.k();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L);
        n4.getClass();
        b2.l b3 = b2.l.b(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC");
        b3.bindLong(1, currentTimeMillis);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) n4.f17315a;
        workDatabase_Impl.b();
        Cursor g10 = workDatabase_Impl.g(b3);
        try {
            int a3 = mb.a(g10, "required_network_type");
            int a10 = mb.a(g10, "requires_charging");
            int a11 = mb.a(g10, "requires_device_idle");
            int a12 = mb.a(g10, "requires_battery_not_low");
            int a13 = mb.a(g10, "requires_storage_not_low");
            int a14 = mb.a(g10, "trigger_content_update_delay");
            int a15 = mb.a(g10, "trigger_max_content_delay");
            int a16 = mb.a(g10, "content_uri_triggers");
            int a17 = mb.a(g10, "id");
            int a18 = mb.a(g10, "state");
            int a19 = mb.a(g10, "worker_class_name");
            lVar = b3;
            try {
                int a20 = mb.a(g10, "input_merger_class_name");
                int a21 = mb.a(g10, "input");
                int a22 = mb.a(g10, "output");
                int a23 = mb.a(g10, "initial_delay");
                int a24 = mb.a(g10, "interval_duration");
                int a25 = mb.a(g10, "flex_duration");
                int a26 = mb.a(g10, "run_attempt_count");
                int a27 = mb.a(g10, "backoff_policy");
                int a28 = mb.a(g10, "backoff_delay_duration");
                int a29 = mb.a(g10, "period_start_time");
                int a30 = mb.a(g10, "minimum_retention_duration");
                int a31 = mb.a(g10, "schedule_requested_at");
                int a32 = mb.a(g10, "run_in_foreground");
                int a33 = mb.a(g10, "out_of_quota_policy");
                int i10 = a22;
                ArrayList arrayList = new ArrayList(g10.getCount());
                while (g10.moveToNext()) {
                    String string = g10.getString(a17);
                    int i11 = a17;
                    String string2 = g10.getString(a19);
                    int i12 = a19;
                    o2.c cVar2 = new o2.c();
                    int i13 = a3;
                    cVar2.f16699a = g6.c(g10.getInt(a3));
                    cVar2.f16700b = g10.getInt(a10) != 0;
                    cVar2.f16701c = g10.getInt(a11) != 0;
                    cVar2.f16702d = g10.getInt(a12) != 0;
                    cVar2.e = g10.getInt(a13) != 0;
                    int i14 = a10;
                    int i15 = a11;
                    cVar2.f16703f = g10.getLong(a14);
                    cVar2.f16704g = g10.getLong(a15);
                    cVar2.f16705h = g6.a(g10.getBlob(a16));
                    h hVar = new h(string, string2);
                    hVar.f19750b = g6.e(g10.getInt(a18));
                    hVar.f19752d = g10.getString(a20);
                    hVar.e = o2.f.a(g10.getBlob(a21));
                    int i16 = i10;
                    hVar.f19753f = o2.f.a(g10.getBlob(i16));
                    int i17 = a18;
                    int i18 = a23;
                    int i19 = a21;
                    hVar.f19754g = g10.getLong(i18);
                    int i20 = a20;
                    int i21 = a24;
                    hVar.f19755h = g10.getLong(i21);
                    int i22 = a25;
                    hVar.f19756i = g10.getLong(i22);
                    int i23 = a26;
                    hVar.f19758k = g10.getInt(i23);
                    int i24 = a27;
                    hVar.f19759l = g6.b(g10.getInt(i24));
                    int i25 = a28;
                    hVar.f19760m = g10.getLong(i25);
                    int i26 = a29;
                    hVar.f19761n = g10.getLong(i26);
                    int i27 = a30;
                    hVar.f19762o = g10.getLong(i27);
                    int i28 = a31;
                    hVar.f19763p = g10.getLong(i28);
                    int i29 = a32;
                    hVar.f19764q = g10.getInt(i29) != 0;
                    int i30 = a33;
                    hVar.r = g6.d(g10.getInt(i30));
                    hVar.f19757j = cVar2;
                    arrayList.add(hVar);
                    a30 = i27;
                    a20 = i20;
                    a25 = i22;
                    a26 = i23;
                    a27 = i24;
                    i10 = i16;
                    a21 = i19;
                    a10 = i14;
                    a24 = i21;
                    a28 = i25;
                    a29 = i26;
                    a32 = i29;
                    a19 = i12;
                    a33 = i30;
                    a31 = i28;
                    a23 = i18;
                    a18 = i17;
                    a17 = i11;
                    a11 = i15;
                    a3 = i13;
                }
                g10.close();
                lVar.c();
                ArrayList d5 = n4.d();
                ArrayList b10 = n4.b();
                boolean isEmpty = arrayList.isEmpty();
                String str = f3037g;
                if (isEmpty) {
                    lVar2 = k10;
                    eVar = l3;
                    cVar = o3;
                    i3 = 0;
                } else {
                    i3 = 0;
                    m.g().h(str, "Recently completed work:\n\n", new Throwable[0]);
                    lVar2 = k10;
                    eVar = l3;
                    cVar = o3;
                    m.g().h(str, h(eVar, cVar, lVar2, arrayList), new Throwable[0]);
                }
                if (!d5.isEmpty()) {
                    m.g().h(str, "Running work:\n\n", new Throwable[i3]);
                    m.g().h(str, h(eVar, cVar, lVar2, d5), new Throwable[i3]);
                }
                if (!b10.isEmpty()) {
                    m.g().h(str, "Enqueued work:\n\n", new Throwable[i3]);
                    m.g().h(str, h(eVar, cVar, lVar2, b10), new Throwable[i3]);
                }
                return new k(o2.f.f16710c);
            } catch (Throwable th2) {
                th = th2;
                g10.close();
                lVar.c();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            lVar = b3;
        }
    }
}
