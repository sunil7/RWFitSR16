package t5;

import android.os.ParcelUuid;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final ParcelUuid f18545a = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");

    public static ParcelUuid a(byte[] bArr) {
        long j4;
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException(l0.j(length, "uuidBytes length invalid - "));
        }
        if (length == 16) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
        }
        if (length == 2) {
            j4 = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
        } else {
            j4 = ((bArr[3] & 255) << 24) + (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
        }
        ParcelUuid parcelUuid = f18545a;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j4 << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }
}
