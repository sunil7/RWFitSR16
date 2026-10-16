package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f19340a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f19341b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final int f19342c;

    /* renamed from: d, reason: collision with root package name */
    public final o f19343d;

    public g(Context context, XmlResourceParser xmlResourceParser) {
        this.f19342c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.State);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.State_android_id) {
                this.f19340a = obtainStyledAttributes.getResourceId(index, this.f19340a);
            } else if (index == R$styleable.State_constraints) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f19342c);
                this.f19342c = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    o oVar = new o();
                    this.f19343d = oVar;
                    oVar.e((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            }
        }
        obtainStyledAttributes.recycle();
    }
}
