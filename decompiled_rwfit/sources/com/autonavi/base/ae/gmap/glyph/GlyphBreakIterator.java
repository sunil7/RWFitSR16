package com.autonavi.base.ae.gmap.glyph;

import java.text.BreakIterator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GlyphBreakIterator {
    public static final int BREAK_BY_CHARACTER_SEQUENCES = 2;
    public static final int BREAK_BY_WORDS = 1;
    public ArrayList<Integer> breakResult = new ArrayList<>();
    public int mBreakMode;

    public GlyphBreakIterator(int i3) {
        this.mBreakMode = i3;
    }

    public int[] setText(String str) {
        BreakIterator breakIterator = null;
        if (str.isEmpty()) {
            return null;
        }
        if (!this.breakResult.isEmpty()) {
            this.breakResult.clear();
        }
        int i3 = this.mBreakMode;
        if (i3 == 1) {
            breakIterator = BreakIterator.getWordInstance();
        } else if (i3 == 2) {
            breakIterator = BreakIterator.getCharacterInstance();
        }
        breakIterator.setText(str);
        int first = breakIterator.first();
        int next = breakIterator.next();
        while (true) {
            int i10 = next;
            int i11 = first;
            first = i10;
            if (first == -1) {
                break;
            }
            this.breakResult.add(Integer.valueOf(i11));
            next = breakIterator.next();
        }
        this.breakResult.add(Integer.valueOf(str.length()));
        int size = this.breakResult.size();
        Integer[] numArr = new Integer[size];
        this.breakResult.toArray(numArr);
        int[] iArr = new int[size];
        for (int i12 = 0; i12 < size; i12++) {
            iArr[i12] = numArr[i12].intValue();
        }
        return iArr;
    }
}
