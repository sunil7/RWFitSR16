package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.amap.api.maps.offlinemap.OfflineMapStatus;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public abstract class ca {
    public static SpannableStringBuilder a(Context context, int i3, String str, oh.a aVar) {
        if (str == null || str.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new com.example.test.utils.u(context, i3, aVar), 0, str.length(), 33);
        return spannableStringBuilder;
    }

    public static String b(String str) {
        ArrayList w8 = kotlin.collections.h.w(kotlin.text.m.u(str, new String[]{":"}));
        String str2 = (String) kotlin.collections.h.q(w8);
        xd.a(16);
        int parseInt = (Integer.parseInt(str2, 16) - 1) & 255;
        String format = String.format("%02X", Arrays.copyOf(new Object[]{Integer.valueOf(parseInt)}, 1));
        if (parseInt == 0) {
            format = "FF";
        }
        w8.set(w8.size() - 1, format);
        return kotlin.collections.h.p(w8, ":", null, 62);
    }

    public static String c(String jlMac) {
        kotlin.jvm.internal.e.f(jlMac, "jlMac");
        ArrayList w8 = kotlin.collections.h.w(kotlin.text.m.u(jlMac, new String[]{":"}));
        String str = (String) kotlin.collections.h.q(w8);
        xd.a(16);
        String format = String.format("%02X", Arrays.copyOf(new Object[]{Integer.valueOf((Integer.parseInt(str, 16) + 1) & 255)}, 1));
        if (format.equals("FF")) {
            format = "00";
        }
        w8.set(w8.size() - 1, format);
        return kotlin.collections.h.p(w8, ":", null, 62);
    }

    public static int d(Context context, int i3) {
        kotlin.jvm.internal.e.f(context, "context");
        int[] iArr = {36, 43, 42, 34, 37, 33, 40, 83, 67, 64, 53, 90, 106, 108, 49, 66, 102, 105, OfflineMapStatus.EXCEPTION_SDCARD, 18, 129, 145, 146, 147, 148, 157};
        for (int i10 = 0; i10 < 26; i10++) {
            if (iArr[i10] == i3) {
                return R$mipmap.jl_workout_ball;
            }
        }
        int[] iArr2 = {19, 45, 25, 39, 59, 57, 91, 88, 92, 86, 96, 97, 68, 101, 98, 93, 85, 58, 104, 87, 112, 115, 22, 31, 116, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 153, 154, 155, 156, 158, 159, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 161};
        for (int i11 = 0; i11 < 48; i11++) {
            if (iArr2[i11] == i3) {
                return R$mipmap.jl_workout_competition;
            }
        }
        int[] iArr3 = {35, 41, 79, 75, 74, 48, 76, 73, 77, 78, 149, 150, 151, 152};
        for (int i12 = 0; i12 < 14; i12++) {
            if (iArr3[i12] == i3) {
                return R$mipmap.jl_workout_dance;
            }
        }
        int[] iArr4 = {20, 26, 32, 44, 30, 28, 29, 38, 50, 61, 11, 65, 70, 71, 81, 100, 109, 63, 62, 95, 72, 60, 89, 113};
        for (int i13 = 0; i13 < 24; i13++) {
            if (iArr4[i13] == i3) {
                return R$mipmap.jl_workout_relaxation;
            }
        }
        int[] iArr5 = {9, 15, 24, 23, 27, 46, 54, 69, 94, 80, 82, 47, 55, 52, 51, 56, 84, 110, 107, 99, AMapEngineUtils.ARROW_LINE_INNER_TEXTURE_ID, 114, 117, 118, 119, 120, 121, 122, 123, 124, 125, WebSocketProtocol.PAYLOAD_SHORT, 127, 128};
        for (int i14 = 0; i14 < 34 && iArr5[i14] != i3; i14++) {
        }
        return R$mipmap.jl_workout_fitness;
    }

    public static String e(long j4) {
        try {
            return new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(Long.valueOf(j4));
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(j4, " getTimeStr translate error ", e.getMessage()));
            return null;
        }
    }

    public static String f(Context context, int[] iArr) {
        String string;
        kotlin.jvm.internal.e.f(context, "context");
        if (iArr == null || iArr.length == 0) {
            String string2 = context.getString(R$string.str_no_repeat);
            kotlin.jvm.internal.e.c(string2);
            return string2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = iArr.length;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i3 < length) {
            int i12 = i11 + 1;
            if (iArr[i3] == 1) {
                stringBuffer.append(g(context, i11));
                stringBuffer.append(Const.STR_MART_COMMA);
                i10++;
            }
            i3++;
            i11 = i12;
        }
        if (i10 == 7) {
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append(context.getString(R$string.str_every_day));
            string = stringBuffer.toString();
        } else if (stringBuffer.length() > 0) {
            String stringBuffer2 = stringBuffer.toString();
            kotlin.jvm.internal.e.e(stringBuffer2, "toString(...)");
            string = stringBuffer2.substring(0, stringBuffer.lastIndexOf(Const.STR_MART_COMMA));
            kotlin.jvm.internal.e.e(string, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            string = context.getString(R$string.str_no_repeat);
        }
        kotlin.jvm.internal.e.c(string);
        return string;
    }

    public static String g(Context context, float f2) {
        kotlin.jvm.internal.e.f(context, "context");
        if (f2 == 0.0f) {
            String string = context.getString(com.example.baselibrary.R$string.sun);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            return string;
        }
        if (f2 == 1.0f) {
            String string2 = context.getString(com.example.baselibrary.R$string.mon);
            kotlin.jvm.internal.e.e(string2, "getString(...)");
            return string2;
        }
        if (f2 == 2.0f) {
            String string3 = context.getString(com.example.baselibrary.R$string.tue);
            kotlin.jvm.internal.e.e(string3, "getString(...)");
            return string3;
        }
        if (f2 == 3.0f) {
            String string4 = context.getString(com.example.baselibrary.R$string.wed);
            kotlin.jvm.internal.e.e(string4, "getString(...)");
            return string4;
        }
        if (f2 == 4.0f) {
            String string5 = context.getString(com.example.baselibrary.R$string.thu);
            kotlin.jvm.internal.e.e(string5, "getString(...)");
            return string5;
        }
        if (f2 == 5.0f) {
            String string6 = context.getString(com.example.baselibrary.R$string.fri);
            kotlin.jvm.internal.e.e(string6, "getString(...)");
            return string6;
        }
        if (f2 == 6.0f) {
            String string7 = context.getString(com.example.baselibrary.R$string.sat);
            kotlin.jvm.internal.e.e(string7, "getString(...)");
            return string7;
        }
        String string8 = context.getString(com.example.baselibrary.R$string.sun);
        kotlin.jvm.internal.e.e(string8, "getString(...)");
        return string8;
    }

    public static boolean h(String str) {
        return (str == null || str.length() == 0 || "null".equalsIgnoreCase(str)) ? false : true;
    }

    public static String i(long j4, String str) {
        try {
            return new SimpleDateFormat(str, Locale.ENGLISH).format(Long.valueOf(j4));
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(j4, " date translate error ", e.getMessage()));
            return null;
        }
    }

    public static String j(long j4) {
        try {
            return new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(j4));
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(j4, " date translate error ", e.getMessage()));
            return null;
        }
    }

    public static String k(Context context, int i3) {
        kotlin.jvm.internal.e.f(context, "context");
        if (1 <= i3 && i3 < 30) {
            String string = context.getString(R$string.str_normal_press_range);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            return string;
        }
        if (30 <= i3 && i3 < 60) {
            String string2 = context.getString(R$string.str_slow_press);
            kotlin.jvm.internal.e.e(string2, "getString(...)");
            return string2;
        }
        if (60 <= i3 && i3 < 80) {
            String string3 = context.getString(R$string.str_middle_press);
            kotlin.jvm.internal.e.e(string3, "getString(...)");
            return string3;
        }
        if (80 > i3 || i3 >= 100) {
            String string4 = context.getString(R$string.str_normal_press_range);
            kotlin.jvm.internal.e.e(string4, "getString(...)");
            return string4;
        }
        String string5 = context.getString(R$string.str_height_press);
        kotlin.jvm.internal.e.e(string5, "getString(...)");
        return string5;
    }
}
