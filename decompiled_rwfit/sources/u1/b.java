package u1;

import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class b extends InputStream implements DataInput {
    public static final ByteOrder e = ByteOrder.LITTLE_ENDIAN;

    /* renamed from: f, reason: collision with root package name */
    public static final ByteOrder f18832f = ByteOrder.BIG_ENDIAN;

    /* renamed from: a, reason: collision with root package name */
    public final DataInputStream f18833a;

    /* renamed from: b, reason: collision with root package name */
    public ByteOrder f18834b;

    /* renamed from: c, reason: collision with root package name */
    public int f18835c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f18836d;

    public b(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f18833a.available();
    }

    public final void b(int i3) {
        int i10 = 0;
        while (i10 < i3) {
            DataInputStream dataInputStream = this.f18833a;
            int i11 = i3 - i10;
            int skip = (int) dataInputStream.skip(i11);
            if (skip <= 0) {
                if (this.f18836d == null) {
                    this.f18836d = new byte[8192];
                }
                skip = dataInputStream.read(this.f18836d, 0, Math.min(8192, i11));
                if (skip == -1) {
                    throw new EOFException(l0.k(i3, "Reached EOF while skipping ", " bytes."));
                }
            }
            i10 += skip;
        }
        this.f18835c += i10;
    }

    @Override // java.io.InputStream
    public final void mark(int i3) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f18835c++;
        return this.f18833a.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f18835c++;
        return this.f18833a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        this.f18835c++;
        int read = this.f18833a.read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f18835c += 2;
        return this.f18833a.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i3, int i10) {
        this.f18835c += i10;
        this.f18833a.readFully(bArr, i3, i10);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        this.f18835c += 4;
        DataInputStream dataInputStream = this.f18833a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        if ((read | read2 | read3 | read4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f18834b;
        if (byteOrder == e) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
        }
        if (byteOrder == f18832f) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        throw new IOException("Invalid byte order: " + this.f18834b);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() {
        long j4;
        long j10;
        this.f18835c += 8;
        DataInputStream dataInputStream = this.f18833a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        int read5 = dataInputStream.read();
        int read6 = dataInputStream.read();
        int read7 = dataInputStream.read();
        int read8 = dataInputStream.read();
        if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f18834b;
        if (byteOrder == e) {
            j4 = (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8);
            j10 = read;
        } else {
            if (byteOrder != f18832f) {
                throw new IOException("Invalid byte order: " + this.f18834b);
            }
            j4 = (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8);
            j10 = read8;
        }
        return j4 + j10;
    }

    @Override // java.io.DataInput
    public final short readShort() {
        this.f18835c += 2;
        DataInputStream dataInputStream = this.f18833a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f18834b;
        if (byteOrder == e) {
            return (short) ((read2 << 8) + read);
        }
        if (byteOrder == f18832f) {
            return (short) ((read << 8) + read2);
        }
        throw new IOException("Invalid byte order: " + this.f18834b);
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f18835c += 2;
        return this.f18833a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f18835c++;
        return this.f18833a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        this.f18835c += 2;
        DataInputStream dataInputStream = this.f18833a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f18834b;
        if (byteOrder == e) {
            return (read2 << 8) + read;
        }
        if (byteOrder == f18832f) {
            return (read << 8) + read2;
        }
        throw new IOException("Invalid byte order: " + this.f18834b);
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i3) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    public b(InputStream inputStream) {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    public b(InputStream inputStream, ByteOrder byteOrder) {
        this.f18834b = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f18833a = dataInputStream;
        dataInputStream.mark(0);
        this.f18835c = 0;
        this.f18834b = byteOrder;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i10) {
        int read = this.f18833a.read(bArr, i3, i10);
        this.f18835c += read;
        return read;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        this.f18835c += bArr.length;
        this.f18833a.readFully(bArr);
    }
}
