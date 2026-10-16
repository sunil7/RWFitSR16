package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataBreathe;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataBreatheDao extends AbstractDao<DataBreathe, Long> {
    public static final String TABLENAME = "t_data_breathe";

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, String.class, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");
        public static final Property Items = new Property(5, String.class, "items", false, "items");
        public static final Property TotalTime = new Property(6, Integer.class, "totalTime", false, "total_time");
        public static final Property IsUpdate = new Property(7, Boolean.TYPE, "isUpdate", false, "is_update");
    }

    public DataBreatheDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_breathe\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" TEXT,\"date\" TEXT,\"items\" TEXT,\"total_time\" INTEGER,\"is_update\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_breathe_user_id_DESC_date_DESC_mac_DESC ON \"t_data_breathe\" (\"user_id\" DESC,\"date\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_breathe\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataBreatheDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataBreathe dataBreathe) {
        if (dataBreathe != null) {
            return dataBreathe.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataBreathe dataBreathe) {
        return dataBreathe.getId() != null;
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
    public final Long updateKeyAfterInsert(DataBreathe dataBreathe, long j4) {
        dataBreathe.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataBreathe dataBreathe) {
        databaseStatement.clearBindings();
        Long id2 = dataBreathe.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataBreathe.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataBreathe.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String timestamp = dataBreathe.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(4, timestamp);
        }
        String date = dataBreathe.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        String items = dataBreathe.getItems();
        if (items != null) {
            databaseStatement.bindString(6, items);
        }
        if (dataBreathe.getTotalTime() != null) {
            databaseStatement.bindLong(7, r0.intValue());
        }
        databaseStatement.bindLong(8, dataBreathe.getIsUpdate() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataBreathe readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        int i14 = i3 + 5;
        int i15 = i3 + 6;
        return new DataBreathe(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.isNull(i14) ? null : cursor.getString(i14), cursor.isNull(i15) ? null : Integer.valueOf(cursor.getInt(i15)), cursor.getShort(i3 + 7) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataBreathe dataBreathe, int i3) {
        dataBreathe.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataBreathe.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataBreathe.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataBreathe.setTimestamp(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataBreathe.setDate(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i3 + 5;
        dataBreathe.setItems(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i3 + 6;
        dataBreathe.setTotalTime(cursor.isNull(i15) ? null : Integer.valueOf(cursor.getInt(i15)));
        dataBreathe.setIsUpdate(cursor.getShort(i3 + 7) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataBreathe dataBreathe) {
        sQLiteStatement.clearBindings();
        Long id2 = dataBreathe.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataBreathe.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataBreathe.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String timestamp = dataBreathe.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(4, timestamp);
        }
        String date = dataBreathe.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        String items = dataBreathe.getItems();
        if (items != null) {
            sQLiteStatement.bindString(6, items);
        }
        if (dataBreathe.getTotalTime() != null) {
            sQLiteStatement.bindLong(7, r0.intValue());
        }
        sQLiteStatement.bindLong(8, dataBreathe.getIsUpdate() ? 1L : 0L);
    }
}
