package com.playground.app.medium_articles_app.data.source.remote

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Document
import com.playground.app.medium_articles_app.data.source.remote.model.ArticleChannelRss
import com.playground.app.medium_articles_app.data.source.remote.model.ArticleRss
import com.prof18.rssparser.RssParser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ArticleApiImpl(
    private val rssParser: RssParser,
    private val coroutineDispatcher: CoroutineDispatcher
) : ArticleApi {
    override suspend fun getArticleChannel(): ArticleChannelRss {
        return withContext(coroutineDispatcher) {
            val rssChannel = rssParser.getRssChannel("https://medium.com/feed/@primoapp")
            val articleList = rssChannel.items.mapNotNull { rssItem ->
                rssItem.content?.let { content ->
                    val htmlDocument = Ksoup.parse(content)
                    val image = extractImageFromHtmlDocument(htmlDocument)
                    val imageReference = extractImageReferenceFromHtmlDocument(htmlDocument)
                    removeUnwantedTag(htmlDocument)

                    ArticleRss(
                        title = rssItem.title ?: "",
                        image = image,
                        imageReference = imageReference,
                        htmlContent = htmlDocument.body().toString(),
                        content = htmlDocument.body().text().substring(0, 199)
                    )
                }
            }
            ArticleChannelRss(
                channelTitle = rssChannel.title!!,
                articles = articleList
            )
        }
    }

    private fun extractImageFromHtmlDocument(htmlDocument: Document): String {
        val imageElements = htmlDocument.select("img")
        val image = imageElements[0].absUrl("src")
        imageElements.remove()
        return image
    }

    private fun extractImageReferenceFromHtmlDocument(htmlDocument: Document): String {
        val imageReferenceElements = htmlDocument.select("figcaption")
        val imageReference = imageReferenceElements.text()
        imageReferenceElements.remove()
        return imageReference
    }

    private fun removeUnwantedTag(htmlDocument: Document) {
        val unwantedElements = htmlDocument.select("figure")
        unwantedElements.remove()
    }
}