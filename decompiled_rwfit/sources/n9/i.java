package n9;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class i extends com.google.android.gms.internal.mlkit_vision_barcode.g implements q9.l {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f16452c = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f16453b;

    public i(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData", 2);
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.f16453b = Arrays.hashCode(bArr);
    }

    public static byte[] A(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public abstract byte[] B();

    @Override // q9.l
    public final int b() {
        return this.f16453b;
    }

    public final boolean equals(Object obj) {
        ba.a o3;
        if (obj != null && (obj instanceof q9.l)) {
            try {
                q9.l lVar = (q9.l) obj;
                if (lVar.b() == this.f16453b && (o3 = lVar.o()) != null) {
                    return Arrays.equals(B(), (byte[]) ba.b.B(o3));
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f16453b;
    }

    @Override // q9.l
    public final ba.a o() {
        return new ba.b(B());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.g
    public final boolean z(int i3, Parcel parcel, Parcel parcel2) {
        if (i3 == 1) {
            ba.a o3 = o();
            parcel2.writeNoException();
            ea.a.c(parcel2, o3);
            return true;
        }
        if (i3 != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(this.f16453b);
        return true;
    }
}
