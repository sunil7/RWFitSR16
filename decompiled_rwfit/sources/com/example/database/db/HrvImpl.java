package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataHeartHrvDao;
import com.example.database.table.DataHeartHrv;
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
public final class HrvImpl {
    public static final HrvImpl INSTANCE = new HrvImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.HrvImpl$mDao$2
        @Override // oh.a
        public final DataHeartHrvDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataHeartHrvDao();
        }
    });

    private HrvImpl() {
    }

    private final DataHeartHrvDao getMDao() {
        return (DataHeartHrvDao) mDao$delegate.getValue();
    }

    public final void deleteAll() {
        getMDao().deleteAll();
    }

    public final DataHeartHrv getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            QueryBuilder<DataHeartHrv> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataHeartHrvDao.Properties.UserId.eq(userId);
            Property property = DataHeartHrvDao.Properties.Date;
            DataHeartHrv dataHeartHrv = (DataHeartHrv) android.support.v4.media.session.e.f(queryBuilder.where(eq, property.eq(date)).orderDesc(property), new Property[]{DataHeartHrvDao.Properties.Id}, 1);
            if (dataHeartHrv == null) {
                return null;
            }
            return dataHeartHrv;
        }
        QueryBuilder<DataHeartHrv> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq2 = DataHeartHrvDao.Properties.UserId.eq(userId);
        WhereCondition eq3 = DataHeartHrvDao.Properties.Mac.eq(str);
        Property property2 = DataHeartHrvDao.Properties.Date;
        DataHeartHrv dataHeartHrv2 = (DataHeartHrv) android.support.v4.media.session.e.f(queryBuilder2.where(eq2, eq3, property2.eq(date)), new Property[]{property2}, 1);
        if (dataHeartHrv2 == null) {
            return null;
        }
        return dataHeartHrv2;
    }

    public final List<DataHeartHrv> getUploadHrs(String userId) {
        e.f(userId, "userId");
        List<DataHeartHrv> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataHeartHrvDao.Properties.UserId.eq(userId), DataHeartHrvDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataHeartHrvDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataHeartHrv> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataHeartHrvDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataHeartHrvDao.Properties.Timestamp});
        List<? extends DataHeartHrv> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataHeartHrv) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataHeartHrv data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataHeartHrv> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataHeartHrv) it.next());
        }
        return true;
    }

    public final List<DataHeartHrv> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataHeartHrv> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataHeartHrvDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataHeartHrvDao.Properties.Mac.eq(str);
            Property property = DataHeartHrvDao.Properties.Date;
            List<DataHeartHrv> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataHeartHrvDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<DataHeartHrv> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataHeartHrvDao.Properties.UserId.eq(userId);
        Property property2 = DataHeartHrvDao.Properties.Date;
        Iterable<DataHeartHrv> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataHeartHrvDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataHeartHrv dataHeartHrv : w9) {
            if (str2.length() == 0 || !e.a(str2, dataHeartHrv.getDate())) {
                arrayList.add(dataHeartHrv);
                str2 = dataHeartHrv.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
