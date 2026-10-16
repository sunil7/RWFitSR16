package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataSetting;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataSettingDao extends AbstractDao<DataSetting, Long> {
    public static final String TABLENAME = "t_data_setting";

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property DataKey = new Property(3, String.class, "dataKey", false, "data_key");
        public static final Property DataValue = new Property(4, String.class, "dataValue", false, "data_value");
    }

    public DataSettingDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_setting\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"data_key\" TEXT,\"data_value\" TEXT);");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_setting_user_id_DESC_mac_DESC_data_key_DESC ON \"t_data_setting\" (\"user_id\" DESC,\"mac\" DESC,\"data_key\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_setting\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataSettingDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataSetting dataSetting) {
        if (dataSetting != null) {
            return dataSetting.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataSetting dataSetting) {
        return dataSetting.getId() != null;
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
    public final Long updateKeyAfterInsert(DataSetting dataSetting, long j4) {
        dataSetting.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataSetting dataSetting) {
        databaseStatement.clearBindings();
        Long id2 = dataSetting.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataSetting.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataSetting.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String dataKey = dataSetting.getDataKey();
        if (dataKey != null) {
            databaseStatement.bindString(4, dataKey);
        }
        String dataValue = dataSetting.getDataValue();
        if (dataValue != null) {
            databaseStatement.bindString(5, dataValue);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataSetting readEntity(Cursor cursor, int i3) {
        Long valueOf = cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3));
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        return new DataSetting(valueOf, cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataSetting dataSetting, int i3) {
        dataSetting.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataSetting.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataSetting.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataSetting.setDataKey(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataSetting.setDataValue(cursor.isNull(i13) ? null : cursor.getString(i13));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataSetting dataSetting) {
        sQLiteStatement.clearBindings();
        Long id2 = dataSetting.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataSetting.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataSetting.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String dataKey = dataSetting.getDataKey();
        if (dataKey != null) {
            sQLiteStatement.bindString(4, dataKey);
        }
        String dataValue = dataSetting.getDataValue();
        if (dataValue != null) {
            sQLiteStatement.bindString(5, dataValue);
        }
    }
}
