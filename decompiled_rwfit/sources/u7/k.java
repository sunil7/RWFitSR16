package u7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.github.mikephil.charting.components.Legend$LegendDirection;
import com.github.mikephil.charting.components.Legend$LegendForm;
import com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment;
import com.github.mikephil.charting.components.Legend$LegendOrientation;
import com.github.mikephil.charting.components.Legend$LegendVerticalAlignment;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k extends a4.a {

    /* renamed from: b, reason: collision with root package name */
    public Paint f18956b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f18957c;

    /* renamed from: d, reason: collision with root package name */
    public n7.f f18958d;
    public ArrayList e;

    /* renamed from: f, reason: collision with root package name */
    public Paint.FontMetrics f18959f;

    /* renamed from: g, reason: collision with root package name */
    public Path f18960g;

    public final void j(o7.h hVar) {
        ArrayList arrayList;
        String str;
        n7.f fVar = this.f18958d;
        fVar.getClass();
        ArrayList arrayList2 = this.e;
        arrayList2.clear();
        for (int i3 = 0; i3 < hVar.c(); i3++) {
            o7.d b3 = hVar.b(i3);
            if (b3 != null) {
                ArrayList arrayList3 = b3.f16807a;
                int size = b3.f16820o.size();
                if (b3 instanceof o7.b) {
                    o7.b bVar = (o7.b) b3;
                    if (bVar.o()) {
                        int min = Math.min(arrayList3.size(), bVar.f16802u);
                        for (int i10 = 0; i10 < min; i10++) {
                            String[] strArr = bVar.f16806y;
                            if (strArr.length > 0) {
                                int i11 = i10 % min;
                                str = i11 < strArr.length ? strArr[i11] : null;
                            } else {
                                str = null;
                            }
                            arrayList2.add(new n7.g(str, b3.f16812g, b3.f16813h, b3.f16814i, ((Integer) arrayList3.get(i10)).intValue()));
                        }
                        if (bVar.f16809c != null) {
                            arrayList2.add(new n7.g(b3.f16809c, Legend$LegendForm.NONE, Float.NaN, Float.NaN, 1122867));
                        }
                    }
                }
                int i12 = 0;
                while (i12 < arrayList3.size() && i12 < size) {
                    arrayList2.add(new n7.g((i12 >= arrayList3.size() - 1 || i12 >= size + (-1)) ? hVar.b(i3).f16809c : null, b3.f16812g, b3.f16813h, b3.f16814i, ((Integer) arrayList3.get(i12)).intValue()));
                    i12++;
                }
            }
        }
        fVar.f16413f = (n7.g[]) arrayList2.toArray(new n7.g[arrayList2.size()]);
        Paint paint = this.f18956b;
        paint.setTextSize(fVar.f16409d);
        paint.setColor(fVar.e);
        float f2 = fVar.f16419l;
        float c9 = v7.h.c(f2);
        float c10 = v7.h.c(fVar.f16423p);
        float f10 = fVar.f16422o;
        float c11 = v7.h.c(f10);
        float c12 = v7.h.c(fVar.f16421n);
        float c13 = v7.h.c(0.0f);
        n7.g[] gVarArr = fVar.f16413f;
        int length = gVarArr.length;
        v7.h.c(f10);
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (n7.g gVar : fVar.f16413f) {
            float c14 = v7.h.c(Float.isNaN(gVar.f16432c) ? f2 : gVar.f16432c);
            if (c14 > f12) {
                f12 = c14;
            }
            String str2 = gVar.f16430a;
            if (str2 != null) {
                float measureText = (int) paint.measureText(str2);
                if (measureText > f11) {
                    f11 = measureText;
                }
            }
        }
        float f13 = 0.0f;
        for (n7.g gVar2 : fVar.f16413f) {
            String str3 = gVar2.f16430a;
            if (str3 != null) {
                float a3 = v7.h.a(paint, str3);
                if (a3 > f13) {
                    f13 = a3;
                }
            }
        }
        fVar.f16426t = f13;
        int i13 = n7.e.f16412a[fVar.f16416i.ordinal()];
        if (i13 == 1) {
            Paint.FontMetrics fontMetrics = v7.h.e;
            paint.getFontMetrics(fontMetrics);
            float f14 = fontMetrics.descent - fontMetrics.ascent;
            float f15 = 0.0f;
            float f16 = 0.0f;
            float f17 = 0.0f;
            boolean z5 = false;
            for (int i14 = 0; i14 < length; i14++) {
                n7.g gVar3 = gVarArr[i14];
                boolean z6 = gVar3.f16431b != Legend$LegendForm.NONE;
                float f18 = gVar3.f16432c;
                float c15 = Float.isNaN(f18) ? c9 : v7.h.c(f18);
                if (!z5) {
                    f17 = 0.0f;
                }
                if (z6) {
                    if (z5) {
                        f17 += c10;
                    }
                    f17 += c15;
                }
                if (gVar3.f16430a != null) {
                    if (z6 && !z5) {
                        f17 += c11;
                    } else if (z5) {
                        f15 = Math.max(f15, f17);
                        f16 += f14 + c13;
                        f17 = 0.0f;
                        z5 = false;
                    }
                    f17 += (int) paint.measureText(r9);
                    f16 = f14 + c13 + f16;
                } else {
                    f17 += c15;
                    if (i14 < length - 1) {
                        f17 += c10;
                    }
                    z5 = true;
                }
                f15 = Math.max(f15, f17);
            }
            fVar.r = f15;
            fVar.f16425s = f16;
        } else if (i13 == 2) {
            Paint.FontMetrics fontMetrics2 = v7.h.e;
            paint.getFontMetrics(fontMetrics2);
            float f19 = fontMetrics2.descent - fontMetrics2.ascent;
            paint.getFontMetrics(fontMetrics2);
            float f20 = (fontMetrics2.ascent - fontMetrics2.top) + fontMetrics2.bottom + c13;
            ((v7.i) this.f78a).f19202b.width();
            ArrayList arrayList4 = fVar.f16428v;
            arrayList4.clear();
            ArrayList arrayList5 = fVar.f16427u;
            arrayList5.clear();
            ArrayList arrayList6 = fVar.f16429w;
            arrayList6.clear();
            float f21 = 0.0f;
            int i15 = -1;
            int i16 = 0;
            float f22 = 0.0f;
            float f23 = 0.0f;
            while (i16 < length) {
                float f24 = c10;
                n7.g gVar4 = gVarArr[i16];
                float f25 = f20;
                float f26 = c11;
                boolean z8 = gVar4.f16431b != Legend$LegendForm.NONE;
                float f27 = gVar4.f16432c;
                float c16 = Float.isNaN(f27) ? c9 : v7.h.c(f27);
                boolean z10 = z8;
                arrayList4.add(Boolean.FALSE);
                float f28 = i15 == -1 ? 0.0f : f22 + f24;
                String str4 = gVar4.f16430a;
                if (str4 != null) {
                    arrayList5.add(v7.h.b(paint, str4));
                    arrayList = arrayList4;
                    f22 = f28 + (z10 ? f26 + c16 : 0.0f) + ((v7.a) arrayList5.get(i16)).f19176b;
                } else {
                    v7.a aVar = (v7.a) v7.a.f19175d.b();
                    arrayList = arrayList4;
                    aVar.f19176b = 0.0f;
                    aVar.f19177c = 0.0f;
                    arrayList5.add(aVar);
                    if (!z10) {
                        c16 = 0.0f;
                    }
                    f22 = f28 + c16;
                    if (i15 == -1) {
                        i15 = i16;
                    }
                }
                if (str4 != null || i16 == length - 1) {
                    float f29 = (f23 == 0.0f ? 0.0f : c12) + f22 + f23;
                    if (i16 == length - 1) {
                        v7.a aVar2 = (v7.a) v7.a.f19175d.b();
                        aVar2.f19176b = f29;
                        aVar2.f19177c = f19;
                        arrayList6.add(aVar2);
                        f21 = Math.max(f21, f29);
                    }
                    f23 = f29;
                }
                if (str4 != null) {
                    i15 = -1;
                }
                i16++;
                c10 = f24;
                f20 = f25;
                c11 = f26;
                arrayList4 = arrayList;
            }
            float f30 = f20;
            fVar.r = f21;
            fVar.f16425s = (f30 * (arrayList6.size() == 0 ? 0 : arrayList6.size() - 1)) + (f19 * arrayList6.size());
        }
        fVar.f16425s += fVar.f16408c;
        fVar.r += fVar.f16407b;
    }

    public final void k(Canvas canvas, float f2, float f10, n7.g gVar, n7.f fVar) {
        int i3 = gVar.e;
        if (i3 == 1122868 || i3 == 1122867 || i3 == 0) {
            return;
        }
        int save = canvas.save();
        Legend$LegendForm legend$LegendForm = Legend$LegendForm.DEFAULT;
        Legend$LegendForm legend$LegendForm2 = gVar.f16431b;
        if (legend$LegendForm2 == legend$LegendForm) {
            legend$LegendForm2 = fVar.f16418k;
        }
        Paint paint = this.f18957c;
        paint.setColor(gVar.e);
        float f11 = gVar.f16432c;
        if (Float.isNaN(f11)) {
            f11 = fVar.f16419l;
        }
        float c9 = v7.h.c(f11);
        float f12 = c9 / 2.0f;
        int i10 = j.f18955d[legend$LegendForm2.ordinal()];
        if (i10 == 3 || i10 == 4) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f2 + f12, f10, f12, paint);
        } else if (i10 == 5) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f2, f10 - f12, f2 + c9, f10 + f12, paint);
        } else if (i10 == 6) {
            float f13 = gVar.f16433d;
            if (Float.isNaN(f13)) {
                f13 = fVar.f16420m;
            }
            float c10 = v7.h.c(f13);
            fVar.getClass();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(c10);
            paint.setPathEffect(null);
            Path path = this.f18960g;
            path.reset();
            path.moveTo(f2, f10);
            path.lineTo(f2 + c9, f10);
            canvas.drawPath(path, paint);
        }
        canvas.restoreToCount(save);
    }

    public final void l(Canvas canvas) {
        float f2;
        float f10;
        float f11;
        int i3;
        ArrayList arrayList;
        int i10;
        Legend$LegendHorizontalAlignment legend$LegendHorizontalAlignment;
        boolean z5;
        String str;
        Canvas canvas2;
        float f12;
        float f13;
        n7.g gVar;
        Legend$LegendDirection legend$LegendDirection;
        float f14;
        Canvas canvas3;
        float f15;
        float width;
        float f16;
        float f17;
        double d5;
        double d8;
        n7.f fVar = this.f18958d;
        if (fVar.f16406a) {
            Paint paint = this.f18956b;
            paint.setTextSize(fVar.f16409d);
            paint.setColor(fVar.e);
            Paint.FontMetrics fontMetrics = this.f18959f;
            DisplayMetrics displayMetrics = v7.h.f19191a;
            paint.getFontMetrics(fontMetrics);
            float f18 = fontMetrics.descent - fontMetrics.ascent;
            paint.getFontMetrics(fontMetrics);
            float c9 = v7.h.c(0.0f) + (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
            float a3 = f18 - (v7.h.a(paint, "ABC") / 2.0f);
            n7.g[] gVarArr = fVar.f16413f;
            float c10 = v7.h.c(fVar.f16422o);
            float c11 = v7.h.c(fVar.f16421n);
            Legend$LegendOrientation legend$LegendOrientation = fVar.f16416i;
            Legend$LegendHorizontalAlignment legend$LegendHorizontalAlignment2 = fVar.f16414g;
            Legend$LegendVerticalAlignment legend$LegendVerticalAlignment = fVar.f16415h;
            Legend$LegendDirection legend$LegendDirection2 = fVar.f16417j;
            float c12 = v7.h.c(fVar.f16419l);
            float c13 = v7.h.c(fVar.f16423p);
            float f19 = fVar.f16408c;
            float f20 = fVar.f16407b;
            int i11 = j.f18952a[legend$LegendHorizontalAlignment2.ordinal()];
            v7.i iVar = (v7.i) this.f78a;
            if (i11 == 1) {
                f2 = c13;
                if (legend$LegendOrientation != Legend$LegendOrientation.VERTICAL) {
                    f20 += iVar.f19202b.left;
                }
                f10 = legend$LegendDirection2 == Legend$LegendDirection.RIGHT_TO_LEFT ? f20 + fVar.r : f20;
            } else if (i11 == 2) {
                f2 = c13;
                f10 = (legend$LegendOrientation == Legend$LegendOrientation.VERTICAL ? iVar.f19203c : iVar.f19202b.right) - f20;
                if (legend$LegendDirection2 == Legend$LegendDirection.LEFT_TO_RIGHT) {
                    f10 -= fVar.r;
                }
            } else if (i11 != 3) {
                f2 = c13;
                f10 = 0.0f;
            } else {
                Legend$LegendOrientation legend$LegendOrientation2 = Legend$LegendOrientation.VERTICAL;
                if (legend$LegendOrientation == legend$LegendOrientation2) {
                    width = iVar.f19203c / 2.0f;
                } else {
                    RectF rectF = iVar.f19202b;
                    width = (rectF.width() / 2.0f) + rectF.left;
                }
                Legend$LegendDirection legend$LegendDirection3 = Legend$LegendDirection.LEFT_TO_RIGHT;
                if (legend$LegendDirection2 == legend$LegendDirection3) {
                    f16 = width;
                    f17 = f20;
                } else {
                    f16 = width;
                    f17 = -f20;
                }
                f10 = f16 + f17;
                if (legend$LegendOrientation == legend$LegendOrientation2) {
                    f2 = c13;
                    double d10 = f10;
                    if (legend$LegendDirection2 == legend$LegendDirection3) {
                        d5 = d10;
                        d8 = ((-fVar.r) / 2.0d) + f20;
                    } else {
                        d5 = d10;
                        d8 = (fVar.r / 2.0d) - f20;
                    }
                    f10 = (float) (d5 + d8);
                } else {
                    f2 = c13;
                }
            }
            int i12 = j.f18954c[legend$LegendOrientation.ordinal()];
            if (i12 != 1) {
                if (i12 != 2) {
                    return;
                }
                int i13 = j.f18953b[legend$LegendVerticalAlignment.ordinal()];
                if (i13 == 1) {
                    f13 = (legend$LegendHorizontalAlignment2 == Legend$LegendHorizontalAlignment.CENTER ? 0.0f : iVar.f19202b.top) + f19;
                } else if (i13 != 2) {
                    f13 = i13 != 3 ? 0.0f : ((iVar.f19204d / 2.0f) - (fVar.f16425s / 2.0f)) + fVar.f16408c;
                } else {
                    f13 = (legend$LegendHorizontalAlignment2 == Legend$LegendHorizontalAlignment.CENTER ? iVar.f19204d : iVar.f19202b.bottom) - (fVar.f16425s + f19);
                }
                float f21 = f13;
                boolean z6 = false;
                int i14 = 0;
                float f22 = 0.0f;
                while (i14 < gVarArr.length) {
                    n7.g gVar2 = gVarArr[i14];
                    boolean z8 = gVar2.f16431b != Legend$LegendForm.NONE;
                    float f23 = gVar2.f16432c;
                    float c14 = Float.isNaN(f23) ? c12 : v7.h.c(f23);
                    if (z8) {
                        Legend$LegendDirection legend$LegendDirection4 = Legend$LegendDirection.LEFT_TO_RIGHT;
                        f15 = legend$LegendDirection2 == legend$LegendDirection4 ? f10 + f22 : f10 - (c14 - f22);
                        f14 = f2;
                        legend$LegendDirection = legend$LegendDirection2;
                        k(canvas, f15, f21 + a3, gVar2, this.f18958d);
                        canvas3 = canvas;
                        gVar = gVar2;
                        if (legend$LegendDirection == legend$LegendDirection4) {
                            f15 += c14;
                        }
                    } else {
                        gVar = gVar2;
                        legend$LegendDirection = legend$LegendDirection2;
                        f14 = f2;
                        canvas3 = canvas;
                        f15 = f10;
                    }
                    String str2 = gVar.f16430a;
                    if (str2 != null) {
                        if (z8 && !z6) {
                            f15 += legend$LegendDirection == Legend$LegendDirection.LEFT_TO_RIGHT ? c10 : -c10;
                        } else if (z6) {
                            f15 = f10;
                        }
                        if (legend$LegendDirection == Legend$LegendDirection.RIGHT_TO_LEFT) {
                            f15 -= (int) paint.measureText(str2);
                        }
                        if (z6) {
                            f21 += f18 + c9;
                            canvas3.drawText(str2, f15, f21 + f18, this.f18956b);
                        } else {
                            canvas3.drawText(str2, f15, f21 + f18, this.f18956b);
                        }
                        f21 = f18 + c9 + f21;
                        f22 = 0.0f;
                    } else {
                        f22 = c14 + f14 + f22;
                        z6 = true;
                    }
                    i14++;
                    legend$LegendDirection2 = legend$LegendDirection;
                    f2 = f14;
                }
                return;
            }
            float f24 = f2;
            ArrayList arrayList2 = fVar.f16429w;
            ArrayList arrayList3 = fVar.f16427u;
            ArrayList arrayList4 = fVar.f16428v;
            int i15 = j.f18953b[legend$LegendVerticalAlignment.ordinal()];
            float f25 = i15 != 1 ? i15 != 2 ? i15 != 3 ? 0.0f : ((iVar.f19204d - fVar.f16425s) / 2.0f) + f19 : (iVar.f19204d - f19) - fVar.f16425s : f19;
            int length = gVarArr.length;
            float f26 = f25;
            float f27 = f10;
            int i16 = 0;
            int i17 = 0;
            while (i17 < length) {
                n7.g gVar3 = gVarArr[i17];
                float f28 = f27;
                int i18 = length;
                boolean z10 = gVar3.f16431b != Legend$LegendForm.NONE;
                float f29 = gVar3.f16432c;
                float c15 = Float.isNaN(f29) ? c12 : v7.h.c(f29);
                if (i17 >= arrayList4.size() || !((Boolean) arrayList4.get(i17)).booleanValue()) {
                    f11 = f28;
                } else {
                    f26 = f18 + c9 + f26;
                    f11 = f10;
                }
                if (f11 == f10) {
                    i3 = i17;
                    if (legend$LegendHorizontalAlignment2 == Legend$LegendHorizontalAlignment.CENTER && i16 < arrayList2.size()) {
                        f11 += (legend$LegendDirection2 == Legend$LegendDirection.RIGHT_TO_LEFT ? ((v7.a) arrayList2.get(i16)).f19176b : -((v7.a) arrayList2.get(i16)).f19176b) / 2.0f;
                        i16++;
                    }
                } else {
                    i3 = i17;
                }
                int i19 = i16;
                String str3 = gVar3.f16430a;
                boolean z11 = str3 == null;
                if (z10) {
                    if (legend$LegendDirection2 == Legend$LegendDirection.RIGHT_TO_LEFT) {
                        f11 -= c15;
                    }
                    float f30 = f11;
                    legend$LegendHorizontalAlignment = legend$LegendHorizontalAlignment2;
                    int i20 = i3;
                    arrayList = arrayList2;
                    i10 = i20;
                    z5 = z10;
                    str = str3;
                    canvas2 = canvas;
                    k(canvas2, f30, f26 + a3, gVar3, this.f18958d);
                    f11 = legend$LegendDirection2 == Legend$LegendDirection.LEFT_TO_RIGHT ? f30 + c15 : f30;
                } else {
                    int i21 = i3;
                    arrayList = arrayList2;
                    i10 = i21;
                    legend$LegendHorizontalAlignment = legend$LegendHorizontalAlignment2;
                    z5 = z10;
                    str = str3;
                    canvas2 = canvas;
                }
                if (z11) {
                    if (legend$LegendDirection2 == Legend$LegendDirection.RIGHT_TO_LEFT) {
                        f12 = f24;
                        f24 = -f12;
                    } else {
                        f12 = f24;
                    }
                    f27 = f11 + f24;
                } else {
                    if (z5) {
                        f11 += legend$LegendDirection2 == Legend$LegendDirection.RIGHT_TO_LEFT ? -c10 : c10;
                    }
                    Legend$LegendDirection legend$LegendDirection5 = Legend$LegendDirection.RIGHT_TO_LEFT;
                    if (legend$LegendDirection2 == legend$LegendDirection5) {
                        f11 -= ((v7.a) arrayList3.get(i10)).f19176b;
                    }
                    canvas2.drawText(str, f11, f26 + f18, this.f18956b);
                    if (legend$LegendDirection2 == Legend$LegendDirection.LEFT_TO_RIGHT) {
                        f11 += ((v7.a) arrayList3.get(i10)).f19176b;
                    }
                    f27 = f11 + (legend$LegendDirection2 == legend$LegendDirection5 ? -c11 : c11);
                    f12 = f24;
                }
                f24 = f12;
                i17 = i10 + 1;
                arrayList2 = arrayList;
                length = i18;
                i16 = i19;
                legend$LegendHorizontalAlignment2 = legend$LegendHorizontalAlignment;
            }
        }
    }
}
