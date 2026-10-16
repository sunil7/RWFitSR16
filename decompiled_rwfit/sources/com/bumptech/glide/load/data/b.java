package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6959a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6960b;

    /* renamed from: c, reason: collision with root package name */
    public final Comparable f6961c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f6962d;

    public /* synthetic */ b(int i3, Comparable comparable, Object obj) {
        this.f6959a = i3;
        this.f6962d = obj;
        this.f6961c = comparable;
    }

    private final void c() {
    }

    private final void d() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch (this.f6959a) {
            case 0:
                Object obj = this.f6960b;
                if (obj != null) {
                    try {
                        g(obj);
                        break;
                    } catch (IOException unused) {
                        return;
                    }
                }
                break;
            default:
                Object obj2 = this.f6960b;
                if (obj2 != null) {
                    try {
                        g(obj2);
                        break;
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i3 = this.f6959a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource e() {
        switch (this.f6959a) {
        }
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void f(Priority priority, d dVar) {
        switch (this.f6959a) {
            case 0:
                try {
                    Object i3 = i((AssetManager) this.f6962d, (String) this.f6961c);
                    this.f6960b = i3;
                    dVar.d(i3);
                    break;
                } catch (IOException e) {
                    if (Log.isLoggable("AssetPathFetcher", 3)) {
                        Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
                    }
                    dVar.c(e);
                    return;
                }
            default:
                try {
                    Object h4 = h((ContentResolver) this.f6962d, (Uri) this.f6961c);
                    this.f6960b = h4;
                    dVar.d(h4);
                    break;
                } catch (FileNotFoundException e10) {
                    if (Log.isLoggable("LocalUriFetcher", 3)) {
                        Log.d("LocalUriFetcher", "Failed to open Uri", e10);
                    }
                    dVar.c(e10);
                }
        }
    }

    public abstract void g(Object obj);

    public abstract Object h(ContentResolver contentResolver, Uri uri);

    public abstract Object i(AssetManager assetManager, String str);
}
