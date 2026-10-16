package z3;

/* loaded from: classes.dex */
public final class o implements Appendable {

    /* renamed from: a, reason: collision with root package name */
    public final Appendable f20283a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f20284b = true;

    public o(Appendable appendable) {
        this.f20283a = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c9) {
        boolean z5 = this.f20284b;
        Appendable appendable = this.f20283a;
        if (z5) {
            this.f20284b = false;
            appendable.append("  ");
        }
        this.f20284b = c9 == '\n';
        appendable.append(c9);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i3, int i10) {
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z5 = this.f20284b;
        Appendable appendable = this.f20283a;
        boolean z6 = false;
        if (z5) {
            this.f20284b = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i10 - 1) == '\n') {
            z6 = true;
        }
        this.f20284b = z6;
        appendable.append(charSequence, i3, i10);
        return this;
    }
}
