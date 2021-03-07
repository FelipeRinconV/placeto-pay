package com.evertec.everteplacetopay.ui.list_transaction

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evertec.everteplacetopay.base.BaseViewHolder
import com.evertec.everteplacetopay.data.model.TransactionEntity
import com.evertec.everteplacetopay.databinding.ItemTransactionBinding

class TransactionAdapter2(
    private val context: Context,
    private val onClickRowListener: OnTransactionListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var mTransactionList = listOf<TransactionEntity>()

    interface OnTransactionListener {
        fun onClickDeleteTransaction(transactionEntity: TransactionEntity)
        fun onClickUpdatedTransaction(transactionEntity: TransactionEntity)
    }


    fun setTransactionList(transactionList: List<TransactionEntity>) {
        this.mTransactionList = transactionList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = mTransactionList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(mTransactionList[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            ItemTransactionBinding.inflate(LayoutInflater.from(context), parent, false)
        val holder = MainViewHolder(itemBinding)

        itemBinding.btnUpdateTransaction.setOnClickListener {
            onClickRowListener.onClickUpdatedTransaction(mTransactionList[holder.adapterPosition])
        }

        itemBinding.btnDeleteTransaction.setOnClickListener {
            onClickRowListener.onClickDeleteTransaction(mTransactionList[holder.adapterPosition])
        }

        return holder
    }


    private inner class MainViewHolder(
        private val binding: ItemTransactionBinding
    ) : BaseViewHolder<TransactionEntity>(binding.root) {
        override fun bind(item: TransactionEntity) = with(binding) {
            txtState.text = item.state
            txtCardNumber.text = item.cardNumber
            txtDate.text = item.date
            txtInternalReference.text = item.internalReference.toString()
            txtValue.text = item.value.toString()

        }
    }

}