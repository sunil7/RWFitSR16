package ca;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.internal.mlkit_common.o;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import o2.m;
import q9.n;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f3407d = null;
    public static String e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f3408f = false;

    /* renamed from: g, reason: collision with root package name */
    public static int f3409g = -1;

    /* renamed from: h, reason: collision with root package name */
    public static Boolean f3410h;

    /* renamed from: l, reason: collision with root package name */
    public static k f3414l;

    /* renamed from: m, reason: collision with root package name */
    public static l f3415m;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3416a;

    /* renamed from: i, reason: collision with root package name */
    public static final ThreadLocal f3411i = new ThreadLocal();

    /* renamed from: j, reason: collision with root package name */
    public static final h f3412j = new h(0);

    /* renamed from: k, reason: collision with root package name */
    public static final hc.a f3413k = new hc.a(3);

    /* renamed from: b, reason: collision with root package name */
    public static final n9.e f3405b = new n9.e(3);

    /* renamed from: c, reason: collision with root package name */
    public static final o f3406c = new o(4);

    public d(Context context) {
        this.f3416a = context;
    }

    public static int a(Context context, String str) {
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (n.h(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e10) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage())));
            return 0;
        }
    }

    public static d c(Context context, c cVar, String str) {
        long j4;
        d dVar;
        Boolean bool;
        ba.a B;
        d dVar2;
        l lVar;
        boolean z5;
        ba.a B2;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new DynamiteModule$LoadingException("null application Context", null);
        }
        ThreadLocal threadLocal = f3411i;
        i iVar = (i) threadLocal.get();
        i iVar2 = new i();
        threadLocal.set(iVar2);
        h hVar = f3412j;
        Long l3 = (Long) hVar.get();
        long longValue = l3.longValue();
        try {
            hVar.set(Long.valueOf(SystemClock.elapsedRealtime()));
            b4.g k10 = cVar.k(context, str, f3413k);
            int i3 = k10.f3158a;
            j4 = longValue;
            try {
                Log.i("DynamiteModule", "Considering local module " + str + ":" + i3 + " and remote module " + str + ":" + k10.f3159b);
                int i10 = k10.f3160c;
                if (i10 != 0) {
                    if (i10 == -1) {
                        if (k10.f3158a != 0) {
                            i10 = -1;
                        }
                    }
                    if (i10 != 1 || k10.f3159b != 0) {
                        if (i10 == -1) {
                            Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
                            dVar = new d(applicationContext);
                        } else {
                            if (i10 != 1) {
                                throw new DynamiteModule$LoadingException("VersionPolicy returned invalid code:" + i10, null);
                            }
                            try {
                                int i11 = k10.f3159b;
                                try {
                                    synchronized (d.class) {
                                        if (!g(context)) {
                                            throw new DynamiteModule$LoadingException("Remote loading disabled", null);
                                        }
                                        bool = f3407d;
                                    }
                                    if (bool == null) {
                                        throw new DynamiteModule$LoadingException("Failed to determine which loading route to use.", null);
                                    }
                                    if (bool.booleanValue()) {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i11);
                                        synchronized (d.class) {
                                            lVar = f3415m;
                                        }
                                        if (lVar == null) {
                                            throw new DynamiteModule$LoadingException("DynamiteLoaderV2 was not cached.", null);
                                        }
                                        i iVar3 = (i) threadLocal.get();
                                        if (iVar3 == null || iVar3.f3421a == null) {
                                            throw new DynamiteModule$LoadingException("No result cursor", null);
                                        }
                                        Context applicationContext2 = context.getApplicationContext();
                                        Cursor cursor = iVar3.f3421a;
                                        new ba.b(null);
                                        synchronized (d.class) {
                                            z5 = f3409g >= 2;
                                        }
                                        if (z5) {
                                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                            B2 = lVar.C(new ba.b(applicationContext2), str, i11, new ba.b(cursor));
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                            B2 = lVar.B(new ba.b(applicationContext2), str, i11, new ba.b(cursor));
                                        }
                                        Context context2 = (Context) ba.b.B(B2);
                                        if (context2 == null) {
                                            throw new DynamiteModule$LoadingException("Failed to get module context", null);
                                        }
                                        dVar2 = new d(context2);
                                    } else {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i11);
                                        k h4 = h(context);
                                        if (h4 == null) {
                                            throw new DynamiteModule$LoadingException("Failed to create IDynamiteLoader.", null);
                                        }
                                        Parcel m10 = h4.m(h4.y(), 6);
                                        int readInt = m10.readInt();
                                        m10.recycle();
                                        if (readInt >= 3) {
                                            i iVar4 = (i) threadLocal.get();
                                            if (iVar4 == null) {
                                                throw new DynamiteModule$LoadingException("No cached result cursor holder", null);
                                            }
                                            B = h4.C(new ba.b(context), str, i11, new ba.b(iVar4.f3421a));
                                        } else if (readInt == 2) {
                                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                                            B = h4.D(new ba.b(context), str, i11);
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                            B = h4.B(new ba.b(context), str, i11);
                                        }
                                        Object B3 = ba.b.B(B);
                                        if (B3 == null) {
                                            throw new DynamiteModule$LoadingException("Failed to load remote module.", null);
                                        }
                                        dVar2 = new d((Context) B3);
                                    }
                                    dVar = dVar2;
                                } catch (RemoteException e10) {
                                    throw new DynamiteModule$LoadingException("Failed to load remote module.", e10, null);
                                } catch (DynamiteModule$LoadingException e11) {
                                    throw e11;
                                } catch (Throwable th2) {
                                    throw new DynamiteModule$LoadingException("Failed to load remote module.", th2, null);
                                }
                            } catch (DynamiteModule$LoadingException e12) {
                                Log.w("DynamiteModule", "Failed to load remote module: " + e12.getMessage());
                                int i12 = k10.f3158a;
                                if (i12 == 0 || cVar.k(context, str, new m((byte) 0, i12, 3)).f3160c != -1) {
                                    throw new DynamiteModule$LoadingException("Remote load failed. No local fallback found.", e12, null);
                                }
                                Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
                                dVar = new d(applicationContext);
                            }
                        }
                        if (j4 == 0) {
                            f3412j.remove();
                        } else {
                            f3412j.set(l3);
                        }
                        Cursor cursor2 = iVar2.f3421a;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        f3411i.set(iVar);
                        return dVar;
                    }
                }
                throw new DynamiteModule$LoadingException("No acceptable module " + str + " found. Local version is " + k10.f3158a + " and remote version is " + k10.f3159b + ".", null);
            } catch (Throwable th3) {
                th = th3;
                if (j4 == 0) {
                    f3412j.remove();
                } else {
                    f3412j.set(l3);
                }
                Cursor cursor3 = iVar2.f3421a;
                if (cursor3 != null) {
                    cursor3.close();
                }
                f3411i.set(iVar);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            j4 = longValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x017c, code lost:
    
        if (r2 != false) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(android.content.Context r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.d.d(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b8, code lost:
    
        r9.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(android.content.Context r9, java.lang.String r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.d.e(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static void f(ClassLoader classLoader) {
        l lVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                lVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                lVar = queryLocalInterface instanceof l ? (l) queryLocalInterface : new l(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 2);
            }
            f3415m = lVar;
        } catch (ClassNotFoundException e10) {
            e = e10;
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e, null);
        } catch (IllegalAccessException e11) {
            e = e11;
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e, null);
        } catch (InstantiationException e12) {
            e = e12;
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e, null);
        } catch (NoSuchMethodException e13) {
            e = e13;
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e, null);
        } catch (InvocationTargetException e14) {
            e = e14;
            throw new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", e, null);
        }
    }

    public static boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f3410h)) {
            return true;
        }
        boolean z5 = false;
        if (f3410h == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (n9.c.f16440b.c(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z5 = true;
            }
            f3410h = Boolean.valueOf(z5);
            if (z5 && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f3408f = true;
            }
        }
        if (!z5) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z5;
    }

    public static k h(Context context) {
        k kVar;
        synchronized (d.class) {
            k kVar2 = f3414l;
            if (kVar2 != null) {
                return kVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    kVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    kVar = queryLocalInterface instanceof k ? (k) queryLocalInterface : new k(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 2);
                }
                if (kVar != null) {
                    f3414l = kVar;
                    return kVar;
                }
            } catch (Exception e10) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e10.getMessage());
            }
            return null;
        }
    }

    public final IBinder b(String str) {
        try {
            return (IBinder) this.f3416a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new DynamiteModule$LoadingException("Failed to instantiate module class: ".concat(str), e10, null);
        }
    }
}
