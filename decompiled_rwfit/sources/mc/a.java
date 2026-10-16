package mc;

import android.content.Context;
import android.util.SparseArray;
import com.example.test.ui.device.activity.f0;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.ag;
import com.google.android.gms.internal.mlkit_vision_barcode.rf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzro;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvw;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f16000a;

    /* renamed from: b, reason: collision with root package name */
    public static final SparseArray f16001b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference f16002c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f16003d;

    static {
        SparseArray sparseArray = new SparseArray();
        f16000a = sparseArray;
        SparseArray sparseArray2 = new SparseArray();
        f16001b = sparseArray2;
        f16002c = new AtomicReference();
        sparseArray.put(-1, zzrn.FORMAT_UNKNOWN);
        sparseArray.put(1, zzrn.FORMAT_CODE_128);
        sparseArray.put(2, zzrn.FORMAT_CODE_39);
        sparseArray.put(4, zzrn.FORMAT_CODE_93);
        sparseArray.put(8, zzrn.FORMAT_CODABAR);
        sparseArray.put(16, zzrn.FORMAT_DATA_MATRIX);
        sparseArray.put(32, zzrn.FORMAT_EAN_13);
        sparseArray.put(64, zzrn.FORMAT_EAN_8);
        sparseArray.put(128, zzrn.FORMAT_ITF);
        sparseArray.put(256, zzrn.FORMAT_QR_CODE);
        sparseArray.put(512, zzrn.FORMAT_UPC_A);
        sparseArray.put(1024, zzrn.FORMAT_UPC_E);
        sparseArray.put(2048, zzrn.FORMAT_PDF417);
        sparseArray.put(4096, zzrn.FORMAT_AZTEC);
        sparseArray2.put(0, zzro.TYPE_UNKNOWN);
        sparseArray2.put(1, zzro.TYPE_CONTACT_INFO);
        sparseArray2.put(2, zzro.TYPE_EMAIL);
        sparseArray2.put(3, zzro.TYPE_ISBN);
        sparseArray2.put(4, zzro.TYPE_PHONE);
        sparseArray2.put(5, zzro.TYPE_PRODUCT);
        sparseArray2.put(6, zzro.TYPE_SMS);
        sparseArray2.put(7, zzro.TYPE_TEXT);
        sparseArray2.put(8, zzro.TYPE_URL);
        sparseArray2.put(9, zzro.TYPE_WIFI);
        sparseArray2.put(10, zzro.TYPE_GEO);
        sparseArray2.put(11, zzro.TYPE_CALENDAR_EVENT);
        sparseArray2.put(12, zzro.TYPE_DRIVER_LICENSE);
        HashMap hashMap = new HashMap();
        f16003d = hashMap;
        hashMap.put(1, zzvw.CODE_128);
        hashMap.put(2, zzvw.CODE_39);
        hashMap.put(4, zzvw.CODE_93);
        hashMap.put(8, zzvw.CODABAR);
        hashMap.put(16, zzvw.DATA_MATRIX);
        hashMap.put(32, zzvw.EAN_13);
        hashMap.put(64, zzvw.EAN_8);
        hashMap.put(128, zzvw.ITF);
        hashMap.put(256, zzvw.QR_CODE);
        hashMap.put(512, zzvw.UPC_A);
        hashMap.put(1024, zzvw.UPC_E);
        hashMap.put(2048, zzvw.PDF417);
        hashMap.put(4096, zzvw.AZTEC);
    }

    public static rf a(ic.b bVar) {
        int i3 = bVar.f14405a;
        androidx.appcompat.widget.a aVar = new androidx.appcompat.widget.a();
        HashMap hashMap = f16003d;
        if (i3 == 0) {
            Collection values = hashMap.values();
            if (values instanceof Collection) {
                Collection collection = values;
                aVar.c(collection.size() + aVar.f866a);
                if (collection instanceof zzcn) {
                    aVar.f866a = ((zzcn) collection).zza((Object[]) aVar.f868c, aVar.f866a);
                }
            }
            Iterator it = values.iterator();
            while (it.hasNext()) {
                aVar.b(it.next());
            }
        } else {
            for (Map.Entry entry : hashMap.entrySet()) {
                if ((((Integer) entry.getKey()).intValue() & i3) != 0) {
                    aVar.b((zzvw) entry.getValue());
                }
            }
        }
        f0 f0Var = new f0(6);
        f0Var.f7859b = aVar.d();
        return new rf(f0Var);
    }

    public static void b(ag agVar, zzrb zzrbVar) {
        agVar.b(new i0(zzrbVar, 29), zzrc.ON_DEVICE_BARCODE_LOAD);
    }

    public static boolean c() {
        AtomicReference atomicReference = f16002c;
        if (atomicReference.get() != null) {
            return ((Boolean) atomicReference.get()).booleanValue();
        }
        Context b3 = gc.e.c().b();
        zzcs zzcsVar = h.f16023h;
        boolean z5 = ca.d.a(b3, ModuleDescriptor.MODULE_ID) > 0;
        atomicReference.set(Boolean.valueOf(z5));
        return z5;
    }
}
