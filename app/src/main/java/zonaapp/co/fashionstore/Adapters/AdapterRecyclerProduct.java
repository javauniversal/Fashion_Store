package zonaapp.co.fashionstore.Adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;

import java.text.DecimalFormat;
import java.util.List;

import zonaapp.co.fashionstore.Entities.EntProduct;
import zonaapp.co.fashionstore.Entities.ProductInterface;
import zonaapp.co.fashionstore.R;

public class AdapterRecyclerProduct extends RecyclerView.Adapter<ProductInterface> {

    private Context context;
    private ImageLoader imageLoader1;
    private DisplayImageOptions options1;
    private DecimalFormat format;
    private String _regular_price, _sale_price, _price,  _max_variation_regular_price, _min_variation_sale_price;;
    List<EntProduct> entProducts;

    public AdapterRecyclerProduct(Context context, List<EntProduct> entProducts) {
        super();
        this.context = context;
        this.entProducts = entProducts;

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
        imageLoader1 = ImageLoader.getInstance();
        imageLoader1.init(config);

        //Setup options for ImageLoader so it will handle caching for us.
        options1 = new DisplayImageOptions.Builder()
                .cacheInMemory()
                .cacheOnDisc()
                .build();

        format = new DecimalFormat("$#,###.##");
    }

    @Override
    public ProductInterface onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductInterface(v, context);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(ProductInterface holder, final int position) {

        getPrecio(position);

        EntProduct items = entProducts.get(position);

        loadeImagenView(items, holder.imageView, holder);

        holder.nombreProduct.setText(items.getPost_title());

        if(!(_regular_price == null || _regular_price.equals(""))){

            holder.price.setVisibility(View.VISIBLE);
            if (!(_sale_price == null || _sale_price.equals(""))) { holder.price.setPaintFlags(holder.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG); }
            holder.price.setText(format.format(Double.parseDouble(_regular_price)));
        }

        if(!(_sale_price == null || _sale_price.equals(""))){
            holder.price_oferta.setVisibility(View.VISIBLE);
            holder.price_oferta.setText(format.format(Double.parseDouble(_sale_price)));
        }

        if(!(_min_variation_sale_price == null || _min_variation_sale_price.equals(""))){
            holder.price_oferta.setVisibility(View.VISIBLE);
            holder.price_oferta.setText(format.format(Double.parseDouble(_min_variation_sale_price)));
        }

        if(!(_max_variation_regular_price == null || _max_variation_regular_price.equals(""))){
            holder.price.setVisibility(View.VISIBLE);
            holder.price.setPaintFlags(holder.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            holder.price.setText(format.format(Double.parseDouble(_max_variation_regular_price)));
        }


    }

    public void getPrecio(int position){

        for (int i=0; i < entProducts.get(position).getAttributesList().size(); i++) {

            if(entProducts.get(position).getAttributesList().get(i).getMeta_key().equals("_regular_price")){
                _regular_price = entProducts.get(position).getAttributesList().get(i).getMeta_value();
            }else if(entProducts.get(position).getAttributesList().get(i).getMeta_key().equals("_sale_price")){
                _sale_price = entProducts.get(position).getAttributesList().get(i).getMeta_value();
            }else if (entProducts.get(position).getAttributesList().get(i).getMeta_key().equals("_price")){
                _price = entProducts.get(position).getAttributesList().get(i).getMeta_value();
            }else if (entProducts.get(position).getAttributesList().get(i).getMeta_key().equals("_min_variation_sale_price")){
                _min_variation_sale_price = entProducts.get(position).getAttributesList().get(i).getMeta_value();
            }else if (entProducts.get(position).getAttributesList().get(i).getMeta_key().equals("_max_variation_regular_price")){
                _max_variation_regular_price = entProducts.get(position).getAttributesList().get(i).getMeta_value();
            }

        }

    }


    @Override
    public int getItemCount() {
        if (entProducts == null) {
            return 0;
        } else {
            return entProducts.size();
        }
    }

    public void loadeImagenView(EntProduct data, ImageView img, final ProductInterface holder){

        ImageLoadingListener listener = new ImageLoadingListener(){
            @Override
            public void onLoadingStarted(String arg0, View arg1) {
                // TODO Auto-generated method stub
                //Inicia metodo
                holder.progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingCancelled(String arg0, View arg1) {
                // TODO Auto-generated method stub
                //Cancelar
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String arg0, View arg1, Bitmap arg2) {
                //Completado
                holder.progressBar.setVisibility(View.GONE);
            }
            @Override
            public void onLoadingFailed(String arg0, View arg1, FailReason arg2) {
                // TODO Auto-generated method stub
                //Error al cargar la imagen.
                holder.progressBar.setVisibility(View.GONE);
            }
        };

        imageLoader1.displayImage(data.getGaleryList().get(0).getGuid(), img, options1, listener);
    }
}
