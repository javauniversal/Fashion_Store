package zonaapp.co.fashionstore.Entities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import zonaapp.co.fashionstore.R;

public class ProductInterface extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView nombreProduct;
    public TextView price_oferta;
    public TextView price;
    public Button addCarrito;
    public ProgressBar progressBar;

    public ProductInterface(View itemView, Context context) {
        super(itemView);

        this.nombreProduct = (TextView) itemView.findViewById(R.id.txtNombreProduct);
        this.price_oferta = (TextView) itemView.findViewById(R.id.precio_oferta);
        this.price = (TextView) itemView.findViewById(R.id.precio_normal);
        this.addCarrito = (Button) itemView.findViewById(R.id.btnAddCarrito);
        this.progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        this.imageView = (ImageView) itemView.findViewById(R.id.imgProduct);

    }
}
