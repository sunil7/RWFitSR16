package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.RawDataSleepDao;
import com.example.database.table.RawDataSleep;
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
public final class RawSleepImpl {
    public static final RawSleepImpl INSTANCE = new RawSleepImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.RawSleepImpl$mDao$2
        @Override // oh.a
        public final RawDataSleepDao invoke() {
            return DBManger.getInstance().getDaoSession().getRawDataSleepDao();
        }
    });

    private RawSleepImpl() {
    }

    private final RawDataSleepDao getMDao() {
        return (RawDataSleepDao) mDao$delegate.getValue();
    }

    public final List<RawDataSleep> getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            List<RawDataSleep> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(RawDataSleepDao.Properties.UserId.eq(userId), RawDataSleepDao.Properties.Date.eq(date)), new Property[]{RawDataSleepDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        List<RawDataSleep> w9 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(RawDataSleepDao.Properties.UserId.eq(userId), RawDataSleepDao.Properties.Mac.eq(str), RawDataSleepDao.Properties.Date.eq(date)), new Property[]{RawDataSleepDao.Properties.Timestamp});
        return w9 == null ? EmptyList.INSTANCE : w9;
    }

    public final List<RawDataSleep> getUploadSleeps(String userId) {
        e.f(userId, "userId");
        List<RawDataSleep> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(RawDataSleepDao.Properties.UserId.eq(userId), RawDataSleepDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{RawDataSleepDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends RawDataSleep> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(RawDataSleepDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{RawDataSleepDao.Properties.Timestamp});
        List<? extends RawDataSleep> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((RawDataSleep) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(RawDataSleep data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends RawDataSleep> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((RawDataSleep) it.next());
        }
        return true;
    }

    public final List<RawDataSleep> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<RawDataSleep> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = RawDataSleepDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = RawDataSleepDao.Properties.Mac.eq(str);
            Property property = RawDataSleepDao.Properties.Date;
            List<RawDataSleep> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{RawDataSleepDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<RawDataSleep> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = RawDataSleepDao.Properties.UserId.eq(userId);
        Property property2 = RawDataSleepDao.Properties.Date;
        List<RawDataSleep> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{RawDataSleepDao.Properties.Timestamp});
        return w9 == null ? EmptyList.INSTANCE : w9;
    }
}
