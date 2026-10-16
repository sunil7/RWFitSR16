package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class x implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2073a = false;

    /* renamed from: b, reason: collision with root package name */
    public Spannable f2074b;

    public x(Spannable spannable) {
        this.f2074b = spannable;
    }

    public final void a() {
        Spannable spannable = this.f2074b;
        if (!this.f2073a) {
            if ((Build.VERSION.SDK_INT < 28 ? new hc.a(2) : new w(2)).g(spannable)) {
                this.f2074b = new SpannableString(spannable);
            }
        }
        this.f2073a = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i3) {
        return this.f2074b.charAt(i3);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f2074b.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f2074b.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f2074b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f2074b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f2074b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i3, int i10, Class cls) {
        return this.f2074b.getSpans(i3, i10, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f2074b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i3, int i10, Class cls) {
        return this.f2074b.nextSpanTransition(i3, i10, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f2074b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i3, int i10, int i11) {
        a();
        this.f2074b.setSpan(obj, i3, i10, i11);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i3, int i10) {
        return this.f2074b.subSequence(i3, i10);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f2074b.toString();
    }

    public x(CharSequence charSequence) {
        this.f2074b = new SpannableString(charSequence);
    }
}
