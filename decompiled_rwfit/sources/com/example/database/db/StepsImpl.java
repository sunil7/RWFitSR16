package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataStepDao;
import com.example.database.table.DataStep;
import eh.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public final class StepsImpl {
    public static final StepsImpl INSTANCE = new StepsImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.StepsImpl$mDao$2
        @Override // oh.a
        public final DataStepDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataStepDao();
        }
    });

    private StepsImpl() {
    }

    private final DataStepDao getMDao() {
        return (DataStepDao) mDao$delegate.getValue();
    }

    public final void deleteAll() {
        getMDao().deleteAll();
    }

    public final DataStep getStepByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataStep> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataStepDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataStepDao.Properties.Mac.eq(str);
            Property property = DataStepDao.Properties.Date;
            DataStep dataStep = (DataStep) android.support.v4.media.session.e.f(queryBuilder.where(eq, eq2, property.eq(date)), new Property[]{property}, 1);
            return dataStep == null ? getStepByDate(null, userId, date) : dataStep;
        }
        QueryBuilder<DataStep> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataStepDao.Properties.UserId.eq(userId);
        Property property2 = DataStepDao.Properties.Date;
        DataStep dataStep2 = (DataStep) android.support.v4.media.session.e.f(queryBuilder2.where(eq3, property2.eq(date)).orderDesc(property2), new Property[]{DataStepDao.Properties.Id}, 1);
        if (dataStep2 == null) {
            return null;
        }
        return dataStep2;
    }

    public final List<DataStep> getUploadSteps(String userId) {
        e.f(userId, "userId");
        List<DataStep> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataStepDao.Properties.UserId.eq(userId), DataStepDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataStepDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataStep> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataStepDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataStepDao.Properties.Timestamp});
        List<? extends DataStep> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataStep) it.next()).setUserId(targetUserId);
        }
        saveSteps(w8);
    }

    public final long saveStep(DataStep step) {
        e.f(step, "step");
        return getMDao().insertOrReplace(step);
    }

    public final boolean saveSteps(List<? extends DataStep> steps) {
        e.f(steps, "steps");
        Iterator<T> it = steps.iterator();
        while (it.hasNext()) {
            INSTANCE.saveStep((DataStep) it.next());
        }
        return true;
    }

    public final List<DataStep> getStepByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataStep> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataStepDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataStepDao.Properties.Mac.eq(str);
            Property property = DataStepDao.Properties.Date;
            List<DataStep> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataStepDao.Properties.Timestamp});
            if (w8 == null) {
                w8 = EmptyList.INSTANCE;
            }
            return w8.isEmpty() ? getStepByDate(null, userId, startDate, endDate) : w8;
        }
        QueryBuilder<DataStep> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataStepDao.Properties.UserId.eq(userId);
        Property property2 = DataStepDao.Properties.Date;
        Iterable<DataStep> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataStepDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataStep dataStep : w9) {
            if (str2.length() == 0 || !e.a(str2, dataStep.getDate())) {
                arrayList.add(dataStep);
                str2 = dataStep.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
