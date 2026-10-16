package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataBloodOxygenDao;
import com.example.database.table.DataBloodOxygen;
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
public final class BloodOxygenImpl {
    public static final BloodOxygenImpl INSTANCE = new BloodOxygenImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.BloodOxygenImpl$mDao$2
        @Override // oh.a
        public final DataBloodOxygenDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataBloodOxygenDao();
        }
    });

    private BloodOxygenImpl() {
    }

    private final DataBloodOxygenDao getMDao() {
        return (DataBloodOxygenDao) mDao$delegate.getValue();
    }

    public final void deleteAll() {
        getMDao().deleteAll();
    }

    public final DataBloodOxygen getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            QueryBuilder<DataBloodOxygen> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataBloodOxygenDao.Properties.UserId.eq(userId);
            Property property = DataBloodOxygenDao.Properties.Date;
            DataBloodOxygen dataBloodOxygen = (DataBloodOxygen) android.support.v4.media.session.e.f(queryBuilder.where(eq, property.eq(date)).orderDesc(property), new Property[]{DataBloodOxygenDao.Properties.Id}, 1);
            if (dataBloodOxygen == null) {
                return null;
            }
            return dataBloodOxygen;
        }
        QueryBuilder<DataBloodOxygen> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq2 = DataBloodOxygenDao.Properties.UserId.eq(userId);
        WhereCondition eq3 = DataBloodOxygenDao.Properties.Mac.eq(str);
        Property property2 = DataBloodOxygenDao.Properties.Date;
        DataBloodOxygen dataBloodOxygen2 = (DataBloodOxygen) android.support.v4.media.session.e.f(queryBuilder2.where(eq2, eq3, property2.eq(date)), new Property[]{property2}, 1);
        if (dataBloodOxygen2 == null) {
            return null;
        }
        return dataBloodOxygen2;
    }

    public final List<DataBloodOxygen> getUploadBo(String userId) {
        e.f(userId, "userId");
        List<DataBloodOxygen> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataBloodOxygenDao.Properties.UserId.eq(userId), DataBloodOxygenDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataBloodOxygenDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataBloodOxygen> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataBloodOxygenDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataBloodOxygenDao.Properties.Timestamp});
        List<? extends DataBloodOxygen> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataBloodOxygen) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataBloodOxygen data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataBloodOxygen> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataBloodOxygen) it.next());
        }
        return true;
    }

    public final List<DataBloodOxygen> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataBloodOxygen> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataBloodOxygenDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataBloodOxygenDao.Properties.Mac.eq(str);
            Property property = DataBloodOxygenDao.Properties.Date;
            List<DataBloodOxygen> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataBloodOxygenDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<DataBloodOxygen> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataBloodOxygenDao.Properties.UserId.eq(userId);
        Property property2 = DataBloodOxygenDao.Properties.Date;
        Iterable<DataBloodOxygen> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataBloodOxygenDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataBloodOxygen dataBloodOxygen : w9) {
            if (str2.length() == 0 || !e.a(str2, dataBloodOxygen.getDate())) {
                arrayList.add(dataBloodOxygen);
                str2 = dataBloodOxygen.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
