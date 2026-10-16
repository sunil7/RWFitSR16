package u1;

import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.h0;
import com.google.mlkit.common.MlKitException;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public final class g {
    public static final byte[] A;
    public static final byte[] B;
    public static final String[] C;
    public static final int[] D;
    public static final byte[] E;
    public static final d F;
    public static final d[][] G;
    public static final d[] H;
    public static final HashMap[] I;
    public static final HashMap[] J;
    public static final HashSet K;
    public static final HashMap L;
    public static final Charset M;
    public static final byte[] N;
    public static final byte[] O;

    /* renamed from: m, reason: collision with root package name */
    public static final boolean f18847m = Log.isLoggable("ExifInterface", 3);

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f18848n;

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f18849o;

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f18850p;

    /* renamed from: q, reason: collision with root package name */
    public static final byte[] f18851q;
    public static final byte[] r;

    /* renamed from: s, reason: collision with root package name */
    public static final byte[] f18852s;

    /* renamed from: t, reason: collision with root package name */
    public static final byte[] f18853t;

    /* renamed from: u, reason: collision with root package name */
    public static final byte[] f18854u;

    /* renamed from: v, reason: collision with root package name */
    public static final byte[] f18855v;

    /* renamed from: w, reason: collision with root package name */
    public static final byte[] f18856w;

    /* renamed from: x, reason: collision with root package name */
    public static final byte[] f18857x;

    /* renamed from: y, reason: collision with root package name */
    public static final byte[] f18858y;

    /* renamed from: z, reason: collision with root package name */
    public static final byte[] f18859z;

    /* renamed from: a, reason: collision with root package name */
    public final String f18860a;

    /* renamed from: b, reason: collision with root package name */
    public final FileDescriptor f18861b;

    /* renamed from: c, reason: collision with root package name */
    public final AssetManager.AssetInputStream f18862c;

    /* renamed from: d, reason: collision with root package name */
    public int f18863d;
    public final HashMap[] e;

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f18864f;

    /* renamed from: g, reason: collision with root package name */
    public ByteOrder f18865g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18866h;

    /* renamed from: i, reason: collision with root package name */
    public int f18867i;

    /* renamed from: j, reason: collision with root package name */
    public int f18868j;

    /* renamed from: k, reason: collision with root package name */
    public int f18869k;

    /* renamed from: l, reason: collision with root package name */
    public int f18870l;

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        f18848n = new int[]{8, 8, 8};
        f18849o = new int[]{8};
        f18850p = new byte[]{-1, -40, -1};
        f18851q = new byte[]{102, 116, 121, 112};
        r = new byte[]{109, 105, 102, 49};
        f18852s = new byte[]{104, 101, 105, 99};
        f18853t = new byte[]{79, 76, 89, 77, 80, 0};
        f18854u = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        f18855v = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        f18856w = new byte[]{101, 88, 73, 102};
        f18857x = new byte[]{73, 72, 68, 82};
        f18858y = new byte[]{73, 69, 78, 68};
        f18859z = new byte[]{82, 73, 70, 70};
        A = new byte[]{87, 69, 66, 80};
        B = new byte[]{69, 88, 73, 70};
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        C = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        D = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        E = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d(256, "ImageWidth", 3, 4), new d(257, "ImageLength", 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", SubsamplingScaleImageView.ORIENTATION_270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d(273, "StripOffsets", 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d(278, "RowsPerStrip", 3, 4), new d(279, "StripByteCounts", 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", MlKitException.LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", FontStyle.WEIGHT_BOLD, 1)};
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d(40962, "PixelXDimension", 3, 4), new d(40963, "PixelYDimension", 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d(50720, "DefaultCropSize", 3, 4)};
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d(2, "GPSLatitude", 5, 10), new d("GPSLongitudeRef", 3, 2), new d(4, "GPSLongitude", 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d(256, "ThumbnailImageWidth", 3, 4), new d(257, "ThumbnailImageLength", 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", SubsamplingScaleImageView.ORIENTATION_270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d(273, "StripOffsets", 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d(278, "RowsPerStrip", 3, 4), new d(279, "StripByteCounts", 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", MlKitException.LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Xmp", FontStyle.WEIGHT_BOLD, 1), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d(50720, "DefaultCropSize", 3, 4)};
        F = new d("StripOffsets", 273, 3);
        G = new d[][]{dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, new d[]{new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)}, new d[]{new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4)}, new d[]{new d("AspectFrame", 4371, 3)}, new d[]{new d("ColorSpace", 55, 3)}};
        H = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        I = new HashMap[10];
        J = new HashMap[10];
        K = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        L = new HashMap();
        Charset forName = Charset.forName("US-ASCII");
        M = forName;
        N = "Exif\u0000\u0000".getBytes(forName);
        O = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i3 = 0;
        while (true) {
            d[][] dVarArr6 = G;
            if (i3 >= dVarArr6.length) {
                HashMap hashMap = L;
                d[] dVarArr7 = H;
                hashMap.put(Integer.valueOf(dVarArr7[0].f18841a), 5);
                hashMap.put(Integer.valueOf(dVarArr7[1].f18841a), 1);
                hashMap.put(Integer.valueOf(dVarArr7[2].f18841a), 2);
                hashMap.put(Integer.valueOf(dVarArr7[3].f18841a), 3);
                hashMap.put(Integer.valueOf(dVarArr7[4].f18841a), 7);
                hashMap.put(Integer.valueOf(dVarArr7[5].f18841a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            I[i3] = new HashMap();
            J[i3] = new HashMap();
            for (d dVar : dVarArr6[i3]) {
                I[i3].put(Integer.valueOf(dVar.f18841a), dVar);
                J[i3].put(dVar.f18842b, dVar);
            }
            i3++;
        }
    }

    public g(String str) {
        FileInputStream fileInputStream;
        boolean z5;
        d[][] dVarArr = G;
        this.e = new HashMap[dVarArr.length];
        this.f18864f = new HashSet(dVarArr.length);
        this.f18865g = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        FileInputStream fileInputStream2 = null;
        this.f18862c = null;
        this.f18860a = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                h.c(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                z5 = true;
            } catch (Exception unused) {
                if (f18847m) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
                z5 = false;
            }
            if (z5) {
                this.f18861b = fileInputStream.getFD();
            } else {
                this.f18861b = null;
            }
            p(fileInputStream);
            h0.b(fileInputStream);
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            h0.b(fileInputStream2);
            throw th;
        }
    }

    public static ByteOrder s(b bVar) {
        short readShort = bVar.readShort();
        boolean z5 = f18847m;
        if (readShort == 18761) {
            if (z5) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            if (z5) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    public final void a() {
        String b3 = b("DateTimeOriginal");
        HashMap[] hashMapArr = this.e;
        if (b3 != null && b("DateTime") == null) {
            hashMapArr[0].put("DateTime", c.a(b3));
        }
        if (b("ImageWidth") == null) {
            hashMapArr[0].put("ImageWidth", c.b(0L, this.f18865g));
        }
        if (b("ImageLength") == null) {
            hashMapArr[0].put("ImageLength", c.b(0L, this.f18865g));
        }
        if (b("Orientation") == null) {
            hashMapArr[0].put("Orientation", c.b(0L, this.f18865g));
        }
        if (b("LightSource") == null) {
            hashMapArr[1].put("LightSource", c.b(0L, this.f18865g));
        }
    }

    public final String b(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c d5 = d(str);
        if (d5 != null) {
            if (!K.contains(str)) {
                return d5.g(this.f18865g);
            }
            if (str.equals("GPSTimeStamp")) {
                int i3 = d5.f18837a;
                if (i3 != 5 && i3 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i3);
                    return null;
                }
                e[] eVarArr = (e[]) d5.h(this.f18865g);
                if (eVarArr == null || eVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr));
                    return null;
                }
                e eVar = eVarArr[0];
                Integer valueOf = Integer.valueOf((int) (eVar.f18845a / eVar.f18846b));
                e eVar2 = eVarArr[1];
                Integer valueOf2 = Integer.valueOf((int) (eVar2.f18845a / eVar2.f18846b));
                e eVar3 = eVarArr[2];
                return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (eVar3.f18845a / eVar3.f18846b)));
            }
            try {
                return Double.toString(d5.e(this.f18865g));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final int c(int i3, String str) {
        c d5 = d(str);
        if (d5 == null) {
            return i3;
        }
        try {
            return d5.f(this.f18865g);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    public final c d(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (f18847m) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i3 = 0; i3 < G.length; i3++) {
            c cVar = (c) this.e[i3].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(f fVar) {
        String str;
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                i.a(mediaMetadataRetriever, new a(fVar));
                String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(extractMetadata3)) {
                    str = mediaMetadataRetriever.extractMetadata(29);
                    str2 = mediaMetadataRetriever.extractMetadata(30);
                    str3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(extractMetadata4)) {
                    str = mediaMetadataRetriever.extractMetadata(18);
                    str2 = mediaMetadataRetriever.extractMetadata(19);
                    str3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                HashMap[] hashMapArr = this.e;
                if (str != null) {
                    hashMapArr[0].put("ImageWidth", c.d(Integer.parseInt(str), this.f18865g));
                }
                if (str2 != null) {
                    hashMapArr[0].put("ImageLength", c.d(Integer.parseInt(str2), this.f18865g));
                }
                if (str3 != null) {
                    int parseInt = Integer.parseInt(str3);
                    hashMapArr[0].put("Orientation", c.d(parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? 1 : 8 : 3 : 6, this.f18865g));
                }
                if (extractMetadata != null && extractMetadata2 != null) {
                    int parseInt2 = Integer.parseInt(extractMetadata);
                    int parseInt3 = Integer.parseInt(extractMetadata2);
                    if (parseInt3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.c(parseInt2);
                    byte[] bArr = new byte[6];
                    if (fVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i3 = parseInt2 + 6;
                    int i10 = parseInt3 - 6;
                    if (!Arrays.equals(bArr, N)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i10];
                    if (fVar.read(bArr2) != i10) {
                        throw new IOException("Can't read exif");
                    }
                    this.f18867i = i3;
                    t(0, bArr2);
                }
                if (f18847m) {
                    Log.d("ExifInterface", "Heif meta: " + str + "x" + str2 + ", rotation " + str3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th2) {
            mediaMetadataRetriever.release();
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0193, code lost:
    
        r23.f18834b = r22.f18865g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0197, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0180 A[LOOP:0: B:9:0x0033->B:32:0x0180, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(u1.b r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.g.f(u1.b, int, int):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:14|15|(4:16|17|18|19)|(16:106|(2:108|109)(1:152)|111|112|(1:114)|115|(3:118|119|(4:124|(3:129|(1:131)(2:139|(1:141))|(3:134|135|136))(2:126|127)|128|120))|117|22|23|25|26|27|(1:93)(1:31)|32|(1:34)(8:36|37|38|39|40|(1:42)(1:79)|43|(1:45)(3:46|(2:47|(2:49|(2:52|53)(1:51))(2:77|78))|(1:55)(3:56|(2:57|(2:59|(1:62)(1:61))(3:67|68|(2:69|(2:71|(1:74)(1:73))(2:75|76))))|(1:65)(1:66)))))|21|22|23|25|26|27|(1:29)|93|32|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x00f4, code lost:
    
        r6 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00fa, code lost:
    
        if (r6 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00fc, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00ff, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00f8, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00f6, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0061, code lost:
    
        if (r9 < 16) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x00ce, code lost:
    
        if (r8 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0166, code lost:
    
        r5 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0100, code lost:
    
        if (r2 != null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0102, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0105, code lost:
    
        r0 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00f3, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0109 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(java.io.BufferedInputStream r18) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.g.g(java.io.BufferedInputStream):int");
    }

    public final void h(f fVar) {
        int i3;
        int i10;
        k(fVar);
        HashMap[] hashMapArr = this.e;
        c cVar = (c) hashMapArr[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.f18840d);
            fVar2.f18834b = this.f18865g;
            byte[] bArr = f18853t;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.c(0L);
            byte[] bArr3 = f18854u;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.c(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.c(12L);
            }
            u(fVar2, 6);
            c cVar2 = (c) hashMapArr[7].get("PreviewImageStart");
            c cVar3 = (c) hashMapArr[7].get("PreviewImageLength");
            if (cVar2 != null && cVar3 != null) {
                hashMapArr[5].put("JPEGInterchangeFormat", cVar2);
                hashMapArr[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = (c) hashMapArr[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.h(this.f18865g);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i11 = iArr[2];
                int i12 = iArr[0];
                if (i11 <= i12 || (i3 = iArr[3]) <= (i10 = iArr[1])) {
                    return;
                }
                int i13 = (i11 - i12) + 1;
                int i14 = (i3 - i10) + 1;
                if (i13 < i14) {
                    int i15 = i13 + i14;
                    i14 = i15 - i14;
                    i13 = i15 - i14;
                }
                c d5 = c.d(i13, this.f18865g);
                c d8 = c.d(i14, this.f18865g);
                hashMapArr[0].put("ImageWidth", d5);
                hashMapArr[0].put("ImageLength", d8);
            }
        }
    }

    public final void i(b bVar) {
        if (f18847m) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.f18834b = ByteOrder.BIG_ENDIAN;
        byte[] bArr = f18855v;
        bVar.b(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i3 = length + 8;
                if (i3 == 16 && !Arrays.equals(bArr2, f18857x)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f18858y)) {
                    return;
                }
                if (Arrays.equals(bArr2, f18856w)) {
                    byte[] bArr3 = new byte[readInt];
                    if (bVar.read(bArr3) != readInt) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + h0.a(bArr2));
                    }
                    int readInt2 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.f18867i = i3;
                        t(0, bArr3);
                        z();
                        w(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                }
                int i10 = readInt + 4;
                bVar.b(i10);
                length = i3 + i10;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void j(b bVar) {
        boolean z5 = f18847m;
        if (z5) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.b(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i3 = ByteBuffer.wrap(bArr).getInt();
        int i10 = ByteBuffer.wrap(bArr2).getInt();
        int i11 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i10];
        bVar.b(i3 - bVar.f18835c);
        bVar.read(bArr4);
        f(new b(bArr4), i3, 5);
        bVar.b(i11 - bVar.f18835c);
        bVar.f18834b = ByteOrder.BIG_ENDIAN;
        int readInt = bVar.readInt();
        if (z5) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i12 = 0; i12 < readInt; i12++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == F.f18841a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                c d5 = c.d(readShort, this.f18865g);
                c d8 = c.d(readShort2, this.f18865g);
                HashMap[] hashMapArr = this.e;
                hashMapArr[0].put("ImageLength", d5);
                hashMapArr[0].put("ImageWidth", d8);
                if (z5) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            bVar.b(readUnsignedShort2);
        }
    }

    public final void k(f fVar) {
        q(fVar);
        u(fVar, 0);
        y(fVar, 0);
        y(fVar, 5);
        y(fVar, 4);
        z();
        if (this.f18863d == 8) {
            HashMap[] hashMapArr = this.e;
            c cVar = (c) hashMapArr[1].get("MakerNote");
            if (cVar != null) {
                f fVar2 = new f(cVar.f18840d);
                fVar2.f18834b = this.f18865g;
                fVar2.b(6);
                u(fVar2, 9);
                c cVar2 = (c) hashMapArr[9].get("ColorSpace");
                if (cVar2 != null) {
                    hashMapArr[1].put("ColorSpace", cVar2);
                }
            }
        }
    }

    public final void l(f fVar) {
        if (f18847m) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + fVar);
        }
        k(fVar);
        HashMap[] hashMapArr = this.e;
        c cVar = (c) hashMapArr[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new b(cVar.f18840d), (int) cVar.f18839c, 5);
        }
        c cVar2 = (c) hashMapArr[0].get("ISO");
        c cVar3 = (c) hashMapArr[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        hashMapArr[1].put("PhotographicSensitivity", cVar2);
    }

    public final void m(b bVar) {
        if (f18847m) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.f18834b = ByteOrder.LITTLE_ENDIAN;
        bVar.b(f18859z.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = A;
        bVar.b(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = bVar.readInt();
                int i3 = length + 8;
                if (Arrays.equals(B, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    if (bVar.read(bArr3) == readInt2) {
                        this.f18867i = i3;
                        t(0, bArr3);
                        w(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + h0.a(bArr2));
                    }
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i3 + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length > readInt) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.b(readInt2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void n(b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("JPEGInterchangeFormat");
        c cVar2 = (c) hashMap.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int f2 = cVar.f(this.f18865g);
        int f10 = cVar2.f(this.f18865g);
        if (this.f18863d == 7) {
            f2 += this.f18868j;
        }
        if (f2 > 0 && f10 > 0 && this.f18860a == null && this.f18862c == null && this.f18861b == null) {
            bVar.skip(f2);
            bVar.read(new byte[f10]);
        }
        if (f18847m) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + f2 + ", length: " + f10);
        }
    }

    public final boolean o(HashMap hashMap) {
        c cVar = (c) hashMap.get("ImageLength");
        c cVar2 = (c) hashMap.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.f(this.f18865g) <= 512 && cVar2.f(this.f18865g) <= 512;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:3:0x0004, B:5:0x0009, B:7:0x001e, B:13:0x003b, B:15:0x0046, B:16:0x005c, B:25:0x004d, B:28:0x0055, B:29:0x0059, B:30:0x0066, B:32:0x006f, B:34:0x0075, B:36:0x007b, B:38:0x0081, B:48:0x008f), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(java.io.InputStream r8) {
        /*
            r7 = this;
            boolean r0 = u1.g.f18847m
            r1 = 0
            r2 = r1
        L4:
            u1.d[][] r3 = u1.g.G     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r3 = r3.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r2 >= r3) goto L1e
            java.util.HashMap[] r3 = r7.e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.<init>()     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3[r2] = r4     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r2 + 1
            goto L4
        L15:
            r8 = move-exception
            goto L97
        L18:
            r8 = move-exception
            goto L8d
        L1b:
            r8 = move-exception
            goto L8d
        L1e:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3 = 5000(0x1388, float:7.006E-42)
            r2.<init>(r8, r3)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r8 = r7.g(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r7.f18863d = r8     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3 = 14
            r4 = 13
            r5 = 9
            r6 = 4
            if (r8 == r6) goto L66
            if (r8 == r5) goto L66
            if (r8 == r4) goto L66
            if (r8 != r3) goto L3b
            goto L66
        L3b:
            u1.f r8 = new u1.f     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r1 = r7.f18863d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 12
            if (r1 != r2) goto L4a
            r7.e(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L5c
        L4a:
            r2 = 7
            if (r1 != r2) goto L51
            r7.h(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L5c
        L51:
            r2 = 10
            if (r1 != r2) goto L59
            r7.l(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L5c
        L59:
            r7.k(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L5c:
            int r1 = r7.f18867i     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.c(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r7.w(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L66:
            u1.b r8 = new u1.b     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r7.f18863d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r2 != r6) goto L73
            r7.f(r8, r1, r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L73:
            if (r2 != r4) goto L79
            r7.i(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L79:
            if (r2 != r5) goto L7f
            r7.j(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L7f:
            if (r2 != r3) goto L84
            r7.m(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L84:
            r7.a()
            if (r0 == 0) goto La8
            r7.r()
            return
        L8d:
            if (r0 == 0) goto La0
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r8)     // Catch: java.lang.Throwable -> L15
            goto La0
        L97:
            r7.a()
            if (r0 == 0) goto L9f
            r7.r()
        L9f:
            throw r8
        La0:
            r7.a()
            if (r0 == 0) goto La8
            r7.r()
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.g.p(java.io.InputStream):void");
    }

    public final void q(f fVar) {
        ByteOrder s7 = s(fVar);
        this.f18865g = s7;
        fVar.f18834b = s7;
        int readUnsignedShort = fVar.readUnsignedShort();
        int i3 = this.f18863d;
        if (i3 != 7 && i3 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = fVar.readInt();
        if (readInt < 8) {
            throw new IOException(l0.j(readInt, "Invalid first Ifd offset: "));
        }
        int i10 = readInt - 8;
        if (i10 > 0) {
            fVar.b(i10);
        }
    }

    public final void r() {
        int i3 = 0;
        while (true) {
            HashMap[] hashMapArr = this.e;
            if (i3 >= hashMapArr.length) {
                return;
            }
            StringBuilder q5 = android.support.v4.media.session.e.q(i3, "The size of tag group[", "]: ");
            q5.append(hashMapArr[i3].size());
            Log.d("ExifInterface", q5.toString());
            for (Map.Entry entry : hashMapArr[i3].entrySet()) {
                c cVar = (c) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + cVar.toString() + ", tagValue: '" + cVar.g(this.f18865g) + "'");
            }
            i3++;
        }
    }

    public final void t(int i3, byte[] bArr) {
        f fVar = new f(bArr);
        q(fVar);
        u(fVar, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x027f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(u1.f r27, int r28) {
        /*
            Method dump skipped, instructions count: 898
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.g.u(u1.f, int):void");
    }

    public final void v(int i3, String str, String str2) {
        HashMap[] hashMapArr = this.e;
        if (hashMapArr[i3].isEmpty() || hashMapArr[i3].get(str) == null) {
            return;
        }
        HashMap hashMap = hashMapArr[i3];
        hashMap.put(str2, hashMap.get(str));
        hashMapArr[i3].remove(str);
    }

    public final void w(b bVar) {
        c cVar;
        int f2;
        HashMap hashMap = this.e[4];
        c cVar2 = (c) hashMap.get("Compression");
        if (cVar2 == null) {
            n(bVar, hashMap);
            return;
        }
        int f10 = cVar2.f(this.f18865g);
        if (f10 != 1) {
            if (f10 == 6) {
                n(bVar, hashMap);
                return;
            } else if (f10 != 7) {
                return;
            }
        }
        c cVar3 = (c) hashMap.get("BitsPerSample");
        if (cVar3 != null) {
            int[] iArr = (int[]) cVar3.h(this.f18865g);
            int[] iArr2 = f18848n;
            if (Arrays.equals(iArr2, iArr) || (this.f18863d == 3 && (cVar = (c) hashMap.get("PhotometricInterpretation")) != null && (((f2 = cVar.f(this.f18865g)) == 1 && Arrays.equals(iArr, f18849o)) || (f2 == 6 && Arrays.equals(iArr, iArr2))))) {
                c cVar4 = (c) hashMap.get("StripOffsets");
                c cVar5 = (c) hashMap.get("StripByteCounts");
                if (cVar4 == null || cVar5 == null) {
                    return;
                }
                long[] c9 = h0.c(cVar4.h(this.f18865g));
                long[] c10 = h0.c(cVar5.h(this.f18865g));
                if (c9 == null || c9.length == 0) {
                    Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (c10 == null || c10.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (c9.length != c10.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j4 = 0;
                for (long j10 : c10) {
                    j4 += j10;
                }
                byte[] bArr = new byte[(int) j4];
                this.f18866h = true;
                int i3 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < c9.length; i11++) {
                    int i12 = (int) c9[i11];
                    int i13 = (int) c10[i11];
                    if (i11 < c9.length - 1 && i12 + i13 != c9[i11 + 1]) {
                        this.f18866h = false;
                    }
                    int i14 = i12 - i3;
                    if (i14 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    long j11 = i14;
                    if (bVar.skip(j11) != j11) {
                        Log.d("ExifInterface", "Failed to skip " + i14 + " bytes.");
                        return;
                    }
                    int i15 = i3 + i14;
                    byte[] bArr2 = new byte[i13];
                    if (bVar.read(bArr2) != i13) {
                        Log.d("ExifInterface", "Failed to read " + i13 + " bytes.");
                        return;
                    }
                    i3 = i15 + i13;
                    System.arraycopy(bArr2, 0, bArr, i10, i13);
                    i10 += i13;
                }
                if (this.f18866h) {
                    long j12 = c9[0];
                    return;
                }
                return;
            }
        }
        if (f18847m) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void x(int i3, int i10) {
        HashMap[] hashMapArr = this.e;
        boolean isEmpty = hashMapArr[i3].isEmpty();
        boolean z5 = f18847m;
        if (isEmpty || hashMapArr[i10].isEmpty()) {
            if (z5) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        c cVar = (c) hashMapArr[i3].get("ImageLength");
        c cVar2 = (c) hashMapArr[i3].get("ImageWidth");
        c cVar3 = (c) hashMapArr[i10].get("ImageLength");
        c cVar4 = (c) hashMapArr[i10].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            if (z5) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (cVar3 == null || cVar4 == null) {
            if (z5) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int f2 = cVar.f(this.f18865g);
        int f10 = cVar2.f(this.f18865g);
        int f11 = cVar3.f(this.f18865g);
        int f12 = cVar4.f(this.f18865g);
        if (f2 >= f11 || f10 >= f12) {
            return;
        }
        HashMap hashMap = hashMapArr[i3];
        hashMapArr[i3] = hashMapArr[i10];
        hashMapArr[i10] = hashMap;
    }

    public final void y(f fVar, int i3) {
        c d5;
        c d8;
        HashMap[] hashMapArr = this.e;
        c cVar = (c) hashMapArr[i3].get("DefaultCropSize");
        c cVar2 = (c) hashMapArr[i3].get("SensorTopBorder");
        c cVar3 = (c) hashMapArr[i3].get("SensorLeftBorder");
        c cVar4 = (c) hashMapArr[i3].get("SensorBottomBorder");
        c cVar5 = (c) hashMapArr[i3].get("SensorRightBorder");
        if (cVar != null) {
            if (cVar.f18837a == 5) {
                e[] eVarArr = (e[]) cVar.h(this.f18865g);
                if (eVarArr == null || eVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(eVarArr));
                    return;
                } else {
                    d5 = c.c(new e[]{eVarArr[0]}, this.f18865g);
                    d8 = c.c(new e[]{eVarArr[1]}, this.f18865g);
                }
            } else {
                int[] iArr = (int[]) cVar.h(this.f18865g);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                d5 = c.d(iArr[0], this.f18865g);
                d8 = c.d(iArr[1], this.f18865g);
            }
            hashMapArr[i3].put("ImageWidth", d5);
            hashMapArr[i3].put("ImageLength", d8);
            return;
        }
        if (cVar2 != null && cVar3 != null && cVar4 != null && cVar5 != null) {
            int f2 = cVar2.f(this.f18865g);
            int f10 = cVar4.f(this.f18865g);
            int f11 = cVar5.f(this.f18865g);
            int f12 = cVar3.f(this.f18865g);
            if (f10 <= f2 || f11 <= f12) {
                return;
            }
            c d10 = c.d(f10 - f2, this.f18865g);
            c d11 = c.d(f11 - f12, this.f18865g);
            hashMapArr[i3].put("ImageLength", d10);
            hashMapArr[i3].put("ImageWidth", d11);
            return;
        }
        c cVar6 = (c) hashMapArr[i3].get("ImageLength");
        c cVar7 = (c) hashMapArr[i3].get("ImageWidth");
        if (cVar6 == null || cVar7 == null) {
            c cVar8 = (c) hashMapArr[i3].get("JPEGInterchangeFormat");
            c cVar9 = (c) hashMapArr[i3].get("JPEGInterchangeFormatLength");
            if (cVar8 == null || cVar9 == null) {
                return;
            }
            int f13 = cVar8.f(this.f18865g);
            int f14 = cVar8.f(this.f18865g);
            fVar.c(f13);
            byte[] bArr = new byte[f14];
            fVar.read(bArr);
            f(new b(bArr), f13, i3);
        }
    }

    public final void z() {
        x(0, 5);
        x(0, 4);
        x(5, 4);
        HashMap[] hashMapArr = this.e;
        c cVar = (c) hashMapArr[1].get("PixelXDimension");
        c cVar2 = (c) hashMapArr[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            hashMapArr[0].put("ImageWidth", cVar);
            hashMapArr[0].put("ImageLength", cVar2);
        }
        if (hashMapArr[4].isEmpty() && o(hashMapArr[5])) {
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        if (!o(hashMapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        v(0, "ThumbnailOrientation", "Orientation");
        v(0, "ThumbnailImageLength", "ImageLength");
        v(0, "ThumbnailImageWidth", "ImageWidth");
        v(5, "ThumbnailOrientation", "Orientation");
        v(5, "ThumbnailImageLength", "ImageLength");
        v(5, "ThumbnailImageWidth", "ImageWidth");
        v(4, "Orientation", "ThumbnailOrientation");
        v(4, "ImageLength", "ThumbnailImageLength");
        v(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public g(InputStream inputStream) {
        d[][] dVarArr = G;
        this.e = new HashMap[dVarArr.length];
        this.f18864f = new HashSet(dVarArr.length);
        this.f18865g = ByteOrder.BIG_ENDIAN;
        this.f18860a = null;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f18862c = (AssetManager.AssetInputStream) inputStream;
            this.f18861b = null;
        } else {
            if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                try {
                    h.c(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                    this.f18862c = null;
                    this.f18861b = fileInputStream.getFD();
                } catch (Exception unused) {
                    if (f18847m) {
                        Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                    }
                }
            }
            this.f18862c = null;
            this.f18861b = null;
        }
        p(inputStream);
    }
}
