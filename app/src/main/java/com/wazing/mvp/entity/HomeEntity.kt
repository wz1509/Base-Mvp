package com.wazing.mvp.entity

class HomeEntity(val curPage: Int,
                 val offset: Int,
                 val over: Boolean,
                 val pageCount: Int,
                 val size: Int,
                 val total: Int,
                 val datas: List<Data>) {

    inner class Data(val id: Long,
                     val title: String,
                     val chapterName: String,
                     val link: String) {

        override fun toString(): String {
            return "Data(id=$id, title='$title', chapterName='$chapterName', link='$link')"
        }
    }
}