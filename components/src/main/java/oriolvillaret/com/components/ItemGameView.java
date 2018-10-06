package oriolvillaret.com.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemGameView extends LinearLayout {

    protected CircleImageView item_game_img;
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
                    .into(item_game_img, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError(Exception e) {
                            setDefaultImageGame();
                        }
                    });
        } else {
            setDefaultImageGame();
        }

        item_game_name.setText(name);
    }

    private void setDefaultImageGame() {
        Picasso.get()
                .load(R.drawable.ic_medal)
                .into(item_game_img);
    }
}
