package collegework.calculator2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class FunctionPlotter extends View {

    public FunctionPlotter(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawLine(canvas.getWidth()/2,0,canvas.getWidth()/2,canvas.getHeight(),paint);
        canvas.drawLine(0,canvas.getHeight()/2,canvas.getWidth(),canvas.getHeight()/2,paint);

        paint.setColor(Color.BLUE);
        double y;
        for (float x = -canvas.getWidth()/2; x <= canvas.getWidth()/2; x+=0.1) {
            y=Parser.evaluate("jx/30|", x)*100;
            if (!Double.isNaN(y)) {
                canvas.drawCircle((int) (x + canvas.getWidth() / 2), canvas.getHeight() / 2 - (int)y, 2, paint);
            }
        }
    }
}