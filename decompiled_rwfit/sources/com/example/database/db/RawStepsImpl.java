package com.example.database.db;

import android.util.Log;
import com.example.database.api.DBManger;
import com.example.database.dao.RawDataStepDao;
import com.example.database.table.RawDataStep;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import eh.b;
import java.util.Iterator;
import java.util.List;
import kotlin.a;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public final class RawStepsImpl {
    public static final RawStepsImpl INSTANCE = new RawStepsImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.RawStepsImpl$mDao$2
        @Override // oh.a
        public final RawDataStepDao invoke() {
            return DBManger.getInstance().getDaoSession().getRawDataStepDao();
        }
    });

    private RawStepsImpl() {
    }

    private final RawDataStepDao getMDao() {
        return (RawDataStepDao) mDao$delegate.getValue();
    }

    public final void deleteDecreaseStepData(List<? extends RawDataStep> dataList) {
        e.f(dataList, "dataList");
        Iterator<? extends RawDataStep> it = dataList.iterator();
        while (it.hasNext()) {
            getMDao().delete(it.next());
        }
    }

    public final void deleteStepByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        List<RawDataStep> stepByDate = getStepByDate(str, userId, date);
        int size = stepByDate.size();
        StringBuilder v6 = l0.v("deleteStepByDate  mac ", str, " userID ", userId, " date ");
        v6.append(date);
        v6.append(" size ");
        v6.append(size);
        Log.e("qob", v6.toString());
        Iterator<RawDataStep> it = stepByDate.iterator();
        while (it.hasNext()) {
            getMDao().delete(it.next());
        }
    }

    public final List<RawDataStep> getStepByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            List<RawDataStep> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(RawDataStepDao.Properties.UserId.eq(userId), RawDataStepDao.Properties.Date.eq(date)), new Property[]{RawDataStepDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        List<RawDataStep> w9 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(RawDataStepDao.Properties.UserId.eq(userId), RawDataStepDao.Properties.Mac.eq(str), RawDataStepDao.Properties.Date.eq(date)), new Property[]{RawDataStepDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        return w9.isEmpty() ? getStepByDate(null, userId, date) : w9;
    }

    public final List<RawDataStep> getUploadSteps(String userId) {
        e.f(userId, "userId");
        List<RawDataStep> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(RawDataStepDao.Properties.UserId.eq(userId), RawDataStepDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{RawDataStepDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends RawDataStep> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(RawDataStepDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{RawDataStepDao.Properties.Timestamp});
        List<? extends RawDataStep> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((RawDataStep) it.next()).setUserId(targetUserId);
        }
        saveSteps(w8);
    }

    public final long saveStep(RawDataStep step) {
        e.f(step, "step");
        List w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(RawDataStepDao.Properties.UserId.eq(step.getUserId()), RawDataStepDao.Properties.Date.eq(step.getDate()), RawDataStepDao.Properties.Hour.eq(step.getHour())), new Property[]{RawDataStepDao.Properties.Timestamp});
        if (w8 == null) {
            w8 = EmptyList.INSTANCE;
        }
        Log.e("qob", "saveStep delete " + w8.size());
        Iterator it = w8.iterator();
        while (it.hasNext()) {
            getMDao().delete((RawDataStep) it.next());
        }
        return getMDao().insertOrReplace(step);
    }

    public final boolean saveSteps(List<? extends RawDataStep> steps) {
        e.f(steps, "steps");
        Iterator<T> it = steps.iterator();
        while (it.hasNext()) {
            INSTANCE.saveStep((RawDataStep) it.next());
        }
        return true;
    }

    public final List<RawDataStep> getStepByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<RawDataStep> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = RawDataStepDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = RawDataStepDao.Properties.Mac.eq(str);
            Property property = RawDataStepDao.Properties.Date;
            List<RawDataStep> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{RawDataStepDao.Properties.Timestamp});
            if (w8 == null) {
                w8 = EmptyList.INSTANCE;
            }
            return w8.isEmpty() ? getStepByDate(null, userId, startDate, endDate) : w8;
        }
        QueryBuilder<RawDataStep> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = RawDataStepDao.Properties.UserId.eq(userId);
        Property property2 = RawDataStepDao.Properties.Date;
        List<RawDataStep> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{RawDataStepDao.Properties.Timestamp});
        return w9 == null ? EmptyList.INSTANCE : w9;
    }
}
