package com.example.database.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.media.session.e;
import android.util.Log;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* loaded from: classes.dex */
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 12;

    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String str) {
            super(context, str);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onUpgrade(Database database, int i3, int i10) {
            Log.i("greenDAO", e.g(i3, "Upgrading schema from version ", i10, " to ", " by dropping all tables"));
            DaoMaster.dropAllTables(database, true);
            onCreate(database);
        }

        public DevOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }
    }

    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String str) {
            super(context, str, 12);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onCreate(Database database) {
            Log.i("greenDAO", "Creating tables for schema version 12");
            DaoMaster.createAllTables(database, false);
        }

        public OpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 12);
        }
    }

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        this(new StandardDatabase(sQLiteDatabase));
    }

    public static void createAllTables(Database database, boolean z5) {
        DataBloodOxygenDao.createTable(database, z5);
        DataBloodPressDao.createTable(database, z5);
        DataBloodSugarDao.createTable(database, z5);
        DataBodyTempDao.createTable(database, z5);
        DataBreatheDao.createTable(database, z5);
        DataHeartHrvDao.createTable(database, z5);
        DataHeartRateDao.createTable(database, z5);
        DataMuslimCountDao.createTable(database, z5);
        DataPressureDao.createTable(database, z5);
        DataQrCodeDao.createTable(database, z5);
        DataSettingDao.createTable(database, z5);
        DataSleepDao.createTable(database, z5);
        DataSportDao.createTable(database, z5);
        DataStepDao.createTable(database, z5);
        DevicesDao.createTable(database, z5);
        RawDataSleepDao.createTable(database, z5);
        RawDataStepDao.createTable(database, z5);
        UserDao.createTable(database, z5);
    }

    public static void dropAllTables(Database database, boolean z5) {
        DataBloodOxygenDao.dropTable(database, z5);
        DataBloodPressDao.dropTable(database, z5);
        DataBloodSugarDao.dropTable(database, z5);
        DataBodyTempDao.dropTable(database, z5);
        DataBreatheDao.dropTable(database, z5);
        DataHeartHrvDao.dropTable(database, z5);
        DataHeartRateDao.dropTable(database, z5);
        DataMuslimCountDao.dropTable(database, z5);
        DataPressureDao.dropTable(database, z5);
        DataQrCodeDao.dropTable(database, z5);
        DataSettingDao.dropTable(database, z5);
        DataSleepDao.dropTable(database, z5);
        DataSportDao.dropTable(database, z5);
        DataStepDao.dropTable(database, z5);
        DevicesDao.dropTable(database, z5);
        RawDataSleepDao.dropTable(database, z5);
        RawDataStepDao.dropTable(database, z5);
        UserDao.dropTable(database, z5);
    }

    public static DaoSession newDevSession(Context context, String str) {
        return new DaoMaster(new DevOpenHelper(context, str).getWritableDb()).newSession();
    }

    public DaoMaster(Database database) {
        super(database, 12);
        registerDaoClass(DataBloodOxygenDao.class);
        registerDaoClass(DataBloodPressDao.class);
        registerDaoClass(DataBloodSugarDao.class);
        registerDaoClass(DataBodyTempDao.class);
        registerDaoClass(DataBreatheDao.class);
        registerDaoClass(DataHeartHrvDao.class);
        registerDaoClass(DataHeartRateDao.class);
        registerDaoClass(DataMuslimCountDao.class);
        registerDaoClass(DataPressureDao.class);
        registerDaoClass(DataQrCodeDao.class);
        registerDaoClass(DataSettingDao.class);
        registerDaoClass(DataSleepDao.class);
        registerDaoClass(DataSportDao.class);
        registerDaoClass(DataStepDao.class);
        registerDaoClass(DevicesDao.class);
        registerDaoClass(RawDataSleepDao.class);
        registerDaoClass(RawDataStepDao.class);
        registerDaoClass(UserDao.class);
    }

    @Override // org.greenrobot.greendao.AbstractDaoMaster
    public DaoSession newSession() {
        return new DaoSession(this.f16957db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // org.greenrobot.greendao.AbstractDaoMaster
    public DaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.f16957db, identityScopeType, this.daoConfigMap);
    }
}
