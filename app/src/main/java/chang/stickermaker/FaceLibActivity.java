package chang.stickermaker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chang on 2016/10/17 0017.
 */
public class FaceLibActivity extends Activity {

    private GridView gridView;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = { R.drawable.face_jinguanzhang, R.drawable.face_cute, R.drawable.face_wunai };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_lib);

        gridView = (GridView)findViewById(R.id.gridview_face_lib);

        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image"};
        int [] to = {R.id.imgview_griditem};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.griditem_pic, from, to);
        //配置适配器
        gridView.setAdapter(sim_adapter);
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
