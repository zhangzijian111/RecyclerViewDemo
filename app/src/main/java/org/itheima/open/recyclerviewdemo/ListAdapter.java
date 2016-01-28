package org.itheima.open.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter
        extends RecyclerView.Adapter<ListAdapter.ListViewHolder>//标准的写法是本类名下的XXViewHolder extends RecyclerView.ViewHolder（即创建一个内部类继承RecyclerView.ViewHolder）
{
    private Context mContext;
    private List<DataBean> mDatas;//数据是由holder内的数据来决定的，所以要封装一个javabean作为容器

    //构造函数传入上下文和数据
    public ListAdapter(Context context, List<DataBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    //一个条目就是一个holder，当holder而被创建的时候此方法被调用
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //当viewholder创建时的回调
        View view = View.inflate(mContext, R.layout.item_list, null);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
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

    //子布局中的viewid在这里实现
    public class ListViewHolder
            extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvName;

        public ListViewHolder(View itemView) {
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
