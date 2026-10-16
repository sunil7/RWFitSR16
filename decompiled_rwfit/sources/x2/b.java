package x2;

import androidx.sqlite.db.SupportSQLiteStatement;
import b2.n;

/* loaded from: classes.dex */
public final class b extends n {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f19738d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(b2.i iVar, int i3) {
        super(iVar);
        this.f19738d = i3;
    }

    @Override // b2.n
    public final String b() {
        switch (this.f19738d) {
            case 0:
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            case 1:
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            case 2:
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
            case 3:
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            case 4:
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ff  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x01db -> B:68:0x01f3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(androidx.sqlite.db.SupportSQLiteStatement r19, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.b.d(androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object):void");
    }

    public final void e(Object obj) {
        SupportSQLiteStatement a3 = a();
        try {
            d(a3, obj);
            a3.executeInsert();
        } finally {
            c(a3);
        }
    }
}
