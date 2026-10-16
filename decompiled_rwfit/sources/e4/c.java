package e4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.e;
import d4.p;
import d4.q;
import java.io.File;
import java.io.FileNotFoundException;
import x3.f;

/* loaded from: classes.dex */
public final class c implements e {

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f12449k = {"_data"};

    /* renamed from: a, reason: collision with root package name */
    public final Context f12450a;

    /* renamed from: b, reason: collision with root package name */
    public final q f12451b;

    /* renamed from: c, reason: collision with root package name */
    public final q f12452c;

    /* renamed from: d, reason: collision with root package name */
    public final Uri f12453d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12454f;

    /* renamed from: g, reason: collision with root package name */
    public final f f12455g;

    /* renamed from: h, reason: collision with root package name */
    public final Class f12456h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f12457i;

    /* renamed from: j, reason: collision with root package name */
    public volatile e f12458j;

    public c(Context context, q qVar, q qVar2, Uri uri, int i3, int i10, f fVar, Class cls) {
        this.f12450a = context.getApplicationContext();
        this.f12451b = qVar;
        this.f12452c = qVar2;
        this.f12453d = uri;
        this.e = i3;
        this.f12454f = i10;
        this.f12455g = fVar;
        this.f12456h = cls;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return this.f12456h;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        e eVar = this.f12458j;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final e c() {
        boolean isExternalStorageLegacy;
        p a3;
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        f fVar = this.f12455g;
        int i3 = this.f12454f;
        int i10 = this.e;
        Context context = this.f12450a;
        if (isExternalStorageLegacy) {
            Uri uri = this.f12453d;
            try {
                Cursor query = context.getContentResolver().query(uri, f12449k, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(query.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty(string)) {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                            File file = new File(string);
                            query.close();
                            a3 = this.f12451b.a(file, i10, i3, fVar);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            int checkSelfPermission = context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
            Uri uri2 = this.f12453d;
            if (checkSelfPermission == 0) {
                uri2 = MediaStore.setRequireOriginal(uri2);
            }
            a3 = this.f12452c.a(uri2, i10, i3, fVar);
        }
        if (a3 != null) {
            return a3.f12282c;
        }
        return null;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f12457i = true;
        e eVar = this.f12458j;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource e() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void f(Priority priority, com.bumptech.glide.load.data.d dVar) {
        try {
            e c9 = c();
            if (c9 == null) {
                dVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f12453d));
            } else {
                this.f12458j = c9;
                if (this.f12457i) {
                    cancel();
                } else {
                    c9.f(priority, dVar);
                }
            }
        } catch (FileNotFoundException e) {
            dVar.c(e);
        }
    }
}
