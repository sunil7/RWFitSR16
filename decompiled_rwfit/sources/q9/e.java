package q9;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zax;
import com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class e implements b {

    /* renamed from: b, reason: collision with root package name */
    public static e f17811b;

    /* renamed from: c, reason: collision with root package name */
    public static final RootTelemetryConfiguration f17812c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* renamed from: d, reason: collision with root package name */
    public static final e f17813d = new e();

    /* renamed from: a, reason: collision with root package name */
    public Object f17814a;

    public /* synthetic */ e(Object obj) {
        this.f17814a = obj;
    }

    public static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f17811b == null) {
                    f17811b = new e();
                }
                eVar = f17811b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    public static View e(Context context, int i3, int i10) {
        e eVar = f17813d;
        try {
            zax zaxVar = new zax(1, i3, i10, null);
            return (View) ba.b.B(((j) eVar.d(context)).B(new ba.b(context), zaxVar));
        } catch (Exception e) {
            throw new RemoteCreator$RemoteCreatorException(l0.i(i3, i10, "Could not get button with size ", " and color "), e);
        }
    }

    @Override // q9.b
    public void a(ConnectionResult connectionResult) {
        boolean k10 = connectionResult.k();
        ha.a aVar = (ha.a) this.f17814a;
        if (k10) {
            aVar.l(null, aVar.f9133w);
            return;
        }
        i iVar = aVar.f9126o;
        if (iVar != null) {
            iVar.f17822a.m(connectionResult);
        }
    }

    public j c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return queryLocalInterface instanceof j ? (j) queryLocalInterface : new j(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator", 1);
    }

    public Object d(Context context) {
        Context context2;
        if (((j) this.f17814a) == null) {
            n.e(context);
            AtomicBoolean atomicBoolean = n9.d.f16441a;
            try {
                context2 = context.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused) {
                context2 = null;
            }
            if (context2 == null) {
                throw new RemoteCreator$RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.f17814a = c((IBinder) context2.getClassLoader().loadClass("com.google.android.gms.common.ui.SignInButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new RemoteCreator$RemoteCreatorException("Could not load creator class.", e);
            } catch (IllegalAccessException e10) {
                throw new RemoteCreator$RemoteCreatorException("Could not access creator.", e10);
            } catch (InstantiationException e11) {
                throw new RemoteCreator$RemoteCreatorException("Could not instantiate creator.", e11);
            }
        }
        return (j) this.f17814a;
    }
}
