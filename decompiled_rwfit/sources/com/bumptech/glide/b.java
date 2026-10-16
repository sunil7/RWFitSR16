package com.bumptech.glide;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.appcompat.app.t;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.load.data.m;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.test.ui.device.activity.e0;
import com.example.test.ui.device.activity.f0;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.ze;
import com.tencent.open.SocialConstants;
import d4.a0;
import d4.c0;
import d4.y;
import d4.z;
import g4.l;
import g4.o;
import g4.s;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class b implements ComponentCallbacks2 {

    /* renamed from: i, reason: collision with root package name */
    public static volatile b f6906i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f6907j;

    /* renamed from: a, reason: collision with root package name */
    public final a4.b f6908a;

    /* renamed from: b, reason: collision with root package name */
    public final b4.e f6909b;

    /* renamed from: c, reason: collision with root package name */
    public final f f6910c;

    /* renamed from: d, reason: collision with root package name */
    public final g f6911d;
    public final a4.g e;

    /* renamed from: f, reason: collision with root package name */
    public final m4.j f6912f;

    /* renamed from: g, reason: collision with root package name */
    public final hc.a f6913g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f6914h = new ArrayList();

    public b(Context context, com.bumptech.glide.load.engine.c cVar, b4.e eVar, a4.b bVar, a4.g gVar, m4.j jVar, hc.a aVar, ec.a aVar2, m0.b bVar2, List list, t tVar) {
        x3.g eVar2;
        x3.g aVar3;
        this.f6908a = bVar;
        this.e = gVar;
        this.f6909b = eVar;
        this.f6912f = jVar;
        this.f6913g = aVar;
        Resources resources = context.getResources();
        g gVar2 = new g();
        this.f6911d = gVar2;
        l lVar = new l();
        l4.c cVar2 = gVar2.f6930g;
        synchronized (cVar2) {
            cVar2.f15766a.add(lVar);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 27) {
            s sVar = new s();
            l4.c cVar3 = gVar2.f6930g;
            synchronized (cVar3) {
                cVar3.f15766a.add(sVar);
            }
        }
        ArrayList e = gVar2.e();
        k4.a aVar4 = new k4.a(context, e, bVar, gVar);
        com.bumptech.glide.load.resource.bitmap.b bVar3 = new com.bumptech.glide.load.resource.bitmap.b(bVar, new eb.e(12));
        o oVar = new o(gVar2.e(), resources.getDisplayMetrics(), bVar, gVar);
        if (!((Map) tVar.f568b).containsKey(c.class) || i3 < 28) {
            eVar2 = new g4.e(oVar, 0);
            aVar3 = new g4.a(3, oVar, gVar);
        } else {
            aVar3 = new g4.f(1);
            eVar2 = new g4.f(0);
        }
        i4.b bVar4 = new i4.b(context);
        a0 a0Var = new a0(resources, 0);
        y yVar = new y(resources, 1);
        z zVar = new z(resources);
        y yVar2 = new y(resources, 0);
        g4.b bVar5 = new g4.b(gVar);
        d6.a aVar5 = new d6.a(5);
        l4.d dVar = new l4.d(1);
        ContentResolver contentResolver = context.getContentResolver();
        gVar2.b(ByteBuffer.class, new c0(5));
        gVar2.b(InputStream.class, new f0(gVar, 13));
        gVar2.d("Bitmap", ByteBuffer.class, Bitmap.class, eVar2);
        gVar2.d("Bitmap", InputStream.class, Bitmap.class, aVar3);
        gVar2.d("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new g4.e(oVar, 1));
        gVar2.d("Bitmap", ParcelFileDescriptor.class, Bitmap.class, bVar3);
        gVar2.d("Bitmap", AssetFileDescriptor.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.b(bVar, new hc.a(11)));
        c0 c0Var = c0.f12247b;
        gVar2.a(Bitmap.class, Bitmap.class, c0Var);
        gVar2.d("Bitmap", Bitmap.class, Bitmap.class, new g4.z(0));
        gVar2.c(Bitmap.class, bVar5);
        gVar2.d("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new g4.a(resources, eVar2));
        gVar2.d("BitmapDrawable", InputStream.class, BitmapDrawable.class, new g4.a(resources, aVar3));
        gVar2.d("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new g4.a(resources, bVar3));
        gVar2.c(BitmapDrawable.class, new com.example.test.utils.y(bVar, 18, bVar5, false));
        gVar2.d("Gif", InputStream.class, k4.c.class, new k4.j(e, aVar4, gVar));
        gVar2.d("Gif", ByteBuffer.class, k4.c.class, aVar4);
        gVar2.c(k4.c.class, new eb.e(14));
        gVar2.a(w3.d.class, w3.d.class, c0Var);
        gVar2.d("Bitmap", w3.d.class, Bitmap.class, new i4.b(bVar));
        gVar2.d("legacy_append", Uri.class, Drawable.class, bVar4);
        gVar2.d("legacy_append", Uri.class, Bitmap.class, new g4.a(2, bVar4, bVar));
        gVar2.g(new com.bumptech.glide.load.data.h(2));
        gVar2.a(File.class, ByteBuffer.class, new c0(6));
        gVar2.a(File.class, InputStream.class, new d4.f(new c0(9)));
        gVar2.d("legacy_append", File.class, File.class, new g4.z(2));
        gVar2.a(File.class, ParcelFileDescriptor.class, new d4.f(new c0(8)));
        gVar2.a(File.class, File.class, c0Var);
        gVar2.g(new m(gVar));
        gVar2.g(new com.bumptech.glide.load.data.h(1));
        Class cls = Integer.TYPE;
        gVar2.a(cls, InputStream.class, a0Var);
        gVar2.a(cls, ParcelFileDescriptor.class, zVar);
        gVar2.a(Integer.class, InputStream.class, a0Var);
        gVar2.a(Integer.class, ParcelFileDescriptor.class, zVar);
        gVar2.a(Integer.class, Uri.class, yVar);
        gVar2.a(cls, AssetFileDescriptor.class, yVar2);
        gVar2.a(Integer.class, AssetFileDescriptor.class, yVar2);
        gVar2.a(cls, Uri.class, yVar);
        gVar2.a(String.class, InputStream.class, new i0(12));
        gVar2.a(Uri.class, InputStream.class, new i0(12));
        gVar2.a(String.class, InputStream.class, new c0(13));
        gVar2.a(String.class, ParcelFileDescriptor.class, new c0(12));
        gVar2.a(String.class, AssetFileDescriptor.class, new c0(11));
        gVar2.a(Uri.class, InputStream.class, new f0(context.getAssets(), 11));
        gVar2.a(Uri.class, ParcelFileDescriptor.class, new e0(context.getAssets(), 13));
        gVar2.a(Uri.class, InputStream.class, new a8.c(context, 2));
        gVar2.a(Uri.class, InputStream.class, new aa.b(context));
        if (i3 >= 29) {
            gVar2.a(Uri.class, InputStream.class, new e4.b(context, InputStream.class));
            gVar2.a(Uri.class, ParcelFileDescriptor.class, new e4.b(context, ParcelFileDescriptor.class));
        }
        int i10 = 14;
        gVar2.a(Uri.class, InputStream.class, new f0(contentResolver, i10));
        gVar2.a(Uri.class, ParcelFileDescriptor.class, new e0(contentResolver, i10));
        gVar2.a(Uri.class, AssetFileDescriptor.class, new i0(contentResolver, 13));
        gVar2.a(Uri.class, InputStream.class, new c0(14));
        gVar2.a(URL.class, InputStream.class, new com.google.android.gms.internal.mlkit_common.o(11));
        gVar2.a(Uri.class, File.class, new b4.d(context));
        gVar2.a(d4.g.class, InputStream.class, new e0(15));
        gVar2.a(byte[].class, ByteBuffer.class, new c0(2));
        gVar2.a(byte[].class, InputStream.class, new c0(4));
        gVar2.a(Uri.class, Uri.class, c0Var);
        gVar2.a(Drawable.class, Drawable.class, c0Var);
        gVar2.d("legacy_append", Drawable.class, Drawable.class, new g4.z(1));
        gVar2.h(Bitmap.class, BitmapDrawable.class, new z(resources));
        gVar2.h(Bitmap.class, byte[].class, aVar5);
        gVar2.h(Drawable.class, byte[].class, new de.o(bVar, 28, aVar5, dVar));
        gVar2.h(k4.c.class, byte[].class, dVar);
        com.bumptech.glide.load.resource.bitmap.b bVar6 = new com.bumptech.glide.load.resource.bitmap.b(bVar, new n9.e(11));
        gVar2.d("legacy_append", ByteBuffer.class, Bitmap.class, bVar6);
        gVar2.d("legacy_append", ByteBuffer.class, BitmapDrawable.class, new g4.a(resources, bVar6));
        this.f6910c = new f(context, gVar, gVar2, new hc.a(18), aVar2, bVar2, list, cVar, tVar);
    }

    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        ec.a aVar;
        m0.b bVar;
        if (f6907j) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f6907j = true;
        m0.b bVar2 = new m0.b();
        b2.h hVar = new b2.h();
        hVar.f3120a = new HashMap();
        ec.a aVar2 = new ec.a(4);
        Context applicationContext = context.getApplicationContext();
        List list = Collections.EMPTY_LIST;
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                if (Log.isLoggable("ManifestParser", 2)) {
                    Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
                }
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        ze.a(str);
                        throw null;
                    }
                }
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Finished loading Glide modules");
                }
            } else if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Got null app info metadata");
            }
            if (generatedAppGlideModule != null && !generatedAppGlideModule.a().isEmpty()) {
                generatedAppGlideModule.a();
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    throw android.support.v4.media.session.e.d(it);
                }
            }
            if (Log.isLoggable("Glide", 3)) {
                Iterator it2 = arrayList.iterator();
                if (it2.hasNext()) {
                    throw android.support.v4.media.session.e.d(it2);
                }
            }
            Iterator it3 = arrayList.iterator();
            if (it3.hasNext()) {
                throw android.support.v4.media.session.e.d(it3);
            }
            if (c4.c.f3380c == 0) {
                c4.c.f3380c = Math.min(4, Runtime.getRuntime().availableProcessors());
            }
            int i3 = c4.c.f3380c;
            if (TextUtils.isEmpty(SocialConstants.PARAM_SOURCE)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            c4.c cVar = new c4.c(new ThreadPoolExecutor(i3, i3, 0L, timeUnit, new PriorityBlockingQueue(), new c4.b(SocialConstants.PARAM_SOURCE, false)));
            if (TextUtils.isEmpty("disk-cache")) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
            }
            c4.c cVar2 = new c4.c(new ThreadPoolExecutor(1, 1, 0L, timeUnit, new PriorityBlockingQueue(), new c4.b("disk-cache", true)));
            if (c4.c.f3380c == 0) {
                c4.c.f3380c = Math.min(4, Runtime.getRuntime().availableProcessors());
            }
            int i10 = c4.c.f3380c >= 4 ? 2 : 1;
            if (TextUtils.isEmpty("animation")) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
            }
            c4.c cVar3 = new c4.c(new ThreadPoolExecutor(i10, i10, 0L, timeUnit, new PriorityBlockingQueue(), new c4.b("animation", true)));
            b4.f fVar = new b4.f(applicationContext);
            b4.g gVar = new b4.g();
            Context context2 = fVar.f3154a;
            ActivityManager activityManager = fVar.f3155b;
            int i11 = activityManager.isLowRamDevice() ? 2097152 : 4194304;
            gVar.f3160c = i11;
            int round = Math.round(activityManager.getMemoryClass() * Const.I_MAX_OFFLINE_DATA_CACHE * (activityManager.isLowRamDevice() ? 0.33f : 0.4f));
            DisplayMetrics displayMetrics = (DisplayMetrics) fVar.f3156c.f568b;
            float f2 = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
            float f10 = fVar.f3157d;
            int round2 = Math.round(f2 * f10);
            int round3 = Math.round(f2 * 2.0f);
            int i12 = round - i11;
            int i13 = round3 + round2;
            if (i13 <= i12) {
                gVar.f3159b = round3;
                gVar.f3158a = round2;
            } else {
                float f11 = i12 / (f10 + 2.0f);
                gVar.f3159b = Math.round(2.0f * f11);
                gVar.f3158a = Math.round(f11 * f10);
            }
            if (Log.isLoggable("MemorySizeCalculator", 3)) {
                StringBuilder sb2 = new StringBuilder("Calculation complete, Calculated memory cache size: ");
                aVar = aVar2;
                bVar = bVar2;
                sb2.append(Formatter.formatFileSize(context2, gVar.f3159b));
                sb2.append(", pool size: ");
                sb2.append(Formatter.formatFileSize(context2, gVar.f3158a));
                sb2.append(", byte array size: ");
                sb2.append(Formatter.formatFileSize(context2, i11));
                sb2.append(", memory class limited? ");
                sb2.append(i13 > round);
                sb2.append(", max size: ");
                sb2.append(Formatter.formatFileSize(context2, round));
                sb2.append(", memoryClass: ");
                sb2.append(activityManager.getMemoryClass());
                sb2.append(", isLowMemoryDevice: ");
                sb2.append(activityManager.isLowRamDevice());
                Log.d("MemorySizeCalculator", sb2.toString());
            } else {
                aVar = aVar2;
                bVar = bVar2;
            }
            hc.a aVar3 = new hc.a(14);
            int i14 = gVar.f3158a;
            a4.b hVar2 = i14 > 0 ? new a4.h(i14) : new eb.e(1);
            a4.g gVar2 = new a4.g(gVar.f3160c);
            b4.e eVar = new b4.e(gVar.f3159b);
            com.bumptech.glide.load.engine.c cVar4 = new com.bumptech.glide.load.engine.c(eVar, new y2.f(applicationContext), cVar2, cVar, new c4.c(new ThreadPoolExecutor(0, SubsamplingScaleImageView.TILE_SIZE_AUTO, c4.c.f3379b, timeUnit, new SynchronousQueue(), new c4.b("source-unlimited", false))), cVar3);
            List list2 = Collections.EMPTY_LIST;
            t tVar = new t(hVar);
            b bVar3 = new b(applicationContext, cVar4, eVar, hVar2, gVar2, new m4.j(tVar), aVar3, aVar, bVar, list2, tVar);
            Iterator it4 = arrayList.iterator();
            if (it4.hasNext()) {
                throw android.support.v4.media.session.e.d(it4);
            }
            applicationContext.registerComponentCallbacks(bVar3);
            f6906i = bVar3;
            f6907j = false;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    public static b b(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (f6906i == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
            } catch (InstantiationException e10) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e10);
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e12);
            }
            synchronized (b.class) {
                try {
                    if (f6906i == null) {
                        a(context, generatedAppGlideModule);
                    }
                } finally {
                }
            }
        }
        return f6906i;
    }

    public static j c(Context context) {
        t4.f.c(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return b(context).f6912f.b(context);
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        char[] cArr = t4.l.f18523a;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
        this.f6909b.g(0L);
        this.f6908a.n();
        a4.g gVar = this.e;
        synchronized (gVar) {
            gVar.b(0);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i3) {
        long j4;
        char[] cArr = t4.l.f18523a;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
        synchronized (this.f6914h) {
            try {
                ArrayList arrayList = this.f6914h;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((j) obj).getClass();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        b4.e eVar = this.f6909b;
        eVar.getClass();
        if (i3 >= 40) {
            eVar.g(0L);
        } else if (i3 >= 20 || i3 == 15) {
            synchronized (eVar) {
                j4 = eVar.f16250a;
            }
            eVar.g(j4 / 2);
        }
        this.f6908a.k(i3);
        a4.g gVar = this.e;
        synchronized (gVar) {
            if (i3 >= 40) {
                synchronized (gVar) {
                    gVar.b(0);
                }
            } else if (i3 >= 20 || i3 == 15) {
                gVar.b(gVar.e / 2);
            }
        }
    }
}
