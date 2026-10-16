package qf;

import android.graphics.RectF;
import android.opengl.GLES20;
import androidx.recyclerview.widget.e1;
import com.google.android.gms.internal.mlkit_vision_barcode.f1;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import o2.m;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final com.otaliastudios.opengl.texture.a f17940a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f17941b;

    /* renamed from: c, reason: collision with root package name */
    public of.a f17942c;

    /* renamed from: d, reason: collision with root package name */
    public of.a f17943d;
    public int e;

    static {
        ef.b.a(d.class.getSimpleName());
    }

    public d() {
        this(new com.otaliastudios.opengl.texture.a(null));
    }

    public final void a() {
        int i3;
        FloatBuffer floatBuffer;
        if (this.f17943d != null) {
            b();
            this.f17942c = this.f17943d;
            this.f17943d = null;
        }
        if (this.e == -1) {
            ((of.b) this.f17942c).getClass();
            ((of.b) this.f17942c).getClass();
            m[] mVarArr = {new m(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n"), new m(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n")};
            int glCreateProgram = GLES20.glCreateProgram();
            xf.a.b("glCreateProgram");
            if (glCreateProgram == 0) {
                throw new RuntimeException("Could not create program");
            }
            for (int i10 = 0; i10 < 2; i10++) {
                GLES20.glAttachShader(glCreateProgram, mVarArr[i10].f16720b);
                xf.a.b("glAttachShader");
            }
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String k10 = kotlin.jvm.internal.e.k(GLES20.glGetProgramInfoLog(glCreateProgram), "Could not link program: ");
                GLES20.glDeleteProgram(glCreateProgram);
                throw new RuntimeException(k10);
            }
            this.e = glCreateProgram;
            of.b bVar = (of.b) this.f17942c;
            bVar.getClass();
            bVar.f16924a = new com.otaliastudios.opengl.program.b(glCreateProgram);
            yf.a aVar = new yf.a();
            FloatBuffer a3 = f1.a(8);
            a3.put(yf.a.f20127d);
            a3.clear();
            aVar.f20130c = a3;
            bVar.f16925b = aVar;
            xf.a.b("program creation");
        }
        GLES20.glUseProgram(this.e);
        xf.a.b("glUseProgram(handle)");
        com.otaliastudios.opengl.texture.a aVar2 = this.f17940a;
        aVar2.getClass();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, aVar2.f11633a);
        xf.a.b("bind");
        of.b bVar2 = (of.b) this.f17942c;
        com.otaliastudios.opengl.program.b bVar3 = bVar2.f16924a;
        if (bVar3 == null) {
            of.b.f16923d.b(2, "Filter.draw() called after destroying the filter. This can happen rarely because of threading.");
            i3 = 33984;
        } else {
            float[] fArr = this.f17941b;
            kotlin.jvm.internal.e.f(fArr, "<set-?>");
            bVar3.f11625c = fArr;
            com.otaliastudios.opengl.program.b bVar4 = bVar2.f16924a;
            yf.a aVar3 = bVar2.f16925b;
            float[] modelViewProjectionMatrix = aVar3.f20128a;
            bVar4.getClass();
            kotlin.jvm.internal.e.f(modelViewProjectionMatrix, "modelViewProjectionMatrix");
            GLES20.glUniformMatrix4fv(bVar4.f11629h.f2554b, 1, false, modelViewProjectionMatrix, 0);
            xf.a.b("glUniformMatrix4fv");
            e1 e1Var = bVar4.f11626d;
            if (e1Var != null) {
                GLES20.glUniformMatrix4fv(e1Var.f2554b, 1, false, bVar4.f11625c, 0);
                xf.a.b("glUniformMatrix4fv");
            }
            e1 e1Var2 = bVar4.f11628g;
            GLES20.glEnableVertexAttribArray(e1Var2.f2555c);
            xf.a.b("glEnableVertexAttribArray");
            int i11 = aVar3.f20129b;
            int i12 = i11 * 4;
            GLES20.glVertexAttribPointer(e1Var2.f2555c, 2, 5126, false, i12, (Buffer) aVar3.f20130c);
            xf.a.b("glVertexAttribPointer");
            e1 e1Var3 = bVar4.f11627f;
            if (e1Var3 == null) {
                i3 = 33984;
            } else {
                if (aVar3.equals(bVar4.f11632k) && bVar4.f11631j == 0) {
                    i3 = 33984;
                } else {
                    bVar4.f11632k = aVar3;
                    bVar4.f11631j = 0;
                    RectF rect = bVar4.f11630i;
                    kotlin.jvm.internal.e.f(rect, "rect");
                    float f2 = -3.4028235E38f;
                    i3 = 33984;
                    int i13 = 0;
                    float f10 = Float.MAX_VALUE;
                    float f11 = Float.MAX_VALUE;
                    float f12 = -3.4028235E38f;
                    while (true) {
                        floatBuffer = aVar3.f20130c;
                        if (!floatBuffer.hasRemaining()) {
                            break;
                        }
                        float f13 = floatBuffer.get();
                        if (i13 % 2 == 0) {
                            f10 = Math.min(f10, f13);
                            f12 = Math.max(f12, f13);
                        } else {
                            f2 = Math.max(f2, f13);
                            f11 = Math.min(f11, f13);
                        }
                        i13++;
                    }
                    floatBuffer.rewind();
                    rect.set(f10, f2, f12, f11);
                    int limit = (aVar3.f20130c.limit() / i11) * 2;
                    if (bVar4.e.capacity() < limit) {
                        kotlin.jvm.internal.e.f(bVar4.e, "<this>");
                        bVar4.e = f1.a(limit);
                    }
                    bVar4.e.clear();
                    bVar4.e.limit(limit);
                    if (limit > 0) {
                        int i14 = 0;
                        while (true) {
                            int i15 = i14 + 1;
                            boolean z5 = i14 % 2 == 0;
                            float f14 = floatBuffer.get(i14);
                            float f15 = z5 ? rect.left : rect.bottom;
                            bVar4.e.put((((f14 - f15) / ((z5 ? rect.right : rect.top) - f15)) * 1.0f) + 0.0f);
                            if (i15 >= limit) {
                                break;
                            } else {
                                i14 = i15;
                            }
                        }
                    }
                }
                bVar4.e.rewind();
                GLES20.glEnableVertexAttribArray(e1Var3.f2555c);
                xf.a.b("glEnableVertexAttribArray");
                GLES20.glVertexAttribPointer(e1Var3.f2555c, 2, 5126, false, i12, (Buffer) bVar4.e);
                xf.a.b("glVertexAttribPointer");
            }
            com.otaliastudios.opengl.program.b bVar5 = bVar2.f16924a;
            yf.a drawable = bVar2.f16925b;
            bVar5.getClass();
            kotlin.jvm.internal.e.f(drawable, "drawable");
            xf.a.b("glDrawArrays start");
            GLES20.glDrawArrays(5, 0, drawable.f20130c.limit() / drawable.f20129b);
            xf.a.b("glDrawArrays end");
            com.otaliastudios.opengl.program.b bVar6 = bVar2.f16924a;
            yf.a drawable2 = bVar2.f16925b;
            bVar6.getClass();
            kotlin.jvm.internal.e.f(drawable2, "drawable");
            GLES20.glDisableVertexAttribArray(bVar6.f11628g.f2555c);
            e1 e1Var4 = bVar6.f11627f;
            if (e1Var4 != null) {
                GLES20.glDisableVertexAttribArray(e1Var4.f2555c);
            }
            xf.a.b("onPostDraw end");
        }
        GLES20.glBindTexture(36197, 0);
        GLES20.glActiveTexture(i3);
        xf.a.b("unbind");
        GLES20.glUseProgram(0);
        xf.a.b("glUseProgram(0)");
    }

    public final void b() {
        if (this.e == -1) {
            return;
        }
        of.b bVar = (of.b) this.f17942c;
        com.otaliastudios.opengl.program.b bVar2 = bVar.f16924a;
        if (!bVar2.f11624b) {
            for (m mVar : bVar2.f11623a) {
                GLES20.glDeleteShader(mVar.f16720b);
            }
            bVar2.f11624b = true;
        }
        kotlin.jvm.internal.e.f(bVar2.e, "<this>");
        bVar.f16924a = null;
        bVar.f16925b = null;
        GLES20.glDeleteProgram(this.e);
        this.e = -1;
    }

    public d(com.otaliastudios.opengl.texture.a aVar) {
        this.f17941b = (float[]) xf.a.f19823a.clone();
        this.f17942c = new of.b();
        this.f17943d = null;
        this.e = -1;
        this.f17940a = aVar;
    }
}
