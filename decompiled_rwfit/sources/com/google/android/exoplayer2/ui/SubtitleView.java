package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.hc;
import d9.a;
import e9.b;
import g9.c;
import g9.d;
import g9.h0;
import g9.n0;
import i9.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class SubtitleView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public List f9040a;

    /* renamed from: b, reason: collision with root package name */
    public d f9041b;

    /* renamed from: c, reason: collision with root package name */
    public float f9042c;

    /* renamed from: d, reason: collision with root package name */
    public float f9043d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9044f;

    /* renamed from: g, reason: collision with root package name */
    public int f9045g;

    /* renamed from: h, reason: collision with root package name */
    public h0 f9046h;

    /* renamed from: i, reason: collision with root package name */
    public View f9047i;

    public SubtitleView(Context context) {
        this(context, null);
    }

    private List<a> getCuesWithStylingPreferencesApplied() {
        if (this.e && this.f9044f) {
            return this.f9040a;
        }
        ArrayList arrayList = new ArrayList(this.f9040a.size());
        for (int i3 = 0; i3 < this.f9040a.size(); i3++) {
            a4.a a3 = ((a) this.f9040a.get(i3)).a();
            if (!this.e) {
                a3.getClass();
                CharSequence charSequence = (CharSequence) a3.f78a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        a3.f78a = SpannableString.valueOf(charSequence);
                    }
                    CharSequence charSequence2 = (CharSequence) a3.f78a;
                    charSequence2.getClass();
                    Spannable spannable = (Spannable) charSequence2;
                    for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                        if (!(obj instanceof b)) {
                            spannable.removeSpan(obj);
                        }
                    }
                }
                hc.a(a3);
            } else if (!this.f9044f) {
                hc.a(a3);
            }
            arrayList.add(a3.a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (g.f14378a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private d getUserCaptionStyle() {
        CaptioningManager captioningManager;
        int i3 = g.f14378a;
        d dVar = d.f13914g;
        if (i3 < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return dVar;
        }
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        if (i3 >= 21) {
            return new d(userStyle.hasForegroundColor() ? userStyle.foregroundColor : -1, userStyle.hasBackgroundColor() ? userStyle.backgroundColor : -16777216, userStyle.hasWindowColor() ? userStyle.windowColor : 0, userStyle.hasEdgeType() ? userStyle.edgeType : 0, userStyle.hasEdgeColor() ? userStyle.edgeColor : -1, userStyle.getTypeface());
        }
        return new d(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
    }

    private <T extends View & h0> void setView(T t8) {
        removeView(this.f9047i);
        View view = this.f9047i;
        if (view instanceof n0) {
            ((n0) view).f13988b.destroy();
        }
        this.f9047i = t8;
        this.f9046h = t8;
        addView(t8);
    }

    public final void a() {
        setStyle(getUserCaptionStyle());
    }

    public final void b() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void c() {
        this.f9046h.a(getCuesWithStylingPreferencesApplied(), this.f9041b, this.f9042c, this.f9043d);
    }

    public void setApplyEmbeddedFontSizes(boolean z5) {
        this.f9044f = z5;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z5) {
        this.e = z5;
        c();
    }

    public void setBottomPaddingFraction(float f2) {
        this.f9043d = f2;
        c();
    }

    public void setCues(List<a> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.f9040a = list;
        c();
    }

    public void setFractionalTextSize(float f2) {
        this.f9042c = f2;
        c();
    }

    public void setStyle(d dVar) {
        this.f9041b = dVar;
        c();
    }

    public void setViewType(int i3) {
        if (this.f9045g == i3) {
            return;
        }
        if (i3 == 1) {
            setView(new c(getContext()));
        } else {
            if (i3 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new n0(getContext()));
        }
        this.f9045g = i3;
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9040a = Collections.EMPTY_LIST;
        this.f9041b = d.f13914g;
        this.f9042c = 0.0533f;
        this.f9043d = 0.08f;
        this.e = true;
        this.f9044f = true;
        c cVar = new c(context);
        this.f9046h = cVar;
        this.f9047i = cVar;
        addView(cVar);
        this.f9045g = 1;
    }
}
