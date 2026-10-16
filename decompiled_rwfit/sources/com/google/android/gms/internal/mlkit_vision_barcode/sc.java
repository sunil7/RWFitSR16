package com.google.android.gms.internal.mlkit_vision_barcode;

import android.opengl.GLES20;
import android.opengl.GLU;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class sc {
    public static void a(int i3, int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            StringBuilder sb2 = new StringBuilder(r5.a.a(r5.a.a(10, glGetShaderInfoLog), str));
            sb2.append(glGetShaderInfoLog);
            sb2.append(", source: ");
            sb2.append(str);
            Log.e("GlUtil", sb2.toString());
        }
        GLES20.glAttachShader(i10, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        b();
    }

    public static void b() {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            String valueOf = String.valueOf(GLU.gluErrorString(glGetError));
            Log.e("GlUtil", valueOf.length() != 0 ? "glError ".concat(valueOf) : new String("glError "));
        }
    }

    public static int c(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        b();
        a(35633, glCreateProgram, str);
        a(35632, glCreateProgram, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            String valueOf = String.valueOf(GLES20.glGetProgramInfoLog(glCreateProgram));
            Log.e("GlUtil", valueOf.length() != 0 ? "Unable to link shader program: \n".concat(valueOf) : new String("Unable to link shader program: \n"));
        }
        b();
        return glCreateProgram;
    }
}
