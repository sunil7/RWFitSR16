package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.example.database.table.User;
import com.tencent.connect.common.Constants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class UserDao extends AbstractDao<User, String> {
    public static final String TABLENAME = "t_user";

    public static class Properties {
        public static final Property Birthday;
        public static final Property CaloriesTarget;
        public static final Property CustomerMaxHeartRate;
        public static final Property DistanceTarget;
        public static final Property DurationTarget;
        public static final Property Height;
        public static final Property IsSyncWeightInfo;
        public static final Property IsUpdateHealthInfo;
        public static final Property IsUpdateSportInfo;
        public static final Property IsUpdateUserInfo;
        public static final Property MeterUnit;
        public static final Property Platform;
        public static final Property Sex;
        public static final Property StepsTarget;
        public static final Property TempUnit;
        public static final Property Weight;
        public static final Property WeightTarget;
        public static final Property UserId = new Property(0, String.class, "userId", true, "user_id");
        public static final Property Account = new Property(1, String.class, "account", false, "ACCOUNT");
        public static final Property Name = new Property(2, String.class, "name", false, "NAME");
        public static final Property Avatar = new Property(3, String.class, "avatar", false, "AVATAR");

        static {
            Class cls = Integer.TYPE;
            Sex = new Property(4, cls, "sex", false, "SEX");
            Birthday = new Property(5, String.class, "birthday", false, "BIRTHDAY");
            Class cls2 = Double.TYPE;
            Height = new Property(6, cls2, "height", false, "HEIGHT");
            Weight = new Property(7, cls2, "weight", false, "WEIGHT");
            DurationTarget = new Property(8, cls, "durationTarget", false, "duration_target");
            DistanceTarget = new Property(9, cls, "distanceTarget", false, "distance_target");
            WeightTarget = new Property(10, cls2, "weightTarget", false, "weight_target");
            CaloriesTarget = new Property(11, cls, "caloriesTarget", false, "calories_target");
            StepsTarget = new Property(12, cls, "stepsTarget", false, "steps_target");
            Class cls3 = Boolean.TYPE;
            IsUpdateUserInfo = new Property(13, cls3, "isUpdateUserInfo", false, "is_update_user_info");
            IsUpdateSportInfo = new Property(14, cls3, "isUpdateSportInfo", false, "is_update_sport_info");
            IsUpdateHealthInfo = new Property(15, cls3, "isUpdateHealthInfo", false, "is_update_health_info");
            IsSyncWeightInfo = new Property(16, cls3, "isSyncWeightInfo", false, "is_sync_weight_info");
            CustomerMaxHeartRate = new Property(17, cls, "customerMaxHeartRate", false, "customer_max_hr");
            Platform = new Property(18, cls, Constants.PARAM_PLATFORM, false, Constants.PARAM_PLATFORM);
            MeterUnit = new Property(19, cls, "meterUnit", false, "meter_unit");
            TempUnit = new Property(20, cls, "tempUnit", false, "temp_unit");
        }
    }

    public UserDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_user\" (\"user_id\" TEXT PRIMARY KEY NOT NULL ,\"ACCOUNT\" TEXT,\"NAME\" TEXT,\"AVATAR\" TEXT,\"SEX\" INTEGER NOT NULL ,\"BIRTHDAY\" TEXT,\"HEIGHT\" REAL NOT NULL ,\"WEIGHT\" REAL NOT NULL ,\"duration_target\" INTEGER NOT NULL ,\"distance_target\" INTEGER NOT NULL ,\"weight_target\" REAL NOT NULL ,\"calories_target\" INTEGER NOT NULL ,\"steps_target\" INTEGER NOT NULL ,\"is_update_user_info\" INTEGER NOT NULL ,\"is_update_sport_info\" INTEGER NOT NULL ,\"is_update_health_info\" INTEGER NOT NULL ,\"is_sync_weight_info\" INTEGER NOT NULL ,\"customer_max_hr\" INTEGER NOT NULL ,\"platform\" INTEGER NOT NULL ,\"meter_unit\" INTEGER NOT NULL ,\"temp_unit\" INTEGER NOT NULL );");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_user_user_id_DESC ON \"t_user\" (\"user_id\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_user\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public UserDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public String getKey(User user) {
        if (user != null) {
            return user.getUserId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(User user) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public String readKey(Cursor cursor, int i3) {
        return cursor.getString(i3);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final String updateKeyAfterInsert(User user, long j4) {
        return user.getUserId();
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, User user) {
        databaseStatement.clearBindings();
        databaseStatement.bindString(1, user.getUserId());
        String account = user.getAccount();
        if (account != null) {
            databaseStatement.bindString(2, account);
        }
        String name = user.getName();
        if (name != null) {
            databaseStatement.bindString(3, name);
        }
        String avatar = user.getAvatar();
        if (avatar != null) {
            databaseStatement.bindString(4, avatar);
        }
        databaseStatement.bindLong(5, user.getSex());
        String birthday = user.getBirthday();
        if (birthday != null) {
            databaseStatement.bindString(6, birthday);
        }
        databaseStatement.bindDouble(7, user.getHeight());
        databaseStatement.bindDouble(8, user.getWeight());
        databaseStatement.bindLong(9, user.getDurationTarget());
        databaseStatement.bindLong(10, user.getDistanceTarget());
        databaseStatement.bindDouble(11, user.getWeightTarget());
        databaseStatement.bindLong(12, user.getCaloriesTarget());
        databaseStatement.bindLong(13, user.getStepsTarget());
        databaseStatement.bindLong(14, user.getIsUpdateUserInfo() ? 1L : 0L);
        databaseStatement.bindLong(15, user.getIsUpdateSportInfo() ? 1L : 0L);
        databaseStatement.bindLong(16, user.getIsUpdateHealthInfo() ? 1L : 0L);
        databaseStatement.bindLong(17, user.getIsSyncWeightInfo() ? 1L : 0L);
        databaseStatement.bindLong(18, user.getCustomerMaxHeartRate());
        databaseStatement.bindLong(19, user.getPlatform());
        databaseStatement.bindLong(20, user.getMeterUnit());
        databaseStatement.bindLong(21, user.getTempUnit());
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
        */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public com.example.database.table.User readEntity(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r27v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:79)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:402)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:390)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:340)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        */

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, User user, int i3) {
        user.setUserId(cursor.getString(i3));
        int i10 = i3 + 1;
        user.setAccount(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        user.setName(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        user.setAvatar(cursor.isNull(i12) ? null : cursor.getString(i12));
        user.setSex(cursor.getInt(i3 + 4));
        int i13 = i3 + 5;
        user.setBirthday(cursor.isNull(i13) ? null : cursor.getString(i13));
        user.setHeight(cursor.getDouble(i3 + 6));
        user.setWeight(cursor.getDouble(i3 + 7));
        user.setDurationTarget(cursor.getInt(i3 + 8));
        user.setDistanceTarget(cursor.getInt(i3 + 9));
        user.setWeightTarget(cursor.getDouble(i3 + 10));
        user.setCaloriesTarget(cursor.getInt(i3 + 11));
        user.setStepsTarget(cursor.getInt(i3 + 12));
        user.setIsUpdateUserInfo(cursor.getShort(i3 + 13) != 0);
        user.setIsUpdateSportInfo(cursor.getShort(i3 + 14) != 0);
        user.setIsUpdateHealthInfo(cursor.getShort(i3 + 15) != 0);
        user.setIsSyncWeightInfo(cursor.getShort(i3 + 16) != 0);
        user.setCustomerMaxHeartRate(cursor.getInt(i3 + 17));
        user.setPlatform(cursor.getInt(i3 + 18));
        user.setMeterUnit(cursor.getInt(i3 + 19));
        user.setTempUnit(cursor.getInt(i3 + 20));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, User user) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindString(1, user.getUserId());
        String account = user.getAccount();
        if (account != null) {
            sQLiteStatement.bindString(2, account);
        }
        String name = user.getName();
        if (name != null) {
            sQLiteStatement.bindString(3, name);
        }
        String avatar = user.getAvatar();
        if (avatar != null) {
            sQLiteStatement.bindString(4, avatar);
        }
        sQLiteStatement.bindLong(5, user.getSex());
        String birthday = user.getBirthday();
        if (birthday != null) {
            sQLiteStatement.bindString(6, birthday);
        }
        sQLiteStatement.bindDouble(7, user.getHeight());
        sQLiteStatement.bindDouble(8, user.getWeight());
        sQLiteStatement.bindLong(9, user.getDurationTarget());
        sQLiteStatement.bindLong(10, user.getDistanceTarget());
        sQLiteStatement.bindDouble(11, user.getWeightTarget());
        sQLiteStatement.bindLong(12, user.getCaloriesTarget());
        sQLiteStatement.bindLong(13, user.getStepsTarget());
        sQLiteStatement.bindLong(14, user.getIsUpdateUserInfo() ? 1L : 0L);
        sQLiteStatement.bindLong(15, user.getIsUpdateSportInfo() ? 1L : 0L);
        sQLiteStatement.bindLong(16, user.getIsUpdateHealthInfo() ? 1L : 0L);
        sQLiteStatement.bindLong(17, user.getIsSyncWeightInfo() ? 1L : 0L);
        sQLiteStatement.bindLong(18, user.getCustomerMaxHeartRate());
        sQLiteStatement.bindLong(19, user.getPlatform());
        sQLiteStatement.bindLong(20, user.getMeterUnit());
        sQLiteStatement.bindLong(21, user.getTempUnit());
    }
}
