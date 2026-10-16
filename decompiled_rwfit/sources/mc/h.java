package mc;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.ag;
import com.google.android.gms.internal.mlkit_vision_barcode.fg;
import com.google.android.gms.internal.mlkit_vision_barcode.gg;
import com.google.android.gms.internal.mlkit_vision_barcode.hg;
import com.google.android.gms.internal.mlkit_vision_barcode.ig;
import com.google.android.gms.internal.mlkit_vision_barcode.t;
import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyd;
import com.google.mlkit.common.MlKitException;
import gc.k;
import ia.m;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class h implements f {

    /* renamed from: h, reason: collision with root package name */
    public static final zzcs f16023h = zzcs.zzh("com.google.android.gms.vision.barcode", "com.google.android.gms.tflite_dynamite");

    /* renamed from: a, reason: collision with root package name */
    public boolean f16024a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16025b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16026c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f16027d;
    public final ic.b e;

    /* renamed from: f, reason: collision with root package name */
    public final ag f16028f;

    /* renamed from: g, reason: collision with root package name */
    public fg f16029g;

    public h(Context context, ic.b bVar, ag agVar) {
        this.f16027d = context;
        this.e = bVar;
        this.f16028f = agVar;
    }

    public final fg a(ca.c cVar, String str, String str2) {
        IInterface ggVar;
        Context context = this.f16027d;
        IBinder b3 = ca.d.c(context, cVar, str).b(str2);
        int i3 = hg.f9338b;
        fg fgVar = null;
        if (b3 == null) {
            ggVar = null;
        } else {
            IInterface queryLocalInterface = b3.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
            ggVar = queryLocalInterface instanceof ig ? (ig) queryLocalInterface : new gg(b3, "com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator", 0);
        }
        ba.b bVar = new ba.b(context);
        zzyd zzydVar = new zzyd(this.e.f14405a, false);
        gg ggVar2 = (gg) ggVar;
        Parcel y4 = ggVar2.y();
        t.a(y4, bVar);
        y4.writeInt(1);
        zzydVar.writeToParcel(y4, 0);
        Parcel z5 = ggVar2.z(y4, 1);
        IBinder readStrongBinder = z5.readStrongBinder();
        if (readStrongBinder != null) {
            IInterface queryLocalInterface2 = readStrongBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
            fgVar = queryLocalInterface2 instanceof fg ? (fg) queryLocalInterface2 : new fg(readStrongBinder, "com.google.mlkit.vision.barcode.aidls.IBarcodeScanner", 0);
        }
        z5.recycle();
        return fgVar;
    }

    @Override // mc.f
    public final boolean b() {
        boolean z5 = false;
        if (this.f16029g != null) {
            return this.f16025b;
        }
        Context context = this.f16027d;
        boolean z6 = ca.d.a(context, ModuleDescriptor.MODULE_ID) > 0;
        ag agVar = this.f16028f;
        if (z6) {
            this.f16025b = true;
            try {
                this.f16029g = a(ca.d.f3406c, ModuleDescriptor.MODULE_ID, "com.google.mlkit.vision.barcode.bundled.internal.ThickBarcodeScannerCreator");
            } catch (RemoteException e) {
                throw new MlKitException("Failed to create thick barcode scanner.", 13, e);
            } catch (DynamiteModule$LoadingException e10) {
                throw new MlKitException("Failed to load the bundled barcode module.", 13, e10);
            }
        } else {
            this.f16025b = false;
            Feature[] featureArr = gc.g.f14033a;
            n9.c.f16440b.getClass();
            int a3 = n9.c.a(context);
            zzcs zzcsVar = f16023h;
            if (a3 >= 221500000) {
                try {
                    m c9 = new u9.f(context, u9.f.f19027i, com.google.android.gms.common.api.b.N0, com.google.android.gms.common.api.e.f9078b).c(new k(gc.g.b(gc.g.f14036d, zzcsVar), 1));
                    gc.b bVar = new gc.b(12);
                    c9.getClass();
                    c9.a(ia.h.f14383a, bVar);
                    z5 = ((ModuleAvailabilityResponse) xc.a(c9)).b();
                } catch (InterruptedException | ExecutionException e11) {
                    Log.e("OptionalModuleUtils", "Failed to complete the task of features availability check", e11);
                }
            } else {
                try {
                    Iterator it = zzcsVar.iterator();
                    while (it.hasNext()) {
                        ca.d.c(context, ca.d.f3405b, (String) it.next());
                    }
                    z5 = true;
                } catch (DynamiteModule$LoadingException unused) {
                }
            }
            if (!z5) {
                if (!this.f16026c) {
                    gc.g.a(context, zzcs.zzh("barcode", "tflite_dynamite"));
                    this.f16026c = true;
                }
                a.b(agVar, zzrb.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            try {
                this.f16029g = a(ca.d.f3405b, "com.google.android.gms.vision.barcode", "com.google.android.gms.vision.barcode.mlkit.BarcodeScannerCreator");
            } catch (RemoteException | DynamiteModule$LoadingException e12) {
                a.b(agVar, zzrb.OPTIONAL_MODULE_INIT_ERROR);
                throw new MlKitException("Failed to create thin barcode scanner.", 13, e12);
            }
        }
        a.b(agVar, zzrb.NO_ERROR);
        return this.f16025b;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0098 A[LOOP:0: B:22:0x0096->B:23:0x0098, LOOP_END] */
    @Override // mc.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList c(nc.a r13) {
        /*
            r12 = this;
            com.google.android.gms.internal.mlkit_vision_barcode.fg r0 = r12.f16029g
            if (r0 != 0) goto L7
            r12.b()
        L7:
            com.google.android.gms.internal.mlkit_vision_barcode.fg r0 = r12.f16029g
            q9.n.e(r0)
            boolean r1 = r12.f16024a
            r2 = 1
            r3 = 13
            if (r1 != 0) goto L27
            android.os.Parcel r1 = r0.y()     // Catch: android.os.RemoteException -> L1d
            r0.A(r1, r2)     // Catch: android.os.RemoteException -> L1d
            r12.f16024a = r2     // Catch: android.os.RemoteException -> L1d
            goto L27
        L1d:
            r0 = move-exception
            r13 = r0
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException
            java.lang.String r1 = "Failed to init barcode scanner."
            r0.<init>(r1, r3, r13)
            throw r0
        L27:
            int r8 = r13.f16460b
            int r7 = r13.e
            r1 = 0
            r11 = 35
            if (r7 == r11) goto Lbe
            com.google.android.gms.internal.mlkit_vision_barcode.zzyu r4 = new com.google.android.gms.internal.mlkit_vision_barcode.zzyu
            int r9 = r13.f16461c
            int r5 = r13.f16462d
            int r10 = com.google.android.gms.internal.mlkit_vision_barcode.lf.a(r5)
            long r5 = android.os.SystemClock.elapsedRealtime()
            r4.<init>(r5, r7, r8, r9, r10)
            int r5 = r13.e
            r6 = -1
            if (r5 == r6) goto Lba
            r6 = 17
            r7 = 3
            if (r5 == r6) goto L67
            if (r5 == r11) goto L61
            r1 = 842094169(0x32315659, float:1.0322389E-8)
            if (r5 != r1) goto L53
            goto L67
        L53:
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException
            int r13 = r13.e
            java.lang.String r1 = "Unsupported image format: "
            java.lang.String r13 = com.google.android.gms.internal.mlkit_vision_barcode.l0.j(r13, r1)
            r0.<init>(r13, r7)
            throw r0
        L61:
            ba.b r13 = new ba.b
            r13.<init>(r1)
            goto L72
        L67:
            java.nio.ByteBuffer r13 = r13.f16459a
            q9.n.e(r13)
            ba.b r1 = new ba.b
            r1.<init>(r13)
            r13 = r1
        L72:
            android.os.Parcel r1 = r0.y()     // Catch: android.os.RemoteException -> Lb0
            com.google.android.gms.internal.mlkit_vision_barcode.t.a(r1, r13)     // Catch: android.os.RemoteException -> Lb0
            r1.writeInt(r2)     // Catch: android.os.RemoteException -> Lb0
            r13 = 0
            r4.writeToParcel(r1, r13)     // Catch: android.os.RemoteException -> Lb0
            android.os.Parcel r0 = r0.z(r1, r7)     // Catch: android.os.RemoteException -> Lb0
            android.os.Parcelable$Creator<com.google.android.gms.internal.mlkit_vision_barcode.zzyb> r1 = com.google.android.gms.internal.mlkit_vision_barcode.zzyb.CREATOR     // Catch: android.os.RemoteException -> Lb0
            java.util.ArrayList r1 = r0.createTypedArrayList(r1)     // Catch: android.os.RemoteException -> Lb0
            r0.recycle()     // Catch: android.os.RemoteException -> Lb0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r2 = r1.size()
        L96:
            if (r13 >= r2) goto Laf
            java.lang.Object r3 = r1.get(r13)
            int r13 = r13 + 1
            com.google.android.gms.internal.mlkit_vision_barcode.zzyb r3 = (com.google.android.gms.internal.mlkit_vision_barcode.zzyb) r3
            kc.a r4 = new kc.a
            mc.g r5 = new mc.g
            r6 = 0
            r5.<init>(r3, r6)
            r4.<init>(r5)
            r0.add(r4)
            goto L96
        Laf:
            return r0
        Lb0:
            r0 = move-exception
            r13 = r0
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException
            java.lang.String r1 = "Failed to run barcode scanner."
            r0.<init>(r1, r3, r13)
            throw r0
        Lba:
            q9.n.e(r1)
            throw r1
        Lbe:
            q9.n.e(r1)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.h.c(nc.a):java.util.ArrayList");
    }

    @Override // mc.f
    public final void d() {
        fg fgVar = this.f16029g;
        if (fgVar != null) {
            try {
                fgVar.A(fgVar.y(), 2);
            } catch (RemoteException e) {
                Log.e("DecoupledBarcodeScanner", "Failed to release barcode scanner.", e);
            }
            this.f16029g = null;
            this.f16024a = false;
        }
    }
}
