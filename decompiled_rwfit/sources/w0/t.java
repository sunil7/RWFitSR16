package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final int f19456a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f19457b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final int f19458c;

    public t(Context context, XmlResourceParser xmlResourceParser) {
        this.f19458c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.State);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.State_android_id) {
                this.f19456a = obtainStyledAttributes.getResourceId(index, this.f19456a);
            } else if (index == R$styleable.State_constraints) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f19458c);
                this.f19458c = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                "layout".equals(resourceTypeName);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
