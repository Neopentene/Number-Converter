package com.NumCo.numberconverter.ObjectPainter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
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
    public final Bitmap.Config defaultConfig = Bitmap.Config.ARGB_8888;
    public final Paint.Align CENTER = Paint.Align.CENTER;
    public final Paint.Align DEFAULT = Paint.Align.LEFT;
    public final Paint.Align RIGHT = Paint.Align.RIGHT;
    public final Paint.Align LEFT = Paint.Align.LEFT;
    public int width, height;

    /**
     * Create a Painter object that takes a bitmap as it's parameter. Use this class to draw bitmaps using the various
     * methods and functions provided.
     *
     * @param side Length of side of a Square
     */

    public Painter(int side) {
        this(Bitmap.createBitmap(side, side, Bitmap.Config.ARGB_8888));
    }

    /**
     * Create a Painter object that takes a bitmap as it's parameter. Use this class to draw bitmaps using the various
     * methods and functions provided.
     *
     * @param width  Width of the bitmap
     * @param height Height of the bitmap
     */

    public Painter(int width, int height) {
        this(Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888));
    }

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
        width = bitmap.getWidth();
        height = bitmap.getHeight();
    }

    /**
     * Draw a circle at center of the bitmap with the specified radius
     *
     * @param radius Radius of the circle
     * @param color  Color used to draw the circle
     * @return Self
     */

    public Painter drawCircle(int radius, int color) {
        setColor(color);
        canvas.drawCircle(bitmapCenterX, bitmapCenterY, radius, paint);
        resetColor();
        return this;
    }

    /**
     * Draw a circle border at center of the bitmap with the specified radius and thickness
     *
     * @param radius    Radius of the circle
     * @param thickness Thickness of the border
     * @param color     Color used to draw the circle
     * @return Self
     */

    public Painter drawBorderedCircle(int radius, int thickness, int color) {
        setPaintParameters(color, Paint.Style.STROKE, thickness, defaultTypeface, defaultTextSize);
        canvas.drawCircle(bitmapCenterX, bitmapCenterY, Math.abs((int) Math.ceil((double) radius - ((float) thickness) / 2)), paint);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw a circle at center of your choosing with the specified radius
     *
     * @param cx     x Co-ordinate of the center
     * @param cy     y Co-ordinate of the center
     * @param radius Radius of the circle
     * @param color  Color used to draw the circle
     * @return Self
     */
    public Painter drawCircle(float cx, float cy, int radius, int color) {
        setColor(color);
        canvas.drawCircle(cx, cy, radius, paint);
        resetColor();
        return this;
    }

    /**
     * Draw a circle border at center of your choosing with the specified radius
     *
     * @param cx        x Co-ordinate of the center
     * @param cy        y Co-ordinate of the center
     * @param thickness Thickness of the border
     * @param radius    Radius of the circle
     * @param color     Color used to draw the circle
     * @return Self
     */

    public Painter drawBorderedCircle(float cx, float cy, int radius, int thickness, int color) {
        setPaintParameters(color, Paint.Style.STROKE, thickness, defaultTypeface, defaultTextSize);
        canvas.drawCircle(cx, cy, Math.abs((int) Math.ceil((double) radius - ((float) thickness) / 2)), paint);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw a rectangle at (left, top) with dimensions (right - top, bottom - top) of your choosing.
     * Below is an example of rectangle (20, 20) and (180, 180)
     * <pre>
     * <code style="font-weight: bold; color: orange">
     * <br />
     *  (0, 0)  (20, 0)    (180, 0)
     *      *   *          *
     *
     *   (20, 20)          (180, 20)
     *  20 top  * -------- * 180 right
     *          |          |
     *          |          |
     *          |          |
     *  20 left * -------- * 180 bottom
     *  (20, 180)          (180, 180)
     *
     *      *   *          *
     * (0, 200)(20, 200)  (180, 200)
     * </code>
     * </pre>
     *
     * @param left   top left corner's x Co-ordinate
     * @param top    top left corner's y Co-ordinate
     * @param right  bottom right corner's x Co-ordinate
     * @param bottom bottom right corner's x Co-ordinate
     * @param color  Color used to draw the circle
     * @return Self
     */

    public Painter drawRectangle(float left, float top, float right, float bottom, int color) {
        setColor(color);
        canvas.drawRect(left, top, right, bottom, paint);
        resetColor();
        return this;
    }

    /**
     * Draw a rectangle at (left, top) with dimensions (right - top, bottom - top) of your choosing.
     * Below is an example of rectangle (20, 20) and (180, 180)
     * <pre>
     * <code style="font-weight: bold; color: orange">
     * <br />
     *  (0, 0)  (20, 0)    (180, 0)
     *      *   *          *
     *
     *   (20, 20)          (180, 20)
     *  20 top  * -------- * 180 right
     *          |          |
     *          |          |
     *          |          |
     *  20 left * -------- * 180 bottom
     *  (20, 180)          (180, 180)
     *
     *      *   *          *
     * (0, 200)(20, 200)  (180, 200)
     * </code>
     * </pre>
     *
     * @param left      top left corner's x Co-ordinate
     * @param top       top left corner's y Co-ordinate
     * @param right     bottom right corner's x Co-ordinate
     * @param bottom    bottom right corner's x Co-ordinate
     * @param thickness Thickness of the border
     * @param color     Color used to draw the circle
     * @return Self
     */

    public Painter drawBorderedRectangle(float left, float top, float right, float bottom, int thickness, int color) {
        setPaintParameters(color, Paint.Style.STROKE, thickness, defaultTypeface, defaultTextSize);
        float thinness = (float) thickness / 2;
        canvas.drawRect(left + thinness, top + thinness, Math.abs(right - thinness), Math.abs(bottom - thinness), paint);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw a rectangle at (left, top) with dimensions (right - top, bottom - top) of your choosing.
     * Below is an example of rectangle (20, 20) and (180, 180)
     * <pre>
     * <code style="font-weight: bold; color: orange">
     * <br />
     *  (0, 0)  (20, 0)    (180, 0)
     *      *   *          *
     *
     *   (20, 20)          (180, 20)
     *  20 top  * -------- * 180 right
     *          |          |
     *          |          |
     *          |          |
     *  20 left * -------- * 180 bottom
     *  (20, 180)          (180, 180)
     *
     *      *   *          *
     * (0, 200)(20, 200)  (180, 200)
     * </code>
     * </pre>
     *
     * @param left   top left corner's x Co-ordinate
     * @param top    top left corner's y Co-ordinate
     * @param right  bottom right corner's x Co-ordinate
     * @param bottom bottom right corner's x Co-ordinate
     * @param rx     x inclination of the rounded corner
     * @param ry     y inclination of the rounded corner
     * @param color  Color used to draw the circle
     * @return Self
     */

    public Painter drawRoundedRectangle(float left, float top, float right, float bottom, float rx, float ry, int color) {
        setColor(color);
        canvas.drawRoundRect(new RectF(left, top, right, bottom), rx, ry, paint);
        resetColor();
        return this;
    }

    /**
     * Draw a rectangle at (left, top) with dimensions (right - top, bottom - top) of your choosing.
     * Below is an example of rectangle (20, 20) and (180, 180)
     * <pre>
     * <code style="font-weight: bold; color: orange">
     * <br />
     *  (0, 0)  (20, 0)    (180, 0)
     *      *   *          *
     *
     *   (20, 20)          (180, 20)
     *  20 top  * -------- * 180 right
     *          |          |
     *          |          |
     *          |          |
     *  20 left * -------- * 180 bottom
     *  (20, 180)          (180, 180)
     *
     *      *   *          *
     * (0, 200)(20, 200)  (180, 200)
     * </code>
     * </pre>
     *
     * @param left      top left corner's x Co-ordinate
     * @param top       top left corner's y Co-ordinate
     * @param right     bottom right corner's x Co-ordinate
     * @param bottom    bottom right corner's x Co-ordinate
     * @param rx        x inclination of the rounded corner
     * @param ry        y inclination of the rounded corner
     * @param thickness Thickness of the border
     * @param color     Color used to draw the circle
     * @return Self
     */

    public Painter drawBorderedRoundedRectangle(float left, float top, float right, float bottom, float rx, float ry, int thickness, int color) {
        setPaintParameters(color, Paint.Style.STROKE, thickness, defaultTypeface, defaultTextSize);
        float thinness = (float) thickness / 2;
        canvas.drawRoundRect(new RectF(left + thinness, top + thinness, Math.abs(right - thinness), Math.abs(bottom - thinness)), rx, ry, paint);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw a rectangle at (left, top) with dimensions (right - top, bottom - top) of your choosing.
     * Below is an example of rectangle (20, 20) and (180, 180)
     * <pre>
     * <code style="font-weight: bold; color: orange">
     * <br />
     *  (0, 0)  (20, 0)    (180, 0)
     *      *   *          *
     *
     *   (20, 20)          (180, 20)
     *  20 top  * -------- * 180 right
     *          |          |
     *          |          |
     *          |          |
     *  20 left * -------- * 180 bottom
     *  (20, 180)          (180, 180)
     *
     *      *   *          *
     * (0, 200)(20, 200)  (180, 200)
     * </code>
     * </pre>
     *
     * @param left   top left corner's x Co-ordinate
     * @param top    top left corner's y Co-ordinate
     * @param right  bottom right corner's x Co-ordinate
     * @param bottom bottom right corner's x Co-ordinate
     * @param r      set equal x and y inclination of the rounded corners
     * @param color  Color used to draw the circle
     * @return Self
     */
    public Painter drawBorderedRoundedRectangle(float left, float top, float right, float bottom, float r, int thickness, int color) {
        setPaintParameters(color, Paint.Style.STROKE, thickness, defaultTypeface, defaultTextSize);
        float thinness = (float) thickness / 2;
        canvas.drawRoundRect(new RectF(left + thinness, top + thinness, Math.abs(right - thinness), Math.abs(bottom - thinness)), r, r, paint);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw text at point (x, y) of your choosing
     *
     * @param text      Text to draw
     * @param x         x Co-ordinate of the top left corner
     * @param y         y Co-ordinate of the top left corner
     * @param typeface  The font family and text style - (ITALICS, BOLD, NORMAL)
     * @param alignment The alignment of the text with respect to (x, y)
     * @param textSize  The size of the text
     * @param color     Color used to draw text
     * @return Self
     */

    public Painter drawText(String text, float x, float y, Typeface typeface, Paint.Align alignment, int textSize, int color) {
        setPaintParameters(color, defaultStyle, defaultStrokeWidth, typeface, textSize);
        paint.setTextAlign(alignment);
        canvas.drawText(text, x, y, paint);
        resetPaintParameters();
        paint.setTextAlign(DEFAULT);
        return this;
    }

    /**
     * Draw text at point (x, y) of your choosing with default alignment - (LEFT)
     *
     * @param text     Text to draw
     * @param x        x Co-ordinate of the top left corner
     * @param y        y Co-ordinate of the top left corner
     * @param typeface The font family and text style - (ITALICS, BOLD, NORMAL)
     * @param textSize The size of the text
     * @param color    Color used to draw text
     * @return Self
     */

    public Painter drawText(String text, float x, float y, Typeface typeface, int textSize, int color) {
        setPaintParameters(color, defaultStyle, defaultStrokeWidth, typeface, textSize);
        canvas.drawText(text, x, y, paint);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw text at point (x, y) of your choosing with default typeface - (SAN-SERIF, NORMAL) and default alignment - (LEFT)
     *
     * @param text     Text to draw
     * @param x        x Co-ordinate of the top left corner
     * @param y        y Co-ordinate of the top left corner
     * @param textSize The size of the text
     * @param color    Color used to draw text
     * @return Self
     */

    public Painter drawText(String text, float x, float y, int textSize, int color) {
        setPaintParameters(color, defaultStyle, defaultStrokeWidth, defaultTypeface, textSize);
        canvas.drawText(text, x, y, paint);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw text at center of the bitmap
     *
     * @param text     Text to draw
     * @param typeface The font family and text style - (ITALICS, BOLD, NORMAL)
     * @param textSize The size of the text
     * @param color    Color used to draw text
     * @return Self
     */

    public Painter drawTextAtCenter(String text, Typeface typeface, int textSize, int color) {
        setPaintParameters(color, defaultStyle, defaultStrokeWidth, typeface, textSize);
        paint.setTextAlign(CENTER);
        float y = bitmapCenterY + (float) textSize * 0.365f;
        canvas.drawText(text, bitmapCenterX, y, paint);
        paint.setTextAlign(DEFAULT);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw text at center of the bitmap with default typeface - (SAN-SERIF, NORMAL)
     *
     * @param text     Text to draw
     * @param textSize The size of the text
     * @param color    Color used to draw text
     * @return Self
     */

    public Painter drawTextAtCenter(String text, int textSize, int color) {
        setPaintParameters(color, defaultStyle, defaultStrokeWidth, defaultTypeface, textSize);
        paint.setTextAlign(CENTER);
        float y = bitmapCenterY + (float) textSize * 0.365f;
        canvas.drawText(text, bitmapCenterX, y, paint);
        paint.setTextAlign(DEFAULT);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw an Arc
     * Below is an example of how arc works with the following parameters (20, 20) and (180, 180)
     * <pre>
     * <code style="font-weight: bold; color: black">
     * <br />
     *  (0, 0)  (20, 0)    (180, 0)
     *      *   *          *
     *
     *   (20, 20)          (180, 20)
     *  20 top  * -------- * 180 right
     *          |          |
     *          |(Arc - in)|
     *          |          |
     *  20 left * -------- * 180 bottom
     *  (20, 180)          (180, 180)
     *
     *      *   *          *
     * (0, 200)(20, 200)  (180, 200)
     * </code>
     * </pre>
     *
     * @param left       top left corner's x Co-ordinate
     * @param top        top left corner's y Co-ordinate
     * @param right      bottom right corner's x Co-ordinate
     * @param bottom     bottom right corner's x Co-ordinate
     * @param startAngle starting angle to draw the arc
     * @param sweepAngle angle between the sides of the arc
     * @param useCenter  include the usage of center while rendering
     * @param color      Color used to draw arc
     * @return Self
     */

    public Painter drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, int color) {
        setColor(color);
        canvas.drawArc(new RectF(left, top, right, bottom), startAngle, sweepAngle, useCenter, paint);
        resetColor();
        return this;
    }

    /**
     * Draw an Arc
     * Below is an example of how arc works with the following parameters (20, 20) and (180, 180)
     * <pre>
     * <code style="font-weight: bold; color: black">
     * <br />
     *  (0, 0)  (20, 0)    (180, 0)
     *      *   *          *
     *
     *   (20, 20)          (180, 20)
     *  20 top  * -------- * 180 right
     *          |          |
     *          |(Arc - in)|
     *          |          |
     *  20 left * -------- * 180 bottom
     *  (20, 180)          (180, 180)
     *
     *      *   *          *
     * (0, 200)(20, 200)  (180, 200)
     * </code>
     * </pre>
     *
     * @param left        top left corner's x Co-ordinate
     * @param top         top left corner's y Co-ordinate
     * @param right       bottom right corner's x Co-ordinate
     * @param bottom      bottom right corner's x Co-ordinate
     * @param startAngle  starting angle to draw the arc
     * @param sweepAngle  angle between the sides of the arc
     * @param useCenter   include the usage of center while rendering
     * @param strokeWidth thickness of the border
     * @param color       Color used to draw arc
     * @return Self
     */

    public Painter drawBorderedArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, int strokeWidth, int color) {
        setPaintParameters(color, Paint.Style.STROKE, strokeWidth, defaultTypeface, defaultTextSize);
        float halfStrokeWidth = (float) strokeWidth / 2;
        canvas.drawArc(new RectF(
                        (float) Math.ceil((double) left + halfStrokeWidth)
                        , (float) Math.ceil((double) top + halfStrokeWidth)
                        , (float) Math.ceil((double) right - halfStrokeWidth)
                        , (float) Math.ceil((double) bottom - halfStrokeWidth))
                , startAngle, sweepAngle, useCenter, paint);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw a line
     * <code style="font-weight: bold; color: yellow">
     * <br/>
     * &#40;x<sub>2</sub> + x<sub>1</sub>&#41;&#40;y<sub>1</sub> - y<sub>2</sub>&#41; &#61; &#40;x<sub>1</sub> - x<sub>2</sub>&#41;&#40;y<sub>2</sub> - y<sub>1</sub>&#41;
     * </code>
     *
     * @param X_1       Starting X Co-ordinate of the line
     * @param Y_1       Starting Y Co-ordinate of the line
     * @param X_2       Ending X Co-ordinate of the line
     * @param Y_2       Ending Y Co-ordinate of the line
     * @param thickness thickness of the line
     * @param color     Color used to draw line
     * @return Self
     */

    public Painter drawLine(float X_1, float Y_1, float X_2, float Y_2, int thickness, int color) {
        setPaintParameters(color, Paint.Style.FILL_AND_STROKE, thickness, defaultTypeface, defaultTextSize);
        canvas.drawLine(X_1, Y_1, X_2, Y_2, paint);
        resetPaintParameters();
        return this;
    }

    /**
     * Draw a border around the bitmap
     *
     * @param thickness thickness of the border
     * @param color     Color used to draw border
     * @return Self
     */

    public Painter drawBorderAroundBitmap(int thickness, int color) {
        drawBorderedRectangle(0, 0, width, height, thickness, color);
        return this;
    }

    /**
     * Draw a rounded border around the bitmap
     *
     * @param rx        x inclination of the rounded corner
     * @param ry        y inclination of the rounded corner
     * @param thickness thickness of the border
     * @param color     Color used to draw border
     * @return Self
     */

    public Painter drawRoundedBorderAroundBitmap(float rx, float ry, int thickness, int color) {
        drawBorderedRoundedRectangle(0, 0, width, height, rx, ry, thickness, color);
        return this;
    }

    /**
     * Draw a rounded border around the bitmap
     *
     * @param r         set equal x and y inclination of the rounded corners
     * @param thickness thickness of the border
     * @param color     Color used to draw border
     * @return Self
     */

    public Painter drawRoundedBorderAroundBitmap(float r, int thickness, int color) {
        drawBorderedRoundedRectangle(0, 0, width, height, r, thickness, color);
        return this;
    }

    /**
     * Draw the given bitmap
     *
     * @param x           x Co-ordinate of the top left corner
     * @param y           y Co-ordinate of the top left corner
     * @param bitmap      Bitmap to draw
     * @param colorFilter Filter used to draw bitmap default - null
     * @return Self
     */

    public Painter drawBitmap(float x, float y, Bitmap bitmap, ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap, x, y, paint);
        resetColorFilter();
        return this;
    }

    /**
     * Scaling with given x and y values
     *
     * @param sx scale x
     * @param sy scale y
     * @return Self
     */

    public Painter scale(float sx, float sy) {
        Bitmap oldMap = getBitmap();
        setBitmap(Bitmap.createBitmap((int) Math.ceil((double) oldMap.getWidth() * sx), (int) Math.ceil((double) oldMap.getHeight() * sy), oldMap.getConfig()));

        Matrix scale = new Matrix();
        scale.setScale(sx, sy);

        canvas.drawBitmap(oldMap, scale, paint);

        resetPaintParameters();
        return this;
    }

    /**
     * Save the canvas layer
     *
     * @return Self
     */

    public Painter save() {
        canvas.save();
        return this;
    }

    /**
     * Restore the last saved canvas layer
     *
     * @return Self
     */

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

    public Painter setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
        return this;
    }

    public Painter resetColorFilter() {
        paint.setColorFilter(null);
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

    /**
     * Get the internal bitmap
     *
     * @return Bitmap
     */
    public Bitmap getBitmap() {
        return bitmap;
    }

    public Painter setBitmap(int width, int height, Bitmap.Config config) {
        bitmap = Bitmap.createBitmap(width, height, config);
        bitmapCenterX = (float) Math.ceil((double) bitmap.getWidth() / 2);
        bitmapCenterY = (float) Math.ceil((double) bitmap.getHeight() / 2);
        canvas = new Canvas(bitmap);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        return this;
    }

    public Painter setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        bitmapCenterX = (float) Math.ceil((double) bitmap.getWidth() / 2);
        bitmapCenterY = (float) Math.ceil((double) bitmap.getHeight() / 2);
        canvas = new Canvas(bitmap);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
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