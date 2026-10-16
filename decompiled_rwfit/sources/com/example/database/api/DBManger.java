package com.example.database.api;

import android.content.Context;
import com.example.database.dao.DaoMaster;
import com.example.database.dao.DaoSession;

/* loaded from: classes.dex */
public class DBManger {
    private static final String DATA_BASE_NAME = "DHouseFit.db";
    private static final String DB_PASSWORD = "xX2022";
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static SqlCipherHelper mHelper;
    private static volatile DBManger mInstance;
    private Context context;

    public static DBManger getInstance() {
        if (mInstance == null) {
            synchronized (DBManger.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new DBManger();
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    public synchronized void closeConnection() {
        closeHelper();
        closeDaoSession();
        mDaoMaster = null;
    }

    public void closeDaoSession() {
        DaoSession daoSession = mDaoSession;
        if (daoSession != null) {
            daoSession.clear();
            mDaoSession = null;
        }
    }

    public void closeHelper() {
        SqlCipherHelper sqlCipherHelper = mHelper;
        if (sqlCipherHelper != null) {
            sqlCipherHelper.close();
            mHelper = null;
        }
    }

    public synchronized DaoMaster getDaoMaster() {
        try {
            if (mDaoMaster == null) {
                SqlCipherHelper sqlCipherHelper = new SqlCipherHelper(this.context, DATA_BASE_NAME, DB_PASSWORD);
                mHelper = sqlCipherHelper;
                DaoMaster daoMaster = new DaoMaster(sqlCipherHelper.getEncryptedDatabase());
                mDaoMaster = daoMaster;
                mDaoSession = daoMaster.newSession();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return mDaoMaster;
    }

    public synchronized DaoSession getDaoSession() {
        try {
            if (mDaoSession == null) {
                if (mDaoMaster == null) {
                    mDaoMaster = getDaoMaster();
                }
                mDaoSession = mDaoMaster.newSession();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return mDaoSession;
    }

    public void init(Context context) {
        this.context = context;
        System.loadLibrary("sqlcipher");
    }
}
