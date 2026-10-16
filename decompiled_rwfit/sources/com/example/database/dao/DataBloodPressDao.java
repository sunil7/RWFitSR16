package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataBloodPress;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataBloodPressDao extends AbstractDao<DataBloodPress, Long> {
    public static final String TABLENAME = "t_data_bp";

    public static class Properties {
        public static final Property AvgDp;
        public static final Property AvgSp;
        public static final Property IsUpdate;
        public static final Property MaxDp;
        public static final Property MaxSp;
        public static final Property MinDp;
        public static final Property MinSp;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, String.class, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property Items = new Property(5, String.class, "items", false, "items");

        static {
            Class cls = Integer.TYPE;
            AvgSp = new Property(6, cls, "avgSp", false, "avg_sp");
            AvgDp = new Property(7, cls, "avgDp", false, "avg_dp");
            MaxSp = new Property(8, cls, "maxSp", false, "max_sp");
            MinSp = new Property(9, cls, "minSp", false, "min_sp");
            MaxDp = new Property(10, cls, "maxDp", false, "max_dp");
            MinDp = new Property(11, cls, "minDp", false, "min_dp");
            IsUpdate = new Property(12, Boolean.TYPE, "isUpdate", false, "is_update");
        }
    }

    public DataBloodPressDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_bp\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" TEXT,\"date\" TEXT,\"items\" TEXT,\"avg_sp\" INTEGER NOT NULL ,\"avg_dp\" INTEGER NOT NULL ,\"max_sp\" INTEGER NOT NULL ,\"min_sp\" INTEGER NOT NULL ,\"max_dp\" INTEGER NOT NULL ,\"min_dp\" INTEGER NOT NULL ,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_bp_user_id_DESC_date_DESC_mac_DESC ON \"t_data_bp\" (\"user_id\" DESC,\"date\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_bp\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataBloodPressDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataBloodPress dataBloodPress) {
        if (dataBloodPress != null) {
            return dataBloodPress.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataBloodPress dataBloodPress) {
        return dataBloodPress.getId() != null;
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
    public final Long updateKeyAfterInsert(DataBloodPress dataBloodPress, long j4) {
        dataBloodPress.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataBloodPress dataBloodPress) {
        databaseStatement.clearBindings();
        Long id2 = dataBloodPress.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataBloodPress.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataBloodPress.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String timestamp = dataBloodPress.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(4, timestamp);
        }
        String date = dataBloodPress.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        String items = dataBloodPress.getItems();
        if (items != null) {
            databaseStatement.bindString(6, items);
        }
        databaseStatement.bindLong(7, dataBloodPress.getAvgSp());
        databaseStatement.bindLong(8, dataBloodPress.getAvgDp());
        databaseStatement.bindLong(9, dataBloodPress.getMaxSp());
        databaseStatement.bindLong(10, dataBloodPress.getMinSp());
        databaseStatement.bindLong(11, dataBloodPress.getMaxDp());
        databaseStatement.bindLong(12, dataBloodPress.getMinDp());
        databaseStatement.bindLong(13, dataBloodPress.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataBloodPress readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        int i14 = i3 + 5;
        return new DataBloodPress(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.isNull(i14) ? null : cursor.getString(i14), cursor.getInt(i3 + 6), cursor.getInt(i3 + 7), cursor.getInt(i3 + 8), cursor.getInt(i3 + 9), cursor.getInt(i3 + 10), cursor.getInt(i3 + 11), cursor.getShort(i3 + 12) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataBloodPress dataBloodPress, int i3) {
        dataBloodPress.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataBloodPress.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataBloodPress.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataBloodPress.setTimestamp(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataBloodPress.setDate(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i3 + 5;
        dataBloodPress.setItems(cursor.isNull(i14) ? null : cursor.getString(i14));
        dataBloodPress.setAvgSp(cursor.getInt(i3 + 6));
        dataBloodPress.setAvgDp(cursor.getInt(i3 + 7));
        dataBloodPress.setMaxSp(cursor.getInt(i3 + 8));
        dataBloodPress.setMinSp(cursor.getInt(i3 + 9));
        dataBloodPress.setMaxDp(cursor.getInt(i3 + 10));
        dataBloodPress.setMinDp(cursor.getInt(i3 + 11));
        dataBloodPress.setIsUpdate(cursor.getShort(i3 + 12) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataBloodPress dataBloodPress) {
        sQLiteStatement.clearBindings();
        Long id2 = dataBloodPress.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataBloodPress.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataBloodPress.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String timestamp = dataBloodPress.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(4, timestamp);
        }
        String date = dataBloodPress.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        String items = dataBloodPress.getItems();
        if (items != null) {
            sQLiteStatement.bindString(6, items);
        }
        sQLiteStatement.bindLong(7, dataBloodPress.getAvgSp());
        sQLiteStatement.bindLong(8, dataBloodPress.getAvgDp());
        sQLiteStatement.bindLong(9, dataBloodPress.getMaxSp());
        sQLiteStatement.bindLong(10, dataBloodPress.getMinSp());
        sQLiteStatement.bindLong(11, dataBloodPress.getMaxDp());
        sQLiteStatement.bindLong(12, dataBloodPress.getMinDp());
        sQLiteStatement.bindLong(13, dataBloodPress.getIsUpdate() ? 1L : 0L);
    }
}
