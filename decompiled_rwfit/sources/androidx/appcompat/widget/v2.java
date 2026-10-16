package androidx.appcompat.widget;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.widget.SearchView;
import com.google.android.material.navigation.NavigationBarItemView;

/* loaded from: classes.dex */
public final class v2 implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1067a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1068b;

    public /* synthetic */ v2(Object obj, int i3) {
        this.f1067a = i3;
        this.f1068b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        switch (this.f1067a) {
            case 0:
                SearchView searchView = (SearchView) this.f1068b;
                View view2 = searchView.f805x;
                if (view2.getWidth() > 1) {
                    Resources resources = searchView.getContext().getResources();
                    int paddingLeft = searchView.r.getPaddingLeft();
                    Rect rect = new Rect();
                    boolean a3 = b4.a(searchView);
                    int dimensionPixelSize = searchView.M ? resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_icon_width) : 0;
                    SearchView.SearchAutoComplete searchAutoComplete = searchView.f798p;
                    searchAutoComplete.getDropDownBackground().getPadding(rect);
                    searchAutoComplete.setDropDownHorizontalOffset(a3 ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
                    searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
                    break;
                }
                break;
            case 1:
                NavigationBarItemView navigationBarItemView = (NavigationBarItemView) this.f1068b;
                if (navigationBarItemView.f10651g.getVisibility() == 0) {
                    ImageView imageView = navigationBarItemView.f10651g;
                    la.a aVar = navigationBarItemView.f10660p;
                    if (aVar != null) {
                        Rect rect2 = new Rect();
                        imageView.getDrawingRect(rect2);
                        aVar.setBounds(rect2);
                        aVar.h(imageView, null);
                        break;
                    }
                }
                break;
            default:
                jb.a aVar2 = (jb.a) this.f1068b;
                aVar2.getClass();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                aVar2.I = iArr[0];
                view.getWindowVisibleDisplayFrame(aVar2.C);
                break;
        }
    }
}
