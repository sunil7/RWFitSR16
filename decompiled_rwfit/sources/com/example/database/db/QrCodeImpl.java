package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.DataQrCodeDao;
import com.example.database.table.DataQrCode;
import eh.b;
import java.util.List;
import kotlin.a;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class QrCodeImpl {
    public static final QrCodeImpl INSTANCE = new QrCodeImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.QrCodeImpl$mDao$2
        @Override // oh.a
        public final DataQrCodeDao invoke() {
            return DBManger.getInstance().getDaoSession().getDataQrCodeDao();
        }
    });

    private QrCodeImpl() {
    }

    private final DataQrCodeDao getMDao() {
        return (DataQrCodeDao) mDao$delegate.getValue();
    }

    public final void delQrCode(DataQrCode dataQrCode) {
        e.f(dataQrCode, "dataQrCode");
        getMDao().delete(dataQrCode);
    }

    public final DataQrCode getQrCode(String userId, String mac, int i3) {
        e.f(userId, "userId");
        e.f(mac, "mac");
        DataQrCode unique = getMDao().queryBuilder().where(DataQrCodeDao.Properties.UserId.eq(userId), DataQrCodeDao.Properties.Mac.eq(mac), DataQrCodeDao.Properties.QrCodeType.eq(Integer.valueOf(i3))).limit(1).build().unique();
        if (unique == null) {
            return null;
        }
        return unique;
    }

    public final void mergeData(String userId, String mac, String targetUserId) {
        e.f(userId, "userId");
        e.f(mac, "mac");
        e.f(targetUserId, "targetUserId");
        List<DataQrCode> list = getMDao().queryBuilder().where(DataQrCodeDao.Properties.UserId.eq(userId), DataQrCodeDao.Properties.Mac.eq(mac)).build().list();
        List<DataQrCode> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        e.c(list);
        for (DataQrCode dataQrCode : list) {
            dataQrCode.setUserId(targetUserId);
            INSTANCE.saveQrCode(dataQrCode);
        }
    }

    public final long saveQrCode(DataQrCode dataQrCode) {
        e.f(dataQrCode, "dataQrCode");
        return getMDao().insertOrReplace(dataQrCode);
    }
}
