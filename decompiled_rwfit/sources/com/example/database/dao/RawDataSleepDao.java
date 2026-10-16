package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.RawDataSleep;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class RawDataSleepDao extends AbstractDao<RawDataSleep, Long> {
    public static final String TABLENAME = "t_raw_data_sleep";

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, Long.TYPE, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property SleepModel = new Property(5, Integer.TYPE, "sleepModel", false, "sleep_model");
        public static final Property IsUpdate = new Property(6, Boolean.TYPE, "isUpdate", false, "is_update");
    }

    public RawDataSleepDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_raw_data_sleep\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" INTEGER NOT NULL ,\"date\" TEXT,\"sleep_model\" INTEGER NOT NULL ,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_raw_data_sleep_user_id_DESC_timestamp_DESC_mac_DESC ON \"t_raw_data_sleep\" (\"user_id\" DESC,\"timestamp\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_raw_data_sleep\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public RawDataSleepDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(RawDataSleep rawDataSleep) {
        if (rawDataSleep != null) {
            return rawDataSleep.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(RawDataSleep rawDataSleep) {
        return rawDataSleep.getId() != null;
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
    public final Long updateKeyAfterInsert(RawDataSleep rawDataSleep, long j4) {
        rawDataSleep.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, RawDataSleep rawDataSleep) {
        databaseStatement.clearBindings();
        Long id2 = rawDataSleep.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = rawDataSleep.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = rawDataSleep.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        databaseStatement.bindLong(4, rawDataSleep.getTimestamp());
        String date = rawDataSleep.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        databaseStatement.bindLong(6, rawDataSleep.getSleepModel());
        databaseStatement.bindLong(7, rawDataSleep.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public RawDataSleep readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 4;
        return new RawDataSleep(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.getLong(i3 + 3), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.getInt(i3 + 5), cursor.getShort(i3 + 6) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, RawDataSleep rawDataSleep, int i3) {
        rawDataSleep.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        rawDataSleep.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        rawDataSleep.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        rawDataSleep.setTimestamp(cursor.getLong(i3 + 3));
        int i12 = i3 + 4;
        rawDataSleep.setDate(cursor.isNull(i12) ? null : cursor.getString(i12));
        rawDataSleep.setSleepModel(cursor.getInt(i3 + 5));
        rawDataSleep.setIsUpdate(cursor.getShort(i3 + 6) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, RawDataSleep rawDataSleep) {
        sQLiteStatement.clearBindings();
        Long id2 = rawDataSleep.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = rawDataSleep.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = rawDataSleep.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        sQLiteStatement.bindLong(4, rawDataSleep.getTimestamp());
        String date = rawDataSleep.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        sQLiteStatement.bindLong(6, rawDataSleep.getSleepModel());
        sQLiteStatement.bindLong(7, rawDataSleep.getIsUpdate() ? 1L : 0L);
    }
}
