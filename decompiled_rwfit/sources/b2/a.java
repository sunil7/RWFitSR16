package b2;

import android.content.Context;
import androidx.room.RoomDatabase$JournalMode;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Factory f3089a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f3090b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3091c;

    /* renamed from: d, reason: collision with root package name */
    public final h f3092d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3093f;

    public a(Context context, String str, SupportSQLiteOpenHelper.Factory factory, h hVar, ArrayList arrayList, boolean z5, RoomDatabase$JournalMode roomDatabase$JournalMode, Executor executor, Executor executor2, boolean z6, boolean z8) {
        this.f3089a = factory;
        this.f3090b = context;
        this.f3091c = str;
        this.f3092d = hVar;
        this.e = z6;
        this.f3093f = z8;
    }
}
