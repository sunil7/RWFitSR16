package p2;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;

/* loaded from: classes.dex */
public final class f implements SupportSQLiteOpenHelper.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f17410a;

    public f(Context context) {
        this.f17410a = context;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        SupportSQLiteOpenHelper.Configuration.Builder builder = SupportSQLiteOpenHelper.Configuration.builder(this.f17410a);
        builder.name(configuration.name).callback(configuration.callback).noBackupDirectory(true);
        return new FrameworkSQLiteOpenHelperFactory().create(builder.build());
    }
}
