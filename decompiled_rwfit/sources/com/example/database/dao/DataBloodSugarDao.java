package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataBloodSugar;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataBloodSugarDao extends AbstractDao<DataBloodSugar, Long> {
    public static final String TABLENAME = "t_data_sugar";

    public static class Properties {
        public static final Property AvgSugar;
        public static final Property IsUpdate;
        public static final Property MaxSugar;
        public static final Property MinSugar;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, String.class, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property Items = new Property(5, String.class, "items", false, "items");

        static {
            Class cls = Float.TYPE;
            AvgSugar = new Property(6, cls, "avgSugar", false, "avg_sugar");
            MaxSugar = new Property(7, cls, "maxSugar", false, "max_sugar");
            MinSugar = new Property(8, cls, "minSugar", false, "min_sugar");
            IsUpdate = new Property(9, Boolean.TYPE, "isUpdate", false, "is_update");
        }
    }

    public DataBloodSugarDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_sugar\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" TEXT,\"date\" TEXT,\"items\" TEXT,\"avg_sugar\" REAL NOT NULL ,\"max_sugar\" REAL NOT NULL ,\"min_sugar\" REAL NOT NULL ,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_sugar_user_id_DESC_date_DESC_mac_DESC ON \"t_data_sugar\" (\"user_id\" DESC,\"date\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_sugar\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataBloodSugarDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataBloodSugar dataBloodSugar) {
        if (dataBloodSugar != null) {
            return dataBloodSugar.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataBloodSugar dataBloodSugar) {
        return dataBloodSugar.getId() != null;
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
    public final Long updateKeyAfterInsert(DataBloodSugar dataBloodSugar, long j4) {
        dataBloodSugar.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataBloodSugar dataBloodSugar) {
        databaseStatement.clearBindings();
        Long id2 = dataBloodSugar.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataBloodSugar.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataBloodSugar.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String timestamp = dataBloodSugar.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(4, timestamp);
        }
        String date = dataBloodSugar.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        String items = dataBloodSugar.getItems();
        if (items != null) {
            databaseStatement.bindString(6, items);
        }
        databaseStatement.bindDouble(7, dataBloodSugar.getAvgSugar());
        databaseStatement.bindDouble(8, dataBloodSugar.getMaxSugar());
        databaseStatement.bindDouble(9, dataBloodSugar.getMinSugar());
        databaseStatement.bindLong(10, dataBloodSugar.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataBloodSugar readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        int i14 = i3 + 5;
        return new DataBloodSugar(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.isNull(i14) ? null : cursor.getString(i14), cursor.getFloat(i3 + 6), cursor.getFloat(i3 + 7), cursor.getFloat(i3 + 8), cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataBloodSugar dataBloodSugar, int i3) {
        dataBloodSugar.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataBloodSugar.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataBloodSugar.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataBloodSugar.setTimestamp(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataBloodSugar.setDate(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i3 + 5;
        dataBloodSugar.setItems(cursor.isNull(i14) ? null : cursor.getString(i14));
        dataBloodSugar.setAvgSugar(cursor.getFloat(i3 + 6));
        dataBloodSugar.setMaxSugar(cursor.getFloat(i3 + 7));
        dataBloodSugar.setMinSugar(cursor.getFloat(i3 + 8));
        dataBloodSugar.setIsUpdate(cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataBloodSugar dataBloodSugar) {
        sQLiteStatement.clearBindings();
        Long id2 = dataBloodSugar.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataBloodSugar.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataBloodSugar.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String timestamp = dataBloodSugar.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(4, timestamp);
        }
        String date = dataBloodSugar.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        String items = dataBloodSugar.getItems();
        if (items != null) {
            sQLiteStatement.bindString(6, items);
        }
        sQLiteStatement.bindDouble(7, dataBloodSugar.getAvgSugar());
        sQLiteStatement.bindDouble(8, dataBloodSugar.getMaxSugar());
        sQLiteStatement.bindDouble(9, dataBloodSugar.getMinSugar());
        sQLiteStatement.bindLong(10, dataBloodSugar.getIsUpdate() ? 1L : 0L);
    }
}
