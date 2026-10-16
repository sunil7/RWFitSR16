package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataSleep;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataSleepDao extends AbstractDao<DataSleep, Long> {
    public static final String TABLENAME = "t_data_sleep";

    public static class Properties {
        public static final Property AsleepTime;
        public static final Property IsUpdate;
        public static final Property SleepDeepTime;
        public static final Property SleepLightTime;
        public static final Property SleepRapidTime;
        public static final Property TotalSleepTime;
        public static final Property WakeupCount;
        public static final Property WakeupTime;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, String.class, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property Items = new Property(5, String.class, "items", false, "items");

        static {
            Class cls = Long.TYPE;
            TotalSleepTime = new Property(6, cls, "totalSleepTime", false, "total_sleep_time");
            SleepDeepTime = new Property(7, cls, "sleepDeepTime", false, "sleep_deep_time");
            SleepLightTime = new Property(8, cls, "sleepLightTime", false, "sleep_light_time");
            SleepRapidTime = new Property(9, cls, "sleepRapidTime", false, "sleep_rapid_time");
            WakeupCount = new Property(10, Integer.TYPE, "wakeupCount", false, "wake_up_count");
            AsleepTime = new Property(11, cls, "asleepTime", false, "asleep_time");
            WakeupTime = new Property(12, cls, "wakeupTime", false, "wakeup_time");
            IsUpdate = new Property(13, Boolean.TYPE, "isUpdate", false, "is_update");
        }
    }

    public DataSleepDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_sleep\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" TEXT,\"date\" TEXT,\"items\" TEXT,\"total_sleep_time\" INTEGER NOT NULL ,\"sleep_deep_time\" INTEGER NOT NULL ,\"sleep_light_time\" INTEGER NOT NULL ,\"sleep_rapid_time\" INTEGER NOT NULL ,\"wake_up_count\" INTEGER NOT NULL ,\"asleep_time\" INTEGER NOT NULL ,\"wakeup_time\" INTEGER NOT NULL ,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_sleep_user_id_DESC_date_DESC_mac_DESC ON \"t_data_sleep\" (\"user_id\" DESC,\"date\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_sleep\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataSleepDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataSleep dataSleep) {
        if (dataSleep != null) {
            return dataSleep.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataSleep dataSleep) {
        return dataSleep.getId() != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public Long readKey(Cursor cursor, int i3) {
        if (cursor.isNull(i3)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i3));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(DataSleep dataSleep, long j4) {
        dataSleep.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataSleep dataSleep) {
        databaseStatement.clearBindings();
        Long id2 = dataSleep.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataSleep.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataSleep.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String timestamp = dataSleep.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(4, timestamp);
        }
        String date = dataSleep.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        String items = dataSleep.getItems();
        if (items != null) {
            databaseStatement.bindString(6, items);
        }
        databaseStatement.bindLong(7, dataSleep.getTotalSleepTime());
        databaseStatement.bindLong(8, dataSleep.getSleepDeepTime());
        databaseStatement.bindLong(9, dataSleep.getSleepLightTime());
        databaseStatement.bindLong(10, dataSleep.getSleepRapidTime());
        databaseStatement.bindLong(11, dataSleep.getWakeupCount());
        databaseStatement.bindLong(12, dataSleep.getAsleepTime());
        databaseStatement.bindLong(13, dataSleep.getWakeupTime());
        databaseStatement.bindLong(14, dataSleep.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataSleep readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        int i14 = i3 + 5;
        return new DataSleep(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.isNull(i14) ? null : cursor.getString(i14), cursor.getLong(i3 + 6), cursor.getLong(i3 + 7), cursor.getLong(i3 + 8), cursor.getLong(i3 + 9), cursor.getInt(i3 + 10), cursor.getLong(i3 + 11), cursor.getLong(i3 + 12), cursor.getShort(i3 + 13) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataSleep dataSleep, int i3) {
        dataSleep.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataSleep.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataSleep.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataSleep.setTimestamp(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataSleep.setDate(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i3 + 5;
        dataSleep.setItems(cursor.isNull(i14) ? null : cursor.getString(i14));
        dataSleep.setTotalSleepTime(cursor.getLong(i3 + 6));
        dataSleep.setSleepDeepTime(cursor.getLong(i3 + 7));
        dataSleep.setSleepLightTime(cursor.getLong(i3 + 8));
        dataSleep.setSleepRapidTime(cursor.getLong(i3 + 9));
        dataSleep.setWakeupCount(cursor.getInt(i3 + 10));
        dataSleep.setAsleepTime(cursor.getLong(i3 + 11));
        dataSleep.setWakeupTime(cursor.getLong(i3 + 12));
        dataSleep.setIsUpdate(cursor.getShort(i3 + 13) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataSleep dataSleep) {
        sQLiteStatement.clearBindings();
        Long id2 = dataSleep.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataSleep.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataSleep.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String timestamp = dataSleep.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(4, timestamp);
        }
        String date = dataSleep.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        String items = dataSleep.getItems();
        if (items != null) {
            sQLiteStatement.bindString(6, items);
        }
        sQLiteStatement.bindLong(7, dataSleep.getTotalSleepTime());
        sQLiteStatement.bindLong(8, dataSleep.getSleepDeepTime());
        sQLiteStatement.bindLong(9, dataSleep.getSleepLightTime());
        sQLiteStatement.bindLong(10, dataSleep.getSleepRapidTime());
        sQLiteStatement.bindLong(11, dataSleep.getWakeupCount());
        sQLiteStatement.bindLong(12, dataSleep.getAsleepTime());
        sQLiteStatement.bindLong(13, dataSleep.getWakeupTime());
        sQLiteStatement.bindLong(14, dataSleep.getIsUpdate() ? 1L : 0L);
    }
}
