package com.example.admin.du_an_1.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.du_an_1.Controller.TicketService;
import com.example.admin.du_an_1.DAO.daoProducts;
import com.example.admin.du_an_1.DAO.daoStats;
import com.example.admin.du_an_1.R;
import com.example.admin.du_an_1.Repository.Product;
import com.example.admin.du_an_1.Repository.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ListStatsAdapter extends ArrayAdapter<Ticket> {

    Context context;
    int Layout;
    ArrayList<Ticket> arrTicket;

    public ListStatsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Ticket> objects) {
        super( context, resource, objects );
        this.context = context;
        this.Layout = resource;
        this.arrTicket = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        TicketService service = new TicketService( context );
        convertView = LayoutInflater.from( context ).inflate( Layout,null );

        TextView tvName_out = (TextView)convertView.findViewById( R.id.tvName_out );
        TextView tvQuantity = (TextView)convertView.findViewById( R.id.tvQuantity_out );
        TextView tvType = (TextView)convertView.findViewById( R.id.tvType );

        // Phần này để set Import hoặc Export. //
        if (arrTicket.get( position ).getType()){
            tvType.setText( "Import" );
        }else {
            tvType.setText( "Export" );
        }
        ////////////////////////////////////////
        
        Ticket temp = arrTicket.get( position );
        tvName_out.setText( temp.getproductCode() );
        tvQuantity.setText( String.valueOf( temp.getQuantity() ) );

        return convertView;
    }
}