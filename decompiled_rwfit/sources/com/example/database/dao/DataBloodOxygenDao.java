package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataBloodOxygen;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataBloodOxygenDao extends AbstractDao<DataBloodOxygen, Long> {
    public static final String TABLENAME = "t_data_bo";

    public static class Properties {
        public static final Property AvgBo;
        public static final Property IsUpdate;
        public static final Property MaxBo;
        public static final Property MinBo;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, String.class, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property Items = new Property(5, String.class, "items", false, "items");

        static {
            Class cls = Integer.TYPE;
            AvgBo = new Property(6, cls, "avgBo", false, "avg_bo");
            MaxBo = new Property(7, cls, "maxBo", false, "max_bo");
            MinBo = new Property(8, cls, "minBo", false, "min_bo");
            IsUpdate = new Property(9, Boolean.TYPE, "isUpdate", false, "is_update");
        }
    }

    public DataBloodOxygenDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_bo\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" TEXT,\"date\" TEXT,\"items\" TEXT,\"avg_bo\" INTEGER NOT NULL ,\"max_bo\" INTEGER NOT NULL ,\"min_bo\" INTEGER NOT NULL ,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_bo_user_id_DESC_date_DESC_mac_DESC ON \"t_data_bo\" (\"user_id\" DESC,\"date\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_bo\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataBloodOxygenDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataBloodOxygen dataBloodOxygen) {
        if (dataBloodOxygen != null) {
            return dataBloodOxygen.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataBloodOxygen dataBloodOxygen) {
        return dataBloodOxygen.getId() != null;
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
    public final Long updateKeyAfterInsert(DataBloodOxygen dataBloodOxygen, long j4) {
        dataBloodOxygen.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataBloodOxygen dataBloodOxygen) {
        databaseStatement.clearBindings();
        Long id2 = dataBloodOxygen.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataBloodOxygen.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataBloodOxygen.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String timestamp = dataBloodOxygen.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(4, timestamp);
        }
        String date = dataBloodOxygen.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        String items = dataBloodOxygen.getItems();
        if (items != null) {
            databaseStatement.bindString(6, items);
        }
        databaseStatement.bindLong(7, dataBloodOxygen.getAvgBo());
        databaseStatement.bindLong(8, dataBloodOxygen.getMaxBo());
        databaseStatement.bindLong(9, dataBloodOxygen.getMinBo());
        databaseStatement.bindLong(10, dataBloodOxygen.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataBloodOxygen readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        int i14 = i3 + 5;
        return new DataBloodOxygen(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.isNull(i14) ? null : cursor.getString(i14), cursor.getInt(i3 + 6), cursor.getInt(i3 + 7), cursor.getInt(i3 + 8), cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataBloodOxygen dataBloodOxygen, int i3) {
        dataBloodOxygen.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataBloodOxygen.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataBloodOxygen.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataBloodOxygen.setTimestamp(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataBloodOxygen.setDate(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i3 + 5;
        dataBloodOxygen.setItems(cursor.isNull(i14) ? null : cursor.getString(i14));
        dataBloodOxygen.setAvgBo(cursor.getInt(i3 + 6));
        dataBloodOxygen.setMaxBo(cursor.getInt(i3 + 7));
        dataBloodOxygen.setMinBo(cursor.getInt(i3 + 8));
        dataBloodOxygen.setIsUpdate(cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataBloodOxygen dataBloodOxygen) {
        sQLiteStatement.clearBindings();
        Long id2 = dataBloodOxygen.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataBloodOxygen.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataBloodOxygen.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String timestamp = dataBloodOxygen.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(4, timestamp);
        }
        String date = dataBloodOxygen.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        String items = dataBloodOxygen.getItems();
        if (items != null) {
            sQLiteStatement.bindString(6, items);
        }
        sQLiteStatement.bindLong(7, dataBloodOxygen.getAvgBo());
        sQLiteStatement.bindLong(8, dataBloodOxygen.getMaxBo());
        sQLiteStatement.bindLong(9, dataBloodOxygen.getMinBo());
        sQLiteStatement.bindLong(10, dataBloodOxygen.getIsUpdate() ? 1L : 0L);
    }
}
