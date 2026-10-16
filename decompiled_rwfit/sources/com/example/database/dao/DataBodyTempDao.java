package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataBodyTemp;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataBodyTempDao extends AbstractDao<DataBodyTemp, Long> {
    public static final String TABLENAME = "t_data_bt";

    public static class Properties {
        public static final Property AvgTemp;
        public static final Property IsUpdate;
        public static final Property MaxTemp;
        public static final Property MinTemp;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, String.class, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property Items = new Property(5, String.class, "items", false, "items");

        static {
            Class cls = Float.TYPE;
            AvgTemp = new Property(6, cls, "avgTemp", false, "avg_temp");
            MaxTemp = new Property(7, cls, "maxTemp", false, "max_temp");
            MinTemp = new Property(8, cls, "minTemp", false, "min_temp");
            IsUpdate = new Property(9, Boolean.TYPE, "isUpdate", false, "is_update");
        }
    }

    public DataBodyTempDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_bt\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" TEXT,\"date\" TEXT,\"items\" TEXT,\"avg_temp\" REAL NOT NULL ,\"max_temp\" REAL NOT NULL ,\"min_temp\" REAL NOT NULL ,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_bt_user_id_DESC_date_DESC_mac_DESC ON \"t_data_bt\" (\"user_id\" DESC,\"date\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_bt\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataBodyTempDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataBodyTemp dataBodyTemp) {
        if (dataBodyTemp != null) {
            return dataBodyTemp.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataBodyTemp dataBodyTemp) {
        return dataBodyTemp.getId() != null;
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
    public final Long updateKeyAfterInsert(DataBodyTemp dataBodyTemp, long j4) {
        dataBodyTemp.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataBodyTemp dataBodyTemp) {
        databaseStatement.clearBindings();
        Long id2 = dataBodyTemp.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataBodyTemp.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataBodyTemp.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String timestamp = dataBodyTemp.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(4, timestamp);
        }
        String date = dataBodyTemp.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        String items = dataBodyTemp.getItems();
        if (items != null) {
            databaseStatement.bindString(6, items);
        }
        databaseStatement.bindDouble(7, dataBodyTemp.getAvgTemp());
        databaseStatement.bindDouble(8, dataBodyTemp.getMaxTemp());
        databaseStatement.bindDouble(9, dataBodyTemp.getMinTemp());
        databaseStatement.bindLong(10, dataBodyTemp.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataBodyTemp readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        int i14 = i3 + 5;
        return new DataBodyTemp(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.isNull(i14) ? null : cursor.getString(i14), cursor.getFloat(i3 + 6), cursor.getFloat(i3 + 7), cursor.getFloat(i3 + 8), cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataBodyTemp dataBodyTemp, int i3) {
        dataBodyTemp.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataBodyTemp.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataBodyTemp.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataBodyTemp.setTimestamp(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataBodyTemp.setDate(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i3 + 5;
        dataBodyTemp.setItems(cursor.isNull(i14) ? null : cursor.getString(i14));
        dataBodyTemp.setAvgTemp(cursor.getFloat(i3 + 6));
        dataBodyTemp.setMaxTemp(cursor.getFloat(i3 + 7));
        dataBodyTemp.setMinTemp(cursor.getFloat(i3 + 8));
        dataBodyTemp.setIsUpdate(cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataBodyTemp dataBodyTemp) {
        sQLiteStatement.clearBindings();
        Long id2 = dataBodyTemp.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataBodyTemp.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataBodyTemp.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String timestamp = dataBodyTemp.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(4, timestamp);
        }
        String date = dataBodyTemp.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        String items = dataBodyTemp.getItems();
        if (items != null) {
            sQLiteStatement.bindString(6, items);
        }
        sQLiteStatement.bindDouble(7, dataBodyTemp.getAvgTemp());
        sQLiteStatement.bindDouble(8, dataBodyTemp.getMaxTemp());
        sQLiteStatement.bindDouble(9, dataBodyTemp.getMinTemp());
        sQLiteStatement.bindLong(10, dataBodyTemp.getIsUpdate() ? 1L : 0L);
    }
}
