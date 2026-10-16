package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataSport;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.tencent.connect.common.Constants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataSportDao extends AbstractDao<DataSport, Long> {
    public static final String TABLENAME = "t_data_sport";

    public static class Properties {
        public static final Property AvgHr;
        public static final Property AvgPace;
        public static final Property AvgSteps;
        public static final Property From;
        public static final Property HrData;
        public static final Property IsNew;
        public static final Property IsUpdate;
        public static final Property LatLng;
        public static final Property MaxHr;
        public static final Property MaxPace;
        public static final Property MaxSteps;
        public static final Property MinHr;
        public static final Property MinPace;
        public static final Property MinSteps;
        public static final Property NewSportHrs;
        public static final Property PaceImperials;
        public static final Property PaceMetrics;
        public static final Property Speed;
        public static final Property SportType;
        public static final Property StepDetails;
        public static final Property TotalCalories;
        public static final Property TotalDistances;
        public static final Property TotalSteps;
        public static final Property TotalTimes;
        public static final Property ViewType;
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property Timestamp = new Property(3, String.class, "timestamp", false, "timestamp");
        public static final Property Date = new Property(4, String.class, "date", false, "date");

        static {
            Class cls = Integer.TYPE;
            SportType = new Property(5, cls, "sportType", false, "sport_type");
            TotalCalories = new Property(6, String.class, "totalCalories", false, "total_calories");
            TotalTimes = new Property(7, String.class, "totalTimes", false, "total_times");
            TotalSteps = new Property(8, String.class, "totalSteps", false, "total_steps");
            TotalDistances = new Property(9, String.class, "totalDistances", false, "total_distances");
            PaceMetrics = new Property(10, String.class, "paceMetrics", false, "pace_metrics");
            PaceImperials = new Property(11, String.class, "paceImperials", false, "pace_imperials");
            StepDetails = new Property(12, String.class, "stepDetails", false, "step_details");
            HrData = new Property(13, String.class, "hrData", false, "hr_data");
            LatLng = new Property(14, String.class, "latLng", false, "lat_lng");
            Class cls2 = Long.TYPE;
            AvgPace = new Property(15, cls2, "avgPace", false, "avg_pace");
            MaxPace = new Property(16, cls2, "maxPace", false, "max_pace");
            MinPace = new Property(17, cls2, "minPace", false, "min_pace");
            AvgSteps = new Property(18, cls2, "avgSteps", false, "avg_steps");
            MaxSteps = new Property(19, cls2, "maxSteps", false, "max_steps");
            MinSteps = new Property(20, cls2, "minSteps", false, "min_steps");
            AvgHr = new Property(21, cls2, "avgHr", false, "avg_hr");
            MaxHr = new Property(22, cls2, "maxHr", false, "max_hr");
            MinHr = new Property(23, cls2, "minHr", false, "min_hr");
            Speed = new Property(24, cls2, Const.JSON_KEY_SPEED, false, Const.JSON_KEY_SPEED);
            Class cls3 = Boolean.TYPE;
            IsUpdate = new Property(25, cls3, "isUpdate", false, "is_update");
            From = new Property(26, cls, Constants.FROM, false, Constants.FROM);
            ViewType = new Property(27, cls, "viewType", false, "viewType");
            NewSportHrs = new Property(28, String.class, "newSportHrs", false, "new_sport_hrs");
            IsNew = new Property(29, cls3, "isNew", false, "isNew");
        }
    }

    public DataSportDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_sport\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"timestamp\" TEXT,\"date\" TEXT,\"sport_type\" INTEGER NOT NULL ,\"total_calories\" TEXT,\"total_times\" TEXT,\"total_steps\" TEXT,\"total_distances\" TEXT,\"pace_metrics\" TEXT,\"pace_imperials\" TEXT,\"step_details\" TEXT,\"hr_data\" TEXT,\"lat_lng\" TEXT,\"avg_pace\" INTEGER NOT NULL ,\"max_pace\" INTEGER NOT NULL ,\"min_pace\" INTEGER NOT NULL ,\"avg_steps\" INTEGER NOT NULL ,\"max_steps\" INTEGER NOT NULL ,\"min_steps\" INTEGER NOT NULL ,\"avg_hr\" INTEGER NOT NULL ,\"max_hr\" INTEGER NOT NULL ,\"min_hr\" INTEGER NOT NULL ,\"speed\" INTEGER NOT NULL ,\"is_update\" INTEGER NOT NULL ,\"from\" INTEGER NOT NULL ,\"viewType\" INTEGER NOT NULL ,\"new_sport_hrs\" TEXT,\"isNew\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_sport_user_id_DESC_timestamp_DESC_mac_DESC ON \"t_data_sport\" (\"user_id\" DESC,\"timestamp\" DESC,\"mac\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_sport\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataSportDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataSport dataSport) {
        if (dataSport != null) {
            return dataSport.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataSport dataSport) {
        return dataSport.getId() != null;
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
    public final Long updateKeyAfterInsert(DataSport dataSport, long j4) {
        dataSport.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataSport dataSport) {
        databaseStatement.clearBindings();
        Long id2 = dataSport.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataSport.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataSport.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        String timestamp = dataSport.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(4, timestamp);
        }
        String date = dataSport.getDate();
        if (date != null) {
            databaseStatement.bindString(5, date);
        }
        databaseStatement.bindLong(6, dataSport.getSportType());
        String totalCalories = dataSport.getTotalCalories();
        if (totalCalories != null) {
            databaseStatement.bindString(7, totalCalories);
        }
        String totalTimes = dataSport.getTotalTimes();
        if (totalTimes != null) {
            databaseStatement.bindString(8, totalTimes);
        }
        String totalSteps = dataSport.getTotalSteps();
        if (totalSteps != null) {
            databaseStatement.bindString(9, totalSteps);
        }
        String totalDistances = dataSport.getTotalDistances();
        if (totalDistances != null) {
            databaseStatement.bindString(10, totalDistances);
        }
        String paceMetrics = dataSport.getPaceMetrics();
        if (paceMetrics != null) {
            databaseStatement.bindString(11, paceMetrics);
        }
        String paceImperials = dataSport.getPaceImperials();
        if (paceImperials != null) {
            databaseStatement.bindString(12, paceImperials);
        }
        String stepDetails = dataSport.getStepDetails();
        if (stepDetails != null) {
            databaseStatement.bindString(13, stepDetails);
        }
        String hrData = dataSport.getHrData();
        if (hrData != null) {
            databaseStatement.bindString(14, hrData);
        }
        String latLng = dataSport.getLatLng();
        if (latLng != null) {
            databaseStatement.bindString(15, latLng);
        }
        databaseStatement.bindLong(16, dataSport.getAvgPace());
        databaseStatement.bindLong(17, dataSport.getMaxPace());
        databaseStatement.bindLong(18, dataSport.getMinPace());
        databaseStatement.bindLong(19, dataSport.getAvgSteps());
        databaseStatement.bindLong(20, dataSport.getMaxSteps());
        databaseStatement.bindLong(21, dataSport.getMinSteps());
        databaseStatement.bindLong(22, dataSport.getAvgHr());
        databaseStatement.bindLong(23, dataSport.getMaxHr());
        databaseStatement.bindLong(24, dataSport.getMinHr());
        databaseStatement.bindLong(25, dataSport.getSpeed());
        databaseStatement.bindLong(26, dataSport.getIsUpdate() ? 1L : 0L);
        databaseStatement.bindLong(27, dataSport.getFrom());
        databaseStatement.bindLong(28, dataSport.getViewType());
        String newSportHrs = dataSport.getNewSportHrs();
        if (newSportHrs != null) {
            databaseStatement.bindString(29, newSportHrs);
        }
        databaseStatement.bindLong(30, dataSport.getIsNew() ? 1L : 0L);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public com.example.database.table.DataSport readEntity(android.database.Cursor r50, int r51) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.database.dao.DataSportDao.readEntity(android.database.Cursor, int):com.example.database.table.DataSport");
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataSport dataSport, int i3) {
        dataSport.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataSport.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataSport.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataSport.setTimestamp(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i3 + 4;
        dataSport.setDate(cursor.isNull(i13) ? null : cursor.getString(i13));
        dataSport.setSportType(cursor.getInt(i3 + 5));
        int i14 = i3 + 6;
        dataSport.setTotalCalories(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i3 + 7;
        dataSport.setTotalTimes(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i3 + 8;
        dataSport.setTotalSteps(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i3 + 9;
        dataSport.setTotalDistances(cursor.isNull(i17) ? null : cursor.getString(i17));
        int i18 = i3 + 10;
        dataSport.setPaceMetrics(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i3 + 11;
        dataSport.setPaceImperials(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i20 = i3 + 12;
        dataSport.setStepDetails(cursor.isNull(i20) ? null : cursor.getString(i20));
        int i21 = i3 + 13;
        dataSport.setHrData(cursor.isNull(i21) ? null : cursor.getString(i21));
        int i22 = i3 + 14;
        dataSport.setLatLng(cursor.isNull(i22) ? null : cursor.getString(i22));
        dataSport.setAvgPace(cursor.getLong(i3 + 15));
        dataSport.setMaxPace(cursor.getLong(i3 + 16));
        dataSport.setMinPace(cursor.getLong(i3 + 17));
        dataSport.setAvgSteps(cursor.getLong(i3 + 18));
        dataSport.setMaxSteps(cursor.getLong(i3 + 19));
        dataSport.setMinSteps(cursor.getLong(i3 + 20));
        dataSport.setAvgHr(cursor.getLong(i3 + 21));
        dataSport.setMaxHr(cursor.getLong(i3 + 22));
        dataSport.setMinHr(cursor.getLong(i3 + 23));
        dataSport.setSpeed(cursor.getLong(i3 + 24));
        dataSport.setIsUpdate(cursor.getShort(i3 + 25) != 0);
        dataSport.setFrom(cursor.getInt(i3 + 26));
        dataSport.setViewType(cursor.getInt(i3 + 27));
        int i23 = i3 + 28;
        dataSport.setNewSportHrs(cursor.isNull(i23) ? null : cursor.getString(i23));
        dataSport.setIsNew(cursor.getShort(i3 + 29) != 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataSport dataSport) {
        sQLiteStatement.clearBindings();
        Long id2 = dataSport.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataSport.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataSport.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        String timestamp = dataSport.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(4, timestamp);
        }
        String date = dataSport.getDate();
        if (date != null) {
            sQLiteStatement.bindString(5, date);
        }
        sQLiteStatement.bindLong(6, dataSport.getSportType());
        String totalCalories = dataSport.getTotalCalories();
        if (totalCalories != null) {
            sQLiteStatement.bindString(7, totalCalories);
        }
        String totalTimes = dataSport.getTotalTimes();
        if (totalTimes != null) {
            sQLiteStatement.bindString(8, totalTimes);
        }
        String totalSteps = dataSport.getTotalSteps();
        if (totalSteps != null) {
            sQLiteStatement.bindString(9, totalSteps);
        }
        String totalDistances = dataSport.getTotalDistances();
        if (totalDistances != null) {
            sQLiteStatement.bindString(10, totalDistances);
        }
        String paceMetrics = dataSport.getPaceMetrics();
        if (paceMetrics != null) {
            sQLiteStatement.bindString(11, paceMetrics);
        }
        String paceImperials = dataSport.getPaceImperials();
        if (paceImperials != null) {
            sQLiteStatement.bindString(12, paceImperials);
        }
        String stepDetails = dataSport.getStepDetails();
        if (stepDetails != null) {
            sQLiteStatement.bindString(13, stepDetails);
        }
        String hrData = dataSport.getHrData();
        if (hrData != null) {
            sQLiteStatement.bindString(14, hrData);
        }
        String latLng = dataSport.getLatLng();
        if (latLng != null) {
            sQLiteStatement.bindString(15, latLng);
        }
        sQLiteStatement.bindLong(16, dataSport.getAvgPace());
        sQLiteStatement.bindLong(17, dataSport.getMaxPace());
        sQLiteStatement.bindLong(18, dataSport.getMinPace());
        sQLiteStatement.bindLong(19, dataSport.getAvgSteps());
        sQLiteStatement.bindLong(20, dataSport.getMaxSteps());
        sQLiteStatement.bindLong(21, dataSport.getMinSteps());
        sQLiteStatement.bindLong(22, dataSport.getAvgHr());
        sQLiteStatement.bindLong(23, dataSport.getMaxHr());
        sQLiteStatement.bindLong(24, dataSport.getMinHr());
        sQLiteStatement.bindLong(25, dataSport.getSpeed());
        sQLiteStatement.bindLong(26, dataSport.getIsUpdate() ? 1L : 0L);
        sQLiteStatement.bindLong(27, dataSport.getFrom());
        sQLiteStatement.bindLong(28, dataSport.getViewType());
        String newSportHrs = dataSport.getNewSportHrs();
        if (newSportHrs != null) {
            sQLiteStatement.bindString(29, newSportHrs);
        }
        sQLiteStatement.bindLong(30, dataSport.getIsNew() ? 1L : 0L);
    }
}
