package c1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.d1;
import java.io.IOException;

/* loaded from: classes.dex */
public final class i extends d1 {
    public static Font e(FontFamily fontFamily, int i3) {
        FontStyle fontStyle = new FontStyle((i3 & 1) != 0 ? com.autonavi.base.ae.gmap.glyph.FontStyle.WEIGHT_BOLD : 400, (i3 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int f2 = f(fontStyle, font.getStyle());
        for (int i10 = 1; i10 < fontFamily.getSize(); i10++) {
            Font font2 = fontFamily.getFont(i10);
            int f10 = f(fontStyle, font2.getStyle());
            if (f10 < f2) {
                font = font2;
                f2 = f10;
            }
        }
        return font;
    }

    public static int f(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.d1
    public final Typeface a(Context context, b1.f fVar, Resources resources, int i3) {
        try {
            FontFamily.Builder builder = null;
            for (b1.g gVar : fVar.f3058a) {
                try {
                    Font build = new Font.Builder(resources, gVar.f3063f).setWeight(gVar.f3060b).setSlant(gVar.f3061c ? 1 : 0).setTtcIndex(gVar.e).setFontVariationSettings(gVar.f3062d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(e(build2, i3).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.d1
    public final Typeface b(Context context, i1.f[] fVarArr, int i3) {
        int i10;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = fVarArr.length;
            FontFamily.Builder builder = null;
            while (i10 < length) {
                i1.f fVar = fVarArr[i10];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(fVar.f14344a, "r", null);
                } catch (IOException unused) {
                }
                if (openFileDescriptor == null) {
                    i10 = openFileDescriptor == null ? i10 + 1 : 0;
                } else {
                    try {
                        Font build = new Font.Builder(openFileDescriptor).setWeight(fVar.f14346c).setSlant(fVar.f14347d ? 1 : 0).setTtcIndex(fVar.f14345b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th2) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                openFileDescriptor.close();
            }
            if (builder != null) {
                FontFamily build2 = builder.build();
                return new Typeface.CustomFallbackBuilder(build2).setStyle(e(build2, i3).getStyle()).build();
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.d1
    public final Typeface c(Context context, Resources resources, int i3, String str, int i10) {
        try {
            Font build = new Font.Builder(resources, i3).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.d1
    public final i1.f d(i1.f[] fVarArr, int i3) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
