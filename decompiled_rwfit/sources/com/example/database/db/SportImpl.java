package com.example.database.db;

import android.util.Log;
import com.example.database.api.DBManger;
import com.example.database.dao.DataSportDao;
import com.example.database.table.DataSport;
import eh.b;
import java.util.Iterator;
import java.util.List;
import kotlin.a;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public final class SportImpl {
    public static final SportImpl INSTANCE = new SportImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.SportImpl$mDao$2
        @Override // oh.a
        public final DataSportDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataSportDao();
        }
    });

    private SportImpl() {
    }

    private final DataSportDao getMDao() {
        return (DataSportDao) mDao$delegate.getValue();
    }

    public final void delSportById(String userId, long j4, String mac) {
        e.f(userId, "userId");
        e.f(mac, "mac");
        DataSport dataSport = (DataSport) android.support.v4.media.session.e.f(getMDao().queryBuilder().where(DataSportDao.Properties.UserId.eq(userId), DataSportDao.Properties.Id.eq(Long.valueOf(j4)), DataSportDao.Properties.Mac.eq(mac)), new Property[]{DataSportDao.Properties.Date}, 1);
        if (dataSport == null) {
            dataSport = null;
        }
        if (dataSport != null) {
            INSTANCE.getMDao().delete(dataSport);
        }
    }

    public final List<DataSport> getAllData(String userId, String mac) {
        e.f(userId, "userId");
        e.f(mac, "mac");
        List<DataSport> list = getMDao().queryBuilder().where(DataSportDao.Properties.UserId.eq(userId), DataSportDao.Properties.Mac.eq(mac)).orderDesc(DataSportDao.Properties.Date).list();
        if (list == null) {
            return null;
        }
        return list;
    }

    public final DataSport getData(String userId, long j4, String mac) {
        e.f(userId, "userId");
        e.f(mac, "mac");
        DataSport dataSport = (DataSport) android.support.v4.media.session.e.f(getMDao().queryBuilder().where(DataSportDao.Properties.UserId.eq(userId), DataSportDao.Properties.Id.eq(Long.valueOf(j4)), DataSportDao.Properties.Mac.eq(mac)), new Property[]{DataSportDao.Properties.Date}, 1);
        if (dataSport == null) {
            return null;
        }
        return dataSport;
    }

    public final List<DataSport> getDataByDate(String userId, String date, String mac) {
        e.f(userId, "userId");
        e.f(date, "date");
        e.f(mac, "mac");
        QueryBuilder<DataSport> queryBuilder = getMDao().queryBuilder();
        WhereCondition eq = DataSportDao.Properties.UserId.eq(userId);
        Property property = DataSportDao.Properties.Date;
        List<DataSport> list = queryBuilder.where(eq, property.eq(date), DataSportDao.Properties.Mac.eq(mac)).orderDesc(property).list();
        if (list == null) {
            return null;
        }
        return list;
    }

    public final List<DataSport> getSportByType(String userId, int i3, String mac) {
        e.f(userId, "userId");
        e.f(mac, "mac");
        List<DataSport> list = getMDao().queryBuilder().where(DataSportDao.Properties.UserId.eq(userId), DataSportDao.Properties.SportType.eq(Integer.valueOf(i3)), DataSportDao.Properties.Mac.eq(mac)).orderDesc(DataSportDao.Properties.Date).list();
        if (list == null) {
            return null;
        }
        return list;
    }

    public final List<DataSport> getUploadSports(String userId) {
        e.f(userId, "userId");
        List<DataSport> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataSportDao.Properties.UserId.eq(userId), DataSportDao.Properties.IsUpdate.eq(Boolean.FALSE)), new Property[]{DataSportDao.Properties.Timestamp});
        return w8 == null ? EmptyList.INSTANCE : w8;
    }

    public final void mergeData(String userId, String targetUserId) {
        e.f(userId, "userId");
        e.f(targetUserId, "targetUserId");
        List<? extends DataSport> w8 = android.support.v4.media.session.e.w(getMDao().queryBuilder().where(DataSportDao.Properties.UserId.eq(userId), new WhereCondition[0]), new Property[]{DataSportDao.Properties.Timestamp});
        List<? extends DataSport> list = w8;
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c(w8);
        Iterator<T> it = w8.iterator();
        while (it.hasNext()) {
            ((DataSport) it.next()).setUserId(targetUserId);
        }
        saveDatas(w8);
    }

    public final long saveData(DataSport data) {
        e.f(data, "data");
        Log.e("SportImpl", "saveData " + com.example.baselibrary.utils.b.z(data));
        return getMDao().insertOrReplace(data);
    }

    public final boolean saveDatas(List<? extends DataSport> list) {
        if (list == null) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            INSTANCE.saveData((DataSport) it.next());
        }
        return true;
    }
}
