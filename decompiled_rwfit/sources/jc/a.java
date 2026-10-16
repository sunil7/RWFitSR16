package jc;

import android.content.Context;
import android.os.Parcel;
import ba.b;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.g;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.h;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.l;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.libraries.barhopper.BarhopperV3;
import com.google.android.libraries.barhopper.MultiScaleDecodingOptions;
import com.google.android.libraries.barhopper.MultiScaleDetectionOptions;
import com.google.android.libraries.barhopper.RecognitionOptions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lb.c;
import lb.d;
import lb.e;
import lb.f;
import lb.i;
import lb.j;
import pc.m;
import q9.n;

/* loaded from: classes.dex */
public final class a extends g implements h {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f15399d = {5, 7, 7, 7, 5, 5};
    public static final double[][] e = {new double[]{0.075d, 1.0d}, new double[]{0.1d, 1.0d}, new double[]{0.125d, 1.0d}, new double[]{0.2d, 2.0d}, new double[]{0.2d, 0.5d}, new double[]{0.15d, 1.0d}, new double[]{0.2d, 1.0d}, new double[]{0.25d, 1.0d}, new double[]{0.35d, 2.0d}, new double[]{0.35d, 0.5d}, new double[]{0.35d, 3.0d}, new double[]{0.35d, 0.3333d}, new double[]{0.3d, 1.0d}, new double[]{0.4d, 1.0d}, new double[]{0.5d, 1.0d}, new double[]{0.5d, 2.0d}, new double[]{0.5d, 0.5d}, new double[]{0.5d, 3.0d}, new double[]{0.5d, 0.3333d}, new double[]{0.6d, 1.0d}, new double[]{0.8d, 1.0d}, new double[]{1.0d, 1.0d}, new double[]{0.65d, 2.0d}, new double[]{0.65d, 0.5d}, new double[]{0.65d, 3.0d}, new double[]{0.65d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.8d, 2.0d}, new double[]{0.8d, 0.5d}, new double[]{0.8d, 3.0d}, new double[]{0.8d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.95d, 2.0d}, new double[]{0.95d, 0.5d}, new double[]{0.95d, 3.0d}, new double[]{0.95d, 0.3333d}};

    /* renamed from: a, reason: collision with root package name */
    public final Context f15400a;

    /* renamed from: b, reason: collision with root package name */
    public final zzba f15401b;

    /* renamed from: c, reason: collision with root package name */
    public BarhopperV3 f15402c;

