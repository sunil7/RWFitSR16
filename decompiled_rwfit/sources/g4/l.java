package g4;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader$EndOfFileException;
import com.example.test.ui.device.activity.f0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class l implements x3.b {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f13826a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f13827b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static ImageHeaderParser$ImageType d(k kVar) {
        try {
            int l3 = kVar.l();
            if (l3 == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int h4 = (l3 << 8) | kVar.h();
            if (h4 == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int h10 = (h4 << 8) | kVar.h();
            if (h10 == -1991225785) {
                kVar.a(21L);
                try {
                    return kVar.h() >= 3 ? ImageHeaderParser$ImageType.PNG_A : ImageHeaderParser$ImageType.PNG;
                } catch (DefaultImageHeaderParser$Reader$EndOfFileException unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            }
            if (h10 != 1380533830) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            kVar.a(4L);
            if (((kVar.l() << 16) | kVar.l()) != 1464156752) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int l5 = (kVar.l() << 16) | kVar.l();
            if ((l5 & (-256)) != 1448097792) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int i3 = l5 & 255;
            if (i3 == 88) {
                kVar.a(4L);
                return (kVar.h() & 16) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
            }
            if (i3 != 76) {
                return ImageHeaderParser$ImageType.WEBP;
            }
            kVar.a(4L);
            return (kVar.h() & 8) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
        } catch (DefaultImageHeaderParser$Reader$EndOfFileException unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(com.example.test.ui.device.activity.f0 r9) {
        /*
        L0:
            short r0 = r9.h()
            r1 = 255(0xff, float:3.57E-43)
            r2 = 3
            r3 = -1
            java.lang.String r4 = "DfltImageHeaderParser"
            if (r0 == r1) goto L24
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L6a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown segmentId="
            r9.<init>(r1)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
            return r3
        L24:
            short r0 = r9.h()
            r1 = 218(0xda, float:3.05E-43)
            if (r0 != r1) goto L2d
            goto L6a
        L2d:
            r1 = 217(0xd9, float:3.04E-43)
            if (r0 != r1) goto L3d
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L6a
            java.lang.String r9 = "Found MARKER_EOI in exif segment"
            android.util.Log.d(r4, r9)
            return r3
        L3d:
            int r1 = r9.l()
            int r1 = r1 + (-2)
            r5 = 225(0xe1, float:3.15E-43)
            if (r0 == r5) goto L6b
            long r5 = (long) r1
            long r7 = r9.a(r5)
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 == 0) goto L0
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L6a
            java.lang.String r9 = "Unable to skip enough data, type: "
            java.lang.String r2 = ", wanted to skip: "
            java.lang.String r5 = ", but actually skipped: "
            java.lang.StringBuilder r9 = com.google.android.gms.internal.mlkit_vision_barcode.l0.s(r0, r9, r1, r2, r5)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
        L6a:
            return r3
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.l.e(com.example.test.ui.device.activity.f0):int");
    }

    public static int f(f0 f0Var, byte[] bArr, int i3) {
        ByteOrder byteOrder;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i3 && (i12 = ((InputStream) f0Var.f7859b).read(bArr, i11, i3 - i11)) != -1) {
            i11 += i12;
        }
        if (i11 == 0 && i12 == -1) {
            throw new DefaultImageHeaderParser$Reader$EndOfFileException();
        }
        if (i11 == i3) {
            short s7 = 1;
            byte[] bArr2 = f13826a;
            boolean z5 = bArr != null && i3 > bArr2.length;
            if (z5) {
                int i13 = 0;
                while (true) {
                    if (i13 >= bArr2.length) {
                        break;
                    }
                    if (bArr[i13] != bArr2[i13]) {
                        z5 = false;
                        break;
                    }
                    i13++;
                }
            }
            if (z5) {
                ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i3);
                short s8 = byteBuffer.remaining() - 6 >= 2 ? byteBuffer.getShort(6) : (short) -1;
                if (s8 == 18761) {
                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                } else if (s8 != 19789) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) s8));
                    }
                    byteOrder = ByteOrder.BIG_ENDIAN;
                } else {
                    byteOrder = ByteOrder.BIG_ENDIAN;
                }
                byteBuffer.order(byteOrder);
                int i14 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
                int i15 = i14 + 6;
                short s10 = byteBuffer.remaining() - i15 >= 2 ? byteBuffer.getShort(i15) : (short) -1;
                while (i10 < s10) {
                    int i16 = (i10 * 12) + i14 + 8;
                    short s11 = byteBuffer.remaining() - i16 >= 2 ? byteBuffer.getShort(i16) : (short) -1;
                    if (s11 == 274) {
                        int i17 = i16 + 2;
                        short s12 = byteBuffer.remaining() - i17 >= 2 ? byteBuffer.getShort(i17) : (short) -1;
                        if (s12 >= s7 && s12 <= 12) {
                            int i18 = i16 + 4;
                            int i19 = byteBuffer.remaining() - i18 >= 4 ? byteBuffer.getInt(i18) : -1;
                            if (i19 >= 0) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    StringBuilder s13 = l0.s(i10, "Got tagIndex=", s11, " tagType=", " formatCode=");
                                    s13.append((int) s12);
                                    s13.append(" componentCount=");
                                    s13.append(i19);
                                    Log.d("DfltImageHeaderParser", s13.toString());
                                }
                                int i20 = i19 + f13827b[s12];
                                if (i20 <= 4) {
                                    int i21 = i16 + 8;
                                    if (i21 < 0 || i21 > byteBuffer.remaining()) {
                                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                            Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i21 + " tagType=" + ((int) s11));
                                        }
                                    } else {
                                        if (i20 >= 0 && i20 + i21 <= byteBuffer.remaining()) {
                                            if (byteBuffer.remaining() - i21 >= 2) {
                                                return byteBuffer.getShort(i21);
                                            }
                                            return -1;
                                        }
                                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                            Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) s11));
                                        }
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) s12));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Negative tiff component count");
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) s12));
                        }
                    }
                    i10++;
                    s7 = 1;
                }
            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i3 + ", actually read: " + i11);
            return -1;
        }
        return -1;
    }

    @Override // x3.b
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        t4.f.c(byteBuffer, "Argument must not be null");
        return d(new j(byteBuffer));
    }

    @Override // x3.b
    public final int b(InputStream inputStream, a4.g gVar) {
        f0 f0Var = new f0(inputStream, 17);
        t4.f.c(gVar, "Argument must not be null");
        try {
            int l3 = f0Var.l();
            if ((l3 & 65496) == 65496 || l3 == 19789 || l3 == 18761) {
                int e = e(f0Var);
                if (e != -1) {
                    byte[] bArr = (byte[]) gVar.c(byte[].class, e);
                    try {
                        return f(f0Var, bArr, e);
                    } finally {
                        gVar.g(bArr);
                    }
                }
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                    return -1;
                }
            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + l3);
                return -1;
            }
        } catch (DefaultImageHeaderParser$Reader$EndOfFileException unused) {
        }
        return -1;
    }

    @Override // x3.b
    public final ImageHeaderParser$ImageType c(InputStream inputStream) {
        return d(new f0(inputStream, 17));
    }
}
