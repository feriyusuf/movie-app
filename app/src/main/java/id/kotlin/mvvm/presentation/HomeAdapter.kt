package id.kotlin.mvvm.presentation

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.mvvm.R
import id.kotlin.mvvm.domain.HomeEntity
import kotlinx.android.synthetic.main.item_home.view.*

enum class Type {
    DATA,
    LOADING
}

class HomeAdapter(private val results: MutableList<HomeEntity.Result?>) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return when (viewType) {
            Type.DATA.ordinal -> {
                HomeViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(
                            R.layout.item_home,
                            parent,
                            false
                        )
                )
            }
            Type.LOADING.ordinal -> {
                HomeViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(
                            R.layout.item_loading,
                            parent,
                            false
                        )
                )
            }
            else -> throw RuntimeException("Illegal view type")
        }
    }

    override fun getItemCount(): Int {
        return results.count()
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            results[position] == null -> Type.LOADING.ordinal
            else -> Type.DATA.ordinal
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is HomeViewHolder -> {
                holder.bind(results[holder.adapterPosition])
            }
        }
    }

    fun showLoading() {
        results.add(null)
        Handler().post { notifyItemInserted(results.count().minus(1)) }
    }

    fun hideLoading() {
        results.removeAt(results.count().minus(1))
        Handler().post { notifyItemRemoved(results.count()) }
    }

    fun loadMore(results: MutableList<HomeEntity.Result?>) {
        this.results.addAll(results)
        Handler().post { notifyDataSetChanged() }
    }

    inner class HomeViewHolder(itemView: View) : ViewHolder(itemView) {

        fun bind(result: HomeEntity.Result?) {
            with(itemView) {
                tv_title.text = result?.title ?: "Untitled"
                tv_overview.text = result?.overview ?: "No description"
            }
        }
    }

    inner class LoadingViewHolder(itemView: View) : ViewHolder(itemView)
}