package g9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.hc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends View implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13908a;

    /* renamed from: b, reason: collision with root package name */
    public List f13909b;

    /* renamed from: c, reason: collision with root package name */
    public float f13910c;

    /* renamed from: d, reason: collision with root package name */
    public d f13911d;
    public float e;

    public c(Context context) {
        super(context, null);
        this.f13908a = new ArrayList();
        this.f13909b = Collections.EMPTY_LIST;
        this.f13910c = 0.0533f;
        this.f13911d = d.f13914g;
        this.e = 0.08f;
    }

    @Override // g9.h0
    public final void a(List list, d dVar, float f2, float f10) {
        this.f13909b = list;
        this.f13911d = dVar;
        this.f13910c = f2;
        this.e = f10;
        while (true) {
            ArrayList arrayList = this.f13908a;
            if (arrayList.size() >= list.size()) {
                invalidate();
                return;
            }
            arrayList.add(new g0(getContext()));
        }
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
        List list;
        int i3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z5;
        int i18;
        boolean z6;
        c cVar = this;
        List list2 = cVar.f13909b;
        if (list2.isEmpty()) {
            return;
        }
        int height = cVar.getHeight();
        int paddingLeft = cVar.getPaddingLeft();
        int paddingTop = cVar.getPaddingTop();
        int width = cVar.getWidth() - cVar.getPaddingRight();
        int paddingBottom = height - cVar.getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i19 = paddingBottom - paddingTop;
        float b3 = hc.b(0, cVar.f13910c, height, i19);
        float f2 = 0.0f;
        if (b3 <= 0.0f) {
            return;
        }
        int size = list2.size();
        int i20 = 0;
        while (i20 < size) {
            d9.a aVar = (d9.a) list2.get(i20);
            aVar.getClass();
            float f10 = f2;
            a4.a a3 = aVar.a();
            a3.getClass();
            a3.a().getClass();
            float b10 = hc.b(0, 0.0f, height, i19);
            g0 g0Var = (g0) cVar.f13908a.get(i20);
            d dVar = cVar.f13911d;
            float f11 = cVar.e;
            g0Var.getClass();
            if (TextUtils.isEmpty(null)) {
                list = list2;
                i3 = height;
                i11 = paddingLeft;
                i12 = paddingTop;
                i13 = width;
                i14 = paddingBottom;
                i10 = i19;
            } else {
                int i21 = dVar.f13917c;
                list = list2;
                CharSequence charSequence = g0Var.f13958i;
                i3 = height;
                TextPaint textPaint = g0Var.f13955f;
                i10 = i19;
                if ((charSequence == null || (charSequence != null && charSequence.equals(null))) && i9.g.a(g0Var.f13959j, null) && g0Var.f13960k == null && g0Var.f13961l == 0.0f && g0Var.f13962m == 0 && Integer.valueOf(g0Var.f13963n).equals(0) && g0Var.f13964o == 0.0f && Integer.valueOf(g0Var.f13965p).equals(0) && g0Var.f13966q == 0.0f && g0Var.r == 0.0f && g0Var.f13967s == dVar.f13915a && g0Var.f13968t == dVar.f13916b && g0Var.f13969u == i21 && g0Var.f13971w == dVar.f13918d && g0Var.f13970v == dVar.e && i9.g.a(textPaint.getTypeface(), dVar.f13919f) && g0Var.f13972x == b3 && g0Var.f13973y == b10 && g0Var.f13974z == f11 && g0Var.A == paddingLeft && g0Var.B == paddingTop && g0Var.C == width && g0Var.D == paddingBottom) {
                    g0Var.a(canvas, true);
                    i11 = paddingLeft;
                    i12 = paddingTop;
                    i13 = width;
                    i14 = paddingBottom;
                } else {
                    g0Var.f13958i = null;
                    g0Var.f13959j = null;
                    g0Var.f13960k = null;
                    g0Var.f13961l = 0.0f;
                    g0Var.f13962m = 0;
                    g0Var.f13963n = 0;
                    g0Var.f13964o = 0.0f;
                    g0Var.f13965p = 0;
                    g0Var.f13966q = 0.0f;
                    g0Var.r = 0.0f;
                    g0Var.f13967s = dVar.f13915a;
                    g0Var.f13968t = dVar.f13916b;
                    g0Var.f13969u = i21;
                    g0Var.f13971w = dVar.f13918d;
                    g0Var.f13970v = dVar.e;
                    textPaint.setTypeface(dVar.f13919f);
                    g0Var.f13972x = b3;
                    g0Var.f13973y = b10;
                    g0Var.f13974z = f11;
                    g0Var.A = paddingLeft;
                    g0Var.B = paddingTop;
                    g0Var.C = width;
                    g0Var.D = paddingBottom;
                    g0Var.f13958i.getClass();
                    CharSequence charSequence2 = g0Var.f13958i;
                    SpannableStringBuilder spannableStringBuilder = charSequence2 instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence2 : new SpannableStringBuilder(g0Var.f13958i);
                    int i22 = g0Var.C - g0Var.A;
                    int i23 = g0Var.D - g0Var.B;
                    textPaint.setTextSize(g0Var.f13972x);
                    int i24 = (int) ((g0Var.f13972x * 0.125f) + 0.5f);
                    int i25 = i24 * 2;
                    int i26 = i22 - i25;
                    float f12 = g0Var.f13966q;
                    if (f12 != -3.4028235E38f) {
                        i26 = (int) (i26 * f12);
                    }
                    int i27 = i26;
                    if (i27 <= 0) {
                        Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
                        i11 = paddingLeft;
                        i12 = paddingTop;
                        i13 = width;
                        i14 = paddingBottom;
                    } else {
                        i11 = paddingLeft;
                        if (g0Var.f13973y > f10) {
                            i12 = paddingTop;
                            i13 = width;
                            i15 = 0;
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) g0Var.f13973y), 0, spannableStringBuilder.length(), 16711680);
                        } else {
                            i12 = paddingTop;
                            i13 = width;
                            i15 = 0;
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                        if (g0Var.f13971w == 1) {
                            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(i15, spannableStringBuilder2.length(), ForegroundColorSpan.class);
                            int i28 = 0;
                            for (int length = foregroundColorSpanArr.length; i28 < length; length = length) {
                                spannableStringBuilder2.removeSpan(foregroundColorSpanArr[i28]);
                                i28++;
                            }
                        }
                        if (Color.alpha(g0Var.f13968t) > 0) {
                            int i29 = g0Var.f13971w;
                            if (i29 == 0 || i29 == 2) {
                                i14 = paddingBottom;
                                spannableStringBuilder.setSpan(new BackgroundColorSpan(g0Var.f13968t), 0, spannableStringBuilder.length(), 16711680);
                            } else {
                                i14 = paddingBottom;
                                spannableStringBuilder2.setSpan(new BackgroundColorSpan(g0Var.f13968t), 0, spannableStringBuilder2.length(), 16711680);
                            }
                        } else {
                            i14 = paddingBottom;
                        }
                        Layout.Alignment alignment = g0Var.f13959j;
                        if (alignment == null) {
                            alignment = Layout.Alignment.ALIGN_CENTER;
                        }
                        Layout.Alignment alignment2 = alignment;
                        SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
                        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder3, textPaint, i27, alignment2, g0Var.f13954d, g0Var.e, true);
                        g0Var.E = staticLayout;
                        int height2 = staticLayout.getHeight();
                        int lineCount = g0Var.E.getLineCount();
                        int i30 = 0;
                        int i31 = 0;
                        while (i30 < lineCount) {
                            i31 = Math.max((int) Math.ceil(g0Var.E.getLineWidth(i30)), i31);
                            i30++;
                            height2 = height2;
                            lineCount = lineCount;
                            spannableStringBuilder2 = spannableStringBuilder2;
                        }
                        int i32 = height2;
                        SpannableStringBuilder spannableStringBuilder4 = spannableStringBuilder2;
                        int i33 = ((g0Var.f13966q == -3.4028235E38f || i31 >= i27) ? i31 : i27) + i25;
                        float f13 = g0Var.f13964o;
                        if (f13 != -3.4028235E38f) {
                            int round = Math.round(i22 * f13);
                            int i34 = g0Var.A;
                            int i35 = round + i34;
                            int i36 = g0Var.f13965p;
                            if (i36 == 1) {
                                i35 = ((i35 * 2) - i33) / 2;
                            } else if (i36 == 2) {
                                i35 -= i33;
                            }
                            i16 = Math.max(i35, i34);
                            i17 = Math.min(i16 + i33, g0Var.C);
                        } else {
                            i16 = g0Var.A + ((i22 - i33) / 2);
                            i17 = i16 + i33;
                        }
                        int i37 = i17 - i16;
                        if (i37 <= 0) {
                            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
                        } else {
                            float f14 = g0Var.f13961l;
                            if (f14 != -3.4028235E38f) {
                                if (g0Var.f13962m == 0) {
                                    i18 = Math.round(i23 * f14) + g0Var.B;
                                    int i38 = g0Var.f13963n;
                                    if (i38 == 2) {
                                        i18 -= i32;
                                    } else if (i38 == 1) {
                                        i18 = ((i18 * 2) - i32) / 2;
                                    }
                                    z5 = false;
                                } else {
                                    z5 = false;
                                    int lineBottom = g0Var.E.getLineBottom(0) - g0Var.E.getLineTop(0);
                                    float f15 = g0Var.f13961l;
                                    i18 = f15 >= f10 ? Math.round(f15 * lineBottom) + g0Var.B : (Math.round((f15 + 1.0f) * lineBottom) + g0Var.D) - i32;
                                }
                                int i39 = i18 + i32;
                                int i40 = g0Var.D;
                                if (i39 > i40) {
                                    i18 = i40 - i32;
                                } else {
                                    int i41 = g0Var.B;
                                    if (i18 < i41) {
                                        i18 = i41;
                                    }
                                }
                            } else {
                                z5 = false;
                                i18 = (g0Var.D - i32) - ((int) (i23 * g0Var.f13974z));
                            }
                            g0Var.E = new StaticLayout(spannableStringBuilder3, textPaint, i37, alignment2, g0Var.f13954d, g0Var.e, true);
                            g0Var.F = new StaticLayout(spannableStringBuilder4, textPaint, i37, alignment2, g0Var.f13954d, g0Var.e, true);
                            g0Var.G = i16;
                            g0Var.H = i18;
                            g0Var.I = i24;
                            z6 = true;
                            g0Var.a(canvas, z6);
                            i20++;
                            cVar = this;
                            f2 = f10;
                            paddingLeft = i11;
                            paddingBottom = i14;
                            list2 = list;
                            height = i3;
                            i19 = i10;
                            paddingTop = i12;
                            width = i13;
                        }
                    }
                    z6 = true;
                    z5 = false;
                    g0Var.a(canvas, z6);
                    i20++;
                    cVar = this;
                    f2 = f10;
                    paddingLeft = i11;
                    paddingBottom = i14;
                    list2 = list;
                    height = i3;
                    i19 = i10;
                    paddingTop = i12;
                    width = i13;
                }
            }
            z5 = false;
            i20++;
            cVar = this;
            f2 = f10;
            paddingLeft = i11;
            paddingBottom = i14;
            list2 = list;
            height = i3;
            i19 = i10;
            paddingTop = i12;
            width = i13;
        }
    }
}
