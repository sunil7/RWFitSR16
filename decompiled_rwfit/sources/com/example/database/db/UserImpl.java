package com.example.database.db;

import com.example.database.api.DBManger;
import com.example.database.dao.UserDao;
import com.example.database.table.User;
import eh.b;
import java.util.Iterator;
import java.util.List;
import kotlin.a;
import kotlin.jvm.internal.e;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public final class UserImpl {
    public static final UserImpl INSTANCE = new UserImpl();
    private static final b mDao$delegate = a.b(new oh.a() { // from class: com.example.database.db.UserImpl$mDao$2
        @Override // oh.a
        public final UserDao invoke() {
            return DBManger.getInstance().getDaoSession().getUserDao();
        }
    });

    private UserImpl() {
    }

    private final UserDao getMDao() {
        return (UserDao) mDao$delegate.getValue();
    }

    public final User queryUserById(String userId) {
        e.f(userId, "userId");
        User unique = getMDao().queryBuilder().where(UserDao.Properties.UserId.eq(userId), new WhereCondition[0]).build().unique();
        if (unique == null) {
            return null;
        }
        return unique;
    }

    public final User queryVisitor() {
        User unique = getMDao().queryBuilder().where(UserDao.Properties.Platform.eq(2), new WhereCondition[0]).build().unique();
        if (unique == null) {
            return null;
        }
        return unique;
    }

    public final void removeVisitor() {
        List<User> list = getMDao().queryBuilder().where(UserDao.Properties.Platform.eq(2), new WhereCondition[0]).build().list();
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                INSTANCE.getMDao().delete((User) it.next());
            }
        }
    }

    public final long saveUser(User user) {
        e.f(user, "user");
        return getMDao().insertOrReplace(user);
    }
}
