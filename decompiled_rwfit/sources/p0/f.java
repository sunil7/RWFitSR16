package p0;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase_Impl;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.mb;
import com.google.android.gms.internal.mlkit_vision_common.g6;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public Object f17315a;

    /* renamed from: b, reason: collision with root package name */
    public Object f17316b;

    /* renamed from: c, reason: collision with root package name */
    public Object f17317c;

    /* renamed from: d, reason: collision with root package name */
    public Object f17318d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public Object f17319f;

    /* renamed from: g, reason: collision with root package name */
    public Object f17320g;

    /* renamed from: h, reason: collision with root package name */
    public Object f17321h;

    /* renamed from: i, reason: collision with root package name */
    public Object f17322i;

    public f(WorkDatabase_Impl workDatabase_Impl) {
        this.f17315a = workDatabase_Impl;
        this.f17316b = new x2.b(workDatabase_Impl, 4);
        this.f17317c = new x2.e(workDatabase_Impl, 3);
        this.f17318d = new x2.e(workDatabase_Impl, 4);
        this.e = new x2.e(workDatabase_Impl, 5);
        this.f17319f = new x2.e(workDatabase_Impl, 6);
        this.f17320g = new x2.e(workDatabase_Impl, 7);
        this.f17321h = new x2.e(workDatabase_Impl, 8);
        this.f17322i = new x2.e(workDatabase_Impl, 9);
        new AtomicBoolean(false);
    }

    public void a(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        x2.e eVar = (x2.e) this.f17317c;
        SupportSQLiteStatement a3 = eVar.a();
        if (str == null) {
            a3.bindNull(1);
        } else {
            a3.bindString(1, str);
        }
        workDatabase_Impl.c();
        try {
            a3.executeUpdateDelete();
            workDatabase_Impl.h();
        } finally {
            workDatabase_Impl.f();
            eVar.c(a3);
        }
    }

    public ArrayList b() {
        b2.l lVar;
        b2.l b3 = b2.l.b(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?");
        b3.bindLong(1, 200);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
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
            int a20 = mb.a(g10, "input_merger_class_name");
            int a21 = mb.a(g10, "input");
            lVar = b3;
            try {
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
                int i3 = a22;
                ArrayList arrayList = new ArrayList(g10.getCount());
                while (g10.moveToNext()) {
                    String string = g10.getString(a17);
                    int i10 = a17;
                    String string2 = g10.getString(a19);
                    int i11 = a19;
                    o2.c cVar = new o2.c();
                    int i12 = a3;
                    cVar.f16699a = g6.c(g10.getInt(a3));
                    cVar.f16700b = g10.getInt(a10) != 0;
                    cVar.f16701c = g10.getInt(a11) != 0;
                    cVar.f16702d = g10.getInt(a12) != 0;
                    cVar.e = g10.getInt(a13) != 0;
                    int i13 = a10;
                    int i14 = a11;
                    cVar.f16703f = g10.getLong(a14);
                    cVar.f16704g = g10.getLong(a15);
                    cVar.f16705h = g6.a(g10.getBlob(a16));
                    x2.h hVar = new x2.h(string, string2);
                    hVar.f19750b = g6.e(g10.getInt(a18));
                    hVar.f19752d = g10.getString(a20);
                    hVar.e = o2.f.a(g10.getBlob(a21));
                    int i15 = i3;
                    hVar.f19753f = o2.f.a(g10.getBlob(i15));
                    int i16 = a21;
                    int i17 = a23;
                    hVar.f19754g = g10.getLong(i17);
                    i3 = i15;
                    int i18 = a24;
                    hVar.f19755h = g10.getLong(i18);
                    int i19 = a12;
                    int i20 = a25;
                    hVar.f19756i = g10.getLong(i20);
                    int i21 = a26;
                    hVar.f19758k = g10.getInt(i21);
                    int i22 = a27;
                    hVar.f19759l = g6.b(g10.getInt(i22));
                    a25 = i20;
                    int i23 = a28;
                    hVar.f19760m = g10.getLong(i23);
                    int i24 = a29;
                    hVar.f19761n = g10.getLong(i24);
                    a29 = i24;
                    int i25 = a30;
                    hVar.f19762o = g10.getLong(i25);
                    int i26 = a31;
                    hVar.f19763p = g10.getLong(i26);
                    int i27 = a32;
                    hVar.f19764q = g10.getInt(i27) != 0;
                    int i28 = a33;
                    hVar.r = g6.d(g10.getInt(i28));
                    hVar.f19757j = cVar;
                    arrayList.add(hVar);
                    a28 = i23;
                    a12 = i19;
                    a27 = i22;
                    a33 = i28;
                    a10 = i13;
                    a23 = i17;
                    a24 = i18;
                    a26 = i21;
                    a31 = i26;
                    a19 = i11;
                    a3 = i12;
                    a32 = i27;
                    a30 = i25;
                    a21 = i16;
                    a17 = i10;
                    a11 = i14;
                }
                g10.close();
                lVar.c();
                return arrayList;
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

    public ArrayList c(int i3) {
        b2.l lVar;
        b2.l b3 = b2.l.b(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))");
        b3.bindLong(1, i3);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
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
            int a20 = mb.a(g10, "input_merger_class_name");
            int a21 = mb.a(g10, "input");
            lVar = b3;
            try {
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
                    o2.c cVar = new o2.c();
                    int i13 = a3;
                    cVar.f16699a = g6.c(g10.getInt(a3));
                    cVar.f16700b = g10.getInt(a10) != 0;
                    cVar.f16701c = g10.getInt(a11) != 0;
                    cVar.f16702d = g10.getInt(a12) != 0;
                    cVar.e = g10.getInt(a13) != 0;
                    int i14 = a10;
                    int i15 = a11;
                    cVar.f16703f = g10.getLong(a14);
                    cVar.f16704g = g10.getLong(a15);
                    cVar.f16705h = g6.a(g10.getBlob(a16));
                    x2.h hVar = new x2.h(string, string2);
                    hVar.f19750b = g6.e(g10.getInt(a18));
                    hVar.f19752d = g10.getString(a20);
                    hVar.e = o2.f.a(g10.getBlob(a21));
                    int i16 = i10;
                    hVar.f19753f = o2.f.a(g10.getBlob(i16));
                    int i17 = a23;
                    int i18 = a21;
                    hVar.f19754g = g10.getLong(i17);
                    i10 = i16;
                    int i19 = a24;
                    hVar.f19755h = g10.getLong(i19);
                    int i20 = a12;
                    int i21 = a25;
                    hVar.f19756i = g10.getLong(i21);
                    int i22 = a26;
                    hVar.f19758k = g10.getInt(i22);
                    int i23 = a27;
                    hVar.f19759l = g6.b(g10.getInt(i23));
                    a25 = i21;
                    int i24 = a28;
                    hVar.f19760m = g10.getLong(i24);
                    int i25 = a29;
                    hVar.f19761n = g10.getLong(i25);
                    a29 = i25;
                    int i26 = a30;
                    hVar.f19762o = g10.getLong(i26);
                    int i27 = a31;
                    hVar.f19763p = g10.getLong(i27);
                    int i28 = a32;
                    hVar.f19764q = g10.getInt(i28) != 0;
                    int i29 = a33;
                    hVar.r = g6.d(g10.getInt(i29));
                    hVar.f19757j = cVar;
                    arrayList.add(hVar);
                    a28 = i24;
                    a12 = i20;
                    a27 = i23;
                    a33 = i29;
                    a10 = i14;
                    a31 = i27;
                    a17 = i11;
                    a19 = i12;
                    a3 = i13;
                    a32 = i28;
                    a21 = i18;
                    a23 = i17;
                    a24 = i19;
                    a26 = i22;
                    a30 = i26;
                    a11 = i15;
                }
                g10.close();
                lVar.c();
                return arrayList;
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

    public ArrayList d() {
        b2.l lVar;
        int a3;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        b2.l b3 = b2.l.b(0, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1");
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        Cursor g10 = workDatabase_Impl.g(b3);
        try {
            a3 = mb.a(g10, "required_network_type");
            a10 = mb.a(g10, "requires_charging");
            a11 = mb.a(g10, "requires_device_idle");
            a12 = mb.a(g10, "requires_battery_not_low");
            a13 = mb.a(g10, "requires_storage_not_low");
            a14 = mb.a(g10, "trigger_content_update_delay");
            a15 = mb.a(g10, "trigger_max_content_delay");
            a16 = mb.a(g10, "content_uri_triggers");
            a17 = mb.a(g10, "id");
            a18 = mb.a(g10, "state");
            a19 = mb.a(g10, "worker_class_name");
            a20 = mb.a(g10, "input_merger_class_name");
            a21 = mb.a(g10, "input");
            lVar = b3;
        } catch (Throwable th2) {
            th = th2;
            lVar = b3;
        }
        try {
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
            int i3 = a22;
            ArrayList arrayList = new ArrayList(g10.getCount());
            while (g10.moveToNext()) {
                String string = g10.getString(a17);
                int i10 = a17;
                String string2 = g10.getString(a19);
                int i11 = a19;
                o2.c cVar = new o2.c();
                int i12 = a3;
                cVar.f16699a = g6.c(g10.getInt(a3));
                cVar.f16700b = g10.getInt(a10) != 0;
                cVar.f16701c = g10.getInt(a11) != 0;
                cVar.f16702d = g10.getInt(a12) != 0;
                cVar.e = g10.getInt(a13) != 0;
                int i13 = a10;
                int i14 = a11;
                cVar.f16703f = g10.getLong(a14);
                cVar.f16704g = g10.getLong(a15);
                cVar.f16705h = g6.a(g10.getBlob(a16));
                x2.h hVar = new x2.h(string, string2);
                hVar.f19750b = g6.e(g10.getInt(a18));
                hVar.f19752d = g10.getString(a20);
                hVar.e = o2.f.a(g10.getBlob(a21));
                int i15 = i3;
                hVar.f19753f = o2.f.a(g10.getBlob(i15));
                int i16 = a21;
                int i17 = a23;
                hVar.f19754g = g10.getLong(i17);
                i3 = i15;
                int i18 = a24;
                hVar.f19755h = g10.getLong(i18);
                int i19 = a12;
                int i20 = a25;
                hVar.f19756i = g10.getLong(i20);
                int i21 = a26;
                hVar.f19758k = g10.getInt(i21);
                int i22 = a27;
                hVar.f19759l = g6.b(g10.getInt(i22));
                a25 = i20;
                int i23 = a28;
                hVar.f19760m = g10.getLong(i23);
                int i24 = a29;
                hVar.f19761n = g10.getLong(i24);
                a29 = i24;
                int i25 = a30;
                hVar.f19762o = g10.getLong(i25);
                int i26 = a31;
                hVar.f19763p = g10.getLong(i26);
                int i27 = a32;
                hVar.f19764q = g10.getInt(i27) != 0;
                int i28 = a33;
                hVar.r = g6.d(g10.getInt(i28));
                hVar.f19757j = cVar;
                arrayList.add(hVar);
                a28 = i23;
                a12 = i19;
                a27 = i22;
                a33 = i28;
                a10 = i13;
                a23 = i17;
                a24 = i18;
                a26 = i21;
                a31 = i26;
                a19 = i11;
                a3 = i12;
                a32 = i27;
                a30 = i25;
                a21 = i16;
                a17 = i10;
                a11 = i14;
            }
            g10.close();
            lVar.c();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            g10.close();
            lVar.c();
            throw th;
        }
    }

    public ArrayList e() {
        b2.l lVar;
        int a3;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        b2.l b3 = b2.l.b(0, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        Cursor g10 = workDatabase_Impl.g(b3);
        try {
            a3 = mb.a(g10, "required_network_type");
            a10 = mb.a(g10, "requires_charging");
            a11 = mb.a(g10, "requires_device_idle");
            a12 = mb.a(g10, "requires_battery_not_low");
            a13 = mb.a(g10, "requires_storage_not_low");
            a14 = mb.a(g10, "trigger_content_update_delay");
            a15 = mb.a(g10, "trigger_max_content_delay");
            a16 = mb.a(g10, "content_uri_triggers");
            a17 = mb.a(g10, "id");
            a18 = mb.a(g10, "state");
            a19 = mb.a(g10, "worker_class_name");
            a20 = mb.a(g10, "input_merger_class_name");
            a21 = mb.a(g10, "input");
            lVar = b3;
        } catch (Throwable th2) {
            th = th2;
            lVar = b3;
        }
        try {
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
            int i3 = a22;
            ArrayList arrayList = new ArrayList(g10.getCount());
            while (g10.moveToNext()) {
                String string = g10.getString(a17);
                int i10 = a17;
                String string2 = g10.getString(a19);
                int i11 = a19;
                o2.c cVar = new o2.c();
                int i12 = a3;
                cVar.f16699a = g6.c(g10.getInt(a3));
                cVar.f16700b = g10.getInt(a10) != 0;
                cVar.f16701c = g10.getInt(a11) != 0;
                cVar.f16702d = g10.getInt(a12) != 0;
                cVar.e = g10.getInt(a13) != 0;
                int i13 = a10;
                int i14 = a11;
                cVar.f16703f = g10.getLong(a14);
                cVar.f16704g = g10.getLong(a15);
                cVar.f16705h = g6.a(g10.getBlob(a16));
                x2.h hVar = new x2.h(string, string2);
                hVar.f19750b = g6.e(g10.getInt(a18));
                hVar.f19752d = g10.getString(a20);
                hVar.e = o2.f.a(g10.getBlob(a21));
                int i15 = i3;
                hVar.f19753f = o2.f.a(g10.getBlob(i15));
                int i16 = a21;
                int i17 = a23;
                hVar.f19754g = g10.getLong(i17);
                i3 = i15;
                int i18 = a24;
                hVar.f19755h = g10.getLong(i18);
                int i19 = a12;
                int i20 = a25;
                hVar.f19756i = g10.getLong(i20);
                int i21 = a26;
                hVar.f19758k = g10.getInt(i21);
                int i22 = a27;
                hVar.f19759l = g6.b(g10.getInt(i22));
                a25 = i20;
                int i23 = a28;
                hVar.f19760m = g10.getLong(i23);
                int i24 = a29;
                hVar.f19761n = g10.getLong(i24);
                a29 = i24;
                int i25 = a30;
                hVar.f19762o = g10.getLong(i25);
                int i26 = a31;
                hVar.f19763p = g10.getLong(i26);
                int i27 = a32;
                hVar.f19764q = g10.getInt(i27) != 0;
                int i28 = a33;
                hVar.r = g6.d(g10.getInt(i28));
                hVar.f19757j = cVar;
                arrayList.add(hVar);
                a28 = i23;
                a12 = i19;
                a27 = i22;
                a33 = i28;
                a10 = i13;
                a23 = i17;
                a24 = i18;
                a26 = i21;
                a31 = i26;
                a19 = i11;
                a3 = i12;
                a32 = i27;
                a30 = i25;
                a21 = i16;
                a17 = i10;
                a11 = i14;
            }
            g10.close();
            lVar.c();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            g10.close();
            lVar.c();
            throw th;
        }
    }

    public WorkInfo$State f(String str) {
        b2.l b3 = b2.l.b(1, "SELECT state FROM workspec WHERE id=?");
        if (str == null) {
            b3.bindNull(1);
        } else {
            b3.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        Cursor g10 = workDatabase_Impl.g(b3);
        try {
            return g10.moveToFirst() ? g6.e(g10.getInt(0)) : null;
        } finally {
            g10.close();
            b3.c();
        }
    }

    public ArrayList g(String str) {
        b2.l b3 = b2.l.b(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            b3.bindNull(1);
        } else {
            b3.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        Cursor g10 = workDatabase_Impl.g(b3);
        try {
            ArrayList arrayList = new ArrayList(g10.getCount());
            while (g10.moveToNext()) {
                arrayList.add(g10.getString(0));
            }
            return arrayList;
        } finally {
            g10.close();
            b3.c();
        }
    }

    public x2.h h(String str) {
        b2.l lVar;
        int a3;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        x2.h hVar;
        b2.l b3 = b2.l.b(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?");
        if (str == null) {
            b3.bindNull(1);
        } else {
            b3.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        Cursor g10 = workDatabase_Impl.g(b3);
        try {
            a3 = mb.a(g10, "required_network_type");
            a10 = mb.a(g10, "requires_charging");
            a11 = mb.a(g10, "requires_device_idle");
            a12 = mb.a(g10, "requires_battery_not_low");
            a13 = mb.a(g10, "requires_storage_not_low");
            a14 = mb.a(g10, "trigger_content_update_delay");
            a15 = mb.a(g10, "trigger_max_content_delay");
            a16 = mb.a(g10, "content_uri_triggers");
            a17 = mb.a(g10, "id");
            a18 = mb.a(g10, "state");
            a19 = mb.a(g10, "worker_class_name");
            a20 = mb.a(g10, "input_merger_class_name");
            a21 = mb.a(g10, "input");
            lVar = b3;
        } catch (Throwable th2) {
            th = th2;
            lVar = b3;
        }
        try {
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
            if (g10.moveToFirst()) {
                String string = g10.getString(a17);
                String string2 = g10.getString(a19);
                o2.c cVar = new o2.c();
                cVar.f16699a = g6.c(g10.getInt(a3));
                cVar.f16700b = g10.getInt(a10) != 0;
                cVar.f16701c = g10.getInt(a11) != 0;
                cVar.f16702d = g10.getInt(a12) != 0;
                cVar.e = g10.getInt(a13) != 0;
                cVar.f16703f = g10.getLong(a14);
                cVar.f16704g = g10.getLong(a15);
                cVar.f16705h = g6.a(g10.getBlob(a16));
                hVar = new x2.h(string, string2);
                hVar.f19750b = g6.e(g10.getInt(a18));
                hVar.f19752d = g10.getString(a20);
                hVar.e = o2.f.a(g10.getBlob(a21));
                hVar.f19753f = o2.f.a(g10.getBlob(a22));
                hVar.f19754g = g10.getLong(a23);
                hVar.f19755h = g10.getLong(a24);
                hVar.f19756i = g10.getLong(a25);
                hVar.f19758k = g10.getInt(a26);
                hVar.f19759l = g6.b(g10.getInt(a27));
                hVar.f19760m = g10.getLong(a28);
                hVar.f19761n = g10.getLong(a29);
                hVar.f19762o = g10.getLong(a30);
                hVar.f19763p = g10.getLong(a31);
                hVar.f19764q = g10.getInt(a32) != 0;
                hVar.r = g6.d(g10.getInt(a33));
                hVar.f19757j = cVar;
            } else {
                hVar = null;
            }
            g10.close();
            lVar.c();
            return hVar;
        } catch (Throwable th3) {
            th = th3;
            g10.close();
            lVar.c();
            throw th;
        }
    }

    public ArrayList i(String str) {
        b2.l b3 = b2.l.b(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            b3.bindNull(1);
        } else {
            b3.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        Cursor g10 = workDatabase_Impl.g(b3);
        try {
            int a3 = mb.a(g10, "id");
            int a10 = mb.a(g10, "state");
            ArrayList arrayList = new ArrayList(g10.getCount());
            while (g10.moveToNext()) {
                x2.g gVar = new x2.g();
                gVar.f19746a = g10.getString(a3);
                gVar.f19747b = g6.e(g10.getInt(a10));
                arrayList.add(gVar);
            }
            return arrayList;
        } finally {
            g10.close();
            b3.c();
        }
    }

    public void j(long j4, String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        x2.e eVar = (x2.e) this.f17321h;
        SupportSQLiteStatement a3 = eVar.a();
        a3.bindLong(1, j4);
        if (str == null) {
            a3.bindNull(2);
        } else {
            a3.bindString(2, str);
        }
        workDatabase_Impl.c();
        try {
            a3.executeUpdateDelete();
            workDatabase_Impl.h();
        } finally {
            workDatabase_Impl.f();
            eVar.c(a3);
        }
    }

    public void k(String str, o2.f fVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        x2.e eVar = (x2.e) this.f17318d;
        SupportSQLiteStatement a3 = eVar.a();
        byte[] b3 = o2.f.b(fVar);
        if (b3 == null) {
            a3.bindNull(1);
        } else {
            a3.bindBlob(1, b3);
        }
        if (str == null) {
            a3.bindNull(2);
        } else {
            a3.bindString(2, str);
        }
        workDatabase_Impl.c();
        try {
            a3.executeUpdateDelete();
            workDatabase_Impl.h();
        } finally {
            workDatabase_Impl.f();
            eVar.c(a3);
        }
    }

    public void l(long j4, String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        x2.e eVar = (x2.e) this.e;
        SupportSQLiteStatement a3 = eVar.a();
        a3.bindLong(1, j4);
        if (str == null) {
            a3.bindNull(2);
        } else {
            a3.bindString(2, str);
        }
        workDatabase_Impl.c();
        try {
            a3.executeUpdateDelete();
            workDatabase_Impl.h();
        } finally {
            workDatabase_Impl.f();
            eVar.c(a3);
        }
    }

    public void m(WorkInfo$State workInfo$State, String... strArr) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f17315a;
        workDatabase_Impl.b();
        StringBuilder sb2 = new StringBuilder("UPDATE workspec SET state=? WHERE id IN (");
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb2.append("?");
            if (i3 < length - 1) {
                sb2.append(Const.STR_MART_COMMA);
            }
        }
        sb2.append(")");
        String sb3 = sb2.toString();
        workDatabase_Impl.a();
        workDatabase_Impl.b();
        SupportSQLiteStatement compileStatement = workDatabase_Impl.f3123c.getWritableDatabase().compileStatement(sb3);
        compileStatement.bindLong(1, g6.f(workInfo$State));
        int i10 = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.bindNull(i10);
            } else {
                compileStatement.bindString(i10, str);
            }
            i10++;
        }
        workDatabase_Impl.c();
        try {
            compileStatement.executeUpdateDelete();
            workDatabase_Impl.h();
        } finally {
            workDatabase_Impl.f();
        }
    }
}
