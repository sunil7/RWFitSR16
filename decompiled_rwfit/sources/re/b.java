package re;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import ye.e;

/* loaded from: classes2.dex */
public final class b implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f18117a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public c f18118b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f18119c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f18120d;
    public final /* synthetic */ n6.a e;

    public b(n6.a aVar, SparseArray sparseArray, SparseArray sparseArray2) {
        this.e = aVar;
        this.f18119c = sparseArray;
        this.f18120d = sparseArray2;
    }

    public final void a() {
        SQLiteDatabase sQLiteDatabase;
        SparseArray sparseArray;
        int i3 = 1;
        c cVar = this.f18118b;
        if (cVar != null) {
            cVar.f18121a.close();
            ArrayList arrayList = cVar.f18122b;
            if (!arrayList.isEmpty()) {
                String join = TextUtils.join(", ", arrayList);
                n6.a aVar = cVar.f18124d;
                SQLiteDatabase sQLiteDatabase2 = (SQLiteDatabase) aVar.f16381b;
                int i10 = e.f20123a;
                Locale locale = Locale.ENGLISH;
                sQLiteDatabase2.execSQL("DELETE FROM filedownloader WHERE _id IN (" + join + ");");
                ((SQLiteDatabase) aVar.f16381b).execSQL(r5.a.f(new StringBuilder("DELETE FROM filedownloaderConnection WHERE id IN ("), join, ");"));
            }
        }
        SparseArray sparseArray2 = this.f18117a;
        int size = sparseArray2.size();
        if (size < 0) {
            return;
        }
        n6.a aVar2 = this.e;
        ((SQLiteDatabase) aVar2.f16381b).beginTransaction();
        int i11 = 0;
        while (true) {
            sQLiteDatabase = (SQLiteDatabase) aVar2.f16381b;
            if (i11 >= size) {
                break;
            }
            try {
                int keyAt = sparseArray2.keyAt(i11);
                FileDownloadModel fileDownloadModel = (FileDownloadModel) sparseArray2.get(keyAt);
                sQLiteDatabase.delete("filedownloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                sQLiteDatabase.insert("filedownloader", null, fileDownloadModel.H());
                if (fileDownloadModel.a() > i3) {
                    ArrayList J = aVar2.J(keyAt);
                    if (J.size() > 0) {
                        sQLiteDatabase.delete("filedownloaderConnection", "id = ?", new String[]{String.valueOf(keyAt)});
                        int size2 = J.size();
                        int i12 = 0;
                        while (i12 < size2) {
                            Object obj = J.get(i12);
                            i12 += i3;
                            ve.a aVar3 = (ve.a) obj;
                            int i13 = i3;
                            aVar3.f19231a = fileDownloadModel.h();
                            sQLiteDatabase.insert("filedownloaderConnection", null, aVar3.a());
                            i3 = i13;
                        }
                    }
                }
                i11++;
                i3 = i3;
            } finally {
            }
            sQLiteDatabase.endTransaction();
        }
        SparseArray sparseArray3 = this.f18119c;
        if (sparseArray3 != null && (sparseArray = this.f18120d) != null) {
            int size3 = sparseArray3.size();
            for (int i14 = 0; i14 < size3; i14++) {
                int h4 = ((FileDownloadModel) sparseArray3.valueAt(i14)).h();
                ArrayList J2 = aVar2.J(h4);
                if (J2.size() > 0) {
                    sparseArray.put(h4, J2);
                }
            }
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        c cVar = new c(this.e);
        this.f18118b = cVar;
        return cVar;
    }
}
