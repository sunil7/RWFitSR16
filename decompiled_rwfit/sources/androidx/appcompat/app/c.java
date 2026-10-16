package androidx.appcompat.app;

import android.R;
import android.content.res.TypedArray;
import android.os.Message;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.util.SparseArray;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckedTextView;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.r3;
import com.example.network.bean.MemberFriendBean;
import com.example.test.ui.testui.TRingFamilyActivity;
import com.example.test.ui.view.FamilyFriendRecyclerView;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f419a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f420b;

    public /* synthetic */ c(Object obj, int i3) {
        this.f419a = i3;
        this.f420b = obj;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        switch (this.f419a) {
            case 0:
                h hVar = (h) this.f420b;
                Message obtain = (view != hVar.f488h || (message3 = hVar.f490j) == null) ? (view != hVar.f491k || (message2 = hVar.f493m) == null) ? (view != hVar.f494n || (message = hVar.f496p) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
                if (obtain != null) {
                    obtain.sendToTarget();
                }
                hVar.D.obtainMessage(1, hVar.f483b).sendToTarget();
                return;
            case 1:
                ((g.a) this.f420b).a();
                return;
            case 2:
                r3 r3Var = ((Toolbar) this.f420b).L;
                h.m mVar = r3Var == null ? null : r3Var.f1037b;
                if (mVar != null) {
                    mVar.collapseActionView();
                    return;
                }
                return;
            case 3:
                FamilyFriendRecyclerView familyFriendRecyclerView = (FamilyFriendRecyclerView) this.f420b;
                u6.i iVar = familyFriendRecyclerView.f8425w1;
                int i3 = familyFriendRecyclerView.f8418p1;
                com.example.test.ui.testui.w wVar = (com.example.test.ui.testui.w) iVar;
                wVar.getClass();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                TRingFamilyActivity tRingFamilyActivity = wVar.f8322a;
                ?? r32 = tRingFamilyActivity.E.get(i3);
                ref$ObjectRef.element = r32;
                if (r32 instanceof MemberFriendBean) {
                    eh.b bVar = tRingFamilyActivity.I;
                    ((com.example.test.ui.dialog.r) bVar.getValue()).setOnDialogListener(new com.example.test.utils.y(ref$ObjectRef, tRingFamilyActivity, i3));
                    ((com.example.test.ui.dialog.r) bVar.getValue()).show();
                }
                familyFriendRecyclerView.f8417o1.scrollTo(0, 0);
                familyFriendRecyclerView.f8416n1 = 0;
                return;
            case 4:
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
                com.google.android.material.internal.n nVar = (com.google.android.material.internal.n) this.f420b;
                com.google.android.material.internal.f fVar = nVar.e;
                boolean z5 = true;
                if (fVar != null) {
                    fVar.f10593c = true;
                }
                h.m itemData = navigationMenuItemView.getItemData();
                boolean q5 = nVar.f10602c.q(itemData, nVar, 0);
                if (itemData != null && itemData.isCheckable() && q5) {
                    nVar.e.b(itemData);
                } else {
                    z5 = false;
                }
                com.google.android.material.internal.f fVar2 = nVar.e;
                if (fVar2 != null) {
                    fVar2.f10593c = false;
                }
                if (z5) {
                    nVar.g(false);
                    return;
                }
                return;
            case 5:
                h.m itemData2 = ((NavigationBarItemView) view).getItemData();
                NavigationBarMenuView navigationBarMenuView = (NavigationBarMenuView) this.f420b;
                if (navigationBarMenuView.f10679s.q(itemData2, navigationBarMenuView.r, 0)) {
                    return;
                }
                itemData2.setChecked(true);
                return;
            case 6:
                com.google.android.material.textfield.e eVar = (com.google.android.material.textfield.e) this.f420b;
                Editable text = eVar.f10921a.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
                TextInputLayout textInputLayout = eVar.f10921a;
                textInputLayout.k(textInputLayout.f10849h0, textInputLayout.f10854j0);
                return;
            case 7:
                com.google.android.material.textfield.l lVar = (com.google.android.material.textfield.l) this.f420b;
                com.google.android.material.textfield.l.d(lVar, (AutoCompleteTextView) lVar.f10921a.getEditText());
                return;
            case 8:
                com.google.android.material.textfield.p pVar = (com.google.android.material.textfield.p) this.f420b;
                EditText editText = pVar.f10921a.getEditText();
                if (editText == null) {
                    return;
                }
                int selectionEnd = editText.getSelectionEnd();
                if (com.google.android.material.textfield.p.d(pVar)) {
                    editText.setTransformationMethod(null);
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                TextInputLayout textInputLayout2 = pVar.f10921a;
                textInputLayout2.k(textInputLayout2.f10849h0, textInputLayout2.f10854j0);
                return;
            case 9:
                TrackSelectionView trackSelectionView = (TrackSelectionView) this.f420b;
                SparseArray sparseArray = trackSelectionView.f9050c;
                boolean z6 = false;
                CheckedTextView checkedTextView = trackSelectionView.f9049b;
                CheckedTextView checkedTextView2 = trackSelectionView.f9048a;
                if (view == checkedTextView2) {
                    trackSelectionView.f9052f = true;
                    sparseArray.clear();
                } else {
                    if (view != checkedTextView) {
                        trackSelectionView.f9052f = false;
                        view.getTag().getClass();
                        throw new ClassCastException();
                    }
                    trackSelectionView.f9052f = false;
                    sparseArray.clear();
                }
                checkedTextView2.setChecked(trackSelectionView.f9052f);
                if (!trackSelectionView.f9052f && sparseArray.size() == 0) {
                    z6 = true;
                }
                checkedTextView.setChecked(z6);
                throw null;
            case 10:
                com.example.test.ui.dialog.c cVar = (com.example.test.ui.dialog.c) this.f420b;
                if (cVar.f7932i && cVar.isShowing()) {
                    if (!cVar.f7934k) {
                        TypedArray obtainStyledAttributes = cVar.getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
                        cVar.f7933j = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                        cVar.f7934k = true;
                    }
                    if (cVar.f7933j) {
                        cVar.cancel();
                        return;
                    }
                    return;
                }
                return;
            default:
                s3.c cVar2 = (s3.c) this.f420b;
                if (cVar2.c()) {
                    cVar2.a();
                    return;
                }
                return;
        }
    }
}
