package oriolvillaret.com.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ItemGameView extends LinearLayout {

    protected ImageView item_game_img;
    protected TextView item_game_name;

    public ItemGameView(Context context) {
        super(context);
        initView();
    }

    public ItemGameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ItemGameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_game, this,
                true);

        item_game_img = findViewById(R.id.item_game_img);
        item_game_name = findViewById(R.id.item_game_name);
    }


    public void setData(String urlImage, String name) {
        if (urlImage != null) {
            Picasso.get()
                    .load(urlImage)
                    .transform(new CircleTransform())
                    .into(item_game_img, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError(Exception e) {
                            setDefaultImage();
                        }
                    });
        } else {
            setDefaultImage();
        }

        item_game_name.setText(name);
    }

    private void setDefaultImage() {
        Picasso.get()
                .load(R.drawable.ic_medal)
                .transform(new CircleTransform())
                .into(item_game_img);
    }
}
