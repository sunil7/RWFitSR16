package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataStep;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataStepDao extends AbstractDao<DataStep, Long> {
    public static final String TABLENAME = "t_data_step";

    public static class Properties {
        public static final Property Calorie;
        public static final Property Distance;
        public static final Property IsUpdate;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, String.class, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property Items = new Property(5, String.class, "items", false, "items");
        public static final Property TotalStep = new Property(6, Integer.TYPE, "totalStep", false, "total_step");

        static {
            Class cls = Float.TYPE;
            Calorie = new Property(7, cls, "calorie", false, "calorie");
            Distance = new Property(8, cls, "distance", false, "distance");
            IsUpdate = new Property(9, Boolean.TYPE, "isUpdate", false, "is_update");
        }
    }

    public DataStepDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_step\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" TEXT,\"date\" TEXT,\"items\" TEXT,\"total_step\" INTEGER NOT NULL ,\"calorie\" REAL NOT NULL ,\"distance\" REAL NOT NULL ,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_step_user_id_DESC_date_DESC_mac_DESC ON \"t_data_step\" (\"user_id\" DESC,\"date\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_step\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataStepDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataStep dataStep) {
        if (dataStep != null) {
            return dataStep.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataStep dataStep) {
        return dataStep.getId() != null;
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
    public final Long updateKeyAfterInsert(DataStep dataStep, long j4) {
        dataStep.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataStep dataStep) {
        databaseStatement.clearBindings();
        Long id2 = dataStep.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataStep.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataStep.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String timestamp = dataStep.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(4, timestamp);
        }
        String date = dataStep.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        String items = dataStep.getItems();
        if (items != null) {
            databaseStatement.bindString(6, items);
        }
        databaseStatement.bindLong(7, dataStep.getTotalStep());
        databaseStatement.bindDouble(8, dataStep.getCalorie());
        databaseStatement.bindDouble(9, dataStep.getDistance());
        databaseStatement.bindLong(10, dataStep.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataStep readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        int i14 = i3 + 5;
        return new DataStep(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.isNull(i14) ? null : cursor.getString(i14), cursor.getInt(i3 + 6), cursor.getFloat(i3 + 7), cursor.getFloat(i3 + 8), cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataStep dataStep, int i3) {
        dataStep.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataStep.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataStep.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataStep.setTimestamp(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataStep.setDate(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i3 + 5;
        dataStep.setItems(cursor.isNull(i14) ? null : cursor.getString(i14));
        dataStep.setTotalStep(cursor.getInt(i3 + 6));
        dataStep.setCalorie(cursor.getFloat(i3 + 7));
        dataStep.setDistance(cursor.getFloat(i3 + 8));
        dataStep.setIsUpdate(cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataStep dataStep) {
        sQLiteStatement.clearBindings();
        Long id2 = dataStep.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataStep.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataStep.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String timestamp = dataStep.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(4, timestamp);
        }
        String date = dataStep.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        String items = dataStep.getItems();
        if (items != null) {
            sQLiteStatement.bindString(6, items);
        }
        sQLiteStatement.bindLong(7, dataStep.getTotalStep());
        sQLiteStatement.bindDouble(8, dataStep.getCalorie());
        sQLiteStatement.bindDouble(9, dataStep.getDistance());
        sQLiteStatement.bindLong(10, dataStep.getIsUpdate() ? 1L : 0L);
    }
}
