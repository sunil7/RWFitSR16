package g4;

import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader$EndOfFileException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class j implements k, x3.d {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f13825a;

    public j() {
        this.f13825a = ByteBuffer.allocate(4);
    }

    @Override // g4.k
    public long a(long j4) {
        ByteBuffer byteBuffer = this.f13825a;
        int min = (int) Math.min(byteBuffer.remaining(), j4);
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }

    @Override // x3.d
    public void d(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Integer num = (Integer) obj;
        if (num == null) {
            return;
        }
        messageDigest.update(bArr);
        synchronized (this.f13825a) {
            this.f13825a.position(0);
            messageDigest.update(this.f13825a.putInt(num.intValue()).array());
        }
    }

    @Override // g4.k
    public short h() {
        ByteBuffer byteBuffer = this.f13825a;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new DefaultImageHeaderParser$Reader$EndOfFileException();
    }

    @Override // g4.k
    public int l() {
        return (h() << 8) | h();
    }

    public j(ByteBuffer byteBuffer) {
        this.f13825a = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }
}
