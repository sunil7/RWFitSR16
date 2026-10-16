package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class t extends SpannableStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2068a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2069b;

    public t(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f2069b = new ArrayList();
        pd.e(cls, "watcherClass cannot be null");
        this.f2068a = cls;
    }

    public final void a() {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f2069b;
            if (i3 >= arrayList.size()) {
                return;
            }
            ((s) arrayList.get(i3)).f2067b.incrementAndGet();
            i3++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f2069b;
            if (i3 >= arrayList.size()) {
                return;
            }
            ((s) arrayList.get(i3)).onTextChanged(this, 0, length(), length());
            i3++;
        }
    }

    public final s c(Object obj) {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f2069b;
            if (i3 >= arrayList.size()) {
                return null;
            }
            s sVar = (s) arrayList.get(i3);
            if (sVar.f2066a == obj) {
                return sVar;
            }
            i3++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            return this.f2068a == obj.getClass();
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i3, int i10) {
        super.delete(i3, i10);
        return this;
    }

    public final void e() {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f2069b;
            if (i3 >= arrayList.size()) {
                return;
            }
            ((s) arrayList.get(i3)).f2067b.decrementAndGet();
            i3++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        s c9;
        if (d(obj) && (c9 = c(obj)) != null) {
            obj = c9;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        s c9;
        if (d(obj) && (c9 = c(obj)) != null) {
            obj = c9;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        s c9;
        if (d(obj) && (c9 = c(obj)) != null) {
            obj = c9;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i3, int i10, Class cls) {
        if (this.f2068a != cls) {
            return super.getSpans(i3, i10, cls);
        }
        s[] sVarArr = (s[]) super.getSpans(i3, i10, s.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, sVarArr.length);
        for (int i11 = 0; i11 < sVarArr.length; i11++) {
            objArr[i11] = sVarArr[i11].f2066a;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i3, CharSequence charSequence) {
        super.insert(i3, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i3, int i10, Class cls) {
        if (cls == null || this.f2068a == cls) {
            cls = s.class;
        }
        return super.nextSpanTransition(i3, i10, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        s sVar;
        if (d(obj)) {
            sVar = c(obj);
            if (sVar != null) {
                obj = sVar;
            }
        } else {
            sVar = null;
        }
        super.removeSpan(obj);
        if (sVar != null) {
            this.f2069b.remove(sVar);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i3, int i10, CharSequence charSequence) {
        replace(i3, i10, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i3, int i10, int i11) {
        if (d(obj)) {
            s sVar = new s(obj);
            this.f2069b.add(sVar);
            obj = sVar;
        }
        super.setSpan(obj, i3, i10, i11);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i3, int i10) {
        return new t(this.f2068a, this, i3, i10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i3, int i10) {
        super.delete(i3, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i3, CharSequence charSequence) {
        super.insert(i3, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i3, int i10, CharSequence charSequence, int i11, int i12) {
        replace(i3, i10, charSequence, i11, i12);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i3, CharSequence charSequence, int i10, int i11) {
        super.insert(i3, charSequence, i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i3, int i10, CharSequence charSequence) {
        a();
        super.replace(i3, i10, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i3, CharSequence charSequence, int i10, int i11) {
        super.insert(i3, charSequence, i10, i11);
        return this;
    }

    public t(Class cls, t tVar, int i3, int i10) {
        super(tVar, i3, i10);
        this.f2069b = new ArrayList();
        pd.e(cls, "watcherClass cannot be null");
        this.f2068a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i3, int i10, CharSequence charSequence, int i11, int i12) {
        a();
        super.replace(i3, i10, charSequence, i11, i12);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i3, int i10) {
        super.append(charSequence, i3, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i3, int i10) {
        super.append(charSequence, i3, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i3, int i10) {
        super.append(charSequence, i3, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i3) {
        super.append(charSequence, obj, i3);
        return this;
    }
}
