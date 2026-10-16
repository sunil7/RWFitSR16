package com.otaliastudios.opengl.texture;

import android.opengl.GLES20;
import eh.g;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f11633a;

    public a(Integer num) {
        int intValue;
        if (num == null) {
            int[] iArr = {r2[0]};
            GLES20.glGenTextures(1, iArr, 0);
            int[] iArr2 = {iArr[0]};
            xf.a.b("glGenTextures");
            intValue = iArr2[0];
        } else {
            intValue = num.intValue();
        }
        this.f11633a = intValue;
        if (num == null) {
            final Integer num2 = null;
            oh.a aVar = new oh.a() { // from class: com.otaliastudios.opengl.texture.GlTexture$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // oh.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m73invoke();
                    return g.f12633a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m73invoke() {
                    a.this.getClass();
                    a.this.getClass();
                    GLES20.glTexParameterf(36197, 10241, 9728.0f);
                    a.this.getClass();
                    GLES20.glTexParameterf(36197, 10240, 9729.0f);
                    a.this.getClass();
                    GLES20.glTexParameteri(36197, 10242, 33071);
                    a.this.getClass();
                    GLES20.glTexParameteri(36197, 10243, 33071);
                    xf.a.b("glTexParameter");
                }
            };
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, intValue);
            xf.a.b("bind");
            aVar.invoke();
            GLES20.glBindTexture(36197, 0);
            GLES20.glActiveTexture(33984);
            xf.a.b("unbind");
        }
    }
}
