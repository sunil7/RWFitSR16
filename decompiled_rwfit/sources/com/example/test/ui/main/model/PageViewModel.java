package com.example.test.ui.main.model;

import a2.d;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.m0;
import androidx.lifecycle.y;
import n.x0;

/* loaded from: classes.dex */
public final class PageViewModel extends m0 {
    private final b0 _index;
    private final y text;

    public PageViewModel() {
        b0 b0Var = new b0();
        this._index = b0Var;
        x0 x0Var = new x0(3);
        a0 a0Var = new a0();
        a0Var.l(b0Var, new d(a0Var, x0Var));
        this.text = a0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String text$lambda$0(Integer num) {
        return "Hello world from section: " + num;
    }

    public final y getText() {
        return this.text;
    }

    public final void setIndex(int i3) {
        this._index.k(Integer.valueOf(i3));
    }
}
