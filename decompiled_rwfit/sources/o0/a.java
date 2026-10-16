package o0;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Arrays;
import n.l;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public final b f16638b;

    /* renamed from: c, reason: collision with root package name */
    public final l f16639c;

    /* renamed from: a, reason: collision with root package name */
    public int f16637a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f16640d = 8;
    public int[] e = new int[8];

    /* renamed from: f, reason: collision with root package name */
    public int[] f16641f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public float[] f16642g = new float[8];

    /* renamed from: h, reason: collision with root package name */
    public int f16643h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f16644i = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16645j = false;

    public a(b bVar, l lVar) {
        this.f16638b = bVar;
        this.f16639c = lVar;
    }

    public final void a(e eVar, float f2, boolean z5) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int i3 = this.f16643h;
            b bVar = this.f16638b;
            if (i3 == -1) {
                this.f16643h = 0;
                this.f16642g[0] = f2;
                this.e[0] = eVar.f16671b;
                this.f16641f[0] = -1;
                eVar.f16680l++;
                eVar.a(bVar);
                this.f16637a++;
                if (this.f16645j) {
                    return;
                }
                int i10 = this.f16644i + 1;
                this.f16644i = i10;
                int[] iArr = this.e;
                if (i10 >= iArr.length) {
                    this.f16645j = true;
                    this.f16644i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i11 = -1;
            for (int i12 = 0; i3 != -1 && i12 < this.f16637a; i12++) {
                int i13 = this.e[i3];
                int i14 = eVar.f16671b;
                if (i13 == i14) {
                    float[] fArr = this.f16642g;
                    float f10 = fArr[i3] + f2;
                    if (f10 > -0.001f && f10 < 0.001f) {
                        f10 = 0.0f;
                    }
                    fArr[i3] = f10;
                    if (f10 == 0.0f) {
                        if (i3 == this.f16643h) {
                            this.f16643h = this.f16641f[i3];
                        } else {
                            int[] iArr2 = this.f16641f;
                            iArr2[i11] = iArr2[i3];
                        }
                        if (z5) {
                            eVar.b(bVar);
                        }
                        if (this.f16645j) {
                            this.f16644i = i3;
                        }
                        eVar.f16680l--;
                        this.f16637a--;
                        return;
                    }
                    return;
                }
                if (i13 < i14) {
                    i11 = i3;
                }
                i3 = this.f16641f[i3];
            }
            int i15 = this.f16644i;
            int i16 = i15 + 1;
            if (this.f16645j) {
                int[] iArr3 = this.e;
                if (iArr3[i15] != -1) {
                    i15 = iArr3.length;
                }
            } else {
                i15 = i16;
            }
            int[] iArr4 = this.e;
            if (i15 >= iArr4.length && this.f16637a < iArr4.length) {
                int i17 = 0;
                while (true) {
                    int[] iArr5 = this.e;
                    if (i17 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i17] == -1) {
                        i15 = i17;
                        break;
                    }
                    i17++;
                }
            }
            int[] iArr6 = this.e;
            if (i15 >= iArr6.length) {
                i15 = iArr6.length;
                int i18 = this.f16640d * 2;
                this.f16640d = i18;
                this.f16645j = false;
                this.f16644i = i15 - 1;
                this.f16642g = Arrays.copyOf(this.f16642g, i18);
                this.e = Arrays.copyOf(this.e, this.f16640d);
                this.f16641f = Arrays.copyOf(this.f16641f, this.f16640d);
            }
            this.e[i15] = eVar.f16671b;
            this.f16642g[i15] = f2;
            if (i11 != -1) {
                int[] iArr7 = this.f16641f;
                iArr7[i15] = iArr7[i11];
                iArr7[i11] = i15;
            } else {
                this.f16641f[i15] = this.f16643h;
                this.f16643h = i15;
            }
            eVar.f16680l++;
            eVar.a(bVar);
            this.f16637a++;
            if (!this.f16645j) {
                this.f16644i++;
            }
            int i19 = this.f16644i;
            int[] iArr8 = this.e;
            if (i19 >= iArr8.length) {
                this.f16645j = true;
                this.f16644i = iArr8.length - 1;
            }
        }
    }

    public final void b() {
        int i3 = this.f16643h;
        for (int i10 = 0; i3 != -1 && i10 < this.f16637a; i10++) {
            e eVar = ((e[]) this.f16639c.f16247d)[this.e[i3]];
            if (eVar != null) {
                eVar.b(this.f16638b);
            }
            i3 = this.f16641f[i3];
        }
        this.f16643h = -1;
        this.f16644i = -1;
        this.f16645j = false;
        this.f16637a = 0;
    }

    public final float c(e eVar) {
        int i3 = this.f16643h;
        for (int i10 = 0; i3 != -1 && i10 < this.f16637a; i10++) {
            if (this.e[i3] == eVar.f16671b) {
                return this.f16642g[i3];
            }
            i3 = this.f16641f[i3];
        }
        return 0.0f;
    }

    public final int d() {
        return this.f16637a;
    }

    public final e e(int i3) {
        int i10 = this.f16643h;
        for (int i11 = 0; i10 != -1 && i11 < this.f16637a; i11++) {
            if (i11 == i3) {
                return ((e[]) this.f16639c.f16247d)[this.e[i10]];
            }
            i10 = this.f16641f[i10];
        }
        return null;
    }

    public final float f(int i3) {
        int i10 = this.f16643h;
        for (int i11 = 0; i10 != -1 && i11 < this.f16637a; i11++) {
            if (i11 == i3) {
                return this.f16642g[i10];
            }
            i10 = this.f16641f[i10];
        }
        return 0.0f;
    }

    public final void g(e eVar, float f2) {
        if (f2 == 0.0f) {
            h(eVar, true);
            return;
        }
        int i3 = this.f16643h;
        b bVar = this.f16638b;
        if (i3 == -1) {
            this.f16643h = 0;
            this.f16642g[0] = f2;
            this.e[0] = eVar.f16671b;
            this.f16641f[0] = -1;
            eVar.f16680l++;
            eVar.a(bVar);
            this.f16637a++;
            if (this.f16645j) {
                return;
            }
            int i10 = this.f16644i + 1;
            this.f16644i = i10;
            int[] iArr = this.e;
            if (i10 >= iArr.length) {
                this.f16645j = true;
                this.f16644i = iArr.length - 1;
                return;
            }
            return;
        }
        int i11 = -1;
        for (int i12 = 0; i3 != -1 && i12 < this.f16637a; i12++) {
            int i13 = this.e[i3];
            int i14 = eVar.f16671b;
            if (i13 == i14) {
                this.f16642g[i3] = f2;
                return;
            }
            if (i13 < i14) {
                i11 = i3;
            }
            i3 = this.f16641f[i3];
        }
        int i15 = this.f16644i;
        int i16 = i15 + 1;
        if (this.f16645j) {
            int[] iArr2 = this.e;
            if (iArr2[i15] != -1) {
                i15 = iArr2.length;
            }
        } else {
            i15 = i16;
        }
        int[] iArr3 = this.e;
        if (i15 >= iArr3.length && this.f16637a < iArr3.length) {
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.e;
                if (i17 >= iArr4.length) {
                    break;
                }
                if (iArr4[i17] == -1) {
                    i15 = i17;
                    break;
                }
                i17++;
            }
        }
        int[] iArr5 = this.e;
        if (i15 >= iArr5.length) {
            i15 = iArr5.length;
            int i18 = this.f16640d * 2;
            this.f16640d = i18;
            this.f16645j = false;
            this.f16644i = i15 - 1;
            this.f16642g = Arrays.copyOf(this.f16642g, i18);
            this.e = Arrays.copyOf(this.e, this.f16640d);
            this.f16641f = Arrays.copyOf(this.f16641f, this.f16640d);
        }
        this.e[i15] = eVar.f16671b;
        this.f16642g[i15] = f2;
        if (i11 != -1) {
            int[] iArr6 = this.f16641f;
            iArr6[i15] = iArr6[i11];
            iArr6[i11] = i15;
        } else {
            this.f16641f[i15] = this.f16643h;
            this.f16643h = i15;
        }
        eVar.f16680l++;
        eVar.a(bVar);
        int i19 = this.f16637a + 1;
        this.f16637a = i19;
        if (!this.f16645j) {
            this.f16644i++;
        }
        int[] iArr7 = this.e;
        if (i19 >= iArr7.length) {
            this.f16645j = true;
        }
        if (this.f16644i >= iArr7.length) {
            this.f16645j = true;
            this.f16644i = iArr7.length - 1;
        }
    }

    public final float h(e eVar, boolean z5) {
        int i3 = this.f16643h;
        if (i3 == -1) {
            return 0.0f;
        }
        int i10 = 0;
        int i11 = -1;
        while (i3 != -1 && i10 < this.f16637a) {
            if (this.e[i3] == eVar.f16671b) {
                if (i3 == this.f16643h) {
                    this.f16643h = this.f16641f[i3];
                } else {
                    int[] iArr = this.f16641f;
                    iArr[i11] = iArr[i3];
                }
                if (z5) {
                    eVar.b(this.f16638b);
                }
                eVar.f16680l--;
                this.f16637a--;
                this.e[i3] = -1;
                if (this.f16645j) {
                    this.f16644i = i3;
                }
                return this.f16642g[i3];
            }
            i10++;
            i11 = i3;
            i3 = this.f16641f[i3];
        }
        return 0.0f;
    }

    public final String toString() {
        int i3 = this.f16643h;
        String str = "";
        for (int i10 = 0; i3 != -1 && i10 < this.f16637a; i10++) {
            StringBuilder t8 = l0.t(android.support.v4.media.session.e.l(str, " -> "));
            t8.append(this.f16642g[i3]);
            t8.append(" : ");
            StringBuilder t10 = l0.t(t8.toString());
            t10.append(((e[]) this.f16639c.f16247d)[this.e[i3]]);
            str = t10.toString();
            i3 = this.f16641f[i3];
        }
        return str;
    }
}
