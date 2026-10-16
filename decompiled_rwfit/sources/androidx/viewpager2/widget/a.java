package androidx.viewpager2.widget;

import android.view.View;
import com.example.test.ui.device.model.BleDeviceModel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.mlkit_vision_barcode.dc;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.File;
import java.util.Comparator;
import java.util.WeakHashMap;
import l1.n0;
import l1.z0;

/* loaded from: classes.dex */
public final class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2968a;

    public /* synthetic */ a(int i3) {
        this.f2968a = i3;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f2968a) {
            case 0:
                return ((int[]) obj)[0] - ((int[]) obj2)[0];
            case 1:
                return dc.a(Long.valueOf(((File) obj).lastModified()), Long.valueOf(((File) obj2).lastModified()));
            case 2:
                return dc.a(Long.valueOf(((File) obj).lastModified()), Long.valueOf(((File) obj2).lastModified()));
            case 3:
                return dc.a(Integer.valueOf(((BleDeviceModel) obj2).getRssi()), Integer.valueOf(((BleDeviceModel) obj).getRssi()));
            case 4:
                return dc.a(Integer.valueOf(((BleDeviceModel) obj2).getRssi()), Integer.valueOf(((BleDeviceModel) obj).getRssi()));
            case 5:
                return dc.a(Integer.valueOf(((BleDeviceModel) obj2).getRssi()), Integer.valueOf(((BleDeviceModel) obj).getRssi()));
            case 6:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 7:
                return ((k3.a) obj2).f15457c - ((k3.a) obj).f15457c;
            case 8:
                int[] iArr = (int[]) obj;
                int[] iArr2 = (int[]) obj2;
                return (iArr2[1] - iArr2[0]) - (iArr[1] - iArr[0]);
            case 9:
                int[] iArr3 = (int[]) obj;
                int[] iArr4 = (int[]) obj2;
                return (iArr3[1] - iArr3[0]) - (iArr4[1] - iArr4[0]);
            case 10:
                return ((Scope) obj).b().compareTo(((Scope) obj2).b());
            case 11:
                return ((n2.g) obj).f16369b - ((n2.g) obj2).f16369b;
            case 12:
                return ((o0.e) obj).f16671b - ((o0.e) obj2).f16671b;
            case 13:
                if (obj == null) {
                    throw l0.f(obj2);
                }
                throw new ClassCastException();
            case 14:
                WeakHashMap weakHashMap = z0.f15748a;
                float m10 = n0.m((View) obj);
                float m11 = n0.m((View) obj2);
                if (m10 > m11) {
                    return -1;
                }
                return m10 < m11 ? 1 : 0;
            default:
                return ((Comparable) obj).compareTo(obj2);
        }
    }
}
