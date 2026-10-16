package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final e f506a;

    /* renamed from: b, reason: collision with root package name */
    public final int f507b;

    public i(Context context) {
        this(context, j.f(context, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    public j create() {
        e eVar = this.f506a;
        j jVar = new j(eVar.f451a, this.f507b);
        View view = eVar.e;
        h hVar = jVar.e;
        if (view != null) {
            hVar.f501v = view;
        } else {
            CharSequence charSequence = eVar.f454d;
            if (charSequence != null) {
                hVar.f485d = charSequence;
                TextView textView = hVar.f499t;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = eVar.f453c;
            if (drawable != null) {
                hVar.r = drawable;
                ImageView imageView = hVar.f498s;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    hVar.f498s.setImageDrawable(drawable);
                }
            }
        }
        CharSequence charSequence2 = eVar.f455f;
        if (charSequence2 != null) {
            hVar.c(-1, charSequence2, eVar.f456g);
        }
        CharSequence charSequence3 = eVar.f457h;
        if (charSequence3 != null) {
            hVar.c(-2, charSequence3, eVar.f458i);
        }
        if (eVar.f460k != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) eVar.f452b.inflate(hVar.f505z, (ViewGroup) null);
            int i3 = eVar.f463n ? hVar.A : hVar.B;
            Object obj = eVar.f460k;
            ?? r8 = obj;
            if (obj == null) {
                r8 = new g(eVar.f451a, i3, R.id.text1, null);
            }
            hVar.f502w = r8;
            hVar.f503x = eVar.f464o;
            if (eVar.f461l != null) {
                alertController$RecycleListView.setOnItemClickListener(new d(0, eVar, hVar));
            }
            if (eVar.f463n) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            hVar.e = alertController$RecycleListView;
        }
        View view2 = eVar.f462m;
        if (view2 != null) {
            hVar.f486f = view2;
            hVar.f487g = false;
        }
        jVar.setCancelable(true);
        jVar.setCanceledOnTouchOutside(true);
        jVar.setOnCancelListener(null);
        jVar.setOnDismissListener(null);
        h.l lVar = eVar.f459j;
        if (lVar != null) {
            jVar.setOnKeyListener(lVar);
        }
        return jVar;
    }

    public Context getContext() {
        return this.f506a.f451a;
    }

    public i setNegativeButton(int i3, DialogInterface.OnClickListener onClickListener) {
        e eVar = this.f506a;
        eVar.f457h = eVar.f451a.getText(i3);
        eVar.f458i = onClickListener;
        return this;
    }

    public i setPositiveButton(int i3, DialogInterface.OnClickListener onClickListener) {
        e eVar = this.f506a;
        eVar.f455f = eVar.f451a.getText(i3);
        eVar.f456g = onClickListener;
        return this;
    }

    public i setTitle(CharSequence charSequence) {
        this.f506a.f454d = charSequence;
        return this;
    }

    public i setView(View view) {
        this.f506a.f462m = view;
        return this;
    }

    public i(Context context, int i3) {
        this.f506a = new e(new ContextThemeWrapper(context, j.f(context, i3)));
        this.f507b = i3;
    }
}
