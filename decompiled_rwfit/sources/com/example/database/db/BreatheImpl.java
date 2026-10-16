package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataBreatheDao;
import com.example.database.table.DataBreathe;
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
public final class BreatheImpl {
    public static final BreatheImpl INSTANCE = new BreatheImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.BreatheImpl$mDao$2
        @Override // oh.a
        public final DataBreatheDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataBreatheDao();
        }
    });

    private BreatheImpl() {
    }

    private final DataBreatheDao getMDao() {
        return (DataBreatheDao) mDao$delegate.getValue();
    }

    public final DataBreathe getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            QueryBuilder<DataBreathe> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataBreatheDao.Properties.UserId.eq(userId);
            Property property = DataBreatheDao.Properties.Date;
            DataBreathe dataBreathe = (DataBreathe) android.support.v4.media.session.e.f(queryBuilder.where(eq, property.eq(date)).orderDesc(property), new Property[]{DataBreatheDao.Properties.Id}, 1);
            if (dataBreathe == null) {
                return null;
            }
            return dataBreathe;
        }
        QueryBuilder<DataBreathe> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq2 = DataBreatheDao.Properties.UserId.eq(userId);
        WhereCondition eq3 = DataBreatheDao.Properties.Mac.eq(str);
        Property property2 = DataBreatheDao.Properties.Date;
        DataBreathe dataBreathe2 = (DataBreathe) android.support.v4.media.session.e.f(queryBuilder2.where(eq2, eq3, property2.eq(date)), new Property[]{property2}, 1);
        if (dataBreathe2 == null) {
            return null;
        }
        return dataBreathe2;
    }

    public final List<DataBreathe> getUploadBreathes(String userId) {
        e.f(userId, "userId");
        List<DataBreathe> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataBreatheDao.Properties.UserId.eq(userId), DataBreatheDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataBreatheDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataBreathe> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataBreatheDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataBreatheDao.Properties.Timestamp});
        List<? extends DataBreathe> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataBreathe) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataBreathe data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataBreathe> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataBreathe) it.next());
        }
        return true;
    }

    public final List<DataBreathe> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataBreathe> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataBreatheDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataBreatheDao.Properties.Mac.eq(str);
            Property property = DataBreatheDao.Properties.Date;
            List<DataBreathe> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataBreatheDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<DataBreathe> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataBreatheDao.Properties.UserId.eq(userId);
        Property property2 = DataBreatheDao.Properties.Date;
        Iterable<DataBreathe> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataBreatheDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataBreathe dataBreathe : w9) {
            if (str2.length() == 0 || !e.a(str2, dataBreathe.getDate())) {
                arrayList.add(dataBreathe);
                str2 = dataBreathe.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
