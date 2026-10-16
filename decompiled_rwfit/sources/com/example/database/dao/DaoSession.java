package com.example.database.dao;

import com.example.database.table.DataBloodOxygen;
import com.example.database.table.DataBloodPress;
import com.example.database.table.DataBloodSugar;
import com.example.database.table.DataBodyTemp;
import com.example.database.table.DataBreathe;
import com.example.database.table.DataHeartHrv;
import com.example.database.table.DataHeartRate;
import com.example.database.table.DataMuslimCount;
import com.example.database.table.DataPressure;
import com.example.database.table.DataQrCode;
import com.example.database.table.DataSetting;
import com.example.database.table.DataSleep;
import com.example.database.table.DataSport;
import com.example.database.table.DataStep;
import com.example.database.table.Devices;
import com.example.database.table.RawDataSleep;
import com.example.database.table.RawDataStep;
import com.example.database.table.User;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes.dex */
public class DaoSession extends AbstractDaoSession {
    private final DataBloodOxygenDao dataBloodOxygenDao;
    private final DaoConfig dataBloodOxygenDaoConfig;
    private final DataBloodPressDao dataBloodPressDao;
    private final DaoConfig dataBloodPressDaoConfig;
    private final DataBloodSugarDao dataBloodSugarDao;
    private final DaoConfig dataBloodSugarDaoConfig;
    private final DataBodyTempDao dataBodyTempDao;
    private final DaoConfig dataBodyTempDaoConfig;
    private final DataBreatheDao dataBreatheDao;
    private final DaoConfig dataBreatheDaoConfig;
    private final DataHeartHrvDao dataHeartHrvDao;
    private final DaoConfig dataHeartHrvDaoConfig;
    private final DataHeartRateDao dataHeartRateDao;
    private final DaoConfig dataHeartRateDaoConfig;
    private final DataMuslimCountDao dataMuslimCountDao;
    private final DaoConfig dataMuslimCountDaoConfig;
    private final DataPressureDao dataPressureDao;
    private final DaoConfig dataPressureDaoConfig;
    private final DataQrCodeDao dataQrCodeDao;
    private final DaoConfig dataQrCodeDaoConfig;
    private final DataSettingDao dataSettingDao;
    private final DaoConfig dataSettingDaoConfig;
    private final DataSleepDao dataSleepDao;
    private final DaoConfig dataSleepDaoConfig;
    private final DataSportDao dataSportDao;
    private final DaoConfig dataSportDaoConfig;
    private final DataStepDao dataStepDao;
    private final DaoConfig dataStepDaoConfig;
    private final DevicesDao devicesDao;
    private final DaoConfig devicesDaoConfig;
    private final RawDataSleepDao rawDataSleepDao;
    private final DaoConfig rawDataSleepDaoConfig;
    private final RawDataStepDao rawDataStepDao;
    private final DaoConfig rawDataStepDaoConfig;
    private final UserDao userDao;
    private final DaoConfig userDaoConfig;

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig clone = map.get(DataBloodOxygenDao.class).clone();
        this.dataBloodOxygenDaoConfig = clone;
        clone.initIdentityScope(identityScopeType);
        DaoConfig clone2 = map.get(DataBloodPressDao.class).clone();
        this.dataBloodPressDaoConfig = clone2;
        clone2.initIdentityScope(identityScopeType);
        DaoConfig clone3 = map.get(DataBloodSugarDao.class).clone();
        this.dataBloodSugarDaoConfig = clone3;
        clone3.initIdentityScope(identityScopeType);
        DaoConfig clone4 = map.get(DataBodyTempDao.class).clone();
        this.dataBodyTempDaoConfig = clone4;
        clone4.initIdentityScope(identityScopeType);
        DaoConfig clone5 = map.get(DataBreatheDao.class).clone();
        this.dataBreatheDaoConfig = clone5;
        clone5.initIdentityScope(identityScopeType);
        DaoConfig clone6 = map.get(DataHeartHrvDao.class).clone();
        this.dataHeartHrvDaoConfig = clone6;
        clone6.initIdentityScope(identityScopeType);
        DaoConfig clone7 = map.get(DataHeartRateDao.class).clone();
        this.dataHeartRateDaoConfig = clone7;
        clone7.initIdentityScope(identityScopeType);
        DaoConfig clone8 = map.get(DataMuslimCountDao.class).clone();
        this.dataMuslimCountDaoConfig = clone8;
        clone8.initIdentityScope(identityScopeType);
        DaoConfig clone9 = map.get(DataPressureDao.class).clone();
        this.dataPressureDaoConfig = clone9;
        clone9.initIdentityScope(identityScopeType);
        DaoConfig clone10 = map.get(DataQrCodeDao.class).clone();
        this.dataQrCodeDaoConfig = clone10;
        clone10.initIdentityScope(identityScopeType);
        DaoConfig clone11 = map.get(DataSettingDao.class).clone();
        this.dataSettingDaoConfig = clone11;
        clone11.initIdentityScope(identityScopeType);
        DaoConfig clone12 = map.get(DataSleepDao.class).clone();
        this.dataSleepDaoConfig = clone12;
        clone12.initIdentityScope(identityScopeType);
        DaoConfig clone13 = map.get(DataSportDao.class).clone();
        this.dataSportDaoConfig = clone13;
        clone13.initIdentityScope(identityScopeType);
        DaoConfig clone14 = map.get(DataStepDao.class).clone();
        this.dataStepDaoConfig = clone14;
        clone14.initIdentityScope(identityScopeType);
        DaoConfig clone15 = map.get(DevicesDao.class).clone();
        this.devicesDaoConfig = clone15;
        clone15.initIdentityScope(identityScopeType);
        DaoConfig clone16 = map.get(RawDataSleepDao.class).clone();
        this.rawDataSleepDaoConfig = clone16;
        clone16.initIdentityScope(identityScopeType);
        DaoConfig clone17 = map.get(RawDataStepDao.class).clone();
        this.rawDataStepDaoConfig = clone17;
        clone17.initIdentityScope(identityScopeType);
        DaoConfig clone18 = map.get(UserDao.class).clone();
        this.userDaoConfig = clone18;
        clone18.initIdentityScope(identityScopeType);
        DataBloodOxygenDao dataBloodOxygenDao = new DataBloodOxygenDao(clone, this);
        this.dataBloodOxygenDao = dataBloodOxygenDao;
        DataBloodPressDao dataBloodPressDao = new DataBloodPressDao(clone2, this);
        this.dataBloodPressDao = dataBloodPressDao;
        DataBloodSugarDao dataBloodSugarDao = new DataBloodSugarDao(clone3, this);
        this.dataBloodSugarDao = dataBloodSugarDao;
        DataBodyTempDao dataBodyTempDao = new DataBodyTempDao(clone4, this);
        this.dataBodyTempDao = dataBodyTempDao;
        DataBreatheDao dataBreatheDao = new DataBreatheDao(clone5, this);
        this.dataBreatheDao = dataBreatheDao;
        DataHeartHrvDao dataHeartHrvDao = new DataHeartHrvDao(clone6, this);
        this.dataHeartHrvDao = dataHeartHrvDao;
        DataHeartRateDao dataHeartRateDao = new DataHeartRateDao(clone7, this);
        this.dataHeartRateDao = dataHeartRateDao;
        DataMuslimCountDao dataMuslimCountDao = new DataMuslimCountDao(clone8, this);
        this.dataMuslimCountDao = dataMuslimCountDao;
        DataPressureDao dataPressureDao = new DataPressureDao(clone9, this);
        this.dataPressureDao = dataPressureDao;
        DataQrCodeDao dataQrCodeDao = new DataQrCodeDao(clone10, this);
        this.dataQrCodeDao = dataQrCodeDao;
        DataSettingDao dataSettingDao = new DataSettingDao(clone11, this);
        this.dataSettingDao = dataSettingDao;
        DataSleepDao dataSleepDao = new DataSleepDao(clone12, this);
        this.dataSleepDao = dataSleepDao;
        DataSportDao dataSportDao = new DataSportDao(clone13, this);
        this.dataSportDao = dataSportDao;
        DataStepDao dataStepDao = new DataStepDao(clone14, this);
        this.dataStepDao = dataStepDao;
        DevicesDao devicesDao = new DevicesDao(clone15, this);
        this.devicesDao = devicesDao;
        RawDataSleepDao rawDataSleepDao = new RawDataSleepDao(clone16, this);
        this.rawDataSleepDao = rawDataSleepDao;
        RawDataStepDao rawDataStepDao = new RawDataStepDao(clone17, this);
        this.rawDataStepDao = rawDataStepDao;
        UserDao userDao = new UserDao(clone18, this);
        this.userDao = userDao;
        registerDao(DataBloodOxygen.class, dataBloodOxygenDao);
        registerDao(DataBloodPress.class, dataBloodPressDao);
        registerDao(DataBloodSugar.class, dataBloodSugarDao);
        registerDao(DataBodyTemp.class, dataBodyTempDao);
        registerDao(DataBreathe.class, dataBreatheDao);
        registerDao(DataHeartHrv.class, dataHeartHrvDao);
        registerDao(DataHeartRate.class, dataHeartRateDao);
        registerDao(DataMuslimCount.class, dataMuslimCountDao);
        registerDao(DataPressure.class, dataPressureDao);
        registerDao(DataQrCode.class, dataQrCodeDao);
        registerDao(DataSetting.class, dataSettingDao);
        registerDao(DataSleep.class, dataSleepDao);
        registerDao(DataSport.class, dataSportDao);
        registerDao(DataStep.class, dataStepDao);
        registerDao(Devices.class, devicesDao);
        registerDao(RawDataSleep.class, rawDataSleepDao);
        registerDao(RawDataStep.class, rawDataStepDao);
        registerDao(User.class, userDao);
    }

    public void clear() {
        this.dataBloodOxygenDaoConfig.clearIdentityScope();
        this.dataBloodPressDaoConfig.clearIdentityScope();
        this.dataBloodSugarDaoConfig.clearIdentityScope();
        this.dataBodyTempDaoConfig.clearIdentityScope();
        this.dataBreatheDaoConfig.clearIdentityScope();
        this.dataHeartHrvDaoConfig.clearIdentityScope();
        this.dataHeartRateDaoConfig.clearIdentityScope();
        this.dataMuslimCountDaoConfig.clearIdentityScope();
        this.dataPressureDaoConfig.clearIdentityScope();
        this.dataQrCodeDaoConfig.clearIdentityScope();
        this.dataSettingDaoConfig.clearIdentityScope();
        this.dataSleepDaoConfig.clearIdentityScope();
        this.dataSportDaoConfig.clearIdentityScope();
        this.dataStepDaoConfig.clearIdentityScope();
        this.devicesDaoConfig.clearIdentityScope();
        this.rawDataSleepDaoConfig.clearIdentityScope();
        this.rawDataStepDaoConfig.clearIdentityScope();
        this.userDaoConfig.clearIdentityScope();
    }

    public DataBloodOxygenDao getDataBloodOxygenDao() {
        return this.dataBloodOxygenDao;
    }

    public DataBloodPressDao getDataBloodPressDao() {
        return this.dataBloodPressDao;
    }

    public DataBloodSugarDao getDataBloodSugarDao() {
        return this.dataBloodSugarDao;
    }

    public DataBodyTempDao getDataBodyTempDao() {
        return this.dataBodyTempDao;
    }

    public DataBreatheDao getDataBreatheDao() {
        return this.dataBreatheDao;
    }

    public DataHeartHrvDao getDataHeartHrvDao() {
        return this.dataHeartHrvDao;
    }

    public DataHeartRateDao getDataHeartRateDao() {
        return this.dataHeartRateDao;
    }

    public DataMuslimCountDao getDataMuslimCountDao() {
        return this.dataMuslimCountDao;
    }

    public DataPressureDao getDataPressureDao() {
        return this.dataPressureDao;
    }

    public DataQrCodeDao getDataQrCodeDao() {
        return this.dataQrCodeDao;
    }

    public DataSettingDao getDataSettingDao() {
        return this.dataSettingDao;
    }

    public DataSleepDao getDataSleepDao() {
        return this.dataSleepDao;
    }

    public DataSportDao getDataSportDao() {
        return this.dataSportDao;
    }

    public DataStepDao getDataStepDao() {
        return this.dataStepDao;
    }

    public DevicesDao getDevicesDao() {
        return this.devicesDao;
    }

    public RawDataSleepDao getRawDataSleepDao() {
        return this.rawDataSleepDao;
    }

    public RawDataStepDao getRawDataStepDao() {
        return this.rawDataStepDao;
    }

    public UserDao getUserDao() {
        return this.userDao;
    }
}
