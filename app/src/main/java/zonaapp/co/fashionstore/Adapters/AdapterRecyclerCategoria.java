package zonaapp.co.fashionstore.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zonaapp.co.fashionstore.Entities.CategoriaInterface;
import zonaapp.co.fashionstore.Entities.EntCategory;
import zonaapp.co.fashionstore.R;

import static zonaapp.co.fashionstore.Entities.EntProductGrup.getEntProductGrup;

public class AdapterRecyclerCategoria extends RecyclerView.Adapter<CategoriaInterface> {

    private Context context;

    public AdapterRecyclerCategoria(Context context) {
        super();
        this.context = context;
    }

    @Override
    public CategoriaInterface onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoriaInterface(v, context);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(CategoriaInterface holder, final int position) {

        EntCategory items = getEntProductGrup().getCategoriaList().get(position);

        holder.nombreCategoria.setText(items.getName());

    }

    @Override
    public int getItemCount() {
        if (getEntProductGrup().getCategoriaList() == null) {
            return 0;
        } else {
            return getEntProductGrup().getCategoriaList().size();
        }
    }

}
