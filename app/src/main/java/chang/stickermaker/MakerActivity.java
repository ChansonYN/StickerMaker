package chang.stickermaker;

import android.app.Activity;
import android.content.Intent;
import android.hardware.camera2.params.Face;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Chang on 2016/10/17 0017.
 */
public class MakerActivity extends Activity {

    private ImageButton imgbtnFrame;
    private ImageButton imgbtnFace;
    private ImageButton imgbtnItem;
    private ImageButton imgbtnWord;
    private ImageView imageView;

    private int[] frame = { R.drawable.frame_panda, R.drawable.frame_cute, R.drawable.frame_panda_touch_head };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maker);

        this.imgbtnFrame = (ImageButton) findViewById(R.id.img_btn_frame);
        this.imgbtnFace  = (ImageButton) findViewById(R.id.img_btn_face);
        this.imgbtnItem  = (ImageButton) findViewById(R.id.img_btn_item);
        this.imgbtnWord  = (ImageButton) findViewById(R.id.img_btn_word);
        imageView         = (ImageView)   findViewById(R.id.imgview_maker);

        imgbtnFrame.setOnClickListener(new menuClickListener());
        imgbtnFace.setOnClickListener(new menuClickListener());
        imgbtnItem.setOnClickListener(new menuClickListener());
        imgbtnWord.setOnClickListener(new menuClickListener());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                Log.i("跳转成功","position");
//                int position = data.getExtras("position");
//                int i = Integer.valueOf(position).intValue();
//                imageView.setImageResource(frame[i]);
                break;
        }
    }

    public class menuClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.img_btn_frame:
                    Intent intent1 = new Intent();
                    intent1.setClass(MakerActivity.this, FrameLibActivity.class);
                    startActivityForResult(intent1, 100);
                    break;
                case R.id.img_btn_face:
                    Intent intent2 = new Intent();
                    intent2.setClass(MakerActivity.this, FaceLibActivity.class);
                    startActivityForResult(intent2, 101);
                    break;
                case R.id.img_btn_item:
                    Intent intent3 = new Intent();
                    intent3.setClass(MakerActivity.this, ItemLibActivity.class);
                    startActivityForResult(intent3, 101);
                    break;
            }
        }
    }
}
