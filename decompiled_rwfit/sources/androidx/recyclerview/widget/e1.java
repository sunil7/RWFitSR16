package androidx.recyclerview.widget;

import android.opengl.GLES20;
import android.util.Log;
import android.view.View;
import com.otaliastudios.opengl.program.GlProgramLocation$Type;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
public final class e1 implements v4.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2553a;

    /* renamed from: b, reason: collision with root package name */
    public int f2554b;

    /* renamed from: c, reason: collision with root package name */
    public int f2555c;

    public /* synthetic */ e1(int i3) {
        this.f2553a = i3;
    }

    public void a(z1 z1Var) {
        View view = z1Var.itemView;
        this.f2554b = view.getLeft();
        this.f2555c = view.getTop();
        view.getRight();
        view.getBottom();
    }

    public com.google.zxing.h b() {
        return new com.google.zxing.h(this.f2554b, this.f2555c);
    }

    @Override // v4.a
    public Object getItem(int i3) {
        if (i3 < 0 || i3 >= z()) {
            return 0;
        }
        return Integer.valueOf(this.f2554b + i3);
    }

    public String toString() {
        switch (this.f2553a) {
            case 5:
                StringBuilder sb2 = new StringBuilder("<");
                sb2.append(this.f2554b);
                sb2.append(' ');
                return android.support.v4.media.session.e.m(sb2, this.f2555c, '>');
            default:
                return super.toString();
        }
    }

    @Override // v4.a
    public int z() {
        return (this.f2555c - this.f2554b) + 1;
    }

    public /* synthetic */ e1(int i3, int i10, int i11) {
        this.f2553a = i11;
        this.f2554b = i3;
        this.f2555c = i10;
    }

    public e1(int i3, GlProgramLocation$Type glProgramLocation$Type, String str) {
        int glGetAttribLocation;
        this.f2553a = 1;
        int i10 = com.otaliastudios.opengl.program.a.f11622a[glProgramLocation$Type.ordinal()];
        if (i10 == 1) {
            glGetAttribLocation = GLES20.glGetAttribLocation(i3, str);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            glGetAttribLocation = GLES20.glGetUniformLocation(i3, str);
        }
        this.f2554b = glGetAttribLocation;
        float[] fArr = xf.a.f19823a;
        if (glGetAttribLocation >= 0) {
            this.f2555c = glGetAttribLocation;
            return;
        }
        String str2 = "Unable to locate " + str + " in program";
        Log.e("Egloo", str2);
        throw new RuntimeException(str2);
    }
}
