package com.example.test3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class Ball extends View {
    private ShapeDrawable drawable;
    private float ballX, ballY;

    public Ball(Context context) {
        super(context);

        drawable = new ShapeDrawable(new OvalShape());
        drawable.setIntrinsicWidth(50);
        drawable.setIntrinsicHeight(50);
        drawable.getPaint().setColor(Color.RED);

    }

    protected void onDraw(Canvas canvas) {
        drawable.draw(canvas);

        /*
        ballX += 5;  // Move ball 5 pixels to the right
        if (ballX > getWidth() - drawable.getIntrinsicWidth()) {
            ballX = 0;  // Reset X if reaching the right edge
        }

        ballY += 2;  // Move ball 2 pixels down
        if (ballY > getHeight() - drawable.getIntrinsicHeight()) {
            ballY = 0;  // Reset Y if reaching the bottom edge
        }

         */

        ballX += 10;
        if (ballX > getWidth() - drawable.getIntrinsicWidth()) {
            ballX = 0;  // Reset X if reaching the right edge

            if (ballY > getHeight() - drawable.getIntrinsicHeight()){
                ballX = 0;
                ballY = 0;
            }
            else
                ballY += drawable.getIntrinsicHeight() + 50;
        }


        // Set the new position of the ShapeDrawable
        drawable.setBounds((int) ballX, (int) ballY,
                (int) (ballX + drawable.getIntrinsicWidth()),
                (int) (ballY + drawable.getIntrinsicHeight()));
        drawable.draw(canvas);  // Draw the ShapeDrawable

        // Invalidate to trigger redraw
        invalidate();

    }
}