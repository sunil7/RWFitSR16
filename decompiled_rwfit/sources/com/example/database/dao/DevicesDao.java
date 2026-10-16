package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.example.database.table.Devices;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DevicesDao extends AbstractDao<Devices, Long> {
    public static final String TABLENAME = "t_device";

    public static class Properties {
        public static final Property CreateTime;
        public static final Property DeviceClass;
        public static final Property DeviceFlag;
        public static final Property DeviceModel;
        public static final Property DeviceUuid;
        public static final Property DeviceVer;
        public static final Property Status;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property UserId = new Property(1, String.class, "userId", false, "user_id");
        public static final Property MacAddress = new Property(2, String.class, "macAddress", false, "mac_addr");
        public static final Property Name = new Property(3, String.class, "name", false, "name");

        static {
            Class cls = Integer.TYPE;
            DeviceClass = new Property(4, cls, "deviceClass", false, "device_class");
            DeviceUuid = new Property(5, String.class, "deviceUuid", false, "device_uuid");
            DeviceVer = new Property(6, String.class, "deviceVer", false, "device_ver");
            Status = new Property(7, cls, FileDownloadModel.STATUS, false, FileDownloadModel.STATUS);
            CreateTime = new Property(8, String.class, "createTime", false, "create_time");
            DeviceModel = new Property(9, String.class, "deviceModel", false, "device_model");
            DeviceFlag = new Property(10, String.class, "deviceFlag", false, "device_flag");
        }
    }

    public DevicesDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_device\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"user_id\" TEXT NOT NULL ,\"mac_addr\" TEXT NOT NULL ,\"name\" TEXT NOT NULL ,\"device_class\" INTEGER NOT NULL ,\"device_uuid\" TEXT NOT NULL ,\"device_ver\" TEXT,\"status\" INTEGER NOT NULL ,\"create_time\" TEXT,\"device_model\" TEXT,\"device_flag\" TEXT);");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_device_user_id_DESC_mac_addr_DESC ON \"t_device\" (\"user_id\" DESC,\"mac_addr\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_device\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DevicesDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(Devices devices) {
        if (devices != null) {
            return devices.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(Devices devices) {
        return devices.getId() != null;
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
    public final Long updateKeyAfterInsert(Devices devices, long j4) {
        devices.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, Devices devices) {
        databaseStatement.clearBindings();
        Long id2 = devices.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        databaseStatement.bindString(2, devices.getUserId());
        databaseStatement.bindString(3, devices.getMacAddress());
        databaseStatement.bindString(4, devices.getName());
        databaseStatement.bindLong(5, devices.getDeviceClass());
        databaseStatement.bindString(6, devices.getDeviceUuid());
        String deviceVer = devices.getDeviceVer();
        if (deviceVer != null) {
            databaseStatement.bindString(7, deviceVer);
        }
        databaseStatement.bindLong(8, devices.getStatus());
        String createTime = devices.getCreateTime();
        if (createTime != null) {
            databaseStatement.bindString(9, createTime);
        }
        String deviceModel = devices.getDeviceModel();
        if (deviceModel != null) {
            databaseStatement.bindString(10, deviceModel);
        }
        String deviceFlag = devices.getDeviceFlag();
        if (deviceFlag != null) {
            databaseStatement.bindString(11, deviceFlag);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public Devices readEntity(Cursor cursor, int i3) {
        int i10 = i3 + 6;
        int i11 = i3 + 8;
        int i12 = i3 + 9;
        int i13 = i3 + 10;
        return new Devices(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)), cursor.getString(i3 + 1), cursor.getString(i3 + 2), cursor.getString(i3 + 3), cursor.getInt(i3 + 4), cursor.getString(i3 + 5), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.getInt(i3 + 7), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, Devices devices, int i3) {
        devices.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        devices.setUserId(cursor.getString(i3 + 1));
        devices.setMacAddress(cursor.getString(i3 + 2));
        devices.setName(cursor.getString(i3 + 3));
        devices.setDeviceClass(cursor.getInt(i3 + 4));
        devices.setDeviceUuid(cursor.getString(i3 + 5));
        int i10 = i3 + 6;
        devices.setDeviceVer(cursor.isNull(i10) ? null : cursor.getString(i10));
        devices.setStatus(cursor.getInt(i3 + 7));
        int i11 = i3 + 8;
        devices.setCreateTime(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 9;
        devices.setDeviceModel(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 10;
        devices.setDeviceFlag(cursor.isNull(i13) ? null : cursor.getString(i13));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, Devices devices) {
        sQLiteStatement.clearBindings();
        Long id2 = devices.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        sQLiteStatement.bindString(2, devices.getUserId());
        sQLiteStatement.bindString(3, devices.getMacAddress());
        sQLiteStatement.bindString(4, devices.getName());
        sQLiteStatement.bindLong(5, devices.getDeviceClass());
        sQLiteStatement.bindString(6, devices.getDeviceUuid());
        String deviceVer = devices.getDeviceVer();
        if (deviceVer != null) {
            sQLiteStatement.bindString(7, deviceVer);
        }
        sQLiteStatement.bindLong(8, devices.getStatus());
        String createTime = devices.getCreateTime();
        if (createTime != null) {
            sQLiteStatement.bindString(9, createTime);
        }
        String deviceModel = devices.getDeviceModel();
        if (deviceModel != null) {
            sQLiteStatement.bindString(10, deviceModel);
        }
        String deviceFlag = devices.getDeviceFlag();
        if (deviceFlag != null) {
            sQLiteStatement.bindString(11, deviceFlag);
        }
    }
}
