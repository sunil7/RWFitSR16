package androidx.appcompat.widget;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$id;

/* loaded from: classes.dex */
public final class h3 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f924a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f925b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f926c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f927d;
    public final ImageView e;

    public h3(View view) {
        this.f924a = (TextView) view.findViewById(R.id.text1);
        this.f925b = (TextView) view.findViewById(R.id.text2);
        this.f926c = (ImageView) view.findViewById(R.id.icon1);
        this.f927d = (ImageView) view.findViewById(R.id.icon2);
        this.e = (ImageView) view.findViewById(R$id.edit_query);
    }
}
