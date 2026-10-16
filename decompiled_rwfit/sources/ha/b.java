package ha;

import android.os.Parcel;
import com.google.android.gms.internal.mlkit_vision_barcode.g;
import com.google.android.gms.signin.internal.zak;
import ia.j;
import o9.v;

/* loaded from: classes.dex */
public abstract class b extends g {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.g
    public final boolean y(int i3, Parcel parcel, Parcel parcel2) {
        switch (i3) {
            case 3:
                da.a.b(parcel);
                break;
            case 4:
                da.a.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                da.a.b(parcel);
                break;
            case 7:
                da.a.b(parcel);
                break;
            case 8:
                zak zakVar = (zak) da.a.a(parcel, zak.CREATOR);
                da.a.b(parcel);
                v vVar = (v) this;
                vVar.f16897c.post(new j(11, vVar, zakVar));
                break;
            case 9:
                da.a.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
