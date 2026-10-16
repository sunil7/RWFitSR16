package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataBloodPressDao;
import com.example.database.table.DataBloodPress;
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
public final class BloodPressImpl {
    public static final BloodPressImpl INSTANCE = new BloodPressImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.BloodPressImpl$mDao$2
        @Override // oh.a
        public final DataBloodPressDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataBloodPressDao();
        }
    });

    private BloodPressImpl() {
    }

    private final DataBloodPressDao getMDao() {
        return (DataBloodPressDao) mDao$delegate.getValue();
    }

    public final DataBloodPress getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            QueryBuilder<DataBloodPress> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataBloodPressDao.Properties.UserId.eq(userId);
            Property property = DataBloodPressDao.Properties.Date;
            DataBloodPress dataBloodPress = (DataBloodPress) android.support.v4.media.session.e.f(queryBuilder.where(eq, property.eq(date)).orderDesc(property), new Property[]{DataBloodPressDao.Properties.Id}, 1);
            if (dataBloodPress == null) {
                return null;
            }
            return dataBloodPress;
        }
        QueryBuilder<DataBloodPress> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq2 = DataBloodPressDao.Properties.UserId.eq(userId);
        WhereCondition eq3 = DataBloodPressDao.Properties.Mac.eq(str);
        Property property2 = DataBloodPressDao.Properties.Date;
        DataBloodPress dataBloodPress2 = (DataBloodPress) android.support.v4.media.session.e.f(queryBuilder2.where(eq2, eq3, property2.eq(date)), new Property[]{property2}, 1);
        if (dataBloodPress2 == null) {
            return null;
        }
        return dataBloodPress2;
    }

    public final List<DataBloodPress> getUploadBps(String userId) {
        e.f(userId, "userId");
        List<DataBloodPress> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataBloodPressDao.Properties.UserId.eq(userId), DataBloodPressDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataBloodPressDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataBloodPress> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataBloodPressDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataBloodPressDao.Properties.Timestamp});
        List<? extends DataBloodPress> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataBloodPress) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataBloodPress data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataBloodPress> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataBloodPress) it.next());
        }
        return true;
    }

    public final List<DataBloodPress> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataBloodPress> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataBloodPressDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataBloodPressDao.Properties.Mac.eq(str);
            Property property = DataBloodPressDao.Properties.Date;
            List<DataBloodPress> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataBloodPressDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<DataBloodPress> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataBloodPressDao.Properties.UserId.eq(userId);
        Property property2 = DataBloodPressDao.Properties.Date;
        Iterable<DataBloodPress> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataBloodPressDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataBloodPress dataBloodPress : w9) {
            if (str2.length() == 0 || !e.a(str2, dataBloodPress.getDate())) {
                arrayList.add(dataBloodPress);
                str2 = dataBloodPress.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
