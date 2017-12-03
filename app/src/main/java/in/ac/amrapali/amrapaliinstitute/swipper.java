package in.ac.amrapali.amrapaliinstitute;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dipanker on 06/11/17.
 */

public class swipper extends PagerAdapter {
    private int[] my_images ={R.drawable.img3,R.drawable.img2,R.drawable.img4};
    private Context ctx;
    private LayoutInflater layoutInflater;

   public swipper(Context ctx){
        this.ctx=ctx;

    }

    @Override
    public int getCount() {
        return my_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view== (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.inflater,container,false);
        ImageView imageView=(ImageView) item_view.findViewById(R.id.imageView);
        imageView.setImageResource(my_images[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
