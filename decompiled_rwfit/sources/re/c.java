package re;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class c implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Cursor f18121a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f18122b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public int f18123c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n6.a f18124d;

    public c(n6.a aVar) {
        this.f18124d = aVar;
        this.f18121a = ((SQLiteDatabase) aVar.f16381b).rawQuery("SELECT * FROM filedownloader", null);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f18121a.moveToNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        FileDownloadModel R = n6.a.R(this.f18121a);
        this.f18123c = R.h();
        return R;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f18122b.add(Integer.valueOf(this.f18123c));
    }
}
