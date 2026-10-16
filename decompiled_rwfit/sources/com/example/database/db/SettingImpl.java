package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataSettingDao;
import com.example.database.table.DataSetting;
import eh.b;
import java.util.Iterator;
import java.util.List;
import kotlin.a;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;

/* loaded from: classes.dex */
public final class SettingImpl {
    public static final SettingImpl INSTANCE = new SettingImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.SettingImpl$mDao$2
        @Override // oh.a
        public final DataSettingDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataSettingDao();
        }
    });

    private SettingImpl() {
    }

    private final DataSettingDao getMDao() {
        return (DataSettingDao) mDao$delegate.getValue();
    }

    public final void clearData(String userId, String mac) {
        e.f(userId, "userId");
        e.f(mac, "mac");
        QueryBuilder<DataSetting> queryBuilder = getMDao().queryBuilder();
        Property property = DataSettingDao.Properties.UserId;
        List<DataSetting> list = queryBuilder.where(property.eq(userId), DataSettingDao.Properties.Mac.eq(mac)).orderDesc(property).list();
        if (list == null) {
            list = EmptyList.INSTANCE;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            INSTANCE.getMDao().delete((DataSetting) it.next());
        }
    }

    public final DataSetting getData(String userId, String mac, String key) {
        e.f(userId, "userId");
        e.f(mac, "mac");
        e.f(key, "key");
        QueryBuilder<DataSetting> queryBuilder = getMDao().queryBuilder();
        Property property = DataSettingDao.Properties.UserId;
        DataSetting dataSetting = (DataSetting) android.support.v4.media.session.e.f(queryBuilder.where(property.eq(userId), DataSettingDao.Properties.Mac.eq(mac), DataSettingDao.Properties.DataKey.eq(key)), new Property[]{property}, 1);
        if (dataSetting == null) {
            return null;
        }
        return dataSetting;
    }

    public final void mergeData(String userId, String mac, String targetUserId) {
        e.f(userId, "userId");
        e.f(mac, "mac");
        e.f(targetUserId, "targetUserId");
        List<DataSetting> list = getMDao().queryBuilder().where(DataSettingDao.Properties.UserId.eq(userId), DataSettingDao.Properties.Mac.eq(mac)).build().list();
        List<DataSetting> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        e.c(list);
        for (DataSetting dataSetting : list) {
            dataSetting.setUserId(targetUserId);
            INSTANCE.saveData(dataSetting);
        }
    }

    public final long saveData(DataSetting data) {
        e.f(data, "data");
        return getMDao().insertOrReplace(data);
    }
}
