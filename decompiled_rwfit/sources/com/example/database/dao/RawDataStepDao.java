package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.RawDataStep;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class RawDataStepDao extends AbstractDao<RawDataStep, Long> {
    public static final String TABLENAME = "t_raw_data_step";

    public static class Properties {
        public static final Property Calorie;
        public static final Property Distance;
        public static final Property IsUpdate;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, Long.TYPE, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property Hour = new Property(5, String.class, "hour", false, "hour");
        public static final Property Step = new Property(6, Integer.TYPE, "step", false, "step");

        static {
            Class cls = Float.TYPE;
            Calorie = new Property(7, cls, "calorie", false, "calorie");
            Distance = new Property(8, cls, "distance", false, "distance");
            IsUpdate = new Property(9, Boolean.TYPE, "isUpdate", false, "is_update");
        }
    }

    public RawDataStepDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_raw_data_step\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" INTEGER NOT NULL ,\"date\" TEXT,\"hour\" TEXT,\"step\" INTEGER NOT NULL ,\"calorie\" REAL NOT NULL ,\"distance\" REAL NOT NULL ,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_raw_data_step_user_id_DESC_timestamp_DESC_mac_DESC ON \"t_raw_data_step\" (\"user_id\" DESC,\"timestamp\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_raw_data_step\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public RawDataStepDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(RawDataStep rawDataStep) {
        if (rawDataStep != null) {
            return rawDataStep.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(RawDataStep rawDataStep) {
        return rawDataStep.getId() != null;
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
    public final Long updateKeyAfterInsert(RawDataStep rawDataStep, long j4) {
        rawDataStep.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, RawDataStep rawDataStep) {
        databaseStatement.clearBindings();
        Long id2 = rawDataStep.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = rawDataStep.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = rawDataStep.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        databaseStatement.bindLong(4, rawDataStep.getTimestamp());
        String date = rawDataStep.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        String hour = rawDataStep.getHour();
        if (hour != null) {
            databaseStatement.bindString(6, hour);
        }
        databaseStatement.bindLong(7, rawDataStep.getStep());
        databaseStatement.bindDouble(8, rawDataStep.getCalorie());
        databaseStatement.bindDouble(9, rawDataStep.getDistance());
        databaseStatement.bindLong(10, rawDataStep.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public RawDataStep readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 4;
        int i13 = i3 + 5;
        return new RawDataStep(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.getLong(i3 + 3), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.getInt(i3 + 6), cursor.getFloat(i3 + 7), cursor.getFloat(i3 + 8), cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, RawDataStep rawDataStep, int i3) {
        rawDataStep.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        rawDataStep.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        rawDataStep.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        rawDataStep.setTimestamp(cursor.getLong(i3 + 3));
        int i12 = i3 + 4;
        rawDataStep.setDate(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 5;
        rawDataStep.setHour(cursor.isNull(i13) ? null : cursor.getString(i13));
        rawDataStep.setStep(cursor.getInt(i3 + 6));
        rawDataStep.setCalorie(cursor.getFloat(i3 + 7));
        rawDataStep.setDistance(cursor.getFloat(i3 + 8));
        rawDataStep.setIsUpdate(cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, RawDataStep rawDataStep) {
        sQLiteStatement.clearBindings();
        Long id2 = rawDataStep.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = rawDataStep.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = rawDataStep.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        sQLiteStatement.bindLong(4, rawDataStep.getTimestamp());
        String date = rawDataStep.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        String hour = rawDataStep.getHour();
        if (hour != null) {
            sQLiteStatement.bindString(6, hour);
        }
        sQLiteStatement.bindLong(7, rawDataStep.getStep());
        sQLiteStatement.bindDouble(8, rawDataStep.getCalorie());
        sQLiteStatement.bindDouble(9, rawDataStep.getDistance());
        sQLiteStatement.bindLong(10, rawDataStep.getIsUpdate() ? 1L : 0L);
    }
}
