//package com.example.permissions; your app's package name

/**
 * Created by Dark Tornado on 2017-07-16.
 * FloatingWindow Class
 * © 2017 Dark Tornado, All rights reserved.
 * Version 1.0
 */

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FloatingWindow {

    private WindowManager mManager;
    private WindowManager.LayoutParams mParams;
    private Context ctx;
    private View view;
    private RelativeLayout layout;

    public FloatingWindow(Context ctx2) {
        try {
            ctx = ctx2;
            mParams = new WindowManager.LayoutParams(
                    -2, -2,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);
            mParams.x = 0;
            mParams.y = 0;
            mParams.gravity = Gravity.CENTER;
            layout = new RelativeLayout(ctx2);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public FloatingWindow(Context ctx2, boolean isIncludeEditText) {
        try {
            ctx = ctx2;
            if (isIncludeEditText) mParams = new WindowManager.LayoutParams(
                    -2, -2,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                    PixelFormat.TRANSLUCENT);
            else mParams = new WindowManager.LayoutParams(
                    -2, -2,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);
            mParams.x = 0;
            mParams.y = 0;
            mParams.gravity = Gravity.CENTER;
            layout = new RelativeLayout(ctx2);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void setContentView(View view1) {
        try {
            view = view1;
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void setGravity(int gravity) {
        try {
            mParams.gravity = gravity;
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void setWidth(int size) {
        try {
            mParams.width = size;
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void setHeight(int size) {
        try {
            mParams.height = size;
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public int getWidth() {
        try {
            return mParams.width;
        } catch (Exception e) {
            toast(e.toString());
        }
        return 0;
    }

    public int getHeight() {
        try {
            return mParams.height;
        } catch (Exception e) {
            toast(e.toString());
        }
        return 0;
    }

    public void setSize(int x, int y) {
        try {
            mParams.width = x;
            mParams.height = y;
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void setPosition(int x, int y) {
        try {
            mParams.x = x;
            mParams.y = y;
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void setPosition(int gravity, int x, int y) {
        try {
            mParams.gravity = gravity;
            mParams.x = x;
            mParams.y = y;
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void setBackgroundColor(int color) {
        try {
            layout.setBackgroundColor(color);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        try {
            layout.setBackgroundDrawable(drawable);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void setBackground(Drawable drawable) {
        try {
            layout.setBackground(drawable);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void show() {
        try {
            layout.addView(view);
            mManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
            mManager.addView(layout, mParams);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void dismiss() {
        try {
            mManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
            mManager.removeView(layout);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void update(int gravity) {
        try {
            mParams.gravity = gravity;
            mManager.updateViewLayout(view, mParams);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void update(int x, int y) {
        try {
            mParams.x = x;
            mParams.y = y;
            mManager.updateViewLayout(view, mParams);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void update(int gravity, int x, int y) {
        try {
            mParams.x = x;
            mParams.y = y;
            mParams.gravity = gravity;
            mManager.updateViewLayout(view, mParams);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void update(int x, int y, int sizeX, int sizeY) {
        try {
            mParams.x = x;
            mParams.y = y;
            mParams.width = sizeX;
            mParams.height = sizeY;
            mManager.updateViewLayout(view, mParams);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    private void toast(final String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
    }

}

