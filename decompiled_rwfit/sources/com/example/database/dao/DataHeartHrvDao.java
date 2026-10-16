package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataHeartHrv;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataHeartHrvDao extends AbstractDao<DataHeartHrv, Long> {
    public static final String TABLENAME = "t_data_hrv";

    public static class Properties {
        public static final Property AvgHr;
        public static final Property IsUpdate;
        public static final Property MaxHr;
        public static final Property MinHr;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, String.class, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property Items = new Property(5, String.class, "items", false, "items");

        static {
            Class cls = Integer.TYPE;
            AvgHr = new Property(6, cls, "avgHr", false, "avg_hr");
            MaxHr = new Property(7, cls, "maxHr", false, "max_hr");
            MinHr = new Property(8, cls, "minHr", false, "min_hr");
            IsUpdate = new Property(9, Boolean.TYPE, "isUpdate", false, "is_update");
        }
    }

    public DataHeartHrvDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_hrv\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" TEXT,\"date\" TEXT,\"items\" TEXT,\"avg_hr\" INTEGER NOT NULL ,\"max_hr\" INTEGER NOT NULL ,\"min_hr\" INTEGER NOT NULL ,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_hrv_user_id_DESC_date_DESC_mac_DESC ON \"t_data_hrv\" (\"user_id\" DESC,\"date\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_hrv\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataHeartHrvDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataHeartHrv dataHeartHrv) {
        if (dataHeartHrv != null) {
            return dataHeartHrv.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataHeartHrv dataHeartHrv) {
        return dataHeartHrv.getId() != null;
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
    public final Long updateKeyAfterInsert(DataHeartHrv dataHeartHrv, long j4) {
        dataHeartHrv.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataHeartHrv dataHeartHrv) {
        databaseStatement.clearBindings();
        Long id2 = dataHeartHrv.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataHeartHrv.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataHeartHrv.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String timestamp = dataHeartHrv.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(4, timestamp);
        }
        String date = dataHeartHrv.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        String items = dataHeartHrv.getItems();
        if (items != null) {
            databaseStatement.bindString(6, items);
        }
        databaseStatement.bindLong(7, dataHeartHrv.getAvgHr());
        databaseStatement.bindLong(8, dataHeartHrv.getMaxHr());
        databaseStatement.bindLong(9, dataHeartHrv.getMinHr());
        databaseStatement.bindLong(10, dataHeartHrv.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataHeartHrv readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        int i14 = i3 + 5;
        return new DataHeartHrv(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.isNull(i14) ? null : cursor.getString(i14), cursor.getInt(i3 + 6), cursor.getInt(i3 + 7), cursor.getInt(i3 + 8), cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataHeartHrv dataHeartHrv, int i3) {
        dataHeartHrv.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataHeartHrv.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataHeartHrv.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataHeartHrv.setTimestamp(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataHeartHrv.setDate(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i3 + 5;
        dataHeartHrv.setItems(cursor.isNull(i14) ? null : cursor.getString(i14));
        dataHeartHrv.setAvgHr(cursor.getInt(i3 + 6));
        dataHeartHrv.setMaxHr(cursor.getInt(i3 + 7));
        dataHeartHrv.setMinHr(cursor.getInt(i3 + 8));
        dataHeartHrv.setIsUpdate(cursor.getShort(i3 + 9) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataHeartHrv dataHeartHrv) {
        sQLiteStatement.clearBindings();
        Long id2 = dataHeartHrv.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataHeartHrv.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataHeartHrv.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String timestamp = dataHeartHrv.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(4, timestamp);
        }
        String date = dataHeartHrv.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        String items = dataHeartHrv.getItems();
        if (items != null) {
            sQLiteStatement.bindString(6, items);
        }
        sQLiteStatement.bindLong(7, dataHeartHrv.getAvgHr());
        sQLiteStatement.bindLong(8, dataHeartHrv.getMaxHr());
        sQLiteStatement.bindLong(9, dataHeartHrv.getMinHr());
        sQLiteStatement.bindLong(10, dataHeartHrv.getIsUpdate() ? 1L : 0L);
    }
}
