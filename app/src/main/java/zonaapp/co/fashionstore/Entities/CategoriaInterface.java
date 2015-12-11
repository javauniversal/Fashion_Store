package zonaapp.co.fashionstore.Entities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import zonaapp.co.fashionstore.R;

public class CategoriaInterface extends RecyclerView.ViewHolder {

    public TextView nombreCategoria;

    public CategoriaInterface(View itemView, Context context) {
        super(itemView);

        this.nombreCategoria = (TextView) itemView.findViewById(R.id.txtCategoria);

    }
}
