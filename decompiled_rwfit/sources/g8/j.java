package g8;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class j extends SQLiteOpenHelper {

    /* renamed from: c, reason: collision with root package name */
    public static final List f13895c = Arrays.asList(h.f13891b, h.f13892c, h.f13893d, h.e);

    /* renamed from: a, reason: collision with root package name */
    public final int f13896a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13897b;

    public j(Context context, String str, int i3) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i3);
        this.f13897b = false;
        this.f13896a = i3;
    }

    public static void b(SQLiteDatabase sQLiteDatabase, int i3, int i10) {
        List list = f13895c;
        if (i10 <= list.size()) {
            while (i3 < i10) {
                ((i) list.get(i3)).a(sQLiteDatabase);
                i3++;
            }
        } else {
            StringBuilder s7 = l0.s(i3, "Migration from ", i10, " to ", " was requested, but cannot be performed. Only ");
            s7.append(list.size());
            s7.append(" migrations are provided");
            throw new IllegalArgumentException(s7.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f13897b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (!this.f13897b) {
            onConfigure(sQLiteDatabase);
        }
        b(sQLiteDatabase, 0, this.f13896a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i10) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        if (!this.f13897b) {
            onConfigure(sQLiteDatabase);
        }
        b(sQLiteDatabase, 0, i10);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (this.f13897b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i10) {
        if (!this.f13897b) {
            onConfigure(sQLiteDatabase);
        }
        b(sQLiteDatabase, i3, i10);
    }
}
