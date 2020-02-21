package cc.rome753.oneadapter.base;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A ViewHolder that auto cast the data, from Object to the type you define
 * @param <D> the data type you define
 */
public abstract class OneViewHolder<D> extends RecyclerView.ViewHolder {

    public OneViewHolder(View itemView) {
        super(itemView);
        init();
    }

    public OneViewHolder(ViewGroup parent, int layoutRes) {
        super(LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false));
        init();
    }

    protected void init(){
        // findViewById if need.
    }

    void bindView(int position, Object o){
        bindViewCasted(position, (D) o);
    }

    protected abstract void bindViewCasted(int position, D d);
}