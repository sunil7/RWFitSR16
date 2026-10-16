package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataBodyTempDao;
import com.example.database.table.DataBodyTemp;
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
public final class BodyTempImpl {
    public static final BodyTempImpl INSTANCE = new BodyTempImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.BodyTempImpl$mDao$2
        @Override // oh.a
        public final DataBodyTempDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataBodyTempDao();
        }
    });

    private BodyTempImpl() {
    }

    private final DataBodyTempDao getMDao() {
        return (DataBodyTempDao) mDao$delegate.getValue();
    }

    public final DataBodyTemp getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            QueryBuilder<DataBodyTemp> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataBodyTempDao.Properties.UserId.eq(userId);
            Property property = DataBodyTempDao.Properties.Date;
            DataBodyTemp dataBodyTemp = (DataBodyTemp) android.support.v4.media.session.e.f(queryBuilder.where(eq, property.eq(date)).orderDesc(property), new Property[]{DataBodyTempDao.Properties.Id}, 1);
            if (dataBodyTemp == null) {
                return null;
            }
            return dataBodyTemp;
        }
        QueryBuilder<DataBodyTemp> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq2 = DataBodyTempDao.Properties.UserId.eq(userId);
        WhereCondition eq3 = DataBodyTempDao.Properties.Mac.eq(str);
        Property property2 = DataBodyTempDao.Properties.Date;
        DataBodyTemp dataBodyTemp2 = (DataBodyTemp) android.support.v4.media.session.e.f(queryBuilder2.where(eq2, eq3, property2.eq(date)), new Property[]{property2}, 1);
        if (dataBodyTemp2 == null) {
            return null;
        }
        return dataBodyTemp2;
    }

    public final List<DataBodyTemp> getUploadBts(String userId) {
        e.f(userId, "userId");
        List<DataBodyTemp> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataBodyTempDao.Properties.UserId.eq(userId), DataBodyTempDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataBodyTempDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataBodyTemp> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataBodyTempDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataBodyTempDao.Properties.Timestamp});
        List<? extends DataBodyTemp> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataBodyTemp) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataBodyTemp data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataBodyTemp> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataBodyTemp) it.next());
        }
        return true;
    }

    public final List<DataBodyTemp> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataBodyTemp> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataBodyTempDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataBodyTempDao.Properties.Mac.eq(str);
            Property property = DataBodyTempDao.Properties.Date;
            List<DataBodyTemp> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataBodyTempDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<DataBodyTemp> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataBodyTempDao.Properties.UserId.eq(userId);
        Property property2 = DataBodyTempDao.Properties.Date;
        Iterable<DataBodyTemp> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataBodyTempDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataBodyTemp dataBodyTemp : w9) {
            if (str2.length() == 0 || !e.a(str2, dataBodyTemp.getDate())) {
                arrayList.add(dataBodyTemp);
                str2 = dataBodyTemp.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
