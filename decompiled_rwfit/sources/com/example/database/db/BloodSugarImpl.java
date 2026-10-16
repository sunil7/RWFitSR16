package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataBloodSugarDao;
import com.example.database.table.DataBloodSugar;
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
public final class BloodSugarImpl {
    public static final BloodSugarImpl INSTANCE = new BloodSugarImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.BloodSugarImpl$mDao$2
        @Override // oh.a
        public final DataBloodSugarDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataBloodSugarDao();
        }
    });

    private BloodSugarImpl() {
    }

    private final DataBloodSugarDao getMDao() {
        return (DataBloodSugarDao) mDao$delegate.getValue();
    }

    public final DataBloodSugar getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            QueryBuilder<DataBloodSugar> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataBloodSugarDao.Properties.UserId.eq(userId);
            Property property = DataBloodSugarDao.Properties.Date;
            DataBloodSugar dataBloodSugar = (DataBloodSugar) android.support.v4.media.session.e.f(queryBuilder.where(eq, property.eq(date)).orderDesc(property), new Property[]{DataBloodSugarDao.Properties.Id}, 1);
            if (dataBloodSugar == null) {
                return null;
            }
            return dataBloodSugar;
        }
        QueryBuilder<DataBloodSugar> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq2 = DataBloodSugarDao.Properties.UserId.eq(userId);
        WhereCondition eq3 = DataBloodSugarDao.Properties.Mac.eq(str);
        Property property2 = DataBloodSugarDao.Properties.Date;
        DataBloodSugar dataBloodSugar2 = (DataBloodSugar) android.support.v4.media.session.e.f(queryBuilder2.where(eq2, eq3, property2.eq(date)), new Property[]{property2}, 1);
        if (dataBloodSugar2 == null) {
            return null;
        }
        return dataBloodSugar2;
    }

    public final List<DataBloodSugar> getUploadSugars(String userId) {
        e.f(userId, "userId");
        List<DataBloodSugar> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataBloodSugarDao.Properties.UserId.eq(userId), DataBloodSugarDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataBloodSugarDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataBloodSugar> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataBloodSugarDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataBloodSugarDao.Properties.Timestamp});
        List<? extends DataBloodSugar> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataBloodSugar) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataBloodSugar data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataBloodSugar> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataBloodSugar) it.next());
        }
        return true;
    }

    public final List<DataBloodSugar> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataBloodSugar> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataBloodSugarDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataBloodSugarDao.Properties.Mac.eq(str);
            Property property = DataBloodSugarDao.Properties.Date;
            List<DataBloodSugar> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataBloodSugarDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<DataBloodSugar> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataBloodSugarDao.Properties.UserId.eq(userId);
        Property property2 = DataBloodSugarDao.Properties.Date;
        Iterable<DataBloodSugar> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataBloodSugarDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataBloodSugar dataBloodSugar : w9) {
            if (str2.length() == 0 || !e.a(str2, dataBloodSugar.getDate())) {
                arrayList.add(dataBloodSugar);
                str2 = dataBloodSugar.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
