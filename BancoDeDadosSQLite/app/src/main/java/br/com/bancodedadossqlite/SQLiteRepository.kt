package br.com.bancodedadossqlite

import android.content.ContentValues
import android.content.Context

class SQLiteRepository(ctx: Context): ProdutoRepository {

    private val helper: ProdutoSqlHelper = ProdutoSqlHelper(ctx)


    private fun insert(produto: Produto) {
        val db = helper.writableDatabase

        val cv = ContentValues().apply {
            put(COLUMN_NAME, produto.name)
            put(COLUMN_VALUE, produto.value)
        }

        val id = db.insert(TABLE_NAME, null, cv)
        if (id != -1L) {
            produto.id = id
        }
        db.close()
    }

    private fun update (produto: Produto) {
        val db = helper.writableDatabase

        val cv = ContentValues().apply {
            put(COLUMN_NAME, produto.name)
            put(COLUMN_VALUE, produto.value)
        }

        db.update(
            TABLE_NAME,
            cv,
            "COLUMN_ID = ? ",
            arrayOf(produto.id.toString())
        )
        db.close()
    }

    override fun save(produto: Produto) {
        if (produto.id == 0L) {
            insert(produto)
        } else {
            update(produto)
        }
    }

    override fun remove(vararg produtos: Produto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun produtoById(id: Long, callback: (Produto?) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun search(term: String, callback: (List<Produto>) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}