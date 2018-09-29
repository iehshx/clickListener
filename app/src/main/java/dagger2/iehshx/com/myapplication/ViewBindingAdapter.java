package dagger2.iehshx.com.myapplication;

import android.databinding.BindingAdapter;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

public class ViewBindingAdapter {
    private static final String TAG = "ViewBindingAdapter";
    @BindingAdapter({"android:onClick", "android:clickable"})
    public static void setOnClick(View view, View.OnClickListener clickListener,boolean clickable){
        setOnClick(view, clickListener);
        view.setClickable(clickable);
    }
    @BindingAdapter({"android:onClick"})
    public static void setOnClick(View view, final View.OnClickListener clickListener) {
        final long[] mHits = new long[2];
        view.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View v) {
                System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
                mHits[mHits.length - 1] = SystemClock.uptimeMillis();
                if (mHits[0] < (SystemClock.uptimeMillis() - 5000)) {
                    if (clickListener!=null)
                    clickListener.onClick(v);
                }
            }
        });
    }

    public static View.OnClickListener onclick = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            Log.d("tag","点击了");
        }
    };

    public void onclick() {
        Log.d("tag","点击了");
    }

    public void setOnclick(View.OnClickListener onclick) {
        this.onclick = onclick;
    }
}