    public a(Context context, zzba zzbaVar) {
        super("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
        this.f15400a = context;
        this.f15401b = zzbaVar;
    }

    public static zzan m(m mVar, String str, String str2) {
        if (mVar == null || str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(str2).matcher(str);
        return new zzan(mVar.s(), mVar.q(), mVar.n(), mVar.o(), mVar.p(), mVar.r(), mVar.u(), matcher.find() ? matcher.group(1) : null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.g
    public final boolean g(int i3, Parcel parcel, Parcel parcel2) {
        if (i3 == 1) {
            k();
            parcel2.writeNoException();
            return true;
        }
        if (i3 == 2) {
            BarhopperV3 barhopperV3 = this.f15402c;
            if (barhopperV3 != null) {
                barhopperV3.close();
                this.f15402c = null;
            }
            parcel2.writeNoException();
            return true;
        }
        if (i3 == 3) {
            ba.a A = b.A(parcel.readStrongBinder());
            zzcc zzccVar = (zzcc) l.a(parcel, zzcc.CREATOR);
            l.b(parcel);
            RecognitionOptions recognitionOptions = new RecognitionOptions();
            zzba zzbaVar = this.f15401b;
            recognitionOptions.a(zzbaVar.b());
            recognitionOptions.f(zzbaVar.h());
            recognitionOptions.b();
            recognitionOptions.c();
            ArrayList z5 = z(A, zzccVar, recognitionOptions);
            parcel2.writeNoException();
            parcel2.writeTypedList(z5);
            return true;
        }
        if (i3 != 4) {
            if (i3 != 5) {
                return false;
            }
            l.b(parcel);
            k();
            parcel2.writeNoException();
            return true;
        }
        ba.a A2 = b.A(parcel.readStrongBinder());
        zzcc zzccVar2 = (zzcc) l.a(parcel, zzcc.CREATOR);
        zzbc zzbcVar = (zzbc) l.a(parcel, zzbc.CREATOR);
        l.b(parcel);
        RecognitionOptions recognitionOptions2 = new RecognitionOptions();
        zzba zzbaVar2 = this.f15401b;
        recognitionOptions2.a(zzbaVar2.b());
        recognitionOptions2.f(zzbaVar2.h());
        recognitionOptions2.b();
        recognitionOptions2.c();
        MultiScaleDecodingOptions multiScaleDecodingOptions = new MultiScaleDecodingOptions();
        multiScaleDecodingOptions.a(zzbcVar.b().i());
        multiScaleDecodingOptions.b(zzbcVar.b().b());
        multiScaleDecodingOptions.c(zzbcVar.b().h());
        recognitionOptions2.d(multiScaleDecodingOptions);
        MultiScaleDetectionOptions multiScaleDetectionOptions = new MultiScaleDetectionOptions();
        multiScaleDetectionOptions.a(zzbcVar.b().i());
        recognitionOptions2.e(multiScaleDetectionOptions);
        recognitionOptions2.g(zzbcVar.h());
        ArrayList z6 = z(A2, zzccVar2, recognitionOptions2);
        parcel2.writeNoException();
        parcel2.writeTypedList(z6);
        return true;
    }

    public final void k() {
        Context context = this.f15400a;
        if (this.f15402c != null) {
            return;
        }
        BarhopperV3 barhopperV3 = new BarhopperV3();
        System.loadLibrary("barhopper_v3");
        this.f15402c = barhopperV3;
        lb.h n4 = i.n();
        f n8 = lb.g.n();
        int i3 = 16;
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            d n10 = e.n();
            n10.e();
            e.r((e) n10.f9790b, i3);
            n10.e();
            e.o((e) n10.f9790b, i3);
            for (int i12 = 0; i12 < f15399d[i11]; i12++) {
                double[] dArr = e[i10];
                double d5 = dArr[0] * 320.0d;
                float sqrt = (float) Math.sqrt(dArr[1]);
                float f2 = (float) d5;
                n10.e();
                e.p((e) n10.f9790b, f2 / sqrt);
                n10.e();
                e.q((e) n10.f9790b, f2 * sqrt);
                i10++;
            }
            i3 += i3;
            n8.e();
            lb.g.o((lb.g) n8.f9790b, (e) n10.b());
        }
        n4.e();
        i.o((i) n4.f9790b, (lb.g) n8.b());
        try {
            InputStream open = context.getAssets().open("mlkit_barcode_models/barcode_ssd_mobilenet_v1_dmp25_quant.tflite");
            try {
                InputStream open2 = context.getAssets().open("mlkit_barcode_models/oned_auto_regressor_mobile.tflite");
                try {
                    InputStream open3 = context.getAssets().open("mlkit_barcode_models/oned_feature_extractor_mobile.tflite");
                    try {
                        BarhopperV3 barhopperV32 = this.f15402c;
                        n.e(barhopperV32);
                        j n11 = lb.a.n();
                        zzdf zzs = zzdf.zzs(open);
                        n4.e();
                        i.p((i) n4.f9790b, zzs);
                        n11.e();
                        lb.a.o((lb.a) n11.f9790b, (i) n4.b());
                        lb.b n12 = c.n();
                        zzdf zzs2 = zzdf.zzs(open2);
                        n12.e();
                        c.p((c) n12.f9790b, zzs2);
                        zzdf zzs3 = zzdf.zzs(open3);
                        n12.e();
                        c.o((c) n12.f9790b, zzs3);
                        n11.e();
                        lb.a.p((lb.a) n11.f9790b, (c) n12.b());
                        barhopperV32.b((lb.a) n11.b());
                        if (open3 != null) {
                            open3.close();
                        }
                        if (open2 != null) {
                            open2.close();
                        }
                        if (open != null) {
                            open.close();
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e10) {
            throw new IllegalStateException("Failed to open Barcode models", e10);
        }
    }

    public final pc.a y(ByteBuffer byteBuffer, zzcc zzccVar, RecognitionOptions recognitionOptions) {
        BarhopperV3 barhopperV3 = this.f15402c;
        n.e(barhopperV3);
        n.e(byteBuffer);
        if (byteBuffer.isDirect()) {
            return barhopperV3.c(zzccVar.j(), zzccVar.b(), byteBuffer, recognitionOptions);
        }
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return barhopperV3.e(zzccVar.j(), zzccVar.b(), byteBuffer.array(), recognitionOptions);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return barhopperV3.e(zzccVar.j(), zzccVar.b(), bArr, recognitionOptions);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    public final java.util.ArrayList z(ba.a r49, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcc r50, com.google.android.libraries.barhopper.RecognitionOptions r51) {
        /*
            Method dump skipped, instructions count: 1282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jc.a.z(ba.a, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcc, com.google.android.libraries.barhopper.RecognitionOptions):java.util.ArrayList");
    }
}
