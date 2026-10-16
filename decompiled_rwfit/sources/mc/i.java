package mc;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.example.test.ui.device.activity.e0;
import com.google.android.gms.common.Feature;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.internal.mlkit_common.zzaf;
import com.google.android.gms.internal.mlkit_vision_barcode.ag;
import com.google.android.gms.internal.mlkit_vision_barcode.lf;
import com.google.android.gms.internal.mlkit_vision_barcode.mf;
import com.google.android.gms.internal.mlkit_vision_barcode.t;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import q9.n;

/* loaded from: classes.dex */
public final class i implements f {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16030a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f16031b;

    /* renamed from: c, reason: collision with root package name */
    public final zzah f16032c;

    /* renamed from: d, reason: collision with root package name */
    public final ag f16033d;
    public com.google.android.gms.internal.mlkit_vision_barcode.c e;

    public i(Context context, ic.b bVar, ag agVar) {
        zzah zzahVar = new zzah();
        this.f16032c = zzahVar;
        this.f16031b = context;
        zzahVar.zza = bVar.f14405a;
        this.f16033d = agVar;
    }

    @Override // mc.f
    public final boolean b() {
        com.google.android.gms.internal.mlkit_vision_barcode.f dVar;
        Context context = this.f16031b;
        if (this.e == null) {
            try {
                IBinder b3 = ca.d.c(context, ca.d.f3405b, "com.google.android.gms.vision.dynamite").b("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator");
                int i3 = com.google.android.gms.internal.mlkit_vision_barcode.e.f9276b;
                if (b3 == null) {
                    dVar = null;
                } else {
                    IInterface queryLocalInterface = b3.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                    dVar = queryLocalInterface instanceof com.google.android.gms.internal.mlkit_vision_barcode.f ? (com.google.android.gms.internal.mlkit_vision_barcode.f) queryLocalInterface : new com.google.android.gms.internal.mlkit_vision_barcode.d(b3, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator", 0);
                }
                com.google.android.gms.internal.mlkit_vision_barcode.c B = ((com.google.android.gms.internal.mlkit_vision_barcode.d) dVar).B(new ba.b(context), this.f16032c);
                this.e = B;
                ag agVar = this.f16033d;
                if (B == null && !this.f16030a) {
                    Log.d("LegacyBarcodeScanner", "Request optional module download.");
                    Feature[] featureArr = gc.g.f14033a;
                    gc.g.a(context, zzaf.zzh("barcode"));
                    this.f16030a = true;
                    a.b(agVar, zzrb.OPTIONAL_MODULE_NOT_AVAILABLE);
                    throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
                }
                a.b(agVar, zzrb.NO_ERROR);
            } catch (RemoteException e) {
                throw new MlKitException("Failed to create legacy barcode detector.", 13, e);
            } catch (DynamiteModule$LoadingException e10) {
                throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e10);
            }
        }
        return false;
    }

    @Override // mc.f
    public final ArrayList c(nc.a aVar) {
        zzu[] zzuVarArr;
        if (this.e == null) {
            b();
        }
        com.google.android.gms.internal.mlkit_vision_barcode.c cVar = this.e;
        if (cVar == null) {
            throw new MlKitException("Error initializing the legacy barcode scanner.", 14);
        }
        zzan zzanVar = new zzan(0L, aVar.f16460b, aVar.f16461c, 0, lf.a(aVar.f16462d));
        try {
            int i3 = aVar.e;
            if (i3 == -1) {
                ba.b bVar = new ba.b(null);
                Parcel y4 = cVar.y();
                t.a(y4, bVar);
                y4.writeInt(1);
                zzanVar.writeToParcel(y4, 0);
                Parcel z5 = cVar.z(y4, 2);
                zzuVarArr = (zzu[]) z5.createTypedArray(zzu.CREATOR);
                z5.recycle();
            } else if (i3 == 17) {
                ba.b bVar2 = new ba.b(aVar.f16459a);
                Parcel y10 = cVar.y();
                t.a(y10, bVar2);
                y10.writeInt(1);
                zzanVar.writeToParcel(y10, 0);
                Parcel z6 = cVar.z(y10, 1);
                zzuVarArr = (zzu[]) z6.createTypedArray(zzu.CREATOR);
                z6.recycle();
            } else {
                if (i3 == 35) {
                    n.e(null);
                    throw null;
                }
                if (i3 != 842094169) {
                    throw new MlKitException("Unsupported image format: " + aVar.e, 3);
                }
                ba.b bVar3 = new ba.b(mf.a(aVar));
                Parcel y11 = cVar.y();
                t.a(y11, bVar3);
                y11.writeInt(1);
                zzanVar.writeToParcel(y11, 0);
                Parcel z8 = cVar.z(y11, 1);
                zzuVarArr = (zzu[]) z8.createTypedArray(zzu.CREATOR);
                z8.recycle();
            }
            ArrayList arrayList = new ArrayList();
            for (zzu zzuVar : zzuVarArr) {
                arrayList.add(new kc.a(new e0(zzuVar, 27)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to detect with legacy barcode detector", 13, e);
        }
    }

    @Override // mc.f
    public final void d() {
        com.google.android.gms.internal.mlkit_vision_barcode.c cVar = this.e;
        if (cVar != null) {
            try {
                cVar.A(cVar.y(), 3);
            } catch (RemoteException e) {
                Log.e("LegacyBarcodeScanner", "Failed to release legacy barcode detector.", e);
            }
            this.e = null;
        }
    }
}
