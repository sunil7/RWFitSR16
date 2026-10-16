package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataSleepDao;
import com.example.database.table.DataSleep;
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
public final class SleepImpl {
    public static final SleepImpl INSTANCE = new SleepImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.SleepImpl$mDao$2
        @Override // oh.a
        public final DataSleepDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataSleepDao();
        }
    });

    private SleepImpl() {
    }

    private final DataSleepDao getMDao() {
        return (DataSleepDao) mDao$delegate.getValue();
    }

    public final void deleteAll() {
        getMDao().deleteAll();
    }

    public final DataSleep getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            QueryBuilder<DataSleep> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataSleepDao.Properties.UserId.eq(userId);
            Property property = DataSleepDao.Properties.Date;
            DataSleep dataSleep = (DataSleep) android.support.v4.media.session.e.f(queryBuilder.where(eq, property.eq(date)).orderDesc(property), new Property[]{DataSleepDao.Properties.Id}, 1);
            if (dataSleep == null) {
                return null;
            }
            return dataSleep;
        }
        QueryBuilder<DataSleep> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq2 = DataSleepDao.Properties.UserId.eq(userId);
        WhereCondition eq3 = DataSleepDao.Properties.Mac.eq(str);
        Property property2 = DataSleepDao.Properties.Date;
        DataSleep dataSleep2 = (DataSleep) android.support.v4.media.session.e.f(queryBuilder2.where(eq2, eq3, property2.eq(date)), new Property[]{property2}, 1);
        if (dataSleep2 == null) {
            return null;
        }
        return dataSleep2;
    }

    public final List<DataSleep> getUploadSleeps(String userId) {
        e.f(userId, "userId");
        List<DataSleep> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataSleepDao.Properties.UserId.eq(userId), DataSleepDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataSleepDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataSleep> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataSleepDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataSleepDao.Properties.Timestamp});
        List<? extends DataSleep> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataSleep) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataSleep data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataSleep> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataSleep) it.next());
        }
        return true;
    }

    public final List<DataSleep> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataSleep> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataSleepDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataSleepDao.Properties.Mac.eq(str);
            Property property = DataSleepDao.Properties.Date;
            List<DataSleep> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataSleepDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<DataSleep> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataSleepDao.Properties.UserId.eq(userId);
        Property property2 = DataSleepDao.Properties.Date;
        Iterable<DataSleep> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataSleepDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataSleep dataSleep : w9) {
            if (str2.length() == 0 || !e.a(str2, dataSleep.getDate())) {
                arrayList.add(dataSleep);
                str2 = dataSleep.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
