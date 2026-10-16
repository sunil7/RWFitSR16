package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataPressureDao;
import com.example.database.table.DataPressure;
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
public final class PressureImpl {
    public static final PressureImpl INSTANCE = new PressureImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.PressureImpl$mDao$2
        @Override // oh.a
        public final DataPressureDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataPressureDao();
        }
    });

    private PressureImpl() {
    }

    private final DataPressureDao getMDao() {
        return (DataPressureDao) mDao$delegate.getValue();
    }

    public final void deleteAll() {
        getMDao().deleteAll();
    }

    public final DataPressure getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            QueryBuilder<DataPressure> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataPressureDao.Properties.UserId.eq(userId);
            Property property = DataPressureDao.Properties.Date;
            DataPressure dataPressure = (DataPressure) android.support.v4.media.session.e.f(queryBuilder.where(eq, property.eq(date)).orderDesc(property), new Property[]{DataPressureDao.Properties.Id}, 1);
            if (dataPressure == null) {
                return null;
            }
            return dataPressure;
        }
        QueryBuilder<DataPressure> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq2 = DataPressureDao.Properties.UserId.eq(userId);
        WhereCondition eq3 = DataPressureDao.Properties.Mac.eq(str);
        Property property2 = DataPressureDao.Properties.Date;
        DataPressure dataPressure2 = (DataPressure) android.support.v4.media.session.e.f(queryBuilder2.where(eq2, eq3, property2.eq(date)), new Property[]{property2}, 1);
        if (dataPressure2 == null) {
            return null;
        }
        return dataPressure2;
    }

    public final List<DataPressure> getUploadPressure(String userId) {
        e.f(userId, "userId");
        List<DataPressure> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataPressureDao.Properties.UserId.eq(userId), DataPressureDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataPressureDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataPressure> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataPressureDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataPressureDao.Properties.Timestamp});
        List<? extends DataPressure> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataPressure) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataPressure data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataPressure> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataPressure) it.next());
        }
        return true;
    }

    public final List<DataPressure> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataPressure> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataPressureDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataPressureDao.Properties.Mac.eq(str);
            Property property = DataPressureDao.Properties.Date;
            List<DataPressure> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataPressureDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<DataPressure> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataPressureDao.Properties.UserId.eq(userId);
        Property property2 = DataPressureDao.Properties.Date;
        Iterable<DataPressure> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataPressureDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataPressure dataPressure : w9) {
            if (str2.length() == 0 || !e.a(str2, dataPressure.getDate())) {
                arrayList.add(dataPressure);
                str2 = dataPressure.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
