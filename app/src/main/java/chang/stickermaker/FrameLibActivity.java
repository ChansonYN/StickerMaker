package chang.stickermaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chang on 2016/10/17 0017.
 */
public class FrameLibActivity extends Activity {

    private GridView gridView;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = { R.drawable.frame_panda, R.drawable.frame_cute, R.drawable.frame_panda_touch_head };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_lib);

        gridView = (GridView)findViewById(R.id.gridview_frame_lib);

        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image"};
        int [] to = {R.id.imgview_griditem};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.griditem_pic, from, to);
        //配置适配器
        gridView.setAdapter(sim_adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent();
                intent.putExtra("picture", icon[position]);
                Log.i("mylog","position");
                setResult(1, intent);
                finish();
            }
        });
    }

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            data_list.add(map);
        }

        return data_list;
    }
}
