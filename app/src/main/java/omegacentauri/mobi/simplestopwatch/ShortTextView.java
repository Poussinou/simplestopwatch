package omegacentauri.mobi.simplestopwatch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class ShortTextView extends TextView {
    public ShortTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //setHeight((int) getPaint().getFontMetrics().ascent);
//        Log.v("chrono", "" + getLineHeight()+ ", "+ getHeight() + " "+getBaseline()+ " "+getPaint().getFontMetrics().ascent);
//        int yOffset = (int) (getHeight() + getPaint().getFontMetrics().ascent);;
//        Log.v("chrono", "yOffset "+yOffset);
        String t = (String)getText();
        setText("");
        super.onDraw(canvas);
        setText(t);
        Paint p = getPaint();
        Rect bounds = new Rect();
        p.getTextBounds(t.replaceAll("[0-9]", "0"), 0, t.length(), bounds);
//        getPaint().setTextAlign(Paint.Align.CENTER);
        canvas.drawText(t, (float)(canvas.getWidth()/2 - bounds.centerX()), (float)(canvas.getHeight()/2 - bounds.centerY()), p);
    }
}