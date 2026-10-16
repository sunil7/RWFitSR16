package com.example.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.example.database.table.DataQrCode;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import r5.a;

/* loaded from: classes.dex */
public class DataQrCodeDao extends AbstractDao<DataQrCode, Long> {
    public static final String TABLENAME = "t_data_qr_code";

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, FileDownloadModel.ID);
        public static final Property Mac = new Property(1, String.class, CoreUtil.STR_DEX_MAC_NAME, false, CoreUtil.STR_DEX_MAC_NAME);
        public static final Property UserId = new Property(2, String.class, "userId", false, "user_id");
        public static final Property QrCodeType = new Property(3, Integer.class, "qrCodeType", false, "qr_code_type");
        public static final Property QrCodeContent = new Property(4, String.class, "qrCodeContent", false, "qr_code_content");
        public static final Property QrCodeTitle = new Property(5, String.class, "qrCodeTitle", false, "qr_code_title");
    }

    public DataQrCodeDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z5) {
        String str = z5 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"t_data_qr_code\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"mac\" TEXT,\"user_id\" TEXT,\"qr_code_type\" INTEGER,\"qr_code_content\" TEXT,\"qr_code_title\" TEXT);");
        a.j(new StringBuilder("CREATE UNIQUE INDEX "), str, "IDX_t_data_qr_code_user_id_DESC_mac_DESC_qr_code_type_DESC ON \"t_data_qr_code\" (\"user_id\" DESC,\"mac\" DESC,\"qr_code_type\" DESC);", database);
    }

    public static void dropTable(Database database, boolean z5) {
        a.j(new StringBuilder("DROP TABLE "), z5 ? "IF EXISTS " : "", "\"t_data_qr_code\"", database);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DataQrCodeDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(DataQrCode dataQrCode) {
        if (dataQrCode != null) {
            return dataQrCode.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(DataQrCode dataQrCode) {
        return dataQrCode.getId() != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public Long readKey(Cursor cursor, int i3) {
        if (cursor.isNull(i3)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i3));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(DataQrCode dataQrCode, long j4) {
        dataQrCode.setId(Long.valueOf(j4));
        return Long.valueOf(j4);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, DataQrCode dataQrCode) {
        databaseStatement.clearBindings();
        Long id2 = dataQrCode.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String mac = dataQrCode.getMac();
        if (mac != null) {
            databaseStatement.bindString(2, mac);
        }
        String userId = dataQrCode.getUserId();
        if (userId != null) {
            databaseStatement.bindString(3, userId);
        }
        if (dataQrCode.getQrCodeType() != null) {
            databaseStatement.bindLong(4, r0.intValue());
        }
        String qrCodeContent = dataQrCode.getQrCodeContent();
        if (qrCodeContent != null) {
            databaseStatement.bindString(5, qrCodeContent);
        }
        String qrCodeTitle = dataQrCode.getQrCodeTitle();
        if (qrCodeTitle != null) {
            databaseStatement.bindString(6, qrCodeTitle);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public DataQrCode readEntity(Cursor cursor, int i3) {
        Long valueOf = cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3));
        int i10 = i3 + 1;
        int i11 = i3 + 2;
        int i12 = i3 + 3;
        int i13 = i3 + 4;
        int i14 = i3 + 5;
        return new DataQrCode(valueOf, cursor.isNull(i10) ? null : cursor.getString(i10), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : Integer.valueOf(cursor.getInt(i12)), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.isNull(i14) ? null : cursor.getString(i14));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, DataQrCode dataQrCode, int i3) {
        dataQrCode.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i10 = i3 + 1;
        dataQrCode.setMac(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i3 + 2;
        dataQrCode.setUserId(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i3 + 3;
        dataQrCode.setQrCodeType(cursor.isNull(i12) ? null : Integer.valueOf(cursor.getInt(i12)));
        int i13 = i3 + 4;
        dataQrCode.setQrCodeContent(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i3 + 5;
        dataQrCode.setQrCodeTitle(cursor.isNull(i14) ? null : cursor.getString(i14));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, DataQrCode dataQrCode) {
        sQLiteStatement.clearBindings();
        Long id2 = dataQrCode.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String mac = dataQrCode.getMac();
        if (mac != null) {
            sQLiteStatement.bindString(2, mac);
        }
        String userId = dataQrCode.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(3, userId);
        }
        if (dataQrCode.getQrCodeType() != null) {
            sQLiteStatement.bindLong(4, r0.intValue());
        }
        String qrCodeContent = dataQrCode.getQrCodeContent();
        if (qrCodeContent != null) {
            sQLiteStatement.bindString(5, qrCodeContent);
        }
        String qrCodeTitle = dataQrCode.getQrCodeTitle();
        if (qrCodeTitle != null) {
            sQLiteStatement.bindString(6, qrCodeTitle);
        }
    }
}
