package com.example.database.api;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.example.database.dao.DaoMaster;
import com.example.database.dao.DataBloodOxygenDao;
import com.example.database.dao.DataBloodPressDao;
import com.example.database.dao.DataBodyTempDao;
import com.example.database.dao.DataBreatheDao;
import com.example.database.dao.DataHeartRateDao;
import com.example.database.dao.DataQrCodeDao;
import com.example.database.dao.DataSettingDao;
import com.example.database.dao.DataSleepDao;
import com.example.database.dao.DataSportDao;
import com.example.database.dao.DataStepDao;
import com.example.database.dao.DevicesDao;
import com.example.database.dao.UserDao;
import com.google.android.gms.internal.mlkit_vision_common.b6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;
import w7.a;
import w7.b;

/* loaded from: classes.dex */
public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
    public MySQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, str, cursorFactory);
    }

    @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
    public void onUpgrade(Database database, int i3, int i10) {
        boolean z5;
        int i11;
        Class[] clsArr;
        int i12;
        int i13;
        String str;
        if (i3 < i10) {
            Class[] clsArr2 = {UserDao.class, DevicesDao.class, DataStepDao.class, DataSleepDao.class, DataHeartRateDao.class, DataBodyTempDao.class, DataBloodPressDao.class, DataBloodOxygenDao.class, DataSettingDao.class, DataSportDao.class, DataQrCodeDao.class, DataBreatheDao.class};
            b6.f9873a = new WeakReference(new a() { // from class: com.example.database.api.MySQLiteOpenHelper.1
                @Override // w7.a
                public void onCreateAllTables(Database database2, boolean z6) {
                    DaoMaster.createAllTables(database2, z6);
                }

                @Override // w7.a
                public void onDropAllTables(Database database2, boolean z6) {
                    DaoMaster.dropAllTables(database2, z6);
                }
            });
            int i14 = 0;
            while (true) {
                z5 = true;
                String str2 = null;
                if (i14 >= 12) {
                    break;
                }
                DaoConfig daoConfig = new DaoConfig(database, clsArr2[i14]);
                String str3 = daoConfig.tablename;
                if (b6.a(database, false, str3)) {
                    try {
                        str2 = daoConfig.tablename.concat("_TEMP");
                        database.execSQL("DROP TABLE IF EXISTS " + str2 + Const.STR_MART_SEMICOLON);
                        database.execSQL("CREATE TEMPORARY TABLE " + str2 + " AS SELECT * FROM `" + str3 + "`;");
                        StringBuilder sb2 = new StringBuilder();
                        int i15 = 0;
                        while (true) {
                            String[] strArr = daoConfig.allColumns;
                            if (i15 >= strArr.length) {
                                break;
                            }
                            sb2.append(strArr[i15]);
                            sb2.append(Const.STR_MART_COMMA);
                            i15++;
                        }
                        if (sb2.length() > 0) {
                            sb2.deleteCharAt(sb2.length() - 1);
                        }
                    } catch (SQLException e) {
                        Log.e("MigrationHelper", "【Failed to generate temp table】" + str2, e);
                    }
                }
                i14++;
            }
            WeakReference weakReference = b6.f9873a;
            a aVar = weakReference != null ? (a) weakReference.get() : null;
            if (aVar != null) {
                aVar.onDropAllTables(database, true);
                aVar.onCreateAllTables(database, false);
            } else {
                b6.b(database, "dropTable", true, clsArr2);
                b6.b(database, "createTable", false, clsArr2);
            }
            int i16 = 0;
            for (i11 = 12; i16 < i11; i11 = 12) {
                String str4 = new DaoConfig(database, clsArr2[i16]).tablename;
                String concat = str4.concat("_TEMP");
                if (b6.a(database, z5, concat)) {
                    try {
                        ArrayList a3 = b.a(database, str4);
                        ArrayList a10 = b.a(database, concat);
                        ArrayList arrayList = new ArrayList(a3.size());
                        ArrayList arrayList2 = new ArrayList(a3.size());
                        int size = a10.size();
                        int i17 = 0;
                        while (i17 < size) {
                            Object obj = a10.get(i17);
                            i17++;
                            b bVar = (b) obj;
                            if (a3.contains(bVar)) {
                                clsArr = clsArr2;
                                try {
                                    StringBuilder sb3 = new StringBuilder();
                                    i12 = i16;
                                    try {
                                        sb3.append('`');
                                        sb3.append(bVar.f19520b);
                                        sb3.append('`');
                                        String sb4 = sb3.toString();
                                        arrayList2.add(sb4);
                                        arrayList.add(sb4);
                                    } catch (SQLException e10) {
                                        e = e10;
                                        Log.e("MigrationHelper", "【Failed to restore data from temp table 】" + concat, e);
                                        i16 = i12 + 1;
                                        clsArr2 = clsArr;
                                        z5 = true;
                                    }
                                } catch (SQLException e11) {
                                    e = e11;
                                    i12 = i16;
                                    Log.e("MigrationHelper", "【Failed to restore data from temp table 】" + concat, e);
                                    i16 = i12 + 1;
                                    clsArr2 = clsArr;
                                    z5 = true;
                                }
                            } else {
                                clsArr = clsArr2;
                                i12 = i16;
                            }
                            clsArr2 = clsArr;
                            i16 = i12;
                        }
                        clsArr = clsArr2;
                        i12 = i16;
                        int size2 = a3.size();
                        int i18 = 0;
                        while (i18 < size2) {
                            Object obj2 = a3.get(i18);
                            i18++;
                            b bVar2 = (b) obj2;
                            if (!bVar2.f19522d || a10.contains(bVar2)) {
                                i13 = size2;
                            } else {
                                String str5 = '`' + bVar2.f19520b + '`';
                                arrayList2.add(str5);
                                if (bVar2.e != null) {
                                    StringBuilder sb5 = new StringBuilder();
                                    i13 = size2;
                                    sb5.append("'");
                                    sb5.append(bVar2.e);
                                    sb5.append("' AS ");
                                    str = sb5.toString();
                                } else {
                                    i13 = size2;
                                    str = "'' AS ";
                                }
                                arrayList.add(str + str5);
                            }
                            size2 = i13;
                        }
                        if (arrayList2.size() != 0) {
                            database.execSQL("REPLACE INTO `" + str4 + "` (" + TextUtils.join(Const.STR_MART_COMMA, arrayList2) + ") SELECT " + TextUtils.join(Const.STR_MART_COMMA, arrayList) + " FROM " + concat + Const.STR_MART_SEMICOLON);
                        }
                        database.execSQL("DROP TABLE " + concat);
                    } catch (SQLException e12) {
                        e = e12;
                        clsArr = clsArr2;
                    }
                } else {
                    clsArr = clsArr2;
                    i12 = i16;
                }
                i16 = i12 + 1;
                clsArr2 = clsArr;
                z5 = true;
            }
        }
    }
}
