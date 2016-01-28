package org.itheima.open.recyclerviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        });

        //初始化view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //默认调用
        loadListData(false, true);
    }

    //填充menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //为menu设置点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_list_normal) {
            //list 标准展示
            loadListData(false, true);
            return true;
        } else if (id == R.id.action_list_vertical_reverse) {
            //list的垂直反向显示
            loadListData(true, true);
            return true;
        } else if (id == R.id.action_list_horizontal) {
            //list的水平展示数据
            loadListData(false, false);
            return true;
        } else if (id == R.id.action_list_horizontal_reverse) {
            //list的水平展示数据
            loadListData(true, false);
            return true;
        } else if (id == R.id.action_grid_normal) {
            loadGridData(false, true);
            return true;
        } else if (id == R.id.action_grid_vertical_reverse) {
            //list的垂直反向显示
            loadGridData(true, true);
            return true;
        } else if (id == R.id.action_grid_horizontal) {
            //list的水平展示数据
            loadGridData(false, false);
            return true;
        } else if (id == R.id.action_grid_horizontal_reverse) {
            //list的水平展示数据
            loadGridData(true, false);
            return true;
        } else if (id == R.id.action_staggered_normal) {
            loadStaggeredData(false, true);
            return true;
        } else if (id == R.id.action_staggered_vertical_reverse) {
            //list的垂直反向显示
            loadStaggeredData(true, true);
            return true;
        } else if (id == R.id.action_staggered_horizontal) {
            //list的水平展示数据
            loadStaggeredData(false, false);
            return true;
        } else if (id == R.id.action_staggered_horizontal_reverse) {
            //list的水平展示数据
            loadStaggeredData(true, false);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //类似listview的展示
    private void loadListData(boolean reverse, boolean vertical) {
        //数据初始化
        List<DataBean> datas = new ArrayList<>();
        for (int i = 0; i < DATAS.ICONS.length; i++) {
            DataBean bean = new DataBean();
            bean.icon = DATAS.ICONS[i];
            bean.name = "图片-" + i;
            datas.add(bean);
        }

        //给RecyclerView加载数据
        //1. 设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置是否反向显示
        layoutManager.setReverseLayout(reverse);
        //设置显示的方向
        layoutManager.setOrientation(vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);

        //2. 设置适配器
        mRecyclerView.setAdapter(new ListAdapter(this, datas));
    }

    //类似gridview的展示
    private void loadGridData(boolean reverse, boolean vertical) {
        List<DataBean> datas = new ArrayList<>();
        for (int i = 0; i < DATAS.ICONS.length; i++) {
            DataBean bean = new DataBean();
            bean.icon = DATAS.ICONS[i];
            bean.name = "图片-" + i;
            datas.add(bean);
        }

        //1.布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        //设置是否反向显示
        layoutManager.setReverseLayout(reverse);
        //设置显示的方向
        layoutManager.setOrientation(vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);

        //2.设置adapter
        mRecyclerView.setAdapter(new GridAdapter(this, datas));
    }

    //瀑布流显示
    private void loadStaggeredData(boolean reverse, boolean vertical) {
        List<DataBean> datas = new ArrayList<>();
        for (int i = 0; i < DATAS.PICS.length; i++) {
            DataBean bean = new DataBean();
            bean.icon = DATAS.PICS[i];
            bean.name = "图片-" + i;
            datas.add(bean);
        }

        //1.设置layoutmanager
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, vertical ?
                StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL);
        layoutManager.setReverseLayout(reverse);
        mRecyclerView.setLayoutManager(layoutManager);

        // 2.设置adapter
        mRecyclerView.setAdapter(new StaggeredAdapter(this, datas));
    }
}
