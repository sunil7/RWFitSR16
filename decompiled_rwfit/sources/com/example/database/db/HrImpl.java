package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataHeartRateDao;
import com.example.database.table.DataHeartRate;
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
public final class HrImpl {
    public static final HrImpl INSTANCE = new HrImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.HrImpl$mDao$2
        @Override // oh.a
        public final DataHeartRateDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataHeartRateDao();
        }
    });

    private HrImpl() {
    }

    private final DataHeartRateDao getMDao() {
        return (DataHeartRateDao) mDao$delegate.getValue();
    }

    public final void deleteAll() {
        getMDao().deleteAll();
    }

    public final DataHeartRate getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            QueryBuilder<DataHeartRate> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataHeartRateDao.Properties.UserId.eq(userId);
            Property property = DataHeartRateDao.Properties.Date;
            DataHeartRate dataHeartRate = (DataHeartRate) android.support.v4.media.session.e.f(queryBuilder.where(eq, property.eq(date)).orderDesc(property), new Property[]{DataHeartRateDao.Properties.Id}, 1);
            if (dataHeartRate == null) {
                return null;
            }
            return dataHeartRate;
        }
        QueryBuilder<DataHeartRate> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq2 = DataHeartRateDao.Properties.UserId.eq(userId);
        WhereCondition eq3 = DataHeartRateDao.Properties.Mac.eq(str);
        Property property2 = DataHeartRateDao.Properties.Date;
        DataHeartRate dataHeartRate2 = (DataHeartRate) android.support.v4.media.session.e.f(queryBuilder2.where(eq2, eq3, property2.eq(date)), new Property[]{property2}, 1);
        if (dataHeartRate2 == null) {
            return null;
        }
        return dataHeartRate2;
    }

    public final List<DataHeartRate> getUploadHrs(String userId) {
        e.f(userId, "userId");
        List<DataHeartRate> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataHeartRateDao.Properties.UserId.eq(userId), DataHeartRateDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataHeartRateDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataHeartRate> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataHeartRateDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataHeartRateDao.Properties.Timestamp});
        List<? extends DataHeartRate> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataHeartRate) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataHeartRate data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataHeartRate> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataHeartRate) it.next());
        }
        return true;
    }

    public final List<DataHeartRate> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataHeartRate> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataHeartRateDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataHeartRateDao.Properties.Mac.eq(str);
            Property property = DataHeartRateDao.Properties.Date;
            List<DataHeartRate> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataHeartRateDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<DataHeartRate> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataHeartRateDao.Properties.UserId.eq(userId);
        Property property2 = DataHeartRateDao.Properties.Date;
        Iterable<DataHeartRate> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataHeartRateDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataHeartRate dataHeartRate : w9) {
            if (str2.length() == 0 || !e.a(str2, dataHeartRate.getDate())) {
                arrayList.add(dataHeartRate);
                str2 = dataHeartRate.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
