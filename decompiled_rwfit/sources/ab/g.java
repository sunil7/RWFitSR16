package ab;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.SwitchCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.internal.mlkit_vision_barcode.jd;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import j2.o0;
import java.util.Arrays;
import java.util.WeakHashMap;
import l1.i0;
import l1.j0;
import l1.z0;

/* loaded from: classes.dex */
public final class g extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f161a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(int i3, Class cls, String str) {
        super(cls, str);
        this.f161a = i3;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f161a) {
            case 0:
                return Float.valueOf(((h) obj).f171i);
            case 1:
                return Float.valueOf(((h) obj).f172j);
            case 2:
                return Float.valueOf(((l) obj).b());
            case 3:
                return Float.valueOf(((r) obj).f208i);
            case 4:
                return Float.valueOf(((s) obj).f216i);
            case 5:
                return Float.valueOf(((SwitchCompat) obj).f835z);
            case 6:
                return null;
            case 7:
                return null;
            case 8:
                return null;
            case 9:
                return null;
            case 10:
                return null;
            case 11:
                return null;
            case 12:
                return null;
            case 13:
                return null;
            case 14:
                return Float.valueOf(o0.f15272a.a((View) obj));
            case 15:
                WeakHashMap weakHashMap = z0.f15748a;
                return j0.a((View) obj);
            case 16:
                return Float.valueOf(((View) obj).getLayoutParams().width);
            case 17:
                return Float.valueOf(((View) obj).getLayoutParams().height);
            case 18:
                WeakHashMap weakHashMap2 = z0.f15748a;
                return Float.valueOf(i0.f((View) obj));
            default:
                WeakHashMap weakHashMap3 = z0.f15748a;
                return Float.valueOf(i0.e((View) obj));
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f161a) {
            case 0:
                h hVar = (h) obj;
                float floatValue = ((Float) obj2).floatValue();
                hVar.f171i = floatValue;
                int i3 = (int) (5400.0f * floatValue);
                float f2 = floatValue * 1520.0f;
                float[] fArr = (float[]) hVar.f195b;
                fArr[0] = (-20.0f) + f2;
                fArr[1] = f2;
                int i10 = 0;
                while (true) {
                    v1.a aVar = hVar.f168f;
                    if (i10 >= 4) {
                        float f10 = fArr[0];
                        float f11 = fArr[1];
                        float f12 = ((f11 - f10) * hVar.f172j) + f10;
                        fArr[0] = f12;
                        fArr[0] = f12 / 360.0f;
                        fArr[1] = f11 / 360.0f;
                        int i11 = 0;
                        while (true) {
                            if (i11 < 4) {
                                float f13 = (i3 - h.f164n[i11]) / AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID;
                                if (f13 < 0.0f || f13 > 1.0f) {
                                    i11++;
                                } else {
                                    int i12 = i11 + hVar.f170h;
                                    CircularProgressIndicatorSpec circularProgressIndicatorSpec = hVar.f169g;
                                    int[] iArr = circularProgressIndicatorSpec.f153c;
                                    int length = i12 % iArr.length;
                                    ((int[]) hVar.f196c)[0] = ja.b.a(aVar.getInterpolation(f13), Integer.valueOf(x.a(iArr[length], ((o) hVar.f194a).f191j)), Integer.valueOf(x.a(circularProgressIndicatorSpec.f153c[(1 + length) % iArr.length], ((o) hVar.f194a).f191j))).intValue();
                                }
                            }
                        }
                        ((o) hVar.f194a).invalidateSelf();
                        break;
                    } else {
                        float f14 = 667;
                        fArr[1] = (aVar.getInterpolation((i3 - h.f162l[i10]) / f14) * 250.0f) + fArr[1];
                        fArr[0] = (aVar.getInterpolation((i3 - h.f163m[i10]) / f14) * 250.0f) + fArr[0];
                        i10++;
                    }
                }
                break;
            case 1:
                ((h) obj).f172j = ((Float) obj2).floatValue();
                break;
            case 2:
                l lVar = (l) obj;
                float floatValue2 = ((Float) obj2).floatValue();
                if (lVar.f189h != floatValue2) {
                    lVar.f189h = floatValue2;
                    lVar.invalidateSelf();
                    break;
                }
                break;
            case 3:
                r rVar = (r) obj;
                rVar.f208i = ((Float) obj2).floatValue();
                float[] fArr2 = (float[]) rVar.f195b;
                fArr2[0] = 0.0f;
                float f15 = ((int) (r15 * 333.0f)) / 667;
                v1.a aVar2 = rVar.e;
                float interpolation = aVar2.getInterpolation(f15);
                fArr2[2] = interpolation;
                fArr2[1] = interpolation;
                float interpolation2 = aVar2.getInterpolation(f15 + 0.49925038f);
                fArr2[4] = interpolation2;
                fArr2[3] = interpolation2;
                fArr2[5] = 1.0f;
                if (rVar.f207h && interpolation2 < 1.0f) {
                    int[] iArr2 = (int[]) rVar.f196c;
                    iArr2[2] = iArr2[1];
                    iArr2[1] = iArr2[0];
                    iArr2[0] = x.a(rVar.f205f.f153c[rVar.f206g], ((o) rVar.f194a).f191j);
                    rVar.f207h = false;
                }
                ((o) rVar.f194a).invalidateSelf();
                break;
            case 4:
                s sVar = (s) obj;
                float floatValue3 = ((Float) obj2).floatValue();
                sVar.f216i = floatValue3;
                int i13 = (int) (floatValue3 * 1800.0f);
                for (int i14 = 0; i14 < 4; i14++) {
                    ((float[]) sVar.f195b)[i14] = Math.max(0.0f, Math.min(1.0f, sVar.e[i14].getInterpolation((i13 - s.f210m[i14]) / s.f209l[i14])));
                }
                if (sVar.f215h) {
                    Arrays.fill((int[]) sVar.f196c, x.a(sVar.f213f.f153c[sVar.f214g], ((o) sVar.f194a).f191j));
                    sVar.f215h = false;
                }
                ((o) sVar.f194a).invalidateSelf();
                break;
            case 5:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
            case 6:
                j2.e eVar = (j2.e) obj;
                PointF pointF = (PointF) obj2;
                eVar.getClass();
                eVar.f15194a = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                eVar.f15195b = round;
                int i15 = eVar.f15198f + 1;
                eVar.f15198f = i15;
                if (i15 == eVar.f15199g) {
                    o0.a(eVar.e, eVar.f15194a, round, eVar.f15196c, eVar.f15197d);
                    eVar.f15198f = 0;
                    eVar.f15199g = 0;
                    break;
                }
                break;
            case 7:
                j2.e eVar2 = (j2.e) obj;
                PointF pointF2 = (PointF) obj2;
                eVar2.getClass();
                eVar2.f15196c = Math.round(pointF2.x);
                int round2 = Math.round(pointF2.y);
                eVar2.f15197d = round2;
                int i16 = eVar2.f15199g + 1;
                eVar2.f15199g = i16;
                if (eVar2.f15198f == i16) {
                    o0.a(eVar2.e, eVar2.f15194a, eVar2.f15195b, eVar2.f15196c, round2);
                    eVar2.f15198f = 0;
                    eVar2.f15199g = 0;
                    break;
                }
                break;
            case 8:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                o0.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 9:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                o0.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case 10:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int round3 = Math.round(pointF5.x);
                int round4 = Math.round(pointF5.y);
                o0.a(view3, round3, round4, view3.getWidth() + round3, view3.getHeight() + round4);
                break;
            case 11:
                ImageView imageView = (ImageView) obj;
                Matrix matrix = (Matrix) obj2;
                if (Build.VERSION.SDK_INT >= 29) {
                    imageView.animateTransform(matrix);
                    break;
                } else if (matrix == null) {
                    Drawable drawable = imageView.getDrawable();
                    if (drawable != null) {
                        drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                        imageView.invalidate();
                        break;
                    }
                } else if (jd.f9368a) {
                    try {
                        imageView.animateTransform(matrix);
                        break;
                    } catch (NoSuchMethodError unused) {
                        jd.f9368a = false;
                        return;
                    }
                }
                break;
            case 12:
                j2.l lVar2 = (j2.l) obj;
                float[] fArr3 = (float[]) obj2;
                lVar2.getClass();
                System.arraycopy(fArr3, 0, lVar2.f15251c, 0, fArr3.length);
                lVar2.a();
                break;
            case 13:
                j2.l lVar3 = (j2.l) obj;
                PointF pointF6 = (PointF) obj2;
                lVar3.getClass();
                lVar3.f15252d = pointF6.x;
                lVar3.e = pointF6.y;
                lVar3.a();
                break;
            case 14:
                o0.b((View) obj, ((Float) obj2).floatValue());
                break;
            case 15:
                WeakHashMap weakHashMap = z0.f15748a;
                j0.c((View) obj, (Rect) obj2);
                break;
            case 16:
                View view4 = (View) obj;
                view4.getLayoutParams().width = ((Float) obj2).intValue();
                view4.requestLayout();
                break;
            case 17:
                View view5 = (View) obj;
                view5.getLayoutParams().height = ((Float) obj2).intValue();
                view5.requestLayout();
                break;
            case 18:
                View view6 = (View) obj;
                int intValue = ((Float) obj2).intValue();
                int paddingTop = view6.getPaddingTop();
                WeakHashMap weakHashMap2 = z0.f15748a;
                i0.k(view6, intValue, paddingTop, i0.e(view6), view6.getPaddingBottom());
                break;
            default:
                View view7 = (View) obj;
                WeakHashMap weakHashMap3 = z0.f15748a;
                i0.k(view7, i0.f(view7), view7.getPaddingTop(), ((Float) obj2).intValue(), view7.getPaddingBottom());
                break;
        }
    }
}
