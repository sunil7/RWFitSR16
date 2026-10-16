package p2;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes.dex */
public final class i extends c2.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f17412c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final Context f17413d;

    public i(Context context, int i3, int i10) {
        super(i3, i10);
        this.f17413d = context;
    }

    @Override // c2.a
    public final void a(SupportSQLiteDatabase supportSQLiteDatabase) {
        switch (this.f17412c) {
            case 0:
                if (this.f3373b >= 10) {
                    supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                    return;
                } else {
                    this.f17413d.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
                    return;
                }
            default:
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                Context context = this.f17413d;
                SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
                if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                    long j4 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
                    long j10 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
                    supportSQLiteDatabase.beginTransaction();
                    try {
                        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j4)});
                        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j10)});
                        sharedPreferences.edit().clear().apply();
                        supportSQLiteDatabase.setTransactionSuccessful();
                    } finally {
                    }
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
                if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                    int i3 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                    int i10 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                    supportSQLiteDatabase.beginTransaction();
                    try {
                        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i3)});
                        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i10)});
                        sharedPreferences2.edit().clear().apply();
                        supportSQLiteDatabase.setTransactionSuccessful();
                        return;
                    } finally {
                    }
                }
                return;
        }
    }

    public i(Context context) {
        super(9, 10);
        this.f17413d = context;
    }
}
