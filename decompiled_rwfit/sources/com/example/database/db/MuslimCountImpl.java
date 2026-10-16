package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataMuslimCountDao;
import com.example.database.table.DataMuslimCount;
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
public final class MuslimCountImpl {
    public static final MuslimCountImpl INSTANCE = new MuslimCountImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.MuslimCountImpl$mDao$2
        @Override // oh.a
        public final DataMuslimCountDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataMuslimCountDao();
        }
    });

    private MuslimCountImpl() {
    }

    private final DataMuslimCountDao getMDao() {
        return (DataMuslimCountDao) mDao$delegate.getValue();
    }

    public final void deleteAday(DataMuslimCount data) {
        e.f(data, "data");
        getMDao().delete(data);
    }

    public final void deleteAll() {
        getMDao().deleteAll();
    }

    public final DataMuslimCount getDataByDate(String str, String userId, String date) {
        e.f(userId, "userId");
        e.f(date, "date");
        if (str == null || str.length() == 0) {
            QueryBuilder<DataMuslimCount> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataMuslimCountDao.Properties.UserId.eq(userId);
            Property property = DataMuslimCountDao.Properties.Date;
            DataMuslimCount dataMuslimCount = (DataMuslimCount) android.support.v4.media.session.e.f(queryBuilder.where(eq, property.eq(date)).orderDesc(property), new Property[]{DataMuslimCountDao.Properties.Id}, 1);
            if (dataMuslimCount == null) {
                return null;
            }
            return dataMuslimCount;
        }
        QueryBuilder<DataMuslimCount> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq2 = DataMuslimCountDao.Properties.UserId.eq(userId);
        WhereCondition eq3 = DataMuslimCountDao.Properties.Mac.eq(str);
        Property property2 = DataMuslimCountDao.Properties.Date;
        DataMuslimCount dataMuslimCount2 = (DataMuslimCount) android.support.v4.media.session.e.f(queryBuilder2.where(eq2, eq3, property2.eq(date)), new Property[]{property2}, 1);
        if (dataMuslimCount2 == null) {
            return null;
        }
        return dataMuslimCount2;
    }

    public final List<DataMuslimCount> getUploadMuslimCount(String userId) {
        e.f(userId, "userId");
        List<DataMuslimCount> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataMuslimCountDao.Properties.UserId.eq(userId), DataMuslimCountDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataMuslimCountDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataMuslimCount> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataMuslimCountDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataMuslimCountDao.Properties.Timestamp});
        List<? extends DataMuslimCount> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataMuslimCount) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataMuslimCount data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataMuslimCount> datas) {
        e.f(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataMuslimCount) it.next());
        }
        return true;
    }

    public final List<DataMuslimCount> getDataByDate(String str, String userId, String startDate, String endDate) {
        e.f(userId, "userId");
        e.f(startDate, "startDate");
        e.f(endDate, "endDate");
        if (str != null && str.length() != 0) {
            QueryBuilder<DataMuslimCount> queryBuilder = getMDao().queryBuilder();
            WhereCondition eq = DataMuslimCountDao.Properties.UserId.eq(userId);
            WhereCondition eq2 = DataMuslimCountDao.Properties.Mac.eq(str);
            Property property = DataMuslimCountDao.Properties.Date;
            List<DataMuslimCount> w8 = android.support.v4.media.session.e.w(queryBuilder.where(eq, eq2, property.le(endDate), property.ge(startDate)), new Property[]{DataMuslimCountDao.Properties.Timestamp});
            return w8 == null ? EmptyList.INSTANCE : w8;
        }
        QueryBuilder<DataMuslimCount> queryBuilder2 = getMDao().queryBuilder();
        WhereCondition eq3 = DataMuslimCountDao.Properties.UserId.eq(userId);
        Property property2 = DataMuslimCountDao.Properties.Date;
        Iterable<DataMuslimCount> w9 = android.support.v4.media.session.e.w(queryBuilder2.where(eq3, property2.le(endDate), property2.ge(startDate)), new Property[]{DataMuslimCountDao.Properties.Timestamp});
        if (w9 == null) {
            w9 = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        for (DataMuslimCount dataMuslimCount : w9) {
            if (str2.length() == 0 || !e.a(str2, dataMuslimCount.getDate())) {
                arrayList.add(dataMuslimCount);
                str2 = dataMuslimCount.getDate();
                e.e(str2, "getDate(...)");
            }
        }
        return arrayList;
    }
}
