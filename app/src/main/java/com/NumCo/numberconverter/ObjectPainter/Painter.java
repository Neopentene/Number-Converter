package com.NumCo.numberconverter.ObjectPainter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;

public class Painter {
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    private final int defaultColor = Color.TRANSPARENT;
    private final int defaultTextSize = 0;
    private final int defaultStrokeWidth = 0;
    private final Paint.Style defaultStyle = Paint.Style.FILL;
    private float bitmapCenterX, bitmapCenterY;
    private final Typeface defaultTypeface = Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL);
    public final Paint.Align CENTER = Paint.Align.CENTER;
    public final Paint.Align DEFAULT = Paint.Align.LEFT;
    public final Paint.Align RIGHT = Paint.Align.RIGHT;
    public final Paint.Align LEFT = Paint.Align.LEFT;

    /**
     * Create a Painter object that takes a bitmap as it's parameter. Use this class to draw bitmaps using the various
     * methods and functions provided.
     *
     * @param width  Width of the bitmap
     * @param height Height of the bitmap
     * @param config Color configuration of the bitmap
     */

    public Painter(int width, int height, Bitmap.Config config) {
        this(Bitmap.createBitmap(width, height, config));
    }

    /**
     * Create a Painter object that takes a bitmap as it's parameter. Use this class to draw bitmaps using the various
     * methods and functions provided.
     *
     * @param bitmap A bitmap object
     */
    public Painter(Bitmap bitmap) {
        this.bitmap = bitmap;
        canvas = new Canvas(bitmap);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmapCenterX = (float) Math.ceil((double) bitmap.getWidth() / 2);
        bitmapCenterY = (float) Math.ceil((double) bitmap.getHeight() / 2);
    }

    /**
     * draw a circle at center of the bitmap with the specified radius
     *
     * @param radius Radius of the circle
     * @param color  Color used to draw the circle
     * @return object
     */

    public Painter drawCircle(int radius, int color) {
        setColor(color);
        canvas.drawCircle(bitmapCenterX, bitmapCenterY, radius, paint);
        resetColor();
        return this;
    }

    public Painter drawBorderedCircle(int radius, int thickness, int color) {
        setPaintParameters(color, Paint.Style.STROKE, thickness, defaultTypeface, defaultTextSize);
        canvas.drawCircle(bitmapCenterX, bitmapCenterY, Math.abs((int) Math.ceil((double) radius - ((float) thickness) / 2)), paint);
        resetPaintParameters();
        return this;
    }

    public Painter drawCircle(float cx, float cy, int radius, int color) {
        setColor(color);
        canvas.drawCircle(cx, cy, radius, paint);
        resetColor();
        return this;
    }

    public Painter drawBorderedCircle(float cx, float cy, int radius, int thickness, int color) {
        setPaintParameters(color, Paint.Style.STROKE, thickness, defaultTypeface, defaultTextSize);
        canvas.drawCircle(cx, cy, Math.abs((int) Math.ceil((double) radius - ((float) thickness) / 2)), paint);
        resetPaintParameters();
        return this;
    }

    public Painter drawRectangle(float left, float top, float right, float bottom, int color) {
        setColor(color);
        canvas.drawRect(left, top, right, bottom, paint);
        resetColor();
        return this;
    }

    public Painter drawBorderedRectangle(float left, float top, float right, float bottom, int thickness, int color) {
        setPaintParameters(color, Paint.Style.STROKE, thickness, defaultTypeface, defaultTextSize);
        float thinness = (float) thickness / 2;
        canvas.drawRect(left + thinness, top + thinness, Math.abs(right - thinness), Math.abs(bottom - thinness), paint);
        resetPaintParameters();
        return this;
    }

    public Painter drawRoundedRectangle(float left, float top, float right, float bottom, float rx, float ry, int color) {
        setColor(color);
        canvas.drawRoundRect(new RectF(left, top, right, bottom), rx, ry, paint);
        resetColor();
        return this;
    }

    public Painter drawBorderedRoundedRectangle(float left, float top, float right, float bottom, float rx, float ry, int thickness, int color) {
        setPaintParameters(color, Paint.Style.STROKE, thickness, defaultTypeface, defaultTextSize);
        float thinness = (float) thickness / 2;
        canvas.drawRoundRect(new RectF(left + thinness, top + thinness, Math.abs(right - thinness), Math.abs(bottom - thinness)), rx, ry, paint);
        resetPaintParameters();
        return this;
    }

    public Painter drawText(String text, float x, float y, Typeface typeface, Paint.Align alignment, int textSize, int color) {
        setPaintParameters(color, defaultStyle, defaultStrokeWidth, typeface, textSize);
        paint.setTextAlign(alignment);
        canvas.drawText(text, x, y, paint);
        resetPaintParameters();
        paint.setTextAlign(DEFAULT);
        return this;
    }

    public Painter drawText(String text, float x, float y, Typeface typeface, int textSize, int color) {
        setPaintParameters(color, defaultStyle, defaultStrokeWidth, typeface, textSize);
        canvas.drawText(text, x, y, paint);
        resetPaintParameters();
        return this;
    }

    public Painter drawText(String text, float x, float y, int textSize, int color) {
        setPaintParameters(color, defaultStyle, defaultStrokeWidth, defaultTypeface, textSize);
        canvas.drawText(text, x, y, paint);
        resetPaintParameters();
        return this;
    }

    public Painter drawTextAtCenter(String text, Typeface typeface, int textSize, int color) {
        setPaintParameters(color, defaultStyle, defaultStrokeWidth, typeface, textSize);
        paint.setTextAlign(CENTER);
        float y = bitmapCenterY - (float) (textSize / 4);
        canvas.drawText(text, bitmapCenterX, y, paint);
        paint.setTextAlign(DEFAULT);
        resetPaintParameters();
        return this;
    }

    public Painter drawTextAtCenter(String text, int textSize, int color) {
        setPaintParameters(color, defaultStyle, defaultStrokeWidth, defaultTypeface, textSize);
        paint.setTextAlign(CENTER);
        float y = bitmapCenterY - (float) (textSize / 4);
        canvas.drawText(text, bitmapCenterX, y, paint);
        paint.setTextAlign(DEFAULT);
        resetPaintParameters();
        return this;
    }

    public Painter drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, int color) {
        setColor(color);
        canvas.drawArc(new RectF(left, top, right, bottom), startAngle, sweepAngle, useCenter, paint);
        resetColor();
        return this;
    }

    public Painter drawBorderedArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, int strokeWidth, int color) {
        setPaintParameters(color, Paint.Style.STROKE, strokeWidth, defaultTypeface, defaultTextSize);
        canvas.drawArc(new RectF(left, top, right, bottom), startAngle, sweepAngle, useCenter, paint);
        resetPaintParameters();
        return this;
    }

    public Painter drawLine(float X_1, float Y_1, float X_2, float Y_2, int thickness, int color) {
        setPaintParameters(color, Paint.Style.FILL_AND_STROKE, thickness, defaultTypeface, defaultTextSize);
        canvas.drawLine(X_1, Y_1, X_2, Y_2, paint);
        resetPaintParameters();
        return this;
    }

    public Painter scale(float sx, float sy) {
        Bitmap oldMap = getBitmap();
        setBitmap(Bitmap.createBitmap((int) Math.ceil((double) oldMap.getWidth() * sx), (int) Math.ceil((double) oldMap.getHeight() * sy), oldMap.getConfig()));

        Matrix scale = new Matrix();
        scale.setScale(sx, sy);

        canvas.drawBitmap(oldMap, scale, paint);

        resetPaintParameters();
        return this;
    }

    public Painter save() {
        canvas.save();
        return this;
    }

    public Painter restore() {
        canvas.restore();
        return this;
    }

    public Painter setColor(int color) {
        paint.setColor(color);
        return this;
    }

    public Painter resetColor() {
        paint.setColor(defaultColor);
        return this;
    }

    public Painter setStrokeWidth(int strokeWidth) {
        paint.setStrokeWidth(strokeWidth);
        return this;
    }

    public Painter resetStrokeWidth() {
        paint.setStrokeWidth(defaultStrokeWidth);
        return this;
    }

    public Painter setTextSize(int textSize) {
        paint.setTextSize(textSize);
        return this;
    }

    public Painter resetTextSize() {
        paint.setTextSize(defaultTextSize);
        return this;
    }

    public Painter setPaintStyle(Paint.Style style) {
        paint.setStyle(style);
        return this;
    }

    public Painter resetPaintStyle() {
        paint.setStyle(defaultStyle);
        return this;
    }

    public void setPaintParameters(int color, Paint.Style style, int strokeWidth, Typeface typeface, int textSize) {
        if (color != defaultColor)
            paint.setColor(color);
        if (!style.equals(defaultStyle))
            paint.setStyle(style);
        if (strokeWidth != defaultStrokeWidth)
            paint.setStrokeWidth(strokeWidth);
        if (!typeface.equals(defaultTypeface))
            paint.setTypeface(typeface);
        if (textSize != defaultTextSize)
            paint.setTextSize(textSize);
    }

    public void resetPaintParameters() {
        if (paint.getColor() != defaultColor)
            paint.setColor(defaultColor);
        if (paint.getStyle() != null && !paint.getStyle().equals(defaultStyle))
            paint.setStyle(defaultStyle);
        if (paint.getStrokeWidth() != defaultStrokeWidth)
            paint.setStrokeWidth(defaultStrokeWidth);
        if (paint.getTypeface() != null && !paint.getTypeface().equals(defaultTypeface))
            paint.setTypeface(defaultTypeface);
        if (paint.getTextSize() != defaultTextSize)
            paint.setTextSize(defaultTextSize);
    }

    public void setDefaultPaintParameters() {
        paint.setColor(defaultColor);
        paint.setStyle(defaultStyle);
        paint.setStrokeWidth(defaultStrokeWidth);
        paint.setTypeface(defaultTypeface);
        paint.setTextSize(defaultTextSize);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Painter setBitmap(int width, int height, Bitmap.Config config) {
        bitmap = Bitmap.createBitmap(width, height, config);
        bitmapCenterX = (float) Math.ceil((double) bitmap.getWidth() / 2);
        bitmapCenterY = (float) Math.ceil((double) bitmap.getHeight() / 2);
        canvas = new Canvas(bitmap);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setDefaultPaintParameters();
        return this;
    }

    public Painter setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        bitmapCenterX = (float) Math.ceil((double) bitmap.getWidth() / 2);
        bitmapCenterY = (float) Math.ceil((double) bitmap.getHeight() / 2);
        canvas = new Canvas(bitmap);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        return this;
    }

    public int getDefaultColor() {
        return defaultColor;
    }

    public int getDefaultTextSize() {
        return defaultTextSize;
    }

    public int getDefaultStrokeWidth() {
        return defaultStrokeWidth;
    }

    public Paint.Style getDefaultStyle() {
        return defaultStyle;
    }

    public Typeface getDefaultTypeface() {
        return defaultTypeface;
    }

    public float getBitmapCenterX() {
        return bitmapCenterX;
    }

    public void setBitmapCenterX(float bitmapCenterX) {
        this.bitmapCenterX = bitmapCenterX;
    }

    public float getBitmapCenterY() {
        return bitmapCenterY;
    }

    public void setBitmapCenterY(float bitmapCenterY) {
        this.bitmapCenterY = bitmapCenterY;
    }
}
