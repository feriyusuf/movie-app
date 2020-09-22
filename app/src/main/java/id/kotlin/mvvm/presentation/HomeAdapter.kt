package id.kotlin.mvvm.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.mvvm.R
import id.kotlin.mvvm.data.Result
import id.kotlin.mvvm.presentation.HomeAdapter.HomeViewHolder
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(private val results: List<Result>) : Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_home,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return results.count()
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(results[holder.adapterPosition])
    }

    inner class HomeViewHolder(itemView: View) : ViewHolder(itemView) {

        fun bind(result: Result) {
            with(itemView) {
                tv_title.text = result.title
                tv_overview.text = result.overview
            }
        }
    }

}