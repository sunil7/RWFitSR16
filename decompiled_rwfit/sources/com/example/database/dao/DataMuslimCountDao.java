package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataMuslimCount;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataMuslimCountDao extends AbstractDao<DataMuslimCount, Long> {
    public static final String TABLENAME = "t_data_muslimcount";

    public static class Properties {
        public static final Property AvgCount;
        public static final Property IsUpdate;
        public static final Property MaxCount;
        public static final Property MinCount;
        public static final Property TotalCount;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, String.class, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property Items = new Property(5, String.class, "items", false, "items");

        static {
            Class cls = Integer.TYPE;
            AvgCount = new Property(6, cls, "avgCount", false, "avg_count");
            MaxCount = new Property(7, cls, "maxCount", false, "max_count");
            MinCount = new Property(8, cls, "minCount", false, "min_count");
            TotalCount = new Property(9, cls, "totalCount", false, "total_count");
            IsUpdate = new Property(10, Boolean.TYPE, "isUpdate", false, "is_update");
        }
    }

    public DataMuslimCountDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_muslimcount\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" TEXT,\"date\" TEXT,\"items\" TEXT,\"avg_count\" INTEGER NOT NULL ,\"max_count\" INTEGER NOT NULL ,\"min_count\" INTEGER NOT NULL ,\"total_count\" INTEGER NOT NULL ,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_muslimcount_user_id_DESC_date_DESC_mac_DESC ON \"t_data_muslimcount\" (\"user_id\" DESC,\"date\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_muslimcount\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataMuslimCountDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataMuslimCount dataMuslimCount) {
        if (dataMuslimCount != null) {
            return dataMuslimCount.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataMuslimCount dataMuslimCount) {
        return dataMuslimCount.getId() != null;
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
    public final Long updateKeyAfterInsert(DataMuslimCount dataMuslimCount, long j4) {
        dataMuslimCount.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataMuslimCount dataMuslimCount) {
        databaseStatement.clearBindings();
        Long id2 = dataMuslimCount.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataMuslimCount.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataMuslimCount.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String timestamp = dataMuslimCount.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(4, timestamp);
        }
        String date = dataMuslimCount.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        String items = dataMuslimCount.getItems();
        if (items != null) {
            databaseStatement.bindString(6, items);
        }
        databaseStatement.bindLong(7, dataMuslimCount.getAvgCount());
        databaseStatement.bindLong(8, dataMuslimCount.getMaxCount());
        databaseStatement.bindLong(9, dataMuslimCount.getMinCount());
        databaseStatement.bindLong(10, dataMuslimCount.getTotalCount());
        databaseStatement.bindLong(11, dataMuslimCount.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataMuslimCount readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        int i14 = i3 + 5;
        return new DataMuslimCount(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.isNull(i14) ? null : cursor.getString(i14), cursor.getInt(i3 + 6), cursor.getInt(i3 + 7), cursor.getInt(i3 + 8), cursor.getInt(i3 + 9), cursor.getShort(i3 + 10) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataMuslimCount dataMuslimCount, int i3) {
        dataMuslimCount.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataMuslimCount.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataMuslimCount.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataMuslimCount.setTimestamp(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataMuslimCount.setDate(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i3 + 5;
        dataMuslimCount.setItems(cursor.isNull(i14) ? null : cursor.getString(i14));
        dataMuslimCount.setAvgCount(cursor.getInt(i3 + 6));
        dataMuslimCount.setMaxCount(cursor.getInt(i3 + 7));
        dataMuslimCount.setMinCount(cursor.getInt(i3 + 8));
        dataMuslimCount.setTotalCount(cursor.getInt(i3 + 9));
        dataMuslimCount.setIsUpdate(cursor.getShort(i3 + 10) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataMuslimCount dataMuslimCount) {
        sQLiteStatement.clearBindings();
        Long id2 = dataMuslimCount.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataMuslimCount.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataMuslimCount.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String timestamp = dataMuslimCount.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(4, timestamp);
        }
        String date = dataMuslimCount.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        String items = dataMuslimCount.getItems();
        if (items != null) {
            sQLiteStatement.bindString(6, items);
        }
        sQLiteStatement.bindLong(7, dataMuslimCount.getAvgCount());
        sQLiteStatement.bindLong(8, dataMuslimCount.getMaxCount());
        sQLiteStatement.bindLong(9, dataMuslimCount.getMinCount());
        sQLiteStatement.bindLong(10, dataMuslimCount.getTotalCount());
        sQLiteStatement.bindLong(11, dataMuslimCount.getIsUpdate() ? 1L : 0L);
    }
}
