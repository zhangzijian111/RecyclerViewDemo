package org.itheima.open.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridAdapter
        extends RecyclerView.Adapter<GridAdapter.GridViewHolder>
{
    private Context        mContext;
    private List<DataBean> mDatas;

    public GridAdapter(Context context, List<DataBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //当viewholder创建时的回调
        View view = View.inflate(mContext, R.layout.item_grid, null);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        //当viewholder和数据绑定时的回调
        //需要有数据
        DataBean bean = mDatas.get(position);
        holder.setData(bean);
    }

    @Override
    public int getItemCount() {
        //返回的是list数据个数
        if (mDatas != null) {
            return mDatas.size();
        }
        return 0;
    }

    public class GridViewHolder
            extends RecyclerView.ViewHolder
    {
        private ImageView ivIcon;
        private TextView tvName;

        public GridViewHolder(View itemView) {
            super(itemView);

            ivIcon = (ImageView) itemView.findViewById(R.id.item_list_iv_icon);
            tvName = (TextView) itemView.findViewById(R.id.item_list_tv_name);
        }

        public void setData(DataBean bean) {
            //设置数据的方法
            ivIcon.setImageResource(bean.icon);
            tvName.setText(bean.name);

        }
    }
}
