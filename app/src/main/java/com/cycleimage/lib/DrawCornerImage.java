package com.cycleimage.lib;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface DrawCornerImage {
    void drawCornerImage(Canvas canvas, Paint paint,float radius, int right, int bottom);
}