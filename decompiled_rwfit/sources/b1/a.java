package b1;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public float f3046a;

    /* renamed from: b, reason: collision with root package name */
    public float f3047b;

    /* renamed from: c, reason: collision with root package name */
    public float f3048c;

    /* renamed from: d, reason: collision with root package name */
    public float f3049d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f3050f;

    public a(float f2, float f10, float f11, float f12, float f13, float f14) {
        this.f3046a = f2;
        this.f3047b = f10;
        this.f3048c = f11;
        this.f3049d = f12;
        this.e = f13;
        this.f3050f = f14;
    }

    public static a b(int i3) {
        p pVar = p.f3079k;
        float c9 = b.c(Color.red(i3));
        float c10 = b.c(Color.green(i3));
        float c11 = b.c(Color.blue(i3));
        float[][] fArr = b.f3054d;
        float[] fArr2 = fArr[0];
        float f2 = (fArr2[2] * c11) + (fArr2[1] * c10) + (fArr2[0] * c9);
        float[] fArr3 = fArr[1];
        float f10 = (fArr3[2] * c11) + (fArr3[1] * c10) + (fArr3[0] * c9);
        float[] fArr4 = fArr[2];
        float[] fArr5 = {f2, f10, (c11 * fArr4[2]) + (c10 * fArr4[1]) + (c9 * fArr4[0])};
        float[][] fArr6 = b.f3051a;
        float f11 = fArr5[0];
        float[] fArr7 = fArr6[0];
        float f12 = fArr7[0] * f11;
        float f13 = fArr5[1];
        float f14 = (fArr7[1] * f13) + f12;
        float f15 = fArr5[2];
        float f16 = (fArr7[2] * f15) + f14;
        float[] fArr8 = fArr6[1];
        float f17 = (fArr8[2] * f15) + (fArr8[1] * f13) + (fArr8[0] * f11);
        float[] fArr9 = fArr6[2];
        float f18 = (f15 * fArr9[2]) + (f13 * fArr9[1]) + (f11 * fArr9[0]);
        float[] fArr10 = pVar.f3085g;
        float f19 = fArr10[0] * f16;
        float f20 = fArr10[1] * f17;
        float f21 = fArr10[2] * f18;
        float abs = Math.abs(f19);
        float f22 = pVar.f3086h;
        float pow = (float) Math.pow((abs * f22) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((Math.abs(f20) * f22) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((Math.abs(f21) * f22) / 100.0d, 0.42d);
        float signum = ((Math.signum(f19) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f20) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f21) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d5 = signum3;
        float f23 = ((float) (((signum2 * (-12.0d)) + (signum * 11.0d)) + d5)) / 11.0f;
        float f24 = ((float) ((signum + signum2) - (d5 * 2.0d))) / 9.0f;
        float f25 = signum2 * 20.0f;
        float f26 = ((21.0f * signum3) + ((signum * 20.0f) + f25)) / 20.0f;
        float f27 = (((signum * 40.0f) + f25) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f24, f23)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f28 = atan2;
        float f29 = (3.1415927f * f28) / 180.0f;
        float f30 = f27 * pVar.f3081b;
        float f31 = pVar.f3080a;
        float f32 = pVar.f3083d;
        float pow4 = ((float) Math.pow(f30 / f31, pVar.f3088j * f32)) * 100.0f;
        Math.sqrt(pow4 / 100.0f);
        float f33 = f31 + 4.0f;
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, pVar.f3084f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) f28) < 20.14d ? 360.0f + f28 : f28) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * pVar.e) * pVar.f3082c) * ((float) Math.sqrt((f24 * f24) + (f23 * f23)))) / (f26 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow4 / 100.0d));
        float f34 = pVar.f3087i * pow5;
        Math.sqrt((r4 * f32) / f33);
        float f35 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((f34 * 0.0228f) + 1.0f)) * 43.85965f;
        double d8 = f29;
        return new a(f28, pow5, pow4, f35, log * ((float) Math.cos(d8)), log * ((float) Math.sin(d8)));
    }

    public static a c(float f2, float f10, float f11) {
        p pVar = p.f3079k;
        float f12 = pVar.f3083d;
        Math.sqrt(f2 / 100.0d);
        float f13 = pVar.f3080a + 4.0f;
        float f14 = pVar.f3087i * f10;
        Math.sqrt(((f10 / ((float) Math.sqrt(r1))) * pVar.f3083d) / f13);
        float f15 = (1.7f * f2) / ((0.007f * f2) + 1.0f);
        float log = ((float) Math.log((f14 * 0.0228d) + 1.0d)) * 43.85965f;
        double d5 = (3.1415927f * f11) / 180.0f;
        return new a(f11, f10, f2, f15, log * ((float) Math.cos(d5)), log * ((float) Math.sin(d5)));
    }

    public void a(float f2, float f10, int i3, int i10, float[] fArr) {
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = (f10 - 0.5f) * 2.0f;
        float f14 = f11 + this.f3048c;
        float f15 = f12 + this.f3049d;
        float f16 = (this.f3046a * (f2 - 0.5f) * 2.0f) + f14;
        float f17 = (this.f3047b * f13) + f15;
        float radians = (float) Math.toRadians(this.f3050f);
        float radians2 = (float) Math.toRadians(this.e);
        double d5 = radians;
        double d8 = i10 * f13;
        float sin = (((float) ((Math.sin(d5) * ((-i3) * r7)) - (Math.cos(d5) * d8))) * radians2) + f16;
        float cos = (radians2 * ((float) ((Math.cos(d5) * (i3 * r7)) - (Math.sin(d5) * d8)))) + f17;
        fArr[0] = sin;
        fArr[1] = cos;
    }

    public int d(p pVar) {
        float f2;
        float f10 = this.f3047b;
        double d5 = f10;
        float f11 = this.f3048c;
        if (d5 != 0.0d) {
            double d8 = f11;
            if (d8 != 0.0d) {
                f2 = f10 / ((float) Math.sqrt(d8 / 100.0d));
                float pow = (float) Math.pow(f2 / Math.pow(1.64d - Math.pow(0.29d, pVar.f3084f), 0.73d), 1.1111111111111112d);
                double d10 = (this.f3046a * 3.1415927f) / 180.0f;
                float cos = ((float) (Math.cos(2.0d + d10) + 3.8d)) * 0.25f;
                float pow2 = pVar.f3080a * ((float) Math.pow(f11 / 100.0d, (1.0d / pVar.f3083d) / pVar.f3088j));
                float f12 = cos * 3846.1538f * pVar.e * pVar.f3082c;
                float f13 = pow2 / pVar.f3081b;
                float sin = (float) Math.sin(d10);
                float cos2 = (float) Math.cos(d10);
                float f14 = (((0.305f + f13) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (((11.0f * pow) * cos2) + (f12 * 23.0f)));
                float f15 = cos2 * f14;
                float f16 = f14 * sin;
                float f17 = f13 * 460.0f;
                float f18 = ((288.0f * f16) + ((451.0f * f15) + f17)) / 1403.0f;
                float f19 = ((f17 - (891.0f * f15)) - (261.0f * f16)) / 1403.0f;
                float f20 = ((f17 - (f15 * 220.0f)) - (f16 * 6300.0f)) / 1403.0f;
                float max = (float) Math.max(0.0d, (Math.abs(f18) * 27.13d) / (400.0d - Math.abs(f18)));
                float signum = Math.signum(f18);
                float f21 = 100.0f / pVar.f3086h;
                float pow3 = signum * f21 * ((float) Math.pow(max, 2.380952380952381d));
                float signum2 = Math.signum(f19) * f21 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f19) * 27.13d) / (400.0d - Math.abs(f19))), 2.380952380952381d));
                float signum3 = Math.signum(f20) * f21 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f20) * 27.13d) / (400.0d - Math.abs(f20))), 2.380952380952381d));
                float[] fArr = pVar.f3085g;
                float f22 = pow3 / fArr[0];
                float f23 = signum2 / fArr[1];
                float f24 = signum3 / fArr[2];
                float[][] fArr2 = b.f3052b;
                float[] fArr3 = fArr2[0];
                float f25 = (fArr3[2] * f24) + (fArr3[1] * f23) + (fArr3[0] * f22);
                float[] fArr4 = fArr2[1];
                float f26 = (fArr4[2] * f24) + (fArr4[1] * f23) + (fArr4[0] * f22);
                float[] fArr5 = fArr2[2];
                return c1.a.a(f25, f26, (f24 * fArr5[2]) + (f23 * fArr5[1]) + (f22 * fArr5[0]));
            }
        }
        f2 = 0.0f;
        float pow4 = (float) Math.pow(f2 / Math.pow(1.64d - Math.pow(0.29d, pVar.f3084f), 0.73d), 1.1111111111111112d);
        double d102 = (this.f3046a * 3.1415927f) / 180.0f;
        float cos3 = ((float) (Math.cos(2.0d + d102) + 3.8d)) * 0.25f;
        float pow22 = pVar.f3080a * ((float) Math.pow(f11 / 100.0d, (1.0d / pVar.f3083d) / pVar.f3088j));
        float f122 = cos3 * 3846.1538f * pVar.e * pVar.f3082c;
        float f132 = pow22 / pVar.f3081b;
        float sin2 = (float) Math.sin(d102);
        float cos22 = (float) Math.cos(d102);
        float f142 = (((0.305f + f132) * 23.0f) * pow4) / (((pow4 * 108.0f) * sin2) + (((11.0f * pow4) * cos22) + (f122 * 23.0f)));
        float f152 = cos22 * f142;
        float f162 = f142 * sin2;
        float f172 = f132 * 460.0f;
        float f182 = ((288.0f * f162) + ((451.0f * f152) + f172)) / 1403.0f;
        float f192 = ((f172 - (891.0f * f152)) - (261.0f * f162)) / 1403.0f;
        float f202 = ((f172 - (f152 * 220.0f)) - (f162 * 6300.0f)) / 1403.0f;
        float max2 = (float) Math.max(0.0d, (Math.abs(f182) * 27.13d) / (400.0d - Math.abs(f182)));
        float signum4 = Math.signum(f182);
        float f212 = 100.0f / pVar.f3086h;
        float pow32 = signum4 * f212 * ((float) Math.pow(max2, 2.380952380952381d));
        float signum22 = Math.signum(f192) * f212 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f192) * 27.13d) / (400.0d - Math.abs(f192))), 2.380952380952381d));
        float signum32 = Math.signum(f202) * f212 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f202) * 27.13d) / (400.0d - Math.abs(f202))), 2.380952380952381d));
        float[] fArr6 = pVar.f3085g;
        float f222 = pow32 / fArr6[0];
        float f232 = signum22 / fArr6[1];
        float f242 = signum32 / fArr6[2];
        float[][] fArr22 = b.f3052b;
        float[] fArr32 = fArr22[0];
        float f252 = (fArr32[2] * f242) + (fArr32[1] * f232) + (fArr32[0] * f222);
        float[] fArr42 = fArr22[1];
        float f262 = (fArr42[2] * f242) + (fArr42[1] * f232) + (fArr42[0] * f222);
        float[] fArr52 = fArr22[2];
        return c1.a.a(f252, f262, (f242 * fArr52[2]) + (f232 * fArr52[1]) + (f222 * fArr52[0]));
    }
}
