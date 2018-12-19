package com.cycleimage;

/**
 * Created by 林亮 on 2018/12/5
 */

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

import com.cycleimage.lib.DrawCornerImage;
import com.squareup.picasso.Transformation;


public class RoundCornersTransformation implements Transformation {

    private float mRadius;

    private DrawCornerImage mDrawCornerImage;

    private Paint mPaint;


    public RoundCornersTransformation(float radius, DrawCornerImage drawCornerImage) {
        mRadius = radius;
        mDrawCornerImage = drawCornerImage;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    public Bitmap transform(Bitmap source) {
        int width = source.getWidth();
        int height = source.getHeight();
        Bitmap newSource = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newSource);
        mPaint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        source.recycle();
        mDrawCornerImage.drawCornerImage(canvas, mPaint, mRadius, width, height);
        return newSource;
    }

    @Override
    public String key() {
        return RoundCornersTransformation.class.toString();
    }
